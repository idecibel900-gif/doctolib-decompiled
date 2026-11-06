package com.swmansion.rnscreens.gamma.tabs;

import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarItemView;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class TabsHostA11yCoordinator {
    private final BottomNavigationView bottomNavigationView;
    private final List tabsScreenFragments;

    public TabsHostA11yCoordinator(BottomNavigationView bottomNavigationView, List tabsScreenFragments) {
        Intrinsics.checkNotNullParameter(bottomNavigationView, "bottomNavigationView");
        Intrinsics.checkNotNullParameter(tabsScreenFragments, "tabsScreenFragments");
        this.bottomNavigationView = bottomNavigationView;
        this.tabsScreenFragments = tabsScreenFragments;
    }

    public final void setA11yPropertiesToTabItem(MenuItem menuItem, TabsScreen tabsScreen) {
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        Intrinsics.checkNotNullParameter(tabsScreen, "tabsScreen");
        NavigationBarItemView navigationBarItemView = (NavigationBarItemView) this.bottomNavigationView.findViewById(menuItem.getItemId());
        if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setContentDescription(tabsScreen.getTabBarItemAccessibilityLabel());
        }
        navigationBarItemView.setTag(tabsScreen.getTabBarItemTestID());
    }

    public final void setA11yPropertiesToAllTabItems() {
        int i = 0;
        for (Object obj : this.tabsScreenFragments) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Menu menu = this.bottomNavigationView.getMenu();
            Intrinsics.checkNotNullExpressionValue(menu, "getMenu(...)");
            setA11yPropertiesToTabItem(menu.getItem(i), ((TabsScreenFragment) obj).getTabsScreen$react_native_screens_release());
            i = i2;
        }
    }
}
