package com.google.android.gms.common.api;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PendingResult {

    public interface StatusListener {
        void onComplete(Status status);
    }

    public abstract void addStatusListener(StatusListener statusListener);

    public abstract Result await(long j, TimeUnit timeUnit);
}
