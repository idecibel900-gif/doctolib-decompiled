package io.sentry.protocol.profiling;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.protocol.SentryStackFrame;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryProfile implements JsonSerializable {
    private Map unknown;
    private List samples = new ArrayList();
    private List stacks = new ArrayList();
    private List frames = new ArrayList();
    private Map threadMetadata = new HashMap();

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        objectWriter.name("samples").value(iLogger, this.samples);
        objectWriter.name("stacks").value(iLogger, this.stacks);
        objectWriter.name("frames").value(iLogger, this.frames);
        objectWriter.name("thread_metadata").value(iLogger, this.threadMetadata);
        Map map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                objectWriter.name(str).value(iLogger, this.unknown.get(str));
            }
        }
        objectWriter.endObject();
    }

    public List getSamples() {
        return this.samples;
    }

    public void setStacks(List list) {
        this.stacks = list;
    }

    public void setFrames(List list) {
        this.frames = list;
    }

    public void setThreadMetadata(Map map) {
        this.threadMetadata = map;
    }

    public void setUnknown(Map map) {
        this.unknown = map;
    }

    public static final class Deserializer implements JsonDeserializer {
        @Override // io.sentry.JsonDeserializer
        public SentryProfile deserialize(ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            SentryProfile sentryProfile = new SentryProfile();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "frames":
                        List listNextListOrNull = objectReader.nextListOrNull(iLogger, new SentryStackFrame.Deserializer());
                        if (listNextListOrNull == null) {
                            break;
                        } else {
                            sentryProfile.frames = listNextListOrNull;
                            break;
                        }
                        break;
                    case "stacks":
                        List list = (List) objectReader.nextOrNull(iLogger, new NestedIntegerListDeserializer());
                        if (list == null) {
                            break;
                        } else {
                            sentryProfile.stacks = list;
                            break;
                        }
                        break;
                    case "samples":
                        List listNextListOrNull2 = objectReader.nextListOrNull(iLogger, new SentrySample.Deserializer());
                        if (listNextListOrNull2 == null) {
                            break;
                        } else {
                            sentryProfile.samples = listNextListOrNull2;
                            break;
                        }
                        break;
                    case "thread_metadata":
                        Map mapNextMapOrNull = objectReader.nextMapOrNull(iLogger, new SentryThreadMetadata.Deserializer());
                        if (mapNextMapOrNull == null) {
                            break;
                        } else {
                            sentryProfile.threadMetadata = mapNextMapOrNull;
                            break;
                        }
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                        break;
                }
            }
            sentryProfile.setUnknown(concurrentHashMap);
            objectReader.endObject();
            return sentryProfile;
        }
    }

    private static final class NestedIntegerListDeserializer implements JsonDeserializer {
        private NestedIntegerListDeserializer() {
        }

        @Override // io.sentry.JsonDeserializer
        public List deserialize(ObjectReader objectReader, ILogger iLogger) {
            ArrayList arrayList = new ArrayList();
            objectReader.beginArray();
            while (objectReader.hasNext()) {
                ArrayList arrayList2 = new ArrayList();
                objectReader.beginArray();
                while (objectReader.hasNext()) {
                    arrayList2.add(Integer.valueOf(objectReader.nextInt()));
                }
                objectReader.endArray();
                arrayList.add(arrayList2);
            }
            objectReader.endArray();
            return arrayList;
        }
    }
}
