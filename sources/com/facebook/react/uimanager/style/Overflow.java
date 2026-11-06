package com.facebook.react.uimanager.style;

import java.util.Locale;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public enum Overflow {
    VISIBLE,
    HIDDEN,
    SCROLL;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final Companion Companion = new Companion(null);

    public static final Overflow fromString(String str) {
        return Companion.fromString(str);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Overflow fromString(String overflow) {
            Intrinsics.checkNotNullParameter(overflow, "overflow");
            String lowerCase = overflow.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            int iHashCode = lowerCase.hashCode();
            if (iHashCode == -1217487446) {
                if (lowerCase.equals("hidden")) {
                    return Overflow.HIDDEN;
                }
                return null;
            }
            if (iHashCode == -907680051) {
                if (lowerCase.equals("scroll")) {
                    return Overflow.SCROLL;
                }
                return null;
            }
            if (iHashCode == 466743410 && lowerCase.equals("visible")) {
                return Overflow.VISIBLE;
            }
            return null;
        }
    }
}
