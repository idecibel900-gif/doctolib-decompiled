package com.swmansion.rnscreens.utils;

import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
final class CacheEntry {
    public static final Companion Companion = new Companion(null);
    private static final CacheEntry EMPTY = new CacheEntry(new CacheKey(LinearLayoutManager.INVALID_OFFSET, false), 0.0f);
    private final CacheKey cacheKey;
    private final float headerHeight;

    public CacheEntry(CacheKey cacheKey, float f) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        this.cacheKey = cacheKey;
        this.headerHeight = f;
    }

    public final float getHeaderHeight() {
        return this.headerHeight;
    }

    public final boolean hasKey(CacheKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.cacheKey.getFontSize() != Integer.MIN_VALUE && Intrinsics.areEqual(this.cacheKey, key);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CacheEntry getEMPTY() {
            return CacheEntry.EMPTY;
        }
    }
}
