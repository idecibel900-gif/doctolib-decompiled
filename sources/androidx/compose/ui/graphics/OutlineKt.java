package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes.dex */
public abstract class OutlineKt {
    public static final void addOutline(Path path, Outline outline) {
        if (outline instanceof Outline.Rectangle) {
            Path.addRect$default(path, ((Outline.Rectangle) outline).getRect(), null, 2, null);
        } else if (outline instanceof Outline.Rounded) {
            Path.addRoundRect$default(path, ((Outline.Rounded) outline).getRoundRect(), null, 2, null);
        } else {
            if (!(outline instanceof Outline.Generic)) {
                throw new NoWhenBranchMatchedException();
            }
            Path.m1463addPathUv8p0NA$default(path, ((Outline.Generic) outline).getPath(), 0L, 2, null);
        }
    }

    /* JADX INFO: renamed from: drawOutline-wDX37Ww$default, reason: not valid java name */
    public static /* synthetic */ void m1458drawOutlinewDX37Ww$default(DrawScope drawScope, Outline outline, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            f = 1.0f;
        }
        float f2 = f;
        if ((i2 & 8) != 0) {
            drawStyle = Fill.INSTANCE;
        }
        DrawStyle drawStyle2 = drawStyle;
        if ((i2 & 16) != 0) {
            colorFilter = null;
        }
        m1457drawOutlinewDX37Ww(drawScope, outline, j, f2, drawStyle2, colorFilter, (i2 & 32) != 0 ? DrawScope.Companion.m1600getDefaultBlendMode0nO6VwU() : i);
    }

    /* JADX INFO: renamed from: drawOutline-hn5TExg$default, reason: not valid java name */
    public static /* synthetic */ void m1456drawOutlinehn5TExg$default(DrawScope drawScope, Outline outline, Brush brush, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            f = 1.0f;
        }
        float f2 = f;
        if ((i2 & 8) != 0) {
            drawStyle = Fill.INSTANCE;
        }
        DrawStyle drawStyle2 = drawStyle;
        if ((i2 & 16) != 0) {
            colorFilter = null;
        }
        ColorFilter colorFilter2 = colorFilter;
        if ((i2 & 32) != 0) {
            i = DrawScope.Companion.m1600getDefaultBlendMode0nO6VwU();
        }
        m1455drawOutlinehn5TExg(drawScope, outline, brush, f2, drawStyle2, colorFilter2, i);
    }

    private static final long topLeft(Rect rect) {
        return OffsetKt.Offset(rect.getLeft(), rect.getTop());
    }

    private static final long size(Rect rect) {
        return SizeKt.Size(rect.getWidth(), rect.getHeight());
    }

    private static final long topLeft(RoundRect roundRect) {
        return OffsetKt.Offset(roundRect.getLeft(), roundRect.getTop());
    }

    private static final long size(RoundRect roundRect) {
        return SizeKt.Size(roundRect.getWidth(), roundRect.getHeight());
    }

    /* JADX INFO: renamed from: drawOutline-hn5TExg, reason: not valid java name */
    public static final void m1455drawOutlinehn5TExg(DrawScope drawScope, Outline outline, Brush brush, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        if (outline instanceof Outline.Rectangle) {
            Rect rect = ((Outline.Rectangle) outline).getRect();
            drawScope.mo1572drawRectAsUm42w(brush, topLeft(rect), size(rect), f, drawStyle, colorFilter, i);
            return;
        }
        if (outline instanceof Outline.Rounded) {
            Outline.Rounded rounded = (Outline.Rounded) outline;
            Path roundRectPath$ui_graphics_release = rounded.getRoundRectPath$ui_graphics_release();
            if (roundRectPath$ui_graphics_release != null) {
                drawScope.mo1570drawPathGBMwjPU(roundRectPath$ui_graphics_release, brush, f, drawStyle, colorFilter, i);
                return;
            }
            RoundRect roundRect = rounded.getRoundRect();
            drawScope.mo1574drawRoundRectZuiqVtQ(brush, topLeft(roundRect), size(roundRect), CornerRadiusKt.CornerRadius$default(CornerRadius.m1209getXimpl(roundRect.m1248getBottomLeftCornerRadiuskKHJgLs()), 0.0f, 2, null), f, drawStyle, colorFilter, i);
            return;
        }
        if (outline instanceof Outline.Generic) {
            drawScope.mo1570drawPathGBMwjPU(((Outline.Generic) outline).getPath(), brush, f, drawStyle, colorFilter, i);
            return;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: drawOutline-wDX37Ww, reason: not valid java name */
    public static final void m1457drawOutlinewDX37Ww(DrawScope drawScope, Outline outline, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        if (outline instanceof Outline.Rectangle) {
            Rect rect = ((Outline.Rectangle) outline).getRect();
            drawScope.mo1573drawRectnJ9OG0(j, topLeft(rect), size(rect), f, drawStyle, colorFilter, i);
            return;
        }
        if (outline instanceof Outline.Rounded) {
            Outline.Rounded rounded = (Outline.Rounded) outline;
            Path roundRectPath$ui_graphics_release = rounded.getRoundRectPath$ui_graphics_release();
            if (roundRectPath$ui_graphics_release != null) {
                drawScope.mo1571drawPathLG529CI(roundRectPath$ui_graphics_release, j, f, drawStyle, colorFilter, i);
                return;
            }
            RoundRect roundRect = rounded.getRoundRect();
            drawScope.mo1575drawRoundRectuAw5IA(j, topLeft(roundRect), size(roundRect), CornerRadiusKt.CornerRadius$default(CornerRadius.m1209getXimpl(roundRect.m1248getBottomLeftCornerRadiuskKHJgLs()), 0.0f, 2, null), drawStyle, f, colorFilter, i);
            return;
        }
        if (outline instanceof Outline.Generic) {
            drawScope.mo1571drawPathLG529CI(((Outline.Generic) outline).getPath(), j, f, drawStyle, colorFilter, i);
            return;
        }
        throw new NoWhenBranchMatchedException();
    }
}
