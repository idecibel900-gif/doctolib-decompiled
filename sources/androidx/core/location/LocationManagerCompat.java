package androidx.core.location;

import android.location.LocationManager;
import android.os.Build;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class LocationManagerCompat {
    static final WeakHashMap sLocationListeners = new WeakHashMap();

    public static boolean isLocationEnabled(LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.isLocationEnabled(locationManager);
        }
        return locationManager.isProviderEnabled("network") || locationManager.isProviderEnabled("gps");
    }

    private static class Api28Impl {
        static boolean isLocationEnabled(LocationManager locationManager) {
            return locationManager.isLocationEnabled();
        }
    }
}
