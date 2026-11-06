package com.reactnativekeyboardcontroller.traversal;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import com.facebook.react.bridge.UiThreadUtil;
import com.reactnativekeyboardcontroller.extensions.EditTextKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class ViewHierarchyNavigator {
    public static final ViewHierarchyNavigator INSTANCE = new ViewHierarchyNavigator();

    private ViewHierarchyNavigator() {
    }

    public final void setFocusTo(String direction, View view) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(view, "view");
        final EditText editTextFindNextEditText = Intrinsics.areEqual(direction, "next") ? findNextEditText(view) : findPreviousEditText(view);
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.reactnativekeyboardcontroller.traversal.ViewHierarchyNavigator$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                EditTextKt.focus(editTextFindNextEditText);
            }
        });
    }

    public final List getAllInputFields(View view) {
        ArrayList arrayList = new ArrayList();
        getAllInputFields$findEditTexts(arrayList, view);
        return arrayList;
    }

    private static final void getAllInputFields$findEditTexts(List list, View view) {
        if (INSTANCE.isValidTextInput(view)) {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.EditText");
            list.add((EditText) view);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                getAllInputFields$findEditTexts(list, viewGroup.getChildAt(i));
            }
        }
    }

    private final EditText findNextEditText(View view) {
        return findEditTextInDirection(view, 1);
    }

    private final EditText findPreviousEditText(View view) {
        return findEditTextInDirection(view, -1);
    }

    private final EditText findEditTextInDirection(View view, int i) {
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup == null) {
            return null;
        }
        int iIndexOfChild = viewGroup.indexOfChild(view);
        int i2 = i > 0 ? iIndexOfChild + 1 : iIndexOfChild - 1;
        int childCount = i > 0 ? viewGroup.getChildCount() : -1;
        while (i2 != childCount) {
            View childAt = viewGroup.getChildAt(i2);
            Intrinsics.checkNotNull(childAt);
            EditText editTextFindEditTextOrGoDeeper = findEditTextOrGoDeeper(childAt, i);
            if (editTextFindEditTextOrGoDeeper != null) {
                return editTextFindEditTextOrGoDeeper;
            }
            i2 += i;
        }
        return findEditTextInDirection(viewGroup, i);
    }

    private final EditText findEditTextInHierarchy(ViewGroup viewGroup, int i) {
        int childCount = viewGroup.getChildCount();
        IntProgression intProgressionUntil = i > 0 ? RangesKt.until(0, childCount) : RangesKt.downTo(childCount - 1, 0);
        int first = intProgressionUntil.getFirst();
        int last = intProgressionUntil.getLast();
        int step = intProgressionUntil.getStep();
        if ((step <= 0 || first > last) && (step >= 0 || last > first)) {
            return null;
        }
        while (true) {
            View childAt = viewGroup.getChildAt(first);
            Intrinsics.checkNotNull(childAt);
            EditText editTextFindEditTextOrGoDeeper = findEditTextOrGoDeeper(childAt, i);
            if (editTextFindEditTextOrGoDeeper != null) {
                return editTextFindEditTextOrGoDeeper;
            }
            if (first == last) {
                return null;
            }
            first += step;
        }
    }

    private final EditText findEditTextOrGoDeeper(View view, int i) {
        if (isValidTextInput(view)) {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.EditText");
            return (EditText) view;
        }
        if (view instanceof ViewGroup) {
            return findEditTextInHierarchy((ViewGroup) view, i);
        }
        return null;
    }

    private final boolean isValidTextInput(View view) {
        return (view instanceof EditText) && ((EditText) view).isEnabled();
    }
}
