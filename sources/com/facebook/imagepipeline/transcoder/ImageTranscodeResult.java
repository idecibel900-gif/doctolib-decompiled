package com.facebook.imagepipeline.transcoder;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ImageTranscodeResult {
    private final int transcodeStatus;

    public ImageTranscodeResult(int i) {
        this.transcodeStatus = i;
    }

    public final int getTranscodeStatus() {
        return this.transcodeStatus;
    }

    public String toString() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(null, "Status: %d", Arrays.copyOf(new Object[]{Integer.valueOf(this.transcodeStatus)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }
}
