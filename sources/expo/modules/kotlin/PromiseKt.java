package expo.modules.kotlin;

import com.facebook.react.bridge.WritableMap;
import expo.modules.kotlin.jni.PromiseImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class PromiseKt {
    public static final com.facebook.react.bridge.Promise toBridgePromise(final Promise promise) {
        final Function1 promiseKt$toBridgePromise$resolveMethod$2;
        Intrinsics.checkNotNullParameter(promise, "<this>");
        if (promise instanceof PromiseImpl) {
            promiseKt$toBridgePromise$resolveMethod$2 = new PromiseKt$toBridgePromise$resolveMethod$1(((PromiseImpl) promise).getCallback());
        } else {
            promiseKt$toBridgePromise$resolveMethod$2 = new PromiseKt$toBridgePromise$resolveMethod$2(promise);
        }
        return new com.facebook.react.bridge.Promise() { // from class: expo.modules.kotlin.PromiseKt.toBridgePromise.1
            @Override // com.facebook.react.bridge.Promise
            public void resolve(Object obj) {
                promiseKt$toBridgePromise$resolveMethod$2.invoke(obj);
            }

            @Override // com.facebook.react.bridge.Promise
            public void reject(String code, String str) {
                Intrinsics.checkNotNullParameter(code, "code");
                promise.reject(code, str, null);
            }

            @Override // com.facebook.react.bridge.Promise
            public void reject(String code, Throwable th) {
                Intrinsics.checkNotNullParameter(code, "code");
                promise.reject(code, null, th);
            }

            @Override // com.facebook.react.bridge.Promise
            public void reject(String code, String str, Throwable th) {
                Intrinsics.checkNotNullParameter(code, "code");
                promise.reject(code, str, th);
            }

            @Override // com.facebook.react.bridge.Promise
            public void reject(Throwable throwable) {
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                promise.reject("UnknownCode", null, throwable);
            }

            @Override // com.facebook.react.bridge.Promise
            public void reject(Throwable throwable, WritableMap userInfo) {
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                Intrinsics.checkNotNullParameter(userInfo, "userInfo");
                promise.reject("UnknownCode", null, throwable);
            }

            @Override // com.facebook.react.bridge.Promise
            public void reject(String code, WritableMap userInfo) {
                Intrinsics.checkNotNullParameter(code, "code");
                Intrinsics.checkNotNullParameter(userInfo, "userInfo");
                promise.reject(code, null, null);
            }

            @Override // com.facebook.react.bridge.Promise
            public void reject(String code, Throwable th, WritableMap userInfo) {
                Intrinsics.checkNotNullParameter(code, "code");
                Intrinsics.checkNotNullParameter(userInfo, "userInfo");
                promise.reject(code, null, th);
            }

            @Override // com.facebook.react.bridge.Promise
            public void reject(String code, String str, WritableMap userInfo) {
                Intrinsics.checkNotNullParameter(code, "code");
                Intrinsics.checkNotNullParameter(userInfo, "userInfo");
                promise.reject(code, str, null);
            }

            @Override // com.facebook.react.bridge.Promise
            public void reject(String str, String str2, Throwable th, WritableMap writableMap) {
                Promise promise2 = promise;
                if (str == null) {
                    str = "UnknownCode";
                }
                promise2.reject(str, str2, th);
            }

            @Override // com.facebook.react.bridge.Promise
            public void reject(String message) {
                Intrinsics.checkNotNullParameter(message, "message");
                promise.reject("UnknownCode", message, null);
            }
        };
    }
}
