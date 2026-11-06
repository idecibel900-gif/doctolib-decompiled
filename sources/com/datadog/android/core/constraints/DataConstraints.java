package com.datadog.android.core.constraints;

import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes3.dex */
public interface DataConstraints {
    Map validateAttributes(Map map, String str, String str2, Set set);

    List validateTags(List list);

    Map validateTimings(Map map);

    public static final class DefaultImpls {
        public static /* synthetic */ Map validateAttributes$default(DataConstraints dataConstraints, Map map, String str, String str2, Set set, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: validateAttributes");
            }
            if ((i & 2) != 0) {
                str = null;
            }
            if ((i & 4) != 0) {
                str2 = null;
            }
            if ((i & 8) != 0) {
                set = SetsKt.emptySet();
            }
            return dataConstraints.validateAttributes(map, str, str2, set);
        }
    }
}
