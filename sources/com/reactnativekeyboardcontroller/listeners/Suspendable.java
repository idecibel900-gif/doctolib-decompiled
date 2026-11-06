package com.reactnativekeyboardcontroller.listeners;

/* JADX INFO: loaded from: classes4.dex */
public interface Suspendable {
    void setSuspended(boolean z);

    public static final class DefaultImpls {
        public static void suspend(Suspendable suspendable, boolean z) {
            suspendable.setSuspended(z);
        }
    }
}
