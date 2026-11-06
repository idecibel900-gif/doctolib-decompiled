package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl;

/* JADX INFO: loaded from: classes3.dex */
abstract class zbl extends BaseImplementation$ApiMethodImpl {
    public zbl(GoogleApiClient googleApiClient) {
        super(Auth.GOOGLE_SIGN_IN_API, googleApiClient);
    }
}
