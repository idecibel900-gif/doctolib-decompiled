package com.doctolib.apps.authentication.internal.storage;

import kotlin.coroutines.Continuation;
import net.openid.appauth.AuthState;

/* JADX INFO: loaded from: classes3.dex */
public interface AuthStateStorage {
    Object clear(Continuation continuation);

    Object read(Continuation continuation);

    Object write(AuthState authState, Continuation continuation);
}
