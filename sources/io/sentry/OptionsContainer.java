package io.sentry;

/* JADX INFO: loaded from: classes5.dex */
public final class OptionsContainer {
    private final Class clazz;

    public static OptionsContainer create(Class cls) {
        return new OptionsContainer(cls);
    }

    private OptionsContainer(Class cls) {
        this.clazz = cls;
    }

    public Object createInstance() {
        return this.clazz.getDeclaredConstructor(null).newInstance(null);
    }
}
