package com.revenuecat.purchases.paywalls.components.properties;

import com.revenuecat.purchases.utils.serializers.SealedDeserializerWithDefault;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/ShapeDeserializer;", "Lcom/revenuecat/purchases/utils/serializers/SealedDeserializerWithDefault;", "Lcom/revenuecat/purchases/paywalls/components/properties/Shape;", "()V", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ShapeDeserializer extends SealedDeserializerWithDefault<Shape> {
    public static final ShapeDeserializer INSTANCE = new ShapeDeserializer();

    private ShapeDeserializer() {
        super("Shape", MapsKt.mapOf(TuplesKt.to("rectangle", new Function0() { // from class: com.revenuecat.purchases.paywalls.components.properties.ShapeDeserializer.1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer invoke() {
                return Shape.Rectangle.INSTANCE.serializer();
            }
        }), TuplesKt.to("pill", new Function0() { // from class: com.revenuecat.purchases.paywalls.components.properties.ShapeDeserializer.2
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer invoke() {
                return Shape.Pill.INSTANCE.serializer();
            }
        })), new Function1() { // from class: com.revenuecat.purchases.paywalls.components.properties.ShapeDeserializer.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public final Shape invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new Shape.Rectangle((CornerRadiuses) null, 1, (DefaultConstructorMarker) (0 == true ? 1 : 0));
            }
        }, null, 8, null);
    }
}
