package expo.modules.video.enums;

import androidx.media3.common.C;
import expo.modules.kotlin.types.Enumerable;
import expo.modules.video.UnsupportedDRMTypeException;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u0011"}, d2 = {"Lexpo/modules/video/enums/DRMType;", "Lexpo/modules/kotlin/types/Enumerable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CLEARKEY", "FAIRPLAY", "PLAYREADY", "WIDEVINE", "isSupported", "", "toUUID", "Ljava/util/UUID;", "expo-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum DRMType implements Enumerable {
    CLEARKEY("clearkey"),
    FAIRPLAY("fairplay"),
    PLAYREADY("playready"),
    WIDEVINE("widevine");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String value;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DRMType.values().length];
            try {
                iArr[DRMType.CLEARKEY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DRMType.FAIRPLAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DRMType.PLAYREADY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DRMType.WIDEVINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }

    DRMType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final boolean isSupported() {
        return this != FAIRPLAY;
    }

    public final UUID toUUID() throws UnsupportedDRMTypeException {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            UUID CLEARKEY_UUID = C.CLEARKEY_UUID;
            Intrinsics.checkNotNullExpressionValue(CLEARKEY_UUID, "CLEARKEY_UUID");
            return CLEARKEY_UUID;
        }
        if (i == 2) {
            throw new UnsupportedDRMTypeException(this);
        }
        if (i == 3) {
            UUID PLAYREADY_UUID = C.PLAYREADY_UUID;
            Intrinsics.checkNotNullExpressionValue(PLAYREADY_UUID, "PLAYREADY_UUID");
            return PLAYREADY_UUID;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        UUID WIDEVINE_UUID = C.WIDEVINE_UUID;
        Intrinsics.checkNotNullExpressionValue(WIDEVINE_UUID, "WIDEVINE_UUID");
        return WIDEVINE_UUID;
    }
}
