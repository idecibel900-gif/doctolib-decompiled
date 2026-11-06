package com.swmansion.rnscreens.gamma.tabs;

import android.view.Menu;
import android.view.MenuItem;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class TabsHostAppearanceCoordinatorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final MenuItem getOrCreateMenuItem(Menu menu, int i, TabsScreen tabsScreen) {
        MenuItem menuItemFindItem = menu.findItem(i);
        if (menuItemFindItem != null) {
            return menuItemFindItem;
        }
        MenuItem menuItemAdd = menu.add(0, i, 0, tabsScreen.getTabTitle());
        Intrinsics.checkNotNullExpressionValue(menuItemAdd, "add(...)");
        return menuItemAdd;
    }
}
