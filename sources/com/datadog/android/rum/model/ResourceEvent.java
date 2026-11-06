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
import net.openid.appauth.RegistrationRequest;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes3.dex */
public final class ResourceEvent {
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
    private final Os os;
    private final Resource resource;
    private final String service;
    private final ResourceEventSession session;
    private final ResourceEventSource source;
    private final Synthetics synthetics;
    private final String type;
    private final Usr usr;
    private final String version;
    private final ResourceEventView view;

    public static /* synthetic */ ResourceEvent copy$default(ResourceEvent resourceEvent, long j, Application application, String str, String str2, String str3, String str4, String str5, ResourceEventSession resourceEventSession, ResourceEventSource resourceEventSource, ResourceEventView resourceEventView, Usr usr, Account account, Connectivity connectivity, Display display, Synthetics synthetics, CiTest ciTest, Os os, Device device, Dd dd, Context context, Action action, Container container, Resource resource, int i, Object obj) {
        Resource resource2;
        Container container2;
        long j2 = (i & 1) != 0 ? resourceEvent.date : j;
        Application application2 = (i & 2) != 0 ? resourceEvent.application : application;
        String str6 = (i & 4) != 0 ? resourceEvent.service : str;
        String str7 = (i & 8) != 0 ? resourceEvent.version : str2;
        String str8 = (i & 16) != 0 ? resourceEvent.buildVersion : str3;
        String str9 = (i & 32) != 0 ? resourceEvent.buildId : str4;
        String str10 = (i & 64) != 0 ? resourceEvent.ddtags : str5;
        ResourceEventSession resourceEventSession2 = (i & 128) != 0 ? resourceEvent.session : resourceEventSession;
        ResourceEventSource resourceEventSource2 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? resourceEvent.source : resourceEventSource;
        ResourceEventView resourceEventView2 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? resourceEvent.view : resourceEventView;
        Usr usr2 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? resourceEvent.usr : usr;
        Account account2 = (i & 2048) != 0 ? resourceEvent.account : account;
        Connectivity connectivity2 = (i & 4096) != 0 ? resourceEvent.connectivity : connectivity;
        long j3 = j2;
        Display display2 = (i & 8192) != 0 ? resourceEvent.display : display;
        Synthetics synthetics2 = (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? resourceEvent.synthetics : synthetics;
        CiTest ciTest2 = (i & 32768) != 0 ? resourceEvent.ciTest : ciTest;
        Os os2 = (i & 65536) != 0 ? resourceEvent.os : os;
        Device device2 = (i & 131072) != 0 ? resourceEvent.device : device;
        Dd dd2 = (i & 262144) != 0 ? resourceEvent.dd : dd;
        Context context2 = (i & 524288) != 0 ? resourceEvent.context : context;
        Action action2 = (i & 1048576) != 0 ? resourceEvent.action : action;
        Container container3 = (i & 2097152) != 0 ? resourceEvent.container : container;
        if ((i & 4194304) != 0) {
            container2 = container3;
            resource2 = resourceEvent.resource;
        } else {
            resource2 = resource;
            container2 = container3;
        }
        return resourceEvent.copy(j3, application2, str6, str7, str8, str9, str10, resourceEventSession2, resourceEventSource2, resourceEventView2, usr2, account2, connectivity2, display2, synthetics2, ciTest2, os2, device2, dd2, context2, action2, container2, resource2);
    }

    public final ResourceEvent copy(long j, Application application, String str, String str2, String str3, String str4, String str5, ResourceEventSession session, ResourceEventSource resourceEventSource, ResourceEventView view, Usr usr, Account account, Connectivity connectivity, Display display, Synthetics synthetics, CiTest ciTest, Os os, Device device, Dd dd, Context context, Action action, Container container, Resource resource) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dd, "dd");
        Intrinsics.checkNotNullParameter(resource, "resource");
        return new ResourceEvent(j, application, str, str2, str3, str4, str5, session, resourceEventSource, view, usr, account, connectivity, display, synthetics, ciTest, os, device, dd, context, action, container, resource);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResourceEvent)) {
            return false;
        }
        ResourceEvent resourceEvent = (ResourceEvent) obj;
        return this.date == resourceEvent.date && Intrinsics.areEqual(this.application, resourceEvent.application) && Intrinsics.areEqual(this.service, resourceEvent.service) && Intrinsics.areEqual(this.version, resourceEvent.version) && Intrinsics.areEqual(this.buildVersion, resourceEvent.buildVersion) && Intrinsics.areEqual(this.buildId, resourceEvent.buildId) && Intrinsics.areEqual(this.ddtags, resourceEvent.ddtags) && Intrinsics.areEqual(this.session, resourceEvent.session) && this.source == resourceEvent.source && Intrinsics.areEqual(this.view, resourceEvent.view) && Intrinsics.areEqual(this.usr, resourceEvent.usr) && Intrinsics.areEqual(this.account, resourceEvent.account) && Intrinsics.areEqual(this.connectivity, resourceEvent.connectivity) && Intrinsics.areEqual(this.display, resourceEvent.display) && Intrinsics.areEqual(this.synthetics, resourceEvent.synthetics) && Intrinsics.areEqual(this.ciTest, resourceEvent.ciTest) && Intrinsics.areEqual(this.os, resourceEvent.os) && Intrinsics.areEqual(this.device, resourceEvent.device) && Intrinsics.areEqual(this.dd, resourceEvent.dd) && Intrinsics.areEqual(this.context, resourceEvent.context) && Intrinsics.areEqual(this.action, resourceEvent.action) && Intrinsics.areEqual(this.container, resourceEvent.container) && Intrinsics.areEqual(this.resource, resourceEvent.resource);
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
        ResourceEventSource resourceEventSource = this.source;
        int iHashCode7 = (((iHashCode6 + (resourceEventSource == null ? 0 : resourceEventSource.hashCode())) * 31) + this.view.hashCode()) * 31;
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
        return ((iHashCode17 + (container != null ? container.hashCode() : 0)) * 31) + this.resource.hashCode();
    }

    public String toString() {
        return "ResourceEvent(date=" + this.date + ", application=" + this.application + ", service=" + this.service + ", version=" + this.version + ", buildVersion=" + this.buildVersion + ", buildId=" + this.buildId + ", ddtags=" + this.ddtags + ", session=" + this.session + ", source=" + this.source + ", view=" + this.view + ", usr=" + this.usr + ", account=" + this.account + ", connectivity=" + this.connectivity + ", display=" + this.display + ", synthetics=" + this.synthetics + ", ciTest=" + this.ciTest + ", os=" + this.os + ", device=" + this.device + ", dd=" + this.dd + ", context=" + this.context + ", action=" + this.action + ", container=" + this.container + ", resource=" + this.resource + ")";
    }

    public ResourceEvent(long j, Application application, String str, String str2, String str3, String str4, String str5, ResourceEventSession session, ResourceEventSource resourceEventSource, ResourceEventView view, Usr usr, Account account, Connectivity connectivity, Display display, Synthetics synthetics, CiTest ciTest, Os os, Device device, Dd dd, Context context, Action action, Container container, Resource resource) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dd, "dd");
        Intrinsics.checkNotNullParameter(resource, "resource");
        this.date = j;
        this.application = application;
        this.service = str;
        this.version = str2;
        this.buildVersion = str3;
        this.buildId = str4;
        this.ddtags = str5;
        this.session = session;
        this.source = resourceEventSource;
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
        this.resource = resource;
        this.type = "resource";
    }

    public /* synthetic */ ResourceEvent(long j, Application application, String str, String str2, String str3, String str4, String str5, ResourceEventSession resourceEventSession, ResourceEventSource resourceEventSource, ResourceEventView resourceEventView, Usr usr, Account account, Connectivity connectivity, Display display, Synthetics synthetics, CiTest ciTest, Os os, Device device, Dd dd, Context context, Action action, Container container, Resource resource, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, application, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, resourceEventSession, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : resourceEventSource, resourceEventView, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : usr, (i & 2048) != 0 ? null : account, (i & 4096) != 0 ? null : connectivity, (i & 8192) != 0 ? null : display, (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? null : synthetics, (32768 & i) != 0 ? null : ciTest, (65536 & i) != 0 ? null : os, (131072 & i) != 0 ? null : device, dd, (524288 & i) != 0 ? null : context, (1048576 & i) != 0 ? null : action, (i & 2097152) != 0 ? null : container, resource);
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
        ResourceEventSource resourceEventSource = this.source;
        if (resourceEventSource != null) {
            jsonObject.add(Constants.ScionAnalytics.PARAM_SOURCE, resourceEventSource.toJson());
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
        jsonObject.add("resource", this.resource.toJson());
        return jsonObject;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ResourceEvent fromJsonObject(JsonObject jsonObject) {
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
                ResourceEventSession.Companion companion2 = ResourceEventSession.Companion;
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                ResourceEventSession resourceEventSessionFromJsonObject = companion2.fromJsonObject(it2);
                JsonElement jsonElement6 = jsonObject.get(Constants.ScionAnalytics.PARAM_SOURCE);
                ResourceEventSource resourceEventSourceFromJson = (jsonElement6 == null || (asString = jsonElement6.getAsString()) == null) ? null : ResourceEventSource.Companion.fromJson(asString);
                JsonObject it3 = jsonObject.get("view").getAsJsonObject();
                ResourceEventView.Companion companion3 = ResourceEventView.Companion;
                Intrinsics.checkNotNullExpressionValue(it3, "it");
                ResourceEventView resourceEventViewFromJsonObject = companion3.fromJsonObject(it3);
                JsonElement jsonElement7 = jsonObject.get("usr");
                Usr usrFromJsonObject = (jsonElement7 == null || (asJsonObject11 = jsonElement7.getAsJsonObject()) == null) ? null : Usr.Companion.fromJsonObject(asJsonObject11);
                JsonElement jsonElement8 = jsonObject.get("account");
                Account accountFromJsonObject = (jsonElement8 == null || (asJsonObject10 = jsonElement8.getAsJsonObject()) == null) ? null : Account.Companion.fromJsonObject(asJsonObject10);
                JsonElement jsonElement9 = jsonObject.get("connectivity");
                Connectivity connectivityFromJsonObject = (jsonElement9 == null || (asJsonObject9 = jsonElement9.getAsJsonObject()) == null) ? null : Connectivity.Companion.fromJsonObject(asJsonObject9);
                JsonElement jsonElement10 = jsonObject.get(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION);
                Display displayFromJsonObject = (jsonElement10 == null || (asJsonObject8 = jsonElement10.getAsJsonObject()) == null) ? null : Display.Companion.fromJsonObject(asJsonObject8);
                JsonElement jsonElement11 = jsonObject.get("synthetics");
                Synthetics syntheticsFromJsonObject = (jsonElement11 == null || (asJsonObject7 = jsonElement11.getAsJsonObject()) == null) ? null : Synthetics.Companion.fromJsonObject(asJsonObject7);
                JsonElement jsonElement12 = jsonObject.get("ci_test");
                CiTest ciTestFromJsonObject = (jsonElement12 == null || (asJsonObject6 = jsonElement12.getAsJsonObject()) == null) ? null : CiTest.Companion.fromJsonObject(asJsonObject6);
                JsonElement jsonElement13 = jsonObject.get("os");
                Os osFromJsonObject = (jsonElement13 == null || (asJsonObject5 = jsonElement13.getAsJsonObject()) == null) ? null : Os.Companion.fromJsonObject(asJsonObject5);
                JsonElement jsonElement14 = jsonObject.get("device");
                Device deviceFromJsonObject = (jsonElement14 == null || (asJsonObject4 = jsonElement14.getAsJsonObject()) == null) ? null : Device.Companion.fromJsonObject(asJsonObject4);
                JsonObject it4 = jsonObject.get("_dd").getAsJsonObject();
                Device device = deviceFromJsonObject;
                Dd.Companion companion4 = Dd.Companion;
                Intrinsics.checkNotNullExpressionValue(it4, "it");
                Dd ddFromJsonObject = companion4.fromJsonObject(it4);
                JsonElement jsonElement15 = jsonObject.get("context");
                Context contextFromJsonObject = (jsonElement15 == null || (asJsonObject3 = jsonElement15.getAsJsonObject()) == null) ? null : Context.Companion.fromJsonObject(asJsonObject3);
                JsonElement jsonElement16 = jsonObject.get("action");
                Action actionFromJsonObject = (jsonElement16 == null || (asJsonObject2 = jsonElement16.getAsJsonObject()) == null) ? null : Action.Companion.fromJsonObject(asJsonObject2);
                JsonElement jsonElement17 = jsonObject.get("container");
                Container containerFromJsonObject = (jsonElement17 == null || (asJsonObject = jsonElement17.getAsJsonObject()) == null) ? null : Container.Companion.fromJsonObject(asJsonObject);
                String asString7 = jsonObject.get("type").getAsString();
                JsonObject it5 = jsonObject.get("resource").getAsJsonObject();
                Container container = containerFromJsonObject;
                Resource.Companion companion5 = Resource.Companion;
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                Resource resourceFromJsonObject = companion5.fromJsonObject(it5);
                if (!Intrinsics.areEqual(asString7, "resource")) {
                    throw new IllegalStateException("Check failed.");
                }
                return new ResourceEvent(asLong, applicationFromJsonObject, asString2, asString3, asString4, asString5, asString6, resourceEventSessionFromJsonObject, resourceEventSourceFromJson, resourceEventViewFromJsonObject, usrFromJsonObject, accountFromJsonObject, connectivityFromJsonObject, displayFromJsonObject, syntheticsFromJsonObject, ciTestFromJsonObject, osFromJsonObject, device, ddFromJsonObject, contextFromJsonObject, actionFromJsonObject, container, resourceFromJsonObject);
            } catch (IllegalStateException e) {
                throw new JsonParseException("Unable to parse json into type ResourceEvent", e);
            } catch (NullPointerException e2) {
                throw new JsonParseException("Unable to parse json into type ResourceEvent", e2);
            } catch (NumberFormatException e3) {
                throw new JsonParseException("Unable to parse json into type ResourceEvent", e3);
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

    public static final class ResourceEventSession {
        public static final Companion Companion = new Companion(null);
        private final Boolean hasReplay;
        private final String id;
        private final ResourceEventSessionType type;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ResourceEventSession)) {
                return false;
            }
            ResourceEventSession resourceEventSession = (ResourceEventSession) obj;
            return Intrinsics.areEqual(this.id, resourceEventSession.id) && this.type == resourceEventSession.type && Intrinsics.areEqual(this.hasReplay, resourceEventSession.hasReplay);
        }

        public int hashCode() {
            int iHashCode = ((this.id.hashCode() * 31) + this.type.hashCode()) * 31;
            Boolean bool = this.hasReplay;
            return iHashCode + (bool == null ? 0 : bool.hashCode());
        }

        public String toString() {
            return "ResourceEventSession(id=" + this.id + ", type=" + this.type + ", hasReplay=" + this.hasReplay + ")";
        }

        public ResourceEventSession(String id, ResourceEventSessionType type, Boolean bool) {
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

            public final ResourceEventSession fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String id = jsonObject.get(DiagnosticsEntry.ID_KEY).getAsString();
                    ResourceEventSessionType.Companion companion = ResourceEventSessionType.Companion;
                    String asString = jsonObject.get("type").getAsString();
                    Intrinsics.checkNotNullExpressionValue(asString, "jsonObject.get(\"type\").asString");
                    ResourceEventSessionType resourceEventSessionTypeFromJson = companion.fromJson(asString);
                    JsonElement jsonElement = jsonObject.get("has_replay");
                    Boolean boolValueOf = jsonElement != null ? Boolean.valueOf(jsonElement.getAsBoolean()) : null;
                    Intrinsics.checkNotNullExpressionValue(id, "id");
                    return new ResourceEventSession(id, resourceEventSessionTypeFromJson, boolValueOf);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type ResourceEventSession", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type ResourceEventSession", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type ResourceEventSession", e3);
                }
            }
        }
    }

    public static final class ResourceEventView {
        public static final Companion Companion = new Companion(null);
        private final String id;
        private String name;
        private String referrer;
        private String url;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ResourceEventView)) {
                return false;
            }
            ResourceEventView resourceEventView = (ResourceEventView) obj;
            return Intrinsics.areEqual(this.id, resourceEventView.id) && Intrinsics.areEqual(this.referrer, resourceEventView.referrer) && Intrinsics.areEqual(this.url, resourceEventView.url) && Intrinsics.areEqual(this.name, resourceEventView.name);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.referrer;
            int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.url.hashCode()) * 31;
            String str2 = this.name;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "ResourceEventView(id=" + this.id + ", referrer=" + this.referrer + ", url=" + this.url + ", name=" + this.name + ")";
        }

        public ResourceEventView(String id, String str, String url, String str2) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(url, "url");
            this.id = id;
            this.referrer = str;
            this.url = url;
            this.name = str2;
        }

        public /* synthetic */ ResourceEventView(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2, str3, (i & 8) != 0 ? null : str4);
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
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final ResourceEventView fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String id = jsonObject.get(DiagnosticsEntry.ID_KEY).getAsString();
                    JsonElement jsonElement = jsonObject.get(com.adjust.sdk.Constants.REFERRER);
                    String asString = jsonElement != null ? jsonElement.getAsString() : null;
                    String url = jsonObject.get("url").getAsString();
                    JsonElement jsonElement2 = jsonObject.get("name");
                    String asString2 = jsonElement2 != null ? jsonElement2.getAsString() : null;
                    Intrinsics.checkNotNullExpressionValue(id, "id");
                    Intrinsics.checkNotNullExpressionValue(url, "url");
                    return new ResourceEventView(id, asString, url, asString2);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type ResourceEventView", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type ResourceEventView", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type ResourceEventView", e3);
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
        private final Boolean discarded;
        private final long formatVersion;
        private final String parentSpanId;
        private final Number rulePsr;
        private final String sdkName;
        private final DdSession session;
        private final String spanId;
        private final String traceId;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Dd)) {
                return false;
            }
            Dd dd = (Dd) obj;
            return Intrinsics.areEqual(this.session, dd.session) && Intrinsics.areEqual(this.configuration, dd.configuration) && Intrinsics.areEqual(this.browserSdkVersion, dd.browserSdkVersion) && Intrinsics.areEqual(this.sdkName, dd.sdkName) && Intrinsics.areEqual(this.spanId, dd.spanId) && Intrinsics.areEqual(this.parentSpanId, dd.parentSpanId) && Intrinsics.areEqual(this.traceId, dd.traceId) && Intrinsics.areEqual(this.rulePsr, dd.rulePsr) && Intrinsics.areEqual(this.discarded, dd.discarded);
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
            String str3 = this.spanId;
            int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.parentSpanId;
            int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.traceId;
            int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
            Number number = this.rulePsr;
            int iHashCode8 = (iHashCode7 + (number == null ? 0 : number.hashCode())) * 31;
            Boolean bool = this.discarded;
            return iHashCode8 + (bool != null ? bool.hashCode() : 0);
        }

        public String toString() {
            return "Dd(session=" + this.session + ", configuration=" + this.configuration + ", browserSdkVersion=" + this.browserSdkVersion + ", sdkName=" + this.sdkName + ", spanId=" + this.spanId + ", parentSpanId=" + this.parentSpanId + ", traceId=" + this.traceId + ", rulePsr=" + this.rulePsr + ", discarded=" + this.discarded + ")";
        }

        public Dd(DdSession ddSession, Configuration configuration, String str, String str2, String str3, String str4, String str5, Number number, Boolean bool) {
            this.session = ddSession;
            this.configuration = configuration;
            this.browserSdkVersion = str;
            this.sdkName = str2;
            this.spanId = str3;
            this.parentSpanId = str4;
            this.traceId = str5;
            this.rulePsr = number;
            this.discarded = bool;
            this.formatVersion = 2L;
        }

        public /* synthetic */ Dd(DdSession ddSession, Configuration configuration, String str, String str2, String str3, String str4, String str5, Number number, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : ddSession, (i & 2) != 0 ? null : configuration, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : number, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : bool);
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
            String str3 = this.spanId;
            if (str3 != null) {
                jsonObject.addProperty("span_id", str3);
            }
            String str4 = this.parentSpanId;
            if (str4 != null) {
                jsonObject.addProperty("parent_span_id", str4);
            }
            String str5 = this.traceId;
            if (str5 != null) {
                jsonObject.addProperty("trace_id", str5);
            }
            Number number = this.rulePsr;
            if (number != null) {
                jsonObject.addProperty("rule_psr", number);
            }
            Boolean bool = this.discarded;
            if (bool != null) {
                jsonObject.addProperty("discarded", bool);
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
                    JsonElement jsonElement5 = jsonObject.get("span_id");
                    String asString3 = jsonElement5 != null ? jsonElement5.getAsString() : null;
                    JsonElement jsonElement6 = jsonObject.get("parent_span_id");
                    String asString4 = jsonElement6 != null ? jsonElement6.getAsString() : null;
                    JsonElement jsonElement7 = jsonObject.get("trace_id");
                    String asString5 = jsonElement7 != null ? jsonElement7.getAsString() : null;
                    JsonElement jsonElement8 = jsonObject.get("rule_psr");
                    Number asNumber = jsonElement8 != null ? jsonElement8.getAsNumber() : null;
                    JsonElement jsonElement9 = jsonObject.get("discarded");
                    Boolean boolValueOf = jsonElement9 != null ? Boolean.valueOf(jsonElement9.getAsBoolean()) : null;
                    if (asLong != 2) {
                        throw new IllegalStateException("Check failed.");
                    }
                    return new Dd(ddSessionFromJsonObject, configurationFromJsonObject, asString, asString2, asString3, asString4, asString5, asNumber, boolValueOf);
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
        private final ResourceEventSource source;
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

        public Container(ContainerView view, ResourceEventSource source) {
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
                    ResourceEventSource.Companion companion2 = ResourceEventSource.Companion;
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

    public static final class Resource {
        public static final Companion Companion = new Companion(null);
        private final Connect connect;
        private final Long decodedBodySize;
        private final DeliveryType deliveryType;
        private final Dns dns;
        private final Download download;
        private final Long duration;
        private final Long encodedBodySize;
        private final FirstByte firstByte;
        private final Graphql graphql;
        private final String id;
        private final Method method;
        private final String protocol;
        private final Provider provider;
        private final Redirect redirect;
        private final RenderBlockingStatus renderBlockingStatus;
        private final Long size;
        private final Ssl ssl;
        private final Long statusCode;
        private final Long transferSize;
        private final ResourceType type;
        private String url;
        private final Worker worker;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Resource)) {
                return false;
            }
            Resource resource = (Resource) obj;
            return Intrinsics.areEqual(this.id, resource.id) && this.type == resource.type && this.method == resource.method && Intrinsics.areEqual(this.url, resource.url) && Intrinsics.areEqual(this.statusCode, resource.statusCode) && Intrinsics.areEqual(this.duration, resource.duration) && Intrinsics.areEqual(this.size, resource.size) && Intrinsics.areEqual(this.encodedBodySize, resource.encodedBodySize) && Intrinsics.areEqual(this.decodedBodySize, resource.decodedBodySize) && Intrinsics.areEqual(this.transferSize, resource.transferSize) && this.renderBlockingStatus == resource.renderBlockingStatus && Intrinsics.areEqual(this.worker, resource.worker) && Intrinsics.areEqual(this.redirect, resource.redirect) && Intrinsics.areEqual(this.dns, resource.dns) && Intrinsics.areEqual(this.connect, resource.connect) && Intrinsics.areEqual(this.ssl, resource.ssl) && Intrinsics.areEqual(this.firstByte, resource.firstByte) && Intrinsics.areEqual(this.download, resource.download) && Intrinsics.areEqual(this.protocol, resource.protocol) && this.deliveryType == resource.deliveryType && Intrinsics.areEqual(this.provider, resource.provider) && Intrinsics.areEqual(this.graphql, resource.graphql);
        }

        public int hashCode() {
            String str = this.id;
            int iHashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.type.hashCode()) * 31;
            Method method = this.method;
            int iHashCode2 = (((iHashCode + (method == null ? 0 : method.hashCode())) * 31) + this.url.hashCode()) * 31;
            Long l = this.statusCode;
            int iHashCode3 = (iHashCode2 + (l == null ? 0 : l.hashCode())) * 31;
            Long l2 = this.duration;
            int iHashCode4 = (iHashCode3 + (l2 == null ? 0 : l2.hashCode())) * 31;
            Long l3 = this.size;
            int iHashCode5 = (iHashCode4 + (l3 == null ? 0 : l3.hashCode())) * 31;
            Long l4 = this.encodedBodySize;
            int iHashCode6 = (iHashCode5 + (l4 == null ? 0 : l4.hashCode())) * 31;
            Long l5 = this.decodedBodySize;
            int iHashCode7 = (iHashCode6 + (l5 == null ? 0 : l5.hashCode())) * 31;
            Long l6 = this.transferSize;
            int iHashCode8 = (iHashCode7 + (l6 == null ? 0 : l6.hashCode())) * 31;
            RenderBlockingStatus renderBlockingStatus = this.renderBlockingStatus;
            int iHashCode9 = (iHashCode8 + (renderBlockingStatus == null ? 0 : renderBlockingStatus.hashCode())) * 31;
            Worker worker = this.worker;
            int iHashCode10 = (iHashCode9 + (worker == null ? 0 : worker.hashCode())) * 31;
            Redirect redirect = this.redirect;
            int iHashCode11 = (iHashCode10 + (redirect == null ? 0 : redirect.hashCode())) * 31;
            Dns dns = this.dns;
            int iHashCode12 = (iHashCode11 + (dns == null ? 0 : dns.hashCode())) * 31;
            Connect connect = this.connect;
            int iHashCode13 = (iHashCode12 + (connect == null ? 0 : connect.hashCode())) * 31;
            Ssl ssl = this.ssl;
            int iHashCode14 = (iHashCode13 + (ssl == null ? 0 : ssl.hashCode())) * 31;
            FirstByte firstByte = this.firstByte;
            int iHashCode15 = (iHashCode14 + (firstByte == null ? 0 : firstByte.hashCode())) * 31;
            Download download = this.download;
            int iHashCode16 = (iHashCode15 + (download == null ? 0 : download.hashCode())) * 31;
            String str2 = this.protocol;
            int iHashCode17 = (iHashCode16 + (str2 == null ? 0 : str2.hashCode())) * 31;
            DeliveryType deliveryType = this.deliveryType;
            int iHashCode18 = (iHashCode17 + (deliveryType == null ? 0 : deliveryType.hashCode())) * 31;
            Provider provider = this.provider;
            int iHashCode19 = (iHashCode18 + (provider == null ? 0 : provider.hashCode())) * 31;
            Graphql graphql = this.graphql;
            return iHashCode19 + (graphql != null ? graphql.hashCode() : 0);
        }

        public String toString() {
            return "Resource(id=" + this.id + ", type=" + this.type + ", method=" + this.method + ", url=" + this.url + ", statusCode=" + this.statusCode + ", duration=" + this.duration + ", size=" + this.size + ", encodedBodySize=" + this.encodedBodySize + ", decodedBodySize=" + this.decodedBodySize + ", transferSize=" + this.transferSize + ", renderBlockingStatus=" + this.renderBlockingStatus + ", worker=" + this.worker + ", redirect=" + this.redirect + ", dns=" + this.dns + ", connect=" + this.connect + ", ssl=" + this.ssl + ", firstByte=" + this.firstByte + ", download=" + this.download + ", protocol=" + this.protocol + ", deliveryType=" + this.deliveryType + ", provider=" + this.provider + ", graphql=" + this.graphql + ")";
        }

        public Resource(String str, ResourceType type, Method method, String url, Long l, Long l2, Long l3, Long l4, Long l5, Long l6, RenderBlockingStatus renderBlockingStatus, Worker worker, Redirect redirect, Dns dns, Connect connect, Ssl ssl, FirstByte firstByte, Download download, String str2, DeliveryType deliveryType, Provider provider, Graphql graphql) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(url, "url");
            this.id = str;
            this.type = type;
            this.method = method;
            this.url = url;
            this.statusCode = l;
            this.duration = l2;
            this.size = l3;
            this.encodedBodySize = l4;
            this.decodedBodySize = l5;
            this.transferSize = l6;
            this.renderBlockingStatus = renderBlockingStatus;
            this.worker = worker;
            this.redirect = redirect;
            this.dns = dns;
            this.connect = connect;
            this.ssl = ssl;
            this.firstByte = firstByte;
            this.download = download;
            this.protocol = str2;
            this.deliveryType = deliveryType;
            this.provider = provider;
            this.graphql = graphql;
        }

        public /* synthetic */ Resource(String str, ResourceType resourceType, Method method, String str2, Long l, Long l2, Long l3, Long l4, Long l5, Long l6, RenderBlockingStatus renderBlockingStatus, Worker worker, Redirect redirect, Dns dns, Connect connect, Ssl ssl, FirstByte firstByte, Download download, String str3, DeliveryType deliveryType, Provider provider, Graphql graphql, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, resourceType, (i & 4) != 0 ? null : method, str2, (i & 16) != 0 ? null : l, (i & 32) != 0 ? null : l2, (i & 64) != 0 ? null : l3, (i & 128) != 0 ? null : l4, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : l5, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? null : l6, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : renderBlockingStatus, (i & 2048) != 0 ? null : worker, (i & 4096) != 0 ? null : redirect, (i & 8192) != 0 ? null : dns, (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? null : connect, (32768 & i) != 0 ? null : ssl, (65536 & i) != 0 ? null : firstByte, (131072 & i) != 0 ? null : download, (262144 & i) != 0 ? null : str3, (524288 & i) != 0 ? null : deliveryType, (1048576 & i) != 0 ? null : provider, (i & 2097152) != 0 ? null : graphql);
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            String str = this.id;
            if (str != null) {
                jsonObject.addProperty(DiagnosticsEntry.ID_KEY, str);
            }
            jsonObject.add("type", this.type.toJson());
            Method method = this.method;
            if (method != null) {
                jsonObject.add("method", method.toJson());
            }
            jsonObject.addProperty("url", this.url);
            Long l = this.statusCode;
            if (l != null) {
                jsonObject.addProperty("status_code", Long.valueOf(l.longValue()));
            }
            Long l2 = this.duration;
            if (l2 != null) {
                jsonObject.addProperty("duration", Long.valueOf(l2.longValue()));
            }
            Long l3 = this.size;
            if (l3 != null) {
                jsonObject.addProperty("size", Long.valueOf(l3.longValue()));
            }
            Long l4 = this.encodedBodySize;
            if (l4 != null) {
                jsonObject.addProperty("encoded_body_size", Long.valueOf(l4.longValue()));
            }
            Long l5 = this.decodedBodySize;
            if (l5 != null) {
                jsonObject.addProperty("decoded_body_size", Long.valueOf(l5.longValue()));
            }
            Long l6 = this.transferSize;
            if (l6 != null) {
                jsonObject.addProperty("transfer_size", Long.valueOf(l6.longValue()));
            }
            RenderBlockingStatus renderBlockingStatus = this.renderBlockingStatus;
            if (renderBlockingStatus != null) {
                jsonObject.add("render_blocking_status", renderBlockingStatus.toJson());
            }
            Worker worker = this.worker;
            if (worker != null) {
                jsonObject.add("worker", worker.toJson());
            }
            Redirect redirect = this.redirect;
            if (redirect != null) {
                jsonObject.add("redirect", redirect.toJson());
            }
            Dns dns = this.dns;
            if (dns != null) {
                jsonObject.add("dns", dns.toJson());
            }
            Connect connect = this.connect;
            if (connect != null) {
                jsonObject.add("connect", connect.toJson());
            }
            Ssl ssl = this.ssl;
            if (ssl != null) {
                jsonObject.add("ssl", ssl.toJson());
            }
            FirstByte firstByte = this.firstByte;
            if (firstByte != null) {
                jsonObject.add("first_byte", firstByte.toJson());
            }
            Download download = this.download;
            if (download != null) {
                jsonObject.add("download", download.toJson());
            }
            String str2 = this.protocol;
            if (str2 != null) {
                jsonObject.addProperty("protocol", str2);
            }
            DeliveryType deliveryType = this.deliveryType;
            if (deliveryType != null) {
                jsonObject.add("delivery_type", deliveryType.toJson());
            }
            Provider provider = this.provider;
            if (provider != null) {
                jsonObject.add("provider", provider.toJson());
            }
            Graphql graphql = this.graphql;
            if (graphql != null) {
                jsonObject.add("graphql", graphql.toJson());
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
                JsonObject asJsonObject2;
                String asString;
                JsonObject asJsonObject3;
                JsonObject asJsonObject4;
                JsonObject asJsonObject5;
                JsonObject asJsonObject6;
                JsonObject asJsonObject7;
                JsonObject asJsonObject8;
                JsonObject asJsonObject9;
                String asString2;
                String asString3;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get(DiagnosticsEntry.ID_KEY);
                    String asString4 = jsonElement != null ? jsonElement.getAsString() : null;
                    ResourceType.Companion companion = ResourceType.Companion;
                    String asString5 = jsonObject.get("type").getAsString();
                    Intrinsics.checkNotNullExpressionValue(asString5, "jsonObject.get(\"type\").asString");
                    ResourceType resourceTypeFromJson = companion.fromJson(asString5);
                    JsonElement jsonElement2 = jsonObject.get("method");
                    Method methodFromJson = (jsonElement2 == null || (asString3 = jsonElement2.getAsString()) == null) ? null : Method.Companion.fromJson(asString3);
                    String url = jsonObject.get("url").getAsString();
                    JsonElement jsonElement3 = jsonObject.get("status_code");
                    Long lValueOf = jsonElement3 != null ? Long.valueOf(jsonElement3.getAsLong()) : null;
                    JsonElement jsonElement4 = jsonObject.get("duration");
                    Long lValueOf2 = jsonElement4 != null ? Long.valueOf(jsonElement4.getAsLong()) : null;
                    JsonElement jsonElement5 = jsonObject.get("size");
                    Long lValueOf3 = jsonElement5 != null ? Long.valueOf(jsonElement5.getAsLong()) : null;
                    JsonElement jsonElement6 = jsonObject.get("encoded_body_size");
                    Long lValueOf4 = jsonElement6 != null ? Long.valueOf(jsonElement6.getAsLong()) : null;
                    JsonElement jsonElement7 = jsonObject.get("decoded_body_size");
                    Long lValueOf5 = jsonElement7 != null ? Long.valueOf(jsonElement7.getAsLong()) : null;
                    JsonElement jsonElement8 = jsonObject.get("transfer_size");
                    Long lValueOf6 = jsonElement8 != null ? Long.valueOf(jsonElement8.getAsLong()) : null;
                    JsonElement jsonElement9 = jsonObject.get("render_blocking_status");
                    RenderBlockingStatus renderBlockingStatusFromJson = (jsonElement9 == null || (asString2 = jsonElement9.getAsString()) == null) ? null : RenderBlockingStatus.Companion.fromJson(asString2);
                    JsonElement jsonElement10 = jsonObject.get("worker");
                    Worker workerFromJsonObject = (jsonElement10 == null || (asJsonObject9 = jsonElement10.getAsJsonObject()) == null) ? null : Worker.Companion.fromJsonObject(asJsonObject9);
                    JsonElement jsonElement11 = jsonObject.get("redirect");
                    Redirect redirectFromJsonObject = (jsonElement11 == null || (asJsonObject8 = jsonElement11.getAsJsonObject()) == null) ? null : Redirect.Companion.fromJsonObject(asJsonObject8);
                    JsonElement jsonElement12 = jsonObject.get("dns");
                    Dns dnsFromJsonObject = (jsonElement12 == null || (asJsonObject7 = jsonElement12.getAsJsonObject()) == null) ? null : Dns.Companion.fromJsonObject(asJsonObject7);
                    JsonElement jsonElement13 = jsonObject.get("connect");
                    Connect connectFromJsonObject = (jsonElement13 == null || (asJsonObject6 = jsonElement13.getAsJsonObject()) == null) ? null : Connect.Companion.fromJsonObject(asJsonObject6);
                    JsonElement jsonElement14 = jsonObject.get("ssl");
                    Ssl sslFromJsonObject = (jsonElement14 == null || (asJsonObject5 = jsonElement14.getAsJsonObject()) == null) ? null : Ssl.Companion.fromJsonObject(asJsonObject5);
                    JsonElement jsonElement15 = jsonObject.get("first_byte");
                    FirstByte firstByteFromJsonObject = (jsonElement15 == null || (asJsonObject4 = jsonElement15.getAsJsonObject()) == null) ? null : FirstByte.Companion.fromJsonObject(asJsonObject4);
                    JsonElement jsonElement16 = jsonObject.get("download");
                    Download downloadFromJsonObject = (jsonElement16 == null || (asJsonObject3 = jsonElement16.getAsJsonObject()) == null) ? null : Download.Companion.fromJsonObject(asJsonObject3);
                    JsonElement jsonElement17 = jsonObject.get("protocol");
                    String asString6 = jsonElement17 != null ? jsonElement17.getAsString() : null;
                    Download download = downloadFromJsonObject;
                    JsonElement jsonElement18 = jsonObject.get("delivery_type");
                    DeliveryType deliveryTypeFromJson = (jsonElement18 == null || (asString = jsonElement18.getAsString()) == null) ? null : DeliveryType.Companion.fromJson(asString);
                    JsonElement jsonElement19 = jsonObject.get("provider");
                    Provider providerFromJsonObject = (jsonElement19 == null || (asJsonObject2 = jsonElement19.getAsJsonObject()) == null) ? null : Provider.Companion.fromJsonObject(asJsonObject2);
                    JsonElement jsonElement20 = jsonObject.get("graphql");
                    Graphql graphqlFromJsonObject = (jsonElement20 == null || (asJsonObject = jsonElement20.getAsJsonObject()) == null) ? null : Graphql.Companion.fromJsonObject(asJsonObject);
                    Redirect redirect = redirectFromJsonObject;
                    Connect connect = connectFromJsonObject;
                    FirstByte firstByte = firstByteFromJsonObject;
                    String str = asString6;
                    Provider provider = providerFromJsonObject;
                    Intrinsics.checkNotNullExpressionValue(url, "url");
                    return new Resource(asString4, resourceTypeFromJson, methodFromJson, url, lValueOf, lValueOf2, lValueOf3, lValueOf4, lValueOf5, lValueOf6, renderBlockingStatusFromJson, workerFromJsonObject, redirect, dnsFromJsonObject, connect, sslFromJsonObject, firstByte, download, str, deliveryTypeFromJson, provider, graphqlFromJsonObject);
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

    public static final class Worker {
        public static final Companion Companion = new Companion(null);
        private final long duration;
        private final long start;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Worker)) {
                return false;
            }
            Worker worker = (Worker) obj;
            return this.duration == worker.duration && this.start == worker.start;
        }

        public int hashCode() {
            return (Long.hashCode(this.duration) * 31) + Long.hashCode(this.start);
        }

        public String toString() {
            return "Worker(duration=" + this.duration + ", start=" + this.start + ")";
        }

        public Worker(long j, long j2) {
            this.duration = j;
            this.start = j2;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("duration", Long.valueOf(this.duration));
            jsonObject.addProperty("start", Long.valueOf(this.start));
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Worker fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    return new Worker(jsonObject.get("duration").getAsLong(), jsonObject.get("start").getAsLong());
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Worker", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Worker", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Worker", e3);
                }
            }
        }
    }

    public static final class Redirect {
        public static final Companion Companion = new Companion(null);
        private final long duration;
        private final long start;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Redirect)) {
                return false;
            }
            Redirect redirect = (Redirect) obj;
            return this.duration == redirect.duration && this.start == redirect.start;
        }

        public int hashCode() {
            return (Long.hashCode(this.duration) * 31) + Long.hashCode(this.start);
        }

        public String toString() {
            return "Redirect(duration=" + this.duration + ", start=" + this.start + ")";
        }

        public Redirect(long j, long j2) {
            this.duration = j;
            this.start = j2;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("duration", Long.valueOf(this.duration));
            jsonObject.addProperty("start", Long.valueOf(this.start));
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Redirect fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    return new Redirect(jsonObject.get("duration").getAsLong(), jsonObject.get("start").getAsLong());
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Redirect", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Redirect", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Redirect", e3);
                }
            }
        }
    }

    public static final class Dns {
        public static final Companion Companion = new Companion(null);
        private final long duration;
        private final long start;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Dns)) {
                return false;
            }
            Dns dns = (Dns) obj;
            return this.duration == dns.duration && this.start == dns.start;
        }

        public int hashCode() {
            return (Long.hashCode(this.duration) * 31) + Long.hashCode(this.start);
        }

        public String toString() {
            return "Dns(duration=" + this.duration + ", start=" + this.start + ")";
        }

        public Dns(long j, long j2) {
            this.duration = j;
            this.start = j2;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("duration", Long.valueOf(this.duration));
            jsonObject.addProperty("start", Long.valueOf(this.start));
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Dns fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    return new Dns(jsonObject.get("duration").getAsLong(), jsonObject.get("start").getAsLong());
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Dns", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Dns", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Dns", e3);
                }
            }
        }
    }

    public static final class Connect {
        public static final Companion Companion = new Companion(null);
        private final long duration;
        private final long start;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Connect)) {
                return false;
            }
            Connect connect = (Connect) obj;
            return this.duration == connect.duration && this.start == connect.start;
        }

        public int hashCode() {
            return (Long.hashCode(this.duration) * 31) + Long.hashCode(this.start);
        }

        public String toString() {
            return "Connect(duration=" + this.duration + ", start=" + this.start + ")";
        }

        public Connect(long j, long j2) {
            this.duration = j;
            this.start = j2;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("duration", Long.valueOf(this.duration));
            jsonObject.addProperty("start", Long.valueOf(this.start));
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Connect fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    return new Connect(jsonObject.get("duration").getAsLong(), jsonObject.get("start").getAsLong());
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Connect", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Connect", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Connect", e3);
                }
            }
        }
    }

    public static final class Ssl {
        public static final Companion Companion = new Companion(null);
        private final long duration;
        private final long start;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Ssl)) {
                return false;
            }
            Ssl ssl = (Ssl) obj;
            return this.duration == ssl.duration && this.start == ssl.start;
        }

        public int hashCode() {
            return (Long.hashCode(this.duration) * 31) + Long.hashCode(this.start);
        }

        public String toString() {
            return "Ssl(duration=" + this.duration + ", start=" + this.start + ")";
        }

        public Ssl(long j, long j2) {
            this.duration = j;
            this.start = j2;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("duration", Long.valueOf(this.duration));
            jsonObject.addProperty("start", Long.valueOf(this.start));
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Ssl fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    return new Ssl(jsonObject.get("duration").getAsLong(), jsonObject.get("start").getAsLong());
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Ssl", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Ssl", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Ssl", e3);
                }
            }
        }
    }

    public static final class FirstByte {
        public static final Companion Companion = new Companion(null);
        private final long duration;
        private final long start;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FirstByte)) {
                return false;
            }
            FirstByte firstByte = (FirstByte) obj;
            return this.duration == firstByte.duration && this.start == firstByte.start;
        }

        public int hashCode() {
            return (Long.hashCode(this.duration) * 31) + Long.hashCode(this.start);
        }

        public String toString() {
            return "FirstByte(duration=" + this.duration + ", start=" + this.start + ")";
        }

        public FirstByte(long j, long j2) {
            this.duration = j;
            this.start = j2;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("duration", Long.valueOf(this.duration));
            jsonObject.addProperty("start", Long.valueOf(this.start));
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final FirstByte fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    return new FirstByte(jsonObject.get("duration").getAsLong(), jsonObject.get("start").getAsLong());
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type FirstByte", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type FirstByte", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type FirstByte", e3);
                }
            }
        }
    }

    public static final class Download {
        public static final Companion Companion = new Companion(null);
        private final long duration;
        private final long start;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Download)) {
                return false;
            }
            Download download = (Download) obj;
            return this.duration == download.duration && this.start == download.start;
        }

        public int hashCode() {
            return (Long.hashCode(this.duration) * 31) + Long.hashCode(this.start);
        }

        public String toString() {
            return "Download(duration=" + this.duration + ", start=" + this.start + ")";
        }

        public Download(long j, long j2) {
            this.duration = j;
            this.start = j2;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("duration", Long.valueOf(this.duration));
            jsonObject.addProperty("start", Long.valueOf(this.start));
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Download fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    return new Download(jsonObject.get("duration").getAsLong(), jsonObject.get("start").getAsLong());
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Download", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Download", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Download", e3);
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

        public /* synthetic */ Provider(String str, String str2, ProviderType providerType, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : providerType);
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

    public static final class Graphql {
        public static final Companion Companion = new Companion(null);
        private final String operationName;
        private final OperationType operationType;
        private String payload;
        private String variables;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Graphql)) {
                return false;
            }
            Graphql graphql = (Graphql) obj;
            return this.operationType == graphql.operationType && Intrinsics.areEqual(this.operationName, graphql.operationName) && Intrinsics.areEqual(this.payload, graphql.payload) && Intrinsics.areEqual(this.variables, graphql.variables);
        }

        public int hashCode() {
            int iHashCode = this.operationType.hashCode() * 31;
            String str = this.operationName;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.payload;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.variables;
            return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "Graphql(operationType=" + this.operationType + ", operationName=" + this.operationName + ", payload=" + this.payload + ", variables=" + this.variables + ")";
        }

        public Graphql(OperationType operationType, String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(operationType, "operationType");
            this.operationType = operationType;
            this.operationName = str;
            this.payload = str2;
            this.variables = str3;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("operationType", this.operationType.toJson());
            String str = this.operationName;
            if (str != null) {
                jsonObject.addProperty("operationName", str);
            }
            String str2 = this.payload;
            if (str2 != null) {
                jsonObject.addProperty("payload", str2);
            }
            String str3 = this.variables;
            if (str3 != null) {
                jsonObject.addProperty("variables", str3);
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Graphql fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    OperationType.Companion companion = OperationType.Companion;
                    String asString = jsonObject.get("operationType").getAsString();
                    Intrinsics.checkNotNullExpressionValue(asString, "jsonObject.get(\"operationType\").asString");
                    OperationType operationTypeFromJson = companion.fromJson(asString);
                    JsonElement jsonElement = jsonObject.get("operationName");
                    String asString2 = jsonElement != null ? jsonElement.getAsString() : null;
                    JsonElement jsonElement2 = jsonObject.get("payload");
                    String asString3 = jsonElement2 != null ? jsonElement2.getAsString() : null;
                    JsonElement jsonElement3 = jsonObject.get("variables");
                    return new Graphql(operationTypeFromJson, asString2, asString3, jsonElement3 != null ? jsonElement3.getAsString() : null);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Graphql", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Graphql", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Graphql", e3);
                }
            }
        }
    }

    public enum ResourceEventSource {
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

        ResourceEventSource(String str) {
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

            public final ResourceEventSource fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (ResourceEventSource resourceEventSource : ResourceEventSource.values()) {
                    if (Intrinsics.areEqual(resourceEventSource.jsonValue, jsonString)) {
                        return resourceEventSource;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    public enum ResourceEventSessionType {
        USER("user"),
        SYNTHETICS("synthetics"),
        CI_TEST("ci_test");

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        ResourceEventSessionType(String str) {
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

            public final ResourceEventSessionType fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (ResourceEventSessionType resourceEventSessionType : ResourceEventSessionType.values()) {
                    if (Intrinsics.areEqual(resourceEventSessionType.jsonValue, jsonString)) {
                        return resourceEventSessionType;
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
        f442G("2g"),
        f453G("3g"),
        f464G("4g");

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

    public enum ResourceType {
        DOCUMENT("document"),
        XHR("xhr"),
        BEACON("beacon"),
        FETCH("fetch"),
        CSS("css"),
        JS("js"),
        IMAGE("image"),
        FONT("font"),
        MEDIA("media"),
        OTHER(PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER),
        NATIVE(RegistrationRequest.APPLICATION_TYPE_NATIVE);

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        ResourceType(String str) {
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

            public final ResourceType fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (ResourceType resourceType : ResourceType.values()) {
                    if (Intrinsics.areEqual(resourceType.jsonValue, jsonString)) {
                        return resourceType;
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

    public enum RenderBlockingStatus {
        BLOCKING("blocking"),
        NON_BLOCKING("non-blocking");

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        RenderBlockingStatus(String str) {
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

            public final RenderBlockingStatus fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (RenderBlockingStatus renderBlockingStatus : RenderBlockingStatus.values()) {
                    if (Intrinsics.areEqual(renderBlockingStatus.jsonValue, jsonString)) {
                        return renderBlockingStatus;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    public enum DeliveryType {
        CACHE("cache"),
        NAVIGATIONAL_PREFETCH("navigational-prefetch"),
        OTHER(PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER);

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        DeliveryType(String str) {
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

            public final DeliveryType fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (DeliveryType deliveryType : DeliveryType.values()) {
                    if (Intrinsics.areEqual(deliveryType.jsonValue, jsonString)) {
                        return deliveryType;
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

    public enum OperationType {
        QUERY(AuthorizationRequest.ResponseMode.QUERY),
        MUTATION("mutation"),
        SUBSCRIPTION("subscription");

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        OperationType(String str) {
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

            public final OperationType fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (OperationType operationType : OperationType.values()) {
                    if (Intrinsics.areEqual(operationType.jsonValue, jsonString)) {
                        return operationType;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }
}
