package coil.disk;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;
import okio.ByteString;
import okio.FileSystem;
import okio.Path;

/* JADX INFO: loaded from: classes3.dex */
public final class RealDiskCache implements DiskCache {
    public static final Companion Companion = new Companion(null);
    private final DiskLruCache cache;
    private final Path directory;
    private final FileSystem fileSystem;
    private final long maxSize;

    public RealDiskCache(long j, Path path, FileSystem fileSystem, CoroutineDispatcher coroutineDispatcher) {
        this.maxSize = j;
        this.directory = path;
        this.fileSystem = fileSystem;
        this.cache = new DiskLruCache(getFileSystem(), getDirectory(), coroutineDispatcher, getMaxSize(), 1, 2);
    }

    public long getMaxSize() {
        return this.maxSize;
    }

    public Path getDirectory() {
        return this.directory;
    }

    @Override // coil.disk.DiskCache
    public FileSystem getFileSystem() {
        return this.fileSystem;
    }

    @Override // coil.disk.DiskCache
    public DiskCache.Snapshot openSnapshot(String str) {
        DiskLruCache.Snapshot snapshot = this.cache.get(hash(str));
        if (snapshot != null) {
            return new RealSnapshot(snapshot);
        }
        return null;
    }

    @Override // coil.disk.DiskCache
    public DiskCache.Editor openEditor(String str) {
        DiskLruCache.Editor editorEdit = this.cache.edit(hash(str));
        if (editorEdit != null) {
            return new RealEditor(editorEdit);
        }
        return null;
    }

    private final String hash(String str) {
        return ByteString.Companion.encodeUtf8(str).sha256().hex();
    }

    private static final class RealSnapshot implements DiskCache.Snapshot {
        private final DiskLruCache.Snapshot snapshot;

        public RealSnapshot(DiskLruCache.Snapshot snapshot) {
            this.snapshot = snapshot;
        }

        @Override // coil.disk.DiskCache.Snapshot
        public Path getMetadata() {
            return this.snapshot.file(0);
        }

        @Override // coil.disk.DiskCache.Snapshot
        public Path getData() {
            return this.snapshot.file(1);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.snapshot.close();
        }

        @Override // coil.disk.DiskCache.Snapshot
        public RealEditor closeAndOpenEditor() {
            DiskLruCache.Editor editorCloseAndEdit = this.snapshot.closeAndEdit();
            if (editorCloseAndEdit != null) {
                return new RealEditor(editorCloseAndEdit);
            }
            return null;
        }
    }

    private static final class RealEditor implements DiskCache.Editor {
        private final DiskLruCache.Editor editor;

        public RealEditor(DiskLruCache.Editor editor) {
            this.editor = editor;
        }

        @Override // coil.disk.DiskCache.Editor
        public Path getMetadata() {
            return this.editor.file(0);
        }

        @Override // coil.disk.DiskCache.Editor
        public Path getData() {
            return this.editor.file(1);
        }

        @Override // coil.disk.DiskCache.Editor
        public RealSnapshot commitAndOpenSnapshot() {
            DiskLruCache.Snapshot snapshotCommitAndGet = this.editor.commitAndGet();
            if (snapshotCommitAndGet != null) {
                return new RealSnapshot(snapshotCommitAndGet);
            }
            return null;
        }

        @Override // coil.disk.DiskCache.Editor
        public void abort() {
            this.editor.abort();
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
