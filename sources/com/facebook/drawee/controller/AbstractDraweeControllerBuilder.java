package com.facebook.drawee.controller;

import android.content.Context;
import android.graphics.drawable.Animatable;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.datasource.FirstAvailableDataSourceSupplier;
import com.facebook.datasource.IncreasingQualityDataSourceSupplier;
import com.facebook.drawee.gestures.GestureDetector;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractDraweeControllerBuilder {
    private boolean mAutoPlayAnimations;
    private final Set mBoundControllerListeners;
    private final Set mBoundControllerListeners2;
    private Object mCallerContext;
    private String mContentDescription;
    private final Context mContext;
    private ControllerListener mControllerListener;
    private Supplier mDataSourceSupplier;
    private Object mImageRequest;
    private boolean mLogWithHighSamplingRate = false;
    private Object mLowResImageRequest;
    private Object[] mMultiImageRequests;
    private DraweeController mOldController;
    private boolean mRetainImageOnFailure;
    private boolean mTapToRetryEnabled;
    private boolean mTryCacheOnlyFirst;
    private static final ControllerListener sAutoPlayAnimationsListener = new BaseControllerListener() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, Object obj, Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException NO_REQUEST_EXCEPTION = new NullPointerException("No image request was specified!");
    private static final AtomicLong sIdCounter = new AtomicLong();

    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    public ControllerViewportVisibilityListener getControllerViewportVisibilityListener() {
        return null;
    }

    protected abstract DataSource getDataSourceForRequest(DraweeController draweeController, String str, Object obj, Object obj2, CacheLevel cacheLevel);

    protected final AbstractDraweeControllerBuilder getThis() {
        return this;
    }

    protected abstract AbstractDraweeController obtainController();

    protected AbstractDraweeControllerBuilder(Context context, Set set, Set set2) {
        this.mContext = context;
        this.mBoundControllerListeners = set;
        this.mBoundControllerListeners2 = set2;
        init();
    }

    private void init() {
        this.mCallerContext = null;
        this.mImageRequest = null;
        this.mLowResImageRequest = null;
        this.mMultiImageRequests = null;
        this.mTryCacheOnlyFirst = true;
        this.mControllerListener = null;
        this.mTapToRetryEnabled = false;
        this.mAutoPlayAnimations = false;
        this.mLogWithHighSamplingRate = false;
        this.mOldController = null;
        this.mContentDescription = null;
    }

    public AbstractDraweeControllerBuilder reset() {
        init();
        return getThis();
    }

    public AbstractDraweeControllerBuilder setCallerContext(Object obj) {
        this.mCallerContext = obj;
        return getThis();
    }

    public Object getCallerContext() {
        return this.mCallerContext;
    }

    public AbstractDraweeControllerBuilder setImageRequest(Object obj) {
        this.mImageRequest = obj;
        return getThis();
    }

    public Object getImageRequest() {
        return this.mImageRequest;
    }

    public AbstractDraweeControllerBuilder setLowResImageRequest(Object obj) {
        this.mLowResImageRequest = obj;
        return getThis();
    }

    public Object getLowResImageRequest() {
        return this.mLowResImageRequest;
    }

    public Object[] getFirstAvailableImageRequests() {
        return this.mMultiImageRequests;
    }

    public boolean getRetainImageOnFailure() {
        return this.mRetainImageOnFailure;
    }

    public AbstractDraweeControllerBuilder setAutoPlayAnimations(boolean z) {
        this.mAutoPlayAnimations = z;
        return getThis();
    }

    public boolean isLogWithHighSamplingRate() {
        return this.mLogWithHighSamplingRate;
    }

    public AbstractDraweeControllerBuilder setControllerListener(ControllerListener controllerListener) {
        this.mControllerListener = controllerListener;
        return getThis();
    }

    public String getContentDescription() {
        return this.mContentDescription;
    }

    public AbstractDraweeControllerBuilder setOldController(DraweeController draweeController) {
        this.mOldController = draweeController;
        return getThis();
    }

    public DraweeController getOldController() {
        return this.mOldController;
    }

    public AbstractDraweeController build() {
        Object obj;
        validate();
        if (this.mImageRequest == null && this.mMultiImageRequests == null && (obj = this.mLowResImageRequest) != null) {
            this.mImageRequest = obj;
            this.mLowResImageRequest = null;
        }
        return buildController();
    }

    protected void validate() {
        boolean z = true;
        Preconditions.checkState(this.mMultiImageRequests == null || this.mImageRequest == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.mDataSourceSupplier != null && (this.mMultiImageRequests != null || this.mImageRequest != null || this.mLowResImageRequest != null)) {
            z = false;
        }
        Preconditions.checkState(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected AbstractDraweeController buildController() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("AbstractDraweeControllerBuilder#buildController");
        }
        AbstractDraweeController abstractDraweeControllerObtainController = obtainController();
        abstractDraweeControllerObtainController.setLogWithHighSamplingRate(isLogWithHighSamplingRate());
        abstractDraweeControllerObtainController.setRetainImageOnFailure(getRetainImageOnFailure());
        abstractDraweeControllerObtainController.setContentDescription(getContentDescription());
        getControllerViewportVisibilityListener();
        abstractDraweeControllerObtainController.setControllerViewportVisibilityListener(null);
        maybeBuildAndSetRetryManager(abstractDraweeControllerObtainController);
        maybeAttachListeners(abstractDraweeControllerObtainController);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return abstractDraweeControllerObtainController;
    }

    protected static String generateUniqueControllerId() {
        return String.valueOf(sIdCounter.getAndIncrement());
    }

    protected Supplier obtainDataSourceSupplier(DraweeController draweeController, String str) {
        Supplier firstAvailableDataSourceSupplier;
        Supplier supplier = this.mDataSourceSupplier;
        if (supplier != null) {
            return supplier;
        }
        Object obj = this.mImageRequest;
        if (obj != null) {
            firstAvailableDataSourceSupplier = getDataSourceSupplierForRequest(draweeController, str, obj);
        } else {
            Object[] objArr = this.mMultiImageRequests;
            firstAvailableDataSourceSupplier = objArr != null ? getFirstAvailableDataSourceSupplier(draweeController, str, objArr, this.mTryCacheOnlyFirst) : null;
        }
        if (firstAvailableDataSourceSupplier != null && this.mLowResImageRequest != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(firstAvailableDataSourceSupplier);
            arrayList.add(getDataSourceSupplierForRequest(draweeController, str, this.mLowResImageRequest));
            firstAvailableDataSourceSupplier = IncreasingQualityDataSourceSupplier.create(arrayList, false);
        }
        return firstAvailableDataSourceSupplier == null ? DataSources.getFailedDataSourceSupplier(NO_REQUEST_EXCEPTION) : firstAvailableDataSourceSupplier;
    }

    protected Supplier getFirstAvailableDataSourceSupplier(DraweeController draweeController, String str, Object[] objArr, boolean z) {
        ArrayList arrayList = new ArrayList(objArr.length * 2);
        if (z) {
            for (Object obj : objArr) {
                arrayList.add(getDataSourceSupplierForRequest(draweeController, str, obj, CacheLevel.BITMAP_MEMORY_CACHE));
            }
        }
        for (Object obj2 : objArr) {
            arrayList.add(getDataSourceSupplierForRequest(draweeController, str, obj2));
        }
        return FirstAvailableDataSourceSupplier.create(arrayList);
    }

    protected Supplier getDataSourceSupplierForRequest(DraweeController draweeController, String str, Object obj) {
        return getDataSourceSupplierForRequest(draweeController, str, obj, CacheLevel.FULL_FETCH);
    }

    protected Supplier getDataSourceSupplierForRequest(final DraweeController draweeController, final String str, final Object obj, final CacheLevel cacheLevel) {
        final Object callerContext = getCallerContext();
        return new Supplier() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            @Override // com.facebook.common.internal.Supplier
            public DataSource get() {
                return AbstractDraweeControllerBuilder.this.getDataSourceForRequest(draweeController, str, obj, callerContext, cacheLevel);
            }

            public String toString() {
                return Objects.toStringHelper(this).add("request", obj.toString()).toString();
            }
        };
    }

    protected void maybeAttachListeners(AbstractDraweeController abstractDraweeController) {
        Set set = this.mBoundControllerListeners;
        if (set != null) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                abstractDraweeController.addControllerListener((ControllerListener) it.next());
            }
        }
        Set set2 = this.mBoundControllerListeners2;
        if (set2 != null) {
            Iterator it2 = set2.iterator();
            while (it2.hasNext()) {
                abstractDraweeController.addControllerListener2((ControllerListener2) it2.next());
            }
        }
        ControllerListener controllerListener = this.mControllerListener;
        if (controllerListener != null) {
            abstractDraweeController.addControllerListener(controllerListener);
        }
        if (this.mAutoPlayAnimations) {
            abstractDraweeController.addControllerListener(sAutoPlayAnimationsListener);
        }
    }

    protected void maybeBuildAndSetRetryManager(AbstractDraweeController abstractDraweeController) {
        if (this.mTapToRetryEnabled) {
            abstractDraweeController.getRetryManager().setTapToRetryEnabled(this.mTapToRetryEnabled);
            maybeBuildAndSetGestureDetector(abstractDraweeController);
        }
    }

    protected void maybeBuildAndSetGestureDetector(AbstractDraweeController abstractDraweeController) {
        if (abstractDraweeController.getGestureDetector() == null) {
            abstractDraweeController.setGestureDetector(GestureDetector.newInstance(this.mContext));
        }
    }
}
