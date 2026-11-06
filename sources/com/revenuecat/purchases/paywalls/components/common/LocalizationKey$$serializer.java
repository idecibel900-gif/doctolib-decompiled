package com.revenuecat.purchases.paywalls.components.common;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.InlineClassDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u001e\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002HÖ\u0001ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, d2 = {"com/revenuecat/purchases/paywalls/components/common/LocalizationKey.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationKey;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "deserialize-4Zn71J0", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/String;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "serialize-7v81vok", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/String;)V", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated
public final class LocalizationKey$$serializer implements GeneratedSerializer {
    public static final LocalizationKey$$serializer INSTANCE;
    private static final /* synthetic */ InlineClassDescriptor descriptor;

    static {
        LocalizationKey$$serializer localizationKey$$serializer = new LocalizationKey$$serializer();
        INSTANCE = localizationKey$$serializer;
        InlineClassDescriptor inlineClassDescriptor = new InlineClassDescriptor("com.revenuecat.purchases.paywalls.components.common.LocalizationKey", localizationKey$$serializer);
        inlineClassDescriptor.addElement("value", false);
        descriptor = inlineClassDescriptor;
    }

    private LocalizationKey$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public /* bridge */ /* synthetic */ Object deserialize(Decoder decoder) {
        return LocalizationKey.m3989boximpl(m3996deserialize4Zn71J0(decoder));
    }

    /* JADX INFO: renamed from: deserialize-4Zn71J0, reason: not valid java name */
    public String m3996deserialize4Zn71J0(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return LocalizationKey.m3990constructorimpl(decoder.decodeInline(getDescriptor()).decodeString());
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        m3997serialize7v81vok(encoder, ((LocalizationKey) obj).m3995unboximpl());
    }

    /* JADX INFO: renamed from: serialize-7v81vok, reason: not valid java name */
    public void m3997serialize7v81vok(Encoder encoder, String value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        Encoder encoderEncodeInline = encoder.encodeInline(getDescriptor());
        if (encoderEncodeInline == null) {
            return;
        }
        encoderEncodeInline.encodeString(value);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
