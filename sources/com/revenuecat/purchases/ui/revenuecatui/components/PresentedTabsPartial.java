package com.revenuecat.purchases.ui.revenuecatui.components;

import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.paywalls.components.PartialTabsComponent;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyList;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyListKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Result;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u0013\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0000H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedTabsPartial;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedPartial;", "backgroundStyles", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;", "borderStyles", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;", "shadowStyles", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;", "partial", "Lcom/revenuecat/purchases/paywalls/components/PartialTabsComponent;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;Lcom/revenuecat/purchases/paywalls/components/PartialTabsComponent;)V", "getBackgroundStyles", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;", "getBorderStyles", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;", "getPartial", "()Lcom/revenuecat/purchases/paywalls/components/PartialTabsComponent;", "getShadowStyles", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;", "combine", "with", "Companion", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PresentedTabsPartial implements PresentedPartial<PresentedTabsPartial> {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final BackgroundStyles backgroundStyles;
    private final BorderStyles borderStyles;
    private final PartialTabsComponent partial;
    private final ShadowStyles shadowStyles;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PresentedTabsPartial)) {
            return false;
        }
        PresentedTabsPartial presentedTabsPartial = (PresentedTabsPartial) obj;
        return Intrinsics.areEqual(this.backgroundStyles, presentedTabsPartial.backgroundStyles) && Intrinsics.areEqual(this.borderStyles, presentedTabsPartial.borderStyles) && Intrinsics.areEqual(this.shadowStyles, presentedTabsPartial.shadowStyles) && Intrinsics.areEqual(this.partial, presentedTabsPartial.partial);
    }

    public int hashCode() {
        BackgroundStyles backgroundStyles = this.backgroundStyles;
        int iHashCode = (backgroundStyles == null ? 0 : backgroundStyles.hashCode()) * 31;
        BorderStyles borderStyles = this.borderStyles;
        int iHashCode2 = (iHashCode + (borderStyles == null ? 0 : borderStyles.hashCode())) * 31;
        ShadowStyles shadowStyles = this.shadowStyles;
        return ((iHashCode2 + (shadowStyles != null ? shadowStyles.hashCode() : 0)) * 31) + this.partial.hashCode();
    }

    public String toString() {
        return "PresentedTabsPartial(backgroundStyles=" + this.backgroundStyles + ", borderStyles=" + this.borderStyles + ", shadowStyles=" + this.shadowStyles + ", partial=" + this.partial + ')';
    }

    public PresentedTabsPartial(BackgroundStyles backgroundStyles, BorderStyles borderStyles, ShadowStyles shadowStyles, PartialTabsComponent partial) {
        Intrinsics.checkNotNullParameter(partial, "partial");
        this.backgroundStyles = backgroundStyles;
        this.borderStyles = borderStyles;
        this.shadowStyles = shadowStyles;
        this.partial = partial;
    }

    public final /* synthetic */ BackgroundStyles getBackgroundStyles() {
        return this.backgroundStyles;
    }

    public final /* synthetic */ BorderStyles getBorderStyles() {
        return this.borderStyles;
    }

    public final /* synthetic */ ShadowStyles getShadowStyles() {
        return this.shadowStyles;
    }

    public final /* synthetic */ PartialTabsComponent getPartial() {
        return this.partial;
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J7\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00042\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0086\u0002¨\u0006\u000e"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedTabsPartial$Companion;", "", "()V", "invoke", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/Result;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedTabsPartial;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyList;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", Constants.MessagePayloadKeys.FROM, "Lcom/revenuecat/purchases/paywalls/components/PartialTabsComponent;", "aliases", "", "Lcom/revenuecat/purchases/ColorAlias;", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final /* synthetic */ Result invoke(PartialTabsComponent from, Map aliases) {
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(aliases, "aliases");
            Background background = from.getBackground();
            BackgroundStyles backgroundStylesM4104boximpl = null;
            Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(background != null ? BackgroundStyleKt.toBackgroundStyles(background, aliases) : null);
            ColorScheme backgroundColor = from.getBackgroundColor();
            Result resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull(backgroundColor != null ? ColorStyleKt.toColorStyles(backgroundColor, aliases) : null);
            Border border = from.getBorder();
            Result resultOrSuccessfullyNull3 = ResultKt.orSuccessfullyNull(border != null ? BorderStyleKt.toBorderStyles(border, aliases) : null);
            Shadow shadow = from.getShadow();
            Result resultOrSuccessfullyNull4 = ResultKt.orSuccessfullyNull(shadow != null ? ShadowStyleKt.toShadowStyles(shadow, aliases) : null);
            Unit unit = Unit.INSTANCE;
            Result.Success success = new Result.Success(unit);
            Result.Success success2 = new Result.Success(unit);
            NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{resultOrSuccessfullyNull, resultOrSuccessfullyNull2, resultOrSuccessfullyNull3, resultOrSuccessfullyNull4, success, success2})));
            if (nonEmptyListOrNull != null) {
                return new Result.Error(nonEmptyListOrNull);
            }
            Intrinsics.checkNotNull(resultOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
            Object value = ((Result.Success) resultOrSuccessfullyNull).getValue();
            Intrinsics.checkNotNull(resultOrSuccessfullyNull2, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
            Object value2 = ((Result.Success) resultOrSuccessfullyNull2).getValue();
            Intrinsics.checkNotNull(resultOrSuccessfullyNull3, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<C of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
            Object value3 = ((Result.Success) resultOrSuccessfullyNull3).getValue();
            Intrinsics.checkNotNull(resultOrSuccessfullyNull4, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<D of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
            Object value4 = ((Result.Success) resultOrSuccessfullyNull4).getValue();
            Object value5 = success.getValue();
            ShadowStyles shadowStyles = (ShadowStyles) value4;
            BorderStyles borderStyles = (BorderStyles) value3;
            ColorStyles colorStyles = (ColorStyles) value2;
            BackgroundStyles backgroundStyles = (BackgroundStyles) value;
            if (backgroundStyles == null) {
                ColorStyles colorStylesM4105constructorimpl = colorStyles != null ? BackgroundStyles.Color.m4105constructorimpl(colorStyles) : null;
                if (colorStylesM4105constructorimpl != null) {
                    backgroundStylesM4104boximpl = BackgroundStyles.Color.m4104boximpl(colorStylesM4105constructorimpl);
                }
            } else {
                backgroundStylesM4104boximpl = backgroundStyles;
            }
            return new Result.Success(new PresentedTabsPartial(backgroundStylesM4104boximpl, borderStyles, shadowStyles, from));
        }
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.PresentedPartial
    public PresentedTabsPartial combine(PresentedTabsPartial with) {
        BackgroundStyles backgroundStyles;
        BorderStyles borderStyles;
        ShadowStyles shadowStyles;
        Boolean visible;
        Size size;
        Padding padding;
        Padding margin;
        ColorScheme backgroundColor;
        Background background;
        Shape shape;
        Border border;
        Shadow shadow;
        PartialTabsComponent partialTabsComponent = with != null ? with.partial : null;
        if (with == null || (backgroundStyles = with.backgroundStyles) == null) {
            backgroundStyles = this.backgroundStyles;
        }
        if (with == null || (borderStyles = with.borderStyles) == null) {
            borderStyles = this.borderStyles;
        }
        if (with == null || (shadowStyles = with.shadowStyles) == null) {
            shadowStyles = this.shadowStyles;
        }
        if (partialTabsComponent == null || (visible = partialTabsComponent.getVisible()) == null) {
            visible = this.partial.getVisible();
        }
        if (partialTabsComponent == null || (size = partialTabsComponent.getSize()) == null) {
            size = this.partial.getSize();
        }
        if (partialTabsComponent == null || (padding = partialTabsComponent.getPadding()) == null) {
            padding = this.partial.getPadding();
        }
        if (partialTabsComponent == null || (margin = partialTabsComponent.getMargin()) == null) {
            margin = this.partial.getMargin();
        }
        if (partialTabsComponent == null || (backgroundColor = partialTabsComponent.getBackgroundColor()) == null) {
            backgroundColor = this.partial.getBackgroundColor();
        }
        if (partialTabsComponent == null || (background = partialTabsComponent.getBackground()) == null) {
            background = this.partial.getBackground();
        }
        if (partialTabsComponent == null || (shape = partialTabsComponent.getShape()) == null) {
            shape = this.partial.getShape();
        }
        if (partialTabsComponent == null || (border = partialTabsComponent.getBorder()) == null) {
            border = this.partial.getBorder();
        }
        if (partialTabsComponent == null || (shadow = partialTabsComponent.getShadow()) == null) {
            shadow = this.partial.getShadow();
        }
        return new PresentedTabsPartial(backgroundStyles, borderStyles, shadowStyles, new PartialTabsComponent(visible, size, padding, margin, backgroundColor, background, shape, border, shadow));
    }
}
