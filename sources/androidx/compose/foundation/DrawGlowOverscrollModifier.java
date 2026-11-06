package androidx.compose.foundation;

import android.graphics.Canvas;
import android.widget.EdgeEffect;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.platform.InspectorValueInfo;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes.dex */
final class DrawGlowOverscrollModifier extends InspectorValueInfo implements DrawModifier {
    private final EdgeEffectWrapper edgeEffectWrapper;
    private final OverscrollConfiguration overscrollConfig;
    private final AndroidEdgeEffectOverscrollEffect overscrollEffect;

    public DrawGlowOverscrollModifier(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, EdgeEffectWrapper edgeEffectWrapper, OverscrollConfiguration overscrollConfiguration, Function1 function1) {
        super(function1);
        this.overscrollEffect = androidEdgeEffectOverscrollEffect;
        this.edgeEffectWrapper = edgeEffectWrapper;
        this.overscrollConfig = overscrollConfiguration;
    }

    @Override // androidx.compose.ui.draw.DrawModifier
    public void draw(ContentDrawScope contentDrawScope) {
        this.overscrollEffect.m114updateSizeuvyYCjk$foundation_release(contentDrawScope.mo1599getSizeNHjbRc());
        if (Size.m1263isEmptyimpl(contentDrawScope.mo1599getSizeNHjbRc())) {
            contentDrawScope.drawContent();
            return;
        }
        contentDrawScope.drawContent();
        this.overscrollEffect.getRedrawSignal$foundation_release().getValue();
        Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(contentDrawScope.getDrawContext().getCanvas());
        EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        boolean zDrawLeftGlow = edgeEffectWrapper.isLeftAnimating() ? drawLeftGlow(contentDrawScope, edgeEffectWrapper.getOrCreateLeftEffect(), nativeCanvas) : false;
        if (edgeEffectWrapper.isTopAnimating()) {
            zDrawLeftGlow = drawTopGlow(contentDrawScope, edgeEffectWrapper.getOrCreateTopEffect(), nativeCanvas) || zDrawLeftGlow;
        }
        if (edgeEffectWrapper.isRightAnimating()) {
            zDrawLeftGlow = drawRightGlow(contentDrawScope, edgeEffectWrapper.getOrCreateRightEffect(), nativeCanvas) || zDrawLeftGlow;
        }
        if (edgeEffectWrapper.isBottomAnimating()) {
            zDrawLeftGlow = drawBottomGlow(contentDrawScope, edgeEffectWrapper.getOrCreateBottomEffect(), nativeCanvas) || zDrawLeftGlow;
        }
        if (zDrawLeftGlow) {
            this.overscrollEffect.invalidateOverscroll$foundation_release();
        }
    }

    private final boolean drawLeftGlow(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        return m151drawWithRotationAndOffsetubNVwUQ(270.0f, OffsetKt.Offset(-Size.m1259getHeightimpl(drawScope.mo1599getSizeNHjbRc()), drawScope.mo231toPx0680j_4(this.overscrollConfig.getDrawPadding().mo295calculateLeftPaddingu2uoSUM(drawScope.getLayoutDirection()))), edgeEffect, canvas);
    }

    private final boolean drawTopGlow(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        return m151drawWithRotationAndOffsetubNVwUQ(0.0f, OffsetKt.Offset(0.0f, drawScope.mo231toPx0680j_4(this.overscrollConfig.getDrawPadding().mo297calculateTopPaddingD9Ej5fM())), edgeEffect, canvas);
    }

    private final boolean drawRightGlow(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        return m151drawWithRotationAndOffsetubNVwUQ(90.0f, OffsetKt.Offset(0.0f, (-MathKt.roundToInt(Size.m1261getWidthimpl(drawScope.mo1599getSizeNHjbRc()))) + drawScope.mo231toPx0680j_4(this.overscrollConfig.getDrawPadding().mo296calculateRightPaddingu2uoSUM(drawScope.getLayoutDirection()))), edgeEffect, canvas);
    }

    private final boolean drawBottomGlow(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        return m151drawWithRotationAndOffsetubNVwUQ(180.0f, OffsetKt.Offset(-Size.m1261getWidthimpl(drawScope.mo1599getSizeNHjbRc()), (-Size.m1259getHeightimpl(drawScope.mo1599getSizeNHjbRc())) + drawScope.mo231toPx0680j_4(this.overscrollConfig.getDrawPadding().mo294calculateBottomPaddingD9Ej5fM())), edgeEffect, canvas);
    }

    /* JADX INFO: renamed from: drawWithRotationAndOffset-ubNVwUQ, reason: not valid java name */
    private final boolean m151drawWithRotationAndOffsetubNVwUQ(float f, long j, EdgeEffect edgeEffect, Canvas canvas) {
        int iSave = canvas.save();
        canvas.rotate(f);
        canvas.translate(Offset.m1223getXimpl(j), Offset.m1224getYimpl(j));
        boolean zDraw = edgeEffect.draw(canvas);
        canvas.restoreToCount(iSave);
        return zDraw;
    }
}
