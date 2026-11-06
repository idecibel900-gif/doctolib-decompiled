package io.didomi.ssl;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016R\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Lio/didomi/sdk/gf;", "Landroidx/fragment/app/Fragment;", "Landroid/content/Context;", "context", "", "onAttach", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "parent", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "view", "onViewCreated", "onDestroyView", "Lio/didomi/sdk/ug;", "a", "Lio/didomi/sdk/ug;", "()Lio/didomi/sdk/ug;", "setModel", "(Lio/didomi/sdk/ug;)V", "model", "Lio/didomi/sdk/e3;", "b", "Lio/didomi/sdk/e3;", "binding", "<init>", "()V", "c", "android_release"}, k = 1, mv = {1, 8, 0})
public final class gf extends Fragment {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public ug model;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private e3 binding;

    /* JADX INFO: renamed from: io.didomi.sdk.gf$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0007¨\u0006\u000b"}, d2 = {"Lio/didomi/sdk/gf$a;", "", "", "dataCategoryId", "Lio/didomi/sdk/gf;", "a", "KEY_DATA_CATEGORY", "Ljava/lang/String;", "TAG", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final gf a(String dataCategoryId) {
            Intrinsics.checkNotNullParameter(dataCategoryId, "dataCategoryId");
            gf gfVar = new gf();
            Bundle bundle = new Bundle();
            bundle.putString("data_category", dataCategoryId);
            gfVar.setArguments(bundle);
            return gfVar;
        }

        private Companion() {
        }
    }

    public final ug a() {
        ug ugVar = this.model;
        if (ugVar != null) {
            return ugVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("model");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Didomi.INSTANCE.getInstance().getComponent$android_release().a(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        e3 e3VarA = e3.a(inflater, parent, false);
        this.binding = e3VarA;
        ConstraintLayout root = e3VarA.getRoot();
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
        String string;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("data_category")) == null) {
            throw new IllegalArgumentException("Missing data_category parameter");
        }
        a().c(string);
        e3 e3Var = this.binding;
        if (e3Var != null) {
            e3Var.e.setText(a().t0());
            e3Var.d.setText(a().j0());
            e3Var.c.setText(a().s0());
        }
    }
}
