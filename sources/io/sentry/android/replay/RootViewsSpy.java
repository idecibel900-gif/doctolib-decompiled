package io.sentry.android.replay;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import io.sentry.ISentryLifecycleToken;
import io.sentry.util.AutoClosableReentrantLock;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class RootViewsSpy implements Closeable {
    private final ArrayList delegatingViewList;
    private final AtomicBoolean isClosed;
    private final CopyOnWriteArrayList listeners;
    private final AutoClosableReentrantLock viewListLock;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public /* synthetic */ RootViewsSpy(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private RootViewsSpy() {
        this.isClosed = new AtomicBoolean(false);
        this.viewListLock = new AutoClosableReentrantLock();
        this.listeners = new CopyOnWriteArrayList() { // from class: io.sentry.android.replay.RootViewsSpy$listeners$1
            public /* bridge */ boolean contains(OnRootViewsChangedListener onRootViewsChangedListener) {
                return super.contains((Object) onRootViewsChangedListener);
            }

            @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
            public final /* bridge */ boolean contains(Object obj) {
                if (obj == null ? true : obj instanceof OnRootViewsChangedListener) {
                    return contains((OnRootViewsChangedListener) obj);
                }
                return false;
            }

            public /* bridge */ int getSize() {
                return super.size();
            }

            public /* bridge */ int indexOf(OnRootViewsChangedListener onRootViewsChangedListener) {
                return super.indexOf((Object) onRootViewsChangedListener);
            }

            @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List
            public final /* bridge */ int indexOf(Object obj) {
                if (obj == null ? true : obj instanceof OnRootViewsChangedListener) {
                    return indexOf((OnRootViewsChangedListener) obj);
                }
                return -1;
            }

            public /* bridge */ int lastIndexOf(OnRootViewsChangedListener onRootViewsChangedListener) {
                return super.lastIndexOf((Object) onRootViewsChangedListener);
            }

            @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List
            public final /* bridge */ int lastIndexOf(Object obj) {
                if (obj == null ? true : obj instanceof OnRootViewsChangedListener) {
                    return lastIndexOf((OnRootViewsChangedListener) obj);
                }
                return -1;
            }

            public /* bridge */ boolean remove(OnRootViewsChangedListener onRootViewsChangedListener) {
                return super.remove((Object) onRootViewsChangedListener);
            }

            @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
            public final /* bridge */ boolean remove(Object obj) {
                if (obj == null ? true : obj instanceof OnRootViewsChangedListener) {
                    return remove((OnRootViewsChangedListener) obj);
                }
                return false;
            }

            @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
            public final /* bridge */ int size() {
                return getSize();
            }

            @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
            public boolean add(OnRootViewsChangedListener onRootViewsChangedListener) throws Exception {
                ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.this$0.viewListLock.acquire();
                try {
                    for (View view : this.this$0.delegatingViewList) {
                        if (onRootViewsChangedListener != null) {
                            onRootViewsChangedListener.onRootViewsChanged(view, true);
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire, null);
                    return super.add(onRootViewsChangedListener);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire, th);
                        throw th2;
                    }
                }
            }
        };
        this.delegatingViewList = new ArrayList() { // from class: io.sentry.android.replay.RootViewsSpy$delegatingViewList$1
            public /* bridge */ boolean contains(View view) {
                return super.contains((Object) view);
            }

            @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
            public final /* bridge */ boolean contains(Object obj) {
                if (obj instanceof View) {
                    return contains((View) obj);
                }
                return false;
            }

            public /* bridge */ int getSize() {
                return super.size();
            }

            public /* bridge */ int indexOf(View view) {
                return super.indexOf((Object) view);
            }

            @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
            public final /* bridge */ int indexOf(Object obj) {
                if (obj instanceof View) {
                    return indexOf((View) obj);
                }
                return -1;
            }

            public /* bridge */ int lastIndexOf(View view) {
                return super.lastIndexOf((Object) view);
            }

            @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
            public final /* bridge */ int lastIndexOf(Object obj) {
                if (obj instanceof View) {
                    return lastIndexOf((View) obj);
                }
                return -1;
            }

            @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
            public final /* bridge */ View remove(int i) {
                return removeAt(i);
            }

            public /* bridge */ boolean remove(View view) {
                return super.remove((Object) view);
            }

            @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
            public final /* bridge */ boolean remove(Object obj) {
                if (obj instanceof View) {
                    return remove((View) obj);
                }
                return false;
            }

            @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
            public final /* bridge */ int size() {
                return getSize();
            }

            @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
            public boolean addAll(Collection elements) {
                Intrinsics.checkNotNullParameter(elements, "elements");
                for (OnRootViewsChangedListener onRootViewsChangedListener : this.this$0.getListeners()) {
                    Iterator it = elements.iterator();
                    while (it.hasNext()) {
                        onRootViewsChangedListener.onRootViewsChanged((View) it.next(), true);
                    }
                }
                return super.addAll(elements);
            }

            @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
            public boolean add(View element) {
                Intrinsics.checkNotNullParameter(element, "element");
                Iterator it = this.this$0.getListeners().iterator();
                while (it.hasNext()) {
                    ((OnRootViewsChangedListener) it.next()).onRootViewsChanged(element, true);
                }
                return super.add(element);
            }

            public View removeAt(int i) {
                Object objRemove = super.remove(i);
                Intrinsics.checkNotNullExpressionValue(objRemove, "removeAt(...)");
                View view = (View) objRemove;
                Iterator it = this.this$0.getListeners().iterator();
                while (it.hasNext()) {
                    ((OnRootViewsChangedListener) it.next()).onRootViewsChanged(view, false);
                }
                return view;
            }
        };
    }

    public final CopyOnWriteArrayList getListeners() {
        return this.listeners;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.isClosed.set(true);
        this.listeners.clear();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RootViewsSpy install() {
            final RootViewsSpy rootViewsSpy = new RootViewsSpy(null);
            new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new Runnable() { // from class: io.sentry.android.replay.RootViewsSpy$Companion$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    RootViewsSpy.Companion.install$lambda$1$lambda$0(rootViewsSpy);
                }
            });
            return rootViewsSpy;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void install$lambda$1$lambda$0(final RootViewsSpy rootViewsSpy) {
            if (rootViewsSpy.isClosed.get()) {
                return;
            }
            WindowManagerSpy.INSTANCE.swapWindowManagerGlobalMViews(new Function1() { // from class: io.sentry.android.replay.RootViewsSpy$Companion$install$1$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final ArrayList invoke(ArrayList mViews) throws Exception {
                    Intrinsics.checkNotNullParameter(mViews, "mViews");
                    ISentryLifecycleToken iSentryLifecycleTokenAcquire = rootViewsSpy.viewListLock.acquire();
                    try {
                        ArrayList arrayList = rootViewsSpy.delegatingViewList;
                        arrayList.addAll(mViews);
                        AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire, null);
                        return arrayList;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire, th);
                            throw th2;
                        }
                    }
                }
            });
        }
    }
}
