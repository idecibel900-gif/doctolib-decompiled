package com.amazon.device.simplesignin.model.request;

import com.amazon.device.simplesignin.model.FailureReason;
import com.amazon.device.simplesignin.model.SSIEvent;

/* JADX INFO: loaded from: classes3.dex */
public class SSIEventRequest {
    private String epochTimestamp;
    private SSIEvent event;
    private FailureReason failureReason;

    public SSIEvent getEvent() {
        return this.event;
    }

    public String getEpochTimestamp() {
        return this.epochTimestamp;
    }

    public FailureReason getFailureReason() {
        return this.failureReason;
    }

    public SSIEventRequest(SSIEvent sSIEvent, FailureReason failureReason) {
        this.epochTimestamp = String.valueOf(System.currentTimeMillis());
        this.event = sSIEvent;
        this.failureReason = failureReason;
    }

    public SSIEventRequest(SSIEvent sSIEvent) {
        this.epochTimestamp = String.valueOf(System.currentTimeMillis());
        this.event = sSIEvent;
        this.failureReason = null;
    }
}
