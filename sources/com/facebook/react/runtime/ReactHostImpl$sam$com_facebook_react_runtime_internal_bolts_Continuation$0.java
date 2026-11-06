package com.facebook.react.runtime;

import com.facebook.react.runtime.internal.bolts.Continuation;
import com.facebook.react.runtime.internal.bolts.Task;
import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
final class ReactHostImpl$sam$com_facebook_react_runtime_internal_bolts_Continuation$0 implements Continuation, FunctionAdapter {
    private final /* synthetic */ Function1 function;

    ReactHostImpl$sam$com_facebook_react_runtime_internal_bolts_Continuation$0(Function1 function) {
        Intrinsics.checkNotNullParameter(function, "function");
        this.function = function;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof Continuation) && (obj instanceof FunctionAdapter)) {
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

    @Override // com.facebook.react.runtime.internal.bolts.Continuation
    public final /* synthetic */ Object then(Task task) {
        return this.function.invoke(task);
    }
}
