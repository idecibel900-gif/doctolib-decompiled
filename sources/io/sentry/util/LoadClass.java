package io.sentry.util;

import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;

/* JADX INFO: loaded from: classes5.dex */
public class LoadClass {
    public Class loadClass(String str, ILogger iLogger) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            if (iLogger == null) {
                return null;
            }
            iLogger.log(SentryLevel.INFO, "Class not available: " + str, new Object[0]);
            return null;
        } catch (UnsatisfiedLinkError e) {
            if (iLogger == null) {
                return null;
            }
            iLogger.log(SentryLevel.ERROR, "Failed to load (UnsatisfiedLinkError) " + str, e);
            return null;
        } catch (Throwable th) {
            if (iLogger == null) {
                return null;
            }
            iLogger.log(SentryLevel.ERROR, "Failed to initialize " + str, th);
            return null;
        }
    }

    public boolean isClassAvailable(String str, ILogger iLogger) {
        return loadClass(str, iLogger) != null;
    }

    public boolean isClassAvailable(String str, SentryOptions sentryOptions) {
        return isClassAvailable(str, sentryOptions != null ? sentryOptions.getLogger() : null);
    }

    public LazyEvaluator isClassAvailableLazy(final String str, final ILogger iLogger) {
        return new LazyEvaluator(new LazyEvaluator.Evaluator() { // from class: io.sentry.util.LoadClass$$ExternalSyntheticLambda1
            @Override // io.sentry.util.LazyEvaluator.Evaluator
            public final Object evaluate() {
                return Boolean.valueOf(this.f$0.isClassAvailable(str, iLogger));
            }
        });
    }

    public LazyEvaluator isClassAvailableLazy(final String str, final SentryOptions sentryOptions) {
        return new LazyEvaluator(new LazyEvaluator.Evaluator() { // from class: io.sentry.util.LoadClass$$ExternalSyntheticLambda0
            @Override // io.sentry.util.LazyEvaluator.Evaluator
            public final Object evaluate() {
                return Boolean.valueOf(this.f$0.isClassAvailable(str, sentryOptions));
            }
        });
    }
}
