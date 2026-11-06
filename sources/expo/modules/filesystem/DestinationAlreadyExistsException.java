package expo.modules.filesystem;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class DestinationAlreadyExistsException extends CodedException {
    public DestinationAlreadyExistsException() {
        super("Destination already exists", null, 2, null);
    }
}
