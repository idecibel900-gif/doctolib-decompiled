package com.opentokreactnative;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Handler;
import android.view.View;
import com.opentok.android.BaseVideoCapturer;

/* JADX INFO: loaded from: classes4.dex */
public class OTScreenCapturer extends BaseVideoCapturer {
    private Bitmap bmp;
    private Canvas canvas;
    private View contentView;
    private int[] frame;
    private boolean capturing = false;
    private int fps = 15;
    private int width = 20;
    private int height = 20;
    private Handler mHandler = new Handler();
    private Runnable newFrame = new Runnable() { // from class: com.opentokreactnative.OTScreenCapturer.1
        @Override // java.lang.Runnable
        public void run() {
            if (OTScreenCapturer.this.capturing) {
                int width = OTScreenCapturer.this.contentView.getWidth();
                int height = OTScreenCapturer.this.contentView.getHeight();
                if (OTScreenCapturer.this.frame == null || OTScreenCapturer.this.width != width || OTScreenCapturer.this.height != height) {
                    OTScreenCapturer.this.width = width;
                    OTScreenCapturer.this.height = height;
                    if (OTScreenCapturer.this.bmp != null) {
                        OTScreenCapturer.this.bmp.recycle();
                        OTScreenCapturer.this.bmp = null;
                    }
                    OTScreenCapturer.this.bmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                    OTScreenCapturer.this.canvas = new Canvas(OTScreenCapturer.this.bmp);
                    OTScreenCapturer.this.frame = new int[width * height];
                }
                OTScreenCapturer.this.canvas.save();
                OTScreenCapturer.this.canvas.translate(-OTScreenCapturer.this.contentView.getScrollX(), -OTScreenCapturer.this.contentView.getScrollY());
                OTScreenCapturer.this.contentView.draw(OTScreenCapturer.this.canvas);
                OTScreenCapturer.this.bmp.getPixels(OTScreenCapturer.this.frame, 0, width, 0, 0, width, height);
                OTScreenCapturer oTScreenCapturer = OTScreenCapturer.this;
                oTScreenCapturer.provideIntArrayFrame(oTScreenCapturer.frame, 2, width, height, 0, false);
                OTScreenCapturer.this.canvas.restore();
                OTScreenCapturer.this.mHandler.postDelayed(OTScreenCapturer.this.newFrame, 1000 / OTScreenCapturer.this.fps);
            }
        }
    };

    @Override // com.opentok.android.BaseVideoCapturer
    public void destroy() {
    }

    @Override // com.opentok.android.BaseVideoCapturer
    public void init() {
    }

    @Override // com.opentok.android.BaseVideoCapturer
    public void onPause() {
    }

    @Override // com.opentok.android.BaseVideoCapturer
    public void onResume() {
    }

    public OTScreenCapturer(View view) {
        View view2 = (View) view.getParent();
        if (view2 != null) {
            this.contentView = view2;
        } else {
            this.contentView = view;
        }
    }

    @Override // com.opentok.android.BaseVideoCapturer
    public int startCapture() {
        this.capturing = true;
        this.mHandler.postDelayed(this.newFrame, 1000 / this.fps);
        return 0;
    }

    @Override // com.opentok.android.BaseVideoCapturer
    public int stopCapture() {
        this.capturing = false;
        this.mHandler.removeCallbacks(this.newFrame);
        return 0;
    }

    @Override // com.opentok.android.BaseVideoCapturer
    public boolean isCaptureStarted() {
        return this.capturing;
    }

    @Override // com.opentok.android.BaseVideoCapturer
    public BaseVideoCapturer.CaptureSettings getCaptureSettings() {
        BaseVideoCapturer.CaptureSettings captureSettings = new BaseVideoCapturer.CaptureSettings();
        captureSettings.fps = this.fps;
        captureSettings.width = this.width;
        captureSettings.height = this.height;
        captureSettings.format = 2;
        return captureSettings;
    }
}
