package com.revenuecat.purchases.ui.revenuecatui.components.video;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.video.VideoViewKt$Video$1$1", f = "VideoView.kt", l = {}, m = "invokeSuspend")
final class VideoViewKt$Video$1$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ boolean $autoPlay;
    final /* synthetic */ MutableState $videoView;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoViewKt$Video$1$1(MutableState mutableState, boolean z, Continuation continuation) {
        super(2, continuation);
        this.$videoView = mutableState;
        this.$autoPlay = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new VideoViewKt$Video$1$1(this.$videoView, this.$autoPlay, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((VideoViewKt$Video$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        TextureVideoView textureVideoView = (TextureVideoView) this.$videoView.getValue();
        if (textureVideoView != null) {
            textureVideoView.setAutoStart(this.$autoPlay);
            textureVideoView.startIfNeeded();
        }
        return Unit.INSTANCE;
    }
}
