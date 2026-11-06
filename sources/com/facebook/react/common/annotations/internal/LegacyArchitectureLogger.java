package com.facebook.react.common.annotations.internal;

import com.facebook.react.bridge.AssertionException;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.common.build.ReactBuildConfig;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class LegacyArchitectureLogger {
    public static final LegacyArchitectureLogger INSTANCE = new LegacyArchitectureLogger();

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LegacyArchitectureLogLevel.values().length];
            try {
                iArr[LegacyArchitectureLogLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LegacyArchitectureLogLevel.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private LegacyArchitectureLogger() {
    }

    public static /* synthetic */ void assertLegacyArchitecture$default(String str, LegacyArchitectureLogLevel legacyArchitectureLogLevel, int i, Object obj) {
        if ((i & 2) != 0) {
            legacyArchitectureLogLevel = LegacyArchitectureLogLevel.WARNING;
        }
        assertLegacyArchitecture(str, legacyArchitectureLogLevel);
    }

    public static final void assertLegacyArchitecture(String name, LegacyArchitectureLogLevel logLevel) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        if (ReactBuildConfig.UNSTABLE_ENABLE_MINIFY_LEGACY_ARCHITECTURE) {
            INSTANCE.executeAssert(name, logLevel);
        }
    }

    private final void executeAssert(String str, LegacyArchitectureLogLevel legacyArchitectureLogLevel) {
        if (ReactBuildConfig.DEBUG) {
            int i = WhenMappings.$EnumSwitchMapping$0[legacyArchitectureLogLevel.ordinal()];
            if (i == 1) {
                throw new AssertionException(str + " is being executed when app is fully running on the NEW Architecture.");
            }
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            ReactSoftExceptionLogger.logSoftException(ReactSoftExceptionLogger.Categories.SOFT_ASSERTIONS, new ReactNoCrashSoftException(str + " is being executed when app is fully running on the NEW Architecture."));
        }
    }
}
