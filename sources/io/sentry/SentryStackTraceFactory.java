package io.sentry;

import io.sentry.protocol.SentryStackFrame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryStackTraceFactory {
    private final SentryOptions options;

    public SentryStackTraceFactory(SentryOptions sentryOptions) {
        this.options = sentryOptions;
    }

    public List getStackFrames(StackTraceElement[] stackTraceElementArr, boolean z) {
        if (stackTraceElementArr == null || stackTraceElementArr.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            if (stackTraceElement != null) {
                String className = stackTraceElement.getClassName();
                if (z || !className.startsWith("io.sentry.") || className.startsWith("io.sentry.samples.") || className.startsWith("io.sentry.mobile.")) {
                    SentryStackFrame sentryStackFrame = new SentryStackFrame();
                    sentryStackFrame.setInApp(isInApp(className));
                    sentryStackFrame.setModule(className);
                    sentryStackFrame.setFunction(stackTraceElement.getMethodName());
                    sentryStackFrame.setFilename(stackTraceElement.getFileName());
                    if (stackTraceElement.getLineNumber() >= 0) {
                        sentryStackFrame.setLineno(Integer.valueOf(stackTraceElement.getLineNumber()));
                    }
                    sentryStackFrame.setNative(Boolean.valueOf(stackTraceElement.isNativeMethod()));
                    arrayList.add(sentryStackFrame);
                    if (arrayList.size() >= 100) {
                        break;
                    }
                }
            }
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    public static Boolean isInApp(String str, List list, List list2) {
        if (str == null || str.isEmpty()) {
            return Boolean.TRUE;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (str.startsWith((String) it.next())) {
                return Boolean.TRUE;
            }
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            if (str.startsWith((String) it2.next())) {
                return Boolean.FALSE;
            }
        }
        return null;
    }

    public Boolean isInApp(String str) {
        return isInApp(str, this.options.getInAppIncludes(), this.options.getInAppExcludes());
    }
}
