package io.didomi.ssl;

import io.didomi.ssl.purpose.common.model.PurposeCategory;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\t¨\u0006\r"}, d2 = {"Lio/didomi/sdk/h9;", "Ljava/util/Comparator;", "Lio/didomi/sdk/Purpose;", "purpose1", "purpose2", "", "a", "", "Lio/didomi/sdk/purpose/common/model/PurposeCategory;", "Ljava/util/List;", "categories", "<init>", "(Ljava/util/List;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class h9 implements Comparator<Purpose> {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final List<PurposeCategory> categories;

    public h9(List<PurposeCategory> categories) {
        Intrinsics.checkNotNullParameter(categories, "categories");
        this.categories = categories;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Purpose purpose1, Purpose purpose2) {
        Intrinsics.checkNotNullParameter(purpose1, "purpose1");
        Intrinsics.checkNotNullParameter(purpose2, "purpose2");
        int i = Integer.MAX_VALUE;
        int i2 = 0;
        int i3 = Integer.MAX_VALUE;
        for (Object obj : this.categories) {
            int i4 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            PurposeCategory purposeCategory = (PurposeCategory) obj;
            if (Intrinsics.areEqual(purpose1.getId(), purposeCategory.getPurposeId())) {
                i = i2;
            } else if (Intrinsics.areEqual(purpose2.getId(), purposeCategory.getPurposeId())) {
                i3 = i2;
            }
            i2 = i4;
        }
        return Intrinsics.compare(i, i3);
    }
}
