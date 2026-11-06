package com.lyft.kronos;

/* JADX INFO: loaded from: classes4.dex */
public interface SyncResponseCache {
    void clear();

    long getCurrentOffset();

    long getCurrentTime();

    long getElapsedTime();

    void setCurrentOffset(long j);

    void setCurrentTime(long j);

    void setElapsedTime(long j);
}
