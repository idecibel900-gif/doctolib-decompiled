package io.sentry.android.core.util;

import android.content.Context;

/* JADX INFO: loaded from: classes5.dex */
public final class AndroidLazyEvaluator {
    private final AndroidEvaluator evaluator;
    private volatile Object value = null;

    public interface AndroidEvaluator {
        Object evaluate(Context context);
    }

    public AndroidLazyEvaluator(AndroidEvaluator androidEvaluator) {
        this.evaluator = androidEvaluator;
    }

    public Object getValue(Context context) {
        if (this.value == null) {
            synchronized (this) {
                try {
                    if (this.value == null) {
                        this.value = this.evaluator.evaluate(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.value;
    }
}
