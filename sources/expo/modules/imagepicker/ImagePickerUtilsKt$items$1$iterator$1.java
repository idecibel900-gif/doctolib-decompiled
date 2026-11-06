package expo.modules.imagepicker;

import android.content.ClipData;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class ImagePickerUtilsKt$items$1$iterator$1 implements Iterator, KMappedMarker {
    final /* synthetic */ ClipData $this_items;
    private final int count;
    private int index;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    ImagePickerUtilsKt$items$1$iterator$1(ClipData clipData) {
        this.$this_items = clipData;
        this.count = clipData.getItemCount();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.count;
    }

    @Override // java.util.Iterator
    public ClipData.Item next() {
        ClipData clipData = this.$this_items;
        int i = this.index;
        this.index = i + 1;
        ClipData.Item itemAt = clipData.getItemAt(i);
        Intrinsics.checkNotNullExpressionValue(itemAt, "getItemAt(...)");
        return itemAt;
    }
}
