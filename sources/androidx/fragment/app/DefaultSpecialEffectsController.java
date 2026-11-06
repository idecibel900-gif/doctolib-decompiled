package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.BackEventCompat;
import androidx.collection.ArrayMap;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: loaded from: classes.dex */
public final class DefaultSpecialEffectsController extends SpecialEffectsController {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultSpecialEffectsController(ViewGroup container) {
        super(container);
        Intrinsics.checkNotNullParameter(container, "container");
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00a7  */
    @Override // androidx.fragment.app.SpecialEffectsController
    public void collectEffects(List operations, boolean z) {
        Object obj;
        Object next;
        Intrinsics.checkNotNullParameter(operations, "operations");
        FragmentManager.isLoggingEnabled(2);
        Iterator it = operations.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            SpecialEffectsController.Operation operation = (SpecialEffectsController.Operation) next;
            SpecialEffectsController.Operation.State.Companion companion = SpecialEffectsController.Operation.State.Companion;
            View view = operation.getFragment().mView;
            Intrinsics.checkNotNullExpressionValue(view, "operation.fragment.mView");
            SpecialEffectsController.Operation.State stateAsOperationState = companion.asOperationState(view);
            SpecialEffectsController.Operation.State state = SpecialEffectsController.Operation.State.VISIBLE;
            if (stateAsOperationState == state && operation.getFinalState() != state) {
                break;
            }
        }
        SpecialEffectsController.Operation operation2 = (SpecialEffectsController.Operation) next;
        ListIterator listIterator = operations.listIterator(operations.size());
        while (listIterator.hasPrevious()) {
            Object objPrevious = listIterator.previous();
            SpecialEffectsController.Operation operation3 = (SpecialEffectsController.Operation) objPrevious;
            SpecialEffectsController.Operation.State.Companion companion2 = SpecialEffectsController.Operation.State.Companion;
            View view2 = operation3.getFragment().mView;
            Intrinsics.checkNotNullExpressionValue(view2, "operation.fragment.mView");
            SpecialEffectsController.Operation.State stateAsOperationState2 = companion2.asOperationState(view2);
            SpecialEffectsController.Operation.State state2 = SpecialEffectsController.Operation.State.VISIBLE;
            if (stateAsOperationState2 != state2 && operation3.getFinalState() == state2) {
                obj = objPrevious;
                break;
            }
        }
        SpecialEffectsController.Operation operation4 = (SpecialEffectsController.Operation) obj;
        if (FragmentManager.isLoggingEnabled(2)) {
            Objects.toString(operation2);
            Objects.toString(operation4);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        syncAnimations(operations);
        Iterator it2 = operations.iterator();
        while (it2.hasNext()) {
            final SpecialEffectsController.Operation operation5 = (SpecialEffectsController.Operation) it2.next();
            arrayList.add(new AnimationInfo(operation5, z));
            boolean z2 = false;
            if (z) {
                if (operation5 == operation2) {
                    z2 = true;
                }
            } else if (operation5 == operation4) {
                z2 = true;
            }
            arrayList2.add(new TransitionInfo(operation5, z, z2));
            operation5.addCompletionListener(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultSpecialEffectsController.collectEffects$lambda$2(this.f$0, operation5);
                }
            });
        }
        createTransitionEffect(arrayList2, z, operation2, operation4);
        collectAnimEffects(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void collectEffects$lambda$2(DefaultSpecialEffectsController this$0, SpecialEffectsController.Operation operation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(operation, "$operation");
        this$0.applyContainerChangesToOperation$fragment_release(operation);
    }

    private final void syncAnimations(List list) {
        Fragment fragment = ((SpecialEffectsController.Operation) CollectionsKt.last(list)).getFragment();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            SpecialEffectsController.Operation operation = (SpecialEffectsController.Operation) it.next();
            operation.getFragment().mAnimationInfo.mEnterAnim = fragment.mAnimationInfo.mEnterAnim;
            operation.getFragment().mAnimationInfo.mExitAnim = fragment.mAnimationInfo.mExitAnim;
            operation.getFragment().mAnimationInfo.mPopEnterAnim = fragment.mAnimationInfo.mPopEnterAnim;
            operation.getFragment().mAnimationInfo.mPopExitAnim = fragment.mAnimationInfo.mPopExitAnim;
        }
    }

