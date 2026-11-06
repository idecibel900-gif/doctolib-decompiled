package com.reactnativekeyboardcontroller.views.background;

/* JADX INFO: loaded from: classes4.dex */
public final class ColorProperties {
    private final int color;
    private final int tone;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ColorProperties)) {
            return false;
        }
        ColorProperties colorProperties = (ColorProperties) obj;
        return this.color == colorProperties.color && this.tone == colorProperties.tone;
    }

    public int hashCode() {
        return (Integer.hashCode(this.color) * 31) + Integer.hashCode(this.tone);
    }

    public String toString() {
        return "ColorProperties(color=" + this.color + ", tone=" + this.tone + ")";
    }

    public ColorProperties(int i, int i2) {
        this.color = i;
        this.tone = i2;
    }

    public final int getBlend() {
        return SkinsKt.shiftRgbChannels(this.color, this.tone);
    }
}
