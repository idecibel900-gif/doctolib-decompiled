package io.legere.pdfiumandroid.suspend;

import android.graphics.RectF;
import androidx.annotation.Keep;
import io.legere.pdfiumandroid.FindFlags;
import io.legere.pdfiumandroid.FindResult;
import io.legere.pdfiumandroid.Logger;
import io.legere.pdfiumandroid.PdfTextPage;
import java.io.Closeable;
import java.util.Set;
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
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\fJ \u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0015J\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0014\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0015J.\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010\u001eJ\u001e\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0011J\u0018\u0010!\u001a\u0004\u0018\u00010\u00172\u0006\u0010\"\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0015J\u001e\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$2\u0006\u0010&\u001a\u00020'H\u0086@¢\u0006\u0002\u0010(J \u0010)\u001a\u0004\u0018\u00010\u000e2\u0006\u0010*\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010+J\u0016\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0015J.\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020\u000e2\f\u00101\u001a\b\u0012\u0004\u0012\u000203022\u0006\u0010\u000f\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u00104J\u000e\u00105\u001a\u000206H\u0086@¢\u0006\u0002\u0010\fJ\b\u00107\u001a\u000208H\u0016J\u0006\u00109\u001a\u00020:R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lio/legere/pdfiumandroid/suspend/PdfTextPageKt;", "Ljava/io/Closeable;", AuthorizationRequest.Display.PAGE, "Lio/legere/pdfiumandroid/PdfTextPage;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lio/legere/pdfiumandroid/PdfTextPage;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getPage", "()Lio/legere/pdfiumandroid/PdfTextPage;", "textPageCountChars", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "textPageGetText", "", "startIndex", "length", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "textPageGetUnicode", "", "index", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "textPageGetCharBox", "Landroid/graphics/RectF;", "textPageGetCharIndexAtPos", "x", "", "y", "xTolerance", "yTolerance", "(DDDDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "textPageCountRects", "count", "textPageGetRect", "rectIndex", "textPageGetRectsForRanges", "", "Lio/legere/pdfiumandroid/WordRangeRect;", "wordRanges", "", "([ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "textPageGetBoundedText", "rect", "(Landroid/graphics/RectF;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFontSize", "charIndex", "findStart", "Lio/legere/pdfiumandroid/suspend/FindResultKt;", "findWhat", "flags", "", "Lio/legere/pdfiumandroid/FindFlags;", "(Ljava/lang/String;Ljava/util/Set;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadWebLink", "Lio/legere/pdfiumandroid/suspend/PdfPageLinkKt;", "close", "", "safeClose", "", "pdfiumandroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PdfTextPageKt implements Closeable {
    private final CoroutineDispatcher dispatcher;
    private final PdfTextPage page;

    public PdfTextPageKt(PdfTextPage page, CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.page = page;
        this.dispatcher = dispatcher;
    }

    public final PdfTextPage getPage() {
        return this.page;
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfTextPageKt$textPageCountChars$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfTextPageKt$textPageCountChars$2", f = "PdfTextPageKt.kt", l = {}, m = "invokeSuspend")
    static final class C11542 extends SuspendLambda implements Function2 {
        int label;

        C11542(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfTextPageKt.this.new C11542(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11542) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxInt(PdfTextPageKt.this.getPage().textPageCountChars());
        }
    }

    public final Object textPageCountChars(Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11542(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfTextPageKt$textPageGetText$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfTextPageKt$textPageGetText$2", f = "PdfTextPageKt.kt", l = {}, m = "invokeSuspend")
    static final class C11612 extends SuspendLambda implements Function2 {
        final /* synthetic */ int $length;
        final /* synthetic */ int $startIndex;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11612(int i, int i2, Continuation continuation) {
            super(2, continuation);
            this.$startIndex = i;
            this.$length = i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfTextPageKt.this.new C11612(this.$startIndex, this.$length, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11612) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfTextPageKt.this.getPage().textPageGetText(this.$startIndex, this.$length);
        }
    }

    public final Object textPageGetText(int i, int i2, Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11612(i, i2, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfTextPageKt$textPageGetUnicode$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\f\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfTextPageKt$textPageGetUnicode$2", f = "PdfTextPageKt.kt", l = {}, m = "invokeSuspend")
    static final class C11622 extends SuspendLambda implements Function2 {
        final /* synthetic */ int $index;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11622(int i, Continuation continuation) {
            super(2, continuation);
            this.$index = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfTextPageKt.this.new C11622(this.$index, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11622) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxChar(PdfTextPageKt.this.getPage().textPageGetUnicode(this.$index));
        }
    }

    public final Object textPageGetUnicode(int i, Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11622(i, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfTextPageKt$textPageGetCharBox$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/RectF;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfTextPageKt$textPageGetCharBox$2", f = "PdfTextPageKt.kt", l = {}, m = "invokeSuspend")
    static final class C11572 extends SuspendLambda implements Function2 {
        final /* synthetic */ int $index;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11572(int i, Continuation continuation) {
            super(2, continuation);
            this.$index = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfTextPageKt.this.new C11572(this.$index, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11572) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfTextPageKt.this.getPage().textPageGetCharBox(this.$index);
        }
    }

    public final Object textPageGetCharBox(int i, Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11572(i, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfTextPageKt$textPageGetCharIndexAtPos$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfTextPageKt$textPageGetCharIndexAtPos$2", f = "PdfTextPageKt.kt", l = {}, m = "invokeSuspend")
    static final class C11582 extends SuspendLambda implements Function2 {
        final /* synthetic */ double $x;
        final /* synthetic */ double $xTolerance;
        final /* synthetic */ double $y;
        final /* synthetic */ double $yTolerance;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11582(double d, double d2, double d3, double d4, Continuation continuation) {
            super(2, continuation);
            this.$x = d;
            this.$y = d2;
            this.$xTolerance = d3;
            this.$yTolerance = d4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfTextPageKt.this.new C11582(this.$x, this.$y, this.$xTolerance, this.$yTolerance, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11582) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxInt(PdfTextPageKt.this.getPage().textPageGetCharIndexAtPos(this.$x, this.$y, this.$xTolerance, this.$yTolerance));
        }
    }

    public final Object textPageGetCharIndexAtPos(double d, double d2, double d3, double d4, Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11582(d, d2, d3, d4, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfTextPageKt$textPageCountRects$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfTextPageKt$textPageCountRects$2", f = "PdfTextPageKt.kt", l = {}, m = "invokeSuspend")
    static final class C11552 extends SuspendLambda implements Function2 {
        final /* synthetic */ int $count;
        final /* synthetic */ int $startIndex;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11552(int i, int i2, Continuation continuation) {
            super(2, continuation);
            this.$startIndex = i;
            this.$count = i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfTextPageKt.this.new C11552(this.$startIndex, this.$count, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11552) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxInt(PdfTextPageKt.this.getPage().textPageCountRects(this.$startIndex, this.$count));
        }
    }

    public final Object textPageCountRects(int i, int i2, Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11552(i, i2, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfTextPageKt$textPageGetRect$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/RectF;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfTextPageKt$textPageGetRect$2", f = "PdfTextPageKt.kt", l = {}, m = "invokeSuspend")
    static final class C11592 extends SuspendLambda implements Function2 {
        final /* synthetic */ int $rectIndex;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11592(int i, Continuation continuation) {
            super(2, continuation);
            this.$rectIndex = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfTextPageKt.this.new C11592(this.$rectIndex, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11592) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfTextPageKt.this.getPage().textPageGetRect(this.$rectIndex);
        }
    }

    public final Object textPageGetRect(int i, Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11592(i, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfTextPageKt$textPageGetRectsForRanges$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/legere/pdfiumandroid/WordRangeRect;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfTextPageKt$textPageGetRectsForRanges$2", f = "PdfTextPageKt.kt", l = {}, m = "invokeSuspend")
    static final class C11602 extends SuspendLambda implements Function2 {
        final /* synthetic */ int[] $wordRanges;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11602(int[] iArr, Continuation continuation) {
            super(2, continuation);
            this.$wordRanges = iArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfTextPageKt.this.new C11602(this.$wordRanges, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11602) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfTextPageKt.this.getPage().textPageGetRectsForRanges(this.$wordRanges);
        }
    }

    public final Object textPageGetRectsForRanges(int[] iArr, Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11602(iArr, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfTextPageKt$textPageGetBoundedText$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfTextPageKt$textPageGetBoundedText$2", f = "PdfTextPageKt.kt", l = {}, m = "invokeSuspend")
    static final class C11562 extends SuspendLambda implements Function2 {
        final /* synthetic */ int $length;
        final /* synthetic */ RectF $rect;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11562(RectF rectF, int i, Continuation continuation) {
            super(2, continuation);
            this.$rect = rectF;
            this.$length = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfTextPageKt.this.new C11562(this.$rect, this.$length, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11562) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfTextPageKt.this.getPage().textPageGetBoundedText(this.$rect, this.$length);
        }
    }

    public final Object textPageGetBoundedText(RectF rectF, int i, Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11562(rectF, i, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfTextPageKt$getFontSize$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0006\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfTextPageKt$getFontSize$2", f = "PdfTextPageKt.kt", l = {}, m = "invokeSuspend")
    static final class C11522 extends SuspendLambda implements Function2 {
        final /* synthetic */ int $charIndex;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11522(int i, Continuation continuation) {
            super(2, continuation);
            this.$charIndex = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfTextPageKt.this.new C11522(this.$charIndex, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11522) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxDouble(PdfTextPageKt.this.getPage().getFontSize(this.$charIndex));
        }
    }

    public final Object getFontSize(int i, Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11522(i, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfTextPageKt$findStart$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lio/legere/pdfiumandroid/suspend/FindResultKt;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfTextPageKt$findStart$2", f = "PdfTextPageKt.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $findWhat;
        final /* synthetic */ Set<FindFlags> $flags;
        final /* synthetic */ int $startIndex;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(String str, Set<? extends FindFlags> set, int i, Continuation continuation) {
            super(2, continuation);
            this.$findWhat = str;
            this.$flags = set;
            this.$startIndex = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfTextPageKt.this.new AnonymousClass2(this.$findWhat, this.$flags, this.$startIndex, continuation);
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
            FindResult findResultFindStart = PdfTextPageKt.this.getPage().findStart(this.$findWhat, this.$flags, this.$startIndex);
            if (findResultFindStart == null) {
                return null;
            }
            return new FindResultKt(findResultFindStart, PdfTextPageKt.this.dispatcher);
        }
    }

    public final Object findStart(String str, Set<? extends FindFlags> set, int i, Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new AnonymousClass2(str, set, i, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfTextPageKt$loadWebLink$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lio/legere/pdfiumandroid/suspend/PdfPageLinkKt;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfTextPageKt$loadWebLink$2", f = "PdfTextPageKt.kt", l = {}, m = "invokeSuspend")
    static final class C11532 extends SuspendLambda implements Function2 {
        int label;

        C11532(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PdfTextPageKt.this.new C11532(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11532) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return new PdfPageLinkKt(PdfTextPageKt.this.getPage().loadWebLink(), PdfTextPageKt.this.dispatcher);
        }
    }

    public final Object loadWebLink(Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11532(null), continuation);
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
            Logger.INSTANCE.e("PdfTextPageKt", e, "PdfTextPageKt.safeClose");
            return false;
        }
    }
}
