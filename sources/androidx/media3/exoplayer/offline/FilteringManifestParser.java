package androidx.media3.exoplayer.offline;

import android.net.Uri;
import androidx.media3.exoplayer.upstream.ParsingLoadable;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class FilteringManifestParser implements ParsingLoadable.Parser {
    private final ParsingLoadable.Parser parser;
    private final List streamKeys;

    public FilteringManifestParser(ParsingLoadable.Parser parser, List list) {
        this.parser = parser;
        this.streamKeys = list;
    }

    @Override // androidx.media3.exoplayer.upstream.ParsingLoadable.Parser
    public FilterableManifest parse(Uri uri, InputStream inputStream) {
        FilterableManifest filterableManifest = (FilterableManifest) this.parser.parse(uri, inputStream);
        List list = this.streamKeys;
        return (list == null || list.isEmpty()) ? filterableManifest : (FilterableManifest) filterableManifest.copy(this.streamKeys);
    }
}
