package expo.modules.calendar.domain.attendee.enums;

import expo.modules.kotlin.types.Enumerable;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \u00112\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u0012"}, d2 = {"Lexpo/modules/calendar/domain/attendee/enums/AttendeeType;", "Lexpo/modules/kotlin/types/Enumerable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "OPTIONAL", "REQUIRED", "RESOURCE", "NONE", "contentProviderValue", "", "getContentProviderValue", "()I", "Companion", "expo-calendar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum AttendeeType implements Enumerable {
    OPTIONAL("optional"),
    REQUIRED("required"),
    RESOURCE("resource"),
    NONE("none");

    private final String value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AttendeeType.values().length];
            try {
                iArr[AttendeeType.OPTIONAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AttendeeType.REQUIRED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AttendeeType.RESOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }

    AttendeeType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final int getContentProviderValue() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return i != 3 ? 0 : 3;
        }
        return 1;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AttendeeType fromContentProviderValue(int i) {
            if (i == 0) {
                return AttendeeType.NONE;
            }
            if (i == 1) {
                return AttendeeType.REQUIRED;
            }
            if (i == 2) {
                return AttendeeType.OPTIONAL;
            }
            if (i == 3) {
                return AttendeeType.RESOURCE;
            }
            return AttendeeType.NONE;
        }

        public final AttendeeType fromString(String stringValue) {
            Object next;
            Intrinsics.checkNotNullParameter(stringValue, "stringValue");
            Iterator<E> it = AttendeeType.getEntries().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(((AttendeeType) next).getValue(), stringValue));
            AttendeeType attendeeType = (AttendeeType) next;
            return attendeeType == null ? AttendeeType.NONE : attendeeType;
        }
    }
}
