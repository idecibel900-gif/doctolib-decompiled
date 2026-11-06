package com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\tH\u0016¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/viewmodel/VirtualCurrencyBalancesScreenViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "purchases", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PurchasesType;", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PurchasesType;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VirtualCurrencyBalancesScreenViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    public static final int $stable = 8;
    private final PurchasesType purchases;

    public VirtualCurrencyBalancesScreenViewModelFactory(PurchasesType purchases) {
        Intrinsics.checkNotNullParameter(purchases, "purchases");
        this.purchases = purchases;
    }

    @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        return new VirtualCurrencyBalancesScreenViewModel(this.purchases);
    }
}
