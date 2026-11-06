package com.swmansion.enriched.markdown.styles;

import android.text.Layout;
import java.util.Locale;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'LEFT' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:160)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes4.dex */
public final class TextAlignment {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TextAlignment[] $VALUES;
    public static final TextAlignment AUTO;
    public static final TextAlignment CENTER;
    public static final Companion Companion;
    public static final TextAlignment JUSTIFY;
    public static final TextAlignment LEFT;
    public static final TextAlignment RIGHT;
    private final Layout.Alignment layoutAlignment;
    private final boolean needsJustify;

    private static final /* synthetic */ TextAlignment[] $values() {
        return new TextAlignment[]{LEFT, CENTER, RIGHT, JUSTIFY, AUTO};
    }

    private TextAlignment(String str, int i, Layout.Alignment alignment, boolean z) {
        super(str, i);
        this.layoutAlignment = alignment;
        this.needsJustify = z;
    }

    public final Layout.Alignment getLayoutAlignment() {
        return this.layoutAlignment;
    }

    public final boolean getNeedsJustify() {
        return this.needsJustify;
    }

    static {
        Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
        LEFT = new TextAlignment("LEFT", 0, alignment, false);
        CENTER = new TextAlignment("CENTER", 1, Layout.Alignment.ALIGN_CENTER, false);
        RIGHT = new TextAlignment("RIGHT", 2, Layout.Alignment.ALIGN_OPPOSITE, false);
        JUSTIFY = new TextAlignment("JUSTIFY", 3, alignment, true);
        AUTO = new TextAlignment("AUTO", 4, alignment, false);
        TextAlignment[] textAlignmentArr$values = $values();
        $VALUES = textAlignmentArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(textAlignmentArr$values);
        Companion = new Companion(null);
    }

    public final boolean getNeedsAlignmentSpan() {
        return this == CENTER || this == RIGHT;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final TextAlignment fromString(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            String lowerCase = value.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            switch (lowerCase.hashCode()) {
                case -1364013995:
                    if (lowerCase.equals("center")) {
                        return TextAlignment.CENTER;
                    }
                    break;
                case -1249482096:
                    if (lowerCase.equals("justify")) {
                        return TextAlignment.JUSTIFY;
                    }
                    break;
                case 3005871:
                    if (lowerCase.equals("auto")) {
                        return TextAlignment.AUTO;
                    }
                    break;
                case 108511772:
                    if (lowerCase.equals("right")) {
                        return TextAlignment.RIGHT;
                    }
                    break;
            }
            return TextAlignment.LEFT;
        }
    }

    public static TextAlignment valueOf(String str) {
        return (TextAlignment) Enum.valueOf(TextAlignment.class, str);
    }

    public static TextAlignment[] values() {
        return (TextAlignment[]) $VALUES.clone();
    }
}
