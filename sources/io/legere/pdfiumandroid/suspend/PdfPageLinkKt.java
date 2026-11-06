package io.legere.pdfiumandroid.suspend;

import io.legere.pdfiumandroid.PdfPageLink;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\fJ \u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0013J\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0011J\"\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00192\u0006\u0010\u000f\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0013J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lio/legere/pdfiumandroid/suspend/PdfPageLinkKt;", "Ljava/io/Closeable;", "pageLink", "Lio/legere/pdfiumandroid/PdfPageLink;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lio/legere/pdfiumandroid/PdfPageLink;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getPageLink", "()Lio/legere/pdfiumandroid/PdfPageLink;", "countWebLinks", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getURL", "", "index", "length", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "countRects", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRect", "Landroid/graphics/RectF;", "linkIndex", "rectIndex", "getTextRange", "Lkotlin/Pair;", "close", "", "pdfiumandroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PdfPageLinkKt implements Closeable {
    private final CoroutineDispatcher dispatcher;
    private final PdfPageLink pageLink;

    public PdfPageLinkKt(PdfPageLink pageLink, CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(pageLink, "pageLink");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.pageLink = pageLink;
        this.dispatcher = dispatcher;
    }

    public final PdfPageLink getPageLink() {
        return this.pageLink;
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageLinkKt$countWebLinks$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageLinkKt$countWebLinks$2", f = "PdfPageLinkKt.kt", l = {}, m = "invokeSuspend")
    static final class C11482 extends SuspendLambda implements Function2 {
        int label;

        C11482(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfPageLinkKt.this.new C11482(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11482) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxInt(PdfPageLinkKt.this.getPageLink().countWebLinks());
        }
    }

    public final Object countWebLinks(Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11482(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageLinkKt$getURL$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageLinkKt$getURL$2", f = "PdfPageLinkKt.kt", l = {}, m = "invokeSuspend")
    static final class C11512 extends SuspendLambda implements Function2 {
        final /* synthetic */ int $index;
        final /* synthetic */ int $length;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11512(int i, int i2, Continuation continuation) {
            super(2, continuation);
            this.$index = i;
            this.$length = i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfPageLinkKt.this.new C11512(this.$index, this.$length, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11512) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageLinkKt.this.getPageLink().getURL(this.$index, this.$length);
        }
    }

    public final Object getURL(int i, int i2, Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11512(i, i2, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageLinkKt$countRects$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageLinkKt$countRects$2", f = "PdfPageLinkKt.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ int $index;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(int i, Continuation continuation) {
            super(2, continuation);
            this.$index = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfPageLinkKt.this.new AnonymousClass2(this.$index, continuation);
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
            return Boxing.boxInt(PdfPageLinkKt.this.getPageLink().countRects(this.$index));
        }
    }

    public final Object countRects(int i, Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new AnonymousClass2(i, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageLinkKt$getRect$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/RectF;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageLinkKt$getRect$2", f = "PdfPageLinkKt.kt", l = {}, m = "invokeSuspend")
    static final class C11492 extends SuspendLambda implements Function2 {
        final /* synthetic */ int $linkIndex;
        final /* synthetic */ int $rectIndex;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11492(int i, int i2, Continuation continuation) {
            super(2, continuation);
            this.$linkIndex = i;
            this.$rectIndex = i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfPageLinkKt.this.new C11492(this.$linkIndex, this.$rectIndex, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11492) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageLinkKt.this.getPageLink().getRect(this.$linkIndex, this.$rectIndex);
        }
    }

    public final Object getRect(int i, int i2, Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11492(i, i2, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageLinkKt$getTextRange$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageLinkKt$getTextRange$2", f = "PdfPageLinkKt.kt", l = {}, m = "invokeSuspend")
    static final class C11502 extends SuspendLambda implements Function2 {
        final /* synthetic */ int $index;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11502(int i, Continuation continuation) {
            super(2, continuation);
            this.$index = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfPageLinkKt.this.new C11502(this.$index, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11502) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageLinkKt.this.getPageLink().getTextRange(this.$index);
        }
    }

    public final Object getTextRange(int i, Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11502(i, null), continuation);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.pageLink.close();
    }
}
