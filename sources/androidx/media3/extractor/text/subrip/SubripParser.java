package androidx.media3.extractor.text.subrip;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.SubtitleParser;
import com.google.common.collect.ImmutableList;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class SubripParser implements SubtitleParser {
    private static final Pattern SUBRIP_TIMING_LINE = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d{3}))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d{3}))?)\\s*");
    private static final Pattern SUBRIP_TAG_PATTERN = Pattern.compile("\\{\\\\.*?\\}");
    private final StringBuilder textBuilder = new StringBuilder();
    private final ArrayList tags = new ArrayList();
    private final ParsableByteArray parsableByteArray = new ParsableByteArray();

    @Override // androidx.media3.extractor.text.SubtitleParser
    public int getCueReplacementBehavior() {
        return 1;
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public void parse(byte[] bArr, int i, int i2, SubtitleParser.OutputOptions outputOptions, Consumer consumer) {
        long j;
        String str;
        this.parsableByteArray.reset(bArr, i + i2);
        this.parsableByteArray.setPosition(i);
        Charset charsetDetectUtfCharset = detectUtfCharset(this.parsableByteArray);
        long j2 = -9223372036854775807L;
        ArrayList arrayList = (outputOptions.startTimeUs == -9223372036854775807L || !outputOptions.outputAllCues) ? null : new ArrayList();
        while (true) {
            String line = this.parsableByteArray.readLine(charsetDetectUtfCharset);
            if (line == null) {
                break;
            }
            if (!line.isEmpty()) {
                try {
                    Integer.parseInt(line);
                    String line2 = this.parsableByteArray.readLine(charsetDetectUtfCharset);
                    if (line2 == null) {
                        Log.w("SubripParser", "Unexpected end");
                        break;
                    }
                    Matcher matcher = SUBRIP_TIMING_LINE.matcher(line2);
                    if (matcher.matches()) {
                        long timecode = parseTimecode(matcher, 1);
                        long timecode2 = parseTimecode(matcher, 6);
                        int i3 = 0;
                        this.textBuilder.setLength(0);
                        this.tags.clear();
                        String line3 = this.parsableByteArray.readLine(charsetDetectUtfCharset);
                        while (!TextUtils.isEmpty(line3)) {
                            if (this.textBuilder.length() > 0) {
                                this.textBuilder.append("<br>");
                            }
                            this.textBuilder.append(processLine(line3, this.tags));
                            line3 = this.parsableByteArray.readLine(charsetDetectUtfCharset);
                        }
                        Spanned spannedFromHtml = Html.fromHtml(this.textBuilder.toString());
                        while (true) {
                            if (i3 >= this.tags.size()) {
                                str = null;
                                break;
                            }
                            str = (String) this.tags.get(i3);
                            if (str.matches("\\{\\\\an[1-9]\\}")) {
                                break;
                            } else {
                                i3++;
                            }
                        }
                        j = j2;
                        long j3 = outputOptions.startTimeUs;
                        if (j3 == j || timecode2 >= j3) {
                            consumer.accept(new CuesWithTiming(ImmutableList.of((Object) buildCue(spannedFromHtml, str)), timecode, timecode2 - timecode));
                        } else if (arrayList != null) {
                            arrayList.add(new CuesWithTiming(ImmutableList.of((Object) buildCue(spannedFromHtml, str)), timecode, timecode2 - timecode));
                        }
                    } else {
                        j = j2;
                        Log.w("SubripParser", "Skipping invalid timing: " + line2);
                    }
                    j2 = j;
                } catch (NumberFormatException unused) {
                    j = j2;
                    Log.w("SubripParser", "Skipping invalid index: " + line);
                }
            }
        }
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                consumer.accept((CuesWithTiming) it.next());
            }
        }
    }

    private Charset detectUtfCharset(ParsableByteArray parsableByteArray) {
        Charset utfCharsetFromBom = parsableByteArray.readUtfCharsetFromBom();
        return utfCharsetFromBom != null ? utfCharsetFromBom : StandardCharsets.UTF_8;
    }

    private String processLine(String str, ArrayList arrayList) {
        String strTrim = str.trim();
        StringBuilder sb = new StringBuilder(strTrim);
        Matcher matcher = SUBRIP_TAG_PATTERN.matcher(strTrim);
        int i = 0;
        while (matcher.find()) {
            String strGroup = matcher.group();
            arrayList.add(strGroup);
            int iStart = matcher.start() - i;
            int length = strGroup.length();
            sb.replace(iStart, iStart + length, "");
            i += length;
        }
        return sb.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:25:0x0059  */
    /* JADX WARN: Code duplicated, block: B:29:0x0068  */
    /* JADX WARN: Code duplicated, block: B:30:0x006c  */
    /* JADX WARN: Code duplicated, block: B:42:0x008b  */
    /* JADX WARN: Code duplicated, block: B:54:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:55:0x00b6  */
    private Cue buildCue(Spanned spanned, String str) {
        Cue.Builder text = new Cue.Builder().setText(spanned);
        if (str == null) {
            return text.build();
        }
        switch (str.hashCode()) {
            case -685620710:
                if (str.equals("{\\an1}")) {
                    text.setPositionAnchor(0);
                } else {
                    text.setPositionAnchor(1);
                }
                break;
            case -685620679:
                str.equals("{\\an2}");
                text.setPositionAnchor(1);
                break;
            case -685620648:
                if (str.equals("{\\an3}")) {
                    text.setPositionAnchor(2);
                } else {
                    text.setPositionAnchor(1);
                }
                break;
            case -685620617:
                if (str.equals("{\\an4}")) {
                    text.setPositionAnchor(0);
                } else {
                    text.setPositionAnchor(1);
                }
                break;
            case -685620586:
                str.equals("{\\an5}");
                text.setPositionAnchor(1);
                break;
            case -685620555:
                if (str.equals("{\\an6}")) {
                    text.setPositionAnchor(2);
                } else {
                    text.setPositionAnchor(1);
                }
                break;
            case -685620524:
                if (str.equals("{\\an7}")) {
                    text.setPositionAnchor(0);
                } else {
                    text.setPositionAnchor(1);
                }
                break;
            case -685620493:
                str.equals("{\\an8}");
                text.setPositionAnchor(1);
                break;
            case -685620462:
                if (str.equals("{\\an9}")) {
                    text.setPositionAnchor(2);
                } else {
                    text.setPositionAnchor(1);
                }
                break;
            default:
                text.setPositionAnchor(1);
                break;
        }
        switch (str.hashCode()) {
            case -685620710:
                if (str.equals("{\\an1}")) {
                    text.setLineAnchor(2);
                } else {
                    text.setLineAnchor(1);
                }
                break;
            case -685620679:
                if (str.equals("{\\an2}")) {
                    text.setLineAnchor(2);
                } else {
                    text.setLineAnchor(1);
                }
                break;
            case -685620648:
                if (str.equals("{\\an3}")) {
                    text.setLineAnchor(2);
                } else {
                    text.setLineAnchor(1);
                }
                break;
            case -685620617:
                str.equals("{\\an4}");
                text.setLineAnchor(1);
                break;
            case -685620586:
                str.equals("{\\an5}");
                text.setLineAnchor(1);
                break;
            case -685620555:
                str.equals("{\\an6}");
                text.setLineAnchor(1);
                break;
            case -685620524:
                if (str.equals("{\\an7}")) {
                    text.setLineAnchor(0);
                } else {
                    text.setLineAnchor(1);
                }
                break;
            case -685620493:
                if (str.equals("{\\an8}")) {
                    text.setLineAnchor(0);
                } else {
                    text.setLineAnchor(1);
                }
                break;
            case -685620462:
                if (str.equals("{\\an9}")) {
                    text.setLineAnchor(0);
                } else {
                    text.setLineAnchor(1);
                }
                break;
            default:
                text.setLineAnchor(1);
                break;
        }
        return text.setPosition(getFractionalPositionForAnchorType(text.getPositionAnchor())).setLine(getFractionalPositionForAnchorType(text.getLineAnchor()), 0).build();
    }

    private static long parseTimecode(Matcher matcher, int i) {
        String strGroup = matcher.group(i + 1);
        long j = (strGroup != null ? Long.parseLong(strGroup) * 3600000 : 0L) + (Long.parseLong((String) Assertions.checkNotNull(matcher.group(i + 2))) * 60000) + (Long.parseLong((String) Assertions.checkNotNull(matcher.group(i + 3))) * 1000);
        String strGroup2 = matcher.group(i + 4);
        if (strGroup2 != null) {
            j += Long.parseLong(strGroup2);
        }
        return j * 1000;
    }

    public static float getFractionalPositionForAnchorType(int i) {
        if (i == 0) {
            return 0.08f;
        }
        if (i == 1) {
            return 0.5f;
        }
        if (i == 2) {
            return 0.92f;
        }
        throw new IllegalArgumentException();
    }
}
