package androidx.compose.ui.text.style;

import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class Hyphens {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int None = m2419constructorimpl(1);
    private static final int Auto = m2419constructorimpl(2);
    private static final int Unspecified = m2419constructorimpl(LinearLayoutManager.INVALID_OFFSET);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Hyphens m2418boximpl(int i) {
        return new Hyphens(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m2419constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2420equalsimpl(int i, Object obj) {
        return (obj instanceof Hyphens) && i == ((Hyphens) obj).m2424unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2421equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2422hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m2420equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2422hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2424unboximpl() {
        return this.value;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getNone-vmbZdU8, reason: not valid java name */
        public final int m2426getNonevmbZdU8() {
            return Hyphens.None;
        }

        /* JADX INFO: renamed from: getAuto-vmbZdU8, reason: not valid java name */
        public final int m2425getAutovmbZdU8() {
            return Hyphens.Auto;
        }

        /* JADX INFO: renamed from: getUnspecified-vmbZdU8, reason: not valid java name */
        public final int m2427getUnspecifiedvmbZdU8() {
            return Hyphens.Unspecified;
        }
    }

    private /* synthetic */ Hyphens(int i) {
        this.value = i;
    }

    public String toString() {
        return m2423toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2423toStringimpl(int i) {
        if (m2421equalsimpl0(i, None)) {
            return "Hyphens.None";
        }
        if (m2421equalsimpl0(i, Auto)) {
            return "Hyphens.Auto";
        }
        return m2421equalsimpl0(i, Unspecified) ? "Hyphens.Unspecified" : "Invalid";
    }
}
