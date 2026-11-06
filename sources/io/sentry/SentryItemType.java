package io.sentry;

import io.sentry.clientreport.ClientReport;
import io.sentry.protocol.SentryTransaction;
import java.io.IOException;
import java.util.Locale;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: loaded from: classes5.dex */
public enum SentryItemType implements JsonSerializable {
    Session("session"),
    Event("event"),
    UserFeedback("user_report"),
    Attachment("attachment"),
    Transaction("transaction"),
    Profile(AuthorizationRequest.Scope.PROFILE),
    ProfileChunk("profile_chunk"),
    ClientReport("client_report"),
    ReplayEvent("replay_event"),
    ReplayRecording("replay_recording"),
    ReplayVideo("replay_video"),
    CheckIn("check_in"),
    Feedback("feedback"),
    Log("log"),
    TraceMetric("trace_metric"),
    Span("span"),
    Unknown("__unknown__");

    private final String itemType;

    public static SentryItemType resolve(Object obj) {
        if (obj instanceof SentryEvent) {
            return ((SentryEvent) obj).getContexts().getFeedback() == null ? Event : Feedback;
        }
        if (obj instanceof SentryTransaction) {
            return Transaction;
        }
        if (obj instanceof Session) {
            return Session;
        }
        if (obj instanceof ClientReport) {
            return ClientReport;
        }
        return Attachment;
    }

    SentryItemType(String str) {
        this.itemType = str;
    }

    public String getItemType() {
        return this.itemType;
    }

    public static SentryItemType valueOfLabel(String str) {
        for (SentryItemType sentryItemType : values()) {
            if (sentryItemType.itemType.equals(str)) {
                return sentryItemType;
            }
        }
        return Unknown;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.value(this.itemType);
    }

    public static final class Deserializer implements JsonDeserializer {
        @Override // io.sentry.JsonDeserializer
        public SentryItemType deserialize(ObjectReader objectReader, ILogger iLogger) {
            return SentryItemType.valueOfLabel(objectReader.nextString().toLowerCase(Locale.ROOT));
        }
    }
}
