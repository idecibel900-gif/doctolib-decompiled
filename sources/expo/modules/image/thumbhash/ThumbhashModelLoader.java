package expo.modules.image.thumbhash;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class ThumbhashModelLoader implements ModelLoader {
    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(ThumbhashModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        return true;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData buildLoadData(ThumbhashModel model, int i, int i2, Options options) {
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(options, "options");
        List<String> pathSegments = model.getUri().getPathSegments();
        Intrinsics.checkNotNullExpressionValue(pathSegments, "getPathSegments(...)");
        return new ModelLoader.LoadData(new ObjectKey(model), new ThumbhashFetcher(StringsKt.replace$default(CollectionsKt.joinToString$default(pathSegments, "/", null, null, 0, null, null, 62, null), "\\", "/", false, 4, (Object) null)));
    }
}
