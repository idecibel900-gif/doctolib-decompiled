package com.datadog.android.trace.model;

import com.adjust.sdk.Constants;
import com.datadog.android.core.internal.utils.JsonSerializer;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: loaded from: classes3.dex */
public final class SpanEvent {
    public static final Companion Companion = new Companion(null);
    private final long duration;
    private final long error;
    private final Meta meta;
    private final Metrics metrics;
    private String name;
    private final String parentId;
    private String resource;
    private final String service;
    private final String spanId;
    private final long start;
    private final String traceId;
    private final String type;

    public static final class Account {
        public abstract int hashCode();

        public abstract JsonElement toJson();
    }

    public final SpanEvent copy(String traceId, String spanId, String parentId, String resource, String name, String service, long j, long j2, long j3, Metrics metrics, Meta meta) {
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(spanId, "spanId");
        Intrinsics.checkNotNullParameter(parentId, "parentId");
        Intrinsics.checkNotNullParameter(resource, "resource");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Intrinsics.checkNotNullParameter(meta, "meta");
        return new SpanEvent(traceId, spanId, parentId, resource, name, service, j, j2, j3, metrics, meta);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpanEvent)) {
            return false;
        }
        SpanEvent spanEvent = (SpanEvent) obj;
        return Intrinsics.areEqual(this.traceId, spanEvent.traceId) && Intrinsics.areEqual(this.spanId, spanEvent.spanId) && Intrinsics.areEqual(this.parentId, spanEvent.parentId) && Intrinsics.areEqual(this.resource, spanEvent.resource) && Intrinsics.areEqual(this.name, spanEvent.name) && Intrinsics.areEqual(this.service, spanEvent.service) && this.duration == spanEvent.duration && this.start == spanEvent.start && this.error == spanEvent.error && Intrinsics.areEqual(this.metrics, spanEvent.metrics) && Intrinsics.areEqual(this.meta, spanEvent.meta);
    }

    public int hashCode() {
        return (((((((((((((((((((this.traceId.hashCode() * 31) + this.spanId.hashCode()) * 31) + this.parentId.hashCode()) * 31) + this.resource.hashCode()) * 31) + this.name.hashCode()) * 31) + this.service.hashCode()) * 31) + Long.hashCode(this.duration)) * 31) + Long.hashCode(this.start)) * 31) + Long.hashCode(this.error)) * 31) + this.metrics.hashCode()) * 31) + this.meta.hashCode();
    }

    public String toString() {
        return "SpanEvent(traceId=" + this.traceId + ", spanId=" + this.spanId + ", parentId=" + this.parentId + ", resource=" + this.resource + ", name=" + this.name + ", service=" + this.service + ", duration=" + this.duration + ", start=" + this.start + ", error=" + this.error + ", metrics=" + this.metrics + ", meta=" + this.meta + ")";
    }

    public SpanEvent(String traceId, String spanId, String parentId, String resource, String name, String service, long j, long j2, long j3, Metrics metrics, Meta meta) {
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(spanId, "spanId");
        Intrinsics.checkNotNullParameter(parentId, "parentId");
        Intrinsics.checkNotNullParameter(resource, "resource");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Intrinsics.checkNotNullParameter(meta, "meta");
        this.traceId = traceId;
        this.spanId = spanId;
        this.parentId = parentId;
        this.resource = resource;
        this.name = name;
        this.service = service;
        this.duration = j;
        this.start = j2;
        this.error = j3;
        this.metrics = metrics;
        this.meta = meta;
        this.type = "custom";
    }

    public final Metrics getMetrics() {
        return this.metrics;
    }

    public final Meta getMeta() {
        return this.meta;
    }

    public final JsonElement toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("trace_id", this.traceId);
        jsonObject.addProperty("span_id", this.spanId);
        jsonObject.addProperty("parent_id", this.parentId);
        jsonObject.addProperty("resource", this.resource);
        jsonObject.addProperty("name", this.name);
        jsonObject.addProperty("service", this.service);
        jsonObject.addProperty("duration", Long.valueOf(this.duration));
        jsonObject.addProperty("start", Long.valueOf(this.start));
        jsonObject.addProperty("error", Long.valueOf(this.error));
        jsonObject.addProperty("type", this.type);
        jsonObject.add("metrics", this.metrics.toJson());
        jsonObject.add(Constants.REFERRER_API_META, this.meta.toJson());
        return jsonObject;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public static final class Metrics {
        public static final Companion Companion = new Companion(null);
        private static final String[] RESERVED_PROPERTIES = {"_top_level"};
        private final Map additionalProperties;
        private final Long topLevel;

        public static /* synthetic */ Metrics copy$default(Metrics metrics, Long l, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                l = metrics.topLevel;
            }
            if ((i & 2) != 0) {
                map = metrics.additionalProperties;
            }
            return metrics.copy(l, map);
        }

        public final Metrics copy(Long l, Map additionalProperties) {
            Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            return new Metrics(l, additionalProperties);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Metrics)) {
                return false;
            }
            Metrics metrics = (Metrics) obj;
            return Intrinsics.areEqual(this.topLevel, metrics.topLevel) && Intrinsics.areEqual(this.additionalProperties, metrics.additionalProperties);
        }

        public int hashCode() {
            Long l = this.topLevel;
            return ((l == null ? 0 : l.hashCode()) * 31) + this.additionalProperties.hashCode();
        }

        public String toString() {
            return "Metrics(topLevel=" + this.topLevel + ", additionalProperties=" + this.additionalProperties + ")";
        }

        public Metrics(Long l, Map additionalProperties) {
            Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            this.topLevel = l;
            this.additionalProperties = additionalProperties;
        }

        public final Map getAdditionalProperties() {
            return this.additionalProperties;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            Long l = this.topLevel;
            if (l != null) {
                jsonObject.addProperty("_top_level", Long.valueOf(l.longValue()));
            }
            for (Map.Entry entry : this.additionalProperties.entrySet()) {
                String str = (String) entry.getKey();
                Number number = (Number) entry.getValue();
                if (!ArraysKt.contains(RESERVED_PROPERTIES, str)) {
                    jsonObject.addProperty(str, number);
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

    public static final class Meta {
        public static final Companion Companion = new Companion(null);
        private static final String[] RESERVED_PROPERTIES = {DiagnosticsEntry.VERSION_KEY, "_dd", "span", "tracer", "usr", "account", "network", "device", "os"};
        private final Account account;
        private final Map additionalProperties;
        private final Dd dd;
        private final Device device;
        private final Network network;
        private final Os os;
        private final Span span;
        private final Tracer tracer;
        private final Usr usr;
        private final String version;

        public static /* synthetic */ Meta copy$default(Meta meta, String str, Dd dd, Span span, Tracer tracer, Usr usr, Account account, Network network, Device device, Os os, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                str = meta.version;
            }
            if ((i & 2) != 0) {
                dd = meta.dd;
            }
            if ((i & 4) != 0) {
                span = meta.span;
            }
            if ((i & 8) != 0) {
                tracer = meta.tracer;
            }
            if ((i & 16) != 0) {
                usr = meta.usr;
            }
            if ((i & 32) != 0) {
                account = meta.account;
            }
            if ((i & 64) != 0) {
                network = meta.network;
            }
            if ((i & 128) != 0) {
                device = meta.device;
            }
            if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0) {
                os = meta.os;
            }
            if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0) {
                map = meta.additionalProperties;
            }
            Os os2 = os;
            Map map2 = map;
            Network network2 = network;
            Device device2 = device;
            Usr usr2 = usr;
            Account account2 = account;
            return meta.copy(str, dd, span, tracer, usr2, account2, network2, device2, os2, map2);
        }

        public final Meta copy(String version, Dd dd, Span span, Tracer tracer, Usr usr, Account account, Network network, Device device, Os os, Map additionalProperties) {
            Intrinsics.checkNotNullParameter(version, "version");
            Intrinsics.checkNotNullParameter(dd, "dd");
            Intrinsics.checkNotNullParameter(span, "span");
            Intrinsics.checkNotNullParameter(tracer, "tracer");
            Intrinsics.checkNotNullParameter(usr, "usr");
            Intrinsics.checkNotNullParameter(device, "device");
            Intrinsics.checkNotNullParameter(os, "os");
            Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            return new Meta(version, dd, span, tracer, usr, account, network, device, os, additionalProperties);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Meta)) {
                return false;
            }
            Meta meta = (Meta) obj;
            return Intrinsics.areEqual(this.version, meta.version) && Intrinsics.areEqual(this.dd, meta.dd) && Intrinsics.areEqual(this.span, meta.span) && Intrinsics.areEqual(this.tracer, meta.tracer) && Intrinsics.areEqual(this.usr, meta.usr) && Intrinsics.areEqual(this.account, meta.account) && Intrinsics.areEqual(this.network, meta.network) && Intrinsics.areEqual(this.device, meta.device) && Intrinsics.areEqual(this.os, meta.os) && Intrinsics.areEqual(this.additionalProperties, meta.additionalProperties);
        }

        public int hashCode() {
            int iHashCode = ((((((((((this.version.hashCode() * 31) + this.dd.hashCode()) * 31) + this.span.hashCode()) * 31) + this.tracer.hashCode()) * 31) + this.usr.hashCode()) * 31) + 0) * 31;
            Network network = this.network;
            return ((((((iHashCode + (network != null ? network.hashCode() : 0)) * 31) + this.device.hashCode()) * 31) + this.os.hashCode()) * 31) + this.additionalProperties.hashCode();
        }

        public String toString() {
            return "Meta(version=" + this.version + ", dd=" + this.dd + ", span=" + this.span + ", tracer=" + this.tracer + ", usr=" + this.usr + ", account=" + this.account + ", network=" + this.network + ", device=" + this.device + ", os=" + this.os + ", additionalProperties=" + this.additionalProperties + ")";
        }

        public Meta(String version, Dd dd, Span span, Tracer tracer, Usr usr, Account account, Network network, Device device, Os os, Map additionalProperties) {
            Intrinsics.checkNotNullParameter(version, "version");
            Intrinsics.checkNotNullParameter(dd, "dd");
            Intrinsics.checkNotNullParameter(span, "span");
            Intrinsics.checkNotNullParameter(tracer, "tracer");
            Intrinsics.checkNotNullParameter(usr, "usr");
            Intrinsics.checkNotNullParameter(device, "device");
            Intrinsics.checkNotNullParameter(os, "os");
            Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            this.version = version;
            this.dd = dd;
            this.span = span;
            this.tracer = tracer;
            this.usr = usr;
            this.account = account;
            this.network = network;
            this.device = device;
            this.os = os;
            this.additionalProperties = additionalProperties;
        }

        public final Usr getUsr() {
            return this.usr;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(DiagnosticsEntry.VERSION_KEY, this.version);
            jsonObject.add("_dd", this.dd.toJson());
            jsonObject.add("span", this.span.toJson());
            jsonObject.add("tracer", this.tracer.toJson());
            jsonObject.add("usr", this.usr.toJson());
            Network network = this.network;
            if (network != null) {
                jsonObject.add("network", network.toJson());
            }
            jsonObject.add("device", this.device.toJson());
            jsonObject.add("os", this.os.toJson());
            for (Map.Entry entry : this.additionalProperties.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                if (!ArraysKt.contains(RESERVED_PROPERTIES, str)) {
                    jsonObject.addProperty(str, str2);
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

    public static final class Dd {
        public static final Companion Companion = new Companion(null);
        private final Application application;
        private final Session session;
        private final String source;
        private final View view;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Dd)) {
                return false;
            }
            Dd dd = (Dd) obj;
            return Intrinsics.areEqual(this.source, dd.source) && Intrinsics.areEqual(this.application, dd.application) && Intrinsics.areEqual(this.session, dd.session) && Intrinsics.areEqual(this.view, dd.view);
        }

        public int hashCode() {
            String str = this.source;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            Application application = this.application;
            int iHashCode2 = (iHashCode + (application == null ? 0 : application.hashCode())) * 31;
            Session session = this.session;
            int iHashCode3 = (iHashCode2 + (session == null ? 0 : session.hashCode())) * 31;
            View view = this.view;
            return iHashCode3 + (view != null ? view.hashCode() : 0);
        }

        public String toString() {
            return "Dd(source=" + this.source + ", application=" + this.application + ", session=" + this.session + ", view=" + this.view + ")";
        }

        public Dd(String str, Application application, Session session, View view) {
            this.source = str;
            this.application = application;
            this.session = session;
            this.view = view;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            String str = this.source;
            if (str != null) {
                jsonObject.addProperty(com.google.firebase.messaging.Constants.ScionAnalytics.PARAM_SOURCE, str);
            }
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

    public static final class Span {
        public static final Companion Companion = new Companion(null);
        private final String kind = "client";

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("kind", this.kind);
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

    public static final class Tracer {
        public static final Companion Companion = new Companion(null);
        private final String version;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Tracer) && Intrinsics.areEqual(this.version, ((Tracer) obj).version);
        }

        public int hashCode() {
            return this.version.hashCode();
        }

        public String toString() {
            return "Tracer(version=" + this.version + ")";
        }

        public Tracer(String version) {
            Intrinsics.checkNotNullParameter(version, "version");
            this.version = version;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(DiagnosticsEntry.VERSION_KEY, this.version);
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

    public static final class Usr {
        public static final Companion Companion = new Companion(null);
        private static final String[] RESERVED_PROPERTIES = {DiagnosticsEntry.ID_KEY, "name", AuthorizationRequest.Scope.EMAIL};
        private final Map additionalProperties;
        private final String email;
        private final String id;
        private final String name;

        public static /* synthetic */ Usr copy$default(Usr usr, String str, String str2, String str3, Map map, int i, Object obj) {
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
                map = usr.additionalProperties;
            }
            return usr.copy(str, str2, str3, map);
        }

        public final Usr copy(String str, String str2, String str3, Map additionalProperties) {
            Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            return new Usr(str, str2, str3, additionalProperties);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Usr)) {
                return false;
            }
            Usr usr = (Usr) obj;
            return Intrinsics.areEqual(this.id, usr.id) && Intrinsics.areEqual(this.name, usr.name) && Intrinsics.areEqual(this.email, usr.email) && Intrinsics.areEqual(this.additionalProperties, usr.additionalProperties);
        }

        public int hashCode() {
            String str = this.id;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.name;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.email;
            return ((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.additionalProperties.hashCode();
        }

        public String toString() {
            return "Usr(id=" + this.id + ", name=" + this.name + ", email=" + this.email + ", additionalProperties=" + this.additionalProperties + ")";
        }

        public Usr(String str, String str2, String str3, Map additionalProperties) {
            Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            this.id = str;
            this.name = str2;
            this.email = str3;
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
            for (Map.Entry entry : this.additionalProperties.entrySet()) {
                String str4 = (String) entry.getKey();
                Object value = entry.getValue();
                if (!ArraysKt.contains(RESERVED_PROPERTIES, str4)) {
                    jsonObject.add(str4, JsonSerializer.INSTANCE.toJsonElement(value));
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

    public static final class Network {
        public static final Companion Companion = new Companion(null);
        private final Client client;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Network) && Intrinsics.areEqual(this.client, ((Network) obj).client);
        }

        public int hashCode() {
            Client client = this.client;
            if (client == null) {
                return 0;
            }
            return client.hashCode();
        }

        public String toString() {
            return "Network(client=" + this.client + ")";
        }

        public Network(Client client) {
            this.client = client;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            Client client = this.client;
            if (client != null) {
                jsonObject.add("client", client.toJson());
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
        private final String name;
        private final Type type;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Device)) {
                return false;
            }
            Device device = (Device) obj;
            return this.type == device.type && Intrinsics.areEqual(this.name, device.name) && Intrinsics.areEqual(this.model, device.model) && Intrinsics.areEqual(this.brand, device.brand) && Intrinsics.areEqual(this.architecture, device.architecture);
        }

        public int hashCode() {
            int iHashCode = this.type.hashCode() * 31;
            String str = this.name;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.model;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.brand;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.architecture;
            return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            return "Device(type=" + this.type + ", name=" + this.name + ", model=" + this.model + ", brand=" + this.brand + ", architecture=" + this.architecture + ")";
        }

        public Device(Type type, String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
            this.name = str;
            this.model = str2;
            this.brand = str3;
            this.architecture = str4;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("type", this.type.toJson());
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
            String str = this.id;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "Application(id=" + this.id + ")";
        }

        public Application(String str) {
            this.id = str;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            String str = this.id;
            if (str != null) {
                jsonObject.addProperty(DiagnosticsEntry.ID_KEY, str);
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
            String str = this.id;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "Session(id=" + this.id + ")";
        }

        public Session(String str) {
            this.id = str;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            String str = this.id;
            if (str != null) {
                jsonObject.addProperty(DiagnosticsEntry.ID_KEY, str);
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
            String str = this.id;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "View(id=" + this.id + ")";
        }

        public View(String str) {
            this.id = str;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            String str = this.id;
            if (str != null) {
                jsonObject.addProperty(DiagnosticsEntry.ID_KEY, str);
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

    public static final class Client {
        public static final Companion Companion = new Companion(null);
        private final String connectivity;
        private final String downlinkKbps;
        private final String signalStrength;
        private final SimCarrier simCarrier;
        private final String uplinkKbps;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Client)) {
                return false;
            }
            Client client = (Client) obj;
            return Intrinsics.areEqual(this.simCarrier, client.simCarrier) && Intrinsics.areEqual(this.signalStrength, client.signalStrength) && Intrinsics.areEqual(this.downlinkKbps, client.downlinkKbps) && Intrinsics.areEqual(this.uplinkKbps, client.uplinkKbps) && Intrinsics.areEqual(this.connectivity, client.connectivity);
        }

        public int hashCode() {
            SimCarrier simCarrier = this.simCarrier;
            int iHashCode = (simCarrier == null ? 0 : simCarrier.hashCode()) * 31;
            String str = this.signalStrength;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.downlinkKbps;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.uplinkKbps;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.connectivity;
            return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            return "Client(simCarrier=" + this.simCarrier + ", signalStrength=" + this.signalStrength + ", downlinkKbps=" + this.downlinkKbps + ", uplinkKbps=" + this.uplinkKbps + ", connectivity=" + this.connectivity + ")";
        }

        public Client(SimCarrier simCarrier, String str, String str2, String str3, String str4) {
            this.simCarrier = simCarrier;
            this.signalStrength = str;
            this.downlinkKbps = str2;
            this.uplinkKbps = str3;
            this.connectivity = str4;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            SimCarrier simCarrier = this.simCarrier;
            if (simCarrier != null) {
                jsonObject.add("sim_carrier", simCarrier.toJson());
            }
            String str = this.signalStrength;
            if (str != null) {
                jsonObject.addProperty("signal_strength", str);
            }
            String str2 = this.downlinkKbps;
            if (str2 != null) {
                jsonObject.addProperty("downlink_kbps", str2);
            }
            String str3 = this.uplinkKbps;
            if (str3 != null) {
                jsonObject.addProperty("uplink_kbps", str3);
            }
            String str4 = this.connectivity;
            if (str4 != null) {
                jsonObject.addProperty("connectivity", str4);
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

    public static final class SimCarrier {
        public static final Companion Companion = new Companion(null);
        private final String id;
        private final String name;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SimCarrier)) {
                return false;
            }
            SimCarrier simCarrier = (SimCarrier) obj;
            return Intrinsics.areEqual(this.id, simCarrier.id) && Intrinsics.areEqual(this.name, simCarrier.name);
        }

        public int hashCode() {
            String str = this.id;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.name;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "SimCarrier(id=" + this.id + ", name=" + this.name + ")";
        }

        public SimCarrier(String str, String str2) {
            this.id = str;
            this.name = str2;
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

    public enum Type {
        MOBILE("mobile"),
        DESKTOP("desktop"),
        TABLET("tablet"),
        TV("tv"),
        GAMING_CONSOLE("gaming_console"),
        BOT("bot"),
        OTHER(PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER);

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
        }
    }
}
