package coil.map;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import coil.request.Options;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ResourceIntMapper implements Mapper {
    @Override // coil.map.Mapper
    public /* bridge */ /* synthetic */ Object map(Object obj, Options options) {
        return map(((Number) obj).intValue(), options);
    }

    public Uri map(int i, Options options) {
        if (!isApplicable(i, options.getContext())) {
            return null;
        }
        Uri uri = Uri.parse("android.resource://" + options.getContext().getPackageName() + '/' + i);
        Intrinsics.checkNotNullExpressionValue(uri, "parse(this)");
        return uri;
    }

    private final boolean isApplicable(int i, Context context) {
        try {
            return context.getResources().getResourceEntryName(i) != null;
        } catch (Resources.NotFoundException unused) {
        }
    }
}
