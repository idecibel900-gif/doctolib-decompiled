package expo.modules.calendar.next.records;

import expo.modules.calendar.domain.event.enums.Availability;
import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \u00102\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0000¢\u0006\u0002\u0010\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u0011"}, d2 = {"Lexpo/modules/calendar/next/records/EventAvailability;", "Lexpo/modules/kotlin/types/Enumerable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "BUSY", "FREE", "TENTATIVE", "toAndroidValue", "", "availability", "(Lexpo/modules/calendar/next/records/EventAvailability;)Ljava/lang/Integer;", "Companion", "expo-calendar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum EventAvailability implements Enumerable {
    BUSY("busy"),
    FREE("free"),
    TENTATIVE("tentative");

    private final String value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }

    EventAvailability(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final Integer toAndroidValue(EventAvailability availability) {
        String str;
        if (availability == null || (str = availability.value) == null) {
            return null;
        }
        return Integer.valueOf(Availability.INSTANCE.fromString(str).getContentProviderValue());
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EventAvailability fromAndroidValue(Integer num) {
            if (num != null && num.intValue() == 0) {
                return EventAvailability.BUSY;
            }
            if (num != null && num.intValue() == 1) {
                return EventAvailability.FREE;
            }
            return (num != null && num.intValue() == 2) ? EventAvailability.TENTATIVE : EventAvailability.BUSY;
        }
    }
}
