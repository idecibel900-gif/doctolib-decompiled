package com.revenuecat.purchases.ui.revenuecatui.helpers;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u0000¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"safeResume", "", "T", "Lkotlinx/coroutines/CancellableContinuation;", "value", "(Lkotlinx/coroutines/CancellableContinuation;Ljava/lang/Object;)V", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CancellableContinuationExtensionsKt {
    public static final <T> void safeResume(CancellableContinuation cancellableContinuation, T t) {
        Intrinsics.checkNotNullParameter(cancellableContinuation, "<this>");
        if (cancellableContinuation.isActive()) {
            cancellableContinuation.resumeWith(kotlin.Result.m5243constructorimpl(t));
        }
    }
}
