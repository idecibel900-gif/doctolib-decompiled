package expo.modules.location;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class ForegroundServiceStartNotAllowedException extends CodedException {
    public ForegroundServiceStartNotAllowedException() {
        super("Couldn't start the foreground service. Foreground service cannot be started when the application is in the background", null, 2, null);
    }
}
