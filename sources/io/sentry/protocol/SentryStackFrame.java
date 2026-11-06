package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.SentryLockReason;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import net.openid.appauth.RegistrationRequest;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryStackFrame implements JsonSerializable {
    private Boolean _native;
    private String _package;
    private String absPath;
    private String addrMode;
    private Integer colno;
    private String contextLine;
    private String filename;
    private List framesOmitted;
    private String function;
    private String imageAddr;
    private Boolean inApp;
    private String instructionAddr;
    private Integer lineno;
    private SentryLockReason lock;
    private String module;
    private String platform;
    private List postContext;
    private List preContext;
    private String rawFunction;
    private String symbol;
    private String symbolAddr;
    private Map unknown;
    private Map vars;

    public void setFilename(String str) {
        this.filename = str;
    }

    public void setFunction(String str) {
        this.function = str;
    }

    public String getModule() {
        return this.module;
    }

    public void setModule(String str) {
        this.module = str;
    }

    public void setLineno(Integer num) {
        this.lineno = num;
    }

    public Boolean isInApp() {
        return this.inApp;
    }

    public void setInApp(Boolean bool) {
        this.inApp = bool;
    }

    public void setPackage(String str) {
        this._package = str;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void setInstructionAddr(String str) {
        this.instructionAddr = str;
    }

    public void setAddrMode(String str) {
        this.addrMode = str;
    }

    public void setNative(Boolean bool) {
        this._native = bool;
    }

    public void setLock(SentryLockReason sentryLockReason) {
        this.lock = sentryLockReason;
    }

    public void setUnknown(Map map) {
        this.unknown = map;
    }

    public boolean equals(Object obj) {
        if (obj != null && SentryStackFrame.class == obj.getClass()) {
            SentryStackFrame sentryStackFrame = (SentryStackFrame) obj;
            if (Objects.equals(this.preContext, sentryStackFrame.preContext) && Objects.equals(this.postContext, sentryStackFrame.postContext) && Objects.equals(this.vars, sentryStackFrame.vars) && Objects.equals(this.framesOmitted, sentryStackFrame.framesOmitted) && Objects.equals(this.filename, sentryStackFrame.filename) && Objects.equals(this.function, sentryStackFrame.function) && Objects.equals(this.module, sentryStackFrame.module) && Objects.equals(this.lineno, sentryStackFrame.lineno) && Objects.equals(this.colno, sentryStackFrame.colno) && Objects.equals(this.absPath, sentryStackFrame.absPath) && Objects.equals(this.contextLine, sentryStackFrame.contextLine) && Objects.equals(this.inApp, sentryStackFrame.inApp) && Objects.equals(this._package, sentryStackFrame._package) && Objects.equals(this._native, sentryStackFrame._native) && Objects.equals(this.platform, sentryStackFrame.platform) && Objects.equals(this.imageAddr, sentryStackFrame.imageAddr) && Objects.equals(this.symbolAddr, sentryStackFrame.symbolAddr) && Objects.equals(this.instructionAddr, sentryStackFrame.instructionAddr) && Objects.equals(this.addrMode, sentryStackFrame.addrMode) && Objects.equals(this.symbol, sentryStackFrame.symbol) && Objects.equals(this.unknown, sentryStackFrame.unknown) && Objects.equals(this.rawFunction, sentryStackFrame.rawFunction) && Objects.equals(this.lock, sentryStackFrame.lock)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.preContext, this.postContext, this.vars, this.framesOmitted, this.filename, this.function, this.module, this.lineno, this.colno, this.absPath, this.contextLine, this.inApp, this._package, this._native, this.platform, this.imageAddr, this.symbolAddr, this.instructionAddr, this.addrMode, this.symbol, this.unknown, this.rawFunction, this.lock);
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        if (this.filename != null) {
            objectWriter.name("filename").value(this.filename);
        }
        if (this.function != null) {
            objectWriter.name("function").value(this.function);
        }
        if (this.module != null) {
            objectWriter.name("module").value(this.module);
        }
        if (this.lineno != null) {
            objectWriter.name("lineno").value(this.lineno);
        }
        if (this.colno != null) {
            objectWriter.name("colno").value(this.colno);
        }
        if (this.absPath != null) {
            objectWriter.name("abs_path").value(this.absPath);
        }
        if (this.contextLine != null) {
            objectWriter.name("context_line").value(this.contextLine);
        }
        if (this.inApp != null) {
            objectWriter.name("in_app").value(this.inApp);
        }
        if (this._package != null) {
            objectWriter.name("package").value(this._package);
        }
        if (this._native != null) {
            objectWriter.name(RegistrationRequest.APPLICATION_TYPE_NATIVE).value(this._native);
        }
        if (this.platform != null) {
            objectWriter.name("platform").value(this.platform);
        }
        if (this.imageAddr != null) {
            objectWriter.name("image_addr").value(this.imageAddr);
        }
        if (this.symbolAddr != null) {
            objectWriter.name("symbol_addr").value(this.symbolAddr);
        }
        if (this.instructionAddr != null) {
            objectWriter.name("instruction_addr").value(this.instructionAddr);
        }
        if (this.addrMode != null) {
            objectWriter.name("addr_mode").value(this.addrMode);
        }
        if (this.rawFunction != null) {
            objectWriter.name("raw_function").value(this.rawFunction);
        }
        if (this.symbol != null) {
            objectWriter.name("symbol").value(this.symbol);
        }
        if (this.lock != null) {
            objectWriter.name("lock").value(iLogger, this.lock);
        }
        List list = this.preContext;
        if (list != null && !list.isEmpty()) {
            objectWriter.name("pre_context").value(iLogger, this.preContext);
        }
        List list2 = this.postContext;
        if (list2 != null && !list2.isEmpty()) {
            objectWriter.name("post_context").value(iLogger, this.postContext);
        }
        Map map = this.vars;
        if (map != null && !map.isEmpty()) {
            objectWriter.name("vars").value(iLogger, this.vars);
        }
        Map map2 = this.unknown;
        if (map2 != null) {
            for (String str : map2.keySet()) {
                Object obj = this.unknown.get(str);
                objectWriter.name(str);
                objectWriter.value(iLogger, obj);
            }
        }
        objectWriter.endObject();
    }

    public static final class Deserializer implements JsonDeserializer {
        @Override // io.sentry.JsonDeserializer
        public SentryStackFrame deserialize(ObjectReader objectReader, ILogger iLogger) {
            SentryStackFrame sentryStackFrame = new SentryStackFrame();
            objectReader.beginObject();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "post_context":
                        sentryStackFrame.postContext = (List) objectReader.nextObjectOrNull();
                        break;
                    case "image_addr":
                        sentryStackFrame.imageAddr = objectReader.nextStringOrNull();
                        break;
                    case "in_app":
                        sentryStackFrame.inApp = objectReader.nextBooleanOrNull();
                        break;
                    case "raw_function":
                        sentryStackFrame.rawFunction = objectReader.nextStringOrNull();
                        break;
                    case "lineno":
                        sentryStackFrame.lineno = objectReader.nextIntegerOrNull();
                        break;
                    case "module":
                        sentryStackFrame.module = objectReader.nextStringOrNull();
                        break;
                    case "native":
                        sentryStackFrame._native = objectReader.nextBooleanOrNull();
                        break;
                    case "symbol":
                        sentryStackFrame.symbol = objectReader.nextStringOrNull();
                        break;
                    case "package":
                        sentryStackFrame._package = objectReader.nextStringOrNull();
                        break;
                    case "filename":
                        sentryStackFrame.filename = objectReader.nextStringOrNull();
                        break;
                    case "symbol_addr":
                        sentryStackFrame.symbolAddr = objectReader.nextStringOrNull();
                        break;
                    case "lock":
                        sentryStackFrame.lock = (SentryLockReason) objectReader.nextOrNull(iLogger, new SentryLockReason.Deserializer());
                        break;
                    case "vars":
                        sentryStackFrame.vars = (Map) objectReader.nextObjectOrNull();
                        break;
                    case "colno":
                        sentryStackFrame.colno = objectReader.nextIntegerOrNull();
                        break;
                    case "instruction_addr":
                        sentryStackFrame.instructionAddr = objectReader.nextStringOrNull();
                        break;
                    case "pre_context":
                        sentryStackFrame.preContext = (List) objectReader.nextObjectOrNull();
                        break;
                    case "addr_mode":
                        sentryStackFrame.addrMode = objectReader.nextStringOrNull();
                        break;
                    case "context_line":
                        sentryStackFrame.contextLine = objectReader.nextStringOrNull();
                        break;
                    case "function":
                        sentryStackFrame.function = objectReader.nextStringOrNull();
                        break;
                    case "abs_path":
                        sentryStackFrame.absPath = objectReader.nextStringOrNull();
                        break;
                    case "platform":
                        sentryStackFrame.platform = objectReader.nextStringOrNull();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                        break;
                }
            }
            sentryStackFrame.setUnknown(concurrentHashMap);
            objectReader.endObject();
            return sentryStackFrame;
        }
    }
}
