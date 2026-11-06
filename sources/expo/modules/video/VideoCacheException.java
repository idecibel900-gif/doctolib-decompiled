package expo.modules.video;

import expo.modules.kotlin.exception.CodedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
public final class VideoCacheException extends CodedException {
    public /* synthetic */ VideoCacheException(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : th);
    }

    public VideoCacheException(String str, Throwable th) {
        super(str == null ? "Unexpected expo-video cache error" : str, th);
    }
}
