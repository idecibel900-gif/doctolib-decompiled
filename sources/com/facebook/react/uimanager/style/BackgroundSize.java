package com.facebook.react.uimanager.style;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BackgroundSize {
    public static final Companion Companion = new Companion(null);

    public /* synthetic */ BackgroundSize(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final class LengthPercentageAuto extends BackgroundSize {
        private final BackgroundSizeLengthPercentage lengthPercentage;

        public final BackgroundSizeLengthPercentage getLengthPercentage() {
            return this.lengthPercentage;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LengthPercentageAuto(BackgroundSizeLengthPercentage lengthPercentage) {
            super(null);
            Intrinsics.checkNotNullParameter(lengthPercentage, "lengthPercentage");
            this.lengthPercentage = lengthPercentage;
        }
    }

    private BackgroundSize() {
    }

    public static final class Companion {

        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ReadableType.values().length];
                try {
                    iArr[ReadableType.Map.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BackgroundSize parse(Dynamic dynamic) {
            ReadableMap readableMapAsMap;
            BackgroundSizeLengthPercentage backgroundSizeLengthPercentage;
            if (dynamic == null) {
                return null;
            }
            if (WhenMappings.$EnumSwitchMapping$0[dynamic.getType().ordinal()] != 1 || (readableMapAsMap = dynamic.asMap()) == null || (backgroundSizeLengthPercentage = BackgroundSizeLengthPercentage.Companion.parse(readableMapAsMap)) == null) {
                return null;
            }
            return new LengthPercentageAuto(backgroundSizeLengthPercentage);
        }
    }
}
