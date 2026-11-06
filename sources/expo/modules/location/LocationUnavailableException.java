package expo.modules.location;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class LocationUnavailableException extends CodedException {
    public LocationUnavailableException() {
        super("Location is unavailable. Make sure that location services are enabled", null, 2, null);
    }
}
