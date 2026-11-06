package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public abstract class BorderKt {
    public static final Modifier border(Modifier modifier, BorderStroke borderStroke, Shape shape) {
        return m123borderziNgDLE(modifier, borderStroke.m130getWidthD9Ej5fM(), borderStroke.getBrush(), shape);
    }

    /* JADX INFO: renamed from: border-xT4_qwU$default, reason: not valid java name */
    public static /* synthetic */ Modifier m122borderxT4_qwU$default(Modifier modifier, float f, long j, Shape shape, int i, Object obj) {
        if ((i & 4) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        return m121borderxT4_qwU(modifier, f, j, shape);
    }

    /* JADX INFO: renamed from: border-xT4_qwU, reason: not valid java name */
    public static final Modifier m121borderxT4_qwU(Modifier modifier, float f, long j, Shape shape) {
        return m123borderziNgDLE(modifier, f, new SolidColor(j, null), shape);
    }

    /* JADX INFO: renamed from: border-ziNgDLE, reason: not valid java name */
    public static final Modifier m123borderziNgDLE(Modifier modifier, float f, Brush brush, Shape shape) {
        return modifier.then(new BorderModifierNodeElement(f, brush, shape, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawResult drawContentWithoutBorder(CacheDrawScope cacheDrawScope) {
        return cacheDrawScope.onDrawWithContent(new Function1() { // from class: androidx.compose.foundation.BorderKt.drawContentWithoutBorder.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContentDrawScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ContentDrawScope contentDrawScope) {
                contentDrawScope.drawContent();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawRectBorder-NsqcLGU, reason: not valid java name */
    public static final DrawResult m124drawRectBorderNsqcLGU(CacheDrawScope cacheDrawScope, final Brush brush, long j, long j2, boolean z, float f) {
        final long jM1235getZeroF1C5BW0 = z ? Offset.Companion.m1235getZeroF1C5BW0() : j;
        final long jM1141getSizeNHjbRc = z ? cacheDrawScope.m1141getSizeNHjbRc() : j2;
        final DrawStyle stroke = z ? Fill.INSTANCE : new Stroke(f, 0.0f, 0, 0, null, 30, null);
        return cacheDrawScope.onDrawWithContent(new Function1() { // from class: androidx.compose.foundation.BorderKt$drawRectBorder$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContentDrawScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ContentDrawScope contentDrawScope) {
                contentDrawScope.drawContent();
                DrawScope.m1594drawRectAsUm42w$default(contentDrawScope, brush, jM1235getZeroF1C5BW0, jM1141getSizeNHjbRc, 0.0f, stroke, null, 0, 104, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Path createRoundRectPath(Path path, RoundRect roundRect, float f, boolean z) {
        path.reset();
        Path.addRoundRect$default(path, roundRect, null, 2, null);
        if (!z) {
            Path Path = AndroidPath_androidKt.Path();
            Path.addRoundRect$default(Path, createInsetRoundedRect(f, roundRect), null, 2, null);
            path.mo1305opN5in7k0(path, Path, PathOperation.Companion.m1471getDifferenceb3I0S0c());
        }
        return path;
    }

    private static final RoundRect createInsetRoundedRect(float f, RoundRect roundRect) {
        return new RoundRect(f, f, roundRect.getWidth() - f, roundRect.getHeight() - f, m125shrinkKibmq7A(roundRect.m1250getTopLeftCornerRadiuskKHJgLs(), f), m125shrinkKibmq7A(roundRect.m1251getTopRightCornerRadiuskKHJgLs(), f), m125shrinkKibmq7A(roundRect.m1249getBottomRightCornerRadiuskKHJgLs(), f), m125shrinkKibmq7A(roundRect.m1248getBottomLeftCornerRadiuskKHJgLs(), f), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: shrink-Kibmq7A, reason: not valid java name */
    public static final long m125shrinkKibmq7A(long j, float f) {
        return CornerRadiusKt.CornerRadius(Math.max(0.0f, CornerRadius.m1209getXimpl(j) - f), Math.max(0.0f, CornerRadius.m1210getYimpl(j) - f));
    }
}
