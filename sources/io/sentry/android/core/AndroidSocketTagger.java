package io.sentry.android.core;

import android.net.TrafficStats;
import io.sentry.ISocketTagger;

/* JADX INFO: loaded from: classes5.dex */
public final class AndroidSocketTagger implements ISocketTagger {
    private static final AndroidSocketTagger instance = new AndroidSocketTagger();

    private AndroidSocketTagger() {
    }

    public static AndroidSocketTagger getInstance() {
        return instance;
    }

    @Override // io.sentry.ISocketTagger
    public void tagSockets() {
        TrafficStats.setThreadStatsTag(61441);
    }

    @Override // io.sentry.ISocketTagger
    public void untagSockets() {
        TrafficStats.clearThreadStatsTag();
    }
}
