package expo.modules.location;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class LocationUnknownException extends CodedException {
    public LocationUnknownException() {
        super("Current location is unknown", null, 2, null);
    }
}
