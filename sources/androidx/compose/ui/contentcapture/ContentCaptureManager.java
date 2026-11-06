package androidx.compose.ui.contentcapture;

/* JADX INFO: loaded from: classes.dex */
public interface ContentCaptureManager {
    public static final Companion Companion = Companion.$$INSTANCE;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static boolean isEnabled = true;

        private Companion() {
        }

        public final boolean isEnabled() {
            return isEnabled;
        }
    }
}
