package expo.modules.calendar.next.records;

import expo.modules.kotlin.types.Enumerable;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lexpo/modules/calendar/next/records/AttendeeStatus;", "Lexpo/modules/kotlin/types/Enumerable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ACCEPTED", "DECLINED", "INVITED", "TENTATIVE", "NONE", "Companion", "expo-calendar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum AttendeeStatus implements Enumerable {
    ACCEPTED("accepted"),
    DECLINED("declined"),
    INVITED("invited"),
    TENTATIVE("tentative"),
    NONE("none");

    private final String value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }

    AttendeeStatus(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AttendeeStatus fromAndroidValue(int i) {
            Object next;
            Iterator<E> it = AttendeeStatus.getEntries().iterator();
            while (it.hasNext()) {
                next = it.next();
                if (Intrinsics.areEqual(((AttendeeStatus) next).getValue(), expo.modules.calendar.domain.attendee.enums.AttendeeStatus.INSTANCE.fromContentProviderValue(i).getValue())) {
                    return (AttendeeStatus) next;
                }
            }
            next = null;
            return (AttendeeStatus) next;
        }
    }
}
