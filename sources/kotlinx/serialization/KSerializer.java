package kotlinx.serialization;

import kotlinx.serialization.descriptors.SerialDescriptor;

/* JADX INFO: loaded from: classes5.dex */
public interface KSerializer extends SerializationStrategy, DeserializationStrategy {
    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    SerialDescriptor getDescriptor();
}
