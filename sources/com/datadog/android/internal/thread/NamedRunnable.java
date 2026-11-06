package com.datadog.android.internal.thread;

import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NamedRunnable implements Runnable {
    private final Runnable runnable;
    private final String sanitizedName;

    @Override // java.lang.Runnable
    public void run() {
        this.runnable.run();
    }

    public NamedRunnable(String name, Runnable runnable) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.runnable = runnable;
        String strReplace = NamedRunnableKt.SanitizedRegex.replace(name, "_");
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = strReplace.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        this.sanitizedName = lowerCase;
    }

    public final String getSanitizedName() {
        return this.sanitizedName;
    }
}
