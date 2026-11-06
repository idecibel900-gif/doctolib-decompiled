package com.revenuecat.purchases.paywalls.components.properties;

import com.revenuecat.purchases.utils.serializers.EnumDeserializerWithDefault;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/TwoDimensionalAlignmentDeserializer;", "Lcom/revenuecat/purchases/utils/serializers/EnumDeserializerWithDefault;", "Lcom/revenuecat/purchases/paywalls/components/properties/TwoDimensionalAlignment;", "()V", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TwoDimensionalAlignmentDeserializer extends EnumDeserializerWithDefault<TwoDimensionalAlignment> {
    public static final TwoDimensionalAlignmentDeserializer INSTANCE = new TwoDimensionalAlignmentDeserializer();

    /* JADX WARN: Multi-variable type inference failed */
    private TwoDimensionalAlignmentDeserializer() {
        super(TwoDimensionalAlignment.TOP, null, 2, 0 == true ? 1 : 0);
    }
}
