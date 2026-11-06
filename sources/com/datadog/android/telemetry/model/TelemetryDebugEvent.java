package com.datadog.android.telemetry.model;

import com.datadog.android.core.internal.utils.JsonSerializer;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.google.firebase.messaging.Constants;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
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

/* JADX INFO: loaded from: classes3.dex */
public final class TelemetryDebugEvent {
    public static final Companion Companion = new Companion(null);
    private final Action action;
    private final Application application;
    private final long date;
    private final Dd dd;
    private final Number effectiveSampleRate;
    private final List experimentalFeatures;
    private final String service;
    private final Session session;
    private final Source source;
    private final Telemetry telemetry;
    private final String type;
    private final String version;
    private final View view;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TelemetryDebugEvent)) {
            return false;
        }
        TelemetryDebugEvent telemetryDebugEvent = (TelemetryDebugEvent) obj;
        return Intrinsics.areEqual(this.dd, telemetryDebugEvent.dd) && this.date == telemetryDebugEvent.date && Intrinsics.areEqual(this.service, telemetryDebugEvent.service) && this.source == telemetryDebugEvent.source && Intrinsics.areEqual(this.version, telemetryDebugEvent.version) && Intrinsics.areEqual(this.application, telemetryDebugEvent.application) && Intrinsics.areEqual(this.session, telemetryDebugEvent.session) && Intrinsics.areEqual(this.view, telemetryDebugEvent.view) && Intrinsics.areEqual(this.action, telemetryDebugEvent.action) && Intrinsics.areEqual(this.effectiveSampleRate, telemetryDebugEvent.effectiveSampleRate) && Intrinsics.areEqual(this.experimentalFeatures, telemetryDebugEvent.experimentalFeatures) && Intrinsics.areEqual(this.telemetry, telemetryDebugEvent.telemetry);
    }

    public int hashCode() {
        int iHashCode = ((((((((this.dd.hashCode() * 31) + Long.hashCode(this.date)) * 31) + this.service.hashCode()) * 31) + this.source.hashCode()) * 31) + this.version.hashCode()) * 31;
        Application application = this.application;
        int iHashCode2 = (iHashCode + (application == null ? 0 : application.hashCode())) * 31;
        Session session = this.session;
        int iHashCode3 = (iHashCode2 + (session == null ? 0 : session.hashCode())) * 31;
        View view = this.view;
        int iHashCode4 = (iHashCode3 + (view == null ? 0 : view.hashCode())) * 31;
        Action action = this.action;
        int iHashCode5 = (iHashCode4 + (action == null ? 0 : action.hashCode())) * 31;
        Number number = this.effectiveSampleRate;
        int iHashCode6 = (iHashCode5 + (number == null ? 0 : number.hashCode())) * 31;
        List list = this.experimentalFeatures;
        return ((iHashCode6 + (list != null ? list.hashCode() : 0)) * 31) + this.telemetry.hashCode();
    }

    public String toString() {
        return "TelemetryDebugEvent(dd=" + this.dd + ", date=" + this.date + ", service=" + this.service + ", source=" + this.source + ", version=" + this.version + ", application=" + this.application + ", session=" + this.session + ", view=" + this.view + ", action=" + this.action + ", effectiveSampleRate=" + this.effectiveSampleRate + ", experimentalFeatures=" + this.experimentalFeatures + ", telemetry=" + this.telemetry + ")";
    }

    public TelemetryDebugEvent(Dd dd, long j, String service, Source source, String version, Application application, Session session, View view, Action action, Number number, List list, Telemetry telemetry) {
        Intrinsics.checkNotNullParameter(dd, "dd");
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(telemetry, "telemetry");
        this.dd = dd;
        this.date = j;
        this.service = service;
        this.source = source;
        this.version = version;
        this.application = application;
        this.session = session;
        this.view = view;
        this.action = action;
        this.effectiveSampleRate = number;
        this.experimentalFeatures = list;
        this.telemetry = telemetry;
        this.type = "telemetry";
    }

    public /* synthetic */ TelemetryDebugEvent(Dd dd, long j, String str, Source source, String str2, Application application, Session session, View view, Action action, Number number, List list, Telemetry telemetry, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dd, j, str, source, str2, (i & 32) != 0 ? null : application, (i & 64) != 0 ? null : session, (i & 128) != 0 ? null : view, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : action, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? null : number, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : list, telemetry);
    }

    public final JsonElement toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("_dd", this.dd.toJson());
        jsonObject.addProperty("type", this.type);
        jsonObject.addProperty("date", Long.valueOf(this.date));
        jsonObject.addProperty("service", this.service);
        jsonObject.add(Constants.ScionAnalytics.PARAM_SOURCE, this.source.toJson());
        jsonObject.addProperty(DiagnosticsEntry.VERSION_KEY, this.version);
        Application application = this.application;
        if (application != null) {
            jsonObject.add("application", application.toJson());
        }
        Session session = this.session;
        if (session != null) {
            jsonObject.add("session", session.toJson());
        }
        View view = this.view;
        if (view != null) {
            jsonObject.add("view", view.toJson());
        }
        Action action = this.action;
        if (action != null) {
            jsonObject.add("action", action.toJson());
        }
        Number number = this.effectiveSampleRate;
        if (number != null) {
            jsonObject.addProperty("effective_sample_rate", number);
        }
        List list = this.experimentalFeatures;
        if (list != null) {
            JsonArray jsonArray = new JsonArray(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                jsonArray.add((String) it.next());
            }
            jsonObject.add("experimental_features", jsonArray);
        }
        jsonObject.add("telemetry", this.telemetry.toJson());
        return jsonObject;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TelemetryDebugEvent fromJsonObject(JsonObject jsonObject) {
            ArrayList arrayList;
            JsonArray asJsonArray;
            JsonObject asJsonObject;
            JsonObject asJsonObject2;
            JsonObject asJsonObject3;
            JsonObject asJsonObject4;
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            try {
                JsonObject it = jsonObject.get("_dd").getAsJsonObject();
                Dd.Companion companion = Dd.Companion;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                Dd ddFromJsonObject = companion.fromJsonObject(it);
                String asString = jsonObject.get("type").getAsString();
                long asLong = jsonObject.get("date").getAsLong();
                String service = jsonObject.get("service").getAsString();
                Source.Companion companion2 = Source.Companion;
                String asString2 = jsonObject.get(Constants.ScionAnalytics.PARAM_SOURCE).getAsString();
                Intrinsics.checkNotNullExpressionValue(asString2, "jsonObject.get(\"source\").asString");
                Source sourceFromJson = companion2.fromJson(asString2);
                String version = jsonObject.get(DiagnosticsEntry.VERSION_KEY).getAsString();
                JsonElement jsonElement = jsonObject.get("application");
                Application applicationFromJsonObject = (jsonElement == null || (asJsonObject4 = jsonElement.getAsJsonObject()) == null) ? null : Application.Companion.fromJsonObject(asJsonObject4);
                JsonElement jsonElement2 = jsonObject.get("session");
                Session sessionFromJsonObject = (jsonElement2 == null || (asJsonObject3 = jsonElement2.getAsJsonObject()) == null) ? null : Session.Companion.fromJsonObject(asJsonObject3);
                JsonElement jsonElement3 = jsonObject.get("view");
                View viewFromJsonObject = (jsonElement3 == null || (asJsonObject2 = jsonElement3.getAsJsonObject()) == null) ? null : View.Companion.fromJsonObject(asJsonObject2);
                JsonElement jsonElement4 = jsonObject.get("action");
                Action actionFromJsonObject = (jsonElement4 == null || (asJsonObject = jsonElement4.getAsJsonObject()) == null) ? null : Action.Companion.fromJsonObject(asJsonObject);
                JsonElement jsonElement5 = jsonObject.get("effective_sample_rate");
                Number asNumber = jsonElement5 != null ? jsonElement5.getAsNumber() : null;
                JsonElement jsonElement6 = jsonObject.get("experimental_features");
                if (jsonElement6 == null || (asJsonArray = jsonElement6.getAsJsonArray()) == null) {
                    arrayList = null;
                } else {
                    ArrayList arrayList2 = new ArrayList(asJsonArray.size());
                    for (Iterator it2 = asJsonArray.iterator(); it2.hasNext(); it2 = it2) {
                        arrayList2.add(((JsonElement) it2.next()).getAsString());
                    }
                    arrayList = arrayList2;
                }
                JsonObject it3 = jsonObject.get("telemetry").getAsJsonObject();
                Telemetry.Companion companion3 = Telemetry.Companion;
                Intrinsics.checkNotNullExpressionValue(it3, "it");
                Telemetry telemetryFromJsonObject = companion3.fromJsonObject(it3);
                if (!Intrinsics.areEqual(asString, "telemetry")) {
                    throw new IllegalStateException("Check failed.");
                }
                Intrinsics.checkNotNullExpressionValue(service, "service");
                Intrinsics.checkNotNullExpressionValue(version, "version");
                return new TelemetryDebugEvent(ddFromJsonObject, asLong, service, sourceFromJson, version, applicationFromJsonObject, sessionFromJsonObject, viewFromJsonObject, actionFromJsonObject, asNumber, arrayList, telemetryFromJsonObject);
            } catch (IllegalStateException e) {
                throw new JsonParseException("Unable to parse json into type TelemetryDebugEvent", e);
            } catch (NullPointerException e2) {
                throw new JsonParseException("Unable to parse json into type TelemetryDebugEvent", e2);
            } catch (NumberFormatException e3) {
                throw new JsonParseException("Unable to parse json into type TelemetryDebugEvent", e3);
            }
        }
    }

    public static final class Dd {
        public static final Companion Companion = new Companion(null);
        private final long formatVersion = 2;

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("format_version", Long.valueOf(this.formatVersion));
            return jsonObject;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Dd fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    if (jsonObject.get("format_version").getAsLong() != 2) {
                        throw new IllegalStateException("Check failed.");
                    }
                    return new Dd();
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

    public static final class Application {
        public static final Companion Companion = new Companion(null);
        private final String id;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Application) && Intrinsics.areEqual(this.id, ((Application) obj).id);
        }

        public int hashCode() {
            return this.id.hashCode();
        }

        public String toString() {
            return "Application(id=" + this.id + ")";
        }

        public Application(String id) {
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

            public final Application fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String id = jsonObject.get(DiagnosticsEntry.ID_KEY).getAsString();
                    Intrinsics.checkNotNullExpressionValue(id, "id");
                    return new Application(id);
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

    public static final class Session {
        public static final Companion Companion = new Companion(null);
        private final String id;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Session) && Intrinsics.areEqual(this.id, ((Session) obj).id);
        }

        public int hashCode() {
            return this.id.hashCode();
        }

        public String toString() {
            return "Session(id=" + this.id + ")";
        }

        public Session(String id) {
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

            public final Session fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String id = jsonObject.get(DiagnosticsEntry.ID_KEY).getAsString();
                    Intrinsics.checkNotNullExpressionValue(id, "id");
                    return new Session(id);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Session", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Session", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Session", e3);
                }
            }
        }
    }

    public static final class View {
        public static final Companion Companion = new Companion(null);
        private final String id;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof View) && Intrinsics.areEqual(this.id, ((View) obj).id);
        }

        public int hashCode() {
            return this.id.hashCode();
        }

        public String toString() {
            return "View(id=" + this.id + ")";
        }

        public View(String id) {
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

            public final View fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String id = jsonObject.get(DiagnosticsEntry.ID_KEY).getAsString();
                    Intrinsics.checkNotNullExpressionValue(id, "id");
                    return new View(id);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type View", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type View", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type View", e3);
                }
            }
        }
    }

    public static final class Action {
        public static final Companion Companion = new Companion(null);
        private final String id;

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

        public Action(String id) {
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

            public final Action fromJsonObject(JsonObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String id = jsonObject.get(DiagnosticsEntry.ID_KEY).getAsString();
                    Intrinsics.checkNotNullExpressionValue(id, "id");
                    return new Action(id);
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

    public static final class Telemetry {
        public static final Companion Companion = new Companion(null);
        private static final String[] RESERVED_PROPERTIES = {"device", "os", "type", "status", "message"};
        private final Map additionalProperties;
        private final Device device;
        private final String message;
        private final Os os;
        private final String status;
        private final String type;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Telemetry)) {
                return false;
            }
            Telemetry telemetry = (Telemetry) obj;
            return Intrinsics.areEqual(this.device, telemetry.device) && Intrinsics.areEqual(this.os, telemetry.os) && Intrinsics.areEqual(this.message, telemetry.message) && Intrinsics.areEqual(this.additionalProperties, telemetry.additionalProperties);
        }

        public int hashCode() {
            Device device = this.device;
            int iHashCode = (device == null ? 0 : device.hashCode()) * 31;
            Os os = this.os;
            return ((((iHashCode + (os != null ? os.hashCode() : 0)) * 31) + this.message.hashCode()) * 31) + this.additionalProperties.hashCode();
        }

        public String toString() {
            return "Telemetry(device=" + this.device + ", os=" + this.os + ", message=" + this.message + ", additionalProperties=" + this.additionalProperties + ")";
        }

        public Telemetry(Device device, Os os, String message, Map additionalProperties) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            this.device = device;
            this.os = os;
            this.message = message;
            this.additionalProperties = additionalProperties;
            this.type = "log";
            this.status = "debug";
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            Device device = this.device;
            if (device != null) {
                jsonObject.add("device", device.toJson());
            }
            Os os = this.os;
            if (os != null) {
                jsonObject.add("os", os.toJson());
            }
            jsonObject.addProperty("type", this.type);
            jsonObject.addProperty("status", this.status);
            jsonObject.addProperty("message", this.message);
            for (Map.Entry entry : this.additionalProperties.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                if (!ArraysKt.contains(RESERVED_PROPERTIES, str)) {
                    jsonObject.add(str, JsonSerializer.INSTANCE.toJsonElement(value));
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
                return Telemetry.RESERVED_PROPERTIES;
            }

            public final Telemetry fromJsonObject(JsonObject jsonObject) {
                JsonObject asJsonObject;
                JsonObject asJsonObject2;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get("device");
                    Device deviceFromJsonObject = (jsonElement == null || (asJsonObject2 = jsonElement.getAsJsonObject()) == null) ? null : Device.Companion.fromJsonObject(asJsonObject2);
                    JsonElement jsonElement2 = jsonObject.get("os");
                    Os osFromJsonObject = (jsonElement2 == null || (asJsonObject = jsonElement2.getAsJsonObject()) == null) ? null : Os.Companion.fromJsonObject(asJsonObject);
                    JsonElement jsonElement3 = jsonObject.get("type");
                    String asString = jsonElement3 != null ? jsonElement3.getAsString() : null;
                    String asString2 = jsonObject.get("status").getAsString();
                    String message = jsonObject.get("message").getAsString();
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry entry : jsonObject.entrySet()) {
                        if (!ArraysKt.contains(getRESERVED_PROPERTIES$dd_sdk_android_rum_release(), entry.getKey())) {
                            Object key = entry.getKey();
                            Intrinsics.checkNotNullExpressionValue(key, "entry.key");
                            linkedHashMap.put(key, entry.getValue());
                        }
                    }
                    if (asString != null && !Intrinsics.areEqual(asString, "log")) {
                        throw new IllegalStateException("Check failed.");
                    }
                    if (!Intrinsics.areEqual(asString2, "debug")) {
                        throw new IllegalStateException("Check failed.");
                    }
                    Intrinsics.checkNotNullExpressionValue(message, "message");
                    return new Telemetry(deviceFromJsonObject, osFromJsonObject, message, linkedHashMap);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Telemetry", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Telemetry", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Telemetry", e3);
                }
            }
        }
    }

    public static final class Device {
        public static final Companion Companion = new Companion(null);
        private final String architecture;
        private final String brand;
        private final String model;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Device)) {
                return false;
            }
            Device device = (Device) obj;
            return Intrinsics.areEqual(this.architecture, device.architecture) && Intrinsics.areEqual(this.brand, device.brand) && Intrinsics.areEqual(this.model, device.model);
        }

        public int hashCode() {
            String str = this.architecture;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.brand;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.model;
            return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "Device(architecture=" + this.architecture + ", brand=" + this.brand + ", model=" + this.model + ")";
        }

        public Device(String str, String str2, String str3) {
            this.architecture = str;
            this.brand = str2;
            this.model = str3;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            String str = this.architecture;
            if (str != null) {
                jsonObject.addProperty("architecture", str);
            }
            String str2 = this.brand;
            if (str2 != null) {
                jsonObject.addProperty("brand", str2);
            }
            String str3 = this.model;
            if (str3 != null) {
                jsonObject.addProperty("model", str3);
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
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get("architecture");
                    String asString = jsonElement != null ? jsonElement.getAsString() : null;
                    JsonElement jsonElement2 = jsonObject.get("brand");
                    String asString2 = jsonElement2 != null ? jsonElement2.getAsString() : null;
                    JsonElement jsonElement3 = jsonObject.get("model");
                    return new Device(asString, asString2, jsonElement3 != null ? jsonElement3.getAsString() : null);
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

    public static final class Os {
        public static final Companion Companion = new Companion(null);
        private final String build;
        private final String name;
        private final String version;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Os)) {
                return false;
            }
            Os os = (Os) obj;
            return Intrinsics.areEqual(this.build, os.build) && Intrinsics.areEqual(this.name, os.name) && Intrinsics.areEqual(this.version, os.version);
        }

        public int hashCode() {
            String str = this.build;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.name;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.version;
            return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "Os(build=" + this.build + ", name=" + this.name + ", version=" + this.version + ")";
        }

        public Os(String str, String str2, String str3) {
            this.build = str;
            this.name = str2;
            this.version = str3;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            String str = this.build;
            if (str != null) {
                jsonObject.addProperty("build", str);
            }
            String str2 = this.name;
            if (str2 != null) {
                jsonObject.addProperty("name", str2);
            }
            String str3 = this.version;
            if (str3 != null) {
                jsonObject.addProperty(DiagnosticsEntry.VERSION_KEY, str3);
            }
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
                    JsonElement jsonElement = jsonObject.get("build");
                    String asString = jsonElement != null ? jsonElement.getAsString() : null;
                    JsonElement jsonElement2 = jsonObject.get("name");
                    String asString2 = jsonElement2 != null ? jsonElement2.getAsString() : null;
                    JsonElement jsonElement3 = jsonObject.get(DiagnosticsEntry.VERSION_KEY);
                    return new Os(asString, asString2, jsonElement3 != null ? jsonElement3.getAsString() : null);
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

    public enum Source {
        ANDROID("android"),
        IOS("ios"),
        BROWSER("browser"),
        FLUTTER("flutter"),
        REACT_NATIVE(RNPurchasesModule.PLATFORM_NAME),
        UNITY("unity"),
        KOTLIN_MULTIPLATFORM("kotlin-multiplatform");

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        Source(String str) {
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

            public final Source fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (Source source : Source.values()) {
                    if (Intrinsics.areEqual(source.jsonValue, jsonString)) {
                        return source;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }
}
