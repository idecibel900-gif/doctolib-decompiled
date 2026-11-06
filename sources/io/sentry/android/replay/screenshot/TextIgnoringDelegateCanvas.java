package io.sentry.android.replay.screenshot;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.Mesh;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.RenderNode;
import android.graphics.Shader;
import android.graphics.fonts.Font;
import android.graphics.text.MeasuredText;
import android.os.Build;
import java.util.WeakHashMap;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
final class TextIgnoringDelegateCanvas extends Canvas {
    private final WeakHashMap bitmapColorCache;
    public Canvas delegate;
    private final Bitmap singlePixelBitmap;
    private final Rect singlePixelBitmapBounds;
    private final Canvas singlePixelCanvas;
    private final Paint solidPaint = new Paint();
    private final Paint textPaint = new Paint();
    private final Rect tmpRect = new Rect();

    @Override // android.graphics.Canvas
    public void drawBitmap(int[] colors, int i, int i2, float f, float f2, int i3, int i4, boolean z, Paint paint) {
        Intrinsics.checkNotNullParameter(colors, "colors");
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(int[] colors, int i, int i2, int i3, int i4, int i5, int i6, boolean z, Paint paint) {
        Intrinsics.checkNotNullParameter(colors, "colors");
    }

    @Override // android.graphics.Canvas
    public void drawBitmapMesh(Bitmap bitmap, int i, int i2, float[] verts, int i3, int[] iArr, int i4, Paint paint) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(verts, "verts");
    }

    @Override // android.graphics.Canvas
    public void drawGlyphs(int[] glyphIds, int i, float[] positions, int i2, int i3, Font font, Paint paint) {
        Intrinsics.checkNotNullParameter(glyphIds, "glyphIds");
        Intrinsics.checkNotNullParameter(positions, "positions");
        Intrinsics.checkNotNullParameter(font, "font");
        Intrinsics.checkNotNullParameter(paint, "paint");
    }

    @Override // android.graphics.Canvas
    public void drawMesh(Mesh mesh, BlendMode blendMode, Paint paint) {
        Intrinsics.checkNotNullParameter(mesh, "mesh");
        Intrinsics.checkNotNullParameter(paint, "paint");
    }

