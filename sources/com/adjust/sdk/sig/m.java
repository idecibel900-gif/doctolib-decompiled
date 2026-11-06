package com.adjust.sdk.sig;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class m {
    public final Class a;

    static {
        List listAsList = Arrays.asList(g0.class, r0.class, v0.class, w0.class, x0.class, y0.class, z0.class, a1.class, b1.class, c1.class, h0.class, i0.class, j0.class, k0.class, l0.class, m0.class, n0.class, o0.class, p0.class, q0.class, s0.class, t0.class, u0.class);
        ArrayList arrayList = new ArrayList(listAsList.size());
        int i = 0;
        int i2 = 0;
        for (Object obj : listAsList) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                throw new ArithmeticException("Index overflow has happened.");
            }
            arrayList.add(new a2((Class) obj, Integer.valueOf(i2)));
            i2 = i3;
        }
        int size = arrayList.size();
        if (size != 0) {
            if (size == 1) {
                a2 a2Var = (a2) arrayList.get(0);
                Collections.singletonMap(a2Var.a, a2Var.b);
                return;
            }
            int size2 = arrayList.size();
            if (size2 >= 0) {
                size2 = size2 < 3 ? size2 + 1 : size2 < 1073741824 ? (int) ((size2 / 0.75f) + 1.0f) : Integer.MAX_VALUE;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(size2);
            int size3 = arrayList.size();
            while (i < size3) {
                Object obj2 = arrayList.get(i);
                i++;
                a2 a2Var2 = (a2) obj2;
                linkedHashMap.put(a2Var2.a, a2Var2.b);
            }
        }
    }

    public m(Class cls) {
        this.a = cls;
    }

    public final String a() {
        String strA;
        Class cls = this.a;
        String strConcat = null;
        if (cls.isAnonymousClass()) {
            return null;
        }
        if (!cls.isLocalClass()) {
            if (!cls.isArray()) {
                String strA2 = l.a(cls.getName());
                return strA2 == null ? cls.getSimpleName() : strA2;
            }
            Class<?> componentType = cls.getComponentType();
            if (componentType.isPrimitive() && (strA = l.a(componentType.getName())) != null) {
                strConcat = strA.concat("Array");
            }
            return strConcat == null ? "Array" : strConcat;
        }
        String simpleName = cls.getSimpleName();
        Method enclosingMethod = cls.getEnclosingMethod();
        if (enclosingMethod != null) {
            String str = enclosingMethod.getName() + '$';
            int iIndexOf = simpleName.indexOf(str, 0);
            if (iIndexOf != -1) {
                return simpleName.substring(str.length() + iIndexOf, simpleName.length());
            }
        } else {
            Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
            if (enclosingConstructor != null) {
                String str2 = enclosingConstructor.getName() + '$';
                int iIndexOf2 = simpleName.indexOf(str2, 0);
                if (iIndexOf2 != -1) {
                    return simpleName.substring(str2.length() + iIndexOf2, simpleName.length());
                }
            } else {
                int iIndexOf3 = simpleName.indexOf(36, 0);
                if (iIndexOf3 != -1) {
                    return simpleName.substring(iIndexOf3 + 1, simpleName.length());
                }
            }
        }
        return simpleName;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof m) && p1.a(this).equals(p1.a((m) obj));
    }

    public final int hashCode() {
        return p1.a(this).hashCode();
    }

    public final String toString() {
        return this.a + " (Kotlin reflection is not available)";
    }
}
