package com.opentok.otc;

/* JADX INFO: loaded from: classes4.dex */
public class otc_session_capabilities {
    private transient long a;
    protected transient boolean b;

    protected otc_session_capabilities(long j, boolean z) {
        this.b = z;
        this.a = j;
    }

    public synchronized void a() {
        try {
            long j = this.a;
            if (j != 0) {
                if (this.b) {
                    this.b = false;
                    opentokJNI.delete_otc_session_capabilities(j);
                }
                this.a = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public int b() {
        return opentokJNI.otc_session_capabilities_force_disconnect_get(this.a, this);
    }

    public int c() {
        return opentokJNI.otc_session_capabilities_force_mute_get(this.a, this);
    }

    public int d() {
        return opentokJNI.otc_session_capabilities_publish_get(this.a, this);
    }

    public int e() {
        return opentokJNI.otc_session_capabilities_subscribe_get(this.a, this);
    }

    protected void finalize() {
        a();
    }
}
