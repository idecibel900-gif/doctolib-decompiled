package com.facebook.fresco.ui.common;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public enum VisibilityState {
    UNKNOWN(-1),
    VISIBLE(1),
    INVISIBLE(2);

    private final int value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final Companion Companion = new Companion(null);
    private static final VisibilityState[] VALUES = values();

    VisibilityState(int i) {
        this.value = i;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
