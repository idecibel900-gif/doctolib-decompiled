package io.sentry.backpressure;

/* JADX INFO: loaded from: classes5.dex */
public interface IBackpressureMonitor {
    void close();

    int getDownsampleFactor();

    void start();
}
