package expo.modules.kotlin.functions;

import expo.modules.kotlin.types.TypeConverterProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class AsyncFunctionBuilder {
    private BaseAsyncFunctionComponent asyncFunctionComponent;
    private final TypeConverterProvider converters;
    private final String name;

    public AsyncFunctionBuilder(String name, TypeConverterProvider typeConverterProvider) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.converters = typeConverterProvider;
    }

    public final String getName() {
        return this.name;
    }

    public final TypeConverterProvider getConverters() {
        return this.converters;
    }

    public final void setAsyncFunctionComponent(BaseAsyncFunctionComponent baseAsyncFunctionComponent) {
        this.asyncFunctionComponent = baseAsyncFunctionComponent;
    }

    public final BaseAsyncFunctionComponent build$expo_modules_core_release() {
        BaseAsyncFunctionComponent baseAsyncFunctionComponent = this.asyncFunctionComponent;
        if (baseAsyncFunctionComponent != null) {
            return baseAsyncFunctionComponent;
        }
        throw new IllegalArgumentException("Required value was null.");
    }
}
