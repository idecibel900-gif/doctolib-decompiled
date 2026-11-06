package com.margelo.nitro.core;

import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class PromiseKt$sam$com_margelo_nitro_core_Promise_OnRejectedCallback$0 implements Promise.OnRejectedCallback, FunctionAdapter {
    private final /* synthetic */ Function1 function;

    PromiseKt$sam$com_margelo_nitro_core_Promise_OnRejectedCallback$0(Function1 function) {
        Intrinsics.checkNotNullParameter(function, "function");
        this.function = function;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof Promise.OnRejectedCallback) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // com.margelo.nitro.core.Promise.OnRejectedCallback
    public final /* synthetic */ void onRejected(Throwable th) {
        this.function.invoke(th);
    }
}
