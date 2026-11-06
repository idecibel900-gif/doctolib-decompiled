package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\"\u0010\n\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u0003HÂ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J-\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006#"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/composables/Fade;", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/PlaceholderHighlight;", "highlightColor", "Landroidx/compose/ui/graphics/Color;", "animationSpec", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "", "(JLandroidx/compose/animation/core/InfiniteRepeatableSpec;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAnimationSpec", "()Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "brush", "Landroidx/compose/ui/graphics/SolidColor;", "J", "alpha", ReactProgressBarViewManager.PROP_PROGRESS, "Landroidx/compose/ui/graphics/Brush;", "size", "Landroidx/compose/ui/geometry/Size;", "brush-d16Qtg0", "(FJ)Landroidx/compose/ui/graphics/Brush;", "component1", "component1-0d7_KjU", "()J", "component2", "copy", "copy-DxMtmZc", "(JLandroidx/compose/animation/core/InfiniteRepeatableSpec;)Lcom/revenuecat/purchases/ui/revenuecatui/composables/Fade;", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class Fade implements PlaceholderHighlight {
    public static final int $stable = InfiniteRepeatableSpec.$stable;
    private final InfiniteRepeatableSpec animationSpec;
    private final SolidColor brush;
    private final long highlightColor;

    public /* synthetic */ Fade(long j, InfiniteRepeatableSpec infiniteRepeatableSpec, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, infiniteRepeatableSpec);
    }

    /* JADX INFO: renamed from: component1-0d7_KjU, reason: not valid java name and from getter */
    private final long getHighlightColor() {
        return this.highlightColor;
    }

    /* JADX INFO: renamed from: copy-DxMtmZc$default, reason: not valid java name */
    public static /* synthetic */ Fade m4234copyDxMtmZc$default(Fade fade, long j, InfiniteRepeatableSpec infiniteRepeatableSpec, int i, Object obj) {
        if ((i & 1) != 0) {
            j = fade.highlightColor;
        }
        if ((i & 2) != 0) {
            infiniteRepeatableSpec = fade.animationSpec;
        }
        return fade.m4236copyDxMtmZc(j, infiniteRepeatableSpec);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.composables.PlaceholderHighlight
    public float alpha(float progress) {
        return progress;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final InfiniteRepeatableSpec getAnimationSpec() {
        return this.animationSpec;
    }

    /* JADX INFO: renamed from: copy-DxMtmZc, reason: not valid java name */
    public final Fade m4236copyDxMtmZc(long highlightColor, InfiniteRepeatableSpec animationSpec) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        return new Fade(highlightColor, animationSpec, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Fade)) {
            return false;
        }
        Fade fade = (Fade) other;
        return Color.m1367equalsimpl0(this.highlightColor, fade.highlightColor) && Intrinsics.areEqual(this.animationSpec, fade.animationSpec);
    }

    public int hashCode() {
        return (Color.m1373hashCodeimpl(this.highlightColor) * 31) + this.animationSpec.hashCode();
    }

    public String toString() {
        return "Fade(highlightColor=" + ((Object) Color.m1374toStringimpl(this.highlightColor)) + ", animationSpec=" + this.animationSpec + ')';
    }

    private Fade(long j, InfiniteRepeatableSpec animationSpec) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        this.highlightColor = j;
        this.animationSpec = animationSpec;
        this.brush = new SolidColor(j, null);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.composables.PlaceholderHighlight
    public InfiniteRepeatableSpec getAnimationSpec() {
        return this.animationSpec;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.composables.PlaceholderHighlight
    /* JADX INFO: renamed from: brush-d16Qtg0, reason: not valid java name */
    public Brush mo4235brushd16Qtg0(float progress, long size) {
        return this.brush;
    }
}
