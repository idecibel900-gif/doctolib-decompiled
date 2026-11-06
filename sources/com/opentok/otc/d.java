package com.opentok.otc;

/* JADX INFO: loaded from: classes4.dex */
public abstract class d {
    public static short a(c cVar, long j) {
        return opentokJNI.uint8Array_getitem(c.a(cVar), j);
    }

    public static int b(SWIGTYPE_p_otc_session sWIGTYPE_p_otc_session, int[] iArr) {
        return opentokJNI.otc_session_get_ice_config_server_count(SWIGTYPE_p_otc_session.a(sWIGTYPE_p_otc_session), iArr);
    }

    public static String[] c(SWIGTYPE_p_otc_session sWIGTYPE_p_otc_session, int[] iArr) {
        return opentokJNI.otc_session_get_ice_config_server_urls(SWIGTYPE_p_otc_session.a(sWIGTYPE_p_otc_session), iArr);
    }

    public static String[] d(SWIGTYPE_p_otc_session sWIGTYPE_p_otc_session, int[] iArr) {
        return opentokJNI.otc_session_get_ice_config_users(SWIGTYPE_p_otc_session.a(sWIGTYPE_p_otc_session), iArr);
    }

    public static String e(SWIGTYPE_p_otc_connection sWIGTYPE_p_otc_connection) {
        return opentokJNI.otc_connection_get_id(SWIGTYPE_p_otc_connection.getCPtr(sWIGTYPE_p_otc_connection));
    }

    public static int f(SWIGTYPE_p_otc_publisher_settings sWIGTYPE_p_otc_publisher_settings, int i) {
        return opentokJNI.otc_publisher_settings_set_sender_stats_track(SWIGTYPE_p_otc_publisher_settings.getCPtr(sWIGTYPE_p_otc_publisher_settings), i);
    }

    public static int g(SWIGTYPE_p_otc_session sWIGTYPE_p_otc_session) {
        return opentokJNI.otc_session_migrate(SWIGTYPE_p_otc_session.a(sWIGTYPE_p_otc_session));
    }

    public static int h(SWIGTYPE_p_otc_session sWIGTYPE_p_otc_session) {
        return opentokJNI.otc_session_reconnect(SWIGTYPE_p_otc_session.a(sWIGTYPE_p_otc_session));
    }

    public static SWIGTYPE_p_otc_session i(SWIGTYPE_p_otc_publisher sWIGTYPE_p_otc_publisher) {
        long jOtc_publisher_get_session = opentokJNI.otc_publisher_get_session(SWIGTYPE_p_otc_publisher.getCPtr(sWIGTYPE_p_otc_publisher));
        if (jOtc_publisher_get_session == 0) {
            return null;
        }
        return new SWIGTYPE_p_otc_session(jOtc_publisher_get_session, false);
    }

    public static SWIGTYPE_p_otc_stream j(SWIGTYPE_p_otc_publisher sWIGTYPE_p_otc_publisher) {
        long jOtc_publisher_get_stream = opentokJNI.otc_publisher_get_stream(SWIGTYPE_p_otc_publisher.getCPtr(sWIGTYPE_p_otc_publisher));
        if (jOtc_publisher_get_stream == 0) {
            return null;
        }
        return new SWIGTYPE_p_otc_stream(jOtc_publisher_get_stream, false);
    }

    public static j k(SWIGTYPE_p_otc_publisher sWIGTYPE_p_otc_publisher) {
        return j.a(opentokJNI.otc_publisher_get_video_bitrate_preset(SWIGTYPE_p_otc_publisher.getCPtr(sWIGTYPE_p_otc_publisher)));
    }

    public static h l(SWIGTYPE_p_otc_publisher sWIGTYPE_p_otc_publisher) {
        return h.a(opentokJNI.otc_publisher_get_video_type(SWIGTYPE_p_otc_publisher.getCPtr(sWIGTYPE_p_otc_publisher)));
    }

    public static b a() {
        long jNew_sizetPointer = opentokJNI.new_sizetPointer();
        if (jNew_sizetPointer == 0) {
            return null;
        }
        return new b(jNew_sizetPointer, false);
    }

    public static int b() {
        return opentokJNI.otc_get_last_error();
    }

    public static String c(SWIGTYPE_p_otc_session sWIGTYPE_p_otc_session, String str) {
        return opentokJNI.otc_session_report_issue_ex(SWIGTYPE_p_otc_session.a(sWIGTYPE_p_otc_session), str);
    }

    public static String d(SWIGTYPE_p_otc_connection sWIGTYPE_p_otc_connection) {
        return opentokJNI.otc_connection_get_data(SWIGTYPE_p_otc_connection.getCPtr(sWIGTYPE_p_otc_connection));
    }

