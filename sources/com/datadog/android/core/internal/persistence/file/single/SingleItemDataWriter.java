package com.datadog.android.core.internal.persistence.file.single;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.persistence.DataWriter;
import com.datadog.android.core.internal.persistence.file.FileOrchestrator;
import com.datadog.android.core.internal.persistence.file.FilePersistenceConfig;
import com.datadog.android.core.internal.persistence.file.FileWriter;
import com.datadog.android.core.persistence.Serializer;
import com.datadog.android.core.persistence.SerializerKt;
import java.io.File;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SingleItemDataWriter implements DataWriter {
    public static final Companion Companion = new Companion(null);
    private final FileOrchestrator fileOrchestrator;
    private final FilePersistenceConfig filePersistenceConfig;
    private final FileWriter fileWriter;
    private final InternalLogger internalLogger;
    private final Serializer serializer;

    public SingleItemDataWriter(FileOrchestrator fileOrchestrator, Serializer serializer, FileWriter fileWriter, InternalLogger internalLogger, FilePersistenceConfig filePersistenceConfig) {
        Intrinsics.checkNotNullParameter(fileOrchestrator, "fileOrchestrator");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(fileWriter, "fileWriter");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(filePersistenceConfig, "filePersistenceConfig");
        this.fileOrchestrator = fileOrchestrator;
        this.serializer = serializer;
        this.fileWriter = fileWriter;
        this.internalLogger = internalLogger;
        this.filePersistenceConfig = filePersistenceConfig;
    }

    public final FilePersistenceConfig getFilePersistenceConfig$dd_sdk_android_core_release() {
        return this.filePersistenceConfig;
    }

    @Override // com.datadog.android.core.internal.persistence.DataWriter
    public void write(Object element) {
        Intrinsics.checkNotNullParameter(element, "element");
        consume(element);
    }

    private final void consume(Object obj) {
        byte[] bArrSerializeToByteArray = SerializerKt.serializeToByteArray(this.serializer, obj, this.internalLogger);
        if (bArrSerializeToByteArray == null) {
            return;
        }
        synchronized (this) {
            writeData(bArrSerializeToByteArray);
        }
    }

    private final boolean writeData(byte[] bArr) {
        File writableFile$default;
        if (checkEventSize(bArr.length) && (writableFile$default = FileOrchestrator.DefaultImpls.getWritableFile$default(this.fileOrchestrator, false, 1, null)) != null) {
            return this.fileWriter.writeData(writableFile$default, bArr, false);
        }
        return false;
    }

    private final boolean checkEventSize(final int i) {
        if (i <= this.filePersistenceConfig.getMaxItemSize()) {
            return true;
        }
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), new Function0() { // from class: com.datadog.android.core.internal.persistence.file.single.SingleItemDataWriter.checkEventSize.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str = String.format(Locale.US, "Can't write data with size %d (max item size is %d)", Arrays.copyOf(new Object[]{Integer.valueOf(i), Long.valueOf(this.getFilePersistenceConfig$dd_sdk_android_core_release().getMaxItemSize())}, 2));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                return str;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
        return false;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
