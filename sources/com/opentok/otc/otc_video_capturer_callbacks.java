package com.opentok.otc;

/* JADX INFO: loaded from: classes4.dex */
public class otc_video_capturer_callbacks {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected otc_video_capturer_callbacks(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(otc_video_capturer_callbacks otc_video_capturer_callbacksVar) {
        if (otc_video_capturer_callbacksVar == null) {
            return 0L;
        }
        return otc_video_capturer_callbacksVar.swigCPtr;
    }

    protected static long swigRelease(otc_video_capturer_callbacks otc_video_capturer_callbacksVar) {
        if (otc_video_capturer_callbacksVar == null) {
            return 0L;
        }
        if (!otc_video_capturer_callbacksVar.swigCMemOwn) {
            throw new RuntimeException("Cannot release ownership as memory is not owned");
        }
        long j = otc_video_capturer_callbacksVar.swigCPtr;
        otc_video_capturer_callbacksVar.swigCMemOwn = false;
        otc_video_capturer_callbacksVar.delete();
        return j;
    }

    public synchronized void delete() {
        try {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    opentokJNI.delete_otc_video_capturer_callbacks(j);
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

    public SWIGTYPE_p_f_p_q_const__struct_otc_video_capturer_p_void__int getDestroy() {
        long jOtc_video_capturer_callbacks_destroy_get = opentokJNI.otc_video_capturer_callbacks_destroy_get(this.swigCPtr, this);
        if (jOtc_video_capturer_callbacks_destroy_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_f_p_q_const__struct_otc_video_capturer_p_void__int(jOtc_video_capturer_callbacks_destroy_get, false);
    }

    public SWIGTYPE_p_f_p_q_const__struct_otc_video_capturer_p_void_p_struct_otc_video_capturer_settings__int getGet_capture_settings() {
        long jOtc_video_capturer_callbacks_get_capture_settings_get = opentokJNI.otc_video_capturer_callbacks_get_capture_settings_get(this.swigCPtr, this);
        if (jOtc_video_capturer_callbacks_get_capture_settings_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_f_p_q_const__struct_otc_video_capturer_p_void_p_struct_otc_video_capturer_settings__int(jOtc_video_capturer_callbacks_get_capture_settings_get, false);
    }

    public SWIGTYPE_p_f_p_q_const__struct_otc_video_capturer_p_void__int getInit() {
        long jOtc_video_capturer_callbacks_init_get = opentokJNI.otc_video_capturer_callbacks_init_get(this.swigCPtr, this);
        if (jOtc_video_capturer_callbacks_init_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_f_p_q_const__struct_otc_video_capturer_p_void__int(jOtc_video_capturer_callbacks_init_get, false);
    }

    public SWIGTYPE_p_void getReserved() {
        long jOtc_video_capturer_callbacks_reserved_get = opentokJNI.otc_video_capturer_callbacks_reserved_get(this.swigCPtr, this);
        if (jOtc_video_capturer_callbacks_reserved_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(jOtc_video_capturer_callbacks_reserved_get, false);
    }

    public SWIGTYPE_p_f_p_q_const__struct_otc_video_capturer_p_void__int getStart() {
        long jOtc_video_capturer_callbacks_start_get = opentokJNI.otc_video_capturer_callbacks_start_get(this.swigCPtr, this);
        if (jOtc_video_capturer_callbacks_start_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_f_p_q_const__struct_otc_video_capturer_p_void__int(jOtc_video_capturer_callbacks_start_get, false);
    }

    public SWIGTYPE_p_f_p_q_const__struct_otc_video_capturer_p_void__int getStop() {
        long jOtc_video_capturer_callbacks_stop_get = opentokJNI.otc_video_capturer_callbacks_stop_get(this.swigCPtr, this);
        if (jOtc_video_capturer_callbacks_stop_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_f_p_q_const__struct_otc_video_capturer_p_void__int(jOtc_video_capturer_callbacks_stop_get, false);
    }

    public SWIGTYPE_p_void getUser_data() {
        long jOtc_video_capturer_callbacks_user_data_get = opentokJNI.otc_video_capturer_callbacks_user_data_get(this.swigCPtr, this);
        if (jOtc_video_capturer_callbacks_user_data_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(jOtc_video_capturer_callbacks_user_data_get, false);
    }

    public void setDestroy(SWIGTYPE_p_f_p_q_const__struct_otc_video_capturer_p_void__int sWIGTYPE_p_f_p_q_const__struct_otc_video_capturer_p_void__int) {
        opentokJNI.otc_video_capturer_callbacks_destroy_set(this.swigCPtr, this, SWIGTYPE_p_f_p_q_const__struct_otc_video_capturer_p_void__int.a(sWIGTYPE_p_f_p_q_const__struct_otc_video_capturer_p_void__int));
    }

    public void setGet_capture_settings(SWIGTYPE_p_f_p_q_const__struct_otc_video_capturer_p_void_p_struct_otc_video_capturer_settings__int sWIGTYPE_p_f_p_q_const__struct_otc_video_capturer_p_void_p_struct_otc_video_capturer_settings__int) {
        opentokJNI.otc_video_capturer_callbacks_get_capture_settings_set(this.swigCPtr, this, SWIGTYPE_p_f_p_q_const__struct_otc_video_capturer_p_void_p_struct_otc_video_capturer_settings__int.a(sWIGTYPE_p_f_p_q_const__struct_otc_video_capturer_p_void_p_struct_otc_video_capturer_settings__int));
    }

    public void setInit(SWIGTYPE_p_f_p_q_const__struct_otc_video_capturer_p_void__int sWIGTYPE_p_f_p_q_const__struct_otc_video_capturer_p_void__int) {
        opentokJNI.otc_video_capturer_callbacks_init_set(this.swigCPtr, this, SWIGTYPE_p_f_p_q_const__struct_otc_video_capturer_p_void__int.a(sWIGTYPE_p_f_p_q_const__struct_otc_video_capturer_p_void__int));
    }

    public void setReserved(SWIGTYPE_p_void sWIGTYPE_p_void) {
        opentokJNI.otc_video_capturer_callbacks_reserved_set(this.swigCPtr, this, SWIGTYPE_p_void.a(sWIGTYPE_p_void));
    }

    public void setStart(SWIGTYPE_p_f_p_q_const__struct_otc_video_capturer_p_void__int sWIGTYPE_p_f_p_q_const__struct_otc_video_capturer_p_void__int) {
        opentokJNI.otc_video_capturer_callbacks_start_set(this.swigCPtr, this, SWIGTYPE_p_f_p_q_const__struct_otc_video_capturer_p_void__int.a(sWIGTYPE_p_f_p_q_const__struct_otc_video_capturer_p_void__int));
    }

    public void setStop(SWIGTYPE_p_f_p_q_const__struct_otc_video_capturer_p_void__int sWIGTYPE_p_f_p_q_const__struct_otc_video_capturer_p_void__int) {
        opentokJNI.otc_video_capturer_callbacks_stop_set(this.swigCPtr, this, SWIGTYPE_p_f_p_q_const__struct_otc_video_capturer_p_void__int.a(sWIGTYPE_p_f_p_q_const__struct_otc_video_capturer_p_void__int));
    }

    public void setUser_data(SWIGTYPE_p_void sWIGTYPE_p_void) {
        opentokJNI.otc_video_capturer_callbacks_user_data_set(this.swigCPtr, this, SWIGTYPE_p_void.a(sWIGTYPE_p_void));
    }
}