    public static int e(SWIGTYPE_p_otc_publisher_settings sWIGTYPE_p_otc_publisher_settings, int i) {
        return opentokJNI.otc_publisher_settings_set_scalable_screenshare(SWIGTYPE_p_otc_publisher_settings.getCPtr(sWIGTYPE_p_otc_publisher_settings), i);
    }

    public static int f(SWIGTYPE_p_otc_publisher sWIGTYPE_p_otc_publisher) {
        return opentokJNI.otc_publisher_get_publish_captions(SWIGTYPE_p_otc_publisher.getCPtr(sWIGTYPE_p_otc_publisher));
    }

    public static int g(SWIGTYPE_p_otc_publisher sWIGTYPE_p_otc_publisher) {
        return opentokJNI.otc_publisher_get_publish_video(SWIGTYPE_p_otc_publisher.getCPtr(sWIGTYPE_p_otc_publisher));
    }

    public static int h(SWIGTYPE_p_otc_publisher_settings sWIGTYPE_p_otc_publisher_settings, int i) {
        return opentokJNI.otc_publisher_settings_set_video_track(SWIGTYPE_p_otc_publisher_settings.getCPtr(sWIGTYPE_p_otc_publisher_settings), i);
    }

    public static int k(SWIGTYPE_p_otc_stream sWIGTYPE_p_otc_stream) {
        return opentokJNI.otc_stream_has_captions(SWIGTYPE_p_otc_stream.getCPtr(sWIGTYPE_p_otc_stream));
    }

    public static int l(SWIGTYPE_p_otc_stream sWIGTYPE_p_otc_stream) {
        return opentokJNI.otc_stream_has_video(SWIGTYPE_p_otc_stream.getCPtr(sWIGTYPE_p_otc_stream));
    }

    public static int b(SWIGTYPE_p_otc_video_frame sWIGTYPE_p_otc_video_frame) {
        return opentokJNI.otc_video_frame_get_height(SWIGTYPE_p_otc_video_frame.getCPtr(sWIGTYPE_p_otc_video_frame));
    }

    public static int c(SWIGTYPE_p_otc_video_frame sWIGTYPE_p_otc_video_frame) {
        return opentokJNI.otc_video_frame_get_width(SWIGTYPE_p_otc_video_frame.getCPtr(sWIGTYPE_p_otc_video_frame));
    }

    public static int d(SWIGTYPE_p_otc_publisher sWIGTYPE_p_otc_publisher, int i) {
        return opentokJNI.otc_publisher_set_publish_video(SWIGTYPE_p_otc_publisher.getCPtr(sWIGTYPE_p_otc_publisher), i);
    }

    public static int e(SWIGTYPE_p_otc_publisher sWIGTYPE_p_otc_publisher) {
        return opentokJNI.otc_publisher_get_publish_audio(SWIGTYPE_p_otc_publisher.getCPtr(sWIGTYPE_p_otc_publisher));
    }

    public static String f(SWIGTYPE_p_otc_session sWIGTYPE_p_otc_session) {
        return opentokJNI.otc_session_get_id(SWIGTYPE_p_otc_session.a(sWIGTYPE_p_otc_session));
    }

    public static int g(SWIGTYPE_p_otc_publisher_settings sWIGTYPE_p_otc_publisher_settings, int i) {
        return opentokJNI.otc_publisher_settings_set_subscriber_audio_fallback_enabled(SWIGTYPE_p_otc_publisher_settings.getCPtr(sWIGTYPE_p_otc_publisher_settings), i);
    }

    public static int h(SWIGTYPE_p_otc_publisher sWIGTYPE_p_otc_publisher) {
        return opentokJNI.otc_publisher_get_rtc_stats_report(SWIGTYPE_p_otc_publisher.getCPtr(sWIGTYPE_p_otc_publisher));
    }

    public static int i(SWIGTYPE_p_otc_stream sWIGTYPE_p_otc_stream) {
        return opentokJNI.otc_stream_get_video_width(SWIGTYPE_p_otc_stream.getCPtr(sWIGTYPE_p_otc_stream));
    }

    public static int j(SWIGTYPE_p_otc_stream sWIGTYPE_p_otc_stream) {
        return opentokJNI.otc_stream_has_audio(SWIGTYPE_p_otc_stream.getCPtr(sWIGTYPE_p_otc_stream));
    }

    public static long a(b bVar) {
        return opentokJNI.sizetPointer_value(b.a(bVar));
    }

    public static int b(SWIGTYPE_p_otc_video_frame sWIGTYPE_p_otc_video_frame, k kVar) {
        return opentokJNI.otc_video_frame_get_plane_stride(SWIGTYPE_p_otc_video_frame.getCPtr(sWIGTYPE_p_otc_video_frame), kVar.a());
    }

    public static long c(SWIGTYPE_p_otc_connection sWIGTYPE_p_otc_connection) {
        return opentokJNI.otc_connection_get_creation_time(SWIGTYPE_p_otc_connection.getCPtr(sWIGTYPE_p_otc_connection));
    }

