package com.datadog.android.core.internal.persistence.file.advanced;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.persistence.DataWriter;
import com.datadog.android.core.internal.utils.ConcurrencyExtKt;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ScheduledWriter implements DataWriter {
    private final DataWriter delegateWriter;
    private final ExecutorService executorService;
    private final InternalLogger internalLogger;

    public ScheduledWriter(DataWriter delegateWriter, ExecutorService executorService, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(delegateWriter, "delegateWriter");
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.delegateWriter = delegateWriter;
        this.executorService = executorService;
        this.internalLogger = internalLogger;
    }

    @Override // com.datadog.android.core.internal.persistence.DataWriter
    public void write(final Object element) {
        Intrinsics.checkNotNullParameter(element, "element");
        ConcurrencyExtKt.executeSafe(this.executorService, "Data writing", this.internalLogger, new Runnable() { // from class: com.datadog.android.core.internal.persistence.file.advanced.ScheduledWriter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ScheduledWriter.write$lambda$0(this.f$0, element);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void write$lambda$0(ScheduledWriter this$0, Object element) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(element, "$element");
        this$0.delegateWriter.write(element);
    }
}
