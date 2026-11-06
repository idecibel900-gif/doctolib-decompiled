package io.legere.pdfiumandroid.suspend;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.Surface;
import androidx.annotation.Keep;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.facebook.imageutils.JfifUtil;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import io.legere.pdfiumandroid.Logger;
import io.legere.pdfiumandroid.PdfPage;
import io.legere.pdfiumandroid.PdfiumCore;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.sync.Mutex;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u0010J\u000e\u0010\u0012\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\fJ\u000e\u0010\u0013\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\fJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0086@¢\u0006\u0002\u0010\fJ\u000e\u0010\u0016\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\fJ\u000e\u0010\u0017\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\fJ\u000e\u0010\u0019\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\fJ\u000e\u0010\u001a\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\fJ\u000e\u0010\u001b\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\fJ\u000e\u0010\u001c\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\fJ\u000e\u0010\u001d\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\fJ\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u0010JV\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u000e2\b\b\u0002\u0010(\u001a\u00020!2\b\b\u0002\u0010)\u001a\u00020\u000e2\b\b\u0002\u0010*\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010+JP\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u00182\b\b\u0002\u0010(\u001a\u00020!2\b\b\u0002\u0010.\u001a\u00020!2\b\b\u0002\u0010)\u001a\u00020\u000e2\b\b\u0002\u0010*\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010/J^\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u000e2\b\b\u0002\u0010(\u001a\u00020!2\b\b\u0002\u0010.\u001a\u00020!2\b\b\u0002\u0010)\u001a\u00020\u000e2\b\b\u0002\u0010*\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u00104JP\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\u0006\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u00182\b\b\u0002\u0010(\u001a\u00020!2\b\b\u0002\u0010.\u001a\u00020!2\b\b\u0002\u0010)\u001a\u00020\u000e2\b\b\u0002\u0010*\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u00105J\u0014\u00106\u001a\b\u0012\u0004\u0012\u00020807H\u0086@¢\u0006\u0002\u0010\fJF\u00109\u001a\u00020:2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?H\u0086@¢\u0006\u0002\u0010AJF\u0010B\u001a\u00020C2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\u000e2\u0006\u0010D\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010FJ>\u0010G\u001a\u00020H2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\u000e2\u0006\u0010I\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010JJ>\u0010K\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\u000e2\u0006\u0010I\u001a\u00020HH\u0086@¢\u0006\u0002\u0010LJ\b\u0010M\u001a\u000201H\u0016J\u0006\u0010N\u001a\u00020!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lio/legere/pdfiumandroid/suspend/PdfPageKt;", "Ljava/io/Closeable;", AuthorizationRequest.Display.PAGE, "Lio/legere/pdfiumandroid/PdfPage;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lio/legere/pdfiumandroid/PdfPage;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getPage", "()Lio/legere/pdfiumandroid/PdfPage;", "openTextPage", "Lio/legere/pdfiumandroid/suspend/PdfTextPageKt;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPageWidth", "", "screenDpi", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPageHeight", "getPageWidthPoint", "getPageHeightPoint", "getPageMatrix", "Landroid/graphics/Matrix;", "getPageRotation", "getPageCropBox", "Landroid/graphics/RectF;", "getPageMediaBox", "getPageBleedBox", "getPageTrimBox", "getPageArtBox", "getPageBoundingBox", "getPageSize", "Lio/legere/pdfiumandroid/util/Size;", "renderPage", "", "surface", "Landroid/view/Surface;", "startX", "startY", "drawSizeX", "drawSizeY", "renderAnnot", "canvasColor", "pageBackgroundColor", "(Landroid/view/Surface;IIIIZIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "matrix", "clipRect", "textMask", "(Landroid/view/Surface;Landroid/graphics/Matrix;Landroid/graphics/RectF;ZZIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "renderPageBitmap", "", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;IIIIZZIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/RectF;ZZIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPageLinks", "", "Lio/legere/pdfiumandroid/PdfDocument$Link;", "mapPageCoordsToDevice", "Landroid/graphics/Point;", "sizeX", "sizeY", "rotate", "pageX", "", "pageY", "(IIIIIDDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mapDeviceCoordsToPage", "Landroid/graphics/PointF;", "deviceX", "deviceY", "(IIIIIIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mapRectToDevice", "Landroid/graphics/Rect;", "coords", "(IIIIILandroid/graphics/RectF;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mapRectToPage", "(IIIIILandroid/graphics/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "safeClose", "pdfiumandroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PdfPageKt implements Closeable {
    private final CoroutineDispatcher dispatcher;
    private final PdfPage page;

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$renderPage$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt", f = "PdfPageKt.kt", l = {399, 167, 181, 194}, m = "renderPage")
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        int I$5;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return PdfPageKt.this.renderPage(null, 0, 0, 0, 0, false, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$renderPage$3, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt", f = "PdfPageKt.kt", l = {399, JfifUtil.MARKER_SOS, 235, 249}, m = "renderPage")
    static final class AnonymousClass3 extends ContinuationImpl {
        int I$0;
        int I$1;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        boolean Z$0;
        boolean Z$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass3(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return PdfPageKt.this.renderPage(null, null, null, false, false, 0, 0, this);
        }
    }

    public PdfPageKt(PdfPage page, CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.page = page;
        this.dispatcher = dispatcher;
    }

    public final PdfPage getPage() {
        return this.page;
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$openTextPage$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lio/legere/pdfiumandroid/suspend/PdfTextPageKt;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$openTextPage$2", f = "PdfPageKt.kt", l = {}, m = "invokeSuspend")
    static final class C11462 extends SuspendLambda implements Function2 {
        int label;

        C11462(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfPageKt.this.new C11462(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11462) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return new PdfTextPageKt(PdfPageKt.this.getPage().openTextPage(), PdfPageKt.this.dispatcher);
        }
    }

    public final Object openTextPage(Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11462(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageWidth$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageWidth$2", f = "PdfPageKt.kt", l = {}, m = "invokeSuspend")
    static final class C11402 extends SuspendLambda implements Function2 {
        final /* synthetic */ int $screenDpi;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11402(int i, Continuation continuation) {
            super(2, continuation);
            this.$screenDpi = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfPageKt.this.new C11402(this.$screenDpi, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11402) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxInt(PdfPageKt.this.getPage().getPageWidth(this.$screenDpi));
        }
    }

    public final Object getPageWidth(int i, Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11402(i, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageHeight$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageHeight$2", f = "PdfPageKt.kt", l = {}, m = "invokeSuspend")
    static final class C11322 extends SuspendLambda implements Function2 {
        final /* synthetic */ int $screenDpi;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11322(int i, Continuation continuation) {
            super(2, continuation);
            this.$screenDpi = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfPageKt.this.new C11322(this.$screenDpi, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11322) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxInt(PdfPageKt.this.getPage().getPageHeight(this.$screenDpi));
        }
    }

    public final Object getPageHeight(int i, Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11322(i, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageWidthPoint$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageWidthPoint$2", f = "PdfPageKt.kt", l = {}, m = "invokeSuspend")
    static final class C11412 extends SuspendLambda implements Function2 {
        int label;

        C11412(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfPageKt.this.new C11412(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11412) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxInt(PdfPageKt.this.getPage().getPageWidthPoint());
        }
    }

    public final Object getPageWidthPoint(Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11412(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageHeightPoint$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageHeightPoint$2", f = "PdfPageKt.kt", l = {}, m = "invokeSuspend")
    static final class C11332 extends SuspendLambda implements Function2 {
        int label;

        C11332(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfPageKt.this.new C11332(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11332) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxInt(PdfPageKt.this.getPage().getPageHeightPoint());
        }
    }

    public final Object getPageHeightPoint(Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11332(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageMatrix$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Matrix;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageMatrix$2", f = "PdfPageKt.kt", l = {}, m = "invokeSuspend")
    static final class C11352 extends SuspendLambda implements Function2 {
        int label;

        C11352(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfPageKt.this.new C11352(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11352) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageKt.this.getPage().getPageMatrix();
        }
    }

    public final Object getPageMatrix(Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11352(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageRotation$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageRotation$2", f = "PdfPageKt.kt", l = {}, m = "invokeSuspend")
    static final class C11372 extends SuspendLambda implements Function2 {
        int label;

        C11372(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfPageKt.this.new C11372(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11372) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxInt(PdfPageKt.this.getPage().getPageRotation());
        }
    }

    public final Object getPageRotation(Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11372(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageCropBox$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/RectF;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageCropBox$2", f = "PdfPageKt.kt", l = {}, m = "invokeSuspend")
    static final class C11312 extends SuspendLambda implements Function2 {
        int label;

        C11312(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfPageKt.this.new C11312(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11312) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageKt.this.getPage().getPageCropBox();
        }
    }

    public final Object getPageCropBox(Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11312(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageMediaBox$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/RectF;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageMediaBox$2", f = "PdfPageKt.kt", l = {}, m = "invokeSuspend")
    static final class C11362 extends SuspendLambda implements Function2 {
        int label;

        C11362(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfPageKt.this.new C11362(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11362) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageKt.this.getPage().getPageMediaBox();
        }
    }

    public final Object getPageMediaBox(Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11362(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageBleedBox$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/RectF;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageBleedBox$2", f = "PdfPageKt.kt", l = {}, m = "invokeSuspend")
    static final class C11292 extends SuspendLambda implements Function2 {
        int label;

        C11292(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfPageKt.this.new C11292(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11292) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageKt.this.getPage().getPageBleedBox();
        }
    }

    public final Object getPageBleedBox(Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11292(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageTrimBox$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/RectF;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageTrimBox$2", f = "PdfPageKt.kt", l = {}, m = "invokeSuspend")
    static final class C11392 extends SuspendLambda implements Function2 {
        int label;

        C11392(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfPageKt.this.new C11392(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11392) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageKt.this.getPage().getPageTrimBox();
        }
    }

    public final Object getPageTrimBox(Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11392(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageArtBox$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/RectF;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageArtBox$2", f = "PdfPageKt.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfPageKt.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageKt.this.getPage().getPageArtBox();
        }
    }

    public final Object getPageArtBox(Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new AnonymousClass2(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageBoundingBox$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/RectF;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageBoundingBox$2", f = "PdfPageKt.kt", l = {}, m = "invokeSuspend")
    static final class C11302 extends SuspendLambda implements Function2 {
        int label;

        C11302(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfPageKt.this.new C11302(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11302) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageKt.this.getPage().getPageBoundingBox();
        }
    }

    public final Object getPageBoundingBox(Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11302(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageSize$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lio/legere/pdfiumandroid/util/Size;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageSize$2", f = "PdfPageKt.kt", l = {}, m = "invokeSuspend")
    static final class C11382 extends SuspendLambda implements Function2 {
        final /* synthetic */ int $screenDpi;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11382(int i, Continuation continuation) {
            super(2, continuation);
            this.$screenDpi = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfPageKt.this.new C11382(this.$screenDpi, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11382) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageKt.this.getPage().getPageSize(this.$screenDpi);
        }
    }

    public final Object getPageSize(int i, Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11382(i, null), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:54:0x019d  */
    /* JADX WARN: Code duplicated, block: B:55:0x019e  */
    /* JADX WARN: Code duplicated, block: B:59:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:72:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r5v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.lang.Object] */
    public final Object renderPage(Surface surface, int i, int i2, int i3, int i4, boolean z, int i5, int i6, Continuation continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Mutex surfaceMutex;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z2;
        int i11;
        int i12;
        Ref$BooleanRef ref$BooleanRef;
        PdfPageKt pdfPageKt;
        Surface surface2;
        long[] jArr;
        Mutex mutex;
        int i13;
        int i14;
        int i15;
        int i16;
        boolean z3;
        int i17;
        int i18;
        Ref$BooleanRef ref$BooleanRef2;
        PdfPageKt pdfPageKt2;
        ?? r5;
        long j;
        long j2;
        CoroutineDispatcher coroutineDispatcher;
        PdfPageKt$renderPage$2$2 pdfPageKt$renderPage$2$2;
        Ref$BooleanRef ref$BooleanRef3;
        long j3;
        Ref$BooleanRef ref$BooleanRef4;
        ?? r6;
        MainCoroutineDispatcher main;
        PdfPageKt$renderPage$2$3 pdfPageKt$renderPage$2$3;
        Ref$BooleanRef ref$BooleanRef5;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i19 = anonymousClass1.label;
            if ((i19 & LinearLayoutManager.INVALID_OFFSET) != 0) {
                anonymousClass1.label = i19 - LinearLayoutManager.INVALID_OFFSET;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        ?? coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r4 = anonymousClass1.label;
        try {
            try {
                if (r4 == 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref$BooleanRef ref$BooleanRef6 = new Ref$BooleanRef();
                    surfaceMutex = PdfiumCore.INSTANCE.getSurfaceMutex();
                    anonymousClass1.L$0 = this;
                    anonymousClass1.L$1 = surface;
                    anonymousClass1.L$2 = ref$BooleanRef6;
                    anonymousClass1.L$3 = surfaceMutex;
                    i7 = i;
                    anonymousClass1.I$0 = i7;
                    i8 = i2;
                    anonymousClass1.I$1 = i8;
                    i9 = i3;
                    anonymousClass1.I$2 = i9;
                    i10 = i4;
                    anonymousClass1.I$3 = i10;
                    z2 = z;
                    anonymousClass1.Z$0 = z2;
                    i11 = i5;
                    anonymousClass1.I$4 = i11;
                    i12 = i6;
                    anonymousClass1.I$5 = i12;
                    anonymousClass1.label = 1;
                    if (surfaceMutex.lock(null, anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ref$BooleanRef = ref$BooleanRef6;
                    pdfPageKt = this;
                    surface2 = surface;
                } else {
                    if (r4 == 1) {
                        int i20 = anonymousClass1.I$5;
                        int i21 = anonymousClass1.I$4;
                        boolean z4 = anonymousClass1.Z$0;
                        int i22 = anonymousClass1.I$3;
                        int i23 = anonymousClass1.I$2;
                        int i24 = anonymousClass1.I$1;
                        int i25 = anonymousClass1.I$0;
                        Mutex mutex2 = (Mutex) anonymousClass1.L$3;
                        ref$BooleanRef = (Ref$BooleanRef) anonymousClass1.L$2;
                        surface2 = (Surface) anonymousClass1.L$1;
                        PdfPageKt pdfPageKt3 = (PdfPageKt) anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj);
                        i12 = i20;
                        surfaceMutex = mutex2;
                        i10 = i22;
                        i9 = i23;
                        pdfPageKt = pdfPageKt3;
                        i8 = i24;
                        z2 = z4;
                        i7 = i25;
                        i11 = i21;
                    } else {
                        if (r4 == 2) {
                            int i26 = anonymousClass1.I$5;
                            int i27 = anonymousClass1.I$4;
                            boolean z5 = anonymousClass1.Z$0;
                            int i28 = anonymousClass1.I$3;
                            int i29 = anonymousClass1.I$2;
                            int i30 = anonymousClass1.I$1;
                            int i31 = anonymousClass1.I$0;
                            jArr = (long[]) anonymousClass1.L$3;
                            Mutex mutex3 = (Mutex) anonymousClass1.L$2;
                            Ref$BooleanRef ref$BooleanRef7 = (Ref$BooleanRef) anonymousClass1.L$1;
                            pdfPageKt2 = (PdfPageKt) anonymousClass1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                r5 = coroutine_suspended;
                                mutex = mutex3;
                                i18 = i26;
                                ref$BooleanRef2 = ref$BooleanRef7;
                                i17 = i27;
                                z3 = z5;
                                i16 = i28;
                                i15 = i29;
                                i14 = i30;
                                i13 = i31;
                                j = jArr[0];
                                j2 = jArr[1];
                                if (j2 != 0 && j2 != -1 && j != 0 && j != -1) {
                                    coroutineDispatcher = pdfPageKt2.dispatcher;
                                    pdfPageKt$renderPage$2$2 = new PdfPageKt$renderPage$2$2(ref$BooleanRef2, pdfPageKt2, j2, i13, i14, i15, i16, z3, i17, i18, null);
                                    ref$BooleanRef3 = ref$BooleanRef2;
                                    j3 = j2;
                                    anonymousClass1.L$0 = ref$BooleanRef3;
                                    anonymousClass1.L$1 = mutex;
                                    anonymousClass1.L$2 = null;
                                    anonymousClass1.L$3 = null;
                                    anonymousClass1.J$0 = j;
                                    anonymousClass1.J$1 = j3;
                                    anonymousClass1.label = 3;
                                    if (BuildersKt.withContext(coroutineDispatcher, pdfPageKt$renderPage$2$2, anonymousClass1) == r5) {
                                        return r5;
                                    }
                                    ref$BooleanRef4 = ref$BooleanRef3;
                                    r6 = r5;
                                    main = Dispatchers.getMain();
                                    pdfPageKt$renderPage$2$3 = new PdfPageKt$renderPage$2$3(j, j3, null);
                                    anonymousClass1.L$0 = ref$BooleanRef4;
                                    anonymousClass1.L$1 = mutex;
                                    anonymousClass1.label = 4;
                                    if (BuildersKt.withContext(main, pdfPageKt$renderPage$2$3, anonymousClass1) == r6) {
                                        return r6;
                                    }
                                    ref$BooleanRef5 = ref$BooleanRef4;
                                }
                                Boolean boolBoxBoolean = Boxing.boxBoolean(false);
                                mutex.unlock(null);
                                return boolBoxBoolean;
                            } catch (Throwable th) {
                                th = th;
                                coroutine_suspended = mutex3;
                                coroutine_suspended.unlock(null);
                                throw th;
                            }
                        }
                        if (r4 == 3) {
                            j3 = anonymousClass1.J$1;
                            j = anonymousClass1.J$0;
                            Mutex mutex4 = (Mutex) anonymousClass1.L$1;
                            ref$BooleanRef4 = (Ref$BooleanRef) anonymousClass1.L$0;
                            ResultKt.throwOnFailure(obj);
                            r6 = coroutine_suspended;
                            mutex = mutex4;
                            main = Dispatchers.getMain();
                            pdfPageKt$renderPage$2$3 = new PdfPageKt$renderPage$2$3(j, j3, null);
                            anonymousClass1.L$0 = ref$BooleanRef4;
                            anonymousClass1.L$1 = mutex;
                            anonymousClass1.label = 4;
                            if (BuildersKt.withContext(main, pdfPageKt$renderPage$2$3, anonymousClass1) == r6) {
                                return r6;
                            }
                            ref$BooleanRef5 = ref$BooleanRef4;
                        } else {
                            if (r4 != 4) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            mutex = (Mutex) anonymousClass1.L$1;
                            ref$BooleanRef5 = (Ref$BooleanRef) anonymousClass1.L$0;
                            ResultKt.throwOnFailure(obj);
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    mutex.unlock(null);
                    return Boxing.boxBoolean(ref$BooleanRef5.element);
                }
                long[] jArr2 = new long[2];
                MainCoroutineDispatcher main2 = Dispatchers.getMain();
                PdfPageKt$renderPage$2$1 pdfPageKt$renderPage$2$1 = new PdfPageKt$renderPage$2$1(surface2, new int[2], jArr2, null);
                anonymousClass1.L$0 = pdfPageKt;
                anonymousClass1.L$1 = ref$BooleanRef;
                anonymousClass1.L$2 = surfaceMutex;
                anonymousClass1.L$3 = jArr2;
                anonymousClass1.I$0 = i7;
                anonymousClass1.I$1 = i8;
                anonymousClass1.I$2 = i9;
                anonymousClass1.I$3 = i10;
                anonymousClass1.Z$0 = z2;
                anonymousClass1.I$4 = i11;
                anonymousClass1.I$5 = i12;
                anonymousClass1.label = 2;
                Object objWithContext = BuildersKt.withContext(main2, pdfPageKt$renderPage$2$1, anonymousClass1);
                ?? r7 = coroutine_suspended;
                if (objWithContext == r7) {
                    return r7;
                }
                jArr = jArr2;
                mutex = surfaceMutex;
                i13 = i7;
                i14 = i8;
                i15 = i9;
                i16 = i10;
                z3 = z2;
                i17 = i11;
                i18 = i12;
                ref$BooleanRef2 = ref$BooleanRef;
                pdfPageKt2 = pdfPageKt;
                r5 = r7;
                j = jArr[0];
                j2 = jArr[1];
                if (j2 != 0) {
                    coroutineDispatcher = pdfPageKt2.dispatcher;
                    pdfPageKt$renderPage$2$2 = new PdfPageKt$renderPage$2$2(ref$BooleanRef2, pdfPageKt2, j2, i13, i14, i15, i16, z3, i17, i18, null);
                    ref$BooleanRef3 = ref$BooleanRef2;
                    j3 = j2;
                    anonymousClass1.L$0 = ref$BooleanRef3;
                    anonymousClass1.L$1 = mutex;
                    anonymousClass1.L$2 = null;
                    anonymousClass1.L$3 = null;
                    anonymousClass1.J$0 = j;
                    anonymousClass1.J$1 = j3;
                    anonymousClass1.label = 3;
                    if (BuildersKt.withContext(coroutineDispatcher, pdfPageKt$renderPage$2$2, anonymousClass1) == r5) {
                        return r5;
                    }
                    ref$BooleanRef4 = ref$BooleanRef3;
                    r6 = r5;
                    main = Dispatchers.getMain();
                    pdfPageKt$renderPage$2$3 = new PdfPageKt$renderPage$2$3(j, j3, null);
                    anonymousClass1.L$0 = ref$BooleanRef4;
                    anonymousClass1.L$1 = mutex;
                    anonymousClass1.label = 4;
                    if (BuildersKt.withContext(main, pdfPageKt$renderPage$2$3, anonymousClass1) == r6) {
                        return r6;
                    }
                    ref$BooleanRef5 = ref$BooleanRef4;
                    Unit unit2 = Unit.INSTANCE;
                    mutex.unlock(null);
                    return Boxing.boxBoolean(ref$BooleanRef5.element);
                }
                Boolean boolBoxBoolean2 = Boxing.boxBoolean(false);
                mutex.unlock(null);
                return boolBoxBoolean2;
            } catch (Throwable th2) {
                th = th2;
                coroutine_suspended = r4;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static /* synthetic */ Object renderPage$default(PdfPageKt pdfPageKt, Surface surface, Matrix matrix, RectF rectF, boolean z, boolean z2, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z = false;
        }
        if ((i3 & 16) != 0) {
            z2 = false;
        }
        if ((i3 & 32) != 0) {
            i = -8092540;
        }
        if ((i3 & 64) != 0) {
            i2 = -1;
        }
        return pdfPageKt.renderPage(surface, matrix, rectF, z, z2, i, i2, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:54:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:55:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:59:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object renderPage(Surface surface, Matrix matrix, RectF rectF, boolean z, boolean z2, int i, int i2, Continuation continuation) throws Throwable {
        AnonymousClass3 anonymousClass3;
        RectF rectF2;
        boolean z3;
        boolean z4;
        int i3;
        Ref$BooleanRef ref$BooleanRef;
        PdfPageKt pdfPageKt;
        Surface surface2;
        Mutex mutex;
        int i4;
        Matrix matrix2;
        Mutex mutex2;
        RectF rectF3;
        boolean z5;
        int i5;
        Matrix matrix3;
        Surface surface3;
        PdfPageKt pdfPageKt2;
        int[] iArr;
        Mutex mutex3;
        long[] jArr;
        int i6;
        boolean z6;
        Ref$BooleanRef ref$BooleanRef2;
        long j;
        long j2;
        int i7;
        int i8;
        CoroutineDispatcher coroutineDispatcher;
        PdfPageKt$renderPage$4$2 pdfPageKt$renderPage$4$2;
        long j3;
        Surface surface4;
        Ref$BooleanRef ref$BooleanRef3;
        Ref$BooleanRef ref$BooleanRef4;
        if (continuation instanceof AnonymousClass3) {
            anonymousClass3 = (AnonymousClass3) continuation;
            int i9 = anonymousClass3.label;
            if ((i9 & LinearLayoutManager.INVALID_OFFSET) != 0) {
                anonymousClass3.label = i9 - LinearLayoutManager.INVALID_OFFSET;
            } else {
                anonymousClass3 = new AnonymousClass3(continuation);
            }
        } else {
            anonymousClass3 = new AnonymousClass3(continuation);
        }
        Object objWithContext = anonymousClass3.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = anonymousClass3.label;
        try {
            if (i10 == 0) {
                ResultKt.throwOnFailure(objWithContext);
                Ref$BooleanRef ref$BooleanRef5 = new Ref$BooleanRef();
                Mutex surfaceMutex = PdfiumCore.INSTANCE.getSurfaceMutex();
                anonymousClass3.L$0 = this;
                anonymousClass3.L$1 = surface;
                anonymousClass3.L$2 = matrix;
                rectF2 = rectF;
                anonymousClass3.L$3 = rectF2;
                anonymousClass3.L$4 = ref$BooleanRef5;
                anonymousClass3.L$5 = surfaceMutex;
                z3 = z;
                anonymousClass3.Z$0 = z3;
                z4 = z2;
                anonymousClass3.Z$1 = z4;
                i3 = i;
                anonymousClass3.I$0 = i3;
                anonymousClass3.I$1 = i2;
                anonymousClass3.label = 1;
                if (surfaceMutex.lock(null, anonymousClass3) != coroutine_suspended) {
                    ref$BooleanRef = ref$BooleanRef5;
                    pdfPageKt = this;
                    surface2 = surface;
                    mutex = surfaceMutex;
                    i4 = i2;
                    matrix2 = matrix;
                }
                return coroutine_suspended;
            }
            if (i10 != 1) {
                if (i10 == 2) {
                    i4 = anonymousClass3.I$1;
                    int i11 = anonymousClass3.I$0;
                    z4 = anonymousClass3.Z$1;
                    boolean z7 = anonymousClass3.Z$0;
                    jArr = (long[]) anonymousClass3.L$7;
                    iArr = (int[]) anonymousClass3.L$6;
                    mutex3 = (Mutex) anonymousClass3.L$5;
                    ref$BooleanRef = (Ref$BooleanRef) anonymousClass3.L$4;
                    RectF rectF4 = (RectF) anonymousClass3.L$3;
                    Matrix matrix4 = (Matrix) anonymousClass3.L$2;
                    surface3 = (Surface) anonymousClass3.L$1;
                    pdfPageKt2 = (PdfPageKt) anonymousClass3.L$0;
                    try {
                        ResultKt.throwOnFailure(objWithContext);
                        rectF3 = rectF4;
                        matrix3 = matrix4;
                        i5 = i11;
                        z5 = z7;
                        i6 = i4;
                        z6 = z4;
                        ref$BooleanRef2 = ref$BooleanRef;
                        j = jArr[0];
                        j2 = jArr[1];
                        i7 = iArr[0];
                        i8 = iArr[1];
                        Logger.INSTANCE.d("PdfPageKt", "nativeWindow: " + j);
                        if (j2 != 0 && j2 != -1 && j != 0 && j != -1) {
                            coroutineDispatcher = pdfPageKt2.dispatcher;
                            pdfPageKt$renderPage$4$2 = new PdfPageKt$renderPage$4$2(ref$BooleanRef2, pdfPageKt2, j2, i7, i8, matrix3, rectF3, z5, z6, i5, i6, null);
                            j3 = j2;
                            anonymousClass3.L$0 = surface3;
                            anonymousClass3.L$1 = ref$BooleanRef2;
                            anonymousClass3.L$2 = mutex3;
                            anonymousClass3.L$3 = null;
                            anonymousClass3.L$4 = null;
                            anonymousClass3.L$5 = null;
                            anonymousClass3.L$6 = null;
                            anonymousClass3.L$7 = null;
                            anonymousClass3.J$0 = j;
                            anonymousClass3.J$1 = j3;
                            anonymousClass3.label = 3;
                            if (BuildersKt.withContext(coroutineDispatcher, pdfPageKt$renderPage$4$2, anonymousClass3) == coroutine_suspended) {
                                surface4 = surface3;
                                ref$BooleanRef3 = ref$BooleanRef2;
                                MainCoroutineDispatcher main = Dispatchers.getMain();
                                PdfPageKt$renderPage$4$3 pdfPageKt$renderPage$4$3 = new PdfPageKt$renderPage$4$3(surface4, j, j3, null);
                                anonymousClass3.L$0 = ref$BooleanRef3;
                                anonymousClass3.L$1 = mutex3;
                                anonymousClass3.L$2 = null;
                                anonymousClass3.label = 4;
                                objWithContext = BuildersKt.withContext(main, pdfPageKt$renderPage$4$3, anonymousClass3);
                                if (objWithContext != coroutine_suspended) {
                                    ref$BooleanRef4 = ref$BooleanRef3;
                                    mutex2 = mutex3;
                                    mutex2.unlock(null);
                                    return Boxing.boxBoolean(ref$BooleanRef4.element);
                                }
                            }
                            return coroutine_suspended;
                        }
                        Boolean boolBoxBoolean = Boxing.boxBoolean(false);
                        mutex3.unlock(null);
                        return boolBoxBoolean;
                    } catch (Throwable th) {
                        th = th;
                        mutex2 = mutex3;
                    }
                } else if (i10 == 3) {
                    j3 = anonymousClass3.J$1;
                    j = anonymousClass3.J$0;
                    Mutex mutex4 = (Mutex) anonymousClass3.L$2;
                    ref$BooleanRef3 = (Ref$BooleanRef) anonymousClass3.L$1;
                    surface4 = (Surface) anonymousClass3.L$0;
                    try {
                        ResultKt.throwOnFailure(objWithContext);
                        mutex3 = mutex4;
                        MainCoroutineDispatcher main2 = Dispatchers.getMain();
                        PdfPageKt$renderPage$4$3 pdfPageKt$renderPage$4$4 = new PdfPageKt$renderPage$4$3(surface4, j, j3, null);
                        anonymousClass3.L$0 = ref$BooleanRef3;
                        anonymousClass3.L$1 = mutex3;
                        anonymousClass3.L$2 = null;
                        anonymousClass3.label = 4;
                        objWithContext = BuildersKt.withContext(main2, pdfPageKt$renderPage$4$4, anonymousClass3);
                        if (objWithContext != coroutine_suspended) {
                            ref$BooleanRef4 = ref$BooleanRef3;
                            mutex2 = mutex3;
                            mutex2.unlock(null);
                            return Boxing.boxBoolean(ref$BooleanRef4.element);
                        }
                        return coroutine_suspended;
                    } catch (Throwable th2) {
                        th = th2;
                        mutex2 = mutex4;
                    }
                } else {
                    if (i10 != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mutex2 = (Mutex) anonymousClass3.L$1;
                    ref$BooleanRef4 = (Ref$BooleanRef) anonymousClass3.L$0;
                    try {
                        ResultKt.throwOnFailure(objWithContext);
                        mutex2.unlock(null);
                        return Boxing.boxBoolean(ref$BooleanRef4.element);
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                mutex2.unlock(null);
                throw th;
            }
            i4 = anonymousClass3.I$1;
            int i12 = anonymousClass3.I$0;
            boolean z8 = anonymousClass3.Z$1;
            boolean z9 = anonymousClass3.Z$0;
            Mutex mutex5 = (Mutex) anonymousClass3.L$5;
            Ref$BooleanRef ref$BooleanRef6 = (Ref$BooleanRef) anonymousClass3.L$4;
            RectF rectF5 = (RectF) anonymousClass3.L$3;
            matrix2 = (Matrix) anonymousClass3.L$2;
            surface2 = (Surface) anonymousClass3.L$1;
            pdfPageKt = (PdfPageKt) anonymousClass3.L$0;
            ResultKt.throwOnFailure(objWithContext);
            i3 = i12;
            mutex = mutex5;
            z3 = z9;
            rectF2 = rectF5;
            ref$BooleanRef = ref$BooleanRef6;
            z4 = z8;
            int[] iArr2 = new int[2];
            long[] jArr2 = new long[2];
            MainCoroutineDispatcher main3 = Dispatchers.getMain();
            PdfPageKt$renderPage$4$1 pdfPageKt$renderPage$4$1 = new PdfPageKt$renderPage$4$1(surface2, iArr2, jArr2, null);
            anonymousClass3.L$0 = pdfPageKt;
            anonymousClass3.L$1 = surface2;
            anonymousClass3.L$2 = matrix2;
            anonymousClass3.L$3 = rectF2;
            anonymousClass3.L$4 = ref$BooleanRef;
            anonymousClass3.L$5 = mutex;
            anonymousClass3.L$6 = iArr2;
            anonymousClass3.L$7 = jArr2;
            anonymousClass3.Z$0 = z3;
            anonymousClass3.Z$1 = z4;
            anonymousClass3.I$0 = i3;
            anonymousClass3.I$1 = i4;
            anonymousClass3.label = 2;
            coroutine_suspended = coroutine_suspended;
            if (BuildersKt.withContext(main3, pdfPageKt$renderPage$4$1, anonymousClass3) != coroutine_suspended) {
                rectF3 = rectF2;
                z5 = z3;
                i5 = i3;
                matrix3 = matrix2;
                surface3 = surface2;
                pdfPageKt2 = pdfPageKt;
                iArr = iArr2;
                mutex3 = mutex;
                jArr = jArr2;
                i6 = i4;
                z6 = z4;
                ref$BooleanRef2 = ref$BooleanRef;
                j = jArr[0];
                j2 = jArr[1];
                i7 = iArr[0];
                i8 = iArr[1];
                Logger.INSTANCE.d("PdfPageKt", "nativeWindow: " + j);
                if (j2 != 0) {
                    coroutineDispatcher = pdfPageKt2.dispatcher;
                    pdfPageKt$renderPage$4$2 = new PdfPageKt$renderPage$4$2(ref$BooleanRef2, pdfPageKt2, j2, i7, i8, matrix3, rectF3, z5, z6, i5, i6, null);
                    j3 = j2;
                    anonymousClass3.L$0 = surface3;
                    anonymousClass3.L$1 = ref$BooleanRef2;
                    anonymousClass3.L$2 = mutex3;
                    anonymousClass3.L$3 = null;
                    anonymousClass3.L$4 = null;
                    anonymousClass3.L$5 = null;
                    anonymousClass3.L$6 = null;
                    anonymousClass3.L$7 = null;
                    anonymousClass3.J$0 = j;
                    anonymousClass3.J$1 = j3;
                    anonymousClass3.label = 3;
                    if (BuildersKt.withContext(coroutineDispatcher, pdfPageKt$renderPage$4$2, anonymousClass3) == coroutine_suspended) {
                        surface4 = surface3;
                        ref$BooleanRef3 = ref$BooleanRef2;
                        MainCoroutineDispatcher main4 = Dispatchers.getMain();
                        PdfPageKt$renderPage$4$3 pdfPageKt$renderPage$4$5 = new PdfPageKt$renderPage$4$3(surface4, j, j3, null);
                        anonymousClass3.L$0 = ref$BooleanRef3;
                        anonymousClass3.L$1 = mutex3;
                        anonymousClass3.L$2 = null;
                        anonymousClass3.label = 4;
                        objWithContext = BuildersKt.withContext(main4, pdfPageKt$renderPage$4$5, anonymousClass3);
                        if (objWithContext != coroutine_suspended) {
                            ref$BooleanRef4 = ref$BooleanRef3;
                            mutex2 = mutex3;
                            mutex2.unlock(null);
                            return Boxing.boxBoolean(ref$BooleanRef4.element);
                        }
                    }
                }
                Boolean boolBoxBoolean2 = Boxing.boxBoolean(false);
                mutex3.unlock(null);
                return boolBoxBoolean2;
            }
            return coroutine_suspended;
        } catch (Throwable th4) {
            th = th4;
            mutex2 = mutex;
        }
    }

    public static /* synthetic */ Object renderPageBitmap$default(PdfPageKt pdfPageKt, Bitmap bitmap, int i, int i2, int i3, int i4, boolean z, boolean z2, int i5, int i6, Continuation continuation, int i7, Object obj) {
        if ((i7 & 32) != 0) {
            z = false;
        }
        if ((i7 & 64) != 0) {
            z2 = false;
        }
        if ((i7 & 128) != 0) {
            i5 = -8092540;
        }
        if ((i7 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0) {
            i6 = -1;
        }
        return pdfPageKt.renderPageBitmap(bitmap, i, i2, i3, i4, z, z2, i5, i6, continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$renderPageBitmap$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$renderPageBitmap$2", f = "PdfPageKt.kt", l = {}, m = "invokeSuspend")
    static final class C11472 extends SuspendLambda implements Function2 {
        final /* synthetic */ Bitmap $bitmap;
        final /* synthetic */ int $canvasColor;
        final /* synthetic */ int $drawSizeX;
        final /* synthetic */ int $drawSizeY;
        final /* synthetic */ int $pageBackgroundColor;
        final /* synthetic */ boolean $renderAnnot;
        final /* synthetic */ int $startX;
        final /* synthetic */ int $startY;
        final /* synthetic */ boolean $textMask;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11472(Bitmap bitmap, int i, int i2, int i3, int i4, boolean z, boolean z2, int i5, int i6, Continuation continuation) {
            super(2, continuation);
            this.$bitmap = bitmap;
            this.$startX = i;
            this.$startY = i2;
            this.$drawSizeX = i3;
            this.$drawSizeY = i4;
            this.$renderAnnot = z;
            this.$textMask = z2;
            this.$canvasColor = i5;
            this.$pageBackgroundColor = i6;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfPageKt.this.new C11472(this.$bitmap, this.$startX, this.$startY, this.$drawSizeX, this.$drawSizeY, this.$renderAnnot, this.$textMask, this.$canvasColor, this.$pageBackgroundColor, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11472) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            PdfPageKt.this.getPage().renderPageBitmap(this.$bitmap, this.$startX, this.$startY, this.$drawSizeX, this.$drawSizeY, this.$renderAnnot, this.$textMask, this.$canvasColor, this.$pageBackgroundColor);
            return Unit.INSTANCE;
        }
    }

    public final Object renderPageBitmap(Bitmap bitmap, int i, int i2, int i3, int i4, boolean z, boolean z2, int i5, int i6, Continuation continuation) {
        Object objWithContext = BuildersKt.withContext(this.dispatcher, new C11472(bitmap, i, i2, i3, i4, z, z2, i5, i6, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    public static /* synthetic */ Object renderPageBitmap$default(PdfPageKt pdfPageKt, Bitmap bitmap, Matrix matrix, RectF rectF, boolean z, boolean z2, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z = false;
        }
        if ((i3 & 16) != 0) {
            z2 = false;
        }
        if ((i3 & 32) != 0) {
            i = -8092540;
        }
        if ((i3 & 64) != 0) {
            i2 = -1;
        }
        return pdfPageKt.renderPageBitmap(bitmap, matrix, rectF, z, z2, i, i2, continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$renderPageBitmap$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$renderPageBitmap$4", f = "PdfPageKt.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass4 extends SuspendLambda implements Function2 {
        final /* synthetic */ Bitmap $bitmap;
        final /* synthetic */ int $canvasColor;
        final /* synthetic */ RectF $clipRect;
        final /* synthetic */ Matrix $matrix;
        final /* synthetic */ int $pageBackgroundColor;
        final /* synthetic */ boolean $renderAnnot;
        final /* synthetic */ boolean $textMask;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(Bitmap bitmap, Matrix matrix, RectF rectF, boolean z, boolean z2, int i, int i2, Continuation continuation) {
            super(2, continuation);
            this.$bitmap = bitmap;
            this.$matrix = matrix;
            this.$clipRect = rectF;
            this.$renderAnnot = z;
            this.$textMask = z2;
            this.$canvasColor = i;
            this.$pageBackgroundColor = i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfPageKt.this.new AnonymousClass4(this.$bitmap, this.$matrix, this.$clipRect, this.$renderAnnot, this.$textMask, this.$canvasColor, this.$pageBackgroundColor, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            PdfPageKt.this.getPage().renderPageBitmap(this.$bitmap, this.$matrix, this.$clipRect, this.$renderAnnot, this.$textMask, this.$canvasColor, this.$pageBackgroundColor);
            return Unit.INSTANCE;
        }
    }

    public final Object renderPageBitmap(Bitmap bitmap, Matrix matrix, RectF rectF, boolean z, boolean z2, int i, int i2, Continuation continuation) {
        Object objWithContext = BuildersKt.withContext(this.dispatcher, new AnonymousClass4(bitmap, matrix, rectF, z, z2, i, i2, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageLinks$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/legere/pdfiumandroid/PdfDocument$Link;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageLinks$2", f = "PdfPageKt.kt", l = {}, m = "invokeSuspend")
    static final class C11342 extends SuspendLambda implements Function2 {
        int label;

        C11342(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfPageKt.this.new C11342(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11342) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageKt.this.getPage().getPageLinks();
        }
    }

    public final Object getPageLinks(Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11342(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$mapPageCoordsToDevice$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Point;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$mapPageCoordsToDevice$2", f = "PdfPageKt.kt", l = {}, m = "invokeSuspend")
    static final class C11432 extends SuspendLambda implements Function2 {
        final /* synthetic */ double $pageX;
        final /* synthetic */ double $pageY;
        final /* synthetic */ int $rotate;
        final /* synthetic */ int $sizeX;
        final /* synthetic */ int $sizeY;
        final /* synthetic */ int $startX;
        final /* synthetic */ int $startY;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11432(int i, int i2, int i3, int i4, int i5, double d, double d2, Continuation continuation) {
            super(2, continuation);
            this.$startX = i;
            this.$startY = i2;
            this.$sizeX = i3;
            this.$sizeY = i4;
            this.$rotate = i5;
            this.$pageX = d;
            this.$pageY = d2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfPageKt.this.new C11432(this.$startX, this.$startY, this.$sizeX, this.$sizeY, this.$rotate, this.$pageX, this.$pageY, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11432) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageKt.this.getPage().mapPageCoordsToDevice(this.$startX, this.$startY, this.$sizeX, this.$sizeY, this.$rotate, this.$pageX, this.$pageY);
        }
    }

    public final Object mapPageCoordsToDevice(int i, int i2, int i3, int i4, int i5, double d, double d2, Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11432(i, i2, i3, i4, i5, d, d2, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$mapDeviceCoordsToPage$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/PointF;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$mapDeviceCoordsToPage$2", f = "PdfPageKt.kt", l = {}, m = "invokeSuspend")
    static final class C11422 extends SuspendLambda implements Function2 {
        final /* synthetic */ int $deviceX;
        final /* synthetic */ int $deviceY;
        final /* synthetic */ int $rotate;
        final /* synthetic */ int $sizeX;
        final /* synthetic */ int $sizeY;
        final /* synthetic */ int $startX;
        final /* synthetic */ int $startY;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11422(int i, int i2, int i3, int i4, int i5, int i6, int i7, Continuation continuation) {
            super(2, continuation);
            this.$startX = i;
            this.$startY = i2;
            this.$sizeX = i3;
            this.$sizeY = i4;
            this.$rotate = i5;
            this.$deviceX = i6;
            this.$deviceY = i7;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfPageKt.this.new C11422(this.$startX, this.$startY, this.$sizeX, this.$sizeY, this.$rotate, this.$deviceX, this.$deviceY, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11422) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageKt.this.getPage().mapDeviceCoordsToPage(this.$startX, this.$startY, this.$sizeX, this.$sizeY, this.$rotate, this.$deviceX, this.$deviceY);
        }
    }

    public final Object mapDeviceCoordsToPage(int i, int i2, int i3, int i4, int i5, int i6, int i7, Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11422(i, i2, i3, i4, i5, i6, i7, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$mapRectToDevice$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Rect;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$mapRectToDevice$2", f = "PdfPageKt.kt", l = {}, m = "invokeSuspend")
    static final class C11442 extends SuspendLambda implements Function2 {
        final /* synthetic */ RectF $coords;
        final /* synthetic */ int $rotate;
        final /* synthetic */ int $sizeX;
        final /* synthetic */ int $sizeY;
        final /* synthetic */ int $startX;
        final /* synthetic */ int $startY;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11442(int i, int i2, int i3, int i4, int i5, RectF rectF, Continuation continuation) {
            super(2, continuation);
            this.$startX = i;
            this.$startY = i2;
            this.$sizeX = i3;
            this.$sizeY = i4;
            this.$rotate = i5;
            this.$coords = rectF;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfPageKt.this.new C11442(this.$startX, this.$startY, this.$sizeX, this.$sizeY, this.$rotate, this.$coords, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11442) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageKt.this.getPage().mapRectToDevice(this.$startX, this.$startY, this.$sizeX, this.$sizeY, this.$rotate, this.$coords);
        }
    }

    public final Object mapRectToDevice(int i, int i2, int i3, int i4, int i5, RectF rectF, Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11442(i, i2, i3, i4, i5, rectF, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$mapRectToPage$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/RectF;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$mapRectToPage$2", f = "PdfPageKt.kt", l = {}, m = "invokeSuspend")
    static final class C11452 extends SuspendLambda implements Function2 {
        final /* synthetic */ Rect $coords;
        final /* synthetic */ int $rotate;
        final /* synthetic */ int $sizeX;
        final /* synthetic */ int $sizeY;
        final /* synthetic */ int $startX;
        final /* synthetic */ int $startY;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11452(int i, int i2, int i3, int i4, int i5, Rect rect, Continuation continuation) {
            super(2, continuation);
            this.$startX = i;
            this.$startY = i2;
            this.$sizeX = i3;
            this.$sizeY = i4;
            this.$rotate = i5;
            this.$coords = rect;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfPageKt.this.new C11452(this.$startX, this.$startY, this.$sizeX, this.$sizeY, this.$rotate, this.$coords, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11452) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageKt.this.getPage().mapRectToPage(this.$startX, this.$startY, this.$sizeX, this.$sizeY, this.$rotate, this.$coords);
        }
    }

    public final Object mapRectToPage(int i, int i2, int i3, int i4, int i5, Rect rect, Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11452(i, i2, i3, i4, i5, rect, null), continuation);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.page.close();
    }

    public final boolean safeClose() {
        try {
            this.page.close();
            return true;
        } catch (IllegalStateException e) {
            Logger.INSTANCE.e("PdfPageKt", e, "PdfPageKt.safeClose");
            return false;
        }
    }
}