    public static String d(SWIGTYPE_p_otc_publisher sWIGTYPE_p_otc_publisher) {
        return opentokJNI.otc_publisher_get_name(SWIGTYPE_p_otc_publisher.getCPtr(sWIGTYPE_p_otc_publisher));
    }

    public static SWIGTYPE_p_otc_connection e(SWIGTYPE_p_otc_session sWIGTYPE_p_otc_session) {
        long jOtc_session_get_connection = opentokJNI.otc_session_get_connection(SWIGTYPE_p_otc_session.a(sWIGTYPE_p_otc_session));
        if (jOtc_session_get_connection == 0) {
            return null;
        }
        return new SWIGTYPE_p_otc_connection(jOtc_session_get_connection, false);
    }

    public static int f(SWIGTYPE_p_otc_subscriber sWIGTYPE_p_otc_subscriber) {
        return opentokJNI.otc_subscriber_get_subscribe_to_captions(SWIGTYPE_p_otc_subscriber.a(sWIGTYPE_p_otc_subscriber));
    }

    public static int g(SWIGTYPE_p_otc_subscriber sWIGTYPE_p_otc_subscriber) {
        return opentokJNI.otc_subscriber_get_subscribe_to_video(SWIGTYPE_p_otc_subscriber.a(sWIGTYPE_p_otc_subscriber));
    }

    public static otc_stream_video_type h(SWIGTYPE_p_otc_stream sWIGTYPE_p_otc_stream) {
        return otc_stream_video_type.a(opentokJNI.otc_stream_get_video_type(SWIGTYPE_p_otc_stream.getCPtr(sWIGTYPE_p_otc_stream)));
    }

    public static int a(SWIGTYPE_p_otc_session sWIGTYPE_p_otc_session, String str, String str2, int i, int i2, String str3) {
        return opentokJNI.otc_session_connect_to_host(SWIGTYPE_p_otc_session.a(sWIGTYPE_p_otc_session), str, str2, i, i2, str3);
    }

    public static int b(SWIGTYPE_p_otc_connection sWIGTYPE_p_otc_connection) {
        return opentokJNI.otc_connection_delete(SWIGTYPE_p_otc_connection.getCPtr(sWIGTYPE_p_otc_connection));
    }

    public static SWIGTYPE_p_otc_publisher_settings c() {
        long jOtc_publisher_settings_new = opentokJNI.otc_publisher_settings_new();
        if (jOtc_publisher_settings_new == 0) {
            return null;
        }
        return new SWIGTYPE_p_otc_publisher_settings(jOtc_publisher_settings_new, false);
    }

    public static int d(SWIGTYPE_p_otc_publisher_settings sWIGTYPE_p_otc_publisher_settings, int i) {
        return opentokJNI.otc_publisher_settings_set_publisher_audio_fallback_enabled(SWIGTYPE_p_otc_publisher_settings.getCPtr(sWIGTYPE_p_otc_publisher_settings), i);
    }

    public static String f(SWIGTYPE_p_otc_stream sWIGTYPE_p_otc_stream) {
        return opentokJNI.otc_stream_get_name(SWIGTYPE_p_otc_stream.getCPtr(sWIGTYPE_p_otc_stream));
    }

    public static int g(SWIGTYPE_p_otc_stream sWIGTYPE_p_otc_stream) {
        return opentokJNI.otc_stream_get_video_height(SWIGTYPE_p_otc_stream.getCPtr(sWIGTYPE_p_otc_stream));
    }

    public static void a(SWIGTYPE_p_otc_session sWIGTYPE_p_otc_session, g gVar) {
        opentokJNI.otc_session_log_external_device_use(SWIGTYPE_p_otc_session.a(sWIGTYPE_p_otc_session), gVar.a());
    }

    public static int b(SWIGTYPE_p_otc_publisher_settings sWIGTYPE_p_otc_publisher_settings, int i) {
        return opentokJNI.otc_publisher_settings_set_audio_track(SWIGTYPE_p_otc_publisher_settings.getCPtr(sWIGTYPE_p_otc_publisher_settings), i);
    }

    public static a d() {
        long jOtc_session_settings_new = opentokJNI.otc_session_settings_new();
        if (jOtc_session_settings_new == 0) {
            return null;
        }
        return new a(jOtc_session_settings_new, false);
    }

    public static int e(SWIGTYPE_p_otc_subscriber sWIGTYPE_p_otc_subscriber) {
        return opentokJNI.otc_subscriber_get_subscribe_to_audio(SWIGTYPE_p_otc_subscriber.a(sWIGTYPE_p_otc_subscriber));
    }

    public static String[] a(SWIGTYPE_p_otc_session sWIGTYPE_p_otc_session, int[] iArr) {
        return opentokJNI.otc_session_get_ice_config_credentials(SWIGTYPE_p_otc_session.a(sWIGTYPE_p_otc_session), iArr);
    }

