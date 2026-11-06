package com.revenuecat.purchases.hybridcommon;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/revenuecat/purchases/hybridcommon/OnResultAny;", "T", "", "onError", "", "errorContainer", "Lcom/revenuecat/purchases/hybridcommon/ErrorContainer;", "onReceived", "result", "(Ljava/lang/Object;)V", "hybridcommon_bc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface OnResultAny<T> {
    void onError(ErrorContainer errorContainer);

    void onReceived(T result);
}
