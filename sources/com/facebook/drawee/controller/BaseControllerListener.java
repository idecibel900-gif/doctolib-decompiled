package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;

/* JADX INFO: loaded from: classes3.dex */
public class BaseControllerListener implements ControllerListener {
    private static final ControllerListener NO_OP_LISTENER = new BaseControllerListener();

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onFailure(String str, Throwable th) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onFinalImageSet(String str, Object obj, Animatable animatable) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onIntermediateImageFailed(String str, Throwable th) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onIntermediateImageSet(String str, Object obj) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onRelease(String str) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onSubmit(String str, Object obj) {
    }

    public static ControllerListener getNoOpListener() {
        return NO_OP_LISTENER;
    }
}
