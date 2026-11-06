package io.legere.pdfiumandroid.suspend;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.Surface;
import io.legere.pdfiumandroid.PdfDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfDocumentKt$renderPages$2$1", f = "PdfDocumentKt.kt", l = {}, m = "invokeSuspend")
final class PdfDocumentKt$renderPages$2$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ int $canvasColor;
    final /* synthetic */ List<RectF> $clipRects;
    final /* synthetic */ List<Matrix> $matrices;
    final /* synthetic */ int $pageBackgroundColor;
    final /* synthetic */ List<PdfPageKt> $pages;
    final /* synthetic */ boolean $renderAnnot;
    final /* synthetic */ Surface $surface;
    final /* synthetic */ boolean $textMask;
    int label;
    final /* synthetic */ PdfDocumentKt this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    PdfDocumentKt$renderPages$2$1(PdfDocumentKt pdfDocumentKt, Surface surface, List<PdfPageKt> list, List<? extends Matrix> list2, List<? extends RectF> list3, boolean z, boolean z2, int i, int i2, Continuation continuation) {
        super(2, continuation);
        this.this$0 = pdfDocumentKt;
        this.$surface = surface;
        this.$pages = list;
        this.$matrices = list2;
        this.$clipRects = list3;
        this.$renderAnnot = z;
        this.$textMask = z2;
        this.$canvasColor = i;
        this.$pageBackgroundColor = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PdfDocumentKt$renderPages$2$1(this.this$0, this.$surface, this.$pages, this.$matrices, this.$clipRects, this.$renderAnnot, this.$textMask, this.$canvasColor, this.$pageBackgroundColor, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((PdfDocumentKt$renderPages$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        PdfDocument document = this.this$0.getDocument();
        Surface surface = this.$surface;
        List<PdfPageKt> list = this.$pages;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((PdfPageKt) it.next()).getPage());
        }
        return Boxing.boxBoolean(document.renderPages(surface, arrayList, this.$matrices, this.$clipRects, this.$renderAnnot, this.$textMask, this.$canvasColor, this.$pageBackgroundColor));
    }
}
