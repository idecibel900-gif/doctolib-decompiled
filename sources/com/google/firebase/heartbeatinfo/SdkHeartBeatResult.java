package com.google.firebase.heartbeatinfo;

import com.google.auto.value.AutoValue;

/* JADX INFO: loaded from: classes3.dex */
@AutoValue
public abstract class SdkHeartBeatResult implements Comparable<SdkHeartBeatResult> {
    public abstract long getMillis();

    public abstract String getSdkName();

    public static SdkHeartBeatResult create(String str, long j) {
        return new AutoValue_SdkHeartBeatResult(str, j);
    }

    @Override // java.lang.Comparable
    public int compareTo(SdkHeartBeatResult sdkHeartBeatResult) {
        return getMillis() < sdkHeartBeatResult.getMillis() ? -1 : 1;
    }
}
