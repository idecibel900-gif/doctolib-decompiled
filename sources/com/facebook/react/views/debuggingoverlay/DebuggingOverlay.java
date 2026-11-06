package com.facebook.react.views.debuggingoverlay;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.facebook.react.bridge.UiThreadUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DebuggingOverlay extends View {
    private final Paint highlightedElementsPaint;
    private List highlightedElementsRectangles;
    private final HashMap traceUpdateIdToCleanupRunnableMap;
    private final Paint traceUpdatePaint;
    private final HashMap traceUpdatesToDisplayMap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebuggingOverlay(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint();
        this.traceUpdatePaint = paint;
        this.traceUpdatesToDisplayMap = new HashMap();
        this.traceUpdateIdToCleanupRunnableMap = new HashMap();
        Paint paint2 = new Paint();
        this.highlightedElementsPaint = paint2;
        this.highlightedElementsRectangles = new ArrayList();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(6.0f);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(-859248897);
    }

    public final void setTraceUpdates(List<TraceUpdate> traceUpdates) {
        Intrinsics.checkNotNullParameter(traceUpdates, "traceUpdates");
        for (TraceUpdate traceUpdate : traceUpdates) {
            int id = traceUpdate.getId();
            if (this.traceUpdateIdToCleanupRunnableMap.containsKey(Integer.valueOf(id))) {
                Runnable runnable = (Runnable) this.traceUpdateIdToCleanupRunnableMap.get(Integer.valueOf(id));
                if (runnable != null) {
                    UiThreadUtil.removeOnUiThread(runnable);
                }
                this.traceUpdateIdToCleanupRunnableMap.remove(Integer.valueOf(id));
            }
            this.traceUpdatesToDisplayMap.put(Integer.valueOf(id), traceUpdate);
        }
        invalidate();
    }

    public final void setHighlightedElementsRectangles(List<RectF> elementsRectangles) {
        Intrinsics.checkNotNullParameter(elementsRectangles, "elementsRectangles");
        this.highlightedElementsRectangles = elementsRectangles;
        invalidate();
    }

    public final void clearElementsHighlights() {
        this.highlightedElementsRectangles.clear();
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        for (Object obj : this.traceUpdatesToDisplayMap.values()) {
            Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
            TraceUpdate traceUpdate = (TraceUpdate) obj;
            this.traceUpdatePaint.setColor(traceUpdate.getColor());
            canvas.drawRect(traceUpdate.getRectangle(), this.traceUpdatePaint);
            final int id = traceUpdate.getId();
            Runnable runnable = new Runnable() { // from class: com.facebook.react.views.debuggingoverlay.DebuggingOverlay$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    DebuggingOverlay.onDraw$lambda$1(this.f$0, id);
                }
            };
            if (!this.traceUpdateIdToCleanupRunnableMap.containsKey(Integer.valueOf(id))) {
                this.traceUpdateIdToCleanupRunnableMap.put(Integer.valueOf(id), runnable);
                UiThreadUtil.runOnUiThread(runnable, 2000L);
            }
        }
        Iterator it = this.highlightedElementsRectangles.iterator();
        while (it.hasNext()) {
            canvas.drawRect((RectF) it.next(), this.highlightedElementsPaint);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onDraw$lambda$1(DebuggingOverlay debuggingOverlay, int i) {
        debuggingOverlay.traceUpdatesToDisplayMap.remove(Integer.valueOf(i));
        debuggingOverlay.traceUpdateIdToCleanupRunnableMap.remove(Integer.valueOf(i));
        debuggingOverlay.invalidate();
    }
}
