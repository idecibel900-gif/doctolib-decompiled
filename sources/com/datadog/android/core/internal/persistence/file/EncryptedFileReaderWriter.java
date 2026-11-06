package com.datadog.android.core.internal.persistence.file;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.security.Encryption;
import java.io.File;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class EncryptedFileReaderWriter implements FileReaderWriter {
    public static final Companion Companion = new Companion(null);
    private final FileReaderWriter delegate;
    private final InternalLogger internalLogger;

    public EncryptedFileReaderWriter(Encryption encryption, FileReaderWriter delegate, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(encryption, "encryption");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.delegate = delegate;
        this.internalLogger = internalLogger;
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileWriter
    public boolean writeData(File file, byte[] data, boolean z) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(data, "data");
        if (z) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0() { // from class: com.datadog.android.core.internal.persistence.file.EncryptedFileReaderWriter.writeData.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Append mode is not supported, use EncryptedBatchFileReaderWriter instead.";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return false;
        }
        throw null;
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileReader
    public byte[] readData(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        throw null;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
