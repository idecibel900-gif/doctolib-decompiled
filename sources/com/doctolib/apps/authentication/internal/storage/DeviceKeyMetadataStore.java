package com.doctolib.apps.authentication.internal.storage;

import android.content.Context;
import android.security.keystore.KeyGenParameterSpec;
import com.doctolib.apps.authentication.error.AppAuthErrorCode;
import com.doctolib.apps.authentication.error.AuthError;
import com.doctolib.apps.authentication.internal.devicekey.DeviceKeyRecord;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes3.dex */
public final class DeviceKeyMetadataStore {
    private final File file;
    private final Lazy wrappingKey$delegate;

    public DeviceKeyMetadataStore(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.file = new File(context.getFilesDir(), "doctolib_apps_auth_device_key.enc");
        this.wrappingKey$delegate = LazyKt.lazy(new Function0() { // from class: com.doctolib.apps.authentication.internal.storage.DeviceKeyMetadataStore$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeviceKeyMetadataStore.wrappingKey_delegate$lambda$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SecretKey getWrappingKey() {
        return (SecretKey) this.wrappingKey$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SecretKey wrappingKey_delegate$lambda$1() throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyStoreException, CertificateException, NoSuchProviderException, InvalidAlgorithmParameterException {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        Key key = keyStore.getKey("doctolib_apps_auth_device_key_key", null);
        SecretKey secretKey = key instanceof SecretKey ? (SecretKey) key : null;
        if (secretKey != null) {
            return secretKey;
        }
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
        KeyGenParameterSpec.Builder keySize = new KeyGenParameterSpec.Builder("doctolib_apps_auth_device_key_key", 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER);
        keySize.setUserAuthenticationRequired(false);
        KeyGenParameterSpec keyGenParameterSpecBuild = keySize.build();
        Intrinsics.checkNotNullExpressionValue(keyGenParameterSpecBuild, "build(...)");
        keyGenerator.init(keyGenParameterSpecBuild);
        SecretKey secretKeyGenerateKey = keyGenerator.generateKey();
        Intrinsics.checkNotNullExpressionValue(secretKeyGenerateKey, "generateKey(...)");
        return secretKeyGenerateKey;
    }

    /* JADX INFO: renamed from: com.doctolib.apps.authentication.internal.storage.DeviceKeyMetadataStore$read$2, reason: invalid class name and case insensitive filesystem */
    static final class C04872 extends SuspendLambda implements Function2 {
        int label;

        C04872(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeviceKeyMetadataStore.this.new C04872(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C04872) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws AuthError {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (!DeviceKeyMetadataStore.this.file.exists()) {
                    return null;
                }
                try {
                    byte[] bytes = FilesKt.readBytes(DeviceKeyMetadataStore.this.file);
                    if (bytes.length < 28) {
                        DeviceKeyMetadataStore.this.file.delete();
                        return null;
                    }
                    try {
                        return DeviceKeyRecord.Companion.fromJson(new String(DeviceKeyMetadataStore.this.decrypt(bytes), Charsets.UTF_8));
                    } catch (BadPaddingException unused) {
                        DeviceKeyMetadataStore.this.file.delete();
                        return null;
                    } catch (Exception e) {
                        throw DeviceKeyMetadataStore.this.unreadable(e);
                    }
                } catch (Exception e2) {
                    throw DeviceKeyMetadataStore.this.unreadable(e2);
                }
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object read(Continuation continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C04872(null), continuation);
    }

    /* JADX INFO: renamed from: com.doctolib.apps.authentication.internal.storage.DeviceKeyMetadataStore$write$2, reason: invalid class name and case insensitive filesystem */
    static final class C04882 extends SuspendLambda implements Function2 {
        final /* synthetic */ DeviceKeyRecord $record;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04882(DeviceKeyRecord deviceKeyRecord, Continuation continuation) {
            super(2, continuation);
            this.$record = deviceKeyRecord;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeviceKeyMetadataStore.this.new C04882(this.$record, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C04882) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws AuthError {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                cipher.init(1, DeviceKeyMetadataStore.this.getWrappingKey());
                byte[] bytes = this.$record.toJson().getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                byte[] bArrDoFinal = cipher.doFinal(bytes);
                File file = DeviceKeyMetadataStore.this.file;
                byte[] iv = cipher.getIV();
                Intrinsics.checkNotNullExpressionValue(iv, "getIV(...)");
                Intrinsics.checkNotNull(bArrDoFinal);
                FilesKt.writeBytes(file, ArraysKt.plus(iv, bArrDoFinal));
                return Unit.INSTANCE;
            } catch (Exception e) {
                throw new AuthError(AppAuthErrorCode.RUNTIME_EXCEPTION, "Failed to write the device-key record", e);
            }
        }
    }

    public final Object write(DeviceKeyRecord deviceKeyRecord, Continuation continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new C04882(deviceKeyRecord, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.doctolib.apps.authentication.internal.storage.DeviceKeyMetadataStore$clear$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeviceKeyMetadataStore.this.new AnonymousClass2(continuation);
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
                if (DeviceKeyMetadataStore.this.file.exists()) {
                    DeviceKeyMetadataStore.this.file.delete();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object clear(Continuation continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] decrypt(byte[] bArr) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] bArrCopyOfRange = ArraysKt.copyOfRange(bArr, 0, 12);
        byte[] bArrCopyOfRange2 = ArraysKt.copyOfRange(bArr, 12, bArr.length);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(2, getWrappingKey(), new GCMParameterSpec(128, bArrCopyOfRange));
        byte[] bArrDoFinal = cipher.doFinal(bArrCopyOfRange2);
        Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "doFinal(...)");
        return bArrDoFinal;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AuthError unreadable(Exception exc) {
        return new AuthError(AppAuthErrorCode.RUNTIME_EXCEPTION, "Failed to read the device-key record", exc);
    }
}
