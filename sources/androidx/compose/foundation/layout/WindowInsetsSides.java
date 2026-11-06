package androidx.compose.foundation.layout;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class WindowInsetsSides {
    private static final int AllowLeftInLtr;
    private static final int AllowLeftInRtl;
    private static final int AllowRightInLtr;
    private static final int AllowRightInRtl;
    private static final int Bottom;
    public static final Companion Companion = new Companion(null);
    private static final int End;
    private static final int Horizontal;
    private static final int Left;
    private static final int Right;
    private static final int Start;
    private static final int Top;
    private static final int Vertical;

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m348constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m349equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hasAny-bkgdKaI$foundation_layout_release, reason: not valid java name */
    public static final boolean m350hasAnybkgdKaI$foundation_layout_release(int i, int i2) {
        return (i & i2) != 0;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m351hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: plus-gK_yJZ4, reason: not valid java name */
    public static final int m352plusgK_yJZ4(int i, int i2) {
        return m348constructorimpl(i | i2);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m353toStringimpl(int i) {
        return "WindowInsetsSides(" + m354valueToStringimpl(i) + ')';
    }

    /* JADX INFO: renamed from: valueToString-impl, reason: not valid java name */
    private static final String m354valueToStringimpl(int i) {
        StringBuilder sb = new StringBuilder();
        int i2 = Start;
        if ((i & i2) == i2) {
            valueToString_impl$lambda$0$appendPlus(sb, "Start");
        }
        int i3 = Left;
        if ((i & i3) == i3) {
            valueToString_impl$lambda$0$appendPlus(sb, "Left");
        }
        int i4 = Top;
        if ((i & i4) == i4) {
            valueToString_impl$lambda$0$appendPlus(sb, "Top");
        }
        int i5 = End;
        if ((i & i5) == i5) {
            valueToString_impl$lambda$0$appendPlus(sb, "End");
        }
        int i6 = Right;
        if ((i & i6) == i6) {
            valueToString_impl$lambda$0$appendPlus(sb, "Right");
        }
        int i7 = Bottom;
        if ((i & i7) == i7) {
            valueToString_impl$lambda$0$appendPlus(sb, "Bottom");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    private static final void valueToString_impl$lambda$0$appendPlus(StringBuilder sb, String str) {
        if (sb.length() > 0) {
            sb.append('+');
        }
        sb.append(str);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getAllowLeftInLtr-JoeWqyM$foundation_layout_release, reason: not valid java name */
        public final int m355getAllowLeftInLtrJoeWqyM$foundation_layout_release() {
            return WindowInsetsSides.AllowLeftInLtr;
        }

        /* JADX INFO: renamed from: getAllowRightInLtr-JoeWqyM$foundation_layout_release, reason: not valid java name */
        public final int m357getAllowRightInLtrJoeWqyM$foundation_layout_release() {
            return WindowInsetsSides.AllowRightInLtr;
        }

        /* JADX INFO: renamed from: getAllowLeftInRtl-JoeWqyM$foundation_layout_release, reason: not valid java name */
        public final int m356getAllowLeftInRtlJoeWqyM$foundation_layout_release() {
            return WindowInsetsSides.AllowLeftInRtl;
        }

        /* JADX INFO: renamed from: getAllowRightInRtl-JoeWqyM$foundation_layout_release, reason: not valid java name */
        public final int m358getAllowRightInRtlJoeWqyM$foundation_layout_release() {
            return WindowInsetsSides.AllowRightInRtl;
        }

        /* JADX INFO: renamed from: getTop-JoeWqyM, reason: not valid java name */
        public final int m361getTopJoeWqyM() {
            return WindowInsetsSides.Top;
        }

        /* JADX INFO: renamed from: getBottom-JoeWqyM, reason: not valid java name */
        public final int m359getBottomJoeWqyM() {
            return WindowInsetsSides.Bottom;
        }

        /* JADX INFO: renamed from: getHorizontal-JoeWqyM, reason: not valid java name */
        public final int m360getHorizontalJoeWqyM() {
            return WindowInsetsSides.Horizontal;
        }
    }

    static {
        int iM348constructorimpl = m348constructorimpl(8);
        AllowLeftInLtr = iM348constructorimpl;
        int iM348constructorimpl2 = m348constructorimpl(4);
        AllowRightInLtr = iM348constructorimpl2;
        int iM348constructorimpl3 = m348constructorimpl(2);
        AllowLeftInRtl = iM348constructorimpl3;
        int iM348constructorimpl4 = m348constructorimpl(1);
        AllowRightInRtl = iM348constructorimpl4;
        Start = m352plusgK_yJZ4(iM348constructorimpl, iM348constructorimpl4);
        End = m352plusgK_yJZ4(iM348constructorimpl2, iM348constructorimpl3);
        int iM348constructorimpl5 = m348constructorimpl(16);
        Top = iM348constructorimpl5;
        int iM348constructorimpl6 = m348constructorimpl(32);
        Bottom = iM348constructorimpl6;
        int iM352plusgK_yJZ4 = m352plusgK_yJZ4(iM348constructorimpl, iM348constructorimpl3);
        Left = iM352plusgK_yJZ4;
        int iM352plusgK_yJZ5 = m352plusgK_yJZ4(iM348constructorimpl2, iM348constructorimpl4);
        Right = iM352plusgK_yJZ5;
        Horizontal = m352plusgK_yJZ4(iM352plusgK_yJZ4, iM352plusgK_yJZ5);
        Vertical = m352plusgK_yJZ4(iM348constructorimpl5, iM348constructorimpl6);
    }
}
