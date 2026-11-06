package expo.modules.kotlin;

import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.types.JSTypeConverterProvider;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class KPromiseWrapper implements Promise {
    private final com.facebook.react.bridge.Promise bridgePromise;

    public KPromiseWrapper(com.facebook.react.bridge.Promise bridgePromise) {
        Intrinsics.checkNotNullParameter(bridgePromise, "bridgePromise");
        this.bridgePromise = bridgePromise;
    }

    @Override // expo.modules.kotlin.Promise
    public void reject(CodedException codedException) {
        Promise.DefaultImpls.reject(this, codedException);
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve() {
        Promise.DefaultImpls.resolve(this);
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(double d) {
        Promise.DefaultImpls.resolve(this, d);
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(float f) {
        Promise.DefaultImpls.resolve((Promise) this, f);
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(int i) {
        Promise.DefaultImpls.resolve((Promise) this, i);
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(String str) {
        Promise.DefaultImpls.resolve(this, str);
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(Map map) {
        Promise.DefaultImpls.resolve(this, map);
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(boolean z) {
        Promise.DefaultImpls.resolve(this, z);
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(Object obj) {
        this.bridgePromise.resolve(JSTypeConverterProvider.convertToJSValue$default(JSTypeConverterProvider.INSTANCE, obj, null, false, 6, null));
    }

    @Override // expo.modules.kotlin.Promise
    public void reject(String code, String str, Throwable th) {
        Intrinsics.checkNotNullParameter(code, "code");
        this.bridgePromise.reject(code, str, th);
    }
}
