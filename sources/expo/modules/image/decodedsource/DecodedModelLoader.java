package expo.modules.image.decodedsource;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class DecodedModelLoader implements ModelLoader {
    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(DecodedModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        return true;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData buildLoadData(DecodedModel model, int i, int i2, Options options) {
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(options, "options");
        return new ModelLoader.LoadData(new ObjectKey(model), new DecodedFetcher(model.getDrawable()));
    }
}
