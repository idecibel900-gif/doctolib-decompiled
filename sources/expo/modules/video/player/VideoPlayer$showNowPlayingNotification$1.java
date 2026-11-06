package expo.modules.video.player;

import expo.modules.kotlin.exception.Exceptions$AppContextLost;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes5.dex */
final class VideoPlayer$showNowPlayingNotification$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ boolean $value;
    int label;
    final /* synthetic */ VideoPlayer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoPlayer$showNowPlayingNotification$1(VideoPlayer videoPlayer, boolean z, Continuation continuation) {
        super(2, continuation);
        this.this$0 = videoPlayer;
        this.$value = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new VideoPlayer$showNowPlayingNotification$1(this.this$0, this.$value, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((VideoPlayer$showNowPlayingNotification$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Exceptions$AppContextLost {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.serviceSetShowNotification(this.$value);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
