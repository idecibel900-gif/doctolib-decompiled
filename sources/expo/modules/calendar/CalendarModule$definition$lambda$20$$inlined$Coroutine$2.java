package expo.modules.calendar;

import expo.modules.calendar.domain.calendar.CalendarRepository;
import expo.modules.calendar.exceptions.CalendarsNotFoundException;
import expo.modules.kotlin.exception.CodedException;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
public final class CalendarModule$definition$lambda$20$$inlined$Coroutine$2 extends SuspendLambda implements Function3 {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CalendarModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CalendarModule$definition$lambda$20$$inlined$Coroutine$2(Continuation continuation, CalendarModule calendarModule) {
        super(3, continuation);
        this.this$0 = calendarModule;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation continuation) {
        CalendarModule$definition$lambda$20$$inlined$Coroutine$2 calendarModule$definition$lambda$20$$inlined$Coroutine$2 = new CalendarModule$definition$lambda$20$$inlined$Coroutine$2(continuation, this.this$0);
        calendarModule$definition$lambda$20$$inlined$Coroutine$2.L$0 = objArr;
        return calendarModule$definition$lambda$20$$inlined$Coroutine$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws CodedException {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String str = (String) ((Object[]) this.L$0)[0];
                this.this$0.checkPermissions();
                if (str == null || !Intrinsics.areEqual(str, "reminder")) {
                    CalendarRepository calendarRepository = this.this$0.getCalendarRepository();
                    this.label = 1;
                    obj = calendarRepository.findCalendars(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    throw new CalendarsNotFoundException("Calendars of type `reminder` are not supported on Android", null);
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return (List) obj;
        } catch (Exception e) {
            throw new CalendarsNotFoundException("Calendars could not be found", e);
        }
    }
}
