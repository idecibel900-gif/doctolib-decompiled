package com.lyft.kronos.internal.ntp;

/* JADX INFO: loaded from: classes4.dex */
public interface SntpResponseCache {
    void clear();

    SntpClient.Response get();

    void update(SntpClient.Response response);
}
