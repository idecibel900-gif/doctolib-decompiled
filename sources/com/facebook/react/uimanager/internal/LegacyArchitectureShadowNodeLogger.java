package com.facebook.react.uimanager.internal;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.common.annotations.LegacyArchitectureShadowNodeWithCxxImpl;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.util.RNLog;
import com.facebook.yoga.YogaMeasureFunction;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class LegacyArchitectureShadowNodeLogger {
    public static final LegacyArchitectureShadowNodeLogger INSTANCE = new LegacyArchitectureShadowNodeLogger();

    private LegacyArchitectureShadowNodeLogger() {
    }

    public static final void assertUnsupportedViewManager(ReactApplicationContext reactContext, Class shadowNodeClass, String viewManagerName) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(shadowNodeClass, "shadowNodeClass");
        Intrinsics.checkNotNullParameter(viewManagerName, "viewManagerName");
        Class<?>[] interfaces = shadowNodeClass.getInterfaces();
        Intrinsics.checkNotNullExpressionValue(interfaces, "getInterfaces(...)");
        boolean zContains = ArraysKt.contains(interfaces, YogaMeasureFunction.class);
        boolean zIsAnnotationPresent = shadowNodeClass.isAnnotationPresent(LegacyArchitectureShadowNodeWithCxxImpl.class);
        if (!zContains || zIsAnnotationPresent) {
            return;
        }
        String strTrimIndent = StringsKt.trimIndent("\n          [Legacy Architecture] The ViewManager `" + viewManagerName + "` is unlikely to work with the New Architecture.\n          That's because the shadow node `" + shadowNodeClass.getSimpleName() + "` implements the `YogaMeasureFunction.measure()` method.\n          This is not supported in the New Architecture as shadow nodes with custom measurements should be implemented in C++.\n          ");
        if (ReactBuildConfig.DEBUG) {
            RNLog.w(reactContext, strTrimIndent);
            ReactSoftExceptionLogger.logSoftException(ReactSoftExceptionLogger.Categories.SOFT_ASSERTIONS, new ReactNoCrashSoftException(strTrimIndent));
        }
    }
}
