package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.os.Build;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.drawscope.DrawContextKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class GraphicsLayer {
    public static final Companion Companion = new Companion(null);
    private static final LayerSnapshotImpl SnapshotImpl;
    private Outline androidOutline;
    private final ChildLayerDependenciesTracker childDependenciesTracker;
    private final GraphicsLayerImpl impl;
    private androidx.compose.ui.graphics.Outline internalOutline;
    private boolean isReleased;
    private Path outlinePath;
    private int parentLayerUsages;
    private long pivotOffset;
    private Path roundRectClipPath;
    private float roundRectCornerRadius;
    private long roundRectOutlineSize;
    private long roundRectOutlineTopLeft;
    private long size;
    private Paint softwareLayerPaint;
    private long topLeft;
    private boolean usePathForClip;
    private Density density = DrawContextKt.getDefaultDensity();
    private LayoutDirection layoutDirection = LayoutDirection.Ltr;
    private Function1 drawBlock = new Function1() { // from class: androidx.compose.ui.graphics.layer.GraphicsLayer$drawBlock$1
        public final void invoke(DrawScope drawScope) {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((DrawScope) obj);
            return Unit.INSTANCE;
        }
    };
    private boolean outlineDirty = true;

    public GraphicsLayer(GraphicsLayerImpl graphicsLayerImpl, LayerManager layerManager) {
        this.impl = graphicsLayerImpl;
        Offset.Companion companion = Offset.Companion;
        this.roundRectOutlineTopLeft = companion.m1235getZeroF1C5BW0();
        this.roundRectOutlineSize = Size.Companion.m1266getUnspecifiedNHjbRc();
        this.childDependenciesTracker = new ChildLayerDependenciesTracker();
        graphicsLayerImpl.setClip(false);
        this.topLeft = IntOffset.Companion.m2598getZeronOccac();
        this.size = IntSize.Companion.m2613getZeroYbymL2g();
        this.pivotOffset = companion.m1234getUnspecifiedF1C5BW0();
    }

    public final boolean isReleased() {
        return this.isReleased;
    }

    /* JADX INFO: renamed from: getCompositingStrategy-ke2Ky5w, reason: not valid java name */
    public final int m1614getCompositingStrategyke2Ky5w() {
        return this.impl.mo1628getCompositingStrategyke2Ky5w();
    }

    /* JADX INFO: renamed from: setCompositingStrategy-Wpw9cng, reason: not valid java name */
    public final void m1620setCompositingStrategyWpw9cng(int i) {
        if (CompositingStrategy.m1607equalsimpl0(this.impl.mo1628getCompositingStrategyke2Ky5w(), i)) {
            return;
        }
        this.impl.mo1631setCompositingStrategyWpw9cng(i);
    }

    /* JADX INFO: renamed from: getTopLeft-nOcc-ac, reason: not valid java name */
    public final long m1617getTopLeftnOccac() {
        return this.topLeft;
    }

    /* JADX INFO: renamed from: setTopLeft--gyyYBs, reason: not valid java name */
    public final void m1625setTopLeftgyyYBs(long j) {
        if (IntOffset.m2590equalsimpl0(this.topLeft, j)) {
            return;
        }
        this.topLeft = j;
        m1611setPositionVbeCjmY(j, this.size);
    }

    /* JADX INFO: renamed from: getSize-YbymL2g, reason: not valid java name */
    public final long m1616getSizeYbymL2g() {
        return this.size;
    }

    /* JADX INFO: renamed from: setSize-ozmzZPI, reason: not valid java name */
    private final void m1612setSizeozmzZPI(long j) {
        if (IntSize.m2607equalsimpl0(this.size, j)) {
            return;
        }
        this.size = j;
        m1611setPositionVbeCjmY(this.topLeft, j);
        if (this.roundRectOutlineSize == 9205357640488583168L) {
            this.outlineDirty = true;
            configureOutline();
        }
    }

    public final float getAlpha() {
        return this.impl.getAlpha();
    }

    public final void setAlpha(float f) {
        if (this.impl.getAlpha() == f) {
            return;
        }
        this.impl.setAlpha(f);
    }

    /* JADX INFO: renamed from: getBlendMode-0nO6VwU, reason: not valid java name */
    public final int m1613getBlendMode0nO6VwU() {
        return this.impl.mo1627getBlendMode0nO6VwU();
    }

    public final ColorFilter getColorFilter() {
        return this.impl.getColorFilter();
    }

    /* JADX INFO: renamed from: getPivotOffset-F1C5BW0, reason: not valid java name */
    public final long m1615getPivotOffsetF1C5BW0() {
        return this.pivotOffset;
    }

    /* JADX INFO: renamed from: setPivotOffset-k-4lQ0M, reason: not valid java name */
    public final void m1621setPivotOffsetk4lQ0M(long j) {
        if (Offset.m1220equalsimpl0(this.pivotOffset, j)) {
            return;
        }
        this.pivotOffset = j;
        this.impl.mo1632setPivotOffsetk4lQ0M(j);
    }

    public final float getScaleX() {
        return this.impl.getScaleX();
    }

    public final void setScaleX(float f) {
        if (this.impl.getScaleX() == f) {
            return;
        }
        this.impl.setScaleX(f);
    }

    public final float getScaleY() {
        return this.impl.getScaleY();
    }

    public final void setScaleY(float f) {
        if (this.impl.getScaleY() == f) {
            return;
        }
        this.impl.setScaleY(f);
    }

    public final float getTranslationX() {
        return this.impl.getTranslationX();
    }

    public final void setTranslationX(float f) {
        if (this.impl.getTranslationX() == f) {
            return;
        }
        this.impl.setTranslationX(f);
    }

    public final float getTranslationY() {
        return this.impl.getTranslationY();
    }

    public final void setTranslationY(float f) {
        if (this.impl.getTranslationY() == f) {
            return;
        }
        this.impl.setTranslationY(f);
    }

    public final float getShadowElevation() {
        return this.impl.getShadowElevation();
    }

    public final void setShadowElevation(float f) {
        if (this.impl.getShadowElevation() == f) {
            return;
        }
        this.impl.setShadowElevation(f);
        this.impl.setClip(getClip() || f > 0.0f);
        this.outlineDirty = true;
        configureOutline();
    }

    public final float getRotationX() {
        return this.impl.getRotationX();
    }

    public final void setRotationX(float f) {
        if (this.impl.getRotationX() == f) {
            return;
        }
        this.impl.setRotationX(f);
    }

    public final float getRotationY() {
        return this.impl.getRotationY();
    }

    public final void setRotationY(float f) {
        if (this.impl.getRotationY() == f) {
            return;
        }
        this.impl.setRotationY(f);
    }

    public final float getRotationZ() {
        return this.impl.getRotationZ();
    }

    public final void setRotationZ(float f) {
        if (this.impl.getRotationZ() == f) {
            return;
        }
        this.impl.setRotationZ(f);
    }

    public final void setCameraDistance(float f) {
        if (this.impl.getCameraDistance() == f) {
            return;
        }
        this.impl.setCameraDistance(f);
    }

    public final boolean getClip() {
        return this.impl.getClip();
    }

    public final void setClip(boolean z) {
        if (this.impl.getClip() != z) {
            this.impl.setClip(z);
            this.outlineDirty = true;
            configureOutline();
        }
    }

    public final void setRenderEffect(RenderEffect renderEffect) {
        if (Intrinsics.areEqual(this.impl.getRenderEffect(), renderEffect)) {
            return;
        }
        this.impl.setRenderEffect(renderEffect);
    }

    /* JADX INFO: renamed from: setPosition-VbeCjmY, reason: not valid java name */
    private final void m1611setPositionVbeCjmY(long j, long j2) {
        this.impl.mo1633setPositionH0pRuoY(IntOffset.m2591getXimpl(j), IntOffset.m2592getYimpl(j), j2);
    }

    /* JADX INFO: renamed from: record-mL-hObY, reason: not valid java name */
    public final void m1618recordmLhObY(Density density, LayoutDirection layoutDirection, long j, Function1 function1) {
        m1612setSizeozmzZPI(j);
        this.density = density;
        this.layoutDirection = layoutDirection;
        this.drawBlock = function1;
        this.impl.setInvalidated(true);
        recordInternal();
    }

    /* JADX WARN: Code duplicated, block: B:29:0x008f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x0091 A[LOOP:0: B:20:0x005a->B:30:0x0091, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:34:0x0094 A[EDGE_INSN: B:34:0x0094->B:31:0x0094 BREAK  A[LOOP:0: B:20:0x005a->B:30:0x0091], SYNTHETIC] */
    private final void recordInternal() {
        ChildLayerDependenciesTracker childLayerDependenciesTracker = this.childDependenciesTracker;
        childLayerDependenciesTracker.oldDependency = childLayerDependenciesTracker.dependency;
        MutableScatterSet mutableScatterSet = childLayerDependenciesTracker.dependenciesSet;
        if (mutableScatterSet != null && mutableScatterSet.isNotEmpty()) {
            MutableScatterSet mutableScatterSetMutableScatterSetOf = childLayerDependenciesTracker.oldDependenciesSet;
            if (mutableScatterSetMutableScatterSetOf == null) {
                mutableScatterSetMutableScatterSetOf = ScatterSetKt.mutableScatterSetOf();
                childLayerDependenciesTracker.oldDependenciesSet = mutableScatterSetMutableScatterSetOf;
            }
            mutableScatterSetMutableScatterSetOf.addAll(mutableScatterSet);
            mutableScatterSet.clear();
        }
        childLayerDependenciesTracker.trackingInProgress = true;
        this.impl.record(this.density, this.layoutDirection, this, this.drawBlock);
        childLayerDependenciesTracker.trackingInProgress = false;
        GraphicsLayer graphicsLayer = childLayerDependenciesTracker.oldDependency;
        if (graphicsLayer != null) {
            graphicsLayer.onRemovedFromParentLayer();
        }
        MutableScatterSet mutableScatterSet2 = childLayerDependenciesTracker.oldDependenciesSet;
        if (mutableScatterSet2 == null || !mutableScatterSet2.isNotEmpty()) {
            return;
        }
        Object[] objArr = mutableScatterSet2.elements;
        long[] jArr = mutableScatterSet2.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i != length) {
                        break;
                        break;
                    }
                    i++;
                } else {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            ((GraphicsLayer) objArr[(i << 3) + i3]).onRemovedFromParentLayer();
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    } else if (i != length) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        mutableScatterSet2.clear();
    }

    private final void addSubLayer(GraphicsLayer graphicsLayer) {
        if (this.childDependenciesTracker.onDependencyAdded(graphicsLayer)) {
            graphicsLayer.onAddedToParentLayer();
        }
    }

    private final void transformCanvas(Canvas canvas) {
        Canvas canvas2;
        float fM2591getXimpl = IntOffset.m2591getXimpl(this.topLeft);
        float fM2592getYimpl = IntOffset.m2592getYimpl(this.topLeft);
        float fM2591getXimpl2 = IntOffset.m2591getXimpl(this.topLeft) + IntSize.m2609getWidthimpl(this.size);
        float fM2592getYimpl2 = IntOffset.m2592getYimpl(this.topLeft) + IntSize.m2608getHeightimpl(this.size);
        float alpha = getAlpha();
        ColorFilter colorFilter = getColorFilter();
        int iM1613getBlendMode0nO6VwU = m1613getBlendMode0nO6VwU();
        if (alpha < 1.0f || !BlendMode.m1313equalsimpl0(iM1613getBlendMode0nO6VwU, BlendMode.Companion.m1343getSrcOver0nO6VwU()) || colorFilter != null || CompositingStrategy.m1607equalsimpl0(m1614getCompositingStrategyke2Ky5w(), CompositingStrategy.Companion.m1610getOffscreenke2Ky5w())) {
            Paint Paint = this.softwareLayerPaint;
            if (Paint == null) {
                Paint = AndroidPaint_androidKt.Paint();
                this.softwareLayerPaint = Paint;
            }
            Paint.setAlpha(alpha);
            Paint.mo1291setBlendModes9anfk8(iM1613getBlendMode0nO6VwU);
            Paint.setColorFilter(colorFilter);
            canvas2 = canvas;
            canvas2.saveLayer(fM2591getXimpl, fM2592getYimpl, fM2591getXimpl2, fM2592getYimpl2, Paint.asFrameworkPaint());
        } else {
            canvas.save();
            canvas2 = canvas;
        }
        canvas2.translate(fM2591getXimpl, fM2592getYimpl);
        canvas2.concat(this.impl.calculateMatrix());
    }

    private final void recreateDisplayListIfNeeded() {
        if (this.impl.getHasDisplayList()) {
            return;
        }
        try {
            recordInternal();
        } catch (Throwable unused) {
        }
    }

    public final void draw$ui_graphics_release(androidx.compose.ui.graphics.Canvas canvas, GraphicsLayer graphicsLayer) {
        if (this.isReleased) {
            return;
        }
        recreateDisplayListIfNeeded();
        configureOutline();
        boolean z = true;
        boolean z2 = getShadowElevation() > 0.0f;
        if (z2) {
            canvas.enableZ();
        }
        Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        boolean zIsHardwareAccelerated = nativeCanvas.isHardwareAccelerated();
        if (!zIsHardwareAccelerated) {
            nativeCanvas.save();
            transformCanvas(nativeCanvas);
        }
        if (!this.usePathForClip && (zIsHardwareAccelerated || !getClip())) {
            z = false;
        }
        if (z) {
            canvas.save();
            androidx.compose.ui.graphics.Outline outline = getOutline();
            if (outline instanceof androidx.compose.ui.graphics.Outline.Rectangle) {
                androidx.compose.ui.graphics.Canvas.m1355clipRectmtrdDE$default(canvas, outline.getBounds(), 0, 2, null);
            } else if (outline instanceof androidx.compose.ui.graphics.Outline.Rounded) {
                Path Path = this.roundRectClipPath;
                if (Path != null) {
                    Path.rewind();
                } else {
                    Path = AndroidPath_androidKt.Path();
                    this.roundRectClipPath = Path;
                }
                Path.addRoundRect$default(Path, ((androidx.compose.ui.graphics.Outline.Rounded) outline).getRoundRect(), null, 2, null);
                androidx.compose.ui.graphics.Canvas.m1353clipPathmtrdDE$default(canvas, Path, 0, 2, null);
            } else if (outline instanceof androidx.compose.ui.graphics.Outline.Generic) {
                androidx.compose.ui.graphics.Canvas.m1353clipPathmtrdDE$default(canvas, ((androidx.compose.ui.graphics.Outline.Generic) outline).getPath(), 0, 2, null);
            }
        }
        if (graphicsLayer != null) {
            graphicsLayer.addSubLayer(this);
        }
        this.impl.draw(canvas);
        if (z) {
            canvas.restore();
        }
        if (z2) {
            canvas.disableZ();
        }
        if (zIsHardwareAccelerated) {
            return;
        }
        nativeCanvas.restore();
    }

    private final void onAddedToParentLayer() {
        this.parentLayerUsages++;
    }

    private final void onRemovedFromParentLayer() {
        this.parentLayerUsages--;
        discardContentIfReleasedAndHaveNoParentLayerUsages();
    }

    private final void configureOutline() {
        if (this.outlineDirty) {
            if (getClip() || getShadowElevation() > 0.0f) {
                Path path = this.outlinePath;
                if (path != null) {
                    Outline outlineUpdatePathOutline = updatePathOutline(path);
                    outlineUpdatePathOutline.setAlpha(getAlpha());
                    this.impl.setOutline(outlineUpdatePathOutline);
                } else {
                    Outline outlineObtainAndroidOutline = obtainAndroidOutline();
                    long jM2615toSizeozmzZPI = IntSizeKt.m2615toSizeozmzZPI(this.size);
                    long j = this.roundRectOutlineTopLeft;
                    long j2 = this.roundRectOutlineSize;
                    if (j2 != 9205357640488583168L) {
                        jM2615toSizeozmzZPI = j2;
                    }
                    outlineObtainAndroidOutline.setRoundRect(Math.round(Offset.m1223getXimpl(j)), Math.round(Offset.m1224getYimpl(j)), Math.round(Offset.m1223getXimpl(j) + Size.m1261getWidthimpl(jM2615toSizeozmzZPI)), Math.round(Offset.m1224getYimpl(j) + Size.m1259getHeightimpl(jM2615toSizeozmzZPI)), this.roundRectCornerRadius);
                    outlineObtainAndroidOutline.setAlpha(getAlpha());
                    this.impl.setOutline(outlineObtainAndroidOutline);
                }
            } else {
                this.impl.setOutline(null);
            }
        }
        this.outlineDirty = false;
    }

    private final Outline updatePathOutline(Path path) {
        Outline outlineObtainAndroidOutline = obtainAndroidOutline();
        int i = Build.VERSION.SDK_INT;
        if (i > 28 || path.isConvex()) {
            if (i <= 30) {
                if (!(path instanceof AndroidPath)) {
                    throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
                }
                outlineObtainAndroidOutline.setConvexPath(((AndroidPath) path).getInternalPath());
            } else {
                OutlineVerificationHelper.INSTANCE.setPath(outlineObtainAndroidOutline, path);
            }
            this.usePathForClip = !outlineObtainAndroidOutline.canClip();
        } else {
            Outline outline = this.androidOutline;
            if (outline != null) {
                outline.setEmpty();
            }
            this.usePathForClip = true;
            this.impl.setInvalidated(true);
        }
        this.outlinePath = path;
        return outlineObtainAndroidOutline;
    }

    private final Outline obtainAndroidOutline() {
        Outline outline = this.androidOutline;
        if (outline != null) {
            return outline;
        }
        Outline outline2 = new Outline();
        this.androidOutline = outline2;
        return outline2;
    }

    public final void release$ui_graphics_release() {
        if (this.isReleased) {
            return;
        }
        this.isReleased = true;
        discardContentIfReleasedAndHaveNoParentLayerUsages();
    }

    private final void discardContentIfReleasedAndHaveNoParentLayerUsages() {
        if (this.isReleased && this.parentLayerUsages == 0) {
            discardDisplayList$ui_graphics_release();
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0055 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:20:0x0057 A[LOOP:0: B:10:0x0020->B:20:0x0057, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:25:0x005a A[EDGE_INSN: B:25:0x005a->B:21:0x005a BREAK  A[LOOP:0: B:10:0x0020->B:20:0x0057], SYNTHETIC] */
    public final void discardDisplayList$ui_graphics_release() {
        ChildLayerDependenciesTracker childLayerDependenciesTracker = this.childDependenciesTracker;
        GraphicsLayer graphicsLayer = childLayerDependenciesTracker.dependency;
        if (graphicsLayer != null) {
            graphicsLayer.onRemovedFromParentLayer();
            childLayerDependenciesTracker.dependency = null;
        }
        MutableScatterSet mutableScatterSet = childLayerDependenciesTracker.dependenciesSet;
        if (mutableScatterSet != null) {
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr = mutableScatterSet.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                        if (i != length) {
                            break;
                            break;
                        }
                        i++;
                    } else {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                ((GraphicsLayer) objArr[(i << 3) + i3]).onRemovedFromParentLayer();
                            }
                            j >>= 8;
                        }
                        if (i2 != 8) {
                            break;
                        } else if (i != length) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
            mutableScatterSet.clear();
        }
        this.impl.discardDisplayList();
    }

    public final androidx.compose.ui.graphics.Outline getOutline() {
        androidx.compose.ui.graphics.Outline rectangle;
        androidx.compose.ui.graphics.Outline outline = this.internalOutline;
        Path path = this.outlinePath;
        if (outline != null) {
            return outline;
        }
        if (path == null) {
            long jM2615toSizeozmzZPI = IntSizeKt.m2615toSizeozmzZPI(this.size);
            long j = this.roundRectOutlineTopLeft;
            long j2 = this.roundRectOutlineSize;
            if (j2 != 9205357640488583168L) {
                jM2615toSizeozmzZPI = j2;
            }
            float fM1223getXimpl = Offset.m1223getXimpl(j);
            float fM1224getYimpl = Offset.m1224getYimpl(j);
            float fM1261getWidthimpl = fM1223getXimpl + Size.m1261getWidthimpl(jM2615toSizeozmzZPI);
            float fM1259getHeightimpl = fM1224getYimpl + Size.m1259getHeightimpl(jM2615toSizeozmzZPI);
            float f = this.roundRectCornerRadius;
            if (f > 0.0f) {
                rectangle = new androidx.compose.ui.graphics.Outline.Rounded(RoundRectKt.m1253RoundRectgG7oq9Y(fM1223getXimpl, fM1224getYimpl, fM1261getWidthimpl, fM1259getHeightimpl, CornerRadiusKt.CornerRadius$default(f, 0.0f, 2, null)));
            } else {
                rectangle = new androidx.compose.ui.graphics.Outline.Rectangle(new Rect(fM1223getXimpl, fM1224getYimpl, fM1261getWidthimpl, fM1259getHeightimpl));
            }
            this.internalOutline = rectangle;
            return rectangle;
        }
        androidx.compose.ui.graphics.Outline.Generic generic = new androidx.compose.ui.graphics.Outline.Generic(path);
        this.internalOutline = generic;
        return generic;
    }

    private final void resetOutlineParams() {
        this.internalOutline = null;
        this.outlinePath = null;
        this.roundRectOutlineSize = Size.Companion.m1266getUnspecifiedNHjbRc();
        this.roundRectOutlineTopLeft = Offset.Companion.m1235getZeroF1C5BW0();
        this.roundRectCornerRadius = 0.0f;
        this.outlineDirty = true;
        this.usePathForClip = false;
    }

    public final void setPathOutline(Path path) {
        resetOutlineParams();
        this.outlinePath = path;
        configureOutline();
    }

    /* JADX INFO: renamed from: setRoundRectOutline-TNW_H78, reason: not valid java name */
    public final void m1623setRoundRectOutlineTNW_H78(long j, long j2, float f) {
        if (Offset.m1220equalsimpl0(this.roundRectOutlineTopLeft, j) && Size.m1258equalsimpl0(this.roundRectOutlineSize, j2) && this.roundRectCornerRadius == f && this.outlinePath == null) {
            return;
        }
        resetOutlineParams();
        this.roundRectOutlineTopLeft = j;
        this.roundRectOutlineSize = j2;
        this.roundRectCornerRadius = f;
        configureOutline();
    }

    /* JADX INFO: renamed from: setRectOutline-tz77jQw, reason: not valid java name */
    public final void m1622setRectOutlinetz77jQw(long j, long j2) {
        m1623setRoundRectOutlineTNW_H78(j, j2, 0.0f);
    }

    /* JADX INFO: renamed from: setAmbientShadowColor-8_81llA, reason: not valid java name */
    public final void m1619setAmbientShadowColor8_81llA(long j) {
        if (Color.m1367equalsimpl0(j, this.impl.mo1626getAmbientShadowColor0d7_KjU())) {
            return;
        }
        this.impl.mo1630setAmbientShadowColor8_81llA(j);
    }

    /* JADX INFO: renamed from: setSpotShadowColor-8_81llA, reason: not valid java name */
    public final void m1624setSpotShadowColor8_81llA(long j) {
        if (Color.m1367equalsimpl0(j, this.impl.mo1629getSpotShadowColor0d7_KjU())) {
            return;
        }
        this.impl.mo1634setSpotShadowColor8_81llA(j);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        LayerSnapshotImpl layerSnapshotImpl;
        if (Build.VERSION.SDK_INT >= 28) {
            layerSnapshotImpl = LayerSnapshotV28.INSTANCE;
        } else if (SurfaceUtils.INSTANCE.isLockHardwareCanvasAvailable()) {
            layerSnapshotImpl = LayerSnapshotV22.INSTANCE;
        } else {
            layerSnapshotImpl = LayerSnapshotV21.INSTANCE;
        }
        SnapshotImpl = layerSnapshotImpl;
    }
}