    public static int b(SWIGTYPE_p_otc_publisher sWIGTYPE_p_otc_publisher, int i) {
        return opentokJNI.otc_publisher_set_publish_audio(SWIGTYPE_p_otc_publisher.getCPtr(sWIGTYPE_p_otc_publisher), i);
    }

    public static int c(SWIGTYPE_p_otc_publisher_settings sWIGTYPE_p_otc_publisher_settings, int i) {
        return opentokJNI.otc_publisher_settings_set_opus_dtx(SWIGTYPE_p_otc_publisher_settings.getCPtr(sWIGTYPE_p_otc_publisher_settings), i);
    }

    public static String e(SWIGTYPE_p_otc_stream sWIGTYPE_p_otc_stream) {
        return opentokJNI.otc_stream_get_id(SWIGTYPE_p_otc_stream.getCPtr(sWIGTYPE_p_otc_stream));
    }

    public static int a(a aVar, int i, String[] strArr, String[] strArr2, String[] strArr3, int i2, int i3, int i4) {
        return opentokJNI.otc_session_settings_set_custom_ice_config_no_struct(a.a(aVar), i, strArr, strArr2, strArr3, i2, i3, i4);
    }

    public static f b(SWIGTYPE_p_otc_publisher sWIGTYPE_p_otc_publisher) {
        return f.a(opentokJNI.otc_publisher_get_degradation_preference(SWIGTYPE_p_otc_publisher.getCPtr(sWIGTYPE_p_otc_publisher)));
    }

    public static int c(SWIGTYPE_p_otc_publisher sWIGTYPE_p_otc_publisher, int i) {
        return opentokJNI.otc_publisher_set_publish_captions(SWIGTYPE_p_otc_publisher.getCPtr(sWIGTYPE_p_otc_publisher), i);
    }

    public static int d(a aVar, int i) {
        return opentokJNI.otc_session_settings_set_single_peer_connection(a.a(aVar), i);
    }

    public static String[] a(int[] iArr) {
        return opentokJNI.otc_media_utils_get_supported_codecs_array(iArr);
    }

    public static int b(SWIGTYPE_p_otc_publisher_settings sWIGTYPE_p_otc_publisher_settings) {
        return opentokJNI.otc_publisher_settings_set_preferred_video_codecs_automatic(SWIGTYPE_p_otc_publisher_settings.getCPtr(sWIGTYPE_p_otc_publisher_settings));
    }

    public static int c(SWIGTYPE_p_otc_publisher sWIGTYPE_p_otc_publisher) {
        return opentokJNI.otc_publisher_get_max_video_bitrate(SWIGTYPE_p_otc_publisher.getCPtr(sWIGTYPE_p_otc_publisher));
    }

    public static otc_session_capabilities d(SWIGTYPE_p_otc_session sWIGTYPE_p_otc_session) {
        return new otc_session_capabilities(opentokJNI.otc_session_get_capabilities(SWIGTYPE_p_otc_session.a(sWIGTYPE_p_otc_session)), true);
    }

    public static int a(SWIGTYPE_p_otc_session sWIGTYPE_p_otc_session, String str, String str2) {
        return opentokJNI.otc_session_log_custom_client_event(SWIGTYPE_p_otc_session.a(sWIGTYPE_p_otc_session), str, str2);
    }

    public static int b(a aVar, int i) {
        return opentokJNI.otc_session_settings_set_ip_whitelist(a.a(aVar), i);
    }

    public static int c(a aVar, int i) {
        return opentokJNI.otc_session_settings_set_session_migration(a.a(aVar), i);
    }

    public static int d(SWIGTYPE_p_otc_session sWIGTYPE_p_otc_session, String str) {
        return opentokJNI.otc_session_set_encryption_secret(SWIGTYPE_p_otc_session.a(sWIGTYPE_p_otc_session), str);
    }

    public static int a(SWIGTYPE_p_otc_session sWIGTYPE_p_otc_session, int i) {
        return opentokJNI.otc_session_set_hybrid_session_enabled(SWIGTYPE_p_otc_session.a(sWIGTYPE_p_otc_session), i);
    }

    public static int b(SWIGTYPE_p_otc_session sWIGTYPE_p_otc_session, SWIGTYPE_p_otc_publisher sWIGTYPE_p_otc_publisher) {
        return opentokJNI.otc_session_unpublish(SWIGTYPE_p_otc_session.a(sWIGTYPE_p_otc_session), SWIGTYPE_p_otc_publisher.getCPtr(sWIGTYPE_p_otc_publisher));
    }

    public static int c(SWIGTYPE_p_otc_session sWIGTYPE_p_otc_session) {
        return opentokJNI.otc_session_disconnect(SWIGTYPE_p_otc_session.a(sWIGTYPE_p_otc_session));
    }

