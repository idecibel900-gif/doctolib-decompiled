package expo.modules.core.logging;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: classes4.dex */
public final class PersistentFileLogSerialDispatchQueue {
    private final Channel channel = ChannelKt.Channel$default(-2, null, null, 6, null);
    private final Job queueRunner = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new PersistentFileLogSerialDispatchQueue$queueRunner$1(this, null), 3, null);

    /* JADX INFO: renamed from: expo.modules.core.logging.PersistentFileLogSerialDispatchQueue$add$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ Function0 $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Function0 function0, Continuation continuation) {
            super(2, continuation);
            this.$block = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PersistentFileLogSerialDispatchQueue.this.new AnonymousClass1(this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Channel channel = PersistentFileLogSerialDispatchQueue.this.channel;
                Function0 function0 = this.$block;
                this.label = 1;
                if (channel.send(function0, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void add(Function0 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(block, null), 1, null);
    }
}
