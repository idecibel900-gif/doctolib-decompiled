package com.revenuecat.purchases.paywalls.components.common;

import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.utils.MapExtensionsKt;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0005J\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016R \u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/VariableLocalizationKeyMapSerializer;", "Lkotlinx/serialization/KSerializer;", "", "Lcom/revenuecat/purchases/paywalls/components/common/VariableLocalizationKey;", "", "()V", "delegate", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VariableLocalizationKeyMapSerializer implements KSerializer {
    public static final VariableLocalizationKeyMapSerializer INSTANCE = new VariableLocalizationKeyMapSerializer();
    private static final KSerializer delegate;
    private static final SerialDescriptor descriptor;

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Map<VariableLocalizationKey, String> value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
    }

    private VariableLocalizationKeyMapSerializer() {
    }

    static {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        KSerializer kSerializerMapSerializer = BuiltinSerializersKt.MapSerializer(BuiltinSerializersKt.serializer(stringCompanionObject), BuiltinSerializersKt.serializer(stringCompanionObject));
        delegate = kSerializerMapSerializer;
        descriptor = kSerializerMapSerializer.getDescriptor();
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Map<VariableLocalizationKey, String> deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return MapExtensionsKt.mapNotNullKeys((Map) decoder.decodeSerializableValue(delegate), new Function1() { // from class: com.revenuecat.purchases.paywalls.components.common.VariableLocalizationKeyMapSerializer.deserialize.1
            @Override // kotlin.jvm.functions.Function1
            public final VariableLocalizationKey invoke(Map.Entry<String, String> entry) {
                Intrinsics.checkNotNullParameter(entry, "<name for destructuring parameter 0>");
                try {
                    String upperCase = entry.getKey().toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                    return VariableLocalizationKey.valueOf(upperCase);
                } catch (IllegalArgumentException unused) {
                    return null;
                }
            }
        });
    }
}
