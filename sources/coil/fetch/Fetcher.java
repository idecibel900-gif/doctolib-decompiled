package coil.fetch;

import coil.ImageLoader;
import coil.request.Options;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes3.dex */
public interface Fetcher {

    public interface Factory {
        Fetcher create(Object obj, Options options, ImageLoader imageLoader);
    }

    Object fetch(Continuation continuation);
}
