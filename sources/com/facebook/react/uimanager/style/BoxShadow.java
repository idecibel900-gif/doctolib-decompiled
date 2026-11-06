package com.facebook.react.uimanager.style;

import android.content.Context;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class BoxShadow {
    public static final Companion Companion = new Companion(null);
    private final Float blurRadius;
    private final Integer color;
    private final Boolean inset;
    private final float offsetX;
    private final float offsetY;
    private final Float spreadDistance;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BoxShadow)) {
            return false;
        }
        BoxShadow boxShadow = (BoxShadow) obj;
        return Float.compare(this.offsetX, boxShadow.offsetX) == 0 && Float.compare(this.offsetY, boxShadow.offsetY) == 0 && Intrinsics.areEqual(this.color, boxShadow.color) && Intrinsics.areEqual(this.blurRadius, boxShadow.blurRadius) && Intrinsics.areEqual(this.spreadDistance, boxShadow.spreadDistance) && Intrinsics.areEqual(this.inset, boxShadow.inset);
    }

    public int hashCode() {
        int iHashCode = ((Float.hashCode(this.offsetX) * 31) + Float.hashCode(this.offsetY)) * 31;
        Integer num = this.color;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Float f = this.blurRadius;
        int iHashCode3 = (iHashCode2 + (f == null ? 0 : f.hashCode())) * 31;
        Float f2 = this.spreadDistance;
        int iHashCode4 = (iHashCode3 + (f2 == null ? 0 : f2.hashCode())) * 31;
        Boolean bool = this.inset;
        return iHashCode4 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "BoxShadow(offsetX=" + this.offsetX + ", offsetY=" + this.offsetY + ", color=" + this.color + ", blurRadius=" + this.blurRadius + ", spreadDistance=" + this.spreadDistance + ", inset=" + this.inset + ")";
    }

    public BoxShadow(float f, float f2, Integer num, Float f3, Float f4, Boolean bool) {
        this.offsetX = f;
        this.offsetY = f2;
        this.color = num;
        this.blurRadius = f3;
        this.spreadDistance = f4;
        this.inset = bool;
    }

    public final float getOffsetX() {
        return this.offsetX;
    }

    public final float getOffsetY() {
        return this.offsetY;
    }

    public final Integer getColor() {
        return this.color;
    }

    public final Float getBlurRadius() {
        return this.blurRadius;
    }

    public final Float getSpreadDistance() {
        return this.spreadDistance;
    }

    public final Boolean getInset() {
        return this.inset;
    }

    public static final class Companion {

        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ReadableType.values().length];
                try {
                    iArr[ReadableType.Number.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ReadableType.Map.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BoxShadow parse(ReadableMap readableMap, Context context) {
            Integer num;
            Integer numValueOf;
            Intrinsics.checkNotNullParameter(context, "context");
            if (readableMap == null || !readableMap.hasKey("offsetX") || !readableMap.hasKey("offsetY")) {
                return null;
            }
            float f = (float) readableMap.getDouble("offsetX");
            float f2 = (float) readableMap.getDouble("offsetY");
            if (readableMap.hasKey("color")) {
                ReadableType type = readableMap.getType("color");
                int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
                if (i == 1) {
                    numValueOf = Integer.valueOf(readableMap.getInt("color"));
                } else if (i == 2) {
                    numValueOf = ColorPropConverter.getColor(readableMap.getMap("color"), context);
                } else {
                    throw new JSApplicationCausedNativeException("Unsupported color type " + type);
                }
                num = numValueOf;
            } else {
                num = null;
            }
            return new BoxShadow(f, f2, num, readableMap.hasKey("blurRadius") ? Float.valueOf((float) readableMap.getDouble("blurRadius")) : null, readableMap.hasKey("spreadDistance") ? Float.valueOf((float) readableMap.getDouble("spreadDistance")) : null, readableMap.hasKey("inset") ? Boolean.valueOf(readableMap.getBoolean("inset")) : null);
        }
    }
}
