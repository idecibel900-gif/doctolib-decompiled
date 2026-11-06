package expo.modules.location;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class SensorManagerUnavailable extends CodedException {
    public SensorManagerUnavailable() {
        super("Sensor manager is unavailable", null, 2, null);
    }
}
