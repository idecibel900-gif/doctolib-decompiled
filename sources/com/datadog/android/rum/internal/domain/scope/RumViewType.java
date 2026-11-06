package com.datadog.android.rum.internal.domain.scope;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public enum RumViewType {
    NONE("NONE"),
    FOREGROUND("FOREGROUND"),
    BACKGROUND("BACKGROUND"),
    APPLICATION_LAUNCH("APPLICATION_LAUNCH");

    public static final Companion Companion = new Companion(null);
    private final String asString;

    RumViewType(String str) {
        this.asString = str;
    }

    public final String getAsString() {
        return this.asString;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RumViewType fromString(String str) {
            for (RumViewType rumViewType : RumViewType.values()) {
                if (Intrinsics.areEqual(rumViewType.getAsString(), str)) {
                    return rumViewType;
                }
            }
            return null;
        }
    }
}
