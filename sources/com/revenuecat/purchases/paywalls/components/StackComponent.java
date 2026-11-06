package com.revenuecat.purchases.paywalls.components;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.facebook.react.modules.appstate.AppStateModule;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.BackgroundDeserializer;
import com.revenuecat.purchases.paywalls.components.common.ComponentOverride;
import com.revenuecat.purchases.paywalls.components.properties.Badge;
import com.revenuecat.purchases.paywalls.components.properties.Badge$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.Border$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import com.revenuecat.purchases.paywalls.components.properties.Dimension$Horizontal$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Dimension$Vertical$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Dimension$ZLayer$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.FlexDistribution;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shadow$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.ShapeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 S2\u00020\u0001:\u0003RSTBÍ\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\u0014\u0010\u001f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 \u0018\u00010\u0005\u0012\b\u0010\"\u001a\u0004\u0018\u00010#\u0012\b\u0010$\u001a\u0004\u0018\u00010%¢\u0006\u0002\u0010&BÉ\u0001\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\u0014\b\u0002\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 0\u0005\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\u0002\u0010'J&\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u00002\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020PHÁ\u0001¢\u0006\u0002\bQR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u0010\u0014\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0013\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u001d\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 0\u0005¢\u0006\b\n\u0000\u001a\u0004\b<\u00103R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b=\u00107R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010F\u001a\u0004\bD\u0010ER\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010I\u001a\u0004\bG\u0010H¨\u0006U"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/StackComponent;", "Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;", "seen1", "", "components", "", "visible", "", "dimension", "Lcom/revenuecat/purchases/paywalls/components/properties/Dimension;", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "spacing", "", "backgroundColor", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", AppStateModule.APP_STATE_BACKGROUND, "Lcom/revenuecat/purchases/paywalls/components/common/Background;", "padding", "Lcom/revenuecat/purchases/paywalls/components/properties/Padding;", "margin", "shape", "Lcom/revenuecat/purchases/paywalls/components/properties/Shape;", "border", "Lcom/revenuecat/purchases/paywalls/components/properties/Border;", "shadow", "Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;", "badge", "Lcom/revenuecat/purchases/paywalls/components/properties/Badge;", "overflow", "Lcom/revenuecat/purchases/paywalls/components/StackComponent$Overflow;", "overrides", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride;", "Lcom/revenuecat/purchases/paywalls/components/PartialStackComponent;", "name", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/lang/Boolean;Lcom/revenuecat/purchases/paywalls/components/properties/Dimension;Lcom/revenuecat/purchases/paywalls/components/properties/Size;Ljava/lang/Float;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Lcom/revenuecat/purchases/paywalls/components/common/Background;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Shape;Lcom/revenuecat/purchases/paywalls/components/properties/Border;Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;Lcom/revenuecat/purchases/paywalls/components/properties/Badge;Lcom/revenuecat/purchases/paywalls/components/StackComponent$Overflow;Ljava/util/List;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/List;Ljava/lang/Boolean;Lcom/revenuecat/purchases/paywalls/components/properties/Dimension;Lcom/revenuecat/purchases/paywalls/components/properties/Size;Ljava/lang/Float;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Lcom/revenuecat/purchases/paywalls/components/common/Background;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Shape;Lcom/revenuecat/purchases/paywalls/components/properties/Border;Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;Lcom/revenuecat/purchases/paywalls/components/properties/Badge;Lcom/revenuecat/purchases/paywalls/components/StackComponent$Overflow;Ljava/util/List;Ljava/lang/String;)V", "getBackground", "()Lcom/revenuecat/purchases/paywalls/components/common/Background;", "getBackgroundColor$annotations", "()V", "getBackgroundColor", "()Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "getBadge", "()Lcom/revenuecat/purchases/paywalls/components/properties/Badge;", "getBorder", "()Lcom/revenuecat/purchases/paywalls/components/properties/Border;", "getComponents", "()Ljava/util/List;", "getDimension", "()Lcom/revenuecat/purchases/paywalls/components/properties/Dimension;", "getMargin", "()Lcom/revenuecat/purchases/paywalls/components/properties/Padding;", "getName", "()Ljava/lang/String;", "getOverflow", "()Lcom/revenuecat/purchases/paywalls/components/StackComponent$Overflow;", "getOverrides", "getPadding", "getShadow", "()Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;", "getShape", "()Lcom/revenuecat/purchases/paywalls/components/properties/Shape;", "getSize", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getSpacing", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getVisible", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "Overflow", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class StackComponent implements PaywallComponent {
    private final Background background;
    private final ColorScheme backgroundColor;
    private final Badge badge;
    private final Border border;
    private final List<PaywallComponent> components;
    private final Dimension dimension;
    private final Padding margin;
    private final String name;
    private final Overflow overflow;
    private final List<ComponentOverride<PartialStackComponent>> overrides;
    private final Padding padding;
    private final Shadow shadow;
    private final Shape shape;
    private final Size size;
    private final Float spacing;
    private final Boolean visible;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer[] $childSerializers = {new ArrayListSerializer(new PaywallComponentSerializer()), null, new SealedClassSerializer("com.revenuecat.purchases.paywalls.components.properties.Dimension", Reflection.getOrCreateKotlinClass(Dimension.class), new KClass[]{Reflection.getOrCreateKotlinClass(Dimension.Horizontal.class), Reflection.getOrCreateKotlinClass(Dimension.Vertical.class), Reflection.getOrCreateKotlinClass(Dimension.ZLayer.class)}, new KSerializer[]{Dimension$Horizontal$$serializer.INSTANCE, Dimension$Vertical$$serializer.INSTANCE, Dimension$ZLayer$$serializer.INSTANCE}, new Annotation[0]), null, null, null, null, null, null, null, null, null, null, null, new ArrayListSerializer(ComponentOverride.INSTANCE.serializer(PartialStackComponent$$serializer.INSTANCE)), null};

    public static /* synthetic */ void getBackgroundColor$annotations() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StackComponent)) {
            return false;
        }
        StackComponent stackComponent = (StackComponent) obj;
        return Intrinsics.areEqual(this.components, stackComponent.components) && Intrinsics.areEqual(this.visible, stackComponent.visible) && Intrinsics.areEqual(this.dimension, stackComponent.dimension) && Intrinsics.areEqual(this.size, stackComponent.size) && Intrinsics.areEqual(this.spacing, stackComponent.spacing) && Intrinsics.areEqual(this.backgroundColor, stackComponent.backgroundColor) && Intrinsics.areEqual(this.background, stackComponent.background) && Intrinsics.areEqual(this.padding, stackComponent.padding) && Intrinsics.areEqual(this.margin, stackComponent.margin) && Intrinsics.areEqual(this.shape, stackComponent.shape) && Intrinsics.areEqual(this.border, stackComponent.border) && Intrinsics.areEqual(this.shadow, stackComponent.shadow) && Intrinsics.areEqual(this.badge, stackComponent.badge) && this.overflow == stackComponent.overflow && Intrinsics.areEqual(this.overrides, stackComponent.overrides) && Intrinsics.areEqual(this.name, stackComponent.name);
    }

    public int hashCode() {
        int iHashCode = this.components.hashCode() * 31;
        Boolean bool = this.visible;
        int iHashCode2 = (((((iHashCode + (bool == null ? 0 : bool.hashCode())) * 31) + this.dimension.hashCode()) * 31) + this.size.hashCode()) * 31;
        Float f = this.spacing;
        int iHashCode3 = (iHashCode2 + (f == null ? 0 : f.hashCode())) * 31;
        ColorScheme colorScheme = this.backgroundColor;
        int iHashCode4 = (iHashCode3 + (colorScheme == null ? 0 : colorScheme.hashCode())) * 31;
        Background background = this.background;
        int iHashCode5 = (((((iHashCode4 + (background == null ? 0 : background.hashCode())) * 31) + this.padding.hashCode()) * 31) + this.margin.hashCode()) * 31;
        Shape shape = this.shape;
        int iHashCode6 = (iHashCode5 + (shape == null ? 0 : shape.hashCode())) * 31;
        Border border = this.border;
        int iHashCode7 = (iHashCode6 + (border == null ? 0 : border.hashCode())) * 31;
        Shadow shadow = this.shadow;
        int iHashCode8 = (iHashCode7 + (shadow == null ? 0 : shadow.hashCode())) * 31;
        Badge badge = this.badge;
        int iHashCode9 = (iHashCode8 + (badge == null ? 0 : badge.hashCode())) * 31;
        Overflow overflow = this.overflow;
        int iHashCode10 = (((iHashCode9 + (overflow == null ? 0 : overflow.hashCode())) * 31) + this.overrides.hashCode()) * 31;
        String str = this.name;
        return iHashCode10 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "StackComponent(components=" + this.components + ", visible=" + this.visible + ", dimension=" + this.dimension + ", size=" + this.size + ", spacing=" + this.spacing + ", backgroundColor=" + this.backgroundColor + ", background=" + this.background + ", padding=" + this.padding + ", margin=" + this.margin + ", shape=" + this.shape + ", border=" + this.border + ", shadow=" + this.shadow + ", badge=" + this.badge + ", overflow=" + this.overflow + ", overrides=" + this.overrides + ", name=" + this.name + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/StackComponent$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/StackComponent;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return StackComponent$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ StackComponent(int i, List list, Boolean bool, Dimension dimension, Size size, Float f, ColorScheme colorScheme, Background background, Padding padding, Padding padding2, Shape shape, Border border, Shadow shadow, Badge badge, Overflow overflow, List list2, String str, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, StackComponent$$serializer.INSTANCE.getDescriptor());
        }
        this.components = list;
        if ((i & 2) == 0) {
            this.visible = null;
        } else {
            this.visible = bool;
        }
        if ((i & 4) == 0) {
            this.dimension = new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START);
        } else {
            this.dimension = dimension;
        }
        if ((i & 8) == 0) {
            this.size = new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE);
        } else {
            this.size = size;
        }
        if ((i & 16) == 0) {
            this.spacing = null;
        } else {
            this.spacing = f;
        }
        if ((i & 32) == 0) {
            this.backgroundColor = null;
        } else {
            this.backgroundColor = colorScheme;
        }
        if ((i & 64) == 0) {
            this.background = null;
        } else {
            this.background = background;
        }
        if ((i & 128) == 0) {
            this.padding = Padding.INSTANCE.getZero();
        } else {
            this.padding = padding;
        }
        if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) == 0) {
            this.margin = Padding.INSTANCE.getZero();
        } else {
            this.margin = padding2;
        }
        if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) == 0) {
            this.shape = null;
        } else {
            this.shape = shape;
        }
        if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) == 0) {
            this.border = null;
        } else {
            this.border = border;
        }
        if ((i & 2048) == 0) {
            this.shadow = null;
        } else {
            this.shadow = shadow;
        }
        if ((i & 4096) == 0) {
            this.badge = null;
        } else {
            this.badge = badge;
        }
        if ((i & 8192) == 0) {
            this.overflow = null;
        } else {
            this.overflow = overflow;
        }
        this.overrides = (i & Http2.INITIAL_MAX_FRAME_SIZE) == 0 ? CollectionsKt.emptyList() : list2;
        if ((i & 32768) == 0) {
            this.name = null;
        } else {
            this.name = str;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StackComponent(List<? extends PaywallComponent> components, Boolean bool, Dimension dimension, Size size, Float f, ColorScheme colorScheme, Background background, Padding padding, Padding margin, Shape shape, Border border, Shadow shadow, Badge badge, Overflow overflow, List<ComponentOverride<PartialStackComponent>> overrides, String str) {
        Intrinsics.checkNotNullParameter(components, "components");
        Intrinsics.checkNotNullParameter(dimension, "dimension");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        this.components = components;
        this.visible = bool;
        this.dimension = dimension;
        this.size = size;
        this.spacing = f;
        this.backgroundColor = colorScheme;
        this.background = background;
        this.padding = padding;
        this.margin = margin;
        this.shape = shape;
        this.border = border;
        this.shadow = shadow;
        this.badge = badge;
        this.overflow = overflow;
        this.overrides = overrides;
        this.name = str;
    }

    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(StackComponent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer[] kSerializerArr = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, kSerializerArr[0], self.components);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.visible != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.visible);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.dimension, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START))) {
            output.encodeSerializableElement(serialDesc, 2, kSerializerArr[2], self.dimension);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.size, new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE))) {
            output.encodeSerializableElement(serialDesc, 3, Size$$serializer.INSTANCE, self.size);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.spacing != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, FloatSerializer.INSTANCE, self.spacing);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.backgroundColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, ColorScheme$$serializer.INSTANCE, self.backgroundColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.background != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, BackgroundDeserializer.INSTANCE, self.background);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || !Intrinsics.areEqual(self.padding, Padding.INSTANCE.getZero())) {
            output.encodeSerializableElement(serialDesc, 7, Padding$$serializer.INSTANCE, self.padding);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || !Intrinsics.areEqual(self.margin, Padding.INSTANCE.getZero())) {
            output.encodeSerializableElement(serialDesc, 8, Padding$$serializer.INSTANCE, self.margin);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.shape != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, ShapeDeserializer.INSTANCE, self.shape);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.border != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, Border$$serializer.INSTANCE, self.border);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.shadow != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, Shadow$$serializer.INSTANCE, self.shadow);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.badge != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, Badge$$serializer.INSTANCE, self.badge);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.overflow != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, StackOverflowDeserializer.INSTANCE, self.overflow);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || !Intrinsics.areEqual(self.overrides, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 14, kSerializerArr[14], self.overrides);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 15) && self.name == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.name);
    }

    public final /* synthetic */ List getComponents() {
        return this.components;
    }

    public final /* synthetic */ Boolean getVisible() {
        return this.visible;
    }

    public /* synthetic */ StackComponent(List list, Boolean bool, Dimension dimension, Size size, Float f, ColorScheme colorScheme, Background background, Padding padding, Padding padding2, Shape shape, Border border, Shadow shadow, Badge badge, Overflow overflow, List list2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START) : dimension, (i & 8) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE) : size, (i & 16) != 0 ? null : f, (i & 32) != 0 ? null : colorScheme, (i & 64) != 0 ? null : background, (i & 128) != 0 ? Padding.INSTANCE.getZero() : padding, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? Padding.INSTANCE.getZero() : padding2, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? null : shape, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : border, (i & 2048) != 0 ? null : shadow, (i & 4096) != 0 ? null : badge, (i & 8192) != 0 ? null : overflow, (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? CollectionsKt.emptyList() : list2, (i & 32768) != 0 ? null : str);
    }

    public final /* synthetic */ Dimension getDimension() {
        return this.dimension;
    }

    public final /* synthetic */ Size getSize() {
        return this.size;
    }

    public final /* synthetic */ Float getSpacing() {
        return this.spacing;
    }

    public final /* synthetic */ ColorScheme getBackgroundColor() {
        return this.backgroundColor;
    }

    public final /* synthetic */ Background getBackground() {
        return this.background;
    }

    public final /* synthetic */ Padding getPadding() {
        return this.padding;
    }

    public final /* synthetic */ Padding getMargin() {
        return this.margin;
    }

    public final /* synthetic */ Shape getShape() {
        return this.shape;
    }

    public final /* synthetic */ Border getBorder() {
        return this.border;
    }

    public final /* synthetic */ Shadow getShadow() {
        return this.shadow;
    }

    public final /* synthetic */ Badge getBadge() {
        return this.badge;
    }

    public final /* synthetic */ Overflow getOverflow() {
        return this.overflow;
    }

    public final /* synthetic */ List getOverrides() {
        return this.overrides;
    }

    public final /* synthetic */ String getName() {
        return this.name;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/StackComponent$Overflow;", "", "(Ljava/lang/String;I)V", "NONE", "SCROLL", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum Overflow {
        NONE,
        SCROLL;


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/StackComponent$Overflow$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/StackComponent$Overflow;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return StackOverflowDeserializer.INSTANCE;
            }
        }
    }
}
