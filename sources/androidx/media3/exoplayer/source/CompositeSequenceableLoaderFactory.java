package androidx.media3.exoplayer.source;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface CompositeSequenceableLoaderFactory {
    SequenceableLoader create(List list, List list2);

    SequenceableLoader empty();
}
