package com.opentok.android;

import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
class VideoCaptureFactory {
    VideoCaptureFactory() {
    }

    public static BaseVideoCapturer constructCapturer(Context context, Publisher.CameraCaptureResolution cameraCaptureResolution, Publisher.CameraCaptureFrameRate cameraCaptureFrameRate) {
        return new Camera2VideoCapturer(context, cameraCaptureResolution, cameraCaptureFrameRate);
    }
}
