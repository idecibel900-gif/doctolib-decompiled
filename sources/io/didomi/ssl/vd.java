package io.didomi.ssl;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0018\u0010\f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0011¨\u0006\u0015"}, d2 = {"Lio/didomi/sdk/vd;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lio/didomi/sdk/de;", "", "getItemCount", "position", "", "getItemId", "getItemViewType", "Landroid/view/ViewGroup;", "parent", "viewType", "a", "holder", "", "", "Lio/didomi/sdk/be;", "Ljava/util/List;", "list", "<init>", "(Ljava/util/List;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class vd extends RecyclerView.Adapter {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final List<be> list;

    /* JADX WARN: Multi-variable type inference failed */
    public vd(List<? extends be> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.list = list;
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public de onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            l4 l4VarA = l4.a(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(l4VarA, "inflate(LayoutInflater.f….context), parent, false)");
            return new ae(l4VarA);
        }
        if (viewType == 1) {
            m4 m4VarA = m4.a(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(m4VarA, "inflate(LayoutInflater.f….context), parent, false)");
            return new ce(m4VarA);
        }
        if (viewType == 2) {
            k4 k4VarA = k4.a(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(k4VarA, "inflate(LayoutInflater.f….context), parent, false)");
            return new wd(k4VarA);
        }
        if (viewType == 100) {
            w3 w3VarA = w3.a(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(w3VarA, "inflate(LayoutInflater.f….context), parent, false)");
            return new xd(w3VarA);
        }
        throw new ClassCastException("Unknown viewType " + viewType);
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
    public void onBindViewHolder(de holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof wd) {
            be beVar = this.list.get(position);
            Intrinsics.checkNotNull(beVar, "null cannot be cast to non-null type io.didomi.sdk.purpose.ctv.model.TVPurposeVendorsList.Content");
            ((wd) holder).a((be.Content) beVar);
        } else if (holder instanceof ce) {
            be beVar2 = this.list.get(position);
            Intrinsics.checkNotNull(beVar2, "null cannot be cast to non-null type io.didomi.sdk.purpose.ctv.model.TVPurposeVendorsList.Title");
            ((ce) holder).a((be.Title) beVar2);
        }
    }
}
