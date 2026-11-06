package com.teleport.global;

import com.teleport.host.PortalHostView;
import com.teleport.portal.PortalView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class PortalRegistry {
    public static final PortalRegistry INSTANCE = new PortalRegistry();
    private static final Map hosts = new HashMap();
    private static final Map pendingPortals = new HashMap();

    private PortalRegistry() {
    }

    public final void registerHost(String name, PortalHostView view) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(view, "view");
        hosts.put(name, new WeakReference(view));
        notifySubscribers(name);
    }

    public final void unregisterHost(String name, int i) {
        PortalHostView portalHostView;
        Intrinsics.checkNotNullParameter(name, "name");
        Map map = hosts;
        WeakReference weakReference = (WeakReference) map.get(name);
        Integer numValueOf = (weakReference == null || (portalHostView = (PortalHostView) weakReference.get()) == null) ? null : Integer.valueOf(portalHostView.getId());
        if (numValueOf != null && numValueOf.intValue() == i) {
            map.remove(name);
            notifySubscribers(name);
        }
    }

    private final void notifySubscribers(String str) {
        List list = (List) pendingPortals.get(str);
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                PortalView portalView = (PortalView) ((WeakReference) it.next()).get();
                if (portalView != null) {
                    portalView.onHostChanged$react_native_teleport_release();
                } else {
                    it.remove();
                }
            }
        }
    }

    public final void notifyHostLayoutChanged(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        List list = (List) pendingPortals.get(name);
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                PortalView portalView = (PortalView) ((WeakReference) it.next()).get();
                if (portalView != null) {
                    portalView.onHostLayoutChanged$react_native_teleport_release();
                } else {
                    it.remove();
                }
            }
        }
    }

    public final PortalHostView getHost(String str) {
        WeakReference weakReference = (WeakReference) hosts.get(str);
        if (weakReference != null) {
            return (PortalHostView) weakReference.get();
        }
        return null;
    }

    public final void registerPendingPortal(String hostName, final PortalView portal) {
        Intrinsics.checkNotNullParameter(hostName, "hostName");
        Intrinsics.checkNotNullParameter(portal, "portal");
        Map map = pendingPortals;
        Object arrayList = map.get(hostName);
        if (arrayList == null) {
            arrayList = new ArrayList();
            map.put(hostName, arrayList);
        }
        List list = (List) arrayList;
        CollectionsKt.removeAll(list, new Function1() { // from class: com.teleport.global.PortalRegistry$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(PortalRegistry.registerPendingPortal$lambda$3(portal, (WeakReference) obj));
            }
        });
        list.add(new WeakReference(portal));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean registerPendingPortal$lambda$3(PortalView portalView, WeakReference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.get() == null || Intrinsics.areEqual(it.get(), portalView);
    }

    public final void unregisterPendingPortal(String hostName, final PortalView portal) {
        Intrinsics.checkNotNullParameter(hostName, "hostName");
        Intrinsics.checkNotNullParameter(portal, "portal");
        Map map = pendingPortals;
        List list = (List) map.get(hostName);
        if (list != null) {
            CollectionsKt.removeAll(list, new Function1() { // from class: com.teleport.global.PortalRegistry$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(PortalRegistry.unregisterPendingPortal$lambda$5$lambda$4(portal, (WeakReference) obj));
                }
            });
            if (list.isEmpty()) {
                map.remove(hostName);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean unregisterPendingPortal$lambda$5$lambda$4(PortalView portalView, WeakReference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.get() == null || Intrinsics.areEqual(it.get(), portalView);
    }
}
