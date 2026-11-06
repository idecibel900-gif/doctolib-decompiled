package com.doctolib.apps.authentication.internal.storage;

import android.content.Context;
import android.security.keystore.KeyGenParameterSpec;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import net.openid.appauth.AuthState;

/* JADX INFO: loaded from: classes3.dex */
public final class AuthStateStorageImpl implements AuthStateStorage {
    public static final Companion Companion = new Companion(null);
    private final Lazy encryptionKey$delegate;
    private final File file;

    public AuthStateStorageImpl(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.file = new File(context.getFilesDir(), "doctolib_apps_auth_state.enc");
        this.encryptionKey$delegate = LazyKt.lazy(new Function0() { // from class: com.doctolib.apps.authentication.internal.storage.AuthStateStorageImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AuthStateStorageImpl.encryptionKey_delegate$lambda$1();
            }
        });
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SecretKey getEncryptionKey() {
        return (SecretKey) this.encryptionKey$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SecretKey encryptionKey_delegate$lambda$1() throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyStoreException, CertificateException, NoSuchProviderException, InvalidAlgorithmParameterException {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        Key key = keyStore.getKey("doctolib_apps_auth_state_key", null);
        SecretKey secretKey = key instanceof SecretKey ? (SecretKey) key : null;
        if (secretKey != null) {
            return secretKey;
        }
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
        KeyGenParameterSpec.Builder keySize = new KeyGenParameterSpec.Builder("doctolib_apps_auth_state_key", 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER);
        keySize.setUserAuthenticationRequired(false);
        KeyGenParameterSpec keyGenParameterSpecBuild = keySize.build();
        Intrinsics.checkNotNullExpressionValue(keyGenParameterSpecBuild, "build(...)");
        keyGenerator.init(keyGenParameterSpecBuild);
        SecretKey secretKeyGenerateKey = keyGenerator.generateKey();
        Intrinsics.checkNotNullExpressionValue(secretKeyGenerateKey, "generateKey(...)");
        return secretKeyGenerateKey;
    }

    /* JADX INFO: renamed from: com.doctolib.apps.authentication.internal.storage.AuthStateStorageImpl$read$2, reason: invalid class name and case insensitive filesystem */
    static final class C04852 extends SuspendLambda implements Function2 {
        int label;

        C04852(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return AuthStateStorageImpl.this.new C04852(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C04852) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (!AuthStateStorageImpl.this.file.exists()) {
                    return null;
                }
                try {
                    byte[] bytes = FilesKt.readBytes(AuthStateStorageImpl.this.file);
                    if (bytes.length != 0 && bytes.length >= 12) {
                        byte[] bArrCopyOfRange = ArraysKt.copyOfRange(bytes, 0, 12);
                        byte[] bArrCopyOfRange2 = ArraysKt.copyOfRange(bytes, 12, bytes.length);
                        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                        cipher.init(2, AuthStateStorageImpl.this.getEncryptionKey(), new GCMParameterSpec(128, bArrCopyOfRange));
                        byte[] bArrDoFinal = cipher.doFinal(bArrCopyOfRange2);
                        Intrinsics.checkNotNull(bArrDoFinal);
                        return AuthState.jsonDeserialize(new String(bArrDoFinal, Charsets.UTF_8));
                    }
                    return null;
                } catch (Exception unused) {
                    return null;
                }
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.doctolib.apps.authentication.internal.storage.AuthStateStorage
    public Object read(Continuation continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C04852(null), continuation);
    }

    /* JADX INFO: renamed from: com.doctolib.apps.authentication.internal.storage.AuthStateStorageImpl$write$2, reason: invalid class name and case insensitive filesystem */
    static final class C04862 extends SuspendLambda implements Function2 {
        final /* synthetic */ AuthState $state;
        int label;
        final /* synthetic */ AuthStateStorageImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04862(AuthState authState, AuthStateStorageImpl authStateStorageImpl, Continuation continuation) {
            super(2, continuation);
            this.$state = authState;
            this.this$0 = authStateStorageImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C04862(this.$state, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C04862) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                String strJsonSerializeString = this.$state.jsonSerializeString();
                Intrinsics.checkNotNull(strJsonSerializeString);
                byte[] bytes = strJsonSerializeString.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                cipher.init(1, this.this$0.getEncryptionKey());
                byte[] iv = cipher.getIV();
                byte[] bArrDoFinal = cipher.doFinal(bytes);
                File file = this.this$0.file;
                Intrinsics.checkNotNull(iv);
                Intrinsics.checkNotNull(bArrDoFinal);
                FilesKt.writeBytes(file, ArraysKt.plus(iv, bArrDoFinal));
            } catch (Exception unused) {
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.doctolib.apps.authentication.internal.storage.AuthStateStorage
    public Object write(AuthState authState, Continuation continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new C04862(authState, this, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.doctolib.apps.authentication.internal.storage.AuthStateStorageImpl$clear$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return AuthStateStorageImpl.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (AuthStateStorageImpl.this.file.exists()) {
                    AuthStateStorageImpl.this.file.delete();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.doctolib.apps.authentication.internal.storage.AuthStateStorage
    public Object clear(Continuation continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }
}
