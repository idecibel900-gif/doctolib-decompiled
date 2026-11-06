package com.datadog.android.core.internal.metrics;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public abstract class RemovalReason {
    public /* synthetic */ RemovalReason(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private RemovalReason() {
    }

    public final boolean includeInMetrics$dd_sdk_android_core_release() {
        return !(this instanceof Flushed);
    }

    public static final class IntakeCode extends RemovalReason {
        private final int responseCode;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof IntakeCode) && this.responseCode == ((IntakeCode) obj).responseCode;
        }

        public int hashCode() {
            return Integer.hashCode(this.responseCode);
        }

        public IntakeCode(int i) {
            super(null);
            this.responseCode = i;
        }

        public String toString() {
            return "intake-code-" + this.responseCode;
        }
    }

    public static final class Invalid extends RemovalReason {
        public static final Invalid INSTANCE = new Invalid();

        private Invalid() {
            super(null);
        }

        public String toString() {
            return "invalid";
        }
    }

    public static final class Purged extends RemovalReason {
        public static final Purged INSTANCE = new Purged();

        private Purged() {
            super(null);
        }

        public String toString() {
            return "purged";
        }
    }

    public static final class Obsolete extends RemovalReason {
        public static final Obsolete INSTANCE = new Obsolete();

        private Obsolete() {
            super(null);
        }

        public String toString() {
            return "obsolete";
        }
    }

    public static final class Flushed extends RemovalReason {
        public static final Flushed INSTANCE = new Flushed();

        private Flushed() {
            super(null);
        }

        public String toString() {
            return "flushed";
        }
    }
}
