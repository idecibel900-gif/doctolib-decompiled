package io.sentry.android.core;

/* JADX INFO: loaded from: classes5.dex */
final class NoOpDebugImagesLoader implements IDebugImagesLoader {
    private static final NoOpDebugImagesLoader instance = new NoOpDebugImagesLoader();

    private NoOpDebugImagesLoader() {
    }

    public static NoOpDebugImagesLoader getInstance() {
        return instance;
    }
}
