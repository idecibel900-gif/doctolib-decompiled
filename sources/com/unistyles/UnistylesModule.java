package com.unistyles;

import com.facebook.fbreact.specs.NativeTurboUnistylesSpec;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.RuntimeExecutor;
import com.facebook.react.turbomodule.core.interfaces.BindingsInstallerHolder;
import com.facebook.react.turbomodule.core.interfaces.TurboModuleWithJSIBindings;
import com.margelo.nitro.unistyles.HybridNativePlatformSpec;
import com.margelo.nitro.unistyles.unistylesOnLoad;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0016B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\t\u0010\u000e\u001a\u00020\u000fH\u0097 J\u0019\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0083 J\t\u0010\u0015\u001a\u00020\fH\u0083 R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/unistyles/UnistylesModule;", "Lcom/facebook/fbreact/specs/NativeTurboUnistylesSpec;", "Lcom/facebook/react/turbomodule/core/interfaces/TurboModuleWithJSIBindings;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "mHybridData", "Lcom/facebook/jni/HybridData;", "_nativePlatform", "Lcom/unistyles/NativePlatformAndroid;", "invalidate", "", "initializeHybridData", "getBindingsInstaller", "Lcom/facebook/react/turbomodule/core/interfaces/BindingsInstallerHolder;", "initHybrid", "runtimeExecutor", "Lcom/facebook/react/bridge/RuntimeExecutor;", "nativePlatform", "Lcom/margelo/nitro/unistyles/HybridNativePlatformSpec;", "invalidateNative", "Companion", "react-native-unistyles_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UnistylesModule extends NativeTurboUnistylesSpec implements TurboModuleWithJSIBindings {
    public static final String NAME = "Unistyles";
    private final NativePlatformAndroid _nativePlatform;

    @DoNotStrip
    private HybridData mHybridData;

    @DoNotStrip
    private final native HybridData initHybrid(RuntimeExecutor runtimeExecutor, HybridNativePlatformSpec nativePlatform);

    @DoNotStrip
    private final native void invalidateNative();

    @Override // com.facebook.react.turbomodule.core.interfaces.TurboModuleWithJSIBindings
    @DoNotStrip
    public native BindingsInstallerHolder getBindingsInstaller();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnistylesModule(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this._nativePlatform = new NativePlatformAndroid(reactContext);
        this.mHybridData = initializeHybridData(reactContext);
    }

    static {
        unistylesOnLoad.Companion.initializeNative();
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        this._nativePlatform.onDestroy();
        invalidateNative();
    }

    private final HybridData initializeHybridData(ReactApplicationContext reactContext) {
        RuntimeExecutor runtimeExecutor;
        CatalystInstance catalystInstance = reactContext.getCatalystInstance();
        if (catalystInstance == null || (runtimeExecutor = catalystInstance.getRuntimeExecutor()) == null) {
            throw new IllegalStateException("Unistyles: React Native runtime executor is not available. Please follow installation guides.");
        }
        return initHybrid(runtimeExecutor, this._nativePlatform);
    }
}
