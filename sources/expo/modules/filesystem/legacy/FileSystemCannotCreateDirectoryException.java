package expo.modules.filesystem.legacy;

import android.net.Uri;
import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class FileSystemCannotCreateDirectoryException extends CodedException {
    /* JADX WARN: Code duplicated, block: B:5:0x001a  */
    /* JADX WARN: Illegal instructions before constructor call */
    public FileSystemCannotCreateDirectoryException(Uri uri) {
        String str;
        if (uri != null) {
            str = "Directory '" + uri + "' could not be created or already exists";
            str = str == null ? "Unknown error" : str;
        }
        super(str, null, 2, null);
    }
}
