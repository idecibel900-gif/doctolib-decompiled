package com.datadog.android.log.internal.logger;

import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpLogHandler implements LogHandler {
    @Override // com.datadog.android.log.internal.logger.LogHandler
    public void handleLog(int i, String message, String str, String str2, String str3, Map attributes, Set tags, Long l) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(tags, "tags");
    }

    @Override // com.datadog.android.log.internal.logger.LogHandler
    public void handleLog(int i, String message, Throwable th, Map attributes, Set tags, Long l) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(tags, "tags");
    }
}
