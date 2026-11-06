package com.revenuecat.purchases.utils.serializers;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0003B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0017\u0010\f\u001a\u0004\u0018\u00018\u00002\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0015R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/revenuecat/purchases/utils/serializers/EmptyObjectToNullSerializer;", "T", "", "Lkotlinx/serialization/KSerializer;", "delegate", "resilient", "", "(Lkotlinx/serialization/KSerializer;Z)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class EmptyObjectToNullSerializer<T> implements KSerializer {
    private final KSerializer delegate;
    private final SerialDescriptor descriptor;
    private final boolean resilient;

    public EmptyObjectToNullSerializer(KSerializer delegate, boolean z) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
        this.resilient = z;
        this.descriptor = delegate.getDescriptor();
    }

    public /* synthetic */ EmptyObjectToNullSerializer(KSerializer kSerializer, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kSerializer, (i & 2) != 0 ? true : z);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public T deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonDecoder jsonDecoder = decoder instanceof JsonDecoder ? (JsonDecoder) decoder : null;
        if (jsonDecoder == null) {
            return (T) this.delegate.deserialize(decoder);
        }
        JsonElement jsonElementDecodeJsonElement = jsonDecoder.decodeJsonElement();
        if (!(jsonElementDecodeJsonElement instanceof JsonObject) || ((JsonObject) jsonElementDecodeJsonElement).isEmpty()) {
            return null;
        }
        if (this.resilient) {
            try {
                return (T) jsonDecoder.getJson().decodeFromJsonElement(this.delegate, jsonElementDecodeJsonElement);
            } catch (SerializationException unused) {
                return null;
            }
        }
        return (T) jsonDecoder.getJson().decodeFromJsonElement(this.delegate, jsonElementDecodeJsonElement);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, T value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        if (value != null) {
            this.delegate.serialize(encoder, value);
        }
    }
}
