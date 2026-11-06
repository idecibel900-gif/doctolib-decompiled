package coil.map;

import android.net.Uri;
import coil.request.Options;
import coil.util.Utils;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class FileUriMapper implements Mapper {
    @Override // coil.map.Mapper
    public File map(Uri uri, Options options) {
        if (!isApplicable(uri)) {
            return null;
        }
        if (Intrinsics.areEqual(uri.getScheme(), "file")) {
            String path = uri.getPath();
            if (path != null) {
                return new File(path);
            }
            return null;
        }
        return new File(uri.toString());
    }

    private final boolean isApplicable(Uri uri) {
        String scheme;
        if (!Utils.isAssetUri(uri) && ((scheme = uri.getScheme()) == null || Intrinsics.areEqual(scheme, "file"))) {
            String path = uri.getPath();
            if (path == null) {
                path = "";
            }
            if (StringsKt.startsWith$default((CharSequence) path, '/', false, 2, (Object) null) && Utils.getFirstPathSegment(uri) != null) {
                return true;
            }
        }
        return false;
    }
}
