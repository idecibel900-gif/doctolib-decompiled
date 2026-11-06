package expo.modules.video;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import androidx.core.content.res.FontResourcesParserCompat$$ExternalSyntheticAutoCloseableDispatcher0;
import androidx.recyclerview.widget.LinearLayoutManager;
import expo.modules.video.records.VideoThumbnailOptions;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: loaded from: classes5.dex */
public abstract class MediaMetadataRetrieverKt {

    /* JADX INFO: renamed from: expo.modules.video.MediaMetadataRetrieverKt$safeUse$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return MediaMetadataRetrieverKt.safeUse(null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object safeUse(MediaMetadataRetriever mediaMetadataRetriever, Function2 function2, Continuation continuation) throws Exception {
        AnonymousClass1 anonymousClass1;
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
        Object objInvoke = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objInvoke);
                anonymousClass1.L$0 = mediaMetadataRetriever;
                anonymousClass1.label = 1;
                objInvoke = function2.invoke(mediaMetadataRetriever, anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mediaMetadataRetriever = (MediaMetadataRetriever) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objInvoke);
            }
            FontResourcesParserCompat$$ExternalSyntheticAutoCloseableDispatcher0.m(mediaMetadataRetriever);
            return objInvoke;
        } catch (Throwable th) {
            FontResourcesParserCompat$$ExternalSyntheticAutoCloseableDispatcher0.m(mediaMetadataRetriever);
            throw th;
        }
    }

    /* JADX INFO: renamed from: generateThumbnailAtTime-8Mi8wO0, reason: not valid java name */
    public static final VideoThumbnail m5000generateThumbnailAtTime8Mi8wO0(MediaMetadataRetriever generateThumbnailAtTime, long j, VideoThumbnailOptions videoThumbnailOptions) {
        MediaMetadataRetriever mediaMetadataRetriever;
        Intrinsics.checkNotNullParameter(generateThumbnailAtTime, "$this$generateThumbnailAtTime");
        Bitmap frameAtTime = null;
        Pair<Integer, Integer> nativeSizeLimit = videoThumbnailOptions != null ? videoThumbnailOptions.toNativeSizeLimit() : null;
        if (nativeSizeLimit != null) {
            int iIntValue = ((Number) nativeSizeLimit.getFirst()).intValue();
            int iIntValue2 = ((Number) nativeSizeLimit.getSecond()).intValue();
            if (Build.VERSION.SDK_INT >= 27) {
                mediaMetadataRetriever = generateThumbnailAtTime;
                frameAtTime = mediaMetadataRetriever.getScaledFrameAtTime(Duration.m5407getInWholeMicrosecondsimpl(j), 3, iIntValue, iIntValue2);
            } else {
                mediaMetadataRetriever = generateThumbnailAtTime;
                Bitmap frameAtTime2 = mediaMetadataRetriever.getFrameAtTime(Duration.m5407getInWholeMicrosecondsimpl(j), 3);
                if (frameAtTime2 != null) {
                    frameAtTime = constrainToDimensions(frameAtTime2, iIntValue, iIntValue2);
                }
            }
        } else {
            mediaMetadataRetriever = generateThumbnailAtTime;
            frameAtTime = mediaMetadataRetriever.getFrameAtTime(Duration.m5407getInWholeMicrosecondsimpl(j), 3);
        }
        Bitmap bitmap = frameAtTime;
        if (bitmap == null) {
            throw new IllegalStateException("Failed to generate thumbnail");
        }
        return new VideoThumbnail(bitmap, j, m4999calculateActualFrameTimeHG0u8IE(mediaMetadataRetriever, j), null);
    }

    /* JADX INFO: renamed from: calculateActualFrameTime-HG0u8IE, reason: not valid java name */
    private static final long m4999calculateActualFrameTimeHG0u8IE(MediaMetadataRetriever mediaMetadataRetriever, long j) {
        Double dFrameTime = frameTime(mediaMetadataRetriever);
        if (dFrameTime == null) {
            return j;
        }
        double dDoubleValue = dFrameTime.doubleValue();
        return DurationKt.toDuration(MathKt.roundToLong(Duration.m5407getInWholeMicrosecondsimpl(j) / dDoubleValue) * dDoubleValue, DurationUnit.MICROSECONDS);
    }

    private static final Double frameTime(MediaMetadataRetriever mediaMetadataRetriever) {
        String strExtractMetadata;
        if (Build.VERSION.SDK_INT >= 28 && (strExtractMetadata = mediaMetadataRetriever.extractMetadata(9)) != null) {
            double d = Double.parseDouble(strExtractMetadata);
            String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(32);
            if (strExtractMetadata2 != null) {
                return Double.valueOf((d * ((double) 1000)) / Double.parseDouble(strExtractMetadata2));
            }
        }
        return null;
    }

    private static final Bitmap constrainToDimensions(Bitmap bitmap, int i, int i2) {
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        float fMax = Math.max(width / i, height / i2);
        if (fMax <= 1.0f) {
            return bitmap;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) (width / fMax), (int) (height / fMax), true);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
        return bitmapCreateScaledBitmap;
    }
}
