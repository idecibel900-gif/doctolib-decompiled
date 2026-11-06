package com.facebook.react.runtime.internal.bolts;

import com.facebook.react.bridge.UiThreadUtil;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class Executors {
    public static final Executors INSTANCE = new Executors();
    public static final Executor UI_THREAD = new UIThreadExecutor();
    public static final Executor IMMEDIATE = new ImmediateExecutor();

    private Executors() {
    }

    private static final class UIThreadExecutor implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable command) {
            Intrinsics.checkNotNullParameter(command, "command");
            UiThreadUtil.runOnUiThread(command);
        }
    }

    private static final class ImmediateExecutor implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable command) {
            Intrinsics.checkNotNullParameter(command, "command");
            command.run();
        }
    }
}
