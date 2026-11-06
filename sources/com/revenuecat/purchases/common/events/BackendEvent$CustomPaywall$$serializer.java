package com.revenuecat.purchases.common.events;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
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

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/common/events/BackendEvent.CustomPaywall.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/common/events/BackendEvent$CustomPaywall;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated
public final class BackendEvent$CustomPaywall$$serializer implements GeneratedSerializer {
    public static final BackendEvent$CustomPaywall$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        BackendEvent$CustomPaywall$$serializer backendEvent$CustomPaywall$$serializer = new BackendEvent$CustomPaywall$$serializer();
        INSTANCE = backendEvent$CustomPaywall$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("custom_paywall_event", backendEvent$CustomPaywall$$serializer, 8);
        pluginGeneratedSerialDescriptor.addElement(DiagnosticsEntry.ID_KEY, false);
        pluginGeneratedSerialDescriptor.addElement(DiagnosticsEntry.VERSION_KEY, false);
        pluginGeneratedSerialDescriptor.addElement("type", false);
        pluginGeneratedSerialDescriptor.addElement("app_user_id", false);
        pluginGeneratedSerialDescriptor.addElement(DiagnosticsEntry.APP_SESSION_ID_KEY, true);
        pluginGeneratedSerialDescriptor.addElement(DiagnosticsEntry.TIMESTAMP_KEY, false);
        pluginGeneratedSerialDescriptor.addElement("paywall_id", true);
        pluginGeneratedSerialDescriptor.addElement("offering_id", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private BackendEvent$CustomPaywall$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, IntSerializer.INSTANCE, stringSerializer, stringSerializer, BuiltinSerializersKt.getNullable(stringSerializer), LongSerializer.INSTANCE, BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public BackendEvent.CustomPaywall deserialize(Decoder decoder) {
        int i;
        String str;
        String str2;
        int i2;
        String str3;
        String str4;
        String str5;
        String str6;
        long j;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
            int iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 1);
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 2);
            String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 3);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, stringSerializer, null);
            long jDecodeLongElement = compositeDecoderBeginStructure.decodeLongElement(descriptor2, 5);
            String str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, stringSerializer, null);
            str3 = strDecodeStringElement;
            str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, stringSerializer, null);
            str2 = str8;
            i = 255;
            str5 = strDecodeStringElement3;
            str6 = str7;
            str4 = strDecodeStringElement2;
            i2 = iDecodeIntElement;
            j = jDecodeLongElement;
        } else {
            boolean z = true;
            int i3 = 0;
            String str9 = null;
            String strDecodeStringElement4 = null;
            String str10 = null;
            long jDecodeLongElement2 = 0;
            int iDecodeIntElement2 = 0;
            String str11 = null;
            String strDecodeStringElement5 = null;
            String strDecodeStringElement6 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        break;
                    case 0:
                        i3 |= 1;
                        strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
                        continue;
                    case 1:
                        i3 |= 2;
                        iDecodeIntElement2 = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 1);
                        continue;
                    case 2:
                        strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 2);
                        i3 |= 4;
                        continue;
                    case 3:
                        strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 3);
                        i3 |= 8;
                        break;
                    case 4:
                        str10 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, str10);
                        i3 |= 16;
                        break;
                    case 5:
                        jDecodeLongElement2 = compositeDecoderBeginStructure.decodeLongElement(descriptor2, 5);
                        i3 |= 32;
                        break;
                    case 6:
                        str11 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, StringSerializer.INSTANCE, str11);
                        i3 |= 64;
                        break;
                    case 7:
                        str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, StringSerializer.INSTANCE, str9);
                        i3 |= 128;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            i = i3;
            str = str9;
            str2 = str11;
            i2 = iDecodeIntElement2;
            str3 = strDecodeStringElement5;
            str4 = strDecodeStringElement6;
            str5 = strDecodeStringElement4;
            str6 = str10;
            j = jDecodeLongElement2;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new BackendEvent.CustomPaywall(i, str3, i2, str4, str5, str6, j, str2, str, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, BackendEvent.CustomPaywall value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        BackendEvent.CustomPaywall.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
