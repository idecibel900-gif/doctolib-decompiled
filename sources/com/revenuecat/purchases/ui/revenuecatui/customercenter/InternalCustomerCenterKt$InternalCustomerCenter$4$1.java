package com.revenuecat.purchases.ui.revenuecatui.customercenter;

import android.app.Activity;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/DisposableEffectResult;", "Landroidx/compose/runtime/DisposableEffectScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class InternalCustomerCenterKt$InternalCustomerCenter$4$1 extends Lambda implements Function1 {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ LifecycleOwner $lifecycleOwner;
    final /* synthetic */ CustomerCenterViewModel $viewModel;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InternalCustomerCenterKt$InternalCustomerCenter$4$1(LifecycleOwner lifecycleOwner, CustomerCenterViewModel customerCenterViewModel, Activity activity) {
        super(1);
        this.$lifecycleOwner = lifecycleOwner;
        this.$viewModel = customerCenterViewModel;
        this.$activity = activity;
    }

    @Override // kotlin.jvm.functions.Function1
    public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        final CustomerCenterViewModel customerCenterViewModel = this.$viewModel;
        final Activity activity = this.$activity;
        final LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$InternalCustomerCenter$4$1$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                InternalCustomerCenterKt$InternalCustomerCenter$4$1.invoke$lambda$0(customerCenterViewModel, activity, lifecycleOwner, event);
            }
        };
        this.$lifecycleOwner.getLifecycle().addObserver(lifecycleEventObserver);
        final LifecycleOwner lifecycleOwner = this.$lifecycleOwner;
        return new DisposableEffectResult() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$InternalCustomerCenter$4$1$invoke$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                lifecycleOwner.getLifecycle().removeObserver(lifecycleEventObserver);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(CustomerCenterViewModel customerCenterViewModel, Activity activity, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event, "event");
        int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
        if (i == 1) {
            customerCenterViewModel.onActivityStopped(activity != null && activity.isChangingConfigurations());
        } else if (i == 2) {
            customerCenterViewModel.onActivityStarted();
        } else {
            if (i != 3) {
                return;
            }
            customerCenterViewModel.onActivityResumed();
        }
    }
}
