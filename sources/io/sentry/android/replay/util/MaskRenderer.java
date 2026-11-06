package io.sentry.android.replay.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import io.sentry.android.replay.viewhierarchy.ViewHierarchyNode;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class MaskRenderer implements Closeable {
    private final Lazy lazySinglePixelBitmap;
    private final Lazy maskingPaint$delegate;
    private final Lazy singlePixelBitmapCanvas$delegate;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public MaskRenderer() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.lazySinglePixelBitmap = LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: io.sentry.android.replay.util.MaskRenderer$lazySinglePixelBitmap$1
            @Override // kotlin.jvm.functions.Function0
            public final Bitmap invoke() {
                return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            }
        });
        this.singlePixelBitmapCanvas$delegate = LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: io.sentry.android.replay.util.MaskRenderer$singlePixelBitmapCanvas$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Canvas invoke() {
                return new Canvas(this.this$0.getSinglePixelBitmap$sentry_android_replay_release());
            }
        });
        this.maskingPaint$delegate = LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: io.sentry.android.replay.util.MaskRenderer$maskingPaint$2
            @Override // kotlin.jvm.functions.Function0
            public final Paint invoke() {
                return new Paint();
            }
        });
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final Bitmap getSinglePixelBitmap$sentry_android_replay_release() {
        return (Bitmap) this.lazySinglePixelBitmap.getValue();
    }

    private final Canvas getSinglePixelBitmapCanvas() {
        return (Canvas) this.singlePixelBitmapCanvas$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Paint getMaskingPaint() {
        return (Paint) this.maskingPaint$delegate.getValue();
    }

    public final List renderMasks(final Bitmap bitmap, ViewHierarchyNode viewHierarchy, final Matrix matrix) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(viewHierarchy, "viewHierarchy");
        if (bitmap.isRecycled()) {
            return CollectionsKt.emptyList();
        }
        final ArrayList arrayList = new ArrayList();
        final Canvas canvas = new Canvas(bitmap);
        if (matrix != null) {
            canvas.setMatrix(matrix);
        }
        viewHierarchy.traverse(new Function1() { // from class: io.sentry.android.replay.util.MaskRenderer.renderMasks.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(ViewHierarchyNode node) {
                Pair pair;
                Integer dominantColor;
                Intrinsics.checkNotNullParameter(node, "node");
                if (node.getShouldMask() && node.getWidth() > 0 && node.getHeight() > 0) {
                    if (node.getVisibleRect() == null) {
                        return Boolean.FALSE;
                    }
                    if (node instanceof ViewHierarchyNode.ImageViewHierarchyNode) {
                        pair = TuplesKt.to(CollectionsKt.listOf(node.getVisibleRect()), Integer.valueOf(MaskRenderer.this.dominantColorForRect(bitmap, node.getVisibleRect(), matrix)));
                    } else {
                        if (node instanceof ViewHierarchyNode.TextViewHierarchyNode) {
                            ViewHierarchyNode.TextViewHierarchyNode textViewHierarchyNode = (ViewHierarchyNode.TextViewHierarchyNode) node;
                            TextLayout layout = textViewHierarchyNode.getLayout();
                            pair = TuplesKt.to(ViewsKt.getVisibleRects(textViewHierarchyNode.getLayout(), node.getVisibleRect(), textViewHierarchyNode.getPaddingLeft(), textViewHierarchyNode.getPaddingTop()), Integer.valueOf(((layout == null || (dominantColor = layout.getDominantTextColor()) == null) && (dominantColor = textViewHierarchyNode.getDominantColor()) == null) ? -16777216 : dominantColor.intValue()));
                        } else {
                            pair = TuplesKt.to(CollectionsKt.listOf(node.getVisibleRect()), -16777216);
                        }
                    }
                    List list = (List) pair.getFirst();
                    MaskRenderer.this.getMaskingPaint().setColor(((Number) pair.getSecond()).intValue());
                    Canvas canvas2 = canvas;
                    MaskRenderer maskRenderer = MaskRenderer.this;
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        canvas2.drawRoundRect(new RectF((Rect) it.next()), 10.0f, 10.0f, maskRenderer.getMaskingPaint());
                    }
                    arrayList.addAll(list);
                }
                return Boolean.TRUE;
            }
        });
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int dominantColorForRect(Bitmap bitmap, Rect rect, Matrix matrix) {
        if (bitmap.isRecycled() || getSinglePixelBitmap$sentry_android_replay_release().isRecycled()) {
            return -16777216;
        }
        Rect rect2 = new Rect(rect);
        RectF rectF = new RectF(rect2);
        if (matrix != null) {
            matrix.mapRect(rectF);
        }
        rectF.round(rect2);
        getSinglePixelBitmapCanvas().drawBitmap(bitmap, rect2, new Rect(0, 0, 1, 1), (Paint) null);
        return getSinglePixelBitmap$sentry_android_replay_release().getPixel(0, 0);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.lazySinglePixelBitmap.isInitialized() || getSinglePixelBitmap$sentry_android_replay_release().isRecycled()) {
            return;
        }
        getSinglePixelBitmap$sentry_android_replay_release().recycle();
    }
}
