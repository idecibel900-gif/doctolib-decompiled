package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.io.InputStream;
import java.util.Map;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkFetchProducer implements Producer {
    private final ByteArrayPool mByteArrayPool;
    private final NetworkFetcher mNetworkFetcher;
    protected final PooledByteBufferFactory mPooledByteBufferFactory;

    public NetworkFetchProducer(PooledByteBufferFactory pooledByteBufferFactory, ByteArrayPool byteArrayPool, NetworkFetcher networkFetcher) {
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
        this.mByteArrayPool = byteArrayPool;
        this.mNetworkFetcher = networkFetcher;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer consumer, ProducerContext producerContext) {
        producerContext.getProducerListener().onProducerStart(producerContext, "NetworkFetchProducer");
        final FetchState fetchStateCreateFetchState = this.mNetworkFetcher.createFetchState(consumer, producerContext);
        this.mNetworkFetcher.fetch(fetchStateCreateFetchState, new NetworkFetcher.Callback() { // from class: com.facebook.imagepipeline.producers.NetworkFetchProducer.1
            @Override // com.facebook.imagepipeline.producers.NetworkFetcher.Callback
            public void onResponse(InputStream inputStream, int i) throws Throwable {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("NetworkFetcher->onResponse");
                }
                NetworkFetchProducer.this.onResponse(fetchStateCreateFetchState, inputStream, i);
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }

            @Override // com.facebook.imagepipeline.producers.NetworkFetcher.Callback
            public void onFailure(Throwable th) {
                NetworkFetchProducer.this.onFailure(fetchStateCreateFetchState, th);
            }

            @Override // com.facebook.imagepipeline.producers.NetworkFetcher.Callback
            public void onCancellation() {
                NetworkFetchProducer.this.onCancellation(fetchStateCreateFetchState);
            }
        });
    }

    protected void onResponse(FetchState fetchState, InputStream inputStream, int i) throws Throwable {
        PooledByteBufferOutputStream pooledByteBufferOutputStreamNewOutputStream;
        if (i > 0) {
            pooledByteBufferOutputStreamNewOutputStream = this.mPooledByteBufferFactory.newOutputStream(i);
        } else {
            pooledByteBufferOutputStreamNewOutputStream = this.mPooledByteBufferFactory.newOutputStream();
        }
        byte[] bArr = (byte[]) this.mByteArrayPool.get(Http2.INITIAL_MAX_FRAME_SIZE);
        while (true) {
            try {
                int i2 = inputStream.read(bArr);
                if (i2 < 0) {
                    this.mNetworkFetcher.onFetchCompletion(fetchState, pooledByteBufferOutputStreamNewOutputStream.size());
                    handleFinalResult(pooledByteBufferOutputStreamNewOutputStream, fetchState);
                    this.mByteArrayPool.release(bArr);
                    pooledByteBufferOutputStreamNewOutputStream.close();
                    return;
                }
                if (i2 > 0) {
                    pooledByteBufferOutputStreamNewOutputStream.write(bArr, 0, i2);
                    maybeHandleIntermediateResult(pooledByteBufferOutputStreamNewOutputStream, fetchState);
                    fetchState.getConsumer().onProgressUpdate(calculateProgress(pooledByteBufferOutputStreamNewOutputStream.size(), i));
                }
            } catch (Throwable th) {
                this.mByteArrayPool.release(bArr);
                pooledByteBufferOutputStreamNewOutputStream.close();
                throw th;
            }
        }
    }

    protected static float calculateProgress(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp(((double) (-i)) / 50000.0d));
    }

    protected void maybeHandleIntermediateResult(PooledByteBufferOutputStream pooledByteBufferOutputStream, FetchState fetchState) throws Throwable {
        if (shouldPropagateIntermediateResults(fetchState, fetchState.getContext())) {
            long systemUptime = getSystemUptime();
            if (systemUptime - fetchState.getLastIntermediateResultTimeMs() >= 100) {
                fetchState.setLastIntermediateResultTimeMs(systemUptime);
                fetchState.getListener().onProducerEvent(fetchState.getContext(), "NetworkFetchProducer", "intermediate_result");
                notifyConsumer(pooledByteBufferOutputStream, fetchState.getOnNewResultStatusFlags(), fetchState.getResponseBytesRange(), fetchState.getConsumer(), fetchState.getContext());
            }
        }
    }

    protected void handleFinalResult(PooledByteBufferOutputStream pooledByteBufferOutputStream, FetchState fetchState) throws Throwable {
        Map extraMap = getExtraMap(fetchState, pooledByteBufferOutputStream.size());
        ProducerListener2 listener = fetchState.getListener();
        listener.onProducerFinishWithSuccess(fetchState.getContext(), "NetworkFetchProducer", extraMap);
        listener.onUltimateProducerReached(fetchState.getContext(), "NetworkFetchProducer", true);
        fetchState.getContext().putOriginExtra("network");
        notifyConsumer(pooledByteBufferOutputStream, fetchState.getOnNewResultStatusFlags() | 1, fetchState.getResponseBytesRange(), fetchState.getConsumer(), fetchState.getContext());
    }

    protected static void notifyConsumer(PooledByteBufferOutputStream pooledByteBufferOutputStream, int i, BytesRange bytesRange, Consumer consumer, ProducerContext producerContext) throws Throwable {
        CloseableReference closeableReferenceOf = CloseableReference.of(pooledByteBufferOutputStream.toByteBuffer());
        EncodedImage encodedImage = null;
        try {
            EncodedImage encodedImage2 = new EncodedImage(closeableReferenceOf);
            try {
                encodedImage2.setBytesRange(bytesRange);
                encodedImage2.parseMetaData();
                consumer.onNewResult(encodedImage2, i);
                EncodedImage.closeSafely(encodedImage2);
                CloseableReference.closeSafely(closeableReferenceOf);
            } catch (Throwable th) {
                th = th;
                encodedImage = encodedImage2;
                EncodedImage.closeSafely(encodedImage);
                CloseableReference.closeSafely(closeableReferenceOf);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFailure(FetchState fetchState, Throwable th) {
        fetchState.getListener().onProducerFinishWithFailure(fetchState.getContext(), "NetworkFetchProducer", th, null);
        fetchState.getListener().onUltimateProducerReached(fetchState.getContext(), "NetworkFetchProducer", false);
        fetchState.getContext().putOriginExtra("network");
        fetchState.getConsumer().onFailure(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCancellation(FetchState fetchState) {
        fetchState.getListener().onProducerFinishWithCancellation(fetchState.getContext(), "NetworkFetchProducer", null);
        fetchState.getConsumer().onCancellation();
    }

    private boolean shouldPropagateIntermediateResults(FetchState fetchState, ProducerContext producerContext) {
        ProgressiveJpegConfig progressiveJpegConfig = producerContext.getImagePipelineConfig().getProgressiveJpegConfig();
        if (progressiveJpegConfig != null && progressiveJpegConfig.decodeProgressively() && fetchState.getContext().isIntermediateResultExpected()) {
            return this.mNetworkFetcher.shouldPropagate(fetchState);
        }
        return false;
    }

    private Map getExtraMap(FetchState fetchState, int i) {
        if (fetchState.getListener().requiresExtraMap(fetchState.getContext(), "NetworkFetchProducer")) {
            return this.mNetworkFetcher.getExtraMap(fetchState, i);
        }
        return null;
    }

    protected long getSystemUptime() {
        return SystemClock.uptimeMillis();
    }
}
