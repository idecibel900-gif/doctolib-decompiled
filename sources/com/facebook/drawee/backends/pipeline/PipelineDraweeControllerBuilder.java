package com.facebook.drawee.backends.pipeline;

import android.content.Context;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableList;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.fresco.ui.common.ImagePerfDataListener;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class PipelineDraweeControllerBuilder extends AbstractDraweeControllerBuilder {
    private ImmutableList mCustomDrawableFactories;
    private final ImagePipeline mImagePipeline;
    private final PipelineDraweeControllerFactory mPipelineDraweeControllerFactory;

    public PipelineDraweeControllerBuilder(Context context, PipelineDraweeControllerFactory pipelineDraweeControllerFactory, ImagePipeline imagePipeline, Set set, Set set2) {
        super(context, set, set2);
        this.mImagePipeline = imagePipeline;
        this.mPipelineDraweeControllerFactory = pipelineDraweeControllerFactory;
    }

    public PipelineDraweeControllerBuilder setPerfDataListener(ImagePerfDataListener imagePerfDataListener) {
        return (PipelineDraweeControllerBuilder) getThis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public PipelineDraweeController obtainController() {
        PipelineDraweeController pipelineDraweeControllerNewController;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("PipelineDraweeControllerBuilder#obtainController");
        }
        try {
            DraweeController oldController = getOldController();
            String strGenerateUniqueControllerId = AbstractDraweeControllerBuilder.generateUniqueControllerId();
            if (oldController instanceof PipelineDraweeController) {
                pipelineDraweeControllerNewController = (PipelineDraweeController) oldController;
            } else {
                pipelineDraweeControllerNewController = this.mPipelineDraweeControllerFactory.newController();
            }
            PipelineDraweeController pipelineDraweeController = pipelineDraweeControllerNewController;
            pipelineDraweeController.initialize(obtainDataSourceSupplier(pipelineDraweeController, strGenerateUniqueControllerId), strGenerateUniqueControllerId, getCacheKey(), getCallerContext(), this.mCustomDrawableFactories);
            pipelineDraweeController.initializePerformanceMonitoring(null, this);
            return pipelineDraweeController;
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    private CacheKey getCacheKey() {
        ImageRequest imageRequest = (ImageRequest) getImageRequest();
        CacheKeyFactory cacheKeyFactory = this.mImagePipeline.getCacheKeyFactory();
        if (cacheKeyFactory == null || imageRequest == null) {
            return null;
        }
        if (imageRequest.getPostprocessor() != null) {
            return cacheKeyFactory.getPostprocessedBitmapCacheKey(imageRequest, getCallerContext());
        }
        return cacheKeyFactory.getBitmapCacheKey(imageRequest, getCallerContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public DataSource getDataSourceForRequest(DraweeController draweeController, String str, ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.mImagePipeline.fetchDecodedImage(imageRequest, obj, convertCacheLevelToRequestLevel(cacheLevel), getRequestListener(draweeController), str);
    }

    protected RequestListener getRequestListener(DraweeController draweeController) {
        if (draweeController instanceof PipelineDraweeController) {
            return ((PipelineDraweeController) draweeController).getRequestListener();
        }
        return null;
    }

    /* JADX INFO: renamed from: com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$drawee$controller$AbstractDraweeControllerBuilder$CacheLevel;

        static {
            int[] iArr = new int[AbstractDraweeControllerBuilder.CacheLevel.values().length];
            $SwitchMap$com$facebook$drawee$controller$AbstractDraweeControllerBuilder$CacheLevel = iArr;
            try {
                iArr[AbstractDraweeControllerBuilder.CacheLevel.FULL_FETCH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$drawee$controller$AbstractDraweeControllerBuilder$CacheLevel[AbstractDraweeControllerBuilder.CacheLevel.DISK_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$drawee$controller$AbstractDraweeControllerBuilder$CacheLevel[AbstractDraweeControllerBuilder.CacheLevel.BITMAP_MEMORY_CACHE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static ImageRequest.RequestLevel convertCacheLevelToRequestLevel(AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        int i = AnonymousClass1.$SwitchMap$com$facebook$drawee$controller$AbstractDraweeControllerBuilder$CacheLevel[cacheLevel.ordinal()];
        if (i == 1) {
            return ImageRequest.RequestLevel.FULL_FETCH;
        }
        if (i == 2) {
            return ImageRequest.RequestLevel.DISK_CACHE;
        }
        if (i == 3) {
            return ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE;
        }
        throw new RuntimeException("Cache level" + cacheLevel + "is not supported. ");
    }
}
