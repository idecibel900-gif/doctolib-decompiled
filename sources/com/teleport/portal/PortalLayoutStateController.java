package com.teleport.portal;

import android.view.View;
import com.facebook.react.uimanager.StateWrapper;
import com.teleport.extensions.FloatKt;
import com.teleport.extensions.ViewKt;
import com.teleport.host.PortalHostView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class PortalLayoutStateController {
    private PortalLayoutState lastLayout;
    private final View sourceView;
    private StateWrapper stateWrapper;

    public PortalLayoutStateController(View sourceView) {
        Intrinsics.checkNotNullParameter(sourceView, "sourceView");
        this.sourceView = sourceView;
        this.lastLayout = PortalLayoutState.Companion.getEMPTY();
    }

    public final void setStateWrapper(StateWrapper stateWrapper) {
        this.stateWrapper = stateWrapper;
    }

    public final void updateIfNeeded(String str, PortalHostView portalHostView) {
        StateWrapper stateWrapper = this.stateWrapper;
        PortalHostView portalHostViewActiveHost = activeHost(str, portalHostView);
        if (stateWrapper != null) {
            if (portalHostViewActiveHost == null) {
                resetIfNeeded();
            } else {
                publishIfChanged(stateWrapper, createLayoutState(portalHostViewActiveHost));
            }
        }
    }

    public final void resetIfNeeded() {
        StateWrapper stateWrapper = this.stateWrapper;
        if (stateWrapper != null) {
            publishIfChanged(stateWrapper, PortalLayoutState.Companion.getEMPTY());
        }
    }

    private final PortalHostView activeHost(String str, PortalHostView portalHostView) {
        if (str == null || portalHostView == null || viewsAreDetached(portalHostView)) {
            return null;
        }
        return portalHostView;
    }

    private final boolean viewsAreDetached(PortalHostView portalHostView) {
        return ViewKt.isDetached(this.sourceView) || ViewKt.isDetached(portalHostView);
    }

    private final void publishIfChanged(StateWrapper stateWrapper, PortalLayoutState portalLayoutState) {
        if (Intrinsics.areEqual(this.lastLayout, portalLayoutState)) {
            return;
        }
        this.lastLayout = portalLayoutState;
        stateWrapper.updateState(portalLayoutState.toMap());
    }

    private final PortalLayoutState createLayoutState(PortalHostView portalHostView) {
        int[] iArrScreenLocation = ViewKt.screenLocation(this.sourceView);
        int[] iArrScreenLocation2 = ViewKt.screenLocation(portalHostView);
        return new PortalLayoutState(FloatKt.getDp(portalHostView.getWidth()), FloatKt.getDp(portalHostView.getHeight()), FloatKt.getDp(iArrScreenLocation2[0] - iArrScreenLocation[0]), FloatKt.getDp(iArrScreenLocation2[1] - iArrScreenLocation[1]));
    }
}
