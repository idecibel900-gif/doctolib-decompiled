package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.SentryUUID;
import io.sentry.util.LazyEvaluator;
import io.sentry.util.StringUtils;
import io.sentry.util.UUIDStringUtils;
import java.util.UUID;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryId implements JsonSerializable {
    public static final SentryId EMPTY_ID = new SentryId("00000000-0000-0000-0000-000000000000".replace("-", ""));
    private final LazyEvaluator lazyStringValue;

    public static /* synthetic */ String $r8$lambda$XfcCjfzzEnKyzDGJLITwiHQDId0(String str) {
        return str;
    }

    public SentryId() {
        this((UUID) null);
    }

    public SentryId(final UUID uuid) {
        if (uuid != null) {
            this.lazyStringValue = new LazyEvaluator(new LazyEvaluator.Evaluator() { // from class: io.sentry.protocol.SentryId$$ExternalSyntheticLambda0
                @Override // io.sentry.util.LazyEvaluator.Evaluator
                public final Object evaluate() {
                    return SentryId.$r8$lambda$9u24CF3zFIKxn4v272EgKPqZ3TI(this.f$0, uuid);
                }
            });
        } else {
            this.lazyStringValue = new LazyEvaluator(new LazyEvaluator.Evaluator() { // from class: io.sentry.protocol.SentryId$$ExternalSyntheticLambda1
                @Override // io.sentry.util.LazyEvaluator.Evaluator
                public final Object evaluate() {
                    return SentryUUID.generateSentryId();
                }
            });
        }
    }

    public static /* synthetic */ String $r8$lambda$9u24CF3zFIKxn4v272EgKPqZ3TI(SentryId sentryId, UUID uuid) {
        sentryId.getClass();
        return sentryId.normalize(UUIDStringUtils.toSentryIdString(uuid));
    }

    public SentryId(String str) {
        final String strNormalizeUUID = StringUtils.normalizeUUID(str);
        if (strNormalizeUUID.length() != 32 && strNormalizeUUID.length() != 36) {
            throw new IllegalArgumentException("String representation of SentryId has either 32 (UUID no dashes) or 36 characters long (completed UUID). Received: " + str);
        }
        if (strNormalizeUUID.length() == 36) {
            this.lazyStringValue = new LazyEvaluator(new LazyEvaluator.Evaluator() { // from class: io.sentry.protocol.SentryId$$ExternalSyntheticLambda2
                @Override // io.sentry.util.LazyEvaluator.Evaluator
                public final Object evaluate() {
                    return this.f$0.normalize(strNormalizeUUID);
                }
            });
        } else {
            this.lazyStringValue = new LazyEvaluator(new LazyEvaluator.Evaluator() { // from class: io.sentry.protocol.SentryId$$ExternalSyntheticLambda3
                @Override // io.sentry.util.LazyEvaluator.Evaluator
                public final Object evaluate() {
                    return SentryId.$r8$lambda$XfcCjfzzEnKyzDGJLITwiHQDId0(strNormalizeUUID);
                }
            });
        }
    }

    public String toString() {
        return (String) this.lazyStringValue.getValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SentryId.class != obj.getClass()) {
            return false;
        }
        return ((String) this.lazyStringValue.getValue()).equals(((SentryId) obj).lazyStringValue.getValue());
    }

    public int hashCode() {
        return ((String) this.lazyStringValue.getValue()).hashCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String normalize(String str) {
        return StringUtils.normalizeUUID(str).replace("-", "");
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.value(toString());
    }

    public static final class Deserializer implements JsonDeserializer {
        @Override // io.sentry.JsonDeserializer
        public SentryId deserialize(ObjectReader objectReader, ILogger iLogger) {
            return new SentryId(objectReader.nextString());
        }
    }
}
