package com.opentok.android;

import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
class VideoRenderFactory {
    private static final OtLog.LogToken log = new OtLog.LogToken();
    private static boolean useTextureViews = false;

    VideoRenderFactory() {
    }

    public static BaseVideoRenderer constructRenderer(Context context) {
        if (useTextureViews) {
            log.i("Using TextureViews for render", new Object[0]);
            return new TextureViewRenderer(context);
        }
        log.i("Using GLSurfaceViews for render", new Object[0]);
        return new DefaultVideoRenderer(context);
    }

    public static void useTextureViews(boolean z) {
        useTextureViews = z;
    }
}
