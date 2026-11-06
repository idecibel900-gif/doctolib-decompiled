package com.facebook.react.uimanager;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class LengthPercentage {
    public static final Companion Companion = new Companion(null);
    private final LengthPercentageType type;
    private final float value;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LengthPercentage)) {
            return false;
        }
        LengthPercentage lengthPercentage = (LengthPercentage) obj;
        return Float.compare(this.value, lengthPercentage.value) == 0 && this.type == lengthPercentage.type;
    }

    public int hashCode() {
        return (Float.hashCode(this.value) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "LengthPercentage(value=" + this.value + ", type=" + this.type + ")";
    }

    public LengthPercentage(float f, LengthPercentageType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.value = f;
        this.type = type;
    }

    public final LengthPercentageType getType() {
        return this.type;
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
                    iArr[ReadableType.String.ordinal()] = 2;
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

        public static /* synthetic */ LengthPercentage setFromDynamic$default(Companion companion, Dynamic dynamic, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.setFromDynamic(dynamic, z);
        }

        public final LengthPercentage setFromDynamic(Dynamic dynamic, boolean z) {
            Intrinsics.checkNotNullParameter(dynamic, "dynamic");
            int i = WhenMappings.$EnumSwitchMapping$0[dynamic.getType().ordinal()];
            if (i == 1) {
                double dAsDouble = dynamic.asDouble();
                if (dAsDouble >= 0.0d || z) {
                    return new LengthPercentage((float) dAsDouble, LengthPercentageType.POINT);
                }
                return null;
            }
            if (i == 2) {
                String strAsString = dynamic.asString();
                if (strAsString != null && StringsKt.endsWith$default(strAsString, "%", false, 2, (Object) null)) {
                    try {
                        String strSubstring = strAsString.substring(0, strAsString.length() - 1);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                        float f = Float.parseFloat(strSubstring);
                        if (f >= 0.0f || z) {
                            return new LengthPercentage(f, LengthPercentageType.PERCENT);
                        }
                        return null;
                    } catch (NumberFormatException unused) {
                        FLog.w("ReactNative", "Invalid percentage format: " + strAsString);
                        return null;
                    }
                }
                FLog.w("ReactNative", "Invalid string value: " + strAsString);
                return null;
            }
            FLog.w("ReactNative", "Unsupported type for radius property: " + dynamic.getType());
            return null;
        }
    }

    public final float resolve(float f) {
        if (this.type == LengthPercentageType.PERCENT) {
            return (this.value / 100) * f;
        }
        return this.value;
    }
}
