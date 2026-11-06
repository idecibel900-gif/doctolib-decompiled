package expo.modules.image;

import android.graphics.drawable.Drawable;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.ThumbnailRequestCoordinator;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import expo.modules.image.enums.ContentFit;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ImageViewWrapperTarget implements Target {
    private int cookie;
    private boolean hasSource;
    private final WeakReference imageViewHolder;
    private boolean isUsed;
    private ContentFit placeholderContentFit;
    private int placeholderHeight;
    private int placeholderWidth;
    private Request request;
    private SizeDeterminer sizeDeterminer;
    private int sourceHeight;
    private int sourceWidth;

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadStarted(Drawable drawable) {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }

    public ImageViewWrapperTarget(WeakReference imageViewHolder) {
        Intrinsics.checkNotNullParameter(imageViewHolder, "imageViewHolder");
        this.imageViewHolder = imageViewHolder;
        this.sourceHeight = -1;
        this.sourceWidth = -1;
        this.placeholderHeight = -1;
        this.placeholderWidth = -1;
        this.cookie = -1;
        this.sizeDeterminer = new SizeDeterminer(imageViewHolder);
    }

    public final boolean getHasSource() {
        return this.hasSource;
    }

    public final void setHasSource(boolean z) {
        this.hasSource = z;
    }

    public final boolean isUsed() {
        return this.isUsed;
    }

    public final void setUsed(boolean z) {
        this.isUsed = z;
    }

    public final int getSourceHeight() {
        return this.sourceHeight;
    }

    public final void setSourceHeight(int i) {
        this.sourceHeight = i;
    }

    public final int getSourceWidth() {
        return this.sourceWidth;
    }

    public final void setSourceWidth(int i) {
        this.sourceWidth = i;
    }

    public final int getPlaceholderHeight() {
        return this.placeholderHeight;
    }

    public final void setPlaceholderHeight(int i) {
        this.placeholderHeight = i;
    }

    public final int getPlaceholderWidth() {
        return this.placeholderWidth;
    }

    public final void setPlaceholderWidth(int i) {
        this.placeholderWidth = i;
    }

    public final void setCookie(int i) {
        endLoadingNewImageTraceBlock();
        synchronized (this) {
            this.cookie = i;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final ContentFit getPlaceholderContentFit() {
        return this.placeholderContentFit;
    }

    public final void setPlaceholderContentFit(ContentFit contentFit) {
        this.placeholderContentFit = contentFit;
    }

    private final void endLoadingNewImageTraceBlock() {
        synchronized (this) {
            if (this.cookie >= 0) {
                Trace trace = Trace.INSTANCE;
                String tag = trace.getTag();
                String loadNewImageBlock = trace.getLoadNewImageBlock();
                androidx.tracing.Trace.endAsyncSection("[" + tag + "] " + loadNewImageBlock, this.cookie);
                this.cookie = -1;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onResourceReady(Drawable resource, Transition transition) {
        Request privateFullRequest;
        Intrinsics.checkNotNullParameter(resource, "resource");
        Object obj = this.imageViewHolder.get();
        if (obj != null) {
            ExpoImageViewWrapper expoImageViewWrapper = (ExpoImageViewWrapper) obj;
            Request request = this.request;
            boolean z = false;
            if (request instanceof ThumbnailRequestCoordinator) {
                ThumbnailRequestCoordinator thumbnailRequestCoordinator = request instanceof ThumbnailRequestCoordinator ? (ThumbnailRequestCoordinator) request : null;
                if (thumbnailRequestCoordinator != null && (privateFullRequest = ThumbnailRequestCoordinatorExtensionKt.getPrivateFullRequest(thumbnailRequestCoordinator)) != null && !privateFullRequest.isComplete()) {
                    z = true;
                }
            }
            if (!z) {
                endLoadingNewImageTraceBlock();
            }
            expoImageViewWrapper.onResourceReady(this, resource, z);
            return;
        }
        endLoadingNewImageTraceBlock();
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadFailed(Drawable drawable) {
        endLoadingNewImageTraceBlock();
    }

    @Override // com.bumptech.glide.request.target.Target
    public void getSize(SizeReadyCallback cb) {
        Intrinsics.checkNotNullParameter(cb, "cb");
        if (this.imageViewHolder.get() == null) {
            cb.onSizeReady(LinearLayoutManager.INVALID_OFFSET, LinearLayoutManager.INVALID_OFFSET);
        } else {
            this.sizeDeterminer.getSize(cb);
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public void removeCallback(SizeReadyCallback cb) {
        Intrinsics.checkNotNullParameter(cb, "cb");
        this.sizeDeterminer.removeCallback(cb);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void setRequest(Request request) {
        this.request = request;
    }

    @Override // com.bumptech.glide.request.target.Target
    public Request getRequest() {
        return this.request;
    }

    public final void clear(RequestManager requestManager) {
        Intrinsics.checkNotNullParameter(requestManager, "requestManager");
        this.sizeDeterminer.clearCallbacksAndListener();
        requestManager.clear(this);
    }
}
