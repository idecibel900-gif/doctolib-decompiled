package androidx.media3.exoplayer.hls.playlist;

import androidx.media3.exoplayer.offline.FilterableManifest;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class HlsPlaylist implements FilterableManifest {
    public final String baseUri;
    public final boolean hasIndependentSegments;
    public final List tags;

    protected HlsPlaylist(String str, List list, boolean z) {
        this.baseUri = str;
        this.tags = Collections.unmodifiableList(list);
        this.hasIndependentSegments = z;
    }
}
