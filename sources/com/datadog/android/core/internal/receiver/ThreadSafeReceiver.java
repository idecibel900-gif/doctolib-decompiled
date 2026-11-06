package com.datadog.android.core.internal.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ThreadSafeReceiver extends BroadcastReceiver {
    public static final Companion Companion = new Companion(null);
    private final AtomicBoolean isRegistered = new AtomicBoolean(false);

    public final Intent registerReceiver(Context context, IntentFilter filter) {
        Intent intentRegisterReceiver;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(filter, "filter");
        int i = Build.VERSION.SDK_INT;
        if (i >= 33 || i >= 26) {
            intentRegisterReceiver = context.registerReceiver(this, filter, 4);
        } else {
            intentRegisterReceiver = context.registerReceiver(this, filter);
        }
        this.isRegistered.set(true);
        return intentRegisterReceiver;
    }

    public final void unregisterReceiver(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.isRegistered.compareAndSet(true, false)) {
            context.unregisterReceiver(this);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
