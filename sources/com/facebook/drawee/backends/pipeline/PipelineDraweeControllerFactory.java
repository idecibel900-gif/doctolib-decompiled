package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Supplier;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public class PipelineDraweeControllerFactory {
    private DrawableFactory mAnimatedDrawableFactory;
    private Supplier mDebugOverlayEnabledSupplier;
    private DeferredReleaser mDeferredReleaser;
    private ImmutableList mDrawableFactories;
    private MemoryCache mMemoryCache;
    private Resources mResources;
    private Executor mUiThreadExecutor;
    private DrawableFactory mXmlDrawableFactory;

    public void init(Resources resources, DeferredReleaser deferredReleaser, DrawableFactory drawableFactory, DrawableFactory drawableFactory2, Executor executor, MemoryCache memoryCache, ImmutableList immutableList, Supplier supplier) {
        this.mResources = resources;
        this.mDeferredReleaser = deferredReleaser;
        this.mAnimatedDrawableFactory = drawableFactory;
        this.mXmlDrawableFactory = drawableFactory2;
        this.mUiThreadExecutor = executor;
        this.mMemoryCache = memoryCache;
        this.mDrawableFactories = immutableList;
        this.mDebugOverlayEnabledSupplier = supplier;
    }

    public PipelineDraweeController newController() {
        PipelineDraweeController pipelineDraweeControllerInternalCreateController = internalCreateController(this.mResources, this.mDeferredReleaser, this.mAnimatedDrawableFactory, this.mXmlDrawableFactory, this.mUiThreadExecutor, this.mMemoryCache, this.mDrawableFactories);
        Supplier supplier = this.mDebugOverlayEnabledSupplier;
        if (supplier != null) {
            pipelineDraweeControllerInternalCreateController.setDrawDebugOverlay(((Boolean) supplier.get()).booleanValue());
        }
        return pipelineDraweeControllerInternalCreateController;
    }

    protected PipelineDraweeController internalCreateController(Resources resources, DeferredReleaser deferredReleaser, DrawableFactory drawableFactory, DrawableFactory drawableFactory2, Executor executor, MemoryCache memoryCache, ImmutableList immutableList) {
        return new PipelineDraweeController(resources, deferredReleaser, drawableFactory, drawableFactory2, executor, memoryCache, immutableList);
    }
}
