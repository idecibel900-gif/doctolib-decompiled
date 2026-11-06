package io.sentry;

import io.sentry.protocol.App;
import io.sentry.protocol.Browser;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.Device;
import io.sentry.protocol.FeatureFlags;
import io.sentry.protocol.Gpu;
import io.sentry.protocol.OperatingSystem;
import io.sentry.protocol.Response;
import io.sentry.protocol.SentryRuntime;
import io.sentry.protocol.Spring;
import java.util.Enumeration;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public final class CombinedContextsView extends Contexts {
    private final Contexts currentContexts;
    private final ScopeType defaultScopeType;
    private final Contexts globalContexts;
    private final Contexts isolationContexts;

    public CombinedContextsView(Contexts contexts, Contexts contexts2, Contexts contexts3, ScopeType scopeType) {
        this.globalContexts = contexts;
        this.isolationContexts = contexts2;
        this.currentContexts = contexts3;
        this.defaultScopeType = scopeType;
    }

    @Override // io.sentry.protocol.Contexts
    public SpanContext getTrace() {
        SpanContext trace = this.currentContexts.getTrace();
        if (trace != null) {
            return trace;
        }
        SpanContext trace2 = this.isolationContexts.getTrace();
        return trace2 != null ? trace2 : this.globalContexts.getTrace();
    }

    @Override // io.sentry.protocol.Contexts
    public void setTrace(SpanContext spanContext) {
        getDefaultContexts().setTrace(spanContext);
    }

    /* JADX INFO: renamed from: io.sentry.CombinedContextsView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$sentry$ScopeType;

        static {
            int[] iArr = new int[ScopeType.values().length];
            $SwitchMap$io$sentry$ScopeType = iArr;
            try {
                iArr[ScopeType.CURRENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$sentry$ScopeType[ScopeType.ISOLATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$sentry$ScopeType[ScopeType.GLOBAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private Contexts getDefaultContexts() {
        int i = AnonymousClass1.$SwitchMap$io$sentry$ScopeType[this.defaultScopeType.ordinal()];
        if (i == 1) {
            return this.currentContexts;
        }
        if (i == 2) {
            return this.isolationContexts;
        }
        if (i == 3) {
            return this.globalContexts;
        }
        return this.currentContexts;
    }

    @Override // io.sentry.protocol.Contexts
    public App getApp() {
        App app2 = this.currentContexts.getApp();
        if (app2 != null) {
            return app2;
        }
        App app3 = this.isolationContexts.getApp();
        return app3 != null ? app3 : this.globalContexts.getApp();
    }

    @Override // io.sentry.protocol.Contexts
    public void setApp(App app2) {
        getDefaultContexts().setApp(app2);
    }

    @Override // io.sentry.protocol.Contexts
    public void setBrowser(Browser browser) {
        getDefaultContexts().setBrowser(browser);
    }

    @Override // io.sentry.protocol.Contexts
    public Device getDevice() {
        Device device = this.currentContexts.getDevice();
        if (device != null) {
            return device;
        }
        Device device2 = this.isolationContexts.getDevice();
        return device2 != null ? device2 : this.globalContexts.getDevice();
    }

    @Override // io.sentry.protocol.Contexts
    public void setDevice(Device device) {
        getDefaultContexts().setDevice(device);
    }

    @Override // io.sentry.protocol.Contexts
    public OperatingSystem getOperatingSystem() {
        OperatingSystem operatingSystem = this.currentContexts.getOperatingSystem();
        if (operatingSystem != null) {
            return operatingSystem;
        }
        OperatingSystem operatingSystem2 = this.isolationContexts.getOperatingSystem();
        return operatingSystem2 != null ? operatingSystem2 : this.globalContexts.getOperatingSystem();
    }

    @Override // io.sentry.protocol.Contexts
    public void setOperatingSystem(OperatingSystem operatingSystem) {
        getDefaultContexts().setOperatingSystem(operatingSystem);
    }

    @Override // io.sentry.protocol.Contexts
    public SentryRuntime getRuntime() {
        SentryRuntime runtime = this.currentContexts.getRuntime();
        if (runtime != null) {
            return runtime;
        }
        SentryRuntime runtime2 = this.isolationContexts.getRuntime();
        return runtime2 != null ? runtime2 : this.globalContexts.getRuntime();
    }

    @Override // io.sentry.protocol.Contexts
    public void setRuntime(SentryRuntime sentryRuntime) {
        getDefaultContexts().setRuntime(sentryRuntime);
    }

    @Override // io.sentry.protocol.Contexts
    public void setGpu(Gpu gpu) {
        getDefaultContexts().setGpu(gpu);
    }

    @Override // io.sentry.protocol.Contexts
    public void setResponse(Response response) {
        getDefaultContexts().setResponse(response);
    }

    @Override // io.sentry.protocol.Contexts
    public void setSpring(Spring spring) {
        getDefaultContexts().setSpring(spring);
    }

    @Override // io.sentry.protocol.Contexts
    public FeatureFlags getFeatureFlags() {
        FeatureFlags featureFlags = this.currentContexts.getFeatureFlags();
        if (featureFlags != null) {
            return featureFlags;
        }
        FeatureFlags featureFlags2 = this.isolationContexts.getFeatureFlags();
        return featureFlags2 != null ? featureFlags2 : this.globalContexts.getFeatureFlags();
    }

    @Override // io.sentry.protocol.Contexts
    public void setFeatureFlags(FeatureFlags featureFlags) {
        getDefaultContexts().setFeatureFlags(featureFlags);
    }

    @Override // io.sentry.protocol.Contexts
    public boolean containsKey(Object obj) {
        return this.globalContexts.containsKey(obj) || this.isolationContexts.containsKey(obj) || this.currentContexts.containsKey(obj);
    }

    @Override // io.sentry.protocol.Contexts
    public Object get(Object obj) {
        Object obj2 = this.currentContexts.get(obj);
        if (obj2 != null) {
            return obj2;
        }
        Object obj3 = this.isolationContexts.get(obj);
        return obj3 != null ? obj3 : this.globalContexts.get(obj);
    }

    @Override // io.sentry.protocol.Contexts
    public Object put(String str, Object obj) {
        return getDefaultContexts().put(str, obj);
    }

    @Override // io.sentry.protocol.Contexts
    public Object remove(Object obj) {
        return getDefaultContexts().remove(obj);
    }

    @Override // io.sentry.protocol.Contexts
    public Enumeration keys() {
        return mergeContexts().keys();
    }

    @Override // io.sentry.protocol.Contexts
    public Set entrySet() {
        return mergeContexts().entrySet();
    }

    @Override // io.sentry.protocol.Contexts, io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        mergeContexts().serialize(objectWriter, iLogger);
    }

    @Override // io.sentry.protocol.Contexts
    public void putAll(Contexts contexts) {
        getDefaultContexts().putAll(contexts);
    }

    private Contexts mergeContexts() {
        Contexts contexts = new Contexts();
        contexts.putAll(this.globalContexts);
        contexts.putAll(this.isolationContexts);
        contexts.putAll(this.currentContexts);
        return contexts;
    }
}
