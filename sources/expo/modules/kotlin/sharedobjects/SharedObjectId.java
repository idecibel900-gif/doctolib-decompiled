package expo.modules.kotlin.sharedobjects;

import expo.modules.kotlin.jni.JavaScriptObject;
import expo.modules.kotlin.jni.JavaScriptWeakObject;
import expo.modules.kotlin.runtime.Runtime;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class SharedObjectId {
    private final int value;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ SharedObjectId m4918boximpl(int i) {
        return new SharedObjectId(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m4919constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m4920equalsimpl(int i, Object obj) {
        return (obj instanceof SharedObjectId) && i == ((SharedObjectId) obj).m4927unboximpl();
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m4921hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m4925toStringimpl(int i) {
        return "SharedObjectId(value=" + i + ")";
    }

    public boolean equals(Object obj) {
        return m4920equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m4921hashCodeimpl(this.value);
    }

    public String toString() {
        return m4925toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m4927unboximpl() {
        return this.value;
    }

    private /* synthetic */ SharedObjectId(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: toNativeObject-impl, reason: not valid java name */
    public static final SharedObject m4923toNativeObjectimpl(int i, Runtime runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        return runtime.getSharedObjectRegistry$expo_modules_core_release().m4932toNativeObjectkyJHjyY$expo_modules_core_release(i);
    }

    /* JADX INFO: renamed from: toNativeObjectOrNull-impl, reason: not valid java name */
    public static final SharedObject m4924toNativeObjectOrNullimpl(int i, Runtime runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        return runtime.getSharedObjectRegistry$expo_modules_core_release().m4933toNativeObjectOrNullkyJHjyY$expo_modules_core_release(i);
    }

    /* JADX INFO: renamed from: toJavaScriptObjectNull-impl, reason: not valid java name */
    public static final JavaScriptObject m4922toJavaScriptObjectNullimpl(int i, Runtime runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        SharedObject sharedObjectM4924toNativeObjectOrNullimpl = m4924toNativeObjectOrNullimpl(i, runtime);
        if (sharedObjectM4924toNativeObjectOrNullimpl == null) {
            return null;
        }
        return runtime.getSharedObjectRegistry$expo_modules_core_release().toJavaScriptObjectOrNull$expo_modules_core_release(sharedObjectM4924toNativeObjectOrNullimpl);
    }

    /* JADX INFO: renamed from: toWeakJavaScriptObjectNull-impl, reason: not valid java name */
    public static final JavaScriptWeakObject m4926toWeakJavaScriptObjectNullimpl(int i, Runtime runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        SharedObject sharedObjectM4924toNativeObjectOrNullimpl = m4924toNativeObjectOrNullimpl(i, runtime);
        if (sharedObjectM4924toNativeObjectOrNullimpl == null) {
            return null;
        }
        return runtime.getSharedObjectRegistry$expo_modules_core_release().toWeakJavaScriptObjectOrNull$expo_modules_core_release(sharedObjectM4924toNativeObjectOrNullimpl);
    }
}
