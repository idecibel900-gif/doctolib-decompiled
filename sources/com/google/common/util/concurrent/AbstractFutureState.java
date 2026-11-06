package com.google.common.util.concurrent;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import com.amazon.a.a.o.b;
import com.amazon.a.a.o.b.f;
import com.google.android.gms.internal.play_billing.zzcp$$ExternalSyntheticBackportWithForwarding0;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
abstract class AbstractFutureState extends InternalFutureFailureAccess implements ListenableFuture {
    private static final AtomicHelper ATOMIC_HELPER;
    static final boolean GENERATE_CANCELLATION_CAUSES;
    static final Object NULL = new Object();
    static final LazyLogger log = new LazyLogger(AbstractFuture.class);
    volatile AbstractFuture.Listener listenersField;
    volatile Object valueField;
    volatile Waiter waitersField;

    final boolean casListeners(AbstractFuture.Listener listener, AbstractFuture.Listener listener2) {
        return ATOMIC_HELPER.casListeners(this, listener, listener2);
    }

    final AbstractFuture.Listener gasListeners(AbstractFuture.Listener listener) {
        return ATOMIC_HELPER.gasListeners(this, listener);
    }

    static boolean casValue(AbstractFutureState abstractFutureState, Object obj, Object obj2) {
        return ATOMIC_HELPER.casValue(abstractFutureState, obj, obj2);
    }

    final Object value() {
        return this.valueField;
    }

    final AbstractFuture.Listener listeners() {
        return this.listenersField;
    }

    final void releaseWaiters() {
        for (Waiter waiterGasWaiters = gasWaiters(Waiter.TOMBSTONE); waiterGasWaiters != null; waiterGasWaiters = waiterGasWaiters.next) {
            waiterGasWaiters.unpark();
        }
    }

    final Object blockingGet(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.valueField;
        if ((obj != null) & AbstractFuture.notInstanceOfDelegatingToFuture(obj)) {
            return AbstractFuture.getDoneValue(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            Waiter waiter = this.waitersField;
            if (waiter != Waiter.TOMBSTONE) {
                Waiter waiter2 = new Waiter();
                while (true) {
                    waiter2.setNext(waiter);
                    if (casWaiters(waiter, waiter2)) {
                        do {
                            OverflowAvoidingLockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                removeWaiter(waiter2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.valueField;
                            if ((obj2 != null) & AbstractFuture.notInstanceOfDelegatingToFuture(obj2)) {
                                return AbstractFuture.getDoneValue(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        removeWaiter(waiter2);
                        break;
                    }
                    waiter = this.waitersField;
                    if (waiter == Waiter.TOMBSTONE) {
                    }
                }
            }
            Object obj3 = this.valueField;
            Objects.requireNonNull(obj3);
            return AbstractFuture.getDoneValue(obj3);
        }
        while (nanos > 0) {
            Object obj4 = this.valueField;
            if ((obj4 != null) & AbstractFuture.notInstanceOfDelegatingToFuture(obj4)) {
                return AbstractFuture.getDoneValue(obj4);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        String str = "Waited " + j + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String str2 = str + " (plus ";
            long j2 = -nanos;
            long jConvert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
            long nanos2 = j2 - timeUnit.toNanos(jConvert);
            boolean z = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String str3 = str2 + jConvert + " " + lowerCase;
                if (z) {
                    str3 = str3 + f.a;
                }
                str2 = str3 + " ";
            }
            if (z) {
                str2 = str2 + nanos2 + " nanoseconds ";
            }
            str = str2 + "delay)";
        }
        if (isDone()) {
            throw new TimeoutException(str + " but future completed as timeout expired");
        }
        throw new TimeoutException(str + " for " + string);
    }

    final Object blockingGet() throws InterruptedException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.valueField;
        if ((obj2 != null) & AbstractFuture.notInstanceOfDelegatingToFuture(obj2)) {
            return AbstractFuture.getDoneValue(obj2);
        }
        Waiter waiter = this.waitersField;
        if (waiter != Waiter.TOMBSTONE) {
            Waiter waiter2 = new Waiter();
            do {
                waiter2.setNext(waiter);
                if (casWaiters(waiter, waiter2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            removeWaiter(waiter2);
                            throw new InterruptedException();
                        }
                        obj = this.valueField;
                    } while (!((obj != null) & AbstractFuture.notInstanceOfDelegatingToFuture(obj)));
                    return AbstractFuture.getDoneValue(obj);
                }
                waiter = this.waitersField;
            } while (waiter != Waiter.TOMBSTONE);
        }
        Object obj3 = this.valueField;
        Objects.requireNonNull(obj3);
        return AbstractFuture.getDoneValue(obj3);
    }

    AbstractFutureState() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.util.logging.Logger] */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.common.util.concurrent.AbstractFutureState$1] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    static {
        boolean z;
        AtomicHelper atomicReferenceFieldUpdaterAtomicHelper;
        Throwable th;
        AtomicHelper unsafeAtomicHelper;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", b.ag));
        } catch (SecurityException unused) {
            z = false;
        }
        GENERATE_CANCELLATION_CAUSES = z;
        ?? r1 = 0;
        ?? r2 = 0;
        if (mightBeAndroid()) {
            try {
                unsafeAtomicHelper = new UnsafeAtomicHelper();
            } catch (Error | Exception e) {
                try {
                    atomicReferenceFieldUpdaterAtomicHelper = new AtomicReferenceFieldUpdaterAtomicHelper();
                } catch (Error | Exception e2) {
                    SynchronizedHelper synchronizedHelper = new SynchronizedHelper();
                    r1 = e2;
                    atomicReferenceFieldUpdaterAtomicHelper = synchronizedHelper;
                }
                AtomicHelper atomicHelper = atomicReferenceFieldUpdaterAtomicHelper;
                th = e;
                unsafeAtomicHelper = atomicHelper;
                r2 = r1;
            }
        } else {
            try {
                unsafeAtomicHelper = new AtomicReferenceFieldUpdaterAtomicHelper();
            } catch (NoClassDefFoundError unused2) {
                unsafeAtomicHelper = new SynchronizedHelper();
            }
        }
        th = null;
        ATOMIC_HELPER = unsafeAtomicHelper;
        if (r2 != 0) {
            LazyLogger lazyLogger = log;
            Logger logger = lazyLogger.get();
            Level level = Level.SEVERE;
            logger.log(level, "UnsafeAtomicHelper is broken!", th);
            lazyLogger.get().log(level, "AtomicReferenceFieldUpdaterAtomicHelper is broken!", r2);
        }
    }

