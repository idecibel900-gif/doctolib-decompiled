package androidx.compose.ui.focus;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
abstract class FocusInteropUtils {
    public static final Companion Companion = new Companion(null);
    private static final int[] tempCoordinates = new int[2];

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int[] getTempCoordinates() {
            return FocusInteropUtils.tempCoordinates;
        }
    }
}
