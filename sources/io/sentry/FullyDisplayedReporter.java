package io.sentry;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class FullyDisplayedReporter {
    private static final FullyDisplayedReporter instance = new FullyDisplayedReporter();
    private final List listeners = new CopyOnWriteArrayList();

    public interface FullyDisplayedReporterListener {
    }

    private FullyDisplayedReporter() {
    }

    public static FullyDisplayedReporter getInstance() {
        return instance;
    }

    public void registerFullyDrawnListener(FullyDisplayedReporterListener fullyDisplayedReporterListener) {
        this.listeners.add(fullyDisplayedReporterListener);
    }
}
