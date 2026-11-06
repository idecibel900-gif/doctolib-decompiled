package expo.modules.calendar.dialogs;

import android.content.Context;
import android.content.Intent;
import android.provider.CalendarContract;
import com.amazon.a.a.o.b;
import expo.modules.calendar.CalendarUtils;
import expo.modules.calendar.domain.event.enums.Availability;
import expo.modules.calendar.domain.event.records.input.RecurrenceRuleInput;
import expo.modules.kotlin.activityresult.AppContextActivityResultContract;
import java.text.ParseException;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class CreateEventContract implements AppContextActivityResultContract {
    @Override // expo.modules.kotlin.activityresult.AppContextActivityResultContract
    public Intent createIntent(Context context, CreatedEventOptions input) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        Intent data = new Intent("android.intent.action.INSERT").setData(CalendarContract.Events.CONTENT_URI);
        Intrinsics.checkNotNullExpressionValue(data, "setData(...)");
        String title = input.getTitle();
        if (title != null) {
            data.putExtra(b.S, title);
        }
        Boolean allDay = input.getAllDay();
        if (allDay != null) {
            data.putExtra("allDay", allDay.booleanValue());
        }
        String notes = input.getNotes();
        if (notes != null) {
            data.putExtra(b.c, notes);
        }
        String location = input.getLocation();
        if (location != null) {
            data.putExtra("eventLocation", location);
        }
        String startDate = input.getStartDate();
        if (startDate != null) {
            data.putExtra("beginTime", getTimestamp(startDate));
        }
        String endDate = input.getEndDate();
        if (endDate != null) {
            data.putExtra("endTime", getTimestamp(endDate));
        }
        String timeZone = input.getTimeZone();
        if (timeZone != null) {
            data.putExtra("eventTimezone", timeZone);
        }
        Availability availability = input.getAvailability();
        if (availability != null) {
            data.putExtra("availability", availability.getContentProviderValue());
        }
        RecurrenceRuleInput recurrenceRule = input.getRecurrenceRule();
        if (recurrenceRule != null) {
            data.putExtra("rrule", recurrenceRule.toRuleString());
        }
        boolean startNewActivityTask = input.getStartNewActivityTask();
        Boolean boolValueOf = Boolean.valueOf(startNewActivityTask);
        if (!startNewActivityTask) {
            boolValueOf = null;
        }
        if (boolValueOf != null) {
            data.addFlags(268435456);
        }
        return data;
    }

    private final long getTimestamp(String str) throws ParseException {
        Date date = CalendarUtils.INSTANCE.getSdf().parse(str);
        Long lValueOf = date != null ? Long.valueOf(date.getTime()) : null;
        if (lValueOf != null) {
            return lValueOf.longValue();
        }
        throw new IllegalArgumentException("Invalid date format");
    }

    @Override // expo.modules.kotlin.activityresult.AppContextActivityResultContract
    public CreateEventIntentResult parseResult(CreatedEventOptions input, int i, Intent intent) {
        Intrinsics.checkNotNullParameter(input, "input");
        return new CreateEventIntentResult(null, 1, null);
    }
}
