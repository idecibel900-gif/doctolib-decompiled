package androidx.compose.ui.autofill;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public abstract class ContentDataType {
    public static final Companion Companion = new Companion(null);
    private static final int Text = m1124constructorimpl(1);
    private static final int List = m1124constructorimpl(3);
    private static final int Date = m1124constructorimpl(4);
    private static final int Toggle = m1124constructorimpl(2);
    private static final int None = m1124constructorimpl(0);

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1124constructorimpl(int i) {
        return i;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getText-A48pgw8, reason: not valid java name */
        public final int m1125getTextA48pgw8() {
            return ContentDataType.Text;
        }
    }
}
