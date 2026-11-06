package com.datadog.opentracing.propagation;

import com.datadog.legacy.trace.api.Config;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class HttpCodec {

    public interface Extractor {
    }

    public interface Injector {
    }

    public static Injector createInjector(Config config) {
        ArrayList arrayList = new ArrayList();
        for (Config.PropagationStyle propagationStyle : config.getPropagationStylesToInject()) {
            if (propagationStyle == Config.PropagationStyle.DATADOG) {
                arrayList.add(new DatadogHttpCodec$Injector());
            } else if (propagationStyle == Config.PropagationStyle.B3) {
                arrayList.add(new Injector() { // from class: com.datadog.opentracing.propagation.B3HttpCodec$Injector
                });
            } else if (propagationStyle == Config.PropagationStyle.B3MULTI) {
                arrayList.add(new Injector() { // from class: com.datadog.opentracing.propagation.B3MHttpCodec$Injector
                });
            } else if (propagationStyle == Config.PropagationStyle.TRACECONTEXT) {
                arrayList.add(new Injector() { // from class: com.datadog.opentracing.propagation.W3CHttpCodec$Injector
                });
            } else if (propagationStyle == Config.PropagationStyle.HAYSTACK) {
                arrayList.add(new Injector() { // from class: com.datadog.opentracing.propagation.HaystackHttpCodec$Injector
                });
            }
        }
        return new CompoundInjector(arrayList);
    }

    public static Extractor createExtractor(Config config, final Map map) {
        ArrayList arrayList = new ArrayList();
        for (Config.PropagationStyle propagationStyle : config.getPropagationStylesToExtract()) {
            if (propagationStyle == Config.PropagationStyle.DATADOG) {
                arrayList.add(new Extractor(map) { // from class: com.datadog.opentracing.propagation.DatadogHttpCodec$Extractor
                    private final Map taggedHeaders = new HashMap();

                    {
                        for (Map.Entry entry : map.entrySet()) {
                            this.taggedHeaders.put(((String) entry.getKey()).trim().toLowerCase(Locale.US), (String) entry.getValue());
                        }
                    }
                });
            } else if (propagationStyle == Config.PropagationStyle.B3) {
                arrayList.add(new Extractor(map) { // from class: com.datadog.opentracing.propagation.B3HttpCodec$Extractor
                    private final Map taggedHeaders = new HashMap();

                    {
                        for (Map.Entry entry : map.entrySet()) {
                            this.taggedHeaders.put(((String) entry.getKey()).trim().toLowerCase(Locale.US), (String) entry.getValue());
                        }
                    }
                });
            } else if (propagationStyle == Config.PropagationStyle.B3MULTI) {
                arrayList.add(new Extractor(map) { // from class: com.datadog.opentracing.propagation.B3MHttpCodec$Extractor
                    private final Map taggedHeaders = new HashMap();

                    {
                        for (Map.Entry entry : map.entrySet()) {
                            this.taggedHeaders.put(((String) entry.getKey()).trim().toLowerCase(Locale.US), (String) entry.getValue());
                        }
                    }
                });
            } else if (propagationStyle == Config.PropagationStyle.TRACECONTEXT) {
                arrayList.add(new Extractor(map) { // from class: com.datadog.opentracing.propagation.W3CHttpCodec$Extractor
                    private final Map taggedHeaders = new HashMap();

                    {
                        for (Map.Entry entry : map.entrySet()) {
                            this.taggedHeaders.put(((String) entry.getKey()).trim().toLowerCase(Locale.US), (String) entry.getValue());
                        }
                    }
                });
            } else if (propagationStyle == Config.PropagationStyle.HAYSTACK) {
                arrayList.add(new Extractor(map) { // from class: com.datadog.opentracing.propagation.HaystackHttpCodec$Extractor
                    private final Map taggedHeaders = new HashMap();

                    {
                        for (Map.Entry entry : map.entrySet()) {
                            this.taggedHeaders.put(((String) entry.getKey()).trim().toLowerCase(Locale.US), (String) entry.getValue());
                        }
                    }
                });
            }
        }
        return new CompoundExtractor(arrayList);
    }

    public static class CompoundInjector implements Injector {
        private final List injectors;

        public CompoundInjector(List list) {
            this.injectors = list;
        }
    }

    public static class CompoundExtractor implements Extractor {
        private final List extractors;

        public CompoundExtractor(List list) {
            this.extractors = list;
        }
    }
}
