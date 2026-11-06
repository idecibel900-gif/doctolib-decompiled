package com.vonage.webrtc;

/* JADX INFO: loaded from: classes4.dex */
class BaseBitrateAdjuster implements BitrateAdjuster {
    protected int targetBitrateBps;
    protected double targetFramerateFps;

    @Override // com.vonage.webrtc.BitrateAdjuster
    public void reportEncodedFrame(int i) {
    }

    BaseBitrateAdjuster() {
    }

    @Override // com.vonage.webrtc.BitrateAdjuster
    public void setTargets(int i, double d) {
        this.targetBitrateBps = i;
        this.targetFramerateFps = d;
    }

    @Override // com.vonage.webrtc.BitrateAdjuster
    public int getAdjustedBitrateBps() {
        return this.targetBitrateBps;
    }

    @Override // com.vonage.webrtc.BitrateAdjuster
    public double getAdjustedFramerateFps() {
        return this.targetFramerateFps;
    }
}
