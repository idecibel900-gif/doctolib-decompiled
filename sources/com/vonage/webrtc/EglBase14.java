package com.vonage.webrtc;

import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;

/* JADX INFO: loaded from: classes4.dex */
public interface EglBase14 extends EglBase {

    public interface Context extends EglBase.Context {
        EGLContext getRawContext();
    }

    public interface EglConnection extends EglBase.EglConnection {
        EGLConfig getConfig();

        EGLContext getContext();

        EGLDisplay getDisplay();
    }
}
