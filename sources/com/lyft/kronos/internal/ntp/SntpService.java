package com.lyft.kronos.internal.ntp;

import com.lyft.kronos.KronosTime;

/* JADX INFO: loaded from: classes4.dex */
public interface SntpService {
    KronosTime currentTime();

    void shutdown();

    void syncInBackground();
}
