package com.revenuecat.purchases.common.workflows;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/common/workflows/WorkflowTrigger.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/common/workflows/WorkflowTrigger;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated
public final class WorkflowTrigger$$serializer implements GeneratedSerializer {
    public static final WorkflowTrigger$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        WorkflowTrigger$$serializer workflowTrigger$$serializer = new WorkflowTrigger$$serializer();
        INSTANCE = workflowTrigger$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.common.workflows.WorkflowTrigger", workflowTrigger$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("name", false);
        pluginGeneratedSerialDescriptor.addElement("type", false);
        pluginGeneratedSerialDescriptor.addElement("action_id", false);
        pluginGeneratedSerialDescriptor.addElement("component_id", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private WorkflowTrigger$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, WorkflowTriggerTypeDeserializer.INSTANCE, stringSerializer, stringSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public WorkflowTrigger deserialize(Decoder decoder) {
        int i;
        String str;
        WorkflowTriggerType workflowTriggerType;
        String str2;
        String strDecodeStringElement;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        String strDecodeStringElement2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
            WorkflowTriggerType workflowTriggerType2 = (WorkflowTriggerType) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, WorkflowTriggerTypeDeserializer.INSTANCE, null);
            String strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 2);
            str = strDecodeStringElement3;
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 3);
            str2 = strDecodeStringElement4;
            workflowTriggerType = workflowTriggerType2;
            i = 15;
        } else {
            boolean z = true;
            int i2 = 0;
            WorkflowTriggerType workflowTriggerType3 = null;
            String strDecodeStringElement5 = null;
            String strDecodeStringElement6 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    workflowTriggerType3 = (WorkflowTriggerType) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, WorkflowTriggerTypeDeserializer.INSTANCE, workflowTriggerType3);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 2);
                    i2 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 3);
                    i2 |= 8;
                }
            }
            i = i2;
            str = strDecodeStringElement2;
            workflowTriggerType = workflowTriggerType3;
            str2 = strDecodeStringElement5;
            strDecodeStringElement = strDecodeStringElement6;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new WorkflowTrigger(i, str, workflowTriggerType, str2, strDecodeStringElement, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, WorkflowTrigger value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        WorkflowTrigger.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
