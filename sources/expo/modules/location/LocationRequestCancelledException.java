package expo.modules.location;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class LocationRequestCancelledException extends CodedException {
    public LocationRequestCancelledException() {
        super("Location request has been cancelled", null, 2, null);
    }
}
