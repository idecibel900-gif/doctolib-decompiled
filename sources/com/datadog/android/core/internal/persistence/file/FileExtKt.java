package com.datadog.android.core.internal.persistence.file;

import com.datadog.android.api.InternalLogger;
import java.io.File;
import java.io.FileFilter;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes3.dex */
public abstract class FileExtKt {
    private static final Object safeCall(final File file, Object obj, InternalLogger internalLogger, Function1 function1) {
        try {
            return function1.invoke(file);
        } catch (SecurityException e) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), new Function0() { // from class: com.datadog.android.core.internal.persistence.file.FileExtKt.safeCall.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Security exception was thrown for file " + file.getPath();
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return obj;
        } catch (Exception e2) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), new Function0() { // from class: com.datadog.android.core.internal.persistence.file.FileExtKt.safeCall.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Unexpected exception was thrown for file " + file.getPath();
                }
            }, (Throwable) e2, false, (Map) null, 48, (Object) null);
            return obj;
        }
    }

    public static final boolean canWriteSafe(File file, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        return ((Boolean) safeCall(file, Boolean.FALSE, internalLogger, new Function1() { // from class: com.datadog.android.core.internal.persistence.file.FileExtKt.canWriteSafe.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(File safeCall) {
                Intrinsics.checkNotNullParameter(safeCall, "$this$safeCall");
                return Boolean.valueOf(safeCall.canWrite());
            }
        })).booleanValue();
    }

    public static final boolean canReadSafe(File file, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        return ((Boolean) safeCall(file, Boolean.FALSE, internalLogger, new Function1() { // from class: com.datadog.android.core.internal.persistence.file.FileExtKt.canReadSafe.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(File safeCall) {
                Intrinsics.checkNotNullParameter(safeCall, "$this$safeCall");
                return Boolean.valueOf(safeCall.canRead());
            }
        })).booleanValue();
    }

    public static final boolean deleteSafe(File file, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        return ((Boolean) safeCall(file, Boolean.FALSE, internalLogger, new Function1() { // from class: com.datadog.android.core.internal.persistence.file.FileExtKt.deleteSafe.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(File safeCall) {
                Intrinsics.checkNotNullParameter(safeCall, "$this$safeCall");
                return Boolean.valueOf(safeCall.delete());
            }
        })).booleanValue();
    }

    public static final boolean existsSafe(File file, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        return ((Boolean) safeCall(file, Boolean.FALSE, internalLogger, new Function1() { // from class: com.datadog.android.core.internal.persistence.file.FileExtKt.existsSafe.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(File safeCall) {
                Intrinsics.checkNotNullParameter(safeCall, "$this$safeCall");
                return Boolean.valueOf(safeCall.exists());
            }
        })).booleanValue();
    }

    public static final boolean isDirectorySafe(File file, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        return ((Boolean) safeCall(file, Boolean.FALSE, internalLogger, new Function1() { // from class: com.datadog.android.core.internal.persistence.file.FileExtKt.isDirectorySafe.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(File safeCall) {
                Intrinsics.checkNotNullParameter(safeCall, "$this$safeCall");
                return Boolean.valueOf(safeCall.isDirectory());
            }
        })).booleanValue();
    }

    public static final File[] listFilesSafe(File file, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        return (File[]) safeCall(file, null, internalLogger, new Function1() { // from class: com.datadog.android.core.internal.persistence.file.FileExtKt.listFilesSafe.1
            @Override // kotlin.jvm.functions.Function1
            public final File[] invoke(File safeCall) {
                Intrinsics.checkNotNullParameter(safeCall, "$this$safeCall");
                return safeCall.listFiles();
            }
        });
    }

    public static final File[] listFilesSafe(File file, final FileFilter filter, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(filter, "filter");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        return (File[]) safeCall(file, null, internalLogger, new Function1() { // from class: com.datadog.android.core.internal.persistence.file.FileExtKt.listFilesSafe.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final File[] invoke(File safeCall) {
                Intrinsics.checkNotNullParameter(safeCall, "$this$safeCall");
                return safeCall.listFiles(filter);
            }
        });
    }

    public static final long lengthSafe(File file, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        return ((Number) safeCall(file, 0L, internalLogger, new Function1() { // from class: com.datadog.android.core.internal.persistence.file.FileExtKt.lengthSafe.1
            @Override // kotlin.jvm.functions.Function1
            public final Long invoke(File safeCall) {
                Intrinsics.checkNotNullParameter(safeCall, "$this$safeCall");
                return Long.valueOf(safeCall.length());
            }
        })).longValue();
    }

    public static final boolean mkdirsSafe(File file, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        return ((Boolean) safeCall(file, Boolean.FALSE, internalLogger, new Function1() { // from class: com.datadog.android.core.internal.persistence.file.FileExtKt.mkdirsSafe.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(File safeCall) {
                Intrinsics.checkNotNullParameter(safeCall, "$this$safeCall");
                return Boolean.valueOf(safeCall.mkdirs());
            }
        })).booleanValue();
    }

    public static final boolean renameToSafe(File file, final File dest, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(dest, "dest");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        return ((Boolean) safeCall(file, Boolean.FALSE, internalLogger, new Function1() { // from class: com.datadog.android.core.internal.persistence.file.FileExtKt.renameToSafe.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(File safeCall) {
                Intrinsics.checkNotNullParameter(safeCall, "$this$safeCall");
                return Boolean.valueOf(safeCall.renameTo(dest));
            }
        })).booleanValue();
    }

    public static final void deleteDirectoryContentsSafe(File file, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        File[] fileArrListFilesSafe = listFilesSafe(file, internalLogger);
        if (fileArrListFilesSafe != null) {
            for (File file2 : fileArrListFilesSafe) {
                deleteSafe(file2, internalLogger);
            }
        }
    }

    public static /* synthetic */ String readTextSafe$default(File file, Charset charset, InternalLogger internalLogger, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return readTextSafe(file, charset, internalLogger);
    }

    public static final String readTextSafe(File file, final Charset charset, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        if (existsSafe(file, internalLogger) && canReadSafe(file, internalLogger)) {
            return (String) safeCall(file, null, internalLogger, new Function1() { // from class: com.datadog.android.core.internal.persistence.file.FileExtKt.readTextSafe.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final String invoke(File safeCall) {
                    Intrinsics.checkNotNullParameter(safeCall, "$this$safeCall");
                    return FilesKt.readText(safeCall, charset);
                }
            });
        }
        return null;
    }

    public static /* synthetic */ List readLinesSafe$default(File file, Charset charset, InternalLogger internalLogger, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return readLinesSafe(file, charset, internalLogger);
    }

    public static final List readLinesSafe(File file, final Charset charset, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        if (existsSafe(file, internalLogger) && canReadSafe(file, internalLogger)) {
            return (List) safeCall(file, null, internalLogger, new Function1() { // from class: com.datadog.android.core.internal.persistence.file.FileExtKt.readLinesSafe.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final List invoke(File safeCall) {
                    Intrinsics.checkNotNullParameter(safeCall, "$this$safeCall");
                    return FilesKt.readLines(safeCall, charset);
                }
            });
        }
        return null;
    }

    public static final void writeTextSafe(File file, final String text, final Charset charset, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        if (existsSafe(file, internalLogger) && canWriteSafe(file, internalLogger)) {
            safeCall(file, null, internalLogger, new Function1() { // from class: com.datadog.android.core.internal.persistence.file.FileExtKt.writeTextSafe.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((File) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(File safeCall) {
                    Intrinsics.checkNotNullParameter(safeCall, "$this$safeCall");
                    FilesKt.writeText(safeCall, text, charset);
                }
            });
        }
    }
}
