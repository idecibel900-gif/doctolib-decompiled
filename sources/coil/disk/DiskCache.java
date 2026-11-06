package coil.disk;

import android.os.StatFs;
import java.io.Closeable;
import java.io.File;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import okio.FileSystem;
import okio.Path;

/* JADX INFO: loaded from: classes3.dex */
public interface DiskCache {

    public interface Editor {
        void abort();

        Snapshot commitAndOpenSnapshot();

        Path getData();

        Path getMetadata();
    }

    public interface Snapshot extends Closeable {
        Editor closeAndOpenEditor();

        Path getData();

        Path getMetadata();
    }

    FileSystem getFileSystem();

    Editor openEditor(String str);

    Snapshot openSnapshot(String str);

    public static final class Builder {
        private Path directory;
        private long maxSizeBytes;
        private FileSystem fileSystem = FileSystem.SYSTEM;
        private double maxSizePercent = 0.02d;
        private long minimumMaxSizeBytes = 10485760;
        private long maximumMaxSizeBytes = 262144000;
        private CoroutineDispatcher cleanupDispatcher = Dispatchers.getIO();

        public final Builder directory(File file) {
            return directory(Path.Companion.get$default(Path.Companion, file, false, 1, (Object) null));
        }

        public final Builder directory(Path path) {
            this.directory = path;
            return this;
        }

        public final Builder maxSizeBytes(long j) {
            if (j <= 0) {
                throw new IllegalArgumentException("size must be > 0.");
            }
            this.maxSizePercent = 0.0d;
            this.maxSizeBytes = j;
            return this;
        }

        public final DiskCache build() {
            long jCoerceIn;
            Path path = this.directory;
            if (path == null) {
                throw new IllegalStateException("directory == null");
            }
            if (this.maxSizePercent > 0.0d) {
                try {
                    File file = path.toFile();
                    file.mkdir();
                    StatFs statFs = new StatFs(file.getAbsolutePath());
                    jCoerceIn = RangesKt.coerceIn((long) (this.maxSizePercent * statFs.getBlockCountLong() * statFs.getBlockSizeLong()), this.minimumMaxSizeBytes, this.maximumMaxSizeBytes);
                } catch (Exception unused) {
                    jCoerceIn = this.minimumMaxSizeBytes;
                }
            } else {
                jCoerceIn = this.maxSizeBytes;
            }
            return new RealDiskCache(jCoerceIn, path, this.fileSystem, this.cleanupDispatcher);
        }
    }
}
