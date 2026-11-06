package com.datadog.android.rum.internal.metric;

/* JADX INFO: loaded from: classes3.dex */
public interface NoValueReason {

    public enum InteractionToNextView implements NoValueReason {
        DISABLED,
        NO_ACTION,
        NO_ELIGIBLE_ACTION,
        NO_PREVIOUS_VIEW,
        UNKNOWN
    }

    public enum TimeToNetworkSettle implements NoValueReason {
        NO_RESOURCES,
        NO_INITIAL_RESOURCES,
        NOT_SETTLED_YET,
        UNKNOWN
    }
}
