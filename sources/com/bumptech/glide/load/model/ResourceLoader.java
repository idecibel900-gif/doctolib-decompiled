package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class ResourceLoader implements ModelLoader {
    private final Resources resources;
    private final ModelLoader uriLoader;

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(Integer num) {
        return true;
    }

    public ResourceLoader(Resources resources, ModelLoader modelLoader) {
        this.resources = resources;
        this.uriLoader = modelLoader;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData buildLoadData(Integer num, int i, int i2, Options options) {
        Uri resourceUri = getResourceUri(num);
        if (resourceUri == null) {
            return null;
        }
        return this.uriLoader.buildLoadData(resourceUri, i, i2, options);
    }

    private Uri getResourceUri(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.resources.getResourcePackageName(num.intValue()) + '/' + num);
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    public static class StreamFactory implements ModelLoaderFactory {
        private final Resources resources;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        public StreamFactory(Resources resources) {
            this.resources = resources;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.resources, multiModelLoaderFactory.build(Uri.class, InputStream.class));
        }
    }

    public static final class AssetFileDescriptorFactory implements ModelLoaderFactory {
        private final Resources resources;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        public AssetFileDescriptorFactory(Resources resources) {
            this.resources = resources;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.resources, multiModelLoaderFactory.build(Uri.class, AssetFileDescriptor.class));
        }
    }

    public static class UriFactory implements ModelLoaderFactory {
        private final Resources resources;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        public UriFactory(Resources resources) {
            this.resources = resources;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.resources, UnitModelLoader.getInstance());
        }
    }
}
