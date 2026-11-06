package com.opentok.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.adjust.sdk.Constants;
import com.opentok.otc.SWIGTYPE_p_otc_session;
import com.opentok.otc.a;
import com.opentok.otc.d;
import com.opentok.otc.e;
import com.opentok.otc.g;
import com.opentok.otc.otc_on_mute_forced_info;
import com.opentok.otc.otc_session_callbacks;
import com.opentok.otc.otc_session_capabilities;
import com.opentok.otc.otc_signal_options;
import com.opentok.otc.otc_stream_video_type;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Observable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class Session extends Observable {
    private static final String ANDROID_SDK_PACKAGE_NAME = "com.opentok.android";
    private static final int AUDIO_TYPE = 1;
    private static final String PERMISSION_DEFAULT_PREFIX = "android.permission.";
    private static final int VIDEO_TYPE = 0;
    protected String apiKey;
    protected URL apiUrl;
    protected ArchiveListener archiveListener;
    protected ConnectionListener connectionListener;
    protected Context context;
    private Handler handler;
    private final OtLog.LogToken log;
    protected MuteListener muteListener;
    private SWIGTYPE_p_otc_session otc_session;
    boolean paused;
    protected ReconnectionListener reconnectionListener;
    protected String sessionId;
    protected SessionListener sessionListener;
    private swig_otc_session_cb session_cb;
    private boolean shouldDestroyOnFinalize;
    protected SignalListener signalListener;
    protected StreamCaptionsPropertiesListener streamCaptionsPropertiesListener;
    protected StreamPropertiesListener streamPropertiesListener;

    public interface ArchiveListener {
        void onArchiveStarted(Session session, String str, String str2);

        void onArchiveStopped(Session session, String str);
    }

    public static class Builder {
        String apiKey;
        URL apiUrl;
        Context context;
        String proxyUrl;
        String sessionId;
        boolean singlePeerConnection;
        boolean connectionEventsSuppressed = false;
        SessionOptions sessionOptions = new SessionOptions() { // from class: com.opentok.android.Session.Builder.1
        };
        TransportPolicy turnRouting = TransportPolicy.All;
        IceServer[] iceServers = new IceServer[0];
        IncludeServers turnServerConfig = IncludeServers.All;
        boolean ipWhitelist = false;
        boolean sessionMigration = false;

        public static class IceServer {
            public String credential;
            public String url;
            public String user;

            public IceServer(String str, String str2, String str3) {
                this.url = str;
                this.user = str2;
                this.credential = str3;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof IceServer)) {
                    return false;
                }
                IceServer iceServer = (IceServer) obj;
                return this.url.equals(iceServer.url) && this.user.equals(iceServer.user) && this.credential.equals(iceServer.credential);
            }

            public String toString() {
                return "[url: " + this.url + ", user: " + this.user + ", credential: " + this.credential + "]";
            }
        }

        public enum IncludeServers {
            All(0),
            Custom(1);

            final int val;

            IncludeServers(int i) {
                this.val = i;
            }
        }

        public enum TransportPolicy {
            All(0),
            Relay(1);

            final int val;

            TransportPolicy(int i) {
                this.val = i;
            }
        }

        public Builder(Context context, String str, String str2) {
            this.context = context;
            this.apiKey = str;
            this.sessionId = str2;
        }

        public Session build() {
            try {
                return new Session(this);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public Builder connectionEventsSuppressed(Boolean bool) {
            this.connectionEventsSuppressed = bool.booleanValue();
            return this;
        }

        public Builder sessionOptions(SessionOptions sessionOptions) {
            this.sessionOptions = sessionOptions;
            return this;
        }

        @Deprecated
        public Builder setApiUrl(URL url) {
            this.apiUrl = url;
            return this;
        }

        public Builder setCustomIceServers(List<IceServer> list, IncludeServers includeServers) {
            this.iceServers = (IceServer[]) list.toArray(new IceServer[list.size()]);
            this.turnServerConfig = includeServers;
            return this;
        }

        public Builder setIceRouting(TransportPolicy transportPolicy) {
            this.turnRouting = transportPolicy;
            return this;
        }

        public Builder setIpWhitelist(boolean z) {
            this.ipWhitelist = z;
            return this;
        }

        public Builder setProxyUrl(String str) {
            this.proxyUrl = str;
            return this;
        }

        public Builder setSessionMigration(boolean z) {
            this.sessionMigration = z;
            return this;
        }

        public Builder setSinglePeerConnection(boolean z) {
            this.singlePeerConnection = z;
            return this;
        }
    }

    public static class Capabilities {
        public boolean canForceDisconnect;
        public boolean canForceMute;
        public boolean canPublish;
        public boolean canSubscribe;
        private final OtLog.LogToken log = new OtLog.LogToken(this);

        public String toString() {
            StringBuilder sb = new StringBuilder("[\n");
            for (Field field : getClass().getFields()) {
                try {
                    sb.append(String.format("\t%s = %b\n", field.getName(), field.get(this)));
                } catch (IllegalAccessException unused) {
                    this.log.e("Error converting Capabilities to String", new Object[0]);
                }
            }
            sb.append(']');
            return sb.toString();
        }
    }

    protected static class ConfigurableSessionOptions extends SessionOptions {
        private final boolean hwDecCapable;

        ConfigurableSessionOptions(boolean z) {
            this.hwDecCapable = z;
        }

        @Override // com.opentok.android.Session.SessionOptions
        public boolean isHwDecodingSupported() {
            return this.hwDecCapable;
        }
    }

    public interface ConnectionListener {
        void onConnectionCreated(Session session, Connection connection);

        void onConnectionDestroyed(Session session, Connection connection);
    }

    public interface MuteListener {
        void onMuteForced(Session session, MuteForcedInfo muteForcedInfo);
    }

    public interface ReconnectionListener {
        void onReconnected(Session session);

        void onReconnecting(Session session);
    }

    public interface SessionListener {
        void onConnected(Session session);

        void onDisconnected(Session session);

        void onError(Session session, OpentokError opentokError);

        void onStreamDropped(Session session, Stream stream);

        void onStreamReceived(Session session, Stream stream);
    }

    public static abstract class SessionOptions {
        @Deprecated
        public boolean isCamera2Capable() {
            return true;
        }

        @Deprecated
        public boolean isHwDecodingSupported() {
            return false;
        }

        public boolean useTextureViews() {
            return false;
        }
    }

    @Deprecated
    public interface SessionOptionsProvider {
        @Deprecated
        boolean isHwDecodingSupported();
    }

    static class SessionPauseResumeEvent {
        boolean mIsSessionPaused;

        SessionPauseResumeEvent(boolean z) {
            this.mIsSessionPaused = z;
        }

        boolean isSessionPaused() {
            return this.mIsSessionPaused;
        }
    }

    public interface SignalListener {
        void onSignalReceived(Session session, String str, String str2, Connection connection);
    }

    public interface StreamCaptionsPropertiesListener {
        void onStreamHasCaptionsChanged(Session session, Stream stream, boolean z);
    }

    public interface StreamPropertiesListener {
        void onStreamHasAudioChanged(Session session, Stream stream, boolean z);

        void onStreamHasVideoChanged(Session session, Stream stream, boolean z);

        void onStreamVideoDimensionsChanged(Session session, Stream stream, int i, int i2);

        void onStreamVideoTypeChanged(Session session, Stream stream, Stream.StreamVideoType streamVideoType);
    }

    static class swig_on_mute_forced_info extends otc_on_mute_forced_info {
        public swig_on_mute_forced_info(long j) {
            super(j, false);
        }

        public long getCPointer() {
            return otc_on_mute_forced_info.getCPtr(this);
        }
    }

    static class swig_otc_session_cb extends otc_session_callbacks {
        public swig_otc_session_cb(long j) {
            super(j, false);
        }

        public long getCPointer() {
            return otc_session_callbacks.getCPtr(this);
        }
    }

    static {
        Loader.load();
    }

    protected Session(Builder builder) throws Exception {
        this.shouldDestroyOnFinalize = true;
        this.paused = false;
        this.log = new OtLog.LogToken(this);
        if (AudioDeviceManager.getAudioDevice() == null) {
            DefaultAudioDevice defaultAudioDevice = new DefaultAudioDevice(builder.context.getApplicationContext());
            defaultAudioDevice.setAudioBus(new BaseAudioDevice.AudioBus(defaultAudioDevice));
            AudioDeviceManager.setAudioDevice(defaultAudioDevice);
        }
        Utils.initOtcEngine(builder.context, AudioDeviceManager.getAudioDevice(), OpenTokConfig.getJNILogs(), OpenTokConfig.getOTKitLogs(), OpenTokConfig.getWebRTCLogs(), OpenTokConfig.getDumpClientLoggingToFile());
        if (OpenTokConfig.getPreferH264Codec() != OpenTokConfig.PreferH264.NOT_SET) {
            set_prefer_h264(OpenTokConfig.getPreferH264Codec() == OpenTokConfig.PreferH264.ENABLE);
        }
        a aVarD = d.d();
        d.a(aVarD, builder.proxyUrl);
        d.a(aVarD, builder.connectionEventsSuppressed ? 1 : 0);
        d.b(aVarD, builder.ipWhitelist ? 1 : 0);
        d.d(aVarD, builder.singlePeerConnection ? 1 : 0);
        d.c(aVarD, builder.sessionMigration ? 1 : 0);
        Builder.IceServer[] iceServerArr = builder.iceServers;
        String[] strArr = new String[iceServerArr.length];
        String[] strArr2 = new String[iceServerArr.length];
        String[] strArr3 = new String[iceServerArr.length];
        int i = 0;
        for (Builder.IceServer iceServer : iceServerArr) {
            this.log.d("Using custom ICE server " + iceServer.toString(), new Object[0]);
            strArr[i] = iceServer.url;
            strArr2[i] = iceServer.user;
            strArr3[i] = iceServer.credential;
            i++;
        }
        int iA = d.a(aVarD, builder.iceServers.length, strArr, strArr2, strArr3, builder.turnRouting.val, builder.turnServerConfig.val, 0);
        if (iA != e.c.a()) {
            throwError(new OpentokError(OpentokError.Domain.SessionErrorDomain, iA, "Invalid ICE Settings"));
            throw new Exception("Invalid ICE Settings");
        }
        swig_otc_session_cb swig_otc_session_cbVar = new swig_otc_session_cb(build_native_session_cb());
        this.session_cb = swig_otc_session_cbVar;
        this.otc_session = d.a(builder.apiKey, builder.sessionId, swig_otc_session_cbVar, aVarD);
        d.a(aVarD);
        this.handler = new Handler(Looper.myLooper());
        VideoRenderFactory.useTextureViews(builder.sessionOptions.useTextureViews());
        this.context = builder.context;
        this.apiKey = builder.apiKey;
        this.sessionId = builder.sessionId;
        this.apiUrl = builder.apiUrl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onArchiveStartedJNI$1(String str, String str2) {
        ArchiveListener archiveListener = this.archiveListener;
        if (archiveListener != null) {
            archiveListener.onArchiveStarted(this, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onArchiveStoppedJNI$3(String str) {
        ArchiveListener archiveListener = this.archiveListener;
        if (archiveListener != null) {
            archiveListener.onArchiveStopped(this, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onConnectedJNI$24() {
        PackageInfo packageInfo;
        JSONObject jSONObject;
        int i = 0;
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            jSONObject2.put("encoders", jSONArray);
            jSONObject2.put("decoders", jSONArray2);
            MediaCodecInfo[] codecInfos = new MediaCodecList(0).getCodecInfos();
            int length = codecInfos.length;
            int i2 = 0;
            while (i2 < length) {
                MediaCodecInfo mediaCodecInfo = codecInfos[i2];
                if (mediaCodecInfo == null || !mediaCodecInfo.isEncoder()) {
                    jSONObject = jSONObject2;
                    if (mediaCodecInfo != null) {
                        for (String str : mediaCodecInfo.getSupportedTypes()) {
                            if (str.equals("video/avc")) {
                                MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put("codec", mediaCodecInfo.getName());
                                jSONObject3.put("color_format", Arrays.toString(capabilitiesForType.colorFormats));
                                jSONArray2.put(jSONObject3);
                            }
                        }
                    }
                } else {
                    String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                    int length2 = supportedTypes.length;
                    int i3 = i;
                    while (i3 < length2) {
                        String str2 = supportedTypes[i3];
                        if (str2.equals("video/avc")) {
                            MediaCodecInfo.CodecCapabilities capabilitiesForType2 = mediaCodecInfo.getCapabilitiesForType(str2);
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("codec", mediaCodecInfo.getName());
                            jSONObject4.put("color_format", Arrays.toString(capabilitiesForType2.colorFormats));
                            jSONArray.put(jSONObject4);
                        }
                        i3++;
                        jSONObject2 = jSONObject2;
                    }
                    jSONObject = jSONObject2;
                }
                i2++;
                jSONObject2 = jSONObject;
                i = 0;
            }
            JSONObject jSONObject5 = jSONObject2;
            this.log.i("Log custom client event: \"codec-avail\" " + jSONObject5.toString(), new Object[0]);
            d.a(this.otc_session, "codec-avail", jSONObject5.toString());
        } catch (Exception e) {
            this.log.w("Failed to analyze codec list: " + e.getMessage(), new Object[0]);
            e.printStackTrace();
        }
        try {
            try {
                packageInfo = this.context.getPackageManager().getPackageInfo("com.opentok.android", 4096);
            } catch (Exception unused) {
                this.log.w("com.opentok.android not found probably because android SDK was added as a direct project dependency. Using current context package instead", new Object[0]);
                packageInfo = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 4096);
            }
            if (packageInfo != null) {
                String[] strArr = packageInfo.requestedPermissions;
                ArrayList arrayList = new ArrayList();
                for (String strSubstring : strArr) {
                    if (this.context.checkCallingOrSelfPermission(strSubstring) >= 0) {
                        this.log.i("Permission granted: " + strSubstring, new Object[0]);
                    } else {
                        this.log.w("Missing permission: " + strSubstring, new Object[0]);
                        if (strSubstring.startsWith(PERMISSION_DEFAULT_PREFIX)) {
                            strSubstring = strSubstring.substring(19);
                        }
                        arrayList.add(strSubstring);
                    }
                }
                if (arrayList.size() > 0) {
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("perm", new JSONArray((Collection) arrayList));
                    d.a(this.otc_session, "missing-permissions", jSONObject6.toString());
                }
            }
        } catch (Exception e2) {
            this.log.e("Error checking permissions", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onConnectedJNI$26() {
        SessionListener sessionListener = this.sessionListener;
        if (sessionListener != null) {
            sessionListener.onConnected(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onConnectionCreatedJNI$15(Connection connection) {
        ConnectionListener connectionListener = this.connectionListener;
        if (connectionListener != null) {
            connectionListener.onConnectionCreated(this, connection);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onConnectionDroppedJNI$17(Connection connection) {
        ConnectionListener connectionListener = this.connectionListener;
        if (connectionListener != null) {
            connectionListener.onConnectionDestroyed(this, connection);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onDisconnectedJNI$28() {
        SessionListener sessionListener = this.sessionListener;
        if (sessionListener != null) {
            sessionListener.onDisconnected(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onErrorJNI$36(OpentokError opentokError) {
        SessionListener sessionListener = this.sessionListener;
        if (sessionListener != null) {
            sessionListener.onError(this, opentokError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMuteForcedJNI$38(MuteForcedInfo muteForcedInfo) {
        MuteListener muteListener = this.muteListener;
        if (muteListener != null) {
            muteListener.onMuteForced(this, muteForcedInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onReconnectedJNI$23() {
        ReconnectionListener reconnectionListener = this.reconnectionListener;
        if (reconnectionListener != null) {
            reconnectionListener.onReconnected(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onReconnectingJNI$21() {
        ReconnectionListener reconnectionListener = this.reconnectionListener;
        if (reconnectionListener != null) {
            reconnectionListener.onReconnecting(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSignalReceivedJNI$19(String str, String str2, Connection connection) {
        SignalListener signalListener = this.signalListener;
        if (signalListener != null) {
            signalListener.onSignalReceived(this, str, str2, connection);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStreamDroppedJNI$34(Stream stream) {
        SessionListener sessionListener = this.sessionListener;
        if (sessionListener != null) {
            sessionListener.onStreamDropped(this, stream);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStreamHasAudioChangedJNI$5(Stream stream, int i) {
        StreamPropertiesListener streamPropertiesListener = this.streamPropertiesListener;
        if (streamPropertiesListener != null) {
            streamPropertiesListener.onStreamHasAudioChanged(this, stream, Utils.intToBoolean(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStreamHasCaptionsChangedJNI$7(Stream stream, int i) {
        StreamCaptionsPropertiesListener streamCaptionsPropertiesListener = this.streamCaptionsPropertiesListener;
        if (streamCaptionsPropertiesListener != null) {
            streamCaptionsPropertiesListener.onStreamHasCaptionsChanged(this, stream, Utils.intToBoolean(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStreamHasVideoChangedJNI$9(Stream stream, int i) {
        StreamPropertiesListener streamPropertiesListener = this.streamPropertiesListener;
        if (streamPropertiesListener != null) {
            streamPropertiesListener.onStreamHasVideoChanged(this, stream, Utils.intToBoolean(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStreamReceivedJNI$31(Stream stream) {
        SessionListener sessionListener = this.sessionListener;
        if (sessionListener != null) {
            sessionListener.onStreamReceived(this, stream);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStreamReceivedJNI$32(Stream stream) {
        SessionListener sessionListener = this.sessionListener;
        if (sessionListener != null) {
            sessionListener.onStreamReceived(this, stream);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStreamVideoDimensionsChangedJNI$11(Stream stream, int i, int i2) {
        StreamPropertiesListener streamPropertiesListener = this.streamPropertiesListener;
        if (streamPropertiesListener != null) {
            streamPropertiesListener.onStreamVideoDimensionsChanged(this, stream, i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStreamVideoTypeChangedJNI$13(Stream stream, int i) {
        StreamPropertiesListener streamPropertiesListener = this.streamPropertiesListener;
        if (streamPropertiesListener != null) {
            streamPropertiesListener.onStreamVideoTypeChanged(this, stream, Stream.StreamVideoType.fromSwig(otc_stream_video_type.a(i)));
        }
    }

    native long build_native_session_cb();

    public void connect(String str) {
        int iA;
        this.log.d("Connect(...) called", new Object[0]);
        if (Build.VERSION.SDK_INT >= 35 && !PermissionsUtils.isBatteryOptimizationIgnored(this.context)) {
            PermissionsUtils.requestBatteryOptimizationIntent(this.context);
        }
        String str2 = this.apiKey;
        if (str2 == null || str2.isEmpty()) {
            throwError(new com.opentok.impl.a(OpentokError.Domain.SessionErrorDomain, OpentokError.ErrorCode.AuthorizationFailure.getErrorCode()));
            return;
        }
        String str3 = this.sessionId;
        if (str3 == null || str3.isEmpty()) {
            throwError(new com.opentok.impl.a(OpentokError.Domain.SessionErrorDomain, OpentokError.ErrorCode.InvalidSessionId.getErrorCode()));
            return;
        }
        URL url = this.apiUrl;
        if (url == null) {
            iA = d.a(this.otc_session, str);
        } else {
            iA = d.a(this.otc_session, url.getHost(), this.apiUrl.getPath(), this.apiUrl.getPort() == -1 ? this.apiUrl.getDefaultPort() : this.apiUrl.getPort(), Utils.booleanToInt(this.apiUrl.getProtocol().equals(Constants.SCHEME)), str);
        }
        if (iA != e.c.a()) {
            throwError(new com.opentok.impl.a(OpentokError.Domain.SessionErrorDomain, iA));
        } else {
            if (AudioDeviceManager.getAudioDevice() instanceof DefaultAudioDevice) {
                return;
            }
            reportExternalDeviceUsage(1);
        }
    }

    native void destroy_native_session_cb(long j);

    public void disableForceMute() {
        int iB = d.b(this.otc_session);
        if (iB == e.c.a()) {
            return;
        }
        throwError(new com.opentok.impl.a(OpentokError.Domain.SessionErrorDomain, iB));
    }

    public void disconnect() {
        this.log.d("Disconnect(...) called", new Object[0]);
        int iC = d.c(this.otc_session);
        if (iC == e.c.a()) {
            deleteObservers();
        } else {
            throwError(new com.opentok.impl.a(OpentokError.Domain.SessionErrorDomain, iC));
        }
    }

    protected void finalize() throws Throwable {
        this.log.d("finalize()", new Object[0]);
        SWIGTYPE_p_otc_session sWIGTYPE_p_otc_session = this.otc_session;
        if (sWIGTYPE_p_otc_session != null && this.shouldDestroyOnFinalize) {
            d.a(sWIGTYPE_p_otc_session);
            this.otc_session = null;
            swig_otc_session_cb swig_otc_session_cbVar = this.session_cb;
            if (swig_otc_session_cbVar != null) {
                destroy_native_session_cb(swig_otc_session_cbVar.getCPointer());
            }
        }
        super.finalize();
    }

    public void forceDisconnect(Connection connection) {
        int iA = d.a(this.otc_session, connection.getOtcConnection());
        if (iA != e.c.a()) {
            throwError(new com.opentok.impl.a(OpentokError.Domain.SessionErrorDomain, iA));
        }
    }

    public void forceMuteAll(Iterable<Stream> iterable) {
        ArrayList arrayList = new ArrayList();
        if (iterable != null) {
            Iterator<Stream> it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getStreamId());
            }
        }
        int iA = d.a(this.otc_session, (String[]) Arrays.copyOf(arrayList.toArray(), arrayList.size(), String[].class), arrayList.size());
        if (iA == e.c.a()) {
            return;
        }
        throwError(new com.opentok.impl.a(OpentokError.Domain.SessionErrorDomain, iA));
    }

    public void forceMuteStream(Stream stream) {
        if (stream == null) {
            throwError(new com.opentok.impl.a(OpentokError.Domain.SessionErrorDomain, OpentokError.ErrorCode.SessionNullOrInvalidParameter.getErrorCode()));
            return;
        }
        this.log.d("forceMuteStream() called with streamID = " + stream.getStreamId(), new Object[0]);
        int iB = d.b(this.otc_session, stream.getStreamId());
        if (iB != e.c.a()) {
            throwError(new com.opentok.impl.a(OpentokError.Domain.SessionErrorDomain, iB));
        }
    }

    public Capabilities getCapabilities() {
        otc_session_capabilities otc_session_capabilitiesVarD = d.d(this.otc_session);
        Capabilities capabilities = new Capabilities();
        capabilities.canPublish = Utils.intToBoolean(otc_session_capabilitiesVarD.d());
        capabilities.canSubscribe = Utils.intToBoolean(otc_session_capabilitiesVarD.e());
        capabilities.canForceMute = Utils.intToBoolean(otc_session_capabilitiesVarD.c());
        capabilities.canForceDisconnect = Utils.intToBoolean(otc_session_capabilitiesVarD.b());
        return capabilities;
    }

    public Connection getConnection() {
        return new Connection(d.e(this.otc_session), true);
    }

    Builder.IceServer[] getIceServers() {
        int[] iArr = new int[1];
        if (d.b(this.otc_session, iArr) != e.c.a()) {
            return new Builder.IceServer[0];
        }
        if (iArr[0] == 0) {
            return new Builder.IceServer[0];
        }
        String[] strArrC = d.c(this.otc_session, iArr);
        String[] strArrD = d.d(this.otc_session, iArr);
        String[] strArrA = d.a(this.otc_session, iArr);
        Builder.IceServer[] iceServerArr = new Builder.IceServer[iArr[0]];
        for (int i = 0; i < iArr[0]; i++) {
            iceServerArr[i] = new Builder.IceServer(strArrC[i], strArrD[i], strArrA[i]);
        }
        return iceServerArr;
    }

    public String getSessionId() {
        return d.f(this.otc_session);
    }

    boolean isSessionConnected() {
        return d.e(this.otc_session) != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: onArchiveStarted, reason: merged with bridge method [inline-methods] */
    public void lambda$onArchiveStartedJNI$0(String str, String str2) {
    }

    void onArchiveStartedJNI(final String str, final String str2) {
        this.handler.post(new Runnable() { // from class: com.opentok.android.Session$$ExternalSyntheticLambda29
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onArchiveStartedJNI$0(str, str2);
            }
        });
        if (this.archiveListener != null) {
            this.handler.post(new Runnable() { // from class: com.opentok.android.Session$$ExternalSyntheticLambda30
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onArchiveStartedJNI$1(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: onArchiveStopped, reason: merged with bridge method [inline-methods] */
    public void lambda$onArchiveStoppedJNI$2(String str) {
    }

    void onArchiveStoppedJNI(final String str) {
        this.handler.post(new Runnable() { // from class: com.opentok.android.Session$$ExternalSyntheticLambda21
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onArchiveStoppedJNI$2(str);
            }
        });
        if (this.archiveListener != null) {
            this.handler.post(new Runnable() { // from class: com.opentok.android.Session$$ExternalSyntheticLambda22
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onArchiveStoppedJNI$3(str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: onConnected, reason: merged with bridge method [inline-methods] */
    public void lambda$onConnectedJNI$25() {
    }

    void onConnectedJNI() {
        this.handler.post(new Runnable() { // from class: com.opentok.android.Session$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onConnectedJNI$24();
            }
        });
        this.handler.post(new Runnable() { // from class: com.opentok.android.Session$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onConnectedJNI$25();
            }
        });
        if (this.sessionListener != null) {
            this.handler.post(new Runnable() { // from class: com.opentok.android.Session$$ExternalSyntheticLambda16
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onConnectedJNI$26();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: onConnectionCreated, reason: merged with bridge method [inline-methods] */
    public void lambda$onConnectionCreatedJNI$14(Connection connection) {
    }

    void onConnectionCreatedJNI(long j) {
        final Connection connection = new Connection(j, true);
        this.handler.post(new Runnable() { // from class: com.opentok.android.Session$$ExternalSyntheticLambda27
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onConnectionCreatedJNI$14(connection);
            }
        });
        if (this.connectionListener != null) {
            this.handler.post(new Runnable() { // from class: com.opentok.android.Session$$ExternalSyntheticLambda28
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onConnectionCreatedJNI$15(connection);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: onConnectionDestroyed, reason: merged with bridge method [inline-methods] */
    public void lambda$onConnectionDroppedJNI$16(Connection connection) {
    }

    void onConnectionDroppedJNI(long j) {
        final Connection connection = new Connection(j, true);
        this.handler.post(new Runnable() { // from class: com.opentok.android.Session$$ExternalSyntheticLambda37
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onConnectionDroppedJNI$16(connection);
            }
        });
        if (this.connectionListener != null) {
            this.handler.post(new Runnable() { // from class: com.opentok.android.Session$$ExternalSyntheticLambda38
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onConnectionDroppedJNI$17(connection);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: onDisconnected, reason: merged with bridge method [inline-methods] */
    public void lambda$onDisconnectedJNI$27() {
    }

    void onDisconnectedJNI() {
        this.handler.post(new Runnable() { // from class: com.opentok.android.Session$$ExternalSyntheticLambda31
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onDisconnectedJNI$27();
            }
        });
        if (this.sessionListener != null) {
            this.handler.post(new Runnable() { // from class: com.opentok.android.Session$$ExternalSyntheticLambda32
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onDisconnectedJNI$28();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: onError, reason: merged with bridge method [inline-methods] */
    public void lambda$onErrorJNI$35(OpentokError opentokError) {
    }

    void onErrorJNI(String str, int i) {
        final OpentokError opentokError = new OpentokError(OpentokError.Domain.SessionErrorDomain, i, str);
        this.handler.post(new Runnable() { // from class: com.opentok.android.Session$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onErrorJNI$35(opentokError);
            }
        });
        if (this.sessionListener != null) {
            this.handler.post(new Runnable() { // from class: com.opentok.android.Session$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onErrorJNI$36(opentokError);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: onMuteForced, reason: merged with bridge method [inline-methods] */
    public void lambda$onMuteForcedJNI$37(MuteForcedInfo muteForcedInfo) {
    }

    void onMuteForcedJNI(long j) {
        this.log.d("onMuteForcedJNI(long) called", new Object[0]);
        final MuteForcedInfo muteForcedInfo = new MuteForcedInfo(new swig_on_mute_forced_info(j).getActive() == 1);
        this.handler.post(new Runnable() { // from class: com.opentok.android.Session$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onMuteForcedJNI$37(muteForcedInfo);
            }
        });
        if (this.muteListener != null) {
            this.handler.post(new Runnable() { // from class: com.opentok.android.Session$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onMuteForcedJNI$38(muteForcedInfo);
                }
            });
        }
    }

    public void onPause() {
        this.paused = true;
        this.log.d("onPause() called", new Object[0]);
        BaseAudioDevice audioDevice = AudioDeviceManager.getAudioDevice();
        if (audioDevice != null) {
            audioDevice.onPause();
        }
        setChanged();
        notifyObservers(new SessionPauseResumeEvent(true));
        clearChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: onReconnected, reason: merged with bridge method [inline-methods] */
    public void lambda$onReconnectedJNI$22() {
    }

    void onReconnectedJNI() {
        this.handler.post(new Runnable() { // from class: com.opentok.android.Session$$ExternalSyntheticLambda33
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onReconnectedJNI$22();
            }
        });
        if (this.reconnectionListener != null) {
            this.handler.post(new Runnable() { // from class: com.opentok.android.Session$$ExternalSyntheticLambda34
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onReconnectedJNI$23();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: onReconnecting, reason: merged with bridge method [inline-methods] */
    public void lambda$onReconnectingJNI$20() {
    }

    void onReconnectingJNI() {
        this.handler.post(new Runnable() { // from class: com.opentok.android.Session$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onReconnectingJNI$20();
            }
        });
        if (this.reconnectionListener != null) {
            this.handler.post(new Runnable() { // from class: com.opentok.android.Session$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onReconnectingJNI$21();
                }
            });
        }
    }

    public void onResume() {
        this.paused = false;
        this.log.d("onResume() called", new Object[0]);
        BaseAudioDevice audioDevice = AudioDeviceManager.getAudioDevice();
        if (audioDevice != null) {
            audioDevice.onResume();
        }
        setChanged();
        notifyObservers(new SessionPauseResumeEvent(false));
        clearChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: onSignalReceived, reason: merged with bridge method [inline-methods] */
    public void lambda$onSignalReceivedJNI$18(String str, String str2, Connection connection) {
    }

    void onSignalReceivedJNI(final String str, final String str2, long j) {
        final Connection connection = new Connection(j, true);
        this.handler.post(new Runnable() { // from class: com.opentok.android.Session$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onSignalReceivedJNI$18(str, str2, connection);
            }
        });
        if (this.signalListener != null) {
            this.handler.post(new Runnable() { // from class: com.opentok.android.Session$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onSignalReceivedJNI$19(str, str2, connection);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: onStreamDropped, reason: merged with bridge method [inline-methods] */
    public void lambda$onStreamDroppedJNI$33(Stream stream) {
    }

    void onStreamDroppedJNI(long j) {
        final Stream stream = new Stream(j, true);
        this.handler.post(new Runnable() { // from class: com.opentok.android.Session$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onStreamDroppedJNI$33(stream);
            }
        });
        if (this.sessionListener != null) {
            this.handler.post(new Runnable() { // from class: com.opentok.android.Session$$ExternalSyntheticLambda13
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onStreamDroppedJNI$34(stream);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: onStreamHasAudioChanged, reason: merged with bridge method [inline-methods] */
    public void lambda$onStreamHasAudioChangedJNI$4(Stream stream, int i) {
    }

    void onStreamHasAudioChangedJNI(long j, final int i) {
        final Stream stream = new Stream(j, true);
        this.handler.post(new Runnable() { // from class: com.opentok.android.Session$$ExternalSyntheticLambda35
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onStreamHasAudioChangedJNI$4(stream, i);
            }
        });
        if (this.streamPropertiesListener != null) {
            this.handler.post(new Runnable() { // from class: com.opentok.android.Session$$ExternalSyntheticLambda36
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onStreamHasAudioChangedJNI$5(stream, i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: onStreamHasCaptionsChanged, reason: merged with bridge method [inline-methods] */
    public void lambda$onStreamHasCaptionsChangedJNI$6(Stream stream, int i) {
    }

    void onStreamHasCaptionsChangedJNI(long j, final int i) {
        final Stream stream = new Stream(j, true);
        this.handler.post(new Runnable() { // from class: com.opentok.android.Session$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onStreamHasCaptionsChangedJNI$6(stream, i);
            }
        });
        if (this.streamCaptionsPropertiesListener != null) {
            this.handler.post(new Runnable() { // from class: com.opentok.android.Session$$ExternalSyntheticLambda18
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onStreamHasCaptionsChangedJNI$7(stream, i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: onStreamHasVideoChanged, reason: merged with bridge method [inline-methods] */
    public void lambda$onStreamHasVideoChangedJNI$8(Stream stream, int i) {
    }

    void onStreamHasVideoChangedJNI(long j, final int i) {
        final Stream stream = new Stream(j, true);
        this.handler.post(new Runnable() { // from class: com.opentok.android.Session$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onStreamHasVideoChangedJNI$8(stream, i);
            }
        });
        if (this.streamPropertiesListener != null) {
            this.handler.post(new Runnable() { // from class: com.opentok.android.Session$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onStreamHasVideoChangedJNI$9(stream, i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: onStreamReceived, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void lambda$onStreamReceivedJNI$30(Stream stream) {
    }

    void onStreamReceivedJNI(long j) {
        final Stream stream = new Stream(j, true);
        String lowerCase = Build.MANUFACTURER.toLowerCase(Locale.ROOT);
        if (lowerCase.equals("huawei")) {
            this.handler.postDelayed(new Runnable() { // from class: com.opentok.android.Session$$ExternalSyntheticLambda23
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onStreamReceivedJNI$29(stream);
                }
            }, 1000);
        } else {
            this.handler.post(new Runnable() { // from class: com.opentok.android.Session$$ExternalSyntheticLambda24
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onStreamReceivedJNI$30(stream);
                }
            });
        }
        if (this.sessionListener != null) {
            if (lowerCase.equals("huawei")) {
                this.handler.postDelayed(new Runnable() { // from class: com.opentok.android.Session$$ExternalSyntheticLambda25
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onStreamReceivedJNI$31(stream);
                    }
                }, 1000);
            } else {
                this.handler.post(new Runnable() { // from class: com.opentok.android.Session$$ExternalSyntheticLambda26
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onStreamReceivedJNI$32(stream);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: onStreamVideoDimensionsChanged, reason: merged with bridge method [inline-methods] */
    public void lambda$onStreamVideoDimensionsChangedJNI$10(Stream stream, int i, int i2) {
    }

    void onStreamVideoDimensionsChangedJNI(long j, final int i, final int i2) {
        final Stream stream = new Stream(j, true);
        this.handler.post(new Runnable() { // from class: com.opentok.android.Session$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onStreamVideoDimensionsChangedJNI$10(stream, i, i2);
            }
        });
        if (this.streamPropertiesListener != null) {
            this.handler.post(new Runnable() { // from class: com.opentok.android.Session$$ExternalSyntheticLambda20
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onStreamVideoDimensionsChangedJNI$11(stream, i, i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: onStreamVideoTypeChanged, reason: merged with bridge method [inline-methods] */
    public void lambda$onStreamVideoTypeChangedJNI$12(Stream stream, int i) {
    }

    void onStreamVideoTypeChangedJNI(long j, final int i) {
        final Stream stream = new Stream(j, true);
        this.handler.post(new Runnable() { // from class: com.opentok.android.Session$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onStreamVideoTypeChangedJNI$12(stream, i);
            }
        });
        if (this.streamPropertiesListener != null) {
            this.handler.post(new Runnable() { // from class: com.opentok.android.Session$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onStreamVideoTypeChangedJNI$13(stream, i);
                }
            });
        }
    }

    public void publish(PublisherKit publisherKit) {
        this.log.d("publish(...) called", new Object[0]);
        if (publisherKit == null || publisherKit.getOtcPublisher() == null) {
            throwError(new com.opentok.impl.a(OpentokError.Domain.SessionErrorDomain, OpentokError.ErrorCode.SessionNullOrInvalidParameter.getErrorCode()));
            return;
        }
        if (!isSessionConnected()) {
            throwError(new com.opentok.impl.a(OpentokError.Domain.SessionErrorDomain, OpentokError.ErrorCode.SessionDisconnected.getErrorCode()));
            return;
        }
        int iA = d.a(this.otc_session, publisherKit.getOtcPublisher());
        if (iA != e.c.a()) {
            throwError(new com.opentok.impl.a(OpentokError.Domain.SessionErrorDomain, iA));
            return;
        }
        if (!(publisherKit.getCapturer() instanceof Camera2VideoCapturer) || !(publisherKit.getRenderer() instanceof DefaultVideoRenderer)) {
            reportExternalDeviceUsage(0);
        }
        addObserver(publisherKit);
        if (this.paused) {
            publisherKit.update(this, new SessionPauseResumeEvent(true));
        }
    }

    void reportExternalDeviceUsage(int i) {
        d.a(this.otc_session, g.a(i));
    }

    public String reportIssue() {
        String strC = d.c(this.otc_session, "");
        return strC == null ? "" : strC;
    }

    public void sendSignal(String str, String str2) {
        int iB = d.b(this.otc_session, str, str2);
        if (iB == e.c.a()) {
            return;
        }
        throwError(new com.opentok.impl.a(OpentokError.Domain.SessionErrorDomain, iB));
    }

    public void setArchiveListener(ArchiveListener archiveListener) {
        this.archiveListener = archiveListener;
    }

    public void setConnectionListener(ConnectionListener connectionListener) {
        this.connectionListener = connectionListener;
    }

    public void setEncryptionSecret(String str) {
        int iD = d.d(this.otc_session, str);
        if (iD == e.c.a()) {
            return;
        }
        throwError(new com.opentok.impl.a(OpentokError.Domain.SessionErrorDomain, iD));
    }

    void setHybridSessionEnabled(int i) {
        int iA = d.a(this.otc_session, i);
        if (iA == e.c.a()) {
            return;
        }
        throwError(new com.opentok.impl.a(OpentokError.Domain.SessionErrorDomain, iA));
    }

    public void setMuteListener(MuteListener muteListener) {
        this.muteListener = muteListener;
    }

    public void setReconnectionListener(ReconnectionListener reconnectionListener) {
        this.reconnectionListener = reconnectionListener;
    }

    public void setSessionListener(SessionListener sessionListener) {
        this.sessionListener = sessionListener;
    }

    public void setSignalListener(SignalListener signalListener) {
        this.signalListener = signalListener;
    }

    public void setStreamCaptionsPropertiesListener(StreamCaptionsPropertiesListener streamCaptionsPropertiesListener) {
        this.streamCaptionsPropertiesListener = streamCaptionsPropertiesListener;
    }

    public void setStreamPropertiesListener(StreamPropertiesListener streamPropertiesListener) {
        this.streamPropertiesListener = streamPropertiesListener;
    }

    native void set_prefer_h264(boolean z);

    void simulateReconnect() {
        if (d.h(this.otc_session) != e.c.a()) {
            this.log.e("Error when simulating a client reconnection.", new Object[0]);
        }
    }

    void simulateSessionMigration() {
        if (d.g(this.otc_session) != e.c.a()) {
            this.log.e("Error when simulating migration.", new Object[0]);
        }
    }

    public void subscribe(SubscriberKit subscriberKit) {
        this.log.d("subscribe(...) called", new Object[0]);
        if (subscriberKit == null || subscriberKit.getOtcSubscriber() == null) {
            throwError(new com.opentok.impl.a(OpentokError.Domain.SessionErrorDomain, OpentokError.ErrorCode.SessionNullOrInvalidParameter.getErrorCode()));
            return;
        }
        if (!isSessionConnected()) {
            throwError(new com.opentok.impl.a(OpentokError.Domain.SessionErrorDomain, OpentokError.ErrorCode.SessionDisconnected.getErrorCode()));
            return;
        }
        int iA = d.a(this.otc_session, subscriberKit.getOtcSubscriber());
        if (iA != e.c.a()) {
            throwError(new com.opentok.impl.a(OpentokError.Domain.SessionErrorDomain, iA));
            return;
        }
        subscriberKit.attachToSession(this);
        addObserver(subscriberKit);
        if (subscriberKit.getRenderer() instanceof DefaultVideoRenderer) {
            return;
        }
        reportExternalDeviceUsage(0);
    }

    void throwError(final OpentokError opentokError) {
        if (this.sessionListener != null) {
            this.handler.post(new Runnable() { // from class: com.opentok.android.Session.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (this) {
                        try {
                            Session session = Session.this;
                            SessionListener sessionListener = session.sessionListener;
                            if (sessionListener != null) {
                                sessionListener.onError(session, opentokError);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            });
        }
    }

    public void unpublish(PublisherKit publisherKit) {
        this.log.d("unpublish(...) called", new Object[0]);
        if (publisherKit == null || publisherKit.getOtcPublisher() == null) {
            throwError(new com.opentok.impl.a(OpentokError.Domain.SessionErrorDomain, OpentokError.ErrorCode.SessionNullOrInvalidParameter.getErrorCode()));
            return;
        }
        if (!isSessionConnected()) {
            throwError(new com.opentok.impl.a(OpentokError.Domain.SessionErrorDomain, OpentokError.ErrorCode.SessionDisconnected.getErrorCode()));
            return;
        }
        int iB = d.b(this.otc_session, publisherKit.getOtcPublisher());
        if (iB == e.c.a()) {
            deleteObserver(publisherKit);
        } else {
            throwError(new com.opentok.impl.a(OpentokError.Domain.SessionErrorDomain, iB));
        }
    }

    public void unsubscribe(SubscriberKit subscriberKit) {
        this.log.d("unsubscribe(...) called", new Object[0]);
        if (subscriberKit == null || subscriberKit.getOtcSubscriber() == null) {
            throwError(new com.opentok.impl.a(OpentokError.Domain.SessionErrorDomain, OpentokError.ErrorCode.SessionNullOrInvalidParameter.getErrorCode()));
            return;
        }
        if (!isSessionConnected()) {
            throwError(new com.opentok.impl.a(OpentokError.Domain.SessionErrorDomain, OpentokError.ErrorCode.SessionDisconnected.getErrorCode()));
            return;
        }
        int iB = d.b(this.otc_session, subscriberKit.getOtcSubscriber());
        if (iB != e.c.a()) {
            throwError(new com.opentok.impl.a(OpentokError.Domain.SessionErrorDomain, iB));
        } else {
            deleteObserver(subscriberKit);
            subscriberKit.detachFromSession(this);
        }
    }

    public void sendSignal(String str, String str2, boolean z) {
        otc_signal_options otc_signal_optionsVar = new otc_signal_options();
        otc_signal_optionsVar.a(z ? 1 : 0);
        int iA = d.a(this.otc_session, str, str2, otc_signal_optionsVar);
        if (iA == e.c.a()) {
            return;
        }
        throwError(new com.opentok.impl.a(OpentokError.Domain.SessionErrorDomain, iA));
    }

    public void sendSignal(String str, String str2, Connection connection) {
        int iA = d.a(this.otc_session, str, str2, connection.getOtcConnection());
        if (iA == e.c.a()) {
            return;
        }
        throwError(new com.opentok.impl.a(OpentokError.Domain.SessionErrorDomain, iA));
    }

    public void sendSignal(String str, String str2, Connection connection, boolean z) {
        otc_signal_options otc_signal_optionsVar = new otc_signal_options();
        otc_signal_optionsVar.a(z ? 1 : 0);
        int iA = d.a(this.otc_session, str, str2, connection.getOtcConnection(), otc_signal_optionsVar);
        if (iA == e.c.a()) {
            return;
        }
        throwError(new com.opentok.impl.a(OpentokError.Domain.SessionErrorDomain, iA));
    }

    Session(SWIGTYPE_p_otc_session sWIGTYPE_p_otc_session, boolean z) {
        this.shouldDestroyOnFinalize = true;
        this.paused = false;
        this.log = new OtLog.LogToken(this);
        this.otc_session = sWIGTYPE_p_otc_session;
        this.shouldDestroyOnFinalize = z;
    }
}
