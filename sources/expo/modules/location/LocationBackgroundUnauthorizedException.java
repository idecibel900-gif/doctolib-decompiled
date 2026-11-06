package expo.modules.location;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class LocationBackgroundUnauthorizedException extends CodedException {
    public LocationBackgroundUnauthorizedException() {
        super("Not authorized to use background location services", null, 2, null);
    }
}
