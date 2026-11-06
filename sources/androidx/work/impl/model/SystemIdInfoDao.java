package androidx.work.impl.model;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public interface SystemIdInfoDao {
    SystemIdInfo getSystemIdInfo(String str, int i);

    List getWorkSpecIds();

    void insertSystemIdInfo(SystemIdInfo systemIdInfo);

    void removeSystemIdInfo(String str);

    default SystemIdInfo getSystemIdInfo(WorkGenerationalId id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return getSystemIdInfo(id.getWorkSpecId(), id.getGeneration());
    }
}
