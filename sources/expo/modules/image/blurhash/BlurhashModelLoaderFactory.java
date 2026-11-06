package expo.modules.image.blurhash;

import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class BlurhashModelLoaderFactory implements ModelLoaderFactory {
    @Override // com.bumptech.glide.load.model.ModelLoaderFactory
    public void teardown() {
    }

    @Override // com.bumptech.glide.load.model.ModelLoaderFactory
    public ModelLoader build(MultiModelLoaderFactory multiFactory) {
        Intrinsics.checkNotNullParameter(multiFactory, "multiFactory");
        return new BlurhashModelLoader();
    }
}
