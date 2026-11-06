package expo.modules.location;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class NoGeocodeException extends CodedException {
    public NoGeocodeException() {
        super("Could not find the Geocoder", null, 2, null);
    }
}
