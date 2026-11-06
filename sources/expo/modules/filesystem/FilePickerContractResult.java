package expo.modules.filesystem;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class FilePickerContractResult {
    public /* synthetic */ FilePickerContractResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final class Success extends FilePickerContractResult {
        private final FileSystemPath path;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(FileSystemPath path) {
            super(null);
            Intrinsics.checkNotNullParameter(path, "path");
            this.path = path;
        }

        public final FileSystemPath getPath() {
            return this.path;
        }
    }

    private FilePickerContractResult() {
    }

    public static final class Cancelled extends FilePickerContractResult {
        public static final Cancelled INSTANCE = new Cancelled();

        private Cancelled() {
            super(null);
        }
    }
}
