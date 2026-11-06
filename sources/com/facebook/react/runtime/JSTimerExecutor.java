package com.facebook.react.runtime;

import com.facebook.jni.HybridClassBase;
import com.facebook.jni.annotations.DoNotStrip;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.modules.core.JavaScriptTimerExecutor;
import com.facebook.soloader.SoLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@DoNotStrip
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0001\u0011B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0006H\u0082 J\u0011\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0082 J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0012"}, d2 = {"Lcom/facebook/react/runtime/JSTimerExecutor;", "Lcom/facebook/jni/HybridClassBase;", "Lcom/facebook/react/modules/core/JavaScriptTimerExecutor;", "<init>", "()V", "initHybrid", "", "callTimers", "timerIDs", "Lcom/facebook/react/bridge/WritableNativeArray;", "Lcom/facebook/react/bridge/WritableArray;", "callIdleCallbacks", "frameTime", "", "emitTimeDriftWarning", "warningMessage", "", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JSTimerExecutor extends HybridClassBase implements JavaScriptTimerExecutor {
    private static final Companion Companion = new Companion(null);

    private final native void callTimers(WritableNativeArray timerIDs);

    private final native void initHybrid();

    @Override // com.facebook.react.modules.core.JavaScriptTimerExecutor
    public void callIdleCallbacks(double frameTime) {
    }

    @Override // com.facebook.react.modules.core.JavaScriptTimerExecutor
    public void emitTimeDriftWarning(String warningMessage) {
        Intrinsics.checkNotNullParameter(warningMessage, "warningMessage");
    }

    public JSTimerExecutor() {
        initHybrid();
    }

    @Override // com.facebook.react.modules.core.JavaScriptTimerExecutor
    public void callTimers(WritableArray timerIDs) {
        Intrinsics.checkNotNullParameter(timerIDs, "timerIDs");
        callTimers((WritableNativeArray) timerIDs);
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        SoLoader.loadLibrary("rninstance");
    }
}
