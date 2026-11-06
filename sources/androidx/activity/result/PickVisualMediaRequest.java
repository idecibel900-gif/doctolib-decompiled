package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContracts$PickMultipleVisualMedia;
import androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class PickVisualMediaRequest {
    private long accentColor;
    private boolean isCustomAccentColorApplied;
    private boolean isOrderedSelection;
    private ActivityResultContracts$PickVisualMedia.VisualMediaType mediaType = ActivityResultContracts$PickVisualMedia.ImageAndVideo.INSTANCE;
    private int maxItems = ActivityResultContracts$PickMultipleVisualMedia.Companion.getMaxItems$activity_release();
    private ActivityResultContracts$PickVisualMedia.DefaultTab defaultTab = ActivityResultContracts$PickVisualMedia.DefaultTab.PhotosTab.INSTANCE;

    public final ActivityResultContracts$PickVisualMedia.MediaCapabilities getMediaCapabilitiesForTranscoding() {
        return null;
    }

    public final void setMediaCapabilitiesForTranscoding$activity_release(ActivityResultContracts$PickVisualMedia.MediaCapabilities mediaCapabilities) {
    }

    public final ActivityResultContracts$PickVisualMedia.VisualMediaType getMediaType() {
        return this.mediaType;
    }

    public final void setMediaType$activity_release(ActivityResultContracts$PickVisualMedia.VisualMediaType visualMediaType) {
        Intrinsics.checkNotNullParameter(visualMediaType, "<set-?>");
        this.mediaType = visualMediaType;
    }

    public final int getMaxItems() {
        return this.maxItems;
    }

    public final void setMaxItems$activity_release(int i) {
        this.maxItems = i;
    }

    public final boolean isOrderedSelection() {
        return this.isOrderedSelection;
    }

    public final void setOrderedSelection$activity_release(boolean z) {
        this.isOrderedSelection = z;
    }

    public final ActivityResultContracts$PickVisualMedia.DefaultTab getDefaultTab() {
        return this.defaultTab;
    }

    public final void setDefaultTab$activity_release(ActivityResultContracts$PickVisualMedia.DefaultTab defaultTab) {
        Intrinsics.checkNotNullParameter(defaultTab, "<set-?>");
        this.defaultTab = defaultTab;
    }

    public final boolean isCustomAccentColorApplied() {
        return this.isCustomAccentColorApplied;
    }

    public final void setCustomAccentColorApplied$activity_release(boolean z) {
        this.isCustomAccentColorApplied = z;
    }

    public final long getAccentColor() {
        return this.accentColor;
    }

    public final void setAccentColor$activity_release(long j) {
        this.accentColor = j;
    }

    public static final class Builder {
        private long accentColor;
        private boolean isCustomAccentColorApplied;
        private boolean isOrderedSelection;
        private ActivityResultContracts$PickVisualMedia.VisualMediaType mediaType = ActivityResultContracts$PickVisualMedia.ImageAndVideo.INSTANCE;
        private int maxItems = ActivityResultContracts$PickMultipleVisualMedia.Companion.getMaxItems$activity_release();
        private ActivityResultContracts$PickVisualMedia.DefaultTab defaultTab = ActivityResultContracts$PickVisualMedia.DefaultTab.PhotosTab.INSTANCE;

        public final Builder setMediaType(ActivityResultContracts$PickVisualMedia.VisualMediaType mediaType) {
            Intrinsics.checkNotNullParameter(mediaType, "mediaType");
            this.mediaType = mediaType;
            return this;
        }

        public final Builder setOrderedSelection(boolean z) {
            this.isOrderedSelection = z;
            return this;
        }

        public final Builder setDefaultTab(ActivityResultContracts$PickVisualMedia.DefaultTab defaultTab) {
            Intrinsics.checkNotNullParameter(defaultTab, "defaultTab");
            this.defaultTab = defaultTab;
            return this;
        }

        public final PickVisualMediaRequest build() {
            PickVisualMediaRequest pickVisualMediaRequest = new PickVisualMediaRequest();
            pickVisualMediaRequest.setMediaType$activity_release(this.mediaType);
            pickVisualMediaRequest.setMaxItems$activity_release(this.maxItems);
            pickVisualMediaRequest.setOrderedSelection$activity_release(this.isOrderedSelection);
            pickVisualMediaRequest.setDefaultTab$activity_release(this.defaultTab);
            pickVisualMediaRequest.setCustomAccentColorApplied$activity_release(this.isCustomAccentColorApplied);
            pickVisualMediaRequest.setAccentColor$activity_release(this.accentColor);
            pickVisualMediaRequest.setMediaCapabilitiesForTranscoding$activity_release(null);
            return pickVisualMediaRequest;
        }
    }
}
