package io.didomi.ssl;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 \u00052\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J$\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00118\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lio/didomi/sdk/se;", "Landroidx/fragment/app/Fragment;", "", "d", "c", "b", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "parent", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "view", "onViewCreated", "onDestroyView", "Lio/didomi/sdk/b3;", "a", "Lio/didomi/sdk/b3;", "()Lio/didomi/sdk/b3;", "setBinding", "(Lio/didomi/sdk/b3;)V", "binding", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
public abstract class se extends Fragment {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private b3 binding;

    /* JADX INFO: renamed from: a, reason: from getter */
    protected final b3 getBinding() {
        return this.binding;
    }

    public abstract void b();

    public abstract void c();

    public abstract void d();

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        b3 b3VarA = b3.a(inflater, parent, false);
        this.binding = b3VarA;
        ConstraintLayout root = b3VarA.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "inflate(inflater, parent…g = it\n            }.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        d();
        c();
        b();
    }
}
