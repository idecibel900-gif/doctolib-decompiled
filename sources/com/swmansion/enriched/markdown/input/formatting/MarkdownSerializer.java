package com.swmansion.enriched.markdown.input.formatting;

import com.swmansion.enriched.markdown.input.model.BlockRange;
import com.swmansion.enriched.markdown.input.model.BlockType;
import com.swmansion.enriched.markdown.input.model.FormattingRange;
import com.swmansion.enriched.markdown.input.model.StyleType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class MarkdownSerializer {
    public static final MarkdownSerializer INSTANCE = new MarkdownSerializer();
    private static final Comparator BOUNDARY_COMPARATOR = new Comparator() { // from class: com.swmansion.enriched.markdown.input.formatting.MarkdownSerializer$$ExternalSyntheticLambda0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return MarkdownSerializer.BOUNDARY_COMPARATOR$lambda$0((MarkdownSerializer.BoundaryEvent) obj, (MarkdownSerializer.BoundaryEvent) obj2);
        }
    };

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StyleType.values().length];
            try {
                iArr[StyleType.BOLD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StyleType.ITALIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StyleType.UNDERLINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[StyleType.STRIKETHROUGH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[StyleType.LINK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[StyleType.SPOILER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private MarkdownSerializer() {
    }

    public final String stripZwsp(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return StringsKt.replace$default(text, "\u200b", "", false, 4, (Object) null);
    }

    public final String serialize(String text, List ranges, List blockRanges, Function1 blockPrefixProvider) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(ranges, "ranges");
        Intrinsics.checkNotNullParameter(blockRanges, "blockRanges");
        Intrinsics.checkNotNullParameter(blockPrefixProvider, "blockPrefixProvider");
        return stripZwsp(serializeWithAnchors(text, ranges, blockRanges, blockPrefixProvider));
    }

    private final String serializeWithAnchors(String str, List list, List list2, Function1 function1) {
        String strSerialize = serialize(str, list);
        if (list2.isEmpty()) {
            return strSerialize;
        }
        List listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{"\n"}, false, 0, 6, (Object) null);
        List mutableList = CollectionsKt.toMutableList((Collection) StringsKt.split$default((CharSequence) strSerialize, new String[]{"\n"}, false, 0, 6, (Object) null));
        if (listSplit$default.size() != mutableList.size()) {
            listSplit$default.size();
            mutableList.size();
            return strSerialize;
        }
        int[] iArr = new int[listSplit$default.size()];
        List list3 = listSplit$default;
        int size = list3.size();
        int length = 0;
        for (int i = 0; i < size; i++) {
            iArr[i] = length;
            length += ((String) listSplit$default.get(i)).length() + 1;
        }
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            BlockRange blockRange = (BlockRange) it.next();
            String str2 = (String) function1.invoke(blockRange);
            if (str2.length() != 0) {
                boolean z = blockRange.getLength() == 0;
                boolean zContains = BlockType.Companion.getLIST_ITEMS().contains(blockRange.getType());
                int size2 = list3.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    int i3 = iArr[i2];
                    int length2 = ((String) listSplit$default.get(i2)).length() + i3;
                    if (!z ? !(length2 < blockRange.getStart() || i3 >= blockRange.getEnd()) : i3 == blockRange.getStart()) {
                        if (!zContains || stripZwsp((String) listSplit$default.get(i2)).length() != 0) {
                            mutableList.set(i2, str2 + mutableList.get(i2));
                        }
                    }
                }
            }
        }
        return CollectionsKt.joinToString$default(mutableList, "\n", null, null, 0, null, null, 62, null);
    }

    public final String serialize(String text, List ranges) {
        int i;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(ranges, "ranges");
        if (ranges.isEmpty()) {
            return text;
        }
        ArrayList arrayList = new ArrayList(ranges.size() * 2);
        Iterator it = ranges.iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            FormattingRange formattingRange = (FormattingRange) it.next();
            int iCoerceIn = RangesKt.coerceIn(formattingRange.getStart(), 0, text.length());
            int iCoerceIn2 = RangesKt.coerceIn(formattingRange.getEnd(), 0, text.length());
            if (iCoerceIn < iCoerceIn2) {
                while (iCoerceIn < iCoerceIn2 && CharsKt.isWhitespace(text.charAt(iCoerceIn))) {
                    iCoerceIn++;
                }
                while (iCoerceIn2 > iCoerceIn && CharsKt.isWhitespace(text.charAt(iCoerceIn2 - 1))) {
                    iCoerceIn2--;
                }
                if (iCoerceIn < iCoerceIn2) {
                    arrayList.add(new BoundaryEvent(iCoerceIn, true, formattingRange.getType(), formattingRange.getUrl()));
                    arrayList.add(new BoundaryEvent(iCoerceIn2, false, formattingRange.getType(), formattingRange.getUrl()));
                }
            }
        }
        CollectionsKt.sortWith(arrayList, BOUNDARY_COMPARATOR);
        StringBuilder sb = new StringBuilder(text.length() + (arrayList.size() * 4));
        Iterator it2 = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
        while (it2.hasNext()) {
            Object next = it2.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            BoundaryEvent boundaryEvent = (BoundaryEvent) next;
            int iCoerceAtMost = RangesKt.coerceAtMost(boundaryEvent.getPosition(), text.length());
            if (iCoerceAtMost > i) {
                sb.append((CharSequence) text, i, iCoerceAtMost);
                i = iCoerceAtMost;
            }
            if (boundaryEvent.isOpening()) {
                sb.append(openingDelimiter(boundaryEvent.getType()));
            } else {
                sb.append(closingDelimiter(boundaryEvent.getType(), boundaryEvent.getUrl()));
            }
        }
        if (i < text.length()) {
            sb.append((CharSequence) text, i, text.length());
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private final String openingDelimiter(StyleType styleType) {
        switch (WhenMappings.$EnumSwitchMapping$0[styleType.ordinal()]) {
            case 1:
                return "**";
            case 2:
                return "*";
            case 3:
                return "_";
            case 4:
                return "~~";
            case 5:
                return "[";
            case 6:
                return "||";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final String closingDelimiter(StyleType styleType, String str) {
        switch (WhenMappings.$EnumSwitchMapping$0[styleType.ordinal()]) {
            case 1:
                return "**";
            case 2:
                return "*";
            case 3:
                return "_";
            case 4:
                return "~~";
            case 5:
                if (str == null) {
                    str = "";
                }
                return "](" + str + ")";
            case 6:
                return "||";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final int nestingPriority(StyleType styleType) {
        switch (WhenMappings.$EnumSwitchMapping$0[styleType.ordinal()]) {
            case 1:
                return 1;
            case 2:
                return 0;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 5;
            case 6:
                return 4;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class BoundaryEvent {
        private final boolean isOpening;
        private final int position;
        private final StyleType type;
        private final String url;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BoundaryEvent)) {
                return false;
            }
            BoundaryEvent boundaryEvent = (BoundaryEvent) obj;
            return this.position == boundaryEvent.position && this.isOpening == boundaryEvent.isOpening && this.type == boundaryEvent.type && Intrinsics.areEqual(this.url, boundaryEvent.url);
        }

        public int hashCode() {
            int iHashCode = ((((Integer.hashCode(this.position) * 31) + Boolean.hashCode(this.isOpening)) * 31) + this.type.hashCode()) * 31;
            String str = this.url;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "BoundaryEvent(position=" + this.position + ", isOpening=" + this.isOpening + ", type=" + this.type + ", url=" + this.url + ")";
        }

        public BoundaryEvent(int i, boolean z, StyleType type, String str) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.position = i;
            this.isOpening = z;
            this.type = type;
            this.url = str;
        }

        public final int getPosition() {
            return this.position;
        }

        public final boolean isOpening() {
            return this.isOpening;
        }

        public final StyleType getType() {
            return this.type;
        }

        public final String getUrl() {
            return this.url;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int BOUNDARY_COMPARATOR$lambda$0(BoundaryEvent boundaryEvent, BoundaryEvent boundaryEvent2) {
        int iNestingPriority;
        int iNestingPriority2;
        if (boundaryEvent.getPosition() != boundaryEvent2.getPosition()) {
            iNestingPriority = boundaryEvent.getPosition();
            iNestingPriority2 = boundaryEvent2.getPosition();
        } else {
            if (boundaryEvent.isOpening() != boundaryEvent2.isOpening()) {
                return boundaryEvent.isOpening() ? 1 : -1;
            }
            if (boundaryEvent.isOpening()) {
                MarkdownSerializer markdownSerializer = INSTANCE;
                iNestingPriority = markdownSerializer.nestingPriority(boundaryEvent.getType());
                iNestingPriority2 = markdownSerializer.nestingPriority(boundaryEvent2.getType());
            } else {
                MarkdownSerializer markdownSerializer2 = INSTANCE;
                return markdownSerializer2.nestingPriority(boundaryEvent2.getType()) - markdownSerializer2.nestingPriority(boundaryEvent.getType());
            }
        }
        return iNestingPriority - iNestingPriority2;
    }
}
