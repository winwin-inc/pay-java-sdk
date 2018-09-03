package com.winwin.pay.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import me.chanjar.weixin.common.annotation.Required;
import me.chanjar.weixin.common.bean.result.WxError;
import me.chanjar.weixin.common.exception.WxErrorException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

public class BeanUtils extends me.chanjar.weixin.common.util.BeanUtils {
    private static Logger log = LoggerFactory.getLogger(BeanUtils.class);

    public static void checkRequiredFields(Object bean) throws WxErrorException {
        List<String> requiredFields = Lists.newArrayList();
        List<Field> fields = new ArrayList<>(Arrays.asList(bean.getClass().getDeclaredFields()));
        buildFieldsOfSuper(fields, bean.getClass());

        for (Field field: fields) {
            try {
                boolean isAccessible = field.isAccessible();
                field.setAccessible(true);
                if (field.isAnnotationPresent(Required.class)) {
                    boolean isRequiredMissing = field.get(bean) == null || field.get(bean) instanceof String && StringUtils.isBlank(field.get(bean).toString());
                    if (isRequiredMissing) {
                        requiredFields.add(field.getName());
                    }
                }

                field.setAccessible(isAccessible);
            } catch (IllegalArgumentException | IllegalAccessException | SecurityException var7) {
                log.error(var7.getMessage(), var7);
            }
        }

        if (!requiredFields.isEmpty()) {
            String msg = "必填字段 " + requiredFields + " 必须提供值";
            log.debug(msg);
            throw new WxErrorException(WxError.builder().errorMsg(msg).build());
        }
    }

    public static Map<String, String> xmlBean2Map(Object bean) {
        Map<String, String> result = Maps.newHashMap();
        List<Field> fields = new ArrayList<>(Arrays.asList(bean.getClass().getDeclaredFields()));
        buildFieldsOfSuper(fields, bean.getClass());

        for (Field field: fields) {
            try {
                boolean isAccessible = field.isAccessible();
                field.setAccessible(true);
                if (field.get(bean) == null) {
                    field.setAccessible(isAccessible);
                } else {
                    if (field.isAnnotationPresent(XStreamAlias.class)) {
                        result.put((field.getAnnotation(XStreamAlias.class)).value(), field.get(bean).toString());
                    } else if (!Modifier.isStatic(field.getModifiers())) {
                        result.put(field.getName(), field.get(bean).toString());
                    }

                    field.setAccessible(isAccessible);
                }
            } catch (IllegalArgumentException | IllegalAccessException | SecurityException var6) {
                log.error(var6.getMessage(), var6);
            }
        }

        return result;
    }

    private static void buildFieldsOfSuper(List<Field> fields, Class clazz) {
        while (clazz.getSuperclass() != null) {
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }
    }
}
