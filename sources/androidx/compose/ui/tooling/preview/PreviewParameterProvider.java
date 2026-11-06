package androidx.compose.ui.tooling.preview;

import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes.dex */
public interface PreviewParameterProvider {
    Sequence getValues();

    default int getCount() {
        return SequencesKt.count(getValues());
    }
}
