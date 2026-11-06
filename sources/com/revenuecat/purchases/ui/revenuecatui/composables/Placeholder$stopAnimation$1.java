package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.composables.Placeholder", f = "Placeholder.kt", l = {188, 189, 190}, m = "stopAnimation$revenuecatui_defaultsBc8Release")
final class Placeholder$stopAnimation$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Placeholder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Placeholder$stopAnimation$1(Placeholder placeholder, Continuation continuation) {
        super(continuation);
        this.this$0 = placeholder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= LinearLayoutManager.INVALID_OFFSET;
        return this.this$0.stopAnimation$revenuecatui_defaultsBc8Release(this);
    }
}
