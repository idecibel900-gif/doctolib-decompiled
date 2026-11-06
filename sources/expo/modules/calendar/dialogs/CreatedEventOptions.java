package expo.modules.calendar.dialogs;

import com.amazon.a.a.o.b;
import expo.modules.calendar.domain.event.enums.Availability;
import expo.modules.calendar.domain.event.records.input.RecurrenceRuleInput;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\tR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\tR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001d\u0012\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\tR\u001e\u0010!\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\tR\u001e\u0010$\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010(R\u001c\u0010)\u001a\u00020\u00198\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010,¨\u0006-"}, d2 = {"Lexpo/modules/calendar/dialogs/CreatedEventOptions;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", "<init>", "()V", b.S, "", "getTitle$annotations", "getTitle", "()Ljava/lang/String;", "location", "getLocation$annotations", "getLocation", "notes", "getNotes$annotations", "getNotes", "timeZone", "getTimeZone$annotations", "getTimeZone", "availability", "Lexpo/modules/calendar/domain/event/enums/Availability;", "getAvailability$annotations", "getAvailability", "()Lexpo/modules/calendar/domain/event/enums/Availability;", "allDay", "", "getAllDay$annotations", "getAllDay", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", b.P, "getStartDate$annotations", "getStartDate", b.d, "getEndDate$annotations", "getEndDate", "recurrenceRule", "Lexpo/modules/calendar/domain/event/records/input/RecurrenceRuleInput;", "getRecurrenceRule$annotations", "getRecurrenceRule", "()Lexpo/modules/calendar/domain/event/records/input/RecurrenceRuleInput;", "startNewActivityTask", "getStartNewActivityTask$annotations", "getStartNewActivityTask", "()Z", "expo-calendar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreatedEventOptions implements Record, Serializable {
    private final Boolean allDay;
    private final Availability availability;
    private final String endDate;
    private final String location;
    private final String notes;
    private final RecurrenceRuleInput recurrenceRule;
    private final String startDate;
    private final boolean startNewActivityTask = true;
    private final String timeZone;
    private final String title;

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
    public static /* synthetic */ void getLocation$annotations() {
    }

    @Field
    public static /* synthetic */ void getNotes$annotations() {
    }

    @Field
    public static /* synthetic */ void getRecurrenceRule$annotations() {
    }

    @Field
    public static /* synthetic */ void getStartDate$annotations() {
    }

    @Field
    public static /* synthetic */ void getStartNewActivityTask$annotations() {
    }

    @Field
    public static /* synthetic */ void getTimeZone$annotations() {
    }

    @Field
    public static /* synthetic */ void getTitle$annotations() {
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getLocation() {
        return this.location;
    }

    public final String getNotes() {
        return this.notes;
    }

    public final String getTimeZone() {
        return this.timeZone;
    }

    public final Availability getAvailability() {
        return this.availability;
    }

    public final Boolean getAllDay() {
        return this.allDay;
    }

    public final String getStartDate() {
        return this.startDate;
    }

    public final String getEndDate() {
        return this.endDate;
    }

    public final RecurrenceRuleInput getRecurrenceRule() {
        return this.recurrenceRule;
    }

    public final boolean getStartNewActivityTask() {
        return this.startNewActivityTask;
    }
}
