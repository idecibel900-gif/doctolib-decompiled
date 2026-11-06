package androidx.media3.extractor;

import com.google.common.collect.ImmutableList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface Extractor {
    default Extractor getUnderlyingImplementation() {
        return this;
    }

    void init(ExtractorOutput extractorOutput);

    int read(ExtractorInput extractorInput, PositionHolder positionHolder);

    void release();

    void seek(long j, long j2);

    boolean sniff(ExtractorInput extractorInput);

    default List getSniffFailureDetails() {
        return ImmutableList.of();
    }
}
