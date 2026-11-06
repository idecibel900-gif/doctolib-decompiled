package com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenViewState;
import com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \n2\u00020\u0001:\u0001\nB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/viewmodel/VirtualCurrencyBalancesScreenViewModel;", "Landroidx/lifecycle/ViewModel;", "purchases", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PurchasesType;", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PurchasesType;)V", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/views/VirtualCurrencyBalancesScreenViewState;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "Companion", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VirtualCurrencyBalancesScreenViewModel extends ViewModel {
    public static final int $stable = 0;
    private static final long STOP_TIMEOUT_MILLIS = 5000;
    private final PurchasesType purchases;
    private final StateFlow viewState;

    public VirtualCurrencyBalancesScreenViewModel(PurchasesType purchases) {
        Intrinsics.checkNotNullParameter(purchases, "purchases");
        this.purchases = purchases;
        this.viewState = FlowKt.stateIn(FlowKt.flow(new VirtualCurrencyBalancesScreenViewModel$viewState$1(this, null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 5000L, 0L, 2, null), VirtualCurrencyBalancesScreenViewState.Loading.INSTANCE);
    }

    public final StateFlow getViewState() {
        return this.viewState;
    }
}
