package androidx.core.net;

import android.net.Uri;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class UriKt {
    public static final File toFile(Uri uri) {
        if (!Intrinsics.areEqual(uri.getScheme(), "file")) {
            throw new IllegalArgumentException(("Uri lacks 'file' scheme: " + uri).toString());
        }
        String path = uri.getPath();
        if (path != null) {
            return new File(path);
        }
        throw new IllegalArgumentException(("Uri path is null: " + uri).toString());
    }
}