    public static SWIGTYPE_p_otc_stream d(SWIGTYPE_p_otc_subscriber sWIGTYPE_p_otc_subscriber) {
        long jOtc_subscriber_get_stream = opentokJNI.otc_subscriber_get_stream(SWIGTYPE_p_otc_subscriber.a(sWIGTYPE_p_otc_subscriber));
        if (jOtc_subscriber_get_stream == 0) {
            return null;
        }
        return new SWIGTYPE_p_otc_stream(jOtc_subscriber_get_stream, false);
    }

    public static String a(int i) {
        return opentokJNI.otc_get_error_message(i);
    }

    public static int b(SWIGTYPE_p_otc_session sWIGTYPE_p_otc_session, SWIGTYPE_p_otc_subscriber sWIGTYPE_p_otc_subscriber) {
        return opentokJNI.otc_session_unsubscribe(SWIGTYPE_p_otc_session.a(sWIGTYPE_p_otc_session), SWIGTYPE_p_otc_subscriber.a(sWIGTYPE_p_otc_subscriber));
    }

    public static int c(SWIGTYPE_p_otc_subscriber sWIGTYPE_p_otc_subscriber, int i) {
        return opentokJNI.otc_subscriber_set_subscribe_to_video(SWIGTYPE_p_otc_subscriber.a(sWIGTYPE_p_otc_subscriber), i);
    }

    public static otc_video_frame_format a(SWIGTYPE_p_otc_video_frame sWIGTYPE_p_otc_video_frame) {
        return otc_video_frame_format.a(opentokJNI.otc_video_frame_get_format(SWIGTYPE_p_otc_video_frame.getCPtr(sWIGTYPE_p_otc_video_frame)));
    }

    public static int b(SWIGTYPE_p_otc_session sWIGTYPE_p_otc_session, String str, String str2) {
        return opentokJNI.otc_session_send_signal(SWIGTYPE_p_otc_session.a(sWIGTYPE_p_otc_session), str, str2);
    }

    public static SWIGTYPE_p_otc_session c(SWIGTYPE_p_otc_subscriber sWIGTYPE_p_otc_subscriber) {
        long jOtc_subscriber_get_session = opentokJNI.otc_subscriber_get_session(SWIGTYPE_p_otc_subscriber.a(sWIGTYPE_p_otc_subscriber));
        if (jOtc_subscriber_get_session == 0) {
            return null;
        }
        return new SWIGTYPE_p_otc_session(jOtc_subscriber_get_session, false);
    }

    public static long d(SWIGTYPE_p_otc_stream sWIGTYPE_p_otc_stream) {
        return opentokJNI.otc_stream_get_creation_time(SWIGTYPE_p_otc_stream.getCPtr(sWIGTYPE_p_otc_stream));
    }

    public static long a(SWIGTYPE_p_otc_video_frame sWIGTYPE_p_otc_video_frame, k kVar) {
        return opentokJNI.otc_video_frame_get_plane_size(SWIGTYPE_p_otc_video_frame.getCPtr(sWIGTYPE_p_otc_video_frame), kVar.a());
    }

    public static int b(SWIGTYPE_p_otc_session sWIGTYPE_p_otc_session) {
        return opentokJNI.otc_session_disable_force_mute(SWIGTYPE_p_otc_session.a(sWIGTYPE_p_otc_session));
    }

    public static c a(SWIGTYPE_p_otc_video_frame sWIGTYPE_p_otc_video_frame, b bVar) {
        long jOtc_video_frame_get_metadata = opentokJNI.otc_video_frame_get_metadata(SWIGTYPE_p_otc_video_frame.getCPtr(sWIGTYPE_p_otc_video_frame), b.a(bVar));
        if (jOtc_video_frame_get_metadata == 0) {
            return null;
        }
        return new c(jOtc_video_frame_get_metadata, false);
    }

    public static int b(SWIGTYPE_p_otc_session sWIGTYPE_p_otc_session, String str) {
        return opentokJNI.otc_session_force_mute_stream(SWIGTYPE_p_otc_session.a(sWIGTYPE_p_otc_session), str);
    }

    public static SWIGTYPE_p_otc_connection c(SWIGTYPE_p_otc_stream sWIGTYPE_p_otc_stream) {
        long jOtc_stream_get_connection = opentokJNI.otc_stream_get_connection(SWIGTYPE_p_otc_stream.getCPtr(sWIGTYPE_p_otc_stream));
        if (jOtc_stream_get_connection == 0) {
            return null;
        }
        return new SWIGTYPE_p_otc_connection(jOtc_stream_get_connection, false);
    }

    public static int b(SWIGTYPE_p_otc_subscriber sWIGTYPE_p_otc_subscriber, int i) {
        return opentokJNI.otc_subscriber_set_subscribe_to_captions(SWIGTYPE_p_otc_subscriber.a(sWIGTYPE_p_otc_subscriber), i);
    }

