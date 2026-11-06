package expo.modules.filesystem;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class DestinationDoesNotExistException extends CodedException {
    public DestinationDoesNotExistException() {
        super("The destination path does not exist", null, 2, null);
    }
}
