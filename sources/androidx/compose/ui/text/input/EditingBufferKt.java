package androidx.compose.ui.text.input;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class EditingBufferKt {
    /* JADX INFO: renamed from: updateRangeAfterDelete-pWDy79M, reason: not valid java name */
    public static final long m2324updateRangeAfterDeletepWDy79M(long j, long j2) {
        int iM2213getLengthimpl;
        int iM2215getMinimpl = TextRange.m2215getMinimpl(j);
        int iM2214getMaximpl = TextRange.m2214getMaximpl(j);
        if (TextRange.m2219intersects5zctL8(j2, j)) {
            if (TextRange.m2207contains5zctL8(j2, j)) {
                iM2215getMinimpl = TextRange.m2215getMinimpl(j2);
                iM2214getMaximpl = iM2215getMinimpl;
            } else {
                if (TextRange.m2207contains5zctL8(j, j2)) {
                    iM2213getLengthimpl = TextRange.m2213getLengthimpl(j2);
                } else if (TextRange.m2208containsimpl(j2, iM2215getMinimpl)) {
                    iM2215getMinimpl = TextRange.m2215getMinimpl(j2);
                    iM2213getLengthimpl = TextRange.m2213getLengthimpl(j2);
                } else {
                    iM2214getMaximpl = TextRange.m2215getMinimpl(j2);
                }
                iM2214getMaximpl -= iM2213getLengthimpl;
            }
        } else if (iM2214getMaximpl > TextRange.m2215getMinimpl(j2)) {
            iM2215getMinimpl -= TextRange.m2213getLengthimpl(j2);
            iM2213getLengthimpl = TextRange.m2213getLengthimpl(j2);
            iM2214getMaximpl -= iM2213getLengthimpl;
        }
        return TextRangeKt.TextRange(iM2215getMinimpl, iM2214getMaximpl);
    }
}
