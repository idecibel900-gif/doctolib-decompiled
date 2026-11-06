package com.opentok.android;

import com.opentok.otc.SWIGTYPE_p_otc_connection;
import com.opentok.otc.d;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public final class Connection {
    private SWIGTYPE_p_otc_connection otc_connection;
    private final boolean shouldDestroyOnFinalize;

    static class swig_otc_connection extends SWIGTYPE_p_otc_connection {
        public swig_otc_connection(long j) {
            super(j, true);
        }
    }

    Connection(SWIGTYPE_p_otc_connection sWIGTYPE_p_otc_connection, boolean z) {
        this.otc_connection = sWIGTYPE_p_otc_connection;
        this.shouldDestroyOnFinalize = z;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Connection) && getConnectionId().equals(((Connection) obj).getConnectionId());
    }

    protected void finalize() throws Throwable {
        SWIGTYPE_p_otc_connection sWIGTYPE_p_otc_connection = this.otc_connection;
        if (sWIGTYPE_p_otc_connection != null && this.shouldDestroyOnFinalize) {
            d.b(sWIGTYPE_p_otc_connection);
        }
        super.finalize();
    }

    public String getConnectionId() {
        return d.e(this.otc_connection);
    }

    public Date getCreationTime() {
        return new Date(d.c(this.otc_connection));
    }

    public String getData() {
        return d.d(this.otc_connection);
    }

    SWIGTYPE_p_otc_connection getOtcConnection() {
        return this.otc_connection;
    }

    public int hashCode() {
        return getConnectionId().hashCode();
    }

    Connection(long j, boolean z) {
        if (z) {
            this.otc_connection = d.a(new swig_otc_connection(j));
        } else {
            this.otc_connection = new swig_otc_connection(j);
        }
        this.shouldDestroyOnFinalize = z;
    }
}
