package com.facebook.yoga;

/* JADX INFO: loaded from: classes3.dex */
public enum YogaDisplay {
    FLEX(0),
    NONE(1),
    CONTENTS(2);

    private final int mIntValue;

    YogaDisplay(int i) {
        this.mIntValue = i;
    }

    public int intValue() {
        return this.mIntValue;
    }
}
