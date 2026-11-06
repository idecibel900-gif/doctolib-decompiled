package com.facebook.yoga;

/* JADX INFO: loaded from: classes3.dex */
public enum YogaOverflow {
    VISIBLE(0),
    HIDDEN(1),
    SCROLL(2);

    private final int mIntValue;

    YogaOverflow(int i) {
        this.mIntValue = i;
    }

    public int intValue() {
        return this.mIntValue;
    }
}
