package com.opentok.android.grafika.gles;

import android.graphics.SurfaceTexture;
import android.view.Surface;

/* JADX INFO: loaded from: classes4.dex */
public class WindowSurface extends a {
    private Surface f;
    private boolean g;

    public WindowSurface(EglCore eglCore, SurfaceTexture surfaceTexture) {
        super(eglCore);
        a(surfaceTexture);
    }

    public void d() {
        b();
        Surface surface = this.f;
        if (surface != null) {
            if (this.g) {
                surface.release();
            }
            this.f = null;
        }
    }
}
