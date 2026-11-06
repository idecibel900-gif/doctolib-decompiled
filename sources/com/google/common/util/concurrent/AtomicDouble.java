package com.google.common.util.concurrent;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public class AtomicDouble extends Number {
    private transient AtomicLong value;

    public AtomicDouble(double d) {
        this.value = new AtomicLong(Double.doubleToRawLongBits(d));
    }

    public final double get() {
        return Double.longBitsToDouble(this.value.get());
    }

    public final void set(double d) {
        this.value.set(Double.doubleToRawLongBits(d));
    }

    public String toString() {
        return Double.toString(get());
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) get();
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) get();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) get();
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return get();
    }
}
