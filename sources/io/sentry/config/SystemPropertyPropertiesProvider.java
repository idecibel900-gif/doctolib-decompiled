package io.sentry.config;

/* JADX INFO: loaded from: classes5.dex */
final class SystemPropertyPropertiesProvider extends AbstractPropertiesProvider {
    public SystemPropertyPropertiesProvider() {
        super("sentry.", System.getProperties());
    }
}
