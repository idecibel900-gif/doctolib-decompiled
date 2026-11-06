package com.swmansion.enriched.markdown.utils.common;

import com.amazon.a.a.o.b.f;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class StreamingMarkdownFilter {
    public static final StreamingMarkdownFilter INSTANCE = new StreamingMarkdownFilter();

    private StreamingMarkdownFilter() {
    }

    public final StreamingFilterResult renderableMarkdownForStreaming(String markdown, TableStreamingMode tableMode, CodeBlockStreamingMode codeBlockMode) {
        Intrinsics.checkNotNullParameter(markdown, "markdown");
        Intrinsics.checkNotNullParameter(tableMode, "tableMode");
        Intrinsics.checkNotNullParameter(codeBlockMode, "codeBlockMode");
        List listSplit$default = StringsKt.split$default((CharSequence) markdown, new String[]{"\n"}, false, 0, 6, (Object) null);
        int iFindOpenCodeFenceLineIndex = findOpenCodeFenceLineIndex(listSplit$default);
        if (iFindOpenCodeFenceLineIndex == -1) {
            return new StreamingFilterResult(removePendingTablesAndMath(markdown, tableMode, listSplit$default), false);
        }
        int i = buildLineOffsets(listSplit$default)[iFindOpenCodeFenceLineIndex];
        String strSubstring = markdown.substring(0, i);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        if (codeBlockMode == CodeBlockStreamingMode.HIDDEN) {
            return new StreamingFilterResult(removePendingTablesAndMath$default(this, strSubstring, tableMode, null, 4, null), false);
        }
        String strSubstring2 = markdown.substring(i);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        return new StreamingFilterResult(removePendingTablesAndMath$default(this, strSubstring, tableMode, null, 4, null) + strSubstring2, true);
    }

    static /* synthetic */ String removePendingTablesAndMath$default(StreamingMarkdownFilter streamingMarkdownFilter, String str, TableStreamingMode tableStreamingMode, List list, int i, Object obj) {
        String str2;
        if ((i & 4) != 0) {
            str2 = str;
            list = StringsKt.split$default((CharSequence) str2, new String[]{"\n"}, false, 0, 6, (Object) null);
        } else {
            str2 = str;
        }
        return streamingMarkdownFilter.removePendingTablesAndMath(str2, tableStreamingMode, list);
    }

    private final String removePendingTablesAndMath(String str, TableStreamingMode tableStreamingMode, List list) {
        String strRemovePendingStreamingMathBlock = removePendingStreamingMathBlock(str, list);
        if (strRemovePendingStreamingMathBlock.length() != str.length()) {
            list = StringsKt.split$default((CharSequence) strRemovePendingStreamingMathBlock, new String[]{"\n"}, false, 0, 6, (Object) null);
        }
        return removePendingStreamingTableBlock(strRemovePendingStreamingMathBlock, list, tableStreamingMode);
    }

    private static final class FenceMarker {

        /* JADX INFO: renamed from: char, reason: not valid java name */
        private final char f90char;
        private final String info;
        private final int length;

        public FenceMarker(char c, int i, String info) {
            Intrinsics.checkNotNullParameter(info, "info");
            this.f90char = c;
            this.length = i;
            this.info = info;
        }

        public final char getChar() {
            return this.f90char;
        }

        public final int getLength() {
            return this.length;
        }

        public final String getInfo() {
            return this.info;
        }
    }

    private final FenceMarker parseFenceMarker(String str) {
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ' && i < 3) {
            i++;
        }
        if (i >= str.length()) {
            return null;
        }
        char cCharAt = str.charAt(i);
        if (cCharAt != '`' && cCharAt != '~') {
            return null;
        }
        int i2 = 0;
        while (i < str.length() && str.charAt(i) == cCharAt) {
            i++;
            i2++;
        }
        if (i2 < 3) {
            return null;
        }
        String strSubstring = str.substring(i);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        if (cCharAt == '`' && StringsKt.contains$default((CharSequence) strSubstring, '`', false, 2, (Object) null)) {
            return null;
        }
        return new FenceMarker(cCharAt, i2, strSubstring);
    }

    private final int findOpenCodeFenceLineIndex(List list) {
        int size = list.size();
        char c = ' ';
        int i = -1;
        int length = 0;
        for (int i2 = 0; i2 < size; i2++) {
            FenceMarker fenceMarker = parseFenceMarker((String) list.get(i2));
            if (i == -1) {
                if (fenceMarker != null) {
                    c = fenceMarker.getChar();
                    length = fenceMarker.getLength();
                    i = i2;
                }
            } else if (fenceMarker != null && fenceMarker.getChar() == c && fenceMarker.getLength() >= length && StringsKt.isBlank(fenceMarker.getInfo())) {
                i = -1;
            }
        }
        return i;
    }

    private final String removePendingStreamingMathBlock(String str, List list) {
        int size = list.size();
        int i = -1;
        for (int i2 = 0; i2 < size; i2++) {
            if (lineIsBlockMathDelimiter((String) list.get(i2))) {
                i = i == -1 ? i2 : -1;
            }
        }
        if (i == -1) {
            return str;
        }
        String strSubstring = str.substring(0, buildLineOffsets(list)[i]);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    private final String removePendingStreamingTableBlock(String str, List list, TableStreamingMode tableStreamingMode) {
        int size = list.size() - 1;
        if (size < 0) {
            size = -1;
            break;
        }
        while (true) {
            int i = size - 1;
            if (!lineIsBlank((String) list.get(size))) {
                break;
            }
            if (i < 0) {
                size = -1;
                break;
            }
            size = i;
        }
        if (size == -1 || size + 1 < list.size() - 1) {
            return str;
        }
        int i2 = size;
        while (i2 > 0 && !lineIsBlank((String) list.get(i2 - 1))) {
            i2--;
        }
        if (i2 > size) {
            return str;
        }
        for (int i3 = i2; lineLooksLikeTableRow((String) list.get(i3)); i3++) {
            if (i3 == size) {
                int[] iArrBuildLineOffsets = buildLineOffsets(list);
                if (tableStreamingMode == TableStreamingMode.PROGRESSIVE) {
                    int i4 = (size - i2) + 1;
                    if (i4 < 2 || !lineLooksLikeTableSeparator((String) list.get(i2 + 1))) {
                        String strSubstring = str.substring(0, iArrBuildLineOffsets[i2]);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                        return strSubstring;
                    }
                    if (i4 <= 2) {
                        return str;
                    }
                    String str2 = (String) list.get(size);
                    String string = StringsKt.trim(str2).toString();
                    String str3 = (String) list.get(i2);
                    if (StringsKt.endsWith$default(string, f.c, false, 2, (Object) null) && pipeCount(str2) >= pipeCount(str3)) {
                        return str;
                    }
                    String strSubstring2 = str.substring(0, iArrBuildLineOffsets[size]);
                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                    return strSubstring2;
                }
                String strSubstring3 = str.substring(0, iArrBuildLineOffsets[i2]);
                Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
                return strSubstring3;
            }
        }
        return str;
    }

    private final boolean lineIsBlank(String str) {
        return StringsKt.isBlank(str);
    }

    private final boolean lineIsBlockMathDelimiter(String str) {
        return Intrinsics.areEqual(StringsKt.trim(str).toString(), "$$");
    }

    private final boolean lineLooksLikeTableRow(String str) {
        return StringsKt.startsWith$default(StringsKt.trim(str).toString(), f.c, false, 2, (Object) null);
    }

    private final boolean lineLooksLikeTableSeparator(String str) {
        String string = StringsKt.trim(str).toString();
        if (string.length() == 0 || string.charAt(0) != '|') {
            return false;
        }
        int length = string.length();
        boolean z = false;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = string.charAt(i2);
            if (cCharAt == '-') {
                i++;
                if (i >= 3) {
                    z = true;
                }
            } else {
                if (cCharAt != '|' && cCharAt != ':' && cCharAt != ' ') {
                    return false;
                }
                i = 0;
            }
        }
        return z;
    }

    private final int pipeCount(String str) {
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.charAt(i2) == '|') {
                i++;
            }
        }
        return i;
    }

    private final int[] buildLineOffsets(List list) {
        int[] iArr = new int[list.size()];
        int size = list.size();
        int length = 0;
        for (int i = 0; i < size; i++) {
            iArr[i] = length;
            length += ((String) list.get(i)).length() + 1;
        }
        return iArr;
    }
}
