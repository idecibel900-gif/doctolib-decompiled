package com.google.android.gms.auth.api.signin;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
public abstract class GoogleSignIn {
    public static GoogleSignInClient getClient(Context context, GoogleSignInOptions googleSignInOptions) {
        return new GoogleSignInClient(context, (GoogleSignInOptions) Preconditions.checkNotNull(googleSignInOptions));
    }
}