    static final class Waiter {
        static final Waiter TOMBSTONE = new Waiter(false);
        volatile Waiter next;
        volatile Thread thread;

        Waiter(boolean z) {
        }

        Waiter() {
            AbstractFutureState.putThread(this, Thread.currentThread());
        }

        void setNext(Waiter waiter) {
            AbstractFutureState.putNext(this, waiter);
        }

        void unpark() {
            Thread thread = this.thread;
            if (thread != null) {
                this.thread = null;
                LockSupport.unpark(thread);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void putThread(Waiter waiter, Thread thread) {
        ATOMIC_HELPER.putThread(waiter, thread);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void putNext(Waiter waiter, Waiter waiter2) {
        ATOMIC_HELPER.putNext(waiter, waiter2);
    }

    private boolean casWaiters(Waiter waiter, Waiter waiter2) {
        return ATOMIC_HELPER.casWaiters(this, waiter, waiter2);
    }

    private final Waiter gasWaiters(Waiter waiter) {
        return ATOMIC_HELPER.gasWaiters(this, waiter);
    }

    private void removeWaiter(Waiter waiter) {
        waiter.thread = null;
        while (true) {
            Waiter waiter2 = this.waitersField;
            if (waiter2 == Waiter.TOMBSTONE) {
                return;
            }
            Waiter waiter3 = null;
            while (waiter2 != null) {
                Waiter waiter4 = waiter2.next;
                if (waiter2.thread != null) {
                    waiter3 = waiter2;
                } else if (waiter3 != null) {
                    waiter3.next = waiter4;
                    if (waiter3.thread == null) {
                    }
                } else if (!casWaiters(waiter2, waiter4)) {
                }
                waiter2 = waiter4;
            }
            return;
        }
    }

    private static abstract class AtomicHelper {
        abstract boolean casListeners(AbstractFutureState abstractFutureState, AbstractFuture.Listener listener, AbstractFuture.Listener listener2);

        abstract boolean casValue(AbstractFutureState abstractFutureState, Object obj, Object obj2);

        abstract boolean casWaiters(AbstractFutureState abstractFutureState, Waiter waiter, Waiter waiter2);

        abstract AbstractFuture.Listener gasListeners(AbstractFutureState abstractFutureState, AbstractFuture.Listener listener);

        abstract Waiter gasWaiters(AbstractFutureState abstractFutureState, Waiter waiter);

        abstract void putNext(Waiter waiter, Waiter waiter2);

        abstract void putThread(Waiter waiter, Thread thread);

        private AtomicHelper() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class UnsafeAtomicHelper extends AtomicHelper {
        static final long LISTENERS_OFFSET;
        static final Unsafe UNSAFE;
        static final long VALUE_OFFSET;
        static final long WAITERS_OFFSET;
        static final long WAITER_NEXT_OFFSET;
        static final long WAITER_THREAD_OFFSET;

        private UnsafeAtomicHelper() {
            super();
        }

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (PrivilegedActionException e) {
                    throw new RuntimeException("Could not initialize intrinsics", e.getCause());
                }
            } catch (SecurityException unused) {
                unsafe = (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction() { // from class: com.google.common.util.concurrent.AbstractFutureState$UnsafeAtomicHelper$$ExternalSyntheticLambda0
                    @Override // java.security.PrivilegedExceptionAction
                    public final Object run() {
                        return AbstractFutureState.UnsafeAtomicHelper.lambda$static$0();
                    }
                });
            }
            try {
                WAITERS_OFFSET = unsafe.objectFieldOffset(AbstractFutureState.class.getDeclaredField("waitersField"));
                LISTENERS_OFFSET = unsafe.objectFieldOffset(AbstractFutureState.class.getDeclaredField("listenersField"));
                VALUE_OFFSET = unsafe.objectFieldOffset(AbstractFutureState.class.getDeclaredField("valueField"));
                WAITER_THREAD_OFFSET = unsafe.objectFieldOffset(Waiter.class.getDeclaredField("thread"));
                WAITER_NEXT_OFFSET = unsafe.objectFieldOffset(Waiter.class.getDeclaredField("next"));
                UNSAFE = unsafe;
            } catch (NoSuchFieldException e2) {
                throw new RuntimeException(e2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Unsafe lambda$static$0() throws IllegalAccessException {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            throw new NoSuchFieldError("the Unsafe");
        }

        @Override // com.google.common.util.concurrent.AbstractFutureState.AtomicHelper
        void putThread(Waiter waiter, Thread thread) {
            UNSAFE.putObject(waiter, WAITER_THREAD_OFFSET, thread);
        }

        @Override // com.google.common.util.concurrent.AbstractFutureState.AtomicHelper
        void putNext(Waiter waiter, Waiter waiter2) {
            UNSAFE.putObject(waiter, WAITER_NEXT_OFFSET, waiter2);
        }

        @Override // com.google.common.util.concurrent.AbstractFutureState.AtomicHelper
        boolean casWaiters(AbstractFutureState abstractFutureState, Waiter waiter, Waiter waiter2) {
            return zzcp$$ExternalSyntheticBackportWithForwarding0.m(UNSAFE, abstractFutureState, WAITERS_OFFSET, waiter, waiter2);
        }

        @Override // com.google.common.util.concurrent.AbstractFutureState.AtomicHelper
        boolean casListeners(AbstractFutureState abstractFutureState, AbstractFuture.Listener listener, AbstractFuture.Listener listener2) {
            return zzcp$$ExternalSyntheticBackportWithForwarding0.m(UNSAFE, abstractFutureState, LISTENERS_OFFSET, listener, listener2);
        }

        @Override // com.google.common.util.concurrent.AbstractFutureState.AtomicHelper
        AbstractFuture.Listener gasListeners(AbstractFutureState abstractFutureState, AbstractFuture.Listener listener) {
            AbstractFuture.Listener listener2;
            do {
                listener2 = abstractFutureState.listenersField;
                if (listener == listener2) {
                    break;
                }
            } while (!casListeners(abstractFutureState, listener2, listener));
            return listener2;
        }

        @Override // com.google.common.util.concurrent.AbstractFutureState.AtomicHelper
        Waiter gasWaiters(AbstractFutureState abstractFutureState, Waiter waiter) {
            Waiter waiter2;
            do {
                waiter2 = abstractFutureState.waitersField;
                if (waiter == waiter2) {
                    break;
                }
            } while (!casWaiters(abstractFutureState, waiter2, waiter));
            return waiter2;
        }

        @Override // com.google.common.util.concurrent.AbstractFutureState.AtomicHelper
        boolean casValue(AbstractFutureState abstractFutureState, Object obj, Object obj2) {
            return zzcp$$ExternalSyntheticBackportWithForwarding0.m(UNSAFE, abstractFutureState, VALUE_OFFSET, obj, obj2);
        }
    }

    private static final class AtomicReferenceFieldUpdaterAtomicHelper extends AtomicHelper {
        private static final AtomicReferenceFieldUpdater waiterThreadUpdater = AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Thread.class, "thread");
        private static final AtomicReferenceFieldUpdater waiterNextUpdater = AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Waiter.class, "next");
        private static final AtomicReferenceFieldUpdater waitersUpdater = AtomicReferenceFieldUpdater.newUpdater(AbstractFutureState.class, Waiter.class, "waitersField");
        private static final AtomicReferenceFieldUpdater listenersUpdater = AtomicReferenceFieldUpdater.newUpdater(AbstractFutureState.class, AbstractFuture.Listener.class, "listenersField");
        private static final AtomicReferenceFieldUpdater valueUpdater = AtomicReferenceFieldUpdater.newUpdater(AbstractFutureState.class, Object.class, "valueField");

        private AtomicReferenceFieldUpdaterAtomicHelper() {
            super();
        }

        @Override // com.google.common.util.concurrent.AbstractFutureState.AtomicHelper
        void putThread(Waiter waiter, Thread thread) {
            waiterThreadUpdater.lazySet(waiter, thread);
        }

        @Override // com.google.common.util.concurrent.AbstractFutureState.AtomicHelper
        void putNext(Waiter waiter, Waiter waiter2) {
            waiterNextUpdater.lazySet(waiter, waiter2);
        }

        @Override // com.google.common.util.concurrent.AbstractFutureState.AtomicHelper
        boolean casWaiters(AbstractFutureState abstractFutureState, Waiter waiter, Waiter waiter2) {
            return AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(waitersUpdater, abstractFutureState, waiter, waiter2);
        }

        @Override // com.google.common.util.concurrent.AbstractFutureState.AtomicHelper
        boolean casListeners(AbstractFutureState abstractFutureState, AbstractFuture.Listener listener, AbstractFuture.Listener listener2) {
            return AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(listenersUpdater, abstractFutureState, listener, listener2);
        }

        @Override // com.google.common.util.concurrent.AbstractFutureState.AtomicHelper
        AbstractFuture.Listener gasListeners(AbstractFutureState abstractFutureState, AbstractFuture.Listener listener) {
            return (AbstractFuture.Listener) listenersUpdater.getAndSet(abstractFutureState, listener);
        }

        @Override // com.google.common.util.concurrent.AbstractFutureState.AtomicHelper
        Waiter gasWaiters(AbstractFutureState abstractFutureState, Waiter waiter) {
            return (Waiter) waitersUpdater.getAndSet(abstractFutureState, waiter);
        }

        @Override // com.google.common.util.concurrent.AbstractFutureState.AtomicHelper
        boolean casValue(AbstractFutureState abstractFutureState, Object obj, Object obj2) {
            return AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(valueUpdater, abstractFutureState, obj, obj2);
        }
    }

    private static final class SynchronizedHelper extends AtomicHelper {
        private SynchronizedHelper() {
            super();
        }

        @Override // com.google.common.util.concurrent.AbstractFutureState.AtomicHelper
        void putThread(Waiter waiter, Thread thread) {
            waiter.thread = thread;
        }

        @Override // com.google.common.util.concurrent.AbstractFutureState.AtomicHelper
        void putNext(Waiter waiter, Waiter waiter2) {
            waiter.next = waiter2;
        }

        @Override // com.google.common.util.concurrent.AbstractFutureState.AtomicHelper
        boolean casWaiters(AbstractFutureState abstractFutureState, Waiter waiter, Waiter waiter2) {
            synchronized (abstractFutureState) {
                try {
                    if (abstractFutureState.waitersField != waiter) {
                        return false;
                    }
                    abstractFutureState.waitersField = waiter2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFutureState.AtomicHelper
        boolean casListeners(AbstractFutureState abstractFutureState, AbstractFuture.Listener listener, AbstractFuture.Listener listener2) {
            synchronized (abstractFutureState) {
                try {
                    if (abstractFutureState.listenersField != listener) {
                        return false;
                    }
                    abstractFutureState.listenersField = listener2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFutureState.AtomicHelper
        AbstractFuture.Listener gasListeners(AbstractFutureState abstractFutureState, AbstractFuture.Listener listener) {
            AbstractFuture.Listener listener2;
            synchronized (abstractFutureState) {
                try {
                    listener2 = abstractFutureState.listenersField;
                    if (listener2 != listener) {
                        abstractFutureState.listenersField = listener;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return listener2;
        }

        @Override // com.google.common.util.concurrent.AbstractFutureState.AtomicHelper
        Waiter gasWaiters(AbstractFutureState abstractFutureState, Waiter waiter) {
            Waiter waiter2;
            synchronized (abstractFutureState) {
                try {
                    waiter2 = abstractFutureState.waitersField;
                    if (waiter2 != waiter) {
                        abstractFutureState.waitersField = waiter;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return waiter2;
        }

        @Override // com.google.common.util.concurrent.AbstractFutureState.AtomicHelper
        boolean casValue(AbstractFutureState abstractFutureState, Object obj, Object obj2) {
            synchronized (abstractFutureState) {
                try {
                    if (abstractFutureState.valueField != obj) {
                        return false;
                    }
                    abstractFutureState.valueField = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private static boolean mightBeAndroid() {
        String property = System.getProperty("java.runtime.name", "");
        return property == null || property.contains("Android");
    }
}
