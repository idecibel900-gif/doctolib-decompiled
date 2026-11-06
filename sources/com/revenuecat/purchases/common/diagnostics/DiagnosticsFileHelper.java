package com.revenuecat.purchases.common.diagnostics;

import com.revenuecat.purchases.common.FileHelper;
import com.revenuecat.purchases.utils.EventsFileHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsFileHelper;", "Lcom/revenuecat/purchases/utils/EventsFileHelper;", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsEntry;", "fileHelper", "Lcom/revenuecat/purchases/common/FileHelper;", "(Lcom/revenuecat/purchases/common/FileHelper;)V", "diagnosticsFileSize", "", "isDiagnosticsFileBigEnoughToSync", "", "isDiagnosticsFileTooBig", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DiagnosticsFileHelper extends EventsFileHelper<DiagnosticsEntry> {
    public static final int DIAGNOSTICS_FILE_LIMIT_IN_KB = 500;
    public static final String DIAGNOSTICS_FILE_PATH = "RevenueCat/diagnostics/diagnostic_entries.jsonl";
    public static final int DIAGNOSTICS_FILE_SYNC_LIMIT_IN_KB = 200;
    private final FileHelper fileHelper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiagnosticsFileHelper(FileHelper fileHelper) {
        super(fileHelper, DIAGNOSTICS_FILE_PATH, null, null, 8, null);
        Intrinsics.checkNotNullParameter(fileHelper, "fileHelper");
        this.fileHelper = fileHelper;
    }

    public final synchronized boolean isDiagnosticsFileTooBig() {
        return diagnosticsFileSize() > 500.0d;
    }

    public final synchronized boolean isDiagnosticsFileBigEnoughToSync() {
        return diagnosticsFileSize() > 200.0d;
    }

    private final double diagnosticsFileSize() {
        return this.fileHelper.fileSizeInKB(DIAGNOSTICS_FILE_PATH);
    }
}
