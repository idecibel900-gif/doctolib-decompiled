package com.datadog.android.rum.internal.anr;

import android.os.Handler;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.core.feature.event.ThreadDump;
import com.datadog.android.internal.utils.ThreadExtKt;
import com.datadog.android.internal.utils.ThrowableExtKt;
import com.datadog.android.rum.GlobalRumMonitor;
import com.datadog.android.rum.RumErrorSource;
import com.revenuecat.purchases.common.networking.HTTPTimeoutManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ANRDetectorRunnable implements Runnable {
    public static final Companion Companion = new Companion(null);
    private final long anrTestDelayMs;
    private final long anrThresholdMs;
    private final Handler handler;
    private final FeatureSdkCore sdkCore;
    private boolean shouldStop;

    public ANRDetectorRunnable(FeatureSdkCore sdkCore, Handler handler, long j, long j2) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.sdkCore = sdkCore;
        this.handler = handler;
        this.anrThresholdMs = j;
        this.anrTestDelayMs = j2;
    }

    public /* synthetic */ ANRDetectorRunnable(FeatureSdkCore featureSdkCore, Handler handler, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(featureSdkCore, handler, (i & 4) != 0 ? HTTPTimeoutManager.SUPPORTED_FALLBACK_TIMEOUT_MS : j, (i & 8) != 0 ? 500L : j2);
    }

    @Override // java.lang.Runnable
    public void run() {
        while (!Thread.interrupted() && !this.shouldStop) {
            try {
                CallbackRunnable callbackRunnable = new CallbackRunnable();
                synchronized (callbackRunnable) {
                    try {
                        if (!this.handler.post(callbackRunnable)) {
                            return;
                        }
                        callbackRunnable.wait(this.anrThresholdMs);
                        if (!callbackRunnable.wasCalled()) {
                            Thread thread = this.handler.getLooper().getThread();
                            Intrinsics.checkNotNullExpressionValue(thread, "handler.looper.thread");
                            ANRException aNRException = new ANRException(thread);
                            String name = thread.getName();
                            Intrinsics.checkNotNullExpressionValue(name, "anrThread.name");
                            Thread.State state = thread.getState();
                            Intrinsics.checkNotNullExpressionValue(state, "anrThread.state");
                            List listMutableListOf = CollectionsKt.mutableListOf(new ThreadDump(name, ThreadExtKt.asString(state), ThrowableExtKt.loggableStackTrace(aNRException), false));
                            Map mapSafeGetAllStacktraces = safeGetAllStacktraces();
                            LinkedHashMap linkedHashMap = new LinkedHashMap();
                            for (Map.Entry entry : mapSafeGetAllStacktraces.entrySet()) {
                                if (!Intrinsics.areEqual((Thread) entry.getKey(), thread)) {
                                    linkedHashMap.put(entry.getKey(), entry.getValue());
                                }
                            }
                            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                                if (!(((StackTraceElement[]) entry2.getValue()).length == 0)) {
                                    linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                                }
                            }
                            ArrayList arrayList = new ArrayList(linkedHashMap2.size());
                            Iterator it = linkedHashMap2.entrySet().iterator();
                            while (it.hasNext()) {
                                Thread thread2 = (Thread) ((Map.Entry) it.next()).getKey();
                                String name2 = thread2.getName();
                                Intrinsics.checkNotNullExpressionValue(name2, "thread.name");
                                Thread.State state2 = thread2.getState();
                                Intrinsics.checkNotNullExpressionValue(state2, "thread.state");
                                String strAsString = ThreadExtKt.asString(state2);
                                StackTraceElement[] stackTrace = thread2.getStackTrace();
                                Intrinsics.checkNotNullExpressionValue(stackTrace, "thread.stackTrace");
                                arrayList.add(new ThreadDump(name2, strAsString, ThreadExtKt.loggableStackTrace(stackTrace), false));
                            }
                            GlobalRumMonitor.get(this.sdkCore).addError("Application Not Responding", RumErrorSource.SOURCE, aNRException, MapsKt.mapOf(TuplesKt.to("_dd.error.threads", CollectionsKt.plus((Collection) listMutableListOf, (Iterable) arrayList))));
                            callbackRunnable.wait();
                        }
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                long j = this.anrTestDelayMs;
                if (j > 0) {
                    Thread.sleep(j);
                }
            } catch (InterruptedException unused) {
                return;
            }
        }
    }

    public final void stop() {
        this.shouldStop = true;
    }

    private final Map safeGetAllStacktraces() {
        try {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            Intrinsics.checkNotNullExpressionValue(allStackTraces, "{\n            Thread.getAllStackTraces()\n        }");
            return allStackTraces;
        } catch (Throwable th) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0() { // from class: com.datadog.android.rum.internal.anr.ANRDetectorRunnable.safeGetAllStacktraces.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to get all stack traces.";
                }
            }, th, false, (Map) null, 48, (Object) null);
            return MapsKt.emptyMap();
        }
    }

    public static final class CallbackRunnable implements Runnable {
        private boolean called;

        @Override // java.lang.Runnable
        public synchronized void run() {
            this.called = true;
            notifyAll();
        }

        public final boolean wasCalled() {
            return this.called;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
