package io.didomi.ssl;

import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.didomi.ssl.events.PreferencesClickViewVendorsEvent;
import io.didomi.ssl.models.DataCategory;
import io.didomi.ssl.vendors.ctv.model.TVDataProcessingLegalType;
import io.didomi.ssl.view.mobile.DidomiToggle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B[\b\u0007\u0012\b\u0010\u0099\u0001\u001a\u00030\u0098\u0001\u0012\u0006\u00102\u001a\u00020/\u0012\b\u0010\u009b\u0001\u001a\u00030\u009a\u0001\u0012\u0006\u00106\u001a\u000203\u0012\b\u0010\u009d\u0001\u001a\u00030\u009c\u0001\u0012\u0006\u0010:\u001a\u000207\u0012\u0006\u0010>\u001a\u00020;\u0012\b\u0010\u009f\u0001\u001a\u00030\u009e\u0001\u0012\u0006\u0010B\u001a\u00020?¢\u0006\u0006\b \u0001\u0010¡\u0001J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0012\u0010\u000b\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002*\b\u0012\u0004\u0012\u00020\f0\bH\u0002J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u000b\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u000eJ\b\u0010\u001c\u001a\u0004\u0018\u00010\nJ\b\u0010\u001d\u001a\u0004\u0018\u00010\nJ\b\u0010\u001e\u001a\u0004\u0018\u00010\nJ\b\u0010\u001f\u001a\u0004\u0018\u00010\nJ\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\"0\u00022\u0006\u0010!\u001a\u00020 J\u0017\u0010\u0019\u001a\u00020\u00122\u0006\u0010!\u001a\u00020 H\u0000¢\u0006\u0004\b\u0019\u0010#J\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010!\u001a\u00020 H\u0000¢\u0006\u0004\b\u000b\u0010$J\u000f\u0010%\u001a\u00020\u0012H\u0010¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0019\u001a\u0004\u0018\u00010)2\u0006\u0010(\u001a\u00020'J\u0010\u0010\u000b\u001a\u0004\u0018\u00010)2\u0006\u0010(\u001a\u00020'J\u0010\u0010\r\u001a\u0004\u0018\u00010)2\u0006\u0010(\u001a\u00020'J\u0006\u0010*\u001a\u00020\u0015J\u0017\u0010+\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b-\u0010,J\u000e\u0010\u0019\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\u0012R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\"\u0010I\u001a\u00020'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010L\u001a\u00020'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010D\u001a\u0004\bK\u0010F\"\u0004\b\u001a\u0010HR\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u001b\u0010U\u001a\u00020\u00178FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR\u0014\u0010W\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bV\u0010&R\u0011\u0010Y\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\bX\u0010&R\u0011\u0010[\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\bZ\u0010&R\u0011\u0010]\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\\\u0010&R\u0011\u0010_\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b^\u0010&R\u0011\u0010a\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b`\u0010&R\u0011\u0010c\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\bb\u0010&R\u0011\u0010e\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\bd\u0010&R\u0011\u0010g\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\bf\u0010&R\u0011\u0010i\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\bh\u0010&R\u0011\u0010k\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\bj\u0010&R\u0011\u0010m\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\bl\u0010&R\u0011\u0010o\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\bn\u0010&R\u0011\u0010q\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\bp\u0010&R\u0011\u0010s\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\br\u0010&R\u0011\u0010u\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\bt\u0010&R\u0011\u0010w\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\bv\u0010&R\u0011\u0010y\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\bx\u0010&R\u0011\u0010{\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\bz\u0010&R\u0018\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020}0|8F¢\u0006\u0006\u001a\u0004\b~\u0010\u007fR\u0015\u0010\u0084\u0001\u001a\u00030\u0081\u00018F¢\u0006\b\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0019\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00020\u00100\u00028F¢\u0006\u0007\u001a\u0005\b\u0085\u0001\u0010\u007fR\u0015\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0007\u001a\u0005\b\u0087\u0001\u0010&R\u0013\u0010\u008a\u0001\u001a\u00020\u00178F¢\u0006\u0007\u001a\u0005\b\u0089\u0001\u0010TR\u001a\u0010\u008d\u0001\u001a\t\u0012\u0005\u0012\u00030\u008b\u00010|8F¢\u0006\u0007\u001a\u0005\b\u008c\u0001\u0010\u007fR\u0013\u0010\u008f\u0001\u001a\u00020\u00128F¢\u0006\u0007\u001a\u0005\b\u008e\u0001\u0010&R\u0013\u0010\u0091\u0001\u001a\u00020\u00128F¢\u0006\u0007\u001a\u0005\b\u0090\u0001\u0010&R\u0016\u0010\u0093\u0001\u001a\u00020\u00128@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u0092\u0001\u0010&R\u0015\u0010\u0097\u0001\u001a\u00030\u0094\u00018F¢\u0006\b\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001¨\u0006¢\u0001"}, d2 = {"Lio/didomi/sdk/ug;", "Lio/didomi/sdk/ki;", "", "Lio/didomi/sdk/bf$a;", "m0", "o0", "l0", "n0", "", "Lio/didomi/sdk/p1;", "Landroid/text/SpannedString;", "b", "Lio/didomi/sdk/m1;", "a", "Lio/didomi/sdk/Vendor;", "vendor", "Lio/didomi/sdk/hg$g;", "L", "", "M", "(Lio/didomi/sdk/Vendor;)Ljava/lang/String;", "", "T0", "", "isChecked", "c", "d", "N", "f0", "e0", "h0", "k0", "Lio/didomi/sdk/vendors/ctv/model/TVDataProcessingLegalType;", "legalType", "Lio/didomi/sdk/bf;", "(Lio/didomi/sdk/vendors/ctv/model/TVDataProcessingLegalType;)Ljava/lang/String;", "(Lio/didomi/sdk/vendors/ctv/model/TVDataProcessingLegalType;)Ljava/util/List;", "H0", "()Ljava/lang/String;", "", "size", "Landroid/graphics/Bitmap;", "U0", "O", "(Lio/didomi/sdk/Vendor;)Z", "P", DiagnosticsEntry.ID_KEY, "Lio/didomi/sdk/e0;", "u", "Lio/didomi/sdk/e0;", "configurationRepository", "Lio/didomi/sdk/n7;", "v", "Lio/didomi/sdk/n7;", "languagesHelper", "Lio/didomi/sdk/jh;", "w", "Lio/didomi/sdk/jh;", "userChoicesInfoProvider", "Lio/didomi/sdk/zh;", "x", "Lio/didomi/sdk/zh;", "vendorRepository", "Lio/didomi/sdk/ib;", "y", "Lio/didomi/sdk/ib;", "resourcesHelper", "z", "I", "i0", "()I", "e", "(I)V", "focusedPosition", "A", "g0", "detailFocusedPosition", "Lio/didomi/sdk/models/DataCategory;", "B", "Lio/didomi/sdk/models/DataCategory;", "selectedDataCategory", "C", "Lkotlin/Lazy;", "y0", "()Z", "shouldHideReadMoreButtonFromVendorData", "q0", "quickActionTextLabel", "S0", "vendorsTitleLabel", "r0", "quickActionTitleLabel", "x0", "settingsTitleLabel", "D0", "vendorConsentOnLabel", "C0", "vendorConsentOffLabel", "N0", "vendorOnLabel", "M0", "vendorOffLabel", "R0", "vendorsSectionTitleLabel", "F0", "vendorIabTitleLabel", "K0", "vendorLegIntOnLabel", "J0", "vendorLegIntOffLabel", "I0", "vendorLegIntLabel", "Q0", "vendorReadMoreLabel", "B0", "vendorConsentLabel", "P0", "vendorPrivacyPolicyTitle", "E0", "vendorIabDescriptionText", "O0", "vendorPrivacyDescriptionText", "G0", "vendorLegIntClaimDescriptionText", "", "Lio/didomi/sdk/hg;", "L0", "()Ljava/util/List;", "vendorList", "Lio/didomi/sdk/hg$a;", "A0", "()Lio/didomi/sdk/hg$a;", "vendorBulk", "z0", "tvVendorItemList", "w0", "selectedVendorName", "v0", "selectedVendorHasIABDisclaimer", "Lio/didomi/sdk/wf;", "u0", "selectedVendorDetail", "t0", "selectedDataCategoryName", "s0", "selectedDataCategoryDescription", "j0", "itemDescriptionLabel", "Ljava/util/Locale;", "p0", "()Ljava/util/Locale;", "locale", "Lio/didomi/sdk/apiEvents/a;", "apiEventsRepository", "Lio/didomi/sdk/b6;", "eventsRepository", "Lio/didomi/sdk/ah;", "themeProvider", "Lio/didomi/sdk/u7;", "logoProvider", "<init>", "(Lio/didomi/sdk/apiEvents/a;Lio/didomi/sdk/e0;Lio/didomi/sdk/b6;Lio/didomi/sdk/n7;Lio/didomi/sdk/ah;Lio/didomi/sdk/jh;Lio/didomi/sdk/zh;Lio/didomi/sdk/u7;Lio/didomi/sdk/ib;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class ug extends ki {

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    private int detailFocusedPosition;

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    private DataCategory selectedDataCategory;

    /* JADX INFO: renamed from: C, reason: from kotlin metadata */
    private final Lazy shouldHideReadMoreButtonFromVendorData;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    private final e0 configurationRepository;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    private final n7 languagesHelper;

    /* JADX INFO: renamed from: w, reason: from kotlin metadata */
    private final jh userChoicesInfoProvider;

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    private final zh vendorRepository;

    /* JADX INFO: renamed from: y, reason: from kotlin metadata */
    private final ib resourcesHelper;

    /* JADX INFO: renamed from: z, reason: from kotlin metadata */
    private int focusedPosition;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[TVDataProcessingLegalType.values().length];
            try {
                iArr[TVDataProcessingLegalType.CONSENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TVDataProcessingLegalType.LEGINT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TVDataProcessingLegalType.ADDITIONAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TVDataProcessingLegalType.REQUIRED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    public static final class b<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return ComparisonsKt.compareValues(((m1) t).getName(), ((m1) t2).getName());
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lio/didomi/sdk/p1;", "it", "", "a", "(Lio/didomi/sdk/p1;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 8, 0})
    static final class c extends Lambda implements Function1 {
        final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str) {
            super(1);
            this.b = str;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(DataProcessingDisplay it) {
            Intrinsics.checkNotNullParameter(it, "it");
            if (it.getRetentionTime() == null) {
                return new SpannableString("• " + it.getLabel());
            }
            Integer retentionTime = it.getRetentionTime();
            SpannableString spannableString = new SpannableString("• " + it.getLabel() + '\t' + this.b + ' ' + ((retentionTime != null && retentionTime.intValue() == 1) ? n7.a(ug.this.languagesHelper, "day_singular", null, null, null, 14, null) : n7.a(ug.this.languagesHelper, "day_plural", null, MapsKt.mapOf(TuplesKt.to("{nb}", String.valueOf(it.getRetentionTime()))), null, 10, null)));
            ug ugVar = ug.this;
            int iIndexOf$default = StringsKt.indexOf$default((CharSequence) spannableString, "\t", 0, false, 6, (Object) null);
            spannableString.setSpan(new RelativeSizeSpan(0.8f), iIndexOf$default, spannableString.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(ugVar.resourcesHelper.a(R.color.didomi_tv_common_text_with_alpha)), iIndexOf$default, spannableString.length(), 33);
            return spannableString;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0})
    static final class d extends Lambda implements Function0 {
        d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(Intrinsics.areEqual(m.d(ug.this.configurationRepository.b()), "2.2"));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ug(io.didomi.ssl.apiEvents.a apiEventsRepository, e0 configurationRepository, b6 eventsRepository, n7 languagesHelper, ah themeProvider, jh userChoicesInfoProvider, zh vendorRepository, u7 logoProvider, ib resourcesHelper) {
        super(apiEventsRepository, configurationRepository, eventsRepository, languagesHelper, themeProvider, userChoicesInfoProvider, vendorRepository, logoProvider);
        Intrinsics.checkNotNullParameter(apiEventsRepository, "apiEventsRepository");
        Intrinsics.checkNotNullParameter(configurationRepository, "configurationRepository");
        Intrinsics.checkNotNullParameter(eventsRepository, "eventsRepository");
        Intrinsics.checkNotNullParameter(languagesHelper, "languagesHelper");
        Intrinsics.checkNotNullParameter(themeProvider, "themeProvider");
        Intrinsics.checkNotNullParameter(userChoicesInfoProvider, "userChoicesInfoProvider");
        Intrinsics.checkNotNullParameter(vendorRepository, "vendorRepository");
        Intrinsics.checkNotNullParameter(logoProvider, "logoProvider");
        Intrinsics.checkNotNullParameter(resourcesHelper, "resourcesHelper");
        this.configurationRepository = configurationRepository;
        this.languagesHelper = languagesHelper;
        this.userChoicesInfoProvider = userChoicesInfoProvider;
        this.vendorRepository = vendorRepository;
        this.resourcesHelper = resourcesHelper;
        this.shouldHideReadMoreButtonFromVendorData = LazyKt.lazy(new d());
    }

    private final List<bf.Description> l0() {
        List<bf.Description> listA;
        Vendor vendor = (Vendor) getSelectedVendor().getValue();
        return (vendor == null || (listA = a(this.vendorRepository.c(vendor))) == null) ? CollectionsKt.emptyList() : listA;
    }

    private final List<bf.Description> m0() {
        List<bf.Description> listA;
        Vendor vendor = (Vendor) getSelectedVendor().getValue();
        return (vendor == null || (listA = a(h(vendor))) == null) ? CollectionsKt.emptyList() : listA;
    }

    private final List<bf.Description> n0() {
        List<bf.Description> listA;
        Vendor vendor = (Vendor) getSelectedVendor().getValue();
        return (vendor == null || (listA = a(this.vendorRepository.b(vendor))) == null) ? CollectionsKt.emptyList() : listA;
    }

    private final List<bf.Description> o0() {
        List<bf.Description> listA;
        Vendor vendor = (Vendor) getSelectedVendor().getValue();
        return (vendor == null || (listA = a(n(vendor))) == null) ? CollectionsKt.emptyList() : listA;
    }

    private final String q0() {
        return n7.a(this.languagesHelper, this.configurationRepository.b().getPreferences().getContent().c(), "bulk_action_on_vendors", (gc) null, 4, (Object) null);
    }

    public final hg.Bulk A0() {
        boolean zB = b();
        return new hg.Bulk(q0(), zB ? N0() : M0(), zB, 0, 8, null);
    }

    public final String B0() {
        return n7.a(this.languagesHelper, AuthorizationRequest.Prompt.CONSENT, (gc) null, (Map) null, 6, (Object) null);
    }

    public final String C0() {
        return n7.a(this.languagesHelper, "consent_off", (gc) null, (Map) null, 6, (Object) null);
    }

    public final String D0() {
        return n7.a(this.languagesHelper, "consent_on", (gc) null, (Map) null, 6, (Object) null);
    }

    public final String E0() {
        return n7.a(this.languagesHelper, "external_link_description", (gc) null, MapsKt.mapOf(TuplesKt.to("{url}", C())), 2, (Object) null);
    }

    public final String F0() {
        return n7.a(this.languagesHelper, "vendor_iab_transparency_button_title", (gc) null, (Map) null, 6, (Object) null);
    }

    public final String G0() {
        String strA;
        Vendor vendor = (Vendor) getSelectedVendor().getValue();
        if (vendor != null) {
            String strM = m(vendor);
            strA = (strM == null || StringsKt.isBlank(strM)) ? "" : n7.a(this.languagesHelper, "external_link_description", (gc) null, MapsKt.mapOf(TuplesKt.to("{url}", strM)), 2, (Object) null);
        } else {
            strA = null;
        }
        return strA == null ? "" : strA;
    }

    @Override // io.didomi.ssl.ki
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public String Y() {
        return X();
    }

    public final String I0() {
        return n7.a(this.languagesHelper, "object_to_legitimate_interest", (gc) null, (Map) null, 6, (Object) null);
    }

    public final String J0() {
        return n7.a(this.languagesHelper, "object_to_legitimate_interest_status_off", (gc) null, (Map) null, 6, (Object) null);
    }

    public final String K0() {
        return n7.a(this.languagesHelper, "object_to_legitimate_interest_status_on", (gc) null, (Map) null, 6, (Object) null);
    }

    public final hg.Vendor L(Vendor vendor) {
        String strC0;
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        boolean zH = H(vendor);
        boolean z = zH && N(vendor);
        String name = vendor.getName();
        if (z) {
            strC0 = D0();
        } else {
            strC0 = zH ? C0() : "";
        }
        return new hg.Vendor(vendor, zH, name, strC0, z, y(vendor), 0, 64, null);
    }

    public final List<hg> L0() {
        int size;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new hg.Header(0, 1, null));
        arrayList.add(new hg.Title(S0(), 0, 2, null));
        Spanned spannedX = x();
        String string = spannedX != null ? spannedX.toString() : null;
        if (string == null) {
            string = "";
        }
        if (!StringsKt.isBlank(string)) {
            arrayList.add(new hg.Description(string, 0, 2, null));
        }
        if (Q()) {
            arrayList.add(new hg.Section(r0(), 0, 2, null));
            size = arrayList.size();
            arrayList.add(A0());
        } else {
            size = z0().isEmpty() ? 0 : arrayList.size() + 1;
        }
        arrayList.add(new hg.Section(R0(), 0, 2, null));
        arrayList.addAll(z0());
        arrayList.add(new hg.Footer(0, 1, null));
        if (this.focusedPosition == 0 && size >= 0) {
            this.focusedPosition = size;
        }
        return arrayList;
    }

    public final String M(Vendor vendor) {
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        return n7.a(this.languagesHelper, "vendor_privacy_policy_button_title", (gc) null, MapsKt.mapOf(TuplesKt.to("{vendorName}", vendor.getName())), 2, (Object) null);
    }

    public final String M0() {
        return n7.a(this.languagesHelper, "purposes_off", (gc) null, (Map) null, 6, (Object) null);
    }

    public final boolean N(Vendor vendor) {
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        if (this.userChoicesInfoProvider.g().contains(vendor) || !F(vendor)) {
            return (this.userChoicesInfoProvider.e().contains(vendor) && G(vendor)) ? false : true;
        }
        return false;
    }

    public final String N0() {
        return n7.a(this.languagesHelper, "purposes_on", (gc) null, (Map) null, 6, (Object) null);
    }

    public final boolean O(Vendor vendor) {
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        return !this.vendorRepository.c(vendor).isEmpty();
    }

    public final String O0() {
        String strA;
        Vendor vendor = (Vendor) getSelectedVendor().getValue();
        if (vendor != null) {
            String strS = s(vendor);
            strA = (strS == null || StringsKt.isBlank(strS)) ? "" : n7.a(this.languagesHelper, "external_link_description", (gc) null, MapsKt.mapOf(TuplesKt.to("{url}", strS)), 2, (Object) null);
        } else {
            strA = null;
        }
        return strA == null ? "" : strA;
    }

    public final boolean P(Vendor vendor) {
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        return !vendor.getEssentialPurposeIds().isEmpty();
    }

    public final String P0() {
        return n7.a(this.languagesHelper, "vendor_privacy_policy_screen_title", gc.UPPER_CASE, (Map) null, 4, (Object) null);
    }

    public final String Q0() {
        return n7.a(this.languagesHelper, "read_more", (gc) null, (Map) null, 6, (Object) null);
    }

    public final String R0() {
        return n7.a(this.languagesHelper, "our_partners_title", gc.UPPER_CASE, (Map) null, 4, (Object) null);
    }

    public final String S0() {
        return n7.a(this.languagesHelper, this.configurationRepository.b().getPreferences().getContent().e(), "our_partners_title", (gc) null, 4, (Object) null);
    }

    public final void T0() {
        a(new PreferencesClickViewVendorsEvent());
    }

    public final void U0() {
        getSelectedVendor().setValue(null);
    }

    public final void d(int i) {
        this.detailFocusedPosition = i;
    }

    public final void e(int i) {
        this.focusedPosition = i;
    }

    public final SpannedString e0() {
        Pair<String, List<DataProcessingDisplay>> pairF;
        List list;
        Vendor vendor = (Vendor) getSelectedVendor().getValue();
        if (vendor == null || (pairF = f(vendor)) == null || (list = (List) pairF.getSecond()) == null) {
            return null;
        }
        return b(list);
    }

    public final SpannedString f0() {
        Pair<String, List<DataProcessingDisplay>> pairG;
        List list;
        Vendor vendor = (Vendor) getSelectedVendor().getValue();
        if (vendor == null || (pairG = g(vendor)) == null || (list = (List) pairG.getSecond()) == null) {
            return null;
        }
        return b(list);
    }

    /* JADX INFO: renamed from: g0, reason: from getter */
    public final int getDetailFocusedPosition() {
        return this.detailFocusedPosition;
    }

    public final SpannedString h0() {
        Pair<String, List<DataProcessingDisplay>> pairL;
        List list;
        Vendor vendor = (Vendor) getSelectedVendor().getValue();
        if (vendor == null || (pairL = l(vendor)) == null || (list = (List) pairL.getSecond()) == null) {
            return null;
        }
        return b(list);
    }

    /* JADX INFO: renamed from: i0, reason: from getter */
    public final int getFocusedPosition() {
        return this.focusedPosition;
    }

    public final String j0() {
        return n7.a(this.languagesHelper, "purpose_legal_description", gc.UPPER_CASE, (Map) null, 4, (Object) null);
    }

    public final SpannedString k0() {
        Pair<String, List<DataProcessingDisplay>> pairO;
        List list;
        Vendor vendor = (Vendor) getSelectedVendor().getValue();
        if (vendor == null || (pairO = o(vendor)) == null || (list = (List) pairO.getSecond()) == null) {
            return null;
        }
        return b(list);
    }

    public final Locale p0() {
        return this.languagesHelper.getSelectedLocale();
    }

    public final String r0() {
        return n7.a(this.languagesHelper, "bulk_action_section_title", gc.UPPER_CASE, (Map) null, 4, (Object) null);
    }

    public final String s0() {
        String description;
        DataCategory dataCategory = this.selectedDataCategory;
        return (dataCategory == null || (description = dataCategory.getDescription()) == null) ? "" : description;
    }

    public final String t0() {
        String name;
        DataCategory dataCategory = this.selectedDataCategory;
        return (dataCategory == null || (name = dataCategory.getName()) == null) ? "" : name;
    }

    public final List<wf> u0() {
        Vendor vendor = (Vendor) getSelectedVendor().getValue();
        if (vendor == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new wf.Disclaimer(vendor.getName(), fc.h(q(vendor)).toString(), y(vendor), 0, 8, null));
        String strS = s(vendor);
        if (strS != null && !StringsKt.isBlank(strS)) {
            arrayList.add(new wf.ArrowLink(M(vendor), wf.ArrowLink.EnumC0156a.PrivacyPolicy, 0, 4, null));
            int size = this.detailFocusedPosition;
            if (size <= 0) {
                size = arrayList.size() - 1;
            }
            this.detailFocusedPosition = size;
        }
        String strM = m(vendor);
        if (strM != null && !StringsKt.isBlank(strM)) {
            arrayList.add(new wf.ArrowLink(Y(), wf.ArrowLink.EnumC0156a.LegIntClaim, 0, 4, null));
            int size2 = this.detailFocusedPosition;
            if (size2 <= 0) {
                size2 = arrayList.size() - 1;
            }
            this.detailFocusedPosition = size2;
        }
        if (y(vendor)) {
            arrayList.add(new wf.ArrowLink(F0(), wf.ArrowLink.EnumC0156a.Iab, 0, 4, null));
            int size3 = this.detailFocusedPosition;
            if (size3 <= 0) {
                size3 = arrayList.size() - 1;
            }
            this.detailFocusedPosition = size3;
        }
        Set<DataCategory> setA = this.vendorRepository.a(vendor);
        if (!setA.isEmpty()) {
            arrayList.add(new wf.SectionTitle(t(), 0, 2, null));
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(setA, 10));
            for (DataCategory dataCategory : setA) {
                arrayList2.add(Boolean.valueOf(arrayList.add(new wf.DataCategory(dataCategory.getName(), dataCategory.getId(), 0, 4, null))));
            }
        }
        arrayList.add(new wf.SectionTitle(x0(), 0, 2, null));
        if (F(vendor)) {
            arrayList.add(new wf.Consent(getSelectedVendorConsentState().getValue() == DidomiToggle.b.ENABLED, r(), D0(), C0(), 0, 16, null));
            int size4 = this.detailFocusedPosition;
            if (size4 <= 0) {
                size4 = arrayList.size() - 1;
            }
            this.detailFocusedPosition = size4;
        }
        if (G(vendor)) {
            arrayList.add(new wf.LegitimateInterest(getSelectedVendorLegIntState().getValue() != DidomiToggle.b.ENABLED, E(), K0(), J0(), 0, 16, null));
            int size5 = this.detailFocusedPosition;
            if (size5 <= 0) {
                size5 = arrayList.size() - 1;
            }
            this.detailFocusedPosition = size5;
        }
        if (O(vendor)) {
            arrayList.add(new wf.ArrowLink(i(), wf.ArrowLink.EnumC0156a.AdditionalDataProcessing, 0, 4, null));
        }
        if (P(vendor)) {
            arrayList.add(new wf.ArrowLink(v(), wf.ArrowLink.EnumC0156a.EssentialPurpose, 0, 4, null));
        }
        if (yh.h(vendor)) {
            String strI = i(vendor);
            if (strI == null) {
                strI = "";
            }
            arrayList.add(new wf.Cookie(strI, 0, 2, null));
        }
        arrayList.add(new wf.Footer(0, 1, null));
        return arrayList;
    }

    public final boolean v0() {
        Vendor vendor = (Vendor) getSelectedVendor().getValue();
        return vendor != null && y(vendor);
    }

    public final String w0() {
        Vendor vendor = (Vendor) getSelectedVendor().getValue();
        if (vendor != null) {
            return vendor.getName();
        }
        return null;
    }

    public final String x0() {
        return n7.a(this.languagesHelper, "settings", gc.UPPER_CASE, (Map) null, 4, (Object) null);
    }

    public final boolean y0() {
        return ((Boolean) this.shouldHideReadMoreButtonFromVendorData.getValue()).booleanValue();
    }

    public final List<hg.Vendor> z0() {
        List<Vendor> listJ = j();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listJ, 10));
        Iterator<T> it = listJ.iterator();
        while (it.hasNext()) {
            arrayList.add(L((Vendor) it.next()));
        }
        return arrayList;
    }

    public final List<bf> a(TVDataProcessingLegalType legalType) {
        Intrinsics.checkNotNullParameter(legalType, "legalType");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new bf.Header(0, 1, null));
        Vendor vendor = (Vendor) getSelectedVendor().getValue();
        String name = vendor != null ? vendor.getName() : null;
        if (name == null) {
            name = "";
        }
        arrayList.add(new bf.Title(name, c(legalType), v0(), 0, 8, null));
        arrayList.addAll(b(legalType));
        arrayList.add(new bf.Footer(0, 1, null));
        return CollectionsKt.toList(arrayList);
    }

    public final void b(boolean isChecked) {
        DidomiToggle.b bVar = isChecked ? DidomiToggle.b.ENABLED : DidomiToggle.b.DISABLED;
        d(bVar);
        a(bVar);
    }

    public final void c(boolean isChecked) {
        if (isChecked) {
            b(DidomiToggle.b.ENABLED);
        } else {
            b(DidomiToggle.b.DISABLED);
        }
        c0();
    }

    public final void d(boolean isChecked) {
        if (isChecked) {
            c(DidomiToggle.b.DISABLED);
        } else {
            c(DidomiToggle.b.ENABLED);
        }
        c0();
    }

    public final List<bf.Description> b(TVDataProcessingLegalType legalType) {
        Intrinsics.checkNotNullParameter(legalType, "legalType");
        int i = a.a[legalType.ordinal()];
        if (i == 1) {
            return m0();
        }
        if (i == 2) {
            return o0();
        }
        if (i == 3) {
            return l0();
        }
        if (i == 4) {
            return n0();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final String c(TVDataProcessingLegalType legalType) {
        Intrinsics.checkNotNullParameter(legalType, "legalType");
        int i = a.a[legalType.ordinal()];
        if (i == 1) {
            String upperCase = r().toUpperCase(this.languagesHelper.getSelectedLocale());
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
            return upperCase;
        }
        if (i == 2) {
            String upperCase2 = E().toUpperCase(this.languagesHelper.getSelectedLocale());
            Intrinsics.checkNotNullExpressionValue(upperCase2, "this as java.lang.String).toUpperCase(locale)");
            return upperCase2;
        }
        if (i == 3) {
            String upperCase3 = i().toUpperCase(this.languagesHelper.getSelectedLocale());
            Intrinsics.checkNotNullExpressionValue(upperCase3, "this as java.lang.String).toUpperCase(locale)");
            return upperCase3;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        String upperCase4 = v().toUpperCase(this.languagesHelper.getSelectedLocale());
        Intrinsics.checkNotNullExpressionValue(upperCase4, "this as java.lang.String).toUpperCase(locale)");
        return upperCase4;
    }

    public final Bitmap b(int size) {
        String strM;
        Vendor vendor = (Vendor) getSelectedVendor().getValue();
        if (vendor == null || (strM = m(vendor)) == null) {
            return null;
        }
        return ta.a.a(strM, size);
    }

    private final SpannedString b(Collection<DataProcessingDisplay> collection) {
        return y.a(collection, "\n", null, null, 0, null, new c(n7.a(this.languagesHelper, "retention_time", null, null, null, 14, null)), 30, null);
    }

    public final Bitmap c(int size) {
        String strS;
        Vendor vendor = (Vendor) getSelectedVendor().getValue();
        if (vendor == null || (strS = s(vendor)) == null) {
            return null;
        }
        return ta.a.a(strS, size);
    }

    public final void c(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.selectedDataCategory = this.vendorRepository.a(id);
    }

    public final Bitmap a(int size) {
        return ta.a.a(C(), size);
    }

    private final List<bf.Description> a(Collection<? extends m1> collection) {
        List<m1> listSortedWith = CollectionsKt.sortedWith(collection, new b());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSortedWith, 10));
        for (m1 m1Var : listSortedWith) {
            arrayList.add(new bf.Description(m1Var.getName(), m1Var.getDescriptionLegal(), 0, 4, null));
        }
        return arrayList;
    }
}
