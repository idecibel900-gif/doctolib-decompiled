package com.swmansion.enriched.markdown.utils.common;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class SegmentReconciler {
    public static final SegmentReconciler INSTANCE = new SegmentReconciler();

    private SegmentReconciler() {
    }

    /* JADX WARN: Code duplicated, block: B:68:0x01c8  */
    public final ReconciliationResult reconcile(List list, List list2, List renderedSegments, boolean z, Function2 matchesKind, Function1 createView, Function2 updateView) {
        View view;
        ArrayDeque arrayDeque;
        List<View> currentViews = list;
        Intrinsics.checkNotNullParameter(currentViews, "currentViews");
        List currentSignatures = list2;
        Intrinsics.checkNotNullParameter(currentSignatures, "currentSignatures");
        Intrinsics.checkNotNullParameter(renderedSegments, "renderedSegments");
        Intrinsics.checkNotNullParameter(matchesKind, "matchesKind");
        Intrinsics.checkNotNullParameter(createView, "createView");
        Intrinsics.checkNotNullParameter(updateView, "updateView");
        List listEmptyList = z ? currentViews : CollectionsKt.emptyList();
        if (z) {
            currentViews = CollectionsKt.emptyList();
        }
        if (z) {
            currentSignatures = CollectionsKt.emptyList();
        }
        HashMap map = new HashMap(currentSignatures.size());
        Iterator it = currentSignatures.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            Long lValueOf = Long.valueOf(((Number) it.next()).longValue());
            Object arrayDeque2 = map.get(lValueOf);
            if (arrayDeque2 == null) {
                arrayDeque2 = new ArrayDeque();
                map.put(lValueOf, arrayDeque2);
            }
            ((ArrayDeque) arrayDeque2).addLast(Integer.valueOf(i));
            i = i2;
        }
        HashMap map2 = new HashMap(renderedSegments.size());
        Iterator it2 = renderedSegments.iterator();
        while (it2.hasNext()) {
            long signature = ((RenderedSegment) it2.next()).getSignature();
            Long lValueOf2 = Long.valueOf(signature);
            Integer num = (Integer) map2.get(Long.valueOf(signature));
            map2.put(lValueOf2, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
        }
        ArrayList arrayList = new ArrayList(renderedSegments.size());
        ArrayList arrayList2 = new ArrayList(renderedSegments.size());
        HashSet hashSet = new HashSet(currentViews.size());
        ArrayList arrayList3 = new ArrayList();
        Iterator it3 = renderedSegments.iterator();
        int i3 = 0;
        while (it3.hasNext()) {
            int i4 = i3 + 1;
            RenderedSegment renderedSegment = (RenderedSegment) it3.next();
            View view2 = (View) CollectionsKt.getOrNull(currentViews, i3);
            Long l = (Long) CollectionsKt.getOrNull(currentSignatures, i3);
            long signature2 = renderedSegment.getSignature();
            Iterator it4 = it3;
            List list3 = listEmptyList;
            Object orDefault = map2.getOrDefault(Long.valueOf(signature2), 0);
            Intrinsics.checkNotNullExpressionValue(orDefault, "getOrDefault(...)");
            int iIntValue = ((Number) orDefault).intValue();
            if (iIntValue > 1) {
                map2.put(Long.valueOf(signature2), Integer.valueOf(iIntValue - 1));
            } else {
                map2.remove(Long.valueOf(signature2));
            }
            View view3 = (view2 == null || hashSet.contains(view2) || !((Boolean) matchesKind.invoke(view2, renderedSegment)).booleanValue() || l == null || l.longValue() != signature2) ? null : view2;
            if (view3 != null || (arrayDeque = (ArrayDeque) map.get(Long.valueOf(signature2))) == null) {
                view = view3;
                break;
            }
            while (true) {
                if (arrayDeque.isEmpty()) {
                    view = view3;
                    break;
                }
                View view4 = view3;
                view = (View) currentViews.get(((Number) arrayDeque.removeFirst()).intValue());
                if (!hashSet.contains(view) && ((Boolean) matchesKind.invoke(view, renderedSegment)).booleanValue()) {
                    break;
                }
                view3 = view4;
            }
            if (view != null || view2 == null || hashSet.contains(view2) || !((Boolean) matchesKind.invoke(view2, renderedSegment)).booleanValue()) {
                view2 = view;
            } else {
                if (l != null) {
                    Integer num2 = (Integer) map2.get(l);
                    if ((num2 != null ? num2.intValue() : 0) != 0) {
                        view2 = view;
                    }
                }
                updateView.invoke(view2, renderedSegment);
            }
            if (view2 == null) {
                view2 = (View) createView.invoke(renderedSegment);
                arrayList3.add(view2);
            }
            arrayList.add(view2);
            arrayList2.add(Long.valueOf(signature2));
            hashSet.add(view2);
            it3 = it4;
            i3 = i4;
            listEmptyList = list3;
        }
        List list4 = listEmptyList;
        ArrayList arrayList4 = new ArrayList(list4.size() + currentViews.size());
        arrayList4.addAll(list4);
        for (View view5 : currentViews) {
            if (!hashSet.contains(view5)) {
                arrayList4.add(view5);
            }
        }
        return new ReconciliationResult(arrayList, arrayList2, arrayList4, arrayList3);
    }
}
