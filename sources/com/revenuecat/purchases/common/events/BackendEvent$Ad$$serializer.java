package com.revenuecat.purchases.common.events;

import com.amazon.a.a.o.b;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.common.verification.SigningManager;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/common/events/BackendEvent.Ad.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/common/events/BackendEvent$Ad;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated
public final class BackendEvent$Ad$$serializer implements GeneratedSerializer {
    public static final BackendEvent$Ad$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        BackendEvent$Ad$$serializer backendEvent$Ad$$serializer = new BackendEvent$Ad$$serializer();
        INSTANCE = backendEvent$Ad$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("ad", backendEvent$Ad$$serializer, 16);
        pluginGeneratedSerialDescriptor.addElement(DiagnosticsEntry.ID_KEY, false);
        pluginGeneratedSerialDescriptor.addElement(DiagnosticsEntry.VERSION_KEY, false);
        pluginGeneratedSerialDescriptor.addElement("type", false);
        pluginGeneratedSerialDescriptor.addElement("timestamp_ms", false);
        pluginGeneratedSerialDescriptor.addElement("network_name", true);
        pluginGeneratedSerialDescriptor.addElement("mediator_name", false);
        pluginGeneratedSerialDescriptor.addElement("ad_format", true);
        pluginGeneratedSerialDescriptor.addElement("placement", false);
        pluginGeneratedSerialDescriptor.addElement("ad_unit_id", false);
        pluginGeneratedSerialDescriptor.addElement("impression_id", false);
        pluginGeneratedSerialDescriptor.addElement("app_user_id", false);
        pluginGeneratedSerialDescriptor.addElement(DiagnosticsEntry.APP_SESSION_ID_KEY, false);
        pluginGeneratedSerialDescriptor.addElement("revenue_micros", true);
        pluginGeneratedSerialDescriptor.addElement(b.a, true);
        pluginGeneratedSerialDescriptor.addElement("precision", true);
        pluginGeneratedSerialDescriptor.addElement("mediator_error_code", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private BackendEvent$Ad$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        LongSerializer longSerializer = LongSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, intSerializer, stringSerializer, longSerializer, BuiltinSerializersKt.getNullable(stringSerializer), stringSerializer, BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), stringSerializer, BuiltinSerializersKt.getNullable(stringSerializer), stringSerializer, stringSerializer, BuiltinSerializersKt.getNullable(longSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(intSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public BackendEvent.Ad deserialize(Decoder decoder) {
        int i;
        String str;
        String str2;
        String str3;
        int i2;
        Integer num;
        String str4;
        String str5;
        String str6;
        Long l;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        long j;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        int i3 = 11;
        int i4 = 10;
        char c = '\t';
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
            int iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 1);
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 2);
            long jDecodeLongElement = compositeDecoderBeginStructure.decodeLongElement(descriptor2, 3);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str13 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, stringSerializer, null);
            String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 5);
            String str14 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, stringSerializer, null);
            String str15 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, stringSerializer, null);
            String strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 8);
            String str16 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, stringSerializer, null);
            String strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 10);
            String strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 11);
            Long l2 = (Long) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, LongSerializer.INSTANCE, null);
            String str17 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, stringSerializer, null);
            String str18 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 14, stringSerializer, null);
            num = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 15, IntSerializer.INSTANCE, null);
            str8 = strDecodeStringElement2;
            i = iDecodeIntElement;
            i2 = 65535;
            str12 = strDecodeStringElement6;
            str11 = strDecodeStringElement5;
            str6 = str16;
            str = str15;
            str2 = str14;
            str9 = strDecodeStringElement3;
            str3 = str13;
            str10 = strDecodeStringElement4;
            str5 = str17;
            str4 = str18;
            l = l2;
            j = jDecodeLongElement;
            str7 = strDecodeStringElement;
        } else {
            boolean z = true;
            int iDecodeIntElement2 = 0;
            String str19 = null;
            String str20 = null;
            Integer num2 = null;
            String str21 = null;
            String str22 = null;
            String str23 = null;
            Long l3 = null;
            String strDecodeStringElement7 = null;
            String strDecodeStringElement8 = null;
            String strDecodeStringElement9 = null;
            String strDecodeStringElement10 = null;
            long jDecodeLongElement2 = 0;
            int i5 = 0;
            String str24 = null;
            String strDecodeStringElement11 = null;
            String strDecodeStringElement12 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        i3 = 11;
                        c = '\t';
                        break;
                    case 0:
                        strDecodeStringElement11 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
                        i5 |= 1;
                        i3 = 11;
                        i4 = 10;
                        c = '\t';
                        break;
                    case 1:
                        i5 |= 2;
                        iDecodeIntElement2 = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 1);
                        i3 = 11;
                        i4 = 10;
                        c = '\t';
                        break;
                    case 2:
                        strDecodeStringElement12 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 2);
                        i5 |= 4;
                        i3 = 11;
                        i4 = 10;
                        c = '\t';
                        break;
                    case 3:
                        jDecodeLongElement2 = compositeDecoderBeginStructure.decodeLongElement(descriptor2, 3);
                        i5 |= 8;
                        i3 = 11;
                        i4 = 10;
                        c = '\t';
                        break;
                    case 4:
                        str24 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, str24);
                        i5 |= 16;
                        i3 = 11;
                        i4 = 10;
                        c = '\t';
                        break;
                    case 5:
                        strDecodeStringElement7 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 5);
                        i5 |= 32;
                        i3 = 11;
                        i4 = 10;
                        c = '\t';
                        break;
                    case 6:
                        str20 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, StringSerializer.INSTANCE, str20);
                        i5 |= 64;
                        i3 = 11;
                        i4 = 10;
                        c = '\t';
                        break;
                    case 7:
                        str19 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, StringSerializer.INSTANCE, str19);
                        i5 |= 128;
                        i3 = 11;
                        i4 = 10;
                        c = '\t';
                        break;
                    case 8:
                        strDecodeStringElement8 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 8);
                        i5 |= IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER;
                        c = c;
                        i3 = 11;
                        break;
                    case 9:
                        str23 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, StringSerializer.INSTANCE, str23);
                        i5 |= IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING;
                        c = '\t';
                        i3 = 11;
                        break;
                    case 10:
                        strDecodeStringElement9 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, i4);
                        i5 |= IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET;
                        c = '\t';
                        break;
                    case BaseVideoCapturer.RGBA /* 11 */:
                        strDecodeStringElement10 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, i3);
                        i5 |= 2048;
                        c = '\t';
                        break;
                    case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                        l3 = (Long) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, LongSerializer.INSTANCE, l3);
                        i5 |= 4096;
                        c = '\t';
                        break;
                    case 13:
                        str22 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, StringSerializer.INSTANCE, str22);
                        i5 |= 8192;
                        c = '\t';
                        break;
                    case 14:
                        str21 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 14, StringSerializer.INSTANCE, str21);
                        i5 |= Http2.INITIAL_MAX_FRAME_SIZE;
                        c = '\t';
                        break;
                    case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                        num2 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 15, IntSerializer.INSTANCE, num2);
                        i5 |= 32768;
                        c = '\t';
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            i = iDecodeIntElement2;
            str = str19;
            str2 = str20;
            str3 = str24;
            i2 = i5;
            num = num2;
            str4 = str21;
            str5 = str22;
            str6 = str23;
            l = l3;
            str7 = strDecodeStringElement11;
            str8 = strDecodeStringElement12;
            str9 = strDecodeStringElement7;
            str10 = strDecodeStringElement8;
            str11 = strDecodeStringElement9;
            str12 = strDecodeStringElement10;
            j = jDecodeLongElement2;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new BackendEvent.Ad(i2, str7, i, str8, j, str3, str9, str2, str, str10, str6, str11, str12, l, str5, str4, num, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, BackendEvent.Ad value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        BackendEvent.Ad.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
