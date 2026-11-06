package com.facebook.yoga;

/* JADX INFO: loaded from: classes3.dex */
public enum YogaFlexDirection {
    COLUMN(0),
    COLUMN_REVERSE(1),
    ROW(2),
    ROW_REVERSE(3);

    private final int mIntValue;

    YogaFlexDirection(int i) {
        this.mIntValue = i;
    }

    public int intValue() {
        return this.mIntValue;
    }
}
