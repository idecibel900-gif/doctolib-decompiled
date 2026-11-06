package expo.modules.image;

import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.ThumbnailRequestCoordinator;
import java.lang.reflect.Field;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ThumbnailRequestCoordinatorExtensionKt {
    public static final Request getPrivateFullRequest(ThumbnailRequestCoordinator thumbnailRequestCoordinator) {
        Intrinsics.checkNotNullParameter(thumbnailRequestCoordinator, "<this>");
        return (Request) getPrivateField(thumbnailRequestCoordinator, "full");
    }

    private static final Object getPrivateField(ThumbnailRequestCoordinator thumbnailRequestCoordinator, String str) {
        try {
            Field declaredField = thumbnailRequestCoordinator.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(thumbnailRequestCoordinator);
        } catch (Throwable unused) {
            return null;
        }
    }
}
