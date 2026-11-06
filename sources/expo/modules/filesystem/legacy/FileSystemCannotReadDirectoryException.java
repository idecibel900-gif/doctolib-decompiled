package expo.modules.filesystem.legacy;

import android.net.Uri;
import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class FileSystemCannotReadDirectoryException extends CodedException {
    public FileSystemCannotReadDirectoryException(Uri uri) {
        super("Uri '" + uri + "' doesn't exist or isn't a directory", null, 2, null);
    }
}