    private final void collectAnimEffects(List list) {
        ArrayList<AnimationInfo> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList2, ((AnimationInfo) it.next()).getOperation().getEffects$fragment_release());
        }
        boolean zIsEmpty = arrayList2.isEmpty();
        Iterator it2 = list.iterator();
        boolean z = false;
        while (it2.hasNext()) {
            AnimationInfo animationInfo = (AnimationInfo) it2.next();
            Context context = getContainer().getContext();
            SpecialEffectsController.Operation operation = animationInfo.getOperation();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            FragmentAnim.AnimationOrAnimator animation = animationInfo.getAnimation(context);
            if (animation != null) {
                if (animation.animator == null) {
                    arrayList.add(animationInfo);
                } else {
                    Fragment fragment = operation.getFragment();
                    if (!operation.getEffects$fragment_release().isEmpty()) {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Objects.toString(fragment);
                        }
                    } else {
                        if (operation.getFinalState() == SpecialEffectsController.Operation.State.GONE) {
                            operation.setAwaitingContainerChanges(false);
                        }
                        operation.addEffect(new AnimatorEffect(animationInfo));
                        z = true;
                    }
                }
            }
        }
        for (AnimationInfo animationInfo2 : arrayList) {
            SpecialEffectsController.Operation operation2 = animationInfo2.getOperation();
            Fragment fragment2 = operation2.getFragment();
            if (zIsEmpty) {
                if (z) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Objects.toString(fragment2);
                    }
                } else {
                    operation2.addEffect(new AnimationEffect(animationInfo2));
                }
            } else if (FragmentManager.isLoggingEnabled(2)) {
                Objects.toString(fragment2);
            }
        }
    }

    private final void createTransitionEffect(List list, boolean z, SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2) {
        Object objWrapTransitionInSet;
        Pair pair;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!((TransitionInfo) obj).isVisibilityUnchanged()) {
                arrayList.add(obj);
            }
        }
        ArrayList<TransitionInfo> arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (((TransitionInfo) obj2).getHandlingImpl() != null) {
                arrayList2.add(obj2);
            }
        }
        FragmentTransitionImpl fragmentTransitionImpl = null;
        for (TransitionInfo transitionInfo : arrayList2) {
            FragmentTransitionImpl handlingImpl = transitionInfo.getHandlingImpl();
            if (fragmentTransitionImpl != null && handlingImpl != fragmentTransitionImpl) {
                throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + transitionInfo.getOperation().getFragment() + " returned Transition " + transitionInfo.getTransition() + " which uses a different Transition type than other Fragments.").toString());
            }
            fragmentTransitionImpl = handlingImpl;
        }
        if (fragmentTransitionImpl == null) {
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayMap arrayMap = new ArrayMap();
        ArrayList<String> arrayList5 = new ArrayList<>();
        ArrayList<String> arrayList6 = new ArrayList<>();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        Iterator it = arrayList2.iterator();
        ArrayList<String> sharedElementTargetNames = arrayList5;
        ArrayList<String> sharedElementSourceNames = arrayList6;
        loop3: while (true) {
            objWrapTransitionInSet = null;
            while (true) {
                if (!it.hasNext()) {
                    break loop3;
                }
                TransitionInfo transitionInfo2 = (TransitionInfo) it.next();
                if (transitionInfo2.hasSharedElementTransition() && operation != null && operation2 != null) {
                    objWrapTransitionInSet = fragmentTransitionImpl.wrapTransitionInSet(fragmentTransitionImpl.cloneTransition(transitionInfo2.getSharedElementTransition()));
                    sharedElementSourceNames = operation2.getFragment().getSharedElementSourceNames();
                    Intrinsics.checkNotNullExpressionValue(sharedElementSourceNames, "lastIn.fragment.sharedElementSourceNames");
                    ArrayList<String> sharedElementSourceNames2 = operation.getFragment().getSharedElementSourceNames();
                    Intrinsics.checkNotNullExpressionValue(sharedElementSourceNames2, "firstOut.fragment.sharedElementSourceNames");
                    ArrayList<String> sharedElementTargetNames2 = operation.getFragment().getSharedElementTargetNames();
                    Intrinsics.checkNotNullExpressionValue(sharedElementTargetNames2, "firstOut.fragment.sharedElementTargetNames");
                    int size = sharedElementTargetNames2.size();
                    int i = 0;
                    while (i < size) {
                        int iIndexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames2.get(i));
                        ArrayList<String> arrayList7 = sharedElementTargetNames2;
                        if (iIndexOf != -1) {
                            sharedElementSourceNames.set(iIndexOf, sharedElementSourceNames2.get(i));
                        }
                        i++;
                        sharedElementTargetNames2 = arrayList7;
                    }
                    sharedElementTargetNames = operation2.getFragment().getSharedElementTargetNames();
                    Intrinsics.checkNotNullExpressionValue(sharedElementTargetNames, "lastIn.fragment.sharedElementTargetNames");
                    if (z) {
                        operation.getFragment().getEnterTransitionCallback();
                        operation2.getFragment().getExitTransitionCallback();
                        pair = TuplesKt.to(null, null);
                    } else {
                        operation.getFragment().getExitTransitionCallback();
                        operation2.getFragment().getEnterTransitionCallback();
                        pair = TuplesKt.to(null, null);
                    }
                    MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(pair.getFirst());
                    MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(pair.getSecond());
                    int i2 = 0;
                    for (int size2 = sharedElementSourceNames.size(); i2 < size2; size2 = size2) {
                        String str = sharedElementSourceNames.get(i2);
                        Intrinsics.checkNotNullExpressionValue(str, "exitingNames[i]");
                        String str2 = sharedElementTargetNames.get(i2);
                        Intrinsics.checkNotNullExpressionValue(str2, "enteringNames[i]");
                        arrayMap.put(str, str2);
                        i2++;
                    }
                    if (FragmentManager.isLoggingEnabled(2)) {
                        for (String str3 : sharedElementTargetNames) {
                        }
                        for (String str4 : sharedElementSourceNames) {
                        }
                    }
                    View view = operation.getFragment().mView;
                    Intrinsics.checkNotNullExpressionValue(view, "firstOut.fragment.mView");
                    findNamedViews(arrayMap2, view);
                    arrayMap2.retainAll(sharedElementSourceNames);
                    arrayMap.retainAll(arrayMap2.keySet());
                    View view2 = operation2.getFragment().mView;
                    Intrinsics.checkNotNullExpressionValue(view2, "lastIn.fragment.mView");
                    findNamedViews(arrayMap3, view2);
                    arrayMap3.retainAll(sharedElementTargetNames);
                    arrayMap3.retainAll(arrayMap.values());
                    FragmentTransition.retainValues(arrayMap, arrayMap3);
                    Collection collectionKeySet = arrayMap.keySet();
                    Intrinsics.checkNotNullExpressionValue(collectionKeySet, "sharedElementNameMapping.keys");
                    retainMatchingViews(arrayMap2, collectionKeySet);
                    Collection collectionValues = arrayMap.values();
                    Intrinsics.checkNotNullExpressionValue(collectionValues, "sharedElementNameMapping.values");
                    retainMatchingViews(arrayMap3, collectionValues);
                    if (arrayMap.isEmpty()) {
                        break;
                    }
                }
            }
            Objects.toString(objWrapTransitionInSet);
            operation.toString();
            operation2.toString();
            arrayList3.clear();
            arrayList4.clear();
        }
        if (objWrapTransitionInSet == null) {
            if (arrayList2.isEmpty()) {
                return;
            }
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                if (((TransitionInfo) it2.next()).getTransition() == null) {
                }
            }
            return;
        }
        TransitionEffect transitionEffect = new TransitionEffect(arrayList2, operation, operation2, fragmentTransitionImpl, objWrapTransitionInSet, arrayList3, arrayList4, arrayMap, sharedElementTargetNames, sharedElementSourceNames, arrayMap2, arrayMap3, z);
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            ((TransitionInfo) it3.next()).getOperation().addEffect(transitionEffect);
        }
    }

    private final void retainMatchingViews(ArrayMap arrayMap, final Collection collection) {
        Set entries = arrayMap.entrySet();
        Intrinsics.checkNotNullExpressionValue(entries, "entries");
        CollectionsKt.retainAll(entries, new Function1() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.retainMatchingViews.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Map.Entry entry) {
                Intrinsics.checkNotNullParameter(entry, "entry");
                return Boolean.valueOf(CollectionsKt.contains(collection, ViewCompat.getTransitionName((View) entry.getValue())));
            }
        });
    }

    private final void findNamedViews(Map map, View view) {
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            map.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = viewGroup.getChildAt(i);
                if (child.getVisibility() == 0) {
                    Intrinsics.checkNotNullExpressionValue(child, "child");
                    findNamedViews(map, child);
                }
            }
        }
    }

    public static class SpecialEffectsInfo {
        private final SpecialEffectsController.Operation operation;

        public SpecialEffectsInfo(SpecialEffectsController.Operation operation) {
            Intrinsics.checkNotNullParameter(operation, "operation");
            this.operation = operation;
        }

        public final SpecialEffectsController.Operation getOperation() {
            return this.operation;
        }

        public final boolean isVisibilityUnchanged() {
            View view = this.operation.getFragment().mView;
            SpecialEffectsController.Operation.State stateAsOperationState = view != null ? SpecialEffectsController.Operation.State.Companion.asOperationState(view) : null;
            SpecialEffectsController.Operation.State finalState = this.operation.getFinalState();
            if (stateAsOperationState == finalState) {
                return true;
            }
            SpecialEffectsController.Operation.State state = SpecialEffectsController.Operation.State.VISIBLE;
            return (stateAsOperationState == state || finalState == state) ? false : true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class AnimationInfo extends SpecialEffectsInfo {
        private FragmentAnim.AnimationOrAnimator animation;
        private boolean isAnimLoaded;
        private final boolean isPop;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnimationInfo(SpecialEffectsController.Operation operation, boolean z) {
            super(operation);
            Intrinsics.checkNotNullParameter(operation, "operation");
            this.isPop = z;
        }

        public final FragmentAnim.AnimationOrAnimator getAnimation(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (this.isAnimLoaded) {
                return this.animation;
            }
            FragmentAnim.AnimationOrAnimator animationOrAnimatorLoadAnimation = FragmentAnim.loadAnimation(context, getOperation().getFragment(), getOperation().getFinalState() == SpecialEffectsController.Operation.State.VISIBLE, this.isPop);
            this.animation = animationOrAnimatorLoadAnimation;
            this.isAnimLoaded = true;
            return animationOrAnimatorLoadAnimation;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class TransitionInfo extends SpecialEffectsInfo {
        private final boolean isOverlapAllowed;
        private final Object sharedElementTransition;
        private final Object transition;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TransitionInfo(SpecialEffectsController.Operation operation, boolean z, boolean z2) {
            Object returnTransition;
            boolean allowEnterTransitionOverlap;
            Object sharedElementEnterTransition;
            super(operation);
            Intrinsics.checkNotNullParameter(operation, "operation");
            SpecialEffectsController.Operation.State finalState = operation.getFinalState();
            SpecialEffectsController.Operation.State state = SpecialEffectsController.Operation.State.VISIBLE;
            if (finalState == state) {
                Fragment fragment = operation.getFragment();
                returnTransition = z ? fragment.getReenterTransition() : fragment.getEnterTransition();
            } else {
                Fragment fragment2 = operation.getFragment();
                returnTransition = z ? fragment2.getReturnTransition() : fragment2.getExitTransition();
            }
            this.transition = returnTransition;
            if (operation.getFinalState() != state) {
                allowEnterTransitionOverlap = true;
            } else if (z) {
                allowEnterTransitionOverlap = operation.getFragment().getAllowReturnTransitionOverlap();
            } else {
                allowEnterTransitionOverlap = operation.getFragment().getAllowEnterTransitionOverlap();
            }
            this.isOverlapAllowed = allowEnterTransitionOverlap;
            if (!z2) {
                sharedElementEnterTransition = null;
            } else if (z) {
                sharedElementEnterTransition = operation.getFragment().getSharedElementReturnTransition();
            } else {
                sharedElementEnterTransition = operation.getFragment().getSharedElementEnterTransition();
            }
            this.sharedElementTransition = sharedElementEnterTransition;
        }

        public final Object getTransition() {
            return this.transition;
        }

        public final boolean isOverlapAllowed() {
            return this.isOverlapAllowed;
        }

        public final Object getSharedElementTransition() {
            return this.sharedElementTransition;
        }

        public final boolean hasSharedElementTransition() {
            return this.sharedElementTransition != null;
        }

        public final FragmentTransitionImpl getHandlingImpl() {
            FragmentTransitionImpl handlingImpl = getHandlingImpl(this.transition);
            FragmentTransitionImpl handlingImpl2 = getHandlingImpl(this.sharedElementTransition);
            if (handlingImpl == null || handlingImpl2 == null || handlingImpl == handlingImpl2) {
                return handlingImpl == null ? handlingImpl2 : handlingImpl;
            }
            throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + getOperation().getFragment() + " returned Transition " + this.transition + " which uses a different Transition  type than its shared element transition " + this.sharedElementTransition).toString());
        }

        private final FragmentTransitionImpl getHandlingImpl(Object obj) {
            if (obj == null) {
                return null;
            }
            FragmentTransitionImpl fragmentTransitionImpl = FragmentTransition.PLATFORM_IMPL;
            if (fragmentTransitionImpl != null && fragmentTransitionImpl.canHandle(obj)) {
                return fragmentTransitionImpl;
            }
            FragmentTransitionImpl fragmentTransitionImpl2 = FragmentTransition.SUPPORT_IMPL;
            if (fragmentTransitionImpl2 != null && fragmentTransitionImpl2.canHandle(obj)) {
                return fragmentTransitionImpl2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + getOperation().getFragment() + " is not a valid framework Transition or AndroidX Transition");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class AnimationEffect extends SpecialEffectsController.Effect {
        private final AnimationInfo animationInfo;

        public AnimationEffect(AnimationInfo animationInfo) {
            Intrinsics.checkNotNullParameter(animationInfo, "animationInfo");
            this.animationInfo = animationInfo;
        }

        public final AnimationInfo getAnimationInfo() {
            return this.animationInfo;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Effect
        public void onCommit(ViewGroup container) {
            Intrinsics.checkNotNullParameter(container, "container");
            if (this.animationInfo.isVisibilityUnchanged()) {
                this.animationInfo.getOperation().completeEffect(this);
                return;
            }
            Context context = container.getContext();
            SpecialEffectsController.Operation operation = this.animationInfo.getOperation();
            View view = operation.getFragment().mView;
            AnimationInfo animationInfo = this.animationInfo;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            FragmentAnim.AnimationOrAnimator animation = animationInfo.getAnimation(context);
            if (animation == null) {
                throw new IllegalStateException("Required value was null.");
            }
            Animation animation2 = animation.animation;
            if (animation2 == null) {
                throw new IllegalStateException("Required value was null.");
            }
            if (operation.getFinalState() != SpecialEffectsController.Operation.State.REMOVED) {
                view.startAnimation(animation2);
                this.animationInfo.getOperation().completeEffect(this);
                return;
            }
            container.startViewTransition(view);
            FragmentAnim.EndViewTransitionAnimation endViewTransitionAnimation = new FragmentAnim.EndViewTransitionAnimation(animation2, container, view);
            endViewTransitionAnimation.setAnimationListener(new DefaultSpecialEffectsController$AnimationEffect$onCommit$1(operation, container, view, this));
            view.startAnimation(endViewTransitionAnimation);
            if (FragmentManager.isLoggingEnabled(2)) {
                operation.toString();
            }
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Effect
        public void onCancel(ViewGroup container) {
            Intrinsics.checkNotNullParameter(container, "container");
            SpecialEffectsController.Operation operation = this.animationInfo.getOperation();
            View view = operation.getFragment().mView;
            view.clearAnimation();
            container.endViewTransition(view);
            this.animationInfo.getOperation().completeEffect(this);
            if (FragmentManager.isLoggingEnabled(2)) {
                operation.toString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class AnimatorEffect extends SpecialEffectsController.Effect {
        private AnimatorSet animator;
        private final AnimationInfo animatorInfo;

        @Override // androidx.fragment.app.SpecialEffectsController.Effect
        public boolean isSeekingSupported() {
            return true;
        }

        public AnimatorEffect(AnimationInfo animatorInfo) {
            Intrinsics.checkNotNullParameter(animatorInfo, "animatorInfo");
            this.animatorInfo = animatorInfo;
        }

        public final AnimationInfo getAnimatorInfo() {
            return this.animatorInfo;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Effect
        public void onStart(final ViewGroup container) {
            final AnimatorEffect animatorEffect;
            Intrinsics.checkNotNullParameter(container, "container");
            if (this.animatorInfo.isVisibilityUnchanged()) {
                return;
            }
            Context context = container.getContext();
            AnimationInfo animationInfo = this.animatorInfo;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            FragmentAnim.AnimationOrAnimator animation = animationInfo.getAnimation(context);
            this.animator = animation != null ? animation.animator : null;
            final SpecialEffectsController.Operation operation = this.animatorInfo.getOperation();
            Fragment fragment = operation.getFragment();
            final boolean z = operation.getFinalState() == SpecialEffectsController.Operation.State.GONE;
            final View view = fragment.mView;
            container.startViewTransition(view);
            AnimatorSet animatorSet = this.animator;
            if (animatorSet != null) {
                animatorEffect = this;
                animatorSet.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.DefaultSpecialEffectsController$AnimatorEffect$onStart$1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator anim) {
                        Intrinsics.checkNotNullParameter(anim, "anim");
                        container.endViewTransition(view);
                        if (z || operation.getFinalState() == SpecialEffectsController.Operation.State.GONE) {
                            SpecialEffectsController.Operation.State finalState = operation.getFinalState();
                            View viewToAnimate = view;
                            Intrinsics.checkNotNullExpressionValue(viewToAnimate, "viewToAnimate");
                            finalState.applyState(viewToAnimate, container);
                        }
                        animatorEffect.getAnimatorInfo().getOperation().completeEffect(animatorEffect);
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Objects.toString(operation);
                        }
                    }
                });
            } else {
                animatorEffect = this;
            }
            AnimatorSet animatorSet2 = animatorEffect.animator;
            if (animatorSet2 != null) {
                animatorSet2.setTarget(view);
            }
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Effect
        public void onProgress(BackEventCompat backEvent, ViewGroup container) {
            Intrinsics.checkNotNullParameter(backEvent, "backEvent");
            Intrinsics.checkNotNullParameter(container, "container");
            SpecialEffectsController.Operation operation = this.animatorInfo.getOperation();
            AnimatorSet animatorSet = this.animator;
            if (animatorSet == null) {
                this.animatorInfo.getOperation().completeEffect(this);
                return;
            }
            if (Build.VERSION.SDK_INT < 34 || !operation.getFragment().mTransitioning) {
                return;
            }
            if (FragmentManager.isLoggingEnabled(2)) {
                operation.toString();
            }
            long j = Api24Impl.INSTANCE.totalDuration(animatorSet);
            long progress = (long) (backEvent.getProgress() * j);
            if (progress == 0) {
                progress = 1;
            }
            if (progress == j) {
                progress = j - 1;
            }
            if (FragmentManager.isLoggingEnabled(2)) {
                animatorSet.toString();
                operation.toString();
            }
            Api26Impl.INSTANCE.setCurrentPlayTime(animatorSet, progress);
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Effect
        public void onCommit(ViewGroup container) {
            Intrinsics.checkNotNullParameter(container, "container");
            SpecialEffectsController.Operation operation = this.animatorInfo.getOperation();
            AnimatorSet animatorSet = this.animator;
            if (animatorSet == null) {
                this.animatorInfo.getOperation().completeEffect(this);
                return;
            }
            animatorSet.start();
            if (FragmentManager.isLoggingEnabled(2)) {
                Objects.toString(operation);
            }
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Effect
        public void onCancel(ViewGroup container) {
            Intrinsics.checkNotNullParameter(container, "container");
            AnimatorSet animatorSet = this.animator;
            if (animatorSet == null) {
                this.animatorInfo.getOperation().completeEffect(this);
                return;
            }
            SpecialEffectsController.Operation operation = this.animatorInfo.getOperation();
            if (operation.isSeeking()) {
                if (Build.VERSION.SDK_INT >= 26) {
                    Api26Impl.INSTANCE.reverse(animatorSet);
                }
            } else {
                animatorSet.end();
            }
            if (FragmentManager.isLoggingEnabled(2)) {
                operation.toString();
                operation.isSeeking();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class TransitionEffect extends SpecialEffectsController.Effect {
        private Object controller;
        private final ArrayList enteringNames;
        private final ArrayList exitingNames;
        private final SpecialEffectsController.Operation firstOut;
        private final ArrayMap firstOutViews;
        private final boolean isPop;
        private final SpecialEffectsController.Operation lastIn;
        private final ArrayMap lastInViews;
        private boolean noControllerReturned;
        private final ArrayList sharedElementFirstOutViews;
        private final ArrayList sharedElementLastInViews;
        private final ArrayMap sharedElementNameMapping;
        private final Object sharedElementTransition;
        private final FragmentTransitionImpl transitionImpl;
        private final List transitionInfos;
        private final CancellationSignal transitionSignal;

        public final List getTransitionInfos() {
            return this.transitionInfos;
        }

        public final SpecialEffectsController.Operation getFirstOut() {
            return this.firstOut;
        }

        public final SpecialEffectsController.Operation getLastIn() {
            return this.lastIn;
        }

        public final FragmentTransitionImpl getTransitionImpl() {
            return this.transitionImpl;
        }

        public TransitionEffect(List transitionInfos, SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2, FragmentTransitionImpl transitionImpl, Object obj, ArrayList sharedElementFirstOutViews, ArrayList sharedElementLastInViews, ArrayMap sharedElementNameMapping, ArrayList enteringNames, ArrayList exitingNames, ArrayMap firstOutViews, ArrayMap lastInViews, boolean z) {
            Intrinsics.checkNotNullParameter(transitionInfos, "transitionInfos");
            Intrinsics.checkNotNullParameter(transitionImpl, "transitionImpl");
            Intrinsics.checkNotNullParameter(sharedElementFirstOutViews, "sharedElementFirstOutViews");
            Intrinsics.checkNotNullParameter(sharedElementLastInViews, "sharedElementLastInViews");
            Intrinsics.checkNotNullParameter(sharedElementNameMapping, "sharedElementNameMapping");
            Intrinsics.checkNotNullParameter(enteringNames, "enteringNames");
            Intrinsics.checkNotNullParameter(exitingNames, "exitingNames");
            Intrinsics.checkNotNullParameter(firstOutViews, "firstOutViews");
            Intrinsics.checkNotNullParameter(lastInViews, "lastInViews");
            this.transitionInfos = transitionInfos;
            this.firstOut = operation;
            this.lastIn = operation2;
            this.transitionImpl = transitionImpl;
            this.sharedElementTransition = obj;
            this.sharedElementFirstOutViews = sharedElementFirstOutViews;
            this.sharedElementLastInViews = sharedElementLastInViews;
            this.sharedElementNameMapping = sharedElementNameMapping;
            this.enteringNames = enteringNames;
            this.exitingNames = exitingNames;
            this.firstOutViews = firstOutViews;
            this.lastInViews = lastInViews;
            this.isPop = z;
            this.transitionSignal = new CancellationSignal();
        }

        public final Object getController() {
            return this.controller;
        }

        public final void setController(Object obj) {
            this.controller = obj;
        }

        public final void setNoControllerReturned(boolean z) {
            this.noControllerReturned = z;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Effect
        public boolean isSeekingSupported() {
            if (!this.transitionImpl.isSeekingSupported()) {
                return false;
            }
            List<TransitionInfo> list = this.transitionInfos;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (TransitionInfo transitionInfo : list) {
                    if (Build.VERSION.SDK_INT < 34 || transitionInfo.getTransition() == null || !this.transitionImpl.isSeekingSupported(transitionInfo.getTransition())) {
                        return false;
                    }
                }
            }
            Object obj = this.sharedElementTransition;
            return obj == null || this.transitionImpl.isSeekingSupported(obj);
        }

        public final boolean getTransitioning() {
            List list = this.transitionInfos;
            if ((list instanceof Collection) && list.isEmpty()) {
                return true;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (!((TransitionInfo) it.next()).getOperation().getFragment().mTransitioning) {
                    return false;
                }
            }
            return true;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Effect
        public void onStart(final ViewGroup container) {
            Intrinsics.checkNotNullParameter(container, "container");
            if (container.isLaidOut()) {
                if (getTransitioning() && this.sharedElementTransition != null && !isSeekingSupported()) {
                    Objects.toString(this.sharedElementTransition);
                    Objects.toString(this.firstOut);
                    Objects.toString(this.lastIn);
                }
                if (isSeekingSupported() && getTransitioning()) {
                    final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                    Pair pairCreateMergedTransition = createMergedTransition(container, this.lastIn, this.firstOut);
                    ArrayList arrayList = (ArrayList) pairCreateMergedTransition.getFirst();
                    final Object second = pairCreateMergedTransition.getSecond();
                    List list = this.transitionInfos;
                    ArrayList<SpecialEffectsController.Operation> arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(((TransitionInfo) it.next()).getOperation());
                    }
                    for (final SpecialEffectsController.Operation operation : arrayList2) {
                        this.transitionImpl.setListenerForTransitionEnd(operation.getFragment(), second, this.transitionSignal, new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                DefaultSpecialEffectsController.TransitionEffect.onStart$lambda$6$lambda$4(ref$ObjectRef);
                            }
                        }, new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda1
                            @Override // java.lang.Runnable
                            public final void run() {
                                DefaultSpecialEffectsController.TransitionEffect.onStart$lambda$6$lambda$5(operation, this);
                            }
                        });
                    }
                    runTransition(arrayList, container, new Function0() { // from class: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m2711invoke();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m2711invoke() {
                            FragmentManager.isLoggingEnabled(2);
                            DefaultSpecialEffectsController.TransitionEffect transitionEffect = this.this$0;
                            transitionEffect.setController(transitionEffect.getTransitionImpl().controlDelayedTransition(container, second));
                            if (this.this$0.getController() == null) {
                                FragmentManager.isLoggingEnabled(2);
                                this.this$0.setNoControllerReturned(true);
                                return;
                            }
                            ref$ObjectRef.element = new AnonymousClass1(this.this$0, second, container);
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Objects.toString(this.this$0.getFirstOut());
                                Objects.toString(this.this$0.getLastIn());
                            }
                        }

                        /* JADX INFO: renamed from: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4$1, reason: invalid class name */
                        static final class AnonymousClass1 extends Lambda implements Function0 {
                            final /* synthetic */ ViewGroup $container;
                            final /* synthetic */ Object $mergedTransition;
                            final /* synthetic */ DefaultSpecialEffectsController.TransitionEffect this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(DefaultSpecialEffectsController.TransitionEffect transitionEffect, Object obj, ViewGroup viewGroup) {
                                super(0);
                                this.this$0 = transitionEffect;
                                this.$mergedTransition = obj;
                                this.$container = viewGroup;
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2713invoke();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m2713invoke() {
                                List transitionInfos = this.this$0.getTransitionInfos();
                                if (!(transitionInfos instanceof Collection) || !transitionInfos.isEmpty()) {
                                    Iterator it = transitionInfos.iterator();
                                    while (it.hasNext()) {
                                        if (!((DefaultSpecialEffectsController.TransitionInfo) it.next()).getOperation().isSeeking()) {
                                            FragmentManager.isLoggingEnabled(2);
                                            CancellationSignal cancellationSignal = new CancellationSignal();
                                            FragmentTransitionImpl transitionImpl = this.this$0.getTransitionImpl();
                                            Fragment fragment = ((DefaultSpecialEffectsController.TransitionInfo) this.this$0.getTransitionInfos().get(0)).getOperation().getFragment();
                                            Object obj = this.$mergedTransition;
                                            final DefaultSpecialEffectsController.TransitionEffect transitionEffect = this.this$0;
                                            transitionImpl.setListenerForTransitionEnd(fragment, obj, cancellationSignal, 
                                            /*  JADX ERROR: Method code generation error
                                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x005d: INVOKE 
                                                  (r1v7 'transitionImpl' androidx.fragment.app.FragmentTransitionImpl)
                                                  (r2v6 'fragment' androidx.fragment.app.Fragment)
                                                  (r3v1 'obj' java.lang.Object)
                                                  (r0v4 'cancellationSignal' androidx.core.os.CancellationSignal)
                                                  (wrap java.lang.Runnable:0x005a: CONSTRUCTOR (r4v0 'transitionEffect' androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect A[DONT_INLINE]) A[MD:(androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect):void (m), WRAPPED] call: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4$1$$ExternalSyntheticLambda1.<init>(androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect):void type: CONSTRUCTOR)
                                                 VIRTUAL call: androidx.fragment.app.FragmentTransitionImpl.setListenerForTransitionEnd(androidx.fragment.app.Fragment, java.lang.Object, androidx.core.os.CancellationSignal, java.lang.Runnable):void A[MD:(androidx.fragment.app.Fragment, java.lang.Object, androidx.core.os.CancellationSignal, java.lang.Runnable):void (m)] in method: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4.1.invoke():void, file: classes.dex
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:226)
                                                	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:173)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4$1$$ExternalSyntheticLambda1, state: NOT_LOADED
                                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:306)
                                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                                	... 35 more
                                                */
                                            /*
                                                this = this;
                                                androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect r0 = r6.this$0
                                                java.util.List r0 = r0.getTransitionInfos()
                                                java.lang.Iterable r0 = (java.lang.Iterable) r0
                                                boolean r1 = r0 instanceof java.util.Collection
                                                r2 = 2
                                                if (r1 == 0) goto L17
                                                r1 = r0
                                                java.util.Collection r1 = (java.util.Collection) r1
                                                boolean r1 = r1.isEmpty()
                                                if (r1 == 0) goto L17
                                                goto L64
                                            L17:
                                                java.util.Iterator r0 = r0.iterator()
                                            L1b:
                                                boolean r1 = r0.hasNext()
                                                if (r1 == 0) goto L64
                                                java.lang.Object r1 = r0.next()
                                                androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo r1 = (androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo) r1
                                                androidx.fragment.app.SpecialEffectsController$Operation r1 = r1.getOperation()
                                                boolean r1 = r1.isSeeking()
                                                if (r1 != 0) goto L1b
                                                androidx.fragment.app.FragmentManager.isLoggingEnabled(r2)
                                                androidx.core.os.CancellationSignal r0 = new androidx.core.os.CancellationSignal
                                                r0.<init>()
                                                androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect r1 = r6.this$0
                                                androidx.fragment.app.FragmentTransitionImpl r1 = r1.getTransitionImpl()
                                                androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect r2 = r6.this$0
                                                java.util.List r2 = r2.getTransitionInfos()
                                                r3 = 0
                                                java.lang.Object r2 = r2.get(r3)
                                                androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo r2 = (androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo) r2
                                                androidx.fragment.app.SpecialEffectsController$Operation r2 = r2.getOperation()
                                                androidx.fragment.app.Fragment r2 = r2.getFragment()
                                                java.lang.Object r3 = r6.$mergedTransition
                                                androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect r4 = r6.this$0
                                                androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4$1$$ExternalSyntheticLambda1 r5 = new androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4$1$$ExternalSyntheticLambda1
                                                r5.<init>(r4)
                                                r1.setListenerForTransitionEnd(r2, r3, r0, r5)
                                                r0.cancel()
                                                return
                                            L64:
                                                androidx.fragment.app.FragmentManager.isLoggingEnabled(r2)
                                                androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect r0 = r6.this$0
                                                androidx.fragment.app.FragmentTransitionImpl r0 = r0.getTransitionImpl()
                                                androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect r1 = r6.this$0
                                                java.lang.Object r1 = r1.getController()
                                                kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
                                                androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect r2 = r6.this$0
                                                android.view.ViewGroup r3 = r6.$container
                                                androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4$1$$ExternalSyntheticLambda0 r4 = new androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4$1$$ExternalSyntheticLambda0
                                                r4.<init>(r2, r3)
                                                r0.animateToStart(r1, r4)
                                                return
                                            */
                                            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4.AnonymousClass1.m2713invoke():void");
                                        }

                                        /* JADX INFO: Access modifiers changed from: private */
                                        public static final void invoke$lambda$2(DefaultSpecialEffectsController.TransitionEffect this$0, ViewGroup container) {
                                            Intrinsics.checkNotNullParameter(this$0, "this$0");
                                            Intrinsics.checkNotNullParameter(container, "$container");
                                            Iterator it = this$0.getTransitionInfos().iterator();
                                            while (it.hasNext()) {
                                                SpecialEffectsController.Operation operation = ((DefaultSpecialEffectsController.TransitionInfo) it.next()).getOperation();
                                                View view = operation.getFragment().getView();
                                                if (view != null) {
                                                    operation.getFinalState().applyState(view, container);
                                                }
                                            }
                                        }

                                        /* JADX INFO: Access modifiers changed from: private */
                                        public static final void invoke$lambda$4(DefaultSpecialEffectsController.TransitionEffect this$0) {
                                            Intrinsics.checkNotNullParameter(this$0, "this$0");
                                            FragmentManager.isLoggingEnabled(2);
                                            Iterator it = this$0.getTransitionInfos().iterator();
                                            while (it.hasNext()) {
                                                ((DefaultSpecialEffectsController.TransitionInfo) it.next()).getOperation().completeEffect(this$0);
                                            }
                                        }
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        Iterator it2 = this.transitionInfos.iterator();
                        while (it2.hasNext()) {
                            SpecialEffectsController.Operation operation2 = ((TransitionInfo) it2.next()).getOperation();
                            if (FragmentManager.isLoggingEnabled(2)) {
                                container.toString();
                                Objects.toString(operation2);
                            }
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final void onStart$lambda$6$lambda$4(Ref$ObjectRef seekCancelLambda) {
                        Intrinsics.checkNotNullParameter(seekCancelLambda, "$seekCancelLambda");
                        Function0 function0 = (Function0) seekCancelLambda.element;
                        if (function0 != null) {
                            function0.invoke();
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final void onStart$lambda$6$lambda$5(SpecialEffectsController.Operation operation, TransitionEffect this$0) {
                        Intrinsics.checkNotNullParameter(operation, "$operation");
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Objects.toString(operation);
                        }
                        operation.completeEffect(this$0);
                    }

                    @Override // androidx.fragment.app.SpecialEffectsController.Effect
                    public void onProgress(BackEventCompat backEvent, ViewGroup container) {
                        Intrinsics.checkNotNullParameter(backEvent, "backEvent");
                        Intrinsics.checkNotNullParameter(container, "container");
                        Object obj = this.controller;
                        if (obj != null) {
                            this.transitionImpl.setCurrentPlayTime(obj, backEvent.getProgress());
                        }
                    }

                    @Override // androidx.fragment.app.SpecialEffectsController.Effect
                    public void onCommit(final ViewGroup container) {
                        Intrinsics.checkNotNullParameter(container, "container");
                        if (container.isLaidOut() && !this.noControllerReturned) {
                            Object obj = this.controller;
                            if (obj != null) {
                                FragmentTransitionImpl fragmentTransitionImpl = this.transitionImpl;
                                Intrinsics.checkNotNull(obj);
                                fragmentTransitionImpl.animateToEnd(obj);
                                if (FragmentManager.isLoggingEnabled(2)) {
                                    Objects.toString(this.firstOut);
                                    Objects.toString(this.lastIn);
                                    return;
                                }
                                return;
                            }
                            Pair pairCreateMergedTransition = createMergedTransition(container, this.lastIn, this.firstOut);
                            ArrayList arrayList = (ArrayList) pairCreateMergedTransition.getFirst();
                            final Object second = pairCreateMergedTransition.getSecond();
                            List list = this.transitionInfos;
                            ArrayList<SpecialEffectsController.Operation> arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                arrayList2.add(((TransitionInfo) it.next()).getOperation());
                            }
                            for (final SpecialEffectsController.Operation operation : arrayList2) {
                                this.transitionImpl.setListenerForTransitionEnd(operation.getFragment(), second, this.transitionSignal, new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda2
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        DefaultSpecialEffectsController.TransitionEffect.onCommit$lambda$11$lambda$10(operation, this);
                                    }
                                });
                            }
                            runTransition(arrayList, container, new Function0() { // from class: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onCommit$4
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m2710invoke();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                public final void m2710invoke() {
                                    this.this$0.getTransitionImpl().beginDelayedTransition(container, second);
                                }
                            });
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Objects.toString(this.firstOut);
                                Objects.toString(this.lastIn);
                                return;
                            }
                            return;
                        }
                        for (TransitionInfo transitionInfo : this.transitionInfos) {
                            SpecialEffectsController.Operation operation2 = transitionInfo.getOperation();
                            if (FragmentManager.isLoggingEnabled(2)) {
                                if (this.noControllerReturned) {
                                    Objects.toString(operation2);
                                } else {
                                    container.toString();
                                    Objects.toString(operation2);
                                }
                            }
                            transitionInfo.getOperation().completeEffect(this);
                        }
                        this.noControllerReturned = false;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final void onCommit$lambda$11$lambda$10(SpecialEffectsController.Operation operation, TransitionEffect this$0) {
                        Intrinsics.checkNotNullParameter(operation, "$operation");
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Objects.toString(operation);
                        }
                        operation.completeEffect(this$0);
                    }

                    private final Pair createMergedTransition(ViewGroup viewGroup, final SpecialEffectsController.Operation operation, final SpecialEffectsController.Operation operation2) {
                        operation = operation;
                        View view = new View(viewGroup.getContext());
                        final Rect rect = new Rect();
                        Iterator it = this.transitionInfos.iterator();
                        boolean z = false;
                        View view2 = null;
                        while (it.hasNext()) {
                            if (((TransitionInfo) it.next()).hasSharedElementTransition() && operation2 != null && operation != null && !this.sharedElementNameMapping.isEmpty() && this.sharedElementTransition != null) {
                                FragmentTransition.callSharedElementStartEnd(operation.getFragment(), operation2.getFragment(), this.isPop, this.firstOutViews, true);
                                OneShotPreDrawListener.add(viewGroup, new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda3
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        DefaultSpecialEffectsController.TransitionEffect.createMergedTransition$lambda$12(operation, operation2, this);
                                    }
                                });
                                this.sharedElementFirstOutViews.addAll(this.firstOutViews.values());
                                if (!this.exitingNames.isEmpty()) {
                                    Object obj = this.exitingNames.get(0);
                                    Intrinsics.checkNotNullExpressionValue(obj, "exitingNames[0]");
                                    view2 = (View) this.firstOutViews.get((String) obj);
                                    this.transitionImpl.setEpicenter(this.sharedElementTransition, view2);
                                }
                                this.sharedElementLastInViews.addAll(this.lastInViews.values());
                                if (!this.enteringNames.isEmpty()) {
                                    Object obj2 = this.enteringNames.get(0);
                                    Intrinsics.checkNotNullExpressionValue(obj2, "enteringNames[0]");
                                    final View view3 = (View) this.lastInViews.get((String) obj2);
                                    if (view3 != null) {
                                        final FragmentTransitionImpl fragmentTransitionImpl = this.transitionImpl;
                                        OneShotPreDrawListener.add(viewGroup, new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda4
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                DefaultSpecialEffectsController.TransitionEffect.createMergedTransition$lambda$13(fragmentTransitionImpl, view3, rect);
                                            }
                                        });
                                        z = true;
                                    }
                                }
                                this.transitionImpl.setSharedElementTargets(this.sharedElementTransition, view, this.sharedElementFirstOutViews);
                                FragmentTransitionImpl fragmentTransitionImpl2 = this.transitionImpl;
                                Object obj3 = this.sharedElementTransition;
                                fragmentTransitionImpl2.scheduleRemoveTargets(obj3, null, null, null, null, obj3, this.sharedElementLastInViews);
                            }
                        }
                        ArrayList arrayList = new ArrayList();
                        Iterator it2 = this.transitionInfos.iterator();
                        Object objMergeTransitionsTogether = null;
                        Object objMergeTransitionsTogether2 = null;
                        while (it2.hasNext()) {
                            TransitionInfo transitionInfo = (TransitionInfo) it2.next();
                            SpecialEffectsController.Operation operation3 = transitionInfo.getOperation();
                            Object objCloneTransition = this.transitionImpl.cloneTransition(transitionInfo.getTransition());
                            if (objCloneTransition != null) {
                                final ArrayList arrayList2 = new ArrayList();
                                boolean z2 = z;
                                View view4 = operation3.getFragment().mView;
                                Iterator it3 = it2;
                                Intrinsics.checkNotNullExpressionValue(view4, "operation.fragment.mView");
                                captureTransitioningViews(arrayList2, view4);
                                if (this.sharedElementTransition != null && (operation3 == operation2 || operation3 == operation)) {
                                    if (operation3 == operation2) {
                                        arrayList2.removeAll(CollectionsKt.toSet(this.sharedElementFirstOutViews));
                                    } else {
                                        arrayList2.removeAll(CollectionsKt.toSet(this.sharedElementLastInViews));
                                    }
                                }
                                if (arrayList2.isEmpty()) {
                                    this.transitionImpl.addTarget(objCloneTransition, view);
                                } else {
                                    this.transitionImpl.addTargets(objCloneTransition, arrayList2);
                                    this.transitionImpl.scheduleRemoveTargets(objCloneTransition, objCloneTransition, arrayList2, null, null, null, null);
                                    if (operation3.getFinalState() == SpecialEffectsController.Operation.State.GONE) {
                                        operation3.setAwaitingContainerChanges(false);
                                        ArrayList arrayList3 = new ArrayList(arrayList2);
                                        arrayList3.remove(operation3.getFragment().mView);
                                        this.transitionImpl.scheduleHideFragmentView(objCloneTransition, operation3.getFragment().mView, arrayList3);
                                        OneShotPreDrawListener.add(viewGroup, new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda5
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                DefaultSpecialEffectsController.TransitionEffect.createMergedTransition$lambda$14(arrayList2);
                                            }
                                        });
                                    }
                                }
                                if (operation3.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                                    arrayList.addAll(arrayList2);
                                    if (z2) {
                                        this.transitionImpl.setEpicenter(objCloneTransition, rect);
                                    }
                                    if (FragmentManager.isLoggingEnabled(2)) {
                                        objCloneTransition.toString();
                                        for (Object transitioningViews : arrayList2) {
                                            Intrinsics.checkNotNullExpressionValue(transitioningViews, "transitioningViews");
                                            Objects.toString((View) transitioningViews);
                                        }
                                    }
                                } else {
                                    this.transitionImpl.setEpicenter(objCloneTransition, view2);
                                    if (FragmentManager.isLoggingEnabled(2)) {
                                        objCloneTransition.toString();
                                        for (Object transitioningViews2 : arrayList2) {
                                            Intrinsics.checkNotNullExpressionValue(transitioningViews2, "transitioningViews");
                                            Objects.toString((View) transitioningViews2);
                                        }
                                    }
                                }
                                if (transitionInfo.isOverlapAllowed()) {
                                    objMergeTransitionsTogether = this.transitionImpl.mergeTransitionsTogether(objMergeTransitionsTogether, objCloneTransition, null);
                                } else {
                                    objMergeTransitionsTogether2 = this.transitionImpl.mergeTransitionsTogether(objMergeTransitionsTogether2, objCloneTransition, null);
                                }
                                z = z2;
                                it2 = it3;
                            }
                        }
                        Object objMergeTransitionsInSequence = this.transitionImpl.mergeTransitionsInSequence(objMergeTransitionsTogether, objMergeTransitionsTogether2, this.sharedElementTransition);
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Objects.toString(objMergeTransitionsInSequence);
                            viewGroup.toString();
                        }
                        return new Pair(arrayList, objMergeTransitionsInSequence);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final void createMergedTransition$lambda$12(SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2, TransitionEffect this$0) {
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        FragmentTransition.callSharedElementStartEnd(operation.getFragment(), operation2.getFragment(), this$0.isPop, this$0.lastInViews, false);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final void createMergedTransition$lambda$13(FragmentTransitionImpl impl, View view, Rect lastInEpicenterRect) {
                        Intrinsics.checkNotNullParameter(impl, "$impl");
                        Intrinsics.checkNotNullParameter(lastInEpicenterRect, "$lastInEpicenterRect");
                        impl.getBoundsOnScreen(view, lastInEpicenterRect);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final void createMergedTransition$lambda$14(ArrayList transitioningViews) {
                        Intrinsics.checkNotNullParameter(transitioningViews, "$transitioningViews");
                        FragmentTransition.setViewVisibility(transitioningViews, 4);
                    }

                    private final void runTransition(ArrayList arrayList, ViewGroup viewGroup, Function0 function0) {
                        FragmentTransition.setViewVisibility(arrayList, 4);
                        ArrayList arrayListPrepareSetNameOverridesReordered = this.transitionImpl.prepareSetNameOverridesReordered(this.sharedElementLastInViews);
                        if (FragmentManager.isLoggingEnabled(2)) {
                            for (Object sharedElementFirstOutViews : this.sharedElementFirstOutViews) {
                                Intrinsics.checkNotNullExpressionValue(sharedElementFirstOutViews, "sharedElementFirstOutViews");
                                View view = (View) sharedElementFirstOutViews;
                                Objects.toString(view);
                                ViewCompat.getTransitionName(view);
                            }
                            for (Object sharedElementLastInViews : this.sharedElementLastInViews) {
                                Intrinsics.checkNotNullExpressionValue(sharedElementLastInViews, "sharedElementLastInViews");
                                View view2 = (View) sharedElementLastInViews;
                                Objects.toString(view2);
                                ViewCompat.getTransitionName(view2);
                            }
                        }
                        function0.invoke();
                        this.transitionImpl.setNameOverridesReordered(viewGroup, this.sharedElementFirstOutViews, this.sharedElementLastInViews, arrayListPrepareSetNameOverridesReordered, this.sharedElementNameMapping);
                        FragmentTransition.setViewVisibility(arrayList, 0);
                        this.transitionImpl.swapSharedElementTargets(this.sharedElementTransition, this.sharedElementFirstOutViews, this.sharedElementLastInViews);
                    }

                    @Override // androidx.fragment.app.SpecialEffectsController.Effect
                    public void onCancel(ViewGroup container) {
                        Intrinsics.checkNotNullParameter(container, "container");
                        this.transitionSignal.cancel();
                    }

                    private final void captureTransitioningViews(ArrayList arrayList, View view) {
                        if (view instanceof ViewGroup) {
                            ViewGroup viewGroup = (ViewGroup) view;
                            if (ViewGroupCompat.isTransitionGroup(viewGroup)) {
                                if (arrayList.contains(view)) {
                                    return;
                                }
                                arrayList.add(view);
                                return;
                            }
                            int childCount = viewGroup.getChildCount();
                            for (int i = 0; i < childCount; i++) {
                                View child = viewGroup.getChildAt(i);
                                if (child.getVisibility() == 0) {
                                    Intrinsics.checkNotNullExpressionValue(child, "child");
                                    captureTransitioningViews(arrayList, child);
                                }
                            }
                            return;
                        }
                        if (arrayList.contains(view)) {
                            return;
                        }
                        arrayList.add(view);
                    }
                }

                public static final class Api24Impl {
                    public static final Api24Impl INSTANCE = new Api24Impl();

                    private Api24Impl() {
                    }

                    public final long totalDuration(AnimatorSet animatorSet) {
                        Intrinsics.checkNotNullParameter(animatorSet, "animatorSet");
                        return animatorSet.getTotalDuration();
                    }
                }

                public static final class Api26Impl {
                    public static final Api26Impl INSTANCE = new Api26Impl();

                    private Api26Impl() {
                    }

                    public final void reverse(AnimatorSet animatorSet) {
                        Intrinsics.checkNotNullParameter(animatorSet, "animatorSet");
                        animatorSet.reverse();
                    }

                    public final void setCurrentPlayTime(AnimatorSet animatorSet, long j) {
                        Intrinsics.checkNotNullParameter(animatorSet, "animatorSet");
                        animatorSet.setCurrentPlayTime(j);
                    }
                }
            }
