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
public final class LongTaskEvent {
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
    private final LongTask longTask;
    private final Os os;
    private final String service;
    private final LongTaskEventSession session;
    private final LongTaskEventSource source;
    private final Synthetics synthetics;
    private final String type;
    private final Usr usr;
    private final String version;
    private final LongTaskEventView view;

    public static /* synthetic */ LongTaskEvent copy$default(LongTaskEvent longTaskEvent, long j, Application application, String str, String str2, String str3, String str4, String str5, LongTaskEventSession longTaskEventSession, LongTaskEventSource longTaskEventSource, LongTaskEventView longTaskEventView, Usr usr, Account account, Connectivity connectivity, Display display, Synthetics synthetics, CiTest ciTest, Os os, Device device, Dd dd, Context context, Action action, Container container, LongTask longTask, int i, Object obj) {
        LongTask longTask2;
        Container container2;
        long j2 = (i & 1) != 0 ? longTaskEvent.date : j;
        Application application2 = (i & 2) != 0 ? longTaskEvent.application : application;
        String str6 = (i & 4) != 0 ? longTaskEvent.service : str;
        String str7 = (i & 8) != 0 ? longTaskEvent.version : str2;
        String str8 = (i & 16) != 0 ? longTaskEvent.buildVersion : str3;
        String str9 = (i & 32) != 0 ? longTaskEvent.buildId : str4;
        String str10 = (i & 64) != 0 ? longTaskEvent.ddtags : str5;
        LongTaskEventSession longTaskEventSession2 = (i & 128) != 0 ? longTaskEvent.session : longTaskEventSession;
        LongTaskEventSource longTaskEventSource2 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? longTaskEvent.source : longTaskEventSource;
        LongTaskEventView longTaskEventView2 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? longTaskEvent.view : longTaskEventView;
        Usr usr2 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? longTaskEvent.usr : usr;
        Account account2 = (i & 2048) != 0 ? longTaskEvent.account : account;
        Connectivity connectivity2 = (i & 4096) != 0 ? longTaskEvent.connectivity : connectivity;
        long j3 = j2;
        Display display2 = (i & 8192) != 0 ? longTaskEvent.display : display;
        Synthetics synthetics2 = (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? longTaskEvent.synthetics : synthetics;
        CiTest ciTest2 = (i & 32768) != 0 ? longTaskEvent.ciTest : ciTest;
        Os os2 = (i & 65536) != 0 ? longTaskEvent.os : os;
        Device device2 = (i & 131072) != 0 ? longTaskEvent.device : device;
        Dd dd2 = (i & 262144) != 0 ? longTaskEvent.dd : dd;
        Context context2 = (i & 524288) != 0 ? longTaskEvent.context : context;
        Action action2 = (i & 1048576) != 0 ? longTaskEvent.action : action;
        Container container3 = (i & 2097152) != 0 ? longTaskEvent.container : container;
        if ((i & 4194304) != 0) {
            container2 = container3;
            longTask2 = longTaskEvent.longTask;
        } else {
            longTask2 = longTask;
            container2 = container3;
        }
        return longTaskEvent.copy(j3, application2, str6, str7, str8, str9, str10, longTaskEventSession2, longTaskEventSource2, longTaskEventView2, usr2, account2, connectivity2, display2, synthetics2, ciTest2, os2, device2, dd2, context2, action2, container2, longTask2);
    }

    public final LongTaskEvent copy(long j, Application application, String str, String str2, String str3, String str4, String str5, LongTaskEventSession session, LongTaskEventSource longTaskEventSource, LongTaskEventView view, Usr usr, Account account, Connectivity connectivity, Display display, Synthetics synthetics, CiTest ciTest, Os os, Device device, Dd dd, Context context, Action action, Container container, LongTask longTask) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dd, "dd");
        Intrinsics.checkNotNullParameter(longTask, "longTask");
        return new LongTaskEvent(j, application, str, str2, str3, str4, str5, session, longTaskEventSource, view, usr, account, connectivity, display, synthetics, ciTest, os, device, dd, context, action, container, longTask);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LongTaskEvent)) {
            return false;
        }
        LongTaskEvent longTaskEvent = (LongTaskEvent) obj;
        return this.date == longTaskEvent.date && Intrinsics.areEqual(this.application, longTaskEvent.application) && Intrinsics.areEqual(this.service, longTaskEvent.service) && Intrinsics.areEqual(this.version, longTaskEvent.version) && Intrinsics.areEqual(this.buildVersion, longTaskEvent.buildVersion) && Intrinsics.areEqual(this.buildId, longTaskEvent.buildId) && Intrinsics.areEqual(this.ddtags, longTaskEvent.ddtags) && Intrinsics.areEqual(this.session, longTaskEvent.session) && this.source == longTaskEvent.source && Intrinsics.areEqual(this.view, longTaskEvent.view) && Intrinsics.areEqual(this.usr, longTaskEvent.usr) && Intrinsics.areEqual(this.account, longTaskEvent.account) && Intrinsics.areEqual(this.connectivity, longTaskEvent.connectivity) && Intrinsics.areEqual(this.display, longTaskEvent.display) && Intrinsics.areEqual(this.synthetics, longTaskEvent.synthetics) && Intrinsics.areEqual(this.ciTest, longTaskEvent.ciTest) && Intrinsics.areEqual(this.os, longTaskEvent.os) && Intrinsics.areEqual(this.device, longTaskEvent.device) && Intrinsics.areEqual(this.dd, longTaskEvent.dd) && Intrinsics.areEqual(this.context, longTaskEvent.context) && Intrinsics.areEqual(this.action, longTaskEvent.action) && Intrinsics.areEqual(this.container, longTaskEvent.container) && Intrinsics.areEqual(this.longTask, longTaskEvent.longTask);
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
        LongTaskEventSource longTaskEventSource = this.source;
        int iHashCode7 = (((iHashCode6 + (longTaskEventSource == null ? 0 : longTaskEventSource.hashCode())) * 31) + this.view.hashCode()) * 31;
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
        return ((iHashCode17 + (container != null ? container.hashCode() : 0)) * 31) + this.longTask.hashCode();
    }

    public String toString() {
        return "LongTaskEvent(date=" + this.date + ", application=" + this.application + ", service=" + this.service + ", version=" + this.version + ", buildVersion=" + this.buildVersion + ", buildId=" + this.buildId + ", ddtags=" + this.ddtags + ", session=" + this.session + ", source=" + this.source + ", view=" + this.view + ", usr=" + this.usr + ", account=" + this.account + ", connectivity=" + this.connectivity + ", display=" + this.display + ", synthetics=" + this.synthetics + ", ciTest=" + this.ciTest + ", os=" + this.os + ", device=" + this.device + ", dd=" + this.dd + ", context=" + this.context + ", action=" + this.action + ", container=" + this.container + ", longTask=" + this.longTask + ")";
    }

    public LongTaskEvent(long j, Application application, String str, String str2, String str3, String str4, String str5, LongTaskEventSession session, LongTaskEventSource longTaskEventSource, LongTaskEventView view, Usr usr, Account account, Connectivity connectivity, Display display, Synthetics synthetics, CiTest ciTest, Os os, Device device, Dd dd, Context context, Action action, Container container, LongTask longTask) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dd, "dd");
        Intrinsics.checkNotNullParameter(longTask, "longTask");
        this.date = j;
        this.application = application;
        this.service = str;
        this.version = str2;
        this.buildVersion = str3;
        this.buildId = str4;
        this.ddtags = str5;
        this.session = session;
        this.source = longTaskEventSource;
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
        this.longTask = longTask;
        this.type = "long_task";
    }

    public /* synthetic */ LongTaskEvent(long j, Application application, String str, String str2, String str3, String str4, String str5, LongTaskEventSession longTaskEventSession, LongTaskEventSource longTaskEventSource, LongTaskEventView longTaskEventView, Usr usr, Account account, Connectivity connectivity, Display display, Synthetics synthetics, CiTest ciTest, Os os, Device device, Dd dd, Context context, Action action, Container container, LongTask longTask, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, application, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, longTaskEventSession, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : longTaskEventSource, longTaskEventView, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : usr, (i & 2048) != 0 ? null : account, (i & 4096) != 0 ? null : connectivity, (i & 8192) != 0 ? null : display, (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? null : synthetics, (32768 & i) != 0 ? null : ciTest, (65536 & i) != 0 ? null : os, (131072 & i) != 0 ? null : device, dd, (524288 & i) != 0 ? null : context, (1048576 & i) != 0 ? null : action, (i & 2097152) != 0 ? null : container, longTask);
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
        LongTaskEventSource longTaskEventSource = this.source;
        if (longTaskEventSource != null) {
            jsonObject.add(Constants.ScionAnalytics.PARAM_SOURCE, longTaskEventSource.toJson());
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
        jsonObject.add("long_task", this.longTask.toJson());
        return jsonObject;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LongTaskEvent fromJsonObject(JsonObject jsonObject) {
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
                LongTaskEventSession.Companion companion2 = LongTaskEventSession.Companion;
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                LongTaskEventSession longTaskEventSessionFromJsonObject = companion2.fromJsonObject(it2);
                JsonElement jsonElement6 = jsonObject.get(Constants.ScionAnalytics.PARAM_SOURCE);
                LongTaskEventSource longTaskEventSourceFromJson = (jsonElement6 == null || (asString = jsonElement6.getAsString()) == null) ? null : LongTaskEventSource.Companion.fromJson(asString);
                JsonObject it3 = jsonObject.get("view").getAsJsonObject();
                LongTaskEventView.Companion companion3 = LongTaskEventView.Companion;
                Intrinsics.checkNotNullExpressionValue(it3, "it");
                LongTaskEventView longTaskEventViewFromJsonObject = companion3.fromJsonObject(it3);
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
                JsonObject it5 = jsonObject.get("long_task").getAsJsonObject();
                Container container = containerFromJsonObject;
                LongTask.Companion companion5 = LongTask.Companion;
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                LongTask longTaskFromJsonObject = companion5.fromJsonObject(it5);
                if (!Intrinsics.areEqual(asString7, "long_task")) {
                    throw new IllegalStateException("Check failed.");
                }
                return new LongTaskEvent(asLong, applicationFromJsonObject, asString2, asString3, asString4, asString5, asString6, longTaskEventSessionFromJsonObject, longTaskEventSourceFromJson, longTaskEventViewFromJsonObject, usrFromJsonObject, accountFromJsonObject, connectivityFromJsonObject, displayFromJsonObject, syntheticsFromJsonObject, ciTestFromJsonObject, osFromJsonObject, device, ddFromJsonObject, contextFromJsonObject, actionFromJsonObject, container, longTaskFromJsonObject);
            } catch (IllegalStateException e) {
                throw new JsonParseException("Unable to parse json into type LongTaskEvent", e);
            } catch (NullPointerException e2) {
                throw new JsonParseException("Unable to parse json into type LongTaskEvent", e2);
            } catch (NumberFormatException e3) {
                throw new JsonParseException("Unable to parse json into type LongTaskEvent", e3);
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

    public static final class LongTaskEventSession {
        public static final Companion Companion = new Companion(null);
        private final Boolean hasReplay;
        private final String id;
        private final LongTaskEventSessionType type;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LongTaskEventSession)) {
                return false;
            }
            LongTaskEventSession longTaskEventSession = (LongTaskEventSession) obj;
            return Intrinsics.areEqual(this.id, longTaskEventSession.id) && this.type == longTaskEventSession.type && Intrinsics.areEqual(this.hasReplay, longTaskEventSession.hasReplay);
        }

        public int hashCode() {
            int iHashCode = ((this.id.hashCode() * 31) + this.type.hashCode()) * 31;
            Boolean bool = this.hasReplay;
            return iHashCode + (bool == null ? 0 : bool.hashCode());
        }

        public String toString() {
            return "LongTaskEventSession(id=" + this.id + ", type=" + this.type + ", hasReplay=" + this.hasReplay + ")";
        }

        public LongTaskEventSession(String id, LongTaskEventSessionType type, Boolean bool) {
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

            public final LongTaskEventSession fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String id = jsonObject.get(DiagnosticsEntry.ID_KEY).getAsString();
                    LongTaskEventSessionType.Companion companion = LongTaskEventSessionType.Companion;
                    String asString = jsonObject.get("type").getAsString();
                    Intrinsics.checkNotNullExpressionValue(asString, "jsonObject.get(\"type\").asString");
                    LongTaskEventSessionType longTaskEventSessionTypeFromJson = companion.fromJson(asString);
                    JsonElement jsonElement = jsonObject.get("has_replay");
                    Boolean boolValueOf = jsonElement != null ? Boolean.valueOf(jsonElement.getAsBoolean()) : null;
                    Intrinsics.checkNotNullExpressionValue(id, "id");
                    return new LongTaskEventSession(id, longTaskEventSessionTypeFromJson, boolValueOf);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type LongTaskEventSession", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type LongTaskEventSession", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type LongTaskEventSession", e3);
                }
            }
        }
    }

    public static final class LongTaskEventView {
        public static final Companion Companion = new Companion(null);
        private final String id;
        private String name;
        private String referrer;
        private String url;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LongTaskEventView)) {
                return false;
            }
            LongTaskEventView longTaskEventView = (LongTaskEventView) obj;
            return Intrinsics.areEqual(this.id, longTaskEventView.id) && Intrinsics.areEqual(this.referrer, longTaskEventView.referrer) && Intrinsics.areEqual(this.url, longTaskEventView.url) && Intrinsics.areEqual(this.name, longTaskEventView.name);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.referrer;
            int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.url.hashCode()) * 31;
            String str2 = this.name;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "LongTaskEventView(id=" + this.id + ", referrer=" + this.referrer + ", url=" + this.url + ", name=" + this.name + ")";
        }

        public LongTaskEventView(String id, String str, String url, String str2) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(url, "url");
            this.id = id;
            this.referrer = str;
            this.url = url;
            this.name = str2;
        }

        public /* synthetic */ LongTaskEventView(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
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

            public final LongTaskEventView fromJsonObject(JsonObject jsonObject) {
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
                    return new LongTaskEventView(id, asString, url, asString2);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type LongTaskEventView", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type LongTaskEventView", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type LongTaskEventView", e3);
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
        private final Profiling profiling;
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
            return Intrinsics.areEqual(this.session, dd.session) && Intrinsics.areEqual(this.configuration, dd.configuration) && Intrinsics.areEqual(this.browserSdkVersion, dd.browserSdkVersion) && Intrinsics.areEqual(this.sdkName, dd.sdkName) && Intrinsics.areEqual(this.discarded, dd.discarded) && Intrinsics.areEqual(this.profiling, dd.profiling);
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
            Boolean bool = this.discarded;
            int iHashCode5 = (iHashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
            Profiling profiling = this.profiling;
            return iHashCode5 + (profiling != null ? profiling.hashCode() : 0);
        }

        public String toString() {
            return "Dd(session=" + this.session + ", configuration=" + this.configuration + ", browserSdkVersion=" + this.browserSdkVersion + ", sdkName=" + this.sdkName + ", discarded=" + this.discarded + ", profiling=" + this.profiling + ")";
        }

        public Dd(DdSession ddSession, Configuration configuration, String str, String str2, Boolean bool, Profiling profiling) {
            this.session = ddSession;
            this.configuration = configuration;
            this.browserSdkVersion = str;
            this.sdkName = str2;
            this.discarded = bool;
            this.profiling = profiling;
            this.formatVersion = 2L;
        }

        public /* synthetic */ Dd(DdSession ddSession, Configuration configuration, String str, String str2, Boolean bool, Profiling profiling, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : ddSession, (i & 2) != 0 ? null : configuration, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : profiling);
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
            Boolean bool = this.discarded;
            if (bool != null) {
                jsonObject.addProperty("discarded", bool);
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
                JsonObject asJsonObject;
                JsonObject asJsonObject2;
                JsonObject asJsonObject3;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    long asLong = jsonObject.get("format_version").getAsLong();
                    JsonElement jsonElement = jsonObject.get("session");
                    Profiling profilingFromJsonObject = null;
                    DdSession ddSessionFromJsonObject = (jsonElement == null || (asJsonObject3 = jsonElement.getAsJsonObject()) == null) ? null : DdSession.Companion.fromJsonObject(asJsonObject3);
                    JsonElement jsonElement2 = jsonObject.get("configuration");
                    Configuration configurationFromJsonObject = (jsonElement2 == null || (asJsonObject2 = jsonElement2.getAsJsonObject()) == null) ? null : Configuration.Companion.fromJsonObject(asJsonObject2);
                    JsonElement jsonElement3 = jsonObject.get("browser_sdk_version");
                    String asString = jsonElement3 != null ? jsonElement3.getAsString() : null;
                    JsonElement jsonElement4 = jsonObject.get("sdk_name");
                    String asString2 = jsonElement4 != null ? jsonElement4.getAsString() : null;
                    JsonElement jsonElement5 = jsonObject.get("discarded");
                    Boolean boolValueOf = jsonElement5 != null ? Boolean.valueOf(jsonElement5.getAsBoolean()) : null;
                    JsonElement jsonElement6 = jsonObject.get("profiling");
                    if (jsonElement6 != null && (asJsonObject = jsonElement6.getAsJsonObject()) != null) {
                        profilingFromJsonObject = Profiling.Companion.fromJsonObject(asJsonObject);
                    }
                    if (asLong != 2) {
                        throw new IllegalStateException("Check failed.");
                    }
                    return new Dd(ddSessionFromJsonObject, configurationFromJsonObject, asString, asString2, boolValueOf, profilingFromJsonObject);
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
        private final LongTaskEventSource source;
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

        public Container(ContainerView view, LongTaskEventSource source) {
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
                    LongTaskEventSource.Companion companion2 = LongTaskEventSource.Companion;
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

    public static final class LongTask {
        public static final Companion Companion = new Companion(null);
        private final Long blockingDuration;
        private final long duration;
        private final EntryType entryType;
        private final Number firstUiEventTimestamp;
        private final String id;
        private final Boolean isFrozenFrame;
        private final Number renderStart;
        private final List scripts;
        private final Number startTime;
        private final Number styleAndLayoutStart;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LongTask)) {
                return false;
            }
            LongTask longTask = (LongTask) obj;
            return Intrinsics.areEqual(this.id, longTask.id) && Intrinsics.areEqual(this.startTime, longTask.startTime) && this.entryType == longTask.entryType && this.duration == longTask.duration && Intrinsics.areEqual(this.blockingDuration, longTask.blockingDuration) && Intrinsics.areEqual(this.renderStart, longTask.renderStart) && Intrinsics.areEqual(this.styleAndLayoutStart, longTask.styleAndLayoutStart) && Intrinsics.areEqual(this.firstUiEventTimestamp, longTask.firstUiEventTimestamp) && Intrinsics.areEqual(this.isFrozenFrame, longTask.isFrozenFrame) && Intrinsics.areEqual(this.scripts, longTask.scripts);
        }

        public int hashCode() {
            String str = this.id;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            Number number = this.startTime;
            int iHashCode2 = (iHashCode + (number == null ? 0 : number.hashCode())) * 31;
            EntryType entryType = this.entryType;
            int iHashCode3 = (((iHashCode2 + (entryType == null ? 0 : entryType.hashCode())) * 31) + Long.hashCode(this.duration)) * 31;
            Long l = this.blockingDuration;
            int iHashCode4 = (iHashCode3 + (l == null ? 0 : l.hashCode())) * 31;
            Number number2 = this.renderStart;
            int iHashCode5 = (iHashCode4 + (number2 == null ? 0 : number2.hashCode())) * 31;
            Number number3 = this.styleAndLayoutStart;
            int iHashCode6 = (iHashCode5 + (number3 == null ? 0 : number3.hashCode())) * 31;
            Number number4 = this.firstUiEventTimestamp;
            int iHashCode7 = (iHashCode6 + (number4 == null ? 0 : number4.hashCode())) * 31;
            Boolean bool = this.isFrozenFrame;
            int iHashCode8 = (iHashCode7 + (bool == null ? 0 : bool.hashCode())) * 31;
            List list = this.scripts;
            return iHashCode8 + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            return "LongTask(id=" + this.id + ", startTime=" + this.startTime + ", entryType=" + this.entryType + ", duration=" + this.duration + ", blockingDuration=" + this.blockingDuration + ", renderStart=" + this.renderStart + ", styleAndLayoutStart=" + this.styleAndLayoutStart + ", firstUiEventTimestamp=" + this.firstUiEventTimestamp + ", isFrozenFrame=" + this.isFrozenFrame + ", scripts=" + this.scripts + ")";
        }

        public LongTask(String str, Number number, EntryType entryType, long j, Long l, Number number2, Number number3, Number number4, Boolean bool, List list) {
            this.id = str;
            this.startTime = number;
            this.entryType = entryType;
            this.duration = j;
            this.blockingDuration = l;
            this.renderStart = number2;
            this.styleAndLayoutStart = number3;
            this.firstUiEventTimestamp = number4;
            this.isFrozenFrame = bool;
            this.scripts = list;
        }

        public /* synthetic */ LongTask(String str, Number number, EntryType entryType, long j, Long l, Number number2, Number number3, Number number4, Boolean bool, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : number, (i & 4) != 0 ? null : entryType, j, (i & 16) != 0 ? null : l, (i & 32) != 0 ? null : number2, (i & 64) != 0 ? null : number3, (i & 128) != 0 ? null : number4, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : bool, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? null : list);
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            String str = this.id;
            if (str != null) {
                jsonObject.addProperty(DiagnosticsEntry.ID_KEY, str);
            }
            Number number = this.startTime;
            if (number != null) {
                jsonObject.addProperty("start_time", number);
            }
            EntryType entryType = this.entryType;
            if (entryType != null) {
                jsonObject.add("entry_type", entryType.toJson());
            }
            jsonObject.addProperty("duration", Long.valueOf(this.duration));
            Long l = this.blockingDuration;
            if (l != null) {
                jsonObject.addProperty("blocking_duration", Long.valueOf(l.longValue()));
            }
            Number number2 = this.renderStart;
            if (number2 != null) {
                jsonObject.addProperty("render_start", number2);
            }
            Number number3 = this.styleAndLayoutStart;
            if (number3 != null) {
                jsonObject.addProperty("style_and_layout_start", number3);
            }
            Number number4 = this.firstUiEventTimestamp;
            if (number4 != null) {
                jsonObject.addProperty("first_ui_event_timestamp", number4);
            }
            Boolean bool = this.isFrozenFrame;
            if (bool != null) {
                jsonObject.addProperty("is_frozen_frame", bool);
            }
            List list = this.scripts;
            if (list != null) {
                JsonArray jsonArray = new JsonArray(list.size());
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    jsonArray.add(((Script) it.next()).toJson());
                }
                jsonObject.add("scripts", jsonArray);
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final LongTask fromJsonObject(JsonObject jsonObject) {
                JsonArray<JsonElement> asJsonArray;
                String asString;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get(DiagnosticsEntry.ID_KEY);
                    ArrayList arrayList = null;
                    String asString2 = jsonElement != null ? jsonElement.getAsString() : null;
                    JsonElement jsonElement2 = jsonObject.get("start_time");
                    Number asNumber = jsonElement2 != null ? jsonElement2.getAsNumber() : null;
                    JsonElement jsonElement3 = jsonObject.get("entry_type");
                    EntryType entryTypeFromJson = (jsonElement3 == null || (asString = jsonElement3.getAsString()) == null) ? null : EntryType.Companion.fromJson(asString);
                    long asLong = jsonObject.get("duration").getAsLong();
                    JsonElement jsonElement4 = jsonObject.get("blocking_duration");
                    Long lValueOf = jsonElement4 != null ? Long.valueOf(jsonElement4.getAsLong()) : null;
                    JsonElement jsonElement5 = jsonObject.get("render_start");
                    Number asNumber2 = jsonElement5 != null ? jsonElement5.getAsNumber() : null;
                    JsonElement jsonElement6 = jsonObject.get("style_and_layout_start");
                    Number asNumber3 = jsonElement6 != null ? jsonElement6.getAsNumber() : null;
                    JsonElement jsonElement7 = jsonObject.get("first_ui_event_timestamp");
                    Number asNumber4 = jsonElement7 != null ? jsonElement7.getAsNumber() : null;
                    JsonElement jsonElement8 = jsonObject.get("is_frozen_frame");
                    Boolean boolValueOf = jsonElement8 != null ? Boolean.valueOf(jsonElement8.getAsBoolean()) : null;
                    JsonElement jsonElement9 = jsonObject.get("scripts");
                    if (jsonElement9 != null && (asJsonArray = jsonElement9.getAsJsonArray()) != null) {
                        arrayList = new ArrayList(asJsonArray.size());
                        for (JsonElement jsonElement10 : asJsonArray) {
                            Script.Companion companion = Script.Companion;
                            JsonObject asJsonObject = jsonElement10.getAsJsonObject();
                            Intrinsics.checkNotNullExpressionValue(asJsonObject, "it.asJsonObject");
                            arrayList.add(companion.fromJsonObject(asJsonObject));
                        }
                    }
                    return new LongTask(asString2, asNumber, entryTypeFromJson, asLong, lValueOf, asNumber2, asNumber3, asNumber4, boolValueOf, arrayList);
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

    public static final class Script {
        public static final Companion Companion = new Companion(null);
        private final Long duration;
        private final Number executionStart;
        private final Long forcedStyleAndLayoutDuration;
        private final String invoker;
        private final InvokerType invokerType;
        private final Long pauseDuration;
        private final Long sourceCharPosition;
        private final String sourceFunctionName;
        private final String sourceUrl;
        private final Number startTime;
        private final String windowAttribution;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Script)) {
                return false;
            }
            Script script = (Script) obj;
            return Intrinsics.areEqual(this.duration, script.duration) && Intrinsics.areEqual(this.pauseDuration, script.pauseDuration) && Intrinsics.areEqual(this.forcedStyleAndLayoutDuration, script.forcedStyleAndLayoutDuration) && Intrinsics.areEqual(this.startTime, script.startTime) && Intrinsics.areEqual(this.executionStart, script.executionStart) && Intrinsics.areEqual(this.sourceUrl, script.sourceUrl) && Intrinsics.areEqual(this.sourceFunctionName, script.sourceFunctionName) && Intrinsics.areEqual(this.sourceCharPosition, script.sourceCharPosition) && Intrinsics.areEqual(this.invoker, script.invoker) && this.invokerType == script.invokerType && Intrinsics.areEqual(this.windowAttribution, script.windowAttribution);
        }

        public int hashCode() {
            Long l = this.duration;
            int iHashCode = (l == null ? 0 : l.hashCode()) * 31;
            Long l2 = this.pauseDuration;
            int iHashCode2 = (iHashCode + (l2 == null ? 0 : l2.hashCode())) * 31;
            Long l3 = this.forcedStyleAndLayoutDuration;
            int iHashCode3 = (iHashCode2 + (l3 == null ? 0 : l3.hashCode())) * 31;
            Number number = this.startTime;
            int iHashCode4 = (iHashCode3 + (number == null ? 0 : number.hashCode())) * 31;
            Number number2 = this.executionStart;
            int iHashCode5 = (iHashCode4 + (number2 == null ? 0 : number2.hashCode())) * 31;
            String str = this.sourceUrl;
            int iHashCode6 = (iHashCode5 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.sourceFunctionName;
            int iHashCode7 = (iHashCode6 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Long l4 = this.sourceCharPosition;
            int iHashCode8 = (iHashCode7 + (l4 == null ? 0 : l4.hashCode())) * 31;
            String str3 = this.invoker;
            int iHashCode9 = (iHashCode8 + (str3 == null ? 0 : str3.hashCode())) * 31;
            InvokerType invokerType = this.invokerType;
            int iHashCode10 = (iHashCode9 + (invokerType == null ? 0 : invokerType.hashCode())) * 31;
            String str4 = this.windowAttribution;
            return iHashCode10 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            return "Script(duration=" + this.duration + ", pauseDuration=" + this.pauseDuration + ", forcedStyleAndLayoutDuration=" + this.forcedStyleAndLayoutDuration + ", startTime=" + this.startTime + ", executionStart=" + this.executionStart + ", sourceUrl=" + this.sourceUrl + ", sourceFunctionName=" + this.sourceFunctionName + ", sourceCharPosition=" + this.sourceCharPosition + ", invoker=" + this.invoker + ", invokerType=" + this.invokerType + ", windowAttribution=" + this.windowAttribution + ")";
        }

        public Script(Long l, Long l2, Long l3, Number number, Number number2, String str, String str2, Long l4, String str3, InvokerType invokerType, String str4) {
            this.duration = l;
            this.pauseDuration = l2;
            this.forcedStyleAndLayoutDuration = l3;
            this.startTime = number;
            this.executionStart = number2;
            this.sourceUrl = str;
            this.sourceFunctionName = str2;
            this.sourceCharPosition = l4;
            this.invoker = str3;
            this.invokerType = invokerType;
            this.windowAttribution = str4;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            Long l = this.duration;
            if (l != null) {
                jsonObject.addProperty("duration", Long.valueOf(l.longValue()));
            }
            Long l2 = this.pauseDuration;
            if (l2 != null) {
                jsonObject.addProperty("pause_duration", Long.valueOf(l2.longValue()));
            }
            Long l3 = this.forcedStyleAndLayoutDuration;
            if (l3 != null) {
                jsonObject.addProperty("forced_style_and_layout_duration", Long.valueOf(l3.longValue()));
            }
            Number number = this.startTime;
            if (number != null) {
                jsonObject.addProperty("start_time", number);
            }
            Number number2 = this.executionStart;
            if (number2 != null) {
                jsonObject.addProperty("execution_start", number2);
            }
            String str = this.sourceUrl;
            if (str != null) {
                jsonObject.addProperty("source_url", str);
            }
            String str2 = this.sourceFunctionName;
            if (str2 != null) {
                jsonObject.addProperty("source_function_name", str2);
            }
            Long l4 = this.sourceCharPosition;
            if (l4 != null) {
                jsonObject.addProperty("source_char_position", Long.valueOf(l4.longValue()));
            }
            String str3 = this.invoker;
            if (str3 != null) {
                jsonObject.addProperty("invoker", str3);
            }
            InvokerType invokerType = this.invokerType;
            if (invokerType != null) {
                jsonObject.add("invoker_type", invokerType.toJson());
            }
            String str4 = this.windowAttribution;
            if (str4 != null) {
                jsonObject.addProperty("window_attribution", str4);
            }
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Script fromJsonObject(JsonObject jsonObject) {
                String asString;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get("duration");
                    Long lValueOf = jsonElement != null ? Long.valueOf(jsonElement.getAsLong()) : null;
                    JsonElement jsonElement2 = jsonObject.get("pause_duration");
                    Long lValueOf2 = jsonElement2 != null ? Long.valueOf(jsonElement2.getAsLong()) : null;
                    JsonElement jsonElement3 = jsonObject.get("forced_style_and_layout_duration");
                    Long lValueOf3 = jsonElement3 != null ? Long.valueOf(jsonElement3.getAsLong()) : null;
                    JsonElement jsonElement4 = jsonObject.get("start_time");
                    Number asNumber = jsonElement4 != null ? jsonElement4.getAsNumber() : null;
                    JsonElement jsonElement5 = jsonObject.get("execution_start");
                    Number asNumber2 = jsonElement5 != null ? jsonElement5.getAsNumber() : null;
                    JsonElement jsonElement6 = jsonObject.get("source_url");
                    String asString2 = jsonElement6 != null ? jsonElement6.getAsString() : null;
                    JsonElement jsonElement7 = jsonObject.get("source_function_name");
                    String asString3 = jsonElement7 != null ? jsonElement7.getAsString() : null;
                    JsonElement jsonElement8 = jsonObject.get("source_char_position");
                    Long lValueOf4 = jsonElement8 != null ? Long.valueOf(jsonElement8.getAsLong()) : null;
                    JsonElement jsonElement9 = jsonObject.get("invoker");
                    String asString4 = jsonElement9 != null ? jsonElement9.getAsString() : null;
                    JsonElement jsonElement10 = jsonObject.get("invoker_type");
                    InvokerType invokerTypeFromJson = (jsonElement10 == null || (asString = jsonElement10.getAsString()) == null) ? null : InvokerType.Companion.fromJson(asString);
                    JsonElement jsonElement11 = jsonObject.get("window_attribution");
                    return new Script(lValueOf, lValueOf2, lValueOf3, asNumber, asNumber2, asString2, asString3, lValueOf4, asString4, invokerTypeFromJson, jsonElement11 != null ? jsonElement11.getAsString() : null);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Script", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Script", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Script", e3);
                }
            }
        }
    }

    public enum LongTaskEventSource {
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

        LongTaskEventSource(String str) {
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

            public final LongTaskEventSource fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (LongTaskEventSource longTaskEventSource : LongTaskEventSource.values()) {
                    if (Intrinsics.areEqual(longTaskEventSource.jsonValue, jsonString)) {
                        return longTaskEventSource;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    public enum LongTaskEventSessionType {
        USER("user"),
        SYNTHETICS("synthetics"),
        CI_TEST("ci_test");

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        LongTaskEventSessionType(String str) {
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

            public final LongTaskEventSessionType fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (LongTaskEventSessionType longTaskEventSessionType : LongTaskEventSessionType.values()) {
                    if (Intrinsics.areEqual(longTaskEventSessionType.jsonValue, jsonString)) {
                        return longTaskEventSessionType;
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
        f412G("2g"),
        f423G("3g"),
        f434G("4g");

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

    public enum EntryType {
        LONG_TASK("long-task"),
        LONG_ANIMATION_FRAME("long-animation-frame");

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        EntryType(String str) {
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

            public final EntryType fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (EntryType entryType : EntryType.values()) {
                    if (Intrinsics.areEqual(entryType.jsonValue, jsonString)) {
                        return entryType;
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

    public enum InvokerType {
        USER_CALLBACK("user-callback"),
        EVENT_LISTENER("event-listener"),
        RESOLVE_PROMISE("resolve-promise"),
        REJECT_PROMISE("reject-promise"),
        CLASSIC_SCRIPT("classic-script"),
        MODULE_SCRIPT("module-script");

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        InvokerType(String str) {
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

            public final InvokerType fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (InvokerType invokerType : InvokerType.values()) {
                    if (Intrinsics.areEqual(invokerType.jsonValue, jsonString)) {
                        return invokerType;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }
}
