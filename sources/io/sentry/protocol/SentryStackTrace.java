package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.util.CollectionUtils;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryStackTrace implements JsonSerializable {
    private List frames;
    private InstructionAddressAdjustment instructionAddressAdjustment;
    private Map registers;
    private Boolean snapshot;
    private Map unknown;

    public SentryStackTrace() {
    }

    public SentryStackTrace(List list) {
        this.frames = list;
    }

    public List getFrames() {
        return this.frames;
    }

    public void setFrames(List list) {
        this.frames = list;
    }

    public void setRegisters(Map map) {
        this.registers = map;
    }

    public void setSnapshot(Boolean bool) {
        this.snapshot = bool;
    }

    public void setUnknown(Map map) {
        this.unknown = map;
    }

    public void setInstructionAddressAdjustment(InstructionAddressAdjustment instructionAddressAdjustment) {
        this.instructionAddressAdjustment = instructionAddressAdjustment;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        if (this.frames != null) {
            objectWriter.name("frames").value(iLogger, this.frames);
        }
        if (this.registers != null) {
            objectWriter.name("registers").value(iLogger, this.registers);
        }
        if (this.snapshot != null) {
            objectWriter.name("snapshot").value(this.snapshot);
        }
        if (this.instructionAddressAdjustment != null) {
            objectWriter.name("instruction_addr_adjustment").value(iLogger, this.instructionAddressAdjustment);
        }
        Map map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.unknown.get(str);
                objectWriter.name(str);
                objectWriter.value(iLogger, obj);
            }
        }
        objectWriter.endObject();
    }

    public static final class Deserializer implements JsonDeserializer {
        @Override // io.sentry.JsonDeserializer
        public SentryStackTrace deserialize(ObjectReader objectReader, ILogger iLogger) {
            SentryStackTrace sentryStackTrace = new SentryStackTrace();
            objectReader.beginObject();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "frames":
                        sentryStackTrace.frames = objectReader.nextListOrNull(iLogger, new SentryStackFrame.Deserializer());
                        break;
                    case "instruction_addr_adjustment":
                        sentryStackTrace.instructionAddressAdjustment = (InstructionAddressAdjustment) objectReader.nextOrNull(iLogger, new InstructionAddressAdjustment.Deserializer());
                        break;
                    case "registers":
                        sentryStackTrace.registers = CollectionUtils.newConcurrentHashMap((Map) objectReader.nextObjectOrNull());
                        break;
                    case "snapshot":
                        sentryStackTrace.snapshot = objectReader.nextBooleanOrNull();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                        break;
                }
            }
            sentryStackTrace.setUnknown(concurrentHashMap);
            objectReader.endObject();
            return sentryStackTrace;
        }
    }

    public enum InstructionAddressAdjustment implements JsonSerializable {
        AUTO,
        ALL,
        ALL_BUT_FIRST,
        NONE;

        @Override // io.sentry.JsonSerializable
        public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
            objectWriter.value(toString().toLowerCase(Locale.ROOT));
        }

        public static final class Deserializer implements JsonDeserializer {
            @Override // io.sentry.JsonDeserializer
            public InstructionAddressAdjustment deserialize(ObjectReader objectReader, ILogger iLogger) {
                return InstructionAddressAdjustment.valueOf(objectReader.nextString().toUpperCase(Locale.ROOT));
            }
        }
    }
}
