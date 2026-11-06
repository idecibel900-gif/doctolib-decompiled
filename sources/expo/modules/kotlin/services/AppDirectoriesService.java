package expo.modules.kotlin.services;

import android.content.Context;
import expo.modules.kotlin.UtilsKt;
import java.io.File;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lexpo/modules/kotlin/services/AppDirectoriesService;", "Lexpo/modules/kotlin/services/Service;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "contextHolder", "Ljava/lang/ref/WeakReference;", "getContext", "()Landroid/content/Context;", "cacheDirectory", "Ljava/io/File;", "getCacheDirectory", "()Ljava/io/File;", "persistentFilesDirectory", "getPersistentFilesDirectory", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class AppDirectoriesService implements Service {
    private final WeakReference contextHolder;

    public AppDirectoriesService(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.contextHolder = UtilsKt.weak(context);
    }

    private final Context getContext() {
        Object obj = this.contextHolder.get();
        if (obj != null) {
            return (Context) obj;
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    public File getCacheDirectory() {
        File cacheDir = getContext().getCacheDir();
        Intrinsics.checkNotNullExpressionValue(cacheDir, "getCacheDir(...)");
        return cacheDir;
    }

    public File getPersistentFilesDirectory() {
        File filesDir = getContext().getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "getFilesDir(...)");
        return filesDir;
    }
}
