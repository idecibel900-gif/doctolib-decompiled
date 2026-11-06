package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.time.AwakeTimeSinceBootClock;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.info.ImagePerfMonitor;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
import com.facebook.drawee.debug.listener.ImageLoadingTimeControllerListener;
import com.facebook.drawee.drawable.ArrayDrawable;
import com.facebook.drawee.drawable.DrawableParent;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.fresco.ui.common.ImagePerfDataListener;
import com.facebook.fresco.ui.common.MultiUriHelper;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public class PipelineDraweeController extends AbstractDraweeController {
    private static final Class TAG = PipelineDraweeController.class;
    private CacheKey mCacheKey;
    private ImmutableList mCustomDrawableFactories;
    private Supplier mDataSourceSupplier;
    private final DrawableFactory mDefaultDrawableFactory;
    private boolean mDrawDebugOverlay;
    private ImageRequest[] mFirstAvailableImageRequests;
    private final ImmutableList mGlobalDrawableFactories;
    private ImagePerfMonitor mImagePerfMonitor;
    private ImageRequest mImageRequest;
    private ImageRequest mLowResImageRequest;
    private final MemoryCache mMemoryCache;
    private Set mRequestListeners;
    private final Resources mResources;

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    protected void releaseDrawable(Drawable drawable) {
    }

    public PipelineDraweeController(Resources resources, DeferredReleaser deferredReleaser, DrawableFactory drawableFactory, DrawableFactory drawableFactory2, Executor executor, MemoryCache memoryCache, ImmutableList immutableList) {
        super(deferredReleaser, executor, null, null);
        this.mResources = resources;
        this.mDefaultDrawableFactory = new DefaultDrawableFactory(resources, drawableFactory, drawableFactory2);
        this.mGlobalDrawableFactories = immutableList;
        this.mMemoryCache = memoryCache;
    }

    public void initialize(Supplier supplier, String str, CacheKey cacheKey, Object obj, ImmutableList immutableList) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("PipelineDraweeController#initialize");
        }
        super.initialize(str, obj);
        init(supplier);
        this.mCacheKey = cacheKey;
        setCustomDrawableFactories(immutableList);
        maybeUpdateDebugOverlay(null);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    protected synchronized void initializePerformanceMonitoring(ImagePerfDataListener imagePerfDataListener, AbstractDraweeControllerBuilder abstractDraweeControllerBuilder) {
        try {
            ImagePerfMonitor imagePerfMonitor = this.mImagePerfMonitor;
            if (imagePerfMonitor != null) {
                imagePerfMonitor.reset();
            }
            if (imagePerfDataListener != null) {
                if (this.mImagePerfMonitor == null) {
                    this.mImagePerfMonitor = new ImagePerfMonitor(AwakeTimeSinceBootClock.get(), this);
                }
                this.mImagePerfMonitor.addImagePerfDataListener(imagePerfDataListener);
                this.mImagePerfMonitor.setEnabled(true);
            }
            this.mImageRequest = (ImageRequest) abstractDraweeControllerBuilder.getImageRequest();
            this.mFirstAvailableImageRequests = (ImageRequest[]) abstractDraweeControllerBuilder.getFirstAvailableImageRequests();
            this.mLowResImageRequest = (ImageRequest) abstractDraweeControllerBuilder.getLowResImageRequest();
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setDrawDebugOverlay(boolean z) {
        this.mDrawDebugOverlay = z;
    }

    public void setCustomDrawableFactories(ImmutableList immutableList) {
        this.mCustomDrawableFactories = immutableList;
    }

    public synchronized void addRequestListener(RequestListener requestListener) {
        try {
            if (this.mRequestListeners == null) {
                this.mRequestListeners = new HashSet();
            }
            this.mRequestListeners.add(requestListener);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void removeRequestListener(RequestListener requestListener) {
        Set set = this.mRequestListeners;
        if (set == null) {
            return;
        }
        set.remove(requestListener);
    }

    private void init(Supplier supplier) {
        this.mDataSourceSupplier = supplier;
        maybeUpdateDebugOverlay(null);
    }

    public synchronized RequestListener getRequestListener() {
        Set set = this.mRequestListeners;
        if (set == null) {
            return null;
        }
        return new ForwardingRequestListener(set);
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    protected DataSource getDataSource() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("PipelineDraweeController#getDataSource");
        }
        if (FLog.isLoggable(2)) {
            FLog.v(TAG, "controller %x: getDataSource", Integer.valueOf(System.identityHashCode(this)));
        }
        DataSource dataSource = (DataSource) this.mDataSourceSupplier.get();
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return dataSource;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public Drawable createDrawable(CloseableReference closeableReference) {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("PipelineDraweeController#createDrawable");
            }
            Preconditions.checkState(CloseableReference.isValid(closeableReference));
            CloseableImage closeableImage = (CloseableImage) closeableReference.get();
            maybeUpdateDebugOverlay(closeableImage);
            Drawable drawableMaybeCreateDrawableFromFactories = maybeCreateDrawableFromFactories(this.mCustomDrawableFactories, closeableImage);
            if (drawableMaybeCreateDrawableFromFactories != null) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                return drawableMaybeCreateDrawableFromFactories;
            }
            Drawable drawableMaybeCreateDrawableFromFactories2 = maybeCreateDrawableFromFactories(this.mGlobalDrawableFactories, closeableImage);
            if (drawableMaybeCreateDrawableFromFactories2 != null) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                return drawableMaybeCreateDrawableFromFactories2;
            }
            Drawable drawableCreateDrawable = this.mDefaultDrawableFactory.createDrawable(closeableImage);
            if (drawableCreateDrawable != null) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                return drawableCreateDrawable;
            }
            throw new UnsupportedOperationException("Unrecognized image class: " + closeableImage);
        } catch (Throwable th) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            throw th;
        }
    }

    private Drawable maybeCreateDrawableFromFactories(ImmutableList immutableList, CloseableImage closeableImage) {
        Drawable drawableCreateDrawable;
        if (immutableList == null) {
            return null;
        }
        Iterator<E> it = immutableList.iterator();
        while (it.hasNext()) {
            DrawableFactory drawableFactory = (DrawableFactory) it.next();
            if (drawableFactory.supportsImageType(closeableImage) && (drawableCreateDrawable = drawableFactory.createDrawable(closeableImage)) != null) {
                return drawableCreateDrawable;
            }
        }
        return null;
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController, com.facebook.drawee.interfaces.DraweeController
    public void setHierarchy(DraweeHierarchy draweeHierarchy) {
        super.setHierarchy(draweeHierarchy);
        maybeUpdateDebugOverlay(null);
    }

    private void maybeUpdateDebugOverlay(CloseableImage closeableImage) {
        if (this.mDrawDebugOverlay) {
            if (getControllerOverlay() == null) {
                DebugControllerOverlayDrawable debugControllerOverlayDrawable = new DebugControllerOverlayDrawable();
                addControllerListener(new ImageLoadingTimeControllerListener(debugControllerOverlayDrawable));
                setControllerOverlay(debugControllerOverlayDrawable);
            }
            if (getControllerOverlay() instanceof DebugControllerOverlayDrawable) {
                updateDebugOverlay(closeableImage, (DebugControllerOverlayDrawable) getControllerOverlay());
            }
        }
    }

    protected void updateDebugOverlay(CloseableImage closeableImage, DebugControllerOverlayDrawable debugControllerOverlayDrawable) {
        ScaleTypeDrawable activeScaleTypeDrawable;
        debugControllerOverlayDrawable.setControllerId(getId());
        DraweeHierarchy hierarchy = getHierarchy();
        ScalingUtils$ScaleType scaleType = null;
        if (hierarchy != null && (activeScaleTypeDrawable = getActiveScaleTypeDrawable(hierarchy.getTopLevelDrawable())) != null) {
            scaleType = activeScaleTypeDrawable.getScaleType();
        }
        debugControllerOverlayDrawable.setScaleType(scaleType);
        String callerContextString = getCallerContextString();
        if (callerContextString != null) {
            debugControllerOverlayDrawable.addAdditionalData("cc", callerContextString);
        }
        if (closeableImage != null) {
            debugControllerOverlayDrawable.setDimensions(closeableImage.getWidth(), closeableImage.getHeight());
            debugControllerOverlayDrawable.setImageSize(closeableImage.getSizeInBytes());
        } else {
            debugControllerOverlayDrawable.reset();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public ImageInfo getImageInfo(CloseableReference closeableReference) {
        Preconditions.checkState(CloseableReference.isValid(closeableReference));
        return ((CloseableImage) closeableReference.get()).getImageInfo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public int getImageHash(CloseableReference closeableReference) {
        if (closeableReference != null) {
            return closeableReference.getValueHash();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public void releaseImage(CloseableReference closeableReference) {
        CloseableReference.closeSafely(closeableReference);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public CloseableReference getCachedImage() {
        CacheKey cacheKey;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("PipelineDraweeController#getCachedImage");
        }
        try {
            MemoryCache memoryCache = this.mMemoryCache;
            if (memoryCache != null && (cacheKey = this.mCacheKey) != null) {
                CloseableReference closeableReference = memoryCache.get(cacheKey);
                if (closeableReference == null || ((CloseableImage) closeableReference.get()).getQualityInfo().isOfFullQuality()) {
                    return closeableReference;
                }
                closeableReference.close();
                return null;
            }
            return null;
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public void onImageLoadedFromCacheImmediately(String str, CloseableReference closeableReference) {
        super.onImageLoadedFromCacheImmediately(str, (Object) closeableReference);
        synchronized (this) {
        }
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public String toString() {
        return Objects.toStringHelper(this).add("super", super.toString()).add("dataSourceSupplier", this.mDataSourceSupplier).toString();
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public Map obtainExtrasFromImage(ImageInfo imageInfo) {
        if (imageInfo == null) {
            return null;
        }
        return imageInfo.getExtras();
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    protected Uri getMainUri() {
        return MultiUriHelper.getMainUri(this.mImageRequest, this.mLowResImageRequest, this.mFirstAvailableImageRequests, ImageRequest.REQUEST_TO_URI_FN);
    }

    protected String getCallerContextString() {
        Object callerContext = getCallerContext();
        if (callerContext == null) {
            return null;
        }
        return callerContext.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ScaleTypeDrawable getActiveScaleTypeDrawable(Drawable drawable) {
        if (drawable == 0) {
            return null;
        }
        if (drawable instanceof ScaleTypeDrawable) {
            return (ScaleTypeDrawable) drawable;
        }
        if (drawable instanceof DrawableParent) {
            return getActiveScaleTypeDrawable(((DrawableParent) drawable).getDrawable());
        }
        if (drawable instanceof ArrayDrawable) {
            ArrayDrawable arrayDrawable = (ArrayDrawable) drawable;
            int numberOfLayers = arrayDrawable.getNumberOfLayers();
            for (int i = 0; i < numberOfLayers; i++) {
                ScaleTypeDrawable activeScaleTypeDrawable = getActiveScaleTypeDrawable(arrayDrawable.getDrawable(i));
                if (activeScaleTypeDrawable != null) {
                    return activeScaleTypeDrawable;
                }
            }
        }
        return null;
    }
}
