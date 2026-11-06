package androidx.compose.ui.text.font;

import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes.dex */
final class AsyncFontListLoader$loadWithTimeoutOrNull$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AsyncFontListLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AsyncFontListLoader$loadWithTimeoutOrNull$1(AsyncFontListLoader asyncFontListLoader, Continuation continuation) {
        super(continuation);
        this.this$0 = asyncFontListLoader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= LinearLayoutManager.INVALID_OFFSET;
        return this.this$0.loadWithTimeoutOrNull$ui_text_release(null, this);
    }
}
