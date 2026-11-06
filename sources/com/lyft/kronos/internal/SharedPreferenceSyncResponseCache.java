package com.lyft.kronos.internal;

import android.content.SharedPreferences;
import com.lyft.kronos.SyncResponseCache;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class SharedPreferenceSyncResponseCache implements SyncResponseCache {
    public static final Companion Companion = new Companion(null);
    private final SharedPreferences sharedPreferences;

    public SharedPreferenceSyncResponseCache(SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        this.sharedPreferences = sharedPreferences;
    }

    @Override // com.lyft.kronos.SyncResponseCache
    public long getCurrentTime() {
        return this.sharedPreferences.getLong("com.lyft.kronos.cached_current_time", 0L);
    }

    @Override // com.lyft.kronos.SyncResponseCache
    public void setCurrentTime(long j) {
        this.sharedPreferences.edit().putLong("com.lyft.kronos.cached_current_time", j).apply();
    }

    @Override // com.lyft.kronos.SyncResponseCache
    public long getElapsedTime() {
        return this.sharedPreferences.getLong("com.lyft.kronos.cached_elapsed_time", 0L);
    }

    @Override // com.lyft.kronos.SyncResponseCache
    public void setElapsedTime(long j) {
        this.sharedPreferences.edit().putLong("com.lyft.kronos.cached_elapsed_time", j).apply();
    }

    @Override // com.lyft.kronos.SyncResponseCache
    public long getCurrentOffset() {
        return this.sharedPreferences.getLong("com.lyft.kronos.cached_offset", 0L);
    }

    @Override // com.lyft.kronos.SyncResponseCache
    public void setCurrentOffset(long j) {
        this.sharedPreferences.edit().putLong("com.lyft.kronos.cached_offset", j).apply();
    }

    @Override // com.lyft.kronos.SyncResponseCache
    public void clear() {
        this.sharedPreferences.edit().clear().apply();
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
