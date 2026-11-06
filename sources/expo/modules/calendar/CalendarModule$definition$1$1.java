package expo.modules.calendar;

import expo.modules.calendar.dialogs.CreateEventContract;
import expo.modules.calendar.dialogs.ViewEventContract;
import expo.modules.kotlin.activityresult.AppContextActivityResultCaller;
import expo.modules.kotlin.activityresult.AppContextActivityResultLauncher;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes4.dex */
final class CalendarModule$definition$1$1 extends SuspendLambda implements Function2 {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ CalendarModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CalendarModule$definition$1$1(CalendarModule calendarModule, Continuation continuation) {
        super(2, continuation);
        this.this$0 = calendarModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        CalendarModule$definition$1$1 calendarModule$definition$1$1 = new CalendarModule$definition$1$1(this.this$0, continuation);
        calendarModule$definition$1$1.L$0 = obj;
        return calendarModule$definition$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AppContextActivityResultCaller appContextActivityResultCaller, Continuation continuation) {
        return ((CalendarModule$definition$1$1) create(appContextActivityResultCaller, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CalendarModule calendarModule;
        CalendarModule$definition$1$1 calendarModule$definition$1$1;
        AppContextActivityResultCaller appContextActivityResultCaller;
        CalendarModule calendarModule2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                calendarModule = (CalendarModule) this.L$1;
                AppContextActivityResultCaller appContextActivityResultCaller2 = (AppContextActivityResultCaller) this.L$0;
                ResultKt.throwOnFailure(obj);
                calendarModule$definition$1$1 = this;
                appContextActivityResultCaller = appContextActivityResultCaller2;
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                calendarModule2 = (CalendarModule) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            calendarModule2.viewEventLauncher = (AppContextActivityResultLauncher) obj;
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        AppContextActivityResultCaller appContextActivityResultCaller3 = (AppContextActivityResultCaller) this.L$0;
        calendarModule = this.this$0;
        CreateEventContract createEventContract = new CreateEventContract();
        this.L$0 = appContextActivityResultCaller3;
        this.L$1 = calendarModule;
        this.label = 1;
        calendarModule$definition$1$1 = this;
        obj = AppContextActivityResultCaller.DefaultImpls.registerForActivityResult$default(appContextActivityResultCaller3, createEventContract, null, calendarModule$definition$1$1, 2, null);
        if (obj != coroutine_suspended) {
            appContextActivityResultCaller = appContextActivityResultCaller3;
        }
        return coroutine_suspended;
        calendarModule.createEventLauncher = (AppContextActivityResultLauncher) obj;
        CalendarModule calendarModule3 = calendarModule$definition$1$1.this$0;
        ViewEventContract viewEventContract = new ViewEventContract();
        calendarModule$definition$1$1.L$0 = calendarModule3;
        calendarModule$definition$1$1.L$1 = null;
        calendarModule$definition$1$1.label = 2;
        Object objRegisterForActivityResult$default = AppContextActivityResultCaller.DefaultImpls.registerForActivityResult$default(appContextActivityResultCaller, viewEventContract, null, this, 2, null);
        if (objRegisterForActivityResult$default != coroutine_suspended) {
            calendarModule2 = calendarModule3;
            obj = objRegisterForActivityResult$default;
            calendarModule2.viewEventLauncher = (AppContextActivityResultLauncher) obj;
            return Unit.INSTANCE;
        }
        return coroutine_suspended;
    }
}
