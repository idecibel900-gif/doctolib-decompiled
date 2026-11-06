package com.revenuecat.purchases.paywalls.components.properties;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import java.lang.annotation.Annotation;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u00022\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0003\u0006\u0007\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/Dimension;", "", "Companion", "Horizontal", "Vertical", "ZLayer", "Lcom/revenuecat/purchases/paywalls/components/properties/Dimension$Horizontal;", "Lcom/revenuecat/purchases/paywalls/components/properties/Dimension$Vertical;", "Lcom/revenuecat/purchases/paywalls/components/properties/Dimension$ZLayer;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface Dimension {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/Dimension$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/properties/Dimension;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final KSerializer serializer() {
            return new SealedClassSerializer("com.revenuecat.purchases.paywalls.components.properties.Dimension", Reflection.getOrCreateKotlinClass(Dimension.class), new KClass[]{Reflection.getOrCreateKotlinClass(Horizontal.class), Reflection.getOrCreateKotlinClass(Vertical.class), Reflection.getOrCreateKotlinClass(ZLayer.class)}, new KSerializer[]{Dimension$Horizontal$$serializer.INSTANCE, Dimension$Vertical$$serializer.INSTANCE, Dimension$ZLayer$$serializer.INSTANCE}, new Annotation[0]);
        }
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B-\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J&\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 HÁ\u0001¢\u0006\u0002\b!R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006$"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/Dimension$Vertical;", "Lcom/revenuecat/purchases/paywalls/components/properties/Dimension;", "seen1", "", "alignment", "Lcom/revenuecat/purchases/paywalls/components/properties/HorizontalAlignment;", "distribution", "Lcom/revenuecat/purchases/paywalls/components/properties/FlexDistribution;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/components/properties/HorizontalAlignment;Lcom/revenuecat/purchases/paywalls/components/properties/FlexDistribution;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/components/properties/HorizontalAlignment;Lcom/revenuecat/purchases/paywalls/components/properties/FlexDistribution;)V", "getAlignment", "()Lcom/revenuecat/purchases/paywalls/components/properties/HorizontalAlignment;", "getDistribution", "()Lcom/revenuecat/purchases/paywalls/components/properties/FlexDistribution;", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Vertical implements Dimension {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final HorizontalAlignment alignment;
        private final FlexDistribution distribution;

        public static /* synthetic */ Vertical copy$default(Vertical vertical, HorizontalAlignment horizontalAlignment, FlexDistribution flexDistribution, int i, Object obj) {
            if ((i & 1) != 0) {
                horizontalAlignment = vertical.alignment;
            }
            if ((i & 2) != 0) {
                flexDistribution = vertical.distribution;
            }
            return vertical.copy(horizontalAlignment, flexDistribution);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final HorizontalAlignment getAlignment() {
            return this.alignment;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final FlexDistribution getDistribution() {
            return this.distribution;
        }

        public final Vertical copy(HorizontalAlignment alignment, FlexDistribution distribution) {
            Intrinsics.checkNotNullParameter(alignment, "alignment");
            Intrinsics.checkNotNullParameter(distribution, "distribution");
            return new Vertical(alignment, distribution);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Vertical)) {
                return false;
            }
            Vertical vertical = (Vertical) other;
            return this.alignment == vertical.alignment && this.distribution == vertical.distribution;
        }

        public int hashCode() {
            return (this.alignment.hashCode() * 31) + this.distribution.hashCode();
        }

        public String toString() {
            return "Vertical(alignment=" + this.alignment + ", distribution=" + this.distribution + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/Dimension$Vertical$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/properties/Dimension$Vertical;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return Dimension$Vertical$$serializer.INSTANCE;
            }
        }

        @Deprecated
        public /* synthetic */ Vertical(int i, HorizontalAlignment horizontalAlignment, FlexDistribution flexDistribution, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i, 3, Dimension$Vertical$$serializer.INSTANCE.getDescriptor());
            }
            this.alignment = horizontalAlignment;
            this.distribution = flexDistribution;
        }

        public Vertical(HorizontalAlignment alignment, FlexDistribution distribution) {
            Intrinsics.checkNotNullParameter(alignment, "alignment");
            Intrinsics.checkNotNullParameter(distribution, "distribution");
            this.alignment = alignment;
            this.distribution = distribution;
        }

        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Vertical self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeSerializableElement(serialDesc, 0, HorizontalAlignmentDeserializer.INSTANCE, self.alignment);
            output.encodeSerializableElement(serialDesc, 1, FlexDistributionDeserializer.INSTANCE, self.distribution);
        }

        public final /* synthetic */ HorizontalAlignment getAlignment() {
            return this.alignment;
        }

        public final /* synthetic */ FlexDistribution getDistribution() {
            return this.distribution;
        }
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B-\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J&\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 HÁ\u0001¢\u0006\u0002\b!R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006$"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/Dimension$Horizontal;", "Lcom/revenuecat/purchases/paywalls/components/properties/Dimension;", "seen1", "", "alignment", "Lcom/revenuecat/purchases/paywalls/components/properties/VerticalAlignment;", "distribution", "Lcom/revenuecat/purchases/paywalls/components/properties/FlexDistribution;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/components/properties/VerticalAlignment;Lcom/revenuecat/purchases/paywalls/components/properties/FlexDistribution;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/components/properties/VerticalAlignment;Lcom/revenuecat/purchases/paywalls/components/properties/FlexDistribution;)V", "getAlignment", "()Lcom/revenuecat/purchases/paywalls/components/properties/VerticalAlignment;", "getDistribution", "()Lcom/revenuecat/purchases/paywalls/components/properties/FlexDistribution;", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Horizontal implements Dimension {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final VerticalAlignment alignment;
        private final FlexDistribution distribution;

        public static /* synthetic */ Horizontal copy$default(Horizontal horizontal, VerticalAlignment verticalAlignment, FlexDistribution flexDistribution, int i, Object obj) {
            if ((i & 1) != 0) {
                verticalAlignment = horizontal.alignment;
            }
            if ((i & 2) != 0) {
                flexDistribution = horizontal.distribution;
            }
            return horizontal.copy(verticalAlignment, flexDistribution);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final VerticalAlignment getAlignment() {
            return this.alignment;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final FlexDistribution getDistribution() {
            return this.distribution;
        }

        public final Horizontal copy(VerticalAlignment alignment, FlexDistribution distribution) {
            Intrinsics.checkNotNullParameter(alignment, "alignment");
            Intrinsics.checkNotNullParameter(distribution, "distribution");
            return new Horizontal(alignment, distribution);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Horizontal)) {
                return false;
            }
            Horizontal horizontal = (Horizontal) other;
            return this.alignment == horizontal.alignment && this.distribution == horizontal.distribution;
        }

        public int hashCode() {
            return (this.alignment.hashCode() * 31) + this.distribution.hashCode();
        }

        public String toString() {
            return "Horizontal(alignment=" + this.alignment + ", distribution=" + this.distribution + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/Dimension$Horizontal$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/properties/Dimension$Horizontal;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return Dimension$Horizontal$$serializer.INSTANCE;
            }
        }

        @Deprecated
        public /* synthetic */ Horizontal(int i, VerticalAlignment verticalAlignment, FlexDistribution flexDistribution, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i, 3, Dimension$Horizontal$$serializer.INSTANCE.getDescriptor());
            }
            this.alignment = verticalAlignment;
            this.distribution = flexDistribution;
        }

        public Horizontal(VerticalAlignment alignment, FlexDistribution distribution) {
            Intrinsics.checkNotNullParameter(alignment, "alignment");
            Intrinsics.checkNotNullParameter(distribution, "distribution");
            this.alignment = alignment;
            this.distribution = distribution;
        }

        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Horizontal self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeSerializableElement(serialDesc, 0, VerticalAlignmentDeserializer.INSTANCE, self.alignment);
            output.encodeSerializableElement(serialDesc, 1, FlexDistributionDeserializer.INSTANCE, self.distribution);
        }

        public final /* synthetic */ VerticalAlignment getAlignment() {
            return this.alignment;
        }

        public final /* synthetic */ FlexDistribution getDistribution() {
            return this.distribution;
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB#\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J&\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bHÁ\u0001¢\u0006\u0002\b\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/Dimension$ZLayer;", "Lcom/revenuecat/purchases/paywalls/components/properties/Dimension;", "seen1", "", "alignment", "Lcom/revenuecat/purchases/paywalls/components/properties/TwoDimensionalAlignment;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/components/properties/TwoDimensionalAlignment;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/components/properties/TwoDimensionalAlignment;)V", "getAlignment", "()Lcom/revenuecat/purchases/paywalls/components/properties/TwoDimensionalAlignment;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class ZLayer implements Dimension {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final TwoDimensionalAlignment alignment;

        public static /* synthetic */ ZLayer copy$default(ZLayer zLayer, TwoDimensionalAlignment twoDimensionalAlignment, int i, Object obj) {
            if ((i & 1) != 0) {
                twoDimensionalAlignment = zLayer.alignment;
            }
            return zLayer.copy(twoDimensionalAlignment);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final TwoDimensionalAlignment getAlignment() {
            return this.alignment;
        }

        public final ZLayer copy(TwoDimensionalAlignment alignment) {
            Intrinsics.checkNotNullParameter(alignment, "alignment");
            return new ZLayer(alignment);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ZLayer) && this.alignment == ((ZLayer) other).alignment;
        }

        public int hashCode() {
            return this.alignment.hashCode();
        }

        public String toString() {
            return "ZLayer(alignment=" + this.alignment + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/Dimension$ZLayer$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/properties/Dimension$ZLayer;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return Dimension$ZLayer$$serializer.INSTANCE;
            }
        }

        @Deprecated
        public /* synthetic */ ZLayer(int i, TwoDimensionalAlignment twoDimensionalAlignment, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, Dimension$ZLayer$$serializer.INSTANCE.getDescriptor());
            }
            this.alignment = twoDimensionalAlignment;
        }

        public ZLayer(TwoDimensionalAlignment alignment) {
            Intrinsics.checkNotNullParameter(alignment, "alignment");
            this.alignment = alignment;
        }

        public final /* synthetic */ TwoDimensionalAlignment getAlignment() {
            return this.alignment;
        }
    }
}
