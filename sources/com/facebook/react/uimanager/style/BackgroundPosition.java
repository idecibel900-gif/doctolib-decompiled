package com.facebook.react.uimanager.style;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.LengthPercentage;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class BackgroundPosition {
    public static final Companion Companion = new Companion(null);
    private final LengthPercentage bottom;
    private final LengthPercentage left;
    private final LengthPercentage right;
    private final LengthPercentage top;

    public BackgroundPosition(LengthPercentage lengthPercentage, LengthPercentage lengthPercentage2, LengthPercentage lengthPercentage3, LengthPercentage lengthPercentage4) {
        this.top = lengthPercentage;
        this.left = lengthPercentage2;
        this.right = lengthPercentage3;
        this.bottom = lengthPercentage4;
    }

    public final LengthPercentage getTop() {
        return this.top;
    }

    public final LengthPercentage getLeft() {
        return this.left;
    }

    public final LengthPercentage getRight() {
        return this.right;
    }

    public final LengthPercentage getBottom() {
        return this.bottom;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BackgroundPosition parse(ReadableMap readableMap) {
            LengthPercentage fromDynamic = null;
            if (readableMap == null) {
                return null;
            }
            LengthPercentage fromDynamic2 = (!readableMap.hasKey("top") || readableMap.getType("top") == ReadableType.Null) ? null : LengthPercentage.Companion.setFromDynamic(readableMap.getDynamic("top"), true);
            LengthPercentage fromDynamic3 = (!readableMap.hasKey("left") || readableMap.getType("left") == ReadableType.Null) ? null : LengthPercentage.Companion.setFromDynamic(readableMap.getDynamic("left"), true);
            LengthPercentage fromDynamic4 = (!readableMap.hasKey("right") || readableMap.getType("right") == ReadableType.Null) ? null : LengthPercentage.Companion.setFromDynamic(readableMap.getDynamic("right"), true);
            if (readableMap.hasKey("bottom") && readableMap.getType("bottom") != ReadableType.Null) {
                fromDynamic = LengthPercentage.Companion.setFromDynamic(readableMap.getDynamic("bottom"), true);
            }
            return new BackgroundPosition(fromDynamic2, fromDynamic3, fromDynamic4, fromDynamic);
        }
    }
}
