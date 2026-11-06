package expo.modules.calendar.next.records;

import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u0000 \u000f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u0010"}, d2 = {"Lexpo/modules/calendar/next/records/EventStatus;", "Lexpo/modules/kotlin/types/Enumerable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CONFIRMED", "TENTATIVE", "CANCELED", "toAndroidValue", "", "status", "Companion", "expo-calendar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum EventStatus implements Enumerable {
    CONFIRMED("confirmed"),
    TENTATIVE("tentative"),
    CANCELED("canceled");

    private final String value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EventStatus.values().length];
            try {
                iArr[EventStatus.CONFIRMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EventStatus.TENTATIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EventStatus.CANCELED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }

    EventStatus(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final int toAndroidValue(EventStatus status) {
        int i = status == null ? -1 : WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
        if (i != 1) {
            return i != 2 ? 2 : 0;
        }
        return 1;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EventStatus fromAndroidValue(int i) {
            if (i == 0) {
                return EventStatus.TENTATIVE;
            }
            if (i == 1) {
                return EventStatus.CONFIRMED;
            }
            if (i == 2) {
                return EventStatus.CANCELED;
            }
            return EventStatus.CANCELED;
        }
    }
}
