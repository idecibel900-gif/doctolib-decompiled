package com.vonage.webrtc;

/* JADX INFO: loaded from: classes4.dex */
class FramerateBitrateAdjuster extends BaseBitrateAdjuster {
    private static final int DEFAULT_FRAMERATE_FPS = 30;

    FramerateBitrateAdjuster() {
    }

    @Override // com.vonage.webrtc.BaseBitrateAdjuster, com.vonage.webrtc.BitrateAdjuster
    public void setTargets(int i, double d) {
        this.targetFramerateFps = 30.0d;
        this.targetBitrateBps = (int) (((double) (i * DEFAULT_FRAMERATE_FPS)) / d);
    }
}