    public static SWIGTYPE_p_otc_connection a(SWIGTYPE_p_otc_connection sWIGTYPE_p_otc_connection) {
        long jOtc_connection_copy = opentokJNI.otc_connection_copy(SWIGTYPE_p_otc_connection.getCPtr(sWIGTYPE_p_otc_connection));
        if (jOtc_connection_copy == 0) {
            return null;
        }
        return new SWIGTYPE_p_otc_connection(jOtc_connection_copy, false);
    }

    public static int b(SWIGTYPE_p_otc_subscriber sWIGTYPE_p_otc_subscriber) {
        return opentokJNI.otc_subscriber_get_rtc_stats_report(SWIGTYPE_p_otc_subscriber.a(sWIGTYPE_p_otc_subscriber));
    }

    public static int b(SWIGTYPE_p_otc_stream sWIGTYPE_p_otc_stream) {
        return opentokJNI.otc_stream_delete(SWIGTYPE_p_otc_stream.getCPtr(sWIGTYPE_p_otc_stream));
    }

    public static int a(SWIGTYPE_p_otc_publisher_settings sWIGTYPE_p_otc_publisher_settings) {
        return opentokJNI.otc_publisher_settings_delete(SWIGTYPE_p_otc_publisher_settings.getCPtr(sWIGTYPE_p_otc_publisher_settings));
    }

    public static int a(SWIGTYPE_p_otc_publisher_settings sWIGTYPE_p_otc_publisher_settings, String str) {
        return opentokJNI.otc_publisher_settings_set_name(SWIGTYPE_p_otc_publisher_settings.getCPtr(sWIGTYPE_p_otc_publisher_settings), str);
    }

    public static int a(SWIGTYPE_p_otc_publisher_settings sWIGTYPE_p_otc_publisher_settings, otc_video_capturer_callbacks otc_video_capturer_callbacksVar) {
        return opentokJNI.otc_publisher_settings_set_video_capturer(SWIGTYPE_p_otc_publisher_settings.getCPtr(sWIGTYPE_p_otc_publisher_settings), otc_video_capturer_callbacks.getCPtr(otc_video_capturer_callbacksVar), otc_video_capturer_callbacksVar);
    }

    public static int a(SWIGTYPE_p_otc_publisher_settings sWIGTYPE_p_otc_publisher_settings, int i) {
        return opentokJNI.otc_publisher_settings_set_allow_audio_capture_while_muted(SWIGTYPE_p_otc_publisher_settings.getCPtr(sWIGTYPE_p_otc_publisher_settings), i);
    }

    public static SWIGTYPE_p_otc_publisher a(otc_publisher_callbacks otc_publisher_callbacksVar, SWIGTYPE_p_otc_publisher_settings sWIGTYPE_p_otc_publisher_settings) {
        long jOtc_publisher_new_with_settings = opentokJNI.otc_publisher_new_with_settings(otc_publisher_callbacks.getCPtr(otc_publisher_callbacksVar), otc_publisher_callbacksVar, SWIGTYPE_p_otc_publisher_settings.getCPtr(sWIGTYPE_p_otc_publisher_settings));
        if (jOtc_publisher_new_with_settings == 0) {
            return null;
        }
        return new SWIGTYPE_p_otc_publisher(jOtc_publisher_new_with_settings, false);
    }

    public static int a(SWIGTYPE_p_otc_publisher sWIGTYPE_p_otc_publisher) {
        return opentokJNI.otc_publisher_delete(SWIGTYPE_p_otc_publisher.getCPtr(sWIGTYPE_p_otc_publisher));
    }

    public static int a(SWIGTYPE_p_otc_publisher sWIGTYPE_p_otc_publisher, long j) {
        return opentokJNI.otc_publisher_set_max_audio_bitrate(SWIGTYPE_p_otc_publisher.getCPtr(sWIGTYPE_p_otc_publisher), j);
    }

    public static int a(SWIGTYPE_p_otc_publisher sWIGTYPE_p_otc_publisher, otc_publisher_rtc_stats_report_cb otc_publisher_rtc_stats_report_cbVar) {
        return opentokJNI.otc_publisher_set_rtc_stats_report_cb(SWIGTYPE_p_otc_publisher.getCPtr(sWIGTYPE_p_otc_publisher), otc_publisher_rtc_stats_report_cb.getCPtr(otc_publisher_rtc_stats_report_cbVar), otc_publisher_rtc_stats_report_cbVar);
    }

    public static int a(SWIGTYPE_p_otc_publisher sWIGTYPE_p_otc_publisher, h hVar) {
        return opentokJNI.otc_publisher_set_video_type(SWIGTYPE_p_otc_publisher.getCPtr(sWIGTYPE_p_otc_publisher), hVar.a());
    }

    public static int a(SWIGTYPE_p_otc_publisher sWIGTYPE_p_otc_publisher, int i) {
        return opentokJNI.otc_publisher_set_max_video_bitrate(SWIGTYPE_p_otc_publisher.getCPtr(sWIGTYPE_p_otc_publisher), i);
    }

