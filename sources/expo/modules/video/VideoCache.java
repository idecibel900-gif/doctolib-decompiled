package expo.modules.video;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import androidx.media3.database.DatabaseProvider;
import androidx.media3.database.StandaloneDatabaseProvider;
import androidx.media3.datasource.cache.LeastRecentlyUsedCacheEvictor;
import androidx.media3.datasource.cache.SimpleCache;
import expo.modules.kotlin.exception.Exceptions$ReactContextLost;
import expo.modules.video.managers.VideoManager;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.UUID;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes5.dex */
public final class VideoCache {
    private LeastRecentlyUsedCacheEvictor cacheEvictor;
    private final DatabaseProvider databaseProvider;
    private SimpleCache instance;
    private final SharedPreferences sharedPreferences;
    private final WeakReference weakContext;

    public VideoCache(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.weakContext = new WeakReference(context);
        StandaloneDatabaseProvider standaloneDatabaseProvider = new StandaloneDatabaseProvider(context);
        this.databaseProvider = standaloneDatabaseProvider;
        this.sharedPreferences = context.getSharedPreferences("ExpoVideoCache", 0);
        this.cacheEvictor = new LeastRecentlyUsedCacheEvictor(getMaxCacheSize());
        this.instance = new SimpleCache(getCacheDir(), this.cacheEvictor, standaloneDatabaseProvider);
    }

    private final Context getContext() throws Exceptions$ReactContextLost {
        Context context = (Context) this.weakContext.get();
        if (context != null) {
            return context;
        }
        throw new Exceptions$ReactContextLost();
    }

    public final SimpleCache getInstance() {
        return this.instance;
    }

    private final long getMaxCacheSize() {
        return this.sharedPreferences.getLong("cacheSize", 1073741824L);
    }

    public final void release() {
        this.instance.release();
    }

    public final void setMaxCacheSize(long j) throws VideoCacheException {
        assertModificationReleaseConditions();
        this.instance.release();
        this.sharedPreferences.edit().putLong("cacheSize", j).apply();
        this.cacheEvictor = new LeastRecentlyUsedCacheEvictor(j);
        this.instance = new SimpleCache(getCacheDir(), this.cacheEvictor, this.databaseProvider);
    }

    public final long getCurrentCacheSize() {
        return getFileSize(getCacheDir());
    }

    private final File getCacheDir() {
        String string = this.sharedPreferences.getString("cacheDir", null);
        if (string == null) {
            string = generateCacheDirName();
            this.sharedPreferences.edit().putString("cacheDir", string).commit();
        }
        File file = new File(new File(getContext().getCacheDir(), "ExpoVideoCache"), string);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private final String generateCacheDirName() {
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final void clear() throws VideoCacheException {
        assertModificationReleaseConditions();
        File cacheDir = getCacheDir();
        SimpleCache simpleCache = this.instance;
        this.sharedPreferences.edit().putString("cacheDir", generateCacheDirName()).apply();
        this.instance = new SimpleCache(getCacheDir(), this.cacheEvictor, this.databaseProvider);
        simpleCache.release();
        FilesKt.deleteRecursively(cacheDir);
    }

    private final long getFileSize(File file) {
        return SequencesKt.sumOfLong(SequencesKt.map(SequencesKt.filter(FilesKt.walkTopDown(file), new Function1() { // from class: expo.modules.video.VideoCache$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(VideoCache.getFileSize$lambda$1((File) obj));
            }
        }), new Function1() { // from class: expo.modules.video.VideoCache$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(VideoCache.getFileSize$lambda$2((File) obj));
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getFileSize$lambda$1(File it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.isFile();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long getFileSize$lambda$2(File it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.length();
    }

    private final void assertModificationReleaseConditions() throws VideoCacheException {
        if (VideoManager.INSTANCE.hasRegisteredPlayers()) {
            throw new VideoCacheException("Cannot clear cache while there are active players", null, 2, null);
        }
        Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
    }
}
