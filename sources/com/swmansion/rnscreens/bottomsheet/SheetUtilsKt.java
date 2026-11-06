package com.swmansion.rnscreens.bottomsheet;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.swmansion.rnscreens.Screen;
import com.swmansion.rnscreens.ScreenStackFragment;
import com.swmansion.rnscreens.ext.FragmentExtKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SheetUtilsKt {
    public static final boolean isSheetFitToContents(Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "<this>");
        return screen.getStackPresentation() == Screen.StackPresentation.FORM_SHEET && screen.getSheetDetents().getCount$react_native_screens_release() == 1 && screen.getSheetDetents().shortest$react_native_screens_release() == -1.0d;
    }

    public static final boolean usesFormSheetPresentation(Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "<this>");
        return screen.getStackPresentation() == Screen.StackPresentation.FORM_SHEET;
    }

    public static final boolean requiresEnterTransitionPostponing(Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "<this>");
        return !screen.getSheetShouldOverflowTopInset() && usesFormSheetPresentation(screen);
    }

    public static final boolean sheetShouldUseDimmingView(Screen screen) {
        ScreenStackFragment screenStackFragmentAsScreenStackFragment;
        SheetDelegate sheetDelegate;
        Intrinsics.checkNotNullParameter(screen, "<this>");
        Fragment fragment = screen.getFragment();
        return ((fragment == null || (screenStackFragmentAsScreenStackFragment = FragmentExtKt.asScreenStackFragment(fragment)) == null || (sheetDelegate = screenStackFragmentAsScreenStackFragment.getSheetDelegate()) == null) ? screen.getSheetInitialDetentIndex() : sheetDelegate.getLastStableDetentIndex()) > screen.getSheetLargestUndimmedDetentIndex();
    }

    public static final boolean isLaidOutOrHasCachedLayout(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return view.isLaidOut() || view.getHeight() > 0 || view.getWidth() > 0;
    }
}
