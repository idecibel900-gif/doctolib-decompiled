package io.didomi.ssl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.common.verification.SigningManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u001d\u0012\u0006\u0010\u0017\u001a\u00020\u0015\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u000f¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0018\u0010\f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J&\u0010\f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\u000e\u0010\f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0003J\u0014\u0010\f\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0016R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lio/didomi/sdk/lf;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lio/didomi/sdk/zf;", "", "getItemCount", "position", "", "getItemId", "getItemViewType", "Landroid/view/ViewGroup;", "parent", "viewType", "a", "holder", "", "", "", "payloads", "", "Lio/didomi/sdk/wf;", "deviceStorageDisclosureList", "Lio/didomi/sdk/lf$a;", "Lio/didomi/sdk/lf$a;", "callback", "b", "Ljava/util/List;", "list", "<init>", "(Lio/didomi/sdk/lf$a;Ljava/util/List;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class lf extends RecyclerView.Adapter {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final a callback;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final List<wf> list;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0002H&J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010\u000b\u001a\u00020\u0002H&J\b\u0010\n\u001a\u00020\u0002H&J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH&¨\u0006\u0011"}, d2 = {"Lio/didomi/sdk/lf$a;", "", "", "e", "f", "d", "a", "", "isChecked", "c", "b", "g", "", "index", "", DiagnosticsEntry.ID_KEY, "position", "android_release"}, k = 1, mv = {1, 8, 0})
    public interface a {
        void a();

        void a(int position);

        void a(String id);

        void a(boolean isChecked);

        void b();

        void b(int index);

        void b(boolean isChecked);

        void c();

        void d();

        void e();

        void f();

        void g();
    }

    public lf(a callback, List<wf> list) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(list, "list");
        this.callback = callback;
        this.list = list;
        setHasStableIds(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(lf this$0, int i, View view, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z) {
            this$0.callback.a(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(lf this$0, int i, View view, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z) {
            this$0.callback.a(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(lf this$0, int i, View view, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z) {
            this$0.callback.a(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(lf this$0, int i, View view, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z) {
            this$0.callback.a(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public zf onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        switch (viewType) {
            case 1:
                w4 w4VarA = w4.a(LayoutInflater.from(parent.getContext()), parent, false);
                Intrinsics.checkNotNullExpressionValue(w4VarA, "inflate(LayoutInflater.f….context), parent, false)");
                return new sf(w4VarA);
            case 2:
                t4 t4VarA = t4.a(LayoutInflater.from(parent.getContext()), parent, false);
                Intrinsics.checkNotNullExpressionValue(t4VarA, "inflate(LayoutInflater.f….context), parent, false)");
                return new mf(t4VarA);
            case 3:
            case 7:
            case 8:
            default:
                throw new ClassCastException("Unknown viewType " + viewType);
            case 4:
                y4 y4VarA = y4.a(LayoutInflater.from(parent.getContext()), parent, false);
                Intrinsics.checkNotNullExpressionValue(y4VarA, "inflate(LayoutInflater.f….context), parent, false)");
                return new yf(y4VarA);
            case 5:
                u4 u4VarA = u4.a(LayoutInflater.from(parent.getContext()), parent, false);
                Intrinsics.checkNotNullExpressionValue(u4VarA, "inflate(LayoutInflater.f….context), parent, false)");
                return new nf(u4VarA);
            case 6:
                x4 x4VarA = x4.a(LayoutInflater.from(parent.getContext()), parent, false);
                Intrinsics.checkNotNullExpressionValue(x4VarA, "inflate(LayoutInflater.f….context), parent, false)");
                return new xf(x4VarA);
            case 9:
                v4 v4VarA = v4.a(LayoutInflater.from(parent.getContext()), parent, false);
                Intrinsics.checkNotNullExpressionValue(v4VarA, "inflate(LayoutInflater.f….context), parent, false)");
                return new of(v4VarA);
            case 10:
                y4 y4VarA2 = y4.a(LayoutInflater.from(parent.getContext()), parent, false);
                Intrinsics.checkNotNullExpressionValue(y4VarA2, "inflate(LayoutInflater.f….context), parent, false)");
                return new rf(y4VarA2);
            case BaseVideoCapturer.RGBA /* 11 */:
                t4 t4VarA2 = t4.a(LayoutInflater.from(parent.getContext()), parent, false);
                Intrinsics.checkNotNullExpressionValue(t4VarA2, "inflate(LayoutInflater.f….context), parent, false)");
                return new qf(t4VarA2);
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                t4 t4VarA3 = t4.a(LayoutInflater.from(parent.getContext()), parent, false);
                Intrinsics.checkNotNullExpressionValue(t4VarA3, "inflate(LayoutInflater.f….context), parent, false)");
                return new pf(t4VarA3);
            case 13:
                w3 w3VarA = w3.a(LayoutInflater.from(parent.getContext()), parent, false);
                Intrinsics.checkNotNullExpressionValue(w3VarA, "inflate(LayoutInflater.f….context), parent, false)");
                return new tf(w3VarA);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return this.list.get(position).a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.list.get(position).getTypeId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(zf holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof sf) {
            wf wfVar = this.list.get(position);
            Intrinsics.checkNotNull(wfVar, "null cannot be cast to non-null type io.didomi.sdk.vendors.ctv.model.TVVendorDetailItem.Disclaimer");
            ((sf) holder).a((wf.Disclaimer) wfVar);
            return;
        }
        if (holder instanceof mf) {
            a aVar = this.callback;
            wf wfVar2 = this.list.get(position);
            Intrinsics.checkNotNull(wfVar2, "null cannot be cast to non-null type io.didomi.sdk.vendors.ctv.model.TVVendorDetailItem.ArrowLink");
            ((mf) holder).a(aVar, (wf.ArrowLink) wfVar2);
            holder.itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: io.didomi.sdk.lf$$ExternalSyntheticLambda1
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    lf.a(this.f$0, position, view, z);
                }
            });
            return;
        }
        if (holder instanceof yf) {
            wf wfVar3 = this.list.get(position);
            Intrinsics.checkNotNull(wfVar3, "null cannot be cast to non-null type io.didomi.sdk.vendors.ctv.model.TVVendorDetailItem.SectionTitle");
            ((yf) holder).a((wf.SectionTitle) wfVar3);
            return;
        }
        if (holder instanceof nf) {
            wf wfVar4 = this.list.get(position);
            Intrinsics.checkNotNull(wfVar4, "null cannot be cast to non-null type io.didomi.sdk.vendors.ctv.model.TVVendorDetailItem.Consent");
            ((nf) holder).a((wf.Consent) wfVar4, this.callback);
            holder.itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: io.didomi.sdk.lf$$ExternalSyntheticLambda2
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    lf.b(this.f$0, position, view, z);
                }
            });
            return;
        }
        if (holder instanceof xf) {
            wf wfVar5 = this.list.get(position);
            Intrinsics.checkNotNull(wfVar5, "null cannot be cast to non-null type io.didomi.sdk.vendors.ctv.model.TVVendorDetailItem.LegitimateInterest");
            ((xf) holder).a((wf.LegitimateInterest) wfVar5, this.callback);
            holder.itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: io.didomi.sdk.lf$$ExternalSyntheticLambda3
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    lf.c(this.f$0, position, view, z);
                }
            });
            return;
        }
        if (holder instanceof of) {
            wf wfVar6 = this.list.get(position);
            Intrinsics.checkNotNull(wfVar6, "null cannot be cast to non-null type io.didomi.sdk.vendors.ctv.model.TVVendorDetailItem.Cookie");
            ((of) holder).a((wf.Cookie) wfVar6);
            return;
        }
        if (holder instanceof rf) {
            wf wfVar7 = this.list.get(position);
            Intrinsics.checkNotNull(wfVar7, "null cannot be cast to non-null type io.didomi.sdk.vendors.ctv.model.TVVendorDetailItem.DeviceStorageDisclosureTitle");
            ((rf) holder).a((wf.DeviceStorageDisclosureTitle) wfVar7);
        } else {
            if (holder instanceof qf) {
                wf wfVar8 = this.list.get(position);
                Intrinsics.checkNotNull(wfVar8, "null cannot be cast to non-null type io.didomi.sdk.vendors.ctv.model.TVVendorDetailItem.DeviceStorageDisclosure");
                ((qf) holder).a((wf.DeviceStorageDisclosure) wfVar8, this.callback);
                holder.itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: io.didomi.sdk.lf$$ExternalSyntheticLambda4
                    @Override // android.view.View.OnFocusChangeListener
                    public final void onFocusChange(View view, boolean z) {
                        lf.d(this.f$0, position, view, z);
                    }
                });
                return;
            }
            if (holder instanceof pf) {
                wf wfVar9 = this.list.get(position);
                Intrinsics.checkNotNull(wfVar9, "null cannot be cast to non-null type io.didomi.sdk.vendors.ctv.model.TVVendorDetailItem.DataCategory");
                ((pf) holder).a((wf.DataCategory) wfVar9, this.callback);
                holder.itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: io.didomi.sdk.lf$$ExternalSyntheticLambda5
                    @Override // android.view.View.OnFocusChangeListener
                    public final void onFocusChange(View view, boolean z) {
                        lf.e(this.f$0, position, view, z);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(lf this$0, int i, View view, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z) {
            this$0.callback.a(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(zf holder, int position, List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, position);
        } else {
            final View view = holder.itemView;
            view.post(new Runnable() { // from class: io.didomi.sdk.lf$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    lf.a(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View this_apply) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.requestFocus();
    }

    public final void a(int position) {
        notifyItemChanged(position, Boolean.TRUE);
    }

    public final void a(List<? extends wf> deviceStorageDisclosureList) {
        Intrinsics.checkNotNullParameter(deviceStorageDisclosureList, "deviceStorageDisclosureList");
        if (deviceStorageDisclosureList.isEmpty()) {
            return;
        }
        int size = this.list.size() - 1;
        this.list.addAll(size, deviceStorageDisclosureList);
        notifyItemRangeInserted(size, deviceStorageDisclosureList.size());
    }
}
