package com.oblador.keychain;

import android.os.Build;
import android.text.TextUtils;
import androidx.biometric.BiometricPrompt;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.amazon.a.a.o.b;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.oblador.keychain.cipherStorage.CipherCache;
import com.oblador.keychain.cipherStorage.CipherStorage;
import com.oblador.keychain.cipherStorage.CipherStorageKeystoreAesCbc;
import com.oblador.keychain.cipherStorage.CipherStorageKeystoreAesGcm;
import com.oblador.keychain.cipherStorage.CipherStorageKeystoreRsaEcb;
import com.oblador.keychain.exceptions.CryptoFailedException;
import com.oblador.keychain.exceptions.EmptyParameterException;
import com.oblador.keychain.exceptions.KeyStoreAccessException;
import com.oblador.keychain.resultHandler.ResultHandler;
import com.oblador.keychain.resultHandler.ResultHandlerProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import net.openid.appauth.TokenRequest;

/* JADX INFO: loaded from: classes4.dex */
@ReactModule(name = KeychainModule.KEYCHAIN_MODULE)
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0016\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 i2\u00020\u0001:\u0001iB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J9\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ0\u0010$\u001a\u00020#2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!H\u0082@¢\u0006\u0004\b$\u0010%J0\u0010'\u001a\u00020#2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!H\u0082@¢\u0006\u0004\b'\u0010%J@\u0010+\u001a\u00020*2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010)\u001a\u00020(2\u0006\u0010\"\u001a\u00020!H\u0082@¢\u0006\u0004\b+\u0010,J\u001f\u0010.\u001a\u00020-2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b.\u0010/J8\u00104\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u00112\u0006\u00103\u001a\u00020#2\u0006\u0010\"\u001a\u00020!H\u0082@¢\u0006\u0004\b4\u00105J\u001f\u00109\u001a\u00020(2\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u000206H\u0002¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u0006H\u0016¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\u000eH\u0016¢\u0006\u0004\b=\u0010>J\u001b\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020@0?H\u0016¢\u0006\u0004\bA\u0010BJ1\u0010C\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\bC\u0010DJ!\u0010E\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\bE\u0010FJ!\u0010G\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\bG\u0010FJ!\u0010H\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\bH\u0010FJ\u001f\u0010I\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\bI\u0010FJ!\u0010J\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\bJ\u0010FJ9\u0010L\u001a\u00020\u000e2\u0006\u0010K\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\bL\u0010\u0010J)\u0010M\u001a\u00020\u000e2\u0006\u0010K\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\bM\u0010\u0015J\u001f\u0010N\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\bN\u0010FJ\u0017\u0010O\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\bO\u0010PJ\u0017\u0010Q\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\bQ\u0010PJ!\u00109\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b9\u0010FJ\u001d\u0010R\u001a\u00020\u00112\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u000206¢\u0006\u0004\bR\u0010SJ\u0019\u0010U\u001a\u0004\u0018\u00010\u00112\b\b\u0001\u0010T\u001a\u00020\u0006¢\u0006\u0004\bU\u0010VR \u0010X\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00110W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010[\u001a\u00020Z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010^\u001a\u00020]8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010a\u001a\u00020`8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0011\u0010c\u001a\u0002068F¢\u0006\u0006\u001a\u0004\bc\u0010dR\u0011\u0010e\u001a\u0002068F¢\u0006\u0006\u001a\u0004\be\u0010dR\u0011\u0010f\u001a\u0002068F¢\u0006\u0006\u001a\u0004\bf\u0010dR\u0011\u0010g\u001a\u0002068F¢\u0006\u0006\u001a\u0004\bg\u0010dR\u0011\u0010h\u001a\u0002068F¢\u0006\u0006\u001a\u0004\bh\u0010d¨\u0006j"}, d2 = {"Lcom/oblador/keychain/KeychainModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "Lcom/facebook/react/bridge/ReactApplicationContext;", "reactContext", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "", "alias", "username", TokenRequest.GRANT_TYPE_PASSWORD, "Lcom/facebook/react/bridge/ReadableMap;", "options", "Lcom/facebook/react/bridge/Promise;", BaseJavaModule.METHOD_TYPE_PROMISE, "", "setGenericPassword", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/facebook/react/bridge/ReadableMap;Lcom/facebook/react/bridge/Promise;)V", "Lcom/oblador/keychain/cipherStorage/CipherStorage;", "getSelectedStorage", "(Lcom/facebook/react/bridge/ReadableMap;)Lcom/oblador/keychain/cipherStorage/CipherStorage;", "getGenericPassword", "(Ljava/lang/String;Lcom/facebook/react/bridge/ReadableMap;Lcom/facebook/react/bridge/Promise;)V", "", "doGetAllGenericPasswordServices", "()Ljava/util/Collection;", "resetGenericPassword", "(Ljava/lang/String;Lcom/facebook/react/bridge/Promise;)V", "cipherStorage", "addCipherStorageToMap", "(Lcom/oblador/keychain/cipherStorage/CipherStorage;)V", "current", "Lcom/oblador/keychain/PrefsStorageBase$ResultSet;", "resultSet", "Landroidx/biometric/BiometricPrompt$PromptInfo;", "promptInfo", "Lcom/oblador/keychain/cipherStorage/CipherStorage$DecryptionResult;", "decryptCredentials", "(Ljava/lang/String;Lcom/oblador/keychain/cipherStorage/CipherStorage;Lcom/oblador/keychain/PrefsStorageBase$ResultSet;Landroidx/biometric/BiometricPrompt$PromptInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "storage", "decryptToResult", "Lcom/oblador/keychain/SecurityLevel;", "securityLevel", "Lcom/oblador/keychain/cipherStorage/CipherStorage$EncryptionResult;", "encryptToResult", "(Ljava/lang/String;Lcom/oblador/keychain/cipherStorage/CipherStorage;Ljava/lang/String;Ljava/lang/String;Lcom/oblador/keychain/SecurityLevel;Landroidx/biometric/BiometricPrompt$PromptInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/oblador/keychain/resultHandler/ResultHandler;", "getInteractiveHandler", "(Lcom/oblador/keychain/cipherStorage/CipherStorage;Landroidx/biometric/BiometricPrompt$PromptInfo;)Lcom/oblador/keychain/resultHandler/ResultHandler;", "service", "newCipherStorage", "oldCipherStorage", "decryptionResult", "migrateCipherStorage", "(Ljava/lang/String;Lcom/oblador/keychain/cipherStorage/CipherStorage;Lcom/oblador/keychain/cipherStorage/CipherStorage;Lcom/oblador/keychain/cipherStorage/CipherStorage$DecryptionResult;Landroidx/biometric/BiometricPrompt$PromptInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "useBiometry", "usePasscode", "getSecurityLevel", "(ZZ)Lcom/oblador/keychain/SecurityLevel;", "getName", "()Ljava/lang/String;", "invalidate", "()V", "", "", "getConstants", "()Ljava/util/Map;", "setGenericPasswordForOptions", "(Lcom/facebook/react/bridge/ReadableMap;Ljava/lang/String;Ljava/lang/String;Lcom/facebook/react/bridge/Promise;)V", "getAllGenericPasswordServices", "(Lcom/facebook/react/bridge/ReadableMap;Lcom/facebook/react/bridge/Promise;)V", "getGenericPasswordForOptions", "resetGenericPasswordForOptions", "hasInternetCredentialsForOptions", "hasGenericPasswordForOptions", "server", "setInternetCredentialsForServer", "getInternetCredentialsForServer", "resetInternetCredentialsForOptions", "isPasscodeAuthAvailable", "(Lcom/facebook/react/bridge/Promise;)V", "getSupportedBiometryType", "getCipherStorageForCurrentAPILevel", "(ZZ)Lcom/oblador/keychain/cipherStorage/CipherStorage;", "knownName", "getCipherStorageByName", "(Ljava/lang/String;)Lcom/oblador/keychain/cipherStorage/CipherStorage;", "", "cipherStorageMap", "Ljava/util/Map;", "Lcom/oblador/keychain/PrefsStorageBase;", "prefsStorage", "Lcom/oblador/keychain/PrefsStorageBase;", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "isFingerprintAuthAvailable", "()Z", "isFaceAuthAvailable", "isIrisAuthAvailable", "isSecureHardwareAvailable", "isPasscodeAvailable", "Companion", "react-native-keychain_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeychainModule extends ReactContextBaseJavaModule {
    public static final String EMPTY_STRING = "";
    public static final String FACE_SUPPORTED_NAME = "Face";
    public static final String FINGERPRINT_SUPPORTED_NAME = "Fingerprint";
    public static final String IRIS_SUPPORTED_NAME = "Iris";
    public static final String KEYCHAIN_MODULE = "RNKeychainManager";
    private final Map<String, CipherStorage> cipherStorageMap;
    private final CoroutineScope coroutineScope;
    private final Mutex mutex;
    private final PrefsStorageBase prefsStorage;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String LOG_TAG = KeychainModule.class.getSimpleName();

    /* JADX INFO: renamed from: com.oblador.keychain.KeychainModule$decryptCredentials$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return KeychainModule.this.decryptCredentials(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.oblador.keychain.KeychainModule$migrateCipherStorage$1, reason: invalid class name and case insensitive filesystem */
    static final class C05361 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C05361(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return KeychainModule.this.migrateCipherStorage(null, null, null, null, null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeychainModule(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.cipherStorageMap = new HashMap();
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.coroutineScope = CoroutineScope;
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        this.prefsStorage = new DataStorePrefsStorage(reactContext, CoroutineScope);
        addCipherStorageToMap(new CipherStorageKeystoreAesCbc(reactContext));
        addCipherStorageToMap(new CipherStorageKeystoreAesGcm(reactContext, false));
        addCipherStorageToMap(new CipherStorageKeystoreAesGcm(reactContext, true));
        addCipherStorageToMap(new CipherStorageKeystoreRsaEcb(reactContext));
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return KEYCHAIN_MODULE;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        super.invalidate();
        if (CoroutineScopeKt.isActive(this.coroutineScope)) {
            CoroutineScopeKt.cancel$default(this.coroutineScope, "RNKeychainManager has been destroyed.", null, 2, null);
        }
        CipherCache.INSTANCE.clearCache();
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        HashMap map = new HashMap();
        map.put(SecurityLevel.ANY.jsName(), "ANY");
        map.put(SecurityLevel.SECURE_SOFTWARE.jsName(), "SECURE_SOFTWARE");
        map.put(SecurityLevel.SECURE_HARDWARE.jsName(), "SECURE_HARDWARE");
        return map;
    }

    /* JADX INFO: renamed from: com.oblador.keychain.KeychainModule$setGenericPassword$1, reason: invalid class name and case insensitive filesystem */
    static final class C05371 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $alias;
        final /* synthetic */ ReadableMap $options;
        final /* synthetic */ String $password;
        final /* synthetic */ Promise $promise;
        final /* synthetic */ String $username;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05371(String str, String str2, ReadableMap readableMap, String str3, Promise promise, Continuation continuation) {
            super(2, continuation);
            this.$username = str;
            this.$password = str2;
            this.$options = readableMap;
            this.$alias = str3;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return KeychainModule.this.new C05371(this.$username, this.$password, this.$options, this.$alias, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C05371) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Mutex mutex;
            ReadableMap readableMap;
            String str;
            Promise promise;
            Mutex mutex2;
            KeychainModule keychainModule;
            String str2;
            String str3;
            Promise promise2;
            Object objEncryptToResult;
            KeychainModule keychainModule2;
            CipherStorage cipherStorage;
            String str4;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Mutex mutex3 = KeychainModule.this.mutex;
                        String str5 = this.$username;
                        String str6 = this.$password;
                        readableMap = this.$options;
                        KeychainModule keychainModule3 = KeychainModule.this;
                        str = this.$alias;
                        promise = this.$promise;
                        this.L$0 = mutex3;
                        this.L$1 = str5;
                        this.L$2 = str6;
                        this.L$3 = readableMap;
                        this.L$4 = keychainModule3;
                        this.L$5 = str;
                        this.L$6 = promise;
                        this.label = 1;
                        if (mutex3.lock(null, this) != coroutine_suspended) {
                            mutex2 = mutex3;
                            keychainModule = keychainModule3;
                            str2 = str6;
                            str3 = str5;
                        }
                        return coroutine_suspended;
                    }
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        cipherStorage = (CipherStorage) this.L$4;
                        promise2 = (Promise) this.L$3;
                        str4 = (String) this.L$2;
                        KeychainModule keychainModule4 = (KeychainModule) this.L$1;
                        mutex = (Mutex) this.L$0;
                        try {
                            try {
                                ResultKt.throwOnFailure(obj);
                                mutex2 = mutex;
                                keychainModule2 = keychainModule4;
                                objEncryptToResult = obj;
                                try {
                                    keychainModule2.prefsStorage.storeEncryptedEntry(str4, (CipherStorage.EncryptionResult) objEncryptToResult);
                                    WritableMap writableMapCreateMap = Arguments.createMap();
                                    writableMapCreateMap.putString("service", str4);
                                    writableMapCreateMap.putString("storage", cipherStorage.getCipherStorageName());
                                    promise2.resolve(writableMapCreateMap);
                                } catch (CryptoFailedException e) {
                                    e = e;
                                    mutex = mutex2;
                                    e.getMessage();
                                    promise2.reject("E_CRYPTO_FAILED", e);
                                    mutex2 = mutex;
                                } catch (EmptyParameterException e2) {
                                    e = e2;
                                    mutex = mutex2;
                                    e.getMessage();
                                    promise2.reject("E_EMPTY_PARAMETERS", e);
                                    mutex2 = mutex;
                                } catch (Throwable th) {
                                    th = th;
                                    mutex = mutex2;
                                    th.getMessage();
                                    promise2.reject("E_UNKNOWN_ERROR", th);
                                    mutex2 = mutex;
                                }
                            } catch (CryptoFailedException e3) {
                                e = e3;
                                e.getMessage();
                                promise2.reject("E_CRYPTO_FAILED", e);
                                mutex2 = mutex;
                                Unit unit = Unit.INSTANCE;
                                mutex2.unlock(null);
                                return Unit.INSTANCE;
                            } catch (EmptyParameterException e4) {
                                e = e4;
                                e.getMessage();
                                promise2.reject("E_EMPTY_PARAMETERS", e);
                                mutex2 = mutex;
                                Unit unit2 = Unit.INSTANCE;
                                mutex2.unlock(null);
                                return Unit.INSTANCE;
                            } catch (Throwable th2) {
                                th = th2;
                                th.getMessage();
                                promise2.reject("E_UNKNOWN_ERROR", th);
                                mutex2 = mutex;
                                Unit unit3 = Unit.INSTANCE;
                                mutex2.unlock(null);
                                return Unit.INSTANCE;
                            }
                            Unit unit4 = Unit.INSTANCE;
                            mutex2.unlock(null);
                            return Unit.INSTANCE;
                        } catch (Throwable th3) {
                            th = th3;
                            mutex = mutex2;
                            mutex.unlock(null);
                            throw th;
                        }
                    }
                    Promise promise3 = (Promise) this.L$6;
                    str = (String) this.L$5;
                    KeychainModule keychainModule5 = (KeychainModule) this.L$4;
                    readableMap = (ReadableMap) this.L$3;
                    String str7 = (String) this.L$2;
                    String str8 = (String) this.L$1;
                    Mutex mutex4 = (Mutex) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    promise = promise3;
                    keychainModule = keychainModule5;
                    str2 = str7;
                    str3 = str8;
                    mutex2 = mutex4;
                    Companion companion = KeychainModule.INSTANCE;
                    companion.throwIfEmptyLoginPassword(str3, str2);
                    SecurityLevel securityLevelOrDefault = companion.getSecurityLevelOrDefault(readableMap);
                    boolean z = true;
                    CipherStorage selectedStorage = keychainModule.getSelectedStorage(readableMap);
                    companion.throwIfInsufficientLevel(selectedStorage, securityLevelOrDefault);
                    String accessControlOrDefault = companion.getAccessControlOrDefault(readableMap);
                    if (!companion.getUsePasscode(accessControlOrDefault) || !keychainModule.isPasscodeAvailable()) {
                        z = false;
                    }
                    BiometricPrompt.PromptInfo promptInfo = companion.getPromptInfo(readableMap, z, companion.getUseBiometry(accessControlOrDefault) && (keychainModule.isFingerprintAuthAvailable() || keychainModule.isFaceAuthAvailable() || keychainModule.isIrisAuthAvailable()));
                    this.L$0 = mutex2;
                    this.L$1 = keychainModule;
                    this.L$2 = str;
                    this.L$3 = promise;
                    this.L$4 = selectedStorage;
                    this.L$5 = null;
                    this.L$6 = null;
                    this.label = 2;
                    String str9 = str;
                    objEncryptToResult = keychainModule.encryptToResult(str9, selectedStorage, str3, str2, securityLevelOrDefault, promptInfo, this);
                    if (objEncryptToResult != coroutine_suspended) {
                        keychainModule2 = keychainModule;
                        cipherStorage = selectedStorage;
                        str4 = str9;
                        promise2 = promise;
                        keychainModule2.prefsStorage.storeEncryptedEntry(str4, (CipherStorage.EncryptionResult) objEncryptToResult);
                        WritableMap writableMapCreateMap2 = Arguments.createMap();
                        writableMapCreateMap2.putString("service", str4);
                        writableMapCreateMap2.putString("storage", cipherStorage.getCipherStorageName());
                        promise2.resolve(writableMapCreateMap2);
                        Unit unit5 = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return Unit.INSTANCE;
                    }
                    return coroutine_suspended;
                } catch (CryptoFailedException e5) {
                    e = e5;
                    mutex = mutex2;
                    promise2 = promise;
                    e.getMessage();
                    promise2.reject("E_CRYPTO_FAILED", e);
                    mutex2 = mutex;
                    Unit unit6 = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                } catch (EmptyParameterException e6) {
                    e = e6;
                    mutex = mutex2;
                    promise2 = promise;
                    e.getMessage();
                    promise2.reject("E_EMPTY_PARAMETERS", e);
                    mutex2 = mutex;
                    Unit unit7 = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                } catch (Throwable th4) {
                    th = th4;
                    mutex = mutex2;
                    promise2 = promise;
                    th.getMessage();
                    promise2.reject("E_UNKNOWN_ERROR", th);
                    mutex2 = mutex;
                    Unit unit8 = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        }
    }

    private final void setGenericPassword(String alias, String username, String password, ReadableMap options, Promise promise) {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C05371(username, password, options, alias, promise, null), 3, null);
    }

    @ReactMethod
    public final void setGenericPasswordForOptions(ReadableMap options, String username, String password, Promise promise) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(promise, "promise");
        setGenericPassword(INSTANCE.getServiceOrDefault(options), username, password, options, promise);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CipherStorage getSelectedStorage(ReadableMap options) throws CryptoFailedException {
        Companion companion = INSTANCE;
        String accessControlOrDefault = companion.getAccessControlOrDefault(options);
        boolean useBiometry = companion.getUseBiometry(accessControlOrDefault);
        boolean usePasscode = companion.getUsePasscode(accessControlOrDefault);
        String specificStorageOrDefault = companion.getSpecificStorageOrDefault(options);
        CipherStorage cipherStorageByName = specificStorageOrDefault != null ? getCipherStorageByName(specificStorageOrDefault) : null;
        return cipherStorageByName == null ? getCipherStorageForCurrentAPILevel(useBiometry, usePasscode) : cipherStorageByName;
    }

    /* JADX INFO: renamed from: com.oblador.keychain.KeychainModule$getGenericPassword$1, reason: invalid class name and case insensitive filesystem */
    static final class C05351 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $alias;
        final /* synthetic */ ReadableMap $options;
        final /* synthetic */ Promise $promise;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05351(String str, Promise promise, ReadableMap readableMap, Continuation continuation) {
            super(2, continuation);
            this.$alias = str;
            this.$promise = promise;
            this.$options = readableMap;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return KeychainModule.this.new C05351(this.$alias, this.$promise, this.$options, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C05351) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:59:0x0125 A[Catch: all -> 0x012a, CryptoFailedException -> 0x012d, KeyStoreAccessException -> 0x0130, TryCatch #6 {CryptoFailedException -> 0x012d, KeyStoreAccessException -> 0x0130, all -> 0x012a, blocks: (B:57:0x0100, B:59:0x0125, B:67:0x0134), top: B:90:0x0100 }] */
        /* JADX WARN: Code duplicated, block: B:66:0x0133  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Mutex mutex;
            KeychainModule keychainModule;
            String str;
            Promise promise;
            Mutex mutex2;
            ReadableMap readableMap;
            KeychainModule keychainModule2;
            Promise promise2;
            Promise promise3;
            CipherStorage cipherStorageByName;
            Object objDecryptCredentials;
            String str2;
            String cipherStorageName;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            boolean z = true;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Mutex mutex3 = KeychainModule.this.mutex;
                        keychainModule = KeychainModule.this;
                        str = this.$alias;
                        promise = this.$promise;
                        ReadableMap readableMap2 = this.$options;
                        this.L$0 = mutex3;
                        this.L$1 = keychainModule;
                        this.L$2 = str;
                        this.L$3 = promise;
                        this.L$4 = readableMap2;
                        this.label = 1;
                        if (mutex3.lock(null, this) != coroutine_suspended) {
                            mutex2 = mutex3;
                            readableMap = readableMap2;
                        }
                        return coroutine_suspended;
                    }
                    if (i == 1) {
                        readableMap = (ReadableMap) this.L$4;
                        promise = (Promise) this.L$3;
                        str = (String) this.L$2;
                        keychainModule = (KeychainModule) this.L$1;
                        mutex2 = (Mutex) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        CipherStorage cipherStorage = (CipherStorage) this.L$3;
                        promise3 = (Promise) this.L$2;
                        String str3 = (String) this.L$1;
                        mutex = (Mutex) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            mutex2 = mutex;
                            str2 = str3;
                            cipherStorageByName = cipherStorage;
                            objDecryptCredentials = obj;
                        } catch (CryptoFailedException e) {
                            e = e;
                            Intrinsics.checkNotNull(e.getMessage());
                            promise3.reject("E_CRYPTO_FAILED", e);
                            mutex2 = mutex;
                        } catch (KeyStoreAccessException e2) {
                            e = e2;
                            Intrinsics.checkNotNull(e.getMessage());
                            promise3.reject("E_KEYSTORE_ACCESS_ERROR", e);
                            mutex2 = mutex;
                        } catch (Throwable th) {
                            th = th;
                            th.getMessage();
                            promise3.reject("E_UNKNOWN_ERROR", th);
                            mutex2 = mutex;
                        }
                    }
                    try {
                        CipherStorage.DecryptionResult decryptionResult = (CipherStorage.DecryptionResult) objDecryptCredentials;
                        WritableMap writableMapCreateMap = Arguments.createMap();
                        writableMapCreateMap.putString("service", str2);
                        writableMapCreateMap.putString("username", (String) decryptionResult.getUsername());
                        writableMapCreateMap.putString(TokenRequest.GRANT_TYPE_PASSWORD, (String) decryptionResult.getPassword());
                        if (cipherStorageByName != null) {
                            cipherStorageName = cipherStorageByName.getCipherStorageName();
                        } else {
                            cipherStorageName = null;
                        }
                        writableMapCreateMap.putString("storage", cipherStorageName);
                        promise3.resolve(writableMapCreateMap);
                    } catch (CryptoFailedException e3) {
                        e = e3;
                        mutex = mutex2;
                        Intrinsics.checkNotNull(e.getMessage());
                        promise3.reject("E_CRYPTO_FAILED", e);
                        mutex2 = mutex;
                    } catch (KeyStoreAccessException e4) {
                        e = e4;
                        mutex = mutex2;
                        Intrinsics.checkNotNull(e.getMessage());
                        promise3.reject("E_KEYSTORE_ACCESS_ERROR", e);
                        mutex2 = mutex;
                    } catch (Throwable th2) {
                        th = th2;
                        mutex = mutex2;
                        th.getMessage();
                        promise3.reject("E_UNKNOWN_ERROR", th);
                        mutex2 = mutex;
                    }
                    try {
                        Unit unit = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return Unit.INSTANCE;
                    } catch (Throwable th3) {
                        th = th3;
                        mutex = mutex2;
                        mutex.unlock(null);
                        throw th;
                    }
                    PrefsStorageBase.ResultSet encryptedEntry = keychainModule2.prefsStorage.getEncryptedEntry(str);
                    if (encryptedEntry == null) {
                        promise2.resolve(Boxing.boxBoolean(false));
                        Unit unit2 = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return unit2;
                    }
                    String str4 = encryptedEntry.cipherStorageName;
                    Companion companion = KeychainModule.INSTANCE;
                    String accessControlOrDefault = companion.getAccessControlOrDefault(readableMap);
                    boolean z2 = companion.getUsePasscode(accessControlOrDefault) && keychainModule2.isPasscodeAvailable();
                    if (!companion.getUseBiometry(accessControlOrDefault) || (!keychainModule2.isFingerprintAuthAvailable() && !keychainModule2.isFaceAuthAvailable() && !keychainModule2.isIrisAuthAvailable())) {
                        z = false;
                    }
                    BiometricPrompt.PromptInfo promptInfo = companion.getPromptInfo(readableMap, z2, z);
                    cipherStorageByName = keychainModule2.getCipherStorageByName(str4);
                    Intrinsics.checkNotNull(cipherStorageByName);
                    this.L$0 = mutex2;
                    this.L$1 = str;
                    this.L$2 = promise2;
                    this.L$3 = cipherStorageByName;
                    this.L$4 = null;
                    this.label = 2;
                    String str5 = str;
                    objDecryptCredentials = keychainModule2.decryptCredentials(str5, cipherStorageByName, encryptedEntry, promptInfo, this);
                    if (objDecryptCredentials != coroutine_suspended) {
                        str2 = str5;
                        promise3 = promise2;
                        CipherStorage.DecryptionResult decryptionResult2 = (CipherStorage.DecryptionResult) objDecryptCredentials;
                        WritableMap writableMapCreateMap2 = Arguments.createMap();
                        writableMapCreateMap2.putString("service", str2);
                        writableMapCreateMap2.putString("username", (String) decryptionResult2.getUsername());
                        writableMapCreateMap2.putString(TokenRequest.GRANT_TYPE_PASSWORD, (String) decryptionResult2.getPassword());
                        if (cipherStorageByName != null) {
                            cipherStorageName = cipherStorageByName.getCipherStorageName();
                        } else {
                            cipherStorageName = null;
                        }
                        writableMapCreateMap2.putString("storage", cipherStorageName);
                        promise3.resolve(writableMapCreateMap2);
                        Unit unit3 = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return Unit.INSTANCE;
                    }
                    return coroutine_suspended;
                } catch (CryptoFailedException e5) {
                    e = e5;
                    promise3 = promise2;
                    mutex = mutex2;
                    Intrinsics.checkNotNull(e.getMessage());
                    promise3.reject("E_CRYPTO_FAILED", e);
                    mutex2 = mutex;
                    Unit unit4 = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                } catch (KeyStoreAccessException e6) {
                    e = e6;
                    promise3 = promise2;
                    mutex = mutex2;
                    Intrinsics.checkNotNull(e.getMessage());
                    promise3.reject("E_KEYSTORE_ACCESS_ERROR", e);
                    mutex2 = mutex;
                    Unit unit5 = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                } catch (Throwable th4) {
                    th = th4;
                    promise3 = promise2;
                    mutex = mutex2;
                    th.getMessage();
                    promise3.reject("E_UNKNOWN_ERROR", th);
                    mutex2 = mutex;
                    Unit unit6 = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                }
                keychainModule2 = keychainModule;
                promise2 = promise;
            } catch (Throwable th5) {
                th = th5;
            }
        }
    }

    private final void getGenericPassword(String alias, ReadableMap options, Promise promise) {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C05351(alias, promise, options, null), 3, null);
    }

    @ReactMethod
    public final void getAllGenericPasswordServices(ReadableMap options, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(Arguments.makeNativeArray(doGetAllGenericPasswordServices().toArray(new String[0])));
        } catch (KeyStoreAccessException e) {
            promise.reject("E_KEYSTORE_ACCESS_ERROR", e);
        }
    }

    private final Collection<String> doGetAllGenericPasswordServices() throws KeyStoreAccessException {
        Set<String> usedCipherNames = this.prefsStorage.getUsedCipherNames();
        ArrayList<CipherStorage> arrayList = new ArrayList(usedCipherNames.size());
        for (String str : usedCipherNames) {
            Intrinsics.checkNotNull(str);
            arrayList.add(getCipherStorageByName(str));
        }
        HashSet hashSet = new HashSet();
        for (CipherStorage cipherStorage : arrayList) {
            Intrinsics.checkNotNull(cipherStorage);
            Iterator it = cipherStorage.getAllKeys().iterator();
            while (it.hasNext()) {
                hashSet.add((String) it.next());
            }
        }
        return hashSet;
    }

    @ReactMethod
    public final void getGenericPasswordForOptions(ReadableMap options, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        getGenericPassword(INSTANCE.getServiceOrDefault(options), options, promise);
    }

    private final void resetGenericPassword(String alias, Promise promise) {
        CipherStorage cipherStorageByName;
        try {
            PrefsStorageBase.ResultSet encryptedEntry = this.prefsStorage.getEncryptedEntry(alias);
            if (encryptedEntry != null && (cipherStorageByName = getCipherStorageByName(encryptedEntry.cipherStorageName)) != null) {
                cipherStorageByName.removeKey(alias);
            }
            this.prefsStorage.removeEntry(alias);
            promise.resolve(Boolean.TRUE);
        } catch (KeyStoreAccessException e) {
            Intrinsics.checkNotNull(e.getMessage());
            promise.reject("E_KEYSTORE_ACCESS_ERROR", e);
        } catch (Throwable th) {
            th.getMessage();
            promise.reject("E_UNKNOWN_ERROR", th);
        }
    }

    @ReactMethod
    public final void resetGenericPasswordForOptions(ReadableMap options, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        resetGenericPassword(INSTANCE.getServiceOrDefault(options), promise);
    }

    @ReactMethod
    public final void hasInternetCredentialsForOptions(ReadableMap options, Promise promise) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (this.prefsStorage.getEncryptedEntry(INSTANCE.getAliasOrDefault(options.getString("server"))) == null) {
            promise.resolve(Boolean.FALSE);
        } else {
            promise.resolve(Boolean.TRUE);
        }
    }

    @ReactMethod
    public final void hasGenericPasswordForOptions(ReadableMap options, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (this.prefsStorage.getEncryptedEntry(INSTANCE.getServiceOrDefault(options)) == null) {
            promise.resolve(Boolean.FALSE);
        } else {
            promise.resolve(Boolean.TRUE);
        }
    }

    @ReactMethod
    public final void setInternetCredentialsForServer(String server, String username, String password, ReadableMap options, Promise promise) {
        Intrinsics.checkNotNullParameter(server, "server");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(promise, "promise");
        setGenericPassword(server, username, password, options, promise);
    }

    @ReactMethod
    public final void getInternetCredentialsForServer(String server, ReadableMap options, Promise promise) {
        Intrinsics.checkNotNullParameter(server, "server");
        Intrinsics.checkNotNullParameter(promise, "promise");
        getGenericPassword(server, options, promise);
    }

    @ReactMethod
    public final void resetInternetCredentialsForOptions(ReadableMap options, Promise promise) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(promise, "promise");
        resetGenericPassword(INSTANCE.getAliasOrDefault(options.getString("server")), promise);
    }

    @ReactMethod
    public final void isPasscodeAuthAvailable(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            DeviceAvailability deviceAvailability = DeviceAvailability.INSTANCE;
            ReactApplicationContext reactApplicationContext = getReactApplicationContext();
            Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
            promise.resolve(Boolean.valueOf(deviceAvailability.isDevicePasscodeAvailable(reactApplicationContext)));
        } catch (Throwable th) {
            th.getMessage();
            promise.reject("E_UNKNOWN_ERROR", th);
        }
    }

    @ReactMethod
    public final void getSupportedBiometryType(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            DeviceAvailability deviceAvailability = DeviceAvailability.INSTANCE;
            ReactApplicationContext reactApplicationContext = getReactApplicationContext();
            Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
            boolean zIsStrongBiometricAuthAvailable = deviceAvailability.isStrongBiometricAuthAvailable(reactApplicationContext);
            String str = null;
            if (zIsStrongBiometricAuthAvailable) {
                if (isFingerprintAuthAvailable()) {
                    str = FINGERPRINT_SUPPORTED_NAME;
                } else if (isFaceAuthAvailable()) {
                    str = FACE_SUPPORTED_NAME;
                } else if (isIrisAuthAvailable()) {
                    str = IRIS_SUPPORTED_NAME;
                }
            }
            promise.resolve(str);
        } catch (Exception e) {
            e.getMessage();
            promise.reject("E_SUPPORTED_BIOMETRY_ERROR", e);
        } catch (Throwable th) {
            th.getMessage();
            promise.reject("E_UNKNOWN_ERROR", th);
        }
    }

    @ReactMethod
    public final void getSecurityLevel(ReadableMap options, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Companion companion = INSTANCE;
        String accessControlOrDefault = companion.getAccessControlOrDefault(options);
        promise.resolve(getSecurityLevel(companion.getUseBiometry(accessControlOrDefault), companion.getUsePasscode(accessControlOrDefault)).name());
    }

    private final void addCipherStorageToMap(CipherStorage cipherStorage) {
        this.cipherStorageMap.put(cipherStorage.getCipherStorageName(), cipherStorage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006a, code lost:
    
        if (r12 == r0) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object decryptCredentials(java.lang.String r8, com.oblador.keychain.cipherStorage.CipherStorage r9, com.oblador.keychain.PrefsStorageBase.ResultSet r10, androidx.biometric.BiometricPrompt.PromptInfo r11, kotlin.coroutines.Continuation r12) throws com.oblador.keychain.exceptions.CryptoFailedException, com.oblador.keychain.exceptions.KeyStoreAccessException {
        /*
            r7 = this;
            boolean r0 = r12 instanceof com.oblador.keychain.KeychainModule.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r12
            com.oblador.keychain.KeychainModule$decryptCredentials$1 r0 = (com.oblador.keychain.KeychainModule.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            com.oblador.keychain.KeychainModule$decryptCredentials$1 r0 = new com.oblador.keychain.KeychainModule$decryptCredentials$1
            r0.<init>(r12)
            goto L12
        L1a:
            java.lang.Object r12 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L3a
            if (r1 == r3) goto L36
            if (r1 != r2) goto L2e
            kotlin.ResultKt.throwOnFailure(r12)
            goto L6d
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            kotlin.ResultKt.throwOnFailure(r12)
            return r12
        L3a:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.String r12 = r10.cipherStorageName
            java.lang.String r1 = r9.getCipherStorageName()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r12, r1)
            if (r1 == 0) goto L58
            r6.label = r3
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            r5 = r11
            java.lang.Object r8 = r1.decryptToResult(r2, r3, r4, r5, r6)
            if (r8 != r0) goto L57
            goto L6c
        L57:
            return r8
        L58:
            r1 = r2
            r2 = r8
            r8 = r1
            r1 = r7
            r4 = r10
            r5 = r11
            com.oblador.keychain.cipherStorage.CipherStorage r3 = r7.getCipherStorageByName(r12)
            if (r3 == 0) goto L70
            r6.label = r8
            java.lang.Object r12 = r1.decryptToResult(r2, r3, r4, r5, r6)
            if (r12 != r0) goto L6d
        L6c:
            return r0
        L6d:
            com.oblador.keychain.cipherStorage.CipherStorage$DecryptionResult r12 = (com.oblador.keychain.cipherStorage.CipherStorage.DecryptionResult) r12
            return r12
        L70:
            com.oblador.keychain.exceptions.KeyStoreAccessException r8 = new com.oblador.keychain.exceptions.KeyStoreAccessException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Wrong cipher storage name '"
            r9.append(r10)
            r9.append(r12)
            java.lang.String r10 = "' or cipher not available"
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oblador.keychain.KeychainModule.decryptCredentials(java.lang.String, com.oblador.keychain.cipherStorage.CipherStorage, com.oblador.keychain.PrefsStorageBase$ResultSet, androidx.biometric.BiometricPrompt$PromptInfo, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object decryptToResult(String str, CipherStorage cipherStorage, PrefsStorageBase.ResultSet resultSet, BiometricPrompt.PromptInfo promptInfo, Continuation continuation) throws CryptoFailedException {
        ResultHandler interactiveHandler = getInteractiveHandler(cipherStorage, promptInfo);
        Object username = resultSet.getUsername();
        Intrinsics.checkNotNull(username);
        Object password = resultSet.getPassword();
        Intrinsics.checkNotNull(password);
        cipherStorage.decrypt(interactiveHandler, str, (byte[]) username, (byte[]) password, SecurityLevel.ANY);
        CryptoFailedException.Companion.reThrowOnError(interactiveHandler.getError());
        if (interactiveHandler.getDecryptionResult() == null) {
            throw new CryptoFailedException("No decryption results and no error. Something deeply wrong!");
        }
        CipherStorage.DecryptionResult decryptionResult = interactiveHandler.getDecryptionResult();
        Intrinsics.checkNotNull(decryptionResult);
        return decryptionResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object encryptToResult(String str, CipherStorage cipherStorage, String str2, String str3, SecurityLevel securityLevel, BiometricPrompt.PromptInfo promptInfo, Continuation continuation) throws CryptoFailedException {
        ResultHandler interactiveHandler = getInteractiveHandler(cipherStorage, promptInfo);
        cipherStorage.encrypt(interactiveHandler, str, str2, str3, securityLevel);
        CryptoFailedException.Companion.reThrowOnError(interactiveHandler.getError());
        if (interactiveHandler.getEncryptionResult() == null) {
            throw new CryptoFailedException("No decryption results and no error. Something deeply wrong!");
        }
        CipherStorage.EncryptionResult encryptionResult = interactiveHandler.getEncryptionResult();
        Intrinsics.checkNotNull(encryptionResult);
        return encryptionResult;
    }

    private final ResultHandler getInteractiveHandler(CipherStorage current, BiometricPrompt.PromptInfo promptInfo) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        return ResultHandlerProvider.INSTANCE.getHandler(reactApplicationContext, current, promptInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public final Object migrateCipherStorage(String str, CipherStorage cipherStorage, CipherStorage cipherStorage2, CipherStorage.DecryptionResult decryptionResult, BiometricPrompt.PromptInfo promptInfo, Continuation continuation) throws CryptoFailedException, IllegalArgumentException, KeyStoreAccessException {
        C05361 c05361;
        KeychainModule keychainModule;
        String str2;
        if (continuation instanceof C05361) {
            c05361 = (C05361) continuation;
            int i = c05361.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                c05361.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                c05361 = new C05361(continuation);
            }
        } else {
            c05361 = new C05361(continuation);
        }
        C05361 c05362 = c05361;
        Object objEncryptToResult = c05362.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c05362.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objEncryptToResult);
            String str3 = (String) decryptionResult.getUsername();
            if (str3 == null) {
                throw new IllegalArgumentException("Username cannot be null");
            }
            String str4 = (String) decryptionResult.getPassword();
            if (str4 == null) {
                throw new IllegalArgumentException("Password cannot be null");
            }
            SecurityLevel securityLevel = decryptionResult.getSecurityLevel();
            c05362.L$0 = str;
            c05362.L$1 = cipherStorage2;
            c05362.label = 1;
            keychainModule = this;
            objEncryptToResult = keychainModule.encryptToResult(str, cipherStorage, str3, str4, securityLevel, promptInfo, c05362);
            if (objEncryptToResult == coroutine_suspended) {
                return coroutine_suspended;
            }
            str2 = str;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            cipherStorage2 = (CipherStorage) c05362.L$1;
            str2 = (String) c05362.L$0;
            ResultKt.throwOnFailure(objEncryptToResult);
            keychainModule = this;
        }
        keychainModule.prefsStorage.storeEncryptedEntry(str2, (CipherStorage.EncryptionResult) objEncryptToResult);
        cipherStorage2.removeKey(str2);
        return Unit.INSTANCE;
    }

    public final CipherStorage getCipherStorageForCurrentAPILevel(boolean useBiometry, boolean usePasscode) throws CryptoFailedException {
        int i = Build.VERSION.SDK_INT;
        boolean z = false;
        boolean z2 = useBiometry && (isFingerprintAuthAvailable() || isFaceAuthAvailable() || isIrisAuthAvailable());
        if (usePasscode && isPasscodeAvailable()) {
            z = true;
        }
        CipherStorage cipherStorage = null;
        for (CipherStorage cipherStorage2 : this.cipherStorageMap.values()) {
            cipherStorage2.getCipherStorageName();
            int minSupportedApiLevel = cipherStorage2.getMinSupportedApiLevel();
            int capabilityLevel = cipherStorage2.getCapabilityLevel();
            if (minSupportedApiLevel <= i && (cipherStorage == null || capabilityLevel >= cipherStorage.getCapabilityLevel())) {
                if (!cipherStorage2.isAuthSupported() || z2 || z) {
                    cipherStorage = cipherStorage2;
                }
            }
        }
        if (cipherStorage == null) {
            throw new CryptoFailedException("Unsupported Android SDK " + Build.VERSION.SDK_INT);
        }
        cipherStorage.getCipherStorageName();
        return cipherStorage;
    }

    public final CipherStorage getCipherStorageByName(String knownName) {
        Intrinsics.checkNotNullParameter(knownName, "knownName");
        return this.cipherStorageMap.get(knownName);
    }

    public final boolean isFingerprintAuthAvailable() {
        DeviceAvailability deviceAvailability = DeviceAvailability.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        if (!deviceAvailability.isStrongBiometricAuthAvailable(reactApplicationContext)) {
            return false;
        }
        ReactApplicationContext reactApplicationContext2 = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext2, "getReactApplicationContext(...)");
        return deviceAvailability.isFingerprintAuthAvailable(reactApplicationContext2);
    }

    public final boolean isFaceAuthAvailable() {
        DeviceAvailability deviceAvailability = DeviceAvailability.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        if (!deviceAvailability.isStrongBiometricAuthAvailable(reactApplicationContext)) {
            return false;
        }
        ReactApplicationContext reactApplicationContext2 = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext2, "getReactApplicationContext(...)");
        return deviceAvailability.isFaceAuthAvailable(reactApplicationContext2);
    }

    public final boolean isIrisAuthAvailable() {
        DeviceAvailability deviceAvailability = DeviceAvailability.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        if (!deviceAvailability.isStrongBiometricAuthAvailable(reactApplicationContext)) {
            return false;
        }
        ReactApplicationContext reactApplicationContext2 = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext2, "getReactApplicationContext(...)");
        return deviceAvailability.isIrisAuthAvailable(reactApplicationContext2);
    }

    public final boolean isSecureHardwareAvailable() {
        DeviceAvailability deviceAvailability = DeviceAvailability.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        return deviceAvailability.isStrongboxAvailable(reactApplicationContext);
    }

    public final boolean isPasscodeAvailable() {
        DeviceAvailability deviceAvailability = DeviceAvailability.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        return deviceAvailability.isDevicePasscodeAvailable(reactApplicationContext);
    }

    private final SecurityLevel getSecurityLevel(boolean useBiometry, boolean usePasscode) {
        try {
            SecurityLevel securityLevel = getCipherStorageForCurrentAPILevel(useBiometry, usePasscode).securityLevel();
            SecurityLevel securityLevel2 = SecurityLevel.SECURE_SOFTWARE;
            if (securityLevel.satisfiesSafetyThreshold(securityLevel2)) {
                return isSecureHardwareAvailable() ? SecurityLevel.SECURE_HARDWARE : securityLevel2;
            }
            return SecurityLevel.ANY;
        } catch (CryptoFailedException e) {
            e.getMessage();
            return SecurityLevel.ANY;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getServiceOrDefault(ReadableMap readableMap) {
            return getAliasOrDefault((readableMap == null || !readableMap.hasKey("service")) ? null : readableMap.getString("service"));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getSpecificStorageOrDefault(ReadableMap readableMap) {
            if (readableMap == null || !readableMap.hasKey("storage")) {
                return null;
            }
            return readableMap.getString("storage");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getAccessControlOrDefault(ReadableMap readableMap) {
            return getAccessControlOrDefault(readableMap, "None");
        }

        private final String getAccessControlOrDefault(ReadableMap readableMap, String str) {
            String string = (readableMap == null || !readableMap.hasKey("accessControl")) ? null : readableMap.getString("accessControl");
            return string == null ? str : string;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final SecurityLevel getSecurityLevelOrDefault(ReadableMap readableMap) {
            return getSecurityLevelOrDefault(readableMap, "ANY");
        }

        private final SecurityLevel getSecurityLevelOrDefault(ReadableMap readableMap, String str) {
            String string = (readableMap == null || !readableMap.hasKey("securityLevel")) ? null : readableMap.getString("securityLevel");
            if (string != null) {
                str = string;
            }
            return SecurityLevel.valueOf(str);
        }

        public final boolean getUseBiometry(String str) {
            return CollectionsKt.contains(SetsKt.setOf((Object[]) new String[]{"BiometryAny", "BiometryCurrentSet", "BiometryAnyOrDevicePasscode", "BiometryCurrentSetOrDevicePasscode"}), str);
        }

        public final boolean getUsePasscode(String str) {
            return CollectionsKt.contains(SetsKt.setOf((Object[]) new String[]{"DevicePasscode", "BiometryAnyOrDevicePasscode", "BiometryCurrentSetOrDevicePasscode"}), str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final BiometricPrompt.PromptInfo getPromptInfo(ReadableMap readableMap, boolean z, boolean z2) {
            String string;
            String string2;
            String string3;
            String string4;
            Integer num = null;
            ReadableMap map = (readableMap == null || !readableMap.hasKey("authenticationPrompt")) ? null : readableMap.getMap("authenticationPrompt");
            BiometricPrompt.PromptInfo.Builder builder = new BiometricPrompt.PromptInfo.Builder();
            if (map != null && (string4 = map.getString(b.S)) != null) {
                builder.setTitle(string4);
            }
            if (map != null && (string3 = map.getString("subtitle")) != null) {
                builder.setSubtitle(string3);
            }
            if (map != null && (string2 = map.getString(b.c)) != null) {
                builder.setDescription(string2);
            }
            if (z && z2) {
                num = 32783;
            } else if (z) {
                num = 32768;
            }
            if (num != null) {
                builder.setAllowedAuthenticators(num.intValue());
            }
            if (!z && map != null && (string = map.getString("cancel")) != null) {
                builder.setNegativeButtonText(string);
            }
            builder.setConfirmationRequired(false);
            BiometricPrompt.PromptInfo promptInfoBuild = builder.build();
            Intrinsics.checkNotNullExpressionValue(promptInfoBuild, "build(...)");
            return promptInfoBuild;
        }

        public final void throwIfEmptyLoginPassword(String str, String str2) throws EmptyParameterException {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                throw new EmptyParameterException("you passed empty or null username/password");
            }
        }

        public final void throwIfInsufficientLevel(CipherStorage storage, SecurityLevel level) throws CryptoFailedException {
            Intrinsics.checkNotNullParameter(storage, "storage");
            Intrinsics.checkNotNullParameter(level, "level");
            if (storage.securityLevel().satisfiesSafetyThreshold(level)) {
                return;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("Cipher Storage is too weak. Required security level is: %s, but only %s is provided", Arrays.copyOf(new Object[]{level.name(), storage.securityLevel().name()}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            throw new CryptoFailedException(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getAliasOrDefault(String str) {
            return str == null ? "" : str;
        }
    }
}
