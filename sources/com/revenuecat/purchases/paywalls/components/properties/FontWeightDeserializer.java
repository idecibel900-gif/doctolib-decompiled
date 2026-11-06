package com.revenuecat.purchases.paywalls.components.properties;

import com.revenuecat.purchases.utils.serializers.EnumDeserializerWithDefault;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/FontWeightDeserializer;", "Lcom/revenuecat/purchases/utils/serializers/EnumDeserializerWithDefault;", "Lcom/revenuecat/purchases/paywalls/components/properties/FontWeight;", "()V", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FontWeightDeserializer extends EnumDeserializerWithDefault<FontWeight> {
    public static final FontWeightDeserializer INSTANCE = new FontWeightDeserializer();

    private FontWeightDeserializer() {
        super(FontWeight.REGULAR, new Function1() { // from class: com.revenuecat.purchases.paywalls.components.properties.FontWeightDeserializer.1

            /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.properties.FontWeightDeserializer$1$WhenMappings */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[FontWeight.values().length];
                    try {
                        iArr[FontWeight.EXTRA_LIGHT.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[FontWeight.THIN.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[FontWeight.LIGHT.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[FontWeight.REGULAR.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[FontWeight.MEDIUM.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    try {
                        iArr[FontWeight.SEMI_BOLD.ordinal()] = 6;
                    } catch (NoSuchFieldError unused6) {
                    }
                    try {
                        iArr[FontWeight.BOLD.ordinal()] = 7;
                    } catch (NoSuchFieldError unused7) {
                    }
                    try {
                        iArr[FontWeight.EXTRA_BOLD.ordinal()] = 8;
                    } catch (NoSuchFieldError unused8) {
                    }
                    try {
                        iArr[FontWeight.BLACK.ordinal()] = 9;
                    } catch (NoSuchFieldError unused9) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(FontWeight value) {
                Intrinsics.checkNotNullParameter(value, "value");
                switch (WhenMappings.$EnumSwitchMapping$0[value.ordinal()]) {
                    case 1:
                        return "extra_light";
                    case 2:
                        return "thin";
                    case 3:
                        return "light";
                    case 4:
                        return "regular";
                    case 5:
                        return "medium";
                    case 6:
                        return "semibold";
                    case 7:
                        return "bold";
                    case 8:
                        return "extra_bold";
                    case 9:
                        return "black";
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
        });
    }
}
