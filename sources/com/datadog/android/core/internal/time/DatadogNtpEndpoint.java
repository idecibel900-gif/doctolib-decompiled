package com.datadog.android.core.internal.time;

/* JADX INFO: loaded from: classes3.dex */
public enum DatadogNtpEndpoint {
    NTP_0("0.datadog.pool.ntp.org"),
    NTP_1("1.datadog.pool.ntp.org"),
    NTP_2("2.datadog.pool.ntp.org"),
    NTP_3("3.datadog.pool.ntp.org");

    private final String host;

    DatadogNtpEndpoint(String str) {
        this.host = str;
    }

    public final String getHost() {
        return this.host;
    }
}
