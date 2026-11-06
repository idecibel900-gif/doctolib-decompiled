package expo.modules.calendar.domain.event.records.input;

import com.amazon.a.a.o.b;
import com.opentok.android.PublisherKit;
import expo.modules.calendar.CalendarUtils;
import expo.modules.calendar.extensions.EitherExtensionsKt;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.types.Either;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0004\u0018\u0001`\n¢\u0006\u0004\b\u000b\u0010\fJ\n\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u0002J\u0006\u0010\u001b\u001a\u00020\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u001d\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0004\u0018\u0001`\nHÆ\u0003JN\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0004\u0018\u0001`\nHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u0005HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0014\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0013R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0014\u0012\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0013R0\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0004\u0018\u0001`\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0019¨\u0006("}, d2 = {"Lexpo/modules/calendar/domain/event/records/input/RecurrenceRuleInput;", "Lexpo/modules/kotlin/records/Record;", "frequency", "", "interval", "", "occurrence", b.d, "Lexpo/modules/kotlin/types/Either;", "", "Lexpo/modules/calendar/extensions/DateTimeInput;", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lexpo/modules/kotlin/types/Either;)V", "getFrequency$annotations", "()V", "getFrequency", "()Ljava/lang/String;", "getInterval$annotations", "getInterval", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOccurrence$annotations", "getOccurrence", "getEndDate$annotations", "getEndDate", "()Lexpo/modules/kotlin/types/Either;", "ruleEndDate", "toRuleString", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lexpo/modules/kotlin/types/Either;)Lexpo/modules/calendar/domain/event/records/input/RecurrenceRuleInput;", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "expo-calendar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class RecurrenceRuleInput implements Record {
    private final Either<String, Long> endDate;
    private final String frequency;
    private final Integer interval;
    private final Integer occurrence;

    public RecurrenceRuleInput() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RecurrenceRuleInput copy$default(RecurrenceRuleInput recurrenceRuleInput, String str, Integer num, Integer num2, Either either, int i, Object obj) {
        if ((i & 1) != 0) {
            str = recurrenceRuleInput.frequency;
        }
        if ((i & 2) != 0) {
            num = recurrenceRuleInput.interval;
        }
        if ((i & 4) != 0) {
            num2 = recurrenceRuleInput.occurrence;
        }
        if ((i & 8) != 0) {
            either = recurrenceRuleInput.endDate;
        }
        return recurrenceRuleInput.copy(str, num, num2, either);
    }

    @Field
    public static /* synthetic */ void getEndDate$annotations() {
    }

    @Field
    public static /* synthetic */ void getFrequency$annotations() {
    }

    @Field
    public static /* synthetic */ void getInterval$annotations() {
    }

    @Field
    public static /* synthetic */ void getOccurrence$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFrequency() {
        return this.frequency;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getInterval() {
        return this.interval;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getOccurrence() {
        return this.occurrence;
    }

    public final Either<String, Long> component4() {
        return this.endDate;
    }

    public final RecurrenceRuleInput copy(String frequency, Integer interval, Integer occurrence, Either<String, Long> endDate) {
        Intrinsics.checkNotNullParameter(frequency, "frequency");
        return new RecurrenceRuleInput(frequency, interval, occurrence, endDate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecurrenceRuleInput)) {
            return false;
        }
        RecurrenceRuleInput recurrenceRuleInput = (RecurrenceRuleInput) other;
        return Intrinsics.areEqual(this.frequency, recurrenceRuleInput.frequency) && Intrinsics.areEqual(this.interval, recurrenceRuleInput.interval) && Intrinsics.areEqual(this.occurrence, recurrenceRuleInput.occurrence) && Intrinsics.areEqual(this.endDate, recurrenceRuleInput.endDate);
    }

    public int hashCode() {
        int iHashCode = this.frequency.hashCode() * 31;
        Integer num = this.interval;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.occurrence;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Either<String, Long> either = this.endDate;
        return iHashCode3 + (either != null ? either.hashCode() : 0);
    }

    public String toString() {
        return "RecurrenceRuleInput(frequency=" + this.frequency + ", interval=" + this.interval + ", occurrence=" + this.occurrence + ", endDate=" + this.endDate + ")";
    }

    public RecurrenceRuleInput(String frequency, Integer num, Integer num2, Either<String, Long> either) {
        Intrinsics.checkNotNullParameter(frequency, "frequency");
        this.frequency = frequency;
        this.interval = num;
        this.occurrence = num2;
        this.endDate = either;
    }

    public /* synthetic */ RecurrenceRuleInput(String str, Integer num, Integer num2, Either either, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : either);
    }

    public final String getFrequency() {
        return this.frequency;
    }

    public final Integer getInterval() {
        return this.interval;
    }

    public final Integer getOccurrence() {
        return this.occurrence;
    }

    public final Either<String, Long> getEndDate() {
        return this.endDate;
    }

    private final String ruleEndDate() {
        Long timeInMillis;
        Either<String, Long> either = this.endDate;
        if (either == null || (timeInMillis = EitherExtensionsKt.getTimeInMillis(either)) == null) {
            return null;
        }
        long jLongValue = timeInMillis.longValue();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(jLongValue);
        return CalendarUtils.INSTANCE.getRecurrenceRuleSDF().format(calendar.getTime());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:19:0x0036  */
    public final String toRuleString() {
        String str;
        switch (this.frequency) {
            case "weekly":
                str = "FREQ=WEEKLY";
                break;
            case "yearly":
                str = "FREQ=YEARLY";
                break;
            case "daily":
                str = "FREQ=DAILY";
                break;
            case "monthly":
                str = "FREQ=MONTHLY";
                break;
            default:
                str = "";
                break;
        }
        Integer num = this.interval;
        if (num != null) {
            str = str + ";INTERVAL=" + num;
        }
        String strRuleEndDate = ruleEndDate();
        if (strRuleEndDate != null) {
            return str + ";UNTIL=" + strRuleEndDate;
        }
        Integer num2 = this.occurrence;
        if (num2 == null) {
            return str;
        }
        return str + ";COUNT=" + num2;
    }
}
