package com.revenuecat.purchases.utils.serializers;

import java.util.Map;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003BO\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012 \u0010\b\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00030\u00070\u0006\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R.\u0010\b\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00030\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0019R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001aR\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0018R\u001a\u0010\u001c\u001a\u00020\u001b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/revenuecat/purchases/utils/serializers/SealedDeserializerWithDefault;", "", "T", "Lkotlinx/serialization/KSerializer;", "", "serialName", "", "Lkotlin/Function0;", "serializerByType", "Lkotlin/Function1;", "defaultValue", "typeDiscriminator", "<init>", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Ljava/lang/String;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "Ljava/lang/String;", "Ljava/util/Map;", "Lkotlin/jvm/functions/Function1;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class SealedDeserializerWithDefault<T> implements KSerializer {
    private final Function1 defaultValue;
    private final SerialDescriptor descriptor;
    private final String serialName;
    private final Map<String, Function0> serializerByType;
    private final String typeDiscriminator;

    /* JADX WARN: Multi-variable type inference failed */
    public SealedDeserializerWithDefault(String serialName, Map<String, ? extends Function0> serializerByType, Function1 defaultValue, String typeDiscriminator) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(serializerByType, "serializerByType");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        Intrinsics.checkNotNullParameter(typeDiscriminator, "typeDiscriminator");
        this.serialName = serialName;
        this.serializerByType = serializerByType;
        this.defaultValue = defaultValue;
        this.typeDiscriminator = typeDiscriminator;
        this.descriptor = SerialDescriptorsKt.buildClassSerialDescriptor(serialName, new SerialDescriptor[0], new Function1(this) { // from class: com.revenuecat.purchases.utils.serializers.SealedDeserializerWithDefault$descriptor$1
            final /* synthetic */ SealedDeserializerWithDefault<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ClassSerialDescriptorBuilder) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
                Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
                ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, ((SealedDeserializerWithDefault) this.this$0).typeDiscriminator, BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE).getDescriptor(), null, false, 12, null);
            }
        });
    }

    public /* synthetic */ SealedDeserializerWithDefault(String str, Map map, Function1 function1, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, map, function1, (i & 8) != 0 ? "type" : str2);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public T deserialize(Decoder decoder) {
        Function0 function0;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonDecoder jsonDecoder = decoder instanceof JsonDecoder ? (JsonDecoder) decoder : null;
        if (jsonDecoder == null) {
            throw new SerializationException("Can only deserialize " + this.serialName + " from JSON, got: " + Reflection.getOrCreateKotlinClass(decoder.getClass()));
        }
        JsonElement jsonElementDecodeJsonElement = jsonDecoder.decodeJsonElement();
        JsonObject jsonObject = jsonElementDecodeJsonElement instanceof JsonObject ? (JsonObject) jsonElementDecodeJsonElement : null;
        if (jsonObject == null) {
            return (T) this.defaultValue.invoke("null");
        }
        Object obj = jsonObject.get((Object) this.typeDiscriminator);
        JsonPrimitive jsonPrimitive = obj instanceof JsonPrimitive ? (JsonPrimitive) obj : null;
        String content = jsonPrimitive != null ? jsonPrimitive.getContent() : null;
        if (content == null || (function0 = this.serializerByType.get(content)) == null) {
            return (T) this.defaultValue.invoke(content != null ? content : "null");
        }
        try {
            return (T) jsonDecoder.getJson().decodeFromJsonElement((DeserializationStrategy) function0.invoke(), jsonObject);
        } catch (Exception unused) {
            return (T) this.defaultValue.invoke(content);
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, T value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        throw new NotImplementedError("Serialization is not implemented because it is not needed.");
    }
}
