package io.legere.pdfiumandroid.suspend;

import io.legere.pdfiumandroid.PdfPage;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$renderPage$2$3", f = "PdfPageKt.kt", l = {}, m = "invokeSuspend")
final class PdfPageKt$renderPage$2$3 extends SuspendLambda implements Function2 {
    final /* synthetic */ long $bufferPtr;
    final /* synthetic */ long $nativeWindow;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PdfPageKt$renderPage$2$3(long j, long j2, Continuation continuation) {
        super(2, continuation);
        this.$nativeWindow = j;
        this.$bufferPtr = j2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PdfPageKt$renderPage$2$3(this.$nativeWindow, this.$bufferPtr, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((PdfPageKt$renderPage$2$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        PdfPage.INSTANCE.unlockSurface(new long[]{this.$nativeWindow, this.$bufferPtr});
        return Unit.INSTANCE;
    }
}
