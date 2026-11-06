package com.revenuecat.purchases.ui.revenuecatui.components.style;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.Dp;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.facebook.react.modules.appstate.AppStateModule;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.paywalls.components.CountdownComponent;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedOverride;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedStackPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResolvedOffer;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\bO\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u00012\u00020\u0002B÷\u0001\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\u0010 \u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#\u0012\b\u0010$\u001a\u0004\u0018\u00010%\u0012\u0006\u0010&\u001a\u00020'\u0012\u0012\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0\u0004\u0012\b\b\u0002\u0010+\u001a\u00020\b\u0012\b\b\u0002\u0010,\u001a\u00020\b\u0012\b\b\u0002\u0010-\u001a\u00020\b\u0012\b\b\u0002\u0010.\u001a\u00020\b¢\u0006\u0002\u0010/J\u000f\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\u0010\u0010c\u001a\u0004\u0018\u00010!HÆ\u0003¢\u0006\u0002\u0010YJ\u000b\u0010d\u001a\u0004\u0018\u00010#HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010%HÆ\u0003J\t\u0010f\u001a\u00020'HÆ\u0003J\t\u0010g\u001a\u00020\u0006HÆ\u0003J\u0015\u0010h\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0\u0004HÆ\u0003J\t\u0010i\u001a\u00020\bHÆ\u0003J\t\u0010j\u001a\u00020\bHÆ\u0003J\t\u0010k\u001a\u00020\bHÆ\u0003J\t\u0010l\u001a\u00020\bHÆ\u0003J\t\u0010m\u001a\u00020\bHÆ\u0003J\t\u0010n\u001a\u00020\nHÆ\u0003J\u0016\u0010o\u001a\u00020\fHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bp\u0010VJ\u000b\u0010q\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010r\u001a\u00020\u0010HÆ\u0003J\t\u0010s\u001a\u00020\u0010HÆ\u0003J\t\u0010t\u001a\u00020\u0013HÆ\u0003J©\u0002\u0010u\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\b\b\u0002\u0010&\u001a\u00020'2\u0014\b\u0002\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0\u00042\b\b\u0002\u0010+\u001a\u00020\b2\b\b\u0002\u0010,\u001a\u00020\b2\b\b\u0002\u0010-\u001a\u00020\b2\b\b\u0002\u0010.\u001a\u00020\bHÆ\u0001ø\u0001\u0000¢\u0006\u0004\bv\u0010wJ\u0013\u0010x\u001a\u00020\b2\b\u0010y\u001a\u0004\u0018\u00010zHÖ\u0003J\t\u0010{\u001a\u00020!HÖ\u0001J\t\u0010|\u001a\u00020}HÖ\u0001R\u0011\u0010-\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010.\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b2\u00101R\u0011\u0010+\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b3\u00101R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0011\u0010&\u001a\u00020'¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0013\u0010$\u001a\u0004\u0018\u00010%¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0011\u0010,\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bB\u00101R\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0016\u0010\"\u001a\u0004\u0018\u00010#X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u001d\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010;R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bH\u0010DR\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u0019\u0010\u000b\u001a\u00020\fø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010W\u001a\u0004\bU\u0010VR\u0018\u0010 \u001a\u0004\u0018\u00010!X\u0096\u0004¢\u0006\n\n\u0002\u0010Z\u001a\u0004\bX\u0010YR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u00101\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006~"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/state/PackageContext;", "children", "", "dimension", "Lcom/revenuecat/purchases/paywalls/components/properties/Dimension;", "visible", "", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "spacing", "Landroidx/compose/ui/unit/Dp;", AppStateModule.APP_STATE_BACKGROUND, "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;", "padding", "Landroidx/compose/foundation/layout/PaddingValues;", "margin", "shape", "Lcom/revenuecat/purchases/paywalls/components/properties/Shape;", "border", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;", "shadow", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;", "badge", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/BadgeStyle;", "scrollOrientation", "Landroidx/compose/foundation/gestures/Orientation;", "rcPackage", "Lcom/revenuecat/purchases/Package;", "resolvedOffer", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "tabIndex", "", "offerEligibility", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "countdownDate", "Ljava/util/Date;", "countFrom", "Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountFrom;", "overrides", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedOverride;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedStackPartial;", "applyTopWindowInsets", "ignoreHeaderHeight", "applyBottomWindowInsets", "applyHorizontalWindowInsets", "(Ljava/util/List;Lcom/revenuecat/purchases/paywalls/components/properties/Dimension;ZLcom/revenuecat/purchases/paywalls/components/properties/Size;FLcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/PaddingValues;Lcom/revenuecat/purchases/paywalls/components/properties/Shape;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/BadgeStyle;Landroidx/compose/foundation/gestures/Orientation;Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;Ljava/lang/Integer;Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;Ljava/util/Date;Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountFrom;Ljava/util/List;ZZZZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getApplyBottomWindowInsets", "()Z", "getApplyHorizontalWindowInsets", "getApplyTopWindowInsets", "getBackground", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;", "getBadge", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/BadgeStyle;", "getBorder", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;", "getChildren", "()Ljava/util/List;", "getCountFrom", "()Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountFrom;", "getCountdownDate", "()Ljava/util/Date;", "getDimension", "()Lcom/revenuecat/purchases/paywalls/components/properties/Dimension;", "getIgnoreHeaderHeight", "getMargin", "()Landroidx/compose/foundation/layout/PaddingValues;", "getOfferEligibility", "()Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "getOverrides", "getPadding", "getRcPackage", "()Lcom/revenuecat/purchases/Package;", "getResolvedOffer", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "getScrollOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getShadow", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;", "getShape", "()Lcom/revenuecat/purchases/paywalls/components/properties/Shape;", "getSize", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getSpacing-D9Ej5fM", "()F", "F", "getTabIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getVisible", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component3", "component4", "component5", "component5-D9Ej5fM", "component6", "component7", "component8", "component9", "copy", "copy-h6c5tkY", "(Ljava/util/List;Lcom/revenuecat/purchases/paywalls/components/properties/Dimension;ZLcom/revenuecat/purchases/paywalls/components/properties/Size;FLcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/PaddingValues;Lcom/revenuecat/purchases/paywalls/components/properties/Shape;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/BadgeStyle;Landroidx/compose/foundation/gestures/Orientation;Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;Ljava/lang/Integer;Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;Ljava/util/Date;Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountFrom;Ljava/util/List;ZZZZ)Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class StackComponentStyle implements ComponentStyle, PackageContext {
    public static final int $stable = 0;
    private final boolean applyBottomWindowInsets;
    private final boolean applyHorizontalWindowInsets;
    private final boolean applyTopWindowInsets;
    private final BackgroundStyles background;
    private final BadgeStyle badge;
    private final BorderStyles border;
    private final List<ComponentStyle> children;
    private final CountdownComponent.CountFrom countFrom;
    private final Date countdownDate;
    private final Dimension dimension;
    private final boolean ignoreHeaderHeight;
    private final PaddingValues margin;
    private final OfferEligibility offerEligibility;
    private final List<PresentedOverride<PresentedStackPartial>> overrides;
    private final PaddingValues padding;
    private final Package rcPackage;
    private final ResolvedOffer resolvedOffer;
    private final Orientation scrollOrientation;
    private final ShadowStyles shadow;
    private final Shape shape;
    private final Size size;
    private final float spacing;
    private final Integer tabIndex;
    private final boolean visible;

    public /* synthetic */ StackComponentStyle(List list, Dimension dimension, boolean z, Size size, float f, BackgroundStyles backgroundStyles, PaddingValues paddingValues, PaddingValues paddingValues2, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, BadgeStyle badgeStyle, Orientation orientation, Package r14, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, Date date, CountdownComponent.CountFrom countFrom, List list2, boolean z2, boolean z3, boolean z4, boolean z5, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, dimension, z, size, f, backgroundStyles, paddingValues, paddingValues2, shape, borderStyles, shadowStyles, badgeStyle, orientation, r14, resolvedOffer, num, offerEligibility, date, countFrom, list2, z2, z3, z4, z5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: copy-h6c5tkY$default, reason: not valid java name */
    public static /* synthetic */ StackComponentStyle m4184copyh6c5tkY$default(StackComponentStyle stackComponentStyle, List list, Dimension dimension, boolean z, Size size, float f, BackgroundStyles backgroundStyles, PaddingValues paddingValues, PaddingValues paddingValues2, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, BadgeStyle badgeStyle, Orientation orientation, Package r31, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, Date date, CountdownComponent.CountFrom countFrom, List list2, boolean z2, boolean z3, boolean z4, boolean z5, int i, Object obj) {
        boolean z6;
        boolean z7;
        List list3 = (i & 1) != 0 ? stackComponentStyle.children : list;
        Dimension dimension2 = (i & 2) != 0 ? stackComponentStyle.dimension : dimension;
        boolean z8 = (i & 4) != 0 ? stackComponentStyle.visible : z;
        Size size2 = (i & 8) != 0 ? stackComponentStyle.size : size;
        float f2 = (i & 16) != 0 ? stackComponentStyle.spacing : f;
        BackgroundStyles backgroundStyles2 = (i & 32) != 0 ? stackComponentStyle.background : backgroundStyles;
        PaddingValues paddingValues3 = (i & 64) != 0 ? stackComponentStyle.padding : paddingValues;
        PaddingValues paddingValues4 = (i & 128) != 0 ? stackComponentStyle.margin : paddingValues2;
        Shape shape2 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? stackComponentStyle.shape : shape;
        BorderStyles borderStyles2 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? stackComponentStyle.border : borderStyles;
        ShadowStyles shadowStyles2 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? stackComponentStyle.shadow : shadowStyles;
        BadgeStyle badgeStyle2 = (i & 2048) != 0 ? stackComponentStyle.badge : badgeStyle;
        Orientation orientation2 = (i & 4096) != 0 ? stackComponentStyle.scrollOrientation : orientation;
        Package r15 = (i & 8192) != 0 ? stackComponentStyle.rcPackage : r31;
        List list4 = list3;
        ResolvedOffer resolvedOffer2 = (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? stackComponentStyle.resolvedOffer : resolvedOffer;
        Integer num2 = (i & 32768) != 0 ? stackComponentStyle.tabIndex : num;
        OfferEligibility offerEligibility2 = (i & 65536) != 0 ? stackComponentStyle.offerEligibility : offerEligibility;
        Date date2 = (i & 131072) != 0 ? stackComponentStyle.countdownDate : date;
        CountdownComponent.CountFrom countFrom2 = (i & 262144) != 0 ? stackComponentStyle.countFrom : countFrom;
        List list5 = (i & 524288) != 0 ? stackComponentStyle.overrides : list2;
        boolean z9 = (i & 1048576) != 0 ? stackComponentStyle.applyTopWindowInsets : z2;
        boolean z10 = (i & 2097152) != 0 ? stackComponentStyle.ignoreHeaderHeight : z3;
        boolean z11 = (i & 4194304) != 0 ? stackComponentStyle.applyBottomWindowInsets : z4;
        if ((i & 8388608) != 0) {
            z7 = z11;
            z6 = stackComponentStyle.applyHorizontalWindowInsets;
        } else {
            z6 = z5;
            z7 = z11;
        }
        return stackComponentStyle.m4186copyh6c5tkY(list4, dimension2, z8, size2, f2, backgroundStyles2, paddingValues3, paddingValues4, shape2, borderStyles2, shadowStyles2, badgeStyle2, orientation2, r15, resolvedOffer2, num2, offerEligibility2, date2, countFrom2, list5, z9, z10, z7, z6);
    }

    public final List<ComponentStyle> component1() {
        return this.children;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final BorderStyles getBorder() {
        return this.border;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final ShadowStyles getShadow() {
        return this.shadow;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final BadgeStyle getBadge() {
        return this.badge;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Orientation getScrollOrientation() {
        return this.scrollOrientation;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final Package getRcPackage() {
        return this.rcPackage;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final ResolvedOffer getResolvedOffer() {
        return this.resolvedOffer;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final Integer getTabIndex() {
        return this.tabIndex;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final OfferEligibility getOfferEligibility() {
        return this.offerEligibility;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final Date getCountdownDate() {
        return this.countdownDate;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final CountdownComponent.CountFrom getCountFrom() {
        return this.countFrom;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Dimension getDimension() {
        return this.dimension;
    }

    public final List<PresentedOverride<PresentedStackPartial>> component20() {
        return this.overrides;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final boolean getApplyTopWindowInsets() {
        return this.applyTopWindowInsets;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final boolean getIgnoreHeaderHeight() {
        return this.ignoreHeaderHeight;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final boolean getApplyBottomWindowInsets() {
        return this.applyBottomWindowInsets;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final boolean getApplyHorizontalWindowInsets() {
        return this.applyHorizontalWindowInsets;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getVisible() {
        return this.visible;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Size getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: component5-D9Ej5fM, reason: not valid java name and from getter */
    public final float getSpacing() {
        return this.spacing;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final BackgroundStyles getBackground() {
        return this.background;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final PaddingValues getPadding() {
        return this.padding;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final PaddingValues getMargin() {
        return this.margin;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Shape getShape() {
        return this.shape;
    }

    /* JADX INFO: renamed from: copy-h6c5tkY, reason: not valid java name */
    public final StackComponentStyle m4186copyh6c5tkY(List<? extends ComponentStyle> children, Dimension dimension, boolean visible, Size size, float spacing, BackgroundStyles background, PaddingValues padding, PaddingValues margin, Shape shape, BorderStyles border, ShadowStyles shadow, BadgeStyle badge, Orientation scrollOrientation, Package rcPackage, ResolvedOffer resolvedOffer, Integer tabIndex, OfferEligibility offerEligibility, Date countdownDate, CountdownComponent.CountFrom countFrom, List<PresentedOverride<PresentedStackPartial>> overrides, boolean applyTopWindowInsets, boolean ignoreHeaderHeight, boolean applyBottomWindowInsets, boolean applyHorizontalWindowInsets) {
        Intrinsics.checkNotNullParameter(children, "children");
        Intrinsics.checkNotNullParameter(dimension, "dimension");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(countFrom, "countFrom");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        return new StackComponentStyle(children, dimension, visible, size, spacing, background, padding, margin, shape, border, shadow, badge, scrollOrientation, rcPackage, resolvedOffer, tabIndex, offerEligibility, countdownDate, countFrom, overrides, applyTopWindowInsets, ignoreHeaderHeight, applyBottomWindowInsets, applyHorizontalWindowInsets, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StackComponentStyle)) {
            return false;
        }
        StackComponentStyle stackComponentStyle = (StackComponentStyle) other;
        return Intrinsics.areEqual(this.children, stackComponentStyle.children) && Intrinsics.areEqual(this.dimension, stackComponentStyle.dimension) && this.visible == stackComponentStyle.visible && Intrinsics.areEqual(this.size, stackComponentStyle.size) && Dp.m2553equalsimpl0(this.spacing, stackComponentStyle.spacing) && Intrinsics.areEqual(this.background, stackComponentStyle.background) && Intrinsics.areEqual(this.padding, stackComponentStyle.padding) && Intrinsics.areEqual(this.margin, stackComponentStyle.margin) && Intrinsics.areEqual(this.shape, stackComponentStyle.shape) && Intrinsics.areEqual(this.border, stackComponentStyle.border) && Intrinsics.areEqual(this.shadow, stackComponentStyle.shadow) && Intrinsics.areEqual(this.badge, stackComponentStyle.badge) && this.scrollOrientation == stackComponentStyle.scrollOrientation && Intrinsics.areEqual(this.rcPackage, stackComponentStyle.rcPackage) && Intrinsics.areEqual(this.resolvedOffer, stackComponentStyle.resolvedOffer) && Intrinsics.areEqual(this.tabIndex, stackComponentStyle.tabIndex) && Intrinsics.areEqual(this.offerEligibility, stackComponentStyle.offerEligibility) && Intrinsics.areEqual(this.countdownDate, stackComponentStyle.countdownDate) && this.countFrom == stackComponentStyle.countFrom && Intrinsics.areEqual(this.overrides, stackComponentStyle.overrides) && this.applyTopWindowInsets == stackComponentStyle.applyTopWindowInsets && this.ignoreHeaderHeight == stackComponentStyle.ignoreHeaderHeight && this.applyBottomWindowInsets == stackComponentStyle.applyBottomWindowInsets && this.applyHorizontalWindowInsets == stackComponentStyle.applyHorizontalWindowInsets;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.children.hashCode() * 31) + this.dimension.hashCode()) * 31) + Boolean.hashCode(this.visible)) * 31) + this.size.hashCode()) * 31) + Dp.m2554hashCodeimpl(this.spacing)) * 31;
        BackgroundStyles backgroundStyles = this.background;
        int iHashCode2 = (((((((iHashCode + (backgroundStyles == null ? 0 : backgroundStyles.hashCode())) * 31) + this.padding.hashCode()) * 31) + this.margin.hashCode()) * 31) + this.shape.hashCode()) * 31;
        BorderStyles borderStyles = this.border;
        int iHashCode3 = (iHashCode2 + (borderStyles == null ? 0 : borderStyles.hashCode())) * 31;
        ShadowStyles shadowStyles = this.shadow;
        int iHashCode4 = (iHashCode3 + (shadowStyles == null ? 0 : shadowStyles.hashCode())) * 31;
        BadgeStyle badgeStyle = this.badge;
        int iHashCode5 = (iHashCode4 + (badgeStyle == null ? 0 : badgeStyle.hashCode())) * 31;
        Orientation orientation = this.scrollOrientation;
        int iHashCode6 = (iHashCode5 + (orientation == null ? 0 : orientation.hashCode())) * 31;
        Package r1 = this.rcPackage;
        int iHashCode7 = (iHashCode6 + (r1 == null ? 0 : r1.hashCode())) * 31;
        ResolvedOffer resolvedOffer = this.resolvedOffer;
        int iHashCode8 = (iHashCode7 + (resolvedOffer == null ? 0 : resolvedOffer.hashCode())) * 31;
        Integer num = this.tabIndex;
        int iHashCode9 = (iHashCode8 + (num == null ? 0 : num.hashCode())) * 31;
        OfferEligibility offerEligibility = this.offerEligibility;
        int iHashCode10 = (iHashCode9 + (offerEligibility == null ? 0 : offerEligibility.hashCode())) * 31;
        Date date = this.countdownDate;
        return ((((((((((((iHashCode10 + (date != null ? date.hashCode() : 0)) * 31) + this.countFrom.hashCode()) * 31) + this.overrides.hashCode()) * 31) + Boolean.hashCode(this.applyTopWindowInsets)) * 31) + Boolean.hashCode(this.ignoreHeaderHeight)) * 31) + Boolean.hashCode(this.applyBottomWindowInsets)) * 31) + Boolean.hashCode(this.applyHorizontalWindowInsets);
    }

    public String toString() {
        return "StackComponentStyle(children=" + this.children + ", dimension=" + this.dimension + ", visible=" + this.visible + ", size=" + this.size + ", spacing=" + ((Object) Dp.m2555toStringimpl(this.spacing)) + ", background=" + this.background + ", padding=" + this.padding + ", margin=" + this.margin + ", shape=" + this.shape + ", border=" + this.border + ", shadow=" + this.shadow + ", badge=" + this.badge + ", scrollOrientation=" + this.scrollOrientation + ", rcPackage=" + this.rcPackage + ", resolvedOffer=" + this.resolvedOffer + ", tabIndex=" + this.tabIndex + ", offerEligibility=" + this.offerEligibility + ", countdownDate=" + this.countdownDate + ", countFrom=" + this.countFrom + ", overrides=" + this.overrides + ", applyTopWindowInsets=" + this.applyTopWindowInsets + ", ignoreHeaderHeight=" + this.ignoreHeaderHeight + ", applyBottomWindowInsets=" + this.applyBottomWindowInsets + ", applyHorizontalWindowInsets=" + this.applyHorizontalWindowInsets + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    private StackComponentStyle(List<? extends ComponentStyle> children, Dimension dimension, boolean z, Size size, float f, BackgroundStyles backgroundStyles, PaddingValues padding, PaddingValues margin, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, BadgeStyle badgeStyle, Orientation orientation, Package r17, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, Date date, CountdownComponent.CountFrom countFrom, List<PresentedOverride<PresentedStackPartial>> overrides, boolean z2, boolean z3, boolean z4, boolean z5) {
        Intrinsics.checkNotNullParameter(children, "children");
        Intrinsics.checkNotNullParameter(dimension, "dimension");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(countFrom, "countFrom");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        this.children = children;
        this.dimension = dimension;
        this.visible = z;
        this.size = size;
        this.spacing = f;
        this.background = backgroundStyles;
        this.padding = padding;
        this.margin = margin;
        this.shape = shape;
        this.border = borderStyles;
        this.shadow = shadowStyles;
        this.badge = badgeStyle;
        this.scrollOrientation = orientation;
        this.rcPackage = r17;
        this.resolvedOffer = resolvedOffer;
        this.tabIndex = num;
        this.offerEligibility = offerEligibility;
        this.countdownDate = date;
        this.countFrom = countFrom;
        this.overrides = overrides;
        this.applyTopWindowInsets = z2;
        this.ignoreHeaderHeight = z3;
        this.applyBottomWindowInsets = z4;
        this.applyHorizontalWindowInsets = z5;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ boolean computeIsSelected(PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo, int i) {
        return PackageContext.DefaultImpls.computeIsSelected(this, selectedPackageInfo, i);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public String getPackageUniqueId() {
        return PackageContext.DefaultImpls.getPackageUniqueId(this);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ OfferEligibility resolveOfferEligibility(OfferEligibility offerEligibility) {
        return PackageContext.DefaultImpls.resolveOfferEligibility(this, offerEligibility);
    }

    public /* synthetic */ StackComponentStyle(List list, Dimension dimension, boolean z, Size size, float f, BackgroundStyles backgroundStyles, PaddingValues paddingValues, PaddingValues paddingValues2, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, BadgeStyle badgeStyle, Orientation orientation, Package r43, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, Date date, CountdownComponent.CountFrom countFrom, List list2, boolean z2, boolean z3, boolean z4, boolean z5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, dimension, z, size, f, backgroundStyles, paddingValues, paddingValues2, shape, borderStyles, shadowStyles, badgeStyle, orientation, r43, (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? null : resolvedOffer, num, (65536 & i) != 0 ? null : offerEligibility, date, countFrom, list2, (1048576 & i) != 0 ? false : z2, (2097152 & i) != 0 ? false : z3, (4194304 & i) != 0 ? false : z4, (i & 8388608) != 0 ? false : z5, null);
    }

    public final /* synthetic */ List getChildren() {
        return this.children;
    }

    public final /* synthetic */ Dimension getDimension() {
        return this.dimension;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public /* synthetic */ boolean getVisible() {
        return this.visible;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public /* synthetic */ Size getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: getSpacing-D9Ej5fM, reason: not valid java name */
    public final /* synthetic */ float m4187getSpacingD9Ej5fM() {
        return this.spacing;
    }

    public final /* synthetic */ BackgroundStyles getBackground() {
        return this.background;
    }

    public final /* synthetic */ PaddingValues getPadding() {
        return this.padding;
    }

    public final /* synthetic */ PaddingValues getMargin() {
        return this.margin;
    }

    public final /* synthetic */ Shape getShape() {
        return this.shape;
    }

    public final /* synthetic */ BorderStyles getBorder() {
        return this.border;
    }

    public final /* synthetic */ ShadowStyles getShadow() {
        return this.shadow;
    }

    public final /* synthetic */ BadgeStyle getBadge() {
        return this.badge;
    }

    public final /* synthetic */ Orientation getScrollOrientation() {
        return this.scrollOrientation;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ Package getRcPackage() {
        return this.rcPackage;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ ResolvedOffer getResolvedOffer() {
        return this.resolvedOffer;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ Integer getTabIndex() {
        return this.tabIndex;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ OfferEligibility getOfferEligibility() {
        return this.offerEligibility;
    }

    public final /* synthetic */ Date getCountdownDate() {
        return this.countdownDate;
    }

    public final /* synthetic */ CountdownComponent.CountFrom getCountFrom() {
        return this.countFrom;
    }

    public final /* synthetic */ List getOverrides() {
        return this.overrides;
    }

    public final /* synthetic */ boolean getApplyTopWindowInsets() {
        return this.applyTopWindowInsets;
    }

    public final /* synthetic */ boolean getIgnoreHeaderHeight() {
        return this.ignoreHeaderHeight;
    }

    public final /* synthetic */ boolean getApplyBottomWindowInsets() {
        return this.applyBottomWindowInsets;
    }

    public final /* synthetic */ boolean getApplyHorizontalWindowInsets() {
        return this.applyHorizontalWindowInsets;
    }
}
