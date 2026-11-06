package com.datadog.android.core.internal.data.upload;

import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.core.internal.persistence.BatchId;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface DataUploader {
    UploadStatus upload(DatadogContext datadogContext, List list, byte[] bArr, BatchId batchId);
}
