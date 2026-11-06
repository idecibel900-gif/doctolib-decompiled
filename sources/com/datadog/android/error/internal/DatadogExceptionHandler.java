package com.datadog.android.error.internal;

import android.content.Context;
import androidx.work.WorkManager;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.core.InternalSdkCore;
import com.datadog.android.core.feature.event.JvmCrash;
import com.datadog.android.core.feature.event.ThreadDump;
import com.datadog.android.core.internal.thread.ThreadPoolExecutorExtKt;
import com.datadog.android.core.internal.utils.WorkManagerUtilsKt;
import com.datadog.android.internal.utils.ThreadExtKt;
import com.datadog.android.internal.utils.ThrowableExtKt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class DatadogExceptionHandler implements Thread.UncaughtExceptionHandler {
    public static final Companion Companion = new Companion(null);
    private final WeakReference contextRef;
    private Thread.UncaughtExceptionHandler previousHandler;
    private final FeatureSdkCore sdkCore;

    public DatadogExceptionHandler(FeatureSdkCore sdkCore, Context appContext) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.sdkCore = sdkCore;
        this.contextRef = new WeakReference(appContext);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread t, Throwable e) {
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(e, "e");
        List threadDumps = getThreadDumps(t, e);
        FeatureScope feature = this.sdkCore.getFeature("logs");
        if (feature != null) {
            String name = t.getName();
            Intrinsics.checkNotNullExpressionValue(name, "t.name");
            feature.sendEvent(new JvmCrash.Logs(name, e, System.currentTimeMillis(), createCrashMessage(e), "crash", threadDumps));
        } else {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.INFO, InternalLogger.Target.USER, (Function0) new Function0() { // from class: com.datadog.android.error.internal.DatadogExceptionHandler.uncaughtException.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Logs feature is not registered, won't report crash as log.";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
        FeatureScope feature2 = this.sdkCore.getFeature("rum");
        if (feature2 != null) {
            feature2.sendEvent(new JvmCrash.Rum(e, createCrashMessage(e), threadDumps));
        } else {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.INFO, InternalLogger.Target.USER, (Function0) new Function0() { // from class: com.datadog.android.error.internal.DatadogExceptionHandler.uncaughtException.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "RUM feature is not registered, won't report crash as RUM event.";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
        FeatureSdkCore featureSdkCore = this.sdkCore;
        if (featureSdkCore instanceof InternalSdkCore) {
            ExecutorService persistenceExecutorService = ((InternalSdkCore) featureSdkCore).getPersistenceExecutorService();
            ThreadPoolExecutor threadPoolExecutor = persistenceExecutorService instanceof ThreadPoolExecutor ? (ThreadPoolExecutor) persistenceExecutorService : null;
            if (!(threadPoolExecutor != null ? ThreadPoolExecutorExtKt.waitToIdle(threadPoolExecutor, 100L, this.sdkCore.getInternalLogger()) : true)) {
                InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0() { // from class: com.datadog.android.error.internal.DatadogExceptionHandler.uncaughtException.3
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Datadog SDK is in an unexpected state due to an ongoing crash. Some events could be lost.";
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
            }
        }
        Context context = (Context) this.contextRef.get();
        if (context != null && WorkManager.isInitialized()) {
            WorkManagerUtilsKt.triggerUploadWorker(context, this.sdkCore.getName(), this.sdkCore.getInternalLogger());
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.previousHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(t, e);
        }
    }

    public final void register() {
        this.previousHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    private final String createCrashMessage(Throwable th) {
        String message = th.getMessage();
        if (message != null && !StringsKt.isBlank(message)) {
            return message;
        }
        String canonicalName = th.getClass().getCanonicalName();
        if (canonicalName == null) {
            canonicalName = th.getClass().getSimpleName();
        }
        return "Application crash detected: " + canonicalName;
    }

    private final List getThreadDumps(Thread thread, Throwable th) {
        String name = thread.getName();
        Thread.State state = thread.getState();
        Intrinsics.checkNotNullExpressionValue(state, "crashedThread.state");
        String strAsString = ThreadExtKt.asString(state);
        String strLoggableStackTrace = ThrowableExtKt.loggableStackTrace(th);
        Intrinsics.checkNotNullExpressionValue(name, "name");
        List listMutableListOf = CollectionsKt.mutableListOf(new ThreadDump(name, strAsString, strLoggableStackTrace, true));
        Map mapSafeGetAllStacktraces = safeGetAllStacktraces();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : mapSafeGetAllStacktraces.entrySet()) {
            if (!Intrinsics.areEqual((Thread) entry.getKey(), thread)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        Iterator it = linkedHashMap.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry2 = (Map.Entry) it.next();
            if (!(((StackTraceElement[]) entry2.getValue()).length == 0)) {
                linkedHashMap2.put(entry2.getKey(), entry2.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap2.size());
        for (Map.Entry entry3 : linkedHashMap2.entrySet()) {
            Thread thread2 = (Thread) entry3.getKey();
            StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) entry3.getValue();
            String name2 = thread2.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "thread.name");
            Thread.State state2 = thread2.getState();
            Intrinsics.checkNotNullExpressionValue(state2, "thread.state");
            arrayList.add(new ThreadDump(name2, ThreadExtKt.asString(state2), ThreadExtKt.loggableStackTrace(stackTraceElementArr), false));
        }
        return CollectionsKt.plus((Collection) listMutableListOf, (Iterable) arrayList);
    }

    private final Map safeGetAllStacktraces() {
        try {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            Intrinsics.checkNotNullExpressionValue(allStackTraces, "{\n            Thread.getAllStackTraces()\n        }");
            return allStackTraces;
        } catch (Throwable th) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0() { // from class: com.datadog.android.error.internal.DatadogExceptionHandler.safeGetAllStacktraces.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to get all threads dump";
                }
            }, th, false, (Map) null, 48, (Object) null);
            return MapsKt.emptyMap();
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
