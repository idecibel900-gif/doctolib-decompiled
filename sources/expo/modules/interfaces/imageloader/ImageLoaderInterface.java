package expo.modules.interfaces.imageloader;

import android.graphics.Bitmap;
import expo.modules.kotlin.services.Service;
import java.util.concurrent.Future;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\bJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lexpo/modules/interfaces/imageloader/ImageLoaderInterface;", "Lexpo/modules/kotlin/services/Service;", "", "url", "Ljava/util/concurrent/Future;", "Landroid/graphics/Bitmap;", "loadImageForManipulationFromURL", "(Ljava/lang/String;)Ljava/util/concurrent/Future;", "ResultListener", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ImageLoaderInterface extends Service {

    public interface ResultListener {
        void onFailure(Throwable th);

        void onSuccess(Bitmap bitmap);
    }

    Future loadImageForManipulationFromURL(String url);
}
