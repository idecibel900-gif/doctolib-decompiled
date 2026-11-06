package io.sentry;

import io.sentry.util.LazyEvaluator;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public final class SpanId implements JsonSerializable {
    public static final SpanId EMPTY_ID = new SpanId("00000000-0000-0000-0000-000000000000".replace("-", "").substring(0, 16));
    private final LazyEvaluator lazyValue;

    /* JADX INFO: renamed from: $r8$lambda$DpHpdd0EN9-M-gXza5p17bilidk, reason: not valid java name */
    public static /* synthetic */ String m5168$r8$lambda$DpHpdd0EN9MgXza5p17bilidk(String str) {
        return str;
    }

    public SpanId(final String str) {
        Objects.requireNonNull(str, "value is required");
        this.lazyValue = new LazyEvaluator(new LazyEvaluator.Evaluator() { // from class: io.sentry.SpanId$$ExternalSyntheticLambda1
            @Override // io.sentry.util.LazyEvaluator.Evaluator
            public final Object evaluate() {
                return SpanId.m5168$r8$lambda$DpHpdd0EN9MgXza5p17bilidk(str);
            }
        });
    }

    public SpanId() {
        this.lazyValue = new LazyEvaluator(new LazyEvaluator.Evaluator() { // from class: io.sentry.SpanId$$ExternalSyntheticLambda0
            @Override // io.sentry.util.LazyEvaluator.Evaluator
            public final Object evaluate() {
                return SentryUUID.generateSpanId();
            }
        });
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SpanId.class != obj.getClass()) {
            return false;
        }
        return ((String) this.lazyValue.getValue()).equals(((SpanId) obj).lazyValue.getValue());
    }

    public int hashCode() {
        return ((String) this.lazyValue.getValue()).hashCode();
    }

    public String toString() {
        return (String) this.lazyValue.getValue();
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.value((String) this.lazyValue.getValue());
    }

    public static final class Deserializer implements JsonDeserializer {
        @Override // io.sentry.JsonDeserializer
        public SpanId deserialize(ObjectReader objectReader, ILogger iLogger) {
            return new SpanId(objectReader.nextString());
        }
    }
}
