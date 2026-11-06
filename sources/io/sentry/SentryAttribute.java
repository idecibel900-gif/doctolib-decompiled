package io.sentry;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryAttribute {
    private final String name;
    private final SentryAttributeType type;
    private final Object value;

    private SentryAttribute(String str, SentryAttributeType sentryAttributeType, Object obj) {
        this.name = str;
        this.type = sentryAttributeType;
        this.value = obj;
    }

    public String getName() {
        return this.name;
    }

    public static SentryAttribute named(String str, Object obj) {
        return new SentryAttribute(str, null, obj);
    }
}
