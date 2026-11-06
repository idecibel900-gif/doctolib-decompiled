package com.swmansion.enriched.markdown.utils.text.interaction;

import android.content.Context;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.widget.TextView;
import com.swmansion.enriched.markdown.renderer.SpanStyleCache;
import com.swmansion.enriched.markdown.spans.BaseListSpan;
import com.swmansion.enriched.markdown.spans.CodeBlockSpan;
import com.swmansion.enriched.markdown.spans.ImageSpan;
import com.swmansion.enriched.markdown.spans.ListMarkerAnchorSpan;
import com.swmansion.enriched.markdown.spans.TaskListSpan;
import com.swmansion.enriched.markdown.styles.ListStyle;
import com.swmansion.enriched.markdown.styles.StyleConfig;
import com.swmansion.enriched.markdown.styles.TaskListStyle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class TaskListTapUtils {
    public static final TaskListTapUtils INSTANCE = new TaskListTapUtils();

    private TaskListTapUtils() {
    }

    public final TaskListHitTestResult hitTest(TextView textView, float f, float f2) {
        Object obj;
        Intrinsics.checkNotNullParameter(textView, "textView");
        Layout layout = textView.getLayout();
        if (layout == null) {
            return null;
        }
        CharSequence text = textView.getText();
        Spanned spanned = text instanceof Spanned ? (Spanned) text : null;
        if (spanned == null) {
            return null;
        }
        int totalPaddingLeft = (((int) f) - textView.getTotalPaddingLeft()) + textView.getScrollX();
        int lineForVertical = layout.getLineForVertical((((int) f2) - textView.getTotalPaddingTop()) + textView.getScrollY());
        Object[] spans = spanned.getSpans(layout.getLineStart(lineForVertical), layout.getLineEnd(lineForVertical), TaskListSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
        if (spans.length != 0) {
            obj = spans[0];
            int lastIndex = ArraysKt.getLastIndex(spans);
            if (lastIndex != 0) {
                int depth = ((TaskListSpan) obj).getDepth();
                int i = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        Object obj2 = spans[i];
                        int depth2 = ((TaskListSpan) obj2).getDepth();
                        if (depth < depth2) {
                            obj = obj2;
                            depth = depth2;
                        }
                        if (i == lastIndex) {
                            break;
                        }
                        i++;
                    }
                }
            }
        } else {
            obj = null;
        }
        TaskListSpan taskListSpan = (TaskListSpan) obj;
        if (taskListSpan == null) {
            return null;
        }
        if (layout.getParagraphDirection(lineForVertical) == -1) {
            if (totalPaddingLeft <= layout.getWidth() - (((int) layout.getLineRight(lineForVertical)) - layout.getParagraphRight(lineForVertical))) {
                return null;
            }
        } else {
            if (totalPaddingLeft >= layout.getParagraphLeft(lineForVertical) - ((int) layout.getLineLeft(lineForVertical))) {
                return null;
            }
        }
        return new TaskListHitTestResult(taskListSpan.getTaskIndex(), taskListSpan.isChecked(), StringsKt.trim(StringsKt.substringBefore$default(spanned.subSequence(spanned.getSpanStart(taskListSpan), spanned.getSpanEnd(taskListSpan)).toString(), '\n', (String) null, 2, (Object) null)).toString());
    }

    public final boolean updateTaskListItemCheckedState(TextView textView, int i, boolean z, StyleConfig styleConfig) {
        int i2;
        int i3;
        ImageSpan imageSpan;
        TextView textView2 = textView;
        int i4 = i;
        StyleConfig styleConfig2 = styleConfig;
        Intrinsics.checkNotNullParameter(textView2, "textView");
        Intrinsics.checkNotNullParameter(styleConfig2, "styleConfig");
        CharSequence text = textView2.getText();
        if (!(text instanceof Spannable)) {
            return false;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
        Object[] spans = spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), TaskListSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
        ArrayList<TaskListSpan> arrayList = new ArrayList();
        for (Object obj : spans) {
            if (((TaskListSpan) obj).getTaskIndex() == i4) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        if (arrayList.isEmpty()) {
            return true;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            boolean z2 = z;
            if (((TaskListSpan) it.next()).isChecked() != z2) {
                int depth = ((TaskListSpan) CollectionsKt.first((List) arrayList)).getDepth();
                Iterator it2 = arrayList.iterator();
                if (!it2.hasNext()) {
                    throw new NoSuchElementException();
                }
                int spanStart = spannableStringBuilder.getSpanStart((TaskListSpan) it2.next());
                loop2: while (true) {
                    i2 = spanStart;
                    do {
                        if (!it2.hasNext()) {
                            break loop2;
                        }
                        spanStart = spannableStringBuilder.getSpanStart((TaskListSpan) it2.next());
                    } while (i2 <= spanStart);
                }
                Iterator it3 = arrayList.iterator();
                if (!it3.hasNext()) {
                    throw new NoSuchElementException();
                }
                int spanEnd = spannableStringBuilder.getSpanEnd((TaskListSpan) it3.next());
                loop4: while (true) {
                    i3 = spanEnd;
                    do {
                        if (!it3.hasNext()) {
                            break loop4;
                        }
                        spanEnd = spannableStringBuilder.getSpanEnd((TaskListSpan) it3.next());
                    } while (i3 >= spanEnd);
                }
                SpanStyleCache spanStyleCache = new SpanStyleCache(styleConfig2);
                for (TaskListSpan taskListSpan : arrayList) {
                    int spanStart2 = spannableStringBuilder.getSpanStart(taskListSpan);
                    int spanEnd2 = spannableStringBuilder.getSpanEnd(taskListSpan);
                    spannableStringBuilder.removeSpan(taskListSpan);
                    Intrinsics.checkNotNull(taskListSpan);
                    spannableStringBuilder.setSpan(updateTaskListItemCheckedState$toggledCopy(styleConfig2, textView2, spanStyleCache, i4, z2, taskListSpan), spanStart2, spanEnd2, 33);
                    textView2 = textView;
                    z2 = z;
                    styleConfig2 = styleConfig;
                }
                Object[] spans2 = spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), ListMarkerAnchorSpan.class);
                Intrinsics.checkNotNullExpressionValue(spans2, "getSpans(...)");
                ArrayList<ListMarkerAnchorSpan> arrayList2 = new ArrayList();
                for (Object obj2 : spans2) {
                    BaseListSpan marker$react_native_enriched_markdown_release = ((ListMarkerAnchorSpan) obj2).getMarker$react_native_enriched_markdown_release();
                    TaskListSpan taskListSpan2 = marker$react_native_enriched_markdown_release instanceof TaskListSpan ? (TaskListSpan) marker$react_native_enriched_markdown_release : null;
                    if (taskListSpan2 != null && taskListSpan2.getTaskIndex() == i4) {
                        arrayList2.add(obj2);
                    }
                }
                for (ListMarkerAnchorSpan listMarkerAnchorSpan : arrayList2) {
                    int spanStart3 = spannableStringBuilder.getSpanStart(listMarkerAnchorSpan);
                    int spanEnd3 = spannableStringBuilder.getSpanEnd(listMarkerAnchorSpan);
                    spannableStringBuilder.removeSpan(listMarkerAnchorSpan);
                    BaseListSpan marker$react_native_enriched_markdown_release2 = listMarkerAnchorSpan.getMarker$react_native_enriched_markdown_release();
                    Intrinsics.checkNotNull(marker$react_native_enriched_markdown_release2, "null cannot be cast to non-null type com.swmansion.enriched.markdown.spans.TaskListSpan");
                    spannableStringBuilder.setSpan(new ListMarkerAnchorSpan(updateTaskListItemCheckedState$toggledCopy(styleConfig, textView, spanStyleCache, i4, z, (TaskListSpan) marker$react_native_enriched_markdown_release2)), spanStart3, spanEnd3, 33);
                    i4 = i;
                }
                TaskListStyle taskListStyle = styleConfig.getTaskListStyle();
                int checkedTextColor = taskListStyle.getCheckedTextColor();
                boolean checkedStrikethrough = taskListStyle.getCheckedStrikethrough();
                Object[] spans3 = spannableStringBuilder.getSpans(i2, i3, BaseListSpan.class);
                Intrinsics.checkNotNullExpressionValue(spans3, "getSpans(...)");
                ArrayList arrayList3 = new ArrayList();
                for (Object obj3 : spans3) {
                    if (((BaseListSpan) obj3).getDepth() > depth) {
                        arrayList3.add(obj3);
                    }
                }
                Object[] spans4 = spannableStringBuilder.getSpans(i2, i3, CodeBlockSpan.class);
                Intrinsics.checkNotNullExpressionValue(spans4, "getSpans(...)");
                List listPlus = CollectionsKt.plus((Collection) arrayList3, (Iterable) ArraysKt.toList(spans4));
                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listPlus, 10));
                for (Object obj4 : listPlus) {
                    arrayList4.add(TuplesKt.to(Integer.valueOf(spannableStringBuilder.getSpanStart(obj4)), Integer.valueOf(spannableStringBuilder.getSpanEnd(obj4))));
                }
                applyDecorationsToRanges(spannableStringBuilder, i2, i3, CollectionsKt.sortedWith(arrayList4, new Comparator() { // from class: com.swmansion.enriched.markdown.utils.text.interaction.TaskListTapUtils$updateTaskListItemCheckedState$$inlined$sortedBy$1
                    @Override // java.util.Comparator
                    public final int compare(Object obj5, Object obj6) {
                        return ComparisonsKt.compareValues((Integer) ((Pair) obj5).getFirst(), (Integer) ((Pair) obj6).getFirst());
                    }
                }), z, checkedTextColor, checkedStrikethrough, styleConfig);
                Spannable spannable = (Spannable) text;
                Object[] spans5 = spannable.getSpans(0, spannable.length(), ImageSpan.class);
                Intrinsics.checkNotNullExpressionValue(spans5, "getSpans(...)");
                List<ImageSpan> list = ArraysKt.toList(spans5);
                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
                for (Object obj5 : list) {
                    linkedHashMap.put(obj5, Integer.valueOf(spannable.getSpanStart((ImageSpan) obj5)));
                }
                textView.setText(spannableStringBuilder);
                ImageSpan[] imageSpanArr = (ImageSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), ImageSpan.class);
                for (ImageSpan imageSpan2 : list) {
                    Intrinsics.checkNotNull(imageSpanArr);
                    int length = imageSpanArr.length;
                    int i5 = 0;
                    while (true) {
                        if (i5 >= length) {
                            imageSpan = null;
                            break;
                        }
                        imageSpan = imageSpanArr[i5];
                        if (Intrinsics.areEqual(imageSpan.getImageUrl(), imageSpan2.getImageUrl())) {
                            int spanStart4 = spannableStringBuilder.getSpanStart(imageSpan);
                            Integer num = (Integer) linkedHashMap.get(imageSpan2);
                            if (num != null && spanStart4 == num.intValue()) {
                                break;
                            }
                        }
                        i5++;
                    }
                    if (imageSpan != null) {
                        imageSpan2 = imageSpan;
                    }
                    imageSpan2.registerTextView(textView);
                }
                textView.invalidate();
                return true;
            }
        }
        return true;
    }

    private static final TaskListSpan updateTaskListItemCheckedState$toggledCopy(StyleConfig styleConfig, TextView textView, SpanStyleCache spanStyleCache, int i, boolean z, TaskListSpan taskListSpan) {
        TaskListStyle taskListStyle = styleConfig.getTaskListStyle();
        ListStyle listStyle = styleConfig.getListStyle();
        int depth = taskListSpan.getDepth();
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return new TaskListSpan(taskListStyle, listStyle, depth, context, spanStyleCache, i, z, taskListSpan.getDrawsMarker$react_native_enriched_markdown_release());
    }

    private final void applyDecorationsToRanges(Spannable spannable, int i, int i2, List list, boolean z, int i3, boolean z2, StyleConfig styleConfig) {
        Spannable spannable2;
        int i4;
        boolean z3;
        Iterator it = list.iterator();
        int iMax = i;
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            int iIntValue = ((Number) pair.getFirst()).intValue();
            int iIntValue2 = ((Number) pair.getSecond()).intValue();
            if (iIntValue <= iMax) {
                spannable2 = spannable;
                i4 = i3;
                z3 = z2;
            } else if (z) {
                spannable2 = spannable;
                i4 = i3;
                z3 = z2;
                applyCheckedSpans(spannable2, iMax, iIntValue, i4, z3);
            } else {
                spannable2 = spannable;
                i4 = i3;
                z3 = z2;
                removeCheckedSpans(spannable2, iMax, iIntValue, styleConfig);
            }
            iMax = Math.max(iMax, iIntValue2);
            spannable = spannable2;
            i3 = i4;
            z2 = z3;
        }
        Spannable spannable3 = spannable;
        int i5 = i3;
        boolean z4 = z2;
        if (iMax < i2) {
            if (z) {
                applyCheckedSpans(spannable3, iMax, i2, i5, z4);
            } else {
                removeCheckedSpans(spannable3, iMax, i2, styleConfig);
            }
        }
    }

    private final void applyCheckedSpans(Spannable spannable, int i, int i2, int i3, boolean z) {
        if (i3 != 0) {
            spannable.setSpan(new ForegroundColorSpan(i3), i, i2, 33);
        }
        if (z) {
            spannable.setSpan(new StrikethroughSpan(), i, i2, 33);
        }
    }

    private final void removeCheckedSpans(Spannable spannable, int i, int i2, StyleConfig styleConfig) {
        StrikethroughSpan[] strikethroughSpanArr = (StrikethroughSpan[]) spannable.getSpans(i, i2, StrikethroughSpan.class);
        Intrinsics.checkNotNull(strikethroughSpanArr);
        for (StrikethroughSpan strikethroughSpan : strikethroughSpanArr) {
            spannable.removeSpan(strikethroughSpan);
        }
        ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) spannable.getSpans(i, i2, ForegroundColorSpan.class);
        Intrinsics.checkNotNull(foregroundColorSpanArr);
        for (ForegroundColorSpan foregroundColorSpan : foregroundColorSpanArr) {
            spannable.removeSpan(foregroundColorSpan);
        }
        int color = styleConfig.getListStyle().getColor();
        if (color != 0) {
            spannable.setSpan(new ForegroundColorSpan(color), i, i2, 33);
        }
    }
}
