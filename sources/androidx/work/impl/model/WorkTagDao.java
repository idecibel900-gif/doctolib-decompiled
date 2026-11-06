package androidx.work.impl.model;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public interface WorkTagDao {
    void deleteByWorkSpecId(String str);

    List getTagsForWorkSpecId(String str);

    void insert(WorkTag workTag);

    default void insertTags(String id, Set tags) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Iterator it = tags.iterator();
        while (it.hasNext()) {
            insert(new WorkTag((String) it.next(), id));
        }
    }
}
