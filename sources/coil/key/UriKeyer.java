package coil.key;

import android.net.Uri;
import coil.request.Options;
import coil.util.Utils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class UriKeyer implements Keyer {
    @Override // coil.key.Keyer
    public String key(Uri uri, Options options) {
        if (Intrinsics.areEqual(uri.getScheme(), "android.resource")) {
            StringBuilder sb = new StringBuilder();
            sb.append(uri);
            sb.append('-');
            sb.append(Utils.getNightMode(options.getContext().getResources().getConfiguration()));
            return sb.toString();
        }
        return uri.toString();
    }
}
