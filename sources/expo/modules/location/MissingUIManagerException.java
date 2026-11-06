package expo.modules.location;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class MissingUIManagerException extends CodedException {
    public MissingUIManagerException() {
        super("UIManager is unavailable", null, 2, null);
    }
}
