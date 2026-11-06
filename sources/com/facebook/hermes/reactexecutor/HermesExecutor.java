package com.facebook.hermes.reactexecutor;

import com.facebook.jni.HybridData;
import com.facebook.jni.annotations.DoNotStrip;
import com.facebook.react.bridge.JavaScriptExecutor;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.soloader.SoLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"Lcom/facebook/hermes/reactexecutor/HermesExecutor;", "Lcom/facebook/react/bridge/JavaScriptExecutor;", "enableDebugger", "", "debuggerName", "", "<init>", "(ZLjava/lang/String;)V", "getName", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HermesExecutor extends JavaScriptExecutor {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static String mode;

    /* JADX INFO: Access modifiers changed from: private */
    @DoNotStrip
    public static final native HybridData initHybrid(boolean z, String str, long j);

    /* JADX INFO: Access modifiers changed from: private */
    @DoNotStrip
    public static final native HybridData initHybridDefaultConfig(boolean z, String str);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HermesExecutor(boolean z, String debuggerName) {
        super(INSTANCE.initHybridDefaultConfig(z, debuggerName));
        Intrinsics.checkNotNullParameter(debuggerName, "debuggerName");
    }

    @Override // com.facebook.react.bridge.JavaScriptExecutor
    public String getName() {
        return "HermesExecutor" + mode;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @DoNotStrip
        private final HybridData initHybrid(boolean z, String str, long j) {
            return HermesExecutor.initHybrid(z, str, j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @DoNotStrip
        public final HybridData initHybridDefaultConfig(boolean z, String str) {
            return HermesExecutor.initHybridDefaultConfig(z, str);
        }

        private Companion() {
        }

        public final void loadLibrary() {
            if (HermesExecutor.mode == null) {
                SoLoader.loadLibrary("hermesvm");
                SoLoader.loadLibrary("hermes_executor");
                HermesExecutor.mode = ReactBuildConfig.DEBUG ? "Debug" : "Release";
            }
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        companion.loadLibrary();
    }
}
