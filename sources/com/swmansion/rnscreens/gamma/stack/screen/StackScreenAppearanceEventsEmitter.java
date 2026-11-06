package com.swmansion.rnscreens.gamma.stack.screen;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.swmansion.rnscreens.gamma.common.event.ViewAppearanceEventEmitter;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class StackScreenAppearanceEventsEmitter implements LifecycleEventObserver {
    private final ViewAppearanceEventEmitter appearanceEventEmitter;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Lifecycle.Event.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public StackScreenAppearanceEventsEmitter(Lifecycle screenLifecycle, ViewAppearanceEventEmitter appearanceEventEmitter) {
        Intrinsics.checkNotNullParameter(screenLifecycle, "screenLifecycle");
        Intrinsics.checkNotNullParameter(appearanceEventEmitter, "appearanceEventEmitter");
        this.appearanceEventEmitter = appearanceEventEmitter;
        screenLifecycle.addObserver(this);
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        switch (WhenMappings.$EnumSwitchMapping$0[event.ordinal()]) {
            case 1:
                this.appearanceEventEmitter.emitOnWillAppear();
                return;
            case 2:
                this.appearanceEventEmitter.emitOnDidAppear();
                return;
            case 3:
                this.appearanceEventEmitter.emitOnWillDisappear();
                return;
            case 4:
                this.appearanceEventEmitter.emitOnDidDisappear();
                return;
            case 5:
                invalidate(source);
                return;
            case 6:
            case 7:
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final void invalidate(LifecycleOwner lifecycleOwner) {
        lifecycleOwner.getLifecycle().removeObserver(this);
    }
}
