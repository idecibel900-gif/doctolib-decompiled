package expo.modules.core;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class ModulePriorities {
    public static final ModulePriorities INSTANCE = new ModulePriorities();
    private static final Map SUPPORTED_MODULES = MapsKt.mapOf(TuplesKt.to("host.exp.exponent.experience.splashscreen.legacy.SplashScreenPackage", 11), TuplesKt.to("expo.modules.updates.UpdatesPackage", 10));

    private ModulePriorities() {
    }

    public final int get(String str) {
        Integer num;
        if (str == null || (num = (Integer) SUPPORTED_MODULES.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }
}
