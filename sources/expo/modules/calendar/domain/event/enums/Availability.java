package expo.modules.calendar.domain.event.enums;

import expo.modules.kotlin.types.Enumerable;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \u00102\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u0011"}, d2 = {"Lexpo/modules/calendar/domain/event/enums/Availability;", "Lexpo/modules/kotlin/types/Enumerable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "FREE", "TENTATIVE", "BUSY", "contentProviderValue", "", "getContentProviderValue", "()I", "Companion", "expo-calendar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum Availability implements Enumerable {
    FREE("free"),
    TENTATIVE("tentative"),
    BUSY("busy");

    private final String value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Availability.values().length];
            try {
                iArr[Availability.FREE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Availability.TENTATIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }

    Availability(String str) {
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
                return 0;
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

        public final Availability fromString(String value) {
            Object next;
            Intrinsics.checkNotNullParameter(value, "value");
            Iterator<E> it = Availability.getEntries().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(((Availability) next).getValue(), value));
            Availability availability = (Availability) next;
            return availability == null ? Availability.BUSY : availability;
        }

        public final Availability fromContentProviderValue(int i) {
            if (i == 0) {
                return Availability.BUSY;
            }
            if (i == 1) {
                return Availability.FREE;
            }
            if (i == 2) {
                return Availability.TENTATIVE;
            }
            return Availability.BUSY;
        }
    }
}
