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
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0013\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0097\u0002¢\u0006\u0002\u0010\u000eJ$\u0010\u000f\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0083 ¢\u0006\u0002\u0010\u000eR\u0010\u0010\u0006\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/margelo/nitro/unistyles/Func_void_std__vector_UnistyleDependency__UnistylesNativeMiniRuntime_cxx;", "Lcom/margelo/nitro/unistyles/Func_void_std__vector_UnistyleDependency__UnistylesNativeMiniRuntime;", "hybridData", "Lcom/facebook/jni/HybridData;", "<init>", "(Lcom/facebook/jni/HybridData;)V", "mHybridData", "invoke", "", "dependencies", "", "Lcom/margelo/nitro/unistyles/UnistyleDependency;", "miniRuntime", "Lcom/margelo/nitro/unistyles/UnistylesNativeMiniRuntime;", "([Lcom/margelo/nitro/unistyles/UnistyleDependency;Lcom/margelo/nitro/unistyles/UnistylesNativeMiniRuntime;)V", "invoke_cxx", "react-native-unistyles_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Func_void_std__vector_UnistyleDependency__UnistylesNativeMiniRuntime_cxx implements Func_void_std__vector_UnistyleDependency__UnistylesNativeMiniRuntime {

    @DoNotStrip
    @Keep
    private final HybridData mHybridData;

    @FastNative
    private final native void invoke_cxx(UnistyleDependency[] dependencies, UnistylesNativeMiniRuntime miniRuntime);

    @Override // com.margelo.nitro.unistyles.Func_void_std__vector_UnistyleDependency__UnistylesNativeMiniRuntime, kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((UnistyleDependency[]) obj, (UnistylesNativeMiniRuntime) obj2);
        return Unit.INSTANCE;
    }

    @DoNotStrip
    @Keep
    private Func_void_std__vector_UnistyleDependency__UnistylesNativeMiniRuntime_cxx(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    @Override // com.margelo.nitro.unistyles.Func_void_std__vector_UnistyleDependency__UnistylesNativeMiniRuntime
    @DoNotStrip
    @Keep
    public void invoke(UnistyleDependency[] dependencies, UnistylesNativeMiniRuntime miniRuntime) {
        Intrinsics.checkNotNullParameter(dependencies, "dependencies");
        Intrinsics.checkNotNullParameter(miniRuntime, "miniRuntime");
        invoke_cxx(dependencies, miniRuntime);
    }
}
