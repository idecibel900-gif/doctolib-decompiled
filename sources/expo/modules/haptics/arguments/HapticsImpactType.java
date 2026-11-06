package expo.modules.haptics.arguments;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class HapticsImpactType {
    public static final HapticsImpactType INSTANCE = new HapticsImpactType();
    private static final Map types = MapsKt.mapOf(TuplesKt.to("light", new HapticsVibrationType(new long[]{0, 50}, new int[]{0, 30}, new long[]{0, 20})), TuplesKt.to("soft", new HapticsVibrationType(new long[]{0, 50}, new int[]{0, 30}, new long[]{0, 20})), TuplesKt.to("medium", new HapticsVibrationType(new long[]{0, 43}, new int[]{0, 50}, new long[]{0, 43})), TuplesKt.to("rigid", new HapticsVibrationType(new long[]{0, 43}, new int[]{0, 50}, new long[]{0, 43})), TuplesKt.to("heavy", new HapticsVibrationType(new long[]{0, 60}, new int[]{0, 70}, new long[]{0, 61})));

    private HapticsImpactType() {
    }

    public final HapticsVibrationType fromString(String style) throws HapticsInvalidArgumentException {
        Intrinsics.checkNotNullParameter(style, "style");
        Object obj = types.get(style);
        if (obj != null) {
            return (HapticsVibrationType) obj;
        }
        throw new HapticsInvalidArgumentException("'style' must be one of ['light', 'medium', 'heavy', 'rigid', 'soft']. Obtained " + style + "'.");
    }
}
