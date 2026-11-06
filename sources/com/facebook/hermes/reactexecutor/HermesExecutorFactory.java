package com.facebook.hermes.reactexecutor;

import com.facebook.hermes.instrumentation.HermesSamplingProfiler;
import com.facebook.react.bridge.JavaScriptExecutor;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class HermesExecutorFactory implements JavaScriptExecutorFactory {
    private boolean enableDebugger = true;
    private String debuggerName = "";

    @Override // com.facebook.react.bridge.JavaScriptExecutorFactory
    public JavaScriptExecutor create() {
        return new HermesExecutor(this.enableDebugger, this.debuggerName);
    }

    @Override // com.facebook.react.bridge.JavaScriptExecutorFactory
    public void startSamplingProfiler() {
        HermesSamplingProfiler.enable();
    }

    @Override // com.facebook.react.bridge.JavaScriptExecutorFactory
    public void stopSamplingProfiler(String filename) {
        Intrinsics.checkNotNullParameter(filename, "filename");
        HermesSamplingProfiler.dumpSampledTraceToFile(filename);
        HermesSamplingProfiler.disable();
    }

    public String toString() {
        return "JSIExecutor+HermesRuntime";
    }
}
