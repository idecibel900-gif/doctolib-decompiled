package expo.modules.location;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class LocationUnauthorizedException extends CodedException {
    public LocationUnauthorizedException() {
        super("Not authorized to use location services", null, 2, null);
    }
}
