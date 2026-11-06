package io.sentry.android.core;

import io.sentry.SentryDate;
import io.sentry.SentryDateProvider;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AndroidDateUtils {
    private static final SentryDateProvider dateProvider = new SentryAndroidDateProvider();

    public static SentryDate getCurrentSentryDateTime() {
        return dateProvider.now();
    }
}
