package com.margelo.nitro.core;

import androidx.annotation.Keep;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import dalvik.annotation.optimization.FastNative;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes4.dex */
@DoNotStrip
@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0017J\b\u0010\n\u001a\u00020\u000bH\u0017J\b\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u000f\u001a\u00020\rH\u0003R\u0014\u0010\u0004\u001a\u00020\u00058WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/margelo/nitro/core/HybridObject;", "", "<init>", "()V", "memorySize", "", "getMemorySize", "()J", "dispose", "", "toString", "", "createCxxPart", "Lcom/margelo/nitro/core/HybridObject$CxxPart;", "cxxPart", "getCxxPart", "CxxPart", "react-native-nitro-modules_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class HybridObject {
    private CxxPart cxxPart;

    @DoNotStrip
    @Keep
    public long getMemorySize() {
        return 0L;
    }

    @DoNotStrip
    @Keep
    public void dispose() {
        synchronized (this) {
            try {
                CxxPart cxxPart = this.cxxPart;
                if (cxxPart != null) {
                    cxxPart.destroy();
                }
                this.cxxPart = null;
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @DoNotStrip
    @Keep
    public String toString() {
        return "[HybridObject " + Reflection.getOrCreateKotlinClass(getClass()).getSimpleName() + "]";
    }

    protected CxxPart createCxxPart() {
        return new CxxPart(this);
    }

    @DoNotStrip
    @Keep
    private final CxxPart getCxxPart() {
        synchronized (this) {
            CxxPart cxxPart = this.cxxPart;
            if (cxxPart != null) {
                return cxxPart;
            }
            CxxPart cxxPartCreateCxxPart = createCxxPart();
            this.cxxPart = cxxPartCreateCxxPart;
            return cxxPartCreateCxxPart;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @DoNotStrip
    @Keep
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0015\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u000bJ\t\u0010\f\u001a\u00020\tH\u0095 R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/margelo/nitro/core/HybridObject$CxxPart;", "", "javaPart", "Lcom/margelo/nitro/core/HybridObject;", "<init>", "(Lcom/margelo/nitro/core/HybridObject;)V", "getJavaPart", "()Lcom/margelo/nitro/core/HybridObject;", "mHybridData", "Lcom/facebook/jni/HybridData;", "destroy", "", "initHybrid", "react-native-nitro-modules_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class CxxPart {

        @DoNotStrip
        @Keep
        private final HybridObject javaPart;

        @DoNotStrip
        @Keep
        private HybridData mHybridData;

        @FastNative
        protected native HybridData initHybrid();

        public CxxPart(HybridObject javaPart) {
            Intrinsics.checkNotNullParameter(javaPart, "javaPart");
            this.javaPart = javaPart;
            this.mHybridData = initHybrid();
        }

        public final HybridObject getJavaPart() {
            return this.javaPart;
        }

        public final void destroy() {
            this.mHybridData.resetNative();
        }
    }
}
