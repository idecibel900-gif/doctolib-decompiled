package expo.modules.filesystem;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class InvalidTypeFolderException extends CodedException {
    public InvalidTypeFolderException() {
        super("A file with the same name already exists in the folder location", null, 2, null);
    }
}
