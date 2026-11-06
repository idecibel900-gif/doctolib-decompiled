package com.doctolibappsauth;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import com.amazon.device.iap.internal.c.b;
import com.doctolib.apps.authentication.client.AuthClient;
import com.doctolib.apps.authentication.client.DeviceKeys;
import com.doctolib.apps.authentication.config.AuthConfig;
import com.doctolib.apps.authentication.config.ServiceConfiguration;
import com.doctolib.apps.authentication.error.AppAuthErrorCode;
import com.doctolib.apps.authentication.error.AuthError;
import com.doctolib.apps.authentication.error.ErrorCode;
import com.doctolib.apps.authentication.model.AuthResult;
import com.doctolib.apps.authentication.model.AuthStatus;
import com.doctolib.apps.authentication.model.AuthTokenFetchStrategy;
import com.doctolib.apps.authentication.model.DeviceKey;
import com.doctolib.apps.authentication.model.DeviceKeyStorage;
import com.doctolib.apps.authentication.model.DeviceKeyUserAuthentication;
import com.doctolib.apps.authentication.model.RefreshResult;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = "DoctolibAppsAuth")
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 P2\u00020\u0001:\u0001PB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0091\u0001\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001d\u001a\u00020\u001eH\u0016¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010!\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u001a\u0010#\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u001a\u0010&\u001a\u00020\u000b2\b\u0010'\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\"\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010+\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010,\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010-\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010.\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u00107\u001a\u000208H\u0002J\u0016\u00109\u001a\b\u0012\u0004\u0012\u00020\t0:2\u0006\u0010;\u001a\u00020\u0010H\u0002J \u0010<\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010=2\b\u0010>\u001a\u0004\u0018\u00010\u0012H\u0002J\u007f\u0010?\u001a\u00020@2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010AJ\u0010\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EH\u0002J\u0010\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\tH\u0002J\u0012\u0010I\u001a\u00020J2\b\u0010H\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010K\u001a\u00020C2\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010N\u001a\u00020C2\u0006\u0010L\u001a\u00020OH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010/\u001a\u00020\t*\u0002008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0018\u00103\u001a\u00020\t*\u0002048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b5\u00106¨\u0006Q"}, d2 = {"Lcom/doctolibappsauth/DoctolibAppsAuthModule;", "Lcom/doctolibappsauth/NativeDoctolibAppsAuthSpec;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "getName", "", "invalidate", "", "initialize", "clientId", "redirectUrl", "scopes", "Lcom/facebook/react/bridge/ReadableArray;", "serviceConfiguration", "Lcom/facebook/react/bridge/ReadableMap;", "issuer", "clientSecret", "additionalParameters", "usePKCE", "", "useNonce", "iosPrefersEphemeralSession", "skipCodeExchange", "deviceKeyIssuer", "customHeaders", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "(Ljava/lang/String;Ljava/lang/String;Lcom/facebook/react/bridge/ReadableArray;Lcom/facebook/react/bridge/ReadableMap;Ljava/lang/String;Ljava/lang/String;Lcom/facebook/react/bridge/ReadableMap;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lcom/facebook/react/bridge/ReadableMap;Lcom/facebook/react/bridge/Promise;)V", "isInitialized", b.au, "getAuthStatus", AuthorizationRequest.Prompt.LOGIN, "getAuthToken", "strategy", "logout", "postLogoutRedirectUrl", "quickLoginEnroll", "userAuthentication", "storage", "quickLoginCanUse", "quickLoginAuthenticate", "quickLoginForgetDevice", "quickLoginEnrolledKey", "stringValue", "Lcom/doctolib/apps/authentication/error/ErrorCode;", "getStringValue", "(Lcom/doctolib/apps/authentication/error/ErrorCode;)Ljava/lang/String;", "jsValue", "Lcom/doctolib/apps/authentication/model/AuthStatus;", "getJsValue", "(Lcom/doctolib/apps/authentication/model/AuthStatus;)Ljava/lang/String;", "getAppCompatActivity", "Landroidx/appcompat/app/AppCompatActivity;", "readableArrayToList", "", "array", "readableMapToMap", "", "map", "createAuthConfig", "Lcom/doctolib/apps/authentication/config/AuthConfig;", "(Ljava/lang/String;Ljava/lang/String;Lcom/facebook/react/bridge/ReadableArray;Lcom/facebook/react/bridge/ReadableMap;Ljava/lang/String;Ljava/lang/String;Lcom/facebook/react/bridge/ReadableMap;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lcom/facebook/react/bridge/ReadableMap;)Lcom/doctolib/apps/authentication/config/AuthConfig;", "deviceKeyToWritableMap", "Lcom/facebook/react/bridge/WritableMap;", SubscriberAttributeKt.JSON_NAME_KEY, "Lcom/doctolib/apps/authentication/model/DeviceKey;", "parseUserAuthentication", "Lcom/doctolib/apps/authentication/model/DeviceKeyUserAuthentication;", "value", "parseStorage", "Lcom/doctolib/apps/authentication/model/DeviceKeyStorage;", "authResultToWritableMap", "result", "Lcom/doctolib/apps/authentication/model/AuthResult;", "refreshResultToWritableMap", "Lcom/doctolib/apps/authentication/model/RefreshResult;", "Companion", "doctolib_doctolib-apps-auth_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoctolibAppsAuthModule extends NativeDoctolibAppsAuthSpec {
    public static final String NAME = "DoctolibAppsAuth";
    private final CoroutineScope mainScope;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AuthStatus.values().length];
            try {
                iArr[AuthStatus.AUTHENTICATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AuthStatus.NOT_AUTHENTICATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DoctolibAppsAuthModule(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.mainScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    @Override // com.doctolibappsauth.NativeDoctolibAppsAuthSpec, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "DoctolibAppsAuth";
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        CoroutineScopeKt.cancel$default(this.mainScope, null, 1, null);
        super.invalidate();
    }

    /* JADX INFO: renamed from: com.doctolibappsauth.DoctolibAppsAuthModule$initialize$1, reason: invalid class name and case insensitive filesystem */
    static final class C04901 extends SuspendLambda implements Function2 {
        final /* synthetic */ ReadableMap $additionalParameters;
        final /* synthetic */ String $clientId;
        final /* synthetic */ String $clientSecret;
        final /* synthetic */ ReadableMap $customHeaders;
        final /* synthetic */ String $deviceKeyIssuer;
        final /* synthetic */ String $issuer;
        final /* synthetic */ Promise $promise;
        final /* synthetic */ String $redirectUrl;
        final /* synthetic */ ReadableArray $scopes;
        final /* synthetic */ ReadableMap $serviceConfiguration;
        final /* synthetic */ Boolean $skipCodeExchange;
        final /* synthetic */ Boolean $useNonce;
        final /* synthetic */ Boolean $usePKCE;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04901(String str, String str2, ReadableArray readableArray, ReadableMap readableMap, String str3, String str4, ReadableMap readableMap2, Boolean bool, Boolean bool2, Boolean bool3, String str5, ReadableMap readableMap3, Promise promise, Continuation continuation) {
            super(2, continuation);
            this.$clientId = str;
            this.$redirectUrl = str2;
            this.$scopes = readableArray;
            this.$serviceConfiguration = readableMap;
            this.$issuer = str3;
            this.$clientSecret = str4;
            this.$additionalParameters = readableMap2;
            this.$usePKCE = bool;
            this.$useNonce = bool2;
            this.$skipCodeExchange = bool3;
            this.$deviceKeyIssuer = str5;
            this.$customHeaders = readableMap3;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DoctolibAppsAuthModule.this.new C04901(this.$clientId, this.$redirectUrl, this.$scopes, this.$serviceConfiguration, this.$issuer, this.$clientSecret, this.$additionalParameters, this.$usePKCE, this.$useNonce, this.$skipCodeExchange, this.$deviceKeyIssuer, this.$customHeaders, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C04901) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    AppCompatActivity appCompatActivity = DoctolibAppsAuthModule.this.getAppCompatActivity();
                    AuthConfig authConfigCreateAuthConfig = DoctolibAppsAuthModule.this.createAuthConfig(this.$clientId, this.$redirectUrl, this.$scopes, this.$serviceConfiguration, this.$issuer, this.$clientSecret, this.$additionalParameters, this.$usePKCE, this.$useNonce, this.$skipCodeExchange, this.$deviceKeyIssuer, this.$customHeaders);
                    AuthClient.Companion companion = AuthClient.Companion;
                    this.label = 1;
                    if (companion.initialize(appCompatActivity, authConfigCreateAuthConfig, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$promise.resolve(null);
            } catch (AuthError e) {
                this.$promise.reject(DoctolibAppsAuthModule.this.getStringValue(e.getCode()), e.getErrorMessage(), e.getCause());
            } catch (IllegalArgumentException e2) {
                this.$promise.reject(AppAuthErrorCode.INVALID_CONFIGURATION.getValue(), e2.getMessage(), e2);
            } catch (CancellationException e3) {
                this.$promise.reject(AppAuthErrorCode.USER_CANCELLED.getValue(), "Initialization cancelled", e3);
                throw e3;
            } catch (Exception e4) {
                this.$promise.reject(AppAuthErrorCode.RUNTIME_EXCEPTION.getValue(), e4.getMessage(), e4);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.doctolibappsauth.NativeDoctolibAppsAuthSpec
    public void initialize(String clientId, String redirectUrl, ReadableArray scopes, ReadableMap serviceConfiguration, String issuer, String clientSecret, ReadableMap additionalParameters, Boolean usePKCE, Boolean useNonce, Boolean iosPrefersEphemeralSession, Boolean skipCodeExchange, String deviceKeyIssuer, ReadableMap customHeaders, Promise promise) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(redirectUrl, "redirectUrl");
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.mainScope, null, null, new C04901(clientId, redirectUrl, scopes, serviceConfiguration, issuer, clientSecret, additionalParameters, usePKCE, useNonce, skipCodeExchange, deviceKeyIssuer, customHeaders, promise, null), 3, null);
    }

    @Override // com.doctolibappsauth.NativeDoctolibAppsAuthSpec
    public void isInitialized(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(Boolean.valueOf(AuthClient.Companion.isInitialized()));
        } catch (AuthError e) {
            promise.reject(getStringValue(e.getCode()), e.getErrorMessage(), e.getCause());
        } catch (Exception e2) {
            promise.reject(AppAuthErrorCode.RUNTIME_EXCEPTION.getValue(), e2.getMessage(), e2);
        }
    }

    @Override // com.doctolibappsauth.NativeDoctolibAppsAuthSpec
    public void reset(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            AuthClient.Companion.reset();
            promise.resolve(null);
        } catch (AuthError e) {
            promise.reject(getStringValue(e.getCode()), e.getErrorMessage(), e.getCause());
        } catch (Exception e2) {
            promise.reject(AppAuthErrorCode.RUNTIME_EXCEPTION.getValue(), e2.getMessage(), e2);
        }
    }

    /* JADX INFO: renamed from: com.doctolibappsauth.DoctolibAppsAuthModule$getAuthStatus$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ Promise $promise;
        int label;
        final /* synthetic */ DoctolibAppsAuthModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Promise promise, DoctolibAppsAuthModule doctolibAppsAuthModule, Continuation continuation) {
            super(2, continuation);
            this.$promise = promise;
            this.this$0 = doctolibAppsAuthModule;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.$promise, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    AuthClient companion = AuthClient.Companion.getInstance();
                    this.label = 1;
                    obj = companion.getAuthStatus(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$promise.resolve(this.this$0.getJsValue((AuthStatus) obj));
            } catch (AuthError e) {
                this.$promise.reject(this.this$0.getStringValue(e.getCode()), e.getErrorMessage(), e.getCause());
            } catch (CancellationException e2) {
                this.$promise.reject(AppAuthErrorCode.USER_CANCELLED.getValue(), "Get auth status cancelled", e2);
                throw e2;
            } catch (Exception e3) {
                this.$promise.reject(AppAuthErrorCode.RUNTIME_EXCEPTION.getValue(), e3.getMessage(), e3);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.doctolibappsauth.NativeDoctolibAppsAuthSpec
    public void getAuthStatus(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.mainScope, null, null, new AnonymousClass1(promise, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.doctolibappsauth.DoctolibAppsAuthModule$login$1, reason: invalid class name and case insensitive filesystem */
    static final class C04911 extends SuspendLambda implements Function2 {
        final /* synthetic */ ReadableMap $additionalParameters;
        final /* synthetic */ Promise $promise;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04911(ReadableMap readableMap, Promise promise, Continuation continuation) {
            super(2, continuation);
            this.$additionalParameters = readableMap;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DoctolibAppsAuthModule.this.new C04911(this.$additionalParameters, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C04911) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    AuthClient companion = AuthClient.Companion.getInstance();
                    Map map = DoctolibAppsAuthModule.this.readableMapToMap(this.$additionalParameters);
                    this.label = 1;
                    obj = companion.authorize(map, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$promise.resolve(DoctolibAppsAuthModule.this.authResultToWritableMap((AuthResult) obj));
            } catch (AuthError e) {
                this.$promise.reject(DoctolibAppsAuthModule.this.getStringValue(e.getCode()), e.getErrorMessage(), e.getCause());
            } catch (CancellationException e2) {
                this.$promise.reject(AppAuthErrorCode.USER_CANCELLED.getValue(), "Login cancelled", e2);
                throw e2;
            } catch (Exception e3) {
                this.$promise.reject(AppAuthErrorCode.RUNTIME_EXCEPTION.getValue(), e3.getMessage(), e3);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.doctolibappsauth.NativeDoctolibAppsAuthSpec
    public void login(ReadableMap additionalParameters, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.mainScope, null, null, new C04911(additionalParameters, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.doctolibappsauth.DoctolibAppsAuthModule$getAuthToken$1, reason: invalid class name and case insensitive filesystem */
    static final class C04891 extends SuspendLambda implements Function2 {
        final /* synthetic */ Promise $promise;
        final /* synthetic */ String $strategy;
        int label;
        final /* synthetic */ DoctolibAppsAuthModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04891(String str, Promise promise, DoctolibAppsAuthModule doctolibAppsAuthModule, Continuation continuation) {
            super(2, continuation);
            this.$strategy = str;
            this.$promise = promise;
            this.this$0 = doctolibAppsAuthModule;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C04891(this.$strategy, this.$promise, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C04891) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AuthTokenFetchStrategy authTokenFetchStrategy;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    String str = this.$strategy;
                    if (Intrinsics.areEqual(str, "force_refresh")) {
                        authTokenFetchStrategy = AuthTokenFetchStrategy.FORCE_REFRESH;
                    } else {
                        authTokenFetchStrategy = Intrinsics.areEqual(str, "cache_only") ? AuthTokenFetchStrategy.CACHE_ONLY : AuthTokenFetchStrategy.DEFAULT;
                    }
                    AuthClient companion = AuthClient.Companion.getInstance();
                    this.label = 1;
                    obj = companion.getAuthToken(authTokenFetchStrategy, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$promise.resolve(this.this$0.refreshResultToWritableMap((RefreshResult) obj));
            } catch (AuthError e) {
                this.$promise.reject(this.this$0.getStringValue(e.getCode()), e.getErrorMessage(), e.getCause());
            } catch (CancellationException e2) {
                this.$promise.reject(AppAuthErrorCode.USER_CANCELLED.getValue(), "Get auth token cancelled", e2);
                throw e2;
            } catch (Exception e3) {
                this.$promise.reject(AppAuthErrorCode.RUNTIME_EXCEPTION.getValue(), e3.getMessage(), e3);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.doctolibappsauth.NativeDoctolibAppsAuthSpec
    public void getAuthToken(String strategy, Promise promise) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.mainScope, null, null, new C04891(strategy, promise, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.doctolibappsauth.DoctolibAppsAuthModule$logout$1, reason: invalid class name and case insensitive filesystem */
    static final class C04921 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $postLogoutRedirectUrl;
        final /* synthetic */ Promise $promise;
        int label;
        final /* synthetic */ DoctolibAppsAuthModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04921(String str, Promise promise, DoctolibAppsAuthModule doctolibAppsAuthModule, Continuation continuation) {
            super(2, continuation);
            this.$postLogoutRedirectUrl = str;
            this.$promise = promise;
            this.this$0 = doctolibAppsAuthModule;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C04921(this.$postLogoutRedirectUrl, this.$promise, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C04921) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    AuthClient companion = AuthClient.Companion.getInstance();
                    String str = this.$postLogoutRedirectUrl;
                    this.label = 1;
                    if (companion.logout(str, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$promise.resolve(null);
            } catch (AuthError e) {
                this.$promise.reject(this.this$0.getStringValue(e.getCode()), e.getErrorMessage(), e.getCause());
            } catch (CancellationException e2) {
                this.$promise.reject(AppAuthErrorCode.USER_CANCELLED.getValue(), "Logout cancelled", e2);
                throw e2;
            } catch (Exception e3) {
                this.$promise.reject(AppAuthErrorCode.RUNTIME_EXCEPTION.getValue(), e3.getMessage(), e3);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.doctolibappsauth.NativeDoctolibAppsAuthSpec
    public void logout(String postLogoutRedirectUrl, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.mainScope, null, null, new C04921(postLogoutRedirectUrl, promise, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.doctolibappsauth.DoctolibAppsAuthModule$quickLoginEnroll$1, reason: invalid class name and case insensitive filesystem */
    static final class C04951 extends SuspendLambda implements Function2 {
        final /* synthetic */ Promise $promise;
        final /* synthetic */ String $storage;
        final /* synthetic */ String $userAuthentication;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04951(String str, String str2, Promise promise, Continuation continuation) {
            super(2, continuation);
            this.$userAuthentication = str;
            this.$storage = str2;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DoctolibAppsAuthModule.this.new C04951(this.$userAuthentication, this.$storage, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C04951) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    DeviceKeys deviceKeys = AuthClient.Companion.getInstance().getDeviceKeys();
                    DeviceKeyUserAuthentication userAuthentication = DoctolibAppsAuthModule.this.parseUserAuthentication(this.$userAuthentication);
                    DeviceKeyStorage storage = DoctolibAppsAuthModule.this.parseStorage(this.$storage);
                    this.label = 1;
                    obj = deviceKeys.enroll(userAuthentication, storage, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$promise.resolve(DoctolibAppsAuthModule.this.deviceKeyToWritableMap((DeviceKey) obj));
            } catch (AuthError e) {
                this.$promise.reject(DoctolibAppsAuthModule.this.getStringValue(e.getCode()), e.getErrorMessage(), e.getCause());
            } catch (CancellationException e2) {
                this.$promise.reject(AppAuthErrorCode.USER_CANCELLED.getValue(), "Quick login enroll cancelled", e2);
                throw e2;
            } catch (Exception e3) {
                this.$promise.reject(AppAuthErrorCode.RUNTIME_EXCEPTION.getValue(), e3.getMessage(), e3);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.doctolibappsauth.NativeDoctolibAppsAuthSpec
    public void quickLoginEnroll(String userAuthentication, String storage, Promise promise) {
        Intrinsics.checkNotNullParameter(userAuthentication, "userAuthentication");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.mainScope, null, null, new C04951(userAuthentication, storage, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.doctolibappsauth.DoctolibAppsAuthModule$quickLoginCanUse$1, reason: invalid class name and case insensitive filesystem */
    static final class C04941 extends SuspendLambda implements Function2 {
        final /* synthetic */ Promise $promise;
        final /* synthetic */ String $userAuthentication;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04941(String str, Promise promise, Continuation continuation) {
            super(2, continuation);
            this.$userAuthentication = str;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DoctolibAppsAuthModule.this.new C04941(this.$userAuthentication, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C04941) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    DeviceKeys deviceKeys = AuthClient.Companion.getInstance().getDeviceKeys();
                    DeviceKeyUserAuthentication userAuthentication = DoctolibAppsAuthModule.this.parseUserAuthentication(this.$userAuthentication);
                    this.label = 1;
                    obj = deviceKeys.canUse(userAuthentication, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$promise.resolve(Boxing.boxBoolean(((Boolean) obj).booleanValue()));
            } catch (AuthError e) {
                this.$promise.reject(DoctolibAppsAuthModule.this.getStringValue(e.getCode()), e.getErrorMessage(), e.getCause());
            } catch (CancellationException e2) {
                this.$promise.reject(AppAuthErrorCode.USER_CANCELLED.getValue(), "Quick login canUse cancelled", e2);
                throw e2;
            } catch (Exception e3) {
                this.$promise.reject(AppAuthErrorCode.RUNTIME_EXCEPTION.getValue(), e3.getMessage(), e3);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.doctolibappsauth.NativeDoctolibAppsAuthSpec
    public void quickLoginCanUse(String userAuthentication, Promise promise) {
        Intrinsics.checkNotNullParameter(userAuthentication, "userAuthentication");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.mainScope, null, null, new C04941(userAuthentication, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.doctolibappsauth.DoctolibAppsAuthModule$quickLoginAuthenticate$1, reason: invalid class name and case insensitive filesystem */
    static final class C04931 extends SuspendLambda implements Function2 {
        final /* synthetic */ Promise $promise;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04931(Promise promise, Continuation continuation) {
            super(2, continuation);
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DoctolibAppsAuthModule.this.new C04931(this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C04931) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    AppCompatActivity appCompatActivity = DoctolibAppsAuthModule.this.getAppCompatActivity();
                    DeviceKeys deviceKeys = AuthClient.Companion.getInstance().getDeviceKeys();
                    this.label = 1;
                    obj = deviceKeys.reLogin(appCompatActivity, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$promise.resolve(DoctolibAppsAuthModule.this.authResultToWritableMap((AuthResult) obj));
            } catch (AuthError e) {
                this.$promise.reject(DoctolibAppsAuthModule.this.getStringValue(e.getCode()), e.getErrorMessage(), e.getCause());
            } catch (CancellationException e2) {
                this.$promise.reject(AppAuthErrorCode.USER_CANCELLED.getValue(), "Quick login authenticate cancelled", e2);
                throw e2;
            } catch (Exception e3) {
                this.$promise.reject(AppAuthErrorCode.RUNTIME_EXCEPTION.getValue(), e3.getMessage(), e3);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.doctolibappsauth.NativeDoctolibAppsAuthSpec
    public void quickLoginAuthenticate(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.mainScope, null, null, new C04931(promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.doctolibappsauth.DoctolibAppsAuthModule$quickLoginForgetDevice$1, reason: invalid class name and case insensitive filesystem */
    static final class C04971 extends SuspendLambda implements Function2 {
        final /* synthetic */ Promise $promise;
        int label;
        final /* synthetic */ DoctolibAppsAuthModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04971(Promise promise, DoctolibAppsAuthModule doctolibAppsAuthModule, Continuation continuation) {
            super(2, continuation);
            this.$promise = promise;
            this.this$0 = doctolibAppsAuthModule;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C04971(this.$promise, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C04971) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    DeviceKeys deviceKeys = AuthClient.Companion.getInstance().getDeviceKeys();
                    this.label = 1;
                    if (deviceKeys.forgetDevice(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$promise.resolve(null);
            } catch (AuthError e) {
                this.$promise.reject(this.this$0.getStringValue(e.getCode()), e.getErrorMessage(), e.getCause());
            } catch (CancellationException e2) {
                this.$promise.reject(AppAuthErrorCode.USER_CANCELLED.getValue(), "Quick login forget device cancelled", e2);
                throw e2;
            } catch (Exception e3) {
                this.$promise.reject(AppAuthErrorCode.RUNTIME_EXCEPTION.getValue(), e3.getMessage(), e3);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.doctolibappsauth.NativeDoctolibAppsAuthSpec
    public void quickLoginForgetDevice(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.mainScope, null, null, new C04971(promise, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.doctolibappsauth.DoctolibAppsAuthModule$quickLoginEnrolledKey$1, reason: invalid class name and case insensitive filesystem */
    static final class C04961 extends SuspendLambda implements Function2 {
        final /* synthetic */ Promise $promise;
        int label;
        final /* synthetic */ DoctolibAppsAuthModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04961(Promise promise, DoctolibAppsAuthModule doctolibAppsAuthModule, Continuation continuation) {
            super(2, continuation);
            this.$promise = promise;
            this.this$0 = doctolibAppsAuthModule;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C04961(this.$promise, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C04961) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    DeviceKeys deviceKeys = AuthClient.Companion.getInstance().getDeviceKeys();
                    this.label = 1;
                    obj = deviceKeys.enrolledKey(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                DeviceKey deviceKey = (DeviceKey) obj;
                this.$promise.resolve(deviceKey != null ? this.this$0.deviceKeyToWritableMap(deviceKey) : null);
            } catch (AuthError e) {
                this.$promise.reject(this.this$0.getStringValue(e.getCode()), e.getErrorMessage(), e.getCause());
            } catch (CancellationException e2) {
                this.$promise.reject(AppAuthErrorCode.USER_CANCELLED.getValue(), "Quick login enrolled key lookup cancelled", e2);
                throw e2;
            } catch (Exception e3) {
                this.$promise.reject(AppAuthErrorCode.RUNTIME_EXCEPTION.getValue(), e3.getMessage(), e3);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.doctolibappsauth.NativeDoctolibAppsAuthSpec
    public void quickLoginEnrolledKey(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.mainScope, null, null, new C04961(promise, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getStringValue(ErrorCode errorCode) {
        return errorCode.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getJsValue(AuthStatus authStatus) {
        int i = WhenMappings.$EnumSwitchMapping$0[authStatus.ordinal()];
        if (i == 1) {
            return "authenticated";
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return "not_authenticated";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppCompatActivity getAppCompatActivity() throws AuthError {
        Activity currentActivity = getReactApplicationContext().getCurrentActivity();
        if (currentActivity == null) {
            throw new AuthError(AppAuthErrorCode.INVALID_CONFIGURATION, "No current activity available", null, 4, null);
        }
        if (!(currentActivity instanceof AppCompatActivity)) {
            throw new AuthError(AppAuthErrorCode.INVALID_CONFIGURATION, "Current activity is not AppCompatActivity", null, 4, null);
        }
        return (AppCompatActivity) currentActivity;
    }

    private final List<String> readableArrayToList(ReadableArray array) {
        ArrayList arrayList = new ArrayList();
        int size = array.size();
        for (int i = 0; i < size; i++) {
            String string = array.getString(i);
            if (string != null) {
                arrayList.add(string);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, String> readableMapToMap(ReadableMap map) {
        if (map == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = map.keySetIterator();
        while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
            String string = map.getString(strNextKey);
            if (string != null) {
                linkedHashMap.put(strNextKey, string);
            }
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AuthConfig createAuthConfig(String clientId, String redirectUrl, ReadableArray scopes, ReadableMap serviceConfiguration, String issuer, String clientSecret, ReadableMap additionalParameters, Boolean usePKCE, Boolean useNonce, Boolean skipCodeExchange, String deviceKeyIssuer, ReadableMap customHeaders) {
        ServiceConfiguration serviceConfiguration2 = null;
        if (serviceConfiguration != null) {
            String string = serviceConfiguration.getString("authorizationEndpoint");
            String string2 = serviceConfiguration.getString("tokenEndpoint");
            if (string != null && !StringsKt.isBlank(string) && string2 != null && !StringsKt.isBlank(string2)) {
                serviceConfiguration2 = new ServiceConfiguration(string, string2, serviceConfiguration.getString("endSessionEndpoint"));
            }
        }
        return new AuthConfig(issuer, serviceConfiguration2, clientId, redirectUrl, readableArrayToList(scopes), clientSecret, readableMapToMap(additionalParameters), usePKCE != null ? usePKCE.booleanValue() : true, useNonce != null ? useNonce.booleanValue() : true, skipCodeExchange != null ? skipCodeExchange.booleanValue() : false, readableMapToMap(customHeaders), deviceKeyIssuer, null, 4096, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WritableMap deviceKeyToWritableMap(DeviceKey key) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("kid", key.getKid());
        writableMapCreateMap.putString("publicJwk", key.getPublicJwk());
        String subject = key.getSubject();
        if (subject != null) {
            writableMapCreateMap.putString("subject", subject);
        }
        writableMapCreateMap.putString("userAuthentication", key.getUserAuthentication().getStringValue());
        writableMapCreateMap.putString("storage", key.getStorage().getStringValue());
        return writableMapCreateMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DeviceKeyUserAuthentication parseUserAuthentication(String value) throws AuthError {
        Object next;
        Iterator<E> it = DeviceKeyUserAuthentication.getEntries().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((DeviceKeyUserAuthentication) next).getStringValue(), value));
        DeviceKeyUserAuthentication deviceKeyUserAuthentication = (DeviceKeyUserAuthentication) next;
        if (deviceKeyUserAuthentication != null) {
            return deviceKeyUserAuthentication;
        }
        throw new AuthError(AppAuthErrorCode.INVALID_CONFIGURATION, "Unknown device key userAuthentication: " + value, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DeviceKeyStorage parseStorage(String value) throws AuthError {
        Object next;
        if (value != null) {
            Iterator<E> it = DeviceKeyStorage.getEntries().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(((DeviceKeyStorage) next).getStringValue(), value));
            DeviceKeyStorage deviceKeyStorage = (DeviceKeyStorage) next;
            if (deviceKeyStorage != null) {
                return deviceKeyStorage;
            }
            throw new AuthError(AppAuthErrorCode.INVALID_CONFIGURATION, "Unknown device key storage: " + value, null, 4, null);
        }
        return DeviceKeyStorage.HARDWARE_BACKED_ONLY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WritableMap authResultToWritableMap(AuthResult result) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        String accessToken = result.getAccessToken();
        if (accessToken == null) {
            accessToken = "";
        }
        writableMapCreateMap.putString("accessToken", accessToken);
        String accessTokenExpirationDate = result.getAccessTokenExpirationDate();
        if (accessTokenExpirationDate == null) {
            accessTokenExpirationDate = "";
        }
        writableMapCreateMap.putString("accessTokenExpirationDate", accessTokenExpirationDate);
        String idToken = result.getIdToken();
        if (idToken != null) {
            writableMapCreateMap.putString("idToken", idToken);
        }
        String tokenType = result.getTokenType();
        if (tokenType == null) {
            tokenType = "";
        }
        writableMapCreateMap.putString("tokenType", tokenType);
        WritableArray writableArrayCreateArray = Arguments.createArray();
        Iterator it = result.getScopes().iterator();
        while (it.hasNext()) {
            writableArrayCreateArray.pushString((String) it.next());
        }
        Unit unit = Unit.INSTANCE;
        writableMapCreateMap.putArray("scopes", writableArrayCreateArray);
        String authorizationCode = result.getAuthorizationCode();
        writableMapCreateMap.putString("authorizationCode", authorizationCode != null ? authorizationCode : "");
        String codeVerifier = result.getCodeVerifier();
        if (codeVerifier != null) {
            writableMapCreateMap.putString("codeVerifier", codeVerifier);
        }
        return writableMapCreateMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WritableMap refreshResultToWritableMap(RefreshResult result) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("accessToken", result.getAccessToken());
        writableMapCreateMap.putString("accessTokenExpirationDate", result.getAccessTokenExpirationDate());
        String idToken = result.getIdToken();
        if (idToken != null) {
            writableMapCreateMap.putString("idToken", idToken);
        }
        writableMapCreateMap.putString("tokenType", result.getTokenType());
        return writableMapCreateMap;
    }
}
