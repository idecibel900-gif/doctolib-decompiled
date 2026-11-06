package expo.modules.image.enums;

import com.bumptech.glide.load.DataSource;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public enum ImageCacheType {
    NONE(DataSource.LOCAL, DataSource.REMOTE),
    DISK(DataSource.DATA_DISK_CACHE, DataSource.RESOURCE_DISK_CACHE),
    MEMORY(DataSource.MEMORY_CACHE);

    private final DataSource[] dataSources;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final Companion Companion = new Companion(null);

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }

    ImageCacheType(DataSource... dataSourceArr) {
        this.dataSources = dataSourceArr;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ImageCacheType fromNativeValue(DataSource value) {
            Object next;
            Intrinsics.checkNotNullParameter(value, "value");
            Iterator<E> it = ImageCacheType.getEntries().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!ArraysKt.contains(((ImageCacheType) next).dataSources, value));
            ImageCacheType imageCacheType = (ImageCacheType) next;
            return imageCacheType == null ? ImageCacheType.NONE : imageCacheType;
        }
    }
}
