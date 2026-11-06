package org.apache.commons.lang3;

import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ObjectUtils {
    public static final Null NULL = new Null();

    public static void identityToString(StringBuffer stringBuffer, Object obj) {
        Validate.notNull(obj, "Cannot get the toString of a null object", new Object[0]);
        String name = obj.getClass().getName();
        String hexString = Integer.toHexString(System.identityHashCode(obj));
        stringBuffer.ensureCapacity(stringBuffer.length() + name.length() + 1 + hexString.length());
        stringBuffer.append(name);
        stringBuffer.append('@');
        stringBuffer.append(hexString);
    }

    public static class Null implements Serializable {
        Null() {
        }
    }
}
