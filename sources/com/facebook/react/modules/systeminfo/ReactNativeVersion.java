package com.facebook.react.modules.systeminfo;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactNativeVersion {
    public static final ReactNativeVersion INSTANCE = new ReactNativeVersion();
    public static final Map VERSION = MapsKt.mapOf(TuplesKt.to("major", 0), TuplesKt.to("minor", 83), TuplesKt.to("patch", 10), TuplesKt.to("prerelease", null));

    private ReactNativeVersion() {
    }
}
