package expo.modules.updates.loader;

/* JADX INFO: loaded from: classes5.dex */
public interface FileDownloadProgressListener {
    void onProgressUpdate(double d);

    void update(long j, long j2);

    public static final class DefaultImpls {
        public static void update(FileDownloadProgressListener fileDownloadProgressListener, long j, long j2) {
            if (j2 > 0) {
                fileDownloadProgressListener.onProgressUpdate(j / j2);
            }
        }
    }
}
