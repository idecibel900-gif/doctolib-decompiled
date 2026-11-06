package expo.modules.kotlin.jni;

import com.facebook.jni.HybridData;
import expo.modules.kotlin.jni.decorators.JSDecoratorsBridgingObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: expo.modules.kotlin.jni.JavaScriptModuleObject, reason: from toString */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0082 ¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0086 ¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0011\u0010\u001a\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lexpo/modules/kotlin/jni/JavaScriptModuleObject;", "Lexpo/modules/kotlin/jni/Destructible;", "Lexpo/modules/kotlin/jni/JNIDeallocator;", "jniDeallocator", "", "name", "<init>", "(Lexpo/modules/kotlin/jni/JNIDeallocator;Ljava/lang/String;)V", "Lcom/facebook/jni/HybridData;", "initHybrid", "()Lcom/facebook/jni/HybridData;", "Lexpo/modules/kotlin/jni/decorators/JSDecoratorsBridgingObject;", "decorator", "", "decorate", "(Lexpo/modules/kotlin/jni/decorators/JSDecoratorsBridgingObject;)V", "finalize", "()V", "toString", "()Ljava/lang/String;", "getHybridDataForJNIDeallocator", "Ljava/lang/String;", "getName", "mHybridData", "Lcom/facebook/jni/HybridData;", "", "isValid", "()Z", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JavaScriptModuleObject_ implements Destructible {
    private final HybridData mHybridData;

    /* JADX INFO: renamed from: name, reason: from kotlin metadata and from toString */
    private final String JavaScriptModuleObject_;

    private final native HybridData initHybrid();

    public final native void decorate(JSDecoratorsBridgingObject decorator);

    public JavaScriptModuleObject_(JNIDeallocator jniDeallocator, String name) {
        Intrinsics.checkNotNullParameter(jniDeallocator, "jniDeallocator");
        Intrinsics.checkNotNullParameter(name, "name");
        this.JavaScriptModuleObject_ = name;
        this.mHybridData = initHybrid();
        jniDeallocator.addReference(this);
    }

    public final boolean isValid() {
        return this.mHybridData.isValid();
    }

    protected final void finalize() {
        this.mHybridData.resetNative();
    }

    public String toString() {
        return "JavaScriptModuleObject_" + this.JavaScriptModuleObject_;
    }

    @Override // expo.modules.kotlin.jni.Destructible
    /* JADX INFO: renamed from: getHybridDataForJNIDeallocator, reason: from getter */
    public HybridData getMHybridData() {
        return this.mHybridData;
    }
}
