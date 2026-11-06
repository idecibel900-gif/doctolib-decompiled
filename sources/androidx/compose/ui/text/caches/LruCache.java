package androidx.compose.ui.text.caches;

import androidx.compose.ui.text.platform.Synchronization_jvmKt;
import androidx.compose.ui.text.platform.SynchronizedObject;
import java.util.HashMap;
import java.util.LinkedHashSet;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes.dex */
public class LruCache {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final LinkedHashSet keySet;
    private final HashMap map;
    private int maxSize;
    private int missCount;
    private final SynchronizedObject monitor = Synchronization_jvmKt.createSynchronizedObject();
    private int putCount;
    private int size;

    protected Object create(Object obj) {
        return null;
    }

    protected void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
    }

    protected int sizeOf(Object obj, Object obj2) {
        return 1;
    }

    public LruCache(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.maxSize = i;
        this.map = new HashMap(0, 0.75f);
        this.keySet = new LinkedHashSet();
    }

    public final Object get(Object obj) {
        synchronized (this.monitor) {
            Object obj2 = this.map.get(obj);
            if (obj2 != null) {
                this.keySet.remove(obj);
                this.keySet.add(obj);
                this.hitCount++;
                return obj2;
            }
            this.missCount++;
            Object objCreate = create(obj);
            if (objCreate == null) {
                return null;
            }
            synchronized (this.monitor) {
                try {
                    this.createCount++;
                    Object objPut = this.map.put(obj, objCreate);
                    this.keySet.remove(obj);
                    this.keySet.add(obj);
                    if (objPut != null) {
                        this.map.put(obj, objPut);
                        obj2 = objPut;
                    } else {
                        this.size = size() + safeSizeOf(obj, objCreate);
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (obj2 != null) {
                entryRemoved(false, obj, objCreate, obj2);
                return obj2;
            }
            trimToSize(this.maxSize);
            return objCreate;
        }
    }

    public final Object put(Object obj, Object obj2) {
        Object objPut;
        if (obj == null || obj2 == null) {
            throw null;
        }
        synchronized (this.monitor) {
            try {
                this.putCount++;
                this.size = size() + safeSizeOf(obj, obj2);
                objPut = this.map.put(obj, obj2);
                if (objPut != null) {
                    this.size = size() - safeSizeOf(obj, objPut);
                }
                if (this.keySet.contains(obj)) {
                    this.keySet.remove(obj);
                }
                this.keySet.add(obj);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (objPut != null) {
            entryRemoved(false, obj, objPut, obj2);
        }
        trimToSize(this.maxSize);
        return objPut;
    }

    public void trimToSize(int i) {
        Object objFirst;
        Object obj;
        while (true) {
            synchronized (this.monitor) {
                try {
                    if (size() >= 0 && (!this.map.isEmpty() || size() == 0)) {
                        if (this.map.isEmpty() != this.keySet.isEmpty()) {
                            break;
                        }
                        if (size() <= i || this.map.isEmpty()) {
                            objFirst = null;
                            obj = null;
                        } else {
                            objFirst = CollectionsKt.first(this.keySet);
                            obj = this.map.get(objFirst);
                            if (obj == null) {
                                throw new IllegalStateException("inconsistent state");
                            }
                            TypeIntrinsics.asMutableMap(this.map).remove(objFirst);
                            TypeIntrinsics.asMutableCollection(this.keySet).remove(objFirst);
                            int size = size();
                            Intrinsics.checkNotNull(objFirst);
                            Intrinsics.checkNotNull(obj);
                            this.size = size - safeSizeOf(objFirst, obj);
                            this.evictionCount++;
                        }
                        Unit unit = Unit.INSTANCE;
                    } else {
                        break;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (objFirst == null && obj == null) {
                return;
            }
            Intrinsics.checkNotNull(objFirst);
            Intrinsics.checkNotNull(obj);
            entryRemoved(true, objFirst, obj, null);
        }
        throw new IllegalStateException("map/keySet size inconsistency");
    }

    public final Object remove(Object obj) {
        Object objRemove;
        obj.getClass();
        synchronized (this.monitor) {
            try {
                objRemove = this.map.remove(obj);
                this.keySet.remove(obj);
                if (objRemove != null) {
                    this.size = size() - safeSizeOf(obj, objRemove);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (objRemove != null) {
            entryRemoved(false, obj, objRemove, null);
        }
        return objRemove;
    }

    private final int safeSizeOf(Object obj, Object obj2) {
        int iSizeOf = sizeOf(obj, obj2);
        if (iSizeOf >= 0) {
            return iSizeOf;
        }
        throw new IllegalStateException(("Negative size: " + obj + '=' + obj2).toString());
    }

    public String toString() {
        String str;
        synchronized (this.monitor) {
            try {
                int i = this.hitCount;
                int i2 = this.missCount + i;
                str = "LruCache[maxSize=" + this.maxSize + ",hits=" + this.hitCount + ",misses=" + this.missCount + ",hitRate=" + (i2 != 0 ? (i * 100) / i2 : 0) + "%]";
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    public final int size() {
        int i;
        synchronized (this.monitor) {
            i = this.size;
        }
        return i;
    }
}
