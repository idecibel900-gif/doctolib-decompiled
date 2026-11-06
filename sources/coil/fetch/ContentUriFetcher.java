package coil.fetch;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import coil.ImageLoader;
import coil.decode.ContentMetadata;
import coil.decode.DataSource;
import coil.decode.ImageSources;
import coil.request.Options;
import coil.size.Dimension;
import com.vonage.webrtc.MediaStreamTrack;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import okio.Okio;

/* JADX INFO: loaded from: classes3.dex */
public final class ContentUriFetcher implements Fetcher {
    private final Uri data;
    private final Options options;

    public ContentUriFetcher(Uri uri, Options options) {
        this.data = uri;
        this.options = options;
    }

    @Override // coil.fetch.Fetcher
    public Object fetch(Continuation continuation) throws FileNotFoundException {
        InputStream inputStreamOpenInputStream;
        ContentResolver contentResolver = this.options.getContext().getContentResolver();
        if (isContactPhotoUri$coil_base_release(this.data)) {
            AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(this.data, "r");
            inputStreamOpenInputStream = assetFileDescriptorOpenAssetFileDescriptor != null ? assetFileDescriptorOpenAssetFileDescriptor.createInputStream() : null;
            if (inputStreamOpenInputStream == null) {
                throw new IllegalStateException(("Unable to find a contact photo associated with '" + this.data + "'.").toString());
            }
        } else if (Build.VERSION.SDK_INT >= 29 && isMusicThumbnailUri$coil_base_release(this.data)) {
            AssetFileDescriptor assetFileDescriptorOpenTypedAssetFile = contentResolver.openTypedAssetFile(this.data, "image/*", newMusicThumbnailSizeOptions(), null);
            inputStreamOpenInputStream = assetFileDescriptorOpenTypedAssetFile != null ? assetFileDescriptorOpenTypedAssetFile.createInputStream() : null;
            if (inputStreamOpenInputStream == null) {
                throw new IllegalStateException(("Unable to find a music thumbnail associated with '" + this.data + "'.").toString());
            }
        } else {
            inputStreamOpenInputStream = contentResolver.openInputStream(this.data);
            if (inputStreamOpenInputStream == null) {
                throw new IllegalStateException(("Unable to open '" + this.data + "'.").toString());
            }
        }
        return new SourceResult(ImageSources.create(Okio.buffer(Okio.source(inputStreamOpenInputStream)), this.options.getContext(), new ContentMetadata(this.data)), contentResolver.getType(this.data), DataSource.DISK);
    }

    public final boolean isContactPhotoUri$coil_base_release(Uri uri) {
        return Intrinsics.areEqual(uri.getAuthority(), "com.android.contacts") && Intrinsics.areEqual(uri.getLastPathSegment(), "display_photo");
    }

    public final boolean isMusicThumbnailUri$coil_base_release(Uri uri) {
        List<String> pathSegments;
        int size;
        return Intrinsics.areEqual(uri.getAuthority(), "media") && (size = (pathSegments = uri.getPathSegments()).size()) >= 3 && Intrinsics.areEqual(pathSegments.get(size + (-3)), MediaStreamTrack.AUDIO_TRACK_KIND) && Intrinsics.areEqual(pathSegments.get(size + (-2)), "albums");
    }

    private final Bundle newMusicThumbnailSizeOptions() {
        Dimension width = this.options.getSize().getWidth();
        Dimension.Pixels pixels = width instanceof Dimension.Pixels ? (Dimension.Pixels) width : null;
        if (pixels == null) {
            return null;
        }
        int i = pixels.px;
        Dimension height = this.options.getSize().getHeight();
        Dimension.Pixels pixels2 = height instanceof Dimension.Pixels ? (Dimension.Pixels) height : null;
        if (pixels2 == null) {
            return null;
        }
        int i2 = pixels2.px;
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("android.content.extra.SIZE", new Point(i, i2));
        return bundle;
    }

    public static final class Factory implements Fetcher.Factory {
        @Override // coil.fetch.Fetcher.Factory
        public Fetcher create(Uri uri, Options options, ImageLoader imageLoader) {
            if (isApplicable(uri)) {
                return new ContentUriFetcher(uri, options);
            }
            return null;
        }

        private final boolean isApplicable(Uri uri) {
            return Intrinsics.areEqual(uri.getScheme(), "content");
        }
    }
}
