package io.didomi.ssl;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00032\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\"\u0010 \u001a\u00020\u001a8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010&\u001a\u00020!8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0005\u0010\"\u001a\u0004\b\u0017\u0010#\"\u0004\b$\u0010%R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010(¨\u0006,"}, d2 = {"Lio/didomi/sdk/rc;", "Landroidx/fragment/app/Fragment;", "", "e", "d", "c", "f", "g", "Landroid/content/Context;", "context", "onAttach", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "parent", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "view", "onViewCreated", "onDestroyView", "Lio/didomi/sdk/v2;", "a", "Lio/didomi/sdk/v2;", "binding", "Lio/didomi/sdk/qe;", "b", "Lio/didomi/sdk/qe;", "()Lio/didomi/sdk/qe;", "setPurposesModel", "(Lio/didomi/sdk/qe;)V", "purposesModel", "Lio/didomi/sdk/vc;", "Lio/didomi/sdk/vc;", "()Lio/didomi/sdk/vc;", "setModel", "(Lio/didomi/sdk/vc;)V", "model", "Landroid/view/View$OnKeyListener;", "Landroid/view/View$OnKeyListener;", "keyListener", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class rc extends Fragment {

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private v2 binding;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public qe purposesModel;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public vc model;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final View.OnKeyListener keyListener = new View.OnKeyListener() { // from class: io.didomi.sdk.rc$$ExternalSyntheticLambda2
        @Override // android.view.View.OnKeyListener
        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            return rc.a(this.f$0, view, i, keyEvent);
        }
    };

    /* JADX INFO: renamed from: io.didomi.sdk.rc$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\b¨\u0006\f"}, d2 = {"Lio/didomi/sdk/rc$a;", "", "Lio/didomi/sdk/m1;", "dataProcessing", "Lio/didomi/sdk/rc;", "a", "", "KEY_DATA_PROCESSING", "Ljava/lang/String;", "TAG", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final rc a(m1 dataProcessing) {
            Intrinsics.checkNotNullParameter(dataProcessing, "dataProcessing");
            rc rcVar = new rc();
            Bundle bundle = new Bundle();
            bundle.putParcelable("data_processing", dataProcessing);
            rcVar.setArguments(bundle);
            return rcVar;
        }

        private Companion() {
        }
    }

    private final void c() {
        v2 v2Var = this.binding;
        if (v2Var != null) {
            int size = b().C0().size();
            if (size >= 0 && size < 2) {
                ImageView imageCtvDataProcessingDetailLeftArrowImage = v2Var.b;
                Intrinsics.checkNotNullExpressionValue(imageCtvDataProcessingDetailLeftArrowImage, "imageCtvDataProcessingDetailLeftArrowImage");
                imageCtvDataProcessingDetailLeftArrowImage.setVisibility(4);
                ImageView imageCtvDataProcessingDetailRightArrowImage = v2Var.c;
                Intrinsics.checkNotNullExpressionValue(imageCtvDataProcessingDetailRightArrowImage, "imageCtvDataProcessingDetailRightArrowImage");
                imageCtvDataProcessingDetailRightArrowImage.setVisibility(4);
                return;
            }
            int currentDataProcessingIndex = b().getCurrentDataProcessingIndex();
            if (currentDataProcessingIndex == 0) {
                ImageView imageCtvDataProcessingDetailRightArrowImage2 = v2Var.c;
                Intrinsics.checkNotNullExpressionValue(imageCtvDataProcessingDetailRightArrowImage2, "imageCtvDataProcessingDetailRightArrowImage");
                imageCtvDataProcessingDetailRightArrowImage2.setVisibility(0);
                ImageView imageCtvDataProcessingDetailLeftArrowImage2 = v2Var.b;
                Intrinsics.checkNotNullExpressionValue(imageCtvDataProcessingDetailLeftArrowImage2, "imageCtvDataProcessingDetailLeftArrowImage");
                imageCtvDataProcessingDetailLeftArrowImage2.setVisibility(4);
                return;
            }
            if (currentDataProcessingIndex == size - 1) {
                ImageView imageCtvDataProcessingDetailRightArrowImage3 = v2Var.c;
                Intrinsics.checkNotNullExpressionValue(imageCtvDataProcessingDetailRightArrowImage3, "imageCtvDataProcessingDetailRightArrowImage");
                imageCtvDataProcessingDetailRightArrowImage3.setVisibility(4);
                ImageView imageCtvDataProcessingDetailLeftArrowImage3 = v2Var.b;
                Intrinsics.checkNotNullExpressionValue(imageCtvDataProcessingDetailLeftArrowImage3, "imageCtvDataProcessingDetailLeftArrowImage");
                imageCtvDataProcessingDetailLeftArrowImage3.setVisibility(0);
                return;
            }
            ImageView imageCtvDataProcessingDetailRightArrowImage4 = v2Var.c;
            Intrinsics.checkNotNullExpressionValue(imageCtvDataProcessingDetailRightArrowImage4, "imageCtvDataProcessingDetailRightArrowImage");
            imageCtvDataProcessingDetailRightArrowImage4.setVisibility(0);
            ImageView imageCtvDataProcessingDetailLeftArrowImage4 = v2Var.b;
            Intrinsics.checkNotNullExpressionValue(imageCtvDataProcessingDetailLeftArrowImage4, "imageCtvDataProcessingDetailLeftArrowImage");
            imageCtvDataProcessingDetailLeftArrowImage4.setVisibility(0);
        }
    }

    private final void d() {
        g();
        f();
        c();
    }

    private final void e() {
        List<m1> listC0 = b().C0();
        int currentDataProcessingIndex = b().getCurrentDataProcessingIndex();
        if (currentDataProcessingIndex >= 0 && currentDataProcessingIndex <= listC0.size()) {
            a().a(listC0.get(currentDataProcessingIndex));
        }
        d();
    }

    private final void f() {
        TextSwitcher textSwitcher;
        v2 v2Var = this.binding;
        if (v2Var == null || (textSwitcher = v2Var.f) == null) {
            return;
        }
        textSwitcher.setText(a().l());
    }

    private final void g() {
        TextSwitcher textSwitcher;
        v2 v2Var = this.binding;
        if (v2Var == null || (textSwitcher = v2Var.g) == null) {
            return;
        }
        textSwitcher.setText(a().h());
    }

    public final vc a() {
        vc vcVar = this.model;
        if (vcVar != null) {
            return vcVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("model");
        return null;
    }

    public final qe b() {
        qe qeVar = this.purposesModel;
        if (qeVar != null) {
            return qeVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("purposesModel");
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
        v2 v2VarA = v2.a(getLayoutInflater(), parent, false);
        this.binding = v2VarA;
        ConstraintLayout root = v2VarA.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "inflate(layoutInflater, …g = it\n            }.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        ScrollView scrollView;
        super.onDestroyView();
        v2 v2Var = this.binding;
        if (v2Var != null && (scrollView = v2Var.e) != null) {
            scrollView.setOnKeyListener(null);
        }
        this.binding = null;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002c  */
    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) throws Throwable {
        m1 m1Var;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (Build.VERSION.SDK_INT >= 33) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                m1Var = (m1) arguments.getParcelable("data_processing", m1.class);
            } else {
                m1Var = null;
            }
        } else {
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                m1Var = (m1) arguments2.getParcelable("data_processing");
            } else {
                m1Var = null;
            }
        }
        vc vcVarA = a();
        if (m1Var == null) {
            throw new Throwable("DataProcessing is invalid");
        }
        vcVarA.a(m1Var);
        v2 v2Var = this.binding;
        if (v2Var != null) {
            v2Var.e.setOnKeyListener(this.keyListener);
            v2Var.f.setFactory(new ViewSwitcher.ViewFactory() { // from class: io.didomi.sdk.rc$$ExternalSyntheticLambda0
                @Override // android.widget.ViewSwitcher.ViewFactory
                public final View makeView() {
                    return rc.a(this.f$0);
                }
            });
            v2Var.g.setFactory(new ViewSwitcher.ViewFactory() { // from class: io.didomi.sdk.rc$$ExternalSyntheticLambda1
                @Override // android.widget.ViewSwitcher.ViewFactory
                public final View makeView() {
                    return rc.b(this.f$0);
                }
            });
            v2Var.d.getLayoutTransition().enableTransitionType(4);
            v2Var.h.setText(a().k());
        }
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(rc this$0, View view, int i, KeyEvent keyEvent) {
        TextSwitcher textSwitcher;
        TextSwitcher textSwitcher2;
        TextSwitcher textSwitcher3;
        TextSwitcher textSwitcher4;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i == 21 && keyEvent.getAction() == 1) {
            if (this$0.b().X1()) {
                v2 v2Var = this$0.binding;
                if (v2Var != null && (textSwitcher4 = v2Var.g) != null) {
                    textSwitcher4.setInAnimation(textSwitcher4.getContext(), R.anim.didomi_text_enter_from_left_alpha);
                    textSwitcher4.setOutAnimation(textSwitcher4.getContext(), R.anim.didomi_text_exit_to_right_alpha);
                }
                v2 v2Var2 = this$0.binding;
                if (v2Var2 != null && (textSwitcher3 = v2Var2.f) != null) {
                    textSwitcher3.setInAnimation(textSwitcher3.getContext(), R.anim.didomi_text_enter_from_left_alpha);
                    textSwitcher3.setOutAnimation(textSwitcher3.getContext(), R.anim.didomi_text_exit_to_right_alpha);
                }
                this$0.e();
            }
        } else {
            if (i != 22 || keyEvent.getAction() != 1) {
                return false;
            }
            if (this$0.b().W1()) {
                v2 v2Var3 = this$0.binding;
                if (v2Var3 != null && (textSwitcher2 = v2Var3.g) != null) {
                    textSwitcher2.setInAnimation(textSwitcher2.getContext(), R.anim.didomi_text_enter_from_right_alpha);
                    textSwitcher2.setOutAnimation(textSwitcher2.getContext(), R.anim.didomi_text_exit_to_left_alpha);
                }
                v2 v2Var4 = this$0.binding;
                if (v2Var4 != null && (textSwitcher = v2Var4.f) != null) {
                    textSwitcher.setInAnimation(textSwitcher.getContext(), R.anim.didomi_text_enter_from_right_alpha);
                    textSwitcher.setOutAnimation(textSwitcher.getContext(), R.anim.didomi_text_exit_to_left_alpha);
                }
                this$0.e();
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View b(rc this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = new TextView(this$0.getContext());
        textView.setTextAppearance(R.style.DidomiTVTextAction);
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View a(rc this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = new TextView(this$0.getContext());
        textView.setTextAppearance(R.style.DidomiTVTextLarge);
        return textView;
    }
}
