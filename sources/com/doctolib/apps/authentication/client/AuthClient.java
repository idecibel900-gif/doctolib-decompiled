package com.doctolib.apps.authentication.client;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.doctolib.apps.authentication.config.AuthConfig;
import com.doctolib.apps.authentication.error.AppAuthErrorCode;
import com.doctolib.apps.authentication.error.AuthError;
import com.doctolib.apps.authentication.internal.core.AuthenticationManager;
import com.doctolib.apps.authentication.internal.core.InternalAuthClient;
import com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager;
import com.doctolib.apps.authentication.internal.storage.AuthStateStorageImpl;
import com.doctolib.apps.authentication.model.AuthTokenFetchStrategy;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import net.openid.appauth.AuthState;
import net.openid.appauth.AuthorizationRequest;
import net.openid.appauth.AuthorizationResponse;

/* JADX INFO: loaded from: classes3.dex */
public final class AuthClient {
    private static volatile AuthClient _instance;
    private DeviceKeys _deviceKeys;
    private final AuthConfig config;
    private InternalAuthClient internalClient;
    public static final Companion Companion = new Companion(null);
    private static final Mutex initializeMutex = MutexKt.Mutex$default(false, 1, null);

    public /* synthetic */ AuthClient(AuthConfig authConfig, DefaultConstructorMarker defaultConstructorMarker) {
        this(authConfig);
    }

    private AuthClient(AuthConfig authConfig) {
        this.config = authConfig;
    }

    public final DeviceKeys getDeviceKeys() throws AuthError {
        DeviceKeys deviceKeys = this._deviceKeys;
        if (deviceKeys != null) {
            return deviceKeys;
        }
        throw new AuthError(AppAuthErrorCode.INVALID_CONFIGURATION, "AuthClient not properly initialized", null, 4, null);
    }

    public final Object authorize(Map map, Continuation continuation) {
        return getInternalClient().authorize(this.config, map, continuation);
    }

    public final Object getAuthToken(AuthTokenFetchStrategy authTokenFetchStrategy, Continuation continuation) {
        return getInternalClient().getAuthToken(this.config, authTokenFetchStrategy, continuation);
    }

    public final Object getAuthStatus(Continuation continuation) {
        return getInternalClient().retrieveState(continuation);
    }

    public final Object logout(String str, Continuation continuation) {
        Object objLogout = getInternalClient().logout(this.config, str, continuation);
        return objLogout == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objLogout : Unit.INSTANCE;
    }

    private final InternalAuthClient getInternalClient() throws AuthError {
        InternalAuthClient internalAuthClient = this.internalClient;
        if (internalAuthClient != null) {
            return internalAuthClient;
        }
        throw new AuthError(AppAuthErrorCode.INVALID_CONFIGURATION, "AuthClient not properly initialized", null, 4, null);
    }

    public final void setInternalClient$authentication_release(InternalAuthClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.internalClient = client;
    }

