package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.logging.Logger;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zbm {
    private static final Logger zba = new Logger("GoogleSignInCommon", new String[0]);

    public static PendingResult zbe(GoogleApiClient googleApiClient, Context context, boolean z) {
        zba.d("Signing out", new Object[0]);
        zbh(context);
        return z ? PendingResults.immediatePendingResult(Status.RESULT_SUCCESS, googleApiClient) : googleApiClient.execute(new zbi(googleApiClient));
    }

    public static PendingResult zbf(GoogleApiClient googleApiClient, Context context, boolean z) {
        zba.d("Revoking access", new Object[0]);
        String savedRefreshToken = Storage.getInstance(context).getSavedRefreshToken();
        zbh(context);
        return z ? zbb.zba(savedRefreshToken) : googleApiClient.execute(new zbk(googleApiClient));
    }

    private static void zbh(Context context) {
        zbn.zba(context).zbb();
        Iterator it = GoogleApiClient.getAllClients().iterator();
        while (it.hasNext()) {
            ((GoogleApiClient) it.next()).maybeSignOut();
        }
        GoogleApiManager.reportSignOut();
    }
}
