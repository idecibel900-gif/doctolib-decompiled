package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Util;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CustomTarget implements Target {
    private final int height;
    private Request request;
    private final int width;

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadFailed(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadStarted(Drawable drawable) {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void removeCallback(SizeReadyCallback sizeReadyCallback) {
    }

    public CustomTarget() {
        this(LinearLayoutManager.INVALID_OFFSET, LinearLayoutManager.INVALID_OFFSET);
    }

    public CustomTarget(int i, int i2) {
        if (!Util.isValidDimensions(i, i2)) {
            throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i + " and height: " + i2);
        }
        this.width = i;
        this.height = i2;
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void getSize(SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.onSizeReady(this.width, this.height);
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void setRequest(Request request) {
        this.request = request;
    }

    @Override // com.bumptech.glide.request.target.Target
    public final Request getRequest() {
        return this.request;
    }
}
