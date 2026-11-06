package com.google.android.gms.auth.api.signin;

import android.content.Context;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.internal.zbm;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes3.dex */
public class GoogleSignInClient extends GoogleApi {
    private static final zba zbb = new zba(null);
    static int zba = 1;

    private final synchronized int zba() {
        int i;
        try {
            i = zba;
            if (i == 1) {
                Context applicationContext = getApplicationContext();
                GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
                int iIsGooglePlayServicesAvailable = googleApiAvailability.isGooglePlayServicesAvailable(applicationContext, 12451000);
                if (iIsGooglePlayServicesAvailable == 0) {
                    i = 4;
                    zba = 4;
                } else if (googleApiAvailability.getErrorResolutionIntent(applicationContext, iIsGooglePlayServicesAvailable, null) != null || DynamiteModule.getLocalVersion(applicationContext, "com.google.android.gms.auth.api.fallback") == 0) {
                    i = 2;
                    zba = 2;
                } else {
                    i = 3;
                    zba = 3;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return i;
    }

    public Task revokeAccess() {
        return PendingResultUtil.toVoidTask(zbm.zbf(asGoogleApiClient(), getApplicationContext(), zba() == 3));
    }

    public Task signOut() {
        return PendingResultUtil.toVoidTask(zbm.zbe(asGoogleApiClient(), getApplicationContext(), zba() == 3));
    }

    GoogleSignInClient(Context context, GoogleSignInOptions googleSignInOptions) {
        super(context, Auth.GOOGLE_SIGN_IN_API, googleSignInOptions, new GoogleApi.Settings.Builder().setMapper(new ApiExceptionMapper()).build());
    }
}
