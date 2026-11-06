package com.facebook.yoga;

/* JADX INFO: loaded from: classes3.dex */
public enum YogaPositionType {
    STATIC(0),
    RELATIVE(1),
    ABSOLUTE(2);

    private final int mIntValue;

    YogaPositionType(int i) {
        this.mIntValue = i;
    }

    public int intValue() {
        return this.mIntValue;
    }
}
