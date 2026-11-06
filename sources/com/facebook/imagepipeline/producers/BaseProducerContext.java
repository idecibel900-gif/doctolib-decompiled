package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableSet;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.core.ImagePipelineConfigInterface;
import com.facebook.imagepipeline.request.ImageRequest;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class BaseProducerContext implements ProducerContext {
    private final List mCallbacks;
    private final Object mCallerContext;
    private final Map mExtras;
    private final String mId;
    private final ImagePipelineConfigInterface mImagePipelineConfig;
    private final ImageRequest mImageRequest;
    private boolean mIsCancelled;
    private boolean mIsIntermediateResultExpected;
    private boolean mIsPrefetch;
    private final ImageRequest.RequestLevel mLowestPermittedRequestLevel;
    private Priority mPriority;
    private final ProducerListener2 mProducerListener;
    private final String mUiComponentId;
    public static final Set INITIAL_KEYS = ImmutableSet.of((Object[]) new String[]{DiagnosticsEntry.ID_KEY, "uri_source"});
    public static final Object CALLER_CONTEXT_UNSET = new Object();

    public BaseProducerContext(ImageRequest imageRequest, String str, ProducerListener2 producerListener2, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority, ImagePipelineConfigInterface imagePipelineConfigInterface) {
        this(imageRequest, str, null, null, producerListener2, obj, requestLevel, z, z2, priority, imagePipelineConfigInterface);
    }

    public BaseProducerContext(ImageRequest imageRequest, String str, String str2, Map map, ProducerListener2 producerListener2, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority, ImagePipelineConfigInterface imagePipelineConfigInterface) {
        this.mImageRequest = imageRequest;
        this.mId = str;
        HashMap map2 = new HashMap();
        this.mExtras = map2;
        map2.put(DiagnosticsEntry.ID_KEY, str);
        map2.put("uri_source", imageRequest == null ? "null-request" : imageRequest.getSourceUri());
        putExtras(map);
        this.mUiComponentId = str2;
        this.mProducerListener = producerListener2;
        this.mCallerContext = obj == null ? CALLER_CONTEXT_UNSET : obj;
        this.mLowestPermittedRequestLevel = requestLevel;
        this.mIsPrefetch = z;
        this.mPriority = priority;
        this.mIsIntermediateResultExpected = z2;
        this.mIsCancelled = false;
        this.mCallbacks = new ArrayList();
        this.mImagePipelineConfig = imagePipelineConfigInterface;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public ImageRequest getImageRequest() {
        return this.mImageRequest;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public String getUiComponentId() {
        return this.mUiComponentId;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public ProducerListener2 getProducerListener() {
        return this.mProducerListener;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public Object getCallerContext() {
        return this.mCallerContext;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public ImageRequest.RequestLevel getLowestPermittedRequestLevel() {
        return this.mLowestPermittedRequestLevel;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public synchronized boolean isPrefetch() {
        return this.mIsPrefetch;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public synchronized Priority getPriority() {
        return this.mPriority;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public synchronized boolean isIntermediateResultExpected() {
        return this.mIsIntermediateResultExpected;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public void addCallbacks(ProducerContextCallbacks producerContextCallbacks) {
        boolean z;
        synchronized (this) {
            this.mCallbacks.add(producerContextCallbacks);
            z = this.mIsCancelled;
        }
        if (z) {
            producerContextCallbacks.onCancellationRequested();
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public ImagePipelineConfigInterface getImagePipelineConfig() {
        return this.mImagePipelineConfig;
    }

    public void cancel() {
        callOnCancellationRequested(cancelNoCallbacks());
    }

    public synchronized List setIsPrefetchNoCallbacks(boolean z) {
        if (z == this.mIsPrefetch) {
            return null;
        }
        this.mIsPrefetch = z;
        return new ArrayList(this.mCallbacks);
    }

    public synchronized List setPriorityNoCallbacks(Priority priority) {
        if (priority == this.mPriority) {
            return null;
        }
        this.mPriority = priority;
        return new ArrayList(this.mCallbacks);
    }

    public synchronized List setIsIntermediateResultExpectedNoCallbacks(boolean z) {
        if (z == this.mIsIntermediateResultExpected) {
            return null;
        }
        this.mIsIntermediateResultExpected = z;
        return new ArrayList(this.mCallbacks);
    }

    public synchronized List cancelNoCallbacks() {
        if (this.mIsCancelled) {
            return null;
        }
        this.mIsCancelled = true;
        return new ArrayList(this.mCallbacks);
    }

    public static void callOnCancellationRequested(List list) {
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((ProducerContextCallbacks) it.next()).onCancellationRequested();
        }
    }

    public static void callOnIsPrefetchChanged(List list) {
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((ProducerContextCallbacks) it.next()).onIsPrefetchChanged();
        }
    }

    public static void callOnIsIntermediateResultExpectedChanged(List list) {
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((ProducerContextCallbacks) it.next()).onIsIntermediateResultExpectedChanged();
        }
    }

    public static void callOnPriorityChanged(List list) {
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((ProducerContextCallbacks) it.next()).onPriorityChanged();
        }
    }

    @Override // com.facebook.fresco.middleware.HasExtraData
    public void putExtra(String str, Object obj) {
        if (INITIAL_KEYS.contains(str)) {
            return;
        }
        this.mExtras.put(str, obj);
    }

    @Override // com.facebook.fresco.middleware.HasExtraData
    public void putExtras(Map map) {
        if (map == null) {
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            putExtra((String) entry.getKey(), entry.getValue());
        }
    }

    @Override // com.facebook.fresco.middleware.HasExtraData
    public Object getExtra(String str) {
        return this.mExtras.get(str);
    }

    @Override // com.facebook.fresco.middleware.HasExtraData
    public Map getExtras() {
        return this.mExtras;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public void putOriginExtra(String str, String str2) {
        this.mExtras.put("origin", str);
        this.mExtras.put("origin_sub", str2);
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public void putOriginExtra(String str) {
        putOriginExtra(str, "default");
    }
}
