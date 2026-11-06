package io.sentry.rrweb;

import com.google.firebase.messaging.Constants;
import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.util.Objects;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class RRWebIncrementalSnapshotEvent extends RRWebEvent {
    private IncrementalSource source;

    public enum IncrementalSource implements JsonSerializable {
        Mutation,
        MouseMove,
        MouseInteraction,
        Scroll,
        ViewportResize,
        Input,
        TouchMove,
        MediaInteraction,
        StyleSheetRule,
        CanvasMutation,
        Font,
        Log,
        Drag,
        StyleDeclaration,
        Selection,
        AdoptedStyleSheet,
        CustomElement;

        @Override // io.sentry.JsonSerializable
        public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
            objectWriter.value(ordinal());
        }

        public static final class Deserializer implements JsonDeserializer {
            @Override // io.sentry.JsonDeserializer
            public IncrementalSource deserialize(ObjectReader objectReader, ILogger iLogger) {
                return IncrementalSource.values()[objectReader.nextInt()];
            }
        }
    }

    public RRWebIncrementalSnapshotEvent(IncrementalSource incrementalSource) {
        super(RRWebEventType.IncrementalSnapshot);
        this.source = incrementalSource;
    }

    public static final class Serializer {
        public void serialize(RRWebIncrementalSnapshotEvent rRWebIncrementalSnapshotEvent, ObjectWriter objectWriter, ILogger iLogger) {
            objectWriter.name(Constants.ScionAnalytics.PARAM_SOURCE).value(iLogger, rRWebIncrementalSnapshotEvent.source);
        }
    }

    public static final class Deserializer {
        public boolean deserializeValue(RRWebIncrementalSnapshotEvent rRWebIncrementalSnapshotEvent, String str, ObjectReader objectReader, ILogger iLogger) {
            if (!str.equals(Constants.ScionAnalytics.PARAM_SOURCE)) {
                return false;
            }
            rRWebIncrementalSnapshotEvent.source = (IncrementalSource) Objects.requireNonNull((IncrementalSource) objectReader.nextOrNull(iLogger, new IncrementalSource.Deserializer()), "");
            return true;
        }
    }
}
