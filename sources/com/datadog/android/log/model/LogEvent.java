package com.datadog.android.log.model;

import com.datadog.android.core.internal.utils.JsonSerializer;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: loaded from: classes3.dex */
public final class LogEvent {
    public static final Companion Companion = new Companion(null);
    private static final String[] RESERVED_PROPERTIES = {"status", "service", "message", "date", "logger", "_dd", "usr", "account", "network", "error", "build_id", "ddtags"};
    private final Account account;
    private final Map additionalProperties;
    private final String buildId;
    private final String date;
    private final Dd dd;
    private String ddtags;
    private final Error error;
    private final Logger logger;
    private String message;
    private final Network network;
    private final String service;
    private Status status;
    private final Usr usr;

    public static final class Account {
        public abstract int hashCode();

        public abstract JsonElement toJson();
    }

    public static /* synthetic */ LogEvent copy$default(LogEvent logEvent, Status status, String str, String str2, String str3, Logger logger, Dd dd, Usr usr, Account account, Network network, Error error, String str4, String str5, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            status = logEvent.status;
        }
        return logEvent.copy(status, (i & 2) != 0 ? logEvent.service : str, (i & 4) != 0 ? logEvent.message : str2, (i & 8) != 0 ? logEvent.date : str3, (i & 16) != 0 ? logEvent.logger : logger, (i & 32) != 0 ? logEvent.dd : dd, (i & 64) != 0 ? logEvent.usr : usr, (i & 128) != 0 ? logEvent.account : account, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? logEvent.network : network, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? logEvent.error : error, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? logEvent.buildId : str4, (i & 2048) != 0 ? logEvent.ddtags : str5, (i & 4096) != 0 ? logEvent.additionalProperties : map);
    }

    public final LogEvent copy(Status status, String service, String message, String date, Logger logger, Dd dd, Usr usr, Account account, Network network, Error error, String str, String ddtags, Map additionalProperties) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(dd, "dd");
        Intrinsics.checkNotNullParameter(ddtags, "ddtags");
        Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
        return new LogEvent(status, service, message, date, logger, dd, usr, account, network, error, str, ddtags, additionalProperties);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LogEvent)) {
            return false;
        }
        LogEvent logEvent = (LogEvent) obj;
        return this.status == logEvent.status && Intrinsics.areEqual(this.service, logEvent.service) && Intrinsics.areEqual(this.message, logEvent.message) && Intrinsics.areEqual(this.date, logEvent.date) && Intrinsics.areEqual(this.logger, logEvent.logger) && Intrinsics.areEqual(this.dd, logEvent.dd) && Intrinsics.areEqual(this.usr, logEvent.usr) && Intrinsics.areEqual(this.account, logEvent.account) && Intrinsics.areEqual(this.network, logEvent.network) && Intrinsics.areEqual(this.error, logEvent.error) && Intrinsics.areEqual(this.buildId, logEvent.buildId) && Intrinsics.areEqual(this.ddtags, logEvent.ddtags) && Intrinsics.areEqual(this.additionalProperties, logEvent.additionalProperties);
    }

    public int hashCode() {
        int iHashCode = ((((((((((this.status.hashCode() * 31) + this.service.hashCode()) * 31) + this.message.hashCode()) * 31) + this.date.hashCode()) * 31) + this.logger.hashCode()) * 31) + this.dd.hashCode()) * 31;
        Usr usr = this.usr;
        int iHashCode2 = (((iHashCode + (usr == null ? 0 : usr.hashCode())) * 31) + 0) * 31;
        Network network = this.network;
        int iHashCode3 = (iHashCode2 + (network == null ? 0 : network.hashCode())) * 31;
        Error error = this.error;
        int iHashCode4 = (iHashCode3 + (error == null ? 0 : error.hashCode())) * 31;
        String str = this.buildId;
        return ((((iHashCode4 + (str != null ? str.hashCode() : 0)) * 31) + this.ddtags.hashCode()) * 31) + this.additionalProperties.hashCode();
    }

    public String toString() {
        return "LogEvent(status=" + this.status + ", service=" + this.service + ", message=" + this.message + ", date=" + this.date + ", logger=" + this.logger + ", dd=" + this.dd + ", usr=" + this.usr + ", account=" + this.account + ", network=" + this.network + ", error=" + this.error + ", buildId=" + this.buildId + ", ddtags=" + this.ddtags + ", additionalProperties=" + this.additionalProperties + ")";
    }

    public LogEvent(Status status, String service, String message, String date, Logger logger, Dd dd, Usr usr, Account account, Network network, Error error, String str, String ddtags, Map additionalProperties) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(dd, "dd");
        Intrinsics.checkNotNullParameter(ddtags, "ddtags");
        Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
        this.status = status;
        this.service = service;
        this.message = message;
        this.date = date;
        this.logger = logger;
        this.dd = dd;
        this.usr = usr;
        this.account = account;
        this.network = network;
        this.error = error;
        this.buildId = str;
        this.ddtags = ddtags;
        this.additionalProperties = additionalProperties;
    }

    public final Usr getUsr() {
        return this.usr;
    }

    public final String getDdtags() {
        return this.ddtags;
    }

    public final Map getAdditionalProperties() {
        return this.additionalProperties;
    }

    public final JsonElement toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("status", this.status.toJson());
        jsonObject.addProperty("service", this.service);
        jsonObject.addProperty("message", this.message);
        jsonObject.addProperty("date", this.date);
        jsonObject.add("logger", this.logger.toJson());
        jsonObject.add("_dd", this.dd.toJson());
        Usr usr = this.usr;
        if (usr != null) {
            jsonObject.add("usr", usr.toJson());
        }
        Network network = this.network;
        if (network != null) {
            jsonObject.add("network", network.toJson());
        }
        Error error = this.error;
        if (error != null) {
            jsonObject.add("error", error.toJson());
        }
        String str = this.buildId;
        if (str != null) {
            jsonObject.addProperty("build_id", str);
        }
        jsonObject.addProperty("ddtags", this.ddtags);
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
    }

    public static final class Logger {
        public static final Companion Companion = new Companion(null);
        private String name;
        private final String threadName;
        private final String version;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Logger)) {
                return false;
            }
            Logger logger = (Logger) obj;
            return Intrinsics.areEqual(this.name, logger.name) && Intrinsics.areEqual(this.threadName, logger.threadName) && Intrinsics.areEqual(this.version, logger.version);
        }

        public int hashCode() {
            int iHashCode = this.name.hashCode() * 31;
            String str = this.threadName;
            return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.version.hashCode();
        }

        public String toString() {
            return "Logger(name=" + this.name + ", threadName=" + this.threadName + ", version=" + this.version + ")";
        }

        public Logger(String name, String str, String version) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(version, "version");
            this.name = name;
            this.threadName = str;
            this.version = version;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("name", this.name);
            String str = this.threadName;
            if (str != null) {
                jsonObject.addProperty("thread_name", str);
            }
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

    public static final class Dd {
        public static final Companion Companion = new Companion(null);
        private final Device device;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Dd) && Intrinsics.areEqual(this.device, ((Dd) obj).device);
        }

        public int hashCode() {
            return this.device.hashCode();
        }

        public String toString() {
            return "Dd(device=" + this.device + ")";
        }

        public Dd(Device device) {
            Intrinsics.checkNotNullParameter(device, "device");
            this.device = device;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("device", this.device.toJson());
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
            return this.client.hashCode();
        }

        public String toString() {
            return "Network(client=" + this.client + ")";
        }

        public Network(Client client) {
            Intrinsics.checkNotNullParameter(client, "client");
            this.client = client;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("client", this.client.toJson());
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

    public static final class Error {
        public static final Companion Companion = new Companion(null);
        private String fingerprint;
        private String kind;
        private String message;
        private String sourceType;
        private String stack;
        private final List threads;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Error)) {
                return false;
            }
            Error error = (Error) obj;
            return Intrinsics.areEqual(this.kind, error.kind) && Intrinsics.areEqual(this.message, error.message) && Intrinsics.areEqual(this.stack, error.stack) && Intrinsics.areEqual(this.sourceType, error.sourceType) && Intrinsics.areEqual(this.fingerprint, error.fingerprint) && Intrinsics.areEqual(this.threads, error.threads);
        }

        public int hashCode() {
            String str = this.kind;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.message;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.stack;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.sourceType;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.fingerprint;
            int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            List list = this.threads;
            return iHashCode5 + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            return "Error(kind=" + this.kind + ", message=" + this.message + ", stack=" + this.stack + ", sourceType=" + this.sourceType + ", fingerprint=" + this.fingerprint + ", threads=" + this.threads + ")";
        }

        public Error(String str, String str2, String str3, String str4, String str5, List list) {
            this.kind = str;
            this.message = str2;
            this.stack = str3;
            this.sourceType = str4;
            this.fingerprint = str5;
            this.threads = list;
        }

        public /* synthetic */ Error(String str, String str2, String str3, String str4, String str5, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : list);
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            String str = this.kind;
            if (str != null) {
                jsonObject.addProperty("kind", str);
            }
            String str2 = this.message;
            if (str2 != null) {
                jsonObject.addProperty("message", str2);
            }
            String str3 = this.stack;
            if (str3 != null) {
                jsonObject.addProperty("stack", str3);
            }
            String str4 = this.sourceType;
            if (str4 != null) {
                jsonObject.addProperty("source_type", str4);
            }
            String str5 = this.fingerprint;
            if (str5 != null) {
                jsonObject.addProperty("fingerprint", str5);
            }
            List list = this.threads;
            if (list != null) {
                JsonArray jsonArray = new JsonArray(list.size());
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    jsonArray.add(((Thread) it.next()).toJson());
                }
                jsonObject.add("threads", jsonArray);
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

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Device) && Intrinsics.areEqual(this.architecture, ((Device) obj).architecture);
        }

        public int hashCode() {
            return this.architecture.hashCode();
        }

        public String toString() {
            return "Device(architecture=" + this.architecture + ")";
        }

        public Device(String architecture) {
            Intrinsics.checkNotNullParameter(architecture, "architecture");
            this.architecture = architecture;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("architecture", this.architecture);
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
            return ((iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.connectivity.hashCode();
        }

        public String toString() {
            return "Client(simCarrier=" + this.simCarrier + ", signalStrength=" + this.signalStrength + ", downlinkKbps=" + this.downlinkKbps + ", uplinkKbps=" + this.uplinkKbps + ", connectivity=" + this.connectivity + ")";
        }

        public Client(SimCarrier simCarrier, String str, String str2, String str3, String connectivity) {
            Intrinsics.checkNotNullParameter(connectivity, "connectivity");
            this.simCarrier = simCarrier;
            this.signalStrength = str;
            this.downlinkKbps = str2;
            this.uplinkKbps = str3;
            this.connectivity = connectivity;
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
            jsonObject.addProperty("connectivity", this.connectivity);
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

    public enum Status {
        CRITICAL("critical"),
        ERROR("error"),
        WARN(app.notifee.core.event.LogEvent.LEVEL_WARN),
        INFO("info"),
        DEBUG("debug"),
        TRACE("trace"),
        EMERGENCY("emergency");

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
        }
    }
}
