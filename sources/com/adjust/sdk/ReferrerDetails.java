package com.adjust.sdk;

/* JADX INFO: loaded from: classes3.dex */
public class ReferrerDetails {
    public Boolean googlePlayInstant;
    public long installBeginTimestampSeconds;
    public long installBeginTimestampServerSeconds;
    public String installReferrer;
    public String installVersion;
    public Boolean isClick;
    public long referrerClickTimestampSeconds;
    public long referrerClickTimestampServerSeconds;

    public ReferrerDetails(String str, long j, long j2, long j3, long j4, String str2, Boolean bool, Boolean bool2) {
        this.installReferrer = str;
        this.referrerClickTimestampSeconds = j;
        this.installBeginTimestampSeconds = j2;
        this.referrerClickTimestampServerSeconds = j3;
        this.installBeginTimestampServerSeconds = j4;
        this.installVersion = str2;
        this.googlePlayInstant = bool;
        this.isClick = bool2;
    }

    public String toString() {
        return Util.formatString(" installReferrer : %s referrerClickTimestampSeconds : %d installBeginTimestampSeconds : %d referrerClickTimestampServerSeconds : %d installBeginTimestampServerSeconds : %d installVersion : %s googlePlayInstant : %s isClick: %s", this.installReferrer, Long.valueOf(this.referrerClickTimestampSeconds), Long.valueOf(this.installBeginTimestampSeconds), Long.valueOf(this.referrerClickTimestampServerSeconds), Long.valueOf(this.installBeginTimestampServerSeconds), this.installVersion, this.googlePlayInstant, this.isClick);
    }

    public ReferrerDetails(String str, long j, long j2) {
        this(str, j, j2, -1L, -1L, null, null, null);
    }

    public ReferrerDetails(String str, long j, Boolean bool) {
        this(str, j, -1L, -1L, -1L, null, null, bool);
    }
}
