package com.dylanvann.fastimage;

import com.bumptech.glide.module.LibraryGlideModule;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class FastImageOkHttpProgressGlideModule extends LibraryGlideModule {
    private static final DispatchingProgressListener progressListener = new DispatchingProgressListener();

    static void forget(String str) {
        progressListener.forget(str);
    }

    static void expect(String str, FastImageProgressListener fastImageProgressListener) {
        progressListener.expect(str, fastImageProgressListener);
    }

    private static class DispatchingProgressListener {
        private final Map LISTENERS;
        private final Map PROGRESSES;

        private DispatchingProgressListener() {
            this.LISTENERS = new WeakHashMap();
            this.PROGRESSES = new HashMap();
        }

        void forget(String str) {
            this.LISTENERS.remove(str);
            this.PROGRESSES.remove(str);
        }

        void expect(String str, FastImageProgressListener fastImageProgressListener) {
            this.LISTENERS.put(str, fastImageProgressListener);
        }
    }
}
