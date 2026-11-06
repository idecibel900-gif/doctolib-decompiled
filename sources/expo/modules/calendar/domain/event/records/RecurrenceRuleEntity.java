package expo.modules.calendar.domain.event.records;

import com.amazon.a.a.o.b;
import com.amazon.a.a.o.b.f;
import com.opentok.android.PublisherKit;
import expo.modules.calendar.CalendarUtils;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J<\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0011\u0012\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0011\u0012\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\u0010R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\r¨\u0006#"}, d2 = {"Lexpo/modules/calendar/domain/event/records/RecurrenceRuleEntity;", "Lexpo/modules/kotlin/records/Record;", "frequency", "", "interval", "", "occurrence", b.d, "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getFrequency$annotations", "()V", "getFrequency", "()Ljava/lang/String;", "getInterval$annotations", "getInterval", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOccurrence$annotations", "getOccurrence", "getEndDate$annotations", "getEndDate", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lexpo/modules/calendar/domain/event/records/RecurrenceRuleEntity;", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "Companion", "expo-calendar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class RecurrenceRuleEntity implements Record {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String endDate;
    private final String frequency;
    private final Integer interval;
    private final Integer occurrence;

    public static /* synthetic */ RecurrenceRuleEntity copy$default(RecurrenceRuleEntity recurrenceRuleEntity, String str, Integer num, Integer num2, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = recurrenceRuleEntity.frequency;
        }
        if ((i & 2) != 0) {
            num = recurrenceRuleEntity.interval;
        }
        if ((i & 4) != 0) {
            num2 = recurrenceRuleEntity.occurrence;
        }
        if ((i & 8) != 0) {
            str2 = recurrenceRuleEntity.endDate;
        }
        return recurrenceRuleEntity.copy(str, num, num2, str2);
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

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getEndDate() {
        return this.endDate;
    }

    public final RecurrenceRuleEntity copy(String frequency, Integer interval, Integer occurrence, String endDate) {
        Intrinsics.checkNotNullParameter(frequency, "frequency");
        return new RecurrenceRuleEntity(frequency, interval, occurrence, endDate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecurrenceRuleEntity)) {
            return false;
        }
        RecurrenceRuleEntity recurrenceRuleEntity = (RecurrenceRuleEntity) other;
        return Intrinsics.areEqual(this.frequency, recurrenceRuleEntity.frequency) && Intrinsics.areEqual(this.interval, recurrenceRuleEntity.interval) && Intrinsics.areEqual(this.occurrence, recurrenceRuleEntity.occurrence) && Intrinsics.areEqual(this.endDate, recurrenceRuleEntity.endDate);
    }

    public int hashCode() {
        int iHashCode = this.frequency.hashCode() * 31;
        Integer num = this.interval;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.occurrence;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.endDate;
        return iHashCode3 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "RecurrenceRuleEntity(frequency=" + this.frequency + ", interval=" + this.interval + ", occurrence=" + this.occurrence + ", endDate=" + this.endDate + ")";
    }

    public RecurrenceRuleEntity(String frequency, Integer num, Integer num2, String str) {
        Intrinsics.checkNotNullParameter(frequency, "frequency");
        this.frequency = frequency;
        this.interval = num;
        this.occurrence = num2;
        this.endDate = str;
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

    public final String getEndDate() {
        return this.endDate;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:26:0x00d9  */
        public final RecurrenceRuleEntity fromRuleString(String rrule) {
            String str;
            Date dateTryParseEndDate;
            Intrinsics.checkNotNullParameter(rrule, "rrule");
            List listSplit$default = StringsKt.split$default((CharSequence) rrule, new String[]{";"}, false, 0, 6, (Object) null);
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listSplit$default, 10)), 16));
            Iterator it = listSplit$default.iterator();
            while (it.hasNext()) {
                List listSplit$default2 = StringsKt.split$default((CharSequence) it.next(), new String[]{f.b}, false, 0, 6, (Object) null);
                Pair pair = new Pair((String) listSplit$default2.get(0), (String) listSplit$default2.get(1));
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            Object obj = linkedHashMap.get("FREQ");
            if (obj == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String lowerCase = ((String) obj).toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            String str2 = (String) linkedHashMap.get("INTERVAL");
            Integer numValueOf = null;
            Integer numValueOf2 = str2 != null ? Integer.valueOf(Integer.parseInt(str2)) : null;
            if (linkedHashMap.containsKey("UNTIL")) {
                String str3 = (String) linkedHashMap.get("UNTIL");
                if (str3 == null || (dateTryParseEndDate = RecurrenceRuleEntityKt.tryParseEndDate(str3)) == null) {
                    str = null;
                } else {
                    str = CalendarUtils.INSTANCE.getSdf().format(dateTryParseEndDate);
                }
            } else if (linkedHashMap.containsKey("COUNT")) {
                String str4 = (String) linkedHashMap.get("COUNT");
                numValueOf = str4 != null ? Integer.valueOf(Integer.parseInt(str4)) : null;
                str = null;
            } else {
                str = null;
            }
            return new RecurrenceRuleEntity(lowerCase, numValueOf2, numValueOf, str);
        }
    }
}
