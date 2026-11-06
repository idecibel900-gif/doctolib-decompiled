package io.sentry.util;

import io.sentry.Hint;
import io.sentry.ILogger;
import io.sentry.hints.ApplyScopeData;
import io.sentry.hints.Backfillable;
import io.sentry.hints.Cached;
import io.sentry.hints.EventDropReason;

/* JADX INFO: loaded from: classes5.dex */
public abstract class HintUtils {

    public interface SentryConsumer {
        void accept(Object obj);
    }

    public interface SentryHintFallback {
        void accept(Object obj, Class cls);
    }

    public static /* synthetic */ void $r8$lambda$OUcjqrtILP5lzF84olFtQrhh_4U(Object obj, Class cls) {
    }

    public static void setIsFromHybridSdk(Hint hint, String str) {
        if (str.startsWith("sentry.javascript") || str.startsWith("sentry.dart") || str.startsWith("sentry.dotnet")) {
            hint.set("sentry:isFromHybridSdk", Boolean.TRUE);
        }
    }

    public static boolean isFromHybridSdk(Hint hint) {
        return Boolean.TRUE.equals(hint.getAs("sentry:isFromHybridSdk", Boolean.class));
    }

    public static void setEventDropReason(Hint hint, EventDropReason eventDropReason) {
        hint.set("sentry:eventDropReason", eventDropReason);
    }

    public static EventDropReason getEventDropReason(Hint hint) {
        return (EventDropReason) hint.getAs("sentry:eventDropReason", EventDropReason.class);
    }

    public static Hint createWithTypeCheckHint(Object obj) {
        Hint hint = new Hint();
        setTypeCheckHint(hint, obj);
        return hint;
    }

    public static void setTypeCheckHint(Hint hint, Object obj) {
        hint.set("sentry:typeCheckHint", obj);
    }

    public static Object getSentrySdkHint(Hint hint) {
        return hint.get("sentry:typeCheckHint");
    }

    public static boolean hasType(Hint hint, Class cls) {
        return cls.isInstance(getSentrySdkHint(hint));
    }

    public static void runIfHasType(Hint hint, Class cls, SentryConsumer sentryConsumer) {
        runIfHasType(hint, cls, sentryConsumer, new SentryHintFallback() { // from class: io.sentry.util.HintUtils$$ExternalSyntheticLambda0
            @Override // io.sentry.util.HintUtils.SentryHintFallback
            public final void accept(Object obj, Class cls2) {
                HintUtils.$r8$lambda$OUcjqrtILP5lzF84olFtQrhh_4U(obj, cls2);
            }
        });
    }

    public static void runIfHasTypeLogIfNot(Hint hint, Class cls, final ILogger iLogger, SentryConsumer sentryConsumer) {
        runIfHasType(hint, cls, sentryConsumer, new SentryHintFallback() { // from class: io.sentry.util.HintUtils$$ExternalSyntheticLambda1
            @Override // io.sentry.util.HintUtils.SentryHintFallback
            public final void accept(Object obj, Class cls2) {
                LogUtils.logNotInstanceOf(cls2, obj, iLogger);
            }
        });
    }

    public static void runIfHasType(Hint hint, Class cls, SentryConsumer sentryConsumer, SentryHintFallback sentryHintFallback) {
        Object sentrySdkHint = getSentrySdkHint(hint);
        if (hasType(hint, cls) && sentrySdkHint != null) {
            sentryConsumer.accept(sentrySdkHint);
        } else {
            sentryHintFallback.accept(sentrySdkHint, cls);
        }
    }

    public static boolean shouldApplyScopeData(Hint hint) {
        return !(hasType(hint, Cached.class) || hasType(hint, Backfillable.class)) || hasType(hint, ApplyScopeData.class);
    }
}
