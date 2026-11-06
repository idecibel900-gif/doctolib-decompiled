package com.lyft.kronos;

/* JADX INFO: loaded from: classes4.dex */
public interface SyncListener {
    void onError(String str, Throwable th);

    void onStartSync(String str);

    void onSuccess(long j, long j2);
}
