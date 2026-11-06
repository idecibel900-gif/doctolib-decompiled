package expo.modules.core.logging;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class PersistentFileLog {
    public static final Companion Companion = new Companion(null);
    private static final PersistentFileLogSerialDispatchQueue queue = new PersistentFileLogSerialDispatchQueue();
    private final String filePath;

    public PersistentFileLog(String category, File filesDirectory) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(filesDirectory, "filesDirectory");
        this.filePath = filesDirectory.getPath() + "/dev.expo.modules.core.logging." + category;
    }

    public final List readEntries() {
        if (0 == getFileSize()) {
            return CollectionsKt.emptyList();
        }
        return readFileLinesSync();
    }

    public static /* synthetic */ void appendEntry$default(PersistentFileLog persistentFileLog, String str, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: expo.modules.core.logging.PersistentFileLog$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return PersistentFileLog.appendEntry$lambda$0((Error) obj2);
                }
            };
        }
        persistentFileLog.appendEntry(str, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit appendEntry$lambda$0(Error error) {
        return Unit.INSTANCE;
    }

    public final void appendEntry(final String entry, final Function1 completionHandler) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        Intrinsics.checkNotNullParameter(completionHandler, "completionHandler");
        queue.add(new Function0() { // from class: expo.modules.core.logging.PersistentFileLog$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PersistentFileLog.appendEntry$lambda$1(this.f$0, entry, completionHandler);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit appendEntry$lambda$1(PersistentFileLog persistentFileLog, String str, Function1 function1) {
        try {
            persistentFileLog.ensureFileExists();
            if (persistentFileLog.getFileSize() != 0) {
                str = "\n" + str;
            }
            persistentFileLog.appendTextToFile(str);
            function1.invoke(null);
        } catch (IOException e) {
            function1.invoke(new Error(e));
        } catch (Error e2) {
            function1.invoke(e2);
        }
        return Unit.INSTANCE;
    }

    public final void purgeEntriesNotMatchingFilter(final Function1 filter, final Function1 completionHandler) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        Intrinsics.checkNotNullParameter(completionHandler, "completionHandler");
        queue.add(new Function0() { // from class: expo.modules.core.logging.PersistentFileLog$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PersistentFileLog.purgeEntriesNotMatchingFilter$lambda$2(this.f$0, filter, completionHandler);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit purgeEntriesNotMatchingFilter$lambda$2(PersistentFileLog persistentFileLog, Function1 function1, Function1 function2) {
        try {
            persistentFileLog.ensureFileExists();
            List fileLinesSync = persistentFileLog.readFileLinesSync();
            ArrayList arrayList = new ArrayList();
            for (Object obj : fileLinesSync) {
                if (((Boolean) function1.invoke(obj)).booleanValue()) {
                    arrayList.add(obj);
                }
            }
            persistentFileLog.writeFileLinesSync(arrayList);
            function2.invoke(null);
        } catch (Throwable th) {
            function2.invoke(new Exception(th));
        }
        return Unit.INSTANCE;
    }

    private final void ensureFileExists() throws IOException {
        File file = new File(this.filePath);
        if (file.exists() || file.createNewFile()) {
            return;
        }
        throw new IOException("Unable to create file at path " + this.filePath);
    }

    private final long getFileSize() {
        File file = new File(this.filePath);
        if (!file.exists()) {
            return 0L;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                long size = fileInputStream.getChannel().size();
                CloseableKt.closeFinally(fileInputStream, null);
                return size;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(fileInputStream, th);
                    throw th2;
                }
            }
        } catch (IOException unused) {
            return 0L;
        }
    }

    private final void appendTextToFile(String str) {
        File file = new File(this.filePath);
        Charset charsetDefaultCharset = Charset.defaultCharset();
        Intrinsics.checkNotNullExpressionValue(charsetDefaultCharset, "defaultCharset(...)");
        FilesKt.appendText(file, str, charsetDefaultCharset);
    }

    private final List readFileLinesSync() {
        File file = new File(this.filePath);
        Charset charsetDefaultCharset = Charset.defaultCharset();
        Intrinsics.checkNotNullExpressionValue(charsetDefaultCharset, "defaultCharset(...)");
        List lines = FilesKt.readLines(file, charsetDefaultCharset);
        ArrayList arrayList = new ArrayList();
        for (Object obj : lines) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final void writeFileLinesSync(List list) {
        File file = new File(this.filePath);
        String strJoinToString$default = CollectionsKt.joinToString$default(list, "\n", null, null, 0, null, null, 62, null);
        Charset charsetDefaultCharset = Charset.defaultCharset();
        Intrinsics.checkNotNullExpressionValue(charsetDefaultCharset, "defaultCharset(...)");
        FilesKt.writeText(file, strJoinToString$default, charsetDefaultCharset);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
