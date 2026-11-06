package expo.modules.calendar.domain.calendar;

import android.net.Uri;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
final class CalendarRepository$deleteCalendar$rows$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ Uri $uri;
    int label;
    final /* synthetic */ CalendarRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CalendarRepository$deleteCalendar$rows$1(CalendarRepository calendarRepository, Uri uri, Continuation continuation) {
        super(2, continuation);
        this.this$0 = calendarRepository;
        this.$uri = uri;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new CalendarRepository$deleteCalendar$rows$1(this.this$0, this.$uri, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((CalendarRepository$deleteCalendar$rows$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return Boxing.boxInt(this.this$0.getContentResolver().delete(this.$uri, null, null));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
