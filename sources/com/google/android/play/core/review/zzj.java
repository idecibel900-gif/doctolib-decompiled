package com.google.android.play.core.review;

import android.os.Bundle;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.openid.appauth.RegistrationRequest;

/* JADX INFO: loaded from: classes3.dex */
public final class zzj {
    private static final Set zza = new HashSet(Arrays.asList(RegistrationRequest.APPLICATION_TYPE_NATIVE, "unity"));
    private static final Map zzb = new HashMap();
    private static final com.google.android.play.core.review.internal.zzi zzc = new com.google.android.play.core.review.internal.zzi("PlayCoreVersion");

    public static Bundle zza() {
        Bundle bundle = new Bundle();
        Map mapZzb = zzb();
        bundle.putInt("playcore_version_code", ((Integer) mapZzb.get("java")).intValue());
        if (mapZzb.containsKey(RegistrationRequest.APPLICATION_TYPE_NATIVE)) {
            bundle.putInt("playcore_native_version", ((Integer) mapZzb.get(RegistrationRequest.APPLICATION_TYPE_NATIVE)).intValue());
        }
        if (mapZzb.containsKey("unity")) {
            bundle.putInt("playcore_unity_version", ((Integer) mapZzb.get("unity")).intValue());
        }
        return bundle;
    }

    public static synchronized Map zzb() {
        Map map;
        map = zzb;
        map.put("java", 11004);
        return map;
    }
}
