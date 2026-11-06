package expo.modules.video.managers;

import expo.modules.video.player.VideoPlayer;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes5.dex */
final class AudioFocusManager$duckPlayer$1$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ VideoPlayer $player;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AudioFocusManager$duckPlayer$1$1(VideoPlayer videoPlayer, Continuation continuation) {
        super(2, continuation);
        this.$player = videoPlayer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AudioFocusManager$duckPlayer$1$1(this.$player, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AudioFocusManager$duckPlayer$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        VideoPlayer videoPlayer = this.$player;
        videoPlayer.setVolume(videoPlayer.getVolume() / 2.0f);
        return Unit.INSTANCE;
    }
}
