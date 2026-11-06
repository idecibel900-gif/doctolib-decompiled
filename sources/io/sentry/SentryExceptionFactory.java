package io.sentry;

import io.sentry.exception.ExceptionMechanismException;
import io.sentry.protocol.Mechanism;
import io.sentry.protocol.SentryException;
import io.sentry.protocol.SentryStackTrace;
import io.sentry.protocol.SentryThread;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryExceptionFactory {
    private final SentryStackTraceFactory sentryStackTraceFactory;

    public SentryExceptionFactory(SentryStackTraceFactory sentryStackTraceFactory) {
        this.sentryStackTraceFactory = sentryStackTraceFactory;
    }

    public List getSentryExceptionsFromThread(SentryThread sentryThread, Mechanism mechanism, Throwable th) {
        SentryStackTrace stacktrace = sentryThread.getStacktrace();
        if (stacktrace == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(getSentryException(th, mechanism, sentryThread.getId(), stacktrace.getFrames(), true));
        return arrayList;
    }

    public List getSentryExceptions(Throwable th) {
        return getSentryExceptions(extractExceptionQueue(th));
    }

    private List getSentryExceptions(Deque deque) {
        return new ArrayList(deque);
    }

    private SentryException getSentryException(Throwable th, Mechanism mechanism, Long l, List list, boolean z) {
        Package r0 = th.getClass().getPackage();
        String name = th.getClass().getName();
        SentryException sentryException = new SentryException();
        String message = th.getMessage();
        if (r0 != null) {
            name = name.replace(r0.getName() + ".", "");
        }
        String name2 = r0 != null ? r0.getName() : null;
        if (list != null && !list.isEmpty()) {
            SentryStackTrace sentryStackTrace = new SentryStackTrace(list);
            if (z) {
                sentryStackTrace.setSnapshot(Boolean.TRUE);
            }
            sentryException.setStacktrace(sentryStackTrace);
        }
        sentryException.setThreadId(l);
        sentryException.setType(name);
        sentryException.setMechanism(mechanism);
        sentryException.setModule(name2);
        sentryException.setValue(message);
        return sentryException;
    }

    Deque extractExceptionQueue(Throwable th) {
        return extractExceptionQueueInternal(th, new AtomicInteger(-1), new HashSet(), new ArrayDeque(), null);
    }

    Deque extractExceptionQueueInternal(Throwable th, AtomicInteger atomicInteger, HashSet hashSet, Deque deque, String str) {
        Mechanism mechanism;
        Thread threadCurrentThread;
        Throwable th2;
        boolean zIsSnapshot;
        String str2 = str;
        int i = atomicInteger.get();
        Throwable cause = th;
        while (cause != null) {
            HashSet hashSet2 = hashSet;
            if (!hashSet2.add(cause)) {
                break;
            }
            if (str2 == null) {
                str2 = "chained";
            }
            int i2 = 0;
            if (cause instanceof ExceptionMechanismException) {
                ExceptionMechanismException exceptionMechanismException = (ExceptionMechanismException) cause;
                mechanism = exceptionMechanismException.getExceptionMechanism();
                Throwable throwable = exceptionMechanismException.getThrowable();
                threadCurrentThread = exceptionMechanismException.getThread();
                zIsSnapshot = exceptionMechanismException.isSnapshot();
                th2 = throwable;
            } else {
                mechanism = new Mechanism();
                threadCurrentThread = Thread.currentThread();
                th2 = cause;
                zIsSnapshot = false;
            }
            Mechanism mechanism2 = mechanism;
            deque.addFirst(getSentryException(th2, mechanism2, threadCurrentThread != null ? Long.valueOf(threadCurrentThread.getId()) : null, this.sentryStackTraceFactory.getStackFrames(th2.getStackTrace(), Boolean.FALSE.equals(mechanism2.isHandled())), zIsSnapshot));
            if (mechanism2.getType() == null) {
                mechanism2.setType(str2);
            }
            if (atomicInteger.get() >= 0) {
                mechanism2.setParentId(Integer.valueOf(i));
            }
            int iIncrementAndGet = atomicInteger.incrementAndGet();
            mechanism2.setExceptionId(Integer.valueOf(iIncrementAndGet));
            Throwable[] suppressed = th2.getSuppressed();
            if (suppressed != null && suppressed.length > 0) {
                int length = suppressed.length;
                while (i2 < length) {
                    extractExceptionQueueInternal(suppressed[i2], atomicInteger, hashSet2, deque, "suppressed");
                    i2++;
                    hashSet2 = hashSet;
                    deque = deque;
                }
            }
            cause = th2.getCause();
            str2 = null;
            i = iIncrementAndGet;
        }
        return deque;
    }
}
