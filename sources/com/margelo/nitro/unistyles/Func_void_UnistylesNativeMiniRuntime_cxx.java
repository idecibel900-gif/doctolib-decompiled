package com.margelo.nitro.unistyles;

import androidx.annotation.Keep;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import dalvik.annotation.optimization.FastNative;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@DoNotStrip
@Keep
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0013\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0097\u0002J\u0011\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0083 R\u0010\u0010\u0006\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/margelo/nitro/unistyles/Func_void_UnistylesNativeMiniRuntime_cxx;", "Lcom/margelo/nitro/unistyles/Func_void_UnistylesNativeMiniRuntime;", "hybridData", "Lcom/facebook/jni/HybridData;", "<init>", "(Lcom/facebook/jni/HybridData;)V", "mHybridData", "invoke", "", "miniRuntime", "Lcom/margelo/nitro/unistyles/UnistylesNativeMiniRuntime;", "invoke_cxx", "react-native-unistyles_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Func_void_UnistylesNativeMiniRuntime_cxx implements Func_void_UnistylesNativeMiniRuntime {

    @DoNotStrip
    @Keep
    private final HybridData mHybridData;

    @FastNative
    private final native void invoke_cxx(UnistylesNativeMiniRuntime miniRuntime);

    @Override // com.margelo.nitro.unistyles.Func_void_UnistylesNativeMiniRuntime, kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((UnistylesNativeMiniRuntime) obj);
        return Unit.INSTANCE;
    }

    @DoNotStrip
    @Keep
    private Func_void_UnistylesNativeMiniRuntime_cxx(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    @Override // com.margelo.nitro.unistyles.Func_void_UnistylesNativeMiniRuntime
    @DoNotStrip
    @Keep
    public void invoke(UnistylesNativeMiniRuntime miniRuntime) {
        Intrinsics.checkNotNullParameter(miniRuntime, "miniRuntime");
        invoke_cxx(miniRuntime);
    }
}
