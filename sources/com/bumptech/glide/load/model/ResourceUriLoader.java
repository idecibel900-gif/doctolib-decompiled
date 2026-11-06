package com.bumptech.glide.load.model;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.load.Options;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class ResourceUriLoader implements ModelLoader {
    private final Context context;
    private final ModelLoader delegate;

    public static ModelLoaderFactory newStreamFactory(Context context) {
        return new InputStreamFactory(context);
    }

    public static ModelLoaderFactory newAssetFileDescriptorFactory(Context context) {
        return new AssetFileDescriptorFactory(context);
    }

    ResourceUriLoader(Context context, ModelLoader modelLoader) {
        this.context = context.getApplicationContext();
        this.delegate = modelLoader;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData buildLoadData(Uri uri, int i, int i2, Options options) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 1) {
            return parseResourceIdUri(uri, i, i2, options);
        }
        if (pathSegments.size() == 2) {
            return parseResourceNameUri(uri, i, i2, options);
        }
        if (!Log.isLoggable("ResourceUriLoader", 5)) {
            return null;
        }
        uri.toString();
        return null;
    }

    private ModelLoader.LoadData parseResourceNameUri(Uri uri, int i, int i2, Options options) {
        List<String> pathSegments = uri.getPathSegments();
        String str = pathSegments.get(0);
        int identifier = this.context.getResources().getIdentifier(pathSegments.get(1), str, this.context.getPackageName());
        if (identifier == 0) {
            if (!Log.isLoggable("ResourceUriLoader", 5)) {
                return null;
            }
            uri.toString();
            return null;
        }
        return this.delegate.buildLoadData(Integer.valueOf(identifier), i, i2, options);
    }

    private ModelLoader.LoadData parseResourceIdUri(Uri uri, int i, int i2, Options options) {
        try {
            int i3 = Integer.parseInt(uri.getPathSegments().get(0));
            if (i3 == 0) {
                if (Log.isLoggable("ResourceUriLoader", 5)) {
                    uri.toString();
                }
                return null;
            }
            return this.delegate.buildLoadData(Integer.valueOf(i3), i, i2, options);
        } catch (NumberFormatException unused) {
            if (Log.isLoggable("ResourceUriLoader", 5)) {
                Objects.toString(uri);
            }
            return null;
        }
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(Uri uri) {
        return "android.resource".equals(uri.getScheme()) && this.context.getPackageName().equals(uri.getAuthority());
    }

    private static final class InputStreamFactory implements ModelLoaderFactory {
        private final Context context;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        InputStreamFactory(Context context) {
            this.context = context;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceUriLoader(this.context, multiModelLoaderFactory.build(Integer.class, InputStream.class));
        }
    }

    private static final class AssetFileDescriptorFactory implements ModelLoaderFactory {
        private final Context context;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        AssetFileDescriptorFactory(Context context) {
            this.context = context;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceUriLoader(this.context, multiModelLoaderFactory.build(Integer.class, AssetFileDescriptor.class));
        }
    }
}
