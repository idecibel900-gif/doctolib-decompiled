package com.swmansion.rnscreens.gamma.tabs;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class TabsScreenFragment extends Fragment {
    private final TabsScreen tabsScreen;

    public final TabsScreen getTabsScreen$react_native_screens_release() {
        return this.tabsScreen;
    }

    public TabsScreenFragment(TabsScreen tabsScreen) {
        Intrinsics.checkNotNullParameter(tabsScreen, "tabsScreen");
        this.tabsScreen = tabsScreen;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return this.tabsScreen;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        this.tabsScreen.getEventEmitter$react_native_screens_release().emitOnWillAppear();
        super.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        this.tabsScreen.getEventEmitter$react_native_screens_release().emitOnDidAppear();
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        this.tabsScreen.getEventEmitter$react_native_screens_release().emitOnWillDisappear();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        this.tabsScreen.getEventEmitter$react_native_screens_release().emitOnDidDisappear();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        this.tabsScreen.onFragmentConfigurationChange$react_native_screens_release(this, newConfig);
    }
}
