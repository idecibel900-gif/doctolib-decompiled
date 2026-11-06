package com.google.android.gms.location;

import android.app.PendingIntent;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes3.dex */
public interface GeofencingClient {
    Task removeGeofences(PendingIntent pendingIntent);
}
