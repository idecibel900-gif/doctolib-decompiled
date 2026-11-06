package androidx.compose.ui.graphics;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class CompositingStrategy {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Auto = m1396constructorimpl(0);
    private static final int Offscreen = m1396constructorimpl(1);
    private static final int ModulateAlpha = m1396constructorimpl(2);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ CompositingStrategy m1395boximpl(int i) {
        return new CompositingStrategy(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1396constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1397equalsimpl(int i, Object obj) {
        return (obj instanceof CompositingStrategy) && i == ((CompositingStrategy) obj).m1401unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1398equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1399hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1400toStringimpl(int i) {
        return "CompositingStrategy(value=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m1397equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1399hashCodeimpl(this.value);
    }

    public String toString() {
        return m1400toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1401unboximpl() {
        return this.value;
    }

    private /* synthetic */ CompositingStrategy(int i) {
        this.value = i;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getAuto--NrFUSI, reason: not valid java name */
        public final int m1402getAutoNrFUSI() {
            return CompositingStrategy.Auto;
        }

        /* JADX INFO: renamed from: getOffscreen--NrFUSI, reason: not valid java name */
        public final int m1404getOffscreenNrFUSI() {
            return CompositingStrategy.Offscreen;
        }

        /* JADX INFO: renamed from: getModulateAlpha--NrFUSI, reason: not valid java name */
        public final int m1403getModulateAlphaNrFUSI() {
            return CompositingStrategy.ModulateAlpha;
        }
    }
}
