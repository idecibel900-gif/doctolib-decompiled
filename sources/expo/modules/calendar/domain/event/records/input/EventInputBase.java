package expo.modules.calendar.domain.event.records.input;

import android.content.ContentValues;
import com.amazon.a.a.o.b;
import expo.modules.calendar.domain.event.enums.Availability;
import expo.modules.calendar.domain.event.enums.EventAccessLevel;
import expo.modules.calendar.domain.event.records.Alarm;
import expo.modules.calendar.extensions.EitherExtensionsKt;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.types.Either;
import java.util.List;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class EventInputBase {
    private final EventAccessLevel accessLevel;
    private final List<Alarm> alarms;
    private final Boolean allDay;
    private final Availability availability;
    private final Either<String, Long> endDate;
    private final String endTimeZone;
    private final Boolean guestsCanInviteOthers;
    private final Boolean guestsCanModify;
    private final Boolean guestsCanSeeGuests;
    private final String location;
    private final String notes;
    private final String organizerEmail;
    private final RecurrenceRuleInput recurrenceRule;
    private final Either<String, Long> startDate;
    private final String timeZone;
    private final String title;

    @Field
    public static /* synthetic */ void getAccessLevel$annotations() {
    }

    @Field
    public static /* synthetic */ void getAlarms$annotations() {
    }

    @Field
    public static /* synthetic */ void getAllDay$annotations() {
    }

    @Field
    public static /* synthetic */ void getAvailability$annotations() {
    }

    @Field
    public static /* synthetic */ void getEndDate$annotations() {
    }

    @Field
    public static /* synthetic */ void getEndTimeZone$annotations() {
    }

    @Field
    public static /* synthetic */ void getGuestsCanInviteOthers$annotations() {
    }

    @Field
    public static /* synthetic */ void getGuestsCanModify$annotations() {
    }

    @Field
    public static /* synthetic */ void getGuestsCanSeeGuests$annotations() {
    }

    @Field
    public static /* synthetic */ void getLocation$annotations() {
    }

    @Field
    public static /* synthetic */ void getNotes$annotations() {
    }

    @Field
    public static /* synthetic */ void getOrganizerEmail$annotations() {
    }

    @Field
    public static /* synthetic */ void getRecurrenceRule$annotations() {
    }

    @Field
    public static /* synthetic */ void getStartDate$annotations() {
    }

    @Field
    public static /* synthetic */ void getTimeZone$annotations() {
    }

    @Field
    public static /* synthetic */ void getTitle$annotations() {
    }

    public final List<Alarm> getAlarms() {
        return this.alarms;
    }

    public final Availability getAvailability() {
        return this.availability;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getNotes() {
        return this.notes;
    }

    public final String getLocation() {
        return this.location;
    }

    public final String getOrganizerEmail() {
        return this.organizerEmail;
    }

    public final Boolean getAllDay() {
        return this.allDay;
    }

    public final Boolean getGuestsCanModify() {
        return this.guestsCanModify;
    }

    public final Boolean getGuestsCanInviteOthers() {
        return this.guestsCanInviteOthers;
    }

    public final Boolean getGuestsCanSeeGuests() {
        return this.guestsCanSeeGuests;
    }

    public final String getTimeZone() {
        return this.timeZone;
    }

    public final String getEndTimeZone() {
        return this.endTimeZone;
    }

    public final EventAccessLevel getAccessLevel() {
        return this.accessLevel;
    }

    public final RecurrenceRuleInput getRecurrenceRule() {
        return this.recurrenceRule;
    }

    public final Either<String, Long> getStartDate() {
        return this.startDate;
    }

    public final Either<String, Long> getEndDate() {
        return this.endDate;
    }

    public final ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        Either<String, Long> either = this.startDate;
        if (either != null) {
            contentValues.put("dtstart", EitherExtensionsKt.getTimeInMillis(either));
        }
        Either<String, Long> either2 = this.endDate;
        if (either2 != null) {
            contentValues.put("dtend", EitherExtensionsKt.getTimeInMillis(either2));
        }
        RecurrenceRuleInput recurrenceRuleInput = this.recurrenceRule;
        if (recurrenceRuleInput != null && recurrenceRuleInput.getFrequency().length() != 0) {
            if (recurrenceRuleInput.getEndDate() == null && recurrenceRuleInput.getOccurrence() == null) {
                Long asLong = contentValues.getAsLong("dtstart");
                long jLongValue = contentValues.getAsLong("dtend").longValue();
                Intrinsics.checkNotNull(asLong);
                long jLongValue2 = (jLongValue - asLong.longValue()) / ((long) 1000);
                contentValues.putNull("lastDate");
                contentValues.putNull("dtend");
                contentValues.put("duration", "PT" + jLongValue2 + "S");
            }
            contentValues.put("rrule", recurrenceRuleInput.toRuleString());
        }
        if (this.alarms != null) {
            contentValues.put("hasAlarm", Boolean.TRUE);
        }
        Availability availability = this.availability;
        if (availability != null) {
            contentValues.put("availability", Integer.valueOf(availability.getContentProviderValue()));
        }
        String str = this.title;
        if (str != null) {
            contentValues.put(b.S, str);
        }
        String str2 = this.notes;
        if (str2 != null) {
            contentValues.put(b.c, str2);
        }
        String str3 = this.location;
        if (str3 != null) {
            contentValues.put("eventLocation", str3);
        }
        String str4 = this.organizerEmail;
        if (str4 != null) {
            contentValues.put("organizer", str4);
        }
        Boolean bool = this.allDay;
        if (bool != null) {
            contentValues.put("allDay", bool);
        }
        Boolean bool2 = this.guestsCanModify;
        if (bool2 != null) {
            contentValues.put("guestsCanModify", bool2);
        }
        Boolean bool3 = this.guestsCanInviteOthers;
        if (bool3 != null) {
            contentValues.put("guestsCanInviteOthers", bool3);
        }
        Boolean bool4 = this.guestsCanSeeGuests;
        if (bool4 != null) {
            contentValues.put("guestsCanSeeGuests", bool4);
        }
        EventAccessLevel eventAccessLevel = this.accessLevel;
        if (eventAccessLevel != null) {
            contentValues.put("accessLevel", Integer.valueOf(eventAccessLevel.getContentProviderValue()));
        }
        String id = TimeZone.getDefault().getID();
        String str5 = this.timeZone;
        if (str5 == null) {
            str5 = id;
        }
        contentValues.put("eventTimezone", str5);
        String str6 = this.endTimeZone;
        if (str6 != null) {
            id = str6;
        }
        contentValues.put("eventEndTimezone", id);
        return contentValues;
    }
}
