package com.opentok.otc;

/* JADX INFO: loaded from: classes4.dex */
public class otc_signal_options {
    private transient long a;
    protected transient boolean b;

    protected otc_signal_options(long j, boolean z) {
        this.b = z;
        this.a = j;
    }

    protected static long a(otc_signal_options otc_signal_optionsVar) {
        if (otc_signal_optionsVar == null) {
            return 0L;
        }
        return otc_signal_optionsVar.a;
    }

    protected void finalize() {
        a();
    }

    public synchronized void a() {
        try {
            long j = this.a;
            if (j != 0) {
                if (this.b) {
                    this.b = false;
                    opentokJNI.delete_otc_signal_options(j);
                }
                this.a = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public otc_signal_options() {
        this(opentokJNI.new_otc_signal_options(), true);
    }

    public void a(int i) {
        opentokJNI.otc_signal_options_retry_after_reconnect_set(this.a, this, i);
    }
}
