package expo.modules.image.dataurls;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class Base64ModelLoader implements ModelLoader {
    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(String model) {
        Intrinsics.checkNotNullParameter(model, "model");
        return StringsKt.startsWith$default(model, "data:", false, 2, (Object) null);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData buildLoadData(String model, int i, int i2, Options options) {
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(options, "options");
        return new ModelLoader.LoadData(new ObjectKey(model), new Base64DataFetcher(model));
    }
}
