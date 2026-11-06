package com.doctolib.apps.authentication.internal.devicekey;

import com.doctolib.apps.authentication.model.DeviceKeySlot;
import java.security.KeyStoreException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
final class DeviceKeyManager$wipeSlotsUnlocked$2$1$1$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ DeviceKeySlot $slot;
    int label;
    final /* synthetic */ DeviceKeyManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeviceKeyManager$wipeSlotsUnlocked$2$1$1$1(DeviceKeyManager deviceKeyManager, DeviceKeySlot deviceKeySlot, Continuation continuation) {
        super(2, continuation);
        this.this$0 = deviceKeyManager;
        this.$slot = deviceKeySlot;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DeviceKeyManager$wipeSlotsUnlocked$2$1$1$1(this.this$0, this.$slot, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DeviceKeyManager$wipeSlotsUnlocked$2$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws KeyStoreException {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.this$0.keystore.deleteKey(this.$slot);
        return Unit.INSTANCE;
    }
}
