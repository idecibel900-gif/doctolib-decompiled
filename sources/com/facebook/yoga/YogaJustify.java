package com.facebook.yoga;

/* JADX INFO: loaded from: classes3.dex */
public enum YogaJustify {
    FLEX_START(0),
    CENTER(1),
    FLEX_END(2),
    SPACE_BETWEEN(3),
    SPACE_AROUND(4),
    SPACE_EVENLY(5);

    private final int mIntValue;

    YogaJustify(int i) {
        this.mIntValue = i;
    }

    public int intValue() {
        return this.mIntValue;
    }
}
