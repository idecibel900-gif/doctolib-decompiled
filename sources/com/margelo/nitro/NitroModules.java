package com.margelo.nitro;

import androidx.annotation.Keep;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import dalvik.annotation.optimization.FastNative;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@DoNotStrip
@Keep
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0017J\t\u0010\r\u001a\u00020\tH\u0083 J\u0019\u0010\f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0082 R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/margelo/nitro/NitroModules;", "Lcom/margelo/nitro/NitroModulesSpec;", "context", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "getContext", "()Lcom/facebook/react/bridge/ReactApplicationContext;", "mHybridData", "Lcom/facebook/jni/HybridData;", "getName", "", "install", "initHybrid", "", "jsRuntimePointer", "", "callInvokerHolder", "Lcom/facebook/react/turbomodule/core/CallInvokerHolderImpl;", "Companion", "react-native-nitro-modules_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NitroModules extends NitroModulesSpec {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String NAME = "NitroModules";
    private static ReactApplicationContext applicationContext;
    private final ReactApplicationContext context;
    private final HybridData mHybridData;

    public static final ReactApplicationContext getApplicationContext() {
        return INSTANCE.getApplicationContext();
    }

    @FastNative
    private final native HybridData initHybrid();

    private final native void install(long jsRuntimePointer, CallInvokerHolderImpl callInvokerHolder);

    public static final void setApplicationContext(ReactApplicationContext reactApplicationContext) {
        INSTANCE.setApplicationContext(reactApplicationContext);
    }

    public final ReactApplicationContext getContext() {
        return this.context;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NitroModules(ReactApplicationContext context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.mHybridData = initHybrid();
        applicationContext = context;
    }

    @Override // com.margelo.nitro.NativeNitroModulesSpec, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "NitroModules";
    }

    @Override // com.margelo.nitro.NativeNitroModulesSpec
    @ReactMethod(isBlockingSynchronousMethod = true)
    public String install() {
        try {
            JavaScriptContextHolder javaScriptContextHolder = this.context.getJavaScriptContextHolder();
            if (javaScriptContextHolder == null) {
                return "ReactApplicationContext.javaScriptContextHolder is null!";
            }
            CallInvokerHolder jSCallInvokerHolder = this.context.getJSCallInvokerHolder();
            CallInvokerHolderImpl callInvokerHolderImpl = jSCallInvokerHolder instanceof CallInvokerHolderImpl ? (CallInvokerHolderImpl) jSCallInvokerHolder : null;
            if (callInvokerHolderImpl == null) {
                return "ReactApplicationContext.jsCallInvokerHolder is null!";
            }
            install(javaScriptContextHolder.getContext(), callInvokerHolderImpl);
            return null;
        } catch (Throwable th) {
            return th.getMessage();
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ReactApplicationContext getApplicationContext() {
            return NitroModules.applicationContext;
        }

        public final void setApplicationContext(ReactApplicationContext reactApplicationContext) {
            NitroModules.applicationContext = reactApplicationContext;
        }
    }

    static {
        JNIOnLoad.initializeNativeNitro();
    }
}
