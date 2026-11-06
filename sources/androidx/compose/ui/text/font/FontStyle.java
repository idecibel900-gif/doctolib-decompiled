package androidx.compose.ui.text.font;

import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class FontStyle {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Normal = m2282constructorimpl(0);
    private static final int Italic = m2282constructorimpl(1);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FontStyle m2281boximpl(int i) {
        return new FontStyle(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m2282constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2283equalsimpl(int i, Object obj) {
        return (obj instanceof FontStyle) && i == ((FontStyle) obj).m2287unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2284equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2285hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m2283equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2285hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2287unboximpl() {
        return this.value;
    }

    private /* synthetic */ FontStyle(int i) {
        this.value = i;
    }

    public String toString() {
        return m2286toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2286toStringimpl(int i) {
        if (m2284equalsimpl0(i, Normal)) {
            return ReactProgressBarViewManager.DEFAULT_STYLE;
        }
        return m2284equalsimpl0(i, Italic) ? "Italic" : "Invalid";
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getNormal-_-LCdwA, reason: not valid java name */
        public final int m2289getNormal_LCdwA() {
            return FontStyle.Normal;
        }

        /* JADX INFO: renamed from: getItalic-_-LCdwA, reason: not valid java name */
        public final int m2288getItalic_LCdwA() {
            return FontStyle.Italic;
        }
    }
}
