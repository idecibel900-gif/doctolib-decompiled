package com.swmansion.rnscreens;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.swmansion.rnscreens.bottomsheet.SheetUtilsKt;
import com.swmansion.rnscreens.events.StackFinishTransitioningEvent;
import com.swmansion.rnscreens.stack.views.ChildrenDrawingOrderStrategy;
import com.swmansion.rnscreens.stack.views.ReverseFromIndex;
import com.swmansion.rnscreens.stack.views.ReverseOrder;
import com.swmansion.rnscreens.stack.views.ScreensCoordinatorLayout;
import com.swmansion.rnscreens.utils.FragmentTransactionKtKt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class ScreenStack extends ScreenContainer {
    public static final Companion Companion = new Companion(null);
    private ChildrenDrawingOrderStrategy childrenDrawingOrderStrategy;
    private ScreenFragmentWrapper currentVisibleBottom;
    private List disappearingTransitioningChildren;
    private final Set dismissedWrappers;
    private final List drawingOpPool;
    private List drawingOps;
    private boolean goingForward;
    private List preloadedWrappers;
    private boolean removalTransitionStarted;
    private final ArrayList stack;
    private ScreenStackFragmentWrapper topScreenWrapper;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Screen.StackPresentation.values().length];
            try {
                iArr[Screen.StackPresentation.FORM_SHEET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ScreenStack(Context context) {
        super(context);
        this.stack = new ArrayList();
        this.dismissedWrappers = new HashSet();
        this.preloadedWrappers = new ArrayList();
        this.drawingOpPool = new ArrayList();
        this.drawingOps = new ArrayList();
        this.disappearingTransitioningChildren = new ArrayList();
    }

    public final boolean getGoingForward() {
        return this.goingForward;
    }

    public final void setGoingForward(boolean z) {
        this.goingForward = z;
    }

    public final void dismiss(ScreenStackFragmentWrapper screenFragment) {
        Intrinsics.checkNotNullParameter(screenFragment, "screenFragment");
        this.dismissedWrappers.add(screenFragment);
        performUpdatesNow();
    }

    @Override // com.swmansion.rnscreens.ScreenContainer
    public Screen getTopScreen() {
        ScreenStackFragmentWrapper screenStackFragmentWrapper = this.topScreenWrapper;
        if (screenStackFragmentWrapper != null) {
            return screenStackFragmentWrapper.getScreen();
        }
        return null;
    }

    public final ArrayList<ScreenStackFragmentWrapper> getFragments() {
        return this.stack;
    }

    public final Screen getRootScreen() {
        Object next;
        Screen screen;
        Iterator it = this.screenWrappers.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (CollectionsKt.contains(this.dismissedWrappers, (ScreenFragmentWrapper) next));
        ScreenFragmentWrapper screenFragmentWrapper = (ScreenFragmentWrapper) next;
        if (screenFragmentWrapper == null || (screen = screenFragmentWrapper.getScreen()) == null) {
            throw new IllegalStateException("[RNScreens] Stack has no root screen set");
        }
        return screen;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.swmansion.rnscreens.ScreenContainer
    public ScreenStackFragmentWrapper adapt(Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (WhenMappings.$EnumSwitchMapping$0[screen.getStackPresentation().ordinal()] == 1) {
            return new ScreenStackFragment(screen);
        }
        return new ScreenStackFragment(screen);
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(View view) {
        ChildrenDrawingOrderStrategy childrenDrawingOrderStrategy;
        Intrinsics.checkNotNullParameter(view, "view");
        if (!(view instanceof ScreensCoordinatorLayout)) {
            throw new IllegalStateException(("[RNScreens] Unexpected type of ScreenStack direct subview " + view.getClass()).toString());
        }
        super.startViewTransition(view);
        if (((ScreensCoordinatorLayout) view).getFragment$react_native_screens_release().isRemoving()) {
            this.disappearingTransitioningChildren.add(view);
        }
        if (!this.disappearingTransitioningChildren.isEmpty() && (childrenDrawingOrderStrategy = this.childrenDrawingOrderStrategy) != null) {
            childrenDrawingOrderStrategy.enable();
        }
        this.removalTransitionStarted = true;
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(View view) {
        ChildrenDrawingOrderStrategy childrenDrawingOrderStrategy;
        Intrinsics.checkNotNullParameter(view, "view");
        super.endViewTransition(view);
        this.disappearingTransitioningChildren.remove(view);
        if (this.disappearingTransitioningChildren.isEmpty() && (childrenDrawingOrderStrategy = this.childrenDrawingOrderStrategy) != null) {
            childrenDrawingOrderStrategy.disable();
        }
        if (this.removalTransitionStarted) {
            this.removalTransitionStarted = false;
            dispatchOnFinishTransitioning();
        }
    }

    public final void onViewAppearTransitionEnd() {
        if (this.removalTransitionStarted) {
            return;
        }
        dispatchOnFinishTransitioning();
    }

    public final List<String> getScreenIds() {
        ArrayList arrayList = this.screenWrappers;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((ScreenFragmentWrapper) it.next()).getScreen().getScreenId());
        }
        return arrayList2;
    }

    private final void dispatchOnFinishTransitioning() {
        int surfaceId = UIManagerHelper.getSurfaceId(this);
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ReactContext) context, getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(new StackFinishTransitioningEvent(surfaceId, getId()));
        }
    }

    @Override // com.swmansion.rnscreens.ScreenContainer
    public void removeScreenAt(int i) {
        Set set = this.dismissedWrappers;
        TypeIntrinsics.asMutableCollection(set).remove(getScreenFragmentWrapperAt(i));
        super.removeScreenAt(i);
    }

    public final boolean popToRoot() {
        int iNextIndex;
        Iterator it = this.screenWrappers.iterator();
        int i = 0;
        while (true) {
            iNextIndex = -1;
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (((ScreenFragmentWrapper) it.next()).getScreen().getActivityState() != Screen.ActivityState.INACTIVE) {
                break;
            }
            i++;
        }
        ArrayList arrayList = this.screenWrappers;
        ListIterator listIterator = arrayList.listIterator(arrayList.size());
        while (listIterator.hasPrevious()) {
            if (((ScreenFragmentWrapper) listIterator.previous()).getScreen().getActivityState() != Screen.ActivityState.INACTIVE) {
                iNextIndex = listIterator.nextIndex();
                break;
            }
        }
        if (i < 0 || iNextIndex <= i) {
            return false;
        }
        int i2 = i + 1;
        if (i2 <= iNextIndex) {
            while (true) {
                notifyScreenDetached(((ScreenFragmentWrapper) this.screenWrappers.get(i2)).getScreen());
                if (i2 == iNextIndex) {
                    break;
                }
                i2++;
            }
        }
        return true;
    }

    @Override // com.swmansion.rnscreens.ScreenContainer
    public void removeAllScreens() {
        this.dismissedWrappers.clear();
        super.removeAllScreens();
    }

    @Override // com.swmansion.rnscreens.ScreenContainer
    public boolean hasScreen(ScreenFragmentWrapper screenFragmentWrapper) {
        return super.hasScreen(screenFragmentWrapper) && !CollectionsKt.contains(this.dismissedWrappers, screenFragmentWrapper);
    }

    @Override // com.swmansion.rnscreens.ScreenContainer
    public void onUpdate() {
        Screen.StackAnimation stackAnimation;
        boolean z;
        Screen screen;
        ScreenStackFragmentWrapper screenStackFragmentWrapper;
        int iCount;
        Object obj;
        Screen screen2;
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        this.childrenDrawingOrderStrategy = null;
        Sequence sequenceFilter = SequencesKt.filter(CollectionsKt.asSequence(CollectionsKt.asReversedMutable(this.screenWrappers)), new Function1() { // from class: com.swmansion.rnscreens.ScreenStack$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return Boolean.valueOf(ScreenStack.onUpdate$lambda$5(this.f$0, (ScreenFragmentWrapper) obj2));
            }
        });
        ref$ObjectRef.element = SequencesKt.firstOrNull(sequenceFilter);
        ScreenFragmentWrapper screenFragmentWrapper = (ScreenFragmentWrapper) SequencesKt.firstOrNull(SequencesKt.dropWhile(sequenceFilter, new Function1() { // from class: com.swmansion.rnscreens.ScreenStack$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return Boolean.valueOf(ScreenStack.onUpdate$lambda$6((ScreenFragmentWrapper) obj2));
            }
        }));
        if (screenFragmentWrapper == null || screenFragmentWrapper == ref$ObjectRef.element) {
            screenFragmentWrapper = null;
        }
        ref$ObjectRef2.element = screenFragmentWrapper;
        this.currentVisibleBottom = screenFragmentWrapper;
        boolean z2 = CollectionsKt.contains(this.stack, ref$ObjectRef.element) && !CollectionsKt.contains(this.preloadedWrappers, ref$ObjectRef.element);
        Object obj2 = ref$ObjectRef.element;
        ScreenStackFragmentWrapper screenStackFragmentWrapper2 = this.topScreenWrapper;
        boolean z3 = obj2 != screenStackFragmentWrapper2;
        if (obj2 == null || z2) {
            if (obj2 == null || screenStackFragmentWrapper2 == null || !z3) {
                stackAnimation = null;
                z = true;
            } else {
                stackAnimation = (screenStackFragmentWrapper2 == null || (screen = screenStackFragmentWrapper2.getScreen()) == null) ? null : screen.getStackAnimation();
                z = false;
            }
        } else if (screenStackFragmentWrapper2 != null) {
            z = (screenStackFragmentWrapper2 != null && this.screenWrappers.contains(screenStackFragmentWrapper2)) || (((ScreenFragmentWrapper) ref$ObjectRef.element).getScreen().getReplaceAnimation() == Screen.ReplaceAnimation.PUSH);
            if (z) {
                screen2 = ((ScreenFragmentWrapper) ref$ObjectRef.element).getScreen();
            } else {
                ScreenStackFragmentWrapper screenStackFragmentWrapper3 = this.topScreenWrapper;
                if (screenStackFragmentWrapper3 == null || (screen2 = screenStackFragmentWrapper3.getScreen()) == null) {
                    stackAnimation = null;
                }
            }
            stackAnimation = screen2.getStackAnimation();
        } else {
            stackAnimation = Screen.StackAnimation.NONE;
            this.goingForward = true;
            z = true;
        }
        this.goingForward = z;
        if (z && (obj = ref$ObjectRef.element) != null && Companion.needsDrawReordering((ScreenFragmentWrapper) obj, stackAnimation) && ref$ObjectRef2.element == null) {
            this.childrenDrawingOrderStrategy = new ReverseOrder();
        } else if (ref$ObjectRef.element != null && z2 && (screenStackFragmentWrapper = this.topScreenWrapper) != null && screenStackFragmentWrapper.isTranslucent() && !((ScreenFragmentWrapper) ref$ObjectRef.element).isTranslucent() && (iCount = SequencesKt.count(SequencesKt.takeWhile(CollectionsKt.asSequence(CollectionsKt.asReversedMutable(this.stack)), new Function1() { // from class: com.swmansion.rnscreens.ScreenStack$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj3) {
                return Boolean.valueOf(ScreenStack.onUpdate$lambda$9(ref$ObjectRef, (ScreenStackFragmentWrapper) obj3));
            }
        }))) > 1) {
            this.childrenDrawingOrderStrategy = new ReverseFromIndex(Math.max((CollectionsKt.getLastIndex(this.stack) - iCount) + 1, 0));
        }
        FragmentTransaction fragmentTransactionCreateTransaction = createTransaction();
        if (stackAnimation != null) {
            FragmentTransactionKtKt.setTweenAnimations(fragmentTransactionCreateTransaction, stackAnimation, z);
        }
        Iterator it = SequencesKt.filter(CollectionsKt.asSequence(this.stack), new Function1() { // from class: com.swmansion.rnscreens.ScreenStack$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj3) {
                return Boolean.valueOf(ScreenStack.onUpdate$lambda$20$lambda$10(this.f$0, (ScreenStackFragmentWrapper) obj3));
            }
        }).iterator();
        while (it.hasNext()) {
            fragmentTransactionCreateTransaction.remove(((ScreenStackFragmentWrapper) it.next()).getFragment());
        }
        Iterator it2 = SequencesKt.filter(SequencesKt.takeWhile(CollectionsKt.asSequence(this.screenWrappers), new Function1() { // from class: com.swmansion.rnscreens.ScreenStack$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj3) {
                return Boolean.valueOf(ScreenStack.onUpdate$lambda$20$lambda$12(ref$ObjectRef2, (ScreenFragmentWrapper) obj3));
            }
        }), new Function1() { // from class: com.swmansion.rnscreens.ScreenStack$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj3) {
                return Boolean.valueOf(ScreenStack.onUpdate$lambda$20$lambda$13(ref$ObjectRef, this, (ScreenFragmentWrapper) obj3));
            }
        }).iterator();
        while (it2.hasNext()) {
            fragmentTransactionCreateTransaction.remove(((ScreenFragmentWrapper) it2.next()).getFragment());
        }
        Object obj3 = ref$ObjectRef2.element;
        if (obj3 != null && !((ScreenFragmentWrapper) obj3).getFragment().isAdded()) {
            final ScreenFragmentWrapper screenFragmentWrapper2 = (ScreenFragmentWrapper) ref$ObjectRef.element;
            Iterator it3 = SequencesKt.dropWhile(CollectionsKt.asSequence(this.screenWrappers), new Function1() { // from class: com.swmansion.rnscreens.ScreenStack$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj4) {
                    return Boolean.valueOf(ScreenStack.onUpdate$lambda$20$lambda$15(ref$ObjectRef2, (ScreenFragmentWrapper) obj4));
                }
            }).iterator();
            while (it3.hasNext()) {
                fragmentTransactionCreateTransaction.add(getId(), ((ScreenFragmentWrapper) it3.next()).getFragment()).runOnCommit(new Runnable() { // from class: com.swmansion.rnscreens.ScreenStack$$ExternalSyntheticLambda7
                    @Override // java.lang.Runnable
                    public final void run() {
                        ScreenStack.onUpdate$lambda$20$lambda$17$lambda$16(screenFragmentWrapper2);
                    }
                });
            }
        } else {
            Object obj4 = ref$ObjectRef.element;
            if (obj4 != null && !((ScreenFragmentWrapper) obj4).getFragment().isAdded()) {
                if (SheetUtilsKt.requiresEnterTransitionPostponing(((ScreenFragmentWrapper) ref$ObjectRef.element).getScreen())) {
                    ((ScreenFragmentWrapper) ref$ObjectRef.element).getFragment().postponeEnterTransition();
                }
                fragmentTransactionCreateTransaction.add(getId(), ((ScreenFragmentWrapper) ref$ObjectRef.element).getFragment());
            }
        }
        Object obj5 = ref$ObjectRef.element;
        this.topScreenWrapper = obj5 instanceof ScreenStackFragmentWrapper ? (ScreenStackFragmentWrapper) obj5 : null;
        this.stack.clear();
        CollectionsKt.addAll(this.stack, SequencesKt.map(CollectionsKt.asSequence(this.screenWrappers), new Function1() { // from class: com.swmansion.rnscreens.ScreenStack$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj6) {
                return ScreenStack.onUpdate$lambda$20$lambda$18((ScreenFragmentWrapper) obj6);
            }
        }));
        this.preloadedWrappers = SequencesKt.toList(SequencesKt.filter(CollectionsKt.asSequence(this.screenWrappers), new Function1() { // from class: com.swmansion.rnscreens.ScreenStack$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj6) {
                return Boolean.valueOf(ScreenStack.onUpdate$lambda$20$lambda$19((ScreenFragmentWrapper) obj6));
            }
        }));
        updateA11yForVisibleScreens$react_native_screens_release();
        fragmentTransactionCreateTransaction.commitNowAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onUpdate$lambda$5(ScreenStack screenStack, ScreenFragmentWrapper it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (CollectionsKt.contains(screenStack.dismissedWrappers, it) || it.getScreen().getActivityState() == Screen.ActivityState.INACTIVE) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onUpdate$lambda$6(ScreenFragmentWrapper it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.isTranslucent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onUpdate$lambda$9(Ref$ObjectRef ref$ObjectRef, ScreenStackFragmentWrapper it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it != ref$ObjectRef.element && it.isTranslucent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onUpdate$lambda$20$lambda$10(ScreenStack screenStack, ScreenStackFragmentWrapper wrapper) {
        Intrinsics.checkNotNullParameter(wrapper, "wrapper");
        return !screenStack.screenWrappers.contains(wrapper) || screenStack.dismissedWrappers.contains(wrapper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onUpdate$lambda$20$lambda$12(Ref$ObjectRef ref$ObjectRef, ScreenFragmentWrapper it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it != ref$ObjectRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onUpdate$lambda$20$lambda$13(Ref$ObjectRef ref$ObjectRef, ScreenStack screenStack, ScreenFragmentWrapper it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !(it == ref$ObjectRef.element || CollectionsKt.contains(screenStack.dismissedWrappers, it)) || it.getScreen().getActivityState() == Screen.ActivityState.INACTIVE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onUpdate$lambda$20$lambda$15(Ref$ObjectRef ref$ObjectRef, ScreenFragmentWrapper it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it != ref$ObjectRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onUpdate$lambda$20$lambda$17$lambda$16(ScreenFragmentWrapper screenFragmentWrapper) {
        Screen screen;
        if (screenFragmentWrapper == null || (screen = screenFragmentWrapper.getScreen()) == null) {
            return;
        }
        screen.bringToFront();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScreenStackFragmentWrapper onUpdate$lambda$20$lambda$18(ScreenFragmentWrapper it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (ScreenStackFragmentWrapper) it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onUpdate$lambda$20$lambda$19(ScreenFragmentWrapper it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getScreen().getActivityState() == Screen.ActivityState.INACTIVE;
    }

    public final void updateA11yForVisibleScreens$react_native_screens_release() {
        if (this.screenWrappers.size() > 1 && this.currentVisibleBottom != null && this.topScreenWrapper != null) {
            boolean zShouldDisableFocusabilityBeneathTopScreen = shouldDisableFocusabilityBeneathTopScreen();
            ArrayList arrayList = this.screenWrappers;
            for (ScreenFragmentWrapper screenFragmentWrapper : CollectionsKt.asReversed(CollectionsKt.slice(arrayList, RangesKt.until(0, arrayList.size() - 1)))) {
                screenFragmentWrapper.getScreen().changeAccessibilityMode(zShouldDisableFocusabilityBeneathTopScreen ? 4 : 0);
                changeScreenFocusability(screenFragmentWrapper.getScreen(), !zShouldDisableFocusabilityBeneathTopScreen);
                if (Intrinsics.areEqual(screenFragmentWrapper, this.currentVisibleBottom)) {
                    break;
                }
            }
        }
        Screen topScreen = getTopScreen();
        if (topScreen != null) {
            topScreen.changeAccessibilityMode(0);
        }
        Screen topScreen2 = getTopScreen();
        if (topScreen2 != null) {
            changeScreenFocusability(topScreen2, true);
        }
    }

    private final boolean shouldDisableFocusabilityBeneathTopScreen() {
        ScreenStackFragmentWrapper screenStackFragmentWrapper = this.topScreenWrapper;
        if (screenStackFragmentWrapper == null) {
            return false;
        }
        if (SheetUtilsKt.usesFormSheetPresentation(screenStackFragmentWrapper.getScreen())) {
            return SheetUtilsKt.sheetShouldUseDimmingView(screenStackFragmentWrapper.getScreen());
        }
        return screenStackFragmentWrapper.isTranslucent();
    }

    private final void changeScreenFocusability(Screen screen, boolean z) {
        int i = z ? 262144 : 393216;
        if (Build.VERSION.SDK_INT >= 26) {
            screen.changeFocusability$react_native_screens_release(z ? 16 : 0, i);
        } else {
            screen.changeFocusabilityCompat$react_native_screens_release(z, i);
        }
    }

    @Override // com.swmansion.rnscreens.ScreenContainer
    protected void notifyContainerUpdate() {
        Iterator it = this.stack.iterator();
        while (it.hasNext()) {
            ((ScreenStackFragmentWrapper) it.next()).onContainerUpdate();
        }
    }

    private final void drawAndRelease() {
        List<DrawingOp> list = this.drawingOps;
        this.drawingOps = new ArrayList();
        for (DrawingOp drawingOp : list) {
            drawingOp.draw();
            this.drawingOpPool.add(drawingOp);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.dispatchDraw(canvas);
        ChildrenDrawingOrderStrategy childrenDrawingOrderStrategy = this.childrenDrawingOrderStrategy;
        if (childrenDrawingOrderStrategy != null) {
            childrenDrawingOrderStrategy.apply(this.drawingOps);
        }
        drawAndRelease();
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View child, long j) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(child, "child");
        List list = this.drawingOps;
        DrawingOp drawingOpObtainDrawingOp = obtainDrawingOp();
        drawingOpObtainDrawingOp.setCanvas(canvas);
        drawingOpObtainDrawingOp.setChild(child);
        drawingOpObtainDrawingOp.setDrawingTime(j);
        list.add(drawingOpObtainDrawingOp);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performDraw(DrawingOp drawingOp) {
        Canvas canvas = drawingOp.getCanvas();
        Intrinsics.checkNotNull(canvas);
        super.drawChild(canvas, drawingOp.getChild(), drawingOp.getDrawingTime());
    }

    private final DrawingOp obtainDrawingOp() {
        if (this.drawingOpPool.isEmpty()) {
            return new DrawingOp();
        }
        List list = this.drawingOpPool;
        return (DrawingOp) list.remove(CollectionsKt.getLastIndex(list));
    }

    public final class DrawingOp {
        private Canvas canvas;
        private View child;
        private long drawingTime;

        public DrawingOp() {
        }

        public final Canvas getCanvas() {
            return this.canvas;
        }

        public final void setCanvas(Canvas canvas) {
            this.canvas = canvas;
        }

        public final View getChild() {
            return this.child;
        }

        public final void setChild(View view) {
            this.child = view;
        }

        public final long getDrawingTime() {
            return this.drawingTime;
        }

        public final void setDrawingTime(long j) {
            this.drawingTime = j;
        }

        public final void draw() {
            ScreenStack.this.performDraw(this);
            this.canvas = null;
            this.child = null;
            this.drawingTime = 0L;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean needsDrawReordering(ScreenFragmentWrapper screenFragmentWrapper, Screen.StackAnimation stackAnimation) {
            if (stackAnimation == null) {
                stackAnimation = screenFragmentWrapper.getScreen().getStackAnimation();
            }
            return (Build.VERSION.SDK_INT >= 33 || stackAnimation == Screen.StackAnimation.SLIDE_FROM_BOTTOM || stackAnimation == Screen.StackAnimation.FADE_FROM_BOTTOM || stackAnimation == Screen.StackAnimation.IOS_FROM_RIGHT || stackAnimation == Screen.StackAnimation.IOS_FROM_LEFT) && stackAnimation != Screen.StackAnimation.NONE;
        }
    }
}
