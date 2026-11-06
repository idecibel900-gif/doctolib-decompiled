package com.datadog.android.core.internal.data.upload;

import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.core.internal.persistence.BatchId;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpDataUploader implements DataUploader {
    @Override // com.datadog.android.core.internal.data.upload.DataUploader
    public UploadStatus upload(DatadogContext context, List batch, byte[] bArr, BatchId batchId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(batch, "batch");
        return UploadStatus.UnknownStatus.INSTANCE;
    }
}
