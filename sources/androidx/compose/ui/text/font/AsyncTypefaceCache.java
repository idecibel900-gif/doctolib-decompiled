package androidx.compose.ui.text.font;

import androidx.compose.ui.text.caches.LruCache;
import androidx.compose.ui.text.caches.SimpleArrayMap;
import androidx.compose.ui.text.platform.Synchronization_jvmKt;
import androidx.compose.ui.text.platform.SynchronizedObject;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class AsyncTypefaceCache {
    private final Object PermanentFailure = AsyncTypefaceResult.m2257constructorimpl(null);
    private final LruCache resultCache = new LruCache(16);
    private final SimpleArrayMap permanentCache = new SimpleArrayMap(0, 1, null);
    private final SynchronizedObject cacheLock = Synchronization_jvmKt.createSynchronizedObject();

    /* JADX INFO: renamed from: androidx.compose.ui.text.font.AsyncTypefaceCache$runCached$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return AsyncTypefaceCache.this.runCached(null, null, false, null, this);
        }
    }

    public static final class AsyncTypefaceResult {
        private final Object result;

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ AsyncTypefaceResult m2256boximpl(Object obj) {
            return new AsyncTypefaceResult(obj);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static Object m2257constructorimpl(Object obj) {
            return obj;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m2258equalsimpl(Object obj, Object obj2) {
            return (obj2 instanceof AsyncTypefaceResult) && Intrinsics.areEqual(obj, ((AsyncTypefaceResult) obj2).m2262unboximpl());
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m2259hashCodeimpl(Object obj) {
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        /* JADX INFO: renamed from: isPermanentFailure-impl, reason: not valid java name */
        public static final boolean m2260isPermanentFailureimpl(Object obj) {
            return obj == null;
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m2261toStringimpl(Object obj) {
            return "AsyncTypefaceResult(result=" + obj + ')';
        }

        public boolean equals(Object obj) {
            return m2258equalsimpl(this.result, obj);
        }

        public int hashCode() {
            return m2259hashCodeimpl(this.result);
        }

        public String toString() {
            return m2261toStringimpl(this.result);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ Object m2262unboximpl() {
            return this.result;
        }

        private /* synthetic */ AsyncTypefaceResult(Object obj) {
            this.result = obj;
        }
    }

    public static final class Key {
        private final Font font;
        private final Object loaderKey;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            return Intrinsics.areEqual(this.font, key.font) && Intrinsics.areEqual(this.loaderKey, key.loaderKey);
        }

        public int hashCode() {
            int iHashCode = this.font.hashCode() * 31;
            Object obj = this.loaderKey;
            return iHashCode + (obj == null ? 0 : obj.hashCode());
        }

        public String toString() {
            return "Key(font=" + this.font + ", loaderKey=" + this.loaderKey + ')';
        }

        public Key(Font font, Object obj) {
            this.font = font;
            this.loaderKey = obj;
        }
    }

    public static /* synthetic */ void put$default(AsyncTypefaceCache asyncTypefaceCache, Font font, PlatformFontLoader platformFontLoader, Object obj, boolean z, int i, Object obj2) {
        if ((i & 8) != 0) {
            z = false;
        }
        asyncTypefaceCache.put(font, platformFontLoader, obj, z);
    }

    public final void put(Font font, PlatformFontLoader platformFontLoader, Object obj, boolean z) {
        Key key = new Key(font, platformFontLoader.getCacheKey());
        synchronized (this.cacheLock) {
            try {
                if (obj == null) {
                } else if (z) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: get-1ASDuI8, reason: not valid java name */
    public final AsyncTypefaceResult m2255get1ASDuI8(Font font, PlatformFontLoader platformFontLoader) {
        AsyncTypefaceResult asyncTypefaceResult;
        Key key = new Key(font, platformFontLoader.getCacheKey());
        synchronized (this.cacheLock) {
            asyncTypefaceResult = (AsyncTypefaceResult) this.resultCache.get(key);
            if (asyncTypefaceResult == null) {
                asyncTypefaceResult = (AsyncTypefaceResult) this.permanentCache.get(key);
            }
        }
        return asyncTypefaceResult;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object runCached(Font font, PlatformFontLoader platformFontLoader, boolean z, Function1 function1, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        Key key;
        AsyncTypefaceCache asyncTypefaceCache;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                anonymousClass1.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Key key2 = new Key(font, platformFontLoader.getCacheKey());
            synchronized (this.cacheLock) {
                try {
                    AsyncTypefaceResult asyncTypefaceResult = (AsyncTypefaceResult) this.resultCache.get(key2);
                    if (asyncTypefaceResult == null) {
                        asyncTypefaceResult = (AsyncTypefaceResult) this.permanentCache.get(key2);
                    }
                    if (asyncTypefaceResult != null) {
                        return asyncTypefaceResult.m2262unboximpl();
                    }
                    Unit unit = Unit.INSTANCE;
                    anonymousClass1.L$0 = this;
                    anonymousClass1.L$1 = key2;
                    anonymousClass1.Z$0 = z;
                    anonymousClass1.label = 1;
                    Object objInvoke = function1.invoke(anonymousClass1);
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = objInvoke;
                    key = key2;
                    asyncTypefaceCache = this;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z = anonymousClass1.Z$0;
            key = (Key) anonymousClass1.L$1;
            asyncTypefaceCache = (AsyncTypefaceCache) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        synchronized (asyncTypefaceCache.cacheLock) {
            try {
                if (obj == null) {
                    asyncTypefaceCache.permanentCache.put(key, AsyncTypefaceResult.m2256boximpl(asyncTypefaceCache.PermanentFailure));
                } else if (z) {
                    asyncTypefaceCache.permanentCache.put(key, AsyncTypefaceResult.m2256boximpl(AsyncTypefaceResult.m2257constructorimpl(obj)));
                } else {
                    asyncTypefaceCache.resultCache.put(key, AsyncTypefaceResult.m2256boximpl(AsyncTypefaceResult.m2257constructorimpl(obj)));
                }
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return obj;
    }
}
