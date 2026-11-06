package com.revenuecat.purchases.paywalls.components.properties;

import com.adjust.sdk.Constants;
import com.revenuecat.purchases.utils.serializers.EnumDeserializerWithDefault;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/FontStyleDeserializer;", "Lcom/revenuecat/purchases/utils/serializers/EnumDeserializerWithDefault;", "Lcom/revenuecat/purchases/paywalls/components/properties/FontStyle;", "()V", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FontStyleDeserializer extends EnumDeserializerWithDefault<FontStyle> {
    public static final FontStyleDeserializer INSTANCE = new FontStyleDeserializer();

    private FontStyleDeserializer() {
        super(FontStyle.NORMAL, new Function1() { // from class: com.revenuecat.purchases.paywalls.components.properties.FontStyleDeserializer.1

            /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.properties.FontStyleDeserializer$1$WhenMappings */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[FontStyle.values().length];
                    try {
                        iArr[FontStyle.NORMAL.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[FontStyle.ITALIC.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(FontStyle value) {
                Intrinsics.checkNotNullParameter(value, "value");
                int i = WhenMappings.$EnumSwitchMapping$0[value.ordinal()];
                if (i == 1) {
                    return Constants.NORMAL;
                }
                if (i == 2) {
                    return "italic";
                }
                throw new NoWhenBranchMatchedException();
            }
        });
    }
}