    @Override // android.graphics.Canvas
    public void drawPosText(String text, float[] pos, Paint paint) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(pos, "pos");
        Intrinsics.checkNotNullParameter(paint, "paint");
    }

    @Override // android.graphics.Canvas
    public void drawPosText(char[] text, int i, int i2, float[] pos, Paint paint) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(pos, "pos");
        Intrinsics.checkNotNullParameter(paint, "paint");
    }

    @Override // android.graphics.Canvas
    public void drawRenderNode(RenderNode renderNode) {
        Intrinsics.checkNotNullParameter(renderNode, "renderNode");
    }

    @Override // android.graphics.Canvas
    public void drawTextOnPath(String text, Path path, float f, float f2, Paint paint) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(paint, "paint");
    }

    @Override // android.graphics.Canvas
    public void drawTextOnPath(char[] text, int i, int i2, Path path, float f, float f2, Paint paint) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(paint, "paint");
    }

    @Override // android.graphics.Canvas
    public void drawVertices(Canvas.VertexMode mode, int i, float[] verts, int i2, float[] fArr, int i3, int[] iArr, int i4, short[] sArr, int i5, int i6, Paint paint) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(verts, "verts");
        Intrinsics.checkNotNullParameter(paint, "paint");
    }

    @Override // android.graphics.Canvas
    public boolean isHardwareAccelerated() {
        return false;
    }

    public TextIgnoringDelegateCanvas() {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        this.singlePixelBitmap = bitmapCreateBitmap;
        this.singlePixelCanvas = new Canvas(bitmapCreateBitmap);
        this.singlePixelBitmapBounds = new Rect(0, 0, 1, 1);
        this.bitmapColorCache = new WeakHashMap();
    }

    public final Canvas getDelegate() {
        Canvas canvas = this.delegate;
        if (canvas != null) {
            return canvas;
        }
        Intrinsics.throwUninitializedPropertyAccessException("delegate");
        return null;
    }

    public final void setDelegate(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "<set-?>");
        this.delegate = canvas;
    }

    @Override // android.graphics.Canvas
    public void setBitmap(Bitmap bitmap) {
        getDelegate().setBitmap(bitmap);
    }

    @Override // android.graphics.Canvas
    public void enableZ() {
        getDelegate().enableZ();
    }

    @Override // android.graphics.Canvas
    public void disableZ() {
        getDelegate().disableZ();
    }

    @Override // android.graphics.Canvas
    public boolean isOpaque() {
        return getDelegate().isOpaque();
    }

    @Override // android.graphics.Canvas
    public int getWidth() {
        return getDelegate().getWidth();
    }

    @Override // android.graphics.Canvas
    public int getHeight() {
        return getDelegate().getHeight();
    }

    @Override // android.graphics.Canvas
    public int getDensity() {
        return getDelegate().getDensity();
    }

    @Override // android.graphics.Canvas
    public void setDensity(int i) {
        getDelegate().setDensity(i);
    }

    @Override // android.graphics.Canvas
    public int getMaximumBitmapWidth() {
        return getDelegate().getMaximumBitmapWidth();
    }

    @Override // android.graphics.Canvas
    public int getMaximumBitmapHeight() {
        return getDelegate().getMaximumBitmapHeight();
    }

    @Override // android.graphics.Canvas
    public int save() {
        return getDelegate().save();
    }

    @Override // android.graphics.Canvas
    public int saveLayer(RectF rectF, Paint paint, int i) {
        BitmapShader bitmapShaderRemoveBitmapShader = removeBitmapShader(paint);
        int iSaveLayer = getDelegate().saveLayer(rectF, paint, i);
        if (paint == null) {
            return iSaveLayer;
        }
        paint.setShader(bitmapShaderRemoveBitmapShader);
        return iSaveLayer;
    }

    @Override // android.graphics.Canvas
    public int saveLayer(RectF rectF, Paint paint) {
        BitmapShader bitmapShaderRemoveBitmapShader = removeBitmapShader(paint);
        int iSaveLayer = getDelegate().saveLayer(rectF, paint);
        if (paint == null) {
            return iSaveLayer;
        }
        paint.setShader(bitmapShaderRemoveBitmapShader);
        return iSaveLayer;
    }

    @Override // android.graphics.Canvas
    public int saveLayer(float f, float f2, float f3, float f4, Paint paint, int i) {
        BitmapShader bitmapShaderRemoveBitmapShader = removeBitmapShader(paint);
        int iSaveLayer = getDelegate().saveLayer(f, f2, f3, f4, paint, i);
        if (paint == null) {
            return iSaveLayer;
        }
        paint.setShader(bitmapShaderRemoveBitmapShader);
        return iSaveLayer;
    }

    @Override // android.graphics.Canvas
    public int saveLayer(float f, float f2, float f3, float f4, Paint paint) {
        BitmapShader bitmapShaderRemoveBitmapShader = removeBitmapShader(paint);
        int iSaveLayer = getDelegate().saveLayer(f, f2, f3, f4, paint);
        if (paint == null) {
            return iSaveLayer;
        }
        paint.setShader(bitmapShaderRemoveBitmapShader);
        return iSaveLayer;
    }

    @Override // android.graphics.Canvas
    public int saveLayerAlpha(RectF rectF, int i, int i2) {
        return getDelegate().saveLayerAlpha(rectF, i, i2);
    }

    @Override // android.graphics.Canvas
    public int saveLayerAlpha(RectF rectF, int i) {
        return getDelegate().saveLayerAlpha(rectF, i);
    }

    @Override // android.graphics.Canvas
    public int saveLayerAlpha(float f, float f2, float f3, float f4, int i, int i2) {
        return getDelegate().saveLayerAlpha(f, f2, f3, f4, i, i2);
    }

    @Override // android.graphics.Canvas
    public int saveLayerAlpha(float f, float f2, float f3, float f4, int i) {
        return getDelegate().saveLayerAlpha(f, f2, f3, f4, i);
    }

    @Override // android.graphics.Canvas
    public void restore() {
        getDelegate().restore();
    }

    @Override // android.graphics.Canvas
    public int getSaveCount() {
        return getDelegate().getSaveCount();
    }

    @Override // android.graphics.Canvas
    public void restoreToCount(int i) {
        getDelegate().restoreToCount(i);
    }

    @Override // android.graphics.Canvas
    public void translate(float f, float f2) {
        getDelegate().translate(f, f2);
    }

    @Override // android.graphics.Canvas
    public void scale(float f, float f2) {
        getDelegate().scale(f, f2);
    }

    @Override // android.graphics.Canvas
    public void rotate(float f) {
        getDelegate().rotate(f);
    }

    @Override // android.graphics.Canvas
    public void skew(float f, float f2) {
        getDelegate().skew(f, f2);
    }

    @Override // android.graphics.Canvas
    public void concat(Matrix matrix) {
        getDelegate().concat(matrix);
    }

    @Override // android.graphics.Canvas
    public void setMatrix(Matrix matrix) {
        getDelegate().setMatrix(matrix);
    }

    @Override // android.graphics.Canvas
    public void getMatrix(Matrix ctm) {
        Intrinsics.checkNotNullParameter(ctm, "ctm");
        getDelegate().getMatrix(ctm);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(RectF rect, Region.Op op) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(op, "op");
        return getDelegate().clipRect(rect, op);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(Rect rect, Region.Op op) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(op, "op");
        return getDelegate().clipRect(rect, op);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return getDelegate().clipRect(rect);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return getDelegate().clipRect(rect);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(float f, float f2, float f3, float f4, Region.Op op) {
        Intrinsics.checkNotNullParameter(op, "op");
        return getDelegate().clipRect(f, f2, f3, f4, op);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(float f, float f2, float f3, float f4) {
        return getDelegate().clipRect(f, f2, f3, f4);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(int i, int i2, int i3, int i4) {
        return getDelegate().clipRect(i, i2, i3, i4);
    }

    @Override // android.graphics.Canvas
    public boolean clipOutRect(RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return getDelegate().clipOutRect(rect);
    }

    @Override // android.graphics.Canvas
    public boolean clipOutRect(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return getDelegate().clipOutRect(rect);
    }

    @Override // android.graphics.Canvas
    public boolean clipOutRect(float f, float f2, float f3, float f4) {
        return getDelegate().clipOutRect(f, f2, f3, f4);
    }

    @Override // android.graphics.Canvas
    public boolean clipOutRect(int i, int i2, int i3, int i4) {
        return getDelegate().clipOutRect(i, i2, i3, i4);
    }

    @Override // android.graphics.Canvas
    public boolean clipPath(Path path, Region.Op op) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(op, "op");
        return getDelegate().clipPath(path, op);
    }

    @Override // android.graphics.Canvas
    public boolean clipPath(Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return getDelegate().clipPath(path);
    }

    @Override // android.graphics.Canvas
    public boolean clipOutPath(Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return getDelegate().clipOutPath(path);
    }

    @Override // android.graphics.Canvas
    public DrawFilter getDrawFilter() {
        return getDelegate().getDrawFilter();
    }

    @Override // android.graphics.Canvas
    public void setDrawFilter(DrawFilter drawFilter) {
        getDelegate().setDrawFilter(drawFilter);
    }

    @Override // android.graphics.Canvas
    public boolean quickReject(RectF rect, Canvas.EdgeType type) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(type, "type");
        return getDelegate().quickReject(rect, type);
    }

    @Override // android.graphics.Canvas
    public boolean quickReject(RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return getDelegate().quickReject(rect);
    }

    @Override // android.graphics.Canvas
    public boolean quickReject(Path path, Canvas.EdgeType type) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(type, "type");
        return getDelegate().quickReject(path, type);
    }

    @Override // android.graphics.Canvas
    public boolean quickReject(Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return getDelegate().quickReject(path);
    }

    @Override // android.graphics.Canvas
    public boolean quickReject(float f, float f2, float f3, float f4, Canvas.EdgeType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return getDelegate().quickReject(f, f2, f3, f4, type);
    }

    @Override // android.graphics.Canvas
    public boolean quickReject(float f, float f2, float f3, float f4) {
        return getDelegate().quickReject(f, f2, f3, f4);
    }

    @Override // android.graphics.Canvas
    public boolean getClipBounds(Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        return getDelegate().getClipBounds(bounds);
    }

    @Override // android.graphics.Canvas
    public void drawPicture(Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        this.solidPaint.setColorFilter(null);
        this.solidPaint.setColor(-16777216);
        getDelegate().drawRect(0.0f, 0.0f, picture.getWidth(), picture.getHeight(), this.solidPaint);
    }

    @Override // android.graphics.Canvas
    public void drawPicture(Picture picture, RectF dst) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        Intrinsics.checkNotNullParameter(dst, "dst");
        this.solidPaint.setColorFilter(null);
        this.solidPaint.setColor(-16777216);
        getDelegate().drawRect(dst, this.solidPaint);
    }

    @Override // android.graphics.Canvas
    public void drawPicture(Picture picture, Rect dst) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        Intrinsics.checkNotNullParameter(dst, "dst");
        this.solidPaint.setColorFilter(null);
        this.solidPaint.setColor(-16777216);
        getDelegate().drawRect(dst, this.solidPaint);
    }

    @Override // android.graphics.Canvas
    public void drawArc(RectF oval, float f, float f2, boolean z, Paint paint) {
        Intrinsics.checkNotNullParameter(oval, "oval");
        Intrinsics.checkNotNullParameter(paint, "paint");
        BitmapShader bitmapShaderRemoveBitmapShader = removeBitmapShader(paint);
        getDelegate().drawArc(oval, f, f2, z, paint);
        paint.setShader(bitmapShaderRemoveBitmapShader);
    }

    @Override // android.graphics.Canvas
    public void drawArc(float f, float f2, float f3, float f4, float f5, float f6, boolean z, Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        BitmapShader bitmapShaderRemoveBitmapShader = removeBitmapShader(paint);
        getDelegate().drawArc(f, f2, f3, f4, f5, f6, z, paint);
        paint.setShader(bitmapShaderRemoveBitmapShader);
    }

    @Override // android.graphics.Canvas
    public void drawARGB(int i, int i2, int i3, int i4) {
        getDelegate().drawARGB(i, i2, i3, i4);
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(Bitmap bitmap, float f, float f2, Paint paint) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.solidPaint.setColor(sampleBitmapColor(bitmap, paint, null));
        this.solidPaint.setColorFilter(null);
        getDelegate().drawRect(f, f2, f + bitmap.getWidth(), f2 + bitmap.getHeight(), this.solidPaint);
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(Bitmap bitmap, Rect rect, RectF dst, Paint paint) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(dst, "dst");
        this.solidPaint.setColor(sampleBitmapColor(bitmap, paint, rect));
        this.solidPaint.setColorFilter(null);
        getDelegate().drawRect(dst, this.solidPaint);
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(Bitmap bitmap, Rect rect, Rect dst, Paint paint) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(dst, "dst");
        this.solidPaint.setColor(sampleBitmapColor(bitmap, paint, rect));
        this.solidPaint.setColorFilter(null);
        getDelegate().drawRect(dst, this.solidPaint);
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(Bitmap bitmap, Matrix matrix, Paint paint) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        this.solidPaint.setColor(sampleBitmapColor(bitmap, paint, null));
        this.solidPaint.setColorFilter(null);
        int iSave = getDelegate().save();
        getDelegate().setMatrix(matrix);
        getDelegate().drawRect(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight(), this.solidPaint);
        getDelegate().restoreToCount(iSave);
    }

    @Override // android.graphics.Canvas
    public void drawCircle(float f, float f2, float f3, Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        BitmapShader bitmapShaderRemoveBitmapShader = removeBitmapShader(paint);
        getDelegate().drawCircle(f, f2, f3, paint);
        paint.setShader(bitmapShaderRemoveBitmapShader);
    }

    @Override // android.graphics.Canvas
    public void drawColor(int i) {
        getDelegate().drawColor(i);
    }

    @Override // android.graphics.Canvas
    public void drawColor(long j) {
        getDelegate().drawColor(j);
    }

    @Override // android.graphics.Canvas
    public void drawColor(int i, PorterDuff.Mode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        getDelegate().drawColor(i, mode);
    }

    @Override // android.graphics.Canvas
    public void drawColor(int i, BlendMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        getDelegate().drawColor(i, mode);
    }

    @Override // android.graphics.Canvas
    public void drawColor(long j, BlendMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        getDelegate().drawColor(j, mode);
    }

    @Override // android.graphics.Canvas
    public void drawLine(float f, float f2, float f3, float f4, Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        BitmapShader bitmapShaderRemoveBitmapShader = removeBitmapShader(paint);
        getDelegate().drawLine(f, f2, f3, f4, paint);
        paint.setShader(bitmapShaderRemoveBitmapShader);
    }

    @Override // android.graphics.Canvas
    public void drawLines(float[] pts, int i, int i2, Paint paint) {
        Intrinsics.checkNotNullParameter(pts, "pts");
        Intrinsics.checkNotNullParameter(paint, "paint");
        BitmapShader bitmapShaderRemoveBitmapShader = removeBitmapShader(paint);
        getDelegate().drawLines(pts, i, i2, paint);
        paint.setShader(bitmapShaderRemoveBitmapShader);
    }

    @Override // android.graphics.Canvas
    public void drawLines(float[] pts, Paint paint) {
        Intrinsics.checkNotNullParameter(pts, "pts");
        Intrinsics.checkNotNullParameter(paint, "paint");
        BitmapShader bitmapShaderRemoveBitmapShader = removeBitmapShader(paint);
        getDelegate().drawLines(pts, paint);
        paint.setShader(bitmapShaderRemoveBitmapShader);
    }

    @Override // android.graphics.Canvas
    public void drawOval(RectF oval, Paint paint) {
        Intrinsics.checkNotNullParameter(oval, "oval");
        Intrinsics.checkNotNullParameter(paint, "paint");
        BitmapShader bitmapShaderRemoveBitmapShader = removeBitmapShader(paint);
        getDelegate().drawOval(oval, paint);
        paint.setShader(bitmapShaderRemoveBitmapShader);
    }

    @Override // android.graphics.Canvas
    public void drawOval(float f, float f2, float f3, float f4, Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        BitmapShader bitmapShaderRemoveBitmapShader = removeBitmapShader(paint);
        getDelegate().drawOval(f, f2, f3, f4, paint);
        paint.setShader(bitmapShaderRemoveBitmapShader);
    }

    @Override // android.graphics.Canvas
    public void drawPaint(Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        BitmapShader bitmapShaderRemoveBitmapShader = removeBitmapShader(paint);
        getDelegate().drawPaint(paint);
        paint.setShader(bitmapShaderRemoveBitmapShader);
    }

    @Override // android.graphics.Canvas
    public void drawPatch(NinePatch patch, Rect dst, Paint paint) {
        Intrinsics.checkNotNullParameter(patch, "patch");
        Intrinsics.checkNotNullParameter(dst, "dst");
        BitmapShader bitmapShaderRemoveBitmapShader = removeBitmapShader(paint);
        getDelegate().drawPatch(patch, dst, paint);
        if (paint == null) {
            return;
        }
        paint.setShader(bitmapShaderRemoveBitmapShader);
    }

    @Override // android.graphics.Canvas
    public void drawPatch(NinePatch patch, RectF dst, Paint paint) {
        Intrinsics.checkNotNullParameter(patch, "patch");
        Intrinsics.checkNotNullParameter(dst, "dst");
        BitmapShader bitmapShaderRemoveBitmapShader = removeBitmapShader(paint);
        getDelegate().drawPatch(patch, dst, paint);
        if (paint == null) {
            return;
        }
        paint.setShader(bitmapShaderRemoveBitmapShader);
    }

    @Override // android.graphics.Canvas
    public void drawPath(Path path, Paint paint) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(paint, "paint");
        BitmapShader bitmapShaderRemoveBitmapShader = removeBitmapShader(paint);
        getDelegate().drawPath(path, paint);
        paint.setShader(bitmapShaderRemoveBitmapShader);
    }

    @Override // android.graphics.Canvas
    public void drawPoint(float f, float f2, Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        BitmapShader bitmapShaderRemoveBitmapShader = removeBitmapShader(paint);
        getDelegate().drawPoint(f, f2, paint);
        paint.setShader(bitmapShaderRemoveBitmapShader);
    }

    @Override // android.graphics.Canvas
    public void drawPoints(float[] fArr, int i, int i2, Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        BitmapShader bitmapShaderRemoveBitmapShader = removeBitmapShader(paint);
        getDelegate().drawPoints(fArr, i, i2, paint);
        paint.setShader(bitmapShaderRemoveBitmapShader);
    }

    @Override // android.graphics.Canvas
    public void drawPoints(float[] pts, Paint paint) {
        Intrinsics.checkNotNullParameter(pts, "pts");
        Intrinsics.checkNotNullParameter(paint, "paint");
        BitmapShader bitmapShaderRemoveBitmapShader = removeBitmapShader(paint);
        getDelegate().drawPoints(pts, paint);
        paint.setShader(bitmapShaderRemoveBitmapShader);
    }

    @Override // android.graphics.Canvas
    public void drawRect(RectF rect, Paint paint) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(paint, "paint");
        BitmapShader bitmapShaderRemoveBitmapShader = removeBitmapShader(paint);
        getDelegate().drawRect(rect, paint);
        paint.setShader(bitmapShaderRemoveBitmapShader);
    }

    @Override // android.graphics.Canvas
    public void drawRect(Rect r, Paint paint) {
        Intrinsics.checkNotNullParameter(r, "r");
        Intrinsics.checkNotNullParameter(paint, "paint");
        BitmapShader bitmapShaderRemoveBitmapShader = removeBitmapShader(paint);
        getDelegate().drawRect(r, paint);
        paint.setShader(bitmapShaderRemoveBitmapShader);
    }

    @Override // android.graphics.Canvas
    public void drawRect(float f, float f2, float f3, float f4, Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        BitmapShader bitmapShaderRemoveBitmapShader = removeBitmapShader(paint);
        getDelegate().drawRect(f, f2, f3, f4, paint);
        paint.setShader(bitmapShaderRemoveBitmapShader);
    }

    @Override // android.graphics.Canvas
    public void drawRGB(int i, int i2, int i3) {
        getDelegate().drawRGB(i, i2, i3);
    }

    @Override // android.graphics.Canvas
    public void drawRoundRect(RectF rect, float f, float f2, Paint paint) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(paint, "paint");
        BitmapShader bitmapShaderRemoveBitmapShader = removeBitmapShader(paint);
        getDelegate().drawRoundRect(rect, f, f2, paint);
        paint.setShader(bitmapShaderRemoveBitmapShader);
    }

    @Override // android.graphics.Canvas
    public void drawRoundRect(float f, float f2, float f3, float f4, float f5, float f6, Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        BitmapShader bitmapShaderRemoveBitmapShader = removeBitmapShader(paint);
        getDelegate().drawRoundRect(f, f2, f3, f4, f5, f6, paint);
        paint.setShader(bitmapShaderRemoveBitmapShader);
    }

    @Override // android.graphics.Canvas
    public void drawDoubleRoundRect(RectF outer, float f, float f2, RectF inner, float f3, float f4, Paint paint) {
        Intrinsics.checkNotNullParameter(outer, "outer");
        Intrinsics.checkNotNullParameter(inner, "inner");
        Intrinsics.checkNotNullParameter(paint, "paint");
        BitmapShader bitmapShaderRemoveBitmapShader = removeBitmapShader(paint);
        getDelegate().drawDoubleRoundRect(outer, f, f2, inner, f3, f4, paint);
        paint.setShader(bitmapShaderRemoveBitmapShader);
    }

    @Override // android.graphics.Canvas
    public void drawDoubleRoundRect(RectF outer, float[] outerRadii, RectF inner, float[] innerRadii, Paint paint) {
        Intrinsics.checkNotNullParameter(outer, "outer");
        Intrinsics.checkNotNullParameter(outerRadii, "outerRadii");
        Intrinsics.checkNotNullParameter(inner, "inner");
        Intrinsics.checkNotNullParameter(innerRadii, "innerRadii");
        Intrinsics.checkNotNullParameter(paint, "paint");
        BitmapShader bitmapShaderRemoveBitmapShader = removeBitmapShader(paint);
        getDelegate().drawDoubleRoundRect(outer, outerRadii, inner, innerRadii, paint);
        paint.setShader(bitmapShaderRemoveBitmapShader);
    }

    @Override // android.graphics.Canvas
    public void drawText(char[] text, int i, int i2, float f, float f2, Paint paint) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        paint.getTextBounds(text, i, i2, this.tmpRect);
        drawMaskedText(paint, f, f2);
    }

    @Override // android.graphics.Canvas
    public void drawText(String text, float f, float f2, Paint paint) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        paint.getTextBounds(text, 0, text.length(), this.tmpRect);
        drawMaskedText(paint, f, f2);
    }

    @Override // android.graphics.Canvas
    public void drawText(String text, int i, int i2, float f, float f2, Paint paint) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        paint.getTextBounds(text, i, i2, this.tmpRect);
        drawMaskedText(paint, f, f2);
    }

    @Override // android.graphics.Canvas
    public void drawText(CharSequence text, int i, int i2, float f, float f2, Paint paint) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        paint.getTextBounds(text.toString(), 0, text.length(), this.tmpRect);
        drawMaskedText(paint, f, f2);
    }

    @Override // android.graphics.Canvas
    public void drawTextRun(char[] text, int i, int i2, int i3, int i4, float f, float f2, boolean z, Paint paint) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        paint.getTextBounds(text, 0, i + i2, this.tmpRect);
        drawMaskedText(paint, f, f2);
    }

    @Override // android.graphics.Canvas
    public void drawTextRun(CharSequence text, int i, int i2, int i3, int i4, float f, float f2, boolean z, Paint paint) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        paint.getTextBounds(text.toString(), i, i2, this.tmpRect);
        drawMaskedText(paint, f, f2);
    }

    @Override // android.graphics.Canvas
    public void drawTextRun(MeasuredText text, int i, int i2, int i3, int i4, float f, float f2, boolean z, Paint paint) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        paint.getTextBounds(text.toString(), i, i2, this.tmpRect);
        drawMaskedText(paint, f, f2);
    }

    private final int sampleBitmapColor(Bitmap bitmap, Paint paint, Rect rect) {
        int pixel = -16777216;
        if (bitmap.isRecycled()) {
            return -16777216;
        }
        Pair pair = (Pair) this.bitmapColorCache.get(bitmap);
        if (pair != null && ((Number) pair.getFirst()).intValue() == bitmap.getGenerationId()) {
            return ((Number) pair.getSecond()).intValue();
        }
        Bitmap.Config config = bitmap.getConfig();
        Bitmap.Config config2 = Bitmap.Config.HARDWARE;
        if (config == config2 && Build.VERSION.SDK_INT >= 31) {
            BitmapShader bitmapShaderRemoveBitmapShader = removeBitmapShader(paint);
            this.singlePixelCanvas.drawBitmap(bitmap.asShared(), rect, this.singlePixelBitmapBounds, paint);
            if (bitmapShaderRemoveBitmapShader != null && paint != null) {
                paint.setShader(bitmapShaderRemoveBitmapShader);
            }
            pixel = this.singlePixelBitmap.getPixel(0, 0);
        } else if (bitmap.getConfig() != config2) {
            BitmapShader bitmapShaderRemoveBitmapShader2 = removeBitmapShader(paint);
            this.singlePixelCanvas.drawBitmap(bitmap, rect, this.singlePixelBitmapBounds, paint);
            if (bitmapShaderRemoveBitmapShader2 != null && paint != null) {
                paint.setShader(bitmapShaderRemoveBitmapShader2);
            }
            pixel = this.singlePixelBitmap.getPixel(0, 0);
        }
        this.bitmapColorCache.put(bitmap, new Pair(Integer.valueOf(bitmap.getGenerationId()), Integer.valueOf(pixel)));
        return pixel;
    }

    private final void drawMaskedText(Paint paint, float f, float f2) {
        this.textPaint.setColorFilter(paint.getColorFilter());
        int color = paint.getColor();
        this.textPaint.setColor(Color.argb(100, Color.red(color), Color.green(color), Color.blue(color)));
        Rect rect = this.tmpRect;
        drawRoundRect(rect.left + f, rect.top + f2, rect.right + f, rect.bottom + f2, 10.0f, 10.0f, this.textPaint);
    }

    private final BitmapShader removeBitmapShader(Paint paint) {
        if (paint == null) {
            return null;
        }
        Shader shader = paint.getShader();
        if (!(shader instanceof BitmapShader)) {
            return null;
        }
        paint.setShader(null);
        return (BitmapShader) shader;
    }
}
