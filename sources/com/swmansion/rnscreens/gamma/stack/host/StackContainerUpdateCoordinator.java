package com.swmansion.rnscreens.gamma.stack.host;

import com.swmansion.rnscreens.gamma.stack.screen.StackScreen;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class StackContainerUpdateCoordinator {
    private final List pendingPushOperations = new ArrayList();
    private final List pendingPopOperations = new ArrayList();

    private final boolean getHasPendingOperations() {
        return (this.pendingPushOperations.isEmpty() && this.pendingPopOperations.isEmpty()) ? false : true;
    }

    public final void addPushOperation$react_native_screens_release(StackScreen stackScreen) {
        Intrinsics.checkNotNullParameter(stackScreen, "stackScreen");
        this.pendingPushOperations.add(new PushOperation(stackScreen));
    }

    public final void addPopOperation$react_native_screens_release(StackScreen stackScreen) {
        Intrinsics.checkNotNullParameter(stackScreen, "stackScreen");
        this.pendingPopOperations.add(new PopOperation(stackScreen));
    }

    public final void executePendingOperationsIfNeeded$react_native_screens_release(StackContainer container, List renderedScreens) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(renderedScreens, "renderedScreens");
        if (getHasPendingOperations()) {
            List<PopOperation> list = this.pendingPopOperations;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (PopOperation popOperation : list) {
                arrayList.add(new Pair(Integer.valueOf(renderedScreens.indexOf(popOperation.getScreen())), popOperation));
            }
            Iterator it = CollectionsKt.asReversed(CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.swmansion.rnscreens.gamma.stack.host.StackContainerUpdateCoordinator$executePendingOperationsIfNeeded$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return ComparisonsKt.compareValues((Integer) ((Pair) obj).getFirst(), (Integer) ((Pair) obj2).getFirst());
                }
            })).iterator();
            while (it.hasNext()) {
                container.enqueuePopOperation$react_native_screens_release(((PopOperation) ((Pair) it.next()).getSecond()).getScreen());
            }
            List<PushOperation> list2 = this.pendingPushOperations;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (PushOperation pushOperation : list2) {
                arrayList2.add(new Pair(Integer.valueOf(renderedScreens.indexOf(pushOperation.getScreen())), pushOperation));
            }
            Iterator it2 = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.swmansion.rnscreens.gamma.stack.host.StackContainerUpdateCoordinator$executePendingOperationsIfNeeded$$inlined$sortedBy$2
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return ComparisonsKt.compareValues((Integer) ((Pair) obj).getFirst(), (Integer) ((Pair) obj2).getFirst());
                }
            }).iterator();
            while (it2.hasNext()) {
                container.enqueuePushOperation$react_native_screens_release(((PushOperation) ((Pair) it2.next()).getSecond()).getScreen());
            }
            container.performContainerUpdateIfNeeded$react_native_screens_release();
            this.pendingPopOperations.clear();
            this.pendingPushOperations.clear();
        }
    }
}
