package coil.map;

import android.net.Uri;
import coil.request.Options;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class StringMapper implements Mapper {
    @Override // coil.map.Mapper
    public Uri map(String str, Options options) {
        Uri uri = Uri.parse(str);
        Intrinsics.checkNotNullExpressionValue(uri, "parse(this)");
        return uri;
    }
}
