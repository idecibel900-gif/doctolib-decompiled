package com.revenuecat.purchases.paywalls.components.common;

import com.revenuecat.purchases.utils.serializers.SealedDeserializerWithDefault;
import com.vonage.webrtc.MediaStreamTrack;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/BackgroundDeserializer;", "Lcom/revenuecat/purchases/utils/serializers/SealedDeserializerWithDefault;", "Lcom/revenuecat/purchases/paywalls/components/common/Background;", "()V", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BackgroundDeserializer extends SealedDeserializerWithDefault<Background> {
    public static final BackgroundDeserializer INSTANCE = new BackgroundDeserializer();

    private BackgroundDeserializer() {
        super("Background", MapsKt.mapOf(TuplesKt.to("color", new Function0() { // from class: com.revenuecat.purchases.paywalls.components.common.BackgroundDeserializer.1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer invoke() {
                return Background.Color.INSTANCE.serializer();
            }
        }), TuplesKt.to("image", new Function0() { // from class: com.revenuecat.purchases.paywalls.components.common.BackgroundDeserializer.2
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer invoke() {
                return Background.Image.INSTANCE.serializer();
            }
        }), TuplesKt.to(MediaStreamTrack.VIDEO_TRACK_KIND, new Function0() { // from class: com.revenuecat.purchases.paywalls.components.common.BackgroundDeserializer.3
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer invoke() {
                return Background.Video.INSTANCE.serializer();
            }
        })), new Function1() { // from class: com.revenuecat.purchases.paywalls.components.common.BackgroundDeserializer.4
            @Override // kotlin.jvm.functions.Function1
            public final Background invoke(String type) {
                Intrinsics.checkNotNullParameter(type, "type");
                return new Background.Unknown(type);
            }
        }, null, 8, null);
    }
}
