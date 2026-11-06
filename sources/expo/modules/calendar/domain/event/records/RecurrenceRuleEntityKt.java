package expo.modules.calendar.domain.event.records;

import expo.modules.calendar.CalendarUtils;
import java.util.Date;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes4.dex */
public abstract class RecurrenceRuleEntityKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Date tryParseEndDate(String str) {
        Object objM5243constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            objM5243constructorimpl = Result.m5243constructorimpl(CalendarUtils.INSTANCE.getRecurrenceRuleSDF().parse(str));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            objM5243constructorimpl = Result.m5243constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m5246exceptionOrNullimpl(objM5243constructorimpl) != null) {
            objM5243constructorimpl = Result.m5243constructorimpl(CalendarUtils.INSTANCE.getAllDayRecurrenceSDF().parse(str));
        }
        if (Result.m5248isFailureimpl(objM5243constructorimpl)) {
            objM5243constructorimpl = null;
        }
        return (Date) objM5243constructorimpl;
    }
}
