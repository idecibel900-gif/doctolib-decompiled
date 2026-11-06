package expo.modules.video.enums;

import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lexpo/modules/video/enums/ContentType;", "Lexpo/modules/kotlin/types/Enumerable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "AUTO", "PROGRESSIVE", "HLS", "DASH", "SMOOTH_STREAMING", "toMimeTypeString", "expo-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum ContentType implements Enumerable {
    AUTO("auto"),
    PROGRESSIVE("progressive"),
    HLS("hls"),
    DASH("dash"),
    SMOOTH_STREAMING("smoothStreaming");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String value;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ContentType.values().length];
            try {
                iArr[ContentType.AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ContentType.PROGRESSIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ContentType.HLS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ContentType.DASH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ContentType.SMOOTH_STREAMING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }

    ContentType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final String toMimeTypeString() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1 || i == 2) {
            return null;
        }
        if (i == 3) {
            return "application/x-mpegURL";
        }
        if (i == 4) {
            return "application/dash+xml";
        }
        if (i != 5) {
            throw new NoWhenBranchMatchedException();
        }
        return "application/vnd.ms-sstr+xml";
    }
}
