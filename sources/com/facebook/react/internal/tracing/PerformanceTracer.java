package com.facebook.react.internal.tracing;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.soloader.SoLoader;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@DoNotStrip
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001#B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0087 ¢\u0006\u0004\b\u000b\u0010\fJ2\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0087 ¢\u0006\u0004\b\u000f\u0010\u0010JF\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0087 ¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018H\u0087 ¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH\u0087 ¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010!\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001dH\u0087 ¢\u0006\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/facebook/react/internal/tracing/PerformanceTracer;", "", "<init>", "()V", "", "name", "", "timestampNanos", "Lcom/facebook/react/bridge/ReadableNativeMap;", "detail", "", "reportMark", "(Ljava/lang/String;JLcom/facebook/react/bridge/ReadableNativeMap;)V", "startTimestampNanos", "durationNanos", "reportMeasure", "(Ljava/lang/String;JJLcom/facebook/react/bridge/ReadableNativeMap;)V", "startTimeNanos", "endTimeNanos", "trackName", "trackGroup", "color", "reportTimeStamp", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "isTracing", "()Z", "Lcom/facebook/react/internal/tracing/PerformanceTracer$TracingStateCallback;", "callback", "", "subscribeToTracingStateChanges", "(Lcom/facebook/react/internal/tracing/PerformanceTracer$TracingStateCallback;)I", "subscriptionId", "unsubscribeFromTracingStateChanges", "(I)V", "TracingStateCallback", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PerformanceTracer {
    public static final PerformanceTracer INSTANCE = new PerformanceTracer();

    @DoNotStrip
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lcom/facebook/react/internal/tracing/PerformanceTracer$TracingStateCallback;", "", "onTracingStateChanged", "", "isTracing", "", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface TracingStateCallback {
        @DoNotStrip
        void onTracingStateChanged(boolean isTracing);
    }

    @DoNotStrip
    public static final native boolean isTracing();

    @DoNotStrip
    public static final native void reportMark(String name, long timestampNanos, ReadableNativeMap detail);

    @DoNotStrip
    public static final native void reportMeasure(String name, long startTimestampNanos, long durationNanos, ReadableNativeMap detail);

    @DoNotStrip
    public static final native void reportTimeStamp(String name, long startTimeNanos, long endTimeNanos, String trackName, String trackGroup, String color);

    @DoNotStrip
    public static final native int subscribeToTracingStateChanges(TracingStateCallback callback);

    @DoNotStrip
    public static final native void unsubscribeFromTracingStateChanges(int subscriptionId);

    private PerformanceTracer() {
    }

    static {
        SoLoader.loadLibrary("react_performancetracerjni");
    }
}
