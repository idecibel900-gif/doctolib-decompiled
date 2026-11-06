package androidx.compose.ui.graphics;

/* JADX INFO: loaded from: classes.dex */
public interface ImageBitmap {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: renamed from: getConfig-_sVssgQ */
    int mo1281getConfig_sVssgQ();

    int getHeight();

    int getWidth();

    void prepareToDraw();

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
