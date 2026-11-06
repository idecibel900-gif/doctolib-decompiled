package expo.modules.haptics.arguments;

import com.amazon.device.simplesignin.a.a.a;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class HapticsNotificationType {
    public static final HapticsNotificationType INSTANCE = new HapticsNotificationType();
    private static final Map types = MapsKt.mapOf(TuplesKt.to(a.s, new HapticsVibrationType(new long[]{0, 40, 100, 40}, new int[]{0, 50, 0, 60}, new long[]{0, 40, 100, 40})), TuplesKt.to("warning", new HapticsVibrationType(new long[]{0, 40, 120, 60}, new int[]{0, 40, 0, 60}, new long[]{0, 40, 120, 60})), TuplesKt.to("error", new HapticsVibrationType(new long[]{0, 60, 100, 40, 80, 50}, new int[]{0, 50, 0, 40, 0, 50}, new long[]{0, 60, 100, 40, 80, 50})));

    private HapticsNotificationType() {
    }

    public final HapticsVibrationType fromString(String type) throws HapticsInvalidArgumentException {
        Intrinsics.checkNotNullParameter(type, "type");
        Object obj = types.get(type);
        if (obj != null) {
            return (HapticsVibrationType) obj;
        }
        throw new HapticsInvalidArgumentException("'type' must be one of ['success', 'warning', 'error']. Obtained '" + type + "'.");
    }
}
