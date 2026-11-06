package io.didomi.ssl;

import com.revenuecat.purchases.strings.OfferingStrings;
import io.didomi.ssl.apiEvents.a;
import io.didomi.ssl.events.PreferencesClickAgreeToAllPurposesEvent;
import io.didomi.ssl.events.PreferencesClickDisagreeToAllPurposesEvent;
import io.didomi.ssl.events.PreferencesClickViewPurposesEvent;
import io.didomi.ssl.exceptions.DidomiNotReadyException;
import io.didomi.ssl.purpose.common.model.PurposeCategory;
import io.didomi.ssl.view.mobile.DidomiToggle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 z2\u00020\u0001:\u0001\u0016Bi\b\u0007\u0012\u0006\u0010a\u001a\u00020`\u0012\u0006\u0010c\u001a\u00020b\u0012\u0006\u0010e\u001a\u00020d\u0012\u0006\u0010g\u001a\u00020f\u0012\u0006\u0010i\u001a\u00020h\u0012\u0006\u0010k\u001a\u00020j\u0012\u0006\u0010m\u001a\u00020l\u0012\u0006\u0010o\u001a\u00020n\u0012\u0006\u0010q\u001a\u00020p\u0012\u0006\u0010s\u001a\u00020r\u0012\u0006\u0010u\u001a\u00020t\u0012\u0006\u0010w\u001a\u00020v¢\u0006\u0004\bx\u0010yJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J\b\u0010\u000f\u001a\u00020\tH\u0002J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0002J\u0016\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0002J\u000e\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0002J\u000e\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0002J\u0017\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010\u001b\u001a\u00020\tJ$\u0010\u0016\u001a\u00020\t2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u001c2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0014J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u001eH\u0016J\u0006\u0010\"\u001a\u00020\u0002J\u0006\u0010#\u001a\u00020\u0002J\b\u0010$\u001a\u00020\tH\u0016J\b\u0010%\u001a\u00020\tH\u0014J\b\u0010&\u001a\u00020\tH\u0014R\"\u0010-\u001a\u00020'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b\u0012\u0010,R\"\u00100\u001a\u00020'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010)\u001a\u0004\b/\u0010+\"\u0004\b\b\u0010,R\u0014\u00103\u001a\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0011\u00106\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b4\u00105R\u0014\u00108\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b7\u00105R\u0014\u0010:\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b9\u00105R\u0014\u0010<\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b;\u00105R\u0014\u0010>\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b=\u00105R\u0014\u0010@\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b?\u00105R\u0014\u0010B\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bA\u00105R\u0014\u0010D\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bC\u00105R\u0014\u0010F\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bE\u00105R\u0014\u0010H\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bG\u00105R\u0014\u0010J\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bI\u00105R\u0014\u0010L\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bK\u00105R\u0014\u0010N\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bM\u00105R\u0014\u0010P\u001a\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bO\u00102R\u001a\u0010T\u001a\b\u0012\u0004\u0012\u00020Q0\u001e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bR\u0010SR\u0014\u0010V\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bU\u00105R\u0017\u0010Y\u001a\b\u0012\u0004\u0012\u00020W0\u001c8F¢\u0006\u0006\u001a\u0004\bX\u0010SR\u0011\u0010]\u001a\u00020Z8F¢\u0006\u0006\u001a\u0004\b[\u0010\\R\u0017\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00100\u001e8F¢\u0006\u0006\u001a\u0004\b^\u0010S¨\u0006{"}, d2 = {"Lio/didomi/sdk/qe;", "Lio/didomi/sdk/ra;", "", "checked", "", "h", "Lio/didomi/sdk/Purpose;", "purpose", "c", "", "B1", "y1", "z1", "w1", "A1", "x1", "Lio/didomi/sdk/pd$g;", "y", "b", "d", "e", "isChecked", "a", "f", "g", "z", "(Lio/didomi/sdk/Purpose;)Z", "Y1", "", Didomi.VIEW_PURPOSES, "", "Lio/didomi/sdk/purpose/common/model/PurposeCategory;", "categories", "O0", "W1", "X1", "v1", "o1", "p1", "", "O", "I", "F1", "()I", "(I)V", "currentDataProcessingIndex", "P", "H1", "focusedPosition", "V1", "()Z", "selectedPurposeHasVendorsCountInfo", "G1", "()Ljava/lang/String;", "dataUsageInfoLabel", "T1", "quickActionTitleLabel", "S1", "quickActionTextLabel", "O1", "purposeOnLabel", "N1", "purposeOffLabel", "R1", "purposesSectionTitleLabel", "X", "essentialPurposeText", "Q1", "purposeSettingsLabel", "P1", "purposeReadMoreLabel", "K1", "purposeLegIntLabel", "L1", "purposeLegalDescriptionLabel", "C1", "additionalDataProcessingDescriptionLabel", "D1", "additionalDataProcessingSectionLabel", "U1", "selectedPurposeHasAdditionalInfo", "Lio/didomi/sdk/gd;", "E1", "()Ljava/util/List;", "additionalInfoList", "b0", "illustrationsHeaderLabel", "Lio/didomi/sdk/pd;", "M1", "purposeList", "Lio/didomi/sdk/pd$c;", "I1", "()Lio/didomi/sdk/pd$c;", "purposeBulk", "J1", "purposeItemList", "Lio/didomi/sdk/apiEvents/a;", "apiEventsRepository", "Lio/didomi/sdk/e0;", "configurationRepository", "Lio/didomi/sdk/r0;", "consentRepository", "Lio/didomi/sdk/v0;", "contextHelper", "Lio/didomi/sdk/b6;", "eventsRepository", "Lio/didomi/sdk/n7;", "languagesHelper", "Lio/didomi/sdk/jh;", "userChoicesInfoProvider", "Lio/didomi/sdk/sh;", "userStatusRepository", "Lio/didomi/sdk/eh;", "uiProvider", "Lio/didomi/sdk/zh;", "vendorRepository", "Lio/didomi/sdk/u7;", "logoProvider", "Lio/didomi/sdk/a8;", "navigationManager", "<init>", "(Lio/didomi/sdk/apiEvents/a;Lio/didomi/sdk/e0;Lio/didomi/sdk/r0;Lio/didomi/sdk/v0;Lio/didomi/sdk/b6;Lio/didomi/sdk/n7;Lio/didomi/sdk/jh;Lio/didomi/sdk/sh;Lio/didomi/sdk/eh;Lio/didomi/sdk/zh;Lio/didomi/sdk/u7;Lio/didomi/sdk/a8;)V", "Q", "android_release"}, k = 1, mv = {1, 8, 0})
public final class qe extends ra {

    /* JADX INFO: renamed from: O, reason: from kotlin metadata */
    private int currentDataProcessingIndex;

    /* JADX INFO: renamed from: P, reason: from kotlin metadata */
    private int focusedPosition;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qe(a apiEventsRepository, e0 configurationRepository, r0 consentRepository, v0 contextHelper, b6 eventsRepository, n7 languagesHelper, jh userChoicesInfoProvider, sh userStatusRepository, eh uiProvider, zh vendorRepository, u7 logoProvider, a8 navigationManager) {
        super(apiEventsRepository, configurationRepository, consentRepository, contextHelper, eventsRepository, languagesHelper, userChoicesInfoProvider, userStatusRepository, uiProvider, vendorRepository, logoProvider, navigationManager);
        Intrinsics.checkNotNullParameter(apiEventsRepository, "apiEventsRepository");
        Intrinsics.checkNotNullParameter(configurationRepository, "configurationRepository");
        Intrinsics.checkNotNullParameter(consentRepository, "consentRepository");
        Intrinsics.checkNotNullParameter(contextHelper, "contextHelper");
        Intrinsics.checkNotNullParameter(eventsRepository, "eventsRepository");
        Intrinsics.checkNotNullParameter(languagesHelper, "languagesHelper");
        Intrinsics.checkNotNullParameter(userChoicesInfoProvider, "userChoicesInfoProvider");
        Intrinsics.checkNotNullParameter(userStatusRepository, "userStatusRepository");
        Intrinsics.checkNotNullParameter(uiProvider, "uiProvider");
        Intrinsics.checkNotNullParameter(vendorRepository, "vendorRepository");
        Intrinsics.checkNotNullParameter(logoProvider, "logoProvider");
        Intrinsics.checkNotNullParameter(navigationManager, "navigationManager");
        this.currentDataProcessingIndex = -1;
    }

    private final void A1() {
        getUserChoicesInfoProvider().l(CollectionsKt.toMutableSet(m0()));
        getUserChoicesInfoProvider().h(new LinkedHashSet());
    }

    private final void B1() {
        try {
            l();
            a(new PreferencesClickAgreeToAllPurposesEvent());
        } catch (DidomiNotReadyException e) {
            e.printStackTrace();
        }
    }

    private final boolean V1() {
        if (U0()) {
            return m1() || n1();
        }
        return false;
    }

    private final String h(boolean checked) {
        return checked ? n7.a(getLanguagesHelper(), "object_to_legitimate_interest_status_on", (gc) null, (Map) null, 6, (Object) null) : n7.a(getLanguagesHelper(), "object_to_legitimate_interest_status_off", (gc) null, (Map) null, 6, (Object) null);
    }

    private final void w1() {
        getUserChoicesInfoProvider().j(new LinkedHashSet());
        getUserChoicesInfoProvider().f(CollectionsKt.toMutableSet(l0()));
    }

    private final void x1() {
        getUserChoicesInfoProvider().l(new LinkedHashSet());
        getUserChoicesInfoProvider().h(CollectionsKt.toMutableSet(m0()));
    }

    private final void y1() {
        try {
            g();
            a(new PreferencesClickDisagreeToAllPurposesEvent());
        } catch (DidomiNotReadyException e) {
            e.printStackTrace();
        }
    }

    private final void z1() {
        getUserChoicesInfoProvider().j(CollectionsKt.toMutableSet(l0()));
        getUserChoicesInfoProvider().f(new LinkedHashSet());
    }

    public final String C1() {
        return n7.a(getLanguagesHelper(), "list_of_additional_data_processing_on_purposes", null, null, null, 14, null);
    }

    public final String D1() {
        return n7.a(getLanguagesHelper(), "additional_data_processing", gc.UPPER_CASE, null, null, 12, null);
    }

    public final List<gd> E1() {
        String strN;
        String strM;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new gd.Header(0, 1, null));
        Purpose purpose = (Purpose) getSelectedPurpose().getValue();
        if (purpose != null) {
            Intrinsics.checkNotNullExpressionValue(purpose, "purpose");
            arrayList.add(new gd.Title(k(purpose), 0, 2, null));
            String strH0 = h0();
            if (StringsKt.isBlank(strH0)) {
                strH0 = null;
            }
            if (strH0 != null) {
                arrayList.add(new gd.Subtitle(L1(), 0, 2, null));
                arrayList.add(new gd.AdditionalDescription(strH0, 0, 2, null));
            }
            List<String> listA0 = a0();
            if (listA0.isEmpty()) {
                listA0 = null;
            }
            if (listA0 != null) {
                arrayList.add(new gd.Subtitle(b0(), 0, 2, null));
                int i = 0;
                for (Object obj : listA0) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    String str = (String) obj;
                    if (i < StringsKt.getLastIndex(str)) {
                        str = str + '\n';
                    }
                    arrayList.add(new gd.AdditionalDescription(str, 0, 2, null));
                    i = i2;
                }
            }
            if (m1() && (strM = m(purpose)) != null) {
                arrayList.add(new gd.VendorsCount(n7.a(getLanguagesHelper(), AuthorizationRequest.Prompt.CONSENT, gc.UPPER_CASE, (Map) null, 4, (Object) null), strM, gi.PurposeConsent, 0, 8, null));
            }
            if (n1() && (strN = n(purpose)) != null) {
                arrayList.add(new gd.VendorsCount(n7.a(getLanguagesHelper(), "legitimate_interest", gc.UPPER_CASE, (Map) null, 4, (Object) null), strN, gi.PurposeLI, 0, 8, null));
            }
            arrayList.add(new gd.Footer(0, 1, null));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: F1, reason: from getter */
    public final int getCurrentDataProcessingIndex() {
        return this.currentDataProcessingIndex;
    }

    public final String G1() {
        return getLanguagesHelper().a(getConfigurationRepository().b().getPreferences().getContent().f(), "view_all_purposes", gc.UPPER_CASE);
    }

    /* JADX INFO: renamed from: H1, reason: from getter */
    public final int getFocusedPosition() {
        return this.focusedPosition;
    }

    public final pd.Bulk I1() {
        boolean zB = b();
        return new pd.Bulk(S1(), zB ? O1() : N1(), zB, 0, 8, null);
    }

    public final List<pd.Purpose> J1() {
        List<Purpose> listJ1 = j1();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listJ1, 10));
        Iterator<T> it = listJ1.iterator();
        while (it.hasNext()) {
            arrayList.add(y((Purpose) it.next()));
        }
        return arrayList;
    }

    public final String K1() {
        return n7.a(getLanguagesHelper(), "object_to_legitimate_interest", (gc) null, (Map) null, 6, (Object) null);
    }

    public final String L1() {
        return n7.a(getLanguagesHelper(), "purpose_legal_description", gc.UPPER_CASE, (Map) null, 4, (Object) null);
    }

    public final List<pd> M1() {
        int size;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new pd.Header(0, 1, null));
        arrayList.add(new pd.Title(G1(), 0, 2, null));
        String string = fc.j(i0()).toString();
        if (!StringsKt.isBlank(string)) {
            arrayList.add(new pd.Description(string, 0, 2, null));
        }
        List<pd.Purpose> listJ1 = J1();
        if (getHasNonEssentialPurposes() && f0.c(getConfigurationRepository())) {
            arrayList.add(new pd.Section(T1(), 0, 2, null));
            size = arrayList.size();
            arrayList.add(I1());
        } else {
            size = listJ1.isEmpty() ? 0 : arrayList.size() + 1;
        }
        arrayList.add(new pd.Section(R1(), 0, 2, null));
        arrayList.addAll(listJ1);
        if (r1()) {
            arrayList.add(new pd.AdditionalDataProcessingHeader(C1(), 0, 2, null));
            arrayList.add(new pd.Section(D1(), 0, 2, null));
            List<m1> listC0 = C0();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listC0, 10));
            int i = 0;
            for (Object obj : listC0) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                m1 m1Var = (m1) obj;
                arrayList2.add(new pd.AdditionalDataProcessingItem(StringsKt.trim(m1Var.getName()).toString(), i, m1Var, 0, 8, null));
                i = i2;
            }
            arrayList.addAll(arrayList2);
        }
        arrayList.add(new pd.Footer(0, 1, null));
        if (this.focusedPosition == 0 && size >= 0) {
            this.focusedPosition = size;
        }
        return arrayList;
    }

    public final String N1() {
        return n7.a(getLanguagesHelper(), "purposes_off", (gc) null, (Map) null, 6, (Object) null);
    }

    @Override // io.didomi.ssl.ra
    public List<Purpose> O0() {
        b(ai.c(getVendorRepository()));
        return j1();
    }

    public final String O1() {
        return n7.a(getLanguagesHelper(), "purposes_on", (gc) null, (Map) null, 6, (Object) null);
    }

    public final String P1() {
        return n7.a(getLanguagesHelper(), "read_more", (gc) null, (Map) null, 6, (Object) null);
    }

    public final String Q1() {
        return n7.a(getLanguagesHelper(), "settings", gc.UPPER_CASE, (Map) null, 4, (Object) null);
    }

    public final String R1() {
        return n7.a(getLanguagesHelper(), "section_title_on_purposes", gc.UPPER_CASE, (Map) null, 4, (Object) null);
    }

    public final String S1() {
        return n7.a(getLanguagesHelper(), getConfigurationRepository().b().getPreferences().getContent().b(), "bulk_action_on_purposes", (gc) null, 4, (Object) null);
    }

    public final String T1() {
        return n7.a(getLanguagesHelper(), "bulk_action_section_title", gc.UPPER_CASE, (Map) null, 4, (Object) null);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002e  */
    public final boolean U1() {
        boolean z;
        Purpose purpose = (Purpose) getSelectedPurpose().getValue();
        if (purpose == null) {
            z = false;
        } else {
            String descriptionLegal = purpose.getDescriptionLegal();
            if (!(descriptionLegal != null ? !StringsKt.isBlank(descriptionLegal) : false)) {
                List<String> illustrations = purpose.getIllustrations();
                if (!(illustrations != null ? !illustrations.isEmpty() : false)) {
                    z = false;
                }
            }
            z = true;
        }
        return z || V1();
    }

    public final boolean W1() {
        if (this.currentDataProcessingIndex >= C0().size() - 1) {
            return false;
        }
        this.focusedPosition++;
        this.currentDataProcessingIndex++;
        return true;
    }

    @Override // io.didomi.ssl.ra
    public String X() {
        return n7.a(getLanguagesHelper(), "essential_purpose_label", null, null, null, 14, null);
    }

    public final boolean X1() {
        int i = this.currentDataProcessingIndex;
        if (i <= 0) {
            return false;
        }
        this.currentDataProcessingIndex = i - 1;
        this.focusedPosition--;
        return true;
    }

    public final void Y1() {
        a(new PreferencesClickViewPurposesEvent());
    }

    public final void a(Purpose purpose, boolean isChecked) {
        Intrinsics.checkNotNullParameter(purpose, "purpose");
        if (isChecked) {
            s(purpose);
        } else {
            r(purpose);
        }
        f1();
    }

    public final void b(int i) {
        this.currentDataProcessingIndex = i;
    }

    @Override // io.didomi.ssl.ra
    public String b0() {
        return n7.a(getLanguagesHelper(), "purpose_illustration_explanation", gc.UPPER_CASE, null, null, 12, null);
    }

    public final void c(int i) {
        this.focusedPosition = i;
    }

    public final String d(Purpose purpose, boolean checked) {
        Intrinsics.checkNotNullParameter(purpose, "purpose");
        String strM = m(purpose);
        if (strM == null) {
            return c(purpose, checked);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(OfferingStrings.LIST_PRODUCTS, Arrays.copyOf(new Object[]{c(purpose, checked), strM}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        return str;
    }

    public final String e(Purpose purpose, boolean checked) {
        Intrinsics.checkNotNullParameter(purpose, "purpose");
        String strN = n(purpose);
        if (strN == null) {
            return h(checked);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(OfferingStrings.LIST_PRODUCTS, Arrays.copyOf(new Object[]{h(checked), strN}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        return str;
    }

    public final void f(boolean isChecked) {
        Purpose purpose = (Purpose) getSelectedPurpose().getValue();
        if (purpose == null) {
            return;
        }
        if (isChecked) {
            e(purpose);
            b(DidomiToggle.b.ENABLED);
        } else {
            b(purpose);
            b(DidomiToggle.b.DISABLED);
        }
        f1();
    }

    public final void g(boolean isChecked) {
        Purpose purpose = (Purpose) getSelectedPurpose().getValue();
        if (purpose == null) {
            return;
        }
        if (isChecked) {
            a(purpose);
            c(DidomiToggle.b.DISABLED);
        } else {
            d(purpose);
            c(DidomiToggle.b.ENABLED);
        }
        f1();
    }

    @Override // io.didomi.ssl.ra
    protected void o1() {
        z1();
        A1();
        k();
        m();
    }

    @Override // io.didomi.ssl.ra
    protected void p1() {
        w1();
        f();
        if (getConfigurationRepository().b().getPreferences().getDenyAppliesToLI()) {
            h();
            x1();
        } else {
            m();
            A1();
        }
    }

    @Override // io.didomi.ssl.ra
    public void v1() {
        getUserChoicesInfoProvider().a(I());
        getUserChoicesInfoProvider().c(k0());
        j();
        n();
        l1();
    }

    public final pd.Purpose y(Purpose purpose) {
        Intrinsics.checkNotNullParameter(purpose, "purpose");
        boolean z = z(purpose);
        return new pd.Purpose(purpose, k(purpose), b(purpose, z), z, 0, 16, null);
    }

    public final boolean z(Purpose purpose) {
        Intrinsics.checkNotNullParameter(purpose, "purpose");
        if (ca.a(U(), purpose) || !v(purpose)) {
            return true;
        }
        if (ca.a(N(), purpose)) {
            return false;
        }
        v(purpose);
        return false;
    }

    private final String c(Purpose purpose, boolean checked) {
        if (purpose.isEssential()) {
            return X();
        }
        return checked ? n7.a(getLanguagesHelper(), "consent_on", (gc) null, (Map) null, 6, (Object) null) : n7.a(getLanguagesHelper(), "consent_off", (gc) null, (Map) null, 6, (Object) null);
    }

    public final String b(Purpose purpose, boolean checked) {
        Intrinsics.checkNotNullParameter(purpose, "purpose");
        if (purpose.isEssential()) {
            return X();
        }
        return checked ? n7.a(getLanguagesHelper(), "consent_on", (gc) null, (Map) null, 6, (Object) null) : n7.a(getLanguagesHelper(), "consent_off", (gc) null, (Map) null, 6, (Object) null);
    }

    @Override // io.didomi.ssl.ra
    protected void a(List<Purpose> purposes, List<PurposeCategory> categories) {
        Intrinsics.checkNotNullParameter(purposes, "purposes");
        Intrinsics.checkNotNullParameter(categories, "categories");
        Collections.sort(purposes, new h9(categories));
    }

    public final void e(boolean isChecked) {
        if (isChecked) {
            B1();
        } else {
            y1();
        }
        f1();
    }
}
