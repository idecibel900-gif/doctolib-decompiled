package io.sentry;

import io.sentry.util.AutoClosableReentrantLock;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
abstract class SynchronizedCollection implements Collection, Serializable {
    private final Collection collection;
    final AutoClosableReentrantLock lock;

    SynchronizedCollection(Collection collection) {
        if (collection == null) {
            throw new NullPointerException("Collection must not be null.");
        }
        this.collection = collection;
        this.lock = new AutoClosableReentrantLock();
    }

    protected Collection decorated() {
        return this.collection;
    }

    @Override // java.util.Collection
    public boolean add(Object obj) {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            boolean zAdd = decorated().add(obj);
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            return zAdd;
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
    public boolean addAll(Collection collection) {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            boolean zAddAll = decorated().addAll(collection);
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            return zAddAll;
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
    public void clear() {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            decorated().clear();
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
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
    public boolean contains(Object obj) {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            boolean zContains = decorated().contains(obj);
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            return zContains;
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
    public boolean containsAll(Collection collection) {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            boolean zContainsAll = decorated().containsAll(collection);
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            return zContainsAll;
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
    public boolean isEmpty() {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            boolean zIsEmpty = decorated().isEmpty();
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            return zIsEmpty;
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

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return decorated().iterator();
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            boolean zRemove = decorated().remove(obj);
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            return zRemove;
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
    public boolean removeAll(Collection collection) {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            boolean zRemoveAll = decorated().removeAll(collection);
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            return zRemoveAll;
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
    public boolean retainAll(Collection collection) {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            boolean zRetainAll = decorated().retainAll(collection);
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            return zRetainAll;
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
    public int size() {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            int size = decorated().size();
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            return size;
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

    public String toString() {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            String string = decorated().toString();
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            return string;
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
