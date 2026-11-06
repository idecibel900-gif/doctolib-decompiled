package expo.modules.image.blurhash;

import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class BlurhashModelLoader implements ModelLoader {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String buildLoadData$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(BlurhashModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        return true;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData buildLoadData(BlurhashModel model, int i, int i2, Options options) {
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(options, "options");
        return new ModelLoader.LoadData(new ObjectKey(model), new BlurHashFetcher((String) getPath(model.getUri(), 0, null, new Function1() { // from class: expo.modules.image.blurhash.BlurhashModelLoader$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BlurhashModelLoader.buildLoadData$lambda$0((String) obj);
            }
        }), model.getWidth(), model.getHeight(), 1.0f));
    }

    private final Object getPath(Uri uri, int i, Object obj, Function1 function1) {
        List<String> pathSegments = uri.getPathSegments();
        Intrinsics.checkNotNullExpressionValue(pathSegments, "getPathSegments(...)");
        String str = (String) CollectionsKt.getOrNull(pathSegments, i);
        return str == null ? obj : function1.invoke(str);
    }
}
