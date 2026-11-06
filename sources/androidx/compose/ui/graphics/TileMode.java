package androidx.compose.ui.graphics;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public abstract class TileMode {
    public static final Companion Companion = new Companion(null);
    private static final int Clamp = m1510constructorimpl(0);
    private static final int Repeated = m1510constructorimpl(1);
    private static final int Mirror = m1510constructorimpl(2);
    private static final int Decal = m1510constructorimpl(3);

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1510constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1511equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1512hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getClamp-3opZhB0, reason: not valid java name */
        public final int m1514getClamp3opZhB0() {
            return TileMode.Clamp;
        }

        /* JADX INFO: renamed from: getRepeated-3opZhB0, reason: not valid java name */
        public final int m1517getRepeated3opZhB0() {
            return TileMode.Repeated;
        }

        /* JADX INFO: renamed from: getMirror-3opZhB0, reason: not valid java name */
        public final int m1516getMirror3opZhB0() {
            return TileMode.Mirror;
        }

        /* JADX INFO: renamed from: getDecal-3opZhB0, reason: not valid java name */
        public final int m1515getDecal3opZhB0() {
            return TileMode.Decal;
        }
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1513toStringimpl(int i) {
        if (m1511equalsimpl0(i, Clamp)) {
            return "Clamp";
        }
        if (m1511equalsimpl0(i, Repeated)) {
            return "Repeated";
        }
        if (m1511equalsimpl0(i, Mirror)) {
            return "Mirror";
        }
        return m1511equalsimpl0(i, Decal) ? "Decal" : "Unknown";
    }
}
