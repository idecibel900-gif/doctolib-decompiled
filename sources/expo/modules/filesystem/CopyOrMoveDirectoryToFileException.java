package expo.modules.filesystem;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class CopyOrMoveDirectoryToFileException extends CodedException {
    public CopyOrMoveDirectoryToFileException() {
        super("Unable to copy or move a folder to a file", null, 2, null);
    }
}
