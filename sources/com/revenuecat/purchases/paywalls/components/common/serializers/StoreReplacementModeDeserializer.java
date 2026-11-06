package com.revenuecat.purchases.paywalls.components.common.serializers;

import com.revenuecat.purchases.models.StoreReplacementMode;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b \u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/serializers/StoreReplacementModeDeserializer;", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/models/StoreReplacementMode;", "defaultValue", "typeForValue", "Lkotlin/Function1;", "", "(Lcom/revenuecat/purchases/models/StoreReplacementMode;Lkotlin/jvm/functions/Function1;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "valuesByType", "", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class StoreReplacementModeDeserializer implements KSerializer {
    private final StoreReplacementMode defaultValue;
    private final SerialDescriptor descriptor;
    private final Map<String, StoreReplacementMode> valuesByType;

    public StoreReplacementModeDeserializer(StoreReplacementMode defaultValue, Function1 typeForValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        Intrinsics.checkNotNullParameter(typeForValue, "typeForValue");
        this.defaultValue = defaultValue;
        List listListOf = CollectionsKt.listOf((Object[]) new StoreReplacementMode[]{StoreReplacementMode.WITHOUT_PRORATION, StoreReplacementMode.WITH_TIME_PRORATION, StoreReplacementMode.CHARGE_FULL_PRICE, StoreReplacementMode.CHARGE_PRORATED_PRICE, StoreReplacementMode.DEFERRED});
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listListOf, 10)), 16));
        for (Object obj : listListOf) {
            linkedHashMap.put(typeForValue.invoke(obj), obj);
        }
        this.valuesByType = linkedHashMap;
        this.descriptor = SerialDescriptorsKt.PrimitiveSerialDescriptor("StoreReplacementMode", PrimitiveKind.STRING.INSTANCE);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public StoreReplacementMode deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        StoreReplacementMode storeReplacementMode = this.valuesByType.get(decoder.decodeString());
        return storeReplacementMode == null ? this.defaultValue : storeReplacementMode;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, StoreReplacementMode value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        throw new NotImplementedError("Serialization is not implemented because it is not needed.");
    }
}
