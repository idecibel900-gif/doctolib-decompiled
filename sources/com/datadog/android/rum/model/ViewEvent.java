package com.datadog.android.rum.model;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.datadog.android.core.internal.utils.JsonSerializer;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.facebook.react.modules.appstate.AppStateModule;
import com.google.firebase.messaging.Constants;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.react.RNPurchasesModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.AuthorizationRequest;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes3.dex */
public final class ViewEvent {
    public static final Companion Companion = new Companion(null);
    private final Account account;
    private final Application application;
    private final String buildId;
    private final String buildVersion;
    private final CiTest ciTest;
    private final Connectivity connectivity;
    private final Container container;
    private final Context context;
    private final long date;
    private final Dd dd;
    private final String ddtags;
    private final Device device;
    private final Display display;
    private final Context featureFlags;
    private final Os os;
    private final Privacy privacy;
    private final String service;
    private final ViewEventSession session;
    private final ViewEventSource source;
    private final Synthetics synthetics;
    private final String type;
    private final Usr usr;
    private final String version;
    private final ViewEventView view;

    public static /* synthetic */ ViewEvent copy$default(ViewEvent viewEvent, long j, Application application, String str, String str2, String str3, String str4, String str5, ViewEventSession viewEventSession, ViewEventSource viewEventSource, ViewEventView viewEventView, Usr usr, Account account, Connectivity connectivity, Display display, Synthetics synthetics, CiTest ciTest, Os os, Device device, Dd dd, Context context, Container container, Context context2, Privacy privacy, int i, Object obj) {
        Privacy privacy2;
        Context context3;
        long j2 = (i & 1) != 0 ? viewEvent.date : j;
        Application application2 = (i & 2) != 0 ? viewEvent.application : application;
        String str6 = (i & 4) != 0 ? viewEvent.service : str;
        String str7 = (i & 8) != 0 ? viewEvent.version : str2;
        String str8 = (i & 16) != 0 ? viewEvent.buildVersion : str3;
        String str9 = (i & 32) != 0 ? viewEvent.buildId : str4;
        String str10 = (i & 64) != 0 ? viewEvent.ddtags : str5;
        ViewEventSession viewEventSession2 = (i & 128) != 0 ? viewEvent.session : viewEventSession;
        ViewEventSource viewEventSource2 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? viewEvent.source : viewEventSource;
        ViewEventView viewEventView2 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? viewEvent.view : viewEventView;
        Usr usr2 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? viewEvent.usr : usr;
        Account account2 = (i & 2048) != 0 ? viewEvent.account : account;
        Connectivity connectivity2 = (i & 4096) != 0 ? viewEvent.connectivity : connectivity;
        long j3 = j2;
        Display display2 = (i & 8192) != 0 ? viewEvent.display : display;
        Synthetics synthetics2 = (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? viewEvent.synthetics : synthetics;
        CiTest ciTest2 = (i & 32768) != 0 ? viewEvent.ciTest : ciTest;
        Os os2 = (i & 65536) != 0 ? viewEvent.os : os;
        Device device2 = (i & 131072) != 0 ? viewEvent.device : device;
        Dd dd2 = (i & 262144) != 0 ? viewEvent.dd : dd;
        Context context4 = (i & 524288) != 0 ? viewEvent.context : context;
        Container container2 = (i & 1048576) != 0 ? viewEvent.container : container;
        Context context5 = (i & 2097152) != 0 ? viewEvent.featureFlags : context2;
        if ((i & 4194304) != 0) {
            context3 = context5;
            privacy2 = viewEvent.privacy;
        } else {
            privacy2 = privacy;
            context3 = context5;
        }
        return viewEvent.copy(j3, application2, str6, str7, str8, str9, str10, viewEventSession2, viewEventSource2, viewEventView2, usr2, account2, connectivity2, display2, synthetics2, ciTest2, os2, device2, dd2, context4, container2, context3, privacy2);
    }

    public final ViewEvent copy(long j, Application application, String str, String str2, String str3, String str4, String str5, ViewEventSession session, ViewEventSource viewEventSource, ViewEventView view, Usr usr, Account account, Connectivity connectivity, Display display, Synthetics synthetics, CiTest ciTest, Os os, Device device, Dd dd, Context context, Container container, Context context2, Privacy privacy) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dd, "dd");
        return new ViewEvent(j, application, str, str2, str3, str4, str5, session, viewEventSource, view, usr, account, connectivity, display, synthetics, ciTest, os, device, dd, context, container, context2, privacy);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ViewEvent)) {
            return false;
        }
        ViewEvent viewEvent = (ViewEvent) obj;
        return this.date == viewEvent.date && Intrinsics.areEqual(this.application, viewEvent.application) && Intrinsics.areEqual(this.service, viewEvent.service) && Intrinsics.areEqual(this.version, viewEvent.version) && Intrinsics.areEqual(this.buildVersion, viewEvent.buildVersion) && Intrinsics.areEqual(this.buildId, viewEvent.buildId) && Intrinsics.areEqual(this.ddtags, viewEvent.ddtags) && Intrinsics.areEqual(this.session, viewEvent.session) && this.source == viewEvent.source && Intrinsics.areEqual(this.view, viewEvent.view) && Intrinsics.areEqual(this.usr, viewEvent.usr) && Intrinsics.areEqual(this.account, viewEvent.account) && Intrinsics.areEqual(this.connectivity, viewEvent.connectivity) && Intrinsics.areEqual(this.display, viewEvent.display) && Intrinsics.areEqual(this.synthetics, viewEvent.synthetics) && Intrinsics.areEqual(this.ciTest, viewEvent.ciTest) && Intrinsics.areEqual(this.os, viewEvent.os) && Intrinsics.areEqual(this.device, viewEvent.device) && Intrinsics.areEqual(this.dd, viewEvent.dd) && Intrinsics.areEqual(this.context, viewEvent.context) && Intrinsics.areEqual(this.container, viewEvent.container) && Intrinsics.areEqual(this.featureFlags, viewEvent.featureFlags) && Intrinsics.areEqual(this.privacy, viewEvent.privacy);
    }

    public int hashCode() {
        int iHashCode = ((Long.hashCode(this.date) * 31) + this.application.hashCode()) * 31;
        String str = this.service;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.version;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.buildVersion;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.buildId;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.ddtags;
        int iHashCode6 = (((iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.session.hashCode()) * 31;
        ViewEventSource viewEventSource = this.source;
        int iHashCode7 = (((iHashCode6 + (viewEventSource == null ? 0 : viewEventSource.hashCode())) * 31) + this.view.hashCode()) * 31;
        Usr usr = this.usr;
        int iHashCode8 = (iHashCode7 + (usr == null ? 0 : usr.hashCode())) * 31;
        Account account = this.account;
        int iHashCode9 = (iHashCode8 + (account == null ? 0 : account.hashCode())) * 31;
        Connectivity connectivity = this.connectivity;
        int iHashCode10 = (iHashCode9 + (connectivity == null ? 0 : connectivity.hashCode())) * 31;
        Display display = this.display;
        int iHashCode11 = (iHashCode10 + (display == null ? 0 : display.hashCode())) * 31;
        Synthetics synthetics = this.synthetics;
        int iHashCode12 = (iHashCode11 + (synthetics == null ? 0 : synthetics.hashCode())) * 31;
        CiTest ciTest = this.ciTest;
        int iHashCode13 = (iHashCode12 + (ciTest == null ? 0 : ciTest.hashCode())) * 31;
        Os os = this.os;
        int iHashCode14 = (iHashCode13 + (os == null ? 0 : os.hashCode())) * 31;
        Device device = this.device;
        int iHashCode15 = (((iHashCode14 + (device == null ? 0 : device.hashCode())) * 31) + this.dd.hashCode()) * 31;
        Context context = this.context;
        int iHashCode16 = (iHashCode15 + (context == null ? 0 : context.hashCode())) * 31;
        Container container = this.container;
        int iHashCode17 = (iHashCode16 + (container == null ? 0 : container.hashCode())) * 31;
        Context context2 = this.featureFlags;
        int iHashCode18 = (iHashCode17 + (context2 == null ? 0 : context2.hashCode())) * 31;
        Privacy privacy = this.privacy;
        return iHashCode18 + (privacy != null ? privacy.hashCode() : 0);
    }

    public String toString() {
        return "ViewEvent(date=" + this.date + ", application=" + this.application + ", service=" + this.service + ", version=" + this.version + ", buildVersion=" + this.buildVersion + ", buildId=" + this.buildId + ", ddtags=" + this.ddtags + ", session=" + this.session + ", source=" + this.source + ", view=" + this.view + ", usr=" + this.usr + ", account=" + this.account + ", connectivity=" + this.connectivity + ", display=" + this.display + ", synthetics=" + this.synthetics + ", ciTest=" + this.ciTest + ", os=" + this.os + ", device=" + this.device + ", dd=" + this.dd + ", context=" + this.context + ", container=" + this.container + ", featureFlags=" + this.featureFlags + ", privacy=" + this.privacy + ")";
    }

    public ViewEvent(long j, Application application, String str, String str2, String str3, String str4, String str5, ViewEventSession session, ViewEventSource viewEventSource, ViewEventView view, Usr usr, Account account, Connectivity connectivity, Display display, Synthetics synthetics, CiTest ciTest, Os os, Device device, Dd dd, Context context, Container container, Context context2, Privacy privacy) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dd, "dd");
        this.date = j;
        this.application = application;
        this.service = str;
        this.version = str2;
        this.buildVersion = str3;
        this.buildId = str4;
        this.ddtags = str5;
        this.session = session;
        this.source = viewEventSource;
        this.view = view;
        this.usr = usr;
        this.account = account;
        this.connectivity = connectivity;
        this.display = display;
        this.synthetics = synthetics;
        this.ciTest = ciTest;
        this.os = os;
        this.device = device;
        this.dd = dd;
        this.context = context;
        this.container = container;
        this.featureFlags = context2;
        this.privacy = privacy;
        this.type = "view";
    }

    public /* synthetic */ ViewEvent(long j, Application application, String str, String str2, String str3, String str4, String str5, ViewEventSession viewEventSession, ViewEventSource viewEventSource, ViewEventView viewEventView, Usr usr, Account account, Connectivity connectivity, Display display, Synthetics synthetics, CiTest ciTest, Os os, Device device, Dd dd, Context context, Container container, Context context2, Privacy privacy, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, application, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, viewEventSession, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : viewEventSource, viewEventView, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : usr, (i & 2048) != 0 ? null : account, (i & 4096) != 0 ? null : connectivity, (i & 8192) != 0 ? null : display, (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? null : synthetics, (32768 & i) != 0 ? null : ciTest, (65536 & i) != 0 ? null : os, (131072 & i) != 0 ? null : device, dd, (524288 & i) != 0 ? null : context, (1048576 & i) != 0 ? null : container, (2097152 & i) != 0 ? null : context2, (i & 4194304) != 0 ? null : privacy);
    }

    public final long getDate() {
        return this.date;
    }

    public final Application getApplication() {
        return this.application;
    }

    public final String getService() {
        return this.service;
    }

    public final String getVersion() {
        return this.version;
    }

    public final ViewEventSession getSession() {
        return this.session;
    }

    public final ViewEventSource getSource() {
        return this.source;
    }

    public final ViewEventView getView() {
        return this.view;
    }

    public final Usr getUsr() {
        return this.usr;
    }

    public final Account getAccount() {
        return this.account;
    }

    public final Connectivity getConnectivity() {
        return this.connectivity;
    }

    public final Dd getDd() {
        return this.dd;
    }

    public final Context getContext() {
        return this.context;
    }

    public final JsonElement toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("date", Long.valueOf(this.date));
        jsonObject.add("application", this.application.toJson());
        String str = this.service;
        if (str != null) {
            jsonObject.addProperty("service", str);
        }
        String str2 = this.version;
        if (str2 != null) {
            jsonObject.addProperty(DiagnosticsEntry.VERSION_KEY, str2);
        }
        String str3 = this.buildVersion;
        if (str3 != null) {
            jsonObject.addProperty("build_version", str3);
        }
        String str4 = this.buildId;
        if (str4 != null) {
            jsonObject.addProperty("build_id", str4);
        }
        String str5 = this.ddtags;
        if (str5 != null) {
            jsonObject.addProperty("ddtags", str5);
        }
        jsonObject.add("session", this.session.toJson());
        ViewEventSource viewEventSource = this.source;
        if (viewEventSource != null) {
            jsonObject.add(Constants.ScionAnalytics.PARAM_SOURCE, viewEventSource.toJson());
        }
        jsonObject.add("view", this.view.toJson());
        Usr usr = this.usr;
        if (usr != null) {
            jsonObject.add("usr", usr.toJson());
        }
        Account account = this.account;
        if (account != null) {
            jsonObject.add("account", account.toJson());
        }
        Connectivity connectivity = this.connectivity;
        if (connectivity != null) {
            jsonObject.add("connectivity", connectivity.toJson());
        }
        Display display = this.display;
        if (display != null) {
            jsonObject.add(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION, display.toJson());
        }
        Synthetics synthetics = this.synthetics;
        if (synthetics != null) {
            jsonObject.add("synthetics", synthetics.toJson());
        }
        CiTest ciTest = this.ciTest;
        if (ciTest != null) {
            jsonObject.add("ci_test", ciTest.toJson());
        }
        Os os = this.os;
        if (os != null) {
            jsonObject.add("os", os.toJson());
        }
        Device device = this.device;
        if (device != null) {
            jsonObject.add("device", device.toJson());
        }
        jsonObject.add("_dd", this.dd.toJson());
        Context context = this.context;
        if (context != null) {
            jsonObject.add("context", context.toJson());
        }
        Container container = this.container;
        if (container != null) {
            jsonObject.add("container", container.toJson());
        }
        jsonObject.addProperty("type", this.type);
        Context context2 = this.featureFlags;
        if (context2 != null) {
            jsonObject.add("feature_flags", context2.toJson());
        }
        Privacy privacy = this.privacy;
        if (privacy != null) {
            jsonObject.add("privacy", privacy.toJson());
        }
        return jsonObject;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ViewEvent fromJsonObject(JsonObject jsonObject) {
            JsonObject asJsonObject;
            JsonObject asJsonObject2;
            JsonObject asJsonObject3;
            JsonObject asJsonObject4;
            JsonObject asJsonObject5;
            JsonObject asJsonObject6;
            JsonObject asJsonObject7;
            JsonObject asJsonObject8;
            JsonObject asJsonObject9;
            JsonObject asJsonObject10;
            JsonObject asJsonObject11;
            JsonObject asJsonObject12;
            String asString;
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            try {
                long asLong = jsonObject.get("date").getAsLong();
                JsonObject it = jsonObject.get("application").getAsJsonObject();
                Application.Companion companion = Application.Companion;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                Application applicationFromJsonObject = companion.fromJsonObject(it);
                JsonElement jsonElement = jsonObject.get("service");
                String asString2 = jsonElement != null ? jsonElement.getAsString() : null;
                JsonElement jsonElement2 = jsonObject.get(DiagnosticsEntry.VERSION_KEY);
                String asString3 = jsonElement2 != null ? jsonElement2.getAsString() : null;
                JsonElement jsonElement3 = jsonObject.get("build_version");
                String asString4 = jsonElement3 != null ? jsonElement3.getAsString() : null;
                JsonElement jsonElement4 = jsonObject.get("build_id");
                String asString5 = jsonElement4 != null ? jsonElement4.getAsString() : null;
                JsonElement jsonElement5 = jsonObject.get("ddtags");
                String asString6 = jsonElement5 != null ? jsonElement5.getAsString() : null;
                JsonObject it2 = jsonObject.get("session").getAsJsonObject();
                ViewEventSession.Companion companion2 = ViewEventSession.Companion;
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                ViewEventSession viewEventSessionFromJsonObject = companion2.fromJsonObject(it2);
                JsonElement jsonElement6 = jsonObject.get(Constants.ScionAnalytics.PARAM_SOURCE);
                ViewEventSource viewEventSourceFromJson = (jsonElement6 == null || (asString = jsonElement6.getAsString()) == null) ? null : ViewEventSource.Companion.fromJson(asString);
                JsonObject it3 = jsonObject.get("view").getAsJsonObject();
                ViewEventView.Companion companion3 = ViewEventView.Companion;
                Intrinsics.checkNotNullExpressionValue(it3, "it");
                ViewEventView viewEventViewFromJsonObject = companion3.fromJsonObject(it3);
                JsonElement jsonElement7 = jsonObject.get("usr");
                Usr usrFromJsonObject = (jsonElement7 == null || (asJsonObject12 = jsonElement7.getAsJsonObject()) == null) ? null : Usr.Companion.fromJsonObject(asJsonObject12);
                JsonElement jsonElement8 = jsonObject.get("account");
                Account accountFromJsonObject = (jsonElement8 == null || (asJsonObject11 = jsonElement8.getAsJsonObject()) == null) ? null : Account.Companion.fromJsonObject(asJsonObject11);
                JsonElement jsonElement9 = jsonObject.get("connectivity");
                Connectivity connectivityFromJsonObject = (jsonElement9 == null || (asJsonObject10 = jsonElement9.getAsJsonObject()) == null) ? null : Connectivity.Companion.fromJsonObject(asJsonObject10);
                JsonElement jsonElement10 = jsonObject.get(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION);
                Display displayFromJsonObject = (jsonElement10 == null || (asJsonObject9 = jsonElement10.getAsJsonObject()) == null) ? null : Display.Companion.fromJsonObject(asJsonObject9);
                JsonElement jsonElement11 = jsonObject.get("synthetics");
                Synthetics syntheticsFromJsonObject = (jsonElement11 == null || (asJsonObject8 = jsonElement11.getAsJsonObject()) == null) ? null : Synthetics.Companion.fromJsonObject(asJsonObject8);
                JsonElement jsonElement12 = jsonObject.get("ci_test");
                CiTest ciTestFromJsonObject = (jsonElement12 == null || (asJsonObject7 = jsonElement12.getAsJsonObject()) == null) ? null : CiTest.Companion.fromJsonObject(asJsonObject7);
                JsonElement jsonElement13 = jsonObject.get("os");
                Os osFromJsonObject = (jsonElement13 == null || (asJsonObject6 = jsonElement13.getAsJsonObject()) == null) ? null : Os.Companion.fromJsonObject(asJsonObject6);
                JsonElement jsonElement14 = jsonObject.get("device");
                Device deviceFromJsonObject = (jsonElement14 == null || (asJsonObject5 = jsonElement14.getAsJsonObject()) == null) ? null : Device.Companion.fromJsonObject(asJsonObject5);
                JsonObject it4 = jsonObject.get("_dd").getAsJsonObject();
                Device device = deviceFromJsonObject;
                Dd.Companion companion4 = Dd.Companion;
                Intrinsics.checkNotNullExpressionValue(it4, "it");
                Dd ddFromJsonObject = companion4.fromJsonObject(it4);
                JsonElement jsonElement15 = jsonObject.get("context");
                Context contextFromJsonObject = (jsonElement15 == null || (asJsonObject4 = jsonElement15.getAsJsonObject()) == null) ? null : Context.Companion.fromJsonObject(asJsonObject4);
                JsonElement jsonElement16 = jsonObject.get("container");
                Container containerFromJsonObject = (jsonElement16 == null || (asJsonObject3 = jsonElement16.getAsJsonObject()) == null) ? null : Container.Companion.fromJsonObject(asJsonObject3);
                String asString7 = jsonObject.get("type").getAsString();
                JsonElement jsonElement17 = jsonObject.get("feature_flags");
                Context contextFromJsonObject2 = (jsonElement17 == null || (asJsonObject2 = jsonElement17.getAsJsonObject()) == null) ? null : Context.Companion.fromJsonObject(asJsonObject2);
                JsonElement jsonElement18 = jsonObject.get("privacy");
                Privacy privacyFromJsonObject = (jsonElement18 == null || (asJsonObject = jsonElement18.getAsJsonObject()) == null) ? null : Privacy.Companion.fromJsonObject(asJsonObject);
                if (!Intrinsics.areEqual(asString7, "view")) {
                    throw new IllegalStateException("Check failed.");
                }
                return new ViewEvent(asLong, applicationFromJsonObject, asString2, asString3, asString4, asString5, asString6, viewEventSessionFromJsonObject, viewEventSourceFromJson, viewEventViewFromJsonObject, usrFromJsonObject, accountFromJsonObject, connectivityFromJsonObject, displayFromJsonObject, syntheticsFromJsonObject, ciTestFromJsonObject, osFromJsonObject, device, ddFromJsonObject, contextFromJsonObject, containerFromJsonObject, contextFromJsonObject2, privacyFromJsonObject);
            } catch (IllegalStateException e) {
                throw new JsonParseException("Unable to parse json into type ViewEvent", e);
            } catch (NullPointerException e2) {
                throw new JsonParseException("Unable to parse json into type ViewEvent", e2);
            } catch (NumberFormatException e3) {
                throw new JsonParseException("Unable to parse json into type ViewEvent", e3);
            }
        }
    }

    public static final class Application {
        public static final Companion Companion = new Companion(null);
        private final String currentLocale;
        private final String id;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Application)) {
                return false;
            }
            Application application = (Application) obj;
            return Intrinsics.areEqual(this.id, application.id) && Intrinsics.areEqual(this.currentLocale, application.currentLocale);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.currentLocale;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Application(id=" + this.id + ", currentLocale=" + this.currentLocale + ")";
        }

        public Application(String id, String str) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
            this.currentLocale = str;
        }

        public final String getId() {
            return this.id;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(DiagnosticsEntry.ID_KEY, this.id);
            String str = this.currentLocale;
            if (str != null) {
                jsonObject.addProperty("current_locale", str);
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Application fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String id = jsonObject.get(DiagnosticsEntry.ID_KEY).getAsString();
                    JsonElement jsonElement = jsonObject.get("current_locale");
                    String asString = jsonElement != null ? jsonElement.getAsString() : null;
                    Intrinsics.checkNotNullExpressionValue(id, "id");
                    return new Application(id, asString);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Application", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Application", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Application", e3);
                }
            }
        }
    }

    public static final class ViewEventSession {
        public static final Companion Companion = new Companion(null);
        private final Boolean hasReplay;
        private final String id;
        private final Boolean isActive;
        private final Boolean sampledForReplay;
        private final ViewEventSessionType type;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ViewEventSession)) {
                return false;
            }
            ViewEventSession viewEventSession = (ViewEventSession) obj;
            return Intrinsics.areEqual(this.id, viewEventSession.id) && this.type == viewEventSession.type && Intrinsics.areEqual(this.hasReplay, viewEventSession.hasReplay) && Intrinsics.areEqual(this.isActive, viewEventSession.isActive) && Intrinsics.areEqual(this.sampledForReplay, viewEventSession.sampledForReplay);
        }

        public int hashCode() {
            int iHashCode = ((this.id.hashCode() * 31) + this.type.hashCode()) * 31;
            Boolean bool = this.hasReplay;
            int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
            Boolean bool2 = this.isActive;
            int iHashCode3 = (iHashCode2 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Boolean bool3 = this.sampledForReplay;
            return iHashCode3 + (bool3 != null ? bool3.hashCode() : 0);
        }

        public String toString() {
            return "ViewEventSession(id=" + this.id + ", type=" + this.type + ", hasReplay=" + this.hasReplay + ", isActive=" + this.isActive + ", sampledForReplay=" + this.sampledForReplay + ")";
        }

        public ViewEventSession(String id, ViewEventSessionType type, Boolean bool, Boolean bool2, Boolean bool3) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            this.id = id;
            this.type = type;
            this.hasReplay = bool;
            this.isActive = bool2;
            this.sampledForReplay = bool3;
        }

        public final String getId() {
            return this.id;
        }

        public final Boolean getHasReplay() {
            return this.hasReplay;
        }

        public /* synthetic */ ViewEventSession(String str, ViewEventSessionType viewEventSessionType, Boolean bool, Boolean bool2, Boolean bool3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, viewEventSessionType, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? Boolean.TRUE : bool2, (i & 16) != 0 ? null : bool3);
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(DiagnosticsEntry.ID_KEY, this.id);
            jsonObject.add("type", this.type.toJson());
            Boolean bool = this.hasReplay;
            if (bool != null) {
                jsonObject.addProperty("has_replay", bool);
            }
            Boolean bool2 = this.isActive;
            if (bool2 != null) {
                jsonObject.addProperty("is_active", bool2);
            }
            Boolean bool3 = this.sampledForReplay;
            if (bool3 != null) {
                jsonObject.addProperty("sampled_for_replay", bool3);
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final ViewEventSession fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String id = jsonObject.get(DiagnosticsEntry.ID_KEY).getAsString();
                    ViewEventSessionType.Companion companion = ViewEventSessionType.Companion;
                    String asString = jsonObject.get("type").getAsString();
                    Intrinsics.checkNotNullExpressionValue(asString, "jsonObject.get(\"type\").asString");
                    ViewEventSessionType viewEventSessionTypeFromJson = companion.fromJson(asString);
                    JsonElement jsonElement = jsonObject.get("has_replay");
                    Boolean boolValueOf = jsonElement != null ? Boolean.valueOf(jsonElement.getAsBoolean()) : null;
                    JsonElement jsonElement2 = jsonObject.get("is_active");
                    Boolean boolValueOf2 = jsonElement2 != null ? Boolean.valueOf(jsonElement2.getAsBoolean()) : null;
                    JsonElement jsonElement3 = jsonObject.get("sampled_for_replay");
                    Boolean boolValueOf3 = jsonElement3 != null ? Boolean.valueOf(jsonElement3.getAsBoolean()) : null;
                    Intrinsics.checkNotNullExpressionValue(id, "id");
                    return new ViewEventSession(id, viewEventSessionTypeFromJson, boolValueOf, boolValueOf2, boolValueOf3);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type ViewEventSession", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type ViewEventSession", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type ViewEventSession", e3);
                }
            }
        }
    }

    public static final class ViewEventView {
        public static final Companion Companion = new Companion(null);
        private final Accessibility accessibility;
        private final Action action;
        private final Number cpuTicksCount;
        private final Number cpuTicksPerSecond;
        private final Crash crash;
        private final Number cumulativeLayoutShift;
        private final String cumulativeLayoutShiftTargetSelector;
        private final Long cumulativeLayoutShiftTime;
        private final CustomTimings customTimings;
        private final Long domComplete;
        private final Long domContentLoaded;
        private final Long domInteractive;
        private final Error error;
        private final Long firstByte;
        private final Long firstContentfulPaint;
        private final Long firstInputDelay;
        private final String firstInputTargetSelector;
        private final Long firstInputTime;
        private final FlutterBuildTime flutterBuildTime;
        private final FlutterBuildTime flutterRasterTime;
        private final Number freezeRate;
        private final FrozenFrame frozenFrame;
        private final Frustration frustration;
        private final String id;
        private final List inForegroundPeriods;
        private final Long interactionToNextPaint;
        private final String interactionToNextPaintTargetSelector;
        private final Long interactionToNextPaintTime;
        private final Long interactionToNextViewTime;
        private final Boolean isActive;
        private final Boolean isSlowRendered;
        private final FlutterBuildTime jsRefreshRate;
        private final Long largestContentfulPaint;
        private final String largestContentfulPaintTargetSelector;
        private final Long loadEvent;
        private final Long loadingTime;
        private final LoadingType loadingType;
        private final LongTask longTask;
        private final Number memoryAverage;
        private final Number memoryMax;
        private String name;
        private final Long networkSettledTime;
        private final Performance performance;
        private String referrer;
        private final Number refreshRateAverage;
        private final Number refreshRateMin;
        private final Resource resource;
        private final List slowFrames;
        private final Number slowFramesRate;
        private final long timeSpent;
        private String url;

        public final ViewEventView copy(String id, String str, String url, String str2, Long l, Long l2, Long l3, LoadingType loadingType, long j, Long l4, Long l5, String str3, Long l6, Long l7, String str4, Long l8, Long l9, String str5, Number number, Long l10, String str6, Long l11, Long l12, Long l13, Long l14, Long l15, CustomTimings customTimings, Boolean bool, Boolean bool2, Action action, Error error, Crash crash, LongTask longTask, FrozenFrame frozenFrame, List list, Resource resource, Frustration frustration, List list2, Number number2, Number number3, Number number4, Number number5, Number number6, Number number7, Number number8, Number number9, FlutterBuildTime flutterBuildTime, FlutterBuildTime flutterBuildTime2, FlutterBuildTime flutterBuildTime3, Performance performance, Accessibility accessibility) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(resource, "resource");
            return new ViewEventView(id, str, url, str2, l, l2, l3, loadingType, j, l4, l5, str3, l6, l7, str4, l8, l9, str5, number, l10, str6, l11, l12, l13, l14, l15, customTimings, bool, bool2, action, error, crash, longTask, frozenFrame, list, resource, frustration, list2, number2, number3, number4, number5, number6, number7, number8, number9, flutterBuildTime, flutterBuildTime2, flutterBuildTime3, performance, accessibility);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ViewEventView)) {
                return false;
            }
            ViewEventView viewEventView = (ViewEventView) obj;
            return Intrinsics.areEqual(this.id, viewEventView.id) && Intrinsics.areEqual(this.referrer, viewEventView.referrer) && Intrinsics.areEqual(this.url, viewEventView.url) && Intrinsics.areEqual(this.name, viewEventView.name) && Intrinsics.areEqual(this.loadingTime, viewEventView.loadingTime) && Intrinsics.areEqual(this.networkSettledTime, viewEventView.networkSettledTime) && Intrinsics.areEqual(this.interactionToNextViewTime, viewEventView.interactionToNextViewTime) && this.loadingType == viewEventView.loadingType && this.timeSpent == viewEventView.timeSpent && Intrinsics.areEqual(this.firstContentfulPaint, viewEventView.firstContentfulPaint) && Intrinsics.areEqual(this.largestContentfulPaint, viewEventView.largestContentfulPaint) && Intrinsics.areEqual(this.largestContentfulPaintTargetSelector, viewEventView.largestContentfulPaintTargetSelector) && Intrinsics.areEqual(this.firstInputDelay, viewEventView.firstInputDelay) && Intrinsics.areEqual(this.firstInputTime, viewEventView.firstInputTime) && Intrinsics.areEqual(this.firstInputTargetSelector, viewEventView.firstInputTargetSelector) && Intrinsics.areEqual(this.interactionToNextPaint, viewEventView.interactionToNextPaint) && Intrinsics.areEqual(this.interactionToNextPaintTime, viewEventView.interactionToNextPaintTime) && Intrinsics.areEqual(this.interactionToNextPaintTargetSelector, viewEventView.interactionToNextPaintTargetSelector) && Intrinsics.areEqual(this.cumulativeLayoutShift, viewEventView.cumulativeLayoutShift) && Intrinsics.areEqual(this.cumulativeLayoutShiftTime, viewEventView.cumulativeLayoutShiftTime) && Intrinsics.areEqual(this.cumulativeLayoutShiftTargetSelector, viewEventView.cumulativeLayoutShiftTargetSelector) && Intrinsics.areEqual(this.domComplete, viewEventView.domComplete) && Intrinsics.areEqual(this.domContentLoaded, viewEventView.domContentLoaded) && Intrinsics.areEqual(this.domInteractive, viewEventView.domInteractive) && Intrinsics.areEqual(this.loadEvent, viewEventView.loadEvent) && Intrinsics.areEqual(this.firstByte, viewEventView.firstByte) && Intrinsics.areEqual(this.customTimings, viewEventView.customTimings) && Intrinsics.areEqual(this.isActive, viewEventView.isActive) && Intrinsics.areEqual(this.isSlowRendered, viewEventView.isSlowRendered) && Intrinsics.areEqual(this.action, viewEventView.action) && Intrinsics.areEqual(this.error, viewEventView.error) && Intrinsics.areEqual(this.crash, viewEventView.crash) && Intrinsics.areEqual(this.longTask, viewEventView.longTask) && Intrinsics.areEqual(this.frozenFrame, viewEventView.frozenFrame) && Intrinsics.areEqual(this.slowFrames, viewEventView.slowFrames) && Intrinsics.areEqual(this.resource, viewEventView.resource) && Intrinsics.areEqual(this.frustration, viewEventView.frustration) && Intrinsics.areEqual(this.inForegroundPeriods, viewEventView.inForegroundPeriods) && Intrinsics.areEqual(this.memoryAverage, viewEventView.memoryAverage) && Intrinsics.areEqual(this.memoryMax, viewEventView.memoryMax) && Intrinsics.areEqual(this.cpuTicksCount, viewEventView.cpuTicksCount) && Intrinsics.areEqual(this.cpuTicksPerSecond, viewEventView.cpuTicksPerSecond) && Intrinsics.areEqual(this.refreshRateAverage, viewEventView.refreshRateAverage) && Intrinsics.areEqual(this.refreshRateMin, viewEventView.refreshRateMin) && Intrinsics.areEqual(this.slowFramesRate, viewEventView.slowFramesRate) && Intrinsics.areEqual(this.freezeRate, viewEventView.freezeRate) && Intrinsics.areEqual(this.flutterBuildTime, viewEventView.flutterBuildTime) && Intrinsics.areEqual(this.flutterRasterTime, viewEventView.flutterRasterTime) && Intrinsics.areEqual(this.jsRefreshRate, viewEventView.jsRefreshRate) && Intrinsics.areEqual(this.performance, viewEventView.performance) && Intrinsics.areEqual(this.accessibility, viewEventView.accessibility);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.referrer;
            int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.url.hashCode()) * 31;
            String str2 = this.name;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Long l = this.loadingTime;
            int iHashCode4 = (iHashCode3 + (l == null ? 0 : l.hashCode())) * 31;
            Long l2 = this.networkSettledTime;
            int iHashCode5 = (iHashCode4 + (l2 == null ? 0 : l2.hashCode())) * 31;
            Long l3 = this.interactionToNextViewTime;
            int iHashCode6 = (iHashCode5 + (l3 == null ? 0 : l3.hashCode())) * 31;
            LoadingType loadingType = this.loadingType;
            int iHashCode7 = (((iHashCode6 + (loadingType == null ? 0 : loadingType.hashCode())) * 31) + Long.hashCode(this.timeSpent)) * 31;
            Long l4 = this.firstContentfulPaint;
            int iHashCode8 = (iHashCode7 + (l4 == null ? 0 : l4.hashCode())) * 31;
            Long l5 = this.largestContentfulPaint;
            int iHashCode9 = (iHashCode8 + (l5 == null ? 0 : l5.hashCode())) * 31;
            String str3 = this.largestContentfulPaintTargetSelector;
            int iHashCode10 = (iHashCode9 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Long l6 = this.firstInputDelay;
            int iHashCode11 = (iHashCode10 + (l6 == null ? 0 : l6.hashCode())) * 31;
            Long l7 = this.firstInputTime;
            int iHashCode12 = (iHashCode11 + (l7 == null ? 0 : l7.hashCode())) * 31;
            String str4 = this.firstInputTargetSelector;
            int iHashCode13 = (iHashCode12 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Long l8 = this.interactionToNextPaint;
            int iHashCode14 = (iHashCode13 + (l8 == null ? 0 : l8.hashCode())) * 31;
            Long l9 = this.interactionToNextPaintTime;
            int iHashCode15 = (iHashCode14 + (l9 == null ? 0 : l9.hashCode())) * 31;
            String str5 = this.interactionToNextPaintTargetSelector;
            int iHashCode16 = (iHashCode15 + (str5 == null ? 0 : str5.hashCode())) * 31;
            Number number = this.cumulativeLayoutShift;
            int iHashCode17 = (iHashCode16 + (number == null ? 0 : number.hashCode())) * 31;
            Long l10 = this.cumulativeLayoutShiftTime;
            int iHashCode18 = (iHashCode17 + (l10 == null ? 0 : l10.hashCode())) * 31;
            String str6 = this.cumulativeLayoutShiftTargetSelector;
            int iHashCode19 = (iHashCode18 + (str6 == null ? 0 : str6.hashCode())) * 31;
            Long l11 = this.domComplete;
            int iHashCode20 = (iHashCode19 + (l11 == null ? 0 : l11.hashCode())) * 31;
            Long l12 = this.domContentLoaded;
            int iHashCode21 = (iHashCode20 + (l12 == null ? 0 : l12.hashCode())) * 31;
            Long l13 = this.domInteractive;
            int iHashCode22 = (iHashCode21 + (l13 == null ? 0 : l13.hashCode())) * 31;
            Long l14 = this.loadEvent;
            int iHashCode23 = (iHashCode22 + (l14 == null ? 0 : l14.hashCode())) * 31;
            Long l15 = this.firstByte;
            int iHashCode24 = (iHashCode23 + (l15 == null ? 0 : l15.hashCode())) * 31;
            CustomTimings customTimings = this.customTimings;
            int iHashCode25 = (iHashCode24 + (customTimings == null ? 0 : customTimings.hashCode())) * 31;
            Boolean bool = this.isActive;
            int iHashCode26 = (iHashCode25 + (bool == null ? 0 : bool.hashCode())) * 31;
            Boolean bool2 = this.isSlowRendered;
            int iHashCode27 = (((((iHashCode26 + (bool2 == null ? 0 : bool2.hashCode())) * 31) + this.action.hashCode()) * 31) + this.error.hashCode()) * 31;
            Crash crash = this.crash;
            int iHashCode28 = (iHashCode27 + (crash == null ? 0 : crash.hashCode())) * 31;
            LongTask longTask = this.longTask;
            int iHashCode29 = (iHashCode28 + (longTask == null ? 0 : longTask.hashCode())) * 31;
            FrozenFrame frozenFrame = this.frozenFrame;
            int iHashCode30 = (iHashCode29 + (frozenFrame == null ? 0 : frozenFrame.hashCode())) * 31;
            List list = this.slowFrames;
            int iHashCode31 = (((iHashCode30 + (list == null ? 0 : list.hashCode())) * 31) + this.resource.hashCode()) * 31;
            Frustration frustration = this.frustration;
            int iHashCode32 = (iHashCode31 + (frustration == null ? 0 : frustration.hashCode())) * 31;
            List list2 = this.inForegroundPeriods;
            int iHashCode33 = (iHashCode32 + (list2 == null ? 0 : list2.hashCode())) * 31;
            Number number2 = this.memoryAverage;
            int iHashCode34 = (iHashCode33 + (number2 == null ? 0 : number2.hashCode())) * 31;
            Number number3 = this.memoryMax;
            int iHashCode35 = (iHashCode34 + (number3 == null ? 0 : number3.hashCode())) * 31;
            Number number4 = this.cpuTicksCount;
            int iHashCode36 = (iHashCode35 + (number4 == null ? 0 : number4.hashCode())) * 31;
            Number number5 = this.cpuTicksPerSecond;
            int iHashCode37 = (iHashCode36 + (number5 == null ? 0 : number5.hashCode())) * 31;
            Number number6 = this.refreshRateAverage;
            int iHashCode38 = (iHashCode37 + (number6 == null ? 0 : number6.hashCode())) * 31;
            Number number7 = this.refreshRateMin;
            int iHashCode39 = (iHashCode38 + (number7 == null ? 0 : number7.hashCode())) * 31;
            Number number8 = this.slowFramesRate;
            int iHashCode40 = (iHashCode39 + (number8 == null ? 0 : number8.hashCode())) * 31;
            Number number9 = this.freezeRate;
            int iHashCode41 = (iHashCode40 + (number9 == null ? 0 : number9.hashCode())) * 31;
            FlutterBuildTime flutterBuildTime = this.flutterBuildTime;
            int iHashCode42 = (iHashCode41 + (flutterBuildTime == null ? 0 : flutterBuildTime.hashCode())) * 31;
            FlutterBuildTime flutterBuildTime2 = this.flutterRasterTime;
            int iHashCode43 = (iHashCode42 + (flutterBuildTime2 == null ? 0 : flutterBuildTime2.hashCode())) * 31;
            FlutterBuildTime flutterBuildTime3 = this.jsRefreshRate;
            int iHashCode44 = (iHashCode43 + (flutterBuildTime3 == null ? 0 : flutterBuildTime3.hashCode())) * 31;
            Performance performance = this.performance;
            int iHashCode45 = (iHashCode44 + (performance == null ? 0 : performance.hashCode())) * 31;
            Accessibility accessibility = this.accessibility;
            return iHashCode45 + (accessibility != null ? accessibility.hashCode() : 0);
        }

        public String toString() {
            return "ViewEventView(id=" + this.id + ", referrer=" + this.referrer + ", url=" + this.url + ", name=" + this.name + ", loadingTime=" + this.loadingTime + ", networkSettledTime=" + this.networkSettledTime + ", interactionToNextViewTime=" + this.interactionToNextViewTime + ", loadingType=" + this.loadingType + ", timeSpent=" + this.timeSpent + ", firstContentfulPaint=" + this.firstContentfulPaint + ", largestContentfulPaint=" + this.largestContentfulPaint + ", largestContentfulPaintTargetSelector=" + this.largestContentfulPaintTargetSelector + ", firstInputDelay=" + this.firstInputDelay + ", firstInputTime=" + this.firstInputTime + ", firstInputTargetSelector=" + this.firstInputTargetSelector + ", interactionToNextPaint=" + this.interactionToNextPaint + ", interactionToNextPaintTime=" + this.interactionToNextPaintTime + ", interactionToNextPaintTargetSelector=" + this.interactionToNextPaintTargetSelector + ", cumulativeLayoutShift=" + this.cumulativeLayoutShift + ", cumulativeLayoutShiftTime=" + this.cumulativeLayoutShiftTime + ", cumulativeLayoutShiftTargetSelector=" + this.cumulativeLayoutShiftTargetSelector + ", domComplete=" + this.domComplete + ", domContentLoaded=" + this.domContentLoaded + ", domInteractive=" + this.domInteractive + ", loadEvent=" + this.loadEvent + ", firstByte=" + this.firstByte + ", customTimings=" + this.customTimings + ", isActive=" + this.isActive + ", isSlowRendered=" + this.isSlowRendered + ", action=" + this.action + ", error=" + this.error + ", crash=" + this.crash + ", longTask=" + this.longTask + ", frozenFrame=" + this.frozenFrame + ", slowFrames=" + this.slowFrames + ", resource=" + this.resource + ", frustration=" + this.frustration + ", inForegroundPeriods=" + this.inForegroundPeriods + ", memoryAverage=" + this.memoryAverage + ", memoryMax=" + this.memoryMax + ", cpuTicksCount=" + this.cpuTicksCount + ", cpuTicksPerSecond=" + this.cpuTicksPerSecond + ", refreshRateAverage=" + this.refreshRateAverage + ", refreshRateMin=" + this.refreshRateMin + ", slowFramesRate=" + this.slowFramesRate + ", freezeRate=" + this.freezeRate + ", flutterBuildTime=" + this.flutterBuildTime + ", flutterRasterTime=" + this.flutterRasterTime + ", jsRefreshRate=" + this.jsRefreshRate + ", performance=" + this.performance + ", accessibility=" + this.accessibility + ")";
        }

        public ViewEventView(String id, String str, String url, String str2, Long l, Long l2, Long l3, LoadingType loadingType, long j, Long l4, Long l5, String str3, Long l6, Long l7, String str4, Long l8, Long l9, String str5, Number number, Long l10, String str6, Long l11, Long l12, Long l13, Long l14, Long l15, CustomTimings customTimings, Boolean bool, Boolean bool2, Action action, Error error, Crash crash, LongTask longTask, FrozenFrame frozenFrame, List list, Resource resource, Frustration frustration, List list2, Number number2, Number number3, Number number4, Number number5, Number number6, Number number7, Number number8, Number number9, FlutterBuildTime flutterBuildTime, FlutterBuildTime flutterBuildTime2, FlutterBuildTime flutterBuildTime3, Performance performance, Accessibility accessibility) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(resource, "resource");
            this.id = id;
            this.referrer = str;
            this.url = url;
            this.name = str2;
            this.loadingTime = l;
            this.networkSettledTime = l2;
            this.interactionToNextViewTime = l3;
            this.loadingType = loadingType;
            this.timeSpent = j;
            this.firstContentfulPaint = l4;
            this.largestContentfulPaint = l5;
            this.largestContentfulPaintTargetSelector = str3;
            this.firstInputDelay = l6;
            this.firstInputTime = l7;
            this.firstInputTargetSelector = str4;
            this.interactionToNextPaint = l8;
            this.interactionToNextPaintTime = l9;
            this.interactionToNextPaintTargetSelector = str5;
            this.cumulativeLayoutShift = number;
            this.cumulativeLayoutShiftTime = l10;
            this.cumulativeLayoutShiftTargetSelector = str6;
            this.domComplete = l11;
            this.domContentLoaded = l12;
            this.domInteractive = l13;
            this.loadEvent = l14;
            this.firstByte = l15;
            this.customTimings = customTimings;
            this.isActive = bool;
            this.isSlowRendered = bool2;
            this.action = action;
            this.error = error;
            this.crash = crash;
            this.longTask = longTask;
            this.frozenFrame = frozenFrame;
            this.slowFrames = list;
            this.resource = resource;
            this.frustration = frustration;
            this.inForegroundPeriods = list2;
            this.memoryAverage = number2;
            this.memoryMax = number3;
            this.cpuTicksCount = number4;
            this.cpuTicksPerSecond = number5;
            this.refreshRateAverage = number6;
            this.refreshRateMin = number7;
            this.slowFramesRate = number8;
            this.freezeRate = number9;
            this.flutterBuildTime = flutterBuildTime;
            this.flutterRasterTime = flutterBuildTime2;
            this.jsRefreshRate = flutterBuildTime3;
            this.performance = performance;
            this.accessibility = accessibility;
        }

        public /* synthetic */ ViewEventView(String str, String str2, String str3, String str4, Long l, Long l2, Long l3, LoadingType loadingType, long j, Long l4, Long l5, String str5, Long l6, Long l7, String str6, Long l8, Long l9, String str7, Number number, Long l10, String str8, Long l11, Long l12, Long l13, Long l14, Long l15, CustomTimings customTimings, Boolean bool, Boolean bool2, Action action, Error error, Crash crash, LongTask longTask, FrozenFrame frozenFrame, List list, Resource resource, Frustration frustration, List list2, Number number2, Number number3, Number number4, Number number5, Number number6, Number number7, Number number8, Number number9, FlutterBuildTime flutterBuildTime, FlutterBuildTime flutterBuildTime2, FlutterBuildTime flutterBuildTime3, Performance performance, Accessibility accessibility, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2, str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : l, (i & 32) != 0 ? null : l2, (i & 64) != 0 ? null : l3, (i & 128) != 0 ? null : loadingType, j, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? null : l4, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : l5, (i & 2048) != 0 ? null : str5, (i & 4096) != 0 ? null : l6, (i & 8192) != 0 ? null : l7, (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? null : str6, (i & 32768) != 0 ? null : l8, (i & 65536) != 0 ? null : l9, (i & 131072) != 0 ? null : str7, (i & 262144) != 0 ? null : number, (524288 & i) != 0 ? null : l10, (1048576 & i) != 0 ? null : str8, (2097152 & i) != 0 ? null : l11, (4194304 & i) != 0 ? null : l12, (8388608 & i) != 0 ? null : l13, (16777216 & i) != 0 ? null : l14, (33554432 & i) != 0 ? null : l15, (67108864 & i) != 0 ? null : customTimings, (134217728 & i) != 0 ? null : bool, (268435456 & i) != 0 ? null : bool2, action, error, (i & LinearLayoutManager.INVALID_OFFSET) != 0 ? null : crash, (i2 & 1) != 0 ? null : longTask, (i2 & 2) != 0 ? null : frozenFrame, (i2 & 4) != 0 ? null : list, resource, (i2 & 16) != 0 ? null : frustration, (i2 & 32) != 0 ? null : list2, (i2 & 64) != 0 ? null : number2, (i2 & 128) != 0 ? null : number3, (i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : number4, (i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? null : number5, (i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : number6, (i2 & 2048) != 0 ? null : number7, (i2 & 4096) != 0 ? null : number8, (i2 & 8192) != 0 ? null : number9, (i2 & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? null : flutterBuildTime, (i2 & 32768) != 0 ? null : flutterBuildTime2, (i2 & 65536) != 0 ? null : flutterBuildTime3, (i2 & 131072) != 0 ? null : performance, (i2 & 262144) != 0 ? null : accessibility);
        }

        public final String getId() {
            return this.id;
        }

        public final String getReferrer() {
            return this.referrer;
        }

        public final String getUrl() {
            return this.url;
        }

        public final String getName() {
            return this.name;
        }

        public final long getTimeSpent() {
            return this.timeSpent;
        }

        public final CustomTimings getCustomTimings() {
            return this.customTimings;
        }

        public final Crash getCrash() {
            return this.crash;
        }

        public final Accessibility getAccessibility() {
            return this.accessibility;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(DiagnosticsEntry.ID_KEY, this.id);
            String str = this.referrer;
            if (str != null) {
                jsonObject.addProperty(com.adjust.sdk.Constants.REFERRER, str);
            }
            jsonObject.addProperty("url", this.url);
            String str2 = this.name;
            if (str2 != null) {
                jsonObject.addProperty("name", str2);
            }
            Long l = this.loadingTime;
            if (l != null) {
                jsonObject.addProperty("loading_time", Long.valueOf(l.longValue()));
            }
            Long l2 = this.networkSettledTime;
            if (l2 != null) {
                jsonObject.addProperty("network_settled_time", Long.valueOf(l2.longValue()));
            }
            Long l3 = this.interactionToNextViewTime;
            if (l3 != null) {
                jsonObject.addProperty("interaction_to_next_view_time", Long.valueOf(l3.longValue()));
            }
            LoadingType loadingType = this.loadingType;
            if (loadingType != null) {
                jsonObject.add("loading_type", loadingType.toJson());
            }
            jsonObject.addProperty("time_spent", Long.valueOf(this.timeSpent));
            Long l4 = this.firstContentfulPaint;
            if (l4 != null) {
                jsonObject.addProperty("first_contentful_paint", Long.valueOf(l4.longValue()));
            }
            Long l5 = this.largestContentfulPaint;
            if (l5 != null) {
                jsonObject.addProperty("largest_contentful_paint", Long.valueOf(l5.longValue()));
            }
            String str3 = this.largestContentfulPaintTargetSelector;
            if (str3 != null) {
                jsonObject.addProperty("largest_contentful_paint_target_selector", str3);
            }
            Long l6 = this.firstInputDelay;
            if (l6 != null) {
                jsonObject.addProperty("first_input_delay", Long.valueOf(l6.longValue()));
            }
            Long l7 = this.firstInputTime;
            if (l7 != null) {
                jsonObject.addProperty("first_input_time", Long.valueOf(l7.longValue()));
            }
            String str4 = this.firstInputTargetSelector;
            if (str4 != null) {
                jsonObject.addProperty("first_input_target_selector", str4);
            }
            Long l8 = this.interactionToNextPaint;
            if (l8 != null) {
                jsonObject.addProperty("interaction_to_next_paint", Long.valueOf(l8.longValue()));
            }
            Long l9 = this.interactionToNextPaintTime;
            if (l9 != null) {
                jsonObject.addProperty("interaction_to_next_paint_time", Long.valueOf(l9.longValue()));
            }
            String str5 = this.interactionToNextPaintTargetSelector;
            if (str5 != null) {
                jsonObject.addProperty("interaction_to_next_paint_target_selector", str5);
            }
            Number number = this.cumulativeLayoutShift;
            if (number != null) {
                jsonObject.addProperty("cumulative_layout_shift", number);
            }
            Long l10 = this.cumulativeLayoutShiftTime;
            if (l10 != null) {
                jsonObject.addProperty("cumulative_layout_shift_time", Long.valueOf(l10.longValue()));
            }
            String str6 = this.cumulativeLayoutShiftTargetSelector;
            if (str6 != null) {
                jsonObject.addProperty("cumulative_layout_shift_target_selector", str6);
            }
            Long l11 = this.domComplete;
            if (l11 != null) {
                jsonObject.addProperty("dom_complete", Long.valueOf(l11.longValue()));
            }
            Long l12 = this.domContentLoaded;
            if (l12 != null) {
                jsonObject.addProperty("dom_content_loaded", Long.valueOf(l12.longValue()));
            }
            Long l13 = this.domInteractive;
            if (l13 != null) {
                jsonObject.addProperty("dom_interactive", Long.valueOf(l13.longValue()));
            }
            Long l14 = this.loadEvent;
            if (l14 != null) {
                jsonObject.addProperty("load_event", Long.valueOf(l14.longValue()));
            }
            Long l15 = this.firstByte;
            if (l15 != null) {
                jsonObject.addProperty("first_byte", Long.valueOf(l15.longValue()));
            }
            CustomTimings customTimings = this.customTimings;
            if (customTimings != null) {
                jsonObject.add("custom_timings", customTimings.toJson());
            }
            Boolean bool = this.isActive;
            if (bool != null) {
                jsonObject.addProperty("is_active", bool);
            }
            Boolean bool2 = this.isSlowRendered;
            if (bool2 != null) {
                jsonObject.addProperty("is_slow_rendered", bool2);
            }
            jsonObject.add("action", this.action.toJson());
            jsonObject.add("error", this.error.toJson());
            Crash crash = this.crash;
            if (crash != null) {
                jsonObject.add("crash", crash.toJson());
            }
            LongTask longTask = this.longTask;
            if (longTask != null) {
                jsonObject.add("long_task", longTask.toJson());
            }
            FrozenFrame frozenFrame = this.frozenFrame;
            if (frozenFrame != null) {
                jsonObject.add("frozen_frame", frozenFrame.toJson());
            }
            List list = this.slowFrames;
            if (list != null) {
                JsonArray jsonArray = new JsonArray(list.size());
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    jsonArray.add(((SlowFrame) it.next()).toJson());
                }
                jsonObject.add("slow_frames", jsonArray);
            }
            jsonObject.add("resource", this.resource.toJson());
            Frustration frustration = this.frustration;
            if (frustration != null) {
                jsonObject.add("frustration", frustration.toJson());
            }
            List list2 = this.inForegroundPeriods;
            if (list2 != null) {
                JsonArray jsonArray2 = new JsonArray(list2.size());
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    jsonArray2.add(((InForegroundPeriod) it2.next()).toJson());
                }
                jsonObject.add("in_foreground_periods", jsonArray2);
            }
            Number number2 = this.memoryAverage;
            if (number2 != null) {
                jsonObject.addProperty("memory_average", number2);
            }
            Number number3 = this.memoryMax;
            if (number3 != null) {
                jsonObject.addProperty("memory_max", number3);
            }
            Number number4 = this.cpuTicksCount;
            if (number4 != null) {
                jsonObject.addProperty("cpu_ticks_count", number4);
            }
            Number number5 = this.cpuTicksPerSecond;
            if (number5 != null) {
                jsonObject.addProperty("cpu_ticks_per_second", number5);
            }
            Number number6 = this.refreshRateAverage;
            if (number6 != null) {
                jsonObject.addProperty("refresh_rate_average", number6);
            }
            Number number7 = this.refreshRateMin;
            if (number7 != null) {
                jsonObject.addProperty("refresh_rate_min", number7);
            }
            Number number8 = this.slowFramesRate;
            if (number8 != null) {
                jsonObject.addProperty("slow_frames_rate", number8);
            }
            Number number9 = this.freezeRate;
            if (number9 != null) {
                jsonObject.addProperty("freeze_rate", number9);
            }
            FlutterBuildTime flutterBuildTime = this.flutterBuildTime;
            if (flutterBuildTime != null) {
                jsonObject.add("flutter_build_time", flutterBuildTime.toJson());
            }
            FlutterBuildTime flutterBuildTime2 = this.flutterRasterTime;
            if (flutterBuildTime2 != null) {
                jsonObject.add("flutter_raster_time", flutterBuildTime2.toJson());
            }
            FlutterBuildTime flutterBuildTime3 = this.jsRefreshRate;
            if (flutterBuildTime3 != null) {
                jsonObject.add("js_refresh_rate", flutterBuildTime3.toJson());
            }
            Performance performance = this.performance;
            if (performance != null) {
                jsonObject.add("performance", performance.toJson());
            }
            Accessibility accessibility = this.accessibility;
            if (accessibility != null) {
                jsonObject.add("accessibility", accessibility.toJson());
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final ViewEventView fromJsonObject(JsonObject jsonObject) {
                String str;
                ArrayList arrayList;
                ArrayList arrayList2;
                JsonObject asJsonObject;
                JsonObject asJsonObject2;
                JsonObject asJsonObject3;
                JsonObject asJsonObject4;
                JsonObject asJsonObject5;
                JsonArray asJsonArray;
                JsonObject asJsonObject6;
                JsonArray asJsonArray2;
                JsonObject asJsonObject7;
                JsonObject asJsonObject8;
                JsonObject asJsonObject9;
                JsonObject asJsonObject10;
                String asString;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String id = jsonObject.get(DiagnosticsEntry.ID_KEY).getAsString();
                    JsonElement jsonElement = jsonObject.get(com.adjust.sdk.Constants.REFERRER);
                    String asString2 = jsonElement != null ? jsonElement.getAsString() : null;
                    String url = jsonObject.get("url").getAsString();
                    JsonElement jsonElement2 = jsonObject.get("name");
                    String asString3 = jsonElement2 != null ? jsonElement2.getAsString() : null;
                    JsonElement jsonElement3 = jsonObject.get("loading_time");
                    Long lValueOf = jsonElement3 != null ? Long.valueOf(jsonElement3.getAsLong()) : null;
                    JsonElement jsonElement4 = jsonObject.get("network_settled_time");
                    Long lValueOf2 = jsonElement4 != null ? Long.valueOf(jsonElement4.getAsLong()) : null;
                    JsonElement jsonElement5 = jsonObject.get("interaction_to_next_view_time");
                    Long lValueOf3 = jsonElement5 != null ? Long.valueOf(jsonElement5.getAsLong()) : null;
                    JsonElement jsonElement6 = jsonObject.get("loading_type");
                    LoadingType loadingTypeFromJson = (jsonElement6 == null || (asString = jsonElement6.getAsString()) == null) ? null : LoadingType.Companion.fromJson(asString);
                    long asLong = jsonObject.get("time_spent").getAsLong();
                    JsonElement jsonElement7 = jsonObject.get("first_contentful_paint");
                    Long lValueOf4 = jsonElement7 != null ? Long.valueOf(jsonElement7.getAsLong()) : null;
                    JsonElement jsonElement8 = jsonObject.get("largest_contentful_paint");
                    Long lValueOf5 = jsonElement8 != null ? Long.valueOf(jsonElement8.getAsLong()) : null;
                    JsonElement jsonElement9 = jsonObject.get("largest_contentful_paint_target_selector");
                    String asString4 = jsonElement9 != null ? jsonElement9.getAsString() : null;
                    JsonElement jsonElement10 = jsonObject.get("first_input_delay");
                    Long lValueOf6 = jsonElement10 != null ? Long.valueOf(jsonElement10.getAsLong()) : null;
                    JsonElement jsonElement11 = jsonObject.get("first_input_time");
                    Long lValueOf7 = jsonElement11 != null ? Long.valueOf(jsonElement11.getAsLong()) : null;
                    JsonElement jsonElement12 = jsonObject.get("first_input_target_selector");
                    String asString5 = jsonElement12 != null ? jsonElement12.getAsString() : null;
                    JsonElement jsonElement13 = jsonObject.get("interaction_to_next_paint");
                    Long lValueOf8 = jsonElement13 != null ? Long.valueOf(jsonElement13.getAsLong()) : null;
                    JsonElement jsonElement14 = jsonObject.get("interaction_to_next_paint_time");
                    Long lValueOf9 = jsonElement14 != null ? Long.valueOf(jsonElement14.getAsLong()) : null;
                    JsonElement jsonElement15 = jsonObject.get("interaction_to_next_paint_target_selector");
                    String asString6 = jsonElement15 != null ? jsonElement15.getAsString() : null;
                    JsonElement jsonElement16 = jsonObject.get("cumulative_layout_shift");
                    Number asNumber = jsonElement16 != null ? jsonElement16.getAsNumber() : null;
                    JsonElement jsonElement17 = jsonObject.get("cumulative_layout_shift_time");
                    Long lValueOf10 = jsonElement17 != null ? Long.valueOf(jsonElement17.getAsLong()) : null;
                    JsonElement jsonElement18 = jsonObject.get("cumulative_layout_shift_target_selector");
                    String asString7 = jsonElement18 != null ? jsonElement18.getAsString() : null;
                    JsonElement jsonElement19 = jsonObject.get("dom_complete");
                    Long lValueOf11 = jsonElement19 != null ? Long.valueOf(jsonElement19.getAsLong()) : null;
                    JsonElement jsonElement20 = jsonObject.get("dom_content_loaded");
                    Long lValueOf12 = jsonElement20 != null ? Long.valueOf(jsonElement20.getAsLong()) : null;
                    JsonElement jsonElement21 = jsonObject.get("dom_interactive");
                    Long lValueOf13 = jsonElement21 != null ? Long.valueOf(jsonElement21.getAsLong()) : null;
                    JsonElement jsonElement22 = jsonObject.get("load_event");
                    Long lValueOf14 = jsonElement22 != null ? Long.valueOf(jsonElement22.getAsLong()) : null;
                    JsonElement jsonElement23 = jsonObject.get("first_byte");
                    Long lValueOf15 = jsonElement23 != null ? Long.valueOf(jsonElement23.getAsLong()) : null;
                    JsonElement jsonElement24 = jsonObject.get("custom_timings");
                    CustomTimings customTimingsFromJsonObject = (jsonElement24 == null || (asJsonObject10 = jsonElement24.getAsJsonObject()) == null) ? null : CustomTimings.Companion.fromJsonObject(asJsonObject10);
                    JsonElement jsonElement25 = jsonObject.get("is_active");
                    Boolean boolValueOf = jsonElement25 != null ? Boolean.valueOf(jsonElement25.getAsBoolean()) : null;
                    JsonElement jsonElement26 = jsonObject.get("is_slow_rendered");
                    Boolean boolValueOf2 = jsonElement26 != null ? Boolean.valueOf(jsonElement26.getAsBoolean()) : null;
                    JsonObject it = jsonObject.get("action").getAsJsonObject();
                    CustomTimings customTimings = customTimingsFromJsonObject;
                    Action.Companion companion = Action.Companion;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    Action actionFromJsonObject = companion.fromJsonObject(it);
                    JsonObject it2 = jsonObject.get("error").getAsJsonObject();
                    Error.Companion companion2 = Error.Companion;
                    Intrinsics.checkNotNullExpressionValue(it2, "it");
                    Error errorFromJsonObject = companion2.fromJsonObject(it2);
                    JsonElement jsonElement27 = jsonObject.get("crash");
                    Crash crashFromJsonObject = (jsonElement27 == null || (asJsonObject9 = jsonElement27.getAsJsonObject()) == null) ? null : Crash.Companion.fromJsonObject(asJsonObject9);
                    JsonElement jsonElement28 = jsonObject.get("long_task");
                    LongTask longTaskFromJsonObject = (jsonElement28 == null || (asJsonObject8 = jsonElement28.getAsJsonObject()) == null) ? null : LongTask.Companion.fromJsonObject(asJsonObject8);
                    JsonElement jsonElement29 = jsonObject.get("frozen_frame");
                    FrozenFrame frozenFrameFromJsonObject = (jsonElement29 == null || (asJsonObject7 = jsonElement29.getAsJsonObject()) == null) ? null : FrozenFrame.Companion.fromJsonObject(asJsonObject7);
                    JsonElement jsonElement30 = jsonObject.get("slow_frames");
                    FrozenFrame frozenFrame = frozenFrameFromJsonObject;
                    if (jsonElement30 == null || (asJsonArray2 = jsonElement30.getAsJsonArray()) == null) {
                        str = asString3;
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(asJsonArray2.size());
                        Iterator it3 = asJsonArray2.iterator();
                        while (it3.hasNext()) {
                            JsonElement jsonElement31 = (JsonElement) it3.next();
                            Iterator it4 = it3;
                            SlowFrame.Companion companion3 = SlowFrame.Companion;
                            String str2 = asString3;
                            JsonObject asJsonObject11 = jsonElement31.getAsJsonObject();
                            Intrinsics.checkNotNullExpressionValue(asJsonObject11, "it.asJsonObject");
                            arrayList.add(companion3.fromJsonObject(asJsonObject11));
                            it3 = it4;
                            asString3 = str2;
                        }
                        str = asString3;
                    }
                    JsonObject it5 = jsonObject.get("resource").getAsJsonObject();
                    Resource.Companion companion4 = Resource.Companion;
                    Intrinsics.checkNotNullExpressionValue(it5, "it");
                    Resource resourceFromJsonObject = companion4.fromJsonObject(it5);
                    JsonElement jsonElement32 = jsonObject.get("frustration");
                    Frustration frustrationFromJsonObject = (jsonElement32 == null || (asJsonObject6 = jsonElement32.getAsJsonObject()) == null) ? null : Frustration.Companion.fromJsonObject(asJsonObject6);
                    JsonElement jsonElement33 = jsonObject.get("in_foreground_periods");
                    if (jsonElement33 == null || (asJsonArray = jsonElement33.getAsJsonArray()) == null) {
                        arrayList2 = null;
                    } else {
                        arrayList2 = new ArrayList(asJsonArray.size());
                        Iterator it6 = asJsonArray.iterator();
                        while (it6.hasNext()) {
                            JsonElement jsonElement34 = (JsonElement) it6.next();
                            Iterator it7 = it6;
                            InForegroundPeriod.Companion companion5 = InForegroundPeriod.Companion;
                            JsonObject asJsonObject12 = jsonElement34.getAsJsonObject();
                            Intrinsics.checkNotNullExpressionValue(asJsonObject12, "it.asJsonObject");
                            arrayList2.add(companion5.fromJsonObject(asJsonObject12));
                            it6 = it7;
                        }
                    }
                    JsonElement jsonElement35 = jsonObject.get("memory_average");
                    Number asNumber2 = jsonElement35 != null ? jsonElement35.getAsNumber() : null;
                    JsonElement jsonElement36 = jsonObject.get("memory_max");
                    Number asNumber3 = jsonElement36 != null ? jsonElement36.getAsNumber() : null;
                    JsonElement jsonElement37 = jsonObject.get("cpu_ticks_count");
                    Number asNumber4 = jsonElement37 != null ? jsonElement37.getAsNumber() : null;
                    JsonElement jsonElement38 = jsonObject.get("cpu_ticks_per_second");
                    Number asNumber5 = jsonElement38 != null ? jsonElement38.getAsNumber() : null;
                    JsonElement jsonElement39 = jsonObject.get("refresh_rate_average");
                    Number asNumber6 = jsonElement39 != null ? jsonElement39.getAsNumber() : null;
                    JsonElement jsonElement40 = jsonObject.get("refresh_rate_min");
                    Number asNumber7 = jsonElement40 != null ? jsonElement40.getAsNumber() : null;
                    JsonElement jsonElement41 = jsonObject.get("slow_frames_rate");
                    Number asNumber8 = jsonElement41 != null ? jsonElement41.getAsNumber() : null;
                    JsonElement jsonElement42 = jsonObject.get("freeze_rate");
                    Number asNumber9 = jsonElement42 != null ? jsonElement42.getAsNumber() : null;
                    JsonElement jsonElement43 = jsonObject.get("flutter_build_time");
                    FlutterBuildTime flutterBuildTimeFromJsonObject = (jsonElement43 == null || (asJsonObject5 = jsonElement43.getAsJsonObject()) == null) ? null : FlutterBuildTime.Companion.fromJsonObject(asJsonObject5);
                    JsonElement jsonElement44 = jsonObject.get("flutter_raster_time");
                    FlutterBuildTime flutterBuildTimeFromJsonObject2 = (jsonElement44 == null || (asJsonObject4 = jsonElement44.getAsJsonObject()) == null) ? null : FlutterBuildTime.Companion.fromJsonObject(asJsonObject4);
                    JsonElement jsonElement45 = jsonObject.get("js_refresh_rate");
                    FlutterBuildTime flutterBuildTimeFromJsonObject3 = (jsonElement45 == null || (asJsonObject3 = jsonElement45.getAsJsonObject()) == null) ? null : FlutterBuildTime.Companion.fromJsonObject(asJsonObject3);
                    JsonElement jsonElement46 = jsonObject.get("performance");
                    Performance performanceFromJsonObject = (jsonElement46 == null || (asJsonObject2 = jsonElement46.getAsJsonObject()) == null) ? null : Performance.Companion.fromJsonObject(asJsonObject2);
                    JsonElement jsonElement47 = jsonObject.get("accessibility");
                    Accessibility accessibilityFromJsonObject = (jsonElement47 == null || (asJsonObject = jsonElement47.getAsJsonObject()) == null) ? null : Accessibility.Companion.fromJsonObject(asJsonObject);
                    Crash crash = crashFromJsonObject;
                    LongTask longTask = longTaskFromJsonObject;
                    ArrayList arrayList3 = arrayList;
                    Intrinsics.checkNotNullExpressionValue(id, "id");
                    Intrinsics.checkNotNullExpressionValue(url, "url");
                    return new ViewEventView(id, asString2, url, str, lValueOf, lValueOf2, lValueOf3, loadingTypeFromJson, asLong, lValueOf4, lValueOf5, asString4, lValueOf6, lValueOf7, asString5, lValueOf8, lValueOf9, asString6, asNumber, lValueOf10, asString7, lValueOf11, lValueOf12, lValueOf13, lValueOf14, lValueOf15, customTimings, boolValueOf, boolValueOf2, actionFromJsonObject, errorFromJsonObject, crash, longTask, frozenFrame, arrayList3, resourceFromJsonObject, frustrationFromJsonObject, arrayList2, asNumber2, asNumber3, asNumber4, asNumber5, asNumber6, asNumber7, asNumber8, asNumber9, flutterBuildTimeFromJsonObject, flutterBuildTimeFromJsonObject2, flutterBuildTimeFromJsonObject3, performanceFromJsonObject, accessibilityFromJsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type ViewEventView", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type ViewEventView", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type ViewEventView", e3);
                }
            }
        }
    }

    public static final class Usr {
        public static final Companion Companion = new Companion(null);
        private static final String[] RESERVED_PROPERTIES = {DiagnosticsEntry.ID_KEY, "name", AuthorizationRequest.Scope.EMAIL, "anonymous_id"};
        private final Map additionalProperties;
        private final String anonymousId;
        private final String email;
        private final String id;
        private final String name;

        public static /* synthetic */ Usr copy$default(Usr usr, String str, String str2, String str3, String str4, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                str = usr.id;
            }
            if ((i & 2) != 0) {
                str2 = usr.name;
            }
            if ((i & 4) != 0) {
                str3 = usr.email;
            }
            if ((i & 8) != 0) {
                str4 = usr.anonymousId;
            }
            if ((i & 16) != 0) {
                map = usr.additionalProperties;
            }
            Map map2 = map;
            String str5 = str3;
            return usr.copy(str, str2, str5, str4, map2);
        }

        public final Usr copy(String str, String str2, String str3, String str4, Map additionalProperties) {
            Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            return new Usr(str, str2, str3, str4, additionalProperties);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Usr)) {
                return false;
            }
            Usr usr = (Usr) obj;
            return Intrinsics.areEqual(this.id, usr.id) && Intrinsics.areEqual(this.name, usr.name) && Intrinsics.areEqual(this.email, usr.email) && Intrinsics.areEqual(this.anonymousId, usr.anonymousId) && Intrinsics.areEqual(this.additionalProperties, usr.additionalProperties);
        }

        public int hashCode() {
            String str = this.id;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.name;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.email;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.anonymousId;
            return ((iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.additionalProperties.hashCode();
        }

        public String toString() {
            return "Usr(id=" + this.id + ", name=" + this.name + ", email=" + this.email + ", anonymousId=" + this.anonymousId + ", additionalProperties=" + this.additionalProperties + ")";
        }

        public Usr(String str, String str2, String str3, String str4, Map additionalProperties) {
            Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            this.id = str;
            this.name = str2;
            this.email = str3;
            this.anonymousId = str4;
            this.additionalProperties = additionalProperties;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public final String getEmail() {
            return this.email;
        }

        public final String getAnonymousId() {
            return this.anonymousId;
        }

        public final Map getAdditionalProperties() {
            return this.additionalProperties;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            String str = this.id;
            if (str != null) {
                jsonObject.addProperty(DiagnosticsEntry.ID_KEY, str);
            }
            String str2 = this.name;
            if (str2 != null) {
                jsonObject.addProperty("name", str2);
            }
            String str3 = this.email;
            if (str3 != null) {
                jsonObject.addProperty(AuthorizationRequest.Scope.EMAIL, str3);
            }
            String str4 = this.anonymousId;
            if (str4 != null) {
                jsonObject.addProperty("anonymous_id", str4);
            }
            for (Map.Entry entry : this.additionalProperties.entrySet()) {
                String str5 = (String) entry.getKey();
                Object value = entry.getValue();
                if (!ArraysKt.contains(RESERVED_PROPERTIES, str5)) {
                    jsonObject.add(str5, JsonSerializer.INSTANCE.toJsonElement(value));
                }
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final String[] getRESERVED_PROPERTIES$dd_sdk_android_rum_release() {
                return Usr.RESERVED_PROPERTIES;
            }

            public final Usr fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get(DiagnosticsEntry.ID_KEY);
                    String asString = jsonElement != null ? jsonElement.getAsString() : null;
                    JsonElement jsonElement2 = jsonObject.get("name");
                    String asString2 = jsonElement2 != null ? jsonElement2.getAsString() : null;
                    JsonElement jsonElement3 = jsonObject.get(AuthorizationRequest.Scope.EMAIL);
                    String asString3 = jsonElement3 != null ? jsonElement3.getAsString() : null;
                    JsonElement jsonElement4 = jsonObject.get("anonymous_id");
                    String asString4 = jsonElement4 != null ? jsonElement4.getAsString() : null;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry entry : jsonObject.entrySet()) {
                        if (!ArraysKt.contains(getRESERVED_PROPERTIES$dd_sdk_android_rum_release(), entry.getKey())) {
                            Object key = entry.getKey();
                            Intrinsics.checkNotNullExpressionValue(key, "entry.key");
                            linkedHashMap.put(key, entry.getValue());
                        }
                    }
                    return new Usr(asString, asString2, asString3, asString4, linkedHashMap);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Usr", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Usr", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Usr", e3);
                }
            }
        }
    }

    public static final class Account {
        public static final Companion Companion = new Companion(null);
        private static final String[] RESERVED_PROPERTIES = {DiagnosticsEntry.ID_KEY, "name"};
        private final Map additionalProperties;
        private final String id;
        private final String name;

        public static /* synthetic */ Account copy$default(Account account, String str, String str2, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                str = account.id;
            }
            if ((i & 2) != 0) {
                str2 = account.name;
            }
            if ((i & 4) != 0) {
                map = account.additionalProperties;
            }
            return account.copy(str, str2, map);
        }

        public final Account copy(String id, String str, Map additionalProperties) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            return new Account(id, str, additionalProperties);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Account)) {
                return false;
            }
            Account account = (Account) obj;
            return Intrinsics.areEqual(this.id, account.id) && Intrinsics.areEqual(this.name, account.name) && Intrinsics.areEqual(this.additionalProperties, account.additionalProperties);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.name;
            return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.additionalProperties.hashCode();
        }

        public String toString() {
            return "Account(id=" + this.id + ", name=" + this.name + ", additionalProperties=" + this.additionalProperties + ")";
        }

        public Account(String id, String str, Map additionalProperties) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            this.id = id;
            this.name = str;
            this.additionalProperties = additionalProperties;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public final Map getAdditionalProperties() {
            return this.additionalProperties;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(DiagnosticsEntry.ID_KEY, this.id);
            String str = this.name;
            if (str != null) {
                jsonObject.addProperty("name", str);
            }
            for (Map.Entry entry : this.additionalProperties.entrySet()) {
                String str2 = (String) entry.getKey();
                Object value = entry.getValue();
                if (!ArraysKt.contains(RESERVED_PROPERTIES, str2)) {
                    jsonObject.add(str2, JsonSerializer.INSTANCE.toJsonElement(value));
                }
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final String[] getRESERVED_PROPERTIES$dd_sdk_android_rum_release() {
                return Account.RESERVED_PROPERTIES;
            }

            public final Account fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String id = jsonObject.get(DiagnosticsEntry.ID_KEY).getAsString();
                    JsonElement jsonElement = jsonObject.get("name");
                    String asString = jsonElement != null ? jsonElement.getAsString() : null;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry entry : jsonObject.entrySet()) {
                        if (!ArraysKt.contains(getRESERVED_PROPERTIES$dd_sdk_android_rum_release(), entry.getKey())) {
                            Object key = entry.getKey();
                            Intrinsics.checkNotNullExpressionValue(key, "entry.key");
                            linkedHashMap.put(key, entry.getValue());
                        }
                    }
                    Intrinsics.checkNotNullExpressionValue(id, "id");
                    return new Account(id, asString, linkedHashMap);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Account", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Account", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Account", e3);
                }
            }
        }
    }

    public static final class Connectivity {
        public static final Companion Companion = new Companion(null);
        private final Cellular cellular;
        private final EffectiveType effectiveType;
        private final List interfaces;
        private final ConnectivityStatus status;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Connectivity)) {
                return false;
            }
            Connectivity connectivity = (Connectivity) obj;
            return this.status == connectivity.status && Intrinsics.areEqual(this.interfaces, connectivity.interfaces) && this.effectiveType == connectivity.effectiveType && Intrinsics.areEqual(this.cellular, connectivity.cellular);
        }

        public int hashCode() {
            int iHashCode = this.status.hashCode() * 31;
            List list = this.interfaces;
            int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
            EffectiveType effectiveType = this.effectiveType;
            int iHashCode3 = (iHashCode2 + (effectiveType == null ? 0 : effectiveType.hashCode())) * 31;
            Cellular cellular = this.cellular;
            return iHashCode3 + (cellular != null ? cellular.hashCode() : 0);
        }

        public String toString() {
            return "Connectivity(status=" + this.status + ", interfaces=" + this.interfaces + ", effectiveType=" + this.effectiveType + ", cellular=" + this.cellular + ")";
        }

        public Connectivity(ConnectivityStatus status, List list, EffectiveType effectiveType, Cellular cellular) {
            Intrinsics.checkNotNullParameter(status, "status");
            this.status = status;
            this.interfaces = list;
            this.effectiveType = effectiveType;
            this.cellular = cellular;
        }

        public /* synthetic */ Connectivity(ConnectivityStatus connectivityStatus, List list, EffectiveType effectiveType, Cellular cellular, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(connectivityStatus, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : effectiveType, (i & 8) != 0 ? null : cellular);
        }

        public final ConnectivityStatus getStatus() {
            return this.status;
        }

        public final List getInterfaces() {
            return this.interfaces;
        }

        public final Cellular getCellular() {
            return this.cellular;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("status", this.status.toJson());
            List list = this.interfaces;
            if (list != null) {
                JsonArray jsonArray = new JsonArray(list.size());
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    jsonArray.add(((Interface) it.next()).toJson());
                }
                jsonObject.add("interfaces", jsonArray);
            }
            EffectiveType effectiveType = this.effectiveType;
            if (effectiveType != null) {
                jsonObject.add("effective_type", effectiveType.toJson());
            }
            Cellular cellular = this.cellular;
            if (cellular != null) {
                jsonObject.add("cellular", cellular.toJson());
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Connectivity fromJsonObject(JsonObject jsonObject) {
                ArrayList arrayList;
                JsonObject asJsonObject;
                String asString;
                JsonArray<JsonElement> asJsonArray;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    ConnectivityStatus.Companion companion = ConnectivityStatus.Companion;
                    String asString2 = jsonObject.get("status").getAsString();
                    Intrinsics.checkNotNullExpressionValue(asString2, "jsonObject.get(\"status\").asString");
                    ConnectivityStatus connectivityStatusFromJson = companion.fromJson(asString2);
                    JsonElement jsonElement = jsonObject.get("interfaces");
                    Cellular cellularFromJsonObject = null;
                    if (jsonElement == null || (asJsonArray = jsonElement.getAsJsonArray()) == null) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(asJsonArray.size());
                        for (JsonElement jsonElement2 : asJsonArray) {
                            Interface.Companion companion2 = Interface.Companion;
                            String asString3 = jsonElement2.getAsString();
                            Intrinsics.checkNotNullExpressionValue(asString3, "it.asString");
                            arrayList.add(companion2.fromJson(asString3));
                        }
                    }
                    JsonElement jsonElement3 = jsonObject.get("effective_type");
                    EffectiveType effectiveTypeFromJson = (jsonElement3 == null || (asString = jsonElement3.getAsString()) == null) ? null : EffectiveType.Companion.fromJson(asString);
                    JsonElement jsonElement4 = jsonObject.get("cellular");
                    if (jsonElement4 != null && (asJsonObject = jsonElement4.getAsJsonObject()) != null) {
                        cellularFromJsonObject = Cellular.Companion.fromJsonObject(asJsonObject);
                    }
                    return new Connectivity(connectivityStatusFromJson, arrayList, effectiveTypeFromJson, cellularFromJsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Connectivity", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Connectivity", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Connectivity", e3);
                }
            }
        }
    }

    public static final class Display {
        public static final Companion Companion = new Companion(null);
        private final Scroll scroll;
        private final Viewport viewport;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Display)) {
                return false;
            }
            Display display = (Display) obj;
            return Intrinsics.areEqual(this.viewport, display.viewport) && Intrinsics.areEqual(this.scroll, display.scroll);
        }

        public int hashCode() {
            Viewport viewport = this.viewport;
            int iHashCode = (viewport == null ? 0 : viewport.hashCode()) * 31;
            Scroll scroll = this.scroll;
            return iHashCode + (scroll != null ? scroll.hashCode() : 0);
        }

        public String toString() {
            return "Display(viewport=" + this.viewport + ", scroll=" + this.scroll + ")";
        }

        public Display(Viewport viewport, Scroll scroll) {
            this.viewport = viewport;
            this.scroll = scroll;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            Viewport viewport = this.viewport;
            if (viewport != null) {
                jsonObject.add("viewport", viewport.toJson());
            }
            Scroll scroll = this.scroll;
            if (scroll != null) {
                jsonObject.add("scroll", scroll.toJson());
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Display fromJsonObject(JsonObject jsonObject) {
                JsonObject asJsonObject;
                JsonObject asJsonObject2;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get("viewport");
                    Scroll scrollFromJsonObject = null;
                    Viewport viewportFromJsonObject = (jsonElement == null || (asJsonObject2 = jsonElement.getAsJsonObject()) == null) ? null : Viewport.Companion.fromJsonObject(asJsonObject2);
                    JsonElement jsonElement2 = jsonObject.get("scroll");
                    if (jsonElement2 != null && (asJsonObject = jsonElement2.getAsJsonObject()) != null) {
                        scrollFromJsonObject = Scroll.Companion.fromJsonObject(asJsonObject);
                    }
                    return new Display(viewportFromJsonObject, scrollFromJsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Display", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Display", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Display", e3);
                }
            }
        }
    }

    public static final class Synthetics {
        public static final Companion Companion = new Companion(null);
        private final Boolean injected;
        private final String resultId;
        private final String testId;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Synthetics)) {
                return false;
            }
            Synthetics synthetics = (Synthetics) obj;
            return Intrinsics.areEqual(this.testId, synthetics.testId) && Intrinsics.areEqual(this.resultId, synthetics.resultId) && Intrinsics.areEqual(this.injected, synthetics.injected);
        }

        public int hashCode() {
            int iHashCode = ((this.testId.hashCode() * 31) + this.resultId.hashCode()) * 31;
            Boolean bool = this.injected;
            return iHashCode + (bool == null ? 0 : bool.hashCode());
        }

        public String toString() {
            return "Synthetics(testId=" + this.testId + ", resultId=" + this.resultId + ", injected=" + this.injected + ")";
        }

        public Synthetics(String testId, String resultId, Boolean bool) {
            Intrinsics.checkNotNullParameter(testId, "testId");
            Intrinsics.checkNotNullParameter(resultId, "resultId");
            this.testId = testId;
            this.resultId = resultId;
            this.injected = bool;
        }

        public /* synthetic */ Synthetics(String str, String str2, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? null : bool);
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("test_id", this.testId);
            jsonObject.addProperty("result_id", this.resultId);
            Boolean bool = this.injected;
            if (bool != null) {
                jsonObject.addProperty("injected", bool);
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Synthetics fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String testId = jsonObject.get("test_id").getAsString();
                    String resultId = jsonObject.get("result_id").getAsString();
                    JsonElement jsonElement = jsonObject.get("injected");
                    Boolean boolValueOf = jsonElement != null ? Boolean.valueOf(jsonElement.getAsBoolean()) : null;
                    Intrinsics.checkNotNullExpressionValue(testId, "testId");
                    Intrinsics.checkNotNullExpressionValue(resultId, "resultId");
                    return new Synthetics(testId, resultId, boolValueOf);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Synthetics", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Synthetics", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Synthetics", e3);
                }
            }
        }
    }

    public static final class CiTest {
        public static final Companion Companion = new Companion(null);
        private final String testExecutionId;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CiTest) && Intrinsics.areEqual(this.testExecutionId, ((CiTest) obj).testExecutionId);
        }

        public int hashCode() {
            return this.testExecutionId.hashCode();
        }

        public String toString() {
            return "CiTest(testExecutionId=" + this.testExecutionId + ")";
        }

        public CiTest(String testExecutionId) {
            Intrinsics.checkNotNullParameter(testExecutionId, "testExecutionId");
            this.testExecutionId = testExecutionId;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("test_execution_id", this.testExecutionId);
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final CiTest fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String testExecutionId = jsonObject.get("test_execution_id").getAsString();
                    Intrinsics.checkNotNullExpressionValue(testExecutionId, "testExecutionId");
                    return new CiTest(testExecutionId);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type CiTest", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type CiTest", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type CiTest", e3);
                }
            }
        }
    }

    public static final class Os {
        public static final Companion Companion = new Companion(null);
        private final String build;
        private final String name;
        private final String version;
        private final String versionMajor;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Os)) {
                return false;
            }
            Os os = (Os) obj;
            return Intrinsics.areEqual(this.name, os.name) && Intrinsics.areEqual(this.version, os.version) && Intrinsics.areEqual(this.build, os.build) && Intrinsics.areEqual(this.versionMajor, os.versionMajor);
        }

        public int hashCode() {
            int iHashCode = ((this.name.hashCode() * 31) + this.version.hashCode()) * 31;
            String str = this.build;
            return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.versionMajor.hashCode();
        }

        public String toString() {
            return "Os(name=" + this.name + ", version=" + this.version + ", build=" + this.build + ", versionMajor=" + this.versionMajor + ")";
        }

        public Os(String name, String version, String str, String versionMajor) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(version, "version");
            Intrinsics.checkNotNullParameter(versionMajor, "versionMajor");
            this.name = name;
            this.version = version;
            this.build = str;
            this.versionMajor = versionMajor;
        }

        public /* synthetic */ Os(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? null : str3, str4);
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("name", this.name);
            jsonObject.addProperty(DiagnosticsEntry.VERSION_KEY, this.version);
            String str = this.build;
            if (str != null) {
                jsonObject.addProperty("build", str);
            }
            jsonObject.addProperty("version_major", this.versionMajor);
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Os fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String name = jsonObject.get("name").getAsString();
                    String version = jsonObject.get(DiagnosticsEntry.VERSION_KEY).getAsString();
                    JsonElement jsonElement = jsonObject.get("build");
                    String asString = jsonElement != null ? jsonElement.getAsString() : null;
                    String versionMajor = jsonObject.get("version_major").getAsString();
                    Intrinsics.checkNotNullExpressionValue(name, "name");
                    Intrinsics.checkNotNullExpressionValue(version, "version");
                    Intrinsics.checkNotNullExpressionValue(versionMajor, "versionMajor");
                    return new Os(name, version, asString, versionMajor);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Os", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Os", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Os", e3);
                }
            }
        }
    }

    public static final class Device {
        public static final Companion Companion = new Companion(null);
        private final String architecture;
        private final Number batteryLevel;
        private final String brand;
        private final Number brightnessLevel;
        private final String locale;
        private final List locales;
        private final String model;
        private final String name;
        private final Boolean powerSavingMode;
        private final String timeZone;
        private final DeviceType type;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Device)) {
                return false;
            }
            Device device = (Device) obj;
            return this.type == device.type && Intrinsics.areEqual(this.name, device.name) && Intrinsics.areEqual(this.model, device.model) && Intrinsics.areEqual(this.brand, device.brand) && Intrinsics.areEqual(this.architecture, device.architecture) && Intrinsics.areEqual(this.locale, device.locale) && Intrinsics.areEqual(this.locales, device.locales) && Intrinsics.areEqual(this.timeZone, device.timeZone) && Intrinsics.areEqual(this.batteryLevel, device.batteryLevel) && Intrinsics.areEqual(this.powerSavingMode, device.powerSavingMode) && Intrinsics.areEqual(this.brightnessLevel, device.brightnessLevel);
        }

        public int hashCode() {
            DeviceType deviceType = this.type;
            int iHashCode = (deviceType == null ? 0 : deviceType.hashCode()) * 31;
            String str = this.name;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.model;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.brand;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.architecture;
            int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.locale;
            int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            List list = this.locales;
            int iHashCode7 = (iHashCode6 + (list == null ? 0 : list.hashCode())) * 31;
            String str6 = this.timeZone;
            int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
            Number number = this.batteryLevel;
            int iHashCode9 = (iHashCode8 + (number == null ? 0 : number.hashCode())) * 31;
            Boolean bool = this.powerSavingMode;
            int iHashCode10 = (iHashCode9 + (bool == null ? 0 : bool.hashCode())) * 31;
            Number number2 = this.brightnessLevel;
            return iHashCode10 + (number2 != null ? number2.hashCode() : 0);
        }

        public String toString() {
            return "Device(type=" + this.type + ", name=" + this.name + ", model=" + this.model + ", brand=" + this.brand + ", architecture=" + this.architecture + ", locale=" + this.locale + ", locales=" + this.locales + ", timeZone=" + this.timeZone + ", batteryLevel=" + this.batteryLevel + ", powerSavingMode=" + this.powerSavingMode + ", brightnessLevel=" + this.brightnessLevel + ")";
        }

        public Device(DeviceType deviceType, String str, String str2, String str3, String str4, String str5, List list, String str6, Number number, Boolean bool, Number number2) {
            this.type = deviceType;
            this.name = str;
            this.model = str2;
            this.brand = str3;
            this.architecture = str4;
            this.locale = str5;
            this.locales = list;
            this.timeZone = str6;
            this.batteryLevel = number;
            this.powerSavingMode = bool;
            this.brightnessLevel = number2;
        }

        public /* synthetic */ Device(DeviceType deviceType, String str, String str2, String str3, String str4, String str5, List list, String str6, Number number, Boolean bool, Number number2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : deviceType, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : list, (i & 128) != 0 ? null : str6, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : number, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? null : bool, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : number2);
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            DeviceType deviceType = this.type;
            if (deviceType != null) {
                jsonObject.add("type", deviceType.toJson());
            }
            String str = this.name;
            if (str != null) {
                jsonObject.addProperty("name", str);
            }
            String str2 = this.model;
            if (str2 != null) {
                jsonObject.addProperty("model", str2);
            }
            String str3 = this.brand;
            if (str3 != null) {
                jsonObject.addProperty("brand", str3);
            }
            String str4 = this.architecture;
            if (str4 != null) {
                jsonObject.addProperty("architecture", str4);
            }
            String str5 = this.locale;
            if (str5 != null) {
                jsonObject.addProperty("locale", str5);
            }
            List list = this.locales;
            if (list != null) {
                JsonArray jsonArray = new JsonArray(list.size());
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    jsonArray.add((String) it.next());
                }
                jsonObject.add("locales", jsonArray);
            }
            String str6 = this.timeZone;
            if (str6 != null) {
                jsonObject.addProperty("time_zone", str6);
            }
            Number number = this.batteryLevel;
            if (number != null) {
                jsonObject.addProperty("battery_level", number);
            }
            Boolean bool = this.powerSavingMode;
            if (bool != null) {
                jsonObject.addProperty("power_saving_mode", bool);
            }
            Number number2 = this.brightnessLevel;
            if (number2 != null) {
                jsonObject.addProperty("brightness_level", number2);
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Device fromJsonObject(JsonObject jsonObject) {
                ArrayList arrayList;
                JsonArray asJsonArray;
                String asString;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get("type");
                    DeviceType deviceTypeFromJson = (jsonElement == null || (asString = jsonElement.getAsString()) == null) ? null : DeviceType.Companion.fromJson(asString);
                    JsonElement jsonElement2 = jsonObject.get("name");
                    String asString2 = jsonElement2 != null ? jsonElement2.getAsString() : null;
                    JsonElement jsonElement3 = jsonObject.get("model");
                    String asString3 = jsonElement3 != null ? jsonElement3.getAsString() : null;
                    JsonElement jsonElement4 = jsonObject.get("brand");
                    String asString4 = jsonElement4 != null ? jsonElement4.getAsString() : null;
                    JsonElement jsonElement5 = jsonObject.get("architecture");
                    String asString5 = jsonElement5 != null ? jsonElement5.getAsString() : null;
                    JsonElement jsonElement6 = jsonObject.get("locale");
                    String asString6 = jsonElement6 != null ? jsonElement6.getAsString() : null;
                    JsonElement jsonElement7 = jsonObject.get("locales");
                    if (jsonElement7 == null || (asJsonArray = jsonElement7.getAsJsonArray()) == null) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(asJsonArray.size());
                        Iterator it = asJsonArray.iterator();
                        while (it.hasNext()) {
                            arrayList.add(((JsonElement) it.next()).getAsString());
                        }
                    }
                    JsonElement jsonElement8 = jsonObject.get("time_zone");
                    String asString7 = jsonElement8 != null ? jsonElement8.getAsString() : null;
                    JsonElement jsonElement9 = jsonObject.get("battery_level");
                    Number asNumber = jsonElement9 != null ? jsonElement9.getAsNumber() : null;
                    JsonElement jsonElement10 = jsonObject.get("power_saving_mode");
                    Boolean boolValueOf = jsonElement10 != null ? Boolean.valueOf(jsonElement10.getAsBoolean()) : null;
                    JsonElement jsonElement11 = jsonObject.get("brightness_level");
                    return new Device(deviceTypeFromJson, asString2, asString3, asString4, asString5, asString6, arrayList, asString7, asNumber, boolValueOf, jsonElement11 != null ? jsonElement11.getAsNumber() : null);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Device", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Device", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Device", e3);
                }
            }
        }
    }

    public static final class Dd {
        public static final Companion Companion = new Companion(null);
        private final String browserSdkVersion;
        private final DdCls cls;
        private final Configuration configuration;
        private final long documentVersion;
        private final long formatVersion;
        private final List pageStates;
        private final Profiling profiling;
        private final ReplayStats replayStats;
        private final String sdkName;
        private final DdSession session;

        public static /* synthetic */ Dd copy$default(Dd dd, DdSession ddSession, Configuration configuration, String str, String str2, long j, List list, ReplayStats replayStats, DdCls ddCls, Profiling profiling, int i, Object obj) {
            if ((i & 1) != 0) {
                ddSession = dd.session;
            }
            if ((i & 2) != 0) {
                configuration = dd.configuration;
            }
            if ((i & 4) != 0) {
                str = dd.browserSdkVersion;
            }
            if ((i & 8) != 0) {
                str2 = dd.sdkName;
            }
            if ((i & 16) != 0) {
                j = dd.documentVersion;
            }
            if ((i & 32) != 0) {
                list = dd.pageStates;
            }
            if ((i & 64) != 0) {
                replayStats = dd.replayStats;
            }
            if ((i & 128) != 0) {
                ddCls = dd.cls;
            }
            if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0) {
                profiling = dd.profiling;
            }
            long j2 = j;
            String str3 = str;
            String str4 = str2;
            return dd.copy(ddSession, configuration, str3, str4, j2, list, replayStats, ddCls, profiling);
        }

        public final Dd copy(DdSession ddSession, Configuration configuration, String str, String str2, long j, List list, ReplayStats replayStats, DdCls ddCls, Profiling profiling) {
            return new Dd(ddSession, configuration, str, str2, j, list, replayStats, ddCls, profiling);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Dd)) {
                return false;
            }
            Dd dd = (Dd) obj;
            return Intrinsics.areEqual(this.session, dd.session) && Intrinsics.areEqual(this.configuration, dd.configuration) && Intrinsics.areEqual(this.browserSdkVersion, dd.browserSdkVersion) && Intrinsics.areEqual(this.sdkName, dd.sdkName) && this.documentVersion == dd.documentVersion && Intrinsics.areEqual(this.pageStates, dd.pageStates) && Intrinsics.areEqual(this.replayStats, dd.replayStats) && Intrinsics.areEqual(this.cls, dd.cls) && Intrinsics.areEqual(this.profiling, dd.profiling);
        }

        public int hashCode() {
            DdSession ddSession = this.session;
            int iHashCode = (ddSession == null ? 0 : ddSession.hashCode()) * 31;
            Configuration configuration = this.configuration;
            int iHashCode2 = (iHashCode + (configuration == null ? 0 : configuration.hashCode())) * 31;
            String str = this.browserSdkVersion;
            int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.sdkName;
            int iHashCode4 = (((iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + Long.hashCode(this.documentVersion)) * 31;
            List list = this.pageStates;
            int iHashCode5 = (iHashCode4 + (list == null ? 0 : list.hashCode())) * 31;
            ReplayStats replayStats = this.replayStats;
            int iHashCode6 = (iHashCode5 + (replayStats == null ? 0 : replayStats.hashCode())) * 31;
            DdCls ddCls = this.cls;
            int iHashCode7 = (iHashCode6 + (ddCls == null ? 0 : ddCls.hashCode())) * 31;
            Profiling profiling = this.profiling;
            return iHashCode7 + (profiling != null ? profiling.hashCode() : 0);
        }

        public String toString() {
            return "Dd(session=" + this.session + ", configuration=" + this.configuration + ", browserSdkVersion=" + this.browserSdkVersion + ", sdkName=" + this.sdkName + ", documentVersion=" + this.documentVersion + ", pageStates=" + this.pageStates + ", replayStats=" + this.replayStats + ", cls=" + this.cls + ", profiling=" + this.profiling + ")";
        }

        public Dd(DdSession ddSession, Configuration configuration, String str, String str2, long j, List list, ReplayStats replayStats, DdCls ddCls, Profiling profiling) {
            this.session = ddSession;
            this.configuration = configuration;
            this.browserSdkVersion = str;
            this.sdkName = str2;
            this.documentVersion = j;
            this.pageStates = list;
            this.replayStats = replayStats;
            this.cls = ddCls;
            this.profiling = profiling;
            this.formatVersion = 2L;
        }

        public /* synthetic */ Dd(DdSession ddSession, Configuration configuration, String str, String str2, long j, List list, ReplayStats replayStats, DdCls ddCls, Profiling profiling, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : ddSession, (i & 2) != 0 ? null : configuration, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, j, (i & 32) != 0 ? null : list, (i & 64) != 0 ? null : replayStats, (i & 128) != 0 ? null : ddCls, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : profiling);
        }

        public final Configuration getConfiguration() {
            return this.configuration;
        }

        public final long getDocumentVersion() {
            return this.documentVersion;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("format_version", Long.valueOf(this.formatVersion));
            DdSession ddSession = this.session;
            if (ddSession != null) {
                jsonObject.add("session", ddSession.toJson());
            }
            Configuration configuration = this.configuration;
            if (configuration != null) {
                jsonObject.add("configuration", configuration.toJson());
            }
            String str = this.browserSdkVersion;
            if (str != null) {
                jsonObject.addProperty("browser_sdk_version", str);
            }
            String str2 = this.sdkName;
            if (str2 != null) {
                jsonObject.addProperty("sdk_name", str2);
            }
            jsonObject.addProperty("document_version", Long.valueOf(this.documentVersion));
            List list = this.pageStates;
            if (list != null) {
                JsonArray jsonArray = new JsonArray(list.size());
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    jsonArray.add(((PageState) it.next()).toJson());
                }
                jsonObject.add("page_states", jsonArray);
            }
            ReplayStats replayStats = this.replayStats;
            if (replayStats != null) {
                jsonObject.add("replay_stats", replayStats.toJson());
            }
            DdCls ddCls = this.cls;
            if (ddCls != null) {
                jsonObject.add("cls", ddCls.toJson());
            }
            Profiling profiling = this.profiling;
            if (profiling != null) {
                jsonObject.add("profiling", profiling.toJson());
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Dd fromJsonObject(JsonObject jsonObject) {
                ArrayList arrayList;
                JsonObject asJsonObject;
                JsonObject asJsonObject2;
                JsonObject asJsonObject3;
                JsonArray<JsonElement> asJsonArray;
                JsonObject asJsonObject4;
                JsonObject asJsonObject5;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    long asLong = jsonObject.get("format_version").getAsLong();
                    JsonElement jsonElement = jsonObject.get("session");
                    Profiling profilingFromJsonObject = null;
                    DdSession ddSessionFromJsonObject = (jsonElement == null || (asJsonObject5 = jsonElement.getAsJsonObject()) == null) ? null : DdSession.Companion.fromJsonObject(asJsonObject5);
                    JsonElement jsonElement2 = jsonObject.get("configuration");
                    Configuration configurationFromJsonObject = (jsonElement2 == null || (asJsonObject4 = jsonElement2.getAsJsonObject()) == null) ? null : Configuration.Companion.fromJsonObject(asJsonObject4);
                    JsonElement jsonElement3 = jsonObject.get("browser_sdk_version");
                    String asString = jsonElement3 != null ? jsonElement3.getAsString() : null;
                    JsonElement jsonElement4 = jsonObject.get("sdk_name");
                    String asString2 = jsonElement4 != null ? jsonElement4.getAsString() : null;
                    long asLong2 = jsonObject.get("document_version").getAsLong();
                    JsonElement jsonElement5 = jsonObject.get("page_states");
                    if (jsonElement5 == null || (asJsonArray = jsonElement5.getAsJsonArray()) == null) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(asJsonArray.size());
                        for (JsonElement jsonElement6 : asJsonArray) {
                            PageState.Companion companion = PageState.Companion;
                            JsonObject asJsonObject6 = jsonElement6.getAsJsonObject();
                            Intrinsics.checkNotNullExpressionValue(asJsonObject6, "it.asJsonObject");
                            arrayList.add(companion.fromJsonObject(asJsonObject6));
                        }
                    }
                    JsonElement jsonElement7 = jsonObject.get("replay_stats");
                    ReplayStats replayStatsFromJsonObject = (jsonElement7 == null || (asJsonObject3 = jsonElement7.getAsJsonObject()) == null) ? null : ReplayStats.Companion.fromJsonObject(asJsonObject3);
                    JsonElement jsonElement8 = jsonObject.get("cls");
                    DdCls ddClsFromJsonObject = (jsonElement8 == null || (asJsonObject2 = jsonElement8.getAsJsonObject()) == null) ? null : DdCls.Companion.fromJsonObject(asJsonObject2);
                    JsonElement jsonElement9 = jsonObject.get("profiling");
                    if (jsonElement9 != null && (asJsonObject = jsonElement9.getAsJsonObject()) != null) {
                        profilingFromJsonObject = Profiling.Companion.fromJsonObject(asJsonObject);
                    }
                    if (asLong != 2) {
                        throw new IllegalStateException("Check failed.");
                    }
                    return new Dd(ddSessionFromJsonObject, configurationFromJsonObject, asString, asString2, asLong2, arrayList, replayStatsFromJsonObject, ddClsFromJsonObject, profilingFromJsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Dd", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Dd", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Dd", e3);
                }
            }
        }
    }

    public static final class Context {
        public static final Companion Companion = new Companion(null);
        private final Map additionalProperties;

        public final Context copy(Map additionalProperties) {
            Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            return new Context(additionalProperties);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Context) && Intrinsics.areEqual(this.additionalProperties, ((Context) obj).additionalProperties);
        }

        public int hashCode() {
            return this.additionalProperties.hashCode();
        }

        public String toString() {
            return "Context(additionalProperties=" + this.additionalProperties + ")";
        }

        public Context(Map additionalProperties) {
            Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            this.additionalProperties = additionalProperties;
        }

        public final Map getAdditionalProperties() {
            return this.additionalProperties;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            for (Map.Entry entry : this.additionalProperties.entrySet()) {
                jsonObject.add((String) entry.getKey(), JsonSerializer.INSTANCE.toJsonElement(entry.getValue()));
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Context fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry entry : jsonObject.entrySet()) {
                        Object key = entry.getKey();
                        Intrinsics.checkNotNullExpressionValue(key, "entry.key");
                        linkedHashMap.put(key, entry.getValue());
                    }
                    return new Context(linkedHashMap);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Context", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Context", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Context", e3);
                }
            }
        }
    }

    public static final class Container {
        public static final Companion Companion = new Companion(null);
        private final ViewEventSource source;
        private final ContainerView view;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Container)) {
                return false;
            }
            Container container = (Container) obj;
            return Intrinsics.areEqual(this.view, container.view) && this.source == container.source;
        }

        public int hashCode() {
            return (this.view.hashCode() * 31) + this.source.hashCode();
        }

        public String toString() {
            return "Container(view=" + this.view + ", source=" + this.source + ")";
        }

        public Container(ContainerView view, ViewEventSource source) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(source, "source");
            this.view = view;
            this.source = source;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("view", this.view.toJson());
            jsonObject.add(Constants.ScionAnalytics.PARAM_SOURCE, this.source.toJson());
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Container fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonObject it = jsonObject.get("view").getAsJsonObject();
                    ContainerView.Companion companion = ContainerView.Companion;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    ContainerView containerViewFromJsonObject = companion.fromJsonObject(it);
                    ViewEventSource.Companion companion2 = ViewEventSource.Companion;
                    String asString = jsonObject.get(Constants.ScionAnalytics.PARAM_SOURCE).getAsString();
                    Intrinsics.checkNotNullExpressionValue(asString, "jsonObject.get(\"source\").asString");
                    return new Container(containerViewFromJsonObject, companion2.fromJson(asString));
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Container", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Container", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Container", e3);
                }
            }
        }
    }

    public static final class Privacy {
        public static final Companion Companion = new Companion(null);
        private final ReplayLevel replayLevel;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Privacy) && this.replayLevel == ((Privacy) obj).replayLevel;
        }

        public int hashCode() {
            return this.replayLevel.hashCode();
        }

        public String toString() {
            return "Privacy(replayLevel=" + this.replayLevel + ")";
        }

        public Privacy(ReplayLevel replayLevel) {
            Intrinsics.checkNotNullParameter(replayLevel, "replayLevel");
            this.replayLevel = replayLevel;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("replay_level", this.replayLevel.toJson());
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Privacy fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    ReplayLevel.Companion companion = ReplayLevel.Companion;
                    String asString = jsonObject.get("replay_level").getAsString();
                    Intrinsics.checkNotNullExpressionValue(asString, "jsonObject.get(\"replay_level\").asString");
                    return new Privacy(companion.fromJson(asString));
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Privacy", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Privacy", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Privacy", e3);
                }
            }
        }
    }

    public static final class CustomTimings {
        public static final Companion Companion = new Companion(null);
        private final Map additionalProperties;

        public final CustomTimings copy(Map additionalProperties) {
            Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            return new CustomTimings(additionalProperties);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CustomTimings) && Intrinsics.areEqual(this.additionalProperties, ((CustomTimings) obj).additionalProperties);
        }

        public int hashCode() {
            return this.additionalProperties.hashCode();
        }

        public String toString() {
            return "CustomTimings(additionalProperties=" + this.additionalProperties + ")";
        }

        public CustomTimings(Map additionalProperties) {
            Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            this.additionalProperties = additionalProperties;
        }

        public final Map getAdditionalProperties() {
            return this.additionalProperties;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            for (Map.Entry entry : this.additionalProperties.entrySet()) {
                jsonObject.addProperty((String) entry.getKey(), Long.valueOf(((Number) entry.getValue()).longValue()));
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final CustomTimings fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry entry : jsonObject.entrySet()) {
                        Object key = entry.getKey();
                        Intrinsics.checkNotNullExpressionValue(key, "entry.key");
                        linkedHashMap.put(key, Long.valueOf(((JsonElement) entry.getValue()).getAsLong()));
                    }
                    return new CustomTimings(linkedHashMap);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type CustomTimings", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type CustomTimings", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type CustomTimings", e3);
                }
            }
        }
    }

    public static final class Action {
        public static final Companion Companion = new Companion(null);
        private final long count;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Action) && this.count == ((Action) obj).count;
        }

        public int hashCode() {
            return Long.hashCode(this.count);
        }

        public String toString() {
            return "Action(count=" + this.count + ")";
        }

        public Action(long j) {
            this.count = j;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("count", Long.valueOf(this.count));
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Action fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    return new Action(jsonObject.get("count").getAsLong());
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Action", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Action", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Action", e3);
                }
            }
        }
    }

    public static final class Error {
        public static final Companion Companion = new Companion(null);
        private final long count;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Error) && this.count == ((Error) obj).count;
        }

        public int hashCode() {
            return Long.hashCode(this.count);
        }

        public String toString() {
            return "Error(count=" + this.count + ")";
        }

        public Error(long j) {
            this.count = j;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("count", Long.valueOf(this.count));
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Error fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    return new Error(jsonObject.get("count").getAsLong());
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Error", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Error", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Error", e3);
                }
            }
        }
    }

    public static final class Crash {
        public static final Companion Companion = new Companion(null);
        private final long count;

        public final Crash copy(long j) {
            return new Crash(j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Crash) && this.count == ((Crash) obj).count;
        }

        public int hashCode() {
            return Long.hashCode(this.count);
        }

        public String toString() {
            return "Crash(count=" + this.count + ")";
        }

        public Crash(long j) {
            this.count = j;
        }

        public final long getCount() {
            return this.count;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("count", Long.valueOf(this.count));
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Crash fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    return new Crash(jsonObject.get("count").getAsLong());
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Crash", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Crash", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Crash", e3);
                }
            }
        }
    }

    public static final class LongTask {
        public static final Companion Companion = new Companion(null);
        private final long count;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LongTask) && this.count == ((LongTask) obj).count;
        }

        public int hashCode() {
            return Long.hashCode(this.count);
        }

        public String toString() {
            return "LongTask(count=" + this.count + ")";
        }

        public LongTask(long j) {
            this.count = j;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("count", Long.valueOf(this.count));
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final LongTask fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    return new LongTask(jsonObject.get("count").getAsLong());
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type LongTask", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type LongTask", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type LongTask", e3);
                }
            }
        }
    }

    public static final class FrozenFrame {
        public static final Companion Companion = new Companion(null);
        private final long count;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof FrozenFrame) && this.count == ((FrozenFrame) obj).count;
        }

        public int hashCode() {
            return Long.hashCode(this.count);
        }

        public String toString() {
            return "FrozenFrame(count=" + this.count + ")";
        }

        public FrozenFrame(long j) {
            this.count = j;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("count", Long.valueOf(this.count));
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final FrozenFrame fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    return new FrozenFrame(jsonObject.get("count").getAsLong());
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type FrozenFrame", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type FrozenFrame", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type FrozenFrame", e3);
                }
            }
        }
    }

    public static final class SlowFrame {
        public static final Companion Companion = new Companion(null);
        private final long duration;
        private final long start;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SlowFrame)) {
                return false;
            }
            SlowFrame slowFrame = (SlowFrame) obj;
            return this.start == slowFrame.start && this.duration == slowFrame.duration;
        }

        public int hashCode() {
            return (Long.hashCode(this.start) * 31) + Long.hashCode(this.duration);
        }

        public String toString() {
            return "SlowFrame(start=" + this.start + ", duration=" + this.duration + ")";
        }

        public SlowFrame(long j, long j2) {
            this.start = j;
            this.duration = j2;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("start", Long.valueOf(this.start));
            jsonObject.addProperty("duration", Long.valueOf(this.duration));
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final SlowFrame fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    return new SlowFrame(jsonObject.get("start").getAsLong(), jsonObject.get("duration").getAsLong());
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type SlowFrame", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type SlowFrame", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type SlowFrame", e3);
                }
            }
        }
    }

    public static final class Resource {
        public static final Companion Companion = new Companion(null);
        private final long count;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Resource) && this.count == ((Resource) obj).count;
        }

        public int hashCode() {
            return Long.hashCode(this.count);
        }

        public String toString() {
            return "Resource(count=" + this.count + ")";
        }

        public Resource(long j) {
            this.count = j;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("count", Long.valueOf(this.count));
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Resource fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    return new Resource(jsonObject.get("count").getAsLong());
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Resource", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Resource", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Resource", e3);
                }
            }
        }
    }

    public static final class Frustration {
        public static final Companion Companion = new Companion(null);
        private final long count;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Frustration) && this.count == ((Frustration) obj).count;
        }

        public int hashCode() {
            return Long.hashCode(this.count);
        }

        public String toString() {
            return "Frustration(count=" + this.count + ")";
        }

        public Frustration(long j) {
            this.count = j;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("count", Long.valueOf(this.count));
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Frustration fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    return new Frustration(jsonObject.get("count").getAsLong());
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Frustration", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Frustration", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Frustration", e3);
                }
            }
        }
    }

    public static final class InForegroundPeriod {
        public static final Companion Companion = new Companion(null);
        private final long duration;
        private final long start;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof InForegroundPeriod)) {
                return false;
            }
            InForegroundPeriod inForegroundPeriod = (InForegroundPeriod) obj;
            return this.start == inForegroundPeriod.start && this.duration == inForegroundPeriod.duration;
        }

        public int hashCode() {
            return (Long.hashCode(this.start) * 31) + Long.hashCode(this.duration);
        }

        public String toString() {
            return "InForegroundPeriod(start=" + this.start + ", duration=" + this.duration + ")";
        }

        public InForegroundPeriod(long j, long j2) {
            this.start = j;
            this.duration = j2;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("start", Long.valueOf(this.start));
            jsonObject.addProperty("duration", Long.valueOf(this.duration));
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final InForegroundPeriod fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    return new InForegroundPeriod(jsonObject.get("start").getAsLong(), jsonObject.get("duration").getAsLong());
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type InForegroundPeriod", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type InForegroundPeriod", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type InForegroundPeriod", e3);
                }
            }
        }
    }

    public static final class FlutterBuildTime {
        public static final Companion Companion = new Companion(null);
        private final Number average;
        private final Number max;
        private final Number metricMax;
        private final Number min;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FlutterBuildTime)) {
                return false;
            }
            FlutterBuildTime flutterBuildTime = (FlutterBuildTime) obj;
            return Intrinsics.areEqual(this.min, flutterBuildTime.min) && Intrinsics.areEqual(this.max, flutterBuildTime.max) && Intrinsics.areEqual(this.average, flutterBuildTime.average) && Intrinsics.areEqual(this.metricMax, flutterBuildTime.metricMax);
        }

        public int hashCode() {
            int iHashCode = ((((this.min.hashCode() * 31) + this.max.hashCode()) * 31) + this.average.hashCode()) * 31;
            Number number = this.metricMax;
            return iHashCode + (number == null ? 0 : number.hashCode());
        }

        public String toString() {
            return "FlutterBuildTime(min=" + this.min + ", max=" + this.max + ", average=" + this.average + ", metricMax=" + this.metricMax + ")";
        }

        public FlutterBuildTime(Number min, Number max, Number average, Number number) {
            Intrinsics.checkNotNullParameter(min, "min");
            Intrinsics.checkNotNullParameter(max, "max");
            Intrinsics.checkNotNullParameter(average, "average");
            this.min = min;
            this.max = max;
            this.average = average;
            this.metricMax = number;
        }

        public /* synthetic */ FlutterBuildTime(Number number, Number number2, Number number3, Number number4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(number, number2, number3, (i & 8) != 0 ? null : number4);
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("min", this.min);
            jsonObject.addProperty("max", this.max);
            jsonObject.addProperty("average", this.average);
            Number number = this.metricMax;
            if (number != null) {
                jsonObject.addProperty("metric_max", number);
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final FlutterBuildTime fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    Number min = jsonObject.get("min").getAsNumber();
                    Number max = jsonObject.get("max").getAsNumber();
                    Number average = jsonObject.get("average").getAsNumber();
                    JsonElement jsonElement = jsonObject.get("metric_max");
                    Number asNumber = jsonElement != null ? jsonElement.getAsNumber() : null;
                    Intrinsics.checkNotNullExpressionValue(min, "min");
                    Intrinsics.checkNotNullExpressionValue(max, "max");
                    Intrinsics.checkNotNullExpressionValue(average, "average");
                    return new FlutterBuildTime(min, max, average, asNumber);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type FlutterBuildTime", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type FlutterBuildTime", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type FlutterBuildTime", e3);
                }
            }
        }
    }

    public static final class Performance {
        public static final Companion Companion = new Companion(null);
        private final PerformanceCls cls;
        private final Fbc fbc;
        private final Fcp fcp;
        private final Fid fid;
        private final Inp inp;
        private final Lcp lcp;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Performance)) {
                return false;
            }
            Performance performance = (Performance) obj;
            return Intrinsics.areEqual(this.cls, performance.cls) && Intrinsics.areEqual(this.fcp, performance.fcp) && Intrinsics.areEqual(this.fid, performance.fid) && Intrinsics.areEqual(this.inp, performance.inp) && Intrinsics.areEqual(this.lcp, performance.lcp) && Intrinsics.areEqual(this.fbc, performance.fbc);
        }

        public int hashCode() {
            PerformanceCls performanceCls = this.cls;
            int iHashCode = (performanceCls == null ? 0 : performanceCls.hashCode()) * 31;
            Fcp fcp = this.fcp;
            int iHashCode2 = (iHashCode + (fcp == null ? 0 : fcp.hashCode())) * 31;
            Fid fid = this.fid;
            int iHashCode3 = (iHashCode2 + (fid == null ? 0 : fid.hashCode())) * 31;
            Inp inp = this.inp;
            int iHashCode4 = (iHashCode3 + (inp == null ? 0 : inp.hashCode())) * 31;
            Lcp lcp = this.lcp;
            int iHashCode5 = (iHashCode4 + (lcp == null ? 0 : lcp.hashCode())) * 31;
            Fbc fbc = this.fbc;
            return iHashCode5 + (fbc != null ? fbc.hashCode() : 0);
        }

        public String toString() {
            return "Performance(cls=" + this.cls + ", fcp=" + this.fcp + ", fid=" + this.fid + ", inp=" + this.inp + ", lcp=" + this.lcp + ", fbc=" + this.fbc + ")";
        }

        public Performance(PerformanceCls performanceCls, Fcp fcp, Fid fid, Inp inp, Lcp lcp, Fbc fbc) {
            this.cls = performanceCls;
            this.fcp = fcp;
            this.fid = fid;
            this.inp = inp;
            this.lcp = lcp;
            this.fbc = fbc;
        }

        public /* synthetic */ Performance(PerformanceCls performanceCls, Fcp fcp, Fid fid, Inp inp, Lcp lcp, Fbc fbc, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : performanceCls, (i & 2) != 0 ? null : fcp, (i & 4) != 0 ? null : fid, (i & 8) != 0 ? null : inp, (i & 16) != 0 ? null : lcp, (i & 32) != 0 ? null : fbc);
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            PerformanceCls performanceCls = this.cls;
            if (performanceCls != null) {
                jsonObject.add("cls", performanceCls.toJson());
            }
            Fcp fcp = this.fcp;
            if (fcp != null) {
                jsonObject.add("fcp", fcp.toJson());
            }
            Fid fid = this.fid;
            if (fid != null) {
                jsonObject.add("fid", fid.toJson());
            }
            Inp inp = this.inp;
            if (inp != null) {
                jsonObject.add("inp", inp.toJson());
            }
            Lcp lcp = this.lcp;
            if (lcp != null) {
                jsonObject.add("lcp", lcp.toJson());
            }
            Fbc fbc = this.fbc;
            if (fbc != null) {
                jsonObject.add("fbc", fbc.toJson());
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Performance fromJsonObject(JsonObject jsonObject) {
                JsonObject asJsonObject;
                JsonObject asJsonObject2;
                JsonObject asJsonObject3;
                JsonObject asJsonObject4;
                JsonObject asJsonObject5;
                JsonObject asJsonObject6;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get("cls");
                    Fbc fbcFromJsonObject = null;
                    PerformanceCls performanceClsFromJsonObject = (jsonElement == null || (asJsonObject6 = jsonElement.getAsJsonObject()) == null) ? null : PerformanceCls.Companion.fromJsonObject(asJsonObject6);
                    JsonElement jsonElement2 = jsonObject.get("fcp");
                    Fcp fcpFromJsonObject = (jsonElement2 == null || (asJsonObject5 = jsonElement2.getAsJsonObject()) == null) ? null : Fcp.Companion.fromJsonObject(asJsonObject5);
                    JsonElement jsonElement3 = jsonObject.get("fid");
                    Fid fidFromJsonObject = (jsonElement3 == null || (asJsonObject4 = jsonElement3.getAsJsonObject()) == null) ? null : Fid.Companion.fromJsonObject(asJsonObject4);
                    JsonElement jsonElement4 = jsonObject.get("inp");
                    Inp inpFromJsonObject = (jsonElement4 == null || (asJsonObject3 = jsonElement4.getAsJsonObject()) == null) ? null : Inp.Companion.fromJsonObject(asJsonObject3);
                    JsonElement jsonElement5 = jsonObject.get("lcp");
                    Lcp lcpFromJsonObject = (jsonElement5 == null || (asJsonObject2 = jsonElement5.getAsJsonObject()) == null) ? null : Lcp.Companion.fromJsonObject(asJsonObject2);
                    JsonElement jsonElement6 = jsonObject.get("fbc");
                    if (jsonElement6 != null && (asJsonObject = jsonElement6.getAsJsonObject()) != null) {
                        fbcFromJsonObject = Fbc.Companion.fromJsonObject(asJsonObject);
                    }
                    return new Performance(performanceClsFromJsonObject, fcpFromJsonObject, fidFromJsonObject, inpFromJsonObject, lcpFromJsonObject, fbcFromJsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Performance", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Performance", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Performance", e3);
                }
            }
        }
    }

    public static final class Accessibility {
        public static final Companion Companion = new Companion(null);
        private final Boolean assistiveSwitchEnabled;
        private final Boolean assistiveTouchEnabled;
        private final Boolean boldTextEnabled;
        private final Boolean buttonShapesEnabled;
        private final Boolean closedCaptioningEnabled;
        private final Boolean grayscaleEnabled;
        private final Boolean increaseContrastEnabled;
        private final Boolean invertColorsEnabled;
        private final Boolean monoAudioEnabled;
        private final Boolean onOffSwitchLabelsEnabled;
        private final Boolean reduceMotionEnabled;
        private final Boolean reduceTransparencyEnabled;
        private final Boolean reducedAnimationsEnabled;
        private final Boolean rtlEnabled;
        private final Boolean screenReaderEnabled;
        private final Boolean shakeToUndoEnabled;
        private final Boolean shouldDifferentiateWithoutColor;
        private final Boolean singleAppModeEnabled;
        private final Boolean speakScreenEnabled;
        private final Boolean speakSelectionEnabled;
        private final String textSize;
        private final Boolean videoAutoplayEnabled;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Accessibility)) {
                return false;
            }
            Accessibility accessibility = (Accessibility) obj;
            return Intrinsics.areEqual(this.textSize, accessibility.textSize) && Intrinsics.areEqual(this.screenReaderEnabled, accessibility.screenReaderEnabled) && Intrinsics.areEqual(this.boldTextEnabled, accessibility.boldTextEnabled) && Intrinsics.areEqual(this.reduceTransparencyEnabled, accessibility.reduceTransparencyEnabled) && Intrinsics.areEqual(this.reduceMotionEnabled, accessibility.reduceMotionEnabled) && Intrinsics.areEqual(this.buttonShapesEnabled, accessibility.buttonShapesEnabled) && Intrinsics.areEqual(this.invertColorsEnabled, accessibility.invertColorsEnabled) && Intrinsics.areEqual(this.increaseContrastEnabled, accessibility.increaseContrastEnabled) && Intrinsics.areEqual(this.assistiveSwitchEnabled, accessibility.assistiveSwitchEnabled) && Intrinsics.areEqual(this.assistiveTouchEnabled, accessibility.assistiveTouchEnabled) && Intrinsics.areEqual(this.videoAutoplayEnabled, accessibility.videoAutoplayEnabled) && Intrinsics.areEqual(this.closedCaptioningEnabled, accessibility.closedCaptioningEnabled) && Intrinsics.areEqual(this.monoAudioEnabled, accessibility.monoAudioEnabled) && Intrinsics.areEqual(this.shakeToUndoEnabled, accessibility.shakeToUndoEnabled) && Intrinsics.areEqual(this.reducedAnimationsEnabled, accessibility.reducedAnimationsEnabled) && Intrinsics.areEqual(this.shouldDifferentiateWithoutColor, accessibility.shouldDifferentiateWithoutColor) && Intrinsics.areEqual(this.grayscaleEnabled, accessibility.grayscaleEnabled) && Intrinsics.areEqual(this.singleAppModeEnabled, accessibility.singleAppModeEnabled) && Intrinsics.areEqual(this.onOffSwitchLabelsEnabled, accessibility.onOffSwitchLabelsEnabled) && Intrinsics.areEqual(this.speakScreenEnabled, accessibility.speakScreenEnabled) && Intrinsics.areEqual(this.speakSelectionEnabled, accessibility.speakSelectionEnabled) && Intrinsics.areEqual(this.rtlEnabled, accessibility.rtlEnabled);
        }

        public int hashCode() {
            String str = this.textSize;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            Boolean bool = this.screenReaderEnabled;
            int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
            Boolean bool2 = this.boldTextEnabled;
            int iHashCode3 = (iHashCode2 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Boolean bool3 = this.reduceTransparencyEnabled;
            int iHashCode4 = (iHashCode3 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
            Boolean bool4 = this.reduceMotionEnabled;
            int iHashCode5 = (iHashCode4 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
            Boolean bool5 = this.buttonShapesEnabled;
            int iHashCode6 = (iHashCode5 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
            Boolean bool6 = this.invertColorsEnabled;
            int iHashCode7 = (iHashCode6 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
            Boolean bool7 = this.increaseContrastEnabled;
            int iHashCode8 = (iHashCode7 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
            Boolean bool8 = this.assistiveSwitchEnabled;
            int iHashCode9 = (iHashCode8 + (bool8 == null ? 0 : bool8.hashCode())) * 31;
            Boolean bool9 = this.assistiveTouchEnabled;
            int iHashCode10 = (iHashCode9 + (bool9 == null ? 0 : bool9.hashCode())) * 31;
            Boolean bool10 = this.videoAutoplayEnabled;
            int iHashCode11 = (iHashCode10 + (bool10 == null ? 0 : bool10.hashCode())) * 31;
            Boolean bool11 = this.closedCaptioningEnabled;
            int iHashCode12 = (iHashCode11 + (bool11 == null ? 0 : bool11.hashCode())) * 31;
            Boolean bool12 = this.monoAudioEnabled;
            int iHashCode13 = (iHashCode12 + (bool12 == null ? 0 : bool12.hashCode())) * 31;
            Boolean bool13 = this.shakeToUndoEnabled;
            int iHashCode14 = (iHashCode13 + (bool13 == null ? 0 : bool13.hashCode())) * 31;
            Boolean bool14 = this.reducedAnimationsEnabled;
            int iHashCode15 = (iHashCode14 + (bool14 == null ? 0 : bool14.hashCode())) * 31;
            Boolean bool15 = this.shouldDifferentiateWithoutColor;
            int iHashCode16 = (iHashCode15 + (bool15 == null ? 0 : bool15.hashCode())) * 31;
            Boolean bool16 = this.grayscaleEnabled;
            int iHashCode17 = (iHashCode16 + (bool16 == null ? 0 : bool16.hashCode())) * 31;
            Boolean bool17 = this.singleAppModeEnabled;
            int iHashCode18 = (iHashCode17 + (bool17 == null ? 0 : bool17.hashCode())) * 31;
            Boolean bool18 = this.onOffSwitchLabelsEnabled;
            int iHashCode19 = (iHashCode18 + (bool18 == null ? 0 : bool18.hashCode())) * 31;
            Boolean bool19 = this.speakScreenEnabled;
            int iHashCode20 = (iHashCode19 + (bool19 == null ? 0 : bool19.hashCode())) * 31;
            Boolean bool20 = this.speakSelectionEnabled;
            int iHashCode21 = (iHashCode20 + (bool20 == null ? 0 : bool20.hashCode())) * 31;
            Boolean bool21 = this.rtlEnabled;
            return iHashCode21 + (bool21 != null ? bool21.hashCode() : 0);
        }

        public String toString() {
            return "Accessibility(textSize=" + this.textSize + ", screenReaderEnabled=" + this.screenReaderEnabled + ", boldTextEnabled=" + this.boldTextEnabled + ", reduceTransparencyEnabled=" + this.reduceTransparencyEnabled + ", reduceMotionEnabled=" + this.reduceMotionEnabled + ", buttonShapesEnabled=" + this.buttonShapesEnabled + ", invertColorsEnabled=" + this.invertColorsEnabled + ", increaseContrastEnabled=" + this.increaseContrastEnabled + ", assistiveSwitchEnabled=" + this.assistiveSwitchEnabled + ", assistiveTouchEnabled=" + this.assistiveTouchEnabled + ", videoAutoplayEnabled=" + this.videoAutoplayEnabled + ", closedCaptioningEnabled=" + this.closedCaptioningEnabled + ", monoAudioEnabled=" + this.monoAudioEnabled + ", shakeToUndoEnabled=" + this.shakeToUndoEnabled + ", reducedAnimationsEnabled=" + this.reducedAnimationsEnabled + ", shouldDifferentiateWithoutColor=" + this.shouldDifferentiateWithoutColor + ", grayscaleEnabled=" + this.grayscaleEnabled + ", singleAppModeEnabled=" + this.singleAppModeEnabled + ", onOffSwitchLabelsEnabled=" + this.onOffSwitchLabelsEnabled + ", speakScreenEnabled=" + this.speakScreenEnabled + ", speakSelectionEnabled=" + this.speakSelectionEnabled + ", rtlEnabled=" + this.rtlEnabled + ")";
        }

        public Accessibility(String str, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, Boolean bool12, Boolean bool13, Boolean bool14, Boolean bool15, Boolean bool16, Boolean bool17, Boolean bool18, Boolean bool19, Boolean bool20, Boolean bool21) {
            this.textSize = str;
            this.screenReaderEnabled = bool;
            this.boldTextEnabled = bool2;
            this.reduceTransparencyEnabled = bool3;
            this.reduceMotionEnabled = bool4;
            this.buttonShapesEnabled = bool5;
            this.invertColorsEnabled = bool6;
            this.increaseContrastEnabled = bool7;
            this.assistiveSwitchEnabled = bool8;
            this.assistiveTouchEnabled = bool9;
            this.videoAutoplayEnabled = bool10;
            this.closedCaptioningEnabled = bool11;
            this.monoAudioEnabled = bool12;
            this.shakeToUndoEnabled = bool13;
            this.reducedAnimationsEnabled = bool14;
            this.shouldDifferentiateWithoutColor = bool15;
            this.grayscaleEnabled = bool16;
            this.singleAppModeEnabled = bool17;
            this.onOffSwitchLabelsEnabled = bool18;
            this.speakScreenEnabled = bool19;
            this.speakSelectionEnabled = bool20;
            this.rtlEnabled = bool21;
        }

        public /* synthetic */ Accessibility(String str, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, Boolean bool12, Boolean bool13, Boolean bool14, Boolean bool15, Boolean bool16, Boolean bool17, Boolean bool18, Boolean bool19, Boolean bool20, Boolean bool21, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : bool2, (i & 8) != 0 ? null : bool3, (i & 16) != 0 ? null : bool4, (i & 32) != 0 ? null : bool5, (i & 64) != 0 ? null : bool6, (i & 128) != 0 ? null : bool7, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : bool8, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? null : bool9, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : bool10, (i & 2048) != 0 ? null : bool11, (i & 4096) != 0 ? null : bool12, (i & 8192) != 0 ? null : bool13, (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? null : bool14, (i & 32768) != 0 ? null : bool15, (i & 65536) != 0 ? null : bool16, (i & 131072) != 0 ? null : bool17, (i & 262144) != 0 ? null : bool18, (i & 524288) != 0 ? null : bool19, (i & 1048576) != 0 ? null : bool20, (i & 2097152) != 0 ? null : bool21);
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            String str = this.textSize;
            if (str != null) {
                jsonObject.addProperty("text_size", str);
            }
            Boolean bool = this.screenReaderEnabled;
            if (bool != null) {
                jsonObject.addProperty("screen_reader_enabled", bool);
            }
            Boolean bool2 = this.boldTextEnabled;
            if (bool2 != null) {
                jsonObject.addProperty("bold_text_enabled", bool2);
            }
            Boolean bool3 = this.reduceTransparencyEnabled;
            if (bool3 != null) {
                jsonObject.addProperty("reduce_transparency_enabled", bool3);
            }
            Boolean bool4 = this.reduceMotionEnabled;
            if (bool4 != null) {
                jsonObject.addProperty("reduce_motion_enabled", bool4);
            }
            Boolean bool5 = this.buttonShapesEnabled;
            if (bool5 != null) {
                jsonObject.addProperty("button_shapes_enabled", bool5);
            }
            Boolean bool6 = this.invertColorsEnabled;
            if (bool6 != null) {
                jsonObject.addProperty("invert_colors_enabled", bool6);
            }
            Boolean bool7 = this.increaseContrastEnabled;
            if (bool7 != null) {
                jsonObject.addProperty("increase_contrast_enabled", bool7);
            }
            Boolean bool8 = this.assistiveSwitchEnabled;
            if (bool8 != null) {
                jsonObject.addProperty("assistive_switch_enabled", bool8);
            }
            Boolean bool9 = this.assistiveTouchEnabled;
            if (bool9 != null) {
                jsonObject.addProperty("assistive_touch_enabled", bool9);
            }
            Boolean bool10 = this.videoAutoplayEnabled;
            if (bool10 != null) {
                jsonObject.addProperty("video_autoplay_enabled", bool10);
            }
            Boolean bool11 = this.closedCaptioningEnabled;
            if (bool11 != null) {
                jsonObject.addProperty("closed_captioning_enabled", bool11);
            }
            Boolean bool12 = this.monoAudioEnabled;
            if (bool12 != null) {
                jsonObject.addProperty("mono_audio_enabled", bool12);
            }
            Boolean bool13 = this.shakeToUndoEnabled;
            if (bool13 != null) {
                jsonObject.addProperty("shake_to_undo_enabled", bool13);
            }
            Boolean bool14 = this.reducedAnimationsEnabled;
            if (bool14 != null) {
                jsonObject.addProperty("reduced_animations_enabled", bool14);
            }
            Boolean bool15 = this.shouldDifferentiateWithoutColor;
            if (bool15 != null) {
                jsonObject.addProperty("should_differentiate_without_color", bool15);
            }
            Boolean bool16 = this.grayscaleEnabled;
            if (bool16 != null) {
                jsonObject.addProperty("grayscale_enabled", bool16);
            }
            Boolean bool17 = this.singleAppModeEnabled;
            if (bool17 != null) {
                jsonObject.addProperty("single_app_mode_enabled", bool17);
            }
            Boolean bool18 = this.onOffSwitchLabelsEnabled;
            if (bool18 != null) {
                jsonObject.addProperty("on_off_switch_labels_enabled", bool18);
            }
            Boolean bool19 = this.speakScreenEnabled;
            if (bool19 != null) {
                jsonObject.addProperty("speak_screen_enabled", bool19);
            }
            Boolean bool20 = this.speakSelectionEnabled;
            if (bool20 != null) {
                jsonObject.addProperty("speak_selection_enabled", bool20);
            }
            Boolean bool21 = this.rtlEnabled;
            if (bool21 != null) {
                jsonObject.addProperty("rtl_enabled", bool21);
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Accessibility fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get("text_size");
                    String asString = jsonElement != null ? jsonElement.getAsString() : null;
                    JsonElement jsonElement2 = jsonObject.get("screen_reader_enabled");
                    Boolean boolValueOf = jsonElement2 != null ? Boolean.valueOf(jsonElement2.getAsBoolean()) : null;
                    JsonElement jsonElement3 = jsonObject.get("bold_text_enabled");
                    Boolean boolValueOf2 = jsonElement3 != null ? Boolean.valueOf(jsonElement3.getAsBoolean()) : null;
                    JsonElement jsonElement4 = jsonObject.get("reduce_transparency_enabled");
                    Boolean boolValueOf3 = jsonElement4 != null ? Boolean.valueOf(jsonElement4.getAsBoolean()) : null;
                    JsonElement jsonElement5 = jsonObject.get("reduce_motion_enabled");
                    Boolean boolValueOf4 = jsonElement5 != null ? Boolean.valueOf(jsonElement5.getAsBoolean()) : null;
                    JsonElement jsonElement6 = jsonObject.get("button_shapes_enabled");
                    Boolean boolValueOf5 = jsonElement6 != null ? Boolean.valueOf(jsonElement6.getAsBoolean()) : null;
                    JsonElement jsonElement7 = jsonObject.get("invert_colors_enabled");
                    Boolean boolValueOf6 = jsonElement7 != null ? Boolean.valueOf(jsonElement7.getAsBoolean()) : null;
                    JsonElement jsonElement8 = jsonObject.get("increase_contrast_enabled");
                    Boolean boolValueOf7 = jsonElement8 != null ? Boolean.valueOf(jsonElement8.getAsBoolean()) : null;
                    JsonElement jsonElement9 = jsonObject.get("assistive_switch_enabled");
                    Boolean boolValueOf8 = jsonElement9 != null ? Boolean.valueOf(jsonElement9.getAsBoolean()) : null;
                    JsonElement jsonElement10 = jsonObject.get("assistive_touch_enabled");
                    Boolean boolValueOf9 = jsonElement10 != null ? Boolean.valueOf(jsonElement10.getAsBoolean()) : null;
                    JsonElement jsonElement11 = jsonObject.get("video_autoplay_enabled");
                    Boolean boolValueOf10 = jsonElement11 != null ? Boolean.valueOf(jsonElement11.getAsBoolean()) : null;
                    JsonElement jsonElement12 = jsonObject.get("closed_captioning_enabled");
                    Boolean boolValueOf11 = jsonElement12 != null ? Boolean.valueOf(jsonElement12.getAsBoolean()) : null;
                    JsonElement jsonElement13 = jsonObject.get("mono_audio_enabled");
                    Boolean boolValueOf12 = jsonElement13 != null ? Boolean.valueOf(jsonElement13.getAsBoolean()) : null;
                    JsonElement jsonElement14 = jsonObject.get("shake_to_undo_enabled");
                    Boolean boolValueOf13 = jsonElement14 != null ? Boolean.valueOf(jsonElement14.getAsBoolean()) : null;
                    String str = asString;
                    JsonElement jsonElement15 = jsonObject.get("reduced_animations_enabled");
                    Boolean boolValueOf14 = jsonElement15 != null ? Boolean.valueOf(jsonElement15.getAsBoolean()) : null;
                    JsonElement jsonElement16 = jsonObject.get("should_differentiate_without_color");
                    Boolean boolValueOf15 = jsonElement16 != null ? Boolean.valueOf(jsonElement16.getAsBoolean()) : null;
                    JsonElement jsonElement17 = jsonObject.get("grayscale_enabled");
                    Boolean boolValueOf16 = jsonElement17 != null ? Boolean.valueOf(jsonElement17.getAsBoolean()) : null;
                    JsonElement jsonElement18 = jsonObject.get("single_app_mode_enabled");
                    Boolean boolValueOf17 = jsonElement18 != null ? Boolean.valueOf(jsonElement18.getAsBoolean()) : null;
                    JsonElement jsonElement19 = jsonObject.get("on_off_switch_labels_enabled");
                    Boolean boolValueOf18 = jsonElement19 != null ? Boolean.valueOf(jsonElement19.getAsBoolean()) : null;
                    JsonElement jsonElement20 = jsonObject.get("speak_screen_enabled");
                    Boolean boolValueOf19 = jsonElement20 != null ? Boolean.valueOf(jsonElement20.getAsBoolean()) : null;
                    JsonElement jsonElement21 = jsonObject.get("speak_selection_enabled");
                    Boolean boolValueOf20 = jsonElement21 != null ? Boolean.valueOf(jsonElement21.getAsBoolean()) : null;
                    JsonElement jsonElement22 = jsonObject.get("rtl_enabled");
                    return new Accessibility(str, boolValueOf, boolValueOf2, boolValueOf3, boolValueOf4, boolValueOf5, boolValueOf6, boolValueOf7, boolValueOf8, boolValueOf9, boolValueOf10, boolValueOf11, boolValueOf12, boolValueOf13, boolValueOf14, boolValueOf15, boolValueOf16, boolValueOf17, boolValueOf18, boolValueOf19, boolValueOf20, jsonElement22 != null ? Boolean.valueOf(jsonElement22.getAsBoolean()) : null);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Accessibility", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Accessibility", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Accessibility", e3);
                }
            }
        }
    }

    public static final class Cellular {
        public static final Companion Companion = new Companion(null);
        private final String carrierName;
        private final String technology;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Cellular)) {
                return false;
            }
            Cellular cellular = (Cellular) obj;
            return Intrinsics.areEqual(this.technology, cellular.technology) && Intrinsics.areEqual(this.carrierName, cellular.carrierName);
        }

        public int hashCode() {
            String str = this.technology;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.carrierName;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Cellular(technology=" + this.technology + ", carrierName=" + this.carrierName + ")";
        }

        public Cellular(String str, String str2) {
            this.technology = str;
            this.carrierName = str2;
        }

        public final String getTechnology() {
            return this.technology;
        }

        public final String getCarrierName() {
            return this.carrierName;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            String str = this.technology;
            if (str != null) {
                jsonObject.addProperty("technology", str);
            }
            String str2 = this.carrierName;
            if (str2 != null) {
                jsonObject.addProperty("carrier_name", str2);
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Cellular fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get("technology");
                    String asString = jsonElement != null ? jsonElement.getAsString() : null;
                    JsonElement jsonElement2 = jsonObject.get("carrier_name");
                    return new Cellular(asString, jsonElement2 != null ? jsonElement2.getAsString() : null);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Cellular", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Cellular", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Cellular", e3);
                }
            }
        }
    }

    public static final class Viewport {
        public static final Companion Companion = new Companion(null);
        private final Number height;
        private final Number width;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Viewport)) {
                return false;
            }
            Viewport viewport = (Viewport) obj;
            return Intrinsics.areEqual(this.width, viewport.width) && Intrinsics.areEqual(this.height, viewport.height);
        }

        public int hashCode() {
            return (this.width.hashCode() * 31) + this.height.hashCode();
        }

        public String toString() {
            return "Viewport(width=" + this.width + ", height=" + this.height + ")";
        }

        public Viewport(Number width, Number height) {
            Intrinsics.checkNotNullParameter(width, "width");
            Intrinsics.checkNotNullParameter(height, "height");
            this.width = width;
            this.height = height;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("width", this.width);
            jsonObject.addProperty("height", this.height);
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Viewport fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    Number width = jsonObject.get("width").getAsNumber();
                    Number height = jsonObject.get("height").getAsNumber();
                    Intrinsics.checkNotNullExpressionValue(width, "width");
                    Intrinsics.checkNotNullExpressionValue(height, "height");
                    return new Viewport(width, height);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Viewport", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Viewport", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Viewport", e3);
                }
            }
        }
    }

    public static final class Scroll {
        public static final Companion Companion = new Companion(null);
        private final Number maxDepth;
        private final Number maxDepthScrollTop;
        private final Number maxScrollHeight;
        private final Number maxScrollHeightTime;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Scroll)) {
                return false;
            }
            Scroll scroll = (Scroll) obj;
            return Intrinsics.areEqual(this.maxDepth, scroll.maxDepth) && Intrinsics.areEqual(this.maxDepthScrollTop, scroll.maxDepthScrollTop) && Intrinsics.areEqual(this.maxScrollHeight, scroll.maxScrollHeight) && Intrinsics.areEqual(this.maxScrollHeightTime, scroll.maxScrollHeightTime);
        }

        public int hashCode() {
            return (((((this.maxDepth.hashCode() * 31) + this.maxDepthScrollTop.hashCode()) * 31) + this.maxScrollHeight.hashCode()) * 31) + this.maxScrollHeightTime.hashCode();
        }

        public String toString() {
            return "Scroll(maxDepth=" + this.maxDepth + ", maxDepthScrollTop=" + this.maxDepthScrollTop + ", maxScrollHeight=" + this.maxScrollHeight + ", maxScrollHeightTime=" + this.maxScrollHeightTime + ")";
        }

        public Scroll(Number maxDepth, Number maxDepthScrollTop, Number maxScrollHeight, Number maxScrollHeightTime) {
            Intrinsics.checkNotNullParameter(maxDepth, "maxDepth");
            Intrinsics.checkNotNullParameter(maxDepthScrollTop, "maxDepthScrollTop");
            Intrinsics.checkNotNullParameter(maxScrollHeight, "maxScrollHeight");
            Intrinsics.checkNotNullParameter(maxScrollHeightTime, "maxScrollHeightTime");
            this.maxDepth = maxDepth;
            this.maxDepthScrollTop = maxDepthScrollTop;
            this.maxScrollHeight = maxScrollHeight;
            this.maxScrollHeightTime = maxScrollHeightTime;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("max_depth", this.maxDepth);
            jsonObject.addProperty("max_depth_scroll_top", this.maxDepthScrollTop);
            jsonObject.addProperty("max_scroll_height", this.maxScrollHeight);
            jsonObject.addProperty("max_scroll_height_time", this.maxScrollHeightTime);
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Scroll fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    Number maxDepth = jsonObject.get("max_depth").getAsNumber();
                    Number maxDepthScrollTop = jsonObject.get("max_depth_scroll_top").getAsNumber();
                    Number maxScrollHeight = jsonObject.get("max_scroll_height").getAsNumber();
                    Number maxScrollHeightTime = jsonObject.get("max_scroll_height_time").getAsNumber();
                    Intrinsics.checkNotNullExpressionValue(maxDepth, "maxDepth");
                    Intrinsics.checkNotNullExpressionValue(maxDepthScrollTop, "maxDepthScrollTop");
                    Intrinsics.checkNotNullExpressionValue(maxScrollHeight, "maxScrollHeight");
                    Intrinsics.checkNotNullExpressionValue(maxScrollHeightTime, "maxScrollHeightTime");
                    return new Scroll(maxDepth, maxDepthScrollTop, maxScrollHeight, maxScrollHeightTime);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Scroll", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Scroll", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Scroll", e3);
                }
            }
        }
    }

    public static final class DdSession {
        public static final Companion Companion = new Companion(null);
        private final Plan plan;
        private final SessionPrecondition sessionPrecondition;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DdSession)) {
                return false;
            }
            DdSession ddSession = (DdSession) obj;
            return this.plan == ddSession.plan && this.sessionPrecondition == ddSession.sessionPrecondition;
        }

        public int hashCode() {
            Plan plan = this.plan;
            int iHashCode = (plan == null ? 0 : plan.hashCode()) * 31;
            SessionPrecondition sessionPrecondition = this.sessionPrecondition;
            return iHashCode + (sessionPrecondition != null ? sessionPrecondition.hashCode() : 0);
        }

        public String toString() {
            return "DdSession(plan=" + this.plan + ", sessionPrecondition=" + this.sessionPrecondition + ")";
        }

        public DdSession(Plan plan, SessionPrecondition sessionPrecondition) {
            this.plan = plan;
            this.sessionPrecondition = sessionPrecondition;
        }

        public /* synthetic */ DdSession(Plan plan, SessionPrecondition sessionPrecondition, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : plan, (i & 2) != 0 ? null : sessionPrecondition);
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            Plan plan = this.plan;
            if (plan != null) {
                jsonObject.add("plan", plan.toJson());
            }
            SessionPrecondition sessionPrecondition = this.sessionPrecondition;
            if (sessionPrecondition != null) {
                jsonObject.add("session_precondition", sessionPrecondition.toJson());
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final DdSession fromJsonObject(JsonObject jsonObject) {
                String asString;
                String asString2;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get("plan");
                    SessionPrecondition sessionPreconditionFromJson = null;
                    Plan planFromJson = (jsonElement == null || (asString2 = jsonElement.getAsString()) == null) ? null : Plan.Companion.fromJson(asString2);
                    JsonElement jsonElement2 = jsonObject.get("session_precondition");
                    if (jsonElement2 != null && (asString = jsonElement2.getAsString()) != null) {
                        sessionPreconditionFromJson = SessionPrecondition.Companion.fromJson(asString);
                    }
                    return new DdSession(planFromJson, sessionPreconditionFromJson);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type DdSession", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type DdSession", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type DdSession", e3);
                }
            }
        }
    }

    public static final class Configuration {
        public static final Companion Companion = new Companion(null);
        private final Number profilingSampleRate;
        private final Number sessionReplaySampleRate;
        private final Number sessionSampleRate;
        private final Boolean startSessionReplayRecordingManually;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Configuration)) {
                return false;
            }
            Configuration configuration = (Configuration) obj;
            return Intrinsics.areEqual(this.sessionSampleRate, configuration.sessionSampleRate) && Intrinsics.areEqual(this.sessionReplaySampleRate, configuration.sessionReplaySampleRate) && Intrinsics.areEqual(this.profilingSampleRate, configuration.profilingSampleRate) && Intrinsics.areEqual(this.startSessionReplayRecordingManually, configuration.startSessionReplayRecordingManually);
        }

        public int hashCode() {
            int iHashCode = this.sessionSampleRate.hashCode() * 31;
            Number number = this.sessionReplaySampleRate;
            int iHashCode2 = (iHashCode + (number == null ? 0 : number.hashCode())) * 31;
            Number number2 = this.profilingSampleRate;
            int iHashCode3 = (iHashCode2 + (number2 == null ? 0 : number2.hashCode())) * 31;
            Boolean bool = this.startSessionReplayRecordingManually;
            return iHashCode3 + (bool != null ? bool.hashCode() : 0);
        }

        public String toString() {
            return "Configuration(sessionSampleRate=" + this.sessionSampleRate + ", sessionReplaySampleRate=" + this.sessionReplaySampleRate + ", profilingSampleRate=" + this.profilingSampleRate + ", startSessionReplayRecordingManually=" + this.startSessionReplayRecordingManually + ")";
        }

        public Configuration(Number sessionSampleRate, Number number, Number number2, Boolean bool) {
            Intrinsics.checkNotNullParameter(sessionSampleRate, "sessionSampleRate");
            this.sessionSampleRate = sessionSampleRate;
            this.sessionReplaySampleRate = number;
            this.profilingSampleRate = number2;
            this.startSessionReplayRecordingManually = bool;
        }

        public /* synthetic */ Configuration(Number number, Number number2, Number number3, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(number, (i & 2) != 0 ? null : number2, (i & 4) != 0 ? null : number3, (i & 8) != 0 ? null : bool);
        }

        public final Number getSessionSampleRate() {
            return this.sessionSampleRate;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("session_sample_rate", this.sessionSampleRate);
            Number number = this.sessionReplaySampleRate;
            if (number != null) {
                jsonObject.addProperty("session_replay_sample_rate", number);
            }
            Number number2 = this.profilingSampleRate;
            if (number2 != null) {
                jsonObject.addProperty("profiling_sample_rate", number2);
            }
            Boolean bool = this.startSessionReplayRecordingManually;
            if (bool != null) {
                jsonObject.addProperty("start_session_replay_recording_manually", bool);
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Configuration fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    Number sessionSampleRate = jsonObject.get("session_sample_rate").getAsNumber();
                    JsonElement jsonElement = jsonObject.get("session_replay_sample_rate");
                    Number asNumber = jsonElement != null ? jsonElement.getAsNumber() : null;
                    JsonElement jsonElement2 = jsonObject.get("profiling_sample_rate");
                    Number asNumber2 = jsonElement2 != null ? jsonElement2.getAsNumber() : null;
                    JsonElement jsonElement3 = jsonObject.get("start_session_replay_recording_manually");
                    Boolean boolValueOf = jsonElement3 != null ? Boolean.valueOf(jsonElement3.getAsBoolean()) : null;
                    Intrinsics.checkNotNullExpressionValue(sessionSampleRate, "sessionSampleRate");
                    return new Configuration(sessionSampleRate, asNumber, asNumber2, boolValueOf);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Configuration", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Configuration", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Configuration", e3);
                }
            }
        }
    }

    public static final class PageState {
        public static final Companion Companion = new Companion(null);
        private final long start;
        private final State state;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PageState)) {
                return false;
            }
            PageState pageState = (PageState) obj;
            return this.state == pageState.state && this.start == pageState.start;
        }

        public int hashCode() {
            return (this.state.hashCode() * 31) + Long.hashCode(this.start);
        }

        public String toString() {
            return "PageState(state=" + this.state + ", start=" + this.start + ")";
        }

        public PageState(State state, long j) {
            Intrinsics.checkNotNullParameter(state, "state");
            this.state = state;
            this.start = j;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("state", this.state.toJson());
            jsonObject.addProperty("start", Long.valueOf(this.start));
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final PageState fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    State.Companion companion = State.Companion;
                    String asString = jsonObject.get("state").getAsString();
                    Intrinsics.checkNotNullExpressionValue(asString, "jsonObject.get(\"state\").asString");
                    return new PageState(companion.fromJson(asString), jsonObject.get("start").getAsLong());
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type PageState", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type PageState", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type PageState", e3);
                }
            }
        }
    }

    public static final class ReplayStats {
        public static final Companion Companion = new Companion(null);
        private final Long recordsCount;
        private final Long segmentsCount;
        private final Long segmentsTotalRawSize;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ReplayStats)) {
                return false;
            }
            ReplayStats replayStats = (ReplayStats) obj;
            return Intrinsics.areEqual(this.recordsCount, replayStats.recordsCount) && Intrinsics.areEqual(this.segmentsCount, replayStats.segmentsCount) && Intrinsics.areEqual(this.segmentsTotalRawSize, replayStats.segmentsTotalRawSize);
        }

        public int hashCode() {
            Long l = this.recordsCount;
            int iHashCode = (l == null ? 0 : l.hashCode()) * 31;
            Long l2 = this.segmentsCount;
            int iHashCode2 = (iHashCode + (l2 == null ? 0 : l2.hashCode())) * 31;
            Long l3 = this.segmentsTotalRawSize;
            return iHashCode2 + (l3 != null ? l3.hashCode() : 0);
        }

        public String toString() {
            return "ReplayStats(recordsCount=" + this.recordsCount + ", segmentsCount=" + this.segmentsCount + ", segmentsTotalRawSize=" + this.segmentsTotalRawSize + ")";
        }

        public ReplayStats(Long l, Long l2, Long l3) {
            this.recordsCount = l;
            this.segmentsCount = l2;
            this.segmentsTotalRawSize = l3;
        }

        public /* synthetic */ ReplayStats(Long l, Long l2, Long l3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 0L : l, (i & 2) != 0 ? 0L : l2, (i & 4) != 0 ? 0L : l3);
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            Long l = this.recordsCount;
            if (l != null) {
                jsonObject.addProperty("records_count", Long.valueOf(l.longValue()));
            }
            Long l2 = this.segmentsCount;
            if (l2 != null) {
                jsonObject.addProperty("segments_count", Long.valueOf(l2.longValue()));
            }
            Long l3 = this.segmentsTotalRawSize;
            if (l3 != null) {
                jsonObject.addProperty("segments_total_raw_size", Long.valueOf(l3.longValue()));
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final ReplayStats fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get("records_count");
                    Long lValueOf = jsonElement != null ? Long.valueOf(jsonElement.getAsLong()) : null;
                    JsonElement jsonElement2 = jsonObject.get("segments_count");
                    Long lValueOf2 = jsonElement2 != null ? Long.valueOf(jsonElement2.getAsLong()) : null;
                    JsonElement jsonElement3 = jsonObject.get("segments_total_raw_size");
                    return new ReplayStats(lValueOf, lValueOf2, jsonElement3 != null ? Long.valueOf(jsonElement3.getAsLong()) : null);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type ReplayStats", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type ReplayStats", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type ReplayStats", e3);
                }
            }
        }
    }

    public static final class DdCls {
        public static final Companion Companion = new Companion(null);
        private final Number devicePixelRatio;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DdCls) && Intrinsics.areEqual(this.devicePixelRatio, ((DdCls) obj).devicePixelRatio);
        }

        public int hashCode() {
            Number number = this.devicePixelRatio;
            if (number == null) {
                return 0;
            }
            return number.hashCode();
        }

        public String toString() {
            return "DdCls(devicePixelRatio=" + this.devicePixelRatio + ")";
        }

        public DdCls(Number number) {
            this.devicePixelRatio = number;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            Number number = this.devicePixelRatio;
            if (number != null) {
                jsonObject.addProperty("device_pixel_ratio", number);
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final DdCls fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get("device_pixel_ratio");
                    return new DdCls(jsonElement != null ? jsonElement.getAsNumber() : null);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type DdCls", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type DdCls", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type DdCls", e3);
                }
            }
        }
    }

    public static final class Profiling {
        public static final Companion Companion = new Companion(null);
        private final ErrorReason errorReason;
        private final ProfilingStatus status;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Profiling)) {
                return false;
            }
            Profiling profiling = (Profiling) obj;
            return this.status == profiling.status && this.errorReason == profiling.errorReason;
        }

        public int hashCode() {
            ProfilingStatus profilingStatus = this.status;
            int iHashCode = (profilingStatus == null ? 0 : profilingStatus.hashCode()) * 31;
            ErrorReason errorReason = this.errorReason;
            return iHashCode + (errorReason != null ? errorReason.hashCode() : 0);
        }

        public String toString() {
            return "Profiling(status=" + this.status + ", errorReason=" + this.errorReason + ")";
        }

        public Profiling(ProfilingStatus profilingStatus, ErrorReason errorReason) {
            this.status = profilingStatus;
            this.errorReason = errorReason;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            ProfilingStatus profilingStatus = this.status;
            if (profilingStatus != null) {
                jsonObject.add("status", profilingStatus.toJson());
            }
            ErrorReason errorReason = this.errorReason;
            if (errorReason != null) {
                jsonObject.add("error_reason", errorReason.toJson());
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Profiling fromJsonObject(JsonObject jsonObject) {
                String asString;
                String asString2;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get("status");
                    ErrorReason errorReasonFromJson = null;
                    ProfilingStatus profilingStatusFromJson = (jsonElement == null || (asString2 = jsonElement.getAsString()) == null) ? null : ProfilingStatus.Companion.fromJson(asString2);
                    JsonElement jsonElement2 = jsonObject.get("error_reason");
                    if (jsonElement2 != null && (asString = jsonElement2.getAsString()) != null) {
                        errorReasonFromJson = ErrorReason.Companion.fromJson(asString);
                    }
                    return new Profiling(profilingStatusFromJson, errorReasonFromJson);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Profiling", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Profiling", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Profiling", e3);
                }
            }
        }
    }

    public static final class ContainerView {
        public static final Companion Companion = new Companion(null);
        private final String id;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ContainerView) && Intrinsics.areEqual(this.id, ((ContainerView) obj).id);
        }

        public int hashCode() {
            return this.id.hashCode();
        }

        public String toString() {
            return "ContainerView(id=" + this.id + ")";
        }

        public ContainerView(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(DiagnosticsEntry.ID_KEY, this.id);
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final ContainerView fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String id = jsonObject.get(DiagnosticsEntry.ID_KEY).getAsString();
                    Intrinsics.checkNotNullExpressionValue(id, "id");
                    return new ContainerView(id);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type ContainerView", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type ContainerView", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type ContainerView", e3);
                }
            }
        }
    }

    public static final class PerformanceCls {
        public static final Companion Companion = new Companion(null);
        private final PreviousRect currentRect;
        private final PreviousRect previousRect;
        private final Number score;
        private final String targetSelector;
        private final Long timestamp;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PerformanceCls)) {
                return false;
            }
            PerformanceCls performanceCls = (PerformanceCls) obj;
            return Intrinsics.areEqual(this.score, performanceCls.score) && Intrinsics.areEqual(this.timestamp, performanceCls.timestamp) && Intrinsics.areEqual(this.targetSelector, performanceCls.targetSelector) && Intrinsics.areEqual(this.previousRect, performanceCls.previousRect) && Intrinsics.areEqual(this.currentRect, performanceCls.currentRect);
        }

        public int hashCode() {
            int iHashCode = this.score.hashCode() * 31;
            Long l = this.timestamp;
            int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
            String str = this.targetSelector;
            int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            PreviousRect previousRect = this.previousRect;
            int iHashCode4 = (iHashCode3 + (previousRect == null ? 0 : previousRect.hashCode())) * 31;
            PreviousRect previousRect2 = this.currentRect;
            return iHashCode4 + (previousRect2 != null ? previousRect2.hashCode() : 0);
        }

        public String toString() {
            return "PerformanceCls(score=" + this.score + ", timestamp=" + this.timestamp + ", targetSelector=" + this.targetSelector + ", previousRect=" + this.previousRect + ", currentRect=" + this.currentRect + ")";
        }

        public PerformanceCls(Number score, Long l, String str, PreviousRect previousRect, PreviousRect previousRect2) {
            Intrinsics.checkNotNullParameter(score, "score");
            this.score = score;
            this.timestamp = l;
            this.targetSelector = str;
            this.previousRect = previousRect;
            this.currentRect = previousRect2;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("score", this.score);
            Long l = this.timestamp;
            if (l != null) {
                jsonObject.addProperty(DiagnosticsEntry.TIMESTAMP_KEY, Long.valueOf(l.longValue()));
            }
            String str = this.targetSelector;
            if (str != null) {
                jsonObject.addProperty("target_selector", str);
            }
            PreviousRect previousRect = this.previousRect;
            if (previousRect != null) {
                jsonObject.add("previous_rect", previousRect.toJson());
            }
            PreviousRect previousRect2 = this.currentRect;
            if (previousRect2 != null) {
                jsonObject.add("current_rect", previousRect2.toJson());
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final PerformanceCls fromJsonObject(JsonObject jsonObject) {
                JsonObject asJsonObject;
                JsonObject asJsonObject2;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    Number score = jsonObject.get("score").getAsNumber();
                    JsonElement jsonElement = jsonObject.get(DiagnosticsEntry.TIMESTAMP_KEY);
                    PreviousRect previousRectFromJsonObject = null;
                    Long lValueOf = jsonElement != null ? Long.valueOf(jsonElement.getAsLong()) : null;
                    JsonElement jsonElement2 = jsonObject.get("target_selector");
                    String asString = jsonElement2 != null ? jsonElement2.getAsString() : null;
                    JsonElement jsonElement3 = jsonObject.get("previous_rect");
                    PreviousRect previousRectFromJsonObject2 = (jsonElement3 == null || (asJsonObject2 = jsonElement3.getAsJsonObject()) == null) ? null : PreviousRect.Companion.fromJsonObject(asJsonObject2);
                    JsonElement jsonElement4 = jsonObject.get("current_rect");
                    if (jsonElement4 != null && (asJsonObject = jsonElement4.getAsJsonObject()) != null) {
                        previousRectFromJsonObject = PreviousRect.Companion.fromJsonObject(asJsonObject);
                    }
                    Intrinsics.checkNotNullExpressionValue(score, "score");
                    return new PerformanceCls(score, lValueOf, asString, previousRectFromJsonObject2, previousRectFromJsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type PerformanceCls", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type PerformanceCls", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type PerformanceCls", e3);
                }
            }
        }
    }

    public static final class Fcp {
        public static final Companion Companion = new Companion(null);
        private final long timestamp;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Fcp) && this.timestamp == ((Fcp) obj).timestamp;
        }

        public int hashCode() {
            return Long.hashCode(this.timestamp);
        }

        public String toString() {
            return "Fcp(timestamp=" + this.timestamp + ")";
        }

        public Fcp(long j) {
            this.timestamp = j;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(DiagnosticsEntry.TIMESTAMP_KEY, Long.valueOf(this.timestamp));
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Fcp fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    return new Fcp(jsonObject.get(DiagnosticsEntry.TIMESTAMP_KEY).getAsLong());
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Fcp", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Fcp", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Fcp", e3);
                }
            }
        }
    }

    public static final class Fid {
        public static final Companion Companion = new Companion(null);
        private final long duration;
        private final String targetSelector;
        private final long timestamp;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Fid)) {
                return false;
            }
            Fid fid = (Fid) obj;
            return this.duration == fid.duration && this.timestamp == fid.timestamp && Intrinsics.areEqual(this.targetSelector, fid.targetSelector);
        }

        public int hashCode() {
            int iHashCode = ((Long.hashCode(this.duration) * 31) + Long.hashCode(this.timestamp)) * 31;
            String str = this.targetSelector;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Fid(duration=" + this.duration + ", timestamp=" + this.timestamp + ", targetSelector=" + this.targetSelector + ")";
        }

        public Fid(long j, long j2, String str) {
            this.duration = j;
            this.timestamp = j2;
            this.targetSelector = str;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("duration", Long.valueOf(this.duration));
            jsonObject.addProperty(DiagnosticsEntry.TIMESTAMP_KEY, Long.valueOf(this.timestamp));
            String str = this.targetSelector;
            if (str != null) {
                jsonObject.addProperty("target_selector", str);
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Fid fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    long asLong = jsonObject.get("duration").getAsLong();
                    long asLong2 = jsonObject.get(DiagnosticsEntry.TIMESTAMP_KEY).getAsLong();
                    JsonElement jsonElement = jsonObject.get("target_selector");
                    return new Fid(asLong, asLong2, jsonElement != null ? jsonElement.getAsString() : null);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Fid", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Fid", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Fid", e3);
                }
            }
        }
    }

    public static final class Inp {
        public static final Companion Companion = new Companion(null);
        private final long duration;
        private final String targetSelector;
        private final Long timestamp;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Inp)) {
                return false;
            }
            Inp inp = (Inp) obj;
            return this.duration == inp.duration && Intrinsics.areEqual(this.timestamp, inp.timestamp) && Intrinsics.areEqual(this.targetSelector, inp.targetSelector);
        }

        public int hashCode() {
            int iHashCode = Long.hashCode(this.duration) * 31;
            Long l = this.timestamp;
            int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
            String str = this.targetSelector;
            return iHashCode2 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "Inp(duration=" + this.duration + ", timestamp=" + this.timestamp + ", targetSelector=" + this.targetSelector + ")";
        }

        public Inp(long j, Long l, String str) {
            this.duration = j;
            this.timestamp = l;
            this.targetSelector = str;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("duration", Long.valueOf(this.duration));
            Long l = this.timestamp;
            if (l != null) {
                jsonObject.addProperty(DiagnosticsEntry.TIMESTAMP_KEY, Long.valueOf(l.longValue()));
            }
            String str = this.targetSelector;
            if (str != null) {
                jsonObject.addProperty("target_selector", str);
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Inp fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    long asLong = jsonObject.get("duration").getAsLong();
                    JsonElement jsonElement = jsonObject.get(DiagnosticsEntry.TIMESTAMP_KEY);
                    Long lValueOf = jsonElement != null ? Long.valueOf(jsonElement.getAsLong()) : null;
                    JsonElement jsonElement2 = jsonObject.get("target_selector");
                    return new Inp(asLong, lValueOf, jsonElement2 != null ? jsonElement2.getAsString() : null);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Inp", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Inp", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Inp", e3);
                }
            }
        }
    }

    public static final class Lcp {
        public static final Companion Companion = new Companion(null);
        private String resourceUrl;
        private final String targetSelector;
        private final long timestamp;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Lcp)) {
                return false;
            }
            Lcp lcp = (Lcp) obj;
            return this.timestamp == lcp.timestamp && Intrinsics.areEqual(this.targetSelector, lcp.targetSelector) && Intrinsics.areEqual(this.resourceUrl, lcp.resourceUrl);
        }

        public int hashCode() {
            int iHashCode = Long.hashCode(this.timestamp) * 31;
            String str = this.targetSelector;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.resourceUrl;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Lcp(timestamp=" + this.timestamp + ", targetSelector=" + this.targetSelector + ", resourceUrl=" + this.resourceUrl + ")";
        }

        public Lcp(long j, String str, String str2) {
            this.timestamp = j;
            this.targetSelector = str;
            this.resourceUrl = str2;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(DiagnosticsEntry.TIMESTAMP_KEY, Long.valueOf(this.timestamp));
            String str = this.targetSelector;
            if (str != null) {
                jsonObject.addProperty("target_selector", str);
            }
            String str2 = this.resourceUrl;
            if (str2 != null) {
                jsonObject.addProperty("resource_url", str2);
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Lcp fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    long asLong = jsonObject.get(DiagnosticsEntry.TIMESTAMP_KEY).getAsLong();
                    JsonElement jsonElement = jsonObject.get("target_selector");
                    String asString = jsonElement != null ? jsonElement.getAsString() : null;
                    JsonElement jsonElement2 = jsonObject.get("resource_url");
                    return new Lcp(asLong, asString, jsonElement2 != null ? jsonElement2.getAsString() : null);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Lcp", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Lcp", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Lcp", e3);
                }
            }
        }
    }

    public static final class Fbc {
        public static final Companion Companion = new Companion(null);
        private final long timestamp;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Fbc) && this.timestamp == ((Fbc) obj).timestamp;
        }

        public int hashCode() {
            return Long.hashCode(this.timestamp);
        }

        public String toString() {
            return "Fbc(timestamp=" + this.timestamp + ")";
        }

        public Fbc(long j) {
            this.timestamp = j;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(DiagnosticsEntry.TIMESTAMP_KEY, Long.valueOf(this.timestamp));
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Fbc fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    return new Fbc(jsonObject.get(DiagnosticsEntry.TIMESTAMP_KEY).getAsLong());
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Fbc", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Fbc", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Fbc", e3);
                }
            }
        }
    }

    public static final class PreviousRect {
        public static final Companion Companion = new Companion(null);
        private final Number height;
        private final Number width;
        private final Number x;
        private final Number y;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PreviousRect)) {
                return false;
            }
            PreviousRect previousRect = (PreviousRect) obj;
            return Intrinsics.areEqual(this.x, previousRect.x) && Intrinsics.areEqual(this.y, previousRect.y) && Intrinsics.areEqual(this.width, previousRect.width) && Intrinsics.areEqual(this.height, previousRect.height);
        }

        public int hashCode() {
            return (((((this.x.hashCode() * 31) + this.y.hashCode()) * 31) + this.width.hashCode()) * 31) + this.height.hashCode();
        }

        public String toString() {
            return "PreviousRect(x=" + this.x + ", y=" + this.y + ", width=" + this.width + ", height=" + this.height + ")";
        }

        public PreviousRect(Number x, Number y, Number width, Number height) {
            Intrinsics.checkNotNullParameter(x, "x");
            Intrinsics.checkNotNullParameter(y, "y");
            Intrinsics.checkNotNullParameter(width, "width");
            Intrinsics.checkNotNullParameter(height, "height");
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("x", this.x);
            jsonObject.addProperty("y", this.y);
            jsonObject.addProperty("width", this.width);
            jsonObject.addProperty("height", this.height);
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final PreviousRect fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    Number x = jsonObject.get("x").getAsNumber();
                    Number y = jsonObject.get("y").getAsNumber();
                    Number width = jsonObject.get("width").getAsNumber();
                    Number height = jsonObject.get("height").getAsNumber();
                    Intrinsics.checkNotNullExpressionValue(x, "x");
                    Intrinsics.checkNotNullExpressionValue(y, "y");
                    Intrinsics.checkNotNullExpressionValue(width, "width");
                    Intrinsics.checkNotNullExpressionValue(height, "height");
                    return new PreviousRect(x, y, width, height);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type PreviousRect", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type PreviousRect", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type PreviousRect", e3);
                }
            }
        }
    }

    public enum ViewEventSource {
        ANDROID("android"),
        IOS("ios"),
        BROWSER("browser"),
        FLUTTER("flutter"),
        REACT_NATIVE(RNPurchasesModule.PLATFORM_NAME),
        ROKU("roku"),
        UNITY("unity"),
        KOTLIN_MULTIPLATFORM("kotlin-multiplatform");

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        ViewEventSource(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final ViewEventSource fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (ViewEventSource viewEventSource : ViewEventSource.values()) {
                    if (Intrinsics.areEqual(viewEventSource.jsonValue, jsonString)) {
                        return viewEventSource;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    public enum ViewEventSessionType {
        USER("user"),
        SYNTHETICS("synthetics"),
        CI_TEST("ci_test");

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        ViewEventSessionType(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final ViewEventSessionType fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (ViewEventSessionType viewEventSessionType : ViewEventSessionType.values()) {
                    if (Intrinsics.areEqual(viewEventSessionType.jsonValue, jsonString)) {
                        return viewEventSessionType;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    public enum LoadingType {
        INITIAL_LOAD("initial_load"),
        ROUTE_CHANGE("route_change"),
        ACTIVITY_DISPLAY("activity_display"),
        ACTIVITY_REDISPLAY("activity_redisplay"),
        FRAGMENT_DISPLAY("fragment_display"),
        FRAGMENT_REDISPLAY("fragment_redisplay"),
        VIEW_CONTROLLER_DISPLAY("view_controller_display"),
        VIEW_CONTROLLER_REDISPLAY("view_controller_redisplay");

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        LoadingType(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final LoadingType fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (LoadingType loadingType : LoadingType.values()) {
                    if (Intrinsics.areEqual(loadingType.jsonValue, jsonString)) {
                        return loadingType;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    public enum ConnectivityStatus {
        CONNECTED("connected"),
        NOT_CONNECTED("not_connected"),
        MAYBE("maybe");

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        ConnectivityStatus(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final ConnectivityStatus fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (ConnectivityStatus connectivityStatus : ConnectivityStatus.values()) {
                    if (Intrinsics.areEqual(connectivityStatus.jsonValue, jsonString)) {
                        return connectivityStatus;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    public enum Interface {
        BLUETOOTH("bluetooth"),
        CELLULAR("cellular"),
        ETHERNET("ethernet"),
        WIFI("wifi"),
        WIMAX("wimax"),
        MIXED("mixed"),
        OTHER(PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER),
        UNKNOWN("unknown"),
        NONE("none");

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        Interface(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Interface fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (Interface r3 : Interface.values()) {
                    if (Intrinsics.areEqual(r3.jsonValue, jsonString)) {
                        return r3;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    public enum EffectiveType {
        SLOW_2G("slow-2g"),
        f472G("2g"),
        f483G("3g"),
        f494G("4g");

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        EffectiveType(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final EffectiveType fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (EffectiveType effectiveType : EffectiveType.values()) {
                    if (Intrinsics.areEqual(effectiveType.jsonValue, jsonString)) {
                        return effectiveType;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    public enum DeviceType {
        MOBILE("mobile"),
        DESKTOP("desktop"),
        TABLET("tablet"),
        TV("tv"),
        GAMING_CONSOLE("gaming_console"),
        BOT("bot"),
        OTHER(PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER);

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        DeviceType(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final DeviceType fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (DeviceType deviceType : DeviceType.values()) {
                    if (Intrinsics.areEqual(deviceType.jsonValue, jsonString)) {
                        return deviceType;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    public enum ReplayLevel {
        ALLOW("allow"),
        MASK("mask"),
        MASK_USER_INPUT("mask-user-input");

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        ReplayLevel(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final ReplayLevel fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (ReplayLevel replayLevel : ReplayLevel.values()) {
                    if (Intrinsics.areEqual(replayLevel.jsonValue, jsonString)) {
                        return replayLevel;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    public enum Plan {
        PLAN_1(1),
        PLAN_2(2);

        public static final Companion Companion = new Companion(null);
        private final Number jsonValue;

        Plan(Number number) {
            this.jsonValue = number;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Plan fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (Plan plan : Plan.values()) {
                    if (Intrinsics.areEqual(plan.jsonValue.toString(), jsonString)) {
                        return plan;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    public enum SessionPrecondition {
        USER_APP_LAUNCH("user_app_launch"),
        INACTIVITY_TIMEOUT("inactivity_timeout"),
        MAX_DURATION("max_duration"),
        BACKGROUND_LAUNCH("background_launch"),
        PREWARM("prewarm"),
        FROM_NON_INTERACTIVE_SESSION("from_non_interactive_session"),
        EXPLICIT_STOP("explicit_stop");

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        SessionPrecondition(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final SessionPrecondition fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (SessionPrecondition sessionPrecondition : SessionPrecondition.values()) {
                    if (Intrinsics.areEqual(sessionPrecondition.jsonValue, jsonString)) {
                        return sessionPrecondition;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    public enum State {
        ACTIVE(AppStateModule.APP_STATE_ACTIVE),
        PASSIVE("passive"),
        HIDDEN("hidden"),
        FROZEN("frozen"),
        TERMINATED("terminated");

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        State(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final State fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (State state : State.values()) {
                    if (Intrinsics.areEqual(state.jsonValue, jsonString)) {
                        return state;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    public enum ProfilingStatus {
        STARTING("starting"),
        RUNNING("running"),
        STOPPED("stopped"),
        ERROR("error");

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        ProfilingStatus(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final ProfilingStatus fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (ProfilingStatus profilingStatus : ProfilingStatus.values()) {
                    if (Intrinsics.areEqual(profilingStatus.jsonValue, jsonString)) {
                        return profilingStatus;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    public enum ErrorReason {
        NOT_SUPPORTED_BY_BROWSER("not-supported-by-browser"),
        FAILED_TO_LAZY_LOAD("failed-to-lazy-load"),
        MISSING_DOCUMENT_POLICY_HEADER("missing-document-policy-header"),
        UNEXPECTED_EXCEPTION("unexpected-exception");

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        ErrorReason(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final ErrorReason fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (ErrorReason errorReason : ErrorReason.values()) {
                    if (Intrinsics.areEqual(errorReason.jsonValue, jsonString)) {
                        return errorReason;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }
}
