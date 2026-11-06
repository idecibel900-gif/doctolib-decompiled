package com.revenuecat.purchases;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/revenuecat/purchases/PresentedOfferingContextSerializer;", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "()V", "OFFERING_IDENTIFIER_INDEX", "", "PLACEMENT_IDENTIFIER_INDEX", "TARGETING_CONTEXT_INDEX", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "nullableStringSerializer", "", "nullableTargetingContextSerializer", "Lcom/revenuecat/purchases/PresentedOfferingContext$TargetingContext;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PresentedOfferingContextSerializer implements KSerializer {
    private static final int OFFERING_IDENTIFIER_INDEX = 0;
    private static final int PLACEMENT_IDENTIFIER_INDEX = 1;
    private static final int TARGETING_CONTEXT_INDEX = 2;
    public static final PresentedOfferingContextSerializer INSTANCE = new PresentedOfferingContextSerializer();
    private static final KSerializer nullableStringSerializer = BuiltinSerializersKt.getNullable(BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE));
    private static final KSerializer nullableTargetingContextSerializer = BuiltinSerializersKt.getNullable(TargetingContextSerializer.INSTANCE);
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.buildClassSerialDescriptor("PresentedOfferingContext", new SerialDescriptor[0], new Function1() { // from class: com.revenuecat.purchases.PresentedOfferingContextSerializer$descriptor$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ClassSerialDescriptorBuilder) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
            Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
            ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "offeringIdentifier", BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE).getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "placementIdentifier", PresentedOfferingContextSerializer.nullableStringSerializer.getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "targetingContext", PresentedOfferingContextSerializer.nullableTargetingContextSerializer.getDescriptor(), null, false, 12, null);
        }
    });

    private PresentedOfferingContextSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PresentedOfferingContext value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        PresentedOfferingContextSerializer presentedOfferingContextSerializer = INSTANCE;
        compositeEncoderBeginStructure.encodeStringElement(presentedOfferingContextSerializer.getDescriptor(), 0, value.getOfferingIdentifier());
        compositeEncoderBeginStructure.encodeSerializableElement(presentedOfferingContextSerializer.getDescriptor(), 1, nullableStringSerializer, value.getPlacementIdentifier());
        compositeEncoderBeginStructure.encodeSerializableElement(presentedOfferingContextSerializer.getDescriptor(), 2, nullableTargetingContextSerializer, value.getTargetingContext());
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PresentedOfferingContext deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        String strDecodeStringElement = "";
        String str = null;
        PresentedOfferingContext.TargetingContext targetingContext = null;
        while (true) {
            PresentedOfferingContextSerializer presentedOfferingContextSerializer = INSTANCE;
            int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(presentedOfferingContextSerializer.getDescriptor());
            if (iDecodeElementIndex == -1) {
                PresentedOfferingContext presentedOfferingContext = new PresentedOfferingContext(strDecodeStringElement, str, targetingContext);
                compositeDecoderBeginStructure.endStructure(descriptor2);
                return presentedOfferingContext;
            }
            if (iDecodeElementIndex == 0) {
                strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(presentedOfferingContextSerializer.getDescriptor(), 0);
            } else if (iDecodeElementIndex == 1) {
                str = (String) CompositeDecoder.DefaultImpls.decodeSerializableElement$default(compositeDecoderBeginStructure, presentedOfferingContextSerializer.getDescriptor(), 1, nullableStringSerializer, null, 8, null);
            } else if (iDecodeElementIndex == 2) {
                targetingContext = (PresentedOfferingContext.TargetingContext) CompositeDecoder.DefaultImpls.decodeSerializableElement$default(compositeDecoderBeginStructure, presentedOfferingContextSerializer.getDescriptor(), 2, nullableTargetingContextSerializer, null, 8, null);
            } else {
                throw new IllegalStateException(("Unexpected index: " + iDecodeElementIndex).toString());
            }
        }
    }
}
