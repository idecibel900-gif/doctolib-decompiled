package com.facebook.fresco.urimod;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NopUriModifier implements UriModifierInterface {
    public static final NopUriModifier INSTANCE = new NopUriModifier();

    @Override // com.facebook.fresco.urimod.UriModifierInterface
    public Uri modifyPrefetchUri(Uri uri, Object obj) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return uri;
    }

    private NopUriModifier() {
    }
}
