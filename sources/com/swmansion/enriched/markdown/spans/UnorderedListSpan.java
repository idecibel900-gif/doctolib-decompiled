package com.swmansion.enriched.markdown.spans;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import com.swmansion.enriched.markdown.renderer.BlockStyle;
import com.swmansion.enriched.markdown.renderer.SpanStyleCache;
import com.swmansion.enriched.markdown.styles.ListStyle;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class UnorderedListSpan extends BaseListSpan {
    public static final Companion Companion = new Companion(null);
    private static final Paint sharedBulletPaint;
    private final ListStyle listStyle;
    private final float markerColumnWidth;
    private final float radius;
    private final float ringStrokeWidth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnorderedListSpan(ListStyle listStyle, int i, Context context, SpanStyleCache styleCache, boolean z) {
        super(i, context, styleCache, new BlockStyle(listStyle.getFontSize(), listStyle.getFontFamily(), listStyle.getFontWeight(), listStyle.getColor()), listStyle.getMarginLeft(), listStyle.getGapWidth(), z);
        Intrinsics.checkNotNullParameter(listStyle, "listStyle");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(styleCache, "styleCache");
        this.listStyle = listStyle;
        float bulletSize = listStyle.getBulletSize() / 2.0f;
        this.radius = bulletSize;
        this.ringStrokeWidth = 0.3f * bulletSize;
        this.markerColumnWidth = listStyle.effectiveMarkerWidth(bulletSize);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        sharedBulletPaint = paint;
    }

    private final Paint configureBulletPaint() {
        Paint paint = sharedBulletPaint;
        paint.setColor(this.listStyle.getBulletColor());
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(0.0f);
        return paint;
    }

    @Override // com.swmansion.enriched.markdown.spans.BaseListSpan
    protected float getMarkerWidth() {
        return this.markerColumnWidth;
    }

    @Override // com.swmansion.enriched.markdown.spans.BaseListSpan
    protected void drawMarker(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, Layout layout, int i6) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Paint paintConfigureBulletPaint = configureBulletPaint();
        float depth = i + (((getDepth() * getMarginLeft()) + this.markerColumnWidth) * i2);
        float f = i4 + ((getMarkerFontMetrics().ascent + getMarkerFontMetrics().descent) / 2.0f);
        int depth2 = getDepth();
        if (depth2 == 0) {
            canvas.drawCircle(depth, f, this.radius, paintConfigureBulletPaint);
            return;
        }
        if (depth2 == 1) {
            paintConfigureBulletPaint.setStyle(Paint.Style.STROKE);
            paintConfigureBulletPaint.setStrokeWidth(this.ringStrokeWidth);
            canvas.drawCircle(depth, f, this.radius - (this.ringStrokeWidth / 2.0f), paintConfigureBulletPaint);
        } else {
            float f2 = this.radius;
            canvas.drawRect(depth - f2, f - f2, depth + f2, f + f2, paintConfigureBulletPaint);
        }
    }
}
