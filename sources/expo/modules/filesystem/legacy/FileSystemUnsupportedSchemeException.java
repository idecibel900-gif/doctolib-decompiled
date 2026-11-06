package expo.modules.filesystem.legacy;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class FileSystemUnsupportedSchemeException extends CodedException {
    public FileSystemUnsupportedSchemeException() {
        super("Can't read Storage Access Framework directory, use StorageAccessFramework.readDirectoryAsync() instead", null, 2, null);
    }
}
