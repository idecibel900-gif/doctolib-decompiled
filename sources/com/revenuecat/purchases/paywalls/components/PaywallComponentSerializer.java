package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallLegacyComponentInteraction;
import com.vonage.webrtc.MediaStreamTrack;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PaywallComponentSerializer;", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PaywallComponentSerializer implements KSerializer {
    private final SerialDescriptor descriptor = SerialDescriptorsKt.buildClassSerialDescriptor("PaywallComponent", new SerialDescriptor[0], new Function1() { // from class: com.revenuecat.purchases.paywalls.components.PaywallComponentSerializer$descriptor$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ClassSerialDescriptorBuilder) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
            Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
            ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "type", BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE).getDescriptor(), null, false, 12, null);
        }
    });

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PaywallComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // kotlinx.serialization.DeserializationStrategy
    public PaywallComponent deserialize(Decoder decoder) {
        String string;
        JsonPrimitive jsonPrimitive;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonDecoder jsonDecoder = decoder instanceof JsonDecoder ? (JsonDecoder) decoder : null;
        if (jsonDecoder == null) {
            throw new SerializationException("Can only deserialize PaywallComponent from JSON, got: " + Reflection.getOrCreateKotlinClass(decoder.getClass()));
        }
        JsonObject jsonObject = JsonElementKt.getJsonObject(jsonDecoder.decodeJsonElement());
        JsonElement jsonElement = (JsonElement) jsonObject.get((Object) "type");
        String content = (jsonElement == null || (jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement)) == null) ? null : jsonPrimitive.getContent();
        if (content != null) {
            switch (content.hashCode()) {
                case -2076650431:
                    if (content.equals("timeline")) {
                        Json json = jsonDecoder.getJson();
                        String string2 = jsonObject.toString();
                        json.getSerializersModule();
                        return (PaywallComponent) json.decodeFromString(TimelineComponent.INSTANCE.serializer(), string2);
                    }
                    break;
                case -1896978765:
                    if (content.equals("tab_control")) {
                        Json json2 = jsonDecoder.getJson();
                        String string3 = jsonObject.toString();
                        json2.getSerializersModule();
                        return (PaywallComponent) json2.decodeFromString(TabControlComponent.INSTANCE.serializer(), string3);
                    }
                    break;
                case -1822017359:
                    if (content.equals("sticky_footer")) {
                        Json json3 = jsonDecoder.getJson();
                        String string4 = jsonObject.toString();
                        json3.getSerializersModule();
                        return (PaywallComponent) json3.decodeFromString(StickyFooterComponent.INSTANCE.serializer(), string4);
                    }
                    break;
                case -1391809488:
                    if (content.equals(PaywallLegacyComponentInteraction.PURCHASE_BUTTON_NAME)) {
                        Json json4 = jsonDecoder.getJson();
                        String string5 = jsonObject.toString();
                        json4.getSerializersModule();
                        return (PaywallComponent) json4.decodeFromString(PurchaseButtonComponent.INSTANCE.serializer(), string5);
                    }
                    break;
                case -1377687758:
                    if (content.equals("button")) {
                        Json json5 = jsonDecoder.getJson();
                        String string6 = jsonObject.toString();
                        json5.getSerializersModule();
                        return (PaywallComponent) json5.decodeFromString(ButtonComponent.INSTANCE.serializer(), string6);
                    }
                    break;
                case -1221270899:
                    if (content.equals("header")) {
                        Json json6 = jsonDecoder.getJson();
                        String string7 = jsonObject.toString();
                        json6.getSerializersModule();
                        return (PaywallComponent) json6.decodeFromString(HeaderComponent.INSTANCE.serializer(), string7);
                    }
                    break;
                case -807062458:
                    if (content.equals("package")) {
                        Json json7 = jsonDecoder.getJson();
                        String string8 = jsonObject.toString();
                        json7.getSerializersModule();
                        return (PaywallComponent) json7.decodeFromString(PackageComponent.INSTANCE.serializer(), string8);
                    }
                    break;
                case -364374390:
                    if (content.equals("fallback_header")) {
                        return FallbackHeaderComponent.INSTANCE;
                    }
                    break;
                case 2908512:
                    if (content.equals("carousel")) {
                        Json json8 = jsonDecoder.getJson();
                        String string9 = jsonObject.toString();
                        json8.getSerializersModule();
                        return (PaywallComponent) json8.decodeFromString(CarouselComponent.INSTANCE.serializer(), string9);
                    }
                    break;
                case 3226745:
                    if (content.equals("icon")) {
                        Json json9 = jsonDecoder.getJson();
                        String string10 = jsonObject.toString();
                        json9.getSerializersModule();
                        return (PaywallComponent) json9.decodeFromString(IconComponent.INSTANCE.serializer(), string10);
                    }
                    break;
                case 3552126:
                    if (content.equals("tabs")) {
                        Json json10 = jsonDecoder.getJson();
                        String string11 = jsonObject.toString();
                        json10.getSerializersModule();
                        return (PaywallComponent) json10.decodeFromString(TabsComponent.INSTANCE.serializer(), string11);
                    }
                    break;
                case 3556653:
                    if (content.equals("text")) {
                        Json json11 = jsonDecoder.getJson();
                        String string12 = jsonObject.toString();
                        json11.getSerializersModule();
                        return (PaywallComponent) json11.decodeFromString(TextComponent.INSTANCE.serializer(), string12);
                    }
                    break;
                case 100313435:
                    if (content.equals("image")) {
                        Json json12 = jsonDecoder.getJson();
                        String string13 = jsonObject.toString();
                        json12.getSerializersModule();
                        return (PaywallComponent) json12.decodeFromString(ImageComponent.INSTANCE.serializer(), string13);
                    }
                    break;
                case 109757064:
                    if (content.equals("stack")) {
                        Json json13 = jsonDecoder.getJson();
                        String string14 = jsonObject.toString();
                        json13.getSerializersModule();
                        return (PaywallComponent) json13.decodeFromString(StackComponent.INSTANCE.serializer(), string14);
                    }
                    break;
                case 112202875:
                    if (content.equals(MediaStreamTrack.VIDEO_TRACK_KIND)) {
                        Json json14 = jsonDecoder.getJson();
                        String string15 = jsonObject.toString();
                        json14.getSerializersModule();
                        return (PaywallComponent) json14.decodeFromString(VideoComponent.INSTANCE.serializer(), string15);
                    }
                    break;
                case 318201406:
                    if (content.equals("tab_control_button")) {
                        Json json15 = jsonDecoder.getJson();
                        String string16 = jsonObject.toString();
                        json15.getSerializersModule();
                        return (PaywallComponent) json15.decodeFromString(TabControlButtonComponent.INSTANCE.serializer(), string16);
                    }
                    break;
                case 827585120:
                    if (content.equals("tab_control_toggle")) {
                        Json json16 = jsonDecoder.getJson();
                        String string17 = jsonObject.toString();
                        json16.getSerializersModule();
                        return (PaywallComponent) json16.decodeFromString(TabControlToggleComponent.INSTANCE.serializer(), string17);
                    }
                    break;
                case 1352226353:
                    if (content.equals("countdown")) {
                        Json json17 = jsonDecoder.getJson();
                        String string18 = jsonObject.toString();
                        json17.getSerializersModule();
                        return (PaywallComponent) json17.decodeFromString(CountdownComponent.INSTANCE.serializer(), string18);
                    }
                    break;
            }
        }
        JsonElement jsonElement2 = (JsonElement) jsonObject.get((Object) "fallback");
        if (jsonElement2 != null) {
            JsonObject jsonObject2 = jsonElement2 instanceof JsonObject ? (JsonObject) jsonElement2 : null;
            if (jsonObject2 != null && (string = jsonObject2.toString()) != null) {
                Json json18 = jsonDecoder.getJson();
                json18.getSerializersModule();
                PaywallComponent paywallComponent = (PaywallComponent) json18.decodeFromString(PaywallComponent.INSTANCE.serializer(), string);
                if (paywallComponent != null) {
                    return paywallComponent;
                }
            }
        }
        throw new SerializationException("No fallback provided for unknown type: " + content);
    }
}
