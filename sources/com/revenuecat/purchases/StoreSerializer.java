package com.revenuecat.purchases;

import com.revenuecat.purchases.utils.serializers.EnumDeserializerWithDefault;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/revenuecat/purchases/StoreSerializer;", "Lcom/revenuecat/purchases/utils/serializers/EnumDeserializerWithDefault;", "Lcom/revenuecat/purchases/Store;", "()V", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class StoreSerializer extends EnumDeserializerWithDefault<Store> {
    public static final StoreSerializer INSTANCE = new StoreSerializer();

    private StoreSerializer() {
        super(Store.UNKNOWN_STORE, new Function1() { // from class: com.revenuecat.purchases.StoreSerializer.1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Store value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return value.getStringValue$purchases_defaultsBc8Release();
            }
        });
    }
}
