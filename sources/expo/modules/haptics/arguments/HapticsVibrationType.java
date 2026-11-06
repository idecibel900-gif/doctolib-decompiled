package expo.modules.haptics.arguments;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class HapticsVibrationType {
    private final int[] amplitudes;
    private final long[] oldSDKPattern;
    private final long[] timings;

    public String toString() {
        return "HapticsVibrationType(timings=" + Arrays.toString(this.timings) + ", amplitudes=" + Arrays.toString(this.amplitudes) + ", oldSDKPattern=" + Arrays.toString(this.oldSDKPattern) + ")";
    }

    public HapticsVibrationType(long[] timings, int[] amplitudes, long[] oldSDKPattern) {
        Intrinsics.checkNotNullParameter(timings, "timings");
        Intrinsics.checkNotNullParameter(amplitudes, "amplitudes");
        Intrinsics.checkNotNullParameter(oldSDKPattern, "oldSDKPattern");
        this.timings = timings;
        this.amplitudes = amplitudes;
        this.oldSDKPattern = oldSDKPattern;
    }

    public final long[] getTimings() {
        return this.timings;
    }

    public final int[] getAmplitudes() {
        return this.amplitudes;
    }

    public final long[] getOldSDKPattern() {
        return this.oldSDKPattern;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(HapticsVibrationType.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.haptics.arguments.HapticsVibrationType");
        HapticsVibrationType hapticsVibrationType = (HapticsVibrationType) obj;
        return Arrays.equals(this.timings, hapticsVibrationType.timings) && Arrays.equals(this.amplitudes, hapticsVibrationType.amplitudes) && Arrays.equals(this.oldSDKPattern, hapticsVibrationType.oldSDKPattern);
    }

    public int hashCode() {
        return (((Arrays.hashCode(this.timings) * 31) + Arrays.hashCode(this.amplitudes)) * 31) + Arrays.hashCode(this.oldSDKPattern);
    }
}
