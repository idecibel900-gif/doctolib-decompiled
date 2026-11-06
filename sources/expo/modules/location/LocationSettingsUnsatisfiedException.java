package expo.modules.location;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class LocationSettingsUnsatisfiedException extends CodedException {
    public LocationSettingsUnsatisfiedException() {
        super("Location request failed due to unsatisfied device settings", null, 2, null);
    }
}
