package com.margelo.nitro.unistyles;

import androidx.annotation.Keep;
import com.facebook.proguard.annotations.DoNotStrip;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@DoNotStrip
@Keep
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0004H\u0097\u0002R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/margelo/nitro/unistyles/Func_void_UnistylesNativeMiniRuntime_java;", "Lcom/margelo/nitro/unistyles/Func_void_UnistylesNativeMiniRuntime;", "function", "Lkotlin/Function1;", "Lcom/margelo/nitro/unistyles/UnistylesNativeMiniRuntime;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "invoke", "miniRuntime", "react-native-unistyles_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Func_void_UnistylesNativeMiniRuntime_java implements Func_void_UnistylesNativeMiniRuntime {
    private final Function1 function;

    @Override // com.margelo.nitro.unistyles.Func_void_UnistylesNativeMiniRuntime, kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((UnistylesNativeMiniRuntime) obj);
        return Unit.INSTANCE;
    }

    public Func_void_UnistylesNativeMiniRuntime_java(Function1 function) {
        Intrinsics.checkNotNullParameter(function, "function");
        this.function = function;
    }

    @Override // com.margelo.nitro.unistyles.Func_void_UnistylesNativeMiniRuntime
    @DoNotStrip
    @Keep
    public void invoke(UnistylesNativeMiniRuntime miniRuntime) {
        Intrinsics.checkNotNullParameter(miniRuntime, "miniRuntime");
        this.function.invoke(miniRuntime);
    }
}