    public static int a(SWIGTYPE_p_otc_publisher sWIGTYPE_p_otc_publisher, j jVar) {
        return opentokJNI.otc_publisher_set_video_bitrate_preset(SWIGTYPE_p_otc_publisher.getCPtr(sWIGTYPE_p_otc_publisher), jVar.a());
    }

    public static int a(SWIGTYPE_p_otc_publisher sWIGTYPE_p_otc_publisher, f fVar) {
        return opentokJNI.otc_publisher_set_degradation_preference(SWIGTYPE_p_otc_publisher.getCPtr(sWIGTYPE_p_otc_publisher), fVar.a());
    }

    public static int a(a aVar, int i) {
        return opentokJNI.otc_session_settings_set_connection_events_suppressed(a.a(aVar), i);
    }

    public static int a(a aVar, String str) {
        return opentokJNI.otc_session_settings_set_proxy_url(a.a(aVar), str);
    }

    public static int a(a aVar) {
        return opentokJNI.otc_session_settings_delete(a.a(aVar));
    }

    public static SWIGTYPE_p_otc_session a(String str, String str2, otc_session_callbacks otc_session_callbacksVar, a aVar) {
        long jOtc_session_new_with_settings = opentokJNI.otc_session_new_with_settings(str, str2, otc_session_callbacks.getCPtr(otc_session_callbacksVar), otc_session_callbacksVar, a.a(aVar));
        if (jOtc_session_new_with_settings == 0) {
            return null;
        }
        return new SWIGTYPE_p_otc_session(jOtc_session_new_with_settings, false);
    }

    public static int a(SWIGTYPE_p_otc_session sWIGTYPE_p_otc_session) {
        return opentokJNI.otc_session_delete(SWIGTYPE_p_otc_session.a(sWIGTYPE_p_otc_session));
    }

    public static int a(SWIGTYPE_p_otc_session sWIGTYPE_p_otc_session, String str) {
        return opentokJNI.otc_session_connect(SWIGTYPE_p_otc_session.a(sWIGTYPE_p_otc_session), str);
    }

    public static int a(SWIGTYPE_p_otc_session sWIGTYPE_p_otc_session, SWIGTYPE_p_otc_publisher sWIGTYPE_p_otc_publisher) {
        return opentokJNI.otc_session_publish(SWIGTYPE_p_otc_session.a(sWIGTYPE_p_otc_session), SWIGTYPE_p_otc_publisher.getCPtr(sWIGTYPE_p_otc_publisher));
    }

    public static int a(SWIGTYPE_p_otc_session sWIGTYPE_p_otc_session, SWIGTYPE_p_otc_subscriber sWIGTYPE_p_otc_subscriber) {
        return opentokJNI.otc_session_subscribe(SWIGTYPE_p_otc_session.a(sWIGTYPE_p_otc_session), SWIGTYPE_p_otc_subscriber.a(sWIGTYPE_p_otc_subscriber));
    }

    public static int a(SWIGTYPE_p_otc_session sWIGTYPE_p_otc_session, String[] strArr, int i) {
        return opentokJNI.otc_session_force_mute_all(SWIGTYPE_p_otc_session.a(sWIGTYPE_p_otc_session), strArr, i);
    }

    public static int a(SWIGTYPE_p_otc_session sWIGTYPE_p_otc_session, SWIGTYPE_p_otc_connection sWIGTYPE_p_otc_connection) {
        return opentokJNI.otc_session_force_disconnect(SWIGTYPE_p_otc_session.a(sWIGTYPE_p_otc_session), SWIGTYPE_p_otc_connection.getCPtr(sWIGTYPE_p_otc_connection));
    }

    public static int a(SWIGTYPE_p_otc_session sWIGTYPE_p_otc_session, String str, String str2, SWIGTYPE_p_otc_connection sWIGTYPE_p_otc_connection) {
        return opentokJNI.otc_session_send_signal_to_connection(SWIGTYPE_p_otc_session.a(sWIGTYPE_p_otc_session), str, str2, SWIGTYPE_p_otc_connection.getCPtr(sWIGTYPE_p_otc_connection));
    }

    public static int a(SWIGTYPE_p_otc_session sWIGTYPE_p_otc_session, String str, String str2, otc_signal_options otc_signal_optionsVar) {
        return opentokJNI.otc_session_send_signal_with_options(SWIGTYPE_p_otc_session.a(sWIGTYPE_p_otc_session), str, str2, otc_signal_options.a(otc_signal_optionsVar), otc_signal_optionsVar);
    }

