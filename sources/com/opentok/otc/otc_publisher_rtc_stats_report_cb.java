package com.opentok.otc;

/* JADX INFO: loaded from: classes4.dex */
public class otc_publisher_rtc_stats_report_cb {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected otc_publisher_rtc_stats_report_cb(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(otc_publisher_rtc_stats_report_cb otc_publisher_rtc_stats_report_cbVar) {
        if (otc_publisher_rtc_stats_report_cbVar == null) {
            return 0L;
        }
        return otc_publisher_rtc_stats_report_cbVar.swigCPtr;
    }

    protected static long swigRelease(otc_publisher_rtc_stats_report_cb otc_publisher_rtc_stats_report_cbVar) {
        if (otc_publisher_rtc_stats_report_cbVar == null) {
            return 0L;
        }
        if (!otc_publisher_rtc_stats_report_cbVar.swigCMemOwn) {
            throw new RuntimeException("Cannot release ownership as memory is not owned");
        }
        long j = otc_publisher_rtc_stats_report_cbVar.swigCPtr;
        otc_publisher_rtc_stats_report_cbVar.swigCMemOwn = false;
        otc_publisher_rtc_stats_report_cbVar.delete();
        return j;
    }

    public synchronized void delete() {
        try {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    opentokJNI.delete_otc_publisher_rtc_stats_report_cb(j);
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

    public SWIGTYPE_p_f_p_struct_otc_publisher_p_void_p_q_const__struct_otc_publisher_rtc_stats_size_t__void getOn_rtc_stats_report() {
        long jOtc_publisher_rtc_stats_report_cb_on_rtc_stats_report_get = opentokJNI.otc_publisher_rtc_stats_report_cb_on_rtc_stats_report_get(this.swigCPtr, this);
        if (jOtc_publisher_rtc_stats_report_cb_on_rtc_stats_report_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_f_p_struct_otc_publisher_p_void_p_q_const__struct_otc_publisher_rtc_stats_size_t__void(jOtc_publisher_rtc_stats_report_cb_on_rtc_stats_report_get, false);
    }

    public SWIGTYPE_p_void getReserved() {
        long jOtc_publisher_rtc_stats_report_cb_reserved_get = opentokJNI.otc_publisher_rtc_stats_report_cb_reserved_get(this.swigCPtr, this);
        if (jOtc_publisher_rtc_stats_report_cb_reserved_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(jOtc_publisher_rtc_stats_report_cb_reserved_get, false);
    }

    public SWIGTYPE_p_void getUser_data() {
        long jOtc_publisher_rtc_stats_report_cb_user_data_get = opentokJNI.otc_publisher_rtc_stats_report_cb_user_data_get(this.swigCPtr, this);
        if (jOtc_publisher_rtc_stats_report_cb_user_data_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(jOtc_publisher_rtc_stats_report_cb_user_data_get, false);
    }

    public void setOn_rtc_stats_report(SWIGTYPE_p_f_p_struct_otc_publisher_p_void_p_q_const__struct_otc_publisher_rtc_stats_size_t__void sWIGTYPE_p_f_p_struct_otc_publisher_p_void_p_q_const__struct_otc_publisher_rtc_stats_size_t__void) {
        opentokJNI.otc_publisher_rtc_stats_report_cb_on_rtc_stats_report_set(this.swigCPtr, this, SWIGTYPE_p_f_p_struct_otc_publisher_p_void_p_q_const__struct_otc_publisher_rtc_stats_size_t__void.a(sWIGTYPE_p_f_p_struct_otc_publisher_p_void_p_q_const__struct_otc_publisher_rtc_stats_size_t__void));
    }

    public void setReserved(SWIGTYPE_p_void sWIGTYPE_p_void) {
        opentokJNI.otc_publisher_rtc_stats_report_cb_reserved_set(this.swigCPtr, this, SWIGTYPE_p_void.a(sWIGTYPE_p_void));
    }

    public void setUser_data(SWIGTYPE_p_void sWIGTYPE_p_void) {
        opentokJNI.otc_publisher_rtc_stats_report_cb_user_data_set(this.swigCPtr, this, SWIGTYPE_p_void.a(sWIGTYPE_p_void));
    }
}
