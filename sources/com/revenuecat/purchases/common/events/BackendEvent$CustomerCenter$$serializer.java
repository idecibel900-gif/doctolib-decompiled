package com.revenuecat.purchases.common.events;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.customercenter.events.CustomerCenterDisplayMode;
import com.revenuecat.purchases.customercenter.events.CustomerCenterEventType;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/common/events/BackendEvent.CustomerCenter.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated
public final class BackendEvent$CustomerCenter$$serializer implements GeneratedSerializer {
    public static final BackendEvent$CustomerCenter$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        BackendEvent$CustomerCenter$$serializer backendEvent$CustomerCenter$$serializer = new BackendEvent$CustomerCenter$$serializer();
        INSTANCE = backendEvent$CustomerCenter$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("customer_center", backendEvent$CustomerCenter$$serializer, 12);
        pluginGeneratedSerialDescriptor.addElement(DiagnosticsEntry.ID_KEY, false);
        pluginGeneratedSerialDescriptor.addElement("revision_id", false);
        pluginGeneratedSerialDescriptor.addElement("type", false);
        pluginGeneratedSerialDescriptor.addElement("app_user_id", false);
        pluginGeneratedSerialDescriptor.addElement(DiagnosticsEntry.APP_SESSION_ID_KEY, false);
        pluginGeneratedSerialDescriptor.addElement(DiagnosticsEntry.TIMESTAMP_KEY, false);
        pluginGeneratedSerialDescriptor.addElement("dark_mode", false);
        pluginGeneratedSerialDescriptor.addElement("locale", false);
        pluginGeneratedSerialDescriptor.addElement("display_mode", false);
        pluginGeneratedSerialDescriptor.addElement("path", false);
        pluginGeneratedSerialDescriptor.addElement("url", false);
        pluginGeneratedSerialDescriptor.addElement("survey_option_id", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private BackendEvent$CustomerCenter$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] childSerializers() {
        KSerializer[] kSerializerArr = BackendEvent.CustomerCenter.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, IntSerializer.INSTANCE, kSerializerArr[2], stringSerializer, stringSerializer, LongSerializer.INSTANCE, BooleanSerializer.INSTANCE, stringSerializer, kSerializerArr[8], BuiltinSerializersKt.getNullable(kSerializerArr[9]), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public BackendEvent.CustomerCenter deserialize(Decoder decoder) {
        CustomerCenterEventType customerCenterEventType;
        String str;
        String str2;
        int i;
        String str3;
        CustomerCenterConfigData.HelpPath.PathType pathType;
        CustomerCenterDisplayMode customerCenterDisplayMode;
        String str4;
        String str5;
        String str6;
        boolean z;
        int i2;
        long j;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = BackendEvent.CustomerCenter.$childSerializers;
        int i3 = 10;
        int i4 = 7;
        int i5 = 6;
        String strDecodeStringElement = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
            int iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 1);
            CustomerCenterEventType customerCenterEventType2 = (CustomerCenterEventType) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, kSerializerArr[2], null);
            String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 3);
            String strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 4);
            long jDecodeLongElement = compositeDecoderBeginStructure.decodeLongElement(descriptor2, 5);
            boolean zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 6);
            String strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 7);
            CustomerCenterDisplayMode customerCenterDisplayMode2 = (CustomerCenterDisplayMode) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 8, kSerializerArr[8], null);
            CustomerCenterConfigData.HelpPath.PathType pathType2 = (CustomerCenterConfigData.HelpPath.PathType) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, kSerializerArr[9], null);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, stringSerializer, null);
            pathType = pathType2;
            str = strDecodeStringElement2;
            str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, stringSerializer, null);
            str3 = str7;
            str6 = strDecodeStringElement5;
            z = zDecodeBooleanElement;
            customerCenterDisplayMode = customerCenterDisplayMode2;
            str4 = strDecodeStringElement3;
            str5 = strDecodeStringElement4;
            i = 4095;
            customerCenterEventType = customerCenterEventType2;
            i2 = iDecodeIntElement;
            j = jDecodeLongElement;
        } else {
            CustomerCenterEventType customerCenterEventType3 = null;
            String str8 = null;
            String strDecodeStringElement6 = null;
            boolean z2 = true;
            int i6 = 0;
            boolean zDecodeBooleanElement2 = false;
            int iDecodeIntElement2 = 0;
            long jDecodeLongElement2 = 0;
            String str9 = null;
            CustomerCenterConfigData.HelpPath.PathType pathType3 = null;
            CustomerCenterDisplayMode customerCenterDisplayMode3 = null;
            String strDecodeStringElement7 = null;
            String strDecodeStringElement8 = null;
            while (z2) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z2 = false;
                        break;
                    case 0:
                        i6 |= 1;
                        i5 = i5;
                        strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
                        i3 = 10;
                        i4 = 7;
                        break;
                    case 1:
                        iDecodeIntElement2 = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 1);
                        i6 |= 2;
                        i5 = i5;
                        i3 = 10;
                        i4 = 7;
                        break;
                    case 2:
                        customerCenterEventType3 = (CustomerCenterEventType) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, kSerializerArr[2], customerCenterEventType3);
                        i6 |= 4;
                        i5 = i5;
                        i3 = 10;
                        i4 = 7;
                        break;
                    case 3:
                        strDecodeStringElement7 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 3);
                        i6 |= 8;
                        i5 = i5;
                        i3 = 10;
                        break;
                    case 4:
                        strDecodeStringElement8 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 4);
                        i6 |= 16;
                        i5 = i5;
                        i3 = 10;
                        break;
                    case 5:
                        jDecodeLongElement2 = compositeDecoderBeginStructure.decodeLongElement(descriptor2, 5);
                        i6 |= 32;
                        i5 = i5;
                        i3 = 10;
                        break;
                    case 6:
                        int i7 = i5;
                        zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, i7);
                        i6 |= 64;
                        i5 = i7;
                        break;
                    case 7:
                        strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, i4);
                        i6 |= 128;
                        i5 = 6;
                        break;
                    case 8:
                        customerCenterDisplayMode3 = (CustomerCenterDisplayMode) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 8, kSerializerArr[8], customerCenterDisplayMode3);
                        i6 |= IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER;
                        i5 = 6;
                        break;
                    case 9:
                        pathType3 = (CustomerCenterConfigData.HelpPath.PathType) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, kSerializerArr[9], pathType3);
                        i6 |= IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING;
                        i5 = 6;
                        break;
                    case 10:
                        str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i3, StringSerializer.INSTANCE, str9);
                        i6 |= IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET;
                        i5 = 6;
                        break;
                    case BaseVideoCapturer.RGBA /* 11 */:
                        str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, StringSerializer.INSTANCE, str8);
                        i6 |= 2048;
                        i5 = 6;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            customerCenterEventType = customerCenterEventType3;
            str = strDecodeStringElement;
            str2 = str8;
            i = i6;
            str3 = str9;
            pathType = pathType3;
            customerCenterDisplayMode = customerCenterDisplayMode3;
            str4 = strDecodeStringElement7;
            str5 = strDecodeStringElement8;
            str6 = strDecodeStringElement6;
            z = zDecodeBooleanElement2;
            i2 = iDecodeIntElement2;
            j = jDecodeLongElement2;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new BackendEvent.CustomerCenter(i, str, i2, customerCenterEventType, str4, str5, j, z, str6, customerCenterDisplayMode, pathType, str3, str2, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, BackendEvent.CustomerCenter value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        BackendEvent.CustomerCenter.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
