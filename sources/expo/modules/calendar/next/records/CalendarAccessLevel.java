package expo.modules.calendar.next.records;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public enum CalendarAccessLevel {
    CONTRIBUTOR("contributor"),
    EDITOR("editor"),
    FREEBUSY("freebusy"),
    OVERRIDE("override"),
    OWNER("owner"),
    READ("read"),
    RESPOND("respond"),
    ROOT("root"),
    NONE("none");

    private final String value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final Companion Companion = new Companion(null);

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CalendarAccessLevel.values().length];
            try {
                iArr[CalendarAccessLevel.OWNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CalendarAccessLevel.EDITOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CalendarAccessLevel.CONTRIBUTOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CalendarAccessLevel.READ.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[CalendarAccessLevel.RESPOND.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[CalendarAccessLevel.FREEBUSY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[CalendarAccessLevel.OVERRIDE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[CalendarAccessLevel.ROOT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[CalendarAccessLevel.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }

    CalendarAccessLevel(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final int toAndroidValue() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return ColorExtractionConstants.MAXIMUM_BRIGHTNESS_THRESHOLD;
            case 2:
                return 600;
            case 3:
                return 500;
            case 4:
                return 200;
            case 5:
                return 300;
            case 6:
                return 100;
            case 7:
                return 400;
            case 8:
                return 800;
            case 9:
                return 0;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CalendarAccessLevel fromAccessLevelString(String str) {
            Object next;
            Iterator<E> it = CalendarAccessLevel.getEntries().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(((CalendarAccessLevel) next).getValue(), str));
            CalendarAccessLevel calendarAccessLevel = (CalendarAccessLevel) next;
            return calendarAccessLevel == null ? CalendarAccessLevel.NONE : calendarAccessLevel;
        }
    }
}
