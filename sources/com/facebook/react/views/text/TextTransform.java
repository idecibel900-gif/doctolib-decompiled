package com.facebook.react.views.text;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public enum TextTransform {
    NONE,
    UPPERCASE,
    LOWERCASE,
    CAPITALIZE,
    UNSET;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String apply(String text, TextTransform textTransform) {
            Intrinsics.checkNotNullParameter(text, "text");
            return TextTransformKt.applyTextTransform(text, textTransform);
        }
    }
}
