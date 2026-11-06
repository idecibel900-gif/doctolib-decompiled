package expo.modules.filesystem.legacy;

import android.net.Uri;
import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class FileSystemFileNotFoundException extends CodedException {
    public FileSystemFileNotFoundException(Uri uri) {
        super("File '" + uri + "' could not be deleted because it could not be found", null, 2, null);
    }
}
