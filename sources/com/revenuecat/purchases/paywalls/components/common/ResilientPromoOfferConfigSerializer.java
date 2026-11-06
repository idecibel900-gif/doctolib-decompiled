package com.revenuecat.purchases.paywalls.components.common;

import com.revenuecat.purchases.utils.serializers.EmptyObjectToNullSerializer;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/ResilientPromoOfferConfigSerializer;", "Lcom/revenuecat/purchases/utils/serializers/EmptyObjectToNullSerializer;", "Lcom/revenuecat/purchases/paywalls/components/common/PromoOfferConfig;", "()V", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ResilientPromoOfferConfigSerializer extends EmptyObjectToNullSerializer<PromoOfferConfig> {
    public static final ResilientPromoOfferConfigSerializer INSTANCE = new ResilientPromoOfferConfigSerializer();

    private ResilientPromoOfferConfigSerializer() {
        super(PromoOfferConfig.INSTANCE.serializer(), false, 2, null);
    }
}
