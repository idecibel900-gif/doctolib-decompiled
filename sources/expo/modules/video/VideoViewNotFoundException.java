package expo.modules.video;

import expo.modules.kotlin.exception.CodedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class VideoViewNotFoundException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoViewNotFoundException(String id) {
        super("VideoView with id: " + id + " not found", null, 2, null);
        Intrinsics.checkNotNullParameter(id, "id");
    }
}
