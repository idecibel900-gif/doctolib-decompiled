package com.abovevacant.epitaph.core;

/* JADX INFO: loaded from: classes3.dex */
public final class LogMessage {
    public final String message;
    public final int pid;
    public final int priority;
    public final String tag;
    public final int tid;
    public final String timestamp;

    public LogMessage(String str, int i, int i2, int i3, String str2, String str3) {
        this.timestamp = str;
        this.pid = i;
        this.tid = i2;
        this.priority = i3;
        this.tag = str2;
        this.message = str3;
    }
}
