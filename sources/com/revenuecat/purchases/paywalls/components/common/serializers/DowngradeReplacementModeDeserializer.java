package com.revenuecat.purchases.paywalls.components.common.serializers;

import com.revenuecat.purchases.models.StoreReplacementMode;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/serializers/DowngradeReplacementModeDeserializer;", "Lcom/revenuecat/purchases/paywalls/components/common/serializers/StoreReplacementModeDeserializer;", "()V", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DowngradeReplacementModeDeserializer extends StoreReplacementModeDeserializer {
    public static final DowngradeReplacementModeDeserializer INSTANCE = new DowngradeReplacementModeDeserializer();

    private DowngradeReplacementModeDeserializer() {
        super(StoreReplacementMode.DEFERRED, new Function1() { // from class: com.revenuecat.purchases.paywalls.components.common.serializers.DowngradeReplacementModeDeserializer.1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(StoreReplacementMode value) {
                Intrinsics.checkNotNullParameter(value, "value");
                String lowerCase = value.getName().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                return lowerCase;
            }
        });
    }
}
