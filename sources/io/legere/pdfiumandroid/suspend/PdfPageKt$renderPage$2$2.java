package io.legere.pdfiumandroid.suspend;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$renderPage$2$2", f = "PdfPageKt.kt", l = {}, m = "invokeSuspend")
final class PdfPageKt$renderPage$2$2 extends SuspendLambda implements Function2 {
    final /* synthetic */ long $bufferPtr;
    final /* synthetic */ int $canvasColor;
    final /* synthetic */ int $drawSizeX;
    final /* synthetic */ int $drawSizeY;
    final /* synthetic */ int $pageBackgroundColor;
    final /* synthetic */ boolean $renderAnnot;
    final /* synthetic */ Ref$BooleanRef $retValue;
    final /* synthetic */ int $startX;
    final /* synthetic */ int $startY;
    int label;
    final /* synthetic */ PdfPageKt this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PdfPageKt$renderPage$2$2(Ref$BooleanRef ref$BooleanRef, PdfPageKt pdfPageKt, long j, int i, int i2, int i3, int i4, boolean z, int i5, int i6, Continuation continuation) {
        super(2, continuation);
        this.$retValue = ref$BooleanRef;
        this.this$0 = pdfPageKt;
        this.$bufferPtr = j;
        this.$startX = i;
        this.$startY = i2;
        this.$drawSizeX = i3;
        this.$drawSizeY = i4;
        this.$renderAnnot = z;
        this.$canvasColor = i5;
        this.$pageBackgroundColor = i6;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PdfPageKt$renderPage$2$2(this.$retValue, this.this$0, this.$bufferPtr, this.$startX, this.$startY, this.$drawSizeX, this.$drawSizeY, this.$renderAnnot, this.$canvasColor, this.$pageBackgroundColor, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((PdfPageKt$renderPage$2$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$retValue.element = this.this$0.getPage().renderPage(this.$bufferPtr, this.$startX, this.$startY, this.$drawSizeX, this.$drawSizeY, this.$renderAnnot, this.$canvasColor, this.$pageBackgroundColor);
        return Unit.INSTANCE;
    }
}
