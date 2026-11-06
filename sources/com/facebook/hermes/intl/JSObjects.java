package com.facebook.hermes.intl;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class JSObjects {
    private static Object s_null;
    private static Object s_undefined;

    public static Object newString(String str) {
        return str;
    }

    private static class UndefinedObject {
        private UndefinedObject() {
        }
    }

    private static class NullObject {
        private NullObject() {
        }
    }

    static {
        s_undefined = new UndefinedObject();
        s_null = new NullObject();
    }

    public static Object Undefined() {
        return s_undefined;
    }

    public static boolean isUndefined(Object obj) {
        return obj instanceof UndefinedObject;
    }

    public static Object Null() {
        return s_null;
    }

    public static boolean isNull(Object obj) {
        return obj instanceof NullObject;
    }

    public static boolean isString(Object obj) {
        return obj instanceof String;
    }

    public static boolean isBoolean(Object obj) {
        return obj instanceof Boolean;
    }

    public static Object newBoolean(boolean z) {
        return Boolean.valueOf(z);
    }

    public static boolean getJavaBoolean(Object obj) {
        return ((Boolean) obj).booleanValue();
    }

    public static boolean isNumber(Object obj) {
        return obj instanceof Double;
    }

    public static Object newNumber(double d) {
        return Double.valueOf(d);
    }

    public static double getJavaDouble(Object obj) {
        return ((Double) obj).doubleValue();
    }

    public static String getJavaString(Object obj) {
        return (String) obj;
    }

    public static boolean isObject(Object obj) {
        return obj instanceof HashMap;
    }

    public static Map getJavaMap(Object obj) {
        return (HashMap) obj;
    }

    public static Object newObject() {
        return new HashMap();
    }

    public static Object Get(Object obj, String str) {
        HashMap map = (HashMap) obj;
        if (map.containsKey(str)) {
            Object obj2 = map.get(str);
            return obj2 == null ? Null() : obj2;
        }
        return Undefined();
    }

    public static void Put(Object obj, String str, Object obj2) {
        ((HashMap) obj).put(str, obj2);
    }
}
