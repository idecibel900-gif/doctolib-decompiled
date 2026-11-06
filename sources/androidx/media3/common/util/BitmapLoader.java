package androidx.media3.common.util;

import android.net.Uri;
import androidx.media3.common.MediaMetadata;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
public interface BitmapLoader {
    ListenableFuture decodeBitmap(byte[] bArr);

    ListenableFuture loadBitmap(Uri uri);

    default ListenableFuture loadBitmapFromMetadata(MediaMetadata mediaMetadata) {
        byte[] bArr = mediaMetadata.artworkData;
        if (bArr != null) {
            return decodeBitmap(bArr);
        }
        Uri uri = mediaMetadata.artworkUri;
        if (uri != null) {
            return loadBitmap(uri);
        }
        return null;
    }
}
