package io.sentry.android.replay;

import android.os.Handler;
import io.sentry.android.replay.util.MainLooperHandler;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes5.dex */
public interface ExecutorProvider {
    Handler getBackgroundHandler();

    ScheduledExecutorService getExecutor();

    MainLooperHandler getMainLooperHandler();
}
