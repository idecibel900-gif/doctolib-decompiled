package com.facebook.imagepipeline.datasource;

import com.facebook.common.internal.Preconditions;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.imagepipeline.listener.RequestListener2;
import com.facebook.imagepipeline.producers.BaseConsumer;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractProducerToDataSourceAdapter extends AbstractDataSource {
    private final RequestListener2 requestListener;
    private final SettableProducerContext settableProducerContext;

    public final SettableProducerContext getSettableProducerContext() {
        return this.settableProducerContext;
    }

    protected AbstractProducerToDataSourceAdapter(Producer producer, SettableProducerContext settableProducerContext, RequestListener2 requestListener) {
        Intrinsics.checkNotNullParameter(producer, "producer");
        Intrinsics.checkNotNullParameter(settableProducerContext, "settableProducerContext");
        Intrinsics.checkNotNullParameter(requestListener, "requestListener");
        this.settableProducerContext = settableProducerContext;
        this.requestListener = requestListener;
        if (!FrescoSystrace.isTracing()) {
            setExtras(settableProducerContext.getExtras());
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("AbstractProducerToDataSourceAdapter()->onRequestStart");
                try {
                    requestListener.onRequestStart(settableProducerContext);
                    Unit unit = Unit.INSTANCE;
                    FrescoSystrace.endSection();
                } catch (Throwable th) {
                    FrescoSystrace.endSection();
                    throw th;
                }
            } else {
                requestListener.onRequestStart(settableProducerContext);
            }
            if (!FrescoSystrace.isTracing()) {
                producer.produceResults(createConsumer(), settableProducerContext);
                return;
            }
            FrescoSystrace.beginSection("AbstractProducerToDataSourceAdapter()->produceResult");
            try {
                producer.produceResults(createConsumer(), settableProducerContext);
                Unit unit2 = Unit.INSTANCE;
                return;
            } finally {
                FrescoSystrace.endSection();
            }
        }
        FrescoSystrace.beginSection("AbstractProducerToDataSourceAdapter()");
        try {
            setExtras(settableProducerContext.getExtras());
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("AbstractProducerToDataSourceAdapter()->onRequestStart");
                try {
                    requestListener.onRequestStart(settableProducerContext);
                    Unit unit3 = Unit.INSTANCE;
                    FrescoSystrace.endSection();
                } catch (Throwable th2) {
                    FrescoSystrace.endSection();
                    throw th2;
                }
            } else {
                requestListener.onRequestStart(settableProducerContext);
            }
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("AbstractProducerToDataSourceAdapter()->produceResult");
                try {
                    producer.produceResults(createConsumer(), settableProducerContext);
                    Unit unit4 = Unit.INSTANCE;
                    FrescoSystrace.endSection();
                } finally {
                    FrescoSystrace.endSection();
                }
            } else {
                producer.produceResults(createConsumer(), settableProducerContext);
            }
            Unit unit5 = Unit.INSTANCE;
        } catch (Throwable th3) {
            FrescoSystrace.endSection();
            throw th3;
        }
    }

    private final Consumer createConsumer() {
        return new BaseConsumer() { // from class: com.facebook.imagepipeline.datasource.AbstractProducerToDataSourceAdapter.createConsumer.1
            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            protected void onNewResultImpl(Object obj, int i) {
                AbstractProducerToDataSourceAdapter abstractProducerToDataSourceAdapter = AbstractProducerToDataSourceAdapter.this;
                abstractProducerToDataSourceAdapter.onNewResultImpl(obj, i, abstractProducerToDataSourceAdapter.getSettableProducerContext());
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            protected void onFailureImpl(Throwable throwable) {
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                AbstractProducerToDataSourceAdapter.this.onFailureImpl(throwable);
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            protected void onCancellationImpl() {
                AbstractProducerToDataSourceAdapter.this.onCancellationImpl();
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            protected void onProgressUpdateImpl(float f) {
                AbstractProducerToDataSourceAdapter.this.setProgress(f);
            }
        };
    }

    protected void onNewResultImpl(Object obj, int i, ProducerContext producerContext) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        boolean zIsLast = BaseConsumer.isLast(i);
        if (super.setResult(obj, zIsLast, getExtras(producerContext)) && zIsLast) {
            this.requestListener.onRequestSuccess(this.settableProducerContext);
        }
    }

    protected final Map getExtras(ProducerContext producerContext) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        return producerContext.getExtras();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onFailureImpl(Throwable th) {
        if (super.setFailure(th, getExtras(this.settableProducerContext))) {
            this.requestListener.onRequestFailure(this.settableProducerContext, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void onCancellationImpl() {
        Preconditions.checkState(isClosed());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    public boolean close() {
        if (!super.close()) {
            return false;
        }
        if (super.isFinished()) {
            return true;
        }
        this.requestListener.onRequestCancellation(this.settableProducerContext);
        this.settableProducerContext.cancel();
        return true;
    }
}
