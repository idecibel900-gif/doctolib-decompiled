package androidx.media3.datasource.cache;

import androidx.media3.datasource.DataSpec;

/* JADX INFO: loaded from: classes.dex */
public interface CacheKeyFactory {
    public static final CacheKeyFactory DEFAULT = new CacheKeyFactory() { // from class: androidx.media3.datasource.cache.CacheKeyFactory$$ExternalSyntheticLambda0
        @Override // androidx.media3.datasource.cache.CacheKeyFactory
        public final String buildCacheKey(DataSpec dataSpec) {
            return CacheKeyFactory.m2730$r8$lambda$XPFtnZJwAC4y4J5WXWzp0oofq4(dataSpec);
        }
    };

    String buildCacheKey(DataSpec dataSpec);

    /* JADX INFO: renamed from: $r8$lambda$XPFtnZJwAC4y4-J5WXWzp0oofq4, reason: not valid java name */
    static /* synthetic */ String m2730$r8$lambda$XPFtnZJwAC4y4J5WXWzp0oofq4(DataSpec dataSpec) {
        String str = dataSpec.key;
        return str != null ? str : dataSpec.uri.toString();
    }
}
