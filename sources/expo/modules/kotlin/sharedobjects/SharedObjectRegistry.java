package expo.modules.kotlin.sharedobjects;

import expo.modules.kotlin.UtilsKt;
import expo.modules.kotlin.exception.Exceptions$AppContextLost;
import expo.modules.kotlin.exception.InvalidSharedObjectIdException;
import expo.modules.kotlin.exception.UsingReleasedSharedObjectException;
import expo.modules.kotlin.jni.JavaScriptObject;
import expo.modules.kotlin.jni.JavaScriptWeakObject;
import expo.modules.kotlin.runtime.Runtime;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class SharedObjectRegistry {
    private int currentId;
    private Map pairs;
    private final WeakReference runtimeContextHolder;

    public SharedObjectRegistry(Runtime runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        this.runtimeContextHolder = UtilsKt.weak(runtime);
        this.currentId = SharedObjectId.m4919constructorimpl(1);
        this.pairs = new LinkedHashMap();
    }

    /* JADX INFO: renamed from: pullNextId-HSeVr_g, reason: not valid java name */
    private final int m4929pullNextIdHSeVr_g() {
        int i;
        synchronized (this) {
            i = this.currentId;
            this.currentId = SharedObjectId.m4919constructorimpl(i + 1);
        }
        return i;
    }

    /* JADX INFO: renamed from: add-5WKnsLU$expo_modules_core_release, reason: not valid java name */
    public final int m4930add5WKnsLU$expo_modules_core_release(SharedObject sharedObject, JavaScriptObject js) throws Exceptions$AppContextLost {
        Intrinsics.checkNotNullParameter(sharedObject, "native");
        Intrinsics.checkNotNullParameter(js, "js");
        int iM4929pullNextIdHSeVr_g = m4929pullNextIdHSeVr_g();
        sharedObject.m4917setSharedObjectIdkyJHjyY$expo_modules_core_release(iM4929pullNextIdHSeVr_g);
        JavaScriptObject.defineProperty$default(js, "__expo_shared_object_id__", iM4929pullNextIdHSeVr_g, (List) null, 4, (Object) null);
        Runtime runtime = (Runtime) this.runtimeContextHolder.get();
        if (runtime == null) {
            throw new Exceptions$AppContextLost();
        }
        runtime.getJsiContext().setNativeStateForSharedObject(iM4929pullNextIdHSeVr_g, js);
        int additionalMemoryPressure = sharedObject.getAdditionalMemoryPressure();
        if (additionalMemoryPressure > 0) {
            js.setExternalMemoryPressure(additionalMemoryPressure);
        }
        if (sharedObject instanceof SharedRef) {
            JavaScriptObject.defineProperty$default(js, "nativeRefType", ((SharedRef) sharedObject).getNativeRefType(), (List) null, 4, (Object) null);
        }
        JavaScriptWeakObject javaScriptWeakObjectCreateWeak = js.createWeak();
        synchronized (this) {
            this.pairs.put(SharedObjectId.m4918boximpl(iM4929pullNextIdHSeVr_g), TuplesKt.to(sharedObject, javaScriptWeakObjectCreateWeak));
            Unit unit = Unit.INSTANCE;
        }
        if (sharedObject.getRuntimeContextHolder().get() == null) {
            sharedObject.setRuntimeContextHolder(UtilsKt.weak(runtime));
        }
        return iM4929pullNextIdHSeVr_g;
    }

    /* JADX INFO: renamed from: delete-kyJHjyY$expo_modules_core_release, reason: not valid java name */
    public final void m4931deletekyJHjyY$expo_modules_core_release(int i) {
        Pair pair;
        synchronized (this) {
            pair = (Pair) this.pairs.remove(SharedObjectId.m4918boximpl(i));
        }
        if (pair != null) {
            SharedObject sharedObject = (SharedObject) pair.getFirst();
            sharedObject.m4917setSharedObjectIdkyJHjyY$expo_modules_core_release(SharedObjectId.m4919constructorimpl(0));
            sharedObject.sharedObjectDidRelease();
        }
    }

    /* JADX INFO: renamed from: toNativeObject-kyJHjyY$expo_modules_core_release, reason: not valid java name */
    public final SharedObject m4932toNativeObjectkyJHjyY$expo_modules_core_release(int i) throws InvalidSharedObjectIdException {
        Pair pair = (Pair) this.pairs.get(SharedObjectId.m4918boximpl(m4928ensureWasNotReleasetuC2VU(i)));
        SharedObject sharedObject = pair != null ? (SharedObject) pair.getFirst() : null;
        if (sharedObject != null) {
            return sharedObject;
        }
        throw new InvalidSharedObjectIdException();
    }

    /* JADX INFO: renamed from: toNativeObjectOrNull-kyJHjyY$expo_modules_core_release, reason: not valid java name */
    public final SharedObject m4933toNativeObjectOrNullkyJHjyY$expo_modules_core_release(int i) {
        SharedObject sharedObject;
        synchronized (this) {
            Pair pair = (Pair) this.pairs.get(SharedObjectId.m4918boximpl(i));
            sharedObject = pair != null ? (SharedObject) pair.getFirst() : null;
        }
        return sharedObject;
    }

    public final JavaScriptObject toJavaScriptObjectOrNull$expo_modules_core_release(SharedObject sharedObject) {
        JavaScriptObject javaScriptObjectLock;
        JavaScriptWeakObject javaScriptWeakObject;
        Intrinsics.checkNotNullParameter(sharedObject, "native");
        synchronized (this) {
            Pair pair = (Pair) this.pairs.get(SharedObjectId.m4918boximpl(sharedObject.m4916getSharedObjectIdHSeVr_g$expo_modules_core_release()));
            javaScriptObjectLock = (pair == null || (javaScriptWeakObject = (JavaScriptWeakObject) pair.getSecond()) == null) ? null : javaScriptWeakObject.lock();
        }
        return javaScriptObjectLock;
    }

    public final JavaScriptWeakObject toWeakJavaScriptObjectOrNull$expo_modules_core_release(SharedObject nativeObject) {
        JavaScriptWeakObject javaScriptWeakObject;
        Intrinsics.checkNotNullParameter(nativeObject, "nativeObject");
        synchronized (this) {
            Pair pair = (Pair) this.pairs.get(SharedObjectId.m4918boximpl(nativeObject.m4916getSharedObjectIdHSeVr_g$expo_modules_core_release()));
            javaScriptWeakObject = pair != null ? (JavaScriptWeakObject) pair.getSecond() : null;
        }
        return javaScriptWeakObject;
    }

    /* JADX INFO: renamed from: ensureWasNotRelease-tuC-2VU, reason: not valid java name */
    private final int m4928ensureWasNotReleasetuC2VU(int i) throws UsingReleasedSharedObjectException {
        if (this.pairs.containsKey(SharedObjectId.m4918boximpl(i)) || i == 0 || i >= this.currentId) {
            return i;
        }
        throw new UsingReleasedSharedObjectException();
    }
}
