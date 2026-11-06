package com.opentok.otc;

/* JADX INFO: loaded from: classes4.dex */
public class otc_on_mute_forced_info {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected otc_on_mute_forced_info(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(otc_on_mute_forced_info otc_on_mute_forced_infoVar) {
        if (otc_on_mute_forced_infoVar == null) {
            return 0L;
        }
        return otc_on_mute_forced_infoVar.swigCPtr;
    }

    protected static long swigRelease(otc_on_mute_forced_info otc_on_mute_forced_infoVar) {
        if (otc_on_mute_forced_infoVar == null) {
            return 0L;
        }
        if (!otc_on_mute_forced_infoVar.swigCMemOwn) {
            throw new RuntimeException("Cannot release ownership as memory is not owned");
        }
        long j = otc_on_mute_forced_infoVar.swigCPtr;
        otc_on_mute_forced_infoVar.swigCMemOwn = false;
        otc_on_mute_forced_infoVar.delete();
        return j;
    }

    public synchronized void delete() {
        try {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    opentokJNI.delete_otc_on_mute_forced_info(j);
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

    public int getActive() {
        return opentokJNI.otc_on_mute_forced_info_active_get(this.swigCPtr, this);
    }

    public void setActive(int i) {
        opentokJNI.otc_on_mute_forced_info_active_set(this.swigCPtr, this, i);
    }
}
