package com.github.barteksc.pdfviewer.listener;

import android.view.MotionEvent;
import com.github.barteksc.pdfviewer.link.LinkHandler;
import com.github.barteksc.pdfviewer.model.LinkTapEvent;

/* JADX INFO: loaded from: classes3.dex */
public class Callbacks {
    private LinkHandler linkHandler;
    private OnDrawListener onDrawAllListener;
    private OnDrawListener onDrawListener;
    private OnErrorListener onErrorListener;
    private OnLoadCompleteListener onLoadCompleteListener;
    private OnPageChangeListener onPageChangeListener;
    private OnPageScrollListener onPageScrollListener;
    private OnTapListener onTapListener;

    public void callOnLongPress(MotionEvent motionEvent) {
    }

    public boolean callOnPageError(int i, Throwable th) {
        return false;
    }

    public void callOnRender(int i) {
    }

    public void setOnLongPress(OnLongPressListener onLongPressListener) {
    }

    public void setOnPageError(OnPageErrorListener onPageErrorListener) {
    }

    public void setOnRender(OnRenderListener onRenderListener) {
    }

    public void setOnLoadComplete(OnLoadCompleteListener onLoadCompleteListener) {
        this.onLoadCompleteListener = onLoadCompleteListener;
    }

    public void callOnLoadComplete(int i) {
        OnLoadCompleteListener onLoadCompleteListener = this.onLoadCompleteListener;
        if (onLoadCompleteListener != null) {
            onLoadCompleteListener.loadComplete(i);
        }
    }

    public void setOnError(OnErrorListener onErrorListener) {
        this.onErrorListener = onErrorListener;
    }

    public OnErrorListener getOnError() {
        return this.onErrorListener;
    }

    public void setOnPageChange(OnPageChangeListener onPageChangeListener) {
        this.onPageChangeListener = onPageChangeListener;
    }

    public void callOnPageChange(int i, int i2) {
        OnPageChangeListener onPageChangeListener = this.onPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageChanged(i, i2);
        }
    }

    public void setOnPageScroll(OnPageScrollListener onPageScrollListener) {
        this.onPageScrollListener = onPageScrollListener;
    }

    public void callOnPageScroll(int i, float f) {
        OnPageScrollListener onPageScrollListener = this.onPageScrollListener;
        if (onPageScrollListener != null) {
            onPageScrollListener.onPageScrolled(i, f);
        }
    }

    public void setOnDraw(OnDrawListener onDrawListener) {
        this.onDrawListener = onDrawListener;
    }

    public OnDrawListener getOnDraw() {
        return this.onDrawListener;
    }

    public void setOnDrawAll(OnDrawListener onDrawListener) {
        this.onDrawAllListener = onDrawListener;
    }

    public OnDrawListener getOnDrawAll() {
        return this.onDrawAllListener;
    }

    public void setOnTap(OnTapListener onTapListener) {
        this.onTapListener = onTapListener;
    }

    public boolean callOnTap(MotionEvent motionEvent) {
        OnTapListener onTapListener = this.onTapListener;
        return onTapListener != null && onTapListener.onTap(motionEvent);
    }

    public void setLinkHandler(LinkHandler linkHandler) {
        this.linkHandler = linkHandler;
    }

    public void callLinkHandler(LinkTapEvent linkTapEvent) {
        LinkHandler linkHandler = this.linkHandler;
        if (linkHandler != null) {
            linkHandler.handleLinkEvent(linkTapEvent);
        }
    }
}
