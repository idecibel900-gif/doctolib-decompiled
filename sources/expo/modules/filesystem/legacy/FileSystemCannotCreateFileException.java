package expo.modules.filesystem.legacy;

import android.net.Uri;
import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class FileSystemCannotCreateFileException extends CodedException {
    /* JADX WARN: Code duplicated, block: B:5:0x001a  */
    /* JADX WARN: Illegal instructions before constructor call */
    public FileSystemCannotCreateFileException(Uri uri) {
        String str;
        if (uri != null) {
            str = "Provided uri '" + uri + "' is not pointing to a directory";
            str = str == null ? "Unknown error" : str;
        }
        super(str, null, 2, null);
    }
}
