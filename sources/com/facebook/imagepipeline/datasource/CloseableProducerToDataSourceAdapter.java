package com.facebook.imagepipeline.datasource;

import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.listener.RequestListener2;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.systrace.FrescoSystrace;

/* JADX INFO: loaded from: classes3.dex */
public class CloseableProducerToDataSourceAdapter extends AbstractProducerToDataSourceAdapter {
    public static DataSource create(Producer producer, SettableProducerContext settableProducerContext, RequestListener2 requestListener2) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("CloseableProducerToDataSourceAdapter#create");
        }
        CloseableProducerToDataSourceAdapter closeableProducerToDataSourceAdapter = new CloseableProducerToDataSourceAdapter(producer, settableProducerContext, requestListener2);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return closeableProducerToDataSourceAdapter;
    }

    private CloseableProducerToDataSourceAdapter(Producer producer, SettableProducerContext settableProducerContext, RequestListener2 requestListener2) {
        super(producer, settableProducerContext, requestListener2);
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    public CloseableReference getResult() {
        return CloseableReference.cloneOrNull((CloseableReference) super.getResult());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.datasource.AbstractDataSource
    public void closeResult(CloseableReference closeableReference) {
        CloseableReference.closeSafely(closeableReference);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.datasource.AbstractProducerToDataSourceAdapter
    public void onNewResultImpl(CloseableReference closeableReference, int i, ProducerContext producerContext) {
        super.onNewResultImpl((Object) CloseableReference.cloneOrNull(closeableReference), i, producerContext);
    }
}
