package com.facebook.yoga;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class YogaValue {
    public static final YogaValue AUTO;
    public static final Companion Companion = new Companion(null);
    public static final YogaValue UNDEFINED;
    public static final YogaValue ZERO;
    public final YogaUnit unit;
    public final float value;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[YogaUnit.values().length];
            try {
                iArr[YogaUnit.UNDEFINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[YogaUnit.POINT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[YogaUnit.PERCENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[YogaUnit.AUTO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public YogaValue(float f, YogaUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.value = f;
        this.unit = unit;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public YogaValue(float f, int i) {
        YogaUnit yogaUnitFromInt = YogaUnit.fromInt(i);
        Intrinsics.checkNotNullExpressionValue(yogaUnitFromInt, "fromInt(...)");
        this(f, yogaUnitFromInt);
    }

    public boolean equals(Object obj) {
        if (obj instanceof YogaValue) {
            YogaUnit yogaUnit = this.unit;
            YogaValue yogaValue = (YogaValue) obj;
            if (yogaUnit == yogaValue.unit) {
                return yogaUnit == YogaUnit.UNDEFINED || yogaUnit == YogaUnit.AUTO || Float.compare(this.value, yogaValue.value) == 0;
            }
        }
        return false;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.value) + this.unit.intValue();
    }

    public String toString() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.unit.ordinal()];
        if (i == 1) {
            return "undefined";
        }
        if (i == 2) {
            return String.valueOf(this.value);
        }
        if (i != 3) {
            if (i == 4) {
                return "auto";
            }
            throw new IllegalStateException();
        }
        return this.value + "%";
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final YogaValue parse(String str) {
            if (str == null) {
                return null;
            }
            if (Intrinsics.areEqual("undefined", str)) {
                return YogaValue.UNDEFINED;
            }
            if (Intrinsics.areEqual("auto", str)) {
                return YogaValue.AUTO;
            }
            if (StringsKt.endsWith$default(str, "%", false, 2, (Object) null)) {
                String strSubstring = str.substring(0, str.length() - 1);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                return new YogaValue(Float.parseFloat(strSubstring), YogaUnit.PERCENT);
            }
            return new YogaValue(Float.parseFloat(str), YogaUnit.POINT);
        }
    }

    static {
        float f = YogaConstants.UNDEFINED;
        UNDEFINED = new YogaValue(f, YogaUnit.UNDEFINED);
        ZERO = new YogaValue(0.0f, YogaUnit.POINT);
        AUTO = new YogaValue(f, YogaUnit.AUTO);
    }
}
