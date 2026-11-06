package com.revenuecat.purchases.paywalls.components;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.facebook.react.modules.appstate.AppStateModule;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.BackgroundDeserializer;
import com.revenuecat.purchases.paywalls.components.common.ComponentOverride;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.Border$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shadow$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.ShapeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.paywalls.components.properties.VerticalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.VerticalAlignmentDeserializer;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.internal.UIntSerializer;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 c2\u00020\u0001:\u0004abcdB÷\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0001\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\u0010 \u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010!\u001a\u0004\u0018\u00010\"\u0012\u0014\u0010#\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$\u0018\u00010\u0005\u0012\b\u0010&\u001a\u0004\u0018\u00010'\u0012\b\u0010(\u001a\u0004\u0018\u00010)¢\u0006\u0002\u0010*Bë\u0001\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\u0014\b\u0002\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$0\u0005\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'¢\u0006\u0002\u0010+J&\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\u00002\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020_HÁ\u0001¢\u0006\u0002\b`R\u001e\u0010!\u001a\u0004\u0018\u00010\"8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010-\u001a\u0004\b3\u00104R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010:\u0012\u0004\b7\u0010-\u001a\u0004\b8\u00109R\u0015\u0010 \u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010=\u001a\u0004\b;\u0010<R\u0011\u0010\u0017\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0013\u0010&\u001a\u0004\u0018\u00010'¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u001d\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$0\u0005¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\bD\u0010?R\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bE\u0010-\u001a\u0004\bF\u0010GR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bH\u0010-\u001a\u0004\bI\u0010JR \u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010:\u0012\u0004\bK\u0010-\u001a\u0004\bL\u00109R \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010P\u0012\u0004\bM\u0010-\u001a\u0004\bN\u0010OR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010CR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010=\u001a\u0004\bX\u0010<¨\u0006e"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/CarouselComponent;", "Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;", "seen1", "", "pages", "", "Lcom/revenuecat/purchases/paywalls/components/StackComponent;", "visible", "", "initialPageIndex", "pageAlignment", "Lcom/revenuecat/purchases/paywalls/components/properties/VerticalAlignment;", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "pagePeek", "pageSpacing", "", "backgroundColor", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", AppStateModule.APP_STATE_BACKGROUND, "Lcom/revenuecat/purchases/paywalls/components/common/Background;", "padding", "Lcom/revenuecat/purchases/paywalls/components/properties/Padding;", "margin", "shape", "Lcom/revenuecat/purchases/paywalls/components/properties/Shape;", "border", "Lcom/revenuecat/purchases/paywalls/components/properties/Border;", "shadow", "Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;", "pageControl", "Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl;", "loop", "autoAdvance", "Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages;", "overrides", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride;", "Lcom/revenuecat/purchases/paywalls/components/PartialCarouselComponent;", "name", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/lang/Boolean;Ljava/lang/Integer;Lcom/revenuecat/purchases/paywalls/components/properties/VerticalAlignment;Lcom/revenuecat/purchases/paywalls/components/properties/Size;Ljava/lang/Integer;Ljava/lang/Float;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Lcom/revenuecat/purchases/paywalls/components/common/Background;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Shape;Lcom/revenuecat/purchases/paywalls/components/properties/Border;Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl;Ljava/lang/Boolean;Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages;Ljava/util/List;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Integer;Lcom/revenuecat/purchases/paywalls/components/properties/VerticalAlignment;Lcom/revenuecat/purchases/paywalls/components/properties/Size;Ljava/lang/Integer;Ljava/lang/Float;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Lcom/revenuecat/purchases/paywalls/components/common/Background;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Shape;Lcom/revenuecat/purchases/paywalls/components/properties/Border;Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl;Ljava/lang/Boolean;Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages;Ljava/util/List;Ljava/lang/String;)V", "getAutoAdvance$annotations", "()V", "getAutoAdvance", "()Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages;", "getBackground", "()Lcom/revenuecat/purchases/paywalls/components/common/Background;", "getBackgroundColor$annotations", "getBackgroundColor", "()Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "getBorder", "()Lcom/revenuecat/purchases/paywalls/components/properties/Border;", "getInitialPageIndex$annotations", "getInitialPageIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLoop", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMargin", "()Lcom/revenuecat/purchases/paywalls/components/properties/Padding;", "getName", "()Ljava/lang/String;", "getOverrides", "()Ljava/util/List;", "getPadding", "getPageAlignment$annotations", "getPageAlignment", "()Lcom/revenuecat/purchases/paywalls/components/properties/VerticalAlignment;", "getPageControl$annotations", "getPageControl", "()Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl;", "getPagePeek$annotations", "getPagePeek", "getPageSpacing$annotations", "getPageSpacing", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getPages", "getShadow", "()Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;", "getShape", "()Lcom/revenuecat/purchases/paywalls/components/properties/Shape;", "getSize", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getVisible", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "AutoAdvancePages", "Companion", "PageControl", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CarouselComponent implements PaywallComponent {
    private final AutoAdvancePages autoAdvance;
    private final Background background;
    private final ColorScheme backgroundColor;
    private final Border border;
    private final Integer initialPageIndex;
    private final Boolean loop;
    private final Padding margin;
    private final String name;
    private final List<ComponentOverride<PartialCarouselComponent>> overrides;
    private final Padding padding;
    private final VerticalAlignment pageAlignment;
    private final PageControl pageControl;
    private final Integer pagePeek;
    private final Float pageSpacing;
    private final List<StackComponent> pages;
    private final Shadow shadow;
    private final Shape shape;
    private final Size size;
    private final Boolean visible;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer[] $childSerializers = {new ArrayListSerializer(StackComponent$$serializer.INSTANCE), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new ArrayListSerializer(ComponentOverride.INSTANCE.serializer(PartialCarouselComponent$$serializer.INSTANCE)), null};

    public static /* synthetic */ void getAutoAdvance$annotations() {
    }

    public static /* synthetic */ void getBackgroundColor$annotations() {
    }

    public static /* synthetic */ void getInitialPageIndex$annotations() {
    }

    public static /* synthetic */ void getPageAlignment$annotations() {
    }

    public static /* synthetic */ void getPageControl$annotations() {
    }

    public static /* synthetic */ void getPagePeek$annotations() {
    }

    public static /* synthetic */ void getPageSpacing$annotations() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CarouselComponent)) {
            return false;
        }
        CarouselComponent carouselComponent = (CarouselComponent) obj;
        return Intrinsics.areEqual(this.pages, carouselComponent.pages) && Intrinsics.areEqual(this.visible, carouselComponent.visible) && Intrinsics.areEqual(this.initialPageIndex, carouselComponent.initialPageIndex) && this.pageAlignment == carouselComponent.pageAlignment && Intrinsics.areEqual(this.size, carouselComponent.size) && Intrinsics.areEqual(this.pagePeek, carouselComponent.pagePeek) && Intrinsics.areEqual(this.pageSpacing, carouselComponent.pageSpacing) && Intrinsics.areEqual(this.backgroundColor, carouselComponent.backgroundColor) && Intrinsics.areEqual(this.background, carouselComponent.background) && Intrinsics.areEqual(this.padding, carouselComponent.padding) && Intrinsics.areEqual(this.margin, carouselComponent.margin) && Intrinsics.areEqual(this.shape, carouselComponent.shape) && Intrinsics.areEqual(this.border, carouselComponent.border) && Intrinsics.areEqual(this.shadow, carouselComponent.shadow) && Intrinsics.areEqual(this.pageControl, carouselComponent.pageControl) && Intrinsics.areEqual(this.loop, carouselComponent.loop) && Intrinsics.areEqual(this.autoAdvance, carouselComponent.autoAdvance) && Intrinsics.areEqual(this.overrides, carouselComponent.overrides) && Intrinsics.areEqual(this.name, carouselComponent.name);
    }

    public int hashCode() {
        int iHashCode = this.pages.hashCode() * 31;
        Boolean bool = this.visible;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num = this.initialPageIndex;
        int iHashCode3 = (((((iHashCode2 + (num == null ? 0 : num.hashCode())) * 31) + this.pageAlignment.hashCode()) * 31) + this.size.hashCode()) * 31;
        Integer num2 = this.pagePeek;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Float f = this.pageSpacing;
        int iHashCode5 = (iHashCode4 + (f == null ? 0 : f.hashCode())) * 31;
        ColorScheme colorScheme = this.backgroundColor;
        int iHashCode6 = (iHashCode5 + (colorScheme == null ? 0 : colorScheme.hashCode())) * 31;
        Background background = this.background;
        int iHashCode7 = (((((iHashCode6 + (background == null ? 0 : background.hashCode())) * 31) + this.padding.hashCode()) * 31) + this.margin.hashCode()) * 31;
        Shape shape = this.shape;
        int iHashCode8 = (iHashCode7 + (shape == null ? 0 : shape.hashCode())) * 31;
        Border border = this.border;
        int iHashCode9 = (iHashCode8 + (border == null ? 0 : border.hashCode())) * 31;
        Shadow shadow = this.shadow;
        int iHashCode10 = (iHashCode9 + (shadow == null ? 0 : shadow.hashCode())) * 31;
        PageControl pageControl = this.pageControl;
        int iHashCode11 = (iHashCode10 + (pageControl == null ? 0 : pageControl.hashCode())) * 31;
        Boolean bool2 = this.loop;
        int iHashCode12 = (iHashCode11 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        AutoAdvancePages autoAdvancePages = this.autoAdvance;
        int iHashCode13 = (((iHashCode12 + (autoAdvancePages == null ? 0 : autoAdvancePages.hashCode())) * 31) + this.overrides.hashCode()) * 31;
        String str = this.name;
        return iHashCode13 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "CarouselComponent(pages=" + this.pages + ", visible=" + this.visible + ", initialPageIndex=" + this.initialPageIndex + ", pageAlignment=" + this.pageAlignment + ", size=" + this.size + ", pagePeek=" + this.pagePeek + ", pageSpacing=" + this.pageSpacing + ", backgroundColor=" + this.backgroundColor + ", background=" + this.background + ", padding=" + this.padding + ", margin=" + this.margin + ", shape=" + this.shape + ", border=" + this.border + ", shadow=" + this.shadow + ", pageControl=" + this.pageControl + ", loop=" + this.loop + ", autoAdvance=" + this.autoAdvance + ", overrides=" + this.overrides + ", name=" + this.name + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/CarouselComponent;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return CarouselComponent$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ CarouselComponent(int i, List list, Boolean bool, Integer num, VerticalAlignment verticalAlignment, Size size, Integer num2, Float f, ColorScheme colorScheme, Background background, Padding padding, Padding padding2, Shape shape, Border border, Shadow shadow, PageControl pageControl, Boolean bool2, AutoAdvancePages autoAdvancePages, List list2, String str, SerializationConstructorMarker serializationConstructorMarker) {
        if (9 != (i & 9)) {
            PluginExceptionsKt.throwMissingFieldException(i, 9, CarouselComponent$$serializer.INSTANCE.getDescriptor());
        }
        this.pages = list;
        if ((i & 2) == 0) {
            this.visible = null;
        } else {
            this.visible = bool;
        }
        if ((i & 4) == 0) {
            this.initialPageIndex = null;
        } else {
            this.initialPageIndex = num;
        }
        this.pageAlignment = verticalAlignment;
        if ((i & 16) == 0) {
            SizeConstraint.Fit fit = SizeConstraint.Fit.INSTANCE;
            this.size = new Size(fit, fit);
        } else {
            this.size = size;
        }
        if ((i & 32) == 0) {
            this.pagePeek = null;
        } else {
            this.pagePeek = num2;
        }
        if ((i & 64) == 0) {
            this.pageSpacing = null;
        } else {
            this.pageSpacing = f;
        }
        if ((i & 128) == 0) {
            this.backgroundColor = null;
        } else {
            this.backgroundColor = colorScheme;
        }
        if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) == 0) {
            this.background = null;
        } else {
            this.background = background;
        }
        if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) == 0) {
            this.padding = Padding.INSTANCE.getZero();
        } else {
            this.padding = padding;
        }
        if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) == 0) {
            this.margin = Padding.INSTANCE.getZero();
        } else {
            this.margin = padding2;
        }
        if ((i & 2048) == 0) {
            this.shape = null;
        } else {
            this.shape = shape;
        }
        if ((i & 4096) == 0) {
            this.border = null;
        } else {
            this.border = border;
        }
        if ((i & 8192) == 0) {
            this.shadow = null;
        } else {
            this.shadow = shadow;
        }
        if ((i & Http2.INITIAL_MAX_FRAME_SIZE) == 0) {
            this.pageControl = null;
        } else {
            this.pageControl = pageControl;
        }
        if ((32768 & i) == 0) {
            this.loop = null;
        } else {
            this.loop = bool2;
        }
        if ((65536 & i) == 0) {
            this.autoAdvance = null;
        } else {
            this.autoAdvance = autoAdvancePages;
        }
        this.overrides = (131072 & i) == 0 ? CollectionsKt.emptyList() : list2;
        if ((i & 262144) == 0) {
            this.name = null;
        } else {
            this.name = str;
        }
    }

    public CarouselComponent(List<StackComponent> pages, Boolean bool, Integer num, VerticalAlignment pageAlignment, Size size, Integer num2, Float f, ColorScheme colorScheme, Background background, Padding padding, Padding margin, Shape shape, Border border, Shadow shadow, PageControl pageControl, Boolean bool2, AutoAdvancePages autoAdvancePages, List<ComponentOverride<PartialCarouselComponent>> overrides, String str) {
        Intrinsics.checkNotNullParameter(pages, "pages");
        Intrinsics.checkNotNullParameter(pageAlignment, "pageAlignment");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        this.pages = pages;
        this.visible = bool;
        this.initialPageIndex = num;
        this.pageAlignment = pageAlignment;
        this.size = size;
        this.pagePeek = num2;
        this.pageSpacing = f;
        this.backgroundColor = colorScheme;
        this.background = background;
        this.padding = padding;
        this.margin = margin;
        this.shape = shape;
        this.border = border;
        this.shadow = shadow;
        this.pageControl = pageControl;
        this.loop = bool2;
        this.autoAdvance = autoAdvancePages;
        this.overrides = overrides;
        this.name = str;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x004f  */
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(CarouselComponent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer[] kSerializerArr = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, kSerializerArr[0], self.pages);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.visible != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.visible);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.initialPageIndex != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.initialPageIndex);
        }
        output.encodeSerializableElement(serialDesc, 3, VerticalAlignmentDeserializer.INSTANCE, self.pageAlignment);
        if (output.shouldEncodeElementDefault(serialDesc, 4)) {
            output.encodeSerializableElement(serialDesc, 4, Size$$serializer.INSTANCE, self.size);
        } else {
            Size size = self.size;
            SizeConstraint.Fit fit = SizeConstraint.Fit.INSTANCE;
            if (!Intrinsics.areEqual(size, new Size(fit, fit))) {
                output.encodeSerializableElement(serialDesc, 4, Size$$serializer.INSTANCE, self.size);
            }
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.pagePeek != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, IntSerializer.INSTANCE, self.pagePeek);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.pageSpacing != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, FloatSerializer.INSTANCE, self.pageSpacing);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.backgroundColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, ColorScheme$$serializer.INSTANCE, self.backgroundColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.background != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, BackgroundDeserializer.INSTANCE, self.background);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || !Intrinsics.areEqual(self.padding, Padding.INSTANCE.getZero())) {
            output.encodeSerializableElement(serialDesc, 9, Padding$$serializer.INSTANCE, self.padding);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || !Intrinsics.areEqual(self.margin, Padding.INSTANCE.getZero())) {
            output.encodeSerializableElement(serialDesc, 10, Padding$$serializer.INSTANCE, self.margin);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.shape != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, ShapeDeserializer.INSTANCE, self.shape);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.border != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, Border$$serializer.INSTANCE, self.border);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.shadow != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, Shadow$$serializer.INSTANCE, self.shadow);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.pageControl != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, CarouselComponent$PageControl$$serializer.INSTANCE, self.pageControl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.loop != null) {
            output.encodeNullableSerializableElement(serialDesc, 15, BooleanSerializer.INSTANCE, self.loop);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || self.autoAdvance != null) {
            output.encodeNullableSerializableElement(serialDesc, 16, CarouselComponent$AutoAdvancePages$$serializer.INSTANCE, self.autoAdvance);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) || !Intrinsics.areEqual(self.overrides, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 17, kSerializerArr[17], self.overrides);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 18) && self.name == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 18, StringSerializer.INSTANCE, self.name);
    }

    public final /* synthetic */ List getPages() {
        return this.pages;
    }

    public final /* synthetic */ Boolean getVisible() {
        return this.visible;
    }

    public final /* synthetic */ Integer getInitialPageIndex() {
        return this.initialPageIndex;
    }

    public final /* synthetic */ VerticalAlignment getPageAlignment() {
        return this.pageAlignment;
    }

    public /* synthetic */ CarouselComponent(List list, Boolean bool, Integer num, VerticalAlignment verticalAlignment, Size size, Integer num2, Float f, ColorScheme colorScheme, Background background, Padding padding, Padding padding2, Shape shape, Border border, Shadow shadow, PageControl pageControl, Boolean bool2, AutoAdvancePages autoAdvancePages, List list2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Size size2;
        Boolean bool3 = (i & 2) != 0 ? null : bool;
        Integer num3 = (i & 4) != 0 ? null : num;
        if ((i & 16) != 0) {
            SizeConstraint.Fit fit = SizeConstraint.Fit.INSTANCE;
            size2 = new Size(fit, fit);
        } else {
            size2 = size;
        }
        this(list, bool3, num3, verticalAlignment, size2, (i & 32) != 0 ? null : num2, (i & 64) != 0 ? null : f, (i & 128) != 0 ? null : colorScheme, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : background, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? Padding.INSTANCE.getZero() : padding, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? Padding.INSTANCE.getZero() : padding2, (i & 2048) != 0 ? null : shape, (i & 4096) != 0 ? null : border, (i & 8192) != 0 ? null : shadow, (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? null : pageControl, (32768 & i) != 0 ? null : bool2, (65536 & i) != 0 ? null : autoAdvancePages, (131072 & i) != 0 ? CollectionsKt.emptyList() : list2, (i & 262144) != 0 ? null : str);
    }

    public final /* synthetic */ Size getSize() {
        return this.size;
    }

    public final /* synthetic */ Integer getPagePeek() {
        return this.pagePeek;
    }

    public final /* synthetic */ Float getPageSpacing() {
        return this.pageSpacing;
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

    public final /* synthetic */ PageControl getPageControl() {
        return this.pageControl;
    }

    public final /* synthetic */ Boolean getLoop() {
        return this.loop;
    }

    public final /* synthetic */ AutoAdvancePages getAutoAdvance() {
        return this.autoAdvance;
    }

    public final /* synthetic */ List getOverrides() {
        return this.overrides;
    }

    public final /* synthetic */ String getName() {
        return this.name;
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0003\u001d\u001e\u001fB9\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB!\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ&\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bHÁ\u0001¢\u0006\u0002\b\u001cR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages;", "", "seen1", "", "msTimePerPage", "msTransitionTime", "transitionType", "Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages$TransitionType;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIILcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages$TransitionType;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(IILcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages$TransitionType;)V", "getMsTimePerPage$annotations", "()V", "getMsTimePerPage", "()I", "getMsTransitionTime$annotations", "getMsTransitionTime", "getTransitionType$annotations", "getTransitionType", "()Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages$TransitionType;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "TransitionType", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AutoAdvancePages {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int msTimePerPage;
        private final int msTransitionTime;
        private final TransitionType transitionType;

        public static /* synthetic */ void getMsTimePerPage$annotations() {
        }

        public static /* synthetic */ void getMsTransitionTime$annotations() {
        }

        public static /* synthetic */ void getTransitionType$annotations() {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AutoAdvancePages)) {
                return false;
            }
            AutoAdvancePages autoAdvancePages = (AutoAdvancePages) obj;
            return this.msTimePerPage == autoAdvancePages.msTimePerPage && this.msTransitionTime == autoAdvancePages.msTransitionTime && this.transitionType == autoAdvancePages.transitionType;
        }

        public int hashCode() {
            int i = ((this.msTimePerPage * 31) + this.msTransitionTime) * 31;
            TransitionType transitionType = this.transitionType;
            return i + (transitionType == null ? 0 : transitionType.hashCode());
        }

        public String toString() {
            return "AutoAdvancePages(msTimePerPage=" + this.msTimePerPage + ", msTransitionTime=" + this.msTransitionTime + ", transitionType=" + this.transitionType + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return CarouselComponent$AutoAdvancePages$$serializer.INSTANCE;
            }
        }

        @Deprecated
        public /* synthetic */ AutoAdvancePages(int i, int i2, int i3, TransitionType transitionType, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i, 3, CarouselComponent$AutoAdvancePages$$serializer.INSTANCE.getDescriptor());
            }
            this.msTimePerPage = i2;
            this.msTransitionTime = i3;
            if ((i & 4) == 0) {
                this.transitionType = null;
            } else {
                this.transitionType = transitionType;
            }
        }

        public AutoAdvancePages(int i, int i2, TransitionType transitionType) {
            this.msTimePerPage = i;
            this.msTransitionTime = i2;
            this.transitionType = transitionType;
        }

        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(AutoAdvancePages self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeIntElement(serialDesc, 0, self.msTimePerPage);
            output.encodeIntElement(serialDesc, 1, self.msTransitionTime);
            if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.transitionType == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 2, CarouselTransitionTypeDeserializer.INSTANCE, self.transitionType);
        }

        public /* synthetic */ AutoAdvancePages(int i, int i2, TransitionType transitionType, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2, (i3 & 4) != 0 ? null : transitionType);
        }

        public final /* synthetic */ int getMsTimePerPage() {
            return this.msTimePerPage;
        }

        public final /* synthetic */ int getMsTransitionTime() {
            return this.msTransitionTime;
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages$TransitionType;", "", "(Ljava/lang/String;I)V", "FADE", "SLIDE", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public enum TransitionType {
            FADE,
            SLIDE;


            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages$TransitionType$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages$TransitionType;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer serializer() {
                    return CarouselTransitionTypeDeserializer.INSTANCE;
                }
            }
        }

        public final /* synthetic */ TransitionType getTransitionType() {
            return this.transitionType;
        }
    }

    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 72\u00020\u0001:\u00046789B\u007f\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017Bm\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0002\u0010\u0018J&\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204HÁ\u0001¢\u0006\u0002\b5R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0014\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,¨\u0006:"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl;", "", "seen1", "", "position", "Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl$Position;", "spacing", "padding", "Lcom/revenuecat/purchases/paywalls/components/properties/Padding;", "margin", "backgroundColor", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "shape", "Lcom/revenuecat/purchases/paywalls/components/properties/Shape;", "border", "Lcom/revenuecat/purchases/paywalls/components/properties/Border;", "shadow", "Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;", AppStateModule.APP_STATE_ACTIVE, "Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl$Indicator;", "default", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl$Position;Ljava/lang/Integer;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Lcom/revenuecat/purchases/paywalls/components/properties/Shape;Lcom/revenuecat/purchases/paywalls/components/properties/Border;Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl$Indicator;Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl$Indicator;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl$Position;Ljava/lang/Integer;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Lcom/revenuecat/purchases/paywalls/components/properties/Shape;Lcom/revenuecat/purchases/paywalls/components/properties/Border;Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl$Indicator;Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl$Indicator;)V", "getActive", "()Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl$Indicator;", "getBackgroundColor$annotations", "()V", "getBackgroundColor", "()Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "getBorder", "()Lcom/revenuecat/purchases/paywalls/components/properties/Border;", "getDefault", "getMargin", "()Lcom/revenuecat/purchases/paywalls/components/properties/Padding;", "getPadding", "getPosition", "()Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl$Position;", "getShadow", "()Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;", "getShape", "()Lcom/revenuecat/purchases/paywalls/components/properties/Shape;", "getSpacing", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "Indicator", "Position", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class PageControl {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Indicator active;
        private final ColorScheme backgroundColor;
        private final Border border;
        private final Indicator default;
        private final Padding margin;
        private final Padding padding;
        private final Position position;
        private final Shadow shadow;
        private final Shape shape;
        private final Integer spacing;

        public static /* synthetic */ void getBackgroundColor$annotations() {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PageControl)) {
                return false;
            }
            PageControl pageControl = (PageControl) obj;
            return this.position == pageControl.position && Intrinsics.areEqual(this.spacing, pageControl.spacing) && Intrinsics.areEqual(this.padding, pageControl.padding) && Intrinsics.areEqual(this.margin, pageControl.margin) && Intrinsics.areEqual(this.backgroundColor, pageControl.backgroundColor) && Intrinsics.areEqual(this.shape, pageControl.shape) && Intrinsics.areEqual(this.border, pageControl.border) && Intrinsics.areEqual(this.shadow, pageControl.shadow) && Intrinsics.areEqual(this.active, pageControl.active) && Intrinsics.areEqual(this.default, pageControl.default);
        }

        public int hashCode() {
            int iHashCode = this.position.hashCode() * 31;
            Integer num = this.spacing;
            int iHashCode2 = (((((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + this.padding.hashCode()) * 31) + this.margin.hashCode()) * 31;
            ColorScheme colorScheme = this.backgroundColor;
            int iHashCode3 = (iHashCode2 + (colorScheme == null ? 0 : colorScheme.hashCode())) * 31;
            Shape shape = this.shape;
            int iHashCode4 = (iHashCode3 + (shape == null ? 0 : shape.hashCode())) * 31;
            Border border = this.border;
            int iHashCode5 = (iHashCode4 + (border == null ? 0 : border.hashCode())) * 31;
            Shadow shadow = this.shadow;
            return ((((iHashCode5 + (shadow != null ? shadow.hashCode() : 0)) * 31) + this.active.hashCode()) * 31) + this.default.hashCode();
        }

        public String toString() {
            return "PageControl(position=" + this.position + ", spacing=" + this.spacing + ", padding=" + this.padding + ", margin=" + this.margin + ", backgroundColor=" + this.backgroundColor + ", shape=" + this.shape + ", border=" + this.border + ", shadow=" + this.shadow + ", active=" + this.active + ", default=" + this.default + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return CarouselComponent$PageControl$$serializer.INSTANCE;
            }
        }

        @Deprecated
        public /* synthetic */ PageControl(int i, Position position, Integer num, Padding padding, Padding padding2, ColorScheme colorScheme, Shape shape, Border border, Shadow shadow, Indicator indicator, Indicator indicator2, SerializationConstructorMarker serializationConstructorMarker) {
            if (769 != (i & 769)) {
                PluginExceptionsKt.throwMissingFieldException(i, 769, CarouselComponent$PageControl$$serializer.INSTANCE.getDescriptor());
            }
            this.position = position;
            if ((i & 2) == 0) {
                this.spacing = null;
            } else {
                this.spacing = num;
            }
            if ((i & 4) == 0) {
                this.padding = Padding.INSTANCE.getZero();
            } else {
                this.padding = padding;
            }
            if ((i & 8) == 0) {
                this.margin = Padding.INSTANCE.getZero();
            } else {
                this.margin = padding2;
            }
            if ((i & 16) == 0) {
                this.backgroundColor = null;
            } else {
                this.backgroundColor = colorScheme;
            }
            if ((i & 32) == 0) {
                this.shape = null;
            } else {
                this.shape = shape;
            }
            if ((i & 64) == 0) {
                this.border = null;
            } else {
                this.border = border;
            }
            if ((i & 128) == 0) {
                this.shadow = null;
            } else {
                this.shadow = shadow;
            }
            this.active = indicator;
            this.default = indicator2;
        }

        public PageControl(Position position, Integer num, Padding padding, Padding margin, ColorScheme colorScheme, Shape shape, Border border, Shadow shadow, Indicator active, Indicator indicator) {
            Intrinsics.checkNotNullParameter(position, "position");
            Intrinsics.checkNotNullParameter(padding, "padding");
            Intrinsics.checkNotNullParameter(margin, "margin");
            Intrinsics.checkNotNullParameter(active, "active");
            Intrinsics.checkNotNullParameter(indicator, "default");
            this.position = position;
            this.spacing = num;
            this.padding = padding;
            this.margin = margin;
            this.backgroundColor = colorScheme;
            this.shape = shape;
            this.border = border;
            this.shadow = shadow;
            this.active = active;
            this.default = indicator;
        }

        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PageControl self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeSerializableElement(serialDesc, 0, CarouselPageControlPositionDeserializer.INSTANCE, self.position);
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.spacing != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.spacing);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.padding, Padding.INSTANCE.getZero())) {
                output.encodeSerializableElement(serialDesc, 2, Padding$$serializer.INSTANCE, self.padding);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.margin, Padding.INSTANCE.getZero())) {
                output.encodeSerializableElement(serialDesc, 3, Padding$$serializer.INSTANCE, self.margin);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.backgroundColor != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, ColorScheme$$serializer.INSTANCE, self.backgroundColor);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.shape != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, ShapeDeserializer.INSTANCE, self.shape);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.border != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, Border$$serializer.INSTANCE, self.border);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.shadow != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, Shadow$$serializer.INSTANCE, self.shadow);
            }
            CarouselComponent$PageControl$Indicator$$serializer carouselComponent$PageControl$Indicator$$serializer = CarouselComponent$PageControl$Indicator$$serializer.INSTANCE;
            output.encodeSerializableElement(serialDesc, 8, carouselComponent$PageControl$Indicator$$serializer, self.active);
            output.encodeSerializableElement(serialDesc, 9, carouselComponent$PageControl$Indicator$$serializer, self.default);
        }

        public final /* synthetic */ Position getPosition() {
            return this.position;
        }

        public final /* synthetic */ Integer getSpacing() {
            return this.spacing;
        }

        public /* synthetic */ PageControl(Position position, Integer num, Padding padding, Padding padding2, ColorScheme colorScheme, Shape shape, Border border, Shadow shadow, Indicator indicator, Indicator indicator2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(position, (i & 2) != 0 ? null : num, (i & 4) != 0 ? Padding.INSTANCE.getZero() : padding, (i & 8) != 0 ? Padding.INSTANCE.getZero() : padding2, (i & 16) != 0 ? null : colorScheme, (i & 32) != 0 ? null : shape, (i & 64) != 0 ? null : border, (i & 128) != 0 ? null : shadow, indicator, indicator2);
        }

        public final /* synthetic */ Padding getPadding() {
            return this.padding;
        }

        public final /* synthetic */ Padding getMargin() {
            return this.margin;
        }

        public final /* synthetic */ ColorScheme getBackgroundColor() {
            return this.backgroundColor;
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

        public final /* synthetic */ Indicator getActive() {
            return this.active;
        }

        public final /* synthetic */ Indicator getDefault() {
            return this.default;
        }

        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 $2\u00020\u0001:\u0002#$BO\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rB5\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000eJ&\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!HÁ\u0001¢\u0006\u0002\b\"R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0010R$\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001a\u0010\u0012\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006%"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl$Indicator;", "", "seen1", "", "width", "Lkotlin/UInt;", "height", "color", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "strokeColor", "strokeWidth", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkotlin/UInt;Lkotlin/UInt;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Lkotlin/UInt;Lkotlinx/serialization/internal/SerializationConstructorMarker;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(IILcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Lkotlin/UInt;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColor", "()Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "getHeight-pVg5ArA", "()I", "I", "getStrokeColor$annotations", "()V", "getStrokeColor", "getStrokeWidth-0hXNFcg$annotations", "getStrokeWidth-0hXNFcg", "()Lkotlin/UInt;", "getWidth-pVg5ArA", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Indicator {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final ColorScheme color;
            private final int height;
            private final ColorScheme strokeColor;
            private final UInt strokeWidth;
            private final int width;

            public /* synthetic */ Indicator(int i, int i2, ColorScheme colorScheme, ColorScheme colorScheme2, UInt uInt, DefaultConstructorMarker defaultConstructorMarker) {
                this(i, i2, colorScheme, colorScheme2, uInt);
            }

            @Deprecated
            public /* synthetic */ Indicator(int i, UInt uInt, UInt uInt2, ColorScheme colorScheme, ColorScheme colorScheme2, UInt uInt3, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
                this(i, uInt, uInt2, colorScheme, colorScheme2, uInt3, serializationConstructorMarker);
            }

            public static /* synthetic */ void getStrokeColor$annotations() {
            }

            /* JADX INFO: renamed from: getStrokeWidth-0hXNFcg$annotations, reason: not valid java name */
            public static /* synthetic */ void m3927getStrokeWidth0hXNFcg$annotations() {
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Indicator)) {
                    return false;
                }
                Indicator indicator = (Indicator) obj;
                return this.width == indicator.width && this.height == indicator.height && Intrinsics.areEqual(this.color, indicator.color) && Intrinsics.areEqual(this.strokeColor, indicator.strokeColor) && Intrinsics.areEqual(this.strokeWidth, indicator.strokeWidth);
            }

            public int hashCode() {
                int iHashCode = ((((this.width * 31) + this.height) * 31) + this.color.hashCode()) * 31;
                ColorScheme colorScheme = this.strokeColor;
                int iHashCode2 = (iHashCode + (colorScheme == null ? 0 : colorScheme.hashCode())) * 31;
                UInt uInt = this.strokeWidth;
                return iHashCode2 + (uInt != null ? UInt.m5277hashCodeimpl(uInt.m5279unboximpl()) : 0);
            }

            public String toString() {
                return "Indicator(width=" + ((Object) UInt.m5278toStringimpl(this.width)) + ", height=" + ((Object) UInt.m5278toStringimpl(this.height)) + ", color=" + this.color + ", strokeColor=" + this.strokeColor + ", strokeWidth=" + this.strokeWidth + ')';
            }

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl$Indicator$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl$Indicator;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer serializer() {
                    return CarouselComponent$PageControl$Indicator$$serializer.INSTANCE;
                }
            }

            private Indicator(int i, int i2, ColorScheme color, ColorScheme colorScheme, UInt uInt) {
                Intrinsics.checkNotNullParameter(color, "color");
                this.width = i;
                this.height = i2;
                this.color = color;
                this.strokeColor = colorScheme;
                this.strokeWidth = uInt;
            }

            private Indicator(int i, UInt uInt, UInt uInt2, ColorScheme colorScheme, ColorScheme colorScheme2, UInt uInt3, SerializationConstructorMarker serializationConstructorMarker) {
                if (7 != (i & 7)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 7, CarouselComponent$PageControl$Indicator$$serializer.INSTANCE.getDescriptor());
                }
                this.width = uInt.m5279unboximpl();
                this.height = uInt2.m5279unboximpl();
                this.color = colorScheme;
                if ((i & 8) == 0) {
                    this.strokeColor = null;
                } else {
                    this.strokeColor = colorScheme2;
                }
                if ((i & 16) == 0) {
                    this.strokeWidth = null;
                } else {
                    this.strokeWidth = uInt3;
                }
            }

            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Indicator self, CompositeEncoder output, SerialDescriptor serialDesc) {
                UIntSerializer uIntSerializer = UIntSerializer.INSTANCE;
                output.encodeSerializableElement(serialDesc, 0, uIntSerializer, UInt.m5274boximpl(self.width));
                output.encodeSerializableElement(serialDesc, 1, uIntSerializer, UInt.m5274boximpl(self.height));
                ColorScheme$$serializer colorScheme$$serializer = ColorScheme$$serializer.INSTANCE;
                output.encodeSerializableElement(serialDesc, 2, colorScheme$$serializer, self.color);
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.strokeColor != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, colorScheme$$serializer, self.strokeColor);
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.strokeWidth == null) {
                    return;
                }
                output.encodeNullableSerializableElement(serialDesc, 4, uIntSerializer, self.strokeWidth);
            }

            public /* synthetic */ Indicator(int i, int i2, ColorScheme colorScheme, ColorScheme colorScheme2, UInt uInt, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this(i, i2, colorScheme, (i3 & 8) != 0 ? null : colorScheme2, (i3 & 16) != 0 ? null : uInt, null);
            }

            /* JADX INFO: renamed from: getWidth-pVg5ArA, reason: not valid java name and from getter */
            public final /* synthetic */ int getWidth() {
                return this.width;
            }

            /* JADX INFO: renamed from: getHeight-pVg5ArA, reason: not valid java name and from getter */
            public final /* synthetic */ int getHeight() {
                return this.height;
            }

            public final /* synthetic */ ColorScheme getColor() {
                return this.color;
            }

            public final /* synthetic */ ColorScheme getStrokeColor() {
                return this.strokeColor;
            }

            /* JADX INFO: renamed from: getStrokeWidth-0hXNFcg, reason: not valid java name and from getter */
            public final /* synthetic */ UInt getStrokeWidth() {
                return this.strokeWidth;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl$Position;", "", "(Ljava/lang/String;I)V", "TOP", "BOTTOM", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public enum Position {
            TOP,
            BOTTOM;


            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl$Position$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl$Position;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer serializer() {
                    return CarouselPageControlPositionDeserializer.INSTANCE;
                }
            }
        }
    }
}
