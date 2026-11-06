package com.vonage.webrtc;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
interface MediaCodecWrapperFactory {
    MediaCodecWrapper createByCodecName(String str) throws IOException;
}
