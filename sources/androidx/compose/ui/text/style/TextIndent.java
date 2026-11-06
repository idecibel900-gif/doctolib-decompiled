package androidx.compose.ui.text.style;

import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class TextIndent {
    public static final Companion Companion = new Companion(null);
    private static final TextIndent None = new TextIndent(0, 0, 3, null);
    private final long firstLine;
    private final long restLine;

    public /* synthetic */ TextIndent(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2);
    }

    private TextIndent(long j, long j2) {
        this.firstLine = j;
        this.restLine = j2;
    }

    public /* synthetic */ TextIndent(long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? TextUnitKt.getSp(0) : j, (i & 2) != 0 ? TextUnitKt.getSp(0) : j2, null);
    }

    /* JADX INFO: renamed from: getFirstLine-XSAIIZE, reason: not valid java name */
    public final long m2503getFirstLineXSAIIZE() {
        return this.firstLine;
    }

    /* JADX INFO: renamed from: getRestLine-XSAIIZE, reason: not valid java name */
    public final long m2504getRestLineXSAIIZE() {
        return this.restLine;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TextIndent getNone() {
            return TextIndent.None;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextIndent)) {
            return false;
        }
        TextIndent textIndent = (TextIndent) obj;
        return TextUnit.m2619equalsimpl0(this.firstLine, textIndent.firstLine) && TextUnit.m2619equalsimpl0(this.restLine, textIndent.restLine);
    }

    public int hashCode() {
        return (TextUnit.m2623hashCodeimpl(this.firstLine) * 31) + TextUnit.m2623hashCodeimpl(this.restLine);
    }

    public String toString() {
        return "TextIndent(firstLine=" + ((Object) TextUnit.m2624toStringimpl(this.firstLine)) + ", restLine=" + ((Object) TextUnit.m2624toStringimpl(this.restLine)) + ')';
    }
}
