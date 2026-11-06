package coil.decode;

import coil.ImageLoader;
import coil.fetch.SourceResult;
import coil.request.Options;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes3.dex */
public interface Decoder {

    public interface Factory {
        Decoder create(SourceResult sourceResult, Options options, ImageLoader imageLoader);
    }

    Object decode(Continuation continuation);
}
