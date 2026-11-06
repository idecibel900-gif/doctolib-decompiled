package io.sentry.android.core.anr;

import com.amazon.a.a.o.b.f;
import io.sentry.protocol.SentryStackFrame;
import io.sentry.protocol.profiling.SentryProfile;
import io.sentry.protocol.profiling.SentrySample;
import io.sentry.protocol.profiling.SentryThreadMetadata;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class StackTraceConverter {
    public static SentryProfile convert(AnrProfile anrProfile) {
        List<AnrStackTrace> list = anrProfile.stacks;
        SentryProfile sentryProfile = new SentryProfile();
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        HashMap map2 = new HashMap();
        for (AnrStackTrace anrStackTrace : list) {
            StackTraceElement[] stackTraceElementArr = anrStackTrace.stack;
            ArrayList arrayList3 = new ArrayList();
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                String strCreateFrameSignature = createFrameSignature(stackTraceElement);
                Integer numValueOf = (Integer) map.get(strCreateFrameSignature);
                if (numValueOf == null) {
                    numValueOf = Integer.valueOf(arrayList.size());
                    arrayList.add(createSentryStackFrame(stackTraceElement));
                    map.put(strCreateFrameSignature, numValueOf);
                }
                arrayList3.add(numValueOf);
            }
            String strCreateStackSignature = createStackSignature(arrayList3);
            Integer numValueOf2 = (Integer) map2.get(strCreateStackSignature);
            if (numValueOf2 == null) {
                numValueOf2 = Integer.valueOf(arrayList2.size());
                arrayList2.add(new ArrayList(arrayList3));
                map2.put(strCreateStackSignature, numValueOf2);
            }
            SentrySample sentrySample = new SentrySample();
            sentrySample.setTimestamp(anrStackTrace.timestampMs / 1000.0d);
            sentrySample.setStackId(numValueOf2.intValue());
            sentrySample.setThreadId("0");
            sentryProfile.getSamples().add(sentrySample);
        }
        sentryProfile.setFrames(arrayList);
        sentryProfile.setStacks(arrayList2);
        SentryThreadMetadata sentryThreadMetadata = new SentryThreadMetadata();
        sentryThreadMetadata.setName("main");
        sentryThreadMetadata.setPriority(5);
        sentryProfile.setThreadMetadata(Collections.singletonMap("0", sentryThreadMetadata));
        return sentryProfile;
    }

    private static String createFrameSignature(StackTraceElement stackTraceElement) {
        return stackTraceElement.getClassName() + "#" + stackTraceElement.getMethodName() + "#" + stackTraceElement.getFileName() + "#" + stackTraceElement.getLineNumber();
    }

    private static String createStackSignature(List list) {
        StringBuilder sb = new StringBuilder();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (sb.length() > 0) {
                sb.append(f.a);
            }
            sb.append(num);
        }
        return sb.toString();
    }

    private static SentryStackFrame createSentryStackFrame(StackTraceElement stackTraceElement) {
        SentryStackFrame sentryStackFrame = new SentryStackFrame();
        sentryStackFrame.setFilename(stackTraceElement.getFileName());
        sentryStackFrame.setFunction(stackTraceElement.getMethodName());
        sentryStackFrame.setModule(stackTraceElement.getClassName());
        sentryStackFrame.setLineno(stackTraceElement.getLineNumber() > 0 ? Integer.valueOf(stackTraceElement.getLineNumber()) : null);
        if (stackTraceElement.isNativeMethod()) {
            sentryStackFrame.setNative(Boolean.TRUE);
        }
        return sentryStackFrame;
    }
}
