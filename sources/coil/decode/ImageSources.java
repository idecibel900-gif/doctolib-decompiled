package coil.decode;

import android.content.Context;
import coil.util.Utils;
import java.io.Closeable;
import java.io.File;
import kotlin.jvm.functions.Function0;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Path;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ImageSources {
    public static /* synthetic */ ImageSource create$default(Path path, FileSystem fileSystem, String str, Closeable closeable, int i, Object obj) {
        if ((i & 2) != 0) {
            fileSystem = FileSystem.SYSTEM;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        if ((i & 8) != 0) {
            closeable = null;
        }
        return create(path, fileSystem, str, closeable);
    }

    public static final ImageSource create(Path path, FileSystem fileSystem, String str, Closeable closeable) {
        return new FileImageSource(path, fileSystem, str, closeable, null);
    }

    public static final ImageSource create(BufferedSource bufferedSource, final Context context) {
        return new SourceImageSource(bufferedSource, new Function0() { // from class: coil.decode.ImageSources$ImageSource$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final File invoke() {
                return Utils.getSafeCacheDir(context);
            }
        }, null);
    }

    public static final ImageSource create(BufferedSource bufferedSource, final Context context, ImageSource.Metadata metadata) {
        return new SourceImageSource(bufferedSource, new Function0() { // from class: coil.decode.ImageSources$ImageSource$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final File invoke() {
                return Utils.getSafeCacheDir(context);
            }
        }, metadata);
    }
}
