package com.a11yorder.views.A11yIndexView.Linking;

import android.view.View;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes3.dex */
public class LinkingQueue {
    public NavigableSet positions = new TreeSet();
    public NavigableMap viewMap = new TreeMap();

    private void linkPosition(View view, View view2) {
        if (view == null || view2 == null) {
            return;
        }
        view.setNextFocusForwardId(view2.getId());
        view.setAccessibilityTraversalBefore(view2.getId());
    }

    private void addWithLinking(int i, View view) {
        this.viewMap.put(Integer.valueOf(i), view);
        Map.Entry entryHigherEntry = this.viewMap.higherEntry(Integer.valueOf(i));
        Map.Entry entryLowerEntry = this.viewMap.lowerEntry(Integer.valueOf(i));
        if (entryLowerEntry != null) {
            linkPosition((View) entryLowerEntry.getValue(), view);
        }
        if (entryHigherEntry != null) {
            linkPosition(view, (View) entryHigherEntry.getValue());
        }
    }

    private void unlinkLast() {
        Map.Entry entryLastEntry = this.viewMap.lastEntry();
        if (entryLastEntry != null) {
            ((View) entryLastEntry.getValue()).setNextFocusForwardId(-1);
            ((View) entryLastEntry.getValue()).setAccessibilityTraversalBefore(-1);
        }
    }

    private void reLinkWithRemove(int i) {
        Map.Entry entryHigherEntry = this.viewMap.higherEntry(Integer.valueOf(i));
        Map.Entry entryLowerEntry = this.viewMap.lowerEntry(Integer.valueOf(i));
        if (entryLowerEntry != null && entryHigherEntry != null) {
            linkPosition((View) entryLowerEntry.getValue(), (View) entryHigherEntry.getValue());
        }
        boolean z = entryHigherEntry == null;
        this.viewMap.remove(Integer.valueOf(i));
        if (z) {
            unlinkLast();
        }
    }

    public void addPosition(View view, int i) {
        if (this.viewMap.get(Integer.valueOf(i)) == view) {
            return;
        }
        addWithLinking(i, view);
    }

    public void removeFromOrder(int i) {
        if (this.positions.contains(Integer.valueOf(i))) {
            reLinkWithRemove(i);
        }
    }

    public void refreshIndexes(View view, int i) {
        this.viewMap.put(Integer.valueOf(i), view);
        for (Map.Entry entry : this.viewMap.entrySet()) {
            if (entry != null) {
                View view2 = (View) entry.getValue();
                Map.Entry entryHigherEntry = this.viewMap.higherEntry((Integer) entry.getKey());
                if (entryHigherEntry != null) {
                    linkPosition(view2, (View) entryHigherEntry.getValue());
                }
            }
        }
        unlinkLast();
    }
}
