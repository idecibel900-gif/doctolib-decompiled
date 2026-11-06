package com.datadog.android.core.internal.time;

import com.datadog.android.api.InternalLogger;
import com.lyft.kronos.SyncListener;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class LoggingSyncListener implements SyncListener {
    private final InternalLogger internalLogger;

    @Override // com.lyft.kronos.SyncListener
    public void onStartSync(String host) {
        Intrinsics.checkNotNullParameter(host, "host");
    }

    @Override // com.lyft.kronos.SyncListener
    public void onSuccess(long j, long j2) {
    }

    public LoggingSyncListener(InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.internalLogger = internalLogger;
    }

    @Override // com.lyft.kronos.SyncListener
    public void onError(final String host, Throwable throwable) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, new Function0() { // from class: com.datadog.android.core.internal.time.LoggingSyncListener.onError.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Kronos onError @host:" + host;
            }
        }, throwable, false, (Map) null, 48, (Object) null);
    }
}
