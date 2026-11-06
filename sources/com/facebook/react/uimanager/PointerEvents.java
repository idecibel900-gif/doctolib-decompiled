package com.facebook.react.uimanager;

import java.util.Locale;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public enum PointerEvents {
    NONE,
    BOX_NONE,
    BOX_ONLY,
    AUTO;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final Companion Companion = new Companion(null);

    public static final boolean canBeTouchTarget(PointerEvents pointerEvents) {
        return Companion.canBeTouchTarget(pointerEvents);
    }

    public static final boolean canChildrenBeTouchTarget(PointerEvents pointerEvents) {
        return Companion.canChildrenBeTouchTarget(pointerEvents);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PointerEvents parsePointerEvents(String str) {
            if (str == null) {
                return PointerEvents.AUTO;
            }
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String upperCase = str.toUpperCase(US);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            return PointerEvents.valueOf(StringsKt.replace$default(upperCase, "-", "_", false, 4, (Object) null));
        }

        public final boolean canBeTouchTarget(PointerEvents pointerEvents) {
            Intrinsics.checkNotNullParameter(pointerEvents, "pointerEvents");
            return pointerEvents == PointerEvents.AUTO || pointerEvents == PointerEvents.BOX_ONLY;
        }

        public final boolean canChildrenBeTouchTarget(PointerEvents pointerEvents) {
            Intrinsics.checkNotNullParameter(pointerEvents, "pointerEvents");
            return pointerEvents == PointerEvents.AUTO || pointerEvents == PointerEvents.BOX_NONE;
        }
    }
}
