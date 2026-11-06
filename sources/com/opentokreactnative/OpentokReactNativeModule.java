package com.opentokreactnative;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.appstate.AppStateModule;
import com.google.firebase.messaging.Constants;
import com.opentok.android.Connection;
import com.opentok.android.MuteForcedInfo;
import com.opentok.android.OpentokError;
import com.opentok.android.Publisher;
import com.opentok.android.Session;
import com.opentok.android.Stream;
import com.opentok.android.Subscriber;
import com.opentokreactnative.utils.EventUtils;
import com.opentokreactnative.utils.Utils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class OpentokReactNativeModule extends NativeOpentokSpec implements Session.SessionListener, Session.SignalListener, Session.ConnectionListener, Session.ReconnectionListener, Session.ArchiveListener, Session.MuteListener, Session.StreamPropertiesListener, Session.StreamCaptionsPropertiesListener, Application.ActivityLifecycleCallbacks {
    public static final String NAME = "OpentokReactNative";
    private ReactApplicationContext context;
    private OTRN sharedState;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Override // com.opentokreactnative.NativeOpentokSpec, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "OpentokReactNative";
    }

    public OpentokReactNativeModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.context = null;
        this.sharedState = OTRN.getSharedState();
        this.context = reactApplicationContext;
    }

    @Override // com.opentokreactnative.NativeOpentokSpec
    public void initSession(String str, String str2, ReadableMap readableMap) {
        final boolean z = readableMap.getBoolean("useTextureViews");
        boolean z2 = readableMap.getBoolean("connectionEventsSuppressed");
        boolean z3 = readableMap.getBoolean("ipWhitelist");
        List<Session.Builder.IceServer> listSanitizeIceServer = Utils.sanitizeIceServer(readableMap.getArray("customServers"));
        Session.Builder.IncludeServers includeServersSanitizeIncludeServer = Utils.sanitizeIncludeServer(readableMap.getString("includeServers"));
        Session.Builder.TransportPolicy transportPolicySanitizeTransportPolicy = Utils.sanitizeTransportPolicy(readableMap.getString("transportPolicy"));
        String string = readableMap.getString("proxyUrl");
        String string2 = readableMap.getString("apiUrl");
        String string3 = readableMap.getString("androidOnTop");
        String string4 = readableMap.getString("androidZOrder");
        boolean z4 = readableMap.getBoolean("enableSinglePeerConnection");
        boolean z5 = readableMap.getBoolean("sessionMigration");
        ConcurrentHashMap androidOnTopMap = this.sharedState.getAndroidOnTopMap();
        ConcurrentHashMap androidZOrderMap = this.sharedState.getAndroidZOrderMap();
        Session.Builder sessionMigration = new Session.Builder(this.context, str, str2).sessionOptions(new Session.SessionOptions() { // from class: com.opentokreactnative.OpentokReactNativeModule.1
            @Override // com.opentok.android.Session.SessionOptions
            public boolean useTextureViews() {
                return z;
            }
        }).connectionEventsSuppressed(Boolean.valueOf(z2)).setCustomIceServers(listSanitizeIceServer, includeServersSanitizeIncludeServer).setIceRouting(transportPolicySanitizeTransportPolicy).setIpWhitelist(z3).setProxyUrl(string).setSinglePeerConnection(z4).setSessionMigration(z5);
        if (string2 != null && !string2.isEmpty()) {
            try {
                sessionMigration.setApiUrl(new URL(string2));
            } catch (MalformedURLException unused) {
            }
        }
        Session sessionBuild = sessionMigration.build();
        this.sharedState.getSessions().put(str2, sessionBuild);
        sessionBuild.setArchiveListener(this);
        sessionBuild.setConnectionListener(this);
        sessionBuild.setMuteListener(this);
        sessionBuild.setMuteListener(this);
        sessionBuild.setSessionListener(this);
        sessionBuild.setSignalListener(this);
        sessionBuild.setStreamCaptionsPropertiesListener(this);
        sessionBuild.setStreamPropertiesListener(this);
        androidOnTopMap.put(str2, string3);
        androidZOrderMap.put(str2, string4);
    }

    @Override // com.opentokreactnative.NativeOpentokSpec
    public void connect(String str, String str2, Promise promise) {
        Session session = (Session) this.sharedState.getSessions().get(str);
        if (session != null) {
            session.connect(str2);
            promise.resolve(null);
        } else {
            promise.reject("Error connecting to session. Could not find native session instance");
        }
    }

    @Override // com.opentokreactnative.NativeOpentokSpec
    public void disconnect(String str, Promise promise) {
        Session session = (Session) this.sharedState.getSessions().get(str);
        if (session != null) {
            session.disconnect();
            promise.resolve(null);
        }
    }

    @Override // com.opentokreactnative.NativeOpentokSpec
    public void sendSignal(String str, String str2, String str3, String str4) {
        Session session = (Session) this.sharedState.getSessions().get(str);
        if (session == null) {
            return;
        }
        if (str4 == null || str4.equals("")) {
            session.sendSignal(str2, str3);
            return;
        }
        Connection connection = (Connection) this.sharedState.getConnections().get(str4);
        if (connection == null) {
            return;
        }
        session.sendSignal(str2, str3, connection);
    }

    @Override // com.opentokreactnative.NativeOpentokSpec
    public void getSubscriberRtcStatsReport(String str) {
        Iterator it = new ArrayList(this.sharedState.getSubscribers().values()).iterator();
        while (it.hasNext()) {
            ((Subscriber) it.next()).getRtcStatsReport();
        }
    }

    @Override // com.opentokreactnative.NativeOpentokSpec
    public void publish(String str, String str2) {
        Publisher publisher;
        Session session = (Session) this.sharedState.getSessions().get(str);
        if (session == null || (publisher = (Publisher) this.sharedState.getPublishers().get(str2)) == null) {
            return;
        }
        session.publish(publisher);
    }

    @Override // com.opentokreactnative.NativeOpentokSpec
    public void unpublish(String str, String str2) {
        Session session = (Session) this.sharedState.getSessions().get(str);
        if (session == null) {
            return;
        }
        ConcurrentHashMap publishers = this.sharedState.getPublishers();
        Publisher publisher = (Publisher) publishers.get(str2);
        if (publisher != null) {
            session.unpublish(publisher);
            publishers.remove(publisher);
        }
    }

    @Override // com.opentokreactnative.NativeOpentokSpec
    public void removeSubscriber(final String str, final String str2) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.opentokreactnative.OpentokReactNativeModule.2
            @Override // java.lang.Runnable
            public void run() {
                Session session = (Session) OpentokReactNativeModule.this.sharedState.getSessions().get(str);
                if (session == null) {
                    return;
                }
                ConcurrentHashMap subscribers = OpentokReactNativeModule.this.sharedState.getSubscribers();
                Subscriber subscriber = (Subscriber) subscribers.get(str2);
                if (subscriber != null) {
                    session.unsubscribe(subscriber);
                    subscribers.remove(subscriber);
                }
            }
        });
    }

    @Override // com.opentokreactnative.NativeOpentokSpec
    public void disableForceMute(String str, Promise promise) {
        Session session = (Session) this.sharedState.getSessions().get(str);
        if (session == null) {
            promise.reject("Session not found.");
        } else {
            session.disableForceMute();
            promise.resolve(Boolean.TRUE);
        }
    }

    @Override // com.opentokreactnative.NativeOpentokSpec
    public void forceMuteAll(String str, ReadableArray readableArray, Promise promise) {
        Session session = (Session) this.sharedState.getSessions().get(str);
        ConcurrentHashMap subscriberStreams = this.sharedState.getSubscriberStreams();
        ArrayList arrayList = new ArrayList();
        if (session == null) {
            promise.reject("Session not found.");
            return;
        }
        for (int i = 0; i < readableArray.size(); i++) {
            Stream stream = (Stream) subscriberStreams.get(readableArray.getString(i));
            if (stream == null) {
                promise.reject("Stream not found.");
            } else {
                arrayList.add(stream);
            }
        }
        session.forceMuteAll(arrayList);
        promise.resolve(null);
    }

    @Override // com.opentokreactnative.NativeOpentokSpec
    public void forceMuteStream(String str, String str2, Promise promise) {
        Session session = (Session) this.sharedState.getSessions().get(str);
        ConcurrentHashMap subscriberStreams = this.sharedState.getSubscriberStreams();
        if (session == null) {
            promise.reject("Session not found.");
            return;
        }
        Stream stream = (Stream) subscriberStreams.get(str2);
        if (stream == null) {
            promise.reject("Stream not found.");
        } else {
            session.forceMuteStream(stream);
            promise.resolve(null);
        }
    }

    @Override // com.opentokreactnative.NativeOpentokSpec
    public void forceDisconnect(String str, String str2, Promise promise) {
        Session session = (Session) this.sharedState.getSessions().get(str);
        ConcurrentHashMap connections = this.sharedState.getConnections();
        if (session == null) {
            promise.reject("Session not found.");
            return;
        }
        Connection connection = (Connection) connections.get(str2);
        if (connection == null) {
            promise.reject("Connection not found.");
        } else {
            session.forceDisconnect(connection);
            promise.resolve(null);
        }
    }

    @Override // com.opentokreactnative.NativeOpentokSpec
    public void getPublisherRtcStatsReport(String str, String str2) {
        Publisher publisher = (Publisher) this.sharedState.getPublishers().get(str2);
        if (publisher != null) {
            publisher.getRtcStatsReport();
        }
    }

    @Override // com.opentokreactnative.NativeOpentokSpec
    public void setAudioTransformers(String str, String str2, ReadableArray readableArray) {
        Publisher publisher = (Publisher) this.sharedState.getPublishers().get(str2);
        if (publisher != null) {
            publisher.setAudioTransformers(Utils.sanitizeAudioTransformerList(publisher, readableArray));
        }
    }

    @Override // com.opentokreactnative.NativeOpentokSpec
    public void setVideoTransformers(String str, String str2, ReadableArray readableArray) {
        Publisher publisher = (Publisher) this.sharedState.getPublishers().get(str2);
        if (publisher != null) {
            publisher.setVideoTransformers(Utils.sanitizeVideoTransformerList(publisher, readableArray));
        }
    }

    @Override // com.opentokreactnative.NativeOpentokSpec
    public void getCapabilities(String str, Promise promise) {
        Session session = (Session) this.sharedState.getSessions().get(str);
        if (session == null) {
            promise.reject("Session not found.");
            return;
        }
        WritableMap writableMapCreateMap = Arguments.createMap();
        Session.Capabilities capabilities = session.getCapabilities();
        writableMapCreateMap.putBoolean("canForceMute", capabilities.canForceMute);
        writableMapCreateMap.putBoolean("canPublish", capabilities.canPublish);
        writableMapCreateMap.putBoolean("canSubscribe", true);
        writableMapCreateMap.putBoolean("canForceDisconnect", capabilities.canForceDisconnect);
        promise.resolve(writableMapCreateMap);
    }

    @Override // com.opentokreactnative.NativeOpentokSpec
    public void reportIssue(String str, Promise promise) {
        Session session = (Session) this.sharedState.getSessions().get(str);
        if (session != null) {
            promise.resolve(session.reportIssue());
        } else {
            promise.reject("Error connecting to session. Could not find native session instance.");
        }
    }

    @Override // com.opentokreactnative.NativeOpentokSpec
    public void setEncryptionSecret(String str, String str2, Promise promise) {
        Session session = (Session) this.sharedState.getSessions().get(str);
        if (session != null) {
            session.setEncryptionSecret(str2);
            promise.resolve(null);
        } else {
            promise.reject("There was an error setting the encryption secret. The native session instance could not be found.");
        }
    }

    @Override // com.opentok.android.Session.SessionListener
    public void onConnected(Session session) {
        Connection connection = session.getConnection();
        this.sharedState.getConnections().put(connection.getConnectionId(), connection);
        emitOnSessionConnected(EventUtils.prepareJSSessionMap(session));
    }

    @Override // com.opentok.android.Session.SessionListener
    public void onDisconnected(Session session) {
        emitOnSessionDisconnected(EventUtils.prepareJSSessionMap(session));
        this.sharedState.getSessions().remove(session.getSessionId());
    }

    @Override // com.opentok.android.Session.SessionListener
    public void onStreamReceived(Session session, Stream stream) {
        this.sharedState.getSubscriberStreams().put(stream.getStreamId(), stream);
        emitOnStreamCreated(EventUtils.prepareJSStreamMap(stream, session));
    }

    @Override // com.opentok.android.Session.SessionListener
    public void onStreamDropped(Session session, Stream stream) {
        emitOnStreamDestroyed(EventUtils.prepareJSStreamMap(stream, session));
    }

    @Override // com.opentok.android.Session.SessionListener
    public void onError(Session session, OpentokError opentokError) {
        emitOnSessionError(EventUtils.prepareJSErrorMap(opentokError));
    }

    @Override // com.opentok.android.Session.SignalListener
    public void onSignalReceived(Session session, String str, String str2, Connection connection) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("sessionId", session.getSessionId());
        writableMapCreateMap.putString("connectionId", connection.getConnectionId());
        writableMapCreateMap.putString("type", str);
        writableMapCreateMap.putString(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, str2);
        emitOnSignalReceived(writableMapCreateMap);
    }

    @Override // com.opentok.android.Session.ArchiveListener
    public void onArchiveStarted(Session session, String str, String str2) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("sessionId", session.getSessionId());
        writableMapCreateMap.putString("archiveId", str);
        writableMapCreateMap.putString("name", str2);
        emitOnArchiveStarted(writableMapCreateMap);
    }

    @Override // com.opentok.android.Session.ArchiveListener
    public void onArchiveStopped(Session session, String str) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("archiveId", str);
        writableMapCreateMap.putString("name", "");
        writableMapCreateMap.putString("sessionId", session.getSessionId());
        emitOnArchiveStopped(writableMapCreateMap);
    }

    @Override // com.opentok.android.Session.ConnectionListener
    public void onConnectionCreated(Session session, Connection connection) {
        this.sharedState.getConnections().put(connection.getConnectionId(), connection);
        WritableMap writableMapPrepareJSConnectionMap = EventUtils.prepareJSConnectionMap(connection);
        writableMapPrepareJSConnectionMap.putString("sessionId", session.getSessionId());
        emitOnConnectionCreated(writableMapPrepareJSConnectionMap);
    }

    @Override // com.opentok.android.Session.ConnectionListener
    public void onConnectionDestroyed(Session session, Connection connection) {
        this.sharedState.getConnections().remove(connection.getConnectionId());
        WritableMap writableMapPrepareJSConnectionMap = EventUtils.prepareJSConnectionMap(connection);
        writableMapPrepareJSConnectionMap.putString("sessionId", session.getSessionId());
        emitOnConnectionDestroyed(writableMapPrepareJSConnectionMap);
    }

    @Override // com.opentok.android.Session.MuteListener
    public void onMuteForced(Session session, MuteForcedInfo muteForcedInfo) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putBoolean(AppStateModule.APP_STATE_ACTIVE, muteForcedInfo.getActive());
        emitOnMuteForced(writableMapCreateMap);
    }

    @Override // com.opentok.android.Session.ReconnectionListener
    public void onReconnecting(Session session) {
        emitOnSessionReconnecting(null);
    }

    @Override // com.opentok.android.Session.ReconnectionListener
    public void onReconnected(Session session) {
        emitOnSessionReconnected(null);
    }

    @Override // com.opentok.android.Session.StreamCaptionsPropertiesListener
    public void onStreamHasCaptionsChanged(Session session, Stream stream, boolean z) {
        emitOnStreamPropertyChanged(EventUtils.prepareStreamPropertyChangedEventData("hasCaptions", Boolean.valueOf(!z), Boolean.valueOf(z), stream, session));
    }

    @Override // com.opentok.android.Session.StreamPropertiesListener
    public void onStreamHasAudioChanged(Session session, Stream stream, boolean z) {
        emitOnStreamPropertyChanged(EventUtils.prepareStreamPropertyChangedEventData("hasAudio", Boolean.valueOf(!z), Boolean.valueOf(z), stream, session));
    }

    @Override // com.opentok.android.Session.StreamPropertiesListener
    public void onStreamHasVideoChanged(Session session, Stream stream, boolean z) {
        emitOnStreamPropertyChanged(EventUtils.prepareStreamPropertyChangedEventData("hasVideo", Boolean.valueOf(!z), Boolean.valueOf(z), stream, session));
    }

    @Override // com.opentok.android.Session.StreamPropertiesListener
    public void onStreamVideoDimensionsChanged(Session session, Stream stream, int i, int i2) {
        Stream stream2 = (Stream) this.sharedState.getSubscriberStreams().get(stream.getStreamId());
        WritableMap writableMapCreateMap = Arguments.createMap();
        if (stream2 != null) {
            writableMapCreateMap.putInt("height", stream2.getVideoHeight());
            writableMapCreateMap.putInt("width", stream2.getVideoWidth());
        }
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        writableMapCreateMap2.putInt("height", i2);
        writableMapCreateMap2.putInt("width", i);
        emitOnStreamPropertyChanged(EventUtils.prepareStreamPropertyChangedEventData("videoDimensions", writableMapCreateMap, writableMapCreateMap2, stream, session));
    }

    @Override // com.opentok.android.Session.StreamPropertiesListener
    public void onStreamVideoTypeChanged(Session session, Stream stream, Stream.StreamVideoType streamVideoType) {
        this.sharedState.getSubscriberStreams();
        emitOnStreamPropertyChanged(EventUtils.prepareStreamPropertyChangedEventData("videoType", stream.getStreamVideoType().toString(), streamVideoType.toString(), stream, session));
    }
}
