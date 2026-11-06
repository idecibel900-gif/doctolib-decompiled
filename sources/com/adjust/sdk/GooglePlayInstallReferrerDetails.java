package com.adjust.sdk;

/* JADX INFO: loaded from: classes3.dex */
public class GooglePlayInstallReferrerDetails {
    public Boolean googlePlayInstant;
    public long installBeginTimestampSeconds;
    public long installBeginTimestampServerSeconds;
    public String installReferrer;
    public String installVersion;
    public long referrerClickTimestampSeconds;
    public long referrerClickTimestampServerSeconds;

    public GooglePlayInstallReferrerDetails(ReferrerDetails referrerDetails) {
        if (referrerDetails == null) {
            return;
        }
        this.installReferrer = referrerDetails.installReferrer;
        this.referrerClickTimestampSeconds = referrerDetails.referrerClickTimestampSeconds;
        this.installBeginTimestampSeconds = referrerDetails.installBeginTimestampSeconds;
        this.referrerClickTimestampServerSeconds = referrerDetails.referrerClickTimestampServerSeconds;
        this.installBeginTimestampServerSeconds = referrerDetails.installBeginTimestampServerSeconds;
        this.installVersion = referrerDetails.installVersion;
        this.googlePlayInstant = referrerDetails.googlePlayInstant;
    }

    public String toString() {
        return Util.formatString(" installReferrer : %s referrerClickTimestampSeconds : %d installBeginTimestampSeconds : %d referrerClickTimestampServerSeconds : %d installBeginTimestampServerSeconds : %d installVersion : %s googlePlayInstant : %s", this.installReferrer, Long.valueOf(this.referrerClickTimestampSeconds), Long.valueOf(this.installBeginTimestampSeconds), Long.valueOf(this.referrerClickTimestampServerSeconds), Long.valueOf(this.installBeginTimestampServerSeconds), this.installVersion, this.googlePlayInstant);
    }
}
