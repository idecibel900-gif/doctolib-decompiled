package io.sentry.android.replay.util;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ContextKt {
    public static final Context appContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }
}
