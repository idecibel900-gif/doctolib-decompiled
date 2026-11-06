package expo.modules.asset;

import expo.modules.kotlin.exception.CodedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class UnableToDownloadAssetException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnableToDownloadAssetException(String url) {
        super("Unable to download asset from url: " + url, null, 2, null);
        Intrinsics.checkNotNullParameter(url, "url");
    }
}
