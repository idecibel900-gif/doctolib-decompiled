package expo.modules.imagepicker;

import android.content.ClipData;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class ImagePickerUtilsKt$items$1 implements Iterable, KMappedMarker {
    final /* synthetic */ ClipData $this_items;

    ImagePickerUtilsKt$items$1(ClipData clipData) {
        this.$this_items = clipData;
    }

    @Override // java.lang.Iterable
    public ImagePickerUtilsKt$items$1$iterator$1 iterator() {
        return new ImagePickerUtilsKt$items$1$iterator$1(this.$this_items);
    }
}