    public final void setDeviceKeys$authentication_release(DeviceKeyManager manager, InternalAuthClient engine) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(engine, "engine");
        this._deviceKeys = new DeviceKeys(manager, engine, this.config);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cleanup() {
        InternalAuthClient internalAuthClient = this.internalClient;
        AuthenticationManager authenticationManager = internalAuthClient instanceof AuthenticationManager ? (AuthenticationManager) internalAuthClient : null;
        if (authenticationManager != null) {
            authenticationManager.cleanup();
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:40:0x00d1  */
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v7, types: [com.doctolib.apps.authentication.client.AuthClientFactory] */
        /* JADX WARN: Type inference failed for: r11v0, types: [com.doctolib.apps.authentication.config.AuthConfig, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r11v1 */
        /* JADX WARN: Type inference failed for: r11v18 */
        /* JADX WARN: Type inference failed for: r11v19 */
        /* JADX WARN: Type inference failed for: r11v2, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r11v20 */
        /* JADX WARN: Type inference failed for: r11v22 */
        /* JADX WARN: Type inference failed for: r11v23 */
        /* JADX WARN: Type inference failed for: r11v24 */
        /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r11v4 */
        /* JADX WARN: Type inference failed for: r11v7, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r2v15 */
        /* JADX WARN: Type inference failed for: r2v5 */
        /* JADX WARN: Type inference failed for: r2v6, types: [com.doctolib.apps.authentication.config.AuthConfig, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v7, types: [com.doctolib.apps.authentication.config.AuthConfig] */
        /* JADX WARN: Type inference failed for: r2v8 */
        /* JADX WARN: Type inference failed for: r5v3, types: [com.doctolib.apps.authentication.client.AuthClient$Companion] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final Object initialize(AppCompatActivity appCompatActivity, AuthConfig authConfig, Continuation continuation) throws Throwable {
            AuthClient$Companion$initialize$1 authClient$Companion$initialize$1;
            Throwable th;
            ?? r11;
            Mutex mutex;
            ?? r12;
            AppCompatActivity appCompatActivity2;
            AuthStateStorageImpl authStateStorageImpl;
            ?? r2;
            Mutex mutex2;
            AuthState authState;
            ?? r1;
            AppCompatActivity appCompatActivity3;
            ?? r3;
            Mutex mutex3;
            if (continuation instanceof AuthClient$Companion$initialize$1) {
                authClient$Companion$initialize$1 = (AuthClient$Companion$initialize$1) continuation;
                int i = authClient$Companion$initialize$1.label;
                if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                    authClient$Companion$initialize$1.label = i - LinearLayoutManager.INVALID_OFFSET;
                } else {
                    authClient$Companion$initialize$1 = new AuthClient$Companion$initialize$1(this, continuation);
                }
            } else {
                authClient$Companion$initialize$1 = new AuthClient$Companion$initialize$1(this, continuation);
            }
            Object obj = authClient$Companion$initialize$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = authClient$Companion$initialize$1.label;
            DefaultConstructorMarker defaultConstructorMarker = null;
            try {
                try {
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj);
                        mutex = AuthClient.initializeMutex;
                        authClient$Companion$initialize$1.L$0 = appCompatActivity;
                        authClient$Companion$initialize$1.L$1 = authConfig;
                        authClient$Companion$initialize$1.L$2 = mutex;
                        authClient$Companion$initialize$1.label = 1;
                        if (mutex.lock(null, authClient$Companion$initialize$1) != coroutine_suspended) {
                        }
                        r12 = authConfig;
                        r3 = r2;
                        authConfig = mutex2;
                        return coroutine_suspended;
                    }
                    if (i2 == 1) {
                        Mutex mutex4 = (Mutex) authClient$Companion$initialize$1.L$2;
                        AuthConfig authConfig2 = (AuthConfig) authClient$Companion$initialize$1.L$1;
                        AppCompatActivity appCompatActivity4 = (AppCompatActivity) authClient$Companion$initialize$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutex = mutex4;
                        appCompatActivity = appCompatActivity4;
                        r12 = authConfig2;
                    } else {
                        if (i2 == 2) {
                            authStateStorageImpl = (AuthStateStorageImpl) authClient$Companion$initialize$1.L$3;
                            Mutex mutex5 = (Mutex) authClient$Companion$initialize$1.L$2;
                            AuthConfig authConfig3 = (AuthConfig) authClient$Companion$initialize$1.L$1;
                            appCompatActivity2 = (AppCompatActivity) authClient$Companion$initialize$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            r2 = authConfig3;
                            mutex2 = mutex5;
                            authState = (AuthState) obj;
                            r3 = r2;
                            authConfig = mutex2;
                            if (authState != null && !AuthClient.Companion.validateConfigMatch(authState, r2)) {
                                authClient$Companion$initialize$1.L$0 = appCompatActivity2;
                                authClient$Companion$initialize$1.L$1 = r2;
                                authClient$Companion$initialize$1.L$2 = mutex2;
                                authClient$Companion$initialize$1.L$3 = authStateStorageImpl;
                                authClient$Companion$initialize$1.label = 3;
                                if (authStateStorageImpl.clear(authClient$Companion$initialize$1) != coroutine_suspended) {
                                    r3 = r2;
                                    authConfig = mutex2;
                                    r1 = r2;
                                    appCompatActivity3 = appCompatActivity2;
                                    mutex3 = mutex2;
                                }
                                r12 = authConfig;
                                r3 = r2;
                                authConfig = mutex2;
                                return coroutine_suspended;
                            }
                            r3 = r2;
                            authConfig = mutex2;
                            AuthClient authClient = new AuthClient(r3, defaultConstructorMarker);
                            AuthClientFactory.INSTANCE.initializeInternal(appCompatActivity2, authClient, authStateStorageImpl, r3);
                            AuthClient._instance = authClient;
                            Unit unit = Unit.INSTANCE;
                            authConfig.unlock(null);
                            return Unit.INSTANCE;
                        }
                        if (i2 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        authStateStorageImpl = (AuthStateStorageImpl) authClient$Companion$initialize$1.L$3;
                        Mutex mutex6 = (Mutex) authClient$Companion$initialize$1.L$2;
                        AuthConfig authConfig4 = (AuthConfig) authClient$Companion$initialize$1.L$1;
                        appCompatActivity3 = (AppCompatActivity) authClient$Companion$initialize$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        r1 = authConfig4;
                        mutex3 = mutex6;
                    }
                    appCompatActivity2 = appCompatActivity3;
                    r3 = r1;
                    authConfig = mutex3;
                    r3 = r2;
                    authConfig = mutex2;
                    AuthClient authClient2 = new AuthClient(r3, defaultConstructorMarker);
                    AuthClientFactory.INSTANCE.initializeInternal(appCompatActivity2, authClient2, authStateStorageImpl, r3);
                    AuthClient._instance = authClient2;
                    Unit unit2 = Unit.INSTANCE;
                    authConfig.unlock(null);
                    return Unit.INSTANCE;
                    r12 = authConfig;
                    if (AuthClient._instance != null) {
                        throw new AuthError(AppAuthErrorCode.ALREADY_INITIALIZED, "AuthClient is already initialized. Call reset() first if you need to re-initialize.", null, 4, null);
                    }
                    Context applicationContext = appCompatActivity.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                    AuthStateStorageImpl authStateStorageImpl2 = new AuthStateStorageImpl(applicationContext);
                    authClient$Companion$initialize$1.L$0 = appCompatActivity;
                    authClient$Companion$initialize$1.L$1 = r12;
                    authClient$Companion$initialize$1.L$2 = mutex;
                    authClient$Companion$initialize$1.L$3 = authStateStorageImpl2;
                    authClient$Companion$initialize$1.label = 2;
                    Object obj2 = authStateStorageImpl2.read(authClient$Companion$initialize$1);
                    if (obj2 != coroutine_suspended) {
                        appCompatActivity2 = appCompatActivity;
                        authStateStorageImpl = authStateStorageImpl2;
                        r2 = r12;
                        mutex2 = mutex;
                        obj = obj2;
                        authState = (AuthState) obj;
                        r3 = r2;
                        authConfig = mutex2;
                        if (authState != null) {
                            authClient$Companion$initialize$1.L$0 = appCompatActivity2;
                            authClient$Companion$initialize$1.L$1 = r2;
                            authClient$Companion$initialize$1.L$2 = mutex2;
                            authClient$Companion$initialize$1.L$3 = authStateStorageImpl;
                            authClient$Companion$initialize$1.label = 3;
                            if (authStateStorageImpl.clear(authClient$Companion$initialize$1) != coroutine_suspended) {
                                r3 = r2;
                                authConfig = mutex2;
                                r1 = r2;
                                appCompatActivity3 = appCompatActivity2;
                                mutex3 = mutex2;
                                appCompatActivity2 = appCompatActivity3;
                                r3 = r1;
                                authConfig = mutex3;
                            }
                        }
                        r3 = r2;
                        authConfig = mutex2;
                        AuthClient authClient3 = new AuthClient(r3, defaultConstructorMarker);
                        AuthClientFactory.INSTANCE.initializeInternal(appCompatActivity2, authClient3, authStateStorageImpl, r3);
                        AuthClient._instance = authClient3;
                        Unit unit3 = Unit.INSTANCE;
                        authConfig.unlock(null);
                        return Unit.INSTANCE;
                    }
                    r12 = authConfig;
                    r3 = r2;
                    authConfig = mutex2;
                    return coroutine_suspended;
                } catch (Throwable th2) {
                    th = th2;
                    r11 = mutex;
                    r11.unlock(null);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                r11 = authConfig;
            }
        }

        private final boolean validateConfigMatch(AuthState authState, AuthConfig authConfig) {
            AuthorizationRequest authorizationRequest;
            AuthorizationResponse lastAuthorizationResponse = authState.getLastAuthorizationResponse();
            return Intrinsics.areEqual((lastAuthorizationResponse == null || (authorizationRequest = lastAuthorizationResponse.request) == null) ? null : authorizationRequest.clientId, authConfig.getClientId());
        }

        public final AuthClient getInstance() throws AuthError {
            AuthClient authClient = AuthClient._instance;
            if (authClient != null) {
                return authClient;
            }
            throw new AuthError(AppAuthErrorCode.NOT_INITIALIZED, "AuthClient must be initialized before use. Call AuthClient.initialize() first.", null, 4, null);
        }

        public final boolean isInitialized() {
            return AuthClient._instance != null;
        }

        public final void reset() {
            synchronized (this) {
                try {
                    AuthClient authClient = AuthClient._instance;
                    if (authClient != null) {
                        authClient.cleanup();
                    }
                    AuthClient._instance = null;
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
