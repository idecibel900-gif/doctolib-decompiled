package expo.modules.video;

import android.media.MediaMetadataRetriever;
import expo.modules.video.records.VideoThumbnailOptions;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes5.dex */
final class VideoModule$definition$1$9$52$1$bitmaps$1$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ MediaMetadataRetriever $$this$safeUse;
    final /* synthetic */ VideoThumbnailOptions $options;
    final /* synthetic */ long $time;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoModule$definition$1$9$52$1$bitmaps$1$1(MediaMetadataRetriever mediaMetadataRetriever, long j, VideoThumbnailOptions videoThumbnailOptions, Continuation continuation) {
        super(2, continuation);
        this.$$this$safeUse = mediaMetadataRetriever;
        this.$time = j;
        this.$options = videoThumbnailOptions;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new VideoModule$definition$1$9$52$1$bitmaps$1$1(this.$$this$safeUse, this.$time, this.$options, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((VideoModule$definition$1$9$52$1$bitmaps$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return MediaMetadataRetrieverKt.m5000generateThumbnailAtTime8Mi8wO0(this.$$this$safeUse, this.$time, this.$options);
    }
}
