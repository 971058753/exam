package com.test.commom;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Slf4j
public final class Validator {

    private Validator() {

    }

    public static boolean greaterZero(Long id) {
        if (null == id) {
            return false;
        }
        return id > 0L;
    }

    public static boolean greaterZero(Integer id) {
        if (null == id) {
            return false;
        }
        return id > 0;
    }

    public static boolean isTrue(Boolean bool) {
        if (null == bool) {
            return false;
        }
        return bool;
    }

    public static boolean isFalse(Boolean bool) {
        return !isTrue(bool);
    }

    public static boolean isNullOrEmpty(Object value) {
        if (null == value) {
            return true;
        }

        if (value instanceof CharSequence) {
            if (value instanceof String && "null".equals(((String) value).toLowerCase())) {
                return true;
            }
            return StringUtils.isBlank((CharSequence) value);
        }

        if (isCollectionsSupportType(value)) {
            return CollectionUtils.sizeIsEmpty(value);
        }
        return false;
    }

    public static boolean isNotNullOrEmpty(Object value) {
        return !isNullOrEmpty(value);
    }

    public static boolean isAllNullOrEmpty(Object... valueList) {
        for (Object value : valueList) {
            if (!isNullOrEmpty(value)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAllNotNullOrEmpty(Object... valueList) {
        for (Object value : valueList) {
            if (isNullOrEmpty(value)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNull(Object value) {
        return null == value;
    }

    public static boolean isNotNull(Object value) {
        return !isNull(value);
    }

    public static boolean isAllNull(Object... valueList) {
        for (Object value : valueList) {
            if (!isNull(value)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAllNotNull(Object... valueList) {
        for (Object value : valueList) {
            if (isNull(value)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isId(Long value) {
        return null != value && value > 0;
    }

    public static boolean isNotId(Long value) {
        return !isId(value);
    }

    public static boolean isId(Integer value) {
        return null != value && value > 0;
    }

    public static boolean isNotId(Integer value) {
        return !isId(value);
    }

    public static boolean isAllId(Integer... valueList) {
        for (Integer value : valueList) {
            if (!isId(value)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAllId(Long... valueList) {
        for (Long value : valueList) {
            if (!isId(value)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAllId(List<? extends Number> idList) {
        for (Number value : idList) {
            if (!Validator.isId(value.intValue())) {
                return false;
            }
        }

        return true;
    }

    public static boolean isAllNotId(Integer... valueList) {
        for (Integer value : valueList) {
            if (isId(value)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAllNotId(Long... valueList) {
        for (Long value : valueList) {
            if (isId(value)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isCollectionsSupportType(Object value) {
        boolean isCollectionOrMap = value instanceof Collection || value instanceof Map;
        boolean isEnumerationOrIterator = value instanceof Enumeration || value instanceof Iterator;
        return isCollectionOrMap// 集合或者map
                || isEnumerationOrIterator// 枚举 或者是 Iterator迭代器
                || value.getClass().isArray()// 判断数组
                ;
    }

    /**
     * 判断一个对象的是不是所有属性为null或者empty
     */
    public static boolean isPropertiesAllNull(Object obj) {
        try {
            for (Field field : obj.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object object = field.get(obj);
                if (object instanceof CharSequence) {
                    if (!ObjectUtils.isEmpty((String) object)) {
                        return false;
                    }
                } else {
                    if (!isNull(object)) {
                        return false;
                    }
                }

            }
        } catch (Exception e) {
            log.error("validator failed obj: {}, exception: {}", obj, e);
        }
        return true;
    }
}