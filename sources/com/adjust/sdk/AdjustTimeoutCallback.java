package com.adjust.sdk;

import com.adjust.sdk.scheduler.TimerOnce;

/* JADX INFO: loaded from: classes3.dex */
public class AdjustTimeoutCallback {
    private OnAdidReadListener onAdidReadListener;
    private OnAttributionReadListener onAttributionReadListener;
    private OnThirdPartySharingSettingsReadListener onThirdPartySharingSettingsReadListener;
    private TimerOnce timeoutTimer;

    public AdjustTimeoutCallback(OnAdidReadListener onAdidReadListener) {
        this.onAdidReadListener = onAdidReadListener;
    }

    public OnAdidReadListener getOnAdidReadListener() {
        return this.onAdidReadListener;
    }

    public OnAttributionReadListener getOnAttributionReadListener() {
        return this.onAttributionReadListener;
    }

    public OnThirdPartySharingSettingsReadListener getOnThirdPartySharingSettingsReadListener() {
        return this.onThirdPartySharingSettingsReadListener;
    }

    public TimerOnce getTimeoutTimer() {
        return this.timeoutTimer;
    }

    public void setOnAdidReadListener(OnAdidReadListener onAdidReadListener) {
        this.onAdidReadListener = onAdidReadListener;
    }

    public void setOnAttributionReadListener(OnAttributionReadListener onAttributionReadListener) {
        this.onAttributionReadListener = onAttributionReadListener;
    }

    public void setOnThirdPartySharingSettingsReadListener(OnThirdPartySharingSettingsReadListener onThirdPartySharingSettingsReadListener) {
        this.onThirdPartySharingSettingsReadListener = onThirdPartySharingSettingsReadListener;
    }

    public void setTimer(TimerOnce timerOnce) {
        this.timeoutTimer = timerOnce;
    }

    public AdjustTimeoutCallback(OnAttributionReadListener onAttributionReadListener) {
        this.onAttributionReadListener = onAttributionReadListener;
    }

    public AdjustTimeoutCallback(OnThirdPartySharingSettingsReadListener onThirdPartySharingSettingsReadListener) {
        this.onThirdPartySharingSettingsReadListener = onThirdPartySharingSettingsReadListener;
    }
}
