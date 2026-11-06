package com.datadog.android.core.internal.persistence.file;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.security.Encryption;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public interface FileReaderWriter extends FileWriter, FileReader {
    public static final Companion Companion = Companion.$$INSTANCE;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final FileReaderWriter create(InternalLogger internalLogger, Encryption encryption) {
            Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
            PlainFileReaderWriter plainFileReaderWriter = new PlainFileReaderWriter(internalLogger);
            return encryption == null ? plainFileReaderWriter : new EncryptedFileReaderWriter(encryption, plainFileReaderWriter, internalLogger);
        }
    }
}
