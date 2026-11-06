package expo.modules.calendar.next;

import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes4.dex */
final class ExpoCalendar$Companion$listEvents$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ExpoCalendar.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ExpoCalendar$Companion$listEvents$1(ExpoCalendar.Companion companion, Continuation continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= LinearLayoutManager.INVALID_OFFSET;
        return this.this$0.listEvents(null, null, null, null, this);
    }
}
