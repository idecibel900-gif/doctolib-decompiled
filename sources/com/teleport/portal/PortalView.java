package com.teleport.portal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import com.facebook.react.uimanager.StateWrapper;
import com.teleport.common.ReparentableReactViewGroup;
import com.teleport.extensions.ViewKt;
import com.teleport.global.PortalRegistry;
import com.teleport.host.PortalHostView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class PortalView extends ReparentableReactViewGroup {
    private String hostName;
    private final PortalLayoutStateController layoutStateController;
    private final List ownChildren;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.layoutStateController = new PortalLayoutStateController(this);
        this.ownChildren = new ArrayList();
    }

    private final boolean isTeleported() {
        String str = this.hostName;
        return (str == null || PortalRegistry.INSTANCE.getHost(str) == null) ? false : true;
    }

    public void setStateWrapper(StateWrapper stateWrapper) {
        this.layoutStateController.setStateWrapper(stateWrapper);
        PortalLayoutStateController portalLayoutStateController = this.layoutStateController;
        String str = this.hostName;
        portalLayoutStateController.updateIfNeeded(str, PortalRegistry.INSTANCE.getHost(str));
    }

    public void setHostName(String str) {
        ViewGroup host;
        if (Intrinsics.areEqual(str, this.hostName)) {
            return;
        }
        List listExtractChildren = extractChildren(str);
        String str2 = this.hostName;
        if (str2 != null) {
            PortalRegistry.INSTANCE.unregisterPendingPortal(str2, this);
        }
        this.hostName = str;
        if (str == null || (host = PortalRegistry.INSTANCE.getHost(str)) == null) {
            host = this;
        }
        int i = 0;
        if (host instanceof PortalHostView) {
            List list = listExtractChildren;
            int size = list.size();
            while (i < size) {
                PortalHostView portalHostView = (PortalHostView) host;
                portalHostView.addView((View) listExtractChildren.get(i), portalHostView.nextInsertionIndexForChildAt(i));
                i++;
            }
            this.ownChildren.addAll(list);
        } else {
            int size2 = listExtractChildren.size();
            while (i < size2) {
                host.addView((View) listExtractChildren.get(i), i);
                i++;
            }
        }
        if (str != null) {
            PortalRegistry.INSTANCE.registerPendingPortal(str, this);
        }
        PortalLayoutStateController portalLayoutStateController = this.layoutStateController;
        String str3 = this.hostName;
        portalLayoutStateController.updateIfNeeded(str3, PortalRegistry.INSTANCE.getHost(str3));
    }

    public void cleanup() {
        String str = this.hostName;
        if (str != null) {
            PortalRegistry.INSTANCE.unregisterPendingPortal(str, this);
        }
        detachOwnChildren$default(this, null, 1, null);
        this.hostName = null;
        this.layoutStateController.resetIfNeeded();
        this.layoutStateController.setStateWrapper(null);
    }

    public final void onHostChanged$react_native_teleport_release() {
        PortalHostView host = PortalRegistry.INSTANCE.getHost(this.hostName);
        int i = 0;
        if (host != null) {
            List listExtractPhysicalChildren = this.ownChildren.isEmpty() ? extractPhysicalChildren(host) : detachOwnChildren(host);
            List list = listExtractPhysicalChildren;
            int size = list.size();
            while (i < size) {
                host.addView((View) listExtractPhysicalChildren.get(i), host.nextInsertionIndexForChildAt(i));
                i++;
            }
            this.ownChildren.addAll(list);
            return;
        }
        if (this.ownChildren.isEmpty()) {
            this.layoutStateController.resetIfNeeded();
            return;
        }
        List listDetachOwnChildren = detachOwnChildren(this);
        int size2 = listDetachOwnChildren.size();
        while (i < size2) {
            addView((View) listDetachOwnChildren.get(i), i);
            i++;
        }
        this.layoutStateController.resetIfNeeded();
    }

    public final void onHostLayoutChanged$react_native_teleport_release() {
        PortalLayoutStateController portalLayoutStateController = this.layoutStateController;
        String str = this.hostName;
        portalLayoutStateController.updateIfNeeded(str, PortalRegistry.INSTANCE.getHost(str));
    }

    private final List extractPhysicalChildren(ViewGroup viewGroup) {
        int childCount = super.getChildCount();
        ArrayList arrayList = new ArrayList(childCount);
        for (int i = 0; i < childCount; i++) {
            View childAt = super.getChildAt(i);
            if (childAt != null) {
                arrayList.add(childAt);
            }
        }
        Iterator it = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            detachFromParent((View) next, viewGroup);
        }
        return arrayList;
    }

    private final void detachFromParent(View view, ViewGroup viewGroup) {
        ViewParent parent = view.getParent();
        ViewGroup viewGroup2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup2 == null) {
            return;
        }
        if (viewGroup != null && (viewGroup2 instanceof ReparentableReactViewGroup) && ViewKt.canReparentAttached(view, viewGroup2, viewGroup)) {
            ((ReparentableReactViewGroup) viewGroup2).detachForReparent$react_native_teleport_release(view);
        } else if (viewGroup2 == this) {
            super.removeView(view);
        } else {
            viewGroup2.removeView(view);
        }
        if (view.getParent() == viewGroup2) {
            viewGroup2.endViewTransition(view);
        }
    }

    static /* synthetic */ List detachOwnChildren$default(PortalView portalView, ViewGroup viewGroup, int i, Object obj) {
        if ((i & 1) != 0) {
            viewGroup = null;
        }
        return portalView.detachOwnChildren(viewGroup);
    }

    private final List detachOwnChildren(ViewGroup viewGroup) {
        ArrayList arrayList = new ArrayList(this.ownChildren.size());
        for (Object obj : this.ownChildren) {
            Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
            View view = (View) obj;
            if (!arrayList.contains(view)) {
                arrayList.add(view);
            }
        }
        this.ownChildren.clear();
        Iterator it = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            detachFromParent((View) next, viewGroup);
        }
        return arrayList;
    }

    private final List extractChildren(String str) {
        ViewGroup host;
        if (str == null || (host = PortalRegistry.INSTANCE.getHost(str)) == null) {
            host = this;
        }
        return isTeleported() ? detachOwnChildren(host) : extractPhysicalChildren(host);
    }

    @Override // android.view.ViewGroup
    public int getChildCount() {
        if (isTeleported()) {
            return this.ownChildren.size();
        }
        return super.getChildCount();
    }

    @Override // android.view.ViewGroup
    public View getChildAt(int i) {
        if (isTeleported()) {
            return (View) CollectionsKt.getOrNull(this.ownChildren, i);
        }
        return super.getChildAt(i);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int i) {
        Intrinsics.checkNotNullParameter(child, "child");
        if (child.getParent() == null && child.isAttachedToWindow()) {
            attachDetachedView(child, i);
            return;
        }
        if (isTeleported()) {
            PortalHostView host = PortalRegistry.INSTANCE.getHost(this.hostName);
            this.ownChildren.add(i, child);
            if (host != null) {
                int iFindNextSiblingHostIndex = ViewKt.findNextSiblingHostIndex(this.ownChildren, host, i);
                if (iFindNextSiblingHostIndex >= 0) {
                    host.addView(child, iFindNextSiblingHostIndex);
                    return;
                } else {
                    host.addView(child);
                    return;
                }
            }
            return;
        }
        super.addView(child, i);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int i, ViewGroup.LayoutParams params) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(params, "params");
        if (isTeleported()) {
            PortalHostView host = PortalRegistry.INSTANCE.getHost(this.hostName);
            this.ownChildren.add(i, child);
            if (host != null) {
                int iFindNextSiblingHostIndex = ViewKt.findNextSiblingHostIndex(this.ownChildren, host, i);
                if (iFindNextSiblingHostIndex >= 0) {
                    host.addView(child, iFindNextSiblingHostIndex);
                    return;
                } else {
                    host.addView(child, params);
                    return;
                }
            }
            return;
        }
        super.addView(child, i, params);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (view == null) {
            return;
        }
        if (isTeleported()) {
            PortalHostView host = PortalRegistry.INSTANCE.getHost(this.hostName);
            if (host != null) {
                host.removeView(view);
            }
            this.ownChildren.remove(view);
            return;
        }
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        if (isTeleported()) {
            PortalHostView host = PortalRegistry.INSTANCE.getHost(this.hostName);
            View view = (View) CollectionsKt.getOrNull(this.ownChildren, i);
            if (view != null) {
                if (host != null) {
                    host.removeView(view);
                }
                this.ownChildren.remove(i);
                return;
            }
            return;
        }
        super.removeViewAt(i);
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        PortalLayoutStateController portalLayoutStateController = this.layoutStateController;
        String str = this.hostName;
        portalLayoutStateController.updateIfNeeded(str, PortalRegistry.INSTANCE.getHost(str));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.layoutStateController.resetIfNeeded();
        super.onDetachedFromWindow();
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        PortalLayoutStateController portalLayoutStateController = this.layoutStateController;
        String str = this.hostName;
        portalLayoutStateController.updateIfNeeded(str, PortalRegistry.INSTANCE.getHost(str));
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    public void addChildrenForAccessibility(ArrayList outChildren) {
        Intrinsics.checkNotNullParameter(outChildren, "outChildren");
        if (isTeleported()) {
            return;
        }
        super.addChildrenForAccessibility(outChildren);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (isTeleported()) {
            return false;
        }
        return super.dispatchPopulateAccessibilityEvent(event);
    }
}
