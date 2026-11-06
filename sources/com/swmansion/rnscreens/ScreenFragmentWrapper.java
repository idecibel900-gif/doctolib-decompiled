package com.swmansion.rnscreens;

import android.app.Activity;
import com.facebook.react.bridge.ReactContext;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface ScreenFragmentWrapper extends FragmentHolder, ScreenEventDispatcher {
    void addChildScreenContainer(ScreenContainer screenContainer);

    List getChildScreenContainers();

    Screen getScreen();

    boolean isTranslucent();

    void onContainerUpdate();

    void removeChildScreenContainer(ScreenContainer screenContainer);

    Activity tryGetActivity();

    ReactContext tryGetContext();
}
