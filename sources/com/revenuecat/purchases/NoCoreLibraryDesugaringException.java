package com.revenuecat.purchases;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/NoCoreLibraryDesugaringException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "cause", "", "(Ljava/lang/Throwable;)V", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoCoreLibraryDesugaringException extends RuntimeException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoCoreLibraryDesugaringException(Throwable cause) {
        super(NoCoreLibraryDesugaringExceptionKt.NO_CORE_LIBRARY_DESUGARING_ERROR_MESSAGE, cause);
        Intrinsics.checkNotNullParameter(cause, "cause");
    }
}
