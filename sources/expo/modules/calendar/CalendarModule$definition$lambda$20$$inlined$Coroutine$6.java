package expo.modules.calendar;

import expo.modules.calendar.domain.calendar.CalendarRepository;
import expo.modules.calendar.exceptions.CalendarNotDeletedException;
import expo.modules.kotlin.exception.CodedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
public final class CalendarModule$definition$lambda$20$$inlined$Coroutine$6 extends SuspendLambda implements Function3 {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CalendarModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CalendarModule$definition$lambda$20$$inlined$Coroutine$6(Continuation continuation, CalendarModule calendarModule) {
        super(3, continuation);
        this.this$0 = calendarModule;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation continuation) {
        CalendarModule$definition$lambda$20$$inlined$Coroutine$6 calendarModule$definition$lambda$20$$inlined$Coroutine$6 = new CalendarModule$definition$lambda$20$$inlined$Coroutine$6(continuation, this.this$0);
        calendarModule$definition$lambda$20$$inlined$Coroutine$6.L$0 = objArr;
        return calendarModule$definition$lambda$20$$inlined$Coroutine$6.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws CodedException {
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String str2 = (String) ((Object[]) this.L$0)[0];
            this.this$0.checkPermissions();
            CalendarRepository calendarRepository = this.this$0.getCalendarRepository();
            this.L$0 = str2;
            this.label = 1;
            Object objDeleteCalendar = calendarRepository.deleteCalendar(str2, this);
            if (objDeleteCalendar == coroutine_suspended) {
                return coroutine_suspended;
            }
            str = str2;
            obj = objDeleteCalendar;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (((Boolean) obj).booleanValue()) {
            return Unit.INSTANCE;
        }
        throw new CalendarNotDeletedException("Calendar with id '" + str + "' could not be deleted", null, 2, null);
    }
}
