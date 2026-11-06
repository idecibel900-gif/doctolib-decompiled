package io.legere.pdfiumandroid.suspend;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.Surface;
import androidx.annotation.Keep;
import androidx.recyclerview.widget.LinearLayoutManager;
import io.legere.pdfiumandroid.Logger;
import io.legere.pdfiumandroid.PdfDocument;
import io.legere.pdfiumandroid.PdfPage;
import io.legere.pdfiumandroid.PdfTextPage;
import io.legere.pdfiumandroid.PdfWriteCallback;
import io.legere.pdfiumandroid.PdfiumCore;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\fJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0012J$\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u00162\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0019Jp\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00100\u00162\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00162\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00162\b\b\u0002\u0010#\u001a\u00020\u001b2\b\b\u0002\u0010$\u001a\u00020\u001b2\b\b\u0002\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010(J\u000e\u0010)\u001a\u00020*H\u0086@¢\u0006\u0002\u0010\fJ\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u0016H\u0086@¢\u0006\u0002\u0010\fJ\u0016\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0010H\u0087@¢\u0006\u0002\u00100J$\u00101\u001a\b\u0012\u0004\u0012\u00020.0\u00162\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0019J\u0016\u00102\u001a\u00020\u001b2\u0006\u00103\u001a\u000204H\u0086@¢\u0006\u0002\u00105J\b\u00106\u001a\u00020\u0014H\u0016J\u0006\u00107\u001a\u00020\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lio/legere/pdfiumandroid/suspend/PdfDocumentKt;", "Ljava/io/Closeable;", "document", "Lio/legere/pdfiumandroid/PdfDocument;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lio/legere/pdfiumandroid/PdfDocument;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getDocument", "()Lio/legere/pdfiumandroid/PdfDocument;", "getPageCount", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPageCharCounts", "", "openPage", "Lio/legere/pdfiumandroid/suspend/PdfPageKt;", "pageIndex", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deletePage", "", "openPages", "", "fromIndex", "toIndex", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "renderPages", "", "surface", "Landroid/view/Surface;", "pages", "matrices", "Landroid/graphics/Matrix;", "clipRects", "Landroid/graphics/RectF;", "renderAnnot", "textMask", "canvasColor", "pageBackgroundColor", "renderCoroutinesDispatcher", "(Landroid/view/Surface;Ljava/util/List;Ljava/util/List;Ljava/util/List;ZZIILkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDocumentMeta", "Lio/legere/pdfiumandroid/PdfDocument$Meta;", "getTableOfContents", "Lio/legere/pdfiumandroid/PdfDocument$Bookmark;", "openTextPage", "Lio/legere/pdfiumandroid/suspend/PdfTextPageKt;", AuthorizationRequest.Display.PAGE, "(Lio/legere/pdfiumandroid/suspend/PdfPageKt;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openTextPages", "saveAsCopy", "callback", "Lio/legere/pdfiumandroid/PdfWriteCallback;", "(Lio/legere/pdfiumandroid/PdfWriteCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "safeClose", "pdfiumandroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PdfDocumentKt implements Closeable {
    private final CoroutineDispatcher dispatcher;
    private final PdfDocument document;

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfDocumentKt$renderPages$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfDocumentKt", f = "PdfDocumentKt.kt", l = {171, 89}, m = "renderPages")
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        boolean Z$0;
        boolean Z$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return PdfDocumentKt.this.renderPages(null, null, null, null, false, false, 0, 0, null, this);
        }
    }

    public PdfDocumentKt(PdfDocument document, CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(document, "document");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.document = document;
        this.dispatcher = dispatcher;
    }

    public final PdfDocument getDocument() {
        return this.document;
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfDocumentKt$getPageCount$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfDocumentKt$getPageCount$2", f = "PdfDocumentKt.kt", l = {}, m = "invokeSuspend")
    static final class C11222 extends SuspendLambda implements Function2 {
        int label;

        C11222(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfDocumentKt.this.new C11222(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11222) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxInt(PdfDocumentKt.this.getDocument().getPageCount());
        }
    }

    public final Object getPageCount(Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11222(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfDocumentKt$getPageCharCounts$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0015\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfDocumentKt$getPageCharCounts$2", f = "PdfDocumentKt.kt", l = {}, m = "invokeSuspend")
    static final class C11212 extends SuspendLambda implements Function2 {
        int label;

        C11212(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfDocumentKt.this.new C11212(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11212) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfDocumentKt.this.getDocument().getPageCharCounts();
        }
    }

    public final Object getPageCharCounts(Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11212(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfDocumentKt$openPage$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lio/legere/pdfiumandroid/suspend/PdfPageKt;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfDocumentKt$openPage$2", f = "PdfDocumentKt.kt", l = {}, m = "invokeSuspend")
    static final class C11242 extends SuspendLambda implements Function2 {
        final /* synthetic */ int $pageIndex;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11242(int i, Continuation continuation) {
            super(2, continuation);
            this.$pageIndex = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfDocumentKt.this.new C11242(this.$pageIndex, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11242) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return new PdfPageKt(PdfDocumentKt.this.getDocument().openPage(this.$pageIndex), PdfDocumentKt.this.dispatcher);
        }
    }

    public final Object openPage(int i, Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11242(i, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfDocumentKt$deletePage$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfDocumentKt$deletePage$2", f = "PdfDocumentKt.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ int $pageIndex;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(int i, Continuation continuation) {
            super(2, continuation);
            this.$pageIndex = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfDocumentKt.this.new AnonymousClass2(this.$pageIndex, continuation);
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
            PdfDocumentKt.this.getDocument().deletePage(this.$pageIndex);
            return Unit.INSTANCE;
        }
    }

    public final Object deletePage(int i, Continuation continuation) {
        Object objWithContext = BuildersKt.withContext(this.dispatcher, new AnonymousClass2(i, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfDocumentKt$openPages$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/legere/pdfiumandroid/suspend/PdfPageKt;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfDocumentKt$openPages$2", f = "PdfDocumentKt.kt", l = {}, m = "invokeSuspend")
    static final class C11252 extends SuspendLambda implements Function2 {
        final /* synthetic */ int $fromIndex;
        final /* synthetic */ int $toIndex;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11252(int i, int i2, Continuation continuation) {
            super(2, continuation);
            this.$fromIndex = i;
            this.$toIndex = i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfDocumentKt.this.new C11252(this.$fromIndex, this.$toIndex, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11252) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            List<PdfPage> listOpenPages = PdfDocumentKt.this.getDocument().openPages(this.$fromIndex, this.$toIndex);
            PdfDocumentKt pdfDocumentKt = PdfDocumentKt.this;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listOpenPages, 10));
            Iterator<T> it = listOpenPages.iterator();
            while (it.hasNext()) {
                arrayList.add(new PdfPageKt((PdfPage) it.next(), pdfDocumentKt.dispatcher));
            }
            return arrayList;
        }
    }

    public final Object openPages(int i, int i2, Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11252(i, i2, null), continuation);
    }

    public static /* synthetic */ Object renderPages$default(PdfDocumentKt pdfDocumentKt, Surface surface, List list, List list2, List list3, boolean z, boolean z2, int i, int i2, CoroutineDispatcher coroutineDispatcher, Continuation continuation, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            z = false;
        }
        if ((i3 & 32) != 0) {
            z2 = false;
        }
        if ((i3 & 64) != 0) {
            i = -8092540;
        }
        if ((i3 & 128) != 0) {
            i2 = -1;
        }
        return pdfDocumentKt.renderPages(surface, list, list2, list3, z, z2, i, i2, coroutineDispatcher, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object renderPages(Surface surface, List<PdfPageKt> list, List<? extends Matrix> list2, List<? extends RectF> list3, boolean z, boolean z2, int i, int i2, CoroutineDispatcher coroutineDispatcher, Continuation continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Mutex mutex;
        CoroutineDispatcher coroutineDispatcher2;
        Surface surface2;
        boolean z3;
        int i3;
        int i4;
        List<? extends Matrix> list4;
        List<? extends RectF> list5;
        boolean z4;
        PdfDocumentKt pdfDocumentKt;
        List<PdfPageKt> list6;
        Mutex mutex2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i5 = anonymousClass1.label;
            if ((i5 & LinearLayoutManager.INVALID_OFFSET) != 0) {
                anonymousClass1.label = i5 - LinearLayoutManager.INVALID_OFFSET;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objWithContext = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i6 = anonymousClass1.label;
        try {
            if (i6 == 0) {
                ResultKt.throwOnFailure(objWithContext);
                Mutex surfaceMutex = PdfiumCore.INSTANCE.getSurfaceMutex();
                anonymousClass1.L$0 = this;
                anonymousClass1.L$1 = surface;
                anonymousClass1.L$2 = list;
                anonymousClass1.L$3 = list2;
                anonymousClass1.L$4 = list3;
                anonymousClass1.L$5 = coroutineDispatcher;
                anonymousClass1.L$6 = surfaceMutex;
                anonymousClass1.Z$0 = z;
                anonymousClass1.Z$1 = z2;
                anonymousClass1.I$0 = i;
                anonymousClass1.I$1 = i2;
                anonymousClass1.label = 1;
                if (surfaceMutex.lock(null, anonymousClass1) != coroutine_suspended) {
                    mutex = surfaceMutex;
                    coroutineDispatcher2 = coroutineDispatcher;
                    surface2 = surface;
                    z3 = z2;
                    i3 = i;
                    i4 = i2;
                    list4 = list2;
                    list5 = list3;
                    z4 = z;
                    pdfDocumentKt = this;
                    list6 = list;
                }
                return coroutine_suspended;
            }
            if (i6 != 1) {
                if (i6 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutex2 = (Mutex) anonymousClass1.L$0;
                try {
                    ResultKt.throwOnFailure(objWithContext);
                    mutex2.unlock(null);
                    return objWithContext;
                } catch (Throwable th) {
                    th = th;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            int i7 = anonymousClass1.I$1;
            int i8 = anonymousClass1.I$0;
            boolean z5 = anonymousClass1.Z$1;
            boolean z6 = anonymousClass1.Z$0;
            Mutex mutex3 = (Mutex) anonymousClass1.L$6;
            CoroutineDispatcher coroutineDispatcher3 = (CoroutineDispatcher) anonymousClass1.L$5;
            List<? extends RectF> list7 = (List) anonymousClass1.L$4;
            List<? extends Matrix> list8 = (List) anonymousClass1.L$3;
            List<PdfPageKt> list9 = (List) anonymousClass1.L$2;
            Surface surface3 = (Surface) anonymousClass1.L$1;
            PdfDocumentKt pdfDocumentKt2 = (PdfDocumentKt) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objWithContext);
            list5 = list7;
            list4 = list8;
            i4 = i7;
            i3 = i8;
            mutex = mutex3;
            coroutineDispatcher2 = coroutineDispatcher3;
            list6 = list9;
            surface2 = surface3;
            z3 = z5;
            z4 = z6;
            pdfDocumentKt = pdfDocumentKt2;
            PdfDocumentKt$renderPages$2$1 pdfDocumentKt$renderPages$2$1 = new PdfDocumentKt$renderPages$2$1(pdfDocumentKt, surface2, list6, list4, list5, z4, z3, i3, i4, null);
            anonymousClass1.L$0 = mutex;
            anonymousClass1.L$1 = null;
            anonymousClass1.L$2 = null;
            anonymousClass1.L$3 = null;
            anonymousClass1.L$4 = null;
            anonymousClass1.L$5 = null;
            anonymousClass1.L$6 = null;
            anonymousClass1.label = 2;
            objWithContext = BuildersKt.withContext(coroutineDispatcher2, pdfDocumentKt$renderPages$2$1, anonymousClass1);
            if (objWithContext != coroutine_suspended) {
                mutex2 = mutex;
                mutex2.unlock(null);
                return objWithContext;
            }
            return coroutine_suspended;
        } catch (Throwable th2) {
            th = th2;
            mutex2 = mutex;
            mutex2.unlock(null);
            throw th;
        }
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfDocumentKt$getDocumentMeta$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lio/legere/pdfiumandroid/PdfDocument$Meta;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfDocumentKt$getDocumentMeta$2", f = "PdfDocumentKt.kt", l = {}, m = "invokeSuspend")
    static final class C11202 extends SuspendLambda implements Function2 {
        int label;

        C11202(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfDocumentKt.this.new C11202(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11202) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfDocumentKt.this.getDocument().getDocumentMeta();
        }
    }

    public final Object getDocumentMeta(Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11202(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfDocumentKt$getTableOfContents$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/legere/pdfiumandroid/PdfDocument$Bookmark;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfDocumentKt$getTableOfContents$2", f = "PdfDocumentKt.kt", l = {}, m = "invokeSuspend")
    static final class C11232 extends SuspendLambda implements Function2 {
        int label;

        C11232(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfDocumentKt.this.new C11232(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11232) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfDocumentKt.this.getDocument().getTableOfContents();
        }
    }

    public final Object getTableOfContents(Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11232(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfDocumentKt$openTextPage$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lio/legere/pdfiumandroid/suspend/PdfTextPageKt;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfDocumentKt$openTextPage$2", f = "PdfDocumentKt.kt", l = {}, m = "invokeSuspend")
    static final class C11262 extends SuspendLambda implements Function2 {
        final /* synthetic */ PdfPageKt $page;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11262(PdfPageKt pdfPageKt, Continuation continuation) {
            super(2, continuation);
            this.$page = pdfPageKt;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfDocumentKt.this.new C11262(this.$page, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11262) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return new PdfTextPageKt(PdfDocumentKt.this.getDocument().openTextPage(this.$page.getPage()), PdfDocumentKt.this.dispatcher);
        }
    }

    @Deprecated
    public final Object openTextPage(PdfPageKt pdfPageKt, Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11262(pdfPageKt, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfDocumentKt$openTextPages$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/legere/pdfiumandroid/suspend/PdfTextPageKt;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfDocumentKt$openTextPages$2", f = "PdfDocumentKt.kt", l = {}, m = "invokeSuspend")
    static final class C11272 extends SuspendLambda implements Function2 {
        final /* synthetic */ int $fromIndex;
        final /* synthetic */ int $toIndex;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11272(int i, int i2, Continuation continuation) {
            super(2, continuation);
            this.$fromIndex = i;
            this.$toIndex = i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfDocumentKt.this.new C11272(this.$fromIndex, this.$toIndex, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11272) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            List<PdfTextPage> listOpenTextPages = PdfDocumentKt.this.getDocument().openTextPages(this.$fromIndex, this.$toIndex);
            PdfDocumentKt pdfDocumentKt = PdfDocumentKt.this;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listOpenTextPages, 10));
            Iterator<T> it = listOpenTextPages.iterator();
            while (it.hasNext()) {
                arrayList.add(new PdfTextPageKt((PdfTextPage) it.next(), pdfDocumentKt.dispatcher));
            }
            return arrayList;
        }
    }

    public final Object openTextPages(int i, int i2, Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11272(i, i2, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfDocumentKt$saveAsCopy$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfDocumentKt$saveAsCopy$2", f = "PdfDocumentKt.kt", l = {}, m = "invokeSuspend")
    static final class C11282 extends SuspendLambda implements Function2 {
        final /* synthetic */ PdfWriteCallback $callback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11282(PdfWriteCallback pdfWriteCallback, Continuation continuation) {
            super(2, continuation);
            this.$callback = pdfWriteCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfDocumentKt.this.new C11282(this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11282) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(PdfDocument.saveAsCopy$default(PdfDocumentKt.this.getDocument(), this.$callback, 0, 2, null));
        }
    }

    public final Object saveAsCopy(PdfWriteCallback pdfWriteCallback, Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11282(pdfWriteCallback, null), continuation);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.document.close();
    }

    public final boolean safeClose() {
        try {
            this.document.close();
            return true;
        } catch (IllegalStateException e) {
            Logger.INSTANCE.e("PdfDocumentKt", e, "PdfDocumentKt.safeClose");
            return false;
        }
    }
}
