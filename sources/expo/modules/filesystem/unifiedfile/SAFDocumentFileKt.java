package expo.modules.filesystem.unifiedfile;

import androidx.documentfile.provider.DocumentFile;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SAFDocumentFileKt {
    public static final boolean deleteRecursively(DocumentFile documentFile) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        if (documentFile.isDirectory()) {
            DocumentFile[] documentFileArrListFiles = documentFile.listFiles();
            Intrinsics.checkNotNullExpressionValue(documentFileArrListFiles, "listFiles(...)");
            for (DocumentFile documentFile2 : documentFileArrListFiles) {
                Intrinsics.checkNotNull(documentFile2);
                deleteRecursively(documentFile2);
            }
        }
        return documentFile.delete();
    }
}
