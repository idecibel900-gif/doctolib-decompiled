package expo.modules.calendar.domain.attendee.enums;

import expo.modules.kotlin.types.Enumerable;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \u00122\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u0013"}, d2 = {"Lexpo/modules/calendar/domain/attendee/enums/AttendeeRole;", "Lexpo/modules/kotlin/types/Enumerable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ATTENDEE", "ORGANIZER", "PERFORMER", "SPEAKER", "NONE", "contentProviderValue", "", "getContentProviderValue", "()I", "Companion", "expo-calendar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum AttendeeRole implements Enumerable {
    ATTENDEE("attendee"),
    ORGANIZER("organizer"),
    PERFORMER("performer"),
    SPEAKER("speaker"),
    NONE("none");

    private final String value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AttendeeRole.values().length];
            try {
                iArr[AttendeeRole.ATTENDEE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AttendeeRole.ORGANIZER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AttendeeRole.PERFORMER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AttendeeRole.SPEAKER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AttendeeRole.NONE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }

    AttendeeRole(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final int getContentProviderValue() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    i2 = 4;
                    if (i != 4) {
                        if (i == 5) {
                            return 0;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                }
            }
        }
        return i2;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AttendeeRole fromContentProviderValue(int i) {
            if (i == 0) {
                return AttendeeRole.NONE;
            }
            if (i == 1) {
                return AttendeeRole.ATTENDEE;
            }
            if (i == 2) {
                return AttendeeRole.ORGANIZER;
            }
            if (i == 3) {
                return AttendeeRole.PERFORMER;
            }
            if (i == 4) {
                return AttendeeRole.SPEAKER;
            }
            return AttendeeRole.NONE;
        }

        public final AttendeeRole fromString(String stringValue) {
            Object next;
            Intrinsics.checkNotNullParameter(stringValue, "stringValue");
            Iterator<E> it = AttendeeRole.getEntries().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(((AttendeeRole) next).getValue(), stringValue));
            AttendeeRole attendeeRole = (AttendeeRole) next;
            return attendeeRole == null ? AttendeeRole.NONE : attendeeRole;
        }
    }
}
