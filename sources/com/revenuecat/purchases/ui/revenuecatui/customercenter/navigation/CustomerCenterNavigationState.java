package com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation;

import com.google.firebase.messaging.Constants;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0081\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÂ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÂ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J/\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0016\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bJ\u0006\u0010\u001d\u001a\u00020\u0000J\u0006\u0010\u001e\u001a\u00020\u0000J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\bJ\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/navigation/CustomerCenterNavigationState;", "", "showingActivePurchasesScreen", "", "managementScreenTitle", "", "backStack", "Ljava/util/Deque;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/navigation/CustomerCenterDestination;", "(ZLjava/lang/String;Ljava/util/Deque;)V", "getBackStack", "()Ljava/util/Deque;", "canNavigateBack", "getCanNavigateBack", "()Z", "currentDestination", "getCurrentDestination", "()Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/navigation/CustomerCenterDestination;", "component1", "component2", "component3", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "isBackwardTransition", Constants.MessagePayloadKeys.FROM, "to", "pop", "popToMain", com.adjust.sdk.Constants.PUSH, "destination", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CustomerCenterNavigationState {
    public static final int $stable = 0;
    private final Deque<CustomerCenterDestination> backStack;
    private final String managementScreenTitle;
    private final boolean showingActivePurchasesScreen;

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final boolean getShowingActivePurchasesScreen() {
        return this.showingActivePurchasesScreen;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final String getManagementScreenTitle() {
        return this.managementScreenTitle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CustomerCenterNavigationState copy$default(CustomerCenterNavigationState customerCenterNavigationState, boolean z, String str, Deque deque, int i, Object obj) {
        if ((i & 1) != 0) {
            z = customerCenterNavigationState.showingActivePurchasesScreen;
        }
        if ((i & 2) != 0) {
            str = customerCenterNavigationState.managementScreenTitle;
        }
        if ((i & 4) != 0) {
            deque = customerCenterNavigationState.backStack;
        }
        return customerCenterNavigationState.copy(z, str, deque);
    }

    public final Deque<CustomerCenterDestination> component3() {
        return this.backStack;
    }

    public final CustomerCenterNavigationState copy(boolean showingActivePurchasesScreen, String managementScreenTitle, Deque<CustomerCenterDestination> backStack) {
        Intrinsics.checkNotNullParameter(backStack, "backStack");
        return new CustomerCenterNavigationState(showingActivePurchasesScreen, managementScreenTitle, backStack);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CustomerCenterNavigationState)) {
            return false;
        }
        CustomerCenterNavigationState customerCenterNavigationState = (CustomerCenterNavigationState) other;
        return this.showingActivePurchasesScreen == customerCenterNavigationState.showingActivePurchasesScreen && Intrinsics.areEqual(this.managementScreenTitle, customerCenterNavigationState.managementScreenTitle) && Intrinsics.areEqual(this.backStack, customerCenterNavigationState.backStack);
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.showingActivePurchasesScreen) * 31;
        String str = this.managementScreenTitle;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.backStack.hashCode();
    }

    public String toString() {
        return "CustomerCenterNavigationState(showingActivePurchasesScreen=" + this.showingActivePurchasesScreen + ", managementScreenTitle=" + this.managementScreenTitle + ", backStack=" + this.backStack + ')';
    }

    public CustomerCenterNavigationState(boolean z, String str, Deque<CustomerCenterDestination> backStack) {
        Intrinsics.checkNotNullParameter(backStack, "backStack");
        this.showingActivePurchasesScreen = z;
        this.managementScreenTitle = str;
        this.backStack = backStack;
    }

    public /* synthetic */ CustomerCenterNavigationState(boolean z, String str, Deque deque, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Deque deque2 = deque;
        if ((i & 4) != 0) {
            ArrayDeque arrayDeque = new ArrayDeque();
            arrayDeque.push(new CustomerCenterDestination.Main(z, str));
            deque2 = arrayDeque;
        }
        this(z, str, deque2);
    }

    public final Deque<CustomerCenterDestination> getBackStack() {
        return this.backStack;
    }

    public final CustomerCenterDestination getCurrentDestination() {
        CustomerCenterDestination customerCenterDestinationPeek = this.backStack.peek();
        return customerCenterDestinationPeek == null ? new CustomerCenterDestination.Main(this.showingActivePurchasesScreen, this.managementScreenTitle) : customerCenterDestinationPeek;
    }

    public final boolean getCanNavigateBack() {
        return this.backStack.size() > 1;
    }

    public final CustomerCenterNavigationState push(CustomerCenterDestination destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        ArrayDeque arrayDeque = new ArrayDeque(this.backStack);
        arrayDeque.push(destination);
        return copy$default(this, false, null, arrayDeque, 3, null);
    }

    public final CustomerCenterNavigationState pop() {
        if (!getCanNavigateBack()) {
            return this;
        }
        ArrayDeque arrayDeque = new ArrayDeque(this.backStack);
        arrayDeque.pop();
        return copy$default(this, false, null, arrayDeque, 3, null);
    }

    public final CustomerCenterNavigationState popToMain() {
        ArrayDeque arrayDeque = new ArrayDeque(this.backStack);
        while (!arrayDeque.isEmpty() && !(arrayDeque.peek() instanceof CustomerCenterDestination.Main)) {
            arrayDeque.pop();
        }
        if (arrayDeque.isEmpty()) {
            Logger.INSTANCE.e("Could not find Main destination in the back stack. Returning unchanged state.");
            return this;
        }
        return copy$default(this, false, null, arrayDeque, 3, null);
    }

    public final boolean isBackwardTransition(CustomerCenterDestination from, CustomerCenterDestination to) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        if ((to instanceof CustomerCenterDestination.Main) && !(from instanceof CustomerCenterDestination.Main)) {
            return true;
        }
        List list = CollectionsKt.toList(this.backStack);
        int iIndexOf = list.indexOf(from);
        int iIndexOf2 = list.indexOf(to);
        if (iIndexOf2 != -1 && iIndexOf != -1) {
            return iIndexOf2 > iIndexOf;
        }
        Logger.INSTANCE.e("One of the destinations (" + from + " [" + iIndexOf + "], " + to + " [" + iIndexOf2 + "]) is not in the back stack. Assuming forward transition.");
        return false;
    }
}
