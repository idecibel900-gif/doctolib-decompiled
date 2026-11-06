package com.margelo.nitro.unistyles;

import androidx.annotation.Keep;
import com.facebook.proguard.annotations.DoNotStrip;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@DoNotStrip
@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u001e\u0010\u0002\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\u0004\b\b\u0010\tJ$\u0010\n\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\f\u001a\u00020\u0006H\u0097\u0002¢\u0006\u0002\u0010\rR&\u0010\u0002\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/margelo/nitro/unistyles/Func_void_std__vector_UnistyleDependency__UnistylesNativeMiniRuntime_java;", "Lcom/margelo/nitro/unistyles/Func_void_std__vector_UnistyleDependency__UnistylesNativeMiniRuntime;", "function", "Lkotlin/Function2;", "", "Lcom/margelo/nitro/unistyles/UnistyleDependency;", "Lcom/margelo/nitro/unistyles/UnistylesNativeMiniRuntime;", "", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "invoke", "dependencies", "miniRuntime", "([Lcom/margelo/nitro/unistyles/UnistyleDependency;Lcom/margelo/nitro/unistyles/UnistylesNativeMiniRuntime;)V", "react-native-unistyles_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Func_void_std__vector_UnistyleDependency__UnistylesNativeMiniRuntime_java implements Func_void_std__vector_UnistyleDependency__UnistylesNativeMiniRuntime {
    private final Function2 function;

    @Override // com.margelo.nitro.unistyles.Func_void_std__vector_UnistyleDependency__UnistylesNativeMiniRuntime, kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((UnistyleDependency[]) obj, (UnistylesNativeMiniRuntime) obj2);
        return Unit.INSTANCE;
    }

    public Func_void_std__vector_UnistyleDependency__UnistylesNativeMiniRuntime_java(Function2 function) {
        Intrinsics.checkNotNullParameter(function, "function");
        this.function = function;
    }

    @Override // com.margelo.nitro.unistyles.Func_void_std__vector_UnistyleDependency__UnistylesNativeMiniRuntime
    @DoNotStrip
    @Keep
    public void invoke(UnistyleDependency[] dependencies, UnistylesNativeMiniRuntime miniRuntime) {
        Intrinsics.checkNotNullParameter(dependencies, "dependencies");
        Intrinsics.checkNotNullParameter(miniRuntime, "miniRuntime");
        this.function.invoke(dependencies, miniRuntime);
    }
}
