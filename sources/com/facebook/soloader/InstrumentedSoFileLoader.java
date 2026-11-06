package com.facebook.soloader;

import com.facebook.soloader.observer.ObserverHolder;

/* JADX INFO: loaded from: classes3.dex */
public class InstrumentedSoFileLoader implements SoFileLoader {
    private final SoFileLoader mDelegate;

    public InstrumentedSoFileLoader(SoFileLoader soFileLoader) {
        this.mDelegate = soFileLoader;
    }

    @Override // com.facebook.soloader.SoFileLoader
    public void load(String str, int i) {
        ObserverHolder.onSoFileLoaderLoadStart(this.mDelegate, "load", i);
        try {
            this.mDelegate.load(str, i);
            ObserverHolder.onSoFileLoaderLoadEnd(null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                ObserverHolder.onSoFileLoaderLoadEnd(th);
                throw th2;
            }
        }
    }
}
