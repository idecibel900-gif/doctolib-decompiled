package expo.modules.calendar;

import expo.modules.calendar.dialogs.ViewEventIntentResult;
import expo.modules.calendar.dialogs.ViewedEventOptions;
import expo.modules.kotlin.activityresult.AppContextActivityResultLauncher;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
public final class CalendarModule$definition$lambda$20$$inlined$Coroutine$29 extends SuspendLambda implements Function3 {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CalendarModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CalendarModule$definition$lambda$20$$inlined$Coroutine$29(Continuation continuation, CalendarModule calendarModule) {
        super(3, continuation);
        this.this$0 = calendarModule;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation continuation) {
        CalendarModule$definition$lambda$20$$inlined$Coroutine$29 calendarModule$definition$lambda$20$$inlined$Coroutine$29 = new CalendarModule$definition$lambda$20$$inlined$Coroutine$29(continuation, this.this$0);
        calendarModule$definition$lambda$20$$inlined$Coroutine$29.L$0 = objArr;
        return calendarModule$definition$lambda$20$$inlined$Coroutine$29.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ViewedEventOptions viewedEventOptions = (ViewedEventOptions) ((Object[]) this.L$0)[0];
            AppContextActivityResultLauncher appContextActivityResultLauncher = this.this$0.viewEventLauncher;
            if (appContextActivityResultLauncher == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewEventLauncher");
                appContextActivityResultLauncher = null;
            }
            this.label = 1;
            obj = appContextActivityResultLauncher.launch(viewedEventOptions, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return (ViewEventIntentResult) obj;
    }
}
