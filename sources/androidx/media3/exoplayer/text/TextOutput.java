package androidx.media3.exoplayer.text;

import androidx.media3.common.text.CueGroup;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface TextOutput {
    void onCues(CueGroup cueGroup);

    void onCues(List list);
}
