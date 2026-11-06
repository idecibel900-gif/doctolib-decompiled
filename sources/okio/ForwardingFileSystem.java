package okio;

import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ForwardingFileSystem extends FileSystem {
    private final FileSystem delegate;

    public Path onPathParameter(Path path, String functionName, String parameterName) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(functionName, "functionName");
        Intrinsics.checkNotNullParameter(parameterName, "parameterName");
        return path;
    }

    public Path onPathResult(Path path, String functionName) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(functionName, "functionName");
        return path;
    }

    public ForwardingFileSystem(FileSystem delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // okio.FileSystem
    public FileMetadata metadataOrNull(Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        FileMetadata fileMetadataMetadataOrNull = this.delegate.metadataOrNull(onPathParameter(path, "metadataOrNull", "path"));
        if (fileMetadataMetadataOrNull == null) {
            return null;
        }
        return fileMetadataMetadataOrNull.getSymlinkTarget() == null ? fileMetadataMetadataOrNull : FileMetadata.copy$default(fileMetadataMetadataOrNull, false, false, onPathResult(fileMetadataMetadataOrNull.getSymlinkTarget(), "metadataOrNull"), null, null, null, null, null, 251, null);
    }

    @Override // okio.FileSystem
    public List list(Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        List list = this.delegate.list(onPathParameter(dir, "list", "dir"));
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(onPathResult((Path) it.next(), "list"));
        }
        CollectionsKt.sort(arrayList);
        return arrayList;
    }

    @Override // okio.FileSystem
    public FileHandle openReadOnly(Path file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return this.delegate.openReadOnly(onPathParameter(file, "openReadOnly", "file"));
    }

    @Override // okio.FileSystem
    public Source source(Path file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return this.delegate.source(onPathParameter(file, Constants.ScionAnalytics.PARAM_SOURCE, "file"));
    }

    @Override // okio.FileSystem
    public Sink sink(Path file, boolean z) {
        Intrinsics.checkNotNullParameter(file, "file");
        return this.delegate.sink(onPathParameter(file, "sink", "file"), z);
    }

    @Override // okio.FileSystem
    public Sink appendingSink(Path file, boolean z) {
        Intrinsics.checkNotNullParameter(file, "file");
        return this.delegate.appendingSink(onPathParameter(file, "appendingSink", "file"), z);
    }

    @Override // okio.FileSystem
    public void createDirectory(Path dir, boolean z) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        this.delegate.createDirectory(onPathParameter(dir, "createDirectory", "dir"), z);
    }

    @Override // okio.FileSystem
    public void atomicMove(Path source, Path target) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        this.delegate.atomicMove(onPathParameter(source, "atomicMove", Constants.ScionAnalytics.PARAM_SOURCE), onPathParameter(target, "atomicMove", "target"));
    }

    @Override // okio.FileSystem
    public void delete(Path path, boolean z) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.delegate.delete(onPathParameter(path, "delete", "path"), z);
    }

    public String toString() {
        return Reflection.getOrCreateKotlinClass(getClass()).getSimpleName() + '(' + this.delegate + ')';
    }
}
