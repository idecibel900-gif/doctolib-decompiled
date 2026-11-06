package expo.modules.updates;

import android.content.Context;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
final class UpdatesPackage$createReactActivityHandlers$handler$1$getDelayLoadAppHandler$1$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $useDeveloperSupport;
    final /* synthetic */ Runnable $whenReadyRunnable;
    int label;
    final /* synthetic */ UpdatesPackage$createReactActivityHandlers$handler$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UpdatesPackage$createReactActivityHandlers$handler$1$getDelayLoadAppHandler$1$1(UpdatesPackage$createReactActivityHandlers$handler$1 updatesPackage$createReactActivityHandlers$handler$1, Context context, boolean z, Runnable runnable, Continuation continuation) {
        super(2, continuation);
        this.this$0 = updatesPackage$createReactActivityHandlers$handler$1;
        this.$context = context;
        this.$useDeveloperSupport = z;
        this.$whenReadyRunnable = runnable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new UpdatesPackage$createReactActivityHandlers$handler$1$getDelayLoadAppHandler$1$1(this.this$0, this.$context, this.$useDeveloperSupport, this.$whenReadyRunnable, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((UpdatesPackage$createReactActivityHandlers$handler$1$getDelayLoadAppHandler$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0040, code lost:
    
        if (r6.invokeReadyRunnable(r1, r5) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r6)
            goto L43
        L12:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1a:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L33
        L1e:
            kotlin.ResultKt.throwOnFailure(r6)
            expo.modules.updates.UpdatesPackage$createReactActivityHandlers$handler$1 r6 = r5.this$0
            android.content.Context r1 = r5.$context
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            boolean r4 = r5.$useDeveloperSupport
            r5.label = r3
            java.lang.Object r6 = expo.modules.updates.UpdatesPackage$createReactActivityHandlers$handler$1.access$startUpdatesController(r6, r1, r4, r5)
            if (r6 != r0) goto L33
            goto L42
        L33:
            expo.modules.updates.UpdatesPackage$createReactActivityHandlers$handler$1 r6 = r5.this$0
            java.lang.Runnable r1 = r5.$whenReadyRunnable
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r5.label = r2
            java.lang.Object r6 = expo.modules.updates.UpdatesPackage$createReactActivityHandlers$handler$1.access$invokeReadyRunnable(r6, r1, r5)
            if (r6 != r0) goto L43
        L42:
            return r0
        L43:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.updates.UpdatesPackage$createReactActivityHandlers$handler$1$getDelayLoadAppHandler$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
