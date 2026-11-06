package com.datadog.android.rum.model;

import com.datadog.android.core.internal.utils.JsonSerializer;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.google.firebase.messaging.Constants;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.react.RNPurchasesModule;
import com.vonage.webrtc.MediaStreamTrack;
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
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: loaded from: classes3.dex */
public final class ErrorEvent {
    public static final Companion Companion = new Companion(null);
    private final Account account;
    private final Action action;
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
    private final Error error;
    private final Context featureFlags;
    private final Freeze freeze;
    private final Os os;
    private final String service;
    private final ErrorEventSession session;
    private final ErrorEventSource source;
    private final Synthetics synthetics;
    private final String type;
    private final Usr usr;
    private final String version;
    private final ErrorEventView view;

    public static /* synthetic */ ErrorEvent copy$default(ErrorEvent errorEvent, long j, Application application, String str, String str2, String str3, String str4, String str5, ErrorEventSession errorEventSession, ErrorEventSource errorEventSource, ErrorEventView errorEventView, Usr usr, Account account, Connectivity connectivity, Display display, Synthetics synthetics, CiTest ciTest, Os os, Device device, Dd dd, Context context, Action action, Container container, Error error, Freeze freeze, Context context2, int i, Object obj) {
        Context context3;
        Freeze freeze2;
        long j2 = (i & 1) != 0 ? errorEvent.date : j;
        Application application2 = (i & 2) != 0 ? errorEvent.application : application;
        String str6 = (i & 4) != 0 ? errorEvent.service : str;
        String str7 = (i & 8) != 0 ? errorEvent.version : str2;
        String str8 = (i & 16) != 0 ? errorEvent.buildVersion : str3;
        String str9 = (i & 32) != 0 ? errorEvent.buildId : str4;
        String str10 = (i & 64) != 0 ? errorEvent.ddtags : str5;
        ErrorEventSession errorEventSession2 = (i & 128) != 0 ? errorEvent.session : errorEventSession;
        ErrorEventSource errorEventSource2 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? errorEvent.source : errorEventSource;
        ErrorEventView errorEventView2 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? errorEvent.view : errorEventView;
        Usr usr2 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? errorEvent.usr : usr;
        Account account2 = (i & 2048) != 0 ? errorEvent.account : account;
        Connectivity connectivity2 = (i & 4096) != 0 ? errorEvent.connectivity : connectivity;
        long j3 = j2;
        Display display2 = (i & 8192) != 0 ? errorEvent.display : display;
        Synthetics synthetics2 = (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? errorEvent.synthetics : synthetics;
        CiTest ciTest2 = (i & 32768) != 0 ? errorEvent.ciTest : ciTest;
        Os os2 = (i & 65536) != 0 ? errorEvent.os : os;
        Device device2 = (i & 131072) != 0 ? errorEvent.device : device;
        Dd dd2 = (i & 262144) != 0 ? errorEvent.dd : dd;
        Context context4 = (i & 524288) != 0 ? errorEvent.context : context;
        Action action2 = (i & 1048576) != 0 ? errorEvent.action : action;
        Container container2 = (i & 2097152) != 0 ? errorEvent.container : container;
        Error error2 = (i & 4194304) != 0 ? errorEvent.error : error;
        Freeze freeze3 = (i & 8388608) != 0 ? errorEvent.freeze : freeze;
        if ((i & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0) {
            freeze2 = freeze3;
            context3 = errorEvent.featureFlags;
        } else {
            context3 = context2;
            freeze2 = freeze3;
        }
        return errorEvent.copy(j3, application2, str6, str7, str8, str9, str10, errorEventSession2, errorEventSource2, errorEventView2, usr2, account2, connectivity2, display2, synthetics2, ciTest2, os2, device2, dd2, context4, action2, container2, error2, freeze2, context3);
    }

    public final ErrorEvent copy(long j, Application application, String str, String str2, String str3, String str4, String str5, ErrorEventSession session, ErrorEventSource errorEventSource, ErrorEventView view, Usr usr, Account account, Connectivity connectivity, Display display, Synthetics synthetics, CiTest ciTest, Os os, Device device, Dd dd, Context context, Action action, Container container, Error error, Freeze freeze, Context context2) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dd, "dd");
        Intrinsics.checkNotNullParameter(error, "error");
        return new ErrorEvent(j, application, str, str2, str3, str4, str5, session, errorEventSource, view, usr, account, connectivity, display, synthetics, ciTest, os, device, dd, context, action, container, error, freeze, context2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ErrorEvent)) {
            return false;
        }
        ErrorEvent errorEvent = (ErrorEvent) obj;
        return this.date == errorEvent.date && Intrinsics.areEqual(this.application, errorEvent.application) && Intrinsics.areEqual(this.service, errorEvent.service) && Intrinsics.areEqual(this.version, errorEvent.version) && Intrinsics.areEqual(this.buildVersion, errorEvent.buildVersion) && Intrinsics.areEqual(this.buildId, errorEvent.buildId) && Intrinsics.areEqual(this.ddtags, errorEvent.ddtags) && Intrinsics.areEqual(this.session, errorEvent.session) && this.source == errorEvent.source && Intrinsics.areEqual(this.view, errorEvent.view) && Intrinsics.areEqual(this.usr, errorEvent.usr) && Intrinsics.areEqual(this.account, errorEvent.account) && Intrinsics.areEqual(this.connectivity, errorEvent.connectivity) && Intrinsics.areEqual(this.display, errorEvent.display) && Intrinsics.areEqual(this.synthetics, errorEvent.synthetics) && Intrinsics.areEqual(this.ciTest, errorEvent.ciTest) && Intrinsics.areEqual(this.os, errorEvent.os) && Intrinsics.areEqual(this.device, errorEvent.device) && Intrinsics.areEqual(this.dd, errorEvent.dd) && Intrinsics.areEqual(this.context, errorEvent.context) && Intrinsics.areEqual(this.action, errorEvent.action) && Intrinsics.areEqual(this.container, errorEvent.container) && Intrinsics.areEqual(this.error, errorEvent.error) && Intrinsics.areEqual(this.freeze, errorEvent.freeze) && Intrinsics.areEqual(this.featureFlags, errorEvent.featureFlags);
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
        ErrorEventSource errorEventSource = this.source;
        int iHashCode7 = (((iHashCode6 + (errorEventSource == null ? 0 : errorEventSource.hashCode())) * 31) + this.view.hashCode()) * 31;
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
        Action action = this.action;
        int iHashCode17 = (iHashCode16 + (action == null ? 0 : action.hashCode())) * 31;
        Container container = this.container;
        int iHashCode18 = (((iHashCode17 + (container == null ? 0 : container.hashCode())) * 31) + this.error.hashCode()) * 31;
        Freeze freeze = this.freeze;
        int iHashCode19 = (iHashCode18 + (freeze == null ? 0 : freeze.hashCode())) * 31;
        Context context2 = this.featureFlags;
        return iHashCode19 + (context2 != null ? context2.hashCode() : 0);
    }

    public String toString() {
        return "ErrorEvent(date=" + this.date + ", application=" + this.application + ", service=" + this.service + ", version=" + this.version + ", buildVersion=" + this.buildVersion + ", buildId=" + this.buildId + ", ddtags=" + this.ddtags + ", session=" + this.session + ", source=" + this.source + ", view=" + this.view + ", usr=" + this.usr + ", account=" + this.account + ", connectivity=" + this.connectivity + ", display=" + this.display + ", synthetics=" + this.synthetics + ", ciTest=" + this.ciTest + ", os=" + this.os + ", device=" + this.device + ", dd=" + this.dd + ", context=" + this.context + ", action=" + this.action + ", container=" + this.container + ", error=" + this.error + ", freeze=" + this.freeze + ", featureFlags=" + this.featureFlags + ")";
    }

    public ErrorEvent(long j, Application application, String str, String str2, String str3, String str4, String str5, ErrorEventSession session, ErrorEventSource errorEventSource, ErrorEventView view, Usr usr, Account account, Connectivity connectivity, Display display, Synthetics synthetics, CiTest ciTest, Os os, Device device, Dd dd, Context context, Action action, Container container, Error error, Freeze freeze, Context context2) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dd, "dd");
        Intrinsics.checkNotNullParameter(error, "error");
        this.date = j;
        this.application = application;
        this.service = str;
        this.version = str2;
        this.buildVersion = str3;
        this.buildId = str4;
        this.ddtags = str5;
        this.session = session;
        this.source = errorEventSource;
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
        this.action = action;
        this.container = container;
        this.error = error;
        this.freeze = freeze;
        this.featureFlags = context2;
        this.type = "error";
    }

    public /* synthetic */ ErrorEvent(long j, Application application, String str, String str2, String str3, String str4, String str5, ErrorEventSession errorEventSession, ErrorEventSource errorEventSource, ErrorEventView errorEventView, Usr usr, Account account, Connectivity connectivity, Display display, Synthetics synthetics, CiTest ciTest, Os os, Device device, Dd dd, Context context, Action action, Container container, Error error, Freeze freeze, Context context2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, application, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, errorEventSession, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : errorEventSource, errorEventView, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : usr, (i & 2048) != 0 ? null : account, (i & 4096) != 0 ? null : connectivity, (i & 8192) != 0 ? null : display, (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? null : synthetics, (32768 & i) != 0 ? null : ciTest, (65536 & i) != 0 ? null : os, (131072 & i) != 0 ? null : device, dd, (524288 & i) != 0 ? null : context, (1048576 & i) != 0 ? null : action, (2097152 & i) != 0 ? null : container, error, (8388608 & i) != 0 ? null : freeze, (i & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? null : context2);
    }

    public final Usr getUsr() {
        return this.usr;
    }

    public final Account getAccount() {
        return this.account;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Error getError() {
        return this.error;
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
        ErrorEventSource errorEventSource = this.source;
        if (errorEventSource != null) {
            jsonObject.add(Constants.ScionAnalytics.PARAM_SOURCE, errorEventSource.toJson());
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
        Action action = this.action;
        if (action != null) {
            jsonObject.add("action", action.toJson());
        }
        Container container = this.container;
        if (container != null) {
            jsonObject.add("container", container.toJson());
        }
        jsonObject.addProperty("type", this.type);
        jsonObject.add("error", this.error.toJson());
        Freeze freeze = this.freeze;
        if (freeze != null) {
            jsonObject.add("freeze", freeze.toJson());
        }
        Context context2 = this.featureFlags;
        if (context2 != null) {
            jsonObject.add("feature_flags", context2.toJson());
        }
        return jsonObject;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ErrorEvent fromJsonObject(JsonObject jsonObject) {
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
            JsonObject asJsonObject13;
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
                ErrorEventSession.Companion companion2 = ErrorEventSession.Companion;
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                ErrorEventSession errorEventSessionFromJsonObject = companion2.fromJsonObject(it2);
                JsonElement jsonElement6 = jsonObject.get(Constants.ScionAnalytics.PARAM_SOURCE);
                ErrorEventSource errorEventSourceFromJson = (jsonElement6 == null || (asString = jsonElement6.getAsString()) == null) ? null : ErrorEventSource.Companion.fromJson(asString);
                JsonObject it3 = jsonObject.get("view").getAsJsonObject();
                ErrorEventView.Companion companion3 = ErrorEventView.Companion;
                Intrinsics.checkNotNullExpressionValue(it3, "it");
                ErrorEventView errorEventViewFromJsonObject = companion3.fromJsonObject(it3);
                JsonElement jsonElement7 = jsonObject.get("usr");
                Usr usrFromJsonObject = (jsonElement7 == null || (asJsonObject13 = jsonElement7.getAsJsonObject()) == null) ? null : Usr.Companion.fromJsonObject(asJsonObject13);
                JsonElement jsonElement8 = jsonObject.get("account");
                Account accountFromJsonObject = (jsonElement8 == null || (asJsonObject12 = jsonElement8.getAsJsonObject()) == null) ? null : Account.Companion.fromJsonObject(asJsonObject12);
                JsonElement jsonElement9 = jsonObject.get("connectivity");
                Connectivity connectivityFromJsonObject = (jsonElement9 == null || (asJsonObject11 = jsonElement9.getAsJsonObject()) == null) ? null : Connectivity.Companion.fromJsonObject(asJsonObject11);
                JsonElement jsonElement10 = jsonObject.get(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION);
                Display displayFromJsonObject = (jsonElement10 == null || (asJsonObject10 = jsonElement10.getAsJsonObject()) == null) ? null : Display.Companion.fromJsonObject(asJsonObject10);
                JsonElement jsonElement11 = jsonObject.get("synthetics");
                Synthetics syntheticsFromJsonObject = (jsonElement11 == null || (asJsonObject9 = jsonElement11.getAsJsonObject()) == null) ? null : Synthetics.Companion.fromJsonObject(asJsonObject9);
                JsonElement jsonElement12 = jsonObject.get("ci_test");
                CiTest ciTestFromJsonObject = (jsonElement12 == null || (asJsonObject8 = jsonElement12.getAsJsonObject()) == null) ? null : CiTest.Companion.fromJsonObject(asJsonObject8);
                JsonElement jsonElement13 = jsonObject.get("os");
                Os osFromJsonObject = (jsonElement13 == null || (asJsonObject7 = jsonElement13.getAsJsonObject()) == null) ? null : Os.Companion.fromJsonObject(asJsonObject7);
                JsonElement jsonElement14 = jsonObject.get("device");
                Device deviceFromJsonObject = (jsonElement14 == null || (asJsonObject6 = jsonElement14.getAsJsonObject()) == null) ? null : Device.Companion.fromJsonObject(asJsonObject6);
                JsonObject it4 = jsonObject.get("_dd").getAsJsonObject();
                Device device = deviceFromJsonObject;
                Dd.Companion companion4 = Dd.Companion;
                Intrinsics.checkNotNullExpressionValue(it4, "it");
                Dd ddFromJsonObject = companion4.fromJsonObject(it4);
                JsonElement jsonElement15 = jsonObject.get("context");
                Context contextFromJsonObject = (jsonElement15 == null || (asJsonObject5 = jsonElement15.getAsJsonObject()) == null) ? null : Context.Companion.fromJsonObject(asJsonObject5);
                JsonElement jsonElement16 = jsonObject.get("action");
                Action actionFromJsonObject = (jsonElement16 == null || (asJsonObject4 = jsonElement16.getAsJsonObject()) == null) ? null : Action.Companion.fromJsonObject(asJsonObject4);
                JsonElement jsonElement17 = jsonObject.get("container");
                Container containerFromJsonObject = (jsonElement17 == null || (asJsonObject3 = jsonElement17.getAsJsonObject()) == null) ? null : Container.Companion.fromJsonObject(asJsonObject3);
                String asString7 = jsonObject.get("type").getAsString();
                Container container = containerFromJsonObject;
                JsonObject it5 = jsonObject.get("error").getAsJsonObject();
                Error.Companion companion5 = Error.Companion;
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                Error errorFromJsonObject = companion5.fromJsonObject(it5);
                JsonElement jsonElement18 = jsonObject.get("freeze");
                Freeze freezeFromJsonObject = (jsonElement18 == null || (asJsonObject2 = jsonElement18.getAsJsonObject()) == null) ? null : Freeze.Companion.fromJsonObject(asJsonObject2);
                JsonElement jsonElement19 = jsonObject.get("feature_flags");
                Context contextFromJsonObject2 = (jsonElement19 == null || (asJsonObject = jsonElement19.getAsJsonObject()) == null) ? null : Context.Companion.fromJsonObject(asJsonObject);
                if (!Intrinsics.areEqual(asString7, "error")) {
                    throw new IllegalStateException("Check failed.");
                }
                return new ErrorEvent(asLong, applicationFromJsonObject, asString2, asString3, asString4, asString5, asString6, errorEventSessionFromJsonObject, errorEventSourceFromJson, errorEventViewFromJsonObject, usrFromJsonObject, accountFromJsonObject, connectivityFromJsonObject, displayFromJsonObject, syntheticsFromJsonObject, ciTestFromJsonObject, osFromJsonObject, device, ddFromJsonObject, contextFromJsonObject, actionFromJsonObject, container, errorFromJsonObject, freezeFromJsonObject, contextFromJsonObject2);
            } catch (IllegalStateException e) {
                throw new JsonParseException("Unable to parse json into type ErrorEvent", e);
            } catch (NullPointerException e2) {
                throw new JsonParseException("Unable to parse json into type ErrorEvent", e2);
            } catch (NumberFormatException e3) {
                throw new JsonParseException("Unable to parse json into type ErrorEvent", e3);
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

        public /* synthetic */ Application(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2);
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

    public static final class ErrorEventSession {
        public static final Companion Companion = new Companion(null);
        private final Boolean hasReplay;
        private final String id;
        private final ErrorEventSessionType type;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ErrorEventSession)) {
                return false;
            }
            ErrorEventSession errorEventSession = (ErrorEventSession) obj;
            return Intrinsics.areEqual(this.id, errorEventSession.id) && this.type == errorEventSession.type && Intrinsics.areEqual(this.hasReplay, errorEventSession.hasReplay);
        }

        public int hashCode() {
            int iHashCode = ((this.id.hashCode() * 31) + this.type.hashCode()) * 31;
            Boolean bool = this.hasReplay;
            return iHashCode + (bool == null ? 0 : bool.hashCode());
        }

        public String toString() {
            return "ErrorEventSession(id=" + this.id + ", type=" + this.type + ", hasReplay=" + this.hasReplay + ")";
        }

        public ErrorEventSession(String id, ErrorEventSessionType type, Boolean bool) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            this.id = id;
            this.type = type;
            this.hasReplay = bool;
        }

        public /* synthetic */ ErrorEventSession(String str, ErrorEventSessionType errorEventSessionType, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, errorEventSessionType, (i & 4) != 0 ? null : bool);
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(DiagnosticsEntry.ID_KEY, this.id);
            jsonObject.add("type", this.type.toJson());
            Boolean bool = this.hasReplay;
            if (bool != null) {
                jsonObject.addProperty("has_replay", bool);
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final ErrorEventSession fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String id = jsonObject.get(DiagnosticsEntry.ID_KEY).getAsString();
                    ErrorEventSessionType.Companion companion = ErrorEventSessionType.Companion;
                    String asString = jsonObject.get("type").getAsString();
                    Intrinsics.checkNotNullExpressionValue(asString, "jsonObject.get(\"type\").asString");
                    ErrorEventSessionType errorEventSessionTypeFromJson = companion.fromJson(asString);
                    JsonElement jsonElement = jsonObject.get("has_replay");
                    Boolean boolValueOf = jsonElement != null ? Boolean.valueOf(jsonElement.getAsBoolean()) : null;
                    Intrinsics.checkNotNullExpressionValue(id, "id");
                    return new ErrorEventSession(id, errorEventSessionTypeFromJson, boolValueOf);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type ErrorEventSession", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type ErrorEventSession", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type ErrorEventSession", e3);
                }
            }
        }
    }

    public static final class ErrorEventView {
        public static final Companion Companion = new Companion(null);
        private final String id;
        private final Boolean inForeground;
        private String name;
        private String referrer;
        private String url;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ErrorEventView)) {
                return false;
            }
            ErrorEventView errorEventView = (ErrorEventView) obj;
            return Intrinsics.areEqual(this.id, errorEventView.id) && Intrinsics.areEqual(this.referrer, errorEventView.referrer) && Intrinsics.areEqual(this.url, errorEventView.url) && Intrinsics.areEqual(this.name, errorEventView.name) && Intrinsics.areEqual(this.inForeground, errorEventView.inForeground);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.referrer;
            int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.url.hashCode()) * 31;
            String str2 = this.name;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Boolean bool = this.inForeground;
            return iHashCode3 + (bool != null ? bool.hashCode() : 0);
        }

        public String toString() {
            return "ErrorEventView(id=" + this.id + ", referrer=" + this.referrer + ", url=" + this.url + ", name=" + this.name + ", inForeground=" + this.inForeground + ")";
        }

        public ErrorEventView(String id, String str, String url, String str2, Boolean bool) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(url, "url");
            this.id = id;
            this.referrer = str;
            this.url = url;
            this.name = str2;
            this.inForeground = bool;
        }

        public /* synthetic */ ErrorEventView(String str, String str2, String str3, String str4, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2, str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : bool);
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
            Boolean bool = this.inForeground;
            if (bool != null) {
                jsonObject.addProperty("in_foreground", bool);
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final ErrorEventView fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String id = jsonObject.get(DiagnosticsEntry.ID_KEY).getAsString();
                    JsonElement jsonElement = jsonObject.get(com.adjust.sdk.Constants.REFERRER);
                    String asString = jsonElement != null ? jsonElement.getAsString() : null;
                    String url = jsonObject.get("url").getAsString();
                    JsonElement jsonElement2 = jsonObject.get("name");
                    String asString2 = jsonElement2 != null ? jsonElement2.getAsString() : null;
                    JsonElement jsonElement3 = jsonObject.get("in_foreground");
                    Boolean boolValueOf = jsonElement3 != null ? Boolean.valueOf(jsonElement3.getAsBoolean()) : null;
                    Intrinsics.checkNotNullExpressionValue(id, "id");
                    Intrinsics.checkNotNullExpressionValue(url, "url");
                    return new ErrorEventView(id, asString, url, asString2, boolValueOf);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type ErrorEventView", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type ErrorEventView", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type ErrorEventView", e3);
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
        private final Status status;

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

        public Connectivity(Status status, List list, EffectiveType effectiveType, Cellular cellular) {
            Intrinsics.checkNotNullParameter(status, "status");
            this.status = status;
            this.interfaces = list;
            this.effectiveType = effectiveType;
            this.cellular = cellular;
        }

        public /* synthetic */ Connectivity(Status status, List list, EffectiveType effectiveType, Cellular cellular, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(status, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : effectiveType, (i & 8) != 0 ? null : cellular);
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
                    Status.Companion companion = Status.Companion;
                    String asString2 = jsonObject.get("status").getAsString();
                    Intrinsics.checkNotNullExpressionValue(asString2, "jsonObject.get(\"status\").asString");
                    Status statusFromJson = companion.fromJson(asString2);
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
                    return new Connectivity(statusFromJson, arrayList, effectiveTypeFromJson, cellularFromJsonObject);
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
        private final Viewport viewport;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Display) && Intrinsics.areEqual(this.viewport, ((Display) obj).viewport);
        }

        public int hashCode() {
            Viewport viewport = this.viewport;
            if (viewport == null) {
                return 0;
            }
            return viewport.hashCode();
        }

        public String toString() {
            return "Display(viewport=" + this.viewport + ")";
        }

        public Display(Viewport viewport) {
            this.viewport = viewport;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            Viewport viewport = this.viewport;
            if (viewport != null) {
                jsonObject.add("viewport", viewport.toJson());
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
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get("viewport");
                    return new Display((jsonElement == null || (asJsonObject = jsonElement.getAsJsonObject()) == null) ? null : Viewport.Companion.fromJsonObject(asJsonObject));
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
        private final Configuration configuration;
        private final long formatVersion;
        private final String sdkName;
        private final DdSession session;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Dd)) {
                return false;
            }
            Dd dd = (Dd) obj;
            return Intrinsics.areEqual(this.session, dd.session) && Intrinsics.areEqual(this.configuration, dd.configuration) && Intrinsics.areEqual(this.browserSdkVersion, dd.browserSdkVersion) && Intrinsics.areEqual(this.sdkName, dd.sdkName);
        }

        public int hashCode() {
            DdSession ddSession = this.session;
            int iHashCode = (ddSession == null ? 0 : ddSession.hashCode()) * 31;
            Configuration configuration = this.configuration;
            int iHashCode2 = (iHashCode + (configuration == null ? 0 : configuration.hashCode())) * 31;
            String str = this.browserSdkVersion;
            int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.sdkName;
            return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Dd(session=" + this.session + ", configuration=" + this.configuration + ", browserSdkVersion=" + this.browserSdkVersion + ", sdkName=" + this.sdkName + ")";
        }

        public Dd(DdSession ddSession, Configuration configuration, String str, String str2) {
            this.session = ddSession;
            this.configuration = configuration;
            this.browserSdkVersion = str;
            this.sdkName = str2;
            this.formatVersion = 2L;
        }

        public /* synthetic */ Dd(DdSession ddSession, Configuration configuration, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : ddSession, (i & 2) != 0 ? null : configuration, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2);
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
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Dd fromJsonObject(JsonObject jsonObject) {
                JsonObject asJsonObject;
                JsonObject asJsonObject2;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    long asLong = jsonObject.get("format_version").getAsLong();
                    JsonElement jsonElement = jsonObject.get("session");
                    DdSession ddSessionFromJsonObject = (jsonElement == null || (asJsonObject2 = jsonElement.getAsJsonObject()) == null) ? null : DdSession.Companion.fromJsonObject(asJsonObject2);
                    JsonElement jsonElement2 = jsonObject.get("configuration");
                    Configuration configurationFromJsonObject = (jsonElement2 == null || (asJsonObject = jsonElement2.getAsJsonObject()) == null) ? null : Configuration.Companion.fromJsonObject(asJsonObject);
                    JsonElement jsonElement3 = jsonObject.get("browser_sdk_version");
                    String asString = jsonElement3 != null ? jsonElement3.getAsString() : null;
                    JsonElement jsonElement4 = jsonObject.get("sdk_name");
                    String asString2 = jsonElement4 != null ? jsonElement4.getAsString() : null;
                    if (asLong != 2) {
                        throw new IllegalStateException("Check failed.");
                    }
                    return new Dd(ddSessionFromJsonObject, configurationFromJsonObject, asString, asString2);
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

    public static final class Action {
        public static final Companion Companion = new Companion(null);
        private final List id;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Action) && Intrinsics.areEqual(this.id, ((Action) obj).id);
        }

        public int hashCode() {
            return this.id.hashCode();
        }

        public String toString() {
            return "Action(id=" + this.id + ")";
        }

        public Action(List id) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            JsonArray jsonArray = new JsonArray(this.id.size());
            Iterator it = this.id.iterator();
            while (it.hasNext()) {
                jsonArray.add((String) it.next());
            }
            jsonObject.add(DiagnosticsEntry.ID_KEY, jsonArray);
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
                    JsonArray jsonArray = jsonObject.get(DiagnosticsEntry.ID_KEY).getAsJsonArray();
                    ArrayList arrayList = new ArrayList(jsonArray.size());
                    Intrinsics.checkNotNullExpressionValue(jsonArray, "jsonArray");
                    Iterator it = jsonArray.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((JsonElement) it.next()).getAsString());
                    }
                    return new Action(arrayList);
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

    public static final class Container {
        public static final Companion Companion = new Companion(null);
        private final ErrorEventSource source;
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

        public Container(ContainerView view, ErrorEventSource source) {
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
                    ErrorEventSource.Companion companion2 = ErrorEventSource.Companion;
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

    public static final class Error {
        public static final Companion Companion = new Companion(null);
        private final List binaryImages;
        private final Category category;
        private List causes;
        private final Csp csp;
        private String fingerprint;
        private final Handling handling;
        private final String handlingStack;
        private final String id;
        private final Boolean isCrash;
        private String message;
        private final Meta meta;
        private final Resource resource;
        private final ErrorSource source;
        private final SourceType sourceType;
        private String stack;
        private final List threads;
        private final Long timeSinceAppStart;
        private final String type;
        private final Boolean wasTruncated;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Error)) {
                return false;
            }
            Error error = (Error) obj;
            return Intrinsics.areEqual(this.id, error.id) && Intrinsics.areEqual(this.message, error.message) && this.source == error.source && Intrinsics.areEqual(this.stack, error.stack) && Intrinsics.areEqual(this.causes, error.causes) && Intrinsics.areEqual(this.isCrash, error.isCrash) && Intrinsics.areEqual(this.fingerprint, error.fingerprint) && Intrinsics.areEqual(this.type, error.type) && this.category == error.category && this.handling == error.handling && Intrinsics.areEqual(this.handlingStack, error.handlingStack) && this.sourceType == error.sourceType && Intrinsics.areEqual(this.resource, error.resource) && Intrinsics.areEqual(this.threads, error.threads) && Intrinsics.areEqual(this.binaryImages, error.binaryImages) && Intrinsics.areEqual(this.wasTruncated, error.wasTruncated) && Intrinsics.areEqual(this.meta, error.meta) && Intrinsics.areEqual(this.csp, error.csp) && Intrinsics.areEqual(this.timeSinceAppStart, error.timeSinceAppStart);
        }

        public int hashCode() {
            String str = this.id;
            int iHashCode = (((((str == null ? 0 : str.hashCode()) * 31) + this.message.hashCode()) * 31) + this.source.hashCode()) * 31;
            String str2 = this.stack;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            List list = this.causes;
            int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
            Boolean bool = this.isCrash;
            int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
            String str3 = this.fingerprint;
            int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.type;
            int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Category category = this.category;
            int iHashCode7 = (iHashCode6 + (category == null ? 0 : category.hashCode())) * 31;
            Handling handling = this.handling;
            int iHashCode8 = (iHashCode7 + (handling == null ? 0 : handling.hashCode())) * 31;
            String str5 = this.handlingStack;
            int iHashCode9 = (iHashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31;
            SourceType sourceType = this.sourceType;
            int iHashCode10 = (iHashCode9 + (sourceType == null ? 0 : sourceType.hashCode())) * 31;
            Resource resource = this.resource;
            int iHashCode11 = (iHashCode10 + (resource == null ? 0 : resource.hashCode())) * 31;
            List list2 = this.threads;
            int iHashCode12 = (iHashCode11 + (list2 == null ? 0 : list2.hashCode())) * 31;
            List list3 = this.binaryImages;
            int iHashCode13 = (iHashCode12 + (list3 == null ? 0 : list3.hashCode())) * 31;
            Boolean bool2 = this.wasTruncated;
            int iHashCode14 = (iHashCode13 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Meta meta = this.meta;
            int iHashCode15 = (iHashCode14 + (meta == null ? 0 : meta.hashCode())) * 31;
            Csp csp = this.csp;
            int iHashCode16 = (iHashCode15 + (csp == null ? 0 : csp.hashCode())) * 31;
            Long l = this.timeSinceAppStart;
            return iHashCode16 + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            return "Error(id=" + this.id + ", message=" + this.message + ", source=" + this.source + ", stack=" + this.stack + ", causes=" + this.causes + ", isCrash=" + this.isCrash + ", fingerprint=" + this.fingerprint + ", type=" + this.type + ", category=" + this.category + ", handling=" + this.handling + ", handlingStack=" + this.handlingStack + ", sourceType=" + this.sourceType + ", resource=" + this.resource + ", threads=" + this.threads + ", binaryImages=" + this.binaryImages + ", wasTruncated=" + this.wasTruncated + ", meta=" + this.meta + ", csp=" + this.csp + ", timeSinceAppStart=" + this.timeSinceAppStart + ")";
        }

        public Error(String str, String message, ErrorSource source, String str2, List list, Boolean bool, String str3, String str4, Category category, Handling handling, String str5, SourceType sourceType, Resource resource, List list2, List list3, Boolean bool2, Meta meta, Csp csp, Long l) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(source, "source");
            this.id = str;
            this.message = message;
            this.source = source;
            this.stack = str2;
            this.causes = list;
            this.isCrash = bool;
            this.fingerprint = str3;
            this.type = str4;
            this.category = category;
            this.handling = handling;
            this.handlingStack = str5;
            this.sourceType = sourceType;
            this.resource = resource;
            this.threads = list2;
            this.binaryImages = list3;
            this.wasTruncated = bool2;
            this.meta = meta;
            this.csp = csp;
            this.timeSinceAppStart = l;
        }

        public /* synthetic */ Error(String str, String str2, ErrorSource errorSource, String str3, List list, Boolean bool, String str4, String str5, Category category, Handling handling, String str6, SourceType sourceType, Resource resource, List list2, List list3, Boolean bool2, Meta meta, Csp csp, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, str2, errorSource, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : bool, (i & 64) != 0 ? null : str4, (i & 128) != 0 ? null : str5, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : category, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? null : handling, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : str6, (i & 2048) != 0 ? null : sourceType, (i & 4096) != 0 ? null : resource, (i & 8192) != 0 ? null : list2, (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? null : list3, (32768 & i) != 0 ? null : bool2, (65536 & i) != 0 ? null : meta, (131072 & i) != 0 ? null : csp, (i & 262144) != 0 ? null : l);
        }

        public final Boolean isCrash() {
            return this.isCrash;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            String str = this.id;
            if (str != null) {
                jsonObject.addProperty(DiagnosticsEntry.ID_KEY, str);
            }
            jsonObject.addProperty("message", this.message);
            jsonObject.add(Constants.ScionAnalytics.PARAM_SOURCE, this.source.toJson());
            String str2 = this.stack;
            if (str2 != null) {
                jsonObject.addProperty("stack", str2);
            }
            List list = this.causes;
            if (list != null) {
                JsonArray jsonArray = new JsonArray(list.size());
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    jsonArray.add(((Cause) it.next()).toJson());
                }
                jsonObject.add("causes", jsonArray);
            }
            Boolean bool = this.isCrash;
            if (bool != null) {
                jsonObject.addProperty("is_crash", bool);
            }
            String str3 = this.fingerprint;
            if (str3 != null) {
                jsonObject.addProperty("fingerprint", str3);
            }
            String str4 = this.type;
            if (str4 != null) {
                jsonObject.addProperty("type", str4);
            }
            Category category = this.category;
            if (category != null) {
                jsonObject.add("category", category.toJson());
            }
            Handling handling = this.handling;
            if (handling != null) {
                jsonObject.add("handling", handling.toJson());
            }
            String str5 = this.handlingStack;
            if (str5 != null) {
                jsonObject.addProperty("handling_stack", str5);
            }
            SourceType sourceType = this.sourceType;
            if (sourceType != null) {
                jsonObject.add("source_type", sourceType.toJson());
            }
            Resource resource = this.resource;
            if (resource != null) {
                jsonObject.add("resource", resource.toJson());
            }
            List list2 = this.threads;
            if (list2 != null) {
                JsonArray jsonArray2 = new JsonArray(list2.size());
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    jsonArray2.add(((Thread) it2.next()).toJson());
                }
                jsonObject.add("threads", jsonArray2);
            }
            List list3 = this.binaryImages;
            if (list3 != null) {
                JsonArray jsonArray3 = new JsonArray(list3.size());
                Iterator it3 = list3.iterator();
                while (it3.hasNext()) {
                    jsonArray3.add(((BinaryImage) it3.next()).toJson());
                }
                jsonObject.add("binary_images", jsonArray3);
            }
            Boolean bool2 = this.wasTruncated;
            if (bool2 != null) {
                jsonObject.addProperty("was_truncated", bool2);
            }
            Meta meta = this.meta;
            if (meta != null) {
                jsonObject.add(com.adjust.sdk.Constants.REFERRER_API_META, meta.toJson());
            }
            Csp csp = this.csp;
            if (csp != null) {
                jsonObject.add("csp", csp.toJson());
            }
            Long l = this.timeSinceAppStart;
            if (l != null) {
                jsonObject.addProperty("time_since_app_start", Long.valueOf(l.longValue()));
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Error fromJsonObject(JsonObject jsonObject) {
                ArrayList arrayList;
                ErrorSource errorSource;
                ArrayList arrayList2;
                ArrayList arrayList3;
                JsonObject asJsonObject;
                JsonObject asJsonObject2;
                JsonArray asJsonArray;
                JsonArray asJsonArray2;
                JsonObject asJsonObject3;
                String asString;
                String asString2;
                String asString3;
                JsonArray<JsonElement> asJsonArray3;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get(DiagnosticsEntry.ID_KEY);
                    String asString4 = jsonElement != null ? jsonElement.getAsString() : null;
                    String message = jsonObject.get("message").getAsString();
                    ErrorSource.Companion companion = ErrorSource.Companion;
                    String asString5 = jsonObject.get(Constants.ScionAnalytics.PARAM_SOURCE).getAsString();
                    Intrinsics.checkNotNullExpressionValue(asString5, "jsonObject.get(\"source\").asString");
                    ErrorSource errorSourceFromJson = companion.fromJson(asString5);
                    JsonElement jsonElement2 = jsonObject.get("stack");
                    String asString6 = jsonElement2 != null ? jsonElement2.getAsString() : null;
                    JsonElement jsonElement3 = jsonObject.get("causes");
                    if (jsonElement3 == null || (asJsonArray3 = jsonElement3.getAsJsonArray()) == null) {
                        arrayList = null;
                    } else {
                        ArrayList arrayList4 = new ArrayList(asJsonArray3.size());
                        for (JsonElement jsonElement4 : asJsonArray3) {
                            Cause.Companion companion2 = Cause.Companion;
                            JsonObject asJsonObject4 = jsonElement4.getAsJsonObject();
                            Intrinsics.checkNotNullExpressionValue(asJsonObject4, "it.asJsonObject");
                            arrayList4.add(companion2.fromJsonObject(asJsonObject4));
                        }
                        arrayList = arrayList4;
                    }
                    JsonElement jsonElement5 = jsonObject.get("is_crash");
                    Boolean boolValueOf = jsonElement5 != null ? Boolean.valueOf(jsonElement5.getAsBoolean()) : null;
                    JsonElement jsonElement6 = jsonObject.get("fingerprint");
                    String asString7 = jsonElement6 != null ? jsonElement6.getAsString() : null;
                    JsonElement jsonElement7 = jsonObject.get("type");
                    String asString8 = jsonElement7 != null ? jsonElement7.getAsString() : null;
                    JsonElement jsonElement8 = jsonObject.get("category");
                    Category categoryFromJson = (jsonElement8 == null || (asString3 = jsonElement8.getAsString()) == null) ? null : Category.Companion.fromJson(asString3);
                    JsonElement jsonElement9 = jsonObject.get("handling");
                    Handling handlingFromJson = (jsonElement9 == null || (asString2 = jsonElement9.getAsString()) == null) ? null : Handling.Companion.fromJson(asString2);
                    JsonElement jsonElement10 = jsonObject.get("handling_stack");
                    String asString9 = jsonElement10 != null ? jsonElement10.getAsString() : null;
                    JsonElement jsonElement11 = jsonObject.get("source_type");
                    SourceType sourceTypeFromJson = (jsonElement11 == null || (asString = jsonElement11.getAsString()) == null) ? null : SourceType.Companion.fromJson(asString);
                    JsonElement jsonElement12 = jsonObject.get("resource");
                    Resource resourceFromJsonObject = (jsonElement12 == null || (asJsonObject3 = jsonElement12.getAsJsonObject()) == null) ? null : Resource.Companion.fromJsonObject(asJsonObject3);
                    JsonElement jsonElement13 = jsonObject.get("threads");
                    if (jsonElement13 == null || (asJsonArray2 = jsonElement13.getAsJsonArray()) == null) {
                        errorSource = errorSourceFromJson;
                        arrayList2 = null;
                    } else {
                        arrayList2 = new ArrayList(asJsonArray2.size());
                        Iterator it = asJsonArray2.iterator();
                        while (it.hasNext()) {
                            JsonElement jsonElement14 = (JsonElement) it.next();
                            Iterator it2 = it;
                            Thread.Companion companion3 = Thread.Companion;
                            ErrorSource errorSource2 = errorSourceFromJson;
                            JsonObject asJsonObject5 = jsonElement14.getAsJsonObject();
                            Intrinsics.checkNotNullExpressionValue(asJsonObject5, "it.asJsonObject");
                            arrayList2.add(companion3.fromJsonObject(asJsonObject5));
                            it = it2;
                            errorSourceFromJson = errorSource2;
                        }
                        errorSource = errorSourceFromJson;
                    }
                    JsonElement jsonElement15 = jsonObject.get("binary_images");
                    if (jsonElement15 == null || (asJsonArray = jsonElement15.getAsJsonArray()) == null) {
                        arrayList3 = null;
                    } else {
                        arrayList3 = new ArrayList(asJsonArray.size());
                        Iterator it3 = asJsonArray.iterator();
                        while (it3.hasNext()) {
                            JsonElement jsonElement16 = (JsonElement) it3.next();
                            Iterator it4 = it3;
                            BinaryImage.Companion companion4 = BinaryImage.Companion;
                            JsonObject asJsonObject6 = jsonElement16.getAsJsonObject();
                            Intrinsics.checkNotNullExpressionValue(asJsonObject6, "it.asJsonObject");
                            arrayList3.add(companion4.fromJsonObject(asJsonObject6));
                            it3 = it4;
                        }
                    }
                    JsonElement jsonElement17 = jsonObject.get("was_truncated");
                    Boolean boolValueOf2 = jsonElement17 != null ? Boolean.valueOf(jsonElement17.getAsBoolean()) : null;
                    JsonElement jsonElement18 = jsonObject.get(com.adjust.sdk.Constants.REFERRER_API_META);
                    Meta metaFromJsonObject = (jsonElement18 == null || (asJsonObject2 = jsonElement18.getAsJsonObject()) == null) ? null : Meta.Companion.fromJsonObject(asJsonObject2);
                    JsonElement jsonElement19 = jsonObject.get("csp");
                    Csp cspFromJsonObject = (jsonElement19 == null || (asJsonObject = jsonElement19.getAsJsonObject()) == null) ? null : Csp.Companion.fromJsonObject(asJsonObject);
                    JsonElement jsonElement20 = jsonObject.get("time_since_app_start");
                    Long lValueOf = jsonElement20 != null ? Long.valueOf(jsonElement20.getAsLong()) : null;
                    Resource resource = resourceFromJsonObject;
                    Boolean bool = boolValueOf2;
                    Csp csp = cspFromJsonObject;
                    Intrinsics.checkNotNullExpressionValue(message, "message");
                    return new Error(asString4, message, errorSource, asString6, arrayList, boolValueOf, asString7, asString8, categoryFromJson, handlingFromJson, asString9, sourceTypeFromJson, resource, arrayList2, arrayList3, bool, metaFromJsonObject, csp, lValueOf);
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

    public static final class Freeze {
        public static final Companion Companion = new Companion(null);
        private final long duration;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Freeze) && this.duration == ((Freeze) obj).duration;
        }

        public int hashCode() {
            return Long.hashCode(this.duration);
        }

        public String toString() {
            return "Freeze(duration=" + this.duration + ")";
        }

        public Freeze(long j) {
            this.duration = j;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("duration", Long.valueOf(this.duration));
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Freeze fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    return new Freeze(jsonObject.get("duration").getAsLong());
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Freeze", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Freeze", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Freeze", e3);
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

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Configuration)) {
                return false;
            }
            Configuration configuration = (Configuration) obj;
            return Intrinsics.areEqual(this.sessionSampleRate, configuration.sessionSampleRate) && Intrinsics.areEqual(this.sessionReplaySampleRate, configuration.sessionReplaySampleRate) && Intrinsics.areEqual(this.profilingSampleRate, configuration.profilingSampleRate);
        }

        public int hashCode() {
            int iHashCode = this.sessionSampleRate.hashCode() * 31;
            Number number = this.sessionReplaySampleRate;
            int iHashCode2 = (iHashCode + (number == null ? 0 : number.hashCode())) * 31;
            Number number2 = this.profilingSampleRate;
            return iHashCode2 + (number2 != null ? number2.hashCode() : 0);
        }

        public String toString() {
            return "Configuration(sessionSampleRate=" + this.sessionSampleRate + ", sessionReplaySampleRate=" + this.sessionReplaySampleRate + ", profilingSampleRate=" + this.profilingSampleRate + ")";
        }

        public Configuration(Number sessionSampleRate, Number number, Number number2) {
            Intrinsics.checkNotNullParameter(sessionSampleRate, "sessionSampleRate");
            this.sessionSampleRate = sessionSampleRate;
            this.sessionReplaySampleRate = number;
            this.profilingSampleRate = number2;
        }

        public /* synthetic */ Configuration(Number number, Number number2, Number number3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(number, (i & 2) != 0 ? null : number2, (i & 4) != 0 ? null : number3);
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
                    Intrinsics.checkNotNullExpressionValue(sessionSampleRate, "sessionSampleRate");
                    return new Configuration(sessionSampleRate, asNumber, asNumber2);
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

    public static final class Cause {
        public static final Companion Companion = new Companion(null);
        private String message;
        private final ErrorSource source;
        private String stack;
        private final String type;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Cause)) {
                return false;
            }
            Cause cause = (Cause) obj;
            return Intrinsics.areEqual(this.message, cause.message) && Intrinsics.areEqual(this.type, cause.type) && Intrinsics.areEqual(this.stack, cause.stack) && this.source == cause.source;
        }

        public int hashCode() {
            int iHashCode = this.message.hashCode() * 31;
            String str = this.type;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.stack;
            return ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.source.hashCode();
        }

        public String toString() {
            return "Cause(message=" + this.message + ", type=" + this.type + ", stack=" + this.stack + ", source=" + this.source + ")";
        }

        public Cause(String message, String str, String str2, ErrorSource source) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(source, "source");
            this.message = message;
            this.type = str;
            this.stack = str2;
            this.source = source;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("message", this.message);
            String str = this.type;
            if (str != null) {
                jsonObject.addProperty("type", str);
            }
            String str2 = this.stack;
            if (str2 != null) {
                jsonObject.addProperty("stack", str2);
            }
            jsonObject.add(Constants.ScionAnalytics.PARAM_SOURCE, this.source.toJson());
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Cause fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String message = jsonObject.get("message").getAsString();
                    JsonElement jsonElement = jsonObject.get("type");
                    String asString = jsonElement != null ? jsonElement.getAsString() : null;
                    JsonElement jsonElement2 = jsonObject.get("stack");
                    String asString2 = jsonElement2 != null ? jsonElement2.getAsString() : null;
                    ErrorSource.Companion companion = ErrorSource.Companion;
                    String asString3 = jsonObject.get(Constants.ScionAnalytics.PARAM_SOURCE).getAsString();
                    Intrinsics.checkNotNullExpressionValue(asString3, "jsonObject.get(\"source\").asString");
                    ErrorSource errorSourceFromJson = companion.fromJson(asString3);
                    Intrinsics.checkNotNullExpressionValue(message, "message");
                    return new Cause(message, asString, asString2, errorSourceFromJson);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Cause", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Cause", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Cause", e3);
                }
            }
        }
    }

    public static final class Resource {
        public static final Companion Companion = new Companion(null);
        private final Method method;
        private final Provider provider;
        private final long statusCode;
        private String url;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Resource)) {
                return false;
            }
            Resource resource = (Resource) obj;
            return this.method == resource.method && this.statusCode == resource.statusCode && Intrinsics.areEqual(this.url, resource.url) && Intrinsics.areEqual(this.provider, resource.provider);
        }

        public int hashCode() {
            int iHashCode = ((((this.method.hashCode() * 31) + Long.hashCode(this.statusCode)) * 31) + this.url.hashCode()) * 31;
            Provider provider = this.provider;
            return iHashCode + (provider == null ? 0 : provider.hashCode());
        }

        public String toString() {
            return "Resource(method=" + this.method + ", statusCode=" + this.statusCode + ", url=" + this.url + ", provider=" + this.provider + ")";
        }

        public Resource(Method method, long j, String url, Provider provider) {
            Intrinsics.checkNotNullParameter(method, "method");
            Intrinsics.checkNotNullParameter(url, "url");
            this.method = method;
            this.statusCode = j;
            this.url = url;
            this.provider = provider;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("method", this.method.toJson());
            jsonObject.addProperty("status_code", Long.valueOf(this.statusCode));
            jsonObject.addProperty("url", this.url);
            Provider provider = this.provider;
            if (provider != null) {
                jsonObject.add("provider", provider.toJson());
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Resource fromJsonObject(JsonObject jsonObject) {
                JsonObject asJsonObject;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    Method.Companion companion = Method.Companion;
                    String asString = jsonObject.get("method").getAsString();
                    Intrinsics.checkNotNullExpressionValue(asString, "jsonObject.get(\"method\").asString");
                    Method methodFromJson = companion.fromJson(asString);
                    long asLong = jsonObject.get("status_code").getAsLong();
                    String url = jsonObject.get("url").getAsString();
                    JsonElement jsonElement = jsonObject.get("provider");
                    Provider providerFromJsonObject = (jsonElement == null || (asJsonObject = jsonElement.getAsJsonObject()) == null) ? null : Provider.Companion.fromJsonObject(asJsonObject);
                    Intrinsics.checkNotNullExpressionValue(url, "url");
                    return new Resource(methodFromJson, asLong, url, providerFromJsonObject);
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

    public static final class Thread {
        public static final Companion Companion = new Companion(null);
        private final boolean crashed;
        private final String name;
        private final String stack;
        private final String state;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Thread)) {
                return false;
            }
            Thread thread = (Thread) obj;
            return Intrinsics.areEqual(this.name, thread.name) && this.crashed == thread.crashed && Intrinsics.areEqual(this.stack, thread.stack) && Intrinsics.areEqual(this.state, thread.state);
        }

        public int hashCode() {
            int iHashCode = ((((this.name.hashCode() * 31) + Boolean.hashCode(this.crashed)) * 31) + this.stack.hashCode()) * 31;
            String str = this.state;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Thread(name=" + this.name + ", crashed=" + this.crashed + ", stack=" + this.stack + ", state=" + this.state + ")";
        }

        public Thread(String name, boolean z, String stack, String str) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(stack, "stack");
            this.name = name;
            this.crashed = z;
            this.stack = stack;
            this.state = str;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("name", this.name);
            jsonObject.addProperty("crashed", Boolean.valueOf(this.crashed));
            jsonObject.addProperty("stack", this.stack);
            String str = this.state;
            if (str != null) {
                jsonObject.addProperty("state", str);
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Thread fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String name = jsonObject.get("name").getAsString();
                    boolean asBoolean = jsonObject.get("crashed").getAsBoolean();
                    String stack = jsonObject.get("stack").getAsString();
                    JsonElement jsonElement = jsonObject.get("state");
                    String asString = jsonElement != null ? jsonElement.getAsString() : null;
                    Intrinsics.checkNotNullExpressionValue(name, "name");
                    Intrinsics.checkNotNullExpressionValue(stack, "stack");
                    return new Thread(name, asBoolean, stack, asString);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Thread", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Thread", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Thread", e3);
                }
            }
        }
    }

    public static final class BinaryImage {
        public static final Companion Companion = new Companion(null);
        private final String arch;
        private final boolean isSystem;
        private final String loadAddress;
        private final String maxAddress;
        private final String name;
        private final String uuid;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BinaryImage)) {
                return false;
            }
            BinaryImage binaryImage = (BinaryImage) obj;
            return Intrinsics.areEqual(this.uuid, binaryImage.uuid) && Intrinsics.areEqual(this.name, binaryImage.name) && this.isSystem == binaryImage.isSystem && Intrinsics.areEqual(this.loadAddress, binaryImage.loadAddress) && Intrinsics.areEqual(this.maxAddress, binaryImage.maxAddress) && Intrinsics.areEqual(this.arch, binaryImage.arch);
        }

        public int hashCode() {
            int iHashCode = ((((this.uuid.hashCode() * 31) + this.name.hashCode()) * 31) + Boolean.hashCode(this.isSystem)) * 31;
            String str = this.loadAddress;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.maxAddress;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.arch;
            return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "BinaryImage(uuid=" + this.uuid + ", name=" + this.name + ", isSystem=" + this.isSystem + ", loadAddress=" + this.loadAddress + ", maxAddress=" + this.maxAddress + ", arch=" + this.arch + ")";
        }

        public BinaryImage(String uuid, String name, boolean z, String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            Intrinsics.checkNotNullParameter(name, "name");
            this.uuid = uuid;
            this.name = name;
            this.isSystem = z;
            this.loadAddress = str;
            this.maxAddress = str2;
            this.arch = str3;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("uuid", this.uuid);
            jsonObject.addProperty("name", this.name);
            jsonObject.addProperty("is_system", Boolean.valueOf(this.isSystem));
            String str = this.loadAddress;
            if (str != null) {
                jsonObject.addProperty("load_address", str);
            }
            String str2 = this.maxAddress;
            if (str2 != null) {
                jsonObject.addProperty("max_address", str2);
            }
            String str3 = this.arch;
            if (str3 != null) {
                jsonObject.addProperty("arch", str3);
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final BinaryImage fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String uuid = jsonObject.get("uuid").getAsString();
                    String name = jsonObject.get("name").getAsString();
                    boolean asBoolean = jsonObject.get("is_system").getAsBoolean();
                    JsonElement jsonElement = jsonObject.get("load_address");
                    String asString = jsonElement != null ? jsonElement.getAsString() : null;
                    JsonElement jsonElement2 = jsonObject.get("max_address");
                    String asString2 = jsonElement2 != null ? jsonElement2.getAsString() : null;
                    JsonElement jsonElement3 = jsonObject.get("arch");
                    String asString3 = jsonElement3 != null ? jsonElement3.getAsString() : null;
                    Intrinsics.checkNotNullExpressionValue(uuid, "uuid");
                    Intrinsics.checkNotNullExpressionValue(name, "name");
                    return new BinaryImage(uuid, name, asBoolean, asString, asString2, asString3);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type BinaryImage", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type BinaryImage", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type BinaryImage", e3);
                }
            }
        }
    }

    public static final class Meta {
        public static final Companion Companion = new Companion(null);
        private final String codeType;
        private final String exceptionCodes;
        private final String exceptionType;
        private final String incidentIdentifier;
        private final String parentProcess;
        private final String path;
        private final String process;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Meta)) {
                return false;
            }
            Meta meta = (Meta) obj;
            return Intrinsics.areEqual(this.codeType, meta.codeType) && Intrinsics.areEqual(this.parentProcess, meta.parentProcess) && Intrinsics.areEqual(this.incidentIdentifier, meta.incidentIdentifier) && Intrinsics.areEqual(this.process, meta.process) && Intrinsics.areEqual(this.exceptionType, meta.exceptionType) && Intrinsics.areEqual(this.exceptionCodes, meta.exceptionCodes) && Intrinsics.areEqual(this.path, meta.path);
        }

        public int hashCode() {
            String str = this.codeType;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.parentProcess;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.incidentIdentifier;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.process;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.exceptionType;
            int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.exceptionCodes;
            int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.path;
            return iHashCode6 + (str7 != null ? str7.hashCode() : 0);
        }

        public String toString() {
            return "Meta(codeType=" + this.codeType + ", parentProcess=" + this.parentProcess + ", incidentIdentifier=" + this.incidentIdentifier + ", process=" + this.process + ", exceptionType=" + this.exceptionType + ", exceptionCodes=" + this.exceptionCodes + ", path=" + this.path + ")";
        }

        public Meta(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            this.codeType = str;
            this.parentProcess = str2;
            this.incidentIdentifier = str3;
            this.process = str4;
            this.exceptionType = str5;
            this.exceptionCodes = str6;
            this.path = str7;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            String str = this.codeType;
            if (str != null) {
                jsonObject.addProperty("code_type", str);
            }
            String str2 = this.parentProcess;
            if (str2 != null) {
                jsonObject.addProperty("parent_process", str2);
            }
            String str3 = this.incidentIdentifier;
            if (str3 != null) {
                jsonObject.addProperty("incident_identifier", str3);
            }
            String str4 = this.process;
            if (str4 != null) {
                jsonObject.addProperty("process", str4);
            }
            String str5 = this.exceptionType;
            if (str5 != null) {
                jsonObject.addProperty("exception_type", str5);
            }
            String str6 = this.exceptionCodes;
            if (str6 != null) {
                jsonObject.addProperty("exception_codes", str6);
            }
            String str7 = this.path;
            if (str7 != null) {
                jsonObject.addProperty("path", str7);
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Meta fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get("code_type");
                    String asString = jsonElement != null ? jsonElement.getAsString() : null;
                    JsonElement jsonElement2 = jsonObject.get("parent_process");
                    String asString2 = jsonElement2 != null ? jsonElement2.getAsString() : null;
                    JsonElement jsonElement3 = jsonObject.get("incident_identifier");
                    String asString3 = jsonElement3 != null ? jsonElement3.getAsString() : null;
                    JsonElement jsonElement4 = jsonObject.get("process");
                    String asString4 = jsonElement4 != null ? jsonElement4.getAsString() : null;
                    JsonElement jsonElement5 = jsonObject.get("exception_type");
                    String asString5 = jsonElement5 != null ? jsonElement5.getAsString() : null;
                    JsonElement jsonElement6 = jsonObject.get("exception_codes");
                    String asString6 = jsonElement6 != null ? jsonElement6.getAsString() : null;
                    JsonElement jsonElement7 = jsonObject.get("path");
                    return new Meta(asString, asString2, asString3, asString4, asString5, asString6, jsonElement7 != null ? jsonElement7.getAsString() : null);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Meta", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Meta", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Meta", e3);
                }
            }
        }
    }

    public static final class Csp {
        public static final Companion Companion = new Companion(null);
        private final Disposition disposition;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Csp) && this.disposition == ((Csp) obj).disposition;
        }

        public int hashCode() {
            Disposition disposition = this.disposition;
            if (disposition == null) {
                return 0;
            }
            return disposition.hashCode();
        }

        public String toString() {
            return "Csp(disposition=" + this.disposition + ")";
        }

        public Csp(Disposition disposition) {
            this.disposition = disposition;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            Disposition disposition = this.disposition;
            if (disposition != null) {
                jsonObject.add("disposition", disposition.toJson());
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Csp fromJsonObject(JsonObject jsonObject) {
                String asString;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get("disposition");
                    return new Csp((jsonElement == null || (asString = jsonElement.getAsString()) == null) ? null : Disposition.Companion.fromJson(asString));
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Csp", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Csp", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Csp", e3);
                }
            }
        }
    }

    public static final class Provider {
        public static final Companion Companion = new Companion(null);
        private final String domain;
        private final String name;
        private final ProviderType type;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Provider)) {
                return false;
            }
            Provider provider = (Provider) obj;
            return Intrinsics.areEqual(this.domain, provider.domain) && Intrinsics.areEqual(this.name, provider.name) && this.type == provider.type;
        }

        public int hashCode() {
            String str = this.domain;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.name;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            ProviderType providerType = this.type;
            return iHashCode2 + (providerType != null ? providerType.hashCode() : 0);
        }

        public String toString() {
            return "Provider(domain=" + this.domain + ", name=" + this.name + ", type=" + this.type + ")";
        }

        public Provider(String str, String str2, ProviderType providerType) {
            this.domain = str;
            this.name = str2;
            this.type = providerType;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            String str = this.domain;
            if (str != null) {
                jsonObject.addProperty("domain", str);
            }
            String str2 = this.name;
            if (str2 != null) {
                jsonObject.addProperty("name", str2);
            }
            ProviderType providerType = this.type;
            if (providerType != null) {
                jsonObject.add("type", providerType.toJson());
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Provider fromJsonObject(JsonObject jsonObject) {
                String asString;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get("domain");
                    ProviderType providerTypeFromJson = null;
                    String asString2 = jsonElement != null ? jsonElement.getAsString() : null;
                    JsonElement jsonElement2 = jsonObject.get("name");
                    String asString3 = jsonElement2 != null ? jsonElement2.getAsString() : null;
                    JsonElement jsonElement3 = jsonObject.get("type");
                    if (jsonElement3 != null && (asString = jsonElement3.getAsString()) != null) {
                        providerTypeFromJson = ProviderType.Companion.fromJson(asString);
                    }
                    return new Provider(asString2, asString3, providerTypeFromJson);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Provider", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Provider", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Provider", e3);
                }
            }
        }
    }

    public enum ErrorEventSource {
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

        ErrorEventSource(String str) {
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

            public final ErrorEventSource fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (ErrorEventSource errorEventSource : ErrorEventSource.values()) {
                    if (Intrinsics.areEqual(errorEventSource.jsonValue, jsonString)) {
                        return errorEventSource;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    public enum ErrorEventSessionType {
        USER("user"),
        SYNTHETICS("synthetics"),
        CI_TEST("ci_test");

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        ErrorEventSessionType(String str) {
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

            public final ErrorEventSessionType fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (ErrorEventSessionType errorEventSessionType : ErrorEventSessionType.values()) {
                    if (Intrinsics.areEqual(errorEventSessionType.jsonValue, jsonString)) {
                        return errorEventSessionType;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    public enum Status {
        CONNECTED("connected"),
        NOT_CONNECTED("not_connected"),
        MAYBE("maybe");

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        Status(String str) {
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

            public final Status fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (Status status : Status.values()) {
                    if (Intrinsics.areEqual(status.jsonValue, jsonString)) {
                        return status;
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
        f382G("2g"),
        f393G("3g"),
        f404G("4g");

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

    public enum ErrorSource {
        NETWORK("network"),
        SOURCE(Constants.ScionAnalytics.PARAM_SOURCE),
        CONSOLE("console"),
        LOGGER("logger"),
        AGENT("agent"),
        WEBVIEW("webview"),
        CUSTOM("custom"),
        REPORT("report");

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        ErrorSource(String str) {
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

            public final ErrorSource fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (ErrorSource errorSource : ErrorSource.values()) {
                    if (Intrinsics.areEqual(errorSource.jsonValue, jsonString)) {
                        return errorSource;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    public enum Category {
        ANR("ANR"),
        APP_HANG("App Hang"),
        EXCEPTION("Exception"),
        WATCHDOG_TERMINATION("Watchdog Termination"),
        MEMORY_WARNING("Memory Warning"),
        NETWORK("Network");

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        Category(String str) {
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

            public final Category fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (Category category : Category.values()) {
                    if (Intrinsics.areEqual(category.jsonValue, jsonString)) {
                        return category;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    public enum Handling {
        HANDLED("handled"),
        UNHANDLED("unhandled");

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        Handling(String str) {
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

            public final Handling fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (Handling handling : Handling.values()) {
                    if (Intrinsics.areEqual(handling.jsonValue, jsonString)) {
                        return handling;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    public enum SourceType {
        ANDROID("android"),
        BROWSER("browser"),
        IOS("ios"),
        REACT_NATIVE(RNPurchasesModule.PLATFORM_NAME),
        FLUTTER("flutter"),
        ROKU("roku"),
        NDK("ndk"),
        IOS_IL2CPP("ios+il2cpp"),
        NDK_IL2CPP("ndk+il2cpp");

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        SourceType(String str) {
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

            public final SourceType fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (SourceType sourceType : SourceType.values()) {
                    if (Intrinsics.areEqual(sourceType.jsonValue, jsonString)) {
                        return sourceType;
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

    public enum Method {
        POST("POST"),
        GET("GET"),
        HEAD("HEAD"),
        PUT("PUT"),
        DELETE("DELETE"),
        PATCH("PATCH"),
        TRACE("TRACE"),
        OPTIONS("OPTIONS"),
        CONNECT("CONNECT");

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        Method(String str) {
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

            public final Method fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (Method method : Method.values()) {
                    if (Intrinsics.areEqual(method.jsonValue, jsonString)) {
                        return method;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    public enum Disposition {
        ENFORCE("enforce"),
        REPORT("report");

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        Disposition(String str) {
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

            public final Disposition fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (Disposition disposition : Disposition.values()) {
                    if (Intrinsics.areEqual(disposition.jsonValue, jsonString)) {
                        return disposition;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    public enum ProviderType {
        AD("ad"),
        ADVERTISING("advertising"),
        ANALYTICS("analytics"),
        CDN("cdn"),
        CONTENT("content"),
        CUSTOMER_SUCCESS("customer-success"),
        FIRST_PARTY("first party"),
        HOSTING("hosting"),
        MARKETING("marketing"),
        OTHER(PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER),
        SOCIAL("social"),
        TAG_MANAGER("tag-manager"),
        UTILITY("utility"),
        VIDEO(MediaStreamTrack.VIDEO_TRACK_KIND);

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        ProviderType(String str) {
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

            public final ProviderType fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (ProviderType providerType : ProviderType.values()) {
                    if (Intrinsics.areEqual(providerType.jsonValue, jsonString)) {
                        return providerType;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }
}
