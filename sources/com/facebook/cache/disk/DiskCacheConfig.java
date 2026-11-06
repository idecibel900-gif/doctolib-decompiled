package com.facebook.cache.disk;

import android.content.Context;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.common.NoOpCacheErrorLogger;
import com.facebook.cache.common.NoOpCacheEventListener;
import com.facebook.common.disk.DiskTrimmableRegistry;
import com.facebook.common.disk.NoOpDiskTrimmableRegistry;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class DiskCacheConfig {
    private final String mBaseDirectoryName;
    private final Supplier mBaseDirectoryPathSupplier;
    private final CacheErrorLogger mCacheErrorLogger;
    private final CacheEventListener mCacheEventListener;
    private final Context mContext;
    private final long mDefaultSizeLimit;
    private final DiskTrimmableRegistry mDiskTrimmableRegistry;
    private final EntryEvictionComparatorSupplier mEntryEvictionComparatorSupplier;
    private final boolean mIndexPopulateAtStartupEnabled;
    private final long mLowDiskSpaceSizeLimit;
    private final long mMinimumSizeLimit;
    private final int mVersion;

    protected DiskCacheConfig(Builder builder) {
        CacheErrorLogger noOpCacheErrorLogger;
        CacheEventListener noOpCacheEventListener;
        DiskTrimmableRegistry noOpDiskTrimmableRegistry;
        Context context = builder.mContext;
        this.mContext = context;
        Preconditions.checkState((builder.mBaseDirectoryPathSupplier == null && context == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
        if (builder.mBaseDirectoryPathSupplier == null && context != null) {
            builder.mBaseDirectoryPathSupplier = new Supplier() { // from class: com.facebook.cache.disk.DiskCacheConfig.1
                @Override // com.facebook.common.internal.Supplier
                public File get() {
                    Preconditions.checkNotNull(DiskCacheConfig.this.mContext);
                    return DiskCacheConfig.this.mContext.getApplicationContext().getCacheDir();
                }
            };
        }
        this.mVersion = builder.mVersion;
        this.mBaseDirectoryName = (String) Preconditions.checkNotNull(builder.mBaseDirectoryName);
        this.mBaseDirectoryPathSupplier = (Supplier) Preconditions.checkNotNull(builder.mBaseDirectoryPathSupplier);
        this.mDefaultSizeLimit = builder.mMaxCacheSize;
        this.mLowDiskSpaceSizeLimit = builder.mMaxCacheSizeOnLowDiskSpace;
        this.mMinimumSizeLimit = builder.mMaxCacheSizeOnVeryLowDiskSpace;
        this.mEntryEvictionComparatorSupplier = (EntryEvictionComparatorSupplier) Preconditions.checkNotNull(builder.mEntryEvictionComparatorSupplier);
        if (builder.mCacheErrorLogger == null) {
            noOpCacheErrorLogger = NoOpCacheErrorLogger.getInstance();
        } else {
            noOpCacheErrorLogger = builder.mCacheErrorLogger;
        }
        this.mCacheErrorLogger = noOpCacheErrorLogger;
        if (builder.mCacheEventListener == null) {
            noOpCacheEventListener = NoOpCacheEventListener.getInstance();
        } else {
            noOpCacheEventListener = builder.mCacheEventListener;
        }
        this.mCacheEventListener = noOpCacheEventListener;
        if (builder.mDiskTrimmableRegistry == null) {
            noOpDiskTrimmableRegistry = NoOpDiskTrimmableRegistry.getInstance();
        } else {
            noOpDiskTrimmableRegistry = builder.mDiskTrimmableRegistry;
        }
        this.mDiskTrimmableRegistry = noOpDiskTrimmableRegistry;
        this.mIndexPopulateAtStartupEnabled = builder.mIndexPopulateAtStartupEnabled;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public String getBaseDirectoryName() {
        return this.mBaseDirectoryName;
    }

    public Supplier getBaseDirectoryPathSupplier() {
        return this.mBaseDirectoryPathSupplier;
    }

    public long getDefaultSizeLimit() {
        return this.mDefaultSizeLimit;
    }

    public long getLowDiskSpaceSizeLimit() {
        return this.mLowDiskSpaceSizeLimit;
    }

    public long getMinimumSizeLimit() {
        return this.mMinimumSizeLimit;
    }

    public EntryEvictionComparatorSupplier getEntryEvictionComparatorSupplier() {
        return this.mEntryEvictionComparatorSupplier;
    }

    public CacheErrorLogger getCacheErrorLogger() {
        return this.mCacheErrorLogger;
    }

    public CacheEventListener getCacheEventListener() {
        return this.mCacheEventListener;
    }

    public DiskTrimmableRegistry getDiskTrimmableRegistry() {
        return this.mDiskTrimmableRegistry;
    }

    public boolean getIndexPopulateAtStartupEnabled() {
        return this.mIndexPopulateAtStartupEnabled;
    }

    public static Builder newBuilder(Context context) {
        return new Builder(context);
    }

    public static final class Builder {
        private String mBaseDirectoryName;
        private Supplier mBaseDirectoryPathSupplier;
        private CacheErrorLogger mCacheErrorLogger;
        private CacheEventListener mCacheEventListener;
        private final Context mContext;
        private DiskTrimmableRegistry mDiskTrimmableRegistry;
        private EntryEvictionComparatorSupplier mEntryEvictionComparatorSupplier;
        private boolean mIndexPopulateAtStartupEnabled;
        private long mMaxCacheSize;
        private long mMaxCacheSizeOnLowDiskSpace;
        private long mMaxCacheSizeOnVeryLowDiskSpace;
        private int mVersion;

        private Builder(Context context) {
            this.mVersion = 1;
            this.mBaseDirectoryName = "image_cache";
            this.mMaxCacheSize = 41943040L;
            this.mMaxCacheSizeOnLowDiskSpace = 10485760L;
            this.mMaxCacheSizeOnVeryLowDiskSpace = 2097152L;
            this.mEntryEvictionComparatorSupplier = new DefaultEntryEvictionComparatorSupplier();
            this.mContext = context;
        }

        public DiskCacheConfig build() {
            return new DiskCacheConfig(this);
        }
    }
}
