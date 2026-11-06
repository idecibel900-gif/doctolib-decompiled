package com.datadog.android.core.internal.persistence;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.api.storage.EventType;
import com.datadog.android.api.storage.RawBatchEvent;
import com.datadog.android.core.internal.persistence.file.FilePersistenceConfig;
import com.datadog.android.core.internal.persistence.file.FileReaderWriter;
import com.datadog.android.core.internal.persistence.file.FileWriter;
import java.io.File;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class FileEventBatchWriter implements EventBatchWriter {
    public static final Companion Companion = new Companion(null);
    private final File batchFile;
    private final BatchWriteEventListener batchWriteEventListener;
    private final FileWriter eventsWriter;
    private final FilePersistenceConfig filePersistenceConfig;
    private final InternalLogger internalLogger;
    private final File metadataFile;
    private final FileReaderWriter metadataReaderWriter;

    public FileEventBatchWriter(File batchFile, File file, FileWriter eventsWriter, FileReaderWriter metadataReaderWriter, FilePersistenceConfig filePersistenceConfig, BatchWriteEventListener batchWriteEventListener, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(batchFile, "batchFile");
        Intrinsics.checkNotNullParameter(eventsWriter, "eventsWriter");
        Intrinsics.checkNotNullParameter(metadataReaderWriter, "metadataReaderWriter");
        Intrinsics.checkNotNullParameter(filePersistenceConfig, "filePersistenceConfig");
        Intrinsics.checkNotNullParameter(batchWriteEventListener, "batchWriteEventListener");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.batchFile = batchFile;
        this.metadataFile = file;
        this.eventsWriter = eventsWriter;
        this.metadataReaderWriter = metadataReaderWriter;
        this.filePersistenceConfig = filePersistenceConfig;
        this.batchWriteEventListener = batchWriteEventListener;
        this.internalLogger = internalLogger;
    }

    @Override // com.datadog.android.api.storage.EventBatchWriter
    public boolean write(RawBatchEvent event, byte[] bArr, EventType eventType) {
        File file;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        if (event.getData().length == 0) {
            return true;
        }
        if (!checkEventSize(event.getData().length) || !this.eventsWriter.writeData(this.batchFile, event, true)) {
            return false;
        }
        this.batchWriteEventListener.onWriteEvent(event.getData().length);
        if (bArr != null) {
            if ((!(bArr.length == 0)) && (file = this.metadataFile) != null) {
                writeBatchMetadata(file, bArr);
            }
        }
        return true;
    }

    private final boolean checkEventSize(final int i) {
        if (i <= this.filePersistenceConfig.getMaxItemSize()) {
            return true;
        }
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.android.core.internal.persistence.FileEventBatchWriter.checkEventSize.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str = String.format(Locale.US, "Can't write data with size %d (max item size is %d)", Arrays.copyOf(new Object[]{Integer.valueOf(i), Long.valueOf(this.filePersistenceConfig.getMaxItemSize())}, 2));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                return str;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
        return false;
    }

    private final void writeBatchMetadata(final File file, byte[] bArr) {
        if (this.metadataReaderWriter.writeData(file, bArr, false)) {
            return;
        }
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.android.core.internal.persistence.FileEventBatchWriter.writeBatchMetadata.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str = String.format(Locale.US, "Unable to write metadata file: %s", Arrays.copyOf(new Object[]{file.getPath()}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                return str;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
