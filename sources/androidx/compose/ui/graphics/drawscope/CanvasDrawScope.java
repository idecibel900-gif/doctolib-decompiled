package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class CanvasDrawScope implements DrawScope {
    private Paint fillPaint;
    private Paint strokePaint;
    private final DrawParams drawParams = new DrawParams(null, null, null, 0, 15, null);
    private final DrawContext drawContext = new DrawContext() { // from class: androidx.compose.ui.graphics.drawscope.CanvasDrawScope$drawContext$1
        private GraphicsLayer graphicsLayer;
        private final DrawTransform transform = CanvasDrawScopeKt.asDrawTransform(this);

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        public Canvas getCanvas() {
            return this.this$0.getDrawParams().getCanvas();
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        public void setCanvas(Canvas canvas) {
            this.this$0.getDrawParams().setCanvas(canvas);
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
        public long mo1579getSizeNHjbRc() {
            return this.this$0.getDrawParams().m1577getSizeNHjbRc();
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        /* JADX INFO: renamed from: setSize-uvyYCjk, reason: not valid java name */
        public void mo1580setSizeuvyYCjk(long j) {
            this.this$0.getDrawParams().m1578setSizeuvyYCjk(j);
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        public DrawTransform getTransform() {
            return this.transform;
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        public LayoutDirection getLayoutDirection() {
            return this.this$0.getDrawParams().getLayoutDirection();
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        public void setLayoutDirection(LayoutDirection layoutDirection) {
            this.this$0.getDrawParams().setLayoutDirection(layoutDirection);
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        public Density getDensity() {
            return this.this$0.getDrawParams().getDensity();
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        public void setDensity(Density density) {
            this.this$0.getDrawParams().setDensity(density);
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        public GraphicsLayer getGraphicsLayer() {
            return this.graphicsLayer;
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        public void setGraphicsLayer(GraphicsLayer graphicsLayer) {
            this.graphicsLayer = graphicsLayer;
        }
    };

    public final DrawParams getDrawParams() {
        return this.drawParams;
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public LayoutDirection getLayoutDirection() {
        return this.drawParams.getLayoutDirection();
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.drawParams.getDensity().getDensity();
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float getFontScale() {
        return this.drawParams.getDensity().getFontScale();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public DrawContext getDrawContext() {
        return this.drawContext;
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawLine-1RTmtNc, reason: not valid java name */
    public void mo1568drawLine1RTmtNc(Brush brush, long j, long j2, float f, int i, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i2) {
        this.drawParams.getCanvas().mo1278drawLineWko1d7g(j, j2, m1562configureStrokePaintho4zsrM$default(this, brush, f, 4.0f, i, StrokeJoin.Companion.m1508getMiterLxFBmk8(), pathEffect, f2, colorFilter, i2, 0, IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawLine-NGM6Ib0, reason: not valid java name */
    public void mo1569drawLineNGM6Ib0(long j, long j2, long j3, float f, int i, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i2) {
        this.drawParams.getCanvas().mo1278drawLineWko1d7g(j2, j3, m1560configureStrokePaintQ_0CZUI$default(this, j, f, 4.0f, i, StrokeJoin.Companion.m1508getMiterLxFBmk8(), pathEffect, f2, colorFilter, i2, 0, IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRect-AsUm42w, reason: not valid java name */
    public void mo1572drawRectAsUm42w(Brush brush, long j, long j2, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.drawParams.getCanvas().drawRect(Offset.m1223getXimpl(j), Offset.m1224getYimpl(j), Offset.m1223getXimpl(j) + Size.m1261getWidthimpl(j2), Offset.m1224getYimpl(j) + Size.m1259getHeightimpl(j2), m1558configurePaintswdJneE$default(this, brush, drawStyle, f, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRect-n-J9OG0, reason: not valid java name */
    public void mo1573drawRectnJ9OG0(long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.drawParams.getCanvas().drawRect(Offset.m1223getXimpl(j2), Offset.m1224getYimpl(j2), Offset.m1223getXimpl(j2) + Size.m1261getWidthimpl(j3), Offset.m1224getYimpl(j2) + Size.m1259getHeightimpl(j3), m1556configurePaint2qPWKa0$default(this, j, drawStyle, f, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawImage-gbVJVH8, reason: not valid java name */
    public void mo1567drawImagegbVJVH8(ImageBitmap imageBitmap, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.drawParams.getCanvas().mo1276drawImaged4ec7I(imageBitmap, j, m1558configurePaintswdJneE$default(this, null, drawStyle, f, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawImage-AZ2fEMs, reason: not valid java name */
    public void mo1566drawImageAZ2fEMs(ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2) {
        this.drawParams.getCanvas().mo1277drawImageRectHPBpro0(imageBitmap, j, j2, j3, j4, m1557configurePaintswdJneE(null, drawStyle, f, colorFilter, i, i2));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRoundRect-ZuiqVtQ, reason: not valid java name */
    public void mo1574drawRoundRectZuiqVtQ(Brush brush, long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.drawParams.getCanvas().drawRoundRect(Offset.m1223getXimpl(j), Offset.m1224getYimpl(j), Offset.m1223getXimpl(j) + Size.m1261getWidthimpl(j2), Offset.m1224getYimpl(j) + Size.m1259getHeightimpl(j2), CornerRadius.m1209getXimpl(j3), CornerRadius.m1210getYimpl(j3), m1558configurePaintswdJneE$default(this, brush, drawStyle, f, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRoundRect-u-Aw5IA, reason: not valid java name */
    public void mo1575drawRoundRectuAw5IA(long j, long j2, long j3, long j4, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i) {
        this.drawParams.getCanvas().drawRoundRect(Offset.m1223getXimpl(j2), Offset.m1224getYimpl(j2), Offset.m1223getXimpl(j2) + Size.m1261getWidthimpl(j3), Offset.m1224getYimpl(j2) + Size.m1259getHeightimpl(j3), CornerRadius.m1209getXimpl(j4), CornerRadius.m1210getYimpl(j4), m1556configurePaint2qPWKa0$default(this, j, drawStyle, f, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawCircle-VaOC9Bg, reason: not valid java name */
    public void mo1565drawCircleVaOC9Bg(long j, float f, long j2, float f2, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.drawParams.getCanvas().mo1275drawCircle9KIMszo(j2, f, m1556configurePaint2qPWKa0$default(this, j, drawStyle, f2, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawArc-yD3GUKo, reason: not valid java name */
    public void mo1564drawArcyD3GUKo(long j, float f, float f2, boolean z, long j2, long j3, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.drawParams.getCanvas().drawArc(Offset.m1223getXimpl(j2), Offset.m1224getYimpl(j2), Offset.m1223getXimpl(j2) + Size.m1261getWidthimpl(j3), Offset.m1224getYimpl(j2) + Size.m1259getHeightimpl(j3), f, f2, z, m1556configurePaint2qPWKa0$default(this, j, drawStyle, f3, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPath-LG529CI, reason: not valid java name */
    public void mo1571drawPathLG529CI(Path path, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.drawParams.getCanvas().drawPath(path, m1556configurePaint2qPWKa0$default(this, j, drawStyle, f, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPath-GBMwjPU, reason: not valid java name */
    public void mo1570drawPathGBMwjPU(Path path, Brush brush, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        this.drawParams.getCanvas().drawPath(path, m1558configurePaintswdJneE$default(this, brush, drawStyle, f, colorFilter, i, 0, 32, null));
    }

    private final Paint obtainFillPaint() {
        Paint paint = this.fillPaint;
        if (paint != null) {
            return paint;
        }
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.mo1296setStylek9PVt8s(PaintingStyle.Companion.m1461getFillTiuSbCo());
        this.fillPaint = Paint;
        return Paint;
    }

    private final Paint obtainStrokePaint() {
        Paint paint = this.strokePaint;
        if (paint != null) {
            return paint;
        }
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.mo1296setStylek9PVt8s(PaintingStyle.Companion.m1462getStrokeTiuSbCo());
        this.strokePaint = Paint;
        return Paint;
    }

    private final Paint selectPaint(DrawStyle drawStyle) {
        if (Intrinsics.areEqual(drawStyle, Fill.INSTANCE)) {
            return obtainFillPaint();
        }
        if (drawStyle instanceof Stroke) {
            Paint paintObtainStrokePaint = obtainStrokePaint();
            Stroke stroke = (Stroke) drawStyle;
            if (paintObtainStrokePaint.getStrokeWidth() != stroke.getWidth()) {
                paintObtainStrokePaint.setStrokeWidth(stroke.getWidth());
            }
            if (!StrokeCap.m1497equalsimpl0(paintObtainStrokePaint.mo1289getStrokeCapKaPHkGw(), stroke.m1603getCapKaPHkGw())) {
                paintObtainStrokePaint.mo1294setStrokeCapBeK7IIE(stroke.m1603getCapKaPHkGw());
            }
            if (paintObtainStrokePaint.getStrokeMiterLimit() != stroke.getMiter()) {
                paintObtainStrokePaint.setStrokeMiterLimit(stroke.getMiter());
            }
            if (!StrokeJoin.m1504equalsimpl0(paintObtainStrokePaint.mo1290getStrokeJoinLxFBmk8(), stroke.m1604getJoinLxFBmk8())) {
                paintObtainStrokePaint.mo1295setStrokeJoinWw9F2mQ(stroke.m1604getJoinLxFBmk8());
            }
            paintObtainStrokePaint.getPathEffect();
            stroke.getPathEffect();
            if (!Intrinsics.areEqual((Object) null, (Object) null)) {
                stroke.getPathEffect();
                paintObtainStrokePaint.setPathEffect(null);
            }
            return paintObtainStrokePaint;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: configurePaint-swdJneE$default, reason: not valid java name */
    static /* synthetic */ Paint m1558configurePaintswdJneE$default(CanvasDrawScope canvasDrawScope, Brush brush, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i, int i2, int i3, Object obj) {
        if ((i3 & 32) != 0) {
            i2 = DrawScope.Companion.m1601getDefaultFilterQualityfv9h1I();
        }
        return canvasDrawScope.m1557configurePaintswdJneE(brush, drawStyle, f, colorFilter, i, i2);
    }

    /* JADX INFO: renamed from: configurePaint-swdJneE, reason: not valid java name */
    private final Paint m1557configurePaintswdJneE(Brush brush, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i, int i2) {
        Paint paintSelectPaint = selectPaint(drawStyle);
        if (brush != null) {
            brush.mo1347applyToPq9zytI(mo1599getSizeNHjbRc(), paintSelectPaint, f);
        } else {
            if (paintSelectPaint.getShader() != null) {
                paintSelectPaint.setShader(null);
            }
            long jMo1287getColor0d7_KjU = paintSelectPaint.mo1287getColor0d7_KjU();
            Color.Companion companion = Color.Companion;
            if (!Color.m1367equalsimpl0(jMo1287getColor0d7_KjU, companion.m1376getBlack0d7_KjU())) {
                paintSelectPaint.mo1292setColor8_81llA(companion.m1376getBlack0d7_KjU());
            }
            if (paintSelectPaint.getAlpha() != f) {
                paintSelectPaint.setAlpha(f);
            }
        }
        if (!Intrinsics.areEqual(paintSelectPaint.getColorFilter(), colorFilter)) {
            paintSelectPaint.setColorFilter(colorFilter);
        }
        if (!BlendMode.m1313equalsimpl0(paintSelectPaint.mo1286getBlendMode0nO6VwU(), i)) {
            paintSelectPaint.mo1291setBlendModes9anfk8(i);
        }
        if (!FilterQuality.m1406equalsimpl0(paintSelectPaint.mo1288getFilterQualityfv9h1I(), i2)) {
            paintSelectPaint.mo1293setFilterQualityvDHp3xo(i2);
        }
        return paintSelectPaint;
    }

    /* JADX INFO: renamed from: configurePaint-2qPWKa0$default, reason: not valid java name */
    static /* synthetic */ Paint m1556configurePaint2qPWKa0$default(CanvasDrawScope canvasDrawScope, long j, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i, int i2, int i3, Object obj) {
        return canvasDrawScope.m1555configurePaint2qPWKa0(j, drawStyle, f, colorFilter, i, (i3 & 32) != 0 ? DrawScope.Companion.m1601getDefaultFilterQualityfv9h1I() : i2);
    }

    /* JADX INFO: renamed from: configurePaint-2qPWKa0, reason: not valid java name */
    private final Paint m1555configurePaint2qPWKa0(long j, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i, int i2) {
        Paint paintSelectPaint = selectPaint(drawStyle);
        long jM1563modulate5vOe2sY = m1563modulate5vOe2sY(j, f);
        if (!Color.m1367equalsimpl0(paintSelectPaint.mo1287getColor0d7_KjU(), jM1563modulate5vOe2sY)) {
            paintSelectPaint.mo1292setColor8_81llA(jM1563modulate5vOe2sY);
        }
        if (paintSelectPaint.getShader() != null) {
            paintSelectPaint.setShader(null);
        }
        if (!Intrinsics.areEqual(paintSelectPaint.getColorFilter(), colorFilter)) {
            paintSelectPaint.setColorFilter(colorFilter);
        }
        if (!BlendMode.m1313equalsimpl0(paintSelectPaint.mo1286getBlendMode0nO6VwU(), i)) {
            paintSelectPaint.mo1291setBlendModes9anfk8(i);
        }
        if (!FilterQuality.m1406equalsimpl0(paintSelectPaint.mo1288getFilterQualityfv9h1I(), i2)) {
            paintSelectPaint.mo1293setFilterQualityvDHp3xo(i2);
        }
        return paintSelectPaint;
    }

    /* JADX INFO: renamed from: configureStrokePaint-Q_0CZUI$default, reason: not valid java name */
    static /* synthetic */ Paint m1560configureStrokePaintQ_0CZUI$default(CanvasDrawScope canvasDrawScope, long j, float f, float f2, int i, int i2, PathEffect pathEffect, float f3, ColorFilter colorFilter, int i3, int i4, int i5, Object obj) {
        return canvasDrawScope.m1559configureStrokePaintQ_0CZUI(j, f, f2, i, i2, pathEffect, f3, colorFilter, i3, (i5 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? DrawScope.Companion.m1601getDefaultFilterQualityfv9h1I() : i4);
    }

    /* JADX INFO: renamed from: configureStrokePaint-Q_0CZUI, reason: not valid java name */
    private final Paint m1559configureStrokePaintQ_0CZUI(long j, float f, float f2, int i, int i2, PathEffect pathEffect, float f3, ColorFilter colorFilter, int i3, int i4) {
        Paint paintObtainStrokePaint = obtainStrokePaint();
        long jM1563modulate5vOe2sY = m1563modulate5vOe2sY(j, f3);
        if (!Color.m1367equalsimpl0(paintObtainStrokePaint.mo1287getColor0d7_KjU(), jM1563modulate5vOe2sY)) {
            paintObtainStrokePaint.mo1292setColor8_81llA(jM1563modulate5vOe2sY);
        }
        if (paintObtainStrokePaint.getShader() != null) {
            paintObtainStrokePaint.setShader(null);
        }
        if (!Intrinsics.areEqual(paintObtainStrokePaint.getColorFilter(), colorFilter)) {
            paintObtainStrokePaint.setColorFilter(colorFilter);
        }
        if (!BlendMode.m1313equalsimpl0(paintObtainStrokePaint.mo1286getBlendMode0nO6VwU(), i3)) {
            paintObtainStrokePaint.mo1291setBlendModes9anfk8(i3);
        }
        if (paintObtainStrokePaint.getStrokeWidth() != f) {
            paintObtainStrokePaint.setStrokeWidth(f);
        }
        if (paintObtainStrokePaint.getStrokeMiterLimit() != f2) {
            paintObtainStrokePaint.setStrokeMiterLimit(f2);
        }
        if (!StrokeCap.m1497equalsimpl0(paintObtainStrokePaint.mo1289getStrokeCapKaPHkGw(), i)) {
            paintObtainStrokePaint.mo1294setStrokeCapBeK7IIE(i);
        }
        if (!StrokeJoin.m1504equalsimpl0(paintObtainStrokePaint.mo1290getStrokeJoinLxFBmk8(), i2)) {
            paintObtainStrokePaint.mo1295setStrokeJoinWw9F2mQ(i2);
        }
        paintObtainStrokePaint.getPathEffect();
        if (!Intrinsics.areEqual((Object) null, pathEffect)) {
            paintObtainStrokePaint.setPathEffect(pathEffect);
        }
        if (!FilterQuality.m1406equalsimpl0(paintObtainStrokePaint.mo1288getFilterQualityfv9h1I(), i4)) {
            paintObtainStrokePaint.mo1293setFilterQualityvDHp3xo(i4);
        }
        return paintObtainStrokePaint;
    }

    /* JADX INFO: renamed from: configureStrokePaint-ho4zsrM$default, reason: not valid java name */
    static /* synthetic */ Paint m1562configureStrokePaintho4zsrM$default(CanvasDrawScope canvasDrawScope, Brush brush, float f, float f2, int i, int i2, PathEffect pathEffect, float f3, ColorFilter colorFilter, int i3, int i4, int i5, Object obj) {
        return canvasDrawScope.m1561configureStrokePaintho4zsrM(brush, f, f2, i, i2, pathEffect, f3, colorFilter, i3, (i5 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? DrawScope.Companion.m1601getDefaultFilterQualityfv9h1I() : i4);
    }

    /* JADX INFO: renamed from: configureStrokePaint-ho4zsrM, reason: not valid java name */
    private final Paint m1561configureStrokePaintho4zsrM(Brush brush, float f, float f2, int i, int i2, PathEffect pathEffect, float f3, ColorFilter colorFilter, int i3, int i4) {
        Paint paintObtainStrokePaint = obtainStrokePaint();
        if (brush != null) {
            brush.mo1347applyToPq9zytI(mo1599getSizeNHjbRc(), paintObtainStrokePaint, f3);
        } else if (paintObtainStrokePaint.getAlpha() != f3) {
            paintObtainStrokePaint.setAlpha(f3);
        }
        if (!Intrinsics.areEqual(paintObtainStrokePaint.getColorFilter(), colorFilter)) {
            paintObtainStrokePaint.setColorFilter(colorFilter);
        }
        if (!BlendMode.m1313equalsimpl0(paintObtainStrokePaint.mo1286getBlendMode0nO6VwU(), i3)) {
            paintObtainStrokePaint.mo1291setBlendModes9anfk8(i3);
        }
        if (paintObtainStrokePaint.getStrokeWidth() != f) {
            paintObtainStrokePaint.setStrokeWidth(f);
        }
        if (paintObtainStrokePaint.getStrokeMiterLimit() != f2) {
            paintObtainStrokePaint.setStrokeMiterLimit(f2);
        }
        if (!StrokeCap.m1497equalsimpl0(paintObtainStrokePaint.mo1289getStrokeCapKaPHkGw(), i)) {
            paintObtainStrokePaint.mo1294setStrokeCapBeK7IIE(i);
        }
        if (!StrokeJoin.m1504equalsimpl0(paintObtainStrokePaint.mo1290getStrokeJoinLxFBmk8(), i2)) {
            paintObtainStrokePaint.mo1295setStrokeJoinWw9F2mQ(i2);
        }
        paintObtainStrokePaint.getPathEffect();
        if (!Intrinsics.areEqual((Object) null, pathEffect)) {
            paintObtainStrokePaint.setPathEffect(pathEffect);
        }
        if (!FilterQuality.m1406equalsimpl0(paintObtainStrokePaint.mo1288getFilterQualityfv9h1I(), i4)) {
            paintObtainStrokePaint.mo1293setFilterQualityvDHp3xo(i4);
        }
        return paintObtainStrokePaint;
    }

    /* JADX INFO: renamed from: modulate-5vOe2sY, reason: not valid java name */
    private final long m1563modulate5vOe2sY(long j, float f) {
        return f == 1.0f ? j : Color.m1365copywmQWz5c$default(j, Color.m1368getAlphaimpl(j) * f, 0.0f, 0.0f, 0.0f, 14, null);
    }

    public static final class DrawParams {
        private Canvas canvas;
        private Density density;
        private LayoutDirection layoutDirection;
        private long size;

        public /* synthetic */ DrawParams(Density density, LayoutDirection layoutDirection, Canvas canvas, long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(density, layoutDirection, canvas, j);
        }

        public final Density component1() {
            return this.density;
        }

        public final LayoutDirection component2() {
            return this.layoutDirection;
        }

        public final Canvas component3() {
            return this.canvas;
        }

        /* JADX INFO: renamed from: component4-NH-jbRc, reason: not valid java name */
        public final long m1576component4NHjbRc() {
            return this.size;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DrawParams)) {
                return false;
            }
            DrawParams drawParams = (DrawParams) obj;
            return Intrinsics.areEqual(this.density, drawParams.density) && this.layoutDirection == drawParams.layoutDirection && Intrinsics.areEqual(this.canvas, drawParams.canvas) && Size.m1258equalsimpl0(this.size, drawParams.size);
        }

        public int hashCode() {
            return (((((this.density.hashCode() * 31) + this.layoutDirection.hashCode()) * 31) + this.canvas.hashCode()) * 31) + Size.m1262hashCodeimpl(this.size);
        }

        public String toString() {
            return "DrawParams(density=" + this.density + ", layoutDirection=" + this.layoutDirection + ", canvas=" + this.canvas + ", size=" + ((Object) Size.m1264toStringimpl(this.size)) + ')';
        }

        private DrawParams(Density density, LayoutDirection layoutDirection, Canvas canvas, long j) {
            this.density = density;
            this.layoutDirection = layoutDirection;
            this.canvas = canvas;
            this.size = j;
        }

        public /* synthetic */ DrawParams(Density density, LayoutDirection layoutDirection, Canvas canvas, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? DrawContextKt.getDefaultDensity() : density, (i & 2) != 0 ? LayoutDirection.Ltr : layoutDirection, (i & 4) != 0 ? new EmptyCanvas() : canvas, (i & 8) != 0 ? Size.Companion.m1267getZeroNHjbRc() : j, null);
        }

        public final Density getDensity() {
            return this.density;
        }

        public final void setDensity(Density density) {
            this.density = density;
        }

        public final LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        public final void setLayoutDirection(LayoutDirection layoutDirection) {
            this.layoutDirection = layoutDirection;
        }

        public final Canvas getCanvas() {
            return this.canvas;
        }

        public final void setCanvas(Canvas canvas) {
            this.canvas = canvas;
        }

        /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
        public final long m1577getSizeNHjbRc() {
            return this.size;
        }

        /* JADX INFO: renamed from: setSize-uvyYCjk, reason: not valid java name */
        public final void m1578setSizeuvyYCjk(long j) {
            this.size = j;
        }
    }
}
