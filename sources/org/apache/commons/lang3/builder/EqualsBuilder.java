package org.apache.commons.lang3.builder;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.tuple.Pair;

/* JADX INFO: loaded from: classes5.dex */
public class EqualsBuilder {
    private static final ThreadLocal REGISTRY = new ThreadLocal();
    private List bypassReflectionClasses;
    private boolean isEquals = true;
    private boolean testTransients = false;
    private boolean testRecursive = false;
    private Class reflectUpToClass = null;
    private String[] excludeFields = null;

    static Set getRegistry() {
        return (Set) REGISTRY.get();
    }

    static Pair getRegisterPair(Object obj, Object obj2) {
        return Pair.of(new IDKey(obj), new IDKey(obj2));
    }

    static boolean isRegistered(Object obj, Object obj2) {
        Set registry = getRegistry();
        Pair registerPair = getRegisterPair(obj, obj2);
        Pair pairOf = Pair.of(registerPair.getRight(), registerPair.getLeft());
        if (registry != null) {
            return registry.contains(registerPair) || registry.contains(pairOf);
        }
        return false;
    }

    private static void register(Object obj, Object obj2) {
        Set registry = getRegistry();
        if (registry == null) {
            registry = new HashSet();
            REGISTRY.set(registry);
        }
        registry.add(getRegisterPair(obj, obj2));
    }

    private static void unregister(Object obj, Object obj2) {
        Set registry = getRegistry();
        if (registry != null) {
            registry.remove(getRegisterPair(obj, obj2));
            if (registry.isEmpty()) {
                REGISTRY.remove();
            }
        }
    }

    public EqualsBuilder() {
        ArrayList arrayList = new ArrayList();
        this.bypassReflectionClasses = arrayList;
        arrayList.add(String.class);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0030  */
    /* JADX WARN: Code duplicated, block: B:21:0x0032  */
    public EqualsBuilder reflectionAppend(Object obj, Object obj2) {
        Class<?> superclass;
        if (this.isEquals && obj != obj2) {
            if (obj == null || obj2 == null) {
                this.isEquals = false;
                return this;
            }
            Class<?> cls = obj.getClass();
            Class<?> cls2 = obj2.getClass();
            if (cls.isInstance(obj2)) {
                if (cls2.isInstance(obj)) {
                    superclass = cls;
                } else {
                    superclass = cls2;
                }
            } else if (cls2.isInstance(obj)) {
                if (cls.isInstance(obj2)) {
                    superclass = cls2;
                } else {
                    superclass = cls;
                }
            } else {
                this.isEquals = false;
                return this;
            }
            try {
                if (superclass.isArray()) {
                    append(obj, obj2);
                    return this;
                }
                List list = this.bypassReflectionClasses;
                if (list != null && (list.contains(cls) || this.bypassReflectionClasses.contains(cls2))) {
                    this.isEquals = obj.equals(obj2);
                    return this;
                }
                reflectionAppend(obj, obj2, superclass);
                while (superclass.getSuperclass() != null && superclass != this.reflectUpToClass) {
                    superclass = superclass.getSuperclass();
                    reflectionAppend(obj, obj2, superclass);
                }
            } catch (IllegalArgumentException unused) {
                this.isEquals = false;
                return this;
            }
        }
        return this;
    }

    private void reflectionAppend(Object obj, Object obj2, Class cls) {
        if (isRegistered(obj, obj2)) {
            return;
        }
        try {
            register(obj, obj2);
            Field[] declaredFields = cls.getDeclaredFields();
            AccessibleObject.setAccessible(declaredFields, true);
            for (int i = 0; i < declaredFields.length && this.isEquals; i++) {
                Field field = declaredFields[i];
                if (!ArrayUtils.contains(this.excludeFields, field.getName()) && !field.getName().contains("$") && (this.testTransients || !Modifier.isTransient(field.getModifiers()))) {
                    if (!Modifier.isStatic(field.getModifiers()) && !field.isAnnotationPresent(EqualsExclude.class)) {
                        try {
                            append(field.get(obj), field.get(obj2));
                        } catch (IllegalAccessException unused) {
                            throw new InternalError("Unexpected IllegalAccessException");
                        }
                    }
                }
            }
            unregister(obj, obj2);
        } catch (Throwable th) {
            unregister(obj, obj2);
            throw th;
        }
    }

    public EqualsBuilder append(Object obj, Object obj2) {
        if (!this.isEquals || obj == obj2) {
            return this;
        }
        if (obj == null || obj2 == null) {
            setEquals(false);
            return this;
        }
        Class<?> cls = obj.getClass();
        if (cls.isArray()) {
            appendArray(obj, obj2);
            return this;
        }
        if (this.testRecursive && !ClassUtils.isPrimitiveOrWrapper(cls)) {
            reflectionAppend(obj, obj2);
            return this;
        }
        this.isEquals = obj.equals(obj2);
        return this;
    }

    private void appendArray(Object obj, Object obj2) {
        if (obj.getClass() != obj2.getClass()) {
            setEquals(false);
            return;
        }
        if (obj instanceof long[]) {
            append((long[]) obj, (long[]) obj2);
            return;
        }
        if (obj instanceof int[]) {
            append((int[]) obj, (int[]) obj2);
            return;
        }
        if (obj instanceof short[]) {
            append((short[]) obj, (short[]) obj2);
            return;
        }
        if (obj instanceof char[]) {
            append((char[]) obj, (char[]) obj2);
            return;
        }
        if (obj instanceof byte[]) {
            append((byte[]) obj, (byte[]) obj2);
            return;
        }
        if (obj instanceof double[]) {
            append((double[]) obj, (double[]) obj2);
            return;
        }
        if (obj instanceof float[]) {
            append((float[]) obj, (float[]) obj2);
        } else if (obj instanceof boolean[]) {
            append((boolean[]) obj, (boolean[]) obj2);
        } else {
            append((Object[]) obj, (Object[]) obj2);
        }
    }

    public EqualsBuilder append(long j, long j2) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = j == j2;
        return this;
    }

