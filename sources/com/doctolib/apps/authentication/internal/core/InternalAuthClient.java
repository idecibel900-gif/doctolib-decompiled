package com.doctolib.apps.authentication.internal.core;

import androidx.fragment.app.FragmentActivity;
import com.doctolib.apps.authentication.config.AuthConfig;
import com.doctolib.apps.authentication.model.AuthTokenFetchStrategy;
import com.doctolib.apps.authentication.model.DeviceKeyStorage;
import com.doctolib.apps.authentication.model.DeviceKeyUserAuthentication;
import java.util.Map;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes3.dex */
public interface InternalAuthClient {
    Object authorize(AuthConfig authConfig, Map map, Continuation continuation);

    Object deviceKeyEnroll(AuthConfig authConfig, DeviceKeyUserAuthentication deviceKeyUserAuthentication, DeviceKeyStorage deviceKeyStorage, Continuation continuation);

    Object deviceKeyForget(AuthConfig authConfig, Continuation continuation);

    Object deviceKeyReLogin(AuthConfig authConfig, FragmentActivity fragmentActivity, Continuation continuation);

    Object getAuthToken(AuthConfig authConfig, AuthTokenFetchStrategy authTokenFetchStrategy, Continuation continuation);

    Object logout(AuthConfig authConfig, String str, Continuation continuation);

    Object retrieveState(Continuation continuation);
}
