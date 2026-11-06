package com.facebook.react.uimanager;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.logging.FLog;
import java.util.ArrayList;
import java.util.Comparator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ViewGroupDrawingOrderHelper {
    private int[] drawingOrderIndices;
    private int numberOfChildrenWithZIndex;
    private final ViewGroup viewGroup;

    public ViewGroupDrawingOrderHelper(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        this.viewGroup = viewGroup;
    }

    public final void handleAddView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (ViewGroupManager.INSTANCE.getViewZIndex(view) != null) {
            this.numberOfChildrenWithZIndex++;
        }
        this.drawingOrderIndices = null;
    }

    public final void handleRemoveView(View view) {
        if (ViewGroupManager.INSTANCE.getViewZIndex(view) != null) {
            this.numberOfChildrenWithZIndex--;
        }
        this.drawingOrderIndices = null;
    }

    public final boolean shouldEnableCustomDrawingOrder() {
        return this.numberOfChildrenWithZIndex > 0;
    }

    public final int getChildDrawingOrder(int i, int i2) {
        int[] iArr = this.drawingOrderIndices;
        if (iArr != null && (i2 >= iArr.length || iArr[i2] >= i)) {
            FLog.w("ReactNative", "getChildDrawingOrder index out of bounds! Please check any custom view manipulations you may have done. childCount = %d, index = %d", Integer.valueOf(i), Integer.valueOf(i2));
            update();
        }
        if (iArr == null) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < i; i3++) {
                arrayList.add(this.viewGroup.getChildAt(i3));
            }
            final Function2 function2 = new Function2() { // from class: com.facebook.react.uimanager.ViewGroupDrawingOrderHelper$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Integer.valueOf(ViewGroupDrawingOrderHelper.getChildDrawingOrder$lambda$0((View) obj, (View) obj2));
                }
            };
            CollectionsKt.sortWith(arrayList, new Comparator() { // from class: com.facebook.react.uimanager.ViewGroupDrawingOrderHelper$$ExternalSyntheticLambda1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return ViewGroupDrawingOrderHelper.getChildDrawingOrder$lambda$1(function2, obj, obj2);
                }
            });
            int[] iArr2 = new int[i];
            for (int i4 = 0; i4 < i; i4++) {
                Object obj = arrayList.get(i4);
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                iArr2[i4] = this.viewGroup.indexOfChild((View) obj);
            }
            this.drawingOrderIndices = iArr2;
            iArr = iArr2;
        }
        return iArr[i2];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getChildDrawingOrder$lambda$1(Function2 function2, Object obj, Object obj2) {
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getChildDrawingOrder$lambda$0(View view, View view2) {
        ViewGroupManager.Companion companion = ViewGroupManager.INSTANCE;
        Integer viewZIndex = companion.getViewZIndex(view);
        int iIntValue = viewZIndex != null ? viewZIndex.intValue() : 0;
        Integer viewZIndex2 = companion.getViewZIndex(view2);
        return iIntValue - (viewZIndex2 != null ? viewZIndex2.intValue() : 0);
    }

    public final void update() {
        this.numberOfChildrenWithZIndex = 0;
        int childCount = this.viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (ViewGroupManager.INSTANCE.getViewZIndex(this.viewGroup.getChildAt(i)) != null) {
                this.numberOfChildrenWithZIndex++;
            }
        }
        this.drawingOrderIndices = null;
    }
}
