package com.datadog.android.log.internal.logger;

import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public interface LogHandler {
    void handleLog(int i, String str, String str2, String str3, String str4, Map map, Set set, Long l);

    void handleLog(int i, String str, Throwable th, Map map, Set set, Long l);
}
