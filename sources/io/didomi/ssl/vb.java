package io.didomi.ssl;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.didomi.ssl.purpose.common.model.PurposeCategory;
import io.didomi.ssl.purpose.mobile.PurposeSaveView;
import io.didomi.ssl.view.mobile.DidomiToggle;
import io.didomi.ssl.view.mobile.HeaderView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 82\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u0002H\u0016R\"\u0010 \u001a\u00020\u001a8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010&\u001a\u00020!8\u0016@\u0016X\u0097.¢\u0006\u0012\n\u0004\b\u0003\u0010\"\u001a\u0004\b\u0006\u0010#\"\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u00069"}, d2 = {"Lio/didomi/sdk/vb;", "Lio/didomi/sdk/g2;", "", "b", "Lio/didomi/sdk/purpose/common/model/PurposeCategory;", "category", "a", "Landroid/content/Context;", "context", "onAttach", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "view", "onViewCreated", "onResume", "Landroid/content/DialogInterface;", "dialog", "onCancel", "onPause", "onDestroyView", "Lio/didomi/sdk/ac;", "Lio/didomi/sdk/ac;", "c", "()Lio/didomi/sdk/ac;", "setModel", "(Lio/didomi/sdk/ac;)V", "model", "Lio/didomi/sdk/ah;", "Lio/didomi/sdk/ah;", "()Lio/didomi/sdk/ah;", "setThemeProvider", "(Lio/didomi/sdk/ah;)V", "themeProvider", "Lio/didomi/sdk/s2;", "Lio/didomi/sdk/s2;", "binding", "Lio/didomi/sdk/o5;", "d", "Lio/didomi/sdk/o5;", "bottomBarBinding", "Lio/didomi/sdk/v8;", "e", "Lio/didomi/sdk/v8;", "dismissHelper", "Lio/didomi/sdk/qb$a;", "f", "Lio/didomi/sdk/qb$a;", "spiCallback", "<init>", "()V", "g", "android_release"}, k = 1, mv = {1, 8, 0})
public final class vb extends g2 {

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public ac model;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public ah themeProvider;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private s2 binding;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private o5 bottomBarBinding;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final v8 dismissHelper = new v8();

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final qb.a spiCallback = new c();

