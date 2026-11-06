package coil.fetch;

import android.webkit.MimeTypeMap;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.decode.ImageSources;
import coil.request.Options;
import java.io.File;
import kotlin.coroutines.Continuation;
import kotlin.io.FilesKt;
import okio.Path;

/* JADX INFO: loaded from: classes3.dex */
public final class FileFetcher implements Fetcher {
    private final File data;

    public FileFetcher(File file) {
        this.data = file;
    }

    @Override // coil.fetch.Fetcher
    public Object fetch(Continuation continuation) {
        return new SourceResult(ImageSources.create$default(Path.Companion.get$default(Path.Companion, this.data, false, 1, (Object) null), null, null, null, 14, null), MimeTypeMap.getSingleton().getMimeTypeFromExtension(FilesKt.getExtension(this.data)), DataSource.DISK);
    }

    public static final class Factory implements Fetcher.Factory {
        @Override // coil.fetch.Fetcher.Factory
        public Fetcher create(File file, Options options, ImageLoader imageLoader) {
            return new FileFetcher(file);
        }
    }
}
