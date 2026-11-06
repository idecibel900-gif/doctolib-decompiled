package expo.modules.kotlin.jni.worklets;

import com.facebook.jni.HybridData;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0086 R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lexpo/modules/kotlin/jni/worklets/WorkletNativeRuntime;", "", "jsRuntimePointer", "", "<init>", "(J)V", "mHybridData", "Lcom/facebook/jni/HybridData;", "initHybrid", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WorkletNativeRuntime {
    private final HybridData mHybridData;

    public final native HybridData initHybrid(long jsRuntimePointer);

    public WorkletNativeRuntime(long j) {
        this.mHybridData = initHybrid(j);
    }
}
