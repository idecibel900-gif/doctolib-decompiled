package com.facebook.react.devsupport.inspector;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.view.FrameMetrics;
import android.view.PixelCopy;
import android.view.View;
import android.view.Window;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 ?2\u00020\u0001:\u0002@?B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ9\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019JE\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0014\u0010\u001a\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u00060\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u0006¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u0006¢\u0006\u0004\b#\u0010\"J\u0017\u0010&\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0004\b&\u0010'R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010(R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010)R\u0014\u0010*\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010(R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010/\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u001c\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0016018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u00107\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u00109\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010(R\u0018\u0010:\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010=\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>¨\u0006A"}, d2 = {"Lcom/facebook/react/devsupport/inspector/FrameTimingsObserver;", "", "", "screenshotsEnabled", "Lkotlin/Function1;", "Lcom/facebook/react/devsupport/inspector/FrameTimingSequence;", "", "onFrameTimingSequence", "<init>", "(ZLkotlin/jvm/functions/Function1;)V", "", "beginTimestamp", "endTimestamp", "emitFrameTiming", "(JJ)V", "", "frameId", "threadId", "", "screenshot", "emitFrameEvent", "(IIJJ[B)V", "Lcom/facebook/react/devsupport/inspector/FrameTimingsObserver$FrameData;", "frameData", "encodeFrame", "(Lcom/facebook/react/devsupport/inspector/FrameTimingsObserver$FrameData;)V", "callback", "captureScreenshot", "(IIJJLkotlin/jvm/functions/Function1;)V", "Landroid/graphics/Bitmap;", "bitmap", "encodeScreenshot", "(Landroid/graphics/Bitmap;)[B", "start", "()V", "stop", "Landroid/view/Window;", "window", "setCurrentWindow", "(Landroid/view/Window;)V", "Z", "Lkotlin/jvm/functions/Function1;", "isSupported", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "Lkotlinx/coroutines/CoroutineDispatcher;", "encodingDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "Ljava/util/concurrent/atomic/AtomicReference;", "lastFrameBuffer", "Ljava/util/concurrent/atomic/AtomicReference;", "frameCounter", "I", "Ljava/util/concurrent/atomic/AtomicBoolean;", "encodingInProgress", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isTracing", "currentWindow", "Landroid/view/Window;", "Landroid/view/Window$OnFrameMetricsAvailableListener;", "frameMetricsListener", "Landroid/view/Window$OnFrameMetricsAvailableListener;", "Companion", "FrameData", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FrameTimingsObserver {
    private static final int SCREENSHOT_OUTPUT_SIZE_HINT = 65536;
    private static final int SCREENSHOT_QUALITY = 80;
    private static final float SCREENSHOT_SCALE_FACTOR = 1.0f;
    private volatile Window currentWindow;
    private final CoroutineDispatcher encodingDispatcher;
    private final AtomicBoolean encodingInProgress;
    private int frameCounter;
    private final Window.OnFrameMetricsAvailableListener frameMetricsListener;
    private final boolean isSupported;
    private volatile boolean isTracing;
    private final AtomicReference<FrameData> lastFrameBuffer;
    private final Handler mainHandler;
    private final Function1 onFrameTimingSequence;
    private final boolean screenshotsEnabled;

    public FrameTimingsObserver(boolean z, Function1 onFrameTimingSequence) {
        Intrinsics.checkNotNullParameter(onFrameTimingSequence, "onFrameTimingSequence");
        this.screenshotsEnabled = z;
        this.onFrameTimingSequence = onFrameTimingSequence;
        this.isSupported = true;
        this.mainHandler = new Handler(Looper.getMainLooper());
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        this.encodingDispatcher = ExecutorsKt.from(executorServiceNewSingleThreadExecutor);
        this.lastFrameBuffer = new AtomicReference<>(null);
        this.encodingInProgress = new AtomicBoolean(false);
        this.frameMetricsListener = new Window.OnFrameMetricsAvailableListener() { // from class: com.facebook.react.devsupport.inspector.FrameTimingsObserver$$ExternalSyntheticLambda1
            @Override // android.view.Window.OnFrameMetricsAvailableListener
            public final void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i) {
                FrameTimingsObserver.frameMetricsListener$lambda$0(this.f$0, window, frameMetrics, i);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class FrameData {
        private final long beginTimestamp;
        private final Bitmap bitmap;
        private final long endTimestamp;
        private final int frameId;
        private final int threadId;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FrameData)) {
                return false;
            }
            FrameData frameData = (FrameData) obj;
            return Intrinsics.areEqual(this.bitmap, frameData.bitmap) && this.frameId == frameData.frameId && this.threadId == frameData.threadId && this.beginTimestamp == frameData.beginTimestamp && this.endTimestamp == frameData.endTimestamp;
        }

        public int hashCode() {
            return (((((((this.bitmap.hashCode() * 31) + Integer.hashCode(this.frameId)) * 31) + Integer.hashCode(this.threadId)) * 31) + Long.hashCode(this.beginTimestamp)) * 31) + Long.hashCode(this.endTimestamp);
        }

        public String toString() {
            return "FrameData(bitmap=" + this.bitmap + ", frameId=" + this.frameId + ", threadId=" + this.threadId + ", beginTimestamp=" + this.beginTimestamp + ", endTimestamp=" + this.endTimestamp + ")";
        }

        public FrameData(Bitmap bitmap, int i, int i2, long j, long j2) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            this.bitmap = bitmap;
            this.frameId = i;
            this.threadId = i2;
            this.beginTimestamp = j;
            this.endTimestamp = j2;
        }

        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        public final int getFrameId() {
            return this.frameId;
        }

        public final int getThreadId() {
            return this.threadId;
        }

        public final long getBeginTimestamp() {
            return this.beginTimestamp;
        }

        public final long getEndTimestamp() {
            return this.endTimestamp;
        }
    }

    public final void start() {
        if (this.isSupported) {
            this.frameCounter = 0;
            this.encodingInProgress.set(false);
            this.lastFrameBuffer.set(null);
            this.isTracing = true;
            long jNanoTime = System.nanoTime();
            emitFrameTiming(jNanoTime, jNanoTime);
            Window window = this.currentWindow;
            if (window != null) {
                window.addOnFrameMetricsAvailableListener(this.frameMetricsListener, this.mainHandler);
            }
        }
    }

    public final void stop() {
        Bitmap bitmap;
        if (this.isSupported) {
            this.isTracing = false;
            Window window = this.currentWindow;
            if (window != null) {
                window.removeOnFrameMetricsAvailableListener(this.frameMetricsListener);
            }
            this.mainHandler.removeCallbacksAndMessages(null);
            FrameData andSet = this.lastFrameBuffer.getAndSet(null);
            if (andSet == null || (bitmap = andSet.getBitmap()) == null) {
                return;
            }
            bitmap.recycle();
        }
    }

    public final void setCurrentWindow(Window window) {
        Window window2;
        if (!this.isSupported || this.currentWindow == window) {
            return;
        }
        Window window3 = this.currentWindow;
        if (window3 != null) {
            window3.removeOnFrameMetricsAvailableListener(this.frameMetricsListener);
        }
        this.currentWindow = window;
        if (!this.isTracing || (window2 = this.currentWindow) == null) {
            return;
        }
        window2.addOnFrameMetricsAvailableListener(this.frameMetricsListener, this.mainHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void frameMetricsListener$lambda$0(FrameTimingsObserver frameTimingsObserver, Window window, FrameMetrics frameMetrics, int i) {
        if (frameTimingsObserver.isTracing) {
            long metric = frameMetrics.getMetric(11);
            frameTimingsObserver.emitFrameTiming(metric, frameMetrics.getMetric(8) + metric);
        }
    }

    private final void emitFrameTiming(final long beginTimestamp, final long endTimestamp) {
        final int i = this.frameCounter;
        this.frameCounter = i + 1;
        final int iMyTid = Process.myTid();
        if (!this.screenshotsEnabled) {
            emitFrameEvent(i, iMyTid, beginTimestamp, endTimestamp, null);
        } else {
            captureScreenshot(i, iMyTid, beginTimestamp, endTimestamp, new Function1() { // from class: com.facebook.react.devsupport.inspector.FrameTimingsObserver$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return FrameTimingsObserver.emitFrameTiming$lambda$1(this.f$0, i, iMyTid, beginTimestamp, endTimestamp, (FrameTimingsObserver.FrameData) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit emitFrameTiming$lambda$1(FrameTimingsObserver frameTimingsObserver, int i, int i2, long j, long j2, FrameData frameData) {
        if (frameData != null) {
            if (frameTimingsObserver.encodingInProgress.compareAndSet(false, true)) {
                frameTimingsObserver.encodeFrame(frameData);
            } else {
                FrameData andSet = frameTimingsObserver.lastFrameBuffer.getAndSet(frameData);
                if (andSet != null) {
                    frameTimingsObserver.emitFrameEvent(andSet.getFrameId(), andSet.getThreadId(), andSet.getBeginTimestamp(), andSet.getEndTimestamp(), null);
                    andSet.getBitmap().recycle();
                }
            }
        } else {
            frameTimingsObserver.emitFrameEvent(i, i2, j, j2, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.facebook.react.devsupport.inspector.FrameTimingsObserver$emitFrameEvent$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ long $beginTimestamp;
        final /* synthetic */ long $endTimestamp;
        final /* synthetic */ int $frameId;
        final /* synthetic */ byte[] $screenshot;
        final /* synthetic */ int $threadId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i, int i2, long j, long j2, byte[] bArr, Continuation continuation) {
            super(2, continuation);
            this.$frameId = i;
            this.$threadId = i2;
            this.$beginTimestamp = j;
            this.$endTimestamp = j2;
            this.$screenshot = bArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return FrameTimingsObserver.this.new AnonymousClass1(this.$frameId, this.$threadId, this.$beginTimestamp, this.$endTimestamp, this.$screenshot, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            FrameTimingsObserver.this.onFrameTimingSequence.invoke(new FrameTimingSequence(this.$frameId, this.$threadId, this.$beginTimestamp, this.$endTimestamp, this.$screenshot));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitFrameEvent(int frameId, int threadId, long beginTimestamp, long endTimestamp, byte[] screenshot) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new AnonymousClass1(frameId, threadId, beginTimestamp, endTimestamp, screenshot, null), 3, null);
    }

    /* JADX INFO: renamed from: com.facebook.react.devsupport.inspector.FrameTimingsObserver$encodeFrame$1, reason: invalid class name and case insensitive filesystem */
    static final class C05221 extends SuspendLambda implements Function2 {
        final /* synthetic */ FrameData $frameData;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05221(FrameData frameData, Continuation continuation) {
            super(2, continuation);
            this.$frameData = frameData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return FrameTimingsObserver.this.new C05221(this.$frameData, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C05221) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    FrameTimingsObserver.this.emitFrameEvent(this.$frameData.getFrameId(), this.$frameData.getThreadId(), this.$frameData.getBeginTimestamp(), this.$frameData.getEndTimestamp(), FrameTimingsObserver.this.encodeScreenshot(this.$frameData.getBitmap()));
                    this.$frameData.getBitmap().recycle();
                    FrameTimingsObserver.this.encodingInProgress.set(false);
                    FrameData frameData = (FrameData) FrameTimingsObserver.this.lastFrameBuffer.getAndSet(null);
                    if (frameData != null) {
                        try {
                            FrameTimingsObserver.this.emitFrameEvent(frameData.getFrameId(), frameData.getThreadId(), frameData.getBeginTimestamp(), frameData.getEndTimestamp(), FrameTimingsObserver.this.encodeScreenshot(frameData.getBitmap()));
                        } finally {
                            frameData.getBitmap().recycle();
                        }
                    }
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                    this.$frameData.getBitmap().recycle();
                    throw th;
                }
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final void encodeFrame(FrameData frameData) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.encodingDispatcher), null, null, new C05221(frameData, null), 3, null);
    }

    private final void captureScreenshot(final int frameId, final int threadId, final long beginTimestamp, final long endTimestamp, final Function1 callback) {
        if (Build.VERSION.SDK_INT < 26) {
            callback.invoke(null);
            return;
        }
        Window window = this.currentWindow;
        if (window == null) {
            callback.invoke(null);
            return;
        }
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        final Bitmap bitmapCreateBitmap = Bitmap.createBitmap(decorView.getWidth(), decorView.getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        PixelCopy.request(window, bitmapCreateBitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: com.facebook.react.devsupport.inspector.FrameTimingsObserver$$ExternalSyntheticLambda2
            @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
            public final void onPixelCopyFinished(int i) {
                FrameTimingsObserver.captureScreenshot$lambda$2(callback, bitmapCreateBitmap, frameId, threadId, beginTimestamp, endTimestamp, i);
            }
        }, this.mainHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void captureScreenshot$lambda$2(Function1 function1, Bitmap bitmap, int i, int i2, long j, long j2, int i3) {
        if (i3 == 0) {
            function1.invoke(new FrameData(bitmap, i, i2, j, j2));
        } else {
            bitmap.recycle();
            function1.invoke(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] encodeScreenshot(Bitmap bitmap) throws Throwable {
        Throwable th;
        Bitmap bitmapCreateScaledBitmap;
        try {
            Window window = this.currentWindow;
            if (window == null) {
                return null;
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            float f = window.getContext().getResources().getDisplayMetrics().density;
            bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) ((width / f) * 1.0f), (int) ((height / f) * 1.0f), true);
            try {
                Bitmap.CompressFormat compressFormat = Build.VERSION.SDK_INT >= 30 ? Bitmap.CompressFormat.WEBP_LOSSY : Bitmap.CompressFormat.JPEG;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(SCREENSHOT_OUTPUT_SIZE_HINT);
                try {
                    bitmapCreateScaledBitmap.compress(compressFormat, 80, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    CloseableKt.closeFinally(byteArrayOutputStream, null);
                    bitmapCreateScaledBitmap.recycle();
                    return byteArray;
                } catch (Throwable th2) {
                    try {
                        throw th2;
                    } catch (Throwable th3) {
                        CloseableKt.closeFinally(byteArrayOutputStream, th2);
                        throw th3;
                    }
                }
            } catch (Exception unused) {
            } catch (Throwable th4) {
                th = th4;
                if (bitmapCreateScaledBitmap != null) {
                    bitmapCreateScaledBitmap.recycle();
                }
                throw th;
            }
        } catch (Exception unused2) {
            bitmapCreateScaledBitmap = null;
        } catch (Throwable th5) {
            th = th5;
            bitmapCreateScaledBitmap = null;
        }
        if (bitmapCreateScaledBitmap != null) {
            bitmapCreateScaledBitmap.recycle();
        }
        return null;
    }
}
