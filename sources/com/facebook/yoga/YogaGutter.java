package com.facebook.yoga;

/* JADX INFO: loaded from: classes3.dex */
public enum YogaGutter {
    COLUMN(0),
    ROW(1),
    ALL(2);

    private final int mIntValue;

    YogaGutter(int i) {
        this.mIntValue = i;
    }

    public int intValue() {
        return this.mIntValue;
    }
}
