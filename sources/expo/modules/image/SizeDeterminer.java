package expo.modules.image;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class SizeDeterminer {
    public static final Companion Companion = new Companion(null);
    private static Integer maxDisplayLength;
    private final List cbs;
    private final WeakReference imageViewHolder;
    private SizeDeterminerLayoutListener layoutListener;
    private boolean waitForLayout;

    private final boolean isDimensionValid(int i) {
        return i > 0 || i == Integer.MIN_VALUE;
    }

    public SizeDeterminer(WeakReference imageViewHolder) {
        Intrinsics.checkNotNullParameter(imageViewHolder, "imageViewHolder");
        this.imageViewHolder = imageViewHolder;
        this.cbs = new ArrayList();
    }

    private final void notifyCbs(int i, int i2) {
        Iterator it = new ArrayList(this.cbs).iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            ((SizeReadyCallback) it.next()).onSizeReady(i, i2);
        }
    }

    public final void checkCurrentDimens() {
        if (this.cbs.isEmpty()) {
            return;
        }
        int targetWidth = getTargetWidth();
        int targetHeight = getTargetHeight();
        if (isViewStateAndSizeValid(targetWidth, targetHeight)) {
            notifyCbs(targetWidth, targetHeight);
            clearCallbacksAndListener();
        }
    }

    public final void getSize(SizeReadyCallback cb) {
        Intrinsics.checkNotNullParameter(cb, "cb");
        ExpoImageViewWrapper expoImageViewWrapper = (ExpoImageViewWrapper) this.imageViewHolder.get();
        if (expoImageViewWrapper == null) {
            return;
        }
        int targetWidth = getTargetWidth();
        int targetHeight = getTargetHeight();
        if (isViewStateAndSizeValid(targetWidth, targetHeight)) {
            cb.onSizeReady(targetWidth, targetHeight);
            return;
        }
        if (!this.cbs.contains(cb)) {
            this.cbs.add(cb);
        }
        if (this.layoutListener == null) {
            ViewTreeObserver viewTreeObserver = expoImageViewWrapper.getViewTreeObserver();
            SizeDeterminerLayoutListener sizeDeterminerLayoutListener = new SizeDeterminerLayoutListener(this);
            this.layoutListener = sizeDeterminerLayoutListener;
            viewTreeObserver.addOnPreDrawListener(sizeDeterminerLayoutListener);
        }
    }

    public final void removeCallback(SizeReadyCallback cb) {
        Intrinsics.checkNotNullParameter(cb, "cb");
        this.cbs.remove(cb);
    }

    public final void clearCallbacksAndListener() {
        ExpoImageViewWrapper expoImageViewWrapper = (ExpoImageViewWrapper) this.imageViewHolder.get();
        ViewTreeObserver viewTreeObserver = expoImageViewWrapper != null ? expoImageViewWrapper.getViewTreeObserver() : null;
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this.layoutListener);
        }
        this.layoutListener = null;
        this.cbs.clear();
    }

    private final boolean isViewStateAndSizeValid(int i, int i2) {
        return isDimensionValid(i) && isDimensionValid(i2);
    }

    private final int getTargetHeight() {
        ExpoImageViewWrapper expoImageViewWrapper = (ExpoImageViewWrapper) this.imageViewHolder.get();
        if (expoImageViewWrapper == null) {
            return LinearLayoutManager.INVALID_OFFSET;
        }
        int paddingTop = expoImageViewWrapper.getPaddingTop() + expoImageViewWrapper.getPaddingBottom();
        ViewGroup.LayoutParams layoutParams = expoImageViewWrapper.getLayoutParams();
        return getTargetDimen(expoImageViewWrapper.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
    }

    private final int getTargetWidth() {
        ExpoImageViewWrapper expoImageViewWrapper = (ExpoImageViewWrapper) this.imageViewHolder.get();
        if (expoImageViewWrapper == null) {
            return LinearLayoutManager.INVALID_OFFSET;
        }
        int paddingLeft = expoImageViewWrapper.getPaddingLeft() + expoImageViewWrapper.getPaddingRight();
        ViewGroup.LayoutParams layoutParams = expoImageViewWrapper.getLayoutParams();
        return getTargetDimen(expoImageViewWrapper.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
    }

    private final int getTargetDimen(int i, int i2, int i3) {
        ExpoImageViewWrapper expoImageViewWrapper = (ExpoImageViewWrapper) this.imageViewHolder.get();
        if (expoImageViewWrapper == null) {
            return LinearLayoutManager.INVALID_OFFSET;
        }
        int i4 = i2 - i3;
        if (i4 > 0) {
            return i4;
        }
        if (this.waitForLayout && expoImageViewWrapper.isLayoutRequested()) {
            return 0;
        }
        int i5 = i - i3;
        if (i5 > 0) {
            return i5;
        }
        if (expoImageViewWrapper.isLayoutRequested() || i2 != -2) {
            return 0;
        }
        Companion companion = Companion;
        Context context = expoImageViewWrapper.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return companion.getMaxDisplayLength(context);
    }

    private static final class SizeDeterminerLayoutListener implements ViewTreeObserver.OnPreDrawListener {
        private final WeakReference sizeDeterminerRef;

        public SizeDeterminerLayoutListener(SizeDeterminer sizeDeterminer) {
            Intrinsics.checkNotNullParameter(sizeDeterminer, "sizeDeterminer");
            this.sizeDeterminerRef = new WeakReference(sizeDeterminer);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            SizeDeterminer sizeDeterminer = (SizeDeterminer) this.sizeDeterminerRef.get();
            if (sizeDeterminer == null) {
                return true;
            }
            sizeDeterminer.checkCurrentDimens();
            return true;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Integer getMaxDisplayLength() {
            return SizeDeterminer.maxDisplayLength;
        }

        public final void setMaxDisplayLength(Integer num) {
            SizeDeterminer.maxDisplayLength = num;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int getMaxDisplayLength(Context context) {
            if (getMaxDisplayLength() == null) {
                Object systemService = context.getSystemService("window");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
                Display defaultDisplay = ((WindowManager) Preconditions.checkNotNull((WindowManager) systemService)).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                setMaxDisplayLength(Integer.valueOf(Math.max(point.x, point.y)));
            }
            Integer maxDisplayLength = getMaxDisplayLength();
            Intrinsics.checkNotNull(maxDisplayLength);
            return maxDisplayLength.intValue();
        }
    }
}
