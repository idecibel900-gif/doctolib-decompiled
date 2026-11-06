package expo.modules.calendar.domain.calendar.enums;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \u00162\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0016B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0017"}, d2 = {"Lexpo/modules/calendar/domain/calendar/enums/CalendarAccessLevel;", "Lexpo/modules/kotlin/types/Enumerable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CONTRIBUTOR", "EDITOR", "FREEBUSY", "OVERRIDE", "OWNER", "READ", "RESPOND", "ROOT", "NONE", "contentProviderValue", "", "getContentProviderValue", "()I", "Companion", "expo-calendar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum CalendarAccessLevel implements Enumerable {
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

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CalendarAccessLevel.values().length];
            try {
                iArr[CalendarAccessLevel.CONTRIBUTOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CalendarAccessLevel.EDITOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CalendarAccessLevel.FREEBUSY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CalendarAccessLevel.OVERRIDE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[CalendarAccessLevel.OWNER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[CalendarAccessLevel.READ.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[CalendarAccessLevel.RESPOND.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[CalendarAccessLevel.ROOT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
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

    public final int getContentProviderValue() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return 500;
            case 2:
                return 600;
            case 3:
                return 100;
            case 4:
                return 400;
            case 5:
                return ColorExtractionConstants.MAXIMUM_BRIGHTNESS_THRESHOLD;
            case 6:
                return 200;
            case 7:
                return 300;
            case 8:
                return 800;
            default:
                return 0;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CalendarAccessLevel fromContentProviderValue(int i) {
            if (i == 0) {
                return CalendarAccessLevel.NONE;
            }
            if (i == 100) {
                return CalendarAccessLevel.FREEBUSY;
            }
            if (i == 200) {
                return CalendarAccessLevel.READ;
            }
            if (i == 300) {
                return CalendarAccessLevel.RESPOND;
            }
            if (i == 400) {
                return CalendarAccessLevel.OVERRIDE;
            }
            if (i == 500) {
                return CalendarAccessLevel.CONTRIBUTOR;
            }
            if (i == 600) {
                return CalendarAccessLevel.EDITOR;
            }
            if (i == 700) {
                return CalendarAccessLevel.OWNER;
            }
            if (i == 800) {
                return CalendarAccessLevel.ROOT;
            }
            return CalendarAccessLevel.NONE;
        }
    }
}
