package com.facebook.react.uimanager.style;

import com.facebook.react.uimanager.LengthPercentage;

/* JADX INFO: loaded from: classes3.dex */
public final class ColorStop {
    private Integer color;
    private final LengthPercentage position;

    public ColorStop(Integer num, LengthPercentage lengthPercentage) {
        this.color = num;
        this.position = lengthPercentage;
    }

    public final Integer getColor() {
        return this.color;
    }

    public final LengthPercentage getPosition() {
        return this.position;
    }
}
