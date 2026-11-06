package coil.fetch;

import coil.ImageLoader;
import coil.decode.DataSource;
import coil.decode.ImageSources;
import coil.request.Options;
import java.nio.ByteBuffer;
import kotlin.coroutines.Continuation;
import okio.Buffer;

/* JADX INFO: loaded from: classes3.dex */
public final class ByteBufferFetcher implements Fetcher {
    private final ByteBuffer data;
    private final Options options;

    public ByteBufferFetcher(ByteBuffer byteBuffer, Options options) {
        this.data = byteBuffer;
        this.options = options;
    }

    @Override // coil.fetch.Fetcher
    public Object fetch(Continuation continuation) {
        try {
            Buffer buffer = new Buffer();
            buffer.write(this.data);
            return new SourceResult(ImageSources.create(buffer, this.options.getContext()), null, DataSource.MEMORY);
        } finally {
            this.data.position(0);
        }
    }

    public static final class Factory implements Fetcher.Factory {
        @Override // coil.fetch.Fetcher.Factory
        public Fetcher create(ByteBuffer byteBuffer, Options options, ImageLoader imageLoader) {
            return new ByteBufferFetcher(byteBuffer, options);
        }
    }
}
