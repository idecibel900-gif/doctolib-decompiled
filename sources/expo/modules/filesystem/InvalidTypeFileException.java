package expo.modules.filesystem;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class InvalidTypeFileException extends CodedException {
    public InvalidTypeFileException() {
        super("A folder with the same name already exists in the file location", null, 2, null);
    }
}