    public static int a(SWIGTYPE_p_otc_session sWIGTYPE_p_otc_session, String str, String str2, SWIGTYPE_p_otc_connection sWIGTYPE_p_otc_connection, otc_signal_options otc_signal_optionsVar) {
        return opentokJNI.otc_session_send_signal_to_connection_with_options(SWIGTYPE_p_otc_session.a(sWIGTYPE_p_otc_session), str, str2, SWIGTYPE_p_otc_connection.getCPtr(sWIGTYPE_p_otc_connection), otc_signal_options.a(otc_signal_optionsVar), otc_signal_optionsVar);
    }

    public static SWIGTYPE_p_otc_subscriber a(SWIGTYPE_p_otc_stream sWIGTYPE_p_otc_stream, otc_subscriber_callbacks otc_subscriber_callbacksVar) {
        long jOtc_subscriber_new = opentokJNI.otc_subscriber_new(SWIGTYPE_p_otc_stream.getCPtr(sWIGTYPE_p_otc_stream), otc_subscriber_callbacks.getCPtr(otc_subscriber_callbacksVar), otc_subscriber_callbacksVar);
        if (jOtc_subscriber_new == 0) {
            return null;
        }
        return new SWIGTYPE_p_otc_subscriber(jOtc_subscriber_new, false);
    }

    public static int a(SWIGTYPE_p_otc_subscriber sWIGTYPE_p_otc_subscriber) {
        return opentokJNI.otc_subscriber_delete(SWIGTYPE_p_otc_subscriber.a(sWIGTYPE_p_otc_subscriber));
    }

    public static int a(SWIGTYPE_p_otc_subscriber sWIGTYPE_p_otc_subscriber, int i) {
        return opentokJNI.otc_subscriber_set_subscribe_to_audio(SWIGTYPE_p_otc_subscriber.a(sWIGTYPE_p_otc_subscriber), i);
    }

    public static int a(SWIGTYPE_p_otc_subscriber sWIGTYPE_p_otc_subscriber, long j, long j2) {
        return opentokJNI.otc_subscriber_set_preferred_resolution(SWIGTYPE_p_otc_subscriber.a(sWIGTYPE_p_otc_subscriber), j, j2);
    }

    public static int a(SWIGTYPE_p_otc_subscriber sWIGTYPE_p_otc_subscriber, long[] jArr, long[] jArr2) {
        return opentokJNI.otc_subscriber_get_preferred_resolution(SWIGTYPE_p_otc_subscriber.a(sWIGTYPE_p_otc_subscriber), jArr, jArr2);
    }

    public static int a(SWIGTYPE_p_otc_subscriber sWIGTYPE_p_otc_subscriber, double d) {
        return opentokJNI.otc_subscriber_set_audio_volume(SWIGTYPE_p_otc_subscriber.a(sWIGTYPE_p_otc_subscriber), d);
    }

    public static int a(SWIGTYPE_p_otc_subscriber sWIGTYPE_p_otc_subscriber, double[] dArr) {
        return opentokJNI.otc_subscriber_get_audio_volume(SWIGTYPE_p_otc_subscriber.a(sWIGTYPE_p_otc_subscriber), dArr);
    }

    public static int a(SWIGTYPE_p_otc_subscriber sWIGTYPE_p_otc_subscriber, float f) {
        return opentokJNI.otc_subscriber_set_preferred_framerate(SWIGTYPE_p_otc_subscriber.a(sWIGTYPE_p_otc_subscriber), f);
    }

    public static int a(SWIGTYPE_p_otc_subscriber sWIGTYPE_p_otc_subscriber, float[] fArr) {
        return opentokJNI.otc_subscriber_get_preferred_framerate(SWIGTYPE_p_otc_subscriber.a(sWIGTYPE_p_otc_subscriber), fArr);
    }

    public static int a(SWIGTYPE_p_otc_subscriber sWIGTYPE_p_otc_subscriber, otc_subscriber_rtc_stats_report_cb otc_subscriber_rtc_stats_report_cbVar) {
        return opentokJNI.otc_subscriber_set_rtc_stats_report_cb(SWIGTYPE_p_otc_subscriber.a(sWIGTYPE_p_otc_subscriber), otc_subscriber_rtc_stats_report_cb.getCPtr(otc_subscriber_rtc_stats_report_cbVar), otc_subscriber_rtc_stats_report_cbVar);
    }

    public static SWIGTYPE_p_otc_stream a(SWIGTYPE_p_otc_stream sWIGTYPE_p_otc_stream) {
        long jOtc_stream_copy = opentokJNI.otc_stream_copy(SWIGTYPE_p_otc_stream.getCPtr(sWIGTYPE_p_otc_stream));
        if (jOtc_stream_copy == 0) {
            return null;
        }
        return new SWIGTYPE_p_otc_stream(jOtc_stream_copy, false);
    }

    public static void a(SWIGTYPE_p_otc_publisher sWIGTYPE_p_otc_publisher, i iVar) {
        opentokJNI.otc_publisher_set_simulcast_level(SWIGTYPE_p_otc_publisher.getCPtr(sWIGTYPE_p_otc_publisher), iVar.a());
    }
}
