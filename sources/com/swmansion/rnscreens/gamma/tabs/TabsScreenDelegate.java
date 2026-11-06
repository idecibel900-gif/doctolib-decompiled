package com.swmansion.rnscreens.gamma.tabs;

import android.content.res.Configuration;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes4.dex */
public interface TabsScreenDelegate {
    Fragment getFragmentForTabsScreen(TabsScreen tabsScreen);

    void onFragmentConfigurationChange(TabsScreen tabsScreen, Configuration configuration);

    void onMenuItemAttributesChange(TabsScreen tabsScreen);

    void onTabFocusChangedFromJS(TabsScreen tabsScreen, boolean z);
}
