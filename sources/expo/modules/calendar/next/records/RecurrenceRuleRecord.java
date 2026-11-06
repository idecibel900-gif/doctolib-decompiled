package expo.modules.calendar.next.records;

import com.amazon.a.a.o.b;
import com.amazon.a.a.o.b.f;
import com.opentok.android.PublisherKit;
import expo.modules.calendar.next.utils.CalendarNextUtilsKt;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001#B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0016\u001a\u0004\u0018\u00010\u0000J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J>\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0006HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0013\u0012\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0013\u0012\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\u0012¨\u0006$"}, d2 = {"Lexpo/modules/calendar/next/records/RecurrenceRuleRecord;", "Lexpo/modules/kotlin/records/Record;", b.d, "", "frequency", "interval", "", "occurrence", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getEndDate$annotations", "()V", "getEndDate", "()Ljava/lang/String;", "getFrequency$annotations", "getFrequency", "getInterval$annotations", "getInterval", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOccurrence$annotations", "getOccurrence", "toRrFormat", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lexpo/modules/calendar/next/records/RecurrenceRuleRecord;", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "Companion", "expo-calendar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class RecurrenceRuleRecord implements Record {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String endDate;
    private final String frequency;
    private final Integer interval;
    private final Integer occurrence;

    public RecurrenceRuleRecord() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ RecurrenceRuleRecord copy$default(RecurrenceRuleRecord recurrenceRuleRecord, String str, String str2, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = recurrenceRuleRecord.endDate;
        }
        if ((i & 2) != 0) {
            str2 = recurrenceRuleRecord.frequency;
        }
        if ((i & 4) != 0) {
            num = recurrenceRuleRecord.interval;
        }
        if ((i & 8) != 0) {
            num2 = recurrenceRuleRecord.occurrence;
        }
        return recurrenceRuleRecord.copy(str, str2, num, num2);
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
    public final String getEndDate() {
        return this.endDate;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFrequency() {
        return this.frequency;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getInterval() {
        return this.interval;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getOccurrence() {
        return this.occurrence;
    }

    public final RecurrenceRuleRecord copy(String endDate, String frequency, Integer interval, Integer occurrence) {
        return new RecurrenceRuleRecord(endDate, frequency, interval, occurrence);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecurrenceRuleRecord)) {
            return false;
        }
        RecurrenceRuleRecord recurrenceRuleRecord = (RecurrenceRuleRecord) other;
        return Intrinsics.areEqual(this.endDate, recurrenceRuleRecord.endDate) && Intrinsics.areEqual(this.frequency, recurrenceRuleRecord.frequency) && Intrinsics.areEqual(this.interval, recurrenceRuleRecord.interval) && Intrinsics.areEqual(this.occurrence, recurrenceRuleRecord.occurrence);
    }

    public int hashCode() {
        String str = this.endDate;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.frequency;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.interval;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.occurrence;
        return iHashCode3 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        return "RecurrenceRuleRecord(endDate=" + this.endDate + ", frequency=" + this.frequency + ", interval=" + this.interval + ", occurrence=" + this.occurrence + ")";
    }

    public RecurrenceRuleRecord(String str, String str2, Integer num, Integer num2) {
        this.endDate = str;
        this.frequency = str2;
        this.interval = num;
        this.occurrence = num2;
    }

    public /* synthetic */ RecurrenceRuleRecord(String str, String str2, Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2);
    }

    public final String getEndDate() {
        return this.endDate;
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

    public final RecurrenceRuleRecord toRrFormat() {
        Date date;
        String str = this.endDate;
        return (str == null || (date = CalendarNextUtilsKt.getSdf().parse(str)) == null) ? this : copy$default(this, CalendarNextUtilsKt.getRrFormat().format(date), null, null, null, 14, null);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:26:0x0098  */
        public final RecurrenceRuleRecord fromRrFormat(String str) {
            String str2;
            String lowerCase;
            Date rrDate;
            Pair pair;
            if (str == null || StringsKt.isBlank(str)) {
                return null;
            }
            List listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{";"}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList();
            Iterator it = listSplit$default.iterator();
            while (it.hasNext()) {
                List listSplit$default2 = StringsKt.split$default((CharSequence) it.next(), new String[]{f.b}, false, 0, 6, (Object) null);
                if (listSplit$default2.size() != 2) {
                    pair = null;
                } else {
                    String str3 = (String) listSplit$default2.get(0);
                    Locale locale = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                    String upperCase = str3.toUpperCase(locale);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                    pair = TuplesKt.to(upperCase, listSplit$default2.get(1));
                }
                if (pair != null) {
                    arrayList.add(pair);
                }
            }
            Map map = MapsKt.toMap(arrayList);
            String str4 = (String) map.get("UNTIL");
            if (str4 == null) {
                str2 = null;
            } else {
                if (StringsKt.isBlank(str4)) {
                    str4 = null;
                }
                if (str4 == null || (rrDate = CalendarNextUtilsKt.parseRrDate(str4)) == null) {
                    str2 = null;
                } else {
                    str2 = CalendarNextUtilsKt.getSdf().format(rrDate);
                }
            }
            String str5 = (String) map.get("FREQ");
            if (str5 != null) {
                Locale locale2 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale2, "getDefault(...)");
                lowerCase = str5.toLowerCase(locale2);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            } else {
                lowerCase = null;
            }
            String str6 = (String) map.get("INTERVAL");
            Integer intOrNull = str6 != null ? StringsKt.toIntOrNull(str6) : null;
            String str7 = (String) map.get("COUNT");
            return new RecurrenceRuleRecord(str2, lowerCase, intOrNull, str7 != null ? StringsKt.toIntOrNull(str7) : null);
        }
    }
}
