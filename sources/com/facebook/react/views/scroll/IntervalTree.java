package com.facebook.react.views.scroll;

import android.graphics.Rect;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.facebook.common.logging.FLog;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableCollection;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: loaded from: classes3.dex */
public final class IntervalTree implements Collection, KMutableCollection {
    private final boolean horizontal;
    private final Map idToIntervalNode = new LinkedHashMap();
    private IntervalNode root;

    @Override // java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return CollectionToArray.toArray(this, array);
    }

    public IntervalTree(boolean z) {
        this.horizontal = z;
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof VirtualView) {
            return contains((VirtualView) obj);
        }
        return false;
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof VirtualView) {
            return remove((VirtualView) obj);
        }
        return false;
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    static /* synthetic */ Interval rectToInterval$default(IntervalTree intervalTree, Rect rect, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        return intervalTree.rectToInterval(rect, str);
    }

    private final Interval rectToInterval(Rect rect, String str) {
        if (this.horizontal) {
            int i = rect.left;
            int i2 = rect.right;
            if (str == null) {
                str = "";
            }
            return new Interval(i, i2, str);
        }
        int i3 = rect.top;
        int i4 = rect.bottom;
        if (str == null) {
            str = "";
        }
        return new Interval(i3, i4, str);
    }

    private final int height(IntervalNode intervalNode) {
        if (intervalNode != null) {
            return intervalNode.getHeight();
        }
        return 0;
    }

    private final void updateHeight(IntervalNode intervalNode) {
        intervalNode.setHeight(Math.max(height(intervalNode.getLeft()), height(intervalNode.getRight())) + 1);
    }

    private final void updateMax(IntervalNode intervalNode) {
        int end = intervalNode.getInterval().getEnd();
        IntervalNode left = intervalNode.getLeft();
        int max = LinearLayoutManager.INVALID_OFFSET;
        int max2 = left != null ? left.getMax() : Integer.MIN_VALUE;
        IntervalNode right = intervalNode.getRight();
        if (right != null) {
            max = right.getMax();
        }
        intervalNode.setMax(Math.max(end, Math.max(max2, max)));
    }

    private final int balanceFactor(IntervalNode intervalNode) {
        if (intervalNode == null) {
            return 0;
        }
        return height(intervalNode.getLeft()) - height(intervalNode.getRight());
    }

    private final IntervalNode rotateRight(IntervalNode intervalNode) {
        IntervalNode left = intervalNode.getLeft();
        if (left == null) {
            throw new IllegalArgumentException("[IntervalTree] AVL node's left must not be null when rotating right.");
        }
        IntervalNode right = left.getRight();
        left.setRight(intervalNode);
        intervalNode.setLeft(right);
        updateHeight(intervalNode);
        updateMax(intervalNode);
        updateHeight(left);
        updateMax(left);
        return left;
    }

    private final IntervalNode rotateLeft(IntervalNode intervalNode) {
        IntervalNode right = intervalNode.getRight();
        if (right == null) {
            throw new IllegalArgumentException("[IntervalTree] AVL node's right must not be null when rotating left.");
        }
        IntervalNode left = right.getLeft();
        right.setLeft(intervalNode);
        intervalNode.setRight(left);
        updateHeight(intervalNode);
        updateMax(intervalNode);
        updateHeight(right);
        updateMax(right);
        return right;
    }

    private final IntervalNode balance(IntervalNode intervalNode) {
        updateHeight(intervalNode);
        updateMax(intervalNode);
        int iBalanceFactor = balanceFactor(intervalNode);
        if (iBalanceFactor > 1) {
            if (balanceFactor(intervalNode.getLeft()) < 0) {
                IntervalNode left = intervalNode.getLeft();
                if (left != null) {
                    intervalNode.setLeft(rotateLeft(left));
                } else {
                    throw new IllegalArgumentException("[IntervalTree] node.left must not be null when performing left rotation around it");
                }
            }
            return rotateRight(intervalNode);
        }
        if (iBalanceFactor >= -1) {
            return intervalNode;
        }
        if (balanceFactor(intervalNode.getRight()) > 0) {
            IntervalNode right = intervalNode.getRight();
            if (right != null) {
                intervalNode.setRight(rotateRight(right));
            } else {
                throw new IllegalArgumentException("[IntervalTree] node.right must not be null when performing right rotation around it");
            }
        }
        return rotateLeft(intervalNode);
    }

    private final int compareIntervals(Interval interval, Interval interval2) {
        if (interval.getStart() != interval2.getStart()) {
            return Intrinsics.compare(interval.getStart(), interval2.getStart());
        }
        return interval.getEnd() != interval2.getEnd() ? Intrinsics.compare(interval.getEnd(), interval2.getEnd()) : interval.getId().compareTo(interval2.getId());
    }

    private final IntervalNode insert(IntervalNode intervalNode, IntervalNode intervalNode2) {
        if (intervalNode == null) {
            return intervalNode2;
        }
        if (compareIntervals(intervalNode2.getInterval(), intervalNode.getInterval()) < 0) {
            intervalNode.setLeft(insert(intervalNode.getLeft(), intervalNode2));
        } else {
            intervalNode.setRight(insert(intervalNode.getRight(), intervalNode2));
        }
        return balance(intervalNode);
    }

    private final IntervalNode findMin(IntervalNode intervalNode) {
        IntervalNode intervalNodeFindMin;
        IntervalNode left = intervalNode.getLeft();
        return (left == null || (intervalNodeFindMin = findMin(left)) == null) ? intervalNode : intervalNodeFindMin;
    }

    private final IntervalNode delete(IntervalNode intervalNode, IntervalNode intervalNode2) {
        if (intervalNode == null) {
            return null;
        }
        if (compareIntervals(intervalNode2.getInterval(), intervalNode.getInterval()) < 0) {
            intervalNode.setLeft(delete(intervalNode.getLeft(), intervalNode2));
        } else if (compareIntervals(intervalNode2.getInterval(), intervalNode.getInterval()) > 0) {
            intervalNode.setRight(delete(intervalNode.getRight(), intervalNode2));
        } else if (intervalNode.getLeft() == null) {
            intervalNode = intervalNode.getRight();
        } else if (intervalNode.getRight() == null) {
            intervalNode = intervalNode.getLeft();
        } else {
            IntervalNode right = intervalNode.getRight();
            if (right != null) {
                IntervalNode intervalNodeFindMin = findMin(right);
                intervalNode.setVirtualView(intervalNodeFindMin.getVirtualView());
                intervalNode.setInterval(intervalNodeFindMin.getInterval());
                intervalNode.setRight(delete(intervalNode.getRight(), intervalNodeFindMin));
            } else {
                throw new IllegalArgumentException("[IntervalTree] node.right must not be null when finding node's successor");
            }
        }
        if (intervalNode == null) {
            return null;
        }
        return balance(intervalNode);
    }

    private final void inorderTraversal(IntervalNode intervalNode, List list) {
        if (intervalNode == null) {
            return;
        }
        inorderTraversal(intervalNode.getLeft(), list);
        list.add(intervalNode.getVirtualView());
        inorderTraversal(intervalNode.getRight(), list);
    }

    public final Set query(Rect queryRect) {
        Intrinsics.checkNotNullParameter(queryRect, "queryRect");
        Interval intervalRectToInterval$default = rectToInterval$default(this, queryRect, null, 2, null);
        HashSet hashSet = new HashSet();
        if (VirtualViewContainerKt.getIS_DEBUG_BUILD() && ReactNativeFeatureFlags.enableVirtualViewDebugFeatures()) {
            FLog.d("VirtualViewContainerStateExperimental:" + AuthorizationRequest.ResponseMode.QUERY, "Querying tree for rect " + queryRect);
        }
        queryHelper(this.root, intervalRectToInterval$default, hashSet);
        if (VirtualViewContainerKt.getIS_DEBUG_BUILD() && ReactNativeFeatureFlags.enableVirtualViewDebugFeatures()) {
            FLog.d("VirtualViewContainerStateExperimental:" + AuthorizationRequest.ResponseMode.QUERY, "Query results: " + hashSet);
        }
        return hashSet;
    }

    public final VirtualView getVirtualView(String virtualViewID) {
        Intrinsics.checkNotNullParameter(virtualViewID, "virtualViewID");
        IntervalNode intervalNode = (IntervalNode) this.idToIntervalNode.get(virtualViewID);
        if (intervalNode != null) {
            return intervalNode.getVirtualView();
        }
        return null;
    }

    @Override // java.util.Collection
    public boolean add(VirtualView element) {
        boolean z;
        Intrinsics.checkNotNullParameter(element, "element");
        String virtualViewID = element.getVirtualViewID();
        IntervalNode intervalNode = (IntervalNode) this.idToIntervalNode.get(virtualViewID);
        if (intervalNode != null) {
            this.root = delete(this.root, intervalNode);
            z = false;
        } else {
            z = true;
        }
        IntervalNode intervalNode2 = new IntervalNode(rectToInterval(element.getContainerRelativeRect(), virtualViewID), element, 0, 0, null, null, 60, null);
        this.root = insert(this.root, intervalNode2);
        this.idToIntervalNode.put(virtualViewID, intervalNode2);
        if (VirtualViewContainerKt.getIS_DEBUG_BUILD() && ReactNativeFeatureFlags.enableVirtualViewDebugFeatures()) {
            FLog.d("VirtualViewContainerStateExperimental:IntervalTree: add", "New VirtualView: (" + element.getVirtualViewID() + ", " + element.getContainerRelativeRect() + "). Node interval " + intervalNode2.getInterval().getId());
        }
        return z;
    }

    @Override // java.util.Collection
    public boolean addAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator it = elements.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (add((VirtualView) it.next())) {
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection
    public void clear() {
        this.root = null;
        this.idToIntervalNode.clear();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        ArrayList arrayList = new ArrayList();
        inorderTraversal(this.root, arrayList);
        return arrayList.iterator();
    }

    public boolean remove(VirtualView element) {
        Intrinsics.checkNotNullParameter(element, "element");
        IntervalNode intervalNode = (IntervalNode) this.idToIntervalNode.get(element.getVirtualViewID());
        if (intervalNode == null) {
            return false;
        }
        this.root = delete(this.root, intervalNode);
        this.idToIntervalNode.remove(element.getVirtualViewID());
        return true;
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator it = elements.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (remove(it.next())) {
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        throw new Error("IntervalTree does not support retainAll yet");
    }

    public int getSize() {
        return this.idToIntervalNode.size();
    }

    public boolean contains(VirtualView element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return this.idToIntervalNode.containsKey(element.getVirtualViewID());
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    private final void queryHelper(IntervalNode intervalNode, Interval interval, Set set) {
        VirtualView virtualView;
        VirtualView virtualView2;
        if (VirtualViewContainerKt.getIS_DEBUG_BUILD() && ReactNativeFeatureFlags.enableVirtualViewDebugFeatures()) {
            String str = "VirtualViewContainerStateExperimental:queryHelper";
            Rect containerRelativeRect = null;
            String virtualViewID = (intervalNode == null || (virtualView2 = intervalNode.getVirtualView()) == null) ? null : virtualView2.getVirtualViewID();
            if (intervalNode != null && (virtualView = intervalNode.getVirtualView()) != null) {
                containerRelativeRect = virtualView.getContainerRelativeRect();
            }
            FLog.d(str, "Check node (" + virtualViewID + ", " + containerRelativeRect + ") against interval(" + interval.getStart() + ", " + interval.getEnd() + ")");
        }
        if (intervalNode == null || intervalNode.getMax() <= interval.getStart()) {
            return;
        }
        queryHelper(intervalNode.getLeft(), interval, set);
        if (intervalNode.getInterval().intersects(interval)) {
            set.add(intervalNode.getVirtualView().getVirtualViewID());
        }
        if (intervalNode.getInterval().getStart() < interval.getEnd()) {
            queryHelper(intervalNode.getRight(), interval, set);
        }
    }
}
