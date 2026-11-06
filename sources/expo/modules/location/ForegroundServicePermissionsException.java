package expo.modules.location;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class ForegroundServicePermissionsException extends CodedException {
    public ForegroundServicePermissionsException() {
        super("Couldn't start the foreground service. Foreground service permissions were not found in the manifest", null, 2, null);
    }
}
