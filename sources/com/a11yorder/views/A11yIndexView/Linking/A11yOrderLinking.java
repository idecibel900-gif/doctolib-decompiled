package com.a11yorder.views.A11yIndexView.Linking;

import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class A11yOrderLinking {
    private static A11yOrderLinking instance;
    private final Map relationships = new HashMap();

    private A11yOrderLinking() {
    }

    public static synchronized A11yOrderLinking getInstance() {
        try {
            if (instance == null) {
                instance = new A11yOrderLinking();
            }
        } catch (Throwable th) {
            throw th;
        }
        return instance;
    }

    public void refreshIndexes(View view, String str, int i) {
        LinkingQueue linkingQueue = (LinkingQueue) this.relationships.get(str);
        if (linkingQueue != null) {
            linkingQueue.refreshIndexes(view, i);
        }
    }

    public void addViewRelationship(View view, String str, int i) {
        LinkingQueue linkingQueue = (LinkingQueue) this.relationships.get(str);
        if (linkingQueue == null) {
            linkingQueue = new LinkingQueue();
            this.relationships.put(str, linkingQueue);
        }
        linkingQueue.addPosition(view, i);
    }

    public void removeRelationship(String str, int i) {
        LinkingQueue linkingQueue = (LinkingQueue) this.relationships.get(str);
        if (linkingQueue == null) {
            return;
        }
        linkingQueue.removeFromOrder(i);
    }
}
