package com.facebook.yoga;

/* JADX INFO: loaded from: classes3.dex */
public final class YogaMeasureOutput {
    public static final YogaMeasureOutput INSTANCE = new YogaMeasureOutput();

    private YogaMeasureOutput() {
    }

    public static final long make(float f, float f2) {
        return ((long) Float.floatToRawIntBits(f2)) | (((long) Float.floatToRawIntBits(f)) << 32);
    }

    public static final long make(int i, int i2) {
        return make(i, i2);
    }

    public static final float getWidth(long j) {
        return Float.intBitsToFloat((int) ((j >> 32) & 4294967295L));
    }

    public static final float getHeight(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }
}
