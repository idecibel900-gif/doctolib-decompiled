package expo.modules.filesystem;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class MissingAppContextException extends CodedException {
    public MissingAppContextException() {
        super("The app context is missing.", null, 2, null);
    }
}
