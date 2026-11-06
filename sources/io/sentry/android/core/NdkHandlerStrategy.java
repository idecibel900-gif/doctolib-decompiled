package io.sentry.android.core;

/* JADX INFO: loaded from: classes5.dex */
public enum NdkHandlerStrategy {
    SENTRY_HANDLER_STRATEGY_DEFAULT(0),
    SENTRY_HANDLER_STRATEGY_CHAIN_AT_START(1);

    private final int value;

    NdkHandlerStrategy(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
