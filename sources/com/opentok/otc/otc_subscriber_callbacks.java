package com.opentok.otc;

/* JADX INFO: loaded from: classes4.dex */
public class otc_subscriber_callbacks {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected otc_subscriber_callbacks(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(otc_subscriber_callbacks otc_subscriber_callbacksVar) {
        if (otc_subscriber_callbacksVar == null) {
            return 0L;
        }
        return otc_subscriber_callbacksVar.swigCPtr;
    }

    protected static long swigRelease(otc_subscriber_callbacks otc_subscriber_callbacksVar) {
        if (otc_subscriber_callbacksVar == null) {
            return 0L;
        }
        if (!otc_subscriber_callbacksVar.swigCMemOwn) {
            throw new RuntimeException("Cannot release ownership as memory is not owned");
        }
        long j = otc_subscriber_callbacksVar.swigCPtr;
        otc_subscriber_callbacksVar.swigCMemOwn = false;
        otc_subscriber_callbacksVar.delete();
        return j;
    }

    public synchronized void delete() {
        try {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    opentokJNI.delete_otc_subscriber_callbacks(j);
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

    public SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_p_q_const__struct_otc_audio_data__void getOn_audio_data() {
        long jOtc_subscriber_callbacks_on_audio_data_get = opentokJNI.otc_subscriber_callbacks_on_audio_data_get(this.swigCPtr, this);
        if (jOtc_subscriber_callbacks_on_audio_data_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_p_q_const__struct_otc_audio_data__void(jOtc_subscriber_callbacks_on_audio_data_get, false);
    }

    public SWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void getOn_audio_disabled() {
        long jOtc_subscriber_callbacks_on_audio_disabled_get = opentokJNI.otc_subscriber_callbacks_on_audio_disabled_get(this.swigCPtr, this);
        if (jOtc_subscriber_callbacks_on_audio_disabled_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void(jOtc_subscriber_callbacks_on_audio_disabled_get, false);
    }

    public SWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void getOn_audio_enabled() {
        long jOtc_subscriber_callbacks_on_audio_enabled_get = opentokJNI.otc_subscriber_callbacks_on_audio_enabled_get(this.swigCPtr, this);
        if (jOtc_subscriber_callbacks_on_audio_enabled_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void(jOtc_subscriber_callbacks_on_audio_enabled_get, false);
    }

    public SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_float__void getOn_audio_level_updated() {
        long jOtc_subscriber_callbacks_on_audio_level_updated_get = opentokJNI.otc_subscriber_callbacks_on_audio_level_updated_get(this.swigCPtr, this);
        if (jOtc_subscriber_callbacks_on_audio_level_updated_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_float__void(jOtc_subscriber_callbacks_on_audio_level_updated_get, false);
    }

    public SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_struct_otc_subscriber_audio_stats__void getOn_audio_stats() {
        long jOtc_subscriber_callbacks_on_audio_stats_get = opentokJNI.otc_subscriber_callbacks_on_audio_stats_get(this.swigCPtr, this);
        if (jOtc_subscriber_callbacks_on_audio_stats_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_struct_otc_subscriber_audio_stats__void(jOtc_subscriber_callbacks_on_audio_stats_get, false);
    }

    public SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_p_q_const__char_int__void getOn_caption_text() {
        long jOtc_subscriber_callbacks_on_caption_text_get = opentokJNI.otc_subscriber_callbacks_on_caption_text_get(this.swigCPtr, this);
        if (jOtc_subscriber_callbacks_on_caption_text_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_p_q_const__char_int__void(jOtc_subscriber_callbacks_on_caption_text_get, false);
    }

    public SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_p_q_const__struct_otc_stream__void getOn_connected() {
        long jOtc_subscriber_callbacks_on_connected_get = opentokJNI.otc_subscriber_callbacks_on_connected_get(this.swigCPtr, this);
        if (jOtc_subscriber_callbacks_on_connected_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_p_q_const__struct_otc_stream__void(jOtc_subscriber_callbacks_on_connected_get, false);
    }

    public SWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void getOn_disconnected() {
        long jOtc_subscriber_callbacks_on_disconnected_get = opentokJNI.otc_subscriber_callbacks_on_disconnected_get(this.swigCPtr, this);
        if (jOtc_subscriber_callbacks_on_disconnected_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void(jOtc_subscriber_callbacks_on_disconnected_get, false);
    }

    public SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_p_q_const__char_enum_otc_subscriber_error_code__void getOn_error() {
        long jOtc_subscriber_callbacks_on_error_get = opentokJNI.otc_subscriber_callbacks_on_error_get(this.swigCPtr, this);
        if (jOtc_subscriber_callbacks_on_error_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_p_q_const__char_enum_otc_subscriber_error_code__void(jOtc_subscriber_callbacks_on_error_get, false);
    }

    public SWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void getOn_reconnected() {
        long jOtc_subscriber_callbacks_on_reconnected_get = opentokJNI.otc_subscriber_callbacks_on_reconnected_get(this.swigCPtr, this);
        if (jOtc_subscriber_callbacks_on_reconnected_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void(jOtc_subscriber_callbacks_on_reconnected_get, false);
    }

    public SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_p_q_const__struct_otc_video_frame__void getOn_render_frame() {
        long jOtc_subscriber_callbacks_on_render_frame_get = opentokJNI.otc_subscriber_callbacks_on_render_frame_get(this.swigCPtr, this);
        if (jOtc_subscriber_callbacks_on_render_frame_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_p_q_const__struct_otc_video_frame__void(jOtc_subscriber_callbacks_on_render_frame_get, false);
    }

    public SWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void getOn_video_data_received() {
        long jOtc_subscriber_callbacks_on_video_data_received_get = opentokJNI.otc_subscriber_callbacks_on_video_data_received_get(this.swigCPtr, this);
        if (jOtc_subscriber_callbacks_on_video_data_received_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void(jOtc_subscriber_callbacks_on_video_data_received_get, false);
    }

    public SWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void getOn_video_disable_warning() {
        long jOtc_subscriber_callbacks_on_video_disable_warning_get = opentokJNI.otc_subscriber_callbacks_on_video_disable_warning_get(this.swigCPtr, this);
        if (jOtc_subscriber_callbacks_on_video_disable_warning_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void(jOtc_subscriber_callbacks_on_video_disable_warning_get, false);
    }

    public SWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void getOn_video_disable_warning_lifted() {
        long jOtc_subscriber_callbacks_on_video_disable_warning_lifted_get = opentokJNI.otc_subscriber_callbacks_on_video_disable_warning_lifted_get(this.swigCPtr, this);
        if (jOtc_subscriber_callbacks_on_video_disable_warning_lifted_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void(jOtc_subscriber_callbacks_on_video_disable_warning_lifted_get, false);
    }

    public SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_enum_otc_video_reason__void getOn_video_disabled() {
        long jOtc_subscriber_callbacks_on_video_disabled_get = opentokJNI.otc_subscriber_callbacks_on_video_disabled_get(this.swigCPtr, this);
        if (jOtc_subscriber_callbacks_on_video_disabled_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_enum_otc_video_reason__void(jOtc_subscriber_callbacks_on_video_disabled_get, false);
    }

    public SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_enum_otc_video_reason__void getOn_video_enabled() {
        long jOtc_subscriber_callbacks_on_video_enabled_get = opentokJNI.otc_subscriber_callbacks_on_video_enabled_get(this.swigCPtr, this);
        if (jOtc_subscriber_callbacks_on_video_enabled_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_enum_otc_video_reason__void(jOtc_subscriber_callbacks_on_video_enabled_get, false);
    }

    public SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_p_q_const__struct_otc_subscriber_video_stats_enum_otc_video_reason__void getOn_video_quality_changed() {
        long jOtc_subscriber_callbacks_on_video_quality_changed_get = opentokJNI.otc_subscriber_callbacks_on_video_quality_changed_get(this.swigCPtr, this);
        if (jOtc_subscriber_callbacks_on_video_quality_changed_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_p_q_const__struct_otc_subscriber_video_stats_enum_otc_video_reason__void(jOtc_subscriber_callbacks_on_video_quality_changed_get, false);
    }

    public SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_struct_otc_subscriber_video_stats__void getOn_video_stats() {
        long jOtc_subscriber_callbacks_on_video_stats_get = opentokJNI.otc_subscriber_callbacks_on_video_stats_get(this.swigCPtr, this);
        if (jOtc_subscriber_callbacks_on_video_stats_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_struct_otc_subscriber_video_stats__void(jOtc_subscriber_callbacks_on_video_stats_get, false);
    }

    public SWIGTYPE_p_void getReserved() {
        long jOtc_subscriber_callbacks_reserved_get = opentokJNI.otc_subscriber_callbacks_reserved_get(this.swigCPtr, this);
        if (jOtc_subscriber_callbacks_reserved_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(jOtc_subscriber_callbacks_reserved_get, false);
    }

    public SWIGTYPE_p_void getUser_data() {
        long jOtc_subscriber_callbacks_user_data_get = opentokJNI.otc_subscriber_callbacks_user_data_get(this.swigCPtr, this);
        if (jOtc_subscriber_callbacks_user_data_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(jOtc_subscriber_callbacks_user_data_get, false);
    }

    public void setOn_audio_data(SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_p_q_const__struct_otc_audio_data__void sWIGTYPE_p_f_p_struct_otc_subscriber_p_void_p_q_const__struct_otc_audio_data__void) {
        opentokJNI.otc_subscriber_callbacks_on_audio_data_set(this.swigCPtr, this, SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_p_q_const__struct_otc_audio_data__void.a(sWIGTYPE_p_f_p_struct_otc_subscriber_p_void_p_q_const__struct_otc_audio_data__void));
    }

    public void setOn_audio_disabled(SWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void sWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void) {
        opentokJNI.otc_subscriber_callbacks_on_audio_disabled_set(this.swigCPtr, this, SWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void.a(sWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void));
    }

    public void setOn_audio_enabled(SWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void sWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void) {
        opentokJNI.otc_subscriber_callbacks_on_audio_enabled_set(this.swigCPtr, this, SWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void.a(sWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void));
    }

    public void setOn_audio_level_updated(SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_float__void sWIGTYPE_p_f_p_struct_otc_subscriber_p_void_float__void) {
        opentokJNI.otc_subscriber_callbacks_on_audio_level_updated_set(this.swigCPtr, this, SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_float__void.a(sWIGTYPE_p_f_p_struct_otc_subscriber_p_void_float__void));
    }

    public void setOn_audio_stats(SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_struct_otc_subscriber_audio_stats__void sWIGTYPE_p_f_p_struct_otc_subscriber_p_void_struct_otc_subscriber_audio_stats__void) {
        opentokJNI.otc_subscriber_callbacks_on_audio_stats_set(this.swigCPtr, this, SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_struct_otc_subscriber_audio_stats__void.a(sWIGTYPE_p_f_p_struct_otc_subscriber_p_void_struct_otc_subscriber_audio_stats__void));
    }

    public void setOn_caption_text(SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_p_q_const__char_int__void sWIGTYPE_p_f_p_struct_otc_subscriber_p_void_p_q_const__char_int__void) {
        opentokJNI.otc_subscriber_callbacks_on_caption_text_set(this.swigCPtr, this, SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_p_q_const__char_int__void.a(sWIGTYPE_p_f_p_struct_otc_subscriber_p_void_p_q_const__char_int__void));
    }

    public void setOn_connected(SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_p_q_const__struct_otc_stream__void sWIGTYPE_p_f_p_struct_otc_subscriber_p_void_p_q_const__struct_otc_stream__void) {
        opentokJNI.otc_subscriber_callbacks_on_connected_set(this.swigCPtr, this, SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_p_q_const__struct_otc_stream__void.a(sWIGTYPE_p_f_p_struct_otc_subscriber_p_void_p_q_const__struct_otc_stream__void));
    }

    public void setOn_disconnected(SWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void sWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void) {
        opentokJNI.otc_subscriber_callbacks_on_disconnected_set(this.swigCPtr, this, SWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void.a(sWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void));
    }

    public void setOn_error(SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_p_q_const__char_enum_otc_subscriber_error_code__void sWIGTYPE_p_f_p_struct_otc_subscriber_p_void_p_q_const__char_enum_otc_subscriber_error_code__void) {
        opentokJNI.otc_subscriber_callbacks_on_error_set(this.swigCPtr, this, SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_p_q_const__char_enum_otc_subscriber_error_code__void.a(sWIGTYPE_p_f_p_struct_otc_subscriber_p_void_p_q_const__char_enum_otc_subscriber_error_code__void));
    }

    public void setOn_reconnected(SWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void sWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void) {
        opentokJNI.otc_subscriber_callbacks_on_reconnected_set(this.swigCPtr, this, SWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void.a(sWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void));
    }

    public void setOn_render_frame(SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_p_q_const__struct_otc_video_frame__void sWIGTYPE_p_f_p_struct_otc_subscriber_p_void_p_q_const__struct_otc_video_frame__void) {
        opentokJNI.otc_subscriber_callbacks_on_render_frame_set(this.swigCPtr, this, SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_p_q_const__struct_otc_video_frame__void.a(sWIGTYPE_p_f_p_struct_otc_subscriber_p_void_p_q_const__struct_otc_video_frame__void));
    }

    public void setOn_video_data_received(SWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void sWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void) {
        opentokJNI.otc_subscriber_callbacks_on_video_data_received_set(this.swigCPtr, this, SWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void.a(sWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void));
    }

    public void setOn_video_disable_warning(SWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void sWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void) {
        opentokJNI.otc_subscriber_callbacks_on_video_disable_warning_set(this.swigCPtr, this, SWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void.a(sWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void));
    }

    public void setOn_video_disable_warning_lifted(SWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void sWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void) {
        opentokJNI.otc_subscriber_callbacks_on_video_disable_warning_lifted_set(this.swigCPtr, this, SWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void.a(sWIGTYPE_p_f_p_struct_otc_subscriber_p_void__void));
    }

    public void setOn_video_disabled(SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_enum_otc_video_reason__void sWIGTYPE_p_f_p_struct_otc_subscriber_p_void_enum_otc_video_reason__void) {
        opentokJNI.otc_subscriber_callbacks_on_video_disabled_set(this.swigCPtr, this, SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_enum_otc_video_reason__void.a(sWIGTYPE_p_f_p_struct_otc_subscriber_p_void_enum_otc_video_reason__void));
    }

    public void setOn_video_enabled(SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_enum_otc_video_reason__void sWIGTYPE_p_f_p_struct_otc_subscriber_p_void_enum_otc_video_reason__void) {
        opentokJNI.otc_subscriber_callbacks_on_video_enabled_set(this.swigCPtr, this, SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_enum_otc_video_reason__void.a(sWIGTYPE_p_f_p_struct_otc_subscriber_p_void_enum_otc_video_reason__void));
    }

    public void setOn_video_quality_changed(SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_p_q_const__struct_otc_subscriber_video_stats_enum_otc_video_reason__void sWIGTYPE_p_f_p_struct_otc_subscriber_p_void_p_q_const__struct_otc_subscriber_video_stats_enum_otc_video_reason__void) {
        opentokJNI.otc_subscriber_callbacks_on_video_quality_changed_set(this.swigCPtr, this, SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_p_q_const__struct_otc_subscriber_video_stats_enum_otc_video_reason__void.a(sWIGTYPE_p_f_p_struct_otc_subscriber_p_void_p_q_const__struct_otc_subscriber_video_stats_enum_otc_video_reason__void));
    }

    public void setOn_video_stats(SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_struct_otc_subscriber_video_stats__void sWIGTYPE_p_f_p_struct_otc_subscriber_p_void_struct_otc_subscriber_video_stats__void) {
        opentokJNI.otc_subscriber_callbacks_on_video_stats_set(this.swigCPtr, this, SWIGTYPE_p_f_p_struct_otc_subscriber_p_void_struct_otc_subscriber_video_stats__void.a(sWIGTYPE_p_f_p_struct_otc_subscriber_p_void_struct_otc_subscriber_video_stats__void));
    }

    public void setReserved(SWIGTYPE_p_void sWIGTYPE_p_void) {
        opentokJNI.otc_subscriber_callbacks_reserved_set(this.swigCPtr, this, SWIGTYPE_p_void.a(sWIGTYPE_p_void));
    }

    public void setUser_data(SWIGTYPE_p_void sWIGTYPE_p_void) {
        opentokJNI.otc_subscriber_callbacks_user_data_set(this.swigCPtr, this, SWIGTYPE_p_void.a(sWIGTYPE_p_void));
    }
}
