package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes3.dex */
abstract class AggregateFuture extends AggregateFutureState {
    private static final LazyLogger logger = new LazyLogger(AggregateFuture.class);
    private final boolean allMustSucceed;
    private final boolean collectsValues;
    private ImmutableCollection futures;

    enum ReleaseResourcesReason {
        OUTPUT_FUTURE_DONE,
        ALL_INPUT_FUTURES_PROCESSED
    }

    abstract void collectOneValue(int i, Object obj);

    abstract void handleAllCompleted();

    AggregateFuture(ImmutableCollection immutableCollection, boolean z, boolean z2) {
        super(immutableCollection.size());
        this.futures = (ImmutableCollection) Preconditions.checkNotNull(immutableCollection);
        this.allMustSucceed = z;
        this.collectsValues = z2;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    protected final void afterDone() {
        super.afterDone();
        ImmutableCollection immutableCollection = this.futures;
        releaseResources(ReleaseResourcesReason.OUTPUT_FUTURE_DONE);
        if (isCancelled() && (immutableCollection != null)) {
            boolean zWasInterrupted = wasInterrupted();
            UnmodifiableIterator it = immutableCollection.iterator();
            while (it.hasNext()) {
                ((Future) it.next()).cancel(zWasInterrupted);
            }
        }
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    protected final String pendingToString() {
        ImmutableCollection immutableCollection = this.futures;
        if (immutableCollection != null) {
            return "futures=" + immutableCollection;
        }
        return super.pendingToString();
    }

    final void init() {
        Objects.requireNonNull(this.futures);
        if (this.futures.isEmpty()) {
            handleAllCompleted();
            return;
        }
        if (this.allMustSucceed) {
            UnmodifiableIterator it = this.futures.iterator();
            final int i = 0;
            while (it.hasNext()) {
                final ListenableFuture listenableFuture = (ListenableFuture) it.next();
                int i2 = i + 1;
                if (listenableFuture.isDone()) {
                    processAllMustSucceedDoneFuture(i, listenableFuture);
                } else {
                    listenableFuture.addListener(new Runnable() { // from class: com.google.common.util.concurrent.AggregateFuture$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.processAllMustSucceedDoneFuture(i, listenableFuture);
                        }
                    }, MoreExecutors.directExecutor());
                }
                i = i2;
            }
            return;
        }
        ImmutableCollection immutableCollection = this.futures;
        final ImmutableCollection immutableCollection2 = this.collectsValues ? immutableCollection : null;
        Runnable runnable = new Runnable() { // from class: com.google.common.util.concurrent.AggregateFuture$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.decrementCountAndMaybeComplete(immutableCollection2);
            }
        };
        UnmodifiableIterator it2 = immutableCollection.iterator();
        while (it2.hasNext()) {
            ListenableFuture listenableFuture2 = (ListenableFuture) it2.next();
            if (listenableFuture2.isDone()) {
                decrementCountAndMaybeComplete(immutableCollection2);
            } else {
                listenableFuture2.addListener(runnable, MoreExecutors.directExecutor());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processAllMustSucceedDoneFuture(int i, ListenableFuture listenableFuture) {
        try {
            if (listenableFuture.isCancelled()) {
                this.futures = null;
                cancel(false);
            } else {
                collectValueFromNonCancelledFuture(i, listenableFuture);
            }
        } finally {
            decrementCountAndMaybeComplete(null);
        }
    }

    private void handleException(Throwable th) {
        Preconditions.checkNotNull(th);
        if (this.allMustSucceed && !setException(th) && addCausalChain(getOrInitSeenExceptions(), th)) {
            log(th);
        } else if (th instanceof Error) {
            log(th);
        }
    }

    private static void log(Throwable th) {
        String str;
        if (th instanceof Error) {
            str = "Input Future failed with Error";
        } else {
            str = "Got more than one input Future failure. Logging failures after the first";
        }
        logger.get().log(Level.SEVERE, str, th);
    }

    @Override // com.google.common.util.concurrent.AggregateFutureState
    final void addInitialException(Set set) {
        Preconditions.checkNotNull(set);
        if (isCancelled()) {
            return;
        }
        Throwable thTryInternalFastPathGetFailure = tryInternalFastPathGetFailure();
        Objects.requireNonNull(thTryInternalFastPathGetFailure);
        addCausalChain(set, thTryInternalFastPathGetFailure);
    }

    private void collectValueFromNonCancelledFuture(int i, Future future) {
        try {
            collectOneValue(i, Uninterruptibles.getUninterruptibly(future));
        } catch (ExecutionException e) {
            handleException(e.getCause());
        } catch (Throwable th) {
            handleException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void decrementCountAndMaybeComplete(ImmutableCollection immutableCollection) {
        int iDecrementRemainingAndGet = decrementRemainingAndGet();
        Preconditions.checkState(iDecrementRemainingAndGet >= 0, "Less than 0 remaining futures");
        if (iDecrementRemainingAndGet == 0) {
            processCompleted(immutableCollection);
        }
    }

    private void processCompleted(ImmutableCollection immutableCollection) {
        if (immutableCollection != null) {
            UnmodifiableIterator it = immutableCollection.iterator();
            int i = 0;
            while (it.hasNext()) {
                Future future = (Future) it.next();
                if (!future.isCancelled()) {
                    collectValueFromNonCancelledFuture(i, future);
                }
                i++;
            }
        }
        clearSeenExceptions();
        handleAllCompleted();
        releaseResources(ReleaseResourcesReason.ALL_INPUT_FUTURES_PROCESSED);
    }

    void releaseResources(ReleaseResourcesReason releaseResourcesReason) {
        Preconditions.checkNotNull(releaseResourcesReason);
        this.futures = null;
    }

    private static boolean addCausalChain(Set set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }
}
