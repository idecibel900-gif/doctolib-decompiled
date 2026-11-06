package androidx.media3.exoplayer.source;

import com.google.common.collect.ImmutableList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class DefaultCompositeSequenceableLoaderFactory implements CompositeSequenceableLoaderFactory {
    @Override // androidx.media3.exoplayer.source.CompositeSequenceableLoaderFactory
    public SequenceableLoader empty() {
        return new CompositeSequenceableLoader(ImmutableList.of(), ImmutableList.of());
    }

    @Override // androidx.media3.exoplayer.source.CompositeSequenceableLoaderFactory
    public SequenceableLoader create(List list, List list2) {
        return new CompositeSequenceableLoader(list, list2);
    }
}
