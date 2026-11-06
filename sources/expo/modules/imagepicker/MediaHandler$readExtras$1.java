package expo.modules.imagepicker;

import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes4.dex */
final class MediaHandler$readExtras$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MediaHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MediaHandler$readExtras$1(MediaHandler mediaHandler, Continuation continuation) {
        super(continuation);
        this.this$0 = mediaHandler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= LinearLayoutManager.INVALID_OFFSET;
        return this.this$0.readExtras$expo_image_picker_release(null, null, this);
    }
}
