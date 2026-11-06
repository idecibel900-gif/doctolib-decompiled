package com.doctolib.apps.authentication.internal.devicekey;

import com.doctolib.apps.authentication.model.DeviceKeySlot;
import com.doctolib.apps.authentication.model.DeviceKeyStorage;
import com.doctolib.apps.authentication.model.DeviceKeyUserAuthentication;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
final class DeviceKeyManager$createKey$2$1$key$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ DeviceKeySlot $slot;
    final /* synthetic */ DeviceKeyStorage $storage;
    final /* synthetic */ DeviceKeyUserAuthentication $userAuthentication;
    int label;
    final /* synthetic */ DeviceKeyManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeviceKeyManager$createKey$2$1$key$1(DeviceKeyManager deviceKeyManager, DeviceKeySlot deviceKeySlot, DeviceKeyUserAuthentication deviceKeyUserAuthentication, DeviceKeyStorage deviceKeyStorage, Continuation continuation) {
        super(2, continuation);
        this.this$0 = deviceKeyManager;
        this.$slot = deviceKeySlot;
        this.$userAuthentication = deviceKeyUserAuthentication;
        this.$storage = deviceKeyStorage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DeviceKeyManager$createKey$2$1$key$1(this.this$0, this.$slot, this.$userAuthentication, this.$storage, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DeviceKeyManager$createKey$2$1$key$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.this$0.keystore.createKey(this.$slot, this.$userAuthentication, this.$storage);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
