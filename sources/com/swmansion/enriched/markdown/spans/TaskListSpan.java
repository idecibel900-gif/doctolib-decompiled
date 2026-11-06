package com.swmansion.enriched.markdown.spans;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.Layout;
import com.swmansion.enriched.markdown.renderer.BlockStyle;
import com.swmansion.enriched.markdown.renderer.SpanStyleCache;
import com.swmansion.enriched.markdown.styles.ListStyle;
import com.swmansion.enriched.markdown.styles.TaskListStyle;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class TaskListSpan extends BaseListSpan {
    public static final Companion Companion = new Companion(null);
    private final Paint boxPaint;
    private final Path checkPath;
    private final float checkboxSize;
    private final float cornerRadius;
    private final boolean isChecked;
    private final ListStyle listStyle;
    private final float markerColumnWidth;
    private final RectF rect;
    private final int taskIndex;
    private final TaskListStyle taskStyle;

    public final int getTaskIndex() {
        return this.taskIndex;
    }

    public final boolean isChecked() {
        return this.isChecked;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskListSpan(TaskListStyle taskStyle, ListStyle listStyle, int i, Context context, SpanStyleCache styleCache, int i2, boolean z, boolean z2) {
        super(i, context, styleCache, new BlockStyle(listStyle.getFontSize(), listStyle.getFontFamily(), listStyle.getFontWeight(), listStyle.getColor()), listStyle.getMarginLeft(), listStyle.getGapWidth(), z2);
        Intrinsics.checkNotNullParameter(taskStyle, "taskStyle");
        Intrinsics.checkNotNullParameter(listStyle, "listStyle");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(styleCache, "styleCache");
        this.taskStyle = taskStyle;
        this.listStyle = listStyle;
        this.taskIndex = i2;
        this.isChecked = z;
        float checkboxSize = taskStyle.getCheckboxSize();
        this.checkboxSize = checkboxSize;
        this.markerColumnWidth = listStyle.effectiveMarkerWidth(checkboxSize);
        this.cornerRadius = taskStyle.getCheckboxBorderRadius();
        this.rect = new RectF();
        this.checkPath = new Path();
        Paint paint = new Paint(1);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
        this.boxPaint = paint;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.swmansion.enriched.markdown.spans.BaseListSpan
    protected float getMarkerWidth() {
        return this.markerColumnWidth;
    }

    @Override // com.swmansion.enriched.markdown.spans.BaseListSpan
    protected void drawMarker(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, Layout layout, int i6) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        float f = i4 - (((-getMarkerFontMetrics().ascent) * 0.72f) / 2.0f);
        float f2 = i;
        float depth = (getDepth() * getMarginLeft()) + this.markerColumnWidth;
        float f3 = this.checkboxSize;
        float f4 = f2 + ((depth - (f3 / 2.0f)) * i2);
        float f5 = f3 / 2.0f;
        this.rect.set(f4 - f5, f - f5, f4 + f5, f5 + f);
        if (this.isChecked) {
            drawChecked(canvas, f);
        } else {
            drawUnchecked(canvas);
        }
    }

    private final void drawChecked(Canvas canvas, float f) {
        Paint paint = this.boxPaint;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(this.taskStyle.getCheckedColor());
        RectF rectF = this.rect;
        float f2 = this.cornerRadius;
        canvas.drawRoundRect(rectF, f2, f2, this.boxPaint);
        Paint paint2 = this.boxPaint;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setColor(this.taskStyle.getCheckmarkColor());
        paint2.setStrokeWidth(Math.max(1.5f, this.checkboxSize * 0.12f));
        float f3 = this.checkboxSize;
        float f4 = 0.22f * f3;
        Path path = this.checkPath;
        path.reset();
        path.moveTo(this.rect.left + f4, f);
        path.lineTo(this.rect.centerX() - (f3 * 0.05f), this.rect.bottom - f4);
        RectF rectF2 = this.rect;
        path.lineTo(rectF2.right - f4, rectF2.top + f4);
        canvas.drawPath(this.checkPath, this.boxPaint);
    }

    private final void drawUnchecked(Canvas canvas) {
        Paint paint = this.boxPaint;
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(this.taskStyle.getBorderColor());
        paint.setStrokeWidth(Math.max(1.0f, this.checkboxSize * 0.09f));
        float strokeWidth = this.boxPaint.getStrokeWidth() / 2.0f;
        RectF rectF = this.rect;
        RectF rectF2 = new RectF(rectF.left + strokeWidth, rectF.top + strokeWidth, rectF.right - strokeWidth, rectF.bottom - strokeWidth);
        float f = this.cornerRadius;
        canvas.drawRoundRect(rectF2, f, f, this.boxPaint);
    }
}
