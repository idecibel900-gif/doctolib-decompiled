package com.swmansion.rnscreens.gamma.tabs.image;

import android.content.Context;
import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
final class ImageSource {
    private final Context context;
    private final String uriString;

    public ImageSource(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.uriString = str;
    }

    private final boolean isLocalResourceUri(Uri uri) {
        String scheme;
        if (uri == null || (scheme = uri.getScheme()) == null) {
            return false;
        }
        return StringsKt.startsWith$default(scheme, "res", false, 2, (Object) null);
    }

    public final Uri getUri(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Uri uriComputeUri = computeUri(context);
        if (!isLocalResourceUri(uriComputeUri)) {
            return uriComputeUri;
        }
        Intrinsics.checkNotNull(uriComputeUri);
        String string = uriComputeUri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return Uri.parse(StringsKt.replace$default(string, "res:/", "android.resource://" + context.getPackageName() + "/", false, 4, (Object) null));
    }

    private final Uri computeUri(Context context) {
        String str = this.uriString;
        if (str == null) {
            return null;
        }
        try {
            Uri uri = Uri.parse(str);
            return uri.getScheme() == null ? computeLocalUri(str, context) : uri;
        } catch (Exception unused) {
            return computeLocalUri(str, context);
        }
    }

    private final Uri computeLocalUri(String str, Context context) {
        return ResourceIdHelper.INSTANCE.getResourceUri(context, str);
    }
}
