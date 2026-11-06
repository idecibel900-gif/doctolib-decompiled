package expo.modules.kotlin;

import expo.modules.kotlin.exception.CodedException;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public interface Promise {
    void reject(CodedException codedException);

    void reject(String str, String str2, Throwable th);

    void resolve();

    void resolve(double d);

    void resolve(float f);

    void resolve(int i);

    void resolve(Object obj);

    void resolve(String str);

    void resolve(Map map);

    void resolve(boolean z);

    public static final class DefaultImpls {
        public static void resolve(Promise promise) {
            promise.resolve((Object) null);
        }

        public static void resolve(Promise promise, int i) {
            promise.resolve(Integer.valueOf(i));
        }

        public static void resolve(Promise promise, boolean z) {
            promise.resolve(Boolean.valueOf(z));
        }

        public static void resolve(Promise promise, double d) {
            promise.resolve(Double.valueOf(d));
        }

        public static void resolve(Promise promise, float f) {
            promise.resolve(Float.valueOf(f));
        }

        public static void resolve(Promise promise, String result) {
            Intrinsics.checkNotNullParameter(result, "result");
            promise.resolve((Object) result);
        }

        public static void resolve(Promise promise, Map result) {
            Intrinsics.checkNotNullParameter(result, "result");
            promise.resolve((Object) result);
        }

        public static void reject(Promise promise, CodedException exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            promise.reject(exception.getCode(), exception.getLocalizedMessage(), exception.getCause());
        }
    }
}
