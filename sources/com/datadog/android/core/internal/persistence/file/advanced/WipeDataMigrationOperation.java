package com.datadog.android.core.internal.persistence.file.advanced;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.persistence.file.FileMover;
import com.datadog.android.core.internal.utils.MiscUtilsKt;
import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class WipeDataMigrationOperation implements DataMigrationOperation {
    public static final Companion Companion = new Companion(null);
    private static final long RETRY_DELAY_NS = TimeUnit.MILLISECONDS.toNanos(500);
    private final FileMover fileMover;
    private final InternalLogger internalLogger;
    private final File targetDir;

    public WipeDataMigrationOperation(File file, FileMover fileMover, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(fileMover, "fileMover");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.targetDir = file;
        this.fileMover = fileMover;
        this.internalLogger = internalLogger;
    }

    public final File getTargetDir$dd_sdk_android_core_release() {
        return this.targetDir;
    }

    public final FileMover getFileMover$dd_sdk_android_core_release() {
        return this.fileMover;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.targetDir == null) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.MAINTAINER, (Function0) new Function0() { // from class: com.datadog.android.core.internal.persistence.file.advanced.WipeDataMigrationOperation.run.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Can't wipe data from a null directory";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        } else {
            MiscUtilsKt.retryWithDelay(3, RETRY_DELAY_NS, this.internalLogger, new Function0() { // from class: com.datadog.android.core.internal.persistence.file.advanced.WipeDataMigrationOperation.run.2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.valueOf(WipeDataMigrationOperation.this.getFileMover$dd_sdk_android_core_release().delete(WipeDataMigrationOperation.this.getTargetDir$dd_sdk_android_core_release()));
                }
            });
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
