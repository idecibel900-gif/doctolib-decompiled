package com.oblador.keychain.resultHandler;

import android.app.Activity;
import android.os.Looper;
import androidx.biometric.BiometricPrompt;
import androidx.fragment.app.FragmentActivity;
import com.facebook.react.bridge.AssertionException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.oblador.keychain.DeviceAvailability;
import com.oblador.keychain.cipherStorage.CipherStorage;
import com.oblador.keychain.cipherStorage.CipherStorageBase;
import com.oblador.keychain.exceptions.CryptoFailedException;
import java.nio.charset.Charset;
import java.security.Key;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes4.dex */
public class ResultHandlerInteractiveBiometric extends BiometricPrompt.AuthenticationCallback implements ResultHandler {
    private final String LOG_TAG;
    private final Condition condition;
    private CryptoContext context;
    private CipherStorage.DecryptionResult decryptionResult;
    private CipherStorage.EncryptionResult encryptionResult;
    private Throwable error;
    private final Executor executor;
    private final ReentrantLock lock;
    private BiometricPrompt.PromptInfo promptInfo;
    private final ReactApplicationContext reactContext;
    private final CipherStorageBase storage;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CryptoOperation.values().length];
            try {
                iArr[CryptoOperation.ENCRYPT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CryptoOperation.DECRYPT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ResultHandlerInteractiveBiometric(ReactApplicationContext reactContext, CipherStorage storage, BiometricPrompt.PromptInfo promptInfo) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(promptInfo, "promptInfo");
        this.reactContext = reactContext;
        this.promptInfo = promptInfo;
        this.storage = (CipherStorageBase) storage;
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        this.executor = executorServiceNewSingleThreadExecutor;
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
        this.LOG_TAG = ResultHandlerInteractiveBiometric.class.getSimpleName();
    }

    @Override // com.oblador.keychain.resultHandler.ResultHandler
    public CipherStorage.DecryptionResult getDecryptionResult() {
        return this.decryptionResult;
    }

    public void setDecryptionResult(CipherStorage.DecryptionResult decryptionResult) {
        this.decryptionResult = decryptionResult;
    }

    @Override // com.oblador.keychain.resultHandler.ResultHandler
    public CipherStorage.EncryptionResult getEncryptionResult() {
        return this.encryptionResult;
    }

    public void setEncryptionResult(CipherStorage.EncryptionResult encryptionResult) {
        this.encryptionResult = encryptionResult;
    }

    @Override // com.oblador.keychain.resultHandler.ResultHandler
    public Throwable getError() {
        return this.error;
    }

    public void setError(Throwable th) {
        this.error = th;
    }

    protected final String getLOG_TAG() {
        return this.LOG_TAG;
    }

    @Override // com.oblador.keychain.resultHandler.ResultHandler
    public void askAccessPermissions(CryptoContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        if (!DeviceAvailability.isPermissionsGranted(this.reactContext)) {
            CryptoFailedException cryptoFailedException = new CryptoFailedException("Could not start biometric Authentication. No permissions granted.");
            int i = WhenMappings.$EnumSwitchMapping$0[context.getOperation().ordinal()];
            if (i == 1) {
                onEncrypt(null, cryptoFailedException);
                return;
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                onDecrypt(null, cryptoFailedException);
                return;
            }
        }
        startAuthentication();
    }

    @Override // com.oblador.keychain.resultHandler.ResultHandler
    public void onEncrypt(CipherStorage.EncryptionResult encryptionResult, Throwable th) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            setEncryptionResult(encryptionResult);
            setError(th);
            this.condition.signalAll();
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.oblador.keychain.resultHandler.ResultHandler
    public void onDecrypt(CipherStorage.DecryptionResult decryptionResult, Throwable th) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            setDecryptionResult(decryptionResult);
            setError(th);
            this.condition.signalAll();
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // androidx.biometric.BiometricPrompt.AuthenticationCallback
    public void onAuthenticationError(int i, CharSequence errString) {
        Intrinsics.checkNotNullParameter(errString, "errString");
        CryptoFailedException cryptoFailedException = new CryptoFailedException("code: " + i + ", msg: " + ((Object) errString));
        CryptoContext cryptoContext = this.context;
        CryptoOperation operation = cryptoContext != null ? cryptoContext.getOperation() : null;
        int i2 = operation == null ? -1 : WhenMappings.$EnumSwitchMapping$0[operation.ordinal()];
        if (i2 != -1) {
            if (i2 == 1) {
                onEncrypt(null, cryptoFailedException);
            } else {
                if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                onDecrypt(null, cryptoFailedException);
            }
        }
    }

    @Override // androidx.biometric.BiometricPrompt.AuthenticationCallback
    public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        try {
            CryptoContext cryptoContext = this.context;
            if (cryptoContext == null) {
                throw new NullPointerException("Crypto context is not assigned yet.");
            }
            CryptoOperation operation = cryptoContext != null ? cryptoContext.getOperation() : null;
            int i = operation == null ? -1 : WhenMappings.$EnumSwitchMapping$0[operation.ordinal()];
            if (i != -1) {
                if (i != 1) {
                    if (i != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    CipherStorageBase cipherStorageBase = this.storage;
                    CryptoContext cryptoContext2 = this.context;
                    Intrinsics.checkNotNull(cryptoContext2);
                    Key key = cryptoContext2.getKey();
                    CryptoContext cryptoContext3 = this.context;
                    Intrinsics.checkNotNull(cryptoContext3);
                    String strDecryptBytes = cipherStorageBase.decryptBytes(key, cryptoContext3.getUsername());
                    CipherStorageBase cipherStorageBase2 = this.storage;
                    CryptoContext cryptoContext4 = this.context;
                    Intrinsics.checkNotNull(cryptoContext4);
                    Key key2 = cryptoContext4.getKey();
                    CryptoContext cryptoContext5 = this.context;
                    Intrinsics.checkNotNull(cryptoContext5);
                    onDecrypt(new CipherStorage.DecryptionResult(strDecryptBytes, cipherStorageBase2.decryptBytes(key2, cryptoContext5.getPassword()), null, 4, null), null);
                    return;
                }
                CipherStorageBase cipherStorageBase3 = this.storage;
                CryptoContext cryptoContext6 = this.context;
                Intrinsics.checkNotNull(cryptoContext6);
                Key key3 = cryptoContext6.getKey();
                CryptoContext cryptoContext7 = this.context;
                Intrinsics.checkNotNull(cryptoContext7);
                byte[] username = cryptoContext7.getUsername();
                Charset charset = Charsets.UTF_8;
                byte[] bArrEncryptString = cipherStorageBase3.encryptString(key3, new String(username, charset));
                CipherStorageBase cipherStorageBase4 = this.storage;
                CryptoContext cryptoContext8 = this.context;
                Intrinsics.checkNotNull(cryptoContext8);
                Key key4 = cryptoContext8.getKey();
                CryptoContext cryptoContext9 = this.context;
                Intrinsics.checkNotNull(cryptoContext9);
                onEncrypt(new CipherStorage.EncryptionResult(bArrEncryptString, cipherStorageBase4.encryptString(key4, new String(cryptoContext9.getPassword(), charset)), this.storage), null);
            }
        } catch (Throwable th) {
            CryptoContext cryptoContext10 = this.context;
            CryptoOperation operation2 = cryptoContext10 != null ? cryptoContext10.getOperation() : null;
            int i2 = operation2 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[operation2.ordinal()];
            if (i2 != -1) {
                if (i2 == 1) {
                    onEncrypt(null, th);
                } else {
                    if (i2 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    onDecrypt(null, th);
                }
            }
        }
    }

    public void startAuthentication() {
        FragmentActivity currentActivity = getCurrentActivity();
        if (!Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            currentActivity.runOnUiThread(new Runnable() { // from class: com.oblador.keychain.resultHandler.ResultHandlerInteractiveBiometric$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.startAuthentication();
                }
            });
            waitResult();
        } else {
            authenticateWithPrompt(currentActivity);
        }
    }

    protected final FragmentActivity getCurrentActivity() {
        Activity currentActivity = this.reactContext.getCurrentActivity();
        FragmentActivity fragmentActivity = currentActivity instanceof FragmentActivity ? (FragmentActivity) currentActivity : null;
        if (fragmentActivity != null) {
            return fragmentActivity;
        }
        throw new NullPointerException("Not assigned current activity");
    }

    protected final BiometricPrompt authenticateWithPrompt(FragmentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        BiometricPrompt biometricPrompt = new BiometricPrompt(activity, this.executor, this);
        biometricPrompt.authenticate(this.promptInfo);
        return biometricPrompt;
    }

    public void waitResult() {
        if (Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            throw new AssertionException("method should not be executed from MAIN thread");
        }
        try {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                this.condition.await();
                Unit unit = Unit.INSTANCE;
            } finally {
                reentrantLock.unlock();
            }
        } catch (InterruptedException unused) {
        }
    }
}
