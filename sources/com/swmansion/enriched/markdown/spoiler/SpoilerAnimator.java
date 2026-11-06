package com.swmansion.enriched.markdown.spoiler;

import android.view.Choreographer;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class SpoilerAnimator {
    private final List drawables;
    private final SpoilerAnimator$frameCallback$1 frameCallback;
    private boolean isIterating;
    private long lastFrameTime;
    private final List pendingRemovals;
    private boolean running;
    private final WeakReference textViewReference;

    /* JADX WARN: Type inference failed for: r2v3, types: [com.swmansion.enriched.markdown.spoiler.SpoilerAnimator$frameCallback$1] */
    public SpoilerAnimator(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        this.textViewReference = new WeakReference(textView);
        this.drawables = new ArrayList();
        this.pendingRemovals = new ArrayList();
        this.frameCallback = new Choreographer.FrameCallback() { // from class: com.swmansion.enriched.markdown.spoiler.SpoilerAnimator$frameCallback$1
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                if (this.this$0.running) {
                    TextView textView2 = (TextView) this.this$0.textViewReference.get();
                    if (textView2 == null) {
                        this.this$0.stop();
                        return;
                    }
                    long j2 = j / 1000000;
                    float fCoerceIn = this.this$0.lastFrameTime == 0 ? 0.016f : RangesKt.coerceIn(j2 - this.this$0.lastFrameTime, 1L, 64L) / 1000.0f;
                    this.this$0.lastFrameTime = j2;
                    this.this$0.isIterating = true;
                    Iterator it = this.this$0.drawables.iterator();
                    while (it.hasNext()) {
                        ((SpoilerParticleDrawable) it.next()).update(fCoerceIn, j2);
                    }
                    this.this$0.isIterating = false;
                    this.this$0.drainPendingRemovals();
                    textView2.invalidate();
                    if (this.this$0.drawables.isEmpty()) {
                        this.this$0.running = false;
                    } else {
                        Choreographer.getInstance().postFrameCallback(this);
                    }
                }
            }
        };
    }

    public final void register(SpoilerParticleDrawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (!this.drawables.contains(drawable)) {
            this.drawables.add(drawable);
        }
        ensureRunning();
    }

    public final void unregister(SpoilerParticleDrawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (this.isIterating) {
            this.pendingRemovals.add(drawable);
            return;
        }
        this.drawables.remove(drawable);
        if (this.drawables.isEmpty()) {
            stop();
        }
    }

    public final void ensureRunning() {
        if (this.running || this.drawables.isEmpty()) {
            return;
        }
        this.running = true;
        this.lastFrameTime = 0L;
        Choreographer.getInstance().postFrameCallback(this.frameCallback);
    }

    public final void stop() {
        this.running = false;
        Choreographer.getInstance().removeFrameCallback(this.frameCallback);
        this.drawables.clear();
        this.pendingRemovals.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void drainPendingRemovals() {
        if (this.pendingRemovals.isEmpty()) {
            return;
        }
        this.drawables.removeAll(CollectionsKt.toSet(this.pendingRemovals));
        this.pendingRemovals.clear();
    }
}
