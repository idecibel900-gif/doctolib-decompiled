package com.revenuecat.purchases.paywalls.components.properties;

import com.revenuecat.purchases.utils.serializers.EnumDeserializerWithDefault;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/BadgeStyleSerializer;", "Lcom/revenuecat/purchases/utils/serializers/EnumDeserializerWithDefault;", "Lcom/revenuecat/purchases/paywalls/components/properties/Badge$Style;", "()V", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BadgeStyleSerializer extends EnumDeserializerWithDefault<Badge.Style> {
    public static final BadgeStyleSerializer INSTANCE = new BadgeStyleSerializer();

    private BadgeStyleSerializer() {
        super(Badge.Style.Overlay, new Function1() { // from class: com.revenuecat.purchases.paywalls.components.properties.BadgeStyleSerializer.1

            /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.properties.BadgeStyleSerializer$1$WhenMappings */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Badge.Style.values().length];
                    try {
                        iArr[Badge.Style.Overlay.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Badge.Style.EdgeToEdge.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[Badge.Style.Nested.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Badge.Style style) {
                Intrinsics.checkNotNullParameter(style, "style");
                int i = WhenMappings.$EnumSwitchMapping$0[style.ordinal()];
                if (i == 1) {
                    return "overlay";
                }
                if (i == 2) {
                    return "edge_to_edge";
                }
                if (i == 3) {
                    return "nested";
                }
                throw new NoWhenBranchMatchedException();
            }
        });
    }
}
