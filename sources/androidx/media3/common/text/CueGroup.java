package androidx.media3.common.text;

import android.os.Bundle;
import androidx.media3.common.util.BundleCollectionUtil;
import androidx.media3.common.util.Util;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class CueGroup {
    private static final Ordering CUES_PRIORITY_COMPARATOR = Ordering.natural().onResultOf(new Function() { // from class: androidx.media3.common.text.CueGroup$$ExternalSyntheticLambda0
        @Override // com.google.common.base.Function
        public final Object apply(Object obj) {
            return Integer.valueOf(((Cue) obj).zIndex);
        }
    });
    public static final CueGroup EMPTY_TIME_ZERO = new CueGroup(ImmutableList.of(), 0);
    private static final String FIELD_CUES = Util.intToStringMaxRadix(0);
    private static final String FIELD_PRESENTATION_TIME_US = Util.intToStringMaxRadix(1);
    public final ImmutableList cues;
    public final long presentationTimeUs;

    public CueGroup(List list, long j) {
        this.cues = ImmutableList.sortedCopyOf(CUES_PRIORITY_COMPARATOR, list);
        this.presentationTimeUs = j;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(FIELD_CUES, BundleCollectionUtil.toBundleArrayList(filterOutBitmapCues(this.cues), new Function() { // from class: androidx.media3.common.text.CueGroup$$ExternalSyntheticLambda1
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return ((Cue) obj).toBinderBasedBundle();
            }
        }));
        bundle.putLong(FIELD_PRESENTATION_TIME_US, this.presentationTimeUs);
        return bundle;
    }

    private static ImmutableList filterOutBitmapCues(List list) {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (int i = 0; i < list.size(); i++) {
            if (((Cue) list.get(i)).bitmap == null) {
                builder.add(list.get(i));
            }
        }
        return builder.build();
    }
}
