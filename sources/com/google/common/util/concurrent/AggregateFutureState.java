package com.google.common.util.concurrent;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import com.google.common.collect.Sets;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes3.dex */
abstract class AggregateFutureState extends AbstractFuture.TrustedFuture {
    private static final AtomicHelper ATOMIC_HELPER;
    private static final LazyLogger log = new LazyLogger(AggregateFutureState.class);
    volatile int remainingField;
    volatile Set seenExceptionsField = null;

    abstract void addInitialException(Set set);

    /* JADX WARN: Multi-variable type inference failed */
    static {
        AtomicHelper safeAtomicHelper;
        Throwable th = null;
        Object[] objArr = 0;
        try {
            safeAtomicHelper = new SafeAtomicHelper();
        } catch (Throwable th2) {
            SynchronizedAtomicHelper synchronizedAtomicHelper = new SynchronizedAtomicHelper();
            th = th2;
            safeAtomicHelper = synchronizedAtomicHelper;
        }
        ATOMIC_HELPER = safeAtomicHelper;
        if (th != null) {
            log.get().log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
    }

    AggregateFutureState(int i) {
        this.remainingField = i;
    }

    final Set getOrInitSeenExceptions() {
        Set set = this.seenExceptionsField;
        if (set != null) {
            return set;
        }
        Set setNewConcurrentHashSet = Sets.newConcurrentHashSet();
        addInitialException(setNewConcurrentHashSet);
        ATOMIC_HELPER.compareAndSetSeenExceptions(this, null, setNewConcurrentHashSet);
        Set set2 = this.seenExceptionsField;
        Objects.requireNonNull(set2);
        return set2;
    }

    final int decrementRemainingAndGet() {
        return ATOMIC_HELPER.decrementAndGetRemainingCount(this);
    }

    final void clearSeenExceptions() {
        this.seenExceptionsField = null;
    }

    private static abstract class AtomicHelper {
        abstract void compareAndSetSeenExceptions(AggregateFutureState aggregateFutureState, Set set, Set set2);

        abstract int decrementAndGetRemainingCount(AggregateFutureState aggregateFutureState);

        private AtomicHelper() {
        }
    }

    private static final class SafeAtomicHelper extends AtomicHelper {
        private static final AtomicReferenceFieldUpdater seenExceptionsUpdater = AtomicReferenceFieldUpdater.newUpdater(AggregateFutureState.class, Set.class, "seenExceptionsField");
        private static final AtomicIntegerFieldUpdater remainingCountUpdater = AtomicIntegerFieldUpdater.newUpdater(AggregateFutureState.class, "remainingField");

        private SafeAtomicHelper() {
            super();
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        void compareAndSetSeenExceptions(AggregateFutureState aggregateFutureState, Set set, Set set2) {
            AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(seenExceptionsUpdater, aggregateFutureState, set, set2);
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        int decrementAndGetRemainingCount(AggregateFutureState aggregateFutureState) {
            return remainingCountUpdater.decrementAndGet(aggregateFutureState);
        }
    }

    private static final class SynchronizedAtomicHelper extends AtomicHelper {
        private SynchronizedAtomicHelper() {
            super();
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        void compareAndSetSeenExceptions(AggregateFutureState aggregateFutureState, Set set, Set set2) {
            synchronized (aggregateFutureState) {
                try {
                    if (aggregateFutureState.seenExceptionsField == set) {
                        aggregateFutureState.seenExceptionsField = set2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        int decrementAndGetRemainingCount(AggregateFutureState aggregateFutureState) {
            int i;
            synchronized (aggregateFutureState) {
                i = aggregateFutureState.remainingField - 1;
                aggregateFutureState.remainingField = i;
            }
            return i;
        }
    }
}
