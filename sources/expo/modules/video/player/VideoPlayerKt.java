package expo.modules.video.player;

import android.net.Uri;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.Tracks;
import androidx.media3.exoplayer.hls.HlsManifest;
import androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist;
import com.google.common.collect.UnmodifiableIterator;
import expo.modules.video.records.VideoTrack;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public abstract class VideoPlayerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final List toVideoTracks(Tracks tracks, HlsManifest hlsManifest) {
        HlsMultivariantPlaylist.Variant variant;
        HlsMultivariantPlaylist hlsMultivariantPlaylist;
        List list;
        Object next;
        ArrayList arrayList = new ArrayList();
        UnmodifiableIterator it = tracks.getGroups().iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Tracks.Group group = (Tracks.Group) it.next();
            int i = group.length;
            for (int i2 = 0; i2 < i; i2++) {
                Format trackFormat = group.getTrackFormat(i2);
                Intrinsics.checkNotNullExpressionValue(trackFormat, "getTrackFormat(...)");
                boolean zIsTrackSupported = group.isTrackSupported(i2);
                if (hlsManifest == null || (hlsMultivariantPlaylist = hlsManifest.multivariantPlaylist) == null || (list = hlsMultivariantPlaylist.variants) == null) {
                    variant = null;
                } else {
                    Iterator it2 = list.iterator();
                    do {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it2.next();
                    } while (!Intrinsics.areEqual(((HlsMultivariantPlaylist.Variant) next).format.id, trackFormat.id));
                    variant = (HlsMultivariantPlaylist.Variant) next;
                }
                Uri uri = variant != null ? variant.url : null;
                if (MimeTypes.isVideo(trackFormat.sampleMimeType)) {
                    arrayList.add(VideoTrack.INSTANCE.fromFormat(trackFormat, zIsTrackSupported, uri));
                }
            }
        }
        return CollectionsKt.filterNotNull(arrayList);
    }
}
