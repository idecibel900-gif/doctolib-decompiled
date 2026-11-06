package com.doctolib.apps.authentication.internal.devicekey;

import android.security.keystore.KeyPermanentlyInvalidatedException;
import android.security.keystore.UserNotAuthenticatedException;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.doctolib.apps.authentication.error.AppAuthErrorCode;
import com.doctolib.apps.authentication.error.AuthError;
import com.doctolib.apps.authentication.internal.storage.DeviceKeyMetadataStore;
import com.doctolib.apps.authentication.model.DeviceKey;
import com.doctolib.apps.authentication.model.DeviceKeySlot;
import com.doctolib.apps.authentication.model.DeviceKeyStorage;
import com.doctolib.apps.authentication.model.DeviceKeyUserAuthentication;
import java.security.Signature;
import java.security.UnrecoverableKeyException;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: loaded from: classes3.dex */
public final class DeviceKeyManager {
    private final DeviceKeyKeystore keystore;
    private final Mutex mutex;
    private final DeviceKeyPrompt prompt;
    private final DeviceKeyRegistrar registrar;
    private final Mutex signMutex;
    private final DeviceKeyMetadataStore store;

    /* JADX INFO: renamed from: com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager$createKey$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return DeviceKeyManager.this.createKey(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager$deleteKey$1, reason: invalid class name and case insensitive filesystem */
    static final class C04671 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C04671(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return DeviceKeyManager.this.deleteKey(null, this);
        }
    }

    /* JADX INFO: renamed from: com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager$enroll$1, reason: invalid class name and case insensitive filesystem */
    static final class C04681 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        C04681(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return DeviceKeyManager.this.enroll(null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager$enrolledKey$1, reason: invalid class name and case insensitive filesystem */
    static final class C04691 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C04691(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return DeviceKeyManager.this.enrolledKey(null, this);
        }
    }

    /* JADX INFO: renamed from: com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager$flushPendingRevocation$1, reason: invalid class name and case insensitive filesystem */
    static final class C04701 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C04701(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return DeviceKeyManager.this.flushPendingRevocation(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager$forgetDevice$1, reason: invalid class name and case insensitive filesystem */
    static final class C04711 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C04711(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return DeviceKeyManager.this.forgetDevice(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager$hasKnownKids$1, reason: invalid class name and case insensitive filesystem */
    static final class C04721 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C04721(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return DeviceKeyManager.this.hasKnownKids(this);
        }
    }

    /* JADX INFO: renamed from: com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager$preflightKey$1, reason: invalid class name and case insensitive filesystem */
    static final class C04731 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C04731(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return DeviceKeyManager.this.preflightKey(null, this);
        }
    }

    /* JADX INFO: renamed from: com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager$reconcileSubject$1, reason: invalid class name and case insensitive filesystem */
    static final class C04741 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C04741(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return DeviceKeyManager.this.reconcileSubject(null, this);
        }
    }

    /* JADX INFO: renamed from: com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager$retireLocally$1, reason: invalid class name and case insensitive filesystem */
    static final class C04751 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C04751(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return DeviceKeyManager.this.retireLocally(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager$revokeKids$1, reason: invalid class name and case insensitive filesystem */
    static final class C04761 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C04761(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return DeviceKeyManager.this.revokeKids(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager$revokeKnownKids$1, reason: invalid class name and case insensitive filesystem */
    static final class C04771 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C04771(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return DeviceKeyManager.this.revokeKnownKids(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager$setSubject$1, reason: invalid class name and case insensitive filesystem */
    static final class C04781 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C04781(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return DeviceKeyManager.this.setSubject(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager$signAssertion$1, reason: invalid class name and case insensitive filesystem */
    static final class C04791 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        C04791(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return DeviceKeyManager.this.signAssertion(null, null, null, null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager$signFailure$1, reason: invalid class name and case insensitive filesystem */
    static final class C04801 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C04801(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return DeviceKeyManager.this.signFailure(null, null, this);
        }
    }

    public DeviceKeyManager(DeviceKeyKeystore keystore, DeviceKeyPrompt prompt, DeviceKeyMetadataStore store, DeviceKeyRegistrar deviceKeyRegistrar) {
        Intrinsics.checkNotNullParameter(keystore, "keystore");
        Intrinsics.checkNotNullParameter(prompt, "prompt");
        Intrinsics.checkNotNullParameter(store, "store");
        this.keystore = keystore;
        this.prompt = prompt;
        this.store = store;
        this.registrar = deviceKeyRegistrar;
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        this.signMutex = MutexKt.Mutex$default(false, 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0080 A[PHI: r0 r5 r7 r8 r9 r10 r11
      0x0080: PHI (r0v23 com.doctolib.apps.authentication.internal.devicekey.DeviceKeyRecord) = 
      (r0v20 com.doctolib.apps.authentication.internal.devicekey.DeviceKeyRecord)
      (r0v25 com.doctolib.apps.authentication.internal.devicekey.DeviceKeyRecord)
     binds: [B:49:0x016b, B:23:0x007d] A[DONT_GENERATE, DONT_INLINE]
      0x0080: PHI (r5v19 kotlinx.coroutines.sync.Mutex) = (r5v27 kotlinx.coroutines.sync.Mutex), (r5v28 kotlinx.coroutines.sync.Mutex) binds: [B:49:0x016b, B:23:0x007d] A[DONT_GENERATE, DONT_INLINE]
      0x0080: PHI (r7v14 ??) = (r7v22 ??), (r7v23 ??) binds: [B:49:0x016b, B:23:0x007d] A[DONT_GENERATE, DONT_INLINE]
      0x0080: PHI (r8v14 com.doctolib.apps.authentication.model.DeviceKeyStorage) = 
      (r8v11 com.doctolib.apps.authentication.model.DeviceKeyStorage)
      (r8v18 com.doctolib.apps.authentication.model.DeviceKeyStorage)
     binds: [B:49:0x016b, B:23:0x007d] A[DONT_GENERATE, DONT_INLINE]
      0x0080: PHI (r9v13 com.doctolib.apps.authentication.model.DeviceKeyUserAuthentication) = 
      (r9v10 com.doctolib.apps.authentication.model.DeviceKeyUserAuthentication)
      (r9v16 com.doctolib.apps.authentication.model.DeviceKeyUserAuthentication)
     binds: [B:49:0x016b, B:23:0x007d] A[DONT_GENERATE, DONT_INLINE]
      0x0080: PHI (r10v11 com.doctolib.apps.authentication.model.DeviceKeySlot) = 
      (r10v8 com.doctolib.apps.authentication.model.DeviceKeySlot)
      (r10v14 com.doctolib.apps.authentication.model.DeviceKeySlot)
     binds: [B:49:0x016b, B:23:0x007d] A[DONT_GENERATE, DONT_INLINE]
      0x0080: PHI (r11v7 com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager) = 
      (r11v4 com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager)
      (r11v10 com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager)
     binds: [B:49:0x016b, B:23:0x007d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:43:0x0125  */
    /* JADX WARN: Code duplicated, block: B:47:0x0146  */
    /* JADX WARN: Code duplicated, block: B:50:0x016d  */
    /* JADX WARN: Code duplicated, block: B:53:0x018f  */
    /* JADX WARN: Code duplicated, block: B:54:0x0190  */
    /* JADX WARN: Code duplicated, block: B:58:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v2, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r4v7, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v14, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v22, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v3, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v8 */
    public final Object createKey(DeviceKeySlot deviceKeySlot, DeviceKeyUserAuthentication deviceKeyUserAuthentication, DeviceKeyStorage deviceKeyStorage, Continuation continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        ?? r5;
        ?? r4;
        DeviceKeySlot deviceKeySlot2;
        DeviceKeyStorage deviceKeyStorage2;
        DeviceKeyManager deviceKeyManager;
        Mutex mutex;
        Mutex mutex2;
        DeviceKeyUserAuthentication deviceKeyUserAuthentication2;
        DeviceKeyManager deviceKeyManager2;
        DeviceKeySlot deviceKeySlot3;
        ?? r2;
        Object obj;
        ?? r7;
        DeviceKeySlot deviceKeySlot4;
        DeviceKeyUserAuthentication deviceKeyUserAuthentication3;
        Mutex mutex3;
        DeviceKeyStorage deviceKeyStorage3;
        DeviceKeyManager deviceKeyManager3;
        DeviceKeyRecord deviceKeyRecordOwedRevocation;
        DeviceKeyMetadataStore deviceKeyMetadataStore;
        ?? r8;
        Mutex mutex4;
        DeviceKeyManager deviceKeyManager4;
        DeviceKeyManager deviceKeyManager5;
        ?? r9;
        DeviceKey deviceKey;
        DeviceKeyMetadataStore deviceKeyMetadataStore2;
        DeviceKeyRecord deviceKeyRecordCopy$default;
        ?? r6;
        ?? r3;
        DeviceKey deviceKey2;
        DeviceKeyUserAuthentication deviceKeyUserAuthentication4 = deviceKeyUserAuthentication;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                anonymousClass1.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objWithContext = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r10 = anonymousClass1.label;
        try {
            try {
                switch (r10) {
                    case 0:
                        ResultKt.throwOnFailure(objWithContext);
                        if (!canUse(deviceKeyUserAuthentication4)) {
                            throw new AuthError(AppAuthErrorCode.DEVICE_KEY_POLICY_UNAVAILABLE, "The device cannot honour " + deviceKeyUserAuthentication4.getStringValue() + " authentication", null, 4, null);
                        }
                        Mutex mutex5 = this.signMutex;
                        anonymousClass1.L$0 = this;
                        deviceKeySlot2 = deviceKeySlot;
                        anonymousClass1.L$1 = deviceKeySlot2;
                        anonymousClass1.L$2 = deviceKeyUserAuthentication4;
                        deviceKeyStorage2 = deviceKeyStorage;
                        anonymousClass1.L$3 = deviceKeyStorage2;
                        anonymousClass1.L$4 = mutex5;
                        anonymousClass1.label = 1;
                        if (mutex5.lock(null, anonymousClass1) != coroutine_suspended) {
                            deviceKeyManager = this;
                            mutex = mutex5;
                            try {
                                mutex2 = deviceKeyManager.mutex;
                                anonymousClass1.L$0 = deviceKeyManager;
                                anonymousClass1.L$1 = deviceKeySlot2;
                                anonymousClass1.L$2 = deviceKeyUserAuthentication4;
                                anonymousClass1.L$3 = deviceKeyStorage2;
                                anonymousClass1.L$4 = mutex;
                                anonymousClass1.L$5 = mutex2;
                                anonymousClass1.label = 2;
                                if (mutex2.lock(null, anonymousClass1) != coroutine_suspended) {
                                    DeviceKeySlot deviceKeySlot5 = deviceKeySlot2;
                                    deviceKeyUserAuthentication2 = deviceKeyUserAuthentication4;
                                    deviceKeyManager2 = deviceKeyManager;
                                    deviceKeySlot3 = deviceKeySlot5;
                                    r2 = mutex;
                                    try {
                                        DeviceKeyMetadataStore deviceKeyMetadataStore3 = deviceKeyManager2.store;
                                        anonymousClass1.L$0 = deviceKeyManager2;
                                        anonymousClass1.L$1 = deviceKeySlot3;
                                        anonymousClass1.L$2 = deviceKeyUserAuthentication2;
                                        anonymousClass1.L$3 = deviceKeyStorage2;
                                        anonymousClass1.L$4 = r2;
                                        anonymousClass1.L$5 = mutex2;
                                        anonymousClass1.L$6 = deviceKeyManager2;
                                        anonymousClass1.label = 3;
                                        obj = deviceKeyMetadataStore3.read(anonymousClass1);
                                        if (obj != coroutine_suspended) {
                                            DeviceKeyStorage deviceKeyStorage4 = deviceKeyStorage2;
                                            r7 = r2;
                                            objWithContext = obj;
                                            deviceKeySlot4 = deviceKeySlot3;
                                            deviceKeyUserAuthentication3 = deviceKeyUserAuthentication2;
                                            mutex3 = mutex2;
                                            deviceKeyStorage3 = deviceKeyStorage4;
                                            deviceKeyManager3 = deviceKeyManager2;
                                            deviceKeyRecordOwedRevocation = deviceKeyManager2.owedRevocation((DeviceKeyRecord) objWithContext);
                                            deviceKeyMetadataStore = deviceKeyManager3.store;
                                            anonymousClass1.L$0 = deviceKeyManager3;
                                            anonymousClass1.L$1 = deviceKeySlot4;
                                            anonymousClass1.L$2 = deviceKeyUserAuthentication3;
                                            anonymousClass1.L$3 = deviceKeyStorage3;
                                            anonymousClass1.L$4 = r7;
                                            anonymousClass1.L$5 = mutex3;
                                            anonymousClass1.L$6 = deviceKeyRecordOwedRevocation;
                                            anonymousClass1.label = 4;
                                            mutex4 = mutex3;
                                            r8 = r7;
                                            if (deviceKeyMetadataStore.write(deviceKeyRecordOwedRevocation, anonymousClass1) == coroutine_suspended) {
                                                deviceKeyManager4 = deviceKeyManager3;
                                                DeviceKeyUserAuthentication deviceKeyUserAuthentication5 = deviceKeyUserAuthentication3;
                                                DeviceKeyStorage deviceKeyStorage5 = deviceKeyStorage3;
                                                CoroutineDispatcher io2 = Dispatchers.getIO();
                                                DeviceKeyManager$createKey$2$1$key$1 deviceKeyManager$createKey$2$1$key$1 = new DeviceKeyManager$createKey$2$1$key$1(deviceKeyManager4, deviceKeySlot4, deviceKeyUserAuthentication5, deviceKeyStorage5, null);
                                                anonymousClass1.L$0 = deviceKeyManager4;
                                                anonymousClass1.L$1 = r8;
                                                anonymousClass1.L$2 = mutex4;
                                                anonymousClass1.L$3 = deviceKeyRecordOwedRevocation;
                                                anonymousClass1.L$4 = null;
                                                anonymousClass1.L$5 = null;
                                                anonymousClass1.L$6 = null;
                                                anonymousClass1.label = 5;
                                                objWithContext = BuildersKt.withContext(io2, deviceKeyManager$createKey$2$1$key$1, anonymousClass1);
                                                if (objWithContext != coroutine_suspended) {
                                                    deviceKeyManager5 = deviceKeyManager4;
                                                    r10 = mutex4;
                                                    r9 = r8;
                                                    DeviceKeyRecord deviceKeyRecord = deviceKeyRecordOwedRevocation;
                                                    deviceKey = (DeviceKey) objWithContext;
                                                    deviceKeyMetadataStore2 = deviceKeyManager5.store;
                                                    deviceKeyRecordCopy$default = DeviceKeyRecord.copy$default(deviceKeyRecord, deviceKey, null, null, 6, null);
                                                    anonymousClass1.L$0 = r9;
                                                    anonymousClass1.L$1 = r10;
                                                    anonymousClass1.L$2 = deviceKey;
                                                    anonymousClass1.L$3 = null;
                                                    anonymousClass1.label = 6;
                                                    if (deviceKeyMetadataStore2.write(deviceKeyRecordCopy$default, anonymousClass1) != coroutine_suspended) {
                                                        r6 = r10;
                                                        r3 = r9;
                                                        deviceKey2 = deviceKey;
                                                        r6.unlock(null);
                                                        r3.unlock(null);
                                                        return deviceKey2;
                                                    }
                                                }
                                            }
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        r4 = mutex2;
                                        r4.unlock(null);
                                        throw th;
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                r5 = mutex;
                                r5.unlock(null);
                                throw th;
                            }
                        }
                        return coroutine_suspended;
                    case 1:
                        Mutex mutex6 = (Mutex) anonymousClass1.L$4;
                        DeviceKeyStorage deviceKeyStorage6 = (DeviceKeyStorage) anonymousClass1.L$3;
                        DeviceKeyUserAuthentication deviceKeyUserAuthentication6 = (DeviceKeyUserAuthentication) anonymousClass1.L$2;
                        DeviceKeySlot deviceKeySlot6 = (DeviceKeySlot) anonymousClass1.L$1;
                        deviceKeyManager = (DeviceKeyManager) anonymousClass1.L$0;
                        ResultKt.throwOnFailure(objWithContext);
                        mutex = mutex6;
                        deviceKeyUserAuthentication4 = deviceKeyUserAuthentication6;
                        deviceKeyStorage2 = deviceKeyStorage6;
                        deviceKeySlot2 = deviceKeySlot6;
                        mutex2 = deviceKeyManager.mutex;
                        anonymousClass1.L$0 = deviceKeyManager;
                        anonymousClass1.L$1 = deviceKeySlot2;
                        anonymousClass1.L$2 = deviceKeyUserAuthentication4;
                        anonymousClass1.L$3 = deviceKeyStorage2;
                        anonymousClass1.L$4 = mutex;
                        anonymousClass1.L$5 = mutex2;
                        anonymousClass1.label = 2;
                        if (mutex2.lock(null, anonymousClass1) != coroutine_suspended) {
                            DeviceKeySlot deviceKeySlot7 = deviceKeySlot2;
                            deviceKeyUserAuthentication2 = deviceKeyUserAuthentication4;
                            deviceKeyManager2 = deviceKeyManager;
                            deviceKeySlot3 = deviceKeySlot7;
                            r2 = mutex;
                            DeviceKeyMetadataStore deviceKeyMetadataStore4 = deviceKeyManager2.store;
                            anonymousClass1.L$0 = deviceKeyManager2;
                            anonymousClass1.L$1 = deviceKeySlot3;
                            anonymousClass1.L$2 = deviceKeyUserAuthentication2;
                            anonymousClass1.L$3 = deviceKeyStorage2;
                            anonymousClass1.L$4 = r2;
                            anonymousClass1.L$5 = mutex2;
                            anonymousClass1.L$6 = deviceKeyManager2;
                            anonymousClass1.label = 3;
                            obj = deviceKeyMetadataStore4.read(anonymousClass1);
                            if (obj != coroutine_suspended) {
                                DeviceKeyStorage deviceKeyStorage7 = deviceKeyStorage2;
                                r7 = r2;
                                objWithContext = obj;
                                deviceKeySlot4 = deviceKeySlot3;
                                deviceKeyUserAuthentication3 = deviceKeyUserAuthentication2;
                                mutex3 = mutex2;
                                deviceKeyStorage3 = deviceKeyStorage7;
                                deviceKeyManager3 = deviceKeyManager2;
                                deviceKeyRecordOwedRevocation = deviceKeyManager2.owedRevocation((DeviceKeyRecord) objWithContext);
                                deviceKeyMetadataStore = deviceKeyManager3.store;
                                anonymousClass1.L$0 = deviceKeyManager3;
                                anonymousClass1.L$1 = deviceKeySlot4;
                                anonymousClass1.L$2 = deviceKeyUserAuthentication3;
                                anonymousClass1.L$3 = deviceKeyStorage3;
                                anonymousClass1.L$4 = r7;
                                anonymousClass1.L$5 = mutex3;
                                anonymousClass1.L$6 = deviceKeyRecordOwedRevocation;
                                anonymousClass1.label = 4;
                                mutex4 = mutex3;
                                r8 = r7;
                                if (deviceKeyMetadataStore.write(deviceKeyRecordOwedRevocation, anonymousClass1) == coroutine_suspended) {
                                    deviceKeyManager4 = deviceKeyManager3;
                                    DeviceKeyUserAuthentication deviceKeyUserAuthentication7 = deviceKeyUserAuthentication3;
                                    DeviceKeyStorage deviceKeyStorage8 = deviceKeyStorage3;
                                    CoroutineDispatcher io3 = Dispatchers.getIO();
                                    DeviceKeyManager$createKey$2$1$key$1 deviceKeyManager$createKey$2$1$key$2 = new DeviceKeyManager$createKey$2$1$key$1(deviceKeyManager4, deviceKeySlot4, deviceKeyUserAuthentication7, deviceKeyStorage8, null);
                                    anonymousClass1.L$0 = deviceKeyManager4;
                                    anonymousClass1.L$1 = r8;
                                    anonymousClass1.L$2 = mutex4;
                                    anonymousClass1.L$3 = deviceKeyRecordOwedRevocation;
                                    anonymousClass1.L$4 = null;
                                    anonymousClass1.L$5 = null;
                                    anonymousClass1.L$6 = null;
                                    anonymousClass1.label = 5;
                                    objWithContext = BuildersKt.withContext(io3, deviceKeyManager$createKey$2$1$key$2, anonymousClass1);
                                    if (objWithContext != coroutine_suspended) {
                                        deviceKeyManager5 = deviceKeyManager4;
                                        r10 = mutex4;
                                        r9 = r8;
                                        DeviceKeyRecord deviceKeyRecord2 = deviceKeyRecordOwedRevocation;
                                        deviceKey = (DeviceKey) objWithContext;
                                        deviceKeyMetadataStore2 = deviceKeyManager5.store;
                                        deviceKeyRecordCopy$default = DeviceKeyRecord.copy$default(deviceKeyRecord2, deviceKey, null, null, 6, null);
                                        anonymousClass1.L$0 = r9;
                                        anonymousClass1.L$1 = r10;
                                        anonymousClass1.L$2 = deviceKey;
                                        anonymousClass1.L$3 = null;
                                        anonymousClass1.label = 6;
                                        if (deviceKeyMetadataStore2.write(deviceKeyRecordCopy$default, anonymousClass1) != coroutine_suspended) {
                                            r6 = r10;
                                            r3 = r9;
                                            deviceKey2 = deviceKey;
                                            r6.unlock(null);
                                            r3.unlock(null);
                                            return deviceKey2;
                                        }
                                    }
                                }
                            }
                        }
                        return coroutine_suspended;
                    case 2:
                        Mutex mutex7 = (Mutex) anonymousClass1.L$5;
                        r5 = (Mutex) anonymousClass1.L$4;
                        deviceKeyStorage2 = (DeviceKeyStorage) anonymousClass1.L$3;
                        DeviceKeyUserAuthentication deviceKeyUserAuthentication8 = (DeviceKeyUserAuthentication) anonymousClass1.L$2;
                        deviceKeySlot3 = (DeviceKeySlot) anonymousClass1.L$1;
                        DeviceKeyManager deviceKeyManager6 = (DeviceKeyManager) anonymousClass1.L$0;
                        try {
                            ResultKt.throwOnFailure(objWithContext);
                            r2 = r5;
                            deviceKeyUserAuthentication2 = deviceKeyUserAuthentication8;
                            mutex2 = mutex7;
                            deviceKeyManager2 = deviceKeyManager6;
                            DeviceKeyMetadataStore deviceKeyMetadataStore5 = deviceKeyManager2.store;
                            anonymousClass1.L$0 = deviceKeyManager2;
                            anonymousClass1.L$1 = deviceKeySlot3;
                            anonymousClass1.L$2 = deviceKeyUserAuthentication2;
                            anonymousClass1.L$3 = deviceKeyStorage2;
                            anonymousClass1.L$4 = r2;
                            anonymousClass1.L$5 = mutex2;
                            anonymousClass1.L$6 = deviceKeyManager2;
                            anonymousClass1.label = 3;
                            obj = deviceKeyMetadataStore5.read(anonymousClass1);
                            if (obj != coroutine_suspended) {
                                DeviceKeyStorage deviceKeyStorage9 = deviceKeyStorage2;
                                r7 = r2;
                                objWithContext = obj;
                                deviceKeySlot4 = deviceKeySlot3;
                                deviceKeyUserAuthentication3 = deviceKeyUserAuthentication2;
                                mutex3 = mutex2;
                                deviceKeyStorage3 = deviceKeyStorage9;
                                deviceKeyManager3 = deviceKeyManager2;
                                deviceKeyRecordOwedRevocation = deviceKeyManager2.owedRevocation((DeviceKeyRecord) objWithContext);
                                deviceKeyMetadataStore = deviceKeyManager3.store;
                                anonymousClass1.L$0 = deviceKeyManager3;
                                anonymousClass1.L$1 = deviceKeySlot4;
                                anonymousClass1.L$2 = deviceKeyUserAuthentication3;
                                anonymousClass1.L$3 = deviceKeyStorage3;
                                anonymousClass1.L$4 = r7;
                                anonymousClass1.L$5 = mutex3;
                                anonymousClass1.L$6 = deviceKeyRecordOwedRevocation;
                                anonymousClass1.label = 4;
                                mutex4 = mutex3;
                                r8 = r7;
                                if (deviceKeyMetadataStore.write(deviceKeyRecordOwedRevocation, anonymousClass1) == coroutine_suspended) {
                                    deviceKeyManager4 = deviceKeyManager3;
                                    DeviceKeyUserAuthentication deviceKeyUserAuthentication9 = deviceKeyUserAuthentication3;
                                    DeviceKeyStorage deviceKeyStorage10 = deviceKeyStorage3;
                                    CoroutineDispatcher io4 = Dispatchers.getIO();
                                    DeviceKeyManager$createKey$2$1$key$1 deviceKeyManager$createKey$2$1$key$3 = new DeviceKeyManager$createKey$2$1$key$1(deviceKeyManager4, deviceKeySlot4, deviceKeyUserAuthentication9, deviceKeyStorage10, null);
                                    anonymousClass1.L$0 = deviceKeyManager4;
                                    anonymousClass1.L$1 = r8;
                                    anonymousClass1.L$2 = mutex4;
                                    anonymousClass1.L$3 = deviceKeyRecordOwedRevocation;
                                    anonymousClass1.L$4 = null;
                                    anonymousClass1.L$5 = null;
                                    anonymousClass1.L$6 = null;
                                    anonymousClass1.label = 5;
                                    objWithContext = BuildersKt.withContext(io4, deviceKeyManager$createKey$2$1$key$3, anonymousClass1);
                                    if (objWithContext != coroutine_suspended) {
                                        deviceKeyManager5 = deviceKeyManager4;
                                        r10 = mutex4;
                                        r9 = r8;
                                        DeviceKeyRecord deviceKeyRecord3 = deviceKeyRecordOwedRevocation;
                                        deviceKey = (DeviceKey) objWithContext;
                                        deviceKeyMetadataStore2 = deviceKeyManager5.store;
                                        deviceKeyRecordCopy$default = DeviceKeyRecord.copy$default(deviceKeyRecord3, deviceKey, null, null, 6, null);
                                        anonymousClass1.L$0 = r9;
                                        anonymousClass1.L$1 = r10;
                                        anonymousClass1.L$2 = deviceKey;
                                        anonymousClass1.L$3 = null;
                                        anonymousClass1.label = 6;
                                        if (deviceKeyMetadataStore2.write(deviceKeyRecordCopy$default, anonymousClass1) != coroutine_suspended) {
                                            r6 = r10;
                                            r3 = r9;
                                            deviceKey2 = deviceKey;
                                            r6.unlock(null);
                                            r3.unlock(null);
                                            return deviceKey2;
                                        }
                                    }
                                }
                            }
                            return coroutine_suspended;
                        } catch (Throwable th3) {
                            th = th3;
                            r5.unlock(null);
                            throw th;
                        }
                    case 3:
                        deviceKeyManager2 = (DeviceKeyManager) anonymousClass1.L$6;
                        Mutex mutex8 = (Mutex) anonymousClass1.L$5;
                        Mutex mutex9 = (Mutex) anonymousClass1.L$4;
                        deviceKeyStorage3 = (DeviceKeyStorage) anonymousClass1.L$3;
                        deviceKeyUserAuthentication3 = (DeviceKeyUserAuthentication) anonymousClass1.L$2;
                        deviceKeySlot4 = (DeviceKeySlot) anonymousClass1.L$1;
                        deviceKeyManager3 = (DeviceKeyManager) anonymousClass1.L$0;
                        ResultKt.throwOnFailure(objWithContext);
                        mutex3 = mutex8;
                        r7 = mutex9;
                        deviceKeyRecordOwedRevocation = deviceKeyManager2.owedRevocation((DeviceKeyRecord) objWithContext);
                        deviceKeyMetadataStore = deviceKeyManager3.store;
                        anonymousClass1.L$0 = deviceKeyManager3;
                        anonymousClass1.L$1 = deviceKeySlot4;
                        anonymousClass1.L$2 = deviceKeyUserAuthentication3;
                        anonymousClass1.L$3 = deviceKeyStorage3;
                        anonymousClass1.L$4 = r7;
                        anonymousClass1.L$5 = mutex3;
                        anonymousClass1.L$6 = deviceKeyRecordOwedRevocation;
                        anonymousClass1.label = 4;
                        mutex4 = mutex3;
                        r8 = r7;
                        if (deviceKeyMetadataStore.write(deviceKeyRecordOwedRevocation, anonymousClass1) == coroutine_suspended) {
                            deviceKeyManager4 = deviceKeyManager3;
                            DeviceKeyUserAuthentication deviceKeyUserAuthentication10 = deviceKeyUserAuthentication3;
                            DeviceKeyStorage deviceKeyStorage11 = deviceKeyStorage3;
                            CoroutineDispatcher io5 = Dispatchers.getIO();
                            DeviceKeyManager$createKey$2$1$key$1 deviceKeyManager$createKey$2$1$key$4 = new DeviceKeyManager$createKey$2$1$key$1(deviceKeyManager4, deviceKeySlot4, deviceKeyUserAuthentication10, deviceKeyStorage11, null);
                            anonymousClass1.L$0 = deviceKeyManager4;
                            anonymousClass1.L$1 = r8;
                            anonymousClass1.L$2 = mutex4;
                            anonymousClass1.L$3 = deviceKeyRecordOwedRevocation;
                            anonymousClass1.L$4 = null;
                            anonymousClass1.L$5 = null;
                            anonymousClass1.L$6 = null;
                            anonymousClass1.label = 5;
                            objWithContext = BuildersKt.withContext(io5, deviceKeyManager$createKey$2$1$key$4, anonymousClass1);
                            if (objWithContext != coroutine_suspended) {
                                deviceKeyManager5 = deviceKeyManager4;
                                r10 = mutex4;
                                r9 = r8;
                                DeviceKeyRecord deviceKeyRecord4 = deviceKeyRecordOwedRevocation;
                                deviceKey = (DeviceKey) objWithContext;
                                deviceKeyMetadataStore2 = deviceKeyManager5.store;
                                deviceKeyRecordCopy$default = DeviceKeyRecord.copy$default(deviceKeyRecord4, deviceKey, null, null, 6, null);
                                anonymousClass1.L$0 = r9;
                                anonymousClass1.L$1 = r10;
                                anonymousClass1.L$2 = deviceKey;
                                anonymousClass1.L$3 = null;
                                anonymousClass1.label = 6;
                                if (deviceKeyMetadataStore2.write(deviceKeyRecordCopy$default, anonymousClass1) != coroutine_suspended) {
                                    r6 = r10;
                                    r3 = r9;
                                    deviceKey2 = deviceKey;
                                    r6.unlock(null);
                                    r3.unlock(null);
                                    return deviceKey2;
                                }
                            }
                        }
                        return coroutine_suspended;
                    case 4:
                        deviceKeyRecordOwedRevocation = (DeviceKeyRecord) anonymousClass1.L$6;
                        Mutex mutex10 = (Mutex) anonymousClass1.L$5;
                        Mutex mutex11 = (Mutex) anonymousClass1.L$4;
                        deviceKeyStorage3 = (DeviceKeyStorage) anonymousClass1.L$3;
                        deviceKeyUserAuthentication3 = (DeviceKeyUserAuthentication) anonymousClass1.L$2;
                        deviceKeySlot4 = (DeviceKeySlot) anonymousClass1.L$1;
                        deviceKeyManager3 = (DeviceKeyManager) anonymousClass1.L$0;
                        ResultKt.throwOnFailure(objWithContext);
                        mutex4 = mutex10;
                        r8 = mutex11;
                        deviceKeyManager4 = deviceKeyManager3;
                        DeviceKeyUserAuthentication deviceKeyUserAuthentication11 = deviceKeyUserAuthentication3;
                        DeviceKeyStorage deviceKeyStorage12 = deviceKeyStorage3;
                        CoroutineDispatcher io6 = Dispatchers.getIO();
                        DeviceKeyManager$createKey$2$1$key$1 deviceKeyManager$createKey$2$1$key$5 = new DeviceKeyManager$createKey$2$1$key$1(deviceKeyManager4, deviceKeySlot4, deviceKeyUserAuthentication11, deviceKeyStorage12, null);
                        anonymousClass1.L$0 = deviceKeyManager4;
                        anonymousClass1.L$1 = r8;
                        anonymousClass1.L$2 = mutex4;
                        anonymousClass1.L$3 = deviceKeyRecordOwedRevocation;
                        anonymousClass1.L$4 = null;
                        anonymousClass1.L$5 = null;
                        anonymousClass1.L$6 = null;
                        anonymousClass1.label = 5;
                        objWithContext = BuildersKt.withContext(io6, deviceKeyManager$createKey$2$1$key$5, anonymousClass1);
                        if (objWithContext != coroutine_suspended) {
                            deviceKeyManager5 = deviceKeyManager4;
                            r10 = mutex4;
                            r9 = r8;
                            DeviceKeyRecord deviceKeyRecord5 = deviceKeyRecordOwedRevocation;
                            deviceKey = (DeviceKey) objWithContext;
                            deviceKeyMetadataStore2 = deviceKeyManager5.store;
                            deviceKeyRecordCopy$default = DeviceKeyRecord.copy$default(deviceKeyRecord5, deviceKey, null, null, 6, null);
                            anonymousClass1.L$0 = r9;
                            anonymousClass1.L$1 = r10;
                            anonymousClass1.L$2 = deviceKey;
                            anonymousClass1.L$3 = null;
                            anonymousClass1.label = 6;
                            if (deviceKeyMetadataStore2.write(deviceKeyRecordCopy$default, anonymousClass1) != coroutine_suspended) {
                                r6 = r10;
                                r3 = r9;
                                deviceKey2 = deviceKey;
                                r6.unlock(null);
                                r3.unlock(null);
                                return deviceKey2;
                            }
                        }
                        return coroutine_suspended;
                    case 5:
                        deviceKeyRecordOwedRevocation = (DeviceKeyRecord) anonymousClass1.L$3;
                        Mutex mutex12 = (Mutex) anonymousClass1.L$2;
                        Mutex mutex13 = (Mutex) anonymousClass1.L$1;
                        deviceKeyManager5 = (DeviceKeyManager) anonymousClass1.L$0;
                        ResultKt.throwOnFailure(objWithContext);
                        r10 = mutex12;
                        r9 = mutex13;
                        DeviceKeyRecord deviceKeyRecord6 = deviceKeyRecordOwedRevocation;
                        deviceKey = (DeviceKey) objWithContext;
                        deviceKeyMetadataStore2 = deviceKeyManager5.store;
                        deviceKeyRecordCopy$default = DeviceKeyRecord.copy$default(deviceKeyRecord6, deviceKey, null, null, 6, null);
                        anonymousClass1.L$0 = r9;
                        anonymousClass1.L$1 = r10;
                        anonymousClass1.L$2 = deviceKey;
                        anonymousClass1.L$3 = null;
                        anonymousClass1.label = 6;
                        if (deviceKeyMetadataStore2.write(deviceKeyRecordCopy$default, anonymousClass1) != coroutine_suspended) {
                            r6 = r10;
                            r3 = r9;
                            deviceKey2 = deviceKey;
                            r6.unlock(null);
                            r3.unlock(null);
                            return deviceKey2;
                        }
                        return coroutine_suspended;
                    case 6:
                        deviceKey2 = (DeviceKey) anonymousClass1.L$2;
                        r4 = (Mutex) anonymousClass1.L$1;
                        Mutex mutex14 = (Mutex) anonymousClass1.L$0;
                        try {
                            ResultKt.throwOnFailure(objWithContext);
                            r3 = mutex14;
                            r6 = r4;
                            r6.unlock(null);
                            r3.unlock(null);
                            return deviceKey2;
                        } catch (Throwable th4) {
                            th = th4;
                            r4.unlock(null);
                            throw th;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable th5) {
                th = th5;
                r4 = r10;
            }
        } catch (Throwable th6) {
            th = th6;
            r5 = anonymousClass1;
        }
    }

    private final DeviceKeyRecord owedRevocation(DeviceKeyRecord deviceKeyRecord) {
        DeviceKey key = deviceKeyRecord != null ? deviceKeyRecord.getKey() : null;
        if (key != null) {
            return new DeviceKeyRecord(null, key.getKid(), key.getSubject(), 1, null);
        }
        return new DeviceKeyRecord(null, deviceKeyRecord != null ? deviceKeyRecord.getPendingRevocationKid() : null, deviceKeyRecord != null ? deviceKeyRecord.getPendingRevocationSubject() : null, 1, null);
    }

    public final boolean canUse(DeviceKeyUserAuthentication userAuthentication) {
        Intrinsics.checkNotNullParameter(userAuthentication, "userAuthentication");
        return this.prompt.canUse(userAuthentication);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x007f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object enrolledKey(DeviceKeySlot deviceKeySlot, Continuation continuation) throws Throwable {
        C04691 c04691;
        Mutex mutex;
        DeviceKeyManager deviceKeyManager;
        Throwable th;
        Mutex mutex2;
        DeviceKey deviceKey;
        if (continuation instanceof C04691) {
            c04691 = (C04691) continuation;
            int i = c04691.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                c04691.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                c04691 = new C04691(continuation);
            }
        } else {
            c04691 = new C04691(continuation);
        }
        Object obj = c04691.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c04691.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = this.mutex;
                c04691.L$0 = this;
                c04691.L$1 = deviceKeySlot;
                c04691.L$2 = mutex;
                c04691.label = 1;
                if (mutex.lock(null, c04691) != coroutine_suspended) {
                    deviceKeyManager = this;
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutex2 = (Mutex) c04691.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    deviceKey = (DeviceKey) obj;
                    if (deviceKey != null || deviceKey.getSubject() == null) {
                        deviceKey = null;
                    }
                    mutex2.unlock(null);
                    return deviceKey;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            Mutex mutex3 = (Mutex) c04691.L$2;
            DeviceKeySlot deviceKeySlot2 = (DeviceKeySlot) c04691.L$1;
            deviceKeyManager = (DeviceKeyManager) c04691.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex3;
            deviceKeySlot = deviceKeySlot2;
            c04691.L$0 = mutex;
            c04691.L$1 = null;
            c04691.L$2 = null;
            c04691.label = 2;
            Object objPreflightKey = deviceKeyManager.preflightKey(deviceKeySlot, c04691);
            if (objPreflightKey != coroutine_suspended) {
                Mutex mutex4 = mutex;
                obj = objPreflightKey;
                mutex2 = mutex4;
                deviceKey = (DeviceKey) obj;
                if (deviceKey != null) {
                    deviceKey = null;
                } else {
                    deviceKey = null;
                }
                mutex2.unlock(null);
                return deviceKey;
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            Mutex mutex5 = mutex;
            th = th3;
            mutex2 = mutex5;
            mutex2.unlock(null);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:41:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:45:0x00df  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v20, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    public final Object deleteKey(DeviceKeySlot deviceKeySlot, Continuation continuation) throws Throwable {
        C04671 c04671;
        Mutex mutex;
        DeviceKeySlot deviceKeySlot2;
        DeviceKeyManager deviceKeyManager;
        Throwable th;
        ?? r11;
        DeviceKeyRecord deviceKeyRecordOwedRevocation;
        DeviceKeyManager deviceKeyManager2;
        DeviceKeyMetadataStore deviceKeyMetadataStore;
        DeviceKeyManager deviceKeyManager3;
        Object obj;
        CoroutineDispatcher io2;
        DeviceKeyManager$deleteKey$2$1 deviceKeyManager$deleteKey$2$1;
        if (continuation instanceof C04671) {
            c04671 = (C04671) continuation;
            int i = c04671.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                c04671.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                c04671 = new C04671(continuation);
            }
        } else {
            c04671 = new C04671(continuation);
        }
        Object obj2 = c04671.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r2 = c04671.label;
        try {
            if (r2 == 0) {
                ResultKt.throwOnFailure(obj2);
                mutex = this.mutex;
                c04671.L$0 = this;
                c04671.L$1 = deviceKeySlot;
                c04671.L$2 = mutex;
                c04671.label = 1;
                if (mutex.lock(null, c04671) != coroutine_suspended) {
                    deviceKeySlot2 = deviceKeySlot;
                    deviceKeyManager = this;
                }
                return coroutine_suspended;
            }
            if (r2 != 1) {
                try {
                    if (r2 != 2) {
                        if (r2 != 3) {
                            if (r2 != 4) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            r11 = (Mutex) c04671.L$0;
                            try {
                                ResultKt.throwOnFailure(obj2);
                                r11 = r11;
                                Unit unit = Unit.INSTANCE;
                                r11.unlock(null);
                                return unit;
                            } catch (Throwable th2) {
                                th = th2;
                                r11.unlock(null);
                                throw th;
                            }
                        }
                        deviceKeyRecordOwedRevocation = (DeviceKeyRecord) c04671.L$2;
                        Mutex mutex2 = (Mutex) c04671.L$1;
                        deviceKeyManager2 = (DeviceKeyManager) c04671.L$0;
                        ResultKt.throwOnFailure(obj2);
                        mutex = mutex2;
                        deviceKeyMetadataStore = deviceKeyManager2.store;
                        c04671.L$0 = mutex;
                        c04671.L$1 = null;
                        c04671.L$2 = null;
                        c04671.label = 4;
                        if (deviceKeyMetadataStore.write(deviceKeyRecordOwedRevocation, c04671) != coroutine_suspended) {
                            r11 = mutex;
                            Unit unit2 = Unit.INSTANCE;
                            r11.unlock(null);
                            return unit2;
                        }
                        return coroutine_suspended;
                    }
                    deviceKeyManager = (DeviceKeyManager) c04671.L$3;
                    Mutex mutex3 = (Mutex) c04671.L$2;
                    DeviceKeySlot deviceKeySlot3 = (DeviceKeySlot) c04671.L$1;
                    deviceKeyManager3 = (DeviceKeyManager) c04671.L$0;
                    ResultKt.throwOnFailure(obj2);
                    obj = obj2;
                    mutex = mutex3;
                    deviceKeySlot2 = deviceKeySlot3;
                    deviceKeyRecordOwedRevocation = deviceKeyManager.owedRevocation((DeviceKeyRecord) obj);
                    io2 = Dispatchers.getIO();
                    deviceKeyManager$deleteKey$2$1 = new DeviceKeyManager$deleteKey$2$1(deviceKeyManager3, deviceKeySlot2, null);
                    c04671.L$0 = deviceKeyManager3;
                    c04671.L$1 = mutex;
                    c04671.L$2 = deviceKeyRecordOwedRevocation;
                    c04671.L$3 = null;
                    c04671.label = 3;
                    if (BuildersKt.withContext(io2, deviceKeyManager$deleteKey$2$1, c04671) == coroutine_suspended) {
                        deviceKeyManager2 = deviceKeyManager3;
                        deviceKeyMetadataStore = deviceKeyManager2.store;
                        c04671.L$0 = mutex;
                        c04671.L$1 = null;
                        c04671.L$2 = null;
                        c04671.label = 4;
                        if (deviceKeyMetadataStore.write(deviceKeyRecordOwedRevocation, c04671) != coroutine_suspended) {
                            r11 = mutex;
                            Unit unit3 = Unit.INSTANCE;
                            r11.unlock(null);
                            return unit3;
                        }
                    }
                    return coroutine_suspended;
                } catch (Throwable th3) {
                    th = th3;
                    r11 = r2;
                    r11.unlock(null);
                    throw th;
                }
            }
            Mutex mutex4 = (Mutex) c04671.L$2;
            deviceKeySlot2 = (DeviceKeySlot) c04671.L$1;
            DeviceKeyManager deviceKeyManager4 = (DeviceKeyManager) c04671.L$0;
            ResultKt.throwOnFailure(obj2);
            mutex = mutex4;
            deviceKeyManager = deviceKeyManager4;
            DeviceKeyMetadataStore deviceKeyMetadataStore2 = deviceKeyManager.store;
            c04671.L$0 = deviceKeyManager;
            c04671.L$1 = deviceKeySlot2;
            c04671.L$2 = mutex;
            c04671.L$3 = deviceKeyManager;
            c04671.label = 2;
            obj = deviceKeyMetadataStore2.read(c04671);
            if (obj != coroutine_suspended) {
                deviceKeyManager3 = deviceKeyManager;
                deviceKeyRecordOwedRevocation = deviceKeyManager.owedRevocation((DeviceKeyRecord) obj);
                io2 = Dispatchers.getIO();
                deviceKeyManager$deleteKey$2$1 = new DeviceKeyManager$deleteKey$2$1(deviceKeyManager3, deviceKeySlot2, null);
                c04671.L$0 = deviceKeyManager3;
                c04671.L$1 = mutex;
                c04671.L$2 = deviceKeyRecordOwedRevocation;
                c04671.L$3 = null;
                c04671.label = 3;
                if (BuildersKt.withContext(io2, deviceKeyManager$deleteKey$2$1, c04671) == coroutine_suspended) {
                    deviceKeyManager2 = deviceKeyManager3;
                    deviceKeyMetadataStore = deviceKeyManager2.store;
                    c04671.L$0 = mutex;
                    c04671.L$1 = null;
                    c04671.L$2 = null;
                    c04671.label = 4;
                    if (deviceKeyMetadataStore.write(deviceKeyRecordOwedRevocation, c04671) != coroutine_suspended) {
                        r11 = mutex;
                        Unit unit4 = Unit.INSTANCE;
                        r11.unlock(null);
                        return unit4;
                    }
                }
            }
            return coroutine_suspended;
        } catch (Throwable th4) {
            Mutex mutex5 = mutex;
            th = th4;
            r11 = mutex5;
            r11.unlock(null);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object setSubject(DeviceKeySlot deviceKeySlot, String str, Continuation continuation) throws Throwable {
        C04781 c04781;
        DeviceKeySlot deviceKeySlot2;
        DeviceKeyManager deviceKeyManager;
        String str2;
        Mutex mutex;
        Mutex mutex2;
        String str3;
        DeviceKeySlot deviceKeySlot3;
        Mutex mutex3;
        DeviceKeyManager deviceKeyManager2;
        DeviceKeyRecord deviceKeyRecord;
        DeviceKey key;
        if (continuation instanceof C04781) {
            c04781 = (C04781) continuation;
            int i = c04781.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                c04781.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                c04781 = new C04781(continuation);
            }
        } else {
            c04781 = new C04781(continuation);
        }
        Object obj = c04781.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c04781.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                Mutex mutex4 = this.mutex;
                c04781.L$0 = this;
                deviceKeySlot2 = deviceKeySlot;
                c04781.L$1 = deviceKeySlot2;
                c04781.L$2 = str;
                c04781.L$3 = mutex4;
                c04781.label = 1;
                if (mutex4.lock(null, c04781) != coroutine_suspended) {
                    deviceKeyManager = this;
                    str2 = str;
                    mutex = mutex4;
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mutex2 = (Mutex) c04781.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        Unit unit = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return unit;
                    } catch (Throwable th) {
                        th = th;
                        mutex2.unlock(null);
                        throw th;
                    }
                }
                mutex3 = (Mutex) c04781.L$3;
                String str4 = (String) c04781.L$2;
                deviceKeySlot3 = (DeviceKeySlot) c04781.L$1;
                deviceKeyManager2 = (DeviceKeyManager) c04781.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    str3 = str4;
                    deviceKeyRecord = (DeviceKeyRecord) obj;
                    if (deviceKeyRecord != null || (key = deviceKeyRecord.getKey()) == null) {
                        throw new AuthError(AppAuthErrorCode.DEVICE_KEY_INVALIDATED, "The " + deviceKeySlot3.getStringValue() + " slot holds no key to record a subject on", null, 4, null);
                    }
                    DeviceKeyMetadataStore deviceKeyMetadataStore = deviceKeyManager2.store;
                    DeviceKeyRecord deviceKeyRecordCopy$default = DeviceKeyRecord.copy$default(deviceKeyRecord, DeviceKey.copy$default(key, null, null, null, str3, null, null, 55, null), null, null, 6, null);
                    c04781.L$0 = mutex3;
                    c04781.L$1 = null;
                    c04781.L$2 = null;
                    c04781.L$3 = null;
                    c04781.label = 3;
                    if (deviceKeyMetadataStore.write(deviceKeyRecordCopy$default, c04781) != coroutine_suspended) {
                        mutex2 = mutex3;
                        Unit unit2 = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return unit2;
                    }
                    return coroutine_suspended;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2 = mutex3;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            Mutex mutex5 = (Mutex) c04781.L$3;
            str2 = (String) c04781.L$2;
            DeviceKeySlot deviceKeySlot4 = (DeviceKeySlot) c04781.L$1;
            deviceKeyManager = (DeviceKeyManager) c04781.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex5;
            deviceKeySlot2 = deviceKeySlot4;
            DeviceKeyMetadataStore deviceKeyMetadataStore2 = deviceKeyManager.store;
            c04781.L$0 = deviceKeyManager;
            c04781.L$1 = deviceKeySlot2;
            c04781.L$2 = str2;
            c04781.L$3 = mutex;
            c04781.label = 2;
            obj = deviceKeyMetadataStore2.read(c04781);
            if (obj != coroutine_suspended) {
                str3 = str2;
                deviceKeySlot3 = deviceKeySlot2;
                mutex3 = mutex;
                deviceKeyManager2 = deviceKeyManager;
                deviceKeyRecord = (DeviceKeyRecord) obj;
                if (deviceKeyRecord != null) {
                }
                throw new AuthError(AppAuthErrorCode.DEVICE_KEY_INVALIDATED, "The " + deviceKeySlot3.getStringValue() + " slot holds no key to record a subject on", null, 4, null);
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            th = th3;
            mutex2 = mutex;
            mutex2.unlock(null);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:104:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:108:0x02ba  */
    /* JADX WARN: Code duplicated, block: B:112:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:145:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x018a  */
    /* JADX WARN: Code duplicated, block: B:59:0x01af  */
    /* JADX WARN: Code duplicated, block: B:71:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:74:0x01df  */
    /* JADX WARN: Code duplicated, block: B:75:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:77:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:78:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code duplicated, block: B:83:0x0220  */
    /* JADX WARN: Code duplicated, block: B:88:0x0249  */
    /* JADX WARN: Code duplicated, block: B:96:0x0286  */
    public final Object enroll(DeviceKeySlot deviceKeySlot, DeviceKeyUserAuthentication deviceKeyUserAuthentication, DeviceKeyStorage deviceKeyStorage, String str, String str2, Continuation continuation) throws Exception {
        C04681 c04681;
        Object objM5243constructorimpl;
        DeviceKeyManager deviceKeyManager;
        DeviceKeySlot deviceKeySlot2;
        String str3;
        String str4;
        DeviceKeyRegistrar deviceKeyRegistrar;
        DeviceKey deviceKey;
        DeviceKeyRecord deviceKeyRecord;
        String pendingRevocationKid;
        String pendingRevocationSubject;
        DeviceKeyRecord deviceKeyRecord2;
        DeviceKeySlot deviceKeySlot3;
        DeviceKeyManager deviceKeyManager2;
        DeviceKey deviceKey2;
        String str5;
        DeviceKeyRegistrar deviceKeyRegistrar2;
        String str6;
        String str7;
        Exception exc;
        String str8;
        DeviceKeySlot deviceKeySlot4;
        String str9;
        String str10;
        DeviceKey deviceKey3;
        DeviceKeyRecord deviceKeyRecord3;
        String str11;
        DeviceKey deviceKey4;
        DeviceKeySlot deviceKeySlot5;
        Object objRevoke;
        Object objM5243constructorimpl2;
        Boolean boolBoxBoolean;
        Exception exc2;
        String str12;
        String str13;
        DeviceKeyManager deviceKeyManager3;
        DeviceKeyRegistrar deviceKeyRegistrar3;
        DeviceKeySlot deviceKeySlot6;
        DeviceKey deviceKey5;
        Mutex mutex;
        DeviceKeyManager deviceKeyManager4;
        Mutex mutex2;
        Mutex mutex3;
        Object obj;
        if (continuation instanceof C04681) {
            c04681 = (C04681) continuation;
            int i = c04681.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                c04681.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                c04681 = new C04681(continuation);
            }
        } else {
            c04681 = new C04681(continuation);
        }
        Object objRegister = c04681.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            try {
                try {
                    switch (c04681.label) {
                        case 0:
                            ResultKt.throwOnFailure(objRegister);
                            DeviceKeyRegistrar deviceKeyRegistrar4 = this.registrar;
                            if (deviceKeyRegistrar4 == null) {
                                throw new AuthError(AppAuthErrorCode.INVALID_CONFIGURATION, "No device-key registrar is configured", null, 4, null);
                            }
                            c04681.L$0 = this;
                            c04681.L$1 = deviceKeySlot;
                            str12 = str;
                            c04681.L$2 = str12;
                            str13 = str2;
                            c04681.L$3 = str13;
                            c04681.L$4 = deviceKeyRegistrar4;
                            c04681.label = 1;
                            Object objCreateKey = createKey(deviceKeySlot, deviceKeyUserAuthentication, deviceKeyStorage, c04681);
                            if (objCreateKey != coroutine_suspended) {
                                deviceKeyManager3 = this;
                                deviceKeyRegistrar3 = deviceKeyRegistrar4;
                                objRegister = objCreateKey;
                                deviceKeySlot6 = deviceKeySlot;
                                deviceKey5 = (DeviceKey) objRegister;
                                try {
                                    Result.Companion companion = Result.Companion;
                                    mutex = deviceKeyManager3.mutex;
                                    c04681.L$0 = deviceKeyManager3;
                                    c04681.L$1 = deviceKeySlot6;
                                    c04681.L$2 = str12;
                                    c04681.L$3 = str13;
                                    c04681.L$4 = deviceKeyRegistrar3;
                                    c04681.L$5 = deviceKey5;
                                    c04681.L$6 = deviceKeyManager3;
                                    c04681.L$7 = mutex;
                                    c04681.label = 2;
                                    if (mutex.lock(null, c04681) != coroutine_suspended) {
                                        deviceKeySlot2 = deviceKeySlot6;
                                        deviceKeyManager = deviceKeyManager3;
                                        deviceKeyRegistrar = deviceKeyRegistrar3;
                                        str3 = str12;
                                        str4 = str13;
                                        deviceKeyManager4 = deviceKeyManager;
                                        deviceKey = deviceKey5;
                                        mutex2 = mutex;
                                        try {
                                            DeviceKeyMetadataStore deviceKeyMetadataStore = deviceKeyManager4.store;
                                            c04681.L$0 = deviceKeyManager;
                                            c04681.L$1 = deviceKeySlot2;
                                            c04681.L$2 = str3;
                                            c04681.L$3 = str4;
                                            c04681.L$4 = deviceKeyRegistrar;
                                            c04681.L$5 = deviceKey;
                                            c04681.L$6 = mutex2;
                                            c04681.L$7 = null;
                                            c04681.label = 3;
                                            obj = deviceKeyMetadataStore.read(c04681);
                                            if (obj != coroutine_suspended) {
                                                mutex3 = mutex2;
                                                objRegister = obj;
                                                DeviceKeyRecord deviceKeyRecord4 = (DeviceKeyRecord) objRegister;
                                                mutex3.unlock(null);
                                                objM5243constructorimpl = Result.m5243constructorimpl(deviceKeyRecord4);
                                                if (Result.m5248isFailureimpl(objM5243constructorimpl)) {
                                                    objM5243constructorimpl = null;
                                                }
                                                deviceKeyRecord = (DeviceKeyRecord) objM5243constructorimpl;
                                                if (deviceKeyRecord != null) {
                                                    pendingRevocationKid = deviceKeyRecord.getPendingRevocationKid();
                                                } else {
                                                    pendingRevocationKid = null;
                                                }
                                                if (deviceKeyRecord != null) {
                                                    pendingRevocationSubject = deviceKeyRecord.getPendingRevocationSubject();
                                                } else {
                                                    pendingRevocationSubject = null;
                                                }
                                                deviceKeyRecord2 = new DeviceKeyRecord(null, pendingRevocationKid, pendingRevocationSubject, 1, null);
                                                try {
                                                    String publicJwk = deviceKey.getPublicJwk();
                                                    c04681.L$0 = deviceKeyManager;
                                                    c04681.L$1 = deviceKeySlot2;
                                                    c04681.L$2 = str3;
                                                    c04681.L$3 = str4;
                                                    c04681.L$4 = deviceKeyRegistrar;
                                                    c04681.L$5 = deviceKey;
                                                    c04681.L$6 = deviceKeyRecord2;
                                                    c04681.L$7 = null;
                                                    c04681.label = 4;
                                                    objRegister = deviceKeyRegistrar.register(publicJwk, str3, str4, c04681);
                                                    if (objRegister != coroutine_suspended) {
                                                        DeviceKeyRegistrar deviceKeyRegistrar5 = deviceKeyRegistrar;
                                                        deviceKey2 = deviceKey;
                                                        str5 = str4;
                                                        deviceKeyRegistrar2 = deviceKeyRegistrar5;
                                                        DeviceKeyManager deviceKeyManager5 = deviceKeyManager;
                                                        str6 = str3;
                                                        deviceKeySlot3 = deviceKeySlot2;
                                                        deviceKeyManager2 = deviceKeyManager5;
                                                        str7 = (String) objRegister;
                                                        try {
                                                            c04681.L$0 = deviceKeyManager2;
                                                            c04681.L$1 = deviceKeySlot3;
                                                            c04681.L$2 = str6;
                                                            c04681.L$3 = str5;
                                                            c04681.L$4 = deviceKeyRegistrar2;
                                                            c04681.L$5 = deviceKey2;
                                                            c04681.L$6 = deviceKeyRecord2;
                                                            c04681.L$7 = str7;
                                                            c04681.label = 6;
                                                            if (deviceKeyManager2.setSubject(deviceKeySlot3, str7, c04681) != coroutine_suspended) {
                                                                str11 = str7;
                                                                return DeviceKey.copy$default(deviceKey2, null, null, null, str11, null, null, 55, null);
                                                            }
                                                        } catch (Exception e) {
                                                            DeviceKeyRecord deviceKeyRecord5 = deviceKeyRecord2;
                                                            exc = e;
                                                            str8 = str6;
                                                            deviceKeySlot4 = deviceKeySlot3;
                                                            str9 = str5;
                                                            str10 = str7;
                                                            deviceKey3 = deviceKey2;
                                                            deviceKeyRecord3 = deviceKeyRecord5;
                                                            try {
                                                                Result.Companion companion2 = Result.Companion;
                                                                String kid = deviceKey3.getKid();
                                                                c04681.L$0 = deviceKeyManager2;
                                                                c04681.L$1 = deviceKeySlot4;
                                                                c04681.L$2 = deviceKey3;
                                                                c04681.L$3 = deviceKeyRecord3;
                                                                c04681.L$4 = str10;
                                                                c04681.L$5 = exc;
                                                                c04681.L$6 = null;
                                                                c04681.L$7 = null;
                                                                c04681.label = 7;
                                                                objRevoke = deviceKeyRegistrar2.revoke(kid, str8, str9, c04681);
                                                                if (objRevoke != coroutine_suspended) {
                                                                    deviceKey4 = deviceKey3;
                                                                    deviceKeySlot5 = deviceKeySlot4;
                                                                    objRegister = objRevoke;
                                                                    objM5243constructorimpl2 = Result.m5243constructorimpl(Boxing.boxBoolean(((Boolean) objRegister).booleanValue()));
                                                                    boolBoxBoolean = Boxing.boxBoolean(false);
                                                                    if (Result.m5248isFailureimpl(objM5243constructorimpl2)) {
                                                                        objM5243constructorimpl2 = boolBoxBoolean;
                                                                    }
                                                                    if (!((Boolean) objM5243constructorimpl2).booleanValue()) {
                                                                        deviceKeyRecord3 = new DeviceKeyRecord(null, deviceKey4.getKid(), str10, 1, null);
                                                                    }
                                                                    c04681.L$0 = exc;
                                                                    c04681.L$1 = null;
                                                                    c04681.L$2 = null;
                                                                    c04681.L$3 = null;
                                                                    c04681.L$4 = null;
                                                                    c04681.L$5 = null;
                                                                    c04681.L$6 = null;
                                                                    c04681.L$7 = null;
                                                                    c04681.label = 8;
                                                                    if (deviceKeyManager2.retireLocally(deviceKeySlot5, deviceKeyRecord3, c04681) != coroutine_suspended) {
                                                                        exc2 = exc;
                                                                        throw new AuthError(AppAuthErrorCode.DEVICE_KEY_REGISTRATION_FAILED, "The device key was registered but its record could not be written", exc2);
                                                                    }
                                                                }
                                                            } catch (Throwable th) {
                                                                th = th;
                                                                deviceKey4 = deviceKey3;
                                                                deviceKeySlot5 = deviceKeySlot4;
                                                                Result.Companion companion3 = Result.Companion;
                                                                objM5243constructorimpl2 = Result.m5243constructorimpl(ResultKt.createFailure(th));
                                                            }
                                                        }
                                                    }
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    deviceKeySlot3 = deviceKeySlot2;
                                                    deviceKeyManager2 = deviceKeyManager;
                                                    c04681.L$0 = e;
                                                    c04681.L$1 = null;
                                                    c04681.L$2 = null;
                                                    c04681.L$3 = null;
                                                    c04681.L$4 = null;
                                                    c04681.L$5 = null;
                                                    c04681.L$6 = null;
                                                    c04681.L$7 = null;
                                                    c04681.label = 5;
                                                    if (deviceKeyManager2.retireLocally(deviceKeySlot3, deviceKeyRecord2, c04681) == coroutine_suspended) {
                                                        throw e;
                                                    }
                                                }
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            mutex3 = mutex2;
                                            mutex3.unlock(null);
                                            throw th;
                                        }
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    deviceKeySlot2 = deviceKeySlot6;
                                    deviceKeyManager = deviceKeyManager3;
                                    deviceKeyRegistrar = deviceKeyRegistrar3;
                                    str3 = str12;
                                    str4 = str13;
                                    deviceKey = deviceKey5;
                                    Result.Companion companion4 = Result.Companion;
                                    objM5243constructorimpl = Result.m5243constructorimpl(ResultKt.createFailure(th));
                                }
                            }
                            return coroutine_suspended;
                        case 1:
                            DeviceKeyRegistrar deviceKeyRegistrar6 = (DeviceKeyRegistrar) c04681.L$4;
                            String str14 = (String) c04681.L$3;
                            String str15 = (String) c04681.L$2;
                            deviceKeySlot6 = (DeviceKeySlot) c04681.L$1;
                            deviceKeyManager3 = (DeviceKeyManager) c04681.L$0;
                            ResultKt.throwOnFailure(objRegister);
                            str13 = str14;
                            str12 = str15;
                            deviceKeyRegistrar3 = deviceKeyRegistrar6;
                            deviceKey5 = (DeviceKey) objRegister;
                            Result.Companion companion5 = Result.Companion;
                            mutex = deviceKeyManager3.mutex;
                            c04681.L$0 = deviceKeyManager3;
                            c04681.L$1 = deviceKeySlot6;
                            c04681.L$2 = str12;
                            c04681.L$3 = str13;
                            c04681.L$4 = deviceKeyRegistrar3;
                            c04681.L$5 = deviceKey5;
                            c04681.L$6 = deviceKeyManager3;
                            c04681.L$7 = mutex;
                            c04681.label = 2;
                            if (mutex.lock(null, c04681) != coroutine_suspended) {
                                deviceKeySlot2 = deviceKeySlot6;
                                deviceKeyManager = deviceKeyManager3;
                                deviceKeyRegistrar = deviceKeyRegistrar3;
                                str3 = str12;
                                str4 = str13;
                                deviceKeyManager4 = deviceKeyManager;
                                deviceKey = deviceKey5;
                                mutex2 = mutex;
                                DeviceKeyMetadataStore deviceKeyMetadataStore2 = deviceKeyManager4.store;
                                c04681.L$0 = deviceKeyManager;
                                c04681.L$1 = deviceKeySlot2;
                                c04681.L$2 = str3;
                                c04681.L$3 = str4;
                                c04681.L$4 = deviceKeyRegistrar;
                                c04681.L$5 = deviceKey;
                                c04681.L$6 = mutex2;
                                c04681.L$7 = null;
                                c04681.label = 3;
                                obj = deviceKeyMetadataStore2.read(c04681);
                                if (obj != coroutine_suspended) {
                                    mutex3 = mutex2;
                                    objRegister = obj;
                                    DeviceKeyRecord deviceKeyRecord6 = (DeviceKeyRecord) objRegister;
                                    mutex3.unlock(null);
                                    objM5243constructorimpl = Result.m5243constructorimpl(deviceKeyRecord6);
                                    if (Result.m5248isFailureimpl(objM5243constructorimpl)) {
                                        objM5243constructorimpl = null;
                                    }
                                    deviceKeyRecord = (DeviceKeyRecord) objM5243constructorimpl;
                                    if (deviceKeyRecord != null) {
                                        pendingRevocationKid = deviceKeyRecord.getPendingRevocationKid();
                                    } else {
                                        pendingRevocationKid = null;
                                    }
                                    if (deviceKeyRecord != null) {
                                        pendingRevocationSubject = deviceKeyRecord.getPendingRevocationSubject();
                                    } else {
                                        pendingRevocationSubject = null;
                                    }
                                    deviceKeyRecord2 = new DeviceKeyRecord(null, pendingRevocationKid, pendingRevocationSubject, 1, null);
                                    String publicJwk2 = deviceKey.getPublicJwk();
                                    c04681.L$0 = deviceKeyManager;
                                    c04681.L$1 = deviceKeySlot2;
                                    c04681.L$2 = str3;
                                    c04681.L$3 = str4;
                                    c04681.L$4 = deviceKeyRegistrar;
                                    c04681.L$5 = deviceKey;
                                    c04681.L$6 = deviceKeyRecord2;
                                    c04681.L$7 = null;
                                    c04681.label = 4;
                                    objRegister = deviceKeyRegistrar.register(publicJwk2, str3, str4, c04681);
                                    if (objRegister != coroutine_suspended) {
                                        DeviceKeyRegistrar deviceKeyRegistrar7 = deviceKeyRegistrar;
                                        deviceKey2 = deviceKey;
                                        str5 = str4;
                                        deviceKeyRegistrar2 = deviceKeyRegistrar7;
                                        DeviceKeyManager deviceKeyManager6 = deviceKeyManager;
                                        str6 = str3;
                                        deviceKeySlot3 = deviceKeySlot2;
                                        deviceKeyManager2 = deviceKeyManager6;
                                        str7 = (String) objRegister;
                                        c04681.L$0 = deviceKeyManager2;
                                        c04681.L$1 = deviceKeySlot3;
                                        c04681.L$2 = str6;
                                        c04681.L$3 = str5;
                                        c04681.L$4 = deviceKeyRegistrar2;
                                        c04681.L$5 = deviceKey2;
                                        c04681.L$6 = deviceKeyRecord2;
                                        c04681.L$7 = str7;
                                        c04681.label = 6;
                                        if (deviceKeyManager2.setSubject(deviceKeySlot3, str7, c04681) != coroutine_suspended) {
                                            str11 = str7;
                                            return DeviceKey.copy$default(deviceKey2, null, null, null, str11, null, null, 55, null);
                                        }
                                    }
                                }
                            }
                            return coroutine_suspended;
                        case 2:
                            mutex = (Mutex) c04681.L$7;
                            deviceKeyManager4 = (DeviceKeyManager) c04681.L$6;
                            deviceKey = (DeviceKey) c04681.L$5;
                            deviceKeyRegistrar = (DeviceKeyRegistrar) c04681.L$4;
                            str4 = (String) c04681.L$3;
                            str3 = (String) c04681.L$2;
                            deviceKeySlot2 = (DeviceKeySlot) c04681.L$1;
                            deviceKeyManager = (DeviceKeyManager) c04681.L$0;
                            ResultKt.throwOnFailure(objRegister);
                            mutex2 = mutex;
                            DeviceKeyMetadataStore deviceKeyMetadataStore3 = deviceKeyManager4.store;
                            c04681.L$0 = deviceKeyManager;
                            c04681.L$1 = deviceKeySlot2;
                            c04681.L$2 = str3;
                            c04681.L$3 = str4;
                            c04681.L$4 = deviceKeyRegistrar;
                            c04681.L$5 = deviceKey;
                            c04681.L$6 = mutex2;
                            c04681.L$7 = null;
                            c04681.label = 3;
                            obj = deviceKeyMetadataStore3.read(c04681);
                            if (obj != coroutine_suspended) {
                                mutex3 = mutex2;
                                objRegister = obj;
                                DeviceKeyRecord deviceKeyRecord7 = (DeviceKeyRecord) objRegister;
                                mutex3.unlock(null);
                                objM5243constructorimpl = Result.m5243constructorimpl(deviceKeyRecord7);
                                if (Result.m5248isFailureimpl(objM5243constructorimpl)) {
                                    objM5243constructorimpl = null;
                                }
                                deviceKeyRecord = (DeviceKeyRecord) objM5243constructorimpl;
                                if (deviceKeyRecord != null) {
                                    pendingRevocationKid = deviceKeyRecord.getPendingRevocationKid();
                                } else {
                                    pendingRevocationKid = null;
                                }
                                if (deviceKeyRecord != null) {
                                    pendingRevocationSubject = deviceKeyRecord.getPendingRevocationSubject();
                                } else {
                                    pendingRevocationSubject = null;
                                }
                                deviceKeyRecord2 = new DeviceKeyRecord(null, pendingRevocationKid, pendingRevocationSubject, 1, null);
                                String publicJwk3 = deviceKey.getPublicJwk();
                                c04681.L$0 = deviceKeyManager;
                                c04681.L$1 = deviceKeySlot2;
                                c04681.L$2 = str3;
                                c04681.L$3 = str4;
                                c04681.L$4 = deviceKeyRegistrar;
                                c04681.L$5 = deviceKey;
                                c04681.L$6 = deviceKeyRecord2;
                                c04681.L$7 = null;
                                c04681.label = 4;
                                objRegister = deviceKeyRegistrar.register(publicJwk3, str3, str4, c04681);
                                if (objRegister != coroutine_suspended) {
                                    DeviceKeyRegistrar deviceKeyRegistrar8 = deviceKeyRegistrar;
                                    deviceKey2 = deviceKey;
                                    str5 = str4;
                                    deviceKeyRegistrar2 = deviceKeyRegistrar8;
                                    DeviceKeyManager deviceKeyManager7 = deviceKeyManager;
                                    str6 = str3;
                                    deviceKeySlot3 = deviceKeySlot2;
                                    deviceKeyManager2 = deviceKeyManager7;
                                    str7 = (String) objRegister;
                                    c04681.L$0 = deviceKeyManager2;
                                    c04681.L$1 = deviceKeySlot3;
                                    c04681.L$2 = str6;
                                    c04681.L$3 = str5;
                                    c04681.L$4 = deviceKeyRegistrar2;
                                    c04681.L$5 = deviceKey2;
                                    c04681.L$6 = deviceKeyRecord2;
                                    c04681.L$7 = str7;
                                    c04681.label = 6;
                                    if (deviceKeyManager2.setSubject(deviceKeySlot3, str7, c04681) != coroutine_suspended) {
                                        str11 = str7;
                                        return DeviceKey.copy$default(deviceKey2, null, null, null, str11, null, null, 55, null);
                                    }
                                }
                            }
                            return coroutine_suspended;
                        case 3:
                            mutex3 = (Mutex) c04681.L$6;
                            deviceKey = (DeviceKey) c04681.L$5;
                            deviceKeyRegistrar = (DeviceKeyRegistrar) c04681.L$4;
                            str4 = (String) c04681.L$3;
                            str3 = (String) c04681.L$2;
                            deviceKeySlot2 = (DeviceKeySlot) c04681.L$1;
                            deviceKeyManager = (DeviceKeyManager) c04681.L$0;
                            try {
                                ResultKt.throwOnFailure(objRegister);
                                DeviceKeyRecord deviceKeyRecord8 = (DeviceKeyRecord) objRegister;
                                mutex3.unlock(null);
                                objM5243constructorimpl = Result.m5243constructorimpl(deviceKeyRecord8);
                                if (Result.m5248isFailureimpl(objM5243constructorimpl)) {
                                    objM5243constructorimpl = null;
                                }
                                deviceKeyRecord = (DeviceKeyRecord) objM5243constructorimpl;
                                if (deviceKeyRecord != null) {
                                    pendingRevocationKid = deviceKeyRecord.getPendingRevocationKid();
                                } else {
                                    pendingRevocationKid = null;
                                }
                                if (deviceKeyRecord != null) {
                                    pendingRevocationSubject = deviceKeyRecord.getPendingRevocationSubject();
                                } else {
                                    pendingRevocationSubject = null;
                                }
                                deviceKeyRecord2 = new DeviceKeyRecord(null, pendingRevocationKid, pendingRevocationSubject, 1, null);
                                String publicJwk4 = deviceKey.getPublicJwk();
                                c04681.L$0 = deviceKeyManager;
                                c04681.L$1 = deviceKeySlot2;
                                c04681.L$2 = str3;
                                c04681.L$3 = str4;
                                c04681.L$4 = deviceKeyRegistrar;
                                c04681.L$5 = deviceKey;
                                c04681.L$6 = deviceKeyRecord2;
                                c04681.L$7 = null;
                                c04681.label = 4;
                                objRegister = deviceKeyRegistrar.register(publicJwk4, str3, str4, c04681);
                                if (objRegister != coroutine_suspended) {
                                    DeviceKeyRegistrar deviceKeyRegistrar9 = deviceKeyRegistrar;
                                    deviceKey2 = deviceKey;
                                    str5 = str4;
                                    deviceKeyRegistrar2 = deviceKeyRegistrar9;
                                    DeviceKeyManager deviceKeyManager8 = deviceKeyManager;
                                    str6 = str3;
                                    deviceKeySlot3 = deviceKeySlot2;
                                    deviceKeyManager2 = deviceKeyManager8;
                                    str7 = (String) objRegister;
                                    c04681.L$0 = deviceKeyManager2;
                                    c04681.L$1 = deviceKeySlot3;
                                    c04681.L$2 = str6;
                                    c04681.L$3 = str5;
                                    c04681.L$4 = deviceKeyRegistrar2;
                                    c04681.L$5 = deviceKey2;
                                    c04681.L$6 = deviceKeyRecord2;
                                    c04681.L$7 = str7;
                                    c04681.label = 6;
                                    if (deviceKeyManager2.setSubject(deviceKeySlot3, str7, c04681) != coroutine_suspended) {
                                        str11 = str7;
                                        return DeviceKey.copy$default(deviceKey2, null, null, null, str11, null, null, 55, null);
                                    }
                                }
                                return coroutine_suspended;
                            } catch (Throwable th4) {
                                th = th4;
                                mutex3.unlock(null);
                                throw th;
                            }
                        case 4:
                            deviceKeyRecord2 = (DeviceKeyRecord) c04681.L$6;
                            DeviceKey deviceKey6 = (DeviceKey) c04681.L$5;
                            DeviceKeyRegistrar deviceKeyRegistrar10 = (DeviceKeyRegistrar) c04681.L$4;
                            String str16 = (String) c04681.L$3;
                            String str17 = (String) c04681.L$2;
                            deviceKeySlot3 = (DeviceKeySlot) c04681.L$1;
                            deviceKeyManager2 = (DeviceKeyManager) c04681.L$0;
                            try {
                                ResultKt.throwOnFailure(objRegister);
                                str6 = str17;
                                deviceKeyRegistrar2 = deviceKeyRegistrar10;
                                str5 = str16;
                                deviceKey2 = deviceKey6;
                                str7 = (String) objRegister;
                                c04681.L$0 = deviceKeyManager2;
                                c04681.L$1 = deviceKeySlot3;
                                c04681.L$2 = str6;
                                c04681.L$3 = str5;
                                c04681.L$4 = deviceKeyRegistrar2;
                                c04681.L$5 = deviceKey2;
                                c04681.L$6 = deviceKeyRecord2;
                                c04681.L$7 = str7;
                                c04681.label = 6;
                                if (deviceKeyManager2.setSubject(deviceKeySlot3, str7, c04681) != coroutine_suspended) {
                                    str11 = str7;
                                    return DeviceKey.copy$default(deviceKey2, null, null, null, str11, null, null, 55, null);
                                }
                            } catch (Exception e3) {
                                e = e3;
                                c04681.L$0 = e;
                                c04681.L$1 = null;
                                c04681.L$2 = null;
                                c04681.L$3 = null;
                                c04681.L$4 = null;
                                c04681.L$5 = null;
                                c04681.L$6 = null;
                                c04681.L$7 = null;
                                c04681.label = 5;
                                if (deviceKeyManager2.retireLocally(deviceKeySlot3, deviceKeyRecord2, c04681) == coroutine_suspended) {
                                    throw e;
                                }
                            }
                            return coroutine_suspended;
                        case 5:
                            Exception exc3 = (Exception) c04681.L$0;
                            ResultKt.throwOnFailure(objRegister);
                            throw exc3;
                        case 6:
                            String str18 = (String) c04681.L$7;
                            DeviceKeyRecord deviceKeyRecord9 = (DeviceKeyRecord) c04681.L$6;
                            deviceKey2 = (DeviceKey) c04681.L$5;
                            deviceKeyRegistrar2 = (DeviceKeyRegistrar) c04681.L$4;
                            str9 = (String) c04681.L$3;
                            String str19 = (String) c04681.L$2;
                            deviceKeySlot4 = (DeviceKeySlot) c04681.L$1;
                            DeviceKeyManager deviceKeyManager9 = (DeviceKeyManager) c04681.L$0;
                            try {
                                ResultKt.throwOnFailure(objRegister);
                                str11 = str18;
                                return DeviceKey.copy$default(deviceKey2, null, null, null, str11, null, null, 55, null);
                            } catch (Exception e4) {
                                deviceKey3 = deviceKey2;
                                deviceKeyRecord3 = deviceKeyRecord9;
                                str10 = str18;
                                exc = e4;
                                str8 = str19;
                                deviceKeyManager2 = deviceKeyManager9;
                                Result.Companion companion6 = Result.Companion;
                                String kid2 = deviceKey3.getKid();
                                c04681.L$0 = deviceKeyManager2;
                                c04681.L$1 = deviceKeySlot4;
                                c04681.L$2 = deviceKey3;
                                c04681.L$3 = deviceKeyRecord3;
                                c04681.L$4 = str10;
                                c04681.L$5 = exc;
                                c04681.L$6 = null;
                                c04681.L$7 = null;
                                c04681.label = 7;
                                objRevoke = deviceKeyRegistrar2.revoke(kid2, str8, str9, c04681);
                                if (objRevoke != coroutine_suspended) {
                                    deviceKey4 = deviceKey3;
                                    deviceKeySlot5 = deviceKeySlot4;
                                    objRegister = objRevoke;
                                    objM5243constructorimpl2 = Result.m5243constructorimpl(Boxing.boxBoolean(((Boolean) objRegister).booleanValue()));
                                    boolBoxBoolean = Boxing.boxBoolean(false);
                                    if (Result.m5248isFailureimpl(objM5243constructorimpl2)) {
                                        objM5243constructorimpl2 = boolBoxBoolean;
                                    }
                                    if (!((Boolean) objM5243constructorimpl2).booleanValue()) {
                                        deviceKeyRecord3 = new DeviceKeyRecord(null, deviceKey4.getKid(), str10, 1, null);
                                    }
                                    c04681.L$0 = exc;
                                    c04681.L$1 = null;
                                    c04681.L$2 = null;
                                    c04681.L$3 = null;
                                    c04681.L$4 = null;
                                    c04681.L$5 = null;
                                    c04681.L$6 = null;
                                    c04681.L$7 = null;
                                    c04681.label = 8;
                                    if (deviceKeyManager2.retireLocally(deviceKeySlot5, deviceKeyRecord3, c04681) != coroutine_suspended) {
                                        exc2 = exc;
                                        throw new AuthError(AppAuthErrorCode.DEVICE_KEY_REGISTRATION_FAILED, "The device key was registered but its record could not be written", exc2);
                                    }
                                }
                                return coroutine_suspended;
                            }
                        case 7:
                            exc = (Exception) c04681.L$5;
                            str10 = (String) c04681.L$4;
                            deviceKeyRecord3 = (DeviceKeyRecord) c04681.L$3;
                            deviceKey4 = (DeviceKey) c04681.L$2;
                            deviceKeySlot5 = (DeviceKeySlot) c04681.L$1;
                            deviceKeyManager2 = (DeviceKeyManager) c04681.L$0;
                            try {
                                ResultKt.throwOnFailure(objRegister);
                                objM5243constructorimpl2 = Result.m5243constructorimpl(Boxing.boxBoolean(((Boolean) objRegister).booleanValue()));
                                break;
                            } catch (Throwable th5) {
                                th = th5;
                                Result.Companion companion7 = Result.Companion;
                                objM5243constructorimpl2 = Result.m5243constructorimpl(ResultKt.createFailure(th));
                            }
                            boolBoxBoolean = Boxing.boxBoolean(false);
                            if (Result.m5248isFailureimpl(objM5243constructorimpl2)) {
                                objM5243constructorimpl2 = boolBoxBoolean;
                            }
                            if (!((Boolean) objM5243constructorimpl2).booleanValue()) {
                                deviceKeyRecord3 = new DeviceKeyRecord(null, deviceKey4.getKid(), str10, 1, null);
                            }
                            c04681.L$0 = exc;
                            c04681.L$1 = null;
                            c04681.L$2 = null;
                            c04681.L$3 = null;
                            c04681.L$4 = null;
                            c04681.L$5 = null;
                            c04681.L$6 = null;
                            c04681.L$7 = null;
                            c04681.label = 8;
                            if (deviceKeyManager2.retireLocally(deviceKeySlot5, deviceKeyRecord3, c04681) != coroutine_suspended) {
                                exc2 = exc;
                                throw new AuthError(AppAuthErrorCode.DEVICE_KEY_REGISTRATION_FAILED, "The device key was registered but its record could not be written", exc2);
                            }
                            return coroutine_suspended;
                        case 8:
                            exc2 = (Exception) c04681.L$0;
                            ResultKt.throwOnFailure(objRegister);
                            throw new AuthError(AppAuthErrorCode.DEVICE_KEY_REGISTRATION_FAILED, "The device key was registered but its record could not be written", exc2);
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (CancellationException e5) {
                throw e5;
            }
        } catch (CancellationException e6) {
            throw e6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ab, code lost:
    
        if (r10.write(r2, r0) == r1) goto L39;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.doctolib.apps.authentication.model.DeviceKeySlot, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v11, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r9v6, types: [com.doctolib.apps.authentication.model.DeviceKeySlot] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object retireLocally(com.doctolib.apps.authentication.model.DeviceKeySlot r9, com.doctolib.apps.authentication.internal.devicekey.DeviceKeyRecord r10, kotlin.coroutines.Continuation r11) {
        /*
            Method dump skipped, instruction units count: 203
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager.retireLocally(com.doctolib.apps.authentication.model.DeviceKeySlot, com.doctolib.apps.authentication.internal.devicekey.DeviceKeyRecord, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:56:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:61:0x010a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code duplicated, block: B:85:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0113, code lost:
    
        if (r11.wipeSlots(r0) == r1) goto L70;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v13, types: [com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager] */
    /* JADX WARN: Type inference failed for: r11v36 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3, types: [com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object forgetDevice(java.lang.String r11, java.lang.String r12, kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager.forgetDevice(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:48:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e9, code lost:
    
        if (r4.revokeKids((com.doctolib.apps.authentication.internal.devicekey.DeviceKeyRecord) r9, r2, r10, r0) == r1) goto L51;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object revokeKnownKids(java.lang.String r9, java.lang.String r10, kotlin.coroutines.Continuation r11) {
        /*
            Method dump skipped, instruction units count: 239
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager.revokeKnownKids(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0094  */
    /* JADX WARN: Code duplicated, block: B:46:0x009a  */
    /* JADX WARN: Code duplicated, block: B:48:0x009f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object hasKnownKids(Continuation continuation) {
        C04721 c04721;
        Object objM5243constructorimpl;
        DeviceKeyRecord deviceKeyRecord;
        Mutex mutex;
        DeviceKeyManager deviceKeyManager;
        Mutex mutex2;
        Throwable th;
        if (continuation instanceof C04721) {
            c04721 = (C04721) continuation;
            int i = c04721.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                c04721.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                c04721 = new C04721(continuation);
            }
        } else {
            c04721 = new C04721(continuation);
        }
        Object obj = c04721.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c04721.label;
        boolean z = true;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    Result.Companion companion = Result.Companion;
                    mutex = this.mutex;
                    c04721.L$0 = this;
                    c04721.L$1 = mutex;
                    c04721.label = 1;
                    if (mutex.lock(null, c04721) != coroutine_suspended) {
                        deviceKeyManager = this;
                    }
                    return coroutine_suspended;
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mutex2 = (Mutex) c04721.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        DeviceKeyRecord deviceKeyRecord2 = (DeviceKeyRecord) obj;
                        mutex2.unlock(null);
                        objM5243constructorimpl = Result.m5243constructorimpl(deviceKeyRecord2);
                        deviceKeyRecord = (DeviceKeyRecord) (Result.m5248isFailureimpl(objM5243constructorimpl) ? null : objM5243constructorimpl);
                        if (deviceKeyRecord == null) {
                            return Boxing.boxBoolean(false);
                        }
                        if (deviceKeyRecord.getKey() == null && deviceKeyRecord.getPendingRevocationKid() == null) {
                            z = false;
                        }
                        return Boxing.boxBoolean(z);
                    } catch (Throwable th2) {
                        th = th2;
                        mutex2.unlock(null);
                        throw th;
                    }
                }
                Mutex mutex3 = (Mutex) c04721.L$1;
                deviceKeyManager = (DeviceKeyManager) c04721.L$0;
                ResultKt.throwOnFailure(obj);
                mutex = mutex3;
                DeviceKeyMetadataStore deviceKeyMetadataStore = deviceKeyManager.store;
                c04721.L$0 = mutex;
                c04721.L$1 = null;
                c04721.label = 2;
                Object obj2 = deviceKeyMetadataStore.read(c04721);
                if (obj2 != coroutine_suspended) {
                    mutex2 = mutex;
                    obj = obj2;
                    DeviceKeyRecord deviceKeyRecord3 = (DeviceKeyRecord) obj;
                    mutex2.unlock(null);
                    objM5243constructorimpl = Result.m5243constructorimpl(deviceKeyRecord3);
                    deviceKeyRecord = (DeviceKeyRecord) (Result.m5248isFailureimpl(objM5243constructorimpl) ? null : objM5243constructorimpl);
                    if (deviceKeyRecord == null) {
                        return Boxing.boxBoolean(false);
                    }
                    if (deviceKeyRecord.getKey() == null) {
                        z = false;
                    }
                    return Boxing.boxBoolean(z);
                }
                return coroutine_suspended;
            } catch (Throwable th3) {
                mutex2 = mutex;
                th = th3;
                mutex2.unlock(null);
                throw th;
            }
        } catch (Throwable th4) {
            Result.Companion companion2 = Result.Companion;
            objM5243constructorimpl = Result.m5243constructorimpl(ResultKt.createFailure(th4));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:36:0x0087  */
    /* JADX WARN: Code duplicated, block: B:39:0x00a1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:40:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00a2 -> B:41:0x00a6). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object revokeKids(com.doctolib.apps.authentication.internal.devicekey.DeviceKeyRecord r8, java.lang.String r9, java.lang.String r10, kotlin.coroutines.Continuation r11) {
        /*
            Method dump skipped, instruction units count: 203
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager.revokeKids(com.doctolib.apps.authentication.internal.devicekey.DeviceKeyRecord, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:102:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:114:0x02d8  */
    /* JADX WARN: Code duplicated, block: B:118:0x0308  */
    /* JADX WARN: Code duplicated, block: B:121:0x032e  */
    /* JADX WARN: Code duplicated, block: B:125:0x0337 A[Catch: all -> 0x00a2, Exception -> 0x00a6, CancellationException -> 0x00aa, TryCatch #14 {CancellationException -> 0x00aa, Exception -> 0x00a6, all -> 0x00a2, blocks: (B:123:0x0332, B:125:0x0337, B:128:0x033f, B:130:0x0345, B:133:0x0351, B:135:0x0357, B:137:0x035d, B:140:0x036d, B:141:0x0385, B:142:0x0386, B:143:0x0389, B:24:0x009d), top: B:179:0x009d }] */
    /* JADX WARN: Code duplicated, block: B:126:0x033c  */
    /* JADX WARN: Code duplicated, block: B:128:0x033f A[Catch: all -> 0x00a2, Exception -> 0x00a6, CancellationException -> 0x00aa, TryCatch #14 {CancellationException -> 0x00aa, Exception -> 0x00a6, all -> 0x00a2, blocks: (B:123:0x0332, B:125:0x0337, B:128:0x033f, B:130:0x0345, B:133:0x0351, B:135:0x0357, B:137:0x035d, B:140:0x036d, B:141:0x0385, B:142:0x0386, B:143:0x0389, B:24:0x009d), top: B:179:0x009d }] */
    /* JADX WARN: Code duplicated, block: B:129:0x0344  */
    /* JADX WARN: Code duplicated, block: B:132:0x034f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:133:0x0351 A[Catch: all -> 0x00a2, Exception -> 0x00a6, CancellationException -> 0x00aa, TryCatch #14 {CancellationException -> 0x00aa, Exception -> 0x00a6, all -> 0x00a2, blocks: (B:123:0x0332, B:125:0x0337, B:128:0x033f, B:130:0x0345, B:133:0x0351, B:135:0x0357, B:137:0x035d, B:140:0x036d, B:141:0x0385, B:142:0x0386, B:143:0x0389, B:24:0x009d), top: B:179:0x009d }] */
    /* JADX WARN: Code duplicated, block: B:134:0x0356  */
    /* JADX WARN: Code duplicated, block: B:137:0x035d A[Catch: all -> 0x00a2, Exception -> 0x00a6, CancellationException -> 0x00aa, TRY_LEAVE, TryCatch #14 {CancellationException -> 0x00aa, Exception -> 0x00a6, all -> 0x00a2, blocks: (B:123:0x0332, B:125:0x0337, B:128:0x033f, B:130:0x0345, B:133:0x0351, B:135:0x0357, B:137:0x035d, B:140:0x036d, B:141:0x0385, B:142:0x0386, B:143:0x0389, B:24:0x009d), top: B:179:0x009d }] */
    /* JADX WARN: Code duplicated, block: B:151:0x03ad  */
    /* JADX WARN: Code duplicated, block: B:47:0x0132 A[PHI: r0 r2 r4 r5 r6 r7 r9 r10 r12
      0x0132: PHI (r0v18 int) = (r0v15 int), (r0v23 int) binds: [B:69:0x01ef, B:46:0x012f] A[DONT_GENERATE, DONT_INLINE]
      0x0132: PHI (r2v12 java.lang.Object) = (r2v11 java.lang.Object), (r2v1 java.lang.Object) binds: [B:69:0x01ef, B:46:0x012f] A[DONT_GENERATE, DONT_INLINE]
      0x0132: PHI (r4v14 ??) = (r4v51 ??), (r4v52 ??) binds: [B:69:0x01ef, B:46:0x012f] A[DONT_GENERATE, DONT_INLINE]
      0x0132: PHI (r5v14 ??) = (r5v37 ??), (r5v38 ??) binds: [B:69:0x01ef, B:46:0x012f] A[DONT_GENERATE, DONT_INLINE]
      0x0132: PHI (r6v12 java.lang.String) = (r6v9 java.lang.String), (r6v17 java.lang.String) binds: [B:69:0x01ef, B:46:0x012f] A[DONT_GENERATE, DONT_INLINE]
      0x0132: PHI (r7v8 java.lang.String) = (r7v5 java.lang.String), (r7v13 java.lang.String) binds: [B:69:0x01ef, B:46:0x012f] A[DONT_GENERATE, DONT_INLINE]
      0x0132: PHI (r9v9 androidx.fragment.app.FragmentActivity) = (r9v6 androidx.fragment.app.FragmentActivity), (r9v14 androidx.fragment.app.FragmentActivity) binds: [B:69:0x01ef, B:46:0x012f] A[DONT_GENERATE, DONT_INLINE]
      0x0132: PHI (r10v8 com.doctolib.apps.authentication.model.DeviceKeySlot) = 
      (r10v5 com.doctolib.apps.authentication.model.DeviceKeySlot)
      (r10v11 com.doctolib.apps.authentication.model.DeviceKeySlot)
     binds: [B:69:0x01ef, B:46:0x012f] A[DONT_GENERATE, DONT_INLINE]
      0x0132: PHI (r12v11 com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager) = 
      (r12v8 com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager)
      (r12v18 com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager)
     binds: [B:69:0x01ef, B:46:0x012f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:67:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:70:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:74:0x01fa A[Catch: all -> 0x015e, TryCatch #16 {all -> 0x015e, blocks: (B:72:0x01f5, B:74:0x01fa, B:77:0x0202, B:83:0x020e, B:87:0x0217, B:88:0x0245, B:91:0x024a, B:155:0x03b2, B:156:0x03e0, B:51:0x0159), top: B:176:0x0159 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:77:0x0202 A[Catch: all -> 0x015e, TRY_LEAVE, TryCatch #16 {all -> 0x015e, blocks: (B:72:0x01f5, B:74:0x01fa, B:77:0x0202, B:83:0x020e, B:87:0x0217, B:88:0x0245, B:91:0x024a, B:155:0x03b2, B:156:0x03e0, B:51:0x0159), top: B:176:0x0159 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x0207  */
    /* JADX WARN: Code duplicated, block: B:82:0x020c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:83:0x020e A[Catch: all -> 0x015e, TRY_ENTER, TryCatch #16 {all -> 0x015e, blocks: (B:72:0x01f5, B:74:0x01fa, B:77:0x0202, B:83:0x020e, B:87:0x0217, B:88:0x0245, B:91:0x024a, B:155:0x03b2, B:156:0x03e0, B:51:0x0159), top: B:176:0x0159 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x0213  */
    /* JADX WARN: Code duplicated, block: B:86:0x0216  */
    /* JADX WARN: Code duplicated, block: B:87:0x0217 A[Catch: all -> 0x015e, TryCatch #16 {all -> 0x015e, blocks: (B:72:0x01f5, B:74:0x01fa, B:77:0x0202, B:83:0x020e, B:87:0x0217, B:88:0x0245, B:91:0x024a, B:155:0x03b2, B:156:0x03e0, B:51:0x0159), top: B:176:0x0159 }] */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    /* JADX WARN: Code duplicated, block: B:90:0x0248 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:97:0x0284 A[Catch: all -> 0x02c2, CancellationException -> 0x02c9, Exception -> 0x02d3, TRY_LEAVE, TryCatch #0 {all -> 0x02c2, blocks: (B:148:0x0390, B:103:0x02bb, B:115:0x02e7, B:95:0x027a, B:97:0x0284, B:99:0x02a9), top: B:165:0x0029 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:87:0x0217, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x02c3: MOVE (r3 I:??[OBJECT, ARRAY]) = (r12 I:??[OBJECT, ARRAY]), block:B:105:0x02c3 */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v19, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v22 */
    /* JADX WARN: Type inference failed for: r12v23 */
    /* JADX WARN: Type inference failed for: r12v24 */
    /* JADX WARN: Type inference failed for: r12v25, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v27 */
    /* JADX WARN: Type inference failed for: r12v28 */
    /* JADX WARN: Type inference failed for: r12v32 */
    /* JADX WARN: Type inference failed for: r12v36 */
    /* JADX WARN: Type inference failed for: r12v37 */
    /* JADX WARN: Type inference failed for: r12v38 */
    /* JADX WARN: Type inference failed for: r12v39 */
    /* JADX WARN: Type inference failed for: r12v40 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v1, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r4v14, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r4v2, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r4v41, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r4v48 */
    /* JADX WARN: Type inference failed for: r4v49 */
    /* JADX WARN: Type inference failed for: r4v51 */
    /* JADX WARN: Type inference failed for: r4v52 */
    /* JADX WARN: Type inference failed for: r5v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v36 */
    /* JADX WARN: Type inference failed for: r5v37 */
    /* JADX WARN: Type inference failed for: r5v38 */
    /* JADX WARN: Type inference failed for: r6v37 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v27, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v30, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r9v33 */
    /* JADX WARN: Type inference failed for: r9v34 */
    /* JADX WARN: Type inference failed for: r9v35 */
    public final Object signAssertion(DeviceKeySlot deviceKeySlot, FragmentActivity fragmentActivity, String str, String str2, int i, Continuation continuation) {
        C04791 c04791;
        ?? r12;
        ?? r5;
        Object obj;
        DeviceKeyManager deviceKeyManager;
        DeviceKeySlot deviceKeySlot2;
        Mutex mutex;
        FragmentActivity fragmentActivity2;
        String str3;
        DeviceKeySlot deviceKeySlot3;
        String str4;
        DeviceKeyManager deviceKeyManager2;
        Mutex mutex2;
        DeviceKeySlot deviceKeySlot4;
        FragmentActivity fragmentActivity3;
        String str5;
        Mutex mutex3;
        Mutex mutex4;
        FragmentActivity fragmentActivity4;
        DeviceKeyRecord deviceKeyRecord;
        DeviceKey key;
        String subject;
        DeviceKey deviceKey;
        String str6;
        DeviceKeyManager deviceKeyManager3;
        ?? r13;
        String str7;
        DeviceKeySlot deviceKeySlot5;
        String str8;
        String pendingRevocationKid;
        FragmentActivity fragmentActivity5;
        DeviceKeySlot deviceKeySlot6;
        DeviceKeyManager deviceKeyManager4;
        Signature signature;
        String str9;
        Signature signature2;
        DeviceKey deviceKey2;
        String str10;
        Object objAuthenticate$default;
        String str11;
        DeviceKey deviceKey3;
        String str12;
        String str13;
        Mutex mutex5;
        ?? r9;
        String str14;
        String str15;
        Mutex mutex6;
        DeviceKey deviceKey4;
        String str16;
        Signature signature3;
        ?? r10;
        int i2;
        Signature signature4;
        String str17;
        String str18;
        DeviceKeyRecord deviceKeyRecord2;
        DeviceKey key2;
        String kid;
        String subject2;
        ?? r6;
        int i3 = i;
        if (continuation instanceof C04791) {
            c04791 = (C04791) continuation;
            int i4 = c04791.label;
            r5 = -2147483648;
            r6 = i4 & LinearLayoutManager.INVALID_OFFSET;
            if (r6 != 0) {
                c04791.label = i4 - LinearLayoutManager.INVALID_OFFSET;
            } else {
                c04791 = new C04791(continuation);
            }
        } else {
            c04791 = new C04791(continuation);
        }
        C04791 c04792 = c04791;
        Object objSignFailure = c04792.result;
        ?? coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r4 = c04792.label;
        try {
            try {
                try {
                    try {
                        try {
                            switch (r4) {
                                case 0:
                                    ResultKt.throwOnFailure(objSignFailure);
                                    if (1 > i3 || i3 >= 121) {
                                        throw new AuthError(AppAuthErrorCode.INVALID_CONFIGURATION, "The assertion lifetime must be between 1 and 120 seconds, got " + i3, null, 4, null);
                                    }
                                    mutex = this.signMutex;
                                    c04792.L$0 = this;
                                    c04792.L$1 = deviceKeySlot;
                                    fragmentActivity2 = fragmentActivity;
                                    c04792.L$2 = fragmentActivity2;
                                    str3 = str;
                                    c04792.L$3 = str3;
                                    c04792.L$4 = str2;
                                    c04792.L$5 = mutex;
                                    c04792.I$0 = i3;
                                    c04792.label = 1;
                                    if (mutex.lock(null, c04792) != coroutine_suspended) {
                                        deviceKeySlot3 = deviceKeySlot;
                                        str4 = str2;
                                        deviceKeyManager2 = this;
                                        try {
                                            mutex2 = deviceKeyManager2.mutex;
                                            c04792.L$0 = deviceKeyManager2;
                                            c04792.L$1 = deviceKeySlot3;
                                            c04792.L$2 = fragmentActivity2;
                                            c04792.L$3 = str3;
                                            c04792.L$4 = str4;
                                            c04792.L$5 = mutex;
                                            c04792.L$6 = mutex2;
                                            c04792.I$0 = i3;
                                            c04792.label = 2;
                                            if (mutex2.lock(null, c04792) != coroutine_suspended) {
                                                deviceKeySlot4 = deviceKeySlot3;
                                                fragmentActivity3 = fragmentActivity2;
                                                str5 = str4;
                                                mutex3 = mutex;
                                                mutex4 = mutex2;
                                                DeviceKeyMetadataStore deviceKeyMetadataStore = deviceKeyManager2.store;
                                                c04792.L$0 = deviceKeyManager2;
                                                c04792.L$1 = deviceKeySlot4;
                                                c04792.L$2 = fragmentActivity3;
                                                c04792.L$3 = str3;
                                                c04792.L$4 = str5;
                                                c04792.L$5 = mutex3;
                                                c04792.L$6 = mutex4;
                                                c04792.I$0 = i3;
                                                c04792.label = 3;
                                                objSignFailure = deviceKeyMetadataStore.read(c04792);
                                                r4 = mutex4;
                                                r5 = mutex3;
                                                if (objSignFailure != coroutine_suspended) {
                                                    deviceKeySlot2 = deviceKeySlot4;
                                                    deviceKeyManager = deviceKeyManager2;
                                                    fragmentActivity4 = fragmentActivity3;
                                                    deviceKeyRecord = (DeviceKeyRecord) objSignFailure;
                                                    r4.unlock(null);
                                                    if (deviceKeyRecord != null) {
                                                        key = deviceKeyRecord.getKey();
                                                    } else {
                                                        key = null;
                                                    }
                                                    if (key != null) {
                                                        subject = key.getSubject();
                                                    } else {
                                                        subject = null;
                                                    }
                                                    if (key == null) {
                                                        if (deviceKeyRecord != null) {
                                                            pendingRevocationKid = deviceKeyRecord.getPendingRevocationKid();
                                                        } else {
                                                            pendingRevocationKid = null;
                                                        }
                                                        if (pendingRevocationKid == null) {
                                                            throw new AuthError(AppAuthErrorCode.DEVICE_KEY_INVALIDATED, "The " + deviceKeySlot2.getStringValue() + " slot's key is gone and its `kid` is still owed a revoke", null, 4, null);
                                                        }
                                                    }
                                                    if (key != null || subject == null) {
                                                        throw new AuthError(AppAuthErrorCode.DEVICE_KEY_NOT_ENROLLED, "The " + deviceKeySlot2.getStringValue() + " slot holds no registered key", null, 4, null);
                                                    }
                                                    try {
                                                        CoroutineDispatcher io2 = Dispatchers.getIO();
                                                        DeviceKeyManager$signAssertion$2$signature$1 deviceKeyManager$signAssertion$2$signature$1 = new DeviceKeyManager$signAssertion$2$signature$1(deviceKeyManager, deviceKeySlot2, null);
                                                        c04792.L$0 = deviceKeyManager;
                                                        c04792.L$1 = deviceKeySlot2;
                                                        c04792.L$2 = fragmentActivity4;
                                                        c04792.L$3 = str3;
                                                        c04792.L$4 = str5;
                                                        c04792.L$5 = r5;
                                                        c04792.L$6 = key;
                                                        c04792.L$7 = subject;
                                                        c04792.I$0 = i3;
                                                        c04792.label = 4;
                                                        objSignFailure = BuildersKt.withContext(io2, deviceKeyManager$signAssertion$2$signature$1, c04792);
                                                        if (objSignFailure != coroutine_suspended) {
                                                            deviceKey = key;
                                                            str6 = str3;
                                                            deviceKeyManager3 = deviceKeyManager;
                                                            r13 = r5;
                                                            str7 = str5;
                                                            deviceKeySlot5 = deviceKeySlot2;
                                                            str8 = subject;
                                                            fragmentActivity5 = fragmentActivity4;
                                                            try {
                                                                try {
                                                                    signature = (Signature) objSignFailure;
                                                                    if (deviceKey.getUserAuthentication() == DeviceKeyUserAuthentication.USER_PRESENCE) {
                                                                        DeviceKeyPrompt deviceKeyPrompt = deviceKeyManager3.prompt;
                                                                        c04792.L$0 = deviceKeyManager3;
                                                                        c04792.L$1 = deviceKeySlot5;
                                                                        c04792.L$2 = str6;
                                                                        c04792.L$3 = str7;
                                                                        c04792.L$4 = r13;
                                                                        c04792.L$5 = deviceKey;
                                                                        c04792.L$6 = str8;
                                                                        c04792.L$7 = null;
                                                                        c04792.I$0 = i3;
                                                                        c04792.label = 5;
                                                                        str10 = str6;
                                                                        deviceKeyManager4 = deviceKeyManager3;
                                                                        deviceKeySlot6 = deviceKeySlot5;
                                                                        try {
                                                                            objAuthenticate$default = DeviceKeyPrompt.authenticate$default(deviceKeyPrompt, fragmentActivity5, signature, null, c04792, 4, null);
                                                                            if (objAuthenticate$default != coroutine_suspended) {
                                                                                String str19 = str8;
                                                                                deviceKeySlot2 = deviceKeySlot6;
                                                                                objSignFailure = objAuthenticate$default;
                                                                                str11 = str19;
                                                                                deviceKey3 = deviceKey;
                                                                                str12 = str7;
                                                                                str13 = str10;
                                                                                deviceKeyManager = deviceKeyManager4;
                                                                                r13 = r13;
                                                                                try {
                                                                                    signature2 = (Signature) objSignFailure;
                                                                                    deviceKey2 = deviceKey3;
                                                                                    str7 = str12;
                                                                                    str9 = str11;
                                                                                    str6 = str13;
                                                                                    r13 = r13;
                                                                                    mutex5 = deviceKeyManager.mutex;
                                                                                    c04792.L$0 = deviceKeyManager;
                                                                                    c04792.L$1 = deviceKeySlot2;
                                                                                    c04792.L$2 = str6;
                                                                                    c04792.L$3 = str7;
                                                                                    c04792.L$4 = r13;
                                                                                    c04792.L$5 = deviceKey2;
                                                                                    c04792.L$6 = str9;
                                                                                    c04792.L$7 = signature2;
                                                                                    c04792.L$8 = mutex5;
                                                                                    c04792.I$0 = i3;
                                                                                    c04792.label = 6;
                                                                                    if (mutex5.lock(null, c04792) != coroutine_suspended) {
                                                                                        r9 = r13;
                                                                                        str14 = str7;
                                                                                        str15 = str6;
                                                                                        mutex6 = mutex5;
                                                                                        deviceKey4 = deviceKey2;
                                                                                        str16 = str9;
                                                                                        signature3 = signature2;
                                                                                        DeviceKeyMetadataStore deviceKeyMetadataStore2 = deviceKeyManager.store;
                                                                                        c04792.L$0 = deviceKeyManager;
                                                                                        c04792.L$1 = deviceKeySlot2;
                                                                                        c04792.L$2 = str15;
                                                                                        c04792.L$3 = str14;
                                                                                        c04792.L$4 = r9;
                                                                                        c04792.L$5 = deviceKey4;
                                                                                        c04792.L$6 = str16;
                                                                                        c04792.L$7 = signature3;
                                                                                        c04792.L$8 = mutex6;
                                                                                        c04792.I$0 = i3;
                                                                                        c04792.label = 7;
                                                                                        objSignFailure = deviceKeyMetadataStore2.read(c04792);
                                                                                        r4 = mutex6;
                                                                                        r10 = r9;
                                                                                        if (objSignFailure == coroutine_suspended) {
                                                                                        }
                                                                                        i2 = i3;
                                                                                        signature4 = signature3;
                                                                                        str17 = str14;
                                                                                        str18 = str15;
                                                                                        deviceKeyRecord2 = (DeviceKeyRecord) objSignFailure;
                                                                                        r4.unlock(null);
                                                                                        if (deviceKeyRecord2 != null) {
                                                                                            key2 = deviceKeyRecord2.getKey();
                                                                                        } else {
                                                                                            key2 = null;
                                                                                        }
                                                                                        if (key2 != null) {
                                                                                            kid = key2.getKid();
                                                                                        } else {
                                                                                            kid = null;
                                                                                        }
                                                                                        if (Intrinsics.areEqual(kid, deviceKey4.getKid())) {
                                                                                            if (key2 != null) {
                                                                                                subject2 = key2.getSubject();
                                                                                            } else {
                                                                                                subject2 = null;
                                                                                            }
                                                                                            if (Intrinsics.areEqual(subject2, str16)) {
                                                                                                String strJwsCompact = DeviceKeyCrypto.INSTANCE.jwsCompact(signature4, deviceKey4.getKid(), str18, str16, str17, i2);
                                                                                                r10.unlock(null);
                                                                                                return strJwsCompact;
                                                                                            }
                                                                                        }
                                                                                        throw new AuthError(AppAuthErrorCode.DEVICE_KEY_INVALIDATED, "The device key changed while its signature was being authorised", null, 4, null);
                                                                                    }
                                                                                } catch (Exception e) {
                                                                                    e = e;
                                                                                    r12 = r13;
                                                                                    c04792.L$0 = r12;
                                                                                    c04792.L$1 = null;
                                                                                    c04792.L$2 = null;
                                                                                    c04792.L$3 = null;
                                                                                    c04792.L$4 = null;
                                                                                    c04792.L$5 = null;
                                                                                    c04792.L$6 = null;
                                                                                    c04792.L$7 = null;
                                                                                    c04792.L$8 = null;
                                                                                    c04792.label = 8;
                                                                                    objSignFailure = deviceKeyManager.signFailure(deviceKeySlot2, e, c04792);
                                                                                    if (objSignFailure != coroutine_suspended) {
                                                                                        throw ((Throwable) objSignFailure);
                                                                                    }
                                                                                }
                                                                            }
                                                                        } catch (Exception e2) {
                                                                            e = e2;
                                                                            deviceKeySlot2 = deviceKeySlot6;
                                                                            deviceKeyManager = deviceKeyManager4;
                                                                            r12 = r13;
                                                                            c04792.L$0 = r12;
                                                                            c04792.L$1 = null;
                                                                            c04792.L$2 = null;
                                                                            c04792.L$3 = null;
                                                                            c04792.L$4 = null;
                                                                            c04792.L$5 = null;
                                                                            c04792.L$6 = null;
                                                                            c04792.L$7 = null;
                                                                            c04792.L$8 = null;
                                                                            c04792.label = 8;
                                                                            objSignFailure = deviceKeyManager.signFailure(deviceKeySlot2, e, c04792);
                                                                            if (objSignFailure != coroutine_suspended) {
                                                                                throw ((Throwable) objSignFailure);
                                                                            }
                                                                        }
                                                                    } else {
                                                                        str9 = str8;
                                                                        deviceKeySlot2 = deviceKeySlot5;
                                                                        signature2 = signature;
                                                                        deviceKey2 = deviceKey;
                                                                        deviceKeyManager = deviceKeyManager3;
                                                                        r13 = r13;
                                                                        mutex5 = deviceKeyManager.mutex;
                                                                        c04792.L$0 = deviceKeyManager;
                                                                        c04792.L$1 = deviceKeySlot2;
                                                                        c04792.L$2 = str6;
                                                                        c04792.L$3 = str7;
                                                                        c04792.L$4 = r13;
                                                                        c04792.L$5 = deviceKey2;
                                                                        c04792.L$6 = str9;
                                                                        c04792.L$7 = signature2;
                                                                        c04792.L$8 = mutex5;
                                                                        c04792.I$0 = i3;
                                                                        c04792.label = 6;
                                                                        if (mutex5.lock(null, c04792) != coroutine_suspended) {
                                                                            r9 = r13;
                                                                            str14 = str7;
                                                                            str15 = str6;
                                                                            mutex6 = mutex5;
                                                                            deviceKey4 = deviceKey2;
                                                                            str16 = str9;
                                                                            signature3 = signature2;
                                                                            DeviceKeyMetadataStore deviceKeyMetadataStore3 = deviceKeyManager.store;
                                                                            c04792.L$0 = deviceKeyManager;
                                                                            c04792.L$1 = deviceKeySlot2;
                                                                            c04792.L$2 = str15;
                                                                            c04792.L$3 = str14;
                                                                            c04792.L$4 = r9;
                                                                            c04792.L$5 = deviceKey4;
                                                                            c04792.L$6 = str16;
                                                                            c04792.L$7 = signature3;
                                                                            c04792.L$8 = mutex6;
                                                                            c04792.I$0 = i3;
                                                                            c04792.label = 7;
                                                                            objSignFailure = deviceKeyMetadataStore3.read(c04792);
                                                                            r4 = mutex6;
                                                                            r10 = r9;
                                                                            if (objSignFailure == coroutine_suspended) {
                                                                            }
                                                                            i2 = i3;
                                                                            signature4 = signature3;
                                                                            str17 = str14;
                                                                            str18 = str15;
                                                                            deviceKeyRecord2 = (DeviceKeyRecord) objSignFailure;
                                                                            r4.unlock(null);
                                                                            if (deviceKeyRecord2 != null) {
                                                                                key2 = deviceKeyRecord2.getKey();
                                                                            } else {
                                                                                key2 = null;
                                                                            }
                                                                            if (key2 != null) {
                                                                                kid = key2.getKid();
                                                                            } else {
                                                                                kid = null;
                                                                            }
                                                                            if (Intrinsics.areEqual(kid, deviceKey4.getKid())) {
                                                                                if (key2 != null) {
                                                                                    subject2 = key2.getSubject();
                                                                                } else {
                                                                                    subject2 = null;
                                                                                }
                                                                                if (Intrinsics.areEqual(subject2, str16)) {
                                                                                    String strJwsCompact2 = DeviceKeyCrypto.INSTANCE.jwsCompact(signature4, deviceKey4.getKid(), str18, str16, str17, i2);
                                                                                    r10.unlock(null);
                                                                                    return strJwsCompact2;
                                                                                }
                                                                            }
                                                                            throw new AuthError(AppAuthErrorCode.DEVICE_KEY_INVALIDATED, "The device key changed while its signature was being authorised", null, 4, null);
                                                                        }
                                                                    }
                                                                } catch (Exception e3) {
                                                                    e = e3;
                                                                    deviceKeySlot6 = deviceKeySlot5;
                                                                    deviceKeyManager4 = deviceKeyManager3;
                                                                }
                                                            } catch (CancellationException e4) {
                                                                throw e4;
                                                            }
                                                        }
                                                    } catch (CancellationException e5) {
                                                        throw e5;
                                                    } catch (Exception e6) {
                                                        e = e6;
                                                        r12 = r5;
                                                        c04792.L$0 = r12;
                                                        c04792.L$1 = null;
                                                        c04792.L$2 = null;
                                                        c04792.L$3 = null;
                                                        c04792.L$4 = null;
                                                        c04792.L$5 = null;
                                                        c04792.L$6 = null;
                                                        c04792.L$7 = null;
                                                        c04792.L$8 = null;
                                                        c04792.label = 8;
                                                        objSignFailure = deviceKeyManager.signFailure(deviceKeySlot2, e, c04792);
                                                        if (objSignFailure != coroutine_suspended) {
                                                            throw ((Throwable) objSignFailure);
                                                        }
                                                        return coroutine_suspended;
                                                    }
                                                }
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            coroutine_suspended = mutex;
                                            coroutine_suspended.unlock(null);
                                            throw th;
                                        }
                                    }
                                    return coroutine_suspended;
                                case 1:
                                    i3 = c04792.I$0;
                                    mutex = (Mutex) c04792.L$5;
                                    str4 = (String) c04792.L$4;
                                    String str20 = (String) c04792.L$3;
                                    FragmentActivity fragmentActivity6 = (FragmentActivity) c04792.L$2;
                                    deviceKeySlot3 = (DeviceKeySlot) c04792.L$1;
                                    DeviceKeyManager deviceKeyManager5 = (DeviceKeyManager) c04792.L$0;
                                    ResultKt.throwOnFailure(objSignFailure);
                                    str3 = str20;
                                    fragmentActivity2 = fragmentActivity6;
                                    deviceKeyManager2 = deviceKeyManager5;
                                    mutex2 = deviceKeyManager2.mutex;
                                    c04792.L$0 = deviceKeyManager2;
                                    c04792.L$1 = deviceKeySlot3;
                                    c04792.L$2 = fragmentActivity2;
                                    c04792.L$3 = str3;
                                    c04792.L$4 = str4;
                                    c04792.L$5 = mutex;
                                    c04792.L$6 = mutex2;
                                    c04792.I$0 = i3;
                                    c04792.label = 2;
                                    if (mutex2.lock(null, c04792) != coroutine_suspended) {
                                        deviceKeySlot4 = deviceKeySlot3;
                                        fragmentActivity3 = fragmentActivity2;
                                        str5 = str4;
                                        mutex3 = mutex;
                                        mutex4 = mutex2;
                                        DeviceKeyMetadataStore deviceKeyMetadataStore4 = deviceKeyManager2.store;
                                        c04792.L$0 = deviceKeyManager2;
                                        c04792.L$1 = deviceKeySlot4;
                                        c04792.L$2 = fragmentActivity3;
                                        c04792.L$3 = str3;
                                        c04792.L$4 = str5;
                                        c04792.L$5 = mutex3;
                                        c04792.L$6 = mutex4;
                                        c04792.I$0 = i3;
                                        c04792.label = 3;
                                        objSignFailure = deviceKeyMetadataStore4.read(c04792);
                                        r4 = mutex4;
                                        r5 = mutex3;
                                        if (objSignFailure != coroutine_suspended) {
                                            deviceKeySlot2 = deviceKeySlot4;
                                            deviceKeyManager = deviceKeyManager2;
                                            fragmentActivity4 = fragmentActivity3;
                                            deviceKeyRecord = (DeviceKeyRecord) objSignFailure;
                                            r4.unlock(null);
                                            if (deviceKeyRecord != null) {
                                                key = deviceKeyRecord.getKey();
                                            } else {
                                                key = null;
                                            }
                                            if (key != null) {
                                                subject = key.getSubject();
                                            } else {
                                                subject = null;
                                            }
                                            if (key == null) {
                                                if (deviceKeyRecord != null) {
                                                    pendingRevocationKid = deviceKeyRecord.getPendingRevocationKid();
                                                } else {
                                                    pendingRevocationKid = null;
                                                }
                                                if (pendingRevocationKid == null) {
                                                    throw new AuthError(AppAuthErrorCode.DEVICE_KEY_INVALIDATED, "The " + deviceKeySlot2.getStringValue() + " slot's key is gone and its `kid` is still owed a revoke", null, 4, null);
                                                }
                                            }
                                            if (key != null) {
                                            }
                                            throw new AuthError(AppAuthErrorCode.DEVICE_KEY_NOT_ENROLLED, "The " + deviceKeySlot2.getStringValue() + " slot holds no registered key", null, 4, null);
                                        }
                                    }
                                    return coroutine_suspended;
                                case 2:
                                    i3 = c04792.I$0;
                                    Mutex mutex7 = (Mutex) c04792.L$6;
                                    Mutex mutex8 = (Mutex) c04792.L$5;
                                    str5 = (String) c04792.L$4;
                                    str3 = (String) c04792.L$3;
                                    fragmentActivity3 = (FragmentActivity) c04792.L$2;
                                    deviceKeySlot4 = (DeviceKeySlot) c04792.L$1;
                                    deviceKeyManager2 = (DeviceKeyManager) c04792.L$0;
                                    try {
                                        ResultKt.throwOnFailure(objSignFailure);
                                        mutex4 = mutex7;
                                        mutex3 = mutex8;
                                        DeviceKeyMetadataStore deviceKeyMetadataStore5 = deviceKeyManager2.store;
                                        c04792.L$0 = deviceKeyManager2;
                                        c04792.L$1 = deviceKeySlot4;
                                        c04792.L$2 = fragmentActivity3;
                                        c04792.L$3 = str3;
                                        c04792.L$4 = str5;
                                        c04792.L$5 = mutex3;
                                        c04792.L$6 = mutex4;
                                        c04792.I$0 = i3;
                                        c04792.label = 3;
                                        objSignFailure = deviceKeyMetadataStore5.read(c04792);
                                        r4 = mutex4;
                                        r5 = mutex3;
                                        if (objSignFailure != coroutine_suspended) {
                                            deviceKeySlot2 = deviceKeySlot4;
                                            deviceKeyManager = deviceKeyManager2;
                                            fragmentActivity4 = fragmentActivity3;
                                            deviceKeyRecord = (DeviceKeyRecord) objSignFailure;
                                            r4.unlock(null);
                                            if (deviceKeyRecord != null) {
                                                key = deviceKeyRecord.getKey();
                                            } else {
                                                key = null;
                                            }
                                            if (key != null) {
                                                subject = key.getSubject();
                                            } else {
                                                subject = null;
                                            }
                                            if (key == null) {
                                                if (deviceKeyRecord != null) {
                                                    pendingRevocationKid = deviceKeyRecord.getPendingRevocationKid();
                                                } else {
                                                    pendingRevocationKid = null;
                                                }
                                                if (pendingRevocationKid == null) {
                                                    throw new AuthError(AppAuthErrorCode.DEVICE_KEY_INVALIDATED, "The " + deviceKeySlot2.getStringValue() + " slot's key is gone and its `kid` is still owed a revoke", null, 4, null);
                                                }
                                            }
                                            if (key != null) {
                                            }
                                            throw new AuthError(AppAuthErrorCode.DEVICE_KEY_NOT_ENROLLED, "The " + deviceKeySlot2.getStringValue() + " slot holds no registered key", null, 4, null);
                                        }
                                        return coroutine_suspended;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        coroutine_suspended = mutex8;
                                        coroutine_suspended.unlock(null);
                                        throw th;
                                    }
                                case 3:
                                    i3 = c04792.I$0;
                                    Mutex mutex9 = (Mutex) c04792.L$6;
                                    Mutex mutex10 = (Mutex) c04792.L$5;
                                    str5 = (String) c04792.L$4;
                                    str3 = (String) c04792.L$3;
                                    fragmentActivity3 = (FragmentActivity) c04792.L$2;
                                    deviceKeySlot4 = (DeviceKeySlot) c04792.L$1;
                                    deviceKeyManager2 = (DeviceKeyManager) c04792.L$0;
                                    ResultKt.throwOnFailure(objSignFailure);
                                    r4 = mutex9;
                                    r5 = mutex10;
                                    deviceKeySlot2 = deviceKeySlot4;
                                    deviceKeyManager = deviceKeyManager2;
                                    fragmentActivity4 = fragmentActivity3;
                                    deviceKeyRecord = (DeviceKeyRecord) objSignFailure;
                                    r4.unlock(null);
                                    if (deviceKeyRecord != null) {
                                        key = deviceKeyRecord.getKey();
                                    } else {
                                        key = null;
                                    }
                                    if (key != null) {
                                        subject = key.getSubject();
                                    } else {
                                        subject = null;
                                    }
                                    if (key == null) {
                                        if (deviceKeyRecord != null) {
                                            pendingRevocationKid = deviceKeyRecord.getPendingRevocationKid();
                                        } else {
                                            pendingRevocationKid = null;
                                        }
                                        if (pendingRevocationKid == null) {
                                            throw new AuthError(AppAuthErrorCode.DEVICE_KEY_INVALIDATED, "The " + deviceKeySlot2.getStringValue() + " slot's key is gone and its `kid` is still owed a revoke", null, 4, null);
                                        }
                                    }
                                    if (key != null) {
                                    }
                                    throw new AuthError(AppAuthErrorCode.DEVICE_KEY_NOT_ENROLLED, "The " + deviceKeySlot2.getStringValue() + " slot holds no registered key", null, 4, null);
                                case 4:
                                    i3 = c04792.I$0;
                                    String str21 = (String) c04792.L$7;
                                    DeviceKey deviceKey5 = (DeviceKey) c04792.L$6;
                                    Mutex mutex11 = (Mutex) c04792.L$5;
                                    String str22 = (String) c04792.L$4;
                                    String str23 = (String) c04792.L$3;
                                    fragmentActivity4 = (FragmentActivity) c04792.L$2;
                                    DeviceKeySlot deviceKeySlot7 = (DeviceKeySlot) c04792.L$1;
                                    DeviceKeyManager deviceKeyManager6 = (DeviceKeyManager) c04792.L$0;
                                    ResultKt.throwOnFailure(objSignFailure);
                                    r13 = mutex11;
                                    str7 = str22;
                                    deviceKeySlot5 = deviceKeySlot7;
                                    deviceKeyManager3 = deviceKeyManager6;
                                    str8 = str21;
                                    deviceKey = deviceKey5;
                                    str6 = str23;
                                    fragmentActivity5 = fragmentActivity4;
                                    signature = (Signature) objSignFailure;
                                    if (deviceKey.getUserAuthentication() == DeviceKeyUserAuthentication.USER_PRESENCE) {
                                        DeviceKeyPrompt deviceKeyPrompt2 = deviceKeyManager3.prompt;
                                        c04792.L$0 = deviceKeyManager3;
                                        c04792.L$1 = deviceKeySlot5;
                                        c04792.L$2 = str6;
                                        c04792.L$3 = str7;
                                        c04792.L$4 = r13;
                                        c04792.L$5 = deviceKey;
                                        c04792.L$6 = str8;
                                        c04792.L$7 = null;
                                        c04792.I$0 = i3;
                                        c04792.label = 5;
                                        str10 = str6;
                                        deviceKeyManager4 = deviceKeyManager3;
                                        deviceKeySlot6 = deviceKeySlot5;
                                        objAuthenticate$default = DeviceKeyPrompt.authenticate$default(deviceKeyPrompt2, fragmentActivity5, signature, null, c04792, 4, null);
                                        if (objAuthenticate$default != coroutine_suspended) {
                                            String str110 = str8;
                                            deviceKeySlot2 = deviceKeySlot6;
                                            objSignFailure = objAuthenticate$default;
                                            str11 = str110;
                                            deviceKey3 = deviceKey;
                                            str12 = str7;
                                            str13 = str10;
                                            deviceKeyManager = deviceKeyManager4;
                                            r13 = r13;
                                            signature2 = (Signature) objSignFailure;
                                            deviceKey2 = deviceKey3;
                                            str7 = str12;
                                            str9 = str11;
                                            str6 = str13;
                                            r13 = r13;
                                            mutex5 = deviceKeyManager.mutex;
                                            c04792.L$0 = deviceKeyManager;
                                            c04792.L$1 = deviceKeySlot2;
                                            c04792.L$2 = str6;
                                            c04792.L$3 = str7;
                                            c04792.L$4 = r13;
                                            c04792.L$5 = deviceKey2;
                                            c04792.L$6 = str9;
                                            c04792.L$7 = signature2;
                                            c04792.L$8 = mutex5;
                                            c04792.I$0 = i3;
                                            c04792.label = 6;
                                            if (mutex5.lock(null, c04792) != coroutine_suspended) {
                                                r9 = r13;
                                                str14 = str7;
                                                str15 = str6;
                                                mutex6 = mutex5;
                                                deviceKey4 = deviceKey2;
                                                str16 = str9;
                                                signature3 = signature2;
                                                DeviceKeyMetadataStore deviceKeyMetadataStore6 = deviceKeyManager.store;
                                                c04792.L$0 = deviceKeyManager;
                                                c04792.L$1 = deviceKeySlot2;
                                                c04792.L$2 = str15;
                                                c04792.L$3 = str14;
                                                c04792.L$4 = r9;
                                                c04792.L$5 = deviceKey4;
                                                c04792.L$6 = str16;
                                                c04792.L$7 = signature3;
                                                c04792.L$8 = mutex6;
                                                c04792.I$0 = i3;
                                                c04792.label = 7;
                                                objSignFailure = deviceKeyMetadataStore6.read(c04792);
                                                r4 = mutex6;
                                                r10 = r9;
                                                if (objSignFailure == coroutine_suspended) {
                                                }
                                                i2 = i3;
                                                signature4 = signature3;
                                                str17 = str14;
                                                str18 = str15;
                                                deviceKeyRecord2 = (DeviceKeyRecord) objSignFailure;
                                                r4.unlock(null);
                                                if (deviceKeyRecord2 != null) {
                                                    key2 = deviceKeyRecord2.getKey();
                                                } else {
                                                    key2 = null;
                                                }
                                                if (key2 != null) {
                                                    kid = key2.getKid();
                                                } else {
                                                    kid = null;
                                                }
                                                if (Intrinsics.areEqual(kid, deviceKey4.getKid())) {
                                                    if (key2 != null) {
                                                        subject2 = key2.getSubject();
                                                    } else {
                                                        subject2 = null;
                                                    }
                                                    if (Intrinsics.areEqual(subject2, str16)) {
                                                        String strJwsCompact3 = DeviceKeyCrypto.INSTANCE.jwsCompact(signature4, deviceKey4.getKid(), str18, str16, str17, i2);
                                                        r10.unlock(null);
                                                        return strJwsCompact3;
                                                    }
                                                }
                                                throw new AuthError(AppAuthErrorCode.DEVICE_KEY_INVALIDATED, "The device key changed while its signature was being authorised", null, 4, null);
                                            }
                                        }
                                    } else {
                                        str9 = str8;
                                        deviceKeySlot2 = deviceKeySlot5;
                                        signature2 = signature;
                                        deviceKey2 = deviceKey;
                                        deviceKeyManager = deviceKeyManager3;
                                        r13 = r13;
                                        mutex5 = deviceKeyManager.mutex;
                                        c04792.L$0 = deviceKeyManager;
                                        c04792.L$1 = deviceKeySlot2;
                                        c04792.L$2 = str6;
                                        c04792.L$3 = str7;
                                        c04792.L$4 = r13;
                                        c04792.L$5 = deviceKey2;
                                        c04792.L$6 = str9;
                                        c04792.L$7 = signature2;
                                        c04792.L$8 = mutex5;
                                        c04792.I$0 = i3;
                                        c04792.label = 6;
                                        if (mutex5.lock(null, c04792) != coroutine_suspended) {
                                            r9 = r13;
                                            str14 = str7;
                                            str15 = str6;
                                            mutex6 = mutex5;
                                            deviceKey4 = deviceKey2;
                                            str16 = str9;
                                            signature3 = signature2;
                                            DeviceKeyMetadataStore deviceKeyMetadataStore7 = deviceKeyManager.store;
                                            c04792.L$0 = deviceKeyManager;
                                            c04792.L$1 = deviceKeySlot2;
                                            c04792.L$2 = str15;
                                            c04792.L$3 = str14;
                                            c04792.L$4 = r9;
                                            c04792.L$5 = deviceKey4;
                                            c04792.L$6 = str16;
                                            c04792.L$7 = signature3;
                                            c04792.L$8 = mutex6;
                                            c04792.I$0 = i3;
                                            c04792.label = 7;
                                            objSignFailure = deviceKeyMetadataStore7.read(c04792);
                                            r4 = mutex6;
                                            r10 = r9;
                                            if (objSignFailure == coroutine_suspended) {
                                            }
                                            i2 = i3;
                                            signature4 = signature3;
                                            str17 = str14;
                                            str18 = str15;
                                            deviceKeyRecord2 = (DeviceKeyRecord) objSignFailure;
                                            r4.unlock(null);
                                            if (deviceKeyRecord2 != null) {
                                                key2 = deviceKeyRecord2.getKey();
                                            } else {
                                                key2 = null;
                                            }
                                            if (key2 != null) {
                                                kid = key2.getKid();
                                            } else {
                                                kid = null;
                                            }
                                            if (Intrinsics.areEqual(kid, deviceKey4.getKid())) {
                                                if (key2 != null) {
                                                    subject2 = key2.getSubject();
                                                } else {
                                                    subject2 = null;
                                                }
                                                if (Intrinsics.areEqual(subject2, str16)) {
                                                    String strJwsCompact4 = DeviceKeyCrypto.INSTANCE.jwsCompact(signature4, deviceKey4.getKid(), str18, str16, str17, i2);
                                                    r10.unlock(null);
                                                    return strJwsCompact4;
                                                }
                                            }
                                            throw new AuthError(AppAuthErrorCode.DEVICE_KEY_INVALIDATED, "The device key changed while its signature was being authorised", null, 4, null);
                                        }
                                    }
                                    return coroutine_suspended;
                                case 5:
                                    i3 = c04792.I$0;
                                    str11 = (String) c04792.L$6;
                                    deviceKey3 = (DeviceKey) c04792.L$5;
                                    Mutex mutex12 = (Mutex) c04792.L$4;
                                    str12 = (String) c04792.L$3;
                                    str13 = (String) c04792.L$2;
                                    deviceKeySlot2 = (DeviceKeySlot) c04792.L$1;
                                    deviceKeyManager = (DeviceKeyManager) c04792.L$0;
                                    ResultKt.throwOnFailure(objSignFailure);
                                    r13 = mutex12;
                                    signature2 = (Signature) objSignFailure;
                                    deviceKey2 = deviceKey3;
                                    str7 = str12;
                                    str9 = str11;
                                    str6 = str13;
                                    r13 = r13;
                                    mutex5 = deviceKeyManager.mutex;
                                    c04792.L$0 = deviceKeyManager;
                                    c04792.L$1 = deviceKeySlot2;
                                    c04792.L$2 = str6;
                                    c04792.L$3 = str7;
                                    c04792.L$4 = r13;
                                    c04792.L$5 = deviceKey2;
                                    c04792.L$6 = str9;
                                    c04792.L$7 = signature2;
                                    c04792.L$8 = mutex5;
                                    c04792.I$0 = i3;
                                    c04792.label = 6;
                                    if (mutex5.lock(null, c04792) != coroutine_suspended) {
                                        r9 = r13;
                                        str14 = str7;
                                        str15 = str6;
                                        mutex6 = mutex5;
                                        deviceKey4 = deviceKey2;
                                        str16 = str9;
                                        signature3 = signature2;
                                        DeviceKeyMetadataStore deviceKeyMetadataStore8 = deviceKeyManager.store;
                                        c04792.L$0 = deviceKeyManager;
                                        c04792.L$1 = deviceKeySlot2;
                                        c04792.L$2 = str15;
                                        c04792.L$3 = str14;
                                        c04792.L$4 = r9;
                                        c04792.L$5 = deviceKey4;
                                        c04792.L$6 = str16;
                                        c04792.L$7 = signature3;
                                        c04792.L$8 = mutex6;
                                        c04792.I$0 = i3;
                                        c04792.label = 7;
                                        objSignFailure = deviceKeyMetadataStore8.read(c04792);
                                        r4 = mutex6;
                                        r10 = r9;
                                        if (objSignFailure == coroutine_suspended) {
                                        }
                                        i2 = i3;
                                        signature4 = signature3;
                                        str17 = str14;
                                        str18 = str15;
                                        deviceKeyRecord2 = (DeviceKeyRecord) objSignFailure;
                                        r4.unlock(null);
                                        if (deviceKeyRecord2 != null) {
                                            key2 = deviceKeyRecord2.getKey();
                                        } else {
                                            key2 = null;
                                        }
                                        if (key2 != null) {
                                            kid = key2.getKid();
                                        } else {
                                            kid = null;
                                        }
                                        if (Intrinsics.areEqual(kid, deviceKey4.getKid())) {
                                            if (key2 != null) {
                                                subject2 = key2.getSubject();
                                            } else {
                                                subject2 = null;
                                            }
                                            if (Intrinsics.areEqual(subject2, str16)) {
                                                String strJwsCompact5 = DeviceKeyCrypto.INSTANCE.jwsCompact(signature4, deviceKey4.getKid(), str18, str16, str17, i2);
                                                r10.unlock(null);
                                                return strJwsCompact5;
                                            }
                                        }
                                        throw new AuthError(AppAuthErrorCode.DEVICE_KEY_INVALIDATED, "The device key changed while its signature was being authorised", null, 4, null);
                                    }
                                    return coroutine_suspended;
                                case 6:
                                    i3 = c04792.I$0;
                                    Mutex mutex13 = (Mutex) c04792.L$8;
                                    signature3 = (Signature) c04792.L$7;
                                    str16 = (String) c04792.L$6;
                                    deviceKey4 = (DeviceKey) c04792.L$5;
                                    Mutex mutex14 = (Mutex) c04792.L$4;
                                    str14 = (String) c04792.L$3;
                                    str15 = (String) c04792.L$2;
                                    deviceKeySlot2 = (DeviceKeySlot) c04792.L$1;
                                    deviceKeyManager = (DeviceKeyManager) c04792.L$0;
                                    try {
                                        ResultKt.throwOnFailure(objSignFailure);
                                        mutex6 = mutex13;
                                        r9 = mutex14;
                                        DeviceKeyMetadataStore deviceKeyMetadataStore9 = deviceKeyManager.store;
                                        c04792.L$0 = deviceKeyManager;
                                        c04792.L$1 = deviceKeySlot2;
                                        c04792.L$2 = str15;
                                        c04792.L$3 = str14;
                                        c04792.L$4 = r9;
                                        c04792.L$5 = deviceKey4;
                                        c04792.L$6 = str16;
                                        c04792.L$7 = signature3;
                                        c04792.L$8 = mutex6;
                                        c04792.I$0 = i3;
                                        c04792.label = 7;
                                        objSignFailure = deviceKeyMetadataStore9.read(c04792);
                                        r4 = mutex6;
                                        r10 = r9;
                                        if (objSignFailure == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        i2 = i3;
                                        signature4 = signature3;
                                        str17 = str14;
                                        str18 = str15;
                                        deviceKeyRecord2 = (DeviceKeyRecord) objSignFailure;
                                        r4.unlock(null);
                                        if (deviceKeyRecord2 != null) {
                                            key2 = deviceKeyRecord2.getKey();
                                        } else {
                                            key2 = null;
                                        }
                                        if (key2 != null) {
                                            kid = key2.getKid();
                                        } else {
                                            kid = null;
                                        }
                                        if (Intrinsics.areEqual(kid, deviceKey4.getKid())) {
                                            if (key2 != null) {
                                                subject2 = key2.getSubject();
                                            } else {
                                                subject2 = null;
                                            }
                                            if (Intrinsics.areEqual(subject2, str16)) {
                                                String strJwsCompact6 = DeviceKeyCrypto.INSTANCE.jwsCompact(signature4, deviceKey4.getKid(), str18, str16, str17, i2);
                                                r10.unlock(null);
                                                return strJwsCompact6;
                                            }
                                        }
                                        throw new AuthError(AppAuthErrorCode.DEVICE_KEY_INVALIDATED, "The device key changed while its signature was being authorised", null, 4, null);
                                    } catch (CancellationException e7) {
                                        throw e7;
                                    } catch (Exception e8) {
                                        e = e8;
                                        r12 = mutex14;
                                        c04792.L$0 = r12;
                                        c04792.L$1 = null;
                                        c04792.L$2 = null;
                                        c04792.L$3 = null;
                                        c04792.L$4 = null;
                                        c04792.L$5 = null;
                                        c04792.L$6 = null;
                                        c04792.L$7 = null;
                                        c04792.L$8 = null;
                                        c04792.label = 8;
                                        objSignFailure = deviceKeyManager.signFailure(deviceKeySlot2, e, c04792);
                                        if (objSignFailure != coroutine_suspended) {
                                            throw ((Throwable) objSignFailure);
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        coroutine_suspended = mutex14;
                                        coroutine_suspended.unlock(null);
                                        throw th;
                                    }
                                case 7:
                                    i3 = c04792.I$0;
                                    Mutex mutex15 = (Mutex) c04792.L$8;
                                    signature3 = (Signature) c04792.L$7;
                                    str16 = (String) c04792.L$6;
                                    deviceKey4 = (DeviceKey) c04792.L$5;
                                    Mutex mutex16 = (Mutex) c04792.L$4;
                                    str14 = (String) c04792.L$3;
                                    str15 = (String) c04792.L$2;
                                    ResultKt.throwOnFailure(objSignFailure);
                                    r4 = mutex15;
                                    r10 = mutex16;
                                    i2 = i3;
                                    signature4 = signature3;
                                    str17 = str14;
                                    str18 = str15;
                                    deviceKeyRecord2 = (DeviceKeyRecord) objSignFailure;
                                    r4.unlock(null);
                                    if (deviceKeyRecord2 != null) {
                                        key2 = deviceKeyRecord2.getKey();
                                    } else {
                                        key2 = null;
                                    }
                                    if (key2 != null) {
                                        kid = key2.getKid();
                                    } else {
                                        kid = null;
                                    }
                                    if (Intrinsics.areEqual(kid, deviceKey4.getKid())) {
                                        if (key2 != null) {
                                            subject2 = key2.getSubject();
                                        } else {
                                            subject2 = null;
                                        }
                                        if (Intrinsics.areEqual(subject2, str16)) {
                                            String strJwsCompact7 = DeviceKeyCrypto.INSTANCE.jwsCompact(signature4, deviceKey4.getKid(), str18, str16, str17, i2);
                                            r10.unlock(null);
                                            return strJwsCompact7;
                                        }
                                    }
                                    throw new AuthError(AppAuthErrorCode.DEVICE_KEY_INVALIDATED, "The device key changed while its signature was being authorised", null, 4, null);
                                case 8:
                                    ResultKt.throwOnFailure(objSignFailure);
                                    throw ((Throwable) objSignFailure);
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            coroutine_suspended = obj;
                        }
                    } catch (Throwable th5) {
                        r4.unlock(null);
                        throw th5;
                    }
                } catch (Throwable th6) {
                    r4.unlock(null);
                    throw th6;
                }
            } catch (Throwable th7) {
                th = th7;
            }
        } catch (CancellationException e9) {
            throw e9;
        } catch (Exception e10) {
            e = e10;
            r12 = r6;
        } catch (Throwable th8) {
            th = th8;
            coroutine_suspended = r6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object signFailure(DeviceKeySlot deviceKeySlot, Exception exc, Continuation continuation) {
        C04801 c04801;
        boolean z;
        if (continuation instanceof C04801) {
            c04801 = (C04801) continuation;
            int i = c04801.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                c04801.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                c04801 = new C04801(continuation);
            }
        } else {
            c04801 = new C04801(continuation);
        }
        Object obj = c04801.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c04801.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                if ((exc instanceof KeyPermanentlyInvalidatedException) || (exc instanceof UnrecoverableKeyException) || (((z = exc instanceof AuthError)) && ((AuthError) exc).getCode() == AppAuthErrorCode.DEVICE_KEY_INVALIDATED)) {
                    Result.Companion companion = Result.Companion;
                    c04801.L$0 = exc;
                    c04801.label = 1;
                    if (deleteKey(deviceKeySlot, c04801) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (exc instanceof UserNotAuthenticatedException) {
                        return new AuthError(AppAuthErrorCode.AUTHENTICATION_FAILED, "The device key was not authorised by the authentication that preceded it", exc);
                    }
                    if (z) {
                        return (AuthError) exc;
                    }
                    return new AuthError(AppAuthErrorCode.RUNTIME_EXCEPTION, "Failed to sign the device-key assertion", exc);
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                exc = (Exception) c04801.L$0;
                ResultKt.throwOnFailure(obj);
            }
            Result.m5243constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m5243constructorimpl(ResultKt.createFailure(th));
        }
        return new AuthError(AppAuthErrorCode.DEVICE_KEY_INVALIDATED, "The device key can no longer sign and has been deleted", exc);
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00d7, code lost:
    
        if (r5.wipeSlotsUnlocked(r0) == r1) goto L54;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v1, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object reconcileSubject(java.lang.String r10, kotlin.coroutines.Continuation r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager.reconcileSubject(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01b7 A[Catch: all -> 0x005d, TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x005d, blocks: (B:117:0x0213, B:118:0x021c, B:119:0x021f, B:22:0x0058, B:101:0x01b7, B:14:0x0032, B:116:0x0211, B:19:0x0047, B:108:0x01e6, B:111:0x01ec, B:113:0x01f6, B:105:0x01d4), top: B:131:0x0023, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:104:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:107:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:108:0x01e6 A[Catch: all -> 0x0037, PHI: r0 r12 r13 r14
      0x01e6: PHI (r0v35 java.lang.Object) = (r0v34 java.lang.Object), (r0v3 java.lang.Object) binds: [B:106:0x01e3, B:19:0x0047] A[DONT_GENERATE, DONT_INLINE]
      0x01e6: PHI (r12v49 kotlinx.coroutines.sync.Mutex) = (r12v61 kotlinx.coroutines.sync.Mutex), (r12v62 kotlinx.coroutines.sync.Mutex) binds: [B:106:0x01e3, B:19:0x0047] A[DONT_GENERATE, DONT_INLINE]
      0x01e6: PHI (r13v33 com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager) = 
      (r13v30 com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager)
      (r13v37 com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager)
     binds: [B:106:0x01e3, B:19:0x0047] A[DONT_GENERATE, DONT_INLINE]
      0x01e6: PHI (r14v38 java.lang.String) = (r14v35 java.lang.String), (r14v42 java.lang.String) binds: [B:106:0x01e3, B:19:0x0047] A[DONT_GENERATE, DONT_INLINE], TryCatch #4 {all -> 0x0037, blocks: (B:14:0x0032, B:116:0x0211, B:19:0x0047, B:108:0x01e6, B:111:0x01ec, B:113:0x01f6, B:105:0x01d4), top: B:131:0x0023, outer: #6 }] */
    /* JADX WARN: Code duplicated, block: B:110:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:111:0x01ec A[Catch: all -> 0x0037, TryCatch #4 {all -> 0x0037, blocks: (B:14:0x0032, B:116:0x0211, B:19:0x0047, B:108:0x01e6, B:111:0x01ec, B:113:0x01f6, B:105:0x01d4), top: B:131:0x0023, outer: #6 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x01f6 A[Catch: all -> 0x0037, TryCatch #4 {all -> 0x0037, blocks: (B:14:0x0032, B:116:0x0211, B:19:0x0047, B:108:0x01e6, B:111:0x01ec, B:113:0x01f6, B:105:0x01d4), top: B:131:0x0023, outer: #6 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x010b  */
    /* JADX WARN: Code duplicated, block: B:70:0x014a  */
    /* JADX WARN: Code duplicated, block: B:73:0x014f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:75:0x0152  */
    /* JADX WARN: Code duplicated, block: B:81:0x0161  */
    /* JADX WARN: Code duplicated, block: B:88:0x0183  */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code duplicated, block: B:96:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:99:0x01b4  */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x020e, code lost:
    
        if (r13.write(r14, r15) == r1) goto L115;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v3, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r12v52, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r12v57 */
    /* JADX WARN: Type inference failed for: r12v58 */
    /* JADX WARN: Type inference failed for: r12v59 */
    /* JADX WARN: Type inference failed for: r12v60 */
    /* JADX WARN: Type inference failed for: r12v64 */
    /* JADX WARN: Type inference failed for: r12v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v13, types: [com.doctolib.apps.authentication.internal.devicekey.DeviceKeyRegistrar] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v17, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object flushPendingRevocation(java.lang.String r12, java.lang.String r13, java.lang.String r14, kotlin.coroutines.Continuation r15) {
        /*
            Method dump skipped, instruction units count: 574
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager.flushPendingRevocation(java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager$wipeSlots$2, reason: invalid class name and case insensitive filesystem */
    static final class C04812 extends SuspendLambda implements Function2 {
        Object L$0;
        Object L$1;
        int label;

        C04812(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeviceKeyManager.this.new C04812(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C04812) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Mutex mutex;
            DeviceKeyManager deviceKeyManager;
            Mutex mutex2;
            Throwable th;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    mutex = DeviceKeyManager.this.mutex;
                    deviceKeyManager = DeviceKeyManager.this;
                    this.L$0 = mutex;
                    this.L$1 = deviceKeyManager;
                    this.label = 1;
                    if (mutex.lock(null, this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mutex2 = (Mutex) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        Unit unit = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return Unit.INSTANCE;
                    } catch (Throwable th2) {
                        th = th2;
                        mutex2.unlock(null);
                        throw th;
                    }
                }
                deviceKeyManager = (DeviceKeyManager) this.L$1;
                Mutex mutex3 = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
                mutex = mutex3;
                this.L$0 = mutex;
                this.L$1 = null;
                this.label = 2;
                if (deviceKeyManager.wipeSlotsUnlocked(this) != coroutine_suspended) {
                    mutex2 = mutex;
                    Unit unit2 = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            } catch (Throwable th3) {
                mutex2 = mutex;
                th = th3;
                mutex2.unlock(null);
                throw th;
            }
        }
    }

    public final Object wipeSlots(Continuation continuation) {
        Object objWithContext = BuildersKt.withContext(NonCancellable.INSTANCE, new C04812(null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager$wipeSlotsUnlocked$2, reason: invalid class name and case insensitive filesystem */
    static final class C04822 extends SuspendLambda implements Function2 {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        C04822(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C04822 c04822 = DeviceKeyManager.this.new C04822(continuation);
            c04822.L$0 = obj;
            return c04822;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C04822) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:20:0x0049  */
        /* JADX WARN: Code duplicated, block: B:23:0x0068  */
        /* JADX WARN: Code duplicated, block: B:24:0x0069 A[Catch: all -> 0x002e, PHI: r1 r4 r5
          0x0069: PHI (r1v6 java.util.Iterator) = (r1v4 java.util.Iterator), (r1v8 java.util.Iterator) binds: [B:22:0x0066, B:13:0x002a] A[DONT_GENERATE, DONT_INLINE]
          0x0069: PHI (r4v3 com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager) = 
          (r4v2 com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager)
          (r4v5 com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager)
         binds: [B:22:0x0066, B:13:0x002a] A[DONT_GENERATE, DONT_INLINE]
          0x0069: PHI (r5v3 kotlinx.coroutines.CoroutineScope) = (r5v2 kotlinx.coroutines.CoroutineScope), (r5v5 kotlinx.coroutines.CoroutineScope) binds: [B:22:0x0066, B:13:0x002a] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #1 {all -> 0x002e, blocks: (B:13:0x002a, B:24:0x0069, B:21:0x004f), top: B:38:0x002a }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0066 -> B:24:0x0069). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r9.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L30
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L13
                goto L90
            L13:
                r10 = move-exception
                goto L96
            L16:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L1e:
                java.lang.Object r1 = r9.L$2
                java.util.Iterator r1 = (java.util.Iterator) r1
                java.lang.Object r4 = r9.L$1
                com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager r4 = (com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager) r4
                java.lang.Object r5 = r9.L$0
                kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5
                kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L2e
                goto L69
            L2e:
                r10 = move-exception
                goto L6f
            L30:
                kotlin.ResultKt.throwOnFailure(r10)
                java.lang.Object r10 = r9.L$0
                kotlinx.coroutines.CoroutineScope r10 = (kotlinx.coroutines.CoroutineScope) r10
                kotlin.enums.EnumEntries r1 = com.doctolib.apps.authentication.model.DeviceKeySlot.getEntries()
                com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager r4 = com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager.this
                java.util.Iterator r1 = r1.iterator()
                r5 = r10
            L42:
                boolean r10 = r1.hasNext()
                r6 = 0
                if (r10 == 0) goto L79
                java.lang.Object r10 = r1.next()
                com.doctolib.apps.authentication.model.DeviceKeySlot r10 = (com.doctolib.apps.authentication.model.DeviceKeySlot) r10
                kotlin.Result$Companion r7 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L2e
                kotlinx.coroutines.CoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.lang.Throwable -> L2e
                com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager$wipeSlotsUnlocked$2$1$1$1 r8 = new com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager$wipeSlotsUnlocked$2$1$1$1     // Catch: java.lang.Throwable -> L2e
                r8.<init>(r4, r10, r6)     // Catch: java.lang.Throwable -> L2e
                r9.L$0 = r5     // Catch: java.lang.Throwable -> L2e
                r9.L$1 = r4     // Catch: java.lang.Throwable -> L2e
                r9.L$2 = r1     // Catch: java.lang.Throwable -> L2e
                r9.label = r3     // Catch: java.lang.Throwable -> L2e
                java.lang.Object r10 = kotlinx.coroutines.BuildersKt.withContext(r7, r8, r9)     // Catch: java.lang.Throwable -> L2e
                if (r10 != r0) goto L69
                goto L8f
            L69:
                kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L2e
                kotlin.Result.m5243constructorimpl(r10)     // Catch: java.lang.Throwable -> L2e
                goto L42
            L6f:
                kotlin.Result$Companion r6 = kotlin.Result.Companion
                java.lang.Object r10 = kotlin.ResultKt.createFailure(r10)
                kotlin.Result.m5243constructorimpl(r10)
                goto L42
            L79:
                com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager r10 = com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager.this
                kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L13
                com.doctolib.apps.authentication.internal.storage.DeviceKeyMetadataStore r10 = com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager.access$getStore$p(r10)     // Catch: java.lang.Throwable -> L13
                r9.L$0 = r6     // Catch: java.lang.Throwable -> L13
                r9.L$1 = r6     // Catch: java.lang.Throwable -> L13
                r9.L$2 = r6     // Catch: java.lang.Throwable -> L13
                r9.label = r2     // Catch: java.lang.Throwable -> L13
                java.lang.Object r10 = r10.clear(r9)     // Catch: java.lang.Throwable -> L13
                if (r10 != r0) goto L90
            L8f:
                return r0
            L90:
                kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L13
                kotlin.Result.m5243constructorimpl(r10)     // Catch: java.lang.Throwable -> L13
                goto L9f
            L96:
                kotlin.Result$Companion r0 = kotlin.Result.Companion
                java.lang.Object r10 = kotlin.ResultKt.createFailure(r10)
                kotlin.Result.m5243constructorimpl(r10)
            L9f:
                kotlin.Unit r10 = kotlin.Unit.INSTANCE
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager.C04822.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object wipeSlotsUnlocked(Continuation continuation) {
        Object objWithContext = BuildersKt.withContext(NonCancellable.INSTANCE, new C04822(null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:36:0x009c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:37:0x009d  */
    /* JADX WARN: Code duplicated, block: B:42:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c7, code lost:
    
        if (r15.write(r14, r0) == r1) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object preflightKey(com.doctolib.apps.authentication.model.DeviceKeySlot r14, kotlin.coroutines.Continuation r15) {
        /*
            Method dump skipped, instruction units count: 218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager.preflightKey(com.doctolib.apps.authentication.model.DeviceKeySlot, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager$preflightKey$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ DeviceKeySlot $slot;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(DeviceKeySlot deviceKeySlot, Continuation continuation) {
            super(2, continuation);
            this.$slot = deviceKeySlot;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeviceKeyManager.this.new AnonymousClass2(this.$slot, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(DeviceKeyManager.this.keystore.containsKey(this.$slot));
        }
    }
}
