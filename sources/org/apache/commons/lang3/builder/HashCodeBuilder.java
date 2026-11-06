package org.apache.commons.lang3.builder;

/* JADX INFO: loaded from: classes5.dex */
public class HashCodeBuilder {
    private static final ThreadLocal REGISTRY = new ThreadLocal();
    private final int iConstant = 37;
    private int iTotal = 17;

    public HashCodeBuilder append(boolean z) {
        this.iTotal = (this.iTotal * this.iConstant) + (!z ? 1 : 0);
        return this;
    }

    public HashCodeBuilder append(boolean[] zArr) {
        if (zArr == null) {
            this.iTotal *= this.iConstant;
            return this;
        }
        for (boolean z : zArr) {
            append(z);
        }
        return this;
    }

    public HashCodeBuilder append(byte b) {
        this.iTotal = (this.iTotal * this.iConstant) + b;
        return this;
    }

    public HashCodeBuilder append(byte[] bArr) {
        if (bArr == null) {
            this.iTotal *= this.iConstant;
            return this;
        }
        for (byte b : bArr) {
            append(b);
        }
        return this;
    }

    public HashCodeBuilder append(char c) {
        this.iTotal = (this.iTotal * this.iConstant) + c;
        return this;
    }

    public HashCodeBuilder append(char[] cArr) {
        if (cArr == null) {
            this.iTotal *= this.iConstant;
            return this;
        }
        for (char c : cArr) {
            append(c);
        }
        return this;
    }

    public HashCodeBuilder append(double d) {
        return append(Double.doubleToLongBits(d));
    }

    public HashCodeBuilder append(double[] dArr) {
        if (dArr == null) {
            this.iTotal *= this.iConstant;
            return this;
        }
        for (double d : dArr) {
            append(d);
        }
        return this;
    }

    public HashCodeBuilder append(float f) {
        this.iTotal = (this.iTotal * this.iConstant) + Float.floatToIntBits(f);
        return this;
    }

    public HashCodeBuilder append(float[] fArr) {
        if (fArr == null) {
            this.iTotal *= this.iConstant;
            return this;
        }
        for (float f : fArr) {
            append(f);
        }
        return this;
    }

    public HashCodeBuilder append(int i) {
        this.iTotal = (this.iTotal * this.iConstant) + i;
        return this;
    }

    public HashCodeBuilder append(int[] iArr) {
        if (iArr == null) {
            this.iTotal *= this.iConstant;
            return this;
        }
        for (int i : iArr) {
            append(i);
        }
        return this;
    }

    public HashCodeBuilder append(long j) {
        this.iTotal = (this.iTotal * this.iConstant) + ((int) (j ^ (j >> 32)));
        return this;
    }

    public HashCodeBuilder append(long[] jArr) {
        if (jArr == null) {
            this.iTotal *= this.iConstant;
            return this;
        }
        for (long j : jArr) {
            append(j);
        }
        return this;
    }

    public HashCodeBuilder append(Object obj) {
        if (obj == null) {
            this.iTotal *= this.iConstant;
            return this;
        }
        if (obj.getClass().isArray()) {
            appendArray(obj);
            return this;
        }
        this.iTotal = (this.iTotal * this.iConstant) + obj.hashCode();
        return this;
    }

    private void appendArray(Object obj) {
        if (obj instanceof long[]) {
            append((long[]) obj);
            return;
        }
        if (obj instanceof int[]) {
            append((int[]) obj);
            return;
        }
        if (obj instanceof short[]) {
            append((short[]) obj);
            return;
        }
        if (obj instanceof char[]) {
            append((char[]) obj);
            return;
        }
        if (obj instanceof byte[]) {
            append((byte[]) obj);
            return;
        }
        if (obj instanceof double[]) {
            append((double[]) obj);
            return;
        }
        if (obj instanceof float[]) {
            append((float[]) obj);
        } else if (obj instanceof boolean[]) {
            append((boolean[]) obj);
        } else {
            append((Object[]) obj);
        }
    }

    public HashCodeBuilder append(Object[] objArr) {
        if (objArr == null) {
            this.iTotal *= this.iConstant;
            return this;
        }
        for (Object obj : objArr) {
            append(obj);
        }
        return this;
    }

    public HashCodeBuilder append(short s) {
        this.iTotal = (this.iTotal * this.iConstant) + s;
        return this;
    }

    public HashCodeBuilder append(short[] sArr) {
        if (sArr == null) {
            this.iTotal *= this.iConstant;
            return this;
        }
        for (short s : sArr) {
            append(s);
        }
        return this;
    }

    public int toHashCode() {
        return this.iTotal;
    }

    public int hashCode() {
        return toHashCode();
    }
}
