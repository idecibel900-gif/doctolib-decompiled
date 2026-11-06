package io.didomi.ssl;

import io.didomi.ssl.models.DataCategory;
import io.didomi.ssl.models.Feature;
import io.didomi.ssl.models.SpecialFeature;
import io.didomi.ssl.models.SpecialPurpose;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010 \n\u0000\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0006\u001a\u00020\u0005*\u00020\u0000\u001a\n\u0010\b\u001a\u00020\u0007*\u00020\u0000\u001a\n\u0010\n\u001a\u00020\t*\u00020\u0000\u001a\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\f*\b\u0012\u0004\u0012\u00020\u00000\u000b\u001a\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\f*\b\u0012\u0004\u0012\u00020\u00000\u000b¨\u0006\r"}, d2 = {"Lio/didomi/sdk/e7;", "Lio/didomi/sdk/models/DataCategory;", "a", "Lio/didomi/sdk/Purpose;", "c", "Lio/didomi/sdk/models/SpecialFeature;", "d", "Lio/didomi/sdk/models/SpecialPurpose;", "e", "Lio/didomi/sdk/models/Feature;", "b", "", "", "android_release"}, k = 2, mv = {1, 8, 0})
public final class f7 {
    public static final DataCategory a(InternalPurpose internalPurpose) {
        Intrinsics.checkNotNullParameter(internalPurpose, "<this>");
        String id = internalPurpose.getId();
        if (id == null) {
            id = "";
        }
        String name = internalPurpose.getName();
        if (name == null) {
            name = "";
        }
        String description = internalPurpose.getDescription();
        return new DataCategory(id, name, description != null ? description : "");
    }

    public static final Feature b(InternalPurpose internalPurpose) {
        Intrinsics.checkNotNullParameter(internalPurpose, "<this>");
        String id = internalPurpose.getId();
        if (id == null) {
            id = "";
        }
        String iabId = internalPurpose.getIabId();
        String name = internalPurpose.getName();
        if (name == null) {
            name = "";
        }
        String description = internalPurpose.getDescription();
        if (description == null) {
            description = "";
        }
        return new Feature(id, iabId, name, description, internalPurpose.getDescriptionLegal(), internalPurpose.e());
    }

    public static final Purpose c(InternalPurpose internalPurpose) {
        Intrinsics.checkNotNullParameter(internalPurpose, "<this>");
        String id = internalPurpose.getId();
        if (id == null) {
            id = "";
        }
        String iabId = internalPurpose.getIabId();
        String name = internalPurpose.getName();
        if (name == null) {
            name = "";
        }
        String description = internalPurpose.getDescription();
        if (description == null) {
            description = "";
        }
        String descriptionLegal = internalPurpose.getDescriptionLegal();
        if (descriptionLegal == null) {
            descriptionLegal = "";
        }
        return new Purpose(id, iabId, name, description, descriptionLegal, internalPurpose.e(), false, false, false, Intrinsics.areEqual(internalPurpose.getIsSpecialFeature(), Boolean.TRUE), null, null, 3520, null);
    }

    public static final SpecialFeature d(InternalPurpose internalPurpose) {
        Intrinsics.checkNotNullParameter(internalPurpose, "<this>");
        String id = internalPurpose.getId();
        if (id == null) {
            id = "";
        }
        String iabId = internalPurpose.getIabId();
        String name = internalPurpose.getName();
        if (name == null) {
            name = "";
        }
        String description = internalPurpose.getDescription();
        if (description == null) {
            description = "";
        }
        return new SpecialFeature(id, iabId, name, description, internalPurpose.getDescriptionLegal(), internalPurpose.e());
    }

    public static final SpecialPurpose e(InternalPurpose internalPurpose) {
        Intrinsics.checkNotNullParameter(internalPurpose, "<this>");
        String id = internalPurpose.getId();
        if (id == null) {
            id = "";
        }
        String iabId = internalPurpose.getIabId();
        String name = internalPurpose.getName();
        if (name == null) {
            name = "";
        }
        String description = internalPurpose.getDescription();
        if (description == null) {
            description = "";
        }
        return new SpecialPurpose(id, iabId, name, description, internalPurpose.getDescriptionLegal(), internalPurpose.e());
    }

    public static final List<Purpose> a(Collection<InternalPurpose> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(c((InternalPurpose) it.next()));
        }
        return arrayList;
    }

    public static final List<SpecialFeature> b(Collection<InternalPurpose> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(d((InternalPurpose) it.next()));
        }
        return arrayList;
    }
}
