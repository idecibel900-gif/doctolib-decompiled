package expo.modules.kotlin.jni;

import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.PromiseAlreadySettledException;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.ResponseTypeValues;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\u000bJ\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\t\u0010\u000eJ\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\t\u0010\u0010J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\t\u0010\u0012J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\t\u0010\u0014J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\t\u0010\u0016J%\u0010\t\u001a\u00020\b2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0017H\u0016¢\u0006\u0004\b\t\u0010\u0018J+\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010!R$\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u000f8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001e\u0010(\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010*\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lexpo/modules/kotlin/jni/PromiseImpl;", "Lexpo/modules/kotlin/Promise;", "Lexpo/modules/kotlin/jni/JavaCallback;", "callback", "<init>", "(Lexpo/modules/kotlin/jni/JavaCallback;)V", "", "value", "", "resolve", "(Ljava/lang/Object;)V", "()V", "", "result", "(I)V", "", "(Z)V", "", "(D)V", "", "(F)V", "", "(Ljava/lang/String;)V", "", "(Ljava/util/Map;)V", ResponseTypeValues.CODE, "message", "", "cause", "reject", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "Lexpo/modules/kotlin/jni/JavaCallback;", "getCallback$expo_modules_core_release", "()Lexpo/modules/kotlin/jni/JavaCallback;", "wasSettled", "Z", "getWasSettled$expo_modules_core_release", "()Z", "Ljava/lang/ref/WeakReference;", "Lexpo/modules/kotlin/AppContext;", "appContextHolder", "Ljava/lang/ref/WeakReference;", "fullFunctionName", "Ljava/lang/String;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromiseImpl implements Promise {
    private WeakReference appContextHolder;
    private final JavaCallback callback;
    private String fullFunctionName;
    private boolean wasSettled;

    @Override // expo.modules.kotlin.Promise
    public void reject(CodedException codedException) {
        Promise.DefaultImpls.reject(this, codedException);
    }

    public PromiseImpl(JavaCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
    }

    /* JADX INFO: renamed from: getCallback$expo_modules_core_release, reason: from getter */
    public final JavaCallback getCallback() {
        return this.callback;
    }

    /* JADX INFO: renamed from: getWasSettled$expo_modules_core_release, reason: from getter */
    public final boolean getWasSettled() {
        return this.wasSettled;
    }

    @Override // expo.modules.kotlin.Promise
    public void reject(String code, String message, Throwable cause) throws PromiseAlreadySettledException {
        AppContext appContext;
        Intrinsics.checkNotNullParameter(code, "code");
        if (!this.wasSettled) {
            JavaCallback javaCallback = this.callback;
            if (message == null) {
                message = cause != null ? cause.getMessage() : null;
                if (message == null) {
                    message = "unknown";
                }
            }
            javaCallback.invoke(code, message);
            this.wasSettled = true;
            return;
        }
        String str = this.fullFunctionName;
        PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str != null ? str : "unknown");
        WeakReference weakReference = this.appContextHolder;
        if (weakReference == null || (appContext = (AppContext) weakReference.get()) == null) {
            throw promiseAlreadySettledException;
        }
        appContext.getJsLogger();
        throw promiseAlreadySettledException;
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve() throws PromiseAlreadySettledException {
        AppContext appContext;
        if (!this.wasSettled) {
            this.callback.invoke();
            this.wasSettled = true;
            return;
        }
        String str = this.fullFunctionName;
        if (str == null) {
            str = "unknown";
        }
        PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
        WeakReference weakReference = this.appContextHolder;
        if (weakReference == null || (appContext = (AppContext) weakReference.get()) == null) {
            throw promiseAlreadySettledException;
        }
        appContext.getJsLogger();
        throw promiseAlreadySettledException;
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(double result) throws PromiseAlreadySettledException {
        AppContext appContext;
        if (!this.wasSettled) {
            this.callback.invoke(result);
            this.wasSettled = true;
            return;
        }
        String str = this.fullFunctionName;
        if (str == null) {
            str = "unknown";
        }
        PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
        WeakReference weakReference = this.appContextHolder;
        if (weakReference == null || (appContext = (AppContext) weakReference.get()) == null) {
            throw promiseAlreadySettledException;
        }
        appContext.getJsLogger();
        throw promiseAlreadySettledException;
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(float result) throws PromiseAlreadySettledException {
        AppContext appContext;
        if (!this.wasSettled) {
            this.callback.invoke(result);
            this.wasSettled = true;
            return;
        }
        String str = this.fullFunctionName;
        if (str == null) {
            str = "unknown";
        }
        PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
        WeakReference weakReference = this.appContextHolder;
        if (weakReference == null || (appContext = (AppContext) weakReference.get()) == null) {
            throw promiseAlreadySettledException;
        }
        appContext.getJsLogger();
        throw promiseAlreadySettledException;
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(int result) throws PromiseAlreadySettledException {
        AppContext appContext;
        if (!this.wasSettled) {
            this.callback.invoke(result);
            this.wasSettled = true;
            return;
        }
        String str = this.fullFunctionName;
        if (str == null) {
            str = "unknown";
        }
        PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
        WeakReference weakReference = this.appContextHolder;
        if (weakReference == null || (appContext = (AppContext) weakReference.get()) == null) {
            throw promiseAlreadySettledException;
        }
        appContext.getJsLogger();
        throw promiseAlreadySettledException;
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(Object value) throws PromiseAlreadySettledException {
        AppContext appContext;
        if (!this.wasSettled) {
            this.callback.invoke(value);
            this.wasSettled = true;
            return;
        }
        String str = this.fullFunctionName;
        if (str == null) {
            str = "unknown";
        }
        PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
        WeakReference weakReference = this.appContextHolder;
        if (weakReference == null || (appContext = (AppContext) weakReference.get()) == null) {
            throw promiseAlreadySettledException;
        }
        appContext.getJsLogger();
        throw promiseAlreadySettledException;
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(String result) throws PromiseAlreadySettledException {
        AppContext appContext;
        Intrinsics.checkNotNullParameter(result, "result");
        if (!this.wasSettled) {
            this.callback.invoke(result);
            this.wasSettled = true;
            return;
        }
        String str = this.fullFunctionName;
        if (str == null) {
            str = "unknown";
        }
        PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
        WeakReference weakReference = this.appContextHolder;
        if (weakReference == null || (appContext = (AppContext) weakReference.get()) == null) {
            throw promiseAlreadySettledException;
        }
        appContext.getJsLogger();
        throw promiseAlreadySettledException;
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(Map result) throws PromiseAlreadySettledException {
        AppContext appContext;
        Intrinsics.checkNotNullParameter(result, "result");
        if (!this.wasSettled) {
            this.callback.invoke(result);
            this.wasSettled = true;
            return;
        }
        String str = this.fullFunctionName;
        if (str == null) {
            str = "unknown";
        }
        PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
        WeakReference weakReference = this.appContextHolder;
        if (weakReference == null || (appContext = (AppContext) weakReference.get()) == null) {
            throw promiseAlreadySettledException;
        }
        appContext.getJsLogger();
        throw promiseAlreadySettledException;
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(boolean result) throws PromiseAlreadySettledException {
        AppContext appContext;
        if (!this.wasSettled) {
            this.callback.invoke(result);
            this.wasSettled = true;
            return;
        }
        String str = this.fullFunctionName;
        if (str == null) {
            str = "unknown";
        }
        PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
        WeakReference weakReference = this.appContextHolder;
        if (weakReference == null || (appContext = (AppContext) weakReference.get()) == null) {
            throw promiseAlreadySettledException;
        }
        appContext.getJsLogger();
        throw promiseAlreadySettledException;
    }
}
