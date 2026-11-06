package com.opentok.otc;

/* JADX INFO: loaded from: classes4.dex */
public class otc_publisher_callbacks {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected otc_publisher_callbacks(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(otc_publisher_callbacks otc_publisher_callbacksVar) {
        if (otc_publisher_callbacksVar == null) {
            return 0L;
        }
        return otc_publisher_callbacksVar.swigCPtr;
    }

    protected static long swigRelease(otc_publisher_callbacks otc_publisher_callbacksVar) {
        if (otc_publisher_callbacksVar == null) {
            return 0L;
        }
        if (!otc_publisher_callbacksVar.swigCMemOwn) {
            throw new RuntimeException("Cannot release ownership as memory is not owned");
        }
        long j = otc_publisher_callbacksVar.swigCPtr;
        otc_publisher_callbacksVar.swigCMemOwn = false;
        otc_publisher_callbacksVar.delete();
        return j;
    }

    public synchronized void delete() {
        try {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    opentokJNI.delete_otc_publisher_callbacks(j);
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

    public SWIGTYPE_p_f_p_struct_otc_publisher_p_void_float__void getOn_audio_level_updated() {
        long jOtc_publisher_callbacks_on_audio_level_updated_get = opentokJNI.otc_publisher_callbacks_on_audio_level_updated_get(this.swigCPtr, this);
        if (jOtc_publisher_callbacks_on_audio_level_updated_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_f_p_struct_otc_publisher_p_void_float__void(jOtc_publisher_callbacks_on_audio_level_updated_get, false);
    }

    public SWIGTYPE_p_f_p_struct_otc_publisher_p_void_a___struct_otc_publisher_audio_stats_size_t__void getOn_audio_stats() {
        long jOtc_publisher_callbacks_on_audio_stats_get = opentokJNI.otc_publisher_callbacks_on_audio_stats_get(this.swigCPtr, this);
        if (jOtc_publisher_callbacks_on_audio_stats_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_f_p_struct_otc_publisher_p_void_a___struct_otc_publisher_audio_stats_size_t__void(jOtc_publisher_callbacks_on_audio_stats_get, false);
    }

    public SWIGTYPE_p_f_p_struct_otc_publisher_p_void_p_q_const__char_enum_otc_publisher_error_code__void getOn_error() {
        long jOtc_publisher_callbacks_on_error_get = opentokJNI.otc_publisher_callbacks_on_error_get(this.swigCPtr, this);
        if (jOtc_publisher_callbacks_on_error_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_f_p_struct_otc_publisher_p_void_p_q_const__char_enum_otc_publisher_error_code__void(jOtc_publisher_callbacks_on_error_get, false);
    }

    public SWIGTYPE_p_f_p_struct_otc_publisher_p_void__void getOn_publisher_mute_forced() {
        long jOtc_publisher_callbacks_on_publisher_mute_forced_get = opentokJNI.otc_publisher_callbacks_on_publisher_mute_forced_get(this.swigCPtr, this);
        if (jOtc_publisher_callbacks_on_publisher_mute_forced_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_f_p_struct_otc_publisher_p_void__void(jOtc_publisher_callbacks_on_publisher_mute_forced_get, false);
    }

    public SWIGTYPE_p_f_p_struct_otc_publisher_p_void_p_q_const__struct_otc_video_frame__void getOn_render_frame() {
        long jOtc_publisher_callbacks_on_render_frame_get = opentokJNI.otc_publisher_callbacks_on_render_frame_get(this.swigCPtr, this);
        if (jOtc_publisher_callbacks_on_render_frame_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_f_p_struct_otc_publisher_p_void_p_q_const__struct_otc_video_frame__void(jOtc_publisher_callbacks_on_render_frame_get, false);
    }

    public SWIGTYPE_p_f_p_struct_otc_publisher_p_void_p_q_const__struct_otc_stream__void getOn_stream_created() {
        long jOtc_publisher_callbacks_on_stream_created_get = opentokJNI.otc_publisher_callbacks_on_stream_created_get(this.swigCPtr, this);
        if (jOtc_publisher_callbacks_on_stream_created_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_f_p_struct_otc_publisher_p_void_p_q_const__struct_otc_stream__void(jOtc_publisher_callbacks_on_stream_created_get, false);
    }

    public SWIGTYPE_p_f_p_struct_otc_publisher_p_void_p_q_const__struct_otc_stream__void getOn_stream_destroyed() {
        long jOtc_publisher_callbacks_on_stream_destroyed_get = opentokJNI.otc_publisher_callbacks_on_stream_destroyed_get(this.swigCPtr, this);
        if (jOtc_publisher_callbacks_on_stream_destroyed_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_f_p_struct_otc_publisher_p_void_p_q_const__struct_otc_stream__void(jOtc_publisher_callbacks_on_stream_destroyed_get, false);
    }

    public SWIGTYPE_p_f_p_struct_otc_publisher_p_void__void getOn_video_disable_warning() {
        long jOtc_publisher_callbacks_on_video_disable_warning_get = opentokJNI.otc_publisher_callbacks_on_video_disable_warning_get(this.swigCPtr, this);
        if (jOtc_publisher_callbacks_on_video_disable_warning_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_f_p_struct_otc_publisher_p_void__void(jOtc_publisher_callbacks_on_video_disable_warning_get, false);
    }

    public SWIGTYPE_p_f_p_struct_otc_publisher_p_void__void getOn_video_disable_warning_lifted() {
        long jOtc_publisher_callbacks_on_video_disable_warning_lifted_get = opentokJNI.otc_publisher_callbacks_on_video_disable_warning_lifted_get(this.swigCPtr, this);
        if (jOtc_publisher_callbacks_on_video_disable_warning_lifted_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_f_p_struct_otc_publisher_p_void__void(jOtc_publisher_callbacks_on_video_disable_warning_lifted_get, false);
    }

    public SWIGTYPE_p_f_p_struct_otc_publisher_p_void_enum_otc_video_reason__void getOn_video_disabled() {
        long jOtc_publisher_callbacks_on_video_disabled_get = opentokJNI.otc_publisher_callbacks_on_video_disabled_get(this.swigCPtr, this);
        if (jOtc_publisher_callbacks_on_video_disabled_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_f_p_struct_otc_publisher_p_void_enum_otc_video_reason__void(jOtc_publisher_callbacks_on_video_disabled_get, false);
    }

    public SWIGTYPE_p_f_p_struct_otc_publisher_p_void_enum_otc_video_reason__void getOn_video_enabled() {
        long jOtc_publisher_callbacks_on_video_enabled_get = opentokJNI.otc_publisher_callbacks_on_video_enabled_get(this.swigCPtr, this);
        if (jOtc_publisher_callbacks_on_video_enabled_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_f_p_struct_otc_publisher_p_void_enum_otc_video_reason__void(jOtc_publisher_callbacks_on_video_enabled_get, false);
    }

    public SWIGTYPE_p_f_p_struct_otc_publisher_p_void_p_q_const__struct_otc_publisher_video_stats_enum_otc_video_reason__void getOn_video_quality_changed() {
        long jOtc_publisher_callbacks_on_video_quality_changed_get = opentokJNI.otc_publisher_callbacks_on_video_quality_changed_get(this.swigCPtr, this);
        if (jOtc_publisher_callbacks_on_video_quality_changed_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_f_p_struct_otc_publisher_p_void_p_q_const__struct_otc_publisher_video_stats_enum_otc_video_reason__void(jOtc_publisher_callbacks_on_video_quality_changed_get, false);
    }

    public SWIGTYPE_p_f_p_struct_otc_publisher_p_void_a___struct_otc_publisher_video_stats_size_t__void getOn_video_stats() {
        long jOtc_publisher_callbacks_on_video_stats_get = opentokJNI.otc_publisher_callbacks_on_video_stats_get(this.swigCPtr, this);
        if (jOtc_publisher_callbacks_on_video_stats_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_f_p_struct_otc_publisher_p_void_a___struct_otc_publisher_video_stats_size_t__void(jOtc_publisher_callbacks_on_video_stats_get, false);
    }

    public SWIGTYPE_p_void getReserved() {
        long jOtc_publisher_callbacks_reserved_get = opentokJNI.otc_publisher_callbacks_reserved_get(this.swigCPtr, this);
        if (jOtc_publisher_callbacks_reserved_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(jOtc_publisher_callbacks_reserved_get, false);
    }

    public SWIGTYPE_p_void getUser_data() {
        long jOtc_publisher_callbacks_user_data_get = opentokJNI.otc_publisher_callbacks_user_data_get(this.swigCPtr, this);
        if (jOtc_publisher_callbacks_user_data_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(jOtc_publisher_callbacks_user_data_get, false);
    }

    public void setOn_audio_level_updated(SWIGTYPE_p_f_p_struct_otc_publisher_p_void_float__void sWIGTYPE_p_f_p_struct_otc_publisher_p_void_float__void) {
        opentokJNI.otc_publisher_callbacks_on_audio_level_updated_set(this.swigCPtr, this, SWIGTYPE_p_f_p_struct_otc_publisher_p_void_float__void.a(sWIGTYPE_p_f_p_struct_otc_publisher_p_void_float__void));
    }

    public void setOn_audio_stats(SWIGTYPE_p_f_p_struct_otc_publisher_p_void_a___struct_otc_publisher_audio_stats_size_t__void sWIGTYPE_p_f_p_struct_otc_publisher_p_void_a___struct_otc_publisher_audio_stats_size_t__void) {
        opentokJNI.otc_publisher_callbacks_on_audio_stats_set(this.swigCPtr, this, SWIGTYPE_p_f_p_struct_otc_publisher_p_void_a___struct_otc_publisher_audio_stats_size_t__void.a(sWIGTYPE_p_f_p_struct_otc_publisher_p_void_a___struct_otc_publisher_audio_stats_size_t__void));
    }

    public void setOn_error(SWIGTYPE_p_f_p_struct_otc_publisher_p_void_p_q_const__char_enum_otc_publisher_error_code__void sWIGTYPE_p_f_p_struct_otc_publisher_p_void_p_q_const__char_enum_otc_publisher_error_code__void) {
        opentokJNI.otc_publisher_callbacks_on_error_set(this.swigCPtr, this, SWIGTYPE_p_f_p_struct_otc_publisher_p_void_p_q_const__char_enum_otc_publisher_error_code__void.a(sWIGTYPE_p_f_p_struct_otc_publisher_p_void_p_q_const__char_enum_otc_publisher_error_code__void));
    }

    public void setOn_publisher_mute_forced(SWIGTYPE_p_f_p_struct_otc_publisher_p_void__void sWIGTYPE_p_f_p_struct_otc_publisher_p_void__void) {
        opentokJNI.otc_publisher_callbacks_on_publisher_mute_forced_set(this.swigCPtr, this, SWIGTYPE_p_f_p_struct_otc_publisher_p_void__void.a(sWIGTYPE_p_f_p_struct_otc_publisher_p_void__void));
    }

    public void setOn_render_frame(SWIGTYPE_p_f_p_struct_otc_publisher_p_void_p_q_const__struct_otc_video_frame__void sWIGTYPE_p_f_p_struct_otc_publisher_p_void_p_q_const__struct_otc_video_frame__void) {
        opentokJNI.otc_publisher_callbacks_on_render_frame_set(this.swigCPtr, this, SWIGTYPE_p_f_p_struct_otc_publisher_p_void_p_q_const__struct_otc_video_frame__void.a(sWIGTYPE_p_f_p_struct_otc_publisher_p_void_p_q_const__struct_otc_video_frame__void));
    }

    public void setOn_stream_created(SWIGTYPE_p_f_p_struct_otc_publisher_p_void_p_q_const__struct_otc_stream__void sWIGTYPE_p_f_p_struct_otc_publisher_p_void_p_q_const__struct_otc_stream__void) {
        opentokJNI.otc_publisher_callbacks_on_stream_created_set(this.swigCPtr, this, SWIGTYPE_p_f_p_struct_otc_publisher_p_void_p_q_const__struct_otc_stream__void.a(sWIGTYPE_p_f_p_struct_otc_publisher_p_void_p_q_const__struct_otc_stream__void));
    }

    public void setOn_stream_destroyed(SWIGTYPE_p_f_p_struct_otc_publisher_p_void_p_q_const__struct_otc_stream__void sWIGTYPE_p_f_p_struct_otc_publisher_p_void_p_q_const__struct_otc_stream__void) {
        opentokJNI.otc_publisher_callbacks_on_stream_destroyed_set(this.swigCPtr, this, SWIGTYPE_p_f_p_struct_otc_publisher_p_void_p_q_const__struct_otc_stream__void.a(sWIGTYPE_p_f_p_struct_otc_publisher_p_void_p_q_const__struct_otc_stream__void));
    }

    public void setOn_video_disable_warning(SWIGTYPE_p_f_p_struct_otc_publisher_p_void__void sWIGTYPE_p_f_p_struct_otc_publisher_p_void__void) {
        opentokJNI.otc_publisher_callbacks_on_video_disable_warning_set(this.swigCPtr, this, SWIGTYPE_p_f_p_struct_otc_publisher_p_void__void.a(sWIGTYPE_p_f_p_struct_otc_publisher_p_void__void));
    }

    public void setOn_video_disable_warning_lifted(SWIGTYPE_p_f_p_struct_otc_publisher_p_void__void sWIGTYPE_p_f_p_struct_otc_publisher_p_void__void) {
        opentokJNI.otc_publisher_callbacks_on_video_disable_warning_lifted_set(this.swigCPtr, this, SWIGTYPE_p_f_p_struct_otc_publisher_p_void__void.a(sWIGTYPE_p_f_p_struct_otc_publisher_p_void__void));
    }

    public void setOn_video_disabled(SWIGTYPE_p_f_p_struct_otc_publisher_p_void_enum_otc_video_reason__void sWIGTYPE_p_f_p_struct_otc_publisher_p_void_enum_otc_video_reason__void) {
        opentokJNI.otc_publisher_callbacks_on_video_disabled_set(this.swigCPtr, this, SWIGTYPE_p_f_p_struct_otc_publisher_p_void_enum_otc_video_reason__void.a(sWIGTYPE_p_f_p_struct_otc_publisher_p_void_enum_otc_video_reason__void));
    }

    public void setOn_video_enabled(SWIGTYPE_p_f_p_struct_otc_publisher_p_void_enum_otc_video_reason__void sWIGTYPE_p_f_p_struct_otc_publisher_p_void_enum_otc_video_reason__void) {
        opentokJNI.otc_publisher_callbacks_on_video_enabled_set(this.swigCPtr, this, SWIGTYPE_p_f_p_struct_otc_publisher_p_void_enum_otc_video_reason__void.a(sWIGTYPE_p_f_p_struct_otc_publisher_p_void_enum_otc_video_reason__void));
    }

    public void setOn_video_quality_changed(SWIGTYPE_p_f_p_struct_otc_publisher_p_void_p_q_const__struct_otc_publisher_video_stats_enum_otc_video_reason__void sWIGTYPE_p_f_p_struct_otc_publisher_p_void_p_q_const__struct_otc_publisher_video_stats_enum_otc_video_reason__void) {
        opentokJNI.otc_publisher_callbacks_on_video_quality_changed_set(this.swigCPtr, this, SWIGTYPE_p_f_p_struct_otc_publisher_p_void_p_q_const__struct_otc_publisher_video_stats_enum_otc_video_reason__void.a(sWIGTYPE_p_f_p_struct_otc_publisher_p_void_p_q_const__struct_otc_publisher_video_stats_enum_otc_video_reason__void));
    }

    public void setOn_video_stats(SWIGTYPE_p_f_p_struct_otc_publisher_p_void_a___struct_otc_publisher_video_stats_size_t__void sWIGTYPE_p_f_p_struct_otc_publisher_p_void_a___struct_otc_publisher_video_stats_size_t__void) {
        opentokJNI.otc_publisher_callbacks_on_video_stats_set(this.swigCPtr, this, SWIGTYPE_p_f_p_struct_otc_publisher_p_void_a___struct_otc_publisher_video_stats_size_t__void.a(sWIGTYPE_p_f_p_struct_otc_publisher_p_void_a___struct_otc_publisher_video_stats_size_t__void));
    }

    public void setReserved(SWIGTYPE_p_void sWIGTYPE_p_void) {
        opentokJNI.otc_publisher_callbacks_reserved_set(this.swigCPtr, this, SWIGTYPE_p_void.a(sWIGTYPE_p_void));
    }

    public void setUser_data(SWIGTYPE_p_void sWIGTYPE_p_void) {
        opentokJNI.otc_publisher_callbacks_user_data_set(this.swigCPtr, this, SWIGTYPE_p_void.a(sWIGTYPE_p_void));
    }
}
