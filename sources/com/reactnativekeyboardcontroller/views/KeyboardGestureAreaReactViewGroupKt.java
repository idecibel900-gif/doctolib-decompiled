package com.reactnativekeyboardcontroller.views;

import com.reactnativekeyboardcontroller.interactive.interpolators.IosInterpolator;
import com.reactnativekeyboardcontroller.interactive.interpolators.LinearInterpolator;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes4.dex */
public abstract class KeyboardGestureAreaReactViewGroupKt {
    private static final Map interpolators = MapsKt.mapOf(TuplesKt.to("linear", new LinearInterpolator()), TuplesKt.to("ios", new IosInterpolator()));

    public static final Map getInterpolators() {
        return interpolators;
    }
}
