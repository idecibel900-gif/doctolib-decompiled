package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ListenerHolders {
    public static ListenerHolder createListenerHolder(Object obj, Looper looper, String str) {
        Preconditions.checkNotNull(obj, "Listener must not be null");
        Preconditions.checkNotNull(looper, "Looper must not be null");
        Preconditions.checkNotNull(str, "Listener type must not be null");
        return new ListenerHolder(looper, obj, str);
    }

    public static ListenerHolder.ListenerKey createListenerKey(Object obj, String str) {
        Preconditions.checkNotNull(obj, "Listener must not be null");
        Preconditions.checkNotNull(str, "Listener type must not be null");
        Preconditions.checkNotEmpty(str, "Listener type must not be empty");
        return new ListenerHolder.ListenerKey(obj, str);
    }

    public static ListenerHolder createListenerHolder(Object obj, Executor executor, String str) {
        Preconditions.checkNotNull(obj, "Listener must not be null");
        Preconditions.checkNotNull(executor, "Executor must not be null");
        Preconditions.checkNotNull(str, "Listener type must not be null");
        return new ListenerHolder(executor, obj, str);
    }
}
