package com.datadog.android.rum.metric.interactiontonextview;

import com.datadog.android.rum.model.ActionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class PreviousViewLastInteractionContext {
    private final ActionEvent.ActionEventActionType actionType;
    private final Long currentViewCreationTimestamp;
    private final long eventCreatedAtNanos;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PreviousViewLastInteractionContext)) {
            return false;
        }
        PreviousViewLastInteractionContext previousViewLastInteractionContext = (PreviousViewLastInteractionContext) obj;
        return this.actionType == previousViewLastInteractionContext.actionType && this.eventCreatedAtNanos == previousViewLastInteractionContext.eventCreatedAtNanos && Intrinsics.areEqual(this.currentViewCreationTimestamp, previousViewLastInteractionContext.currentViewCreationTimestamp);
    }

    public int hashCode() {
        int iHashCode = ((this.actionType.hashCode() * 31) + Long.hashCode(this.eventCreatedAtNanos)) * 31;
        Long l = this.currentViewCreationTimestamp;
        return iHashCode + (l == null ? 0 : l.hashCode());
    }

    public String toString() {
        return "PreviousViewLastInteractionContext(actionType=" + this.actionType + ", eventCreatedAtNanos=" + this.eventCreatedAtNanos + ", currentViewCreationTimestamp=" + this.currentViewCreationTimestamp + ")";
    }

    public PreviousViewLastInteractionContext(ActionEvent.ActionEventActionType actionType, long j, Long l) {
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        this.actionType = actionType;
        this.eventCreatedAtNanos = j;
        this.currentViewCreationTimestamp = l;
    }

    public final long getEventCreatedAtNanos() {
        return this.eventCreatedAtNanos;
    }

    public final Long getCurrentViewCreationTimestamp() {
        return this.currentViewCreationTimestamp;
    }
}
