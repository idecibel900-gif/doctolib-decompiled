package okio;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.internal.ResourceFileSystem;

/* JADX INFO: loaded from: classes5.dex */
public abstract class FileSystem {
    public static final Companion Companion = new Companion(null);
    public static final FileSystem RESOURCES;
    public static final FileSystem SYSTEM;
    public static final Path SYSTEM_TEMPORARY_DIRECTORY;

    public abstract Sink appendingSink(Path path, boolean z);

    public abstract void atomicMove(Path path, Path path2);

    public abstract void createDirectory(Path path, boolean z);

    public abstract void delete(Path path, boolean z);

    public abstract List list(Path path);

    public abstract FileMetadata metadataOrNull(Path path);

    public abstract FileHandle openReadOnly(Path path);

    public abstract Sink sink(Path path, boolean z);

    public abstract Source source(Path path);

    public final FileMetadata metadata(Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return okio.internal.FileSystem.commonMetadata(this, path);
    }

    public final boolean exists(Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return okio.internal.FileSystem.commonExists(this, path);
    }

    public final Sink sink(Path file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return sink(file, false);
    }

    public final Sink appendingSink(Path file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return appendingSink(file, false);
    }

    public final void createDirectory(Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        createDirectory(dir, false);
    }

    public final void createDirectories(Path dir, boolean z) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        okio.internal.FileSystem.commonCreateDirectories(this, dir, z);
    }

    public final void createDirectories(Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        createDirectories(dir, false);
    }

    public final void delete(Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        delete(path, false);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        FileSystem jvmSystemFileSystem;
        try {
            Class.forName("java.nio.file.Files");
            jvmSystemFileSystem = new NioSystemFileSystem();
        } catch (ClassNotFoundException unused) {
            jvmSystemFileSystem = new JvmSystemFileSystem();
        }
        SYSTEM = jvmSystemFileSystem;
        Path.Companion companion = Path.Companion;
        String property = System.getProperty("java.io.tmpdir");
        Intrinsics.checkNotNullExpressionValue(property, "getProperty(...)");
        SYSTEM_TEMPORARY_DIRECTORY = Path.Companion.get$default(companion, property, false, 1, (Object) null);
        ClassLoader classLoader = ResourceFileSystem.class.getClassLoader();
        Intrinsics.checkNotNullExpressionValue(classLoader, "getClassLoader(...)");
        RESOURCES = new ResourceFileSystem(classLoader, false, null, 4, null);
    }
}
