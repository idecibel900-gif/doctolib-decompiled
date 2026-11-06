package com.revenuecat.purchases;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/revenuecat/purchases/TargetingContextSerializer;", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/PresentedOfferingContext$TargetingContext;", "()V", "REVISION_INDEX", "", "RULE_ID_INDEX", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TargetingContextSerializer implements KSerializer {
    private static final int REVISION_INDEX = 0;
    private static final int RULE_ID_INDEX = 1;
    public static final TargetingContextSerializer INSTANCE = new TargetingContextSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.buildClassSerialDescriptor("TargetingContext", new SerialDescriptor[0], new Function1() { // from class: com.revenuecat.purchases.TargetingContextSerializer$descriptor$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ClassSerialDescriptorBuilder) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
            Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
            ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "revision", BuiltinSerializersKt.serializer(IntCompanionObject.INSTANCE).getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "ruleId", BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE).getDescriptor(), null, false, 12, null);
        }
    });

    private TargetingContextSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PresentedOfferingContext.TargetingContext value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        TargetingContextSerializer targetingContextSerializer = INSTANCE;
        compositeEncoderBeginStructure.encodeIntElement(targetingContextSerializer.getDescriptor(), 0, value.getRevision());
        compositeEncoderBeginStructure.encodeStringElement(targetingContextSerializer.getDescriptor(), 1, value.getRuleId());
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PresentedOfferingContext.TargetingContext deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        String strDecodeStringElement = "";
        int iDecodeIntElement = 0;
        while (true) {
            TargetingContextSerializer targetingContextSerializer = INSTANCE;
            int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(targetingContextSerializer.getDescriptor());
            if (iDecodeElementIndex == -1) {
                PresentedOfferingContext.TargetingContext targetingContext = new PresentedOfferingContext.TargetingContext(iDecodeIntElement, strDecodeStringElement);
                compositeDecoderBeginStructure.endStructure(descriptor2);
                return targetingContext;
            }
            if (iDecodeElementIndex == 0) {
                iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(targetingContextSerializer.getDescriptor(), 0);
            } else if (iDecodeElementIndex == 1) {
                strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(targetingContextSerializer.getDescriptor(), 1);
            } else {
                throw new IllegalStateException(("Unexpected index: " + iDecodeElementIndex).toString());
            }
        }
    }
}
