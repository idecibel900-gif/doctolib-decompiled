package com.facebook.yoga;

/* JADX INFO: loaded from: classes3.dex */
public enum YogaWrap {
    NO_WRAP(0),
    WRAP(1),
    WRAP_REVERSE(2);

    private final int mIntValue;

    YogaWrap(int i) {
        this.mIntValue = i;
    }

    public int intValue() {
        return this.mIntValue;
    }
}
