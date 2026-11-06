package com.datadog.android.rum.internal.monitor;

import com.datadog.android.rum.model.ActionEvent;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class StorageEvent {
    public /* synthetic */ StorageEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private StorageEvent() {
    }

    public static final class Action extends StorageEvent {
        private final long eventEndTimestampInNanos;
        private final int frustrationCount;
        private final ActionEvent.ActionEventActionType type;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Action)) {
                return false;
            }
            Action action = (Action) obj;
            return this.frustrationCount == action.frustrationCount && this.type == action.type && this.eventEndTimestampInNanos == action.eventEndTimestampInNanos;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.frustrationCount) * 31) + this.type.hashCode()) * 31) + Long.hashCode(this.eventEndTimestampInNanos);
        }

        public String toString() {
            return "Action(frustrationCount=" + this.frustrationCount + ", type=" + this.type + ", eventEndTimestampInNanos=" + this.eventEndTimestampInNanos + ")";
        }

        public final int getFrustrationCount() {
            return this.frustrationCount;
        }

        public final ActionEvent.ActionEventActionType getType() {
            return this.type;
        }

        public final long getEventEndTimestampInNanos() {
            return this.eventEndTimestampInNanos;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Action(int i, ActionEvent.ActionEventActionType type, long j) {
            super(null);
            Intrinsics.checkNotNullParameter(type, "type");
            this.frustrationCount = i;
            this.type = type;
            this.eventEndTimestampInNanos = j;
        }
    }

    public static final class Resource extends StorageEvent {
        private final String resourceId;
        private final long resourceStopTimestampInNanos;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Resource)) {
                return false;
            }
            Resource resource = (Resource) obj;
            return Intrinsics.areEqual(this.resourceId, resource.resourceId) && this.resourceStopTimestampInNanos == resource.resourceStopTimestampInNanos;
        }

        public int hashCode() {
            return (this.resourceId.hashCode() * 31) + Long.hashCode(this.resourceStopTimestampInNanos);
        }

        public String toString() {
            return "Resource(resourceId=" + this.resourceId + ", resourceStopTimestampInNanos=" + this.resourceStopTimestampInNanos + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Resource(String resourceId, long j) {
            super(null);
            Intrinsics.checkNotNullParameter(resourceId, "resourceId");
            this.resourceId = resourceId;
            this.resourceStopTimestampInNanos = j;
        }

        public final String getResourceId() {
            return this.resourceId;
        }

        public final long getResourceStopTimestampInNanos() {
            return this.resourceStopTimestampInNanos;
        }
    }

    public static final class Error extends StorageEvent {
        private final String resourceId;
        private final Long resourceStopTimestampInNanos;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Error)) {
                return false;
            }
            Error error = (Error) obj;
            return Intrinsics.areEqual(this.resourceId, error.resourceId) && Intrinsics.areEqual(this.resourceStopTimestampInNanos, error.resourceStopTimestampInNanos);
        }

        public int hashCode() {
            String str = this.resourceId;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            Long l = this.resourceStopTimestampInNanos;
            return iHashCode + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            return "Error(resourceId=" + this.resourceId + ", resourceStopTimestampInNanos=" + this.resourceStopTimestampInNanos + ")";
        }

        public Error(String str, Long l) {
            super(null);
            this.resourceId = str;
            this.resourceStopTimestampInNanos = l;
        }

        public /* synthetic */ Error(String str, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l);
        }

        public final String getResourceId() {
            return this.resourceId;
        }

        public final Long getResourceStopTimestampInNanos() {
            return this.resourceStopTimestampInNanos;
        }
    }

    public static final class LongTask extends StorageEvent {
        public static final LongTask INSTANCE = new LongTask();

        private LongTask() {
            super(null);
        }
    }

    public static final class FrozenFrame extends StorageEvent {
        public static final FrozenFrame INSTANCE = new FrozenFrame();

        private FrozenFrame() {
            super(null);
        }
    }
}
