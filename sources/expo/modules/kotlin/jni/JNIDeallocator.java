package expo.modules.kotlin.jni;

import com.facebook.jni.HybridData;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\u001fB\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\t\u001a\u00020\b*\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R&\u0010\u001a\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0018\u0012\u0004\u0012\u00020\u00190\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001d\u001a\b\u0018\u00010\u001cR\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lexpo/modules/kotlin/jni/JNIDeallocator;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "", "shouldCreateDestructorThread", "<init>", "(Z)V", "Ljava/lang/Thread;", "", "deallocator", "(Ljava/lang/Thread;)V", "Lexpo/modules/kotlin/jni/Destructible;", "destructible", "addReference", "(Lexpo/modules/kotlin/jni/Destructible;)V", "deallocate$expo_modules_core_release", "()Lkotlin/Unit;", "deallocate", "close", "()V", "Ljava/lang/ref/ReferenceQueue;", "referenceQueue", "Ljava/lang/ref/ReferenceQueue;", "", "Ljava/lang/ref/PhantomReference;", "Lcom/facebook/jni/HybridData;", "destructorMap", "Ljava/util/Map;", "Lexpo/modules/kotlin/jni/JNIDeallocator$DeallocatorThread;", "destructorThread", "Lexpo/modules/kotlin/jni/JNIDeallocator$DeallocatorThread;", "DeallocatorThread", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JNIDeallocator implements AutoCloseable {
    private final Map destructorMap;
    private final DeallocatorThread destructorThread;
    private final ReferenceQueue referenceQueue;

    public JNIDeallocator() {
        this(false, 1, null);
    }

    private final class DeallocatorThread extends Thread {
        public DeallocatorThread() {
            super("Expo JNI deallocator");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            JNIDeallocator.this.deallocator(this);
        }
    }

    public JNIDeallocator(boolean z) {
        DeallocatorThread deallocatorThread;
        this.referenceQueue = new ReferenceQueue();
        this.destructorMap = new LinkedHashMap();
        if (z) {
            deallocatorThread = new DeallocatorThread();
            deallocatorThread.start();
        } else {
            deallocatorThread = null;
        }
        this.destructorThread = deallocatorThread;
    }

    public /* synthetic */ JNIDeallocator(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z);
    }

    public final void addReference(Destructible destructible) {
        Intrinsics.checkNotNullParameter(destructible, "destructible");
        synchronized (this) {
            this.destructorMap.put(new PhantomReference(destructible, this.referenceQueue), destructible.getMHybridData());
            Unit unit = Unit.INSTANCE;
        }
    }

    public final Unit deallocate$expo_modules_core_release() {
        Unit unit;
        synchronized (this) {
            try {
                Iterator it = this.destructorMap.values().iterator();
                while (it.hasNext()) {
                    ((HybridData) it.next()).resetNative();
                }
                this.destructorMap.clear();
                DeallocatorThread deallocatorThread = this.destructorThread;
                if (deallocatorThread != null) {
                    deallocatorThread.interrupt();
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return unit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void deallocator(Thread thread) {
        while (!thread.isInterrupted()) {
            try {
                Reference referenceRemove = this.referenceQueue.remove();
                HybridData hybridData = (HybridData) this.destructorMap.get(referenceRemove);
                if (hybridData != null) {
                    hybridData.resetNative();
                }
                synchronized (this) {
                    try {
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (InterruptedException unused) {
                return;
            }
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        deallocate$expo_modules_core_release();
    }
}
