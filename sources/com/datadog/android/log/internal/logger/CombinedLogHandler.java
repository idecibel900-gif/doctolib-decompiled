package com.datadog.android.log.internal.logger;

import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class CombinedLogHandler implements LogHandler {
    private final LogHandler[] handlers;

    public CombinedLogHandler(LogHandler... handlers) {
        Intrinsics.checkNotNullParameter(handlers, "handlers");
        this.handlers = handlers;
    }

    @Override // com.datadog.android.log.internal.logger.LogHandler
    public void handleLog(int i, String message, Throwable th, Map attributes, Set tags, Long l) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(tags, "tags");
        for (LogHandler logHandler : this.handlers) {
            logHandler.handleLog(i, message, th, attributes, tags, l);
        }
    }

    @Override // com.datadog.android.log.internal.logger.LogHandler
    public void handleLog(int i, String message, String str, String str2, String str3, Map map, Set set, Long l) {
        Intrinsics.checkNotNullParameter(message, "message");
        Map attributes = map;
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Set tags = set;
        Intrinsics.checkNotNullParameter(tags, "tags");
        LogHandler[] logHandlerArr = this.handlers;
        int length = logHandlerArr.length;
        int i2 = 0;
        while (i2 < length) {
            logHandlerArr[i2].handleLog(i, message, str, str2, str3, attributes, tags, l);
            i2++;
            attributes = map;
            tags = set;
        }
    }
}
