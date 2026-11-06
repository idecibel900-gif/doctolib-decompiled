package com.revenuecat.purchases.paywalls.components;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.facebook.react.modules.appstate.AppStateModule;
import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.BackgroundDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Badge;
import com.revenuecat.purchases.paywalls.components.properties.Badge$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.Border$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shadow$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.ShapeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import java.util.List;
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
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.http2.Settings;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/components/StackComponent.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/components/StackComponent;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated
public final class StackComponent$$serializer implements GeneratedSerializer {
    public static final StackComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        StackComponent$$serializer stackComponent$$serializer = new StackComponent$$serializer();
        INSTANCE = stackComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("stack", stackComponent$$serializer, 16);
        pluginGeneratedSerialDescriptor.addElement("components", false);
        pluginGeneratedSerialDescriptor.addElement("visible", true);
        pluginGeneratedSerialDescriptor.addElement("dimension", true);
        pluginGeneratedSerialDescriptor.addElement("size", true);
        pluginGeneratedSerialDescriptor.addElement("spacing", true);
        pluginGeneratedSerialDescriptor.addElement("background_color", true);
        pluginGeneratedSerialDescriptor.addElement(AppStateModule.APP_STATE_BACKGROUND, true);
        pluginGeneratedSerialDescriptor.addElement("padding", true);
        pluginGeneratedSerialDescriptor.addElement("margin", true);
        pluginGeneratedSerialDescriptor.addElement("shape", true);
        pluginGeneratedSerialDescriptor.addElement("border", true);
        pluginGeneratedSerialDescriptor.addElement("shadow", true);
        pluginGeneratedSerialDescriptor.addElement("badge", true);
        pluginGeneratedSerialDescriptor.addElement("overflow", true);
        pluginGeneratedSerialDescriptor.addElement("overrides", true);
        pluginGeneratedSerialDescriptor.addElement("name", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private StackComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] childSerializers() {
        KSerializer[] kSerializerArr = StackComponent.$childSerializers;
        KSerializer kSerializer = kSerializerArr[0];
        KSerializer nullable = BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE);
        KSerializer kSerializer2 = kSerializerArr[2];
        KSerializer nullable2 = BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE);
        KSerializer nullable3 = BuiltinSerializersKt.getNullable(ColorScheme$$serializer.INSTANCE);
        KSerializer nullable4 = BuiltinSerializersKt.getNullable(BackgroundDeserializer.INSTANCE);
        KSerializer nullable5 = BuiltinSerializersKt.getNullable(ShapeDeserializer.INSTANCE);
        KSerializer nullable6 = BuiltinSerializersKt.getNullable(Border$$serializer.INSTANCE);
        KSerializer nullable7 = BuiltinSerializersKt.getNullable(Shadow$$serializer.INSTANCE);
        KSerializer nullable8 = BuiltinSerializersKt.getNullable(Badge$$serializer.INSTANCE);
        KSerializer nullable9 = BuiltinSerializersKt.getNullable(StackOverflowDeserializer.INSTANCE);
        KSerializer kSerializer3 = kSerializerArr[14];
        KSerializer nullable10 = BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE);
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new KSerializer[]{kSerializer, nullable, kSerializer2, Size$$serializer.INSTANCE, nullable2, nullable3, nullable4, padding$$serializer, padding$$serializer, nullable5, nullable6, nullable7, nullable8, nullable9, kSerializer3, nullable10};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public StackComponent deserialize(Decoder decoder) {
        int i;
        List list;
        Float f;
        String str;
        Badge badge;
        Shadow shadow;
        Shape shape;
        Padding padding;
        Padding padding2;
        ColorScheme colorScheme;
        Border border;
        Background background;
        Boolean bool;
        Dimension dimension;
        Size size;
        List list2;
        StackComponent.Overflow overflow;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = StackComponent.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            list = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, kSerializerArr[0], null);
            Boolean bool2 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, BooleanSerializer.INSTANCE, null);
            Dimension dimension2 = (Dimension) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, kSerializerArr[2], null);
            Size size2 = (Size) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, Size$$serializer.INSTANCE, null);
            Float f2 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, FloatSerializer.INSTANCE, null);
            ColorScheme colorScheme2 = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, ColorScheme$$serializer.INSTANCE, null);
            Background background2 = (Background) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, BackgroundDeserializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            Padding padding3 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 7, padding$$serializer, null);
            Padding padding4 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 8, padding$$serializer, null);
            Shape shape2 = (Shape) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, ShapeDeserializer.INSTANCE, null);
            Border border2 = (Border) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, Border$$serializer.INSTANCE, null);
            Shadow shadow2 = (Shadow) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, Shadow$$serializer.INSTANCE, null);
            Badge badge2 = (Badge) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, Badge$$serializer.INSTANCE, null);
            StackComponent.Overflow overflow2 = (StackComponent.Overflow) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, StackOverflowDeserializer.INSTANCE, null);
            List list3 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 14, kSerializerArr[14], null);
            String str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 15, StringSerializer.INSTANCE, null);
            i = Settings.DEFAULT_INITIAL_WINDOW_SIZE;
            str = str2;
            dimension = dimension2;
            bool = bool2;
            size = size2;
            border = border2;
            shape = shape2;
            padding2 = padding3;
            background = background2;
            colorScheme = colorScheme2;
            f = f2;
            padding = padding4;
            list2 = list3;
            overflow = overflow2;
            badge = badge2;
            shadow = shadow2;
        } else {
            int i2 = 2;
            int i3 = 1;
            int i4 = 0;
            StackComponent.Overflow overflow3 = null;
            List list4 = null;
            Float f3 = null;
            Size size3 = null;
            Badge badge3 = null;
            Shadow shadow3 = null;
            Shape shape3 = null;
            Padding padding5 = null;
            Padding padding6 = null;
            ColorScheme colorScheme3 = null;
            Border border3 = null;
            Background background3 = null;
            List list5 = null;
            Boolean bool3 = null;
            Dimension dimension3 = null;
            i = 0;
            String str3 = null;
            while (i3 != 0) {
                Size size4 = size3;
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        i3 = i4;
                        size3 = size4;
                        list4 = list4;
                        i2 = 2;
                        i4 = i3;
                        overflow3 = overflow3;
                        break;
                    case 0:
                        List list6 = list4;
                        int i5 = i4;
                        list5 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i5, kSerializerArr[i4], list5);
                        i |= 1;
                        f3 = f3;
                        bool3 = bool3;
                        size3 = size4;
                        list4 = list6;
                        i2 = 2;
                        i4 = i5;
                        overflow3 = overflow3;
                        break;
                    case 1:
                        bool3 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, BooleanSerializer.INSTANCE, bool3);
                        i |= 2;
                        f3 = f3;
                        dimension3 = dimension3;
                        size3 = size4;
                        list4 = list4;
                        overflow3 = overflow3;
                        i2 = 2;
                        break;
                    case 2:
                        List list7 = list4;
                        int i6 = i2;
                        dimension3 = (Dimension) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i6, kSerializerArr[i2], dimension3);
                        i |= 4;
                        f3 = f3;
                        size3 = size4;
                        list4 = list7;
                        i2 = i6;
                        overflow3 = overflow3;
                        break;
                    case 3:
                        i |= 8;
                        f3 = f3;
                        list4 = list4;
                        size3 = (Size) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, Size$$serializer.INSTANCE, size4);
                        overflow3 = overflow3;
                        break;
                    case 4:
                        f3 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, FloatSerializer.INSTANCE, f3);
                        i |= 16;
                        overflow3 = overflow3;
                        size3 = size4;
                        break;
                    case 5:
                        colorScheme3 = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, ColorScheme$$serializer.INSTANCE, colorScheme3);
                        i |= 32;
                        size3 = size4;
                        f3 = f3;
                        break;
                    case 6:
                        background3 = (Background) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, BackgroundDeserializer.INSTANCE, background3);
                        i |= 64;
                        size3 = size4;
                        f3 = f3;
                        break;
                    case 7:
                        padding6 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 7, Padding$$serializer.INSTANCE, padding6);
                        i |= 128;
                        size3 = size4;
                        f3 = f3;
                        break;
                    case 8:
                        padding5 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 8, Padding$$serializer.INSTANCE, padding5);
                        i |= IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER;
                        size3 = size4;
                        f3 = f3;
                        break;
                    case 9:
                        shape3 = (Shape) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, ShapeDeserializer.INSTANCE, shape3);
                        i |= IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING;
                        size3 = size4;
                        f3 = f3;
                        break;
                    case 10:
                        border3 = (Border) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, Border$$serializer.INSTANCE, border3);
                        i |= IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET;
                        size3 = size4;
                        f3 = f3;
                        break;
                    case BaseVideoCapturer.RGBA /* 11 */:
                        shadow3 = (Shadow) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, Shadow$$serializer.INSTANCE, shadow3);
                        i |= 2048;
                        size3 = size4;
                        f3 = f3;
                        break;
                    case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                        badge3 = (Badge) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, Badge$$serializer.INSTANCE, badge3);
                        i |= 4096;
                        size3 = size4;
                        f3 = f3;
                        break;
                    case 13:
                        overflow3 = (StackComponent.Overflow) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, StackOverflowDeserializer.INSTANCE, overflow3);
                        i |= 8192;
                        size3 = size4;
                        f3 = f3;
                        break;
                    case 14:
                        list4 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 14, kSerializerArr[14], list4);
                        i |= Http2.INITIAL_MAX_FRAME_SIZE;
                        size3 = size4;
                        f3 = f3;
                        break;
                    case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                        str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 15, StringSerializer.INSTANCE, str3);
                        i |= 32768;
                        size3 = size4;
                        f3 = f3;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            List list8 = list4;
            list = list5;
            f = f3;
            str = str3;
            badge = badge3;
            shadow = shadow3;
            shape = shape3;
            padding = padding5;
            padding2 = padding6;
            colorScheme = colorScheme3;
            border = border3;
            background = background3;
            bool = bool3;
            dimension = dimension3;
            size = size3;
            list2 = list8;
            overflow = overflow3;
        }
        List list9 = list;
        int i7 = i;
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new StackComponent(i7, list9, bool, dimension, size, f, colorScheme, background, padding2, padding, shape, border, shadow, badge, overflow, list2, str, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, StackComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        StackComponent.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
