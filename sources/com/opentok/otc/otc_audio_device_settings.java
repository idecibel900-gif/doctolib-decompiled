package com.opentok.otc;

/* JADX INFO: loaded from: classes4.dex */
public class otc_audio_device_settings {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected otc_audio_device_settings(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(otc_audio_device_settings otc_audio_device_settingsVar) {
        if (otc_audio_device_settingsVar == null) {
            return 0L;
        }
        return otc_audio_device_settingsVar.swigCPtr;
    }

    protected static long swigRelease(otc_audio_device_settings otc_audio_device_settingsVar) {
        if (otc_audio_device_settingsVar == null) {
            return 0L;
        }
        if (!otc_audio_device_settingsVar.swigCMemOwn) {
            throw new RuntimeException("Cannot release ownership as memory is not owned");
        }
        long j = otc_audio_device_settingsVar.swigCPtr;
        otc_audio_device_settingsVar.swigCMemOwn = false;
        otc_audio_device_settingsVar.delete();
        return j;
    }

    public synchronized void delete() {
        try {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    opentokJNI.delete_otc_audio_device_settings(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    protected void finalize() {
        delete();
    }

    public int getNumber_of_channels() {
        return opentokJNI.otc_audio_device_settings_number_of_channels_get(this.swigCPtr, this);
    }

    public int getSampling_rate() {
        return opentokJNI.otc_audio_device_settings_sampling_rate_get(this.swigCPtr, this);
    }

    public void setNumber_of_channels(int i) {
        opentokJNI.otc_audio_device_settings_number_of_channels_set(this.swigCPtr, this, i);
    }

    public void setSampling_rate(int i) {
        opentokJNI.otc_audio_device_settings_sampling_rate_set(this.swigCPtr, this, i);
    }
}
