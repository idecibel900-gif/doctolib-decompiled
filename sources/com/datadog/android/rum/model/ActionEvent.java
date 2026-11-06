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
public final class ActionEvent {
    public static final Companion Companion = new Companion(null);
    private final Account account;
    private final ActionEventAction action;
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
    private final Os os;
    private final String service;
    private final ActionEventSession session;
    private final ActionEventSource source;
    private final Synthetics synthetics;
    private final String type;
    private final Usr usr;
    private final String version;
    private final ActionEventView view;

    public static /* synthetic */ ActionEvent copy$default(ActionEvent actionEvent, long j, Application application, String str, String str2, String str3, String str4, String str5, ActionEventSession actionEventSession, ActionEventSource actionEventSource, ActionEventView actionEventView, Usr usr, Account account, Connectivity connectivity, Display display, Synthetics synthetics, CiTest ciTest, Os os, Device device, Dd dd, Context context, Container container, ActionEventAction actionEventAction, int i, Object obj) {
        ActionEventAction actionEventAction2;
        Container container2;
        long j2 = (i & 1) != 0 ? actionEvent.date : j;
        Application application2 = (i & 2) != 0 ? actionEvent.application : application;
        String str6 = (i & 4) != 0 ? actionEvent.service : str;
        String str7 = (i & 8) != 0 ? actionEvent.version : str2;
        String str8 = (i & 16) != 0 ? actionEvent.buildVersion : str3;
        String str9 = (i & 32) != 0 ? actionEvent.buildId : str4;
        String str10 = (i & 64) != 0 ? actionEvent.ddtags : str5;
        ActionEventSession actionEventSession2 = (i & 128) != 0 ? actionEvent.session : actionEventSession;
        ActionEventSource actionEventSource2 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? actionEvent.source : actionEventSource;
        ActionEventView actionEventView2 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? actionEvent.view : actionEventView;
        Usr usr2 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? actionEvent.usr : usr;
        Account account2 = (i & 2048) != 0 ? actionEvent.account : account;
        Connectivity connectivity2 = (i & 4096) != 0 ? actionEvent.connectivity : connectivity;
        long j3 = j2;
        Display display2 = (i & 8192) != 0 ? actionEvent.display : display;
        Synthetics synthetics2 = (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? actionEvent.synthetics : synthetics;
        CiTest ciTest2 = (i & 32768) != 0 ? actionEvent.ciTest : ciTest;
        Os os2 = (i & 65536) != 0 ? actionEvent.os : os;
        Device device2 = (i & 131072) != 0 ? actionEvent.device : device;
        Dd dd2 = (i & 262144) != 0 ? actionEvent.dd : dd;
        Context context2 = (i & 524288) != 0 ? actionEvent.context : context;
        Container container3 = (i & 1048576) != 0 ? actionEvent.container : container;
        if ((i & 2097152) != 0) {
            container2 = container3;
            actionEventAction2 = actionEvent.action;
        } else {
            actionEventAction2 = actionEventAction;
            container2 = container3;
        }
        return actionEvent.copy(j3, application2, str6, str7, str8, str9, str10, actionEventSession2, actionEventSource2, actionEventView2, usr2, account2, connectivity2, display2, synthetics2, ciTest2, os2, device2, dd2, context2, container2, actionEventAction2);
    }

    public final ActionEvent copy(long j, Application application, String str, String str2, String str3, String str4, String str5, ActionEventSession session, ActionEventSource actionEventSource, ActionEventView view, Usr usr, Account account, Connectivity connectivity, Display display, Synthetics synthetics, CiTest ciTest, Os os, Device device, Dd dd, Context context, Container container, ActionEventAction action) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dd, "dd");
        Intrinsics.checkNotNullParameter(action, "action");
        return new ActionEvent(j, application, str, str2, str3, str4, str5, session, actionEventSource, view, usr, account, connectivity, display, synthetics, ciTest, os, device, dd, context, container, action);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActionEvent)) {
            return false;
        }
        ActionEvent actionEvent = (ActionEvent) obj;
        return this.date == actionEvent.date && Intrinsics.areEqual(this.application, actionEvent.application) && Intrinsics.areEqual(this.service, actionEvent.service) && Intrinsics.areEqual(this.version, actionEvent.version) && Intrinsics.areEqual(this.buildVersion, actionEvent.buildVersion) && Intrinsics.areEqual(this.buildId, actionEvent.buildId) && Intrinsics.areEqual(this.ddtags, actionEvent.ddtags) && Intrinsics.areEqual(this.session, actionEvent.session) && this.source == actionEvent.source && Intrinsics.areEqual(this.view, actionEvent.view) && Intrinsics.areEqual(this.usr, actionEvent.usr) && Intrinsics.areEqual(this.account, actionEvent.account) && Intrinsics.areEqual(this.connectivity, actionEvent.connectivity) && Intrinsics.areEqual(this.display, actionEvent.display) && Intrinsics.areEqual(this.synthetics, actionEvent.synthetics) && Intrinsics.areEqual(this.ciTest, actionEvent.ciTest) && Intrinsics.areEqual(this.os, actionEvent.os) && Intrinsics.areEqual(this.device, actionEvent.device) && Intrinsics.areEqual(this.dd, actionEvent.dd) && Intrinsics.areEqual(this.context, actionEvent.context) && Intrinsics.areEqual(this.container, actionEvent.container) && Intrinsics.areEqual(this.action, actionEvent.action);
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
        ActionEventSource actionEventSource = this.source;
        int iHashCode7 = (((iHashCode6 + (actionEventSource == null ? 0 : actionEventSource.hashCode())) * 31) + this.view.hashCode()) * 31;
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
        return ((iHashCode16 + (container != null ? container.hashCode() : 0)) * 31) + this.action.hashCode();
    }

    public String toString() {
        return "ActionEvent(date=" + this.date + ", application=" + this.application + ", service=" + this.service + ", version=" + this.version + ", buildVersion=" + this.buildVersion + ", buildId=" + this.buildId + ", ddtags=" + this.ddtags + ", session=" + this.session + ", source=" + this.source + ", view=" + this.view + ", usr=" + this.usr + ", account=" + this.account + ", connectivity=" + this.connectivity + ", display=" + this.display + ", synthetics=" + this.synthetics + ", ciTest=" + this.ciTest + ", os=" + this.os + ", device=" + this.device + ", dd=" + this.dd + ", context=" + this.context + ", container=" + this.container + ", action=" + this.action + ")";
    }

    public ActionEvent(long j, Application application, String str, String str2, String str3, String str4, String str5, ActionEventSession session, ActionEventSource actionEventSource, ActionEventView view, Usr usr, Account account, Connectivity connectivity, Display display, Synthetics synthetics, CiTest ciTest, Os os, Device device, Dd dd, Context context, Container container, ActionEventAction action) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dd, "dd");
        Intrinsics.checkNotNullParameter(action, "action");
        this.date = j;
        this.application = application;
        this.service = str;
        this.version = str2;
        this.buildVersion = str3;
        this.buildId = str4;
        this.ddtags = str5;
        this.session = session;
        this.source = actionEventSource;
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
        this.action = action;
        this.type = "action";
    }

    public /* synthetic */ ActionEvent(long j, Application application, String str, String str2, String str3, String str4, String str5, ActionEventSession actionEventSession, ActionEventSource actionEventSource, ActionEventView actionEventView, Usr usr, Account account, Connectivity connectivity, Display display, Synthetics synthetics, CiTest ciTest, Os os, Device device, Dd dd, Context context, Container container, ActionEventAction actionEventAction, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, application, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, actionEventSession, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : actionEventSource, actionEventView, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : usr, (i & 2048) != 0 ? null : account, (i & 4096) != 0 ? null : connectivity, (i & 8192) != 0 ? null : display, (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? null : synthetics, (32768 & i) != 0 ? null : ciTest, (65536 & i) != 0 ? null : os, (131072 & i) != 0 ? null : device, dd, (524288 & i) != 0 ? null : context, (i & 1048576) != 0 ? null : container, actionEventAction);
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
        ActionEventSource actionEventSource = this.source;
        if (actionEventSource != null) {
            jsonObject.add(Constants.ScionAnalytics.PARAM_SOURCE, actionEventSource.toJson());
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
        jsonObject.add("action", this.action.toJson());
        return jsonObject;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ActionEvent fromJsonObject(JsonObject jsonObject) {
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
                ActionEventSession.Companion companion2 = ActionEventSession.Companion;
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                ActionEventSession actionEventSessionFromJsonObject = companion2.fromJsonObject(it2);
                JsonElement jsonElement6 = jsonObject.get(Constants.ScionAnalytics.PARAM_SOURCE);
                ActionEventSource actionEventSourceFromJson = (jsonElement6 == null || (asString = jsonElement6.getAsString()) == null) ? null : ActionEventSource.Companion.fromJson(asString);
                JsonObject it3 = jsonObject.get("view").getAsJsonObject();
                ActionEventView.Companion companion3 = ActionEventView.Companion;
                Intrinsics.checkNotNullExpressionValue(it3, "it");
                ActionEventView actionEventViewFromJsonObject = companion3.fromJsonObject(it3);
                JsonElement jsonElement7 = jsonObject.get("usr");
                Usr usrFromJsonObject = (jsonElement7 == null || (asJsonObject10 = jsonElement7.getAsJsonObject()) == null) ? null : Usr.Companion.fromJsonObject(asJsonObject10);
                JsonElement jsonElement8 = jsonObject.get("account");
                Account accountFromJsonObject = (jsonElement8 == null || (asJsonObject9 = jsonElement8.getAsJsonObject()) == null) ? null : Account.Companion.fromJsonObject(asJsonObject9);
                JsonElement jsonElement9 = jsonObject.get("connectivity");
                Connectivity connectivityFromJsonObject = (jsonElement9 == null || (asJsonObject8 = jsonElement9.getAsJsonObject()) == null) ? null : Connectivity.Companion.fromJsonObject(asJsonObject8);
                JsonElement jsonElement10 = jsonObject.get(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION);
                Display displayFromJsonObject = (jsonElement10 == null || (asJsonObject7 = jsonElement10.getAsJsonObject()) == null) ? null : Display.Companion.fromJsonObject(asJsonObject7);
                JsonElement jsonElement11 = jsonObject.get("synthetics");
                Synthetics syntheticsFromJsonObject = (jsonElement11 == null || (asJsonObject6 = jsonElement11.getAsJsonObject()) == null) ? null : Synthetics.Companion.fromJsonObject(asJsonObject6);
                JsonElement jsonElement12 = jsonObject.get("ci_test");
                CiTest ciTestFromJsonObject = (jsonElement12 == null || (asJsonObject5 = jsonElement12.getAsJsonObject()) == null) ? null : CiTest.Companion.fromJsonObject(asJsonObject5);
                JsonElement jsonElement13 = jsonObject.get("os");
                Os osFromJsonObject = (jsonElement13 == null || (asJsonObject4 = jsonElement13.getAsJsonObject()) == null) ? null : Os.Companion.fromJsonObject(asJsonObject4);
                JsonElement jsonElement14 = jsonObject.get("device");
                Device deviceFromJsonObject = (jsonElement14 == null || (asJsonObject3 = jsonElement14.getAsJsonObject()) == null) ? null : Device.Companion.fromJsonObject(asJsonObject3);
                JsonObject it4 = jsonObject.get("_dd").getAsJsonObject();
                Device device = deviceFromJsonObject;
                Dd.Companion companion4 = Dd.Companion;
                Intrinsics.checkNotNullExpressionValue(it4, "it");
                Dd ddFromJsonObject = companion4.fromJsonObject(it4);
                JsonElement jsonElement15 = jsonObject.get("context");
                Context contextFromJsonObject = (jsonElement15 == null || (asJsonObject2 = jsonElement15.getAsJsonObject()) == null) ? null : Context.Companion.fromJsonObject(asJsonObject2);
                JsonElement jsonElement16 = jsonObject.get("container");
                Container containerFromJsonObject = (jsonElement16 == null || (asJsonObject = jsonElement16.getAsJsonObject()) == null) ? null : Container.Companion.fromJsonObject(asJsonObject);
                String asString7 = jsonObject.get("type").getAsString();
                JsonObject it5 = jsonObject.get("action").getAsJsonObject();
                Container container = containerFromJsonObject;
                ActionEventAction.Companion companion5 = ActionEventAction.Companion;
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                ActionEventAction actionEventActionFromJsonObject = companion5.fromJsonObject(it5);
                if (!Intrinsics.areEqual(asString7, "action")) {
                    throw new IllegalStateException("Check failed.");
                }
                return new ActionEvent(asLong, applicationFromJsonObject, asString2, asString3, asString4, asString5, asString6, actionEventSessionFromJsonObject, actionEventSourceFromJson, actionEventViewFromJsonObject, usrFromJsonObject, accountFromJsonObject, connectivityFromJsonObject, displayFromJsonObject, syntheticsFromJsonObject, ciTestFromJsonObject, osFromJsonObject, device, ddFromJsonObject, contextFromJsonObject, container, actionEventActionFromJsonObject);
            } catch (IllegalStateException e) {
                throw new JsonParseException("Unable to parse json into type ActionEvent", e);
            } catch (NullPointerException e2) {
                throw new JsonParseException("Unable to parse json into type ActionEvent", e2);
            } catch (NumberFormatException e3) {
                throw new JsonParseException("Unable to parse json into type ActionEvent", e3);
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

    public static final class ActionEventSession {
        public static final Companion Companion = new Companion(null);
        private final Boolean hasReplay;
        private final String id;
        private final ActionEventSessionType type;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ActionEventSession)) {
                return false;
            }
            ActionEventSession actionEventSession = (ActionEventSession) obj;
            return Intrinsics.areEqual(this.id, actionEventSession.id) && this.type == actionEventSession.type && Intrinsics.areEqual(this.hasReplay, actionEventSession.hasReplay);
        }

        public int hashCode() {
            int iHashCode = ((this.id.hashCode() * 31) + this.type.hashCode()) * 31;
            Boolean bool = this.hasReplay;
            return iHashCode + (bool == null ? 0 : bool.hashCode());
        }

        public String toString() {
            return "ActionEventSession(id=" + this.id + ", type=" + this.type + ", hasReplay=" + this.hasReplay + ")";
        }

        public ActionEventSession(String id, ActionEventSessionType type, Boolean bool) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            this.id = id;
            this.type = type;
            this.hasReplay = bool;
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

            public final ActionEventSession fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String id = jsonObject.get(DiagnosticsEntry.ID_KEY).getAsString();
                    ActionEventSessionType.Companion companion = ActionEventSessionType.Companion;
                    String asString = jsonObject.get("type").getAsString();
                    Intrinsics.checkNotNullExpressionValue(asString, "jsonObject.get(\"type\").asString");
                    ActionEventSessionType actionEventSessionTypeFromJson = companion.fromJson(asString);
                    JsonElement jsonElement = jsonObject.get("has_replay");
                    Boolean boolValueOf = jsonElement != null ? Boolean.valueOf(jsonElement.getAsBoolean()) : null;
                    Intrinsics.checkNotNullExpressionValue(id, "id");
                    return new ActionEventSession(id, actionEventSessionTypeFromJson, boolValueOf);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type ActionEventSession", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type ActionEventSession", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type ActionEventSession", e3);
                }
            }
        }
    }

    public static final class ActionEventView {
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
            if (!(obj instanceof ActionEventView)) {
                return false;
            }
            ActionEventView actionEventView = (ActionEventView) obj;
            return Intrinsics.areEqual(this.id, actionEventView.id) && Intrinsics.areEqual(this.referrer, actionEventView.referrer) && Intrinsics.areEqual(this.url, actionEventView.url) && Intrinsics.areEqual(this.name, actionEventView.name) && Intrinsics.areEqual(this.inForeground, actionEventView.inForeground);
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
            return "ActionEventView(id=" + this.id + ", referrer=" + this.referrer + ", url=" + this.url + ", name=" + this.name + ", inForeground=" + this.inForeground + ")";
        }

        public ActionEventView(String id, String str, String url, String str2, Boolean bool) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(url, "url");
            this.id = id;
            this.referrer = str;
            this.url = url;
            this.name = str2;
            this.inForeground = bool;
        }

        public /* synthetic */ ActionEventView(String str, String str2, String str3, String str4, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
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

            public final ActionEventView fromJsonObject(JsonObject jsonObject) {
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
                    return new ActionEventView(id, asString, url, asString2, boolValueOf);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type ActionEventView", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type ActionEventView", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type ActionEventView", e3);
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
        private final DdAction action;
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
            return Intrinsics.areEqual(this.session, dd.session) && Intrinsics.areEqual(this.configuration, dd.configuration) && Intrinsics.areEqual(this.browserSdkVersion, dd.browserSdkVersion) && Intrinsics.areEqual(this.sdkName, dd.sdkName) && Intrinsics.areEqual(this.action, dd.action);
        }

        public int hashCode() {
            DdSession ddSession = this.session;
            int iHashCode = (ddSession == null ? 0 : ddSession.hashCode()) * 31;
            Configuration configuration = this.configuration;
            int iHashCode2 = (iHashCode + (configuration == null ? 0 : configuration.hashCode())) * 31;
            String str = this.browserSdkVersion;
            int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.sdkName;
            int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            DdAction ddAction = this.action;
            return iHashCode4 + (ddAction != null ? ddAction.hashCode() : 0);
        }

        public String toString() {
            return "Dd(session=" + this.session + ", configuration=" + this.configuration + ", browserSdkVersion=" + this.browserSdkVersion + ", sdkName=" + this.sdkName + ", action=" + this.action + ")";
        }

        public Dd(DdSession ddSession, Configuration configuration, String str, String str2, DdAction ddAction) {
            this.session = ddSession;
            this.configuration = configuration;
            this.browserSdkVersion = str;
            this.sdkName = str2;
            this.action = ddAction;
            this.formatVersion = 2L;
        }

        public /* synthetic */ Dd(DdSession ddSession, Configuration configuration, String str, String str2, DdAction ddAction, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : ddSession, (i & 2) != 0 ? null : configuration, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : ddAction);
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
            DdAction ddAction = this.action;
            if (ddAction != null) {
                jsonObject.add("action", ddAction.toJson());
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
                JsonObject asJsonObject3;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    long asLong = jsonObject.get("format_version").getAsLong();
                    JsonElement jsonElement = jsonObject.get("session");
                    DdAction ddActionFromJsonObject = null;
                    DdSession ddSessionFromJsonObject = (jsonElement == null || (asJsonObject3 = jsonElement.getAsJsonObject()) == null) ? null : DdSession.Companion.fromJsonObject(asJsonObject3);
                    JsonElement jsonElement2 = jsonObject.get("configuration");
                    Configuration configurationFromJsonObject = (jsonElement2 == null || (asJsonObject2 = jsonElement2.getAsJsonObject()) == null) ? null : Configuration.Companion.fromJsonObject(asJsonObject2);
                    JsonElement jsonElement3 = jsonObject.get("browser_sdk_version");
                    String asString = jsonElement3 != null ? jsonElement3.getAsString() : null;
                    JsonElement jsonElement4 = jsonObject.get("sdk_name");
                    String asString2 = jsonElement4 != null ? jsonElement4.getAsString() : null;
                    JsonElement jsonElement5 = jsonObject.get("action");
                    if (jsonElement5 != null && (asJsonObject = jsonElement5.getAsJsonObject()) != null) {
                        ddActionFromJsonObject = DdAction.Companion.fromJsonObject(asJsonObject);
                    }
                    if (asLong != 2) {
                        throw new IllegalStateException("Check failed.");
                    }
                    return new Dd(ddSessionFromJsonObject, configurationFromJsonObject, asString, asString2, ddActionFromJsonObject);
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
        private final ActionEventSource source;
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

        public Container(ContainerView view, ActionEventSource source) {
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
                    ActionEventSource.Companion companion2 = ActionEventSource.Companion;
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

    public static final class ActionEventAction {
        public static final Companion Companion = new Companion(null);
        private final Crash crash;
        private final Error error;
        private final Frustration frustration;
        private final String id;
        private final Long loadingTime;
        private final LongTask longTask;
        private final Resource resource;
        private final ActionEventActionTarget target;
        private final ActionEventActionType type;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ActionEventAction)) {
                return false;
            }
            ActionEventAction actionEventAction = (ActionEventAction) obj;
            return this.type == actionEventAction.type && Intrinsics.areEqual(this.id, actionEventAction.id) && Intrinsics.areEqual(this.loadingTime, actionEventAction.loadingTime) && Intrinsics.areEqual(this.target, actionEventAction.target) && Intrinsics.areEqual(this.frustration, actionEventAction.frustration) && Intrinsics.areEqual(this.error, actionEventAction.error) && Intrinsics.areEqual(this.crash, actionEventAction.crash) && Intrinsics.areEqual(this.longTask, actionEventAction.longTask) && Intrinsics.areEqual(this.resource, actionEventAction.resource);
        }

        public int hashCode() {
            int iHashCode = this.type.hashCode() * 31;
            String str = this.id;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Long l = this.loadingTime;
            int iHashCode3 = (iHashCode2 + (l == null ? 0 : l.hashCode())) * 31;
            ActionEventActionTarget actionEventActionTarget = this.target;
            int iHashCode4 = (iHashCode3 + (actionEventActionTarget == null ? 0 : actionEventActionTarget.hashCode())) * 31;
            Frustration frustration = this.frustration;
            int iHashCode5 = (iHashCode4 + (frustration == null ? 0 : frustration.hashCode())) * 31;
            Error error = this.error;
            int iHashCode6 = (iHashCode5 + (error == null ? 0 : error.hashCode())) * 31;
            Crash crash = this.crash;
            int iHashCode7 = (iHashCode6 + (crash == null ? 0 : crash.hashCode())) * 31;
            LongTask longTask = this.longTask;
            int iHashCode8 = (iHashCode7 + (longTask == null ? 0 : longTask.hashCode())) * 31;
            Resource resource = this.resource;
            return iHashCode8 + (resource != null ? resource.hashCode() : 0);
        }

        public String toString() {
            return "ActionEventAction(type=" + this.type + ", id=" + this.id + ", loadingTime=" + this.loadingTime + ", target=" + this.target + ", frustration=" + this.frustration + ", error=" + this.error + ", crash=" + this.crash + ", longTask=" + this.longTask + ", resource=" + this.resource + ")";
        }

        public ActionEventAction(ActionEventActionType type, String str, Long l, ActionEventActionTarget actionEventActionTarget, Frustration frustration, Error error, Crash crash, LongTask longTask, Resource resource) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
            this.id = str;
            this.loadingTime = l;
            this.target = actionEventActionTarget;
            this.frustration = frustration;
            this.error = error;
            this.crash = crash;
            this.longTask = longTask;
            this.resource = resource;
        }

        public /* synthetic */ ActionEventAction(ActionEventActionType actionEventActionType, String str, Long l, ActionEventActionTarget actionEventActionTarget, Frustration frustration, Error error, Crash crash, LongTask longTask, Resource resource, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(actionEventActionType, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : actionEventActionTarget, (i & 16) != 0 ? null : frustration, (i & 32) != 0 ? null : error, (i & 64) != 0 ? null : crash, (i & 128) != 0 ? null : longTask, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : resource);
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("type", this.type.toJson());
            String str = this.id;
            if (str != null) {
                jsonObject.addProperty(DiagnosticsEntry.ID_KEY, str);
            }
            Long l = this.loadingTime;
            if (l != null) {
                jsonObject.addProperty("loading_time", Long.valueOf(l.longValue()));
            }
            ActionEventActionTarget actionEventActionTarget = this.target;
            if (actionEventActionTarget != null) {
                jsonObject.add("target", actionEventActionTarget.toJson());
            }
            Frustration frustration = this.frustration;
            if (frustration != null) {
                jsonObject.add("frustration", frustration.toJson());
            }
            Error error = this.error;
            if (error != null) {
                jsonObject.add("error", error.toJson());
            }
            Crash crash = this.crash;
            if (crash != null) {
                jsonObject.add("crash", crash.toJson());
            }
            LongTask longTask = this.longTask;
            if (longTask != null) {
                jsonObject.add("long_task", longTask.toJson());
            }
            Resource resource = this.resource;
            if (resource != null) {
                jsonObject.add("resource", resource.toJson());
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final ActionEventAction fromJsonObject(JsonObject jsonObject) {
                JsonObject asJsonObject;
                JsonObject asJsonObject2;
                JsonObject asJsonObject3;
                JsonObject asJsonObject4;
                JsonObject asJsonObject5;
                JsonObject asJsonObject6;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    ActionEventActionType.Companion companion = ActionEventActionType.Companion;
                    String asString = jsonObject.get("type").getAsString();
                    Intrinsics.checkNotNullExpressionValue(asString, "jsonObject.get(\"type\").asString");
                    ActionEventActionType actionEventActionTypeFromJson = companion.fromJson(asString);
                    JsonElement jsonElement = jsonObject.get(DiagnosticsEntry.ID_KEY);
                    Resource resourceFromJsonObject = null;
                    String asString2 = jsonElement != null ? jsonElement.getAsString() : null;
                    JsonElement jsonElement2 = jsonObject.get("loading_time");
                    Long lValueOf = jsonElement2 != null ? Long.valueOf(jsonElement2.getAsLong()) : null;
                    JsonElement jsonElement3 = jsonObject.get("target");
                    ActionEventActionTarget actionEventActionTargetFromJsonObject = (jsonElement3 == null || (asJsonObject6 = jsonElement3.getAsJsonObject()) == null) ? null : ActionEventActionTarget.Companion.fromJsonObject(asJsonObject6);
                    JsonElement jsonElement4 = jsonObject.get("frustration");
                    Frustration frustrationFromJsonObject = (jsonElement4 == null || (asJsonObject5 = jsonElement4.getAsJsonObject()) == null) ? null : Frustration.Companion.fromJsonObject(asJsonObject5);
                    JsonElement jsonElement5 = jsonObject.get("error");
                    Error errorFromJsonObject = (jsonElement5 == null || (asJsonObject4 = jsonElement5.getAsJsonObject()) == null) ? null : Error.Companion.fromJsonObject(asJsonObject4);
                    JsonElement jsonElement6 = jsonObject.get("crash");
                    Crash crashFromJsonObject = (jsonElement6 == null || (asJsonObject3 = jsonElement6.getAsJsonObject()) == null) ? null : Crash.Companion.fromJsonObject(asJsonObject3);
                    JsonElement jsonElement7 = jsonObject.get("long_task");
                    LongTask longTaskFromJsonObject = (jsonElement7 == null || (asJsonObject2 = jsonElement7.getAsJsonObject()) == null) ? null : LongTask.Companion.fromJsonObject(asJsonObject2);
                    JsonElement jsonElement8 = jsonObject.get("resource");
                    if (jsonElement8 != null && (asJsonObject = jsonElement8.getAsJsonObject()) != null) {
                        resourceFromJsonObject = Resource.Companion.fromJsonObject(asJsonObject);
                    }
                    return new ActionEventAction(actionEventActionTypeFromJson, asString2, lValueOf, actionEventActionTargetFromJsonObject, frustrationFromJsonObject, errorFromJsonObject, crashFromJsonObject, longTaskFromJsonObject, resourceFromJsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type ActionEventAction", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type ActionEventAction", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type ActionEventAction", e3);
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

    public static final class DdAction {
        public static final Companion Companion = new Companion(null);
        private NameSource nameSource;
        private final Position position;
        private final DdActionTarget target;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DdAction)) {
                return false;
            }
            DdAction ddAction = (DdAction) obj;
            return Intrinsics.areEqual(this.position, ddAction.position) && Intrinsics.areEqual(this.target, ddAction.target) && this.nameSource == ddAction.nameSource;
        }

        public int hashCode() {
            Position position = this.position;
            int iHashCode = (position == null ? 0 : position.hashCode()) * 31;
            DdActionTarget ddActionTarget = this.target;
            int iHashCode2 = (iHashCode + (ddActionTarget == null ? 0 : ddActionTarget.hashCode())) * 31;
            NameSource nameSource = this.nameSource;
            return iHashCode2 + (nameSource != null ? nameSource.hashCode() : 0);
        }

        public String toString() {
            return "DdAction(position=" + this.position + ", target=" + this.target + ", nameSource=" + this.nameSource + ")";
        }

        public DdAction(Position position, DdActionTarget ddActionTarget, NameSource nameSource) {
            this.position = position;
            this.target = ddActionTarget;
            this.nameSource = nameSource;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            Position position = this.position;
            if (position != null) {
                jsonObject.add("position", position.toJson());
            }
            DdActionTarget ddActionTarget = this.target;
            if (ddActionTarget != null) {
                jsonObject.add("target", ddActionTarget.toJson());
            }
            NameSource nameSource = this.nameSource;
            if (nameSource != null) {
                jsonObject.add("name_source", nameSource.toJson());
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final DdAction fromJsonObject(JsonObject jsonObject) {
                String asString;
                JsonObject asJsonObject;
                JsonObject asJsonObject2;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get("position");
                    NameSource nameSourceFromJson = null;
                    Position positionFromJsonObject = (jsonElement == null || (asJsonObject2 = jsonElement.getAsJsonObject()) == null) ? null : Position.Companion.fromJsonObject(asJsonObject2);
                    JsonElement jsonElement2 = jsonObject.get("target");
                    DdActionTarget ddActionTargetFromJsonObject = (jsonElement2 == null || (asJsonObject = jsonElement2.getAsJsonObject()) == null) ? null : DdActionTarget.Companion.fromJsonObject(asJsonObject);
                    JsonElement jsonElement3 = jsonObject.get("name_source");
                    if (jsonElement3 != null && (asString = jsonElement3.getAsString()) != null) {
                        nameSourceFromJson = NameSource.Companion.fromJson(asString);
                    }
                    return new DdAction(positionFromJsonObject, ddActionTargetFromJsonObject, nameSourceFromJson);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type DdAction", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type DdAction", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type DdAction", e3);
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

    public static final class ActionEventActionTarget {
        public static final Companion Companion = new Companion(null);
        private String name;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ActionEventActionTarget) && Intrinsics.areEqual(this.name, ((ActionEventActionTarget) obj).name);
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        public String toString() {
            return "ActionEventActionTarget(name=" + this.name + ")";
        }

        public ActionEventActionTarget(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("name", this.name);
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final ActionEventActionTarget fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String name = jsonObject.get("name").getAsString();
                    Intrinsics.checkNotNullExpressionValue(name, "name");
                    return new ActionEventActionTarget(name);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type ActionEventActionTarget", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type ActionEventActionTarget", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type ActionEventActionTarget", e3);
                }
            }
        }
    }

    public static final class Frustration {
        public static final Companion Companion = new Companion(null);
        private final List type;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Frustration) && Intrinsics.areEqual(this.type, ((Frustration) obj).type);
        }

        public int hashCode() {
            return this.type.hashCode();
        }

        public String toString() {
            return "Frustration(type=" + this.type + ")";
        }

        public Frustration(List type) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            JsonArray jsonArray = new JsonArray(this.type.size());
            Iterator it = this.type.iterator();
            while (it.hasNext()) {
                jsonArray.add(((Type) it.next()).toJson());
            }
            jsonObject.add("type", jsonArray);
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
                    JsonArray<JsonElement> jsonArray = jsonObject.get("type").getAsJsonArray();
                    ArrayList arrayList = new ArrayList(jsonArray.size());
                    Intrinsics.checkNotNullExpressionValue(jsonArray, "jsonArray");
                    for (JsonElement jsonElement : jsonArray) {
                        Type.Companion companion = Type.Companion;
                        String asString = jsonElement.getAsString();
                        Intrinsics.checkNotNullExpressionValue(asString, "it.asString");
                        arrayList.add(companion.fromJson(asString));
                    }
                    return new Frustration(arrayList);
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

    public static final class Position {
        public static final Companion Companion = new Companion(null);
        private final long x;
        private final long y;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Position)) {
                return false;
            }
            Position position = (Position) obj;
            return this.x == position.x && this.y == position.y;
        }

        public int hashCode() {
            return (Long.hashCode(this.x) * 31) + Long.hashCode(this.y);
        }

        public String toString() {
            return "Position(x=" + this.x + ", y=" + this.y + ")";
        }

        public Position(long j, long j2) {
            this.x = j;
            this.y = j2;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("x", Long.valueOf(this.x));
            jsonObject.addProperty("y", Long.valueOf(this.y));
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Position fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    return new Position(jsonObject.get("x").getAsLong(), jsonObject.get("y").getAsLong());
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Position", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Position", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Position", e3);
                }
            }
        }
    }

    public static final class DdActionTarget {
        public static final Companion Companion = new Companion(null);
        private final Long height;
        private final String selector;
        private final Long width;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DdActionTarget)) {
                return false;
            }
            DdActionTarget ddActionTarget = (DdActionTarget) obj;
            return Intrinsics.areEqual(this.selector, ddActionTarget.selector) && Intrinsics.areEqual(this.width, ddActionTarget.width) && Intrinsics.areEqual(this.height, ddActionTarget.height);
        }

        public int hashCode() {
            String str = this.selector;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            Long l = this.width;
            int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
            Long l2 = this.height;
            return iHashCode2 + (l2 != null ? l2.hashCode() : 0);
        }

        public String toString() {
            return "DdActionTarget(selector=" + this.selector + ", width=" + this.width + ", height=" + this.height + ")";
        }

        public DdActionTarget(String str, Long l, Long l2) {
            this.selector = str;
            this.width = l;
            this.height = l2;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            String str = this.selector;
            if (str != null) {
                jsonObject.addProperty("selector", str);
            }
            Long l = this.width;
            if (l != null) {
                jsonObject.addProperty("width", Long.valueOf(l.longValue()));
            }
            Long l2 = this.height;
            if (l2 != null) {
                jsonObject.addProperty("height", Long.valueOf(l2.longValue()));
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final DdActionTarget fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get("selector");
                    String asString = jsonElement != null ? jsonElement.getAsString() : null;
                    JsonElement jsonElement2 = jsonObject.get("width");
                    Long lValueOf = jsonElement2 != null ? Long.valueOf(jsonElement2.getAsLong()) : null;
                    JsonElement jsonElement3 = jsonObject.get("height");
                    return new DdActionTarget(asString, lValueOf, jsonElement3 != null ? Long.valueOf(jsonElement3.getAsLong()) : null);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type DdActionTarget", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type DdActionTarget", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type DdActionTarget", e3);
                }
            }
        }
    }

    public enum ActionEventSource {
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

        ActionEventSource(String str) {
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

            public final ActionEventSource fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (ActionEventSource actionEventSource : ActionEventSource.values()) {
                    if (Intrinsics.areEqual(actionEventSource.jsonValue, jsonString)) {
                        return actionEventSource;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    public enum ActionEventSessionType {
        USER("user"),
        SYNTHETICS("synthetics"),
        CI_TEST("ci_test");

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        ActionEventSessionType(String str) {
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

            public final ActionEventSessionType fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (ActionEventSessionType actionEventSessionType : ActionEventSessionType.values()) {
                    if (Intrinsics.areEqual(actionEventSessionType.jsonValue, jsonString)) {
                        return actionEventSessionType;
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
        f352G("2g"),
        f363G("3g"),
        f374G("4g");

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

    public enum ActionEventActionType {
        CUSTOM("custom"),
        CLICK("click"),
        TAP("tap"),
        SCROLL("scroll"),
        SWIPE("swipe"),
        APPLICATION_START("application_start"),
        BACK("back");

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        ActionEventActionType(String str) {
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

            public final ActionEventActionType fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (ActionEventActionType actionEventActionType : ActionEventActionType.values()) {
                    if (Intrinsics.areEqual(actionEventActionType.jsonValue, jsonString)) {
                        return actionEventActionType;
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

    public enum NameSource {
        CUSTOM_ATTRIBUTE("custom_attribute"),
        MASK_PLACEHOLDER("mask_placeholder"),
        STANDARD_ATTRIBUTE("standard_attribute"),
        TEXT_CONTENT("text_content"),
        MASK_DISALLOWED("mask_disallowed"),
        BLANK("blank");

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        NameSource(String str) {
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

            public final NameSource fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (NameSource nameSource : NameSource.values()) {
                    if (Intrinsics.areEqual(nameSource.jsonValue, jsonString)) {
                        return nameSource;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    public enum Type {
        RAGE_CLICK("rage_click"),
        DEAD_CLICK("dead_click"),
        ERROR_CLICK("error_click"),
        RAGE_TAP("rage_tap"),
        ERROR_TAP("error_tap");

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        Type(String str) {
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

            public final Type fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (Type type : Type.values()) {
                    if (Intrinsics.areEqual(type.jsonValue, jsonString)) {
                        return type;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }
}
