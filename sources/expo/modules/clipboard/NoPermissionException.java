package expo.modules.clipboard;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class NoPermissionException extends CodedException {
    public NoPermissionException(SecurityException securityException) {
        super("App has no permission to read this clipboard item", securityException);
    }
}
