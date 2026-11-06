package com.doctolib.apps.authentication.internal.devicekey;

import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes3.dex */
public interface DeviceKeyRegistrar {
    Object register(String str, String str2, String str3, Continuation continuation);

    Object revoke(String str, String str2, String str3, Continuation continuation);
}
