package com.facebook.imagepipeline.common;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public enum Priority {
    LOW,
    MEDIUM,
    HIGH;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final Companion Companion = new Companion(null);

    public static final Priority getHigherPriority(Priority priority, Priority priority2) {
        return Companion.getHigherPriority(priority, priority2);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Priority getHigherPriority(Priority priority1, Priority priority2) {
            Intrinsics.checkNotNullParameter(priority1, "priority1");
            Intrinsics.checkNotNullParameter(priority2, "priority2");
            return priority1.ordinal() > priority2.ordinal() ? priority1 : priority2;
        }
    }
}