    /* JADX INFO: renamed from: io.didomi.sdk.vb$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lio/didomi/sdk/vb$a;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(FragmentManager fragmentManager) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            if (fragmentManager.findFragmentByTag("SensitivePersonalInfoFragment") == null) {
                new vb().show(fragmentManager, "SensitivePersonalInfoFragment");
            } else {
                Log.w$default("Fragment with tag 'SensitivePersonalInfoFragment' is already present", null, 2, null);
            }
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lio/didomi/sdk/view/mobile/DidomiToggle$b;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lio/didomi/sdk/view/mobile/DidomiToggle$b;)V"}, k = 3, mv = {1, 8, 0})
    static final class b extends Lambda implements Function1 {
        b() {
            super(1);
        }

        public final void a(DidomiToggle.b bVar) {
            PurposeCategory purposeCategory = (PurposeCategory) vb.this.c().getSelectedCategory().getValue();
            if (purposeCategory == null) {
                return;
            }
            vb.this.a(purposeCategory);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((DidomiToggle.b) obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(vb this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.c().v();
        this$0.dismiss();
    }

    public final ac c() {
        ac acVar = this.model;
        if (acVar != null) {
            return acVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("model");
        return null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        h2 h2VarA = d2.a(this);
        if (h2VarA != null) {
            h2VarA.a(this);
        }
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        b();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        s2 s2VarA = s2.a(inflater, container, false);
        this.binding = s2VarA;
        ConstraintLayout constraintLayoutA = s2VarA.getRoot();
        Intrinsics.checkNotNullExpressionValue(constraintLayoutA, "inflate(inflater, contai…g = it\n            }.root");
        return constraintLayoutA;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        RecyclerView recyclerView;
        ac acVarC = c();
        acVarC.getSelectedCategoryState().removeObservers(getViewLifecycleOwner());
        u7 u7VarI = acVarC.getLogoProvider();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        u7VarI.a(viewLifecycleOwner);
        this.bottomBarBinding = null;
        s2 s2Var = this.binding;
        if (s2Var != null && (recyclerView = s2Var.d) != null) {
            recyclerView.setAdapter(null);
            recyclerView.setLayoutManager(null);
        }
        this.binding = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        this.dismissHelper.a();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.dismissHelper.a(this, c().getUiProvider());
    }

    @Override // io.didomi.ssl.g2, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ac acVarC = c();
        acVarC.C();
        acVarC.w();
        acVarC.A();
        acVarC.y();
        s2 s2Var = this.binding;
        int i = 4;
        if (s2Var != null) {
            AppCompatImageButton onViewCreated$lambda$11$lambda$3 = s2Var.b;
            Intrinsics.checkNotNullExpressionValue(onViewCreated$lambda$11$lambda$3, "onViewCreated$lambda$11$lambda$3");
            mi.a(onViewCreated$lambda$11$lambda$3, c().d(), c().e(), null, false, null, 0, null, null, 252, null);
            a7.a(onViewCreated$lambda$11$lambda$3, a().j());
            onViewCreated$lambda$11$lambda$3.setOnClickListener(new View.OnClickListener() { // from class: io.didomi.sdk.vb$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    vb.a(this.f$0, view2);
                }
            });
            HeaderView onViewCreated$lambda$11$lambda$4 = s2Var.c;
            Intrinsics.checkNotNullExpressionValue(onViewCreated$lambda$11$lambda$4, "onViewCreated$lambda$11$lambda$4");
            HeaderView.a(onViewCreated$lambda$11$lambda$4, c().q(), null, 0, 6, null);
            onViewCreated$lambda$11$lambda$4.a();
            View view2 = s2Var.f;
            Intrinsics.checkNotNullExpressionValue(view2, "binding.viewSpiBottomDivider");
            ni.a(view2, a());
            RecyclerView onViewCreated$lambda$11$lambda$5 = s2Var.d;
            List<o8> listB = c().b();
            onViewCreated$lambda$11$lambda$5.setAdapter(new qb(listB, a(), this.spiCallback));
            onViewCreated$lambda$11$lambda$5.setLayoutManager(new LinearLayoutManager(onViewCreated$lambda$11$lambda$5.getContext(), 1, false));
            Context context = onViewCreated$lambda$11$lambda$5.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            onViewCreated$lambda$11$lambda$5.addItemDecoration(new aa(context, a(), false, 4, null));
            int dimensionPixelSize = onViewCreated$lambda$11$lambda$5.getResources().getDimensionPixelSize(R.dimen.didomi_content_max_width);
            int i2 = onViewCreated$lambda$11$lambda$5.getResources().getDisplayMetrics().widthPixels;
            if (i2 > dimensionPixelSize) {
                int i3 = (i2 - dimensionPixelSize) / 2;
                onViewCreated$lambda$11$lambda$5.setPadding(i3, 0, i3, onViewCreated$lambda$11$lambda$5.getResources().getDimensionPixelSize(R.dimen.didomi_purpose_list_padding_bottom));
            }
            Intrinsics.checkNotNullExpressionValue(onViewCreated$lambda$11$lambda$5, "onViewCreated$lambda$11$lambda$5");
            ya.a(onViewCreated$lambda$11$lambda$5, q7.a(listB, PersonalDataDisplayItem.class));
            HeaderView headerView = s2Var.c;
            Intrinsics.checkNotNullExpressionValue(headerView, "binding.headerSpi");
            ya.a(onViewCreated$lambda$11$lambda$5, headerView);
            PurposeSaveView purposeSaveView = s2Var.e;
            Button saveButton$android_release = purposeSaveView.getSaveButton$android_release();
            if (saveButton$android_release != null) {
                zg.a(saveButton$android_release, purposeSaveView.getThemeProvider().i().j());
                saveButton$android_release.setOnClickListener(new View.OnClickListener() { // from class: io.didomi.sdk.vb$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        vb.b(this.f$0, view3);
                    }
                });
                saveButton$android_release.setText(c().k());
            }
            ImageView logoImage$android_release = purposeSaveView.getLogoImage$android_release();
            if (logoImage$android_release != null) {
                logoImage$android_release.setVisibility(c().a(true) ? 4 : 0);
            }
            PurposeSaveView purposeSaveView2 = s2Var.e;
            purposeSaveView2.setVisibility(0);
            purposeSaveView2.b();
            MutableLiveData mutableLiveDataN = c().getSelectedCategoryState();
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            final b bVar = new b();
            mutableLiveDataN.observe(viewLifecycleOwner, new Observer() { // from class: io.didomi.sdk.vb$$ExternalSyntheticLambda2
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    vb.a(bVar, obj);
                }
            });
        }
        o5 o5Var = this.bottomBarBinding;
        if (o5Var != null) {
            AppCompatImageView onViewCreated$lambda$13$lambda$12 = o5Var.e;
            if (!c().a(true)) {
                Intrinsics.checkNotNullExpressionValue(onViewCreated$lambda$13$lambda$12, "onViewCreated$lambda$13$lambda$12");
                a7.a(onViewCreated$lambda$13$lambda$12, a().g());
                i = 0;
            }
            onViewCreated$lambda$13$lambda$12.setVisibility(i);
        }
    }

    private final void b() {
        c().x();
        dismiss();
    }

    @Override // io.didomi.ssl.g2
    public ah a() {
        ah ahVar = this.themeProvider;
        if (ahVar != null) {
            return ahVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("themeProvider");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(vb this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(PurposeCategory category) {
        RecyclerView recyclerView;
        s2 s2Var = this.binding;
        RecyclerView.Adapter adapter = (s2Var == null || (recyclerView = s2Var.d) == null) ? null : recyclerView.getAdapter();
        qb qbVar = adapter instanceof qb ? (qb) adapter : null;
        if (qbVar != null) {
            qb.a(qbVar, category.getId(), c().d(category), false, 4, null);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\n"}, d2 = {"io/didomi/sdk/vb$c", "Lio/didomi/sdk/qb$a;", "Lio/didomi/sdk/o8$a;", "type", "", DiagnosticsEntry.ID_KEY, "Lio/didomi/sdk/view/mobile/DidomiToggle$b;", "state", "", "a", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements qb.a {

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[o8.a.values().length];
                try {
                    iArr[o8.a.Category.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                a = iArr;
            }
        }

        c() {
        }

        @Override // io.didomi.sdk.qb.a
        public void a(o8.a type, String id, DidomiToggle.b state) {
            PurposeCategory purposeCategoryA;
            RecyclerView recyclerView;
            RecyclerView recyclerView2;
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(state, "state");
            Purpose purposeB = vb.this.c().b(id);
            if (purposeB != null) {
                vb vbVar = vb.this;
                if (type == o8.a.PersonalData) {
                    vbVar.c().a(purposeB, state);
                    s2 s2Var = vbVar.binding;
                    RecyclerView.Adapter adapter = (s2Var == null || (recyclerView2 = s2Var.d) == null) ? null : recyclerView2.getAdapter();
                    qb qbVar = adapter instanceof qb ? (qb) adapter : null;
                    if (qbVar != null) {
                        qbVar.b(id, state, true);
                    }
                }
            }
            if (type != o8.a.Category || (purposeCategoryA = vb.this.c().a(id)) == null) {
                return;
            }
            vb vbVar2 = vb.this;
            vbVar2.c().a(purposeCategoryA, state);
            DidomiToggle.b bVarD = vbVar2.c().d(purposeCategoryA);
            s2 s2Var2 = vbVar2.binding;
            RecyclerView.Adapter adapter2 = (s2Var2 == null || (recyclerView = s2Var2.d) == null) ? null : recyclerView.getAdapter();
            qb qbVar2 = adapter2 instanceof qb ? (qb) adapter2 : null;
            if (qbVar2 != null) {
                qbVar2.a(id, bVarD, true);
            }
        }

        @Override // io.didomi.sdk.qb.a
        public void a(o8.a type, String id) throws Throwable {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(id, "id");
            if (a.a[type.ordinal()] == 1) {
                PurposeCategory purposeCategoryA = vb.this.c().a(id);
                if (purposeCategoryA == null) {
                    return;
                }
                rb.Companion aVar = rb.INSTANCE;
                FragmentManager parentFragmentManager = vb.this.getParentFragmentManager();
                Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                aVar.a(parentFragmentManager, purposeCategoryA);
                return;
            }
            throw new Throwable("Invalid type (" + type + ')');
        }
    }
}
