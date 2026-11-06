package androidx.media3.exoplayer.hls.playlist;

import androidx.media3.exoplayer.upstream.ParsingLoadable;

/* JADX INFO: loaded from: classes.dex */
public interface HlsPlaylistParserFactory {
    ParsingLoadable.Parser createPlaylistParser();

    ParsingLoadable.Parser createPlaylistParser(HlsMultivariantPlaylist hlsMultivariantPlaylist, HlsMediaPlaylist hlsMediaPlaylist);
}
