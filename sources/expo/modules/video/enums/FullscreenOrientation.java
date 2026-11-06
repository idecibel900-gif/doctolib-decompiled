package expo.modules.video.enums;

import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0012"}, d2 = {"Lexpo/modules/video/enums/FullscreenOrientation;", "Lexpo/modules/kotlin/types/Enumerable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "LANDSCAPE", "PORTRAIT", "LANDSCAPE_LEFT", "LANDSCAPE_RIGHT", "PORTRAIT_UP", "PORTRAIT_DOWN", "DEFAULT", "toActivityOrientation", "", "expo-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum FullscreenOrientation implements Enumerable {
    LANDSCAPE("landscape"),
    PORTRAIT("portrait"),
    LANDSCAPE_LEFT("landscapeLeft"),
    LANDSCAPE_RIGHT("landscapeRight"),
    PORTRAIT_UP("portraitUp"),
    PORTRAIT_DOWN("portraitDown"),
    DEFAULT("default");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String value;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FullscreenOrientation.values().length];
            try {
                iArr[FullscreenOrientation.LANDSCAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FullscreenOrientation.PORTRAIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FullscreenOrientation.LANDSCAPE_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FullscreenOrientation.LANDSCAPE_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FullscreenOrientation.PORTRAIT_UP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[FullscreenOrientation.PORTRAIT_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[FullscreenOrientation.DEFAULT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }

    FullscreenOrientation(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final int toActivityOrientation() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return 11;
            case 2:
                return 12;
            case 3:
                return 0;
            case 4:
                return 8;
            case 5:
                return 1;
            case 6:
                return 9;
            case 7:
                return -1;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
