package com.revenuecat.purchases.utils.serializers;

import java.lang.Enum;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B%\b\u0016\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bB!\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u000bJ\u0015\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0002\u0010\u0016J\u001d\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001cR\u0010\u0010\u0004\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\n \u0012*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/revenuecat/purchases/utils/serializers/EnumDeserializerWithDefault;", "T", "", "Lkotlinx/serialization/KSerializer;", "defaultValue", "typeForValue", "Lkotlin/Function1;", "", "(Ljava/lang/Enum;Lkotlin/jvm/functions/Function1;)V", "valuesByType", "", "(Ljava/util/Map;Ljava/lang/Enum;)V", "Ljava/lang/Enum;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "enumName", "kotlin.jvm.PlatformType", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Enum;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Enum;)V", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class EnumDeserializerWithDefault<T extends Enum<T>> implements KSerializer {
    private final T defaultValue;
    private final SerialDescriptor descriptor;
    private final String enumName;
    private final Map<String, T> valuesByType;

    /* JADX WARN: Multi-variable type inference failed */
    public EnumDeserializerWithDefault(Map<String, ? extends T> valuesByType, T defaultValue) {
        Intrinsics.checkNotNullParameter(valuesByType, "valuesByType");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        this.valuesByType = valuesByType;
        this.defaultValue = defaultValue;
        String enumName = defaultValue.getClass().getSimpleName();
        this.enumName = enumName;
        Intrinsics.checkNotNullExpressionValue(enumName, "enumName");
        this.descriptor = SerialDescriptorsKt.PrimitiveSerialDescriptor(enumName, PrimitiveKind.STRING.INSTANCE);
    }

    public /* synthetic */ EnumDeserializerWithDefault(Enum r1, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, (i & 2) != 0 ? new Function1() { // from class: com.revenuecat.purchases.utils.serializers.EnumDeserializerWithDefault.1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(T value) {
                Intrinsics.checkNotNullParameter(value, "value");
                String lowerCase = value.name().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                return lowerCase;
            }
        } : function1);
    }

    public EnumDeserializerWithDefault(T defaultValue, Function1 typeForValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        Intrinsics.checkNotNullParameter(typeForValue, "typeForValue");
        Object[] enumConstants = defaultValue.getClass().getEnumConstants();
        Intrinsics.checkNotNullExpressionValue(enumConstants, "defaultValue::class.java.enumConstants");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(enumConstants.length), 16));
        for (Object obj : enumConstants) {
            linkedHashMap.put(typeForValue.invoke(obj), obj);
        }
        this(linkedHashMap, defaultValue);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public T deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        T t = this.valuesByType.get(decoder.decodeString());
        return t == null ? this.defaultValue : t;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, T value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        throw new NotImplementedError("Serialization is not implemented because it is not needed.");
    }
}
