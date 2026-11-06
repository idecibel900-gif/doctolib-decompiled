package com.revenuecat.purchases;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/revenuecat/purchases/AppLifecycleHandler;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "lifecycleDelegate", "Lcom/revenuecat/purchases/LifecycleDelegate;", "(Lcom/revenuecat/purchases/LifecycleDelegate;)V", "onCreate", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AppLifecycleHandler implements DefaultLifecycleObserver {
    private final LifecycleDelegate lifecycleDelegate;

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onCreate(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onPause(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
    }

    public AppLifecycleHandler(LifecycleDelegate lifecycleDelegate) {
        Intrinsics.checkNotNullParameter(lifecycleDelegate, "lifecycleDelegate");
        this.lifecycleDelegate = lifecycleDelegate;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStart(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.lifecycleDelegate.onAppForegrounded();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.lifecycleDelegate.onAppBackgrounded();
    }
}
