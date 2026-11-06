package com.datadog.android.core.internal.persistence.file.batch;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.persistence.file.FileWriter;
import com.datadog.android.security.Encryption;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public interface BatchFileReaderWriter extends FileWriter, BatchFileReader {
    public static final Companion Companion = Companion.$$INSTANCE;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final BatchFileReaderWriter create(InternalLogger internalLogger, Encryption encryption) {
            Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
            PlainBatchFileReaderWriter plainBatchFileReaderWriter = new PlainBatchFileReaderWriter(internalLogger);
            return encryption == null ? plainBatchFileReaderWriter : new EncryptedBatchReaderWriter(encryption, plainBatchFileReaderWriter, internalLogger);
        }
    }
}
