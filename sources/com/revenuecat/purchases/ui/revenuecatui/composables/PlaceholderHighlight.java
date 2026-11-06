package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.ui.graphics.Brush;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H'J$\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\b\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH&ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000f"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/composables/PlaceholderHighlight;", "", "animationSpec", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "", "getAnimationSpec", "()Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "alpha", ReactProgressBarViewManager.PROP_PROGRESS, "brush", "Landroidx/compose/ui/graphics/Brush;", "size", "Landroidx/compose/ui/geometry/Size;", "brush-d16Qtg0", "(FJ)Landroidx/compose/ui/graphics/Brush;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PlaceholderHighlight {
    float alpha(float progress);

    /* JADX INFO: renamed from: brush-d16Qtg0 */
    Brush mo4235brushd16Qtg0(float progress, long size);

    InfiniteRepeatableSpec getAnimationSpec();
}
