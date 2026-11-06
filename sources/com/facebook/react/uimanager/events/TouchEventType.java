package com.facebook.react.uimanager.events;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public enum TouchEventType {
    START("topTouchStart"),
    END("topTouchEnd"),
    MOVE("topTouchMove"),
    CANCEL("topTouchCancel");

    private final String jsName;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final Companion Companion = new Companion(null);

    TouchEventType(String str) {
        this.jsName = str;
    }

    public final String getJsName() {
        return this.jsName;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getJSEventName(TouchEventType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return type.getJsName();
        }
    }
}
