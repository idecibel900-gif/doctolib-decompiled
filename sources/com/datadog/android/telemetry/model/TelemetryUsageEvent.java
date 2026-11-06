package com.datadog.android.telemetry.model;

import com.datadog.android.core.internal.utils.JsonSerializer;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.google.firebase.messaging.Constants;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.react.RNPurchasesModule;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class TelemetryUsageEvent {
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
        if (!(obj instanceof TelemetryUsageEvent)) {
            return false;
        }
        TelemetryUsageEvent telemetryUsageEvent = (TelemetryUsageEvent) obj;
        return Intrinsics.areEqual(this.dd, telemetryUsageEvent.dd) && this.date == telemetryUsageEvent.date && Intrinsics.areEqual(this.service, telemetryUsageEvent.service) && this.source == telemetryUsageEvent.source && Intrinsics.areEqual(this.version, telemetryUsageEvent.version) && Intrinsics.areEqual(this.application, telemetryUsageEvent.application) && Intrinsics.areEqual(this.session, telemetryUsageEvent.session) && Intrinsics.areEqual(this.view, telemetryUsageEvent.view) && Intrinsics.areEqual(this.action, telemetryUsageEvent.action) && Intrinsics.areEqual(this.effectiveSampleRate, telemetryUsageEvent.effectiveSampleRate) && Intrinsics.areEqual(this.experimentalFeatures, telemetryUsageEvent.experimentalFeatures) && Intrinsics.areEqual(this.telemetry, telemetryUsageEvent.telemetry);
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
        return "TelemetryUsageEvent(dd=" + this.dd + ", date=" + this.date + ", service=" + this.service + ", source=" + this.source + ", version=" + this.version + ", application=" + this.application + ", session=" + this.session + ", view=" + this.view + ", action=" + this.action + ", effectiveSampleRate=" + this.effectiveSampleRate + ", experimentalFeatures=" + this.experimentalFeatures + ", telemetry=" + this.telemetry + ")";
    }

    public TelemetryUsageEvent(Dd dd, long j, String service, Source source, String version, Application application, Session session, View view, Action action, Number number, List list, Telemetry telemetry) {
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

    public /* synthetic */ TelemetryUsageEvent(Dd dd, long j, String str, Source source, String str2, Application application, Session session, View view, Action action, Number number, List list, Telemetry telemetry, int i, DefaultConstructorMarker defaultConstructorMarker) {
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
        }
    }

    public static final class Telemetry {
        public static final Companion Companion = new Companion(null);
        private static final String[] RESERVED_PROPERTIES = {"device", "os", "type", "usage"};
        private final Map additionalProperties;
        private final Device device;
        private final Os os;
        private final String type;
        private final Usage usage;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Telemetry)) {
                return false;
            }
            Telemetry telemetry = (Telemetry) obj;
            return Intrinsics.areEqual(this.device, telemetry.device) && Intrinsics.areEqual(this.os, telemetry.os) && Intrinsics.areEqual(this.usage, telemetry.usage) && Intrinsics.areEqual(this.additionalProperties, telemetry.additionalProperties);
        }

        public int hashCode() {
            Device device = this.device;
            int iHashCode = (device == null ? 0 : device.hashCode()) * 31;
            Os os = this.os;
            return ((((iHashCode + (os != null ? os.hashCode() : 0)) * 31) + this.usage.hashCode()) * 31) + this.additionalProperties.hashCode();
        }

        public String toString() {
            return "Telemetry(device=" + this.device + ", os=" + this.os + ", usage=" + this.usage + ", additionalProperties=" + this.additionalProperties + ")";
        }

        public Telemetry(Device device, Os os, Usage usage, Map additionalProperties) {
            Intrinsics.checkNotNullParameter(usage, "usage");
            Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            this.device = device;
            this.os = os;
            this.usage = usage;
            this.additionalProperties = additionalProperties;
            this.type = "usage";
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
            jsonObject.add("usage", this.usage.toJson());
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
        }
    }

    public static abstract class Usage {
        public static final Companion Companion = new Companion(null);

        public /* synthetic */ Usage(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract JsonElement toJson();

        private Usage() {
        }

        public static final class AddViewLoadingTime extends Usage {
            public static final Companion Companion = new Companion(null);
            private final String feature;
            private final boolean noActiveView;
            private final boolean noView;
            private final boolean overwritten;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof AddViewLoadingTime)) {
                    return false;
                }
                AddViewLoadingTime addViewLoadingTime = (AddViewLoadingTime) obj;
                return this.noView == addViewLoadingTime.noView && this.noActiveView == addViewLoadingTime.noActiveView && this.overwritten == addViewLoadingTime.overwritten;
            }

            public int hashCode() {
                return (((Boolean.hashCode(this.noView) * 31) + Boolean.hashCode(this.noActiveView)) * 31) + Boolean.hashCode(this.overwritten);
            }

            public String toString() {
                return "AddViewLoadingTime(noView=" + this.noView + ", noActiveView=" + this.noActiveView + ", overwritten=" + this.overwritten + ")";
            }

            public AddViewLoadingTime(boolean z, boolean z2, boolean z3) {
                super(null);
                this.noView = z;
                this.noActiveView = z2;
                this.overwritten = z3;
                this.feature = "addViewLoadingTime";
            }

            @Override // com.datadog.android.telemetry.model.TelemetryUsageEvent.Usage
            public JsonElement toJson() {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("feature", this.feature);
                jsonObject.addProperty("no_view", Boolean.valueOf(this.noView));
                jsonObject.addProperty("no_active_view", Boolean.valueOf(this.noActiveView));
                jsonObject.addProperty("overwritten", Boolean.valueOf(this.overwritten));
                return jsonObject;
            }

            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }
            }
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
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
