package com.revenuecat.purchases.ui.revenuecatui.composables;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.composables.PlaceholderKt$rememberPlaceholder$3$1", f = "Placeholder.kt", l = {120, 122}, m = "invokeSuspend")
final class PlaceholderKt$rememberPlaceholder$3$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ boolean $inPreviewMode;
    final /* synthetic */ Placeholder $placeholder;
    final /* synthetic */ boolean $visible;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PlaceholderKt$rememberPlaceholder$3$1(boolean z, boolean z2, Placeholder placeholder, Continuation continuation) {
        super(2, continuation);
        this.$visible = z;
        this.$inPreviewMode = z2;
        this.$placeholder = placeholder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PlaceholderKt$rememberPlaceholder$3$1(this.$visible, this.$inPreviewMode, this.$placeholder, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((PlaceholderKt$rememberPlaceholder$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:
    
        if (r5.startAnimation$revenuecatui_defaultsBc8Release(r4) == r0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
    
        if (r5.stopAnimation$revenuecatui_defaultsBc8Release(r4) == r0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
    
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1b
            if (r1 == r3) goto L17
            if (r1 != r2) goto Lf
            goto L17
        Lf:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L17:
            kotlin.ResultKt.throwOnFailure(r5)
            goto L3c
        L1b:
            kotlin.ResultKt.throwOnFailure(r5)
            boolean r5 = r4.$visible
            if (r5 == 0) goto L31
            boolean r5 = r4.$inPreviewMode
            if (r5 != 0) goto L31
            com.revenuecat.purchases.ui.revenuecatui.composables.Placeholder r5 = r4.$placeholder
            r4.label = r3
            java.lang.Object r5 = r5.startAnimation$revenuecatui_defaultsBc8Release(r4)
            if (r5 != r0) goto L3c
            goto L3b
        L31:
            com.revenuecat.purchases.ui.revenuecatui.composables.Placeholder r5 = r4.$placeholder
            r4.label = r2
            java.lang.Object r5 = r5.stopAnimation$revenuecatui_defaultsBc8Release(r4)
            if (r5 != r0) goto L3c
        L3b:
            return r0
        L3c:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.composables.PlaceholderKt$rememberPlaceholder$3$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
