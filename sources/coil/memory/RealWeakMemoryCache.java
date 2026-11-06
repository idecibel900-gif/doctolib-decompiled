package coil.memory;

import android.graphics.Bitmap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class RealWeakMemoryCache implements WeakMemoryCache {
    public static final Companion Companion = new Companion(null);
    private final LinkedHashMap cache = new LinkedHashMap();
    private int operationsSinceCleanUp;

    @Override // coil.memory.WeakMemoryCache
    public synchronized MemoryCache.Value get(MemoryCache.Key key) {
        try {
            ArrayList arrayList = (ArrayList) this.cache.get(key);
            MemoryCache.Value value = null;
            if (arrayList == null) {
                return null;
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                InternalValue internalValue = (InternalValue) arrayList.get(i);
                Bitmap bitmap = (Bitmap) internalValue.getBitmap().get();
                MemoryCache.Value value2 = bitmap != null ? new MemoryCache.Value(bitmap, internalValue.getExtras()) : null;
                if (value2 != null) {
                    value = value2;
                    break;
                }
            }
            cleanUpIfNecessary();
            return value;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // coil.memory.WeakMemoryCache
    public synchronized void set(MemoryCache.Key key, Bitmap bitmap, Map map, int i) {
        try {
            LinkedHashMap linkedHashMap = this.cache;
            Object arrayList = linkedHashMap.get(key);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(key, arrayList);
            }
            ArrayList arrayList2 = (ArrayList) arrayList;
            int iIdentityHashCode = System.identityHashCode(bitmap);
            InternalValue internalValue = new InternalValue(iIdentityHashCode, new WeakReference(bitmap), map, i);
            int size = arrayList2.size();
            int i2 = 0;
            while (true) {
                if (i2 < size) {
                    InternalValue internalValue2 = (InternalValue) arrayList2.get(i2);
                    if (i >= internalValue2.getSize()) {
                        if (internalValue2.getIdentityHashCode() == iIdentityHashCode && internalValue2.getBitmap().get() == bitmap) {
                            arrayList2.set(i2, internalValue);
                            break;
                        } else {
                            arrayList2.add(i2, internalValue);
                            break;
                        }
                    }
                    i2++;
                } else {
                    arrayList2.add(internalValue);
                    break;
                }
            }
            cleanUpIfNecessary();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // coil.memory.WeakMemoryCache
    public synchronized void trimMemory(int i) {
        if (i >= 10 && i != 20) {
            cleanUp$coil_base_release();
        }
    }

    private final void cleanUpIfNecessary() {
        int i = this.operationsSinceCleanUp;
        this.operationsSinceCleanUp = i + 1;
        if (i >= 10) {
            cleanUp$coil_base_release();
        }
    }

    public final void cleanUp$coil_base_release() {
        WeakReference bitmap;
        this.operationsSinceCleanUp = 0;
        Iterator it = this.cache.values().iterator();
        while (it.hasNext()) {
            ArrayList arrayList = (ArrayList) it.next();
            if (arrayList.size() > 1) {
                int size = arrayList.size();
                int i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    int i3 = i2 - i;
                    if (((InternalValue) arrayList.get(i3)).getBitmap().get() == null) {
                        arrayList.remove(i3);
                        i++;
                    }
                }
                if (arrayList.isEmpty()) {
                    it.remove();
                }
            } else {
                InternalValue internalValue = (InternalValue) CollectionsKt.firstOrNull((List) arrayList);
                if (((internalValue == null || (bitmap = internalValue.getBitmap()) == null) ? null : (Bitmap) bitmap.get()) == null) {
                    it.remove();
                }
            }
        }
    }

    public static final class InternalValue {
        private final WeakReference bitmap;
        private final Map extras;
        private final int identityHashCode;
        private final int size;

        public InternalValue(int i, WeakReference weakReference, Map map, int i2) {
            this.identityHashCode = i;
            this.bitmap = weakReference;
            this.extras = map;
            this.size = i2;
        }

        public final int getIdentityHashCode() {
            return this.identityHashCode;
        }

        public final WeakReference getBitmap() {
            return this.bitmap;
        }

        public final Map getExtras() {
            return this.extras;
        }

        public final int getSize() {
            return this.size;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
