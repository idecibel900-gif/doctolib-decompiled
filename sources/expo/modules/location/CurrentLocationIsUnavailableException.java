package expo.modules.location;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class CurrentLocationIsUnavailableException extends CodedException {
    public CurrentLocationIsUnavailableException() {
        super("Current location is unavailable. Make sure that location services are enabled", null, 2, null);
    }
}
