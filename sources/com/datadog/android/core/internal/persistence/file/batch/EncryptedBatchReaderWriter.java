package com.datadog.android.core.internal.persistence.file.batch;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.storage.RawBatchEvent;
import com.datadog.android.security.Encryption;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class EncryptedBatchReaderWriter implements BatchFileReaderWriter {
    public static final Companion Companion = new Companion(null);
    private final BatchFileReaderWriter delegate;
    private final InternalLogger internalLogger;

    public EncryptedBatchReaderWriter(Encryption encryption, BatchFileReaderWriter delegate, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(encryption, "encryption");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.delegate = delegate;
        this.internalLogger = internalLogger;
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileWriter
    public boolean writeData(File file, RawBatchEvent data, boolean z) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(data, "data");
        data.getData();
        throw null;
    }

    @Override // com.datadog.android.core.internal.persistence.file.batch.BatchFileReader
    public List readData(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        List<RawBatchEvent> data = this.delegate.readData(file);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(data, 10));
        for (RawBatchEvent rawBatchEvent : data) {
            if (!(rawBatchEvent.getData().length == 0)) {
                rawBatchEvent.getData();
                throw null;
            }
            byte[] data2 = rawBatchEvent.getData();
            if (!(rawBatchEvent.getMetadata().length == 0)) {
                rawBatchEvent.getMetadata();
                throw null;
            }
            arrayList.add(new RawBatchEvent(data2, rawBatchEvent.getMetadata()));
        }
        return arrayList;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
