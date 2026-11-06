package androidx.media3.exoplayer.hls.playlist;

import androidx.media3.exoplayer.offline.FilteringManifestParser;
import androidx.media3.exoplayer.upstream.ParsingLoadable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class FilteringHlsPlaylistParserFactory implements HlsPlaylistParserFactory {
    private final HlsPlaylistParserFactory hlsPlaylistParserFactory;
    private final List streamKeys;

    public FilteringHlsPlaylistParserFactory(HlsPlaylistParserFactory hlsPlaylistParserFactory, List list) {
        this.hlsPlaylistParserFactory = hlsPlaylistParserFactory;
        this.streamKeys = list;
    }

    @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistParserFactory
    public ParsingLoadable.Parser createPlaylistParser() {
        return new FilteringManifestParser(this.hlsPlaylistParserFactory.createPlaylistParser(), this.streamKeys);
    }

    @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistParserFactory
    public ParsingLoadable.Parser createPlaylistParser(HlsMultivariantPlaylist hlsMultivariantPlaylist, HlsMediaPlaylist hlsMediaPlaylist) {
        return new FilteringManifestParser(this.hlsPlaylistParserFactory.createPlaylistParser(hlsMultivariantPlaylist, hlsMediaPlaylist), this.streamKeys);
    }
}
