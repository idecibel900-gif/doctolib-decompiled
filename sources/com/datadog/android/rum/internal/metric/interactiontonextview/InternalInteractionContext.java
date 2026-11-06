package com.datadog.android.rum.internal.metric.interactiontonextview;

import com.datadog.android.rum.model.ActionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class InternalInteractionContext {
    private final ActionEvent.ActionEventActionType actionType;
    private final long eventCreatedAtNanos;
    private final String viewId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InternalInteractionContext)) {
            return false;
        }
        InternalInteractionContext internalInteractionContext = (InternalInteractionContext) obj;
        return Intrinsics.areEqual(this.viewId, internalInteractionContext.viewId) && this.actionType == internalInteractionContext.actionType && this.eventCreatedAtNanos == internalInteractionContext.eventCreatedAtNanos;
    }

    public int hashCode() {
        return (((this.viewId.hashCode() * 31) + this.actionType.hashCode()) * 31) + Long.hashCode(this.eventCreatedAtNanos);
    }

    public String toString() {
        return "InternalInteractionContext(viewId=" + this.viewId + ", actionType=" + this.actionType + ", eventCreatedAtNanos=" + this.eventCreatedAtNanos + ")";
    }

    public InternalInteractionContext(String viewId, ActionEvent.ActionEventActionType actionType, long j) {
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        this.viewId = viewId;
        this.actionType = actionType;
        this.eventCreatedAtNanos = j;
    }

    public final String getViewId$dd_sdk_android_rum_release() {
        return this.viewId;
    }

    public final ActionEvent.ActionEventActionType getActionType$dd_sdk_android_rum_release() {
        return this.actionType;
    }

    public final long getEventCreatedAtNanos$dd_sdk_android_rum_release() {
        return this.eventCreatedAtNanos;
    }
}
