package com.datadog.android.core.internal.persistence.file;

import com.datadog.android.api.InternalLogger;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class FileMover {
    public static final Companion Companion = new Companion(null);
    private final InternalLogger internalLogger;

    public FileMover(InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.internalLogger = internalLogger;
    }

    public final boolean delete(final File target) {
        Intrinsics.checkNotNullParameter(target, "target");
        try {
            return FilesKt.deleteRecursively(target);
        } catch (FileNotFoundException e) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), new Function0() { // from class: com.datadog.android.core.internal.persistence.file.FileMover.delete.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "Unable to delete file: %s", Arrays.copyOf(new Object[]{target.getPath()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return false;
        } catch (SecurityException e2) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), new Function0() { // from class: com.datadog.android.core.internal.persistence.file.FileMover.delete.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "Unable to delete file: %s", Arrays.copyOf(new Object[]{target.getPath()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) e2, false, (Map) null, 48, (Object) null);
            return false;
        }
    }

    public final boolean moveFiles(final File srcDir, final File destDir) {
        Intrinsics.checkNotNullParameter(srcDir, "srcDir");
        Intrinsics.checkNotNullParameter(destDir, "destDir");
        if (!FileExtKt.existsSafe(srcDir, this.internalLogger)) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.INFO, InternalLogger.Target.MAINTAINER, new Function0() { // from class: com.datadog.android.core.internal.persistence.file.FileMover.moveFiles.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "Unable to move files; source directory does not exist: %s", Arrays.copyOf(new Object[]{srcDir.getPath()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return true;
        }
        if (!FileExtKt.isDirectorySafe(srcDir, this.internalLogger)) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), new Function0() { // from class: com.datadog.android.core.internal.persistence.file.FileMover.moveFiles.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "Unable to move files; file is not a directory: %s", Arrays.copyOf(new Object[]{srcDir.getPath()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return false;
        }
        if (!FileExtKt.existsSafe(destDir, this.internalLogger)) {
            if (!FileExtKt.mkdirsSafe(destDir, this.internalLogger)) {
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), new Function0() { // from class: com.datadog.android.core.internal.persistence.file.FileMover.moveFiles.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        String str = String.format(Locale.US, "Unable to move files; could not create directory: %s", Arrays.copyOf(new Object[]{srcDir.getPath()}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        return str;
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
                return false;
            }
        } else if (!FileExtKt.isDirectorySafe(destDir, this.internalLogger)) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), new Function0() { // from class: com.datadog.android.core.internal.persistence.file.FileMover.moveFiles.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "Unable to move files; file is not a directory: %s", Arrays.copyOf(new Object[]{destDir.getPath()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return false;
        }
        File[] fileArrListFilesSafe = FileExtKt.listFilesSafe(srcDir, this.internalLogger);
        if (fileArrListFilesSafe == null) {
            fileArrListFilesSafe = new File[0];
        }
        for (File file : fileArrListFilesSafe) {
            if (!moveFile(file, destDir)) {
                return false;
            }
        }
        return true;
    }

    private final boolean moveFile(File file, File file2) {
        return FileExtKt.renameToSafe(file, new File(file2, file.getName()), this.internalLogger);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
