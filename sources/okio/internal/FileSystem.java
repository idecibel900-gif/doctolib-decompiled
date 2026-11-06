package okio.internal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;
import okio.FileMetadata;
import okio.Path;

/* JADX INFO: renamed from: okio.internal.-FileSystem, reason: invalid class name */
/* JADX INFO: loaded from: classes5.dex */
public abstract class FileSystem {
    public static final FileMetadata commonMetadata(okio.FileSystem fileSystem, Path path) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        FileMetadata fileMetadataMetadataOrNull = fileSystem.metadataOrNull(path);
        if (fileMetadataMetadataOrNull != null) {
            return fileMetadataMetadataOrNull;
        }
        throw new FileNotFoundException("no such file: " + path);
    }

    public static final boolean commonExists(okio.FileSystem fileSystem, Path path) {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        return fileSystem.metadataOrNull(path) != null;
    }

    public static final void commonCreateDirectories(okio.FileSystem fileSystem, Path dir, boolean z) {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(dir, "dir");
        ArrayDeque arrayDeque = new ArrayDeque();
        for (Path pathParent = dir; pathParent != null && !fileSystem.exists(pathParent); pathParent = pathParent.parent()) {
            arrayDeque.addFirst(pathParent);
        }
        if (z && arrayDeque.isEmpty()) {
            throw new IOException(dir + " already exists.");
        }
        Iterator<E> it = arrayDeque.iterator();
        while (it.hasNext()) {
            fileSystem.createDirectory((Path) it.next());
        }
    }
}
