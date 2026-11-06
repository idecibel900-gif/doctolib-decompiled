package com.facebook.react.uimanager.style;

import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.PixelUtil;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class CornerRadii {
    private final float horizontal;
    private final float vertical;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CornerRadii)) {
            return false;
        }
        CornerRadii cornerRadii = (CornerRadii) obj;
        return Float.compare(this.horizontal, cornerRadii.horizontal) == 0 && Float.compare(this.vertical, cornerRadii.vertical) == 0;
    }

    public int hashCode() {
        return (Float.hashCode(this.horizontal) * 31) + Float.hashCode(this.vertical);
    }

    public String toString() {
        return "CornerRadii(horizontal=" + this.horizontal + ", vertical=" + this.vertical + ")";
    }

    public CornerRadii(float f, float f2) {
        this.horizontal = f;
        this.vertical = f2;
    }

    public final float getHorizontal() {
        return this.horizontal;
    }

    public final float getVertical() {
        return this.vertical;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CornerRadii(LengthPercentage length, float f, float f2) {
        this(length.resolve(f), length.resolve(f2));
        Intrinsics.checkNotNullParameter(length, "length");
    }

    public final CornerRadii toPixelFromDIP() {
        return new CornerRadii(PixelUtil.toPixelFromDIP(this.horizontal), PixelUtil.toPixelFromDIP(this.vertical));
    }
}
