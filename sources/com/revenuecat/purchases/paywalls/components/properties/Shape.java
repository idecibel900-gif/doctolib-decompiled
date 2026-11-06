package com.revenuecat.purchases.paywalls.components.properties;

import com.revenuecat.purchases.InternalRevenueCatAPI;
import java.lang.annotation.Annotation;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ObjectSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u00062\u00020\u0001:\u0003\u0006\u0007\bR\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0002\t\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/Shape;", "", "cornerRadiuses", "Lcom/revenuecat/purchases/paywalls/components/properties/CornerRadiuses;", "getCornerRadiuses", "()Lcom/revenuecat/purchases/paywalls/components/properties/CornerRadiuses;", "Companion", "Pill", "Rectangle", "Lcom/revenuecat/purchases/paywalls/components/properties/Shape$Pill;", "Lcom/revenuecat/purchases/paywalls/components/properties/Shape$Rectangle;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface Shape {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/Shape$Companion;", "", "()V", "pillCornerRadiuses", "Lcom/revenuecat/purchases/paywalls/components/properties/CornerRadiuses$Percentage;", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/properties/Shape;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final CornerRadiuses.Percentage pillCornerRadiuses = new CornerRadiuses.Percentage(50);

        private Companion() {
        }

        public final KSerializer serializer() {
            return ShapeDeserializer.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0002\u0014\u0015B#\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u0011\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ&\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012HÁ\u0001¢\u0006\u0002\b\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/Shape$Rectangle;", "Lcom/revenuecat/purchases/paywalls/components/properties/Shape;", "seen1", "", "corners", "Lcom/revenuecat/purchases/paywalls/components/properties/CornerRadiuses;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/components/properties/CornerRadiuses;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/components/properties/CornerRadiuses;)V", "getCorners", "()Lcom/revenuecat/purchases/paywalls/components/properties/CornerRadiuses;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Rectangle implements Shape {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final CornerRadiuses corners;

        /* JADX WARN: Multi-variable type inference failed */
        public Rectangle() {
            this((CornerRadiuses) null, 1, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Rectangle) && Intrinsics.areEqual(this.corners, ((Rectangle) obj).corners);
        }

        public int hashCode() {
            CornerRadiuses cornerRadiuses = this.corners;
            if (cornerRadiuses == null) {
                return 0;
            }
            return cornerRadiuses.hashCode();
        }

        public String toString() {
            return "Rectangle(corners=" + this.corners + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/Shape$Rectangle$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/properties/Shape$Rectangle;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return Shape$Rectangle$$serializer.INSTANCE;
            }
        }

        @Deprecated
        public /* synthetic */ Rectangle(int i, CornerRadiuses cornerRadiuses, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.corners = null;
            } else {
                this.corners = cornerRadiuses;
            }
        }

        public Rectangle(CornerRadiuses cornerRadiuses) {
            this.corners = cornerRadiuses;
        }

        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Rectangle self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (!output.shouldEncodeElementDefault(serialDesc, 0) && self.corners == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 0, CornerRadiusesSerializer.INSTANCE, self.corners);
        }

        public /* synthetic */ Rectangle(CornerRadiuses cornerRadiuses, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : cornerRadiuses);
        }

        public final /* synthetic */ CornerRadiuses getCorners() {
            return this.corners;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004HÆ\u0001¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/Shape$Pill;", "Lcom/revenuecat/purchases/paywalls/components/properties/Shape;", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Pill implements Shape {
        public static final Pill INSTANCE = new Pill();
        private static final /* synthetic */ Lazy $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.revenuecat.purchases.paywalls.components.properties.Shape.Pill.1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer invoke() {
                return new ObjectSerializer("com.revenuecat.purchases.paywalls.components.properties.Shape.Pill", Pill.INSTANCE, new Annotation[0]);
            }
        });

        private Pill() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public final KSerializer serializer() {
            return get$cachedSerializer();
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static CornerRadiuses getCornerRadiuses(Shape shape) {
            return Shape.super.getCornerRadiuses();
        }
    }

    default CornerRadiuses getCornerRadiuses() {
        if (!(this instanceof Rectangle)) {
            return Companion.pillCornerRadiuses;
        }
        CornerRadiuses corners = ((Rectangle) this).getCorners();
        return corners == null ? CornerRadiuses.Dp.INSTANCE.getZero() : corners;
    }
}
