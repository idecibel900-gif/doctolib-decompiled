package io.sentry;

import java.util.Queue;

/* JADX INFO: loaded from: classes5.dex */
final class SynchronizedQueue extends SynchronizedCollection implements Queue {
    static SynchronizedQueue synchronizedQueue(Queue queue) {
        return new SynchronizedQueue(queue);
    }

    private SynchronizedQueue(Queue queue) {
        super(queue);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.sentry.SynchronizedCollection
    public Queue decorated() {
        return (Queue) super.decorated();
    }

    @Override // java.util.Queue
    public Object element() {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            Object objElement = decorated().element();
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            return objElement;
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            boolean zEquals = decorated().equals(obj);
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            return zEquals;
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // java.util.Collection
    public int hashCode() {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            int iHashCode = decorated().hashCode();
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            return iHashCode;
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // java.util.Queue
    public boolean offer(Object obj) {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            boolean zOffer = decorated().offer(obj);
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            return zOffer;
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // java.util.Queue
    public Object peek() {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            Object objPeek = decorated().peek();
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            return objPeek;
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // java.util.Queue
    public Object poll() {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            Object objPoll = decorated().poll();
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            return objPoll;
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // java.util.Queue
    public Object remove() {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            Object objRemove = decorated().remove();
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            return objRemove;
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            Object[] array = decorated().toArray();
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            return array;
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] objArr) {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            Object[] array = decorated().toArray(objArr);
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            return array;
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
