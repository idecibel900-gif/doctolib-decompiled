package com.revenuecat.purchases.customercenter;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0013\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0096\u0002J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/customercenter/Resumable;", "", "invoke", "", "shouldResume", "", "resume", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface Resumable {
    void resume(boolean shouldResume);

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void invoke(Resumable resumable, boolean z) {
            Resumable.super.invoke(z);
        }
    }

    static /* synthetic */ void invoke$default(Resumable resumable, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        resumable.invoke(z);
    }

    default void invoke(boolean shouldResume) {
        resume(shouldResume);
    }
}
