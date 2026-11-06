package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseNetworkFetcher implements NetworkFetcher {
    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public boolean shouldPropagate(FetchState fetchState) {
        return true;
    }
}
