package io.sentry.android.ndk;

import io.sentry.SentryOptions;
import io.sentry.android.core.IDebugImagesLoader;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.ndk.NativeModuleListLoader;
import io.sentry.util.AutoClosableReentrantLock;
import io.sentry.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public final class DebugImagesLoader implements IDebugImagesLoader {
    protected static final AutoClosableReentrantLock debugImagesLock = new AutoClosableReentrantLock();
    private final NativeModuleListLoader moduleListLoader;
    private final SentryOptions options;

    public DebugImagesLoader(SentryAndroidOptions sentryAndroidOptions, NativeModuleListLoader nativeModuleListLoader) {
        this.options = (SentryOptions) Objects.requireNonNull(sentryAndroidOptions, "The SentryAndroidOptions is required.");
        this.moduleListLoader = (NativeModuleListLoader) Objects.requireNonNull(nativeModuleListLoader, "The NativeModuleListLoader is required.");
    }
}
