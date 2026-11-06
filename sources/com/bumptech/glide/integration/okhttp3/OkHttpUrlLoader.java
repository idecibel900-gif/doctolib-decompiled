package com.bumptech.glide.integration.okhttp3;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import okhttp3.Call;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes3.dex */
public class OkHttpUrlLoader implements ModelLoader {
    private final Call.Factory client;

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(GlideUrl glideUrl) {
        return true;
    }

    public OkHttpUrlLoader(Call.Factory factory) {
        this.client = factory;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData buildLoadData(GlideUrl glideUrl, int i, int i2, Options options) {
        return new ModelLoader.LoadData(glideUrl, new OkHttpStreamFetcher(this.client, glideUrl));
    }

    public static class Factory implements ModelLoaderFactory {
        private static volatile Call.Factory internalClient;
        private final Call.Factory client;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        private static Call.Factory getInternalClient() {
            if (internalClient == null) {
                synchronized (Factory.class) {
                    try {
                        if (internalClient == null) {
                            internalClient = new OkHttpClient();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return internalClient;
        }

        public Factory() {
            this(getInternalClient());
        }

        public Factory(Call.Factory factory) {
            this.client = factory;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new OkHttpUrlLoader(this.client);
        }
    }
}