    public EqualsBuilder append(int i, int i2) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = i == i2;
        return this;
    }

    public EqualsBuilder append(short s, short s2) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = s == s2;
        return this;
    }

    public EqualsBuilder append(char c, char c2) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = c == c2;
        return this;
    }

    public EqualsBuilder append(byte b, byte b2) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = b == b2;
        return this;
    }

    public EqualsBuilder append(double d, double d2) {
        return !this.isEquals ? this : append(Double.doubleToLongBits(d), Double.doubleToLongBits(d2));
    }

    public EqualsBuilder append(float f, float f2) {
        return !this.isEquals ? this : append(Float.floatToIntBits(f), Float.floatToIntBits(f2));
    }

    public EqualsBuilder append(boolean z, boolean z2) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = z == z2;
        return this;
    }

    public EqualsBuilder append(Object[] objArr, Object[] objArr2) {
        if (this.isEquals && objArr != objArr2) {
            if (objArr == null || objArr2 == null) {
                setEquals(false);
                return this;
            }
            if (objArr.length != objArr2.length) {
                setEquals(false);
                return this;
            }
            for (int i = 0; i < objArr.length && this.isEquals; i++) {
                append(objArr[i], objArr2[i]);
            }
        }
        return this;
    }

    public EqualsBuilder append(long[] jArr, long[] jArr2) {
        if (this.isEquals && jArr != jArr2) {
            if (jArr == null || jArr2 == null) {
                setEquals(false);
                return this;
            }
            if (jArr.length != jArr2.length) {
                setEquals(false);
                return this;
            }
            for (int i = 0; i < jArr.length && this.isEquals; i++) {
                append(jArr[i], jArr2[i]);
            }
        }
        return this;
    }

    public EqualsBuilder append(int[] iArr, int[] iArr2) {
        if (this.isEquals && iArr != iArr2) {
            if (iArr == null || iArr2 == null) {
                setEquals(false);
                return this;
            }
            if (iArr.length != iArr2.length) {
                setEquals(false);
                return this;
            }
            for (int i = 0; i < iArr.length && this.isEquals; i++) {
                append(iArr[i], iArr2[i]);
            }
        }
        return this;
    }

    public EqualsBuilder append(short[] sArr, short[] sArr2) {
        if (this.isEquals && sArr != sArr2) {
            if (sArr == null || sArr2 == null) {
                setEquals(false);
                return this;
            }
            if (sArr.length != sArr2.length) {
                setEquals(false);
                return this;
            }
            for (int i = 0; i < sArr.length && this.isEquals; i++) {
                append(sArr[i], sArr2[i]);
            }
        }
        return this;
    }

    public EqualsBuilder append(char[] cArr, char[] cArr2) {
        if (this.isEquals && cArr != cArr2) {
            if (cArr == null || cArr2 == null) {
                setEquals(false);
                return this;
            }
            if (cArr.length != cArr2.length) {
                setEquals(false);
                return this;
            }
            for (int i = 0; i < cArr.length && this.isEquals; i++) {
                append(cArr[i], cArr2[i]);
            }
        }
        return this;
    }

    public EqualsBuilder append(byte[] bArr, byte[] bArr2) {
        if (this.isEquals && bArr != bArr2) {
            if (bArr == null || bArr2 == null) {
                setEquals(false);
                return this;
            }
            if (bArr.length != bArr2.length) {
                setEquals(false);
                return this;
            }
            for (int i = 0; i < bArr.length && this.isEquals; i++) {
                append(bArr[i], bArr2[i]);
            }
        }
        return this;
    }

    public EqualsBuilder append(double[] dArr, double[] dArr2) {
        if (this.isEquals && dArr != dArr2) {
            if (dArr == null || dArr2 == null) {
                setEquals(false);
                return this;
            }
            if (dArr.length != dArr2.length) {
                setEquals(false);
                return this;
            }
            for (int i = 0; i < dArr.length && this.isEquals; i++) {
                append(dArr[i], dArr2[i]);
            }
        }
        return this;
    }

    public EqualsBuilder append(float[] fArr, float[] fArr2) {
        if (this.isEquals && fArr != fArr2) {
            if (fArr == null || fArr2 == null) {
                setEquals(false);
                return this;
            }
            if (fArr.length != fArr2.length) {
                setEquals(false);
                return this;
            }
            for (int i = 0; i < fArr.length && this.isEquals; i++) {
                append(fArr[i], fArr2[i]);
            }
        }
        return this;
    }

    public EqualsBuilder append(boolean[] zArr, boolean[] zArr2) {
        if (this.isEquals && zArr != zArr2) {
            if (zArr == null || zArr2 == null) {
                setEquals(false);
                return this;
            }
            if (zArr.length != zArr2.length) {
                setEquals(false);
                return this;
            }
            for (int i = 0; i < zArr.length && this.isEquals; i++) {
                append(zArr[i], zArr2[i]);
            }
        }
        return this;
    }

    public boolean isEquals() {
        return this.isEquals;
    }

    protected void setEquals(boolean z) {
        this.isEquals = z;
    }
}
