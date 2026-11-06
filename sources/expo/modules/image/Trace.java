package expo.modules.image;

/* JADX INFO: loaded from: classes4.dex */
public final class Trace {
    private static int lastCookieValue;
    public static final Trace INSTANCE = new Trace();
    private static final String tag = "ExpoImage";
    private static final String loadNewImageBlock = "load new image";

    private Trace() {
    }

    public final String getTag() {
        return tag;
    }

    public final String getLoadNewImageBlock() {
        return loadNewImageBlock;
    }

    public final int getNextCookieValue() {
        int i;
        synchronized (this) {
            i = lastCookieValue;
            lastCookieValue = i + 1;
        }
        return i;
    }
}
