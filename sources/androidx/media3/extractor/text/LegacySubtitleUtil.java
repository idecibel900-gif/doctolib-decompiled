package androidx.media3.extractor.text;

import androidx.media3.common.util.Consumer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class LegacySubtitleUtil {
    /* JADX WARN: Code duplicated, block: B:11:0x003a  */
    public static void toCuesWithTiming(Subtitle subtitle, SubtitleParser.OutputOptions outputOptions, Consumer consumer) {
        boolean z;
        int startIndex = getStartIndex(subtitle, outputOptions.startTimeUs);
        if (outputOptions.startTimeUs == -9223372036854775807L || startIndex >= subtitle.getEventTimeCount()) {
            z = false;
        } else {
            List cues = subtitle.getCues(outputOptions.startTimeUs);
            long eventTime = subtitle.getEventTime(startIndex);
            if (cues.isEmpty()) {
                z = false;
            } else {
                long j = outputOptions.startTimeUs;
                if (j < eventTime) {
                    consumer.accept(new CuesWithTiming(cues, j, eventTime - j));
                    z = true;
                } else {
                    z = false;
                }
            }
        }
        for (int i = startIndex; i < subtitle.getEventTimeCount(); i++) {
            outputSubtitleEvent(subtitle, i, consumer);
        }
        if (outputOptions.outputAllCues) {
            if (z) {
                startIndex--;
            }
            for (int i2 = 0; i2 < startIndex; i2++) {
                outputSubtitleEvent(subtitle, i2, consumer);
            }
            if (z) {
                consumer.accept(new CuesWithTiming(subtitle.getCues(outputOptions.startTimeUs), subtitle.getEventTime(startIndex), outputOptions.startTimeUs - subtitle.getEventTime(startIndex)));
            }
        }
    }

    private static int getStartIndex(Subtitle subtitle, long j) {
        if (j == -9223372036854775807L) {
            return 0;
        }
        int nextEventTimeIndex = subtitle.getNextEventTimeIndex(j);
        if (nextEventTimeIndex == -1) {
            nextEventTimeIndex = subtitle.getEventTimeCount();
        }
        return (nextEventTimeIndex <= 0 || subtitle.getEventTime(nextEventTimeIndex + (-1)) != j) ? nextEventTimeIndex : nextEventTimeIndex - 1;
    }

    private static void outputSubtitleEvent(Subtitle subtitle, int i, Consumer consumer) {
        long eventTime = subtitle.getEventTime(i);
        List cues = subtitle.getCues(eventTime);
        if (cues.isEmpty()) {
            return;
        }
        if (i == subtitle.getEventTimeCount() - 1) {
            throw new IllegalStateException();
        }
        long eventTime2 = subtitle.getEventTime(i + 1) - subtitle.getEventTime(i);
        if (eventTime2 > 0) {
            consumer.accept(new CuesWithTiming(cues, eventTime, eventTime2));
        }
    }
}
