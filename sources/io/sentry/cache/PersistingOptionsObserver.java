package io.sentry.cache;

import io.sentry.IOptionsObserver;
import io.sentry.JsonDeserializer;
import io.sentry.SentryOptions;
import io.sentry.protocol.SdkVersion;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class PersistingOptionsObserver implements IOptionsObserver {
    private final SentryOptions options;

    public PersistingOptionsObserver(SentryOptions sentryOptions) {
        this.options = sentryOptions;
    }

    @Override // io.sentry.IOptionsObserver
    public void setRelease(String str) {
        if (str == null) {
            delete("release.json");
        } else {
            store(str, "release.json");
        }
    }

    @Override // io.sentry.IOptionsObserver
    public void setProguardUuid(String str) {
        if (str == null) {
            delete("proguard-uuid.json");
        } else {
            store(str, "proguard-uuid.json");
        }
    }

    @Override // io.sentry.IOptionsObserver
    public void setSdkVersion(SdkVersion sdkVersion) {
        if (sdkVersion == null) {
            delete("sdk-version.json");
        } else {
            store(sdkVersion, "sdk-version.json");
        }
    }

    @Override // io.sentry.IOptionsObserver
    public void setDist(String str) {
        if (str == null) {
            delete("dist.json");
        } else {
            store(str, "dist.json");
        }
    }

    @Override // io.sentry.IOptionsObserver
    public void setEnvironment(String str) {
        if (str == null) {
            delete("environment.json");
        } else {
            store(str, "environment.json");
        }
    }

    @Override // io.sentry.IOptionsObserver
    public void setTags(Map map) {
        store(map, "tags.json");
    }

    @Override // io.sentry.IOptionsObserver
    public void setReplayErrorSampleRate(Double d) {
        if (d != null) {
            store(d.toString(), "replay-error-sample-rate.json");
        } else {
            delete("replay-error-sample-rate.json");
        }
    }

    private void store(Object obj, String str) {
        CacheUtils.store(this.options, obj, ".options-cache", str);
    }

    private void delete(String str) {
        CacheUtils.delete(this.options, ".options-cache", str);
    }

    public static Object read(SentryOptions sentryOptions, String str, Class cls) {
        return read(sentryOptions, str, cls, null);
    }

    public static Object read(SentryOptions sentryOptions, String str, Class cls, JsonDeserializer jsonDeserializer) {
        return CacheUtils.read(sentryOptions, ".options-cache", str, cls, jsonDeserializer);
    }
}
