package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Looper;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes3.dex */
public interface FusedLocationProviderClient {
    Task getCurrentLocation(CurrentLocationRequest currentLocationRequest, CancellationToken cancellationToken);

    Task getLastLocation();

    Task removeLocationUpdates(PendingIntent pendingIntent);

    Task removeLocationUpdates(LocationCallback locationCallback);

    Task requestLocationUpdates(LocationRequest locationRequest, LocationCallback locationCallback, Looper looper);
}
