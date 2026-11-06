package io.sentry;

import io.sentry.protocol.SentryStackTrace;
import io.sentry.protocol.SentryThread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryThreadFactory {
    private final SentryStackTraceFactory sentryStackTraceFactory;

    public SentryThreadFactory(SentryStackTraceFactory sentryStackTraceFactory) {
        this.sentryStackTraceFactory = sentryStackTraceFactory;
    }

    List getCurrentThread(boolean z) {
        HashMap map = new HashMap();
        Thread threadCurrentThread = Thread.currentThread();
        map.put(threadCurrentThread, threadCurrentThread.getStackTrace());
        return getCurrentThreads(map, null, false, z);
    }

    List getCurrentThreads(List list, boolean z, boolean z2) {
        return getCurrentThreads(Thread.getAllStackTraces(), list, z, z2);
    }

    List getCurrentThreads(Map map, List list, boolean z, boolean z2) {
        Thread threadCurrentThread = Thread.currentThread();
        if (map.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!map.containsKey(threadCurrentThread)) {
            map.put(threadCurrentThread, threadCurrentThread.getStackTrace());
        }
        for (Map.Entry entry : map.entrySet()) {
            Thread thread = (Thread) entry.getKey();
            arrayList.add(getSentryThread((thread == threadCurrentThread && !z) || !(list == null || !list.contains(Long.valueOf(thread.getId())) || z), (StackTraceElement[]) entry.getValue(), (Thread) entry.getKey(), z2));
        }
        return arrayList;
    }

    private SentryThread getSentryThread(boolean z, StackTraceElement[] stackTraceElementArr, Thread thread, boolean z2) {
        List stackFrames;
        SentryThread sentryThread = new SentryThread();
        sentryThread.setName(thread.getName());
        sentryThread.setPriority(Integer.valueOf(thread.getPriority()));
        sentryThread.setId(Long.valueOf(thread.getId()));
        sentryThread.setDaemon(Boolean.valueOf(thread.isDaemon()));
        sentryThread.setState(thread.getState().name());
        sentryThread.setCrashed(Boolean.valueOf(z));
        if (z2 && (stackFrames = this.sentryStackTraceFactory.getStackFrames(stackTraceElementArr, false)) != null && !stackFrames.isEmpty()) {
            SentryStackTrace sentryStackTrace = new SentryStackTrace(stackFrames);
            sentryStackTrace.setSnapshot(Boolean.TRUE);
            sentryThread.setStacktrace(sentryStackTrace);
        }
        return sentryThread;
    }
}
