package com.facebook.react.uimanager.style;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.LengthPercentage;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class BackgroundSizeLengthPercentage {
    public static final Companion Companion = new Companion(null);
    private final LengthPercentage x;
    private final LengthPercentage y;

    public BackgroundSizeLengthPercentage(LengthPercentage lengthPercentage, LengthPercentage lengthPercentage2) {
        this.x = lengthPercentage;
        this.y = lengthPercentage2;
    }

    public final LengthPercentage getX() {
        return this.x;
    }

    public final LengthPercentage getY() {
        return this.y;
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

        /* JADX WARN: Code duplicated, block: B:12:0x002b  */
        public final BackgroundSizeLengthPercentage parse(ReadableMap readableMap) {
            LengthPercentage fromDynamic$default;
            LengthPercentage fromDynamic$default2 = null;
            if (readableMap == null) {
                return null;
            }
            if (!readableMap.hasKey("x") || readableMap.getType("x") == ReadableType.Null) {
                fromDynamic$default = null;
            } else {
                int i = WhenMappings.$EnumSwitchMapping$0[readableMap.getType("x").ordinal()];
                if (i == 1) {
                    fromDynamic$default = LengthPercentage.Companion.setFromDynamic$default(LengthPercentage.Companion, readableMap.getDynamic("x"), false, 2, null);
                } else if (i != 2) {
                    fromDynamic$default = null;
                } else {
                    String string = readableMap.getString("x");
                    if (Intrinsics.areEqual(string, "auto") || string == null || !StringsKt.endsWith$default(string, "%", false, 2, (Object) null)) {
                        fromDynamic$default = null;
                    } else {
                        fromDynamic$default = LengthPercentage.Companion.setFromDynamic$default(LengthPercentage.Companion, readableMap.getDynamic("x"), false, 2, null);
                    }
                }
            }
            if (readableMap.hasKey("y") && readableMap.getType("y") != ReadableType.Null) {
                int i2 = WhenMappings.$EnumSwitchMapping$0[readableMap.getType("y").ordinal()];
                if (i2 == 1) {
                    fromDynamic$default2 = LengthPercentage.Companion.setFromDynamic$default(LengthPercentage.Companion, readableMap.getDynamic("y"), false, 2, null);
                } else if (i2 == 2) {
                    String string2 = readableMap.getString("y");
                    if (!Intrinsics.areEqual(string2, "auto") && string2 != null && StringsKt.endsWith$default(string2, "%", false, 2, (Object) null)) {
                        fromDynamic$default2 = LengthPercentage.Companion.setFromDynamic$default(LengthPercentage.Companion, readableMap.getDynamic("y"), false, 2, null);
                    }
                }
            }
            return new BackgroundSizeLengthPercentage(fromDynamic$default, fromDynamic$default2);
        }
    }
}
