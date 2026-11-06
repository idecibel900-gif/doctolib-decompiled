package com.swmansion.enriched.markdown.input.formatting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class InputRemend {
    public static final InputRemend INSTANCE = new InputRemend();
    private static final DelimiterPair[] DELIMITER_PAIRS = {new DelimiterPair("***", "***", true), new DelimiterPair("**", "**", true), new DelimiterPair("*", "*", true), new DelimiterPair("_", "_", true), new DelimiterPair("~~", "~~", true), new DelimiterPair("||", "||", true), new DelimiterPair("`", "`", true), new DelimiterPair("[", "]", false)};

    private static final class DelimiterPair {
        private final String close;
        private final String open;
        private final boolean symmetric;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DelimiterPair)) {
                return false;
            }
            DelimiterPair delimiterPair = (DelimiterPair) obj;
            return Intrinsics.areEqual(this.open, delimiterPair.open) && Intrinsics.areEqual(this.close, delimiterPair.close) && this.symmetric == delimiterPair.symmetric;
        }

        public int hashCode() {
            return (((this.open.hashCode() * 31) + this.close.hashCode()) * 31) + Boolean.hashCode(this.symmetric);
        }

        public String toString() {
            return "DelimiterPair(open=" + this.open + ", close=" + this.close + ", symmetric=" + this.symmetric + ")";
        }

        public DelimiterPair(String open, String close, boolean z) {
            Intrinsics.checkNotNullParameter(open, "open");
            Intrinsics.checkNotNullParameter(close, "close");
            this.open = open;
            this.close = close;
            this.symmetric = z;
        }

        public final String getOpen() {
            return this.open;
        }

        public final String getClose() {
            return this.close;
        }

        public final boolean getSymmetric() {
            return this.symmetric;
        }
    }

    private InputRemend() {
    }

    public final String complete(String markdown) {
        int i;
        Intrinsics.checkNotNullParameter(markdown, "markdown");
        if (markdown.length() == 0) {
            return markdown;
        }
        ArrayList arrayList = new ArrayList();
        int length = markdown.length();
        int i2 = 0;
        boolean z = false;
        while (i2 < length) {
            char cCharAt = markdown.charAt(i2);
            if (cCharAt != '\\' || i2 + 1 >= length) {
                boolean z2 = true;
                if (cCharAt == ']' && !z && (i = i2 + 1) < length && markdown.charAt(i) == '(') {
                    int iLastIndexOf = arrayList.lastIndexOf("[");
                    if (iLastIndexOf != -1) {
                        arrayList.subList(iLastIndexOf, arrayList.size()).clear();
                    }
                    i2 += 2;
                    z = true;
                } else if (z && cCharAt == ')') {
                    i2++;
                    z = false;
                } else {
                    if (!z) {
                        DelimiterPair[] delimiterPairArr = DELIMITER_PAIRS;
                        int length2 = delimiterPairArr.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= length2) {
                                z2 = false;
                                break;
                            }
                            DelimiterPair delimiterPair = delimiterPairArr[i3];
                            int length3 = delimiterPair.getOpen().length() + i2;
                            if (length3 <= length) {
                                String strSubstring = markdown.substring(i2, length3);
                                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                                if (delimiterPair.getSymmetric()) {
                                    if (Intrinsics.areEqual(strSubstring, delimiterPair.getOpen())) {
                                        if (!arrayList.isEmpty() && Intrinsics.areEqual(CollectionsKt.last((List) arrayList), delimiterPair.getOpen())) {
                                            arrayList.remove(CollectionsKt.getLastIndex(arrayList));
                                        } else {
                                            arrayList.add(delimiterPair.getOpen());
                                        }
                                        i2 = length3;
                                        break;
                                    }
                                } else {
                                    if (Intrinsics.areEqual(strSubstring, delimiterPair.getOpen())) {
                                        arrayList.add(delimiterPair.getOpen());
                                    } else {
                                        length3 = delimiterPair.getClose().length() + i2;
                                        if (length3 <= length) {
                                            String strSubstring2 = markdown.substring(i2, length3);
                                            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                                            if (Intrinsics.areEqual(strSubstring2, delimiterPair.getClose())) {
                                                if (!arrayList.isEmpty() && Intrinsics.areEqual(CollectionsKt.last((List) arrayList), delimiterPair.getOpen())) {
                                                    arrayList.remove(CollectionsKt.getLastIndex(arrayList));
                                                }
                                            }
                                        } else {
                                            continue;
                                        }
                                    }
                                    i2 = length3;
                                    break;
                                }
                            }
                            i3++;
                        }
                        if (!z2) {
                        }
                    }
                    i2++;
                }
            } else {
                i2 += 2;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append(")");
        }
        Iterator it = CollectionsKt.reversed(arrayList).iterator();
        while (it.hasNext()) {
            sb.append(closingFor((String) it.next()));
        }
        if (sb.length() == 0) {
            return markdown;
        }
        return markdown + ((Object) sb);
    }

    private final String closingFor(String str) {
        DelimiterPair delimiterPair;
        String close;
        DelimiterPair[] delimiterPairArr = DELIMITER_PAIRS;
        int length = delimiterPairArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                delimiterPair = null;
                break;
            }
            delimiterPair = delimiterPairArr[i];
            if (Intrinsics.areEqual(delimiterPair.getOpen(), str)) {
                break;
            }
            i++;
        }
        return (delimiterPair == null || (close = delimiterPair.getClose()) == null) ? str : close;
    }
}
