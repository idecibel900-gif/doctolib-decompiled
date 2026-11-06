package com.opentok.android;

import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
class Utils {
    static boolean otcEngineInitialized;

    static {
        Loader.load();
        otcEngineInitialized = false;
    }

    Utils() {
    }

    static int booleanToInt(boolean z) {
        return z ? 1 : 0;
    }

    static void initOtcEngine(Context context, BaseAudioDevice baseAudioDevice, boolean z, boolean z2, boolean z3, boolean z4) {
        if (otcEngineInitialized) {
            return;
        }
        init_otc_engine(context, baseAudioDevice, z, z2, z3, z4);
        otcEngineInitialized = true;
    }

    static native void init_otc_engine(Context context, BaseAudioDevice baseAudioDevice, boolean z, boolean z2, boolean z3, boolean z4);

    static boolean intToBoolean(int i) {
        return i != 0;
    }
}
