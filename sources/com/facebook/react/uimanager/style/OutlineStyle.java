package com.facebook.react.uimanager.style;

import java.util.Locale;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public enum OutlineStyle {
    SOLID,
    DASHED,
    DOTTED;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final Companion Companion = new Companion(null);

    public static final OutlineStyle fromString(String str) {
        return Companion.fromString(str);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final OutlineStyle fromString(String outlineStyle) {
            Intrinsics.checkNotNullParameter(outlineStyle, "outlineStyle");
            String lowerCase = outlineStyle.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            int iHashCode = lowerCase.hashCode();
            if (iHashCode == -1338941519) {
                if (lowerCase.equals("dashed")) {
                    return OutlineStyle.DASHED;
                }
                return null;
            }
            if (iHashCode == -1325970902) {
                if (lowerCase.equals("dotted")) {
                    return OutlineStyle.DOTTED;
                }
                return null;
            }
            if (iHashCode == 109618859 && lowerCase.equals("solid")) {
                return OutlineStyle.SOLID;
            }
            return null;
        }
    }
}
