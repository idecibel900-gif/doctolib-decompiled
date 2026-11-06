package com.adjust.sdk.network;

import com.adjust.sdk.ActivityKind;
import com.adjust.sdk.AdjustFactory;
import com.adjust.sdk.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class UrlStrategy {
    private static final String BASE_URL_IO = "https://app.adjust.io";
    private static final String GDPR_URL_IO = "https://gdpr.adjust.io";
    private static final String PURCHASE_VERIFICATION_URL_IO = "https://ssrv.adjust.io";
    private static final String SUBSCRIPTION_URL_IO = "https://subscription.adjust.io";
    private final String baseUrlOverwrite;
    private final String gdprUrlOverwrite;
    private final String purchaseVerificationUrlOverwrite;
    private final String subscriptionUrlOverwrite;
    private final List<String> urlStrategyDomains;
    private final boolean useSubdomains;
    final List<String> baseUrlChoicesList = baseUrlChoices();
    final List<String> gdprUrlChoicesList = gdprUrlChoices();
    final List<String> subscriptionUrlChoicesList = subscriptionUrlChoices();
    final List<String> purchaseVerificationUrlChoicesList = purchaseVerificationUrlChoices();
    boolean wasLastAttemptSuccess = false;
    int choiceIndex = 0;
    int startingChoiceIndex = 0;
    boolean wasLastAttemptWithOverwrittenUrl = false;

    public UrlStrategy(String str, String str2, String str3, String str4, List<String> list, boolean z) {
        this.urlStrategyDomains = list;
        this.useSubdomains = z;
        this.baseUrlOverwrite = str;
        this.gdprUrlOverwrite = str2;
        this.subscriptionUrlOverwrite = str3;
        this.purchaseVerificationUrlOverwrite = str4;
    }

    private List<String> baseUrlChoices() {
        List<String> list = this.urlStrategyDomains;
        if (list == null || list.isEmpty()) {
            return Arrays.asList(Constants.BASE_URL, BASE_URL_IO);
        }
        if (this.useSubdomains) {
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = this.urlStrategyDomains.iterator();
            while (it.hasNext()) {
                arrayList.add("https://app." + it.next());
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it2 = this.urlStrategyDomains.iterator();
        while (it2.hasNext()) {
            arrayList2.add("https://" + it2.next());
        }
        return arrayList2;
    }

    private List<String> gdprUrlChoices() {
        List<String> list = this.urlStrategyDomains;
        if (list == null || list.isEmpty()) {
            return Arrays.asList(Constants.GDPR_URL, GDPR_URL_IO);
        }
        ArrayList arrayList = new ArrayList();
        boolean z = this.useSubdomains;
        List<String> list2 = this.urlStrategyDomains;
        if (z) {
            Iterator<String> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add("https://gdpr." + it.next());
            }
        } else {
            Iterator<String> it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList.add("https://" + it2.next());
            }
        }
        return arrayList;
    }

    private List<String> purchaseVerificationUrlChoices() {
        List<String> list = this.urlStrategyDomains;
        if (list == null || list.isEmpty()) {
            return Arrays.asList(Constants.PURCHASE_VERIFICATION_URL, PURCHASE_VERIFICATION_URL_IO);
        }
        ArrayList arrayList = new ArrayList();
        boolean z = this.useSubdomains;
        List<String> list2 = this.urlStrategyDomains;
        if (z) {
            Iterator<String> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add("https://ssrv." + it.next());
            }
        } else {
            Iterator<String> it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList.add("https://" + it2.next());
            }
        }
        return arrayList;
    }

    private List<String> subscriptionUrlChoices() {
        List<String> list = this.urlStrategyDomains;
        if (list == null || list.isEmpty()) {
            return Arrays.asList(Constants.SUBSCRIPTION_URL, SUBSCRIPTION_URL_IO);
        }
        ArrayList arrayList = new ArrayList();
        boolean z = this.useSubdomains;
        List<String> list2 = this.urlStrategyDomains;
        if (z) {
            Iterator<String> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add("https://subscription." + it.next());
            }
        } else {
            Iterator<String> it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList.add("https://" + it2.next());
            }
        }
        return arrayList;
    }

    public void resetAfterSuccess() {
        this.startingChoiceIndex = this.choiceIndex;
        this.wasLastAttemptSuccess = true;
    }

    public boolean shouldRetryAfterFailure(ActivityKind activityKind) {
        int size;
        this.wasLastAttemptSuccess = false;
        if (AdjustFactory.isAllowUrlStrategyFallback() && this.wasLastAttemptWithOverwrittenUrl) {
            return false;
        }
        if (activityKind == ActivityKind.GDPR) {
            size = this.gdprUrlChoicesList.size();
        } else if (activityKind == ActivityKind.SUBSCRIPTION) {
            size = this.subscriptionUrlChoicesList.size();
        } else {
            size = activityKind == ActivityKind.PURCHASE_VERIFICATION ? this.purchaseVerificationUrlChoicesList.size() : this.baseUrlChoicesList.size();
        }
        int i = (this.choiceIndex + 1) % size;
        this.choiceIndex = i;
        return i != this.startingChoiceIndex;
    }

    public String targetUrlByActivityKind(ActivityKind activityKind) {
        if (activityKind == ActivityKind.GDPR) {
            String str = this.gdprUrlOverwrite;
            if (str != null) {
                this.wasLastAttemptWithOverwrittenUrl = true;
                return str;
            }
            this.wasLastAttemptWithOverwrittenUrl = false;
            return this.gdprUrlChoicesList.get(this.choiceIndex);
        }
        if (activityKind == ActivityKind.SUBSCRIPTION) {
            String str2 = this.subscriptionUrlOverwrite;
            if (str2 != null) {
                this.wasLastAttemptWithOverwrittenUrl = true;
                return str2;
            }
            this.wasLastAttemptWithOverwrittenUrl = false;
            return this.subscriptionUrlChoicesList.get(this.choiceIndex);
        }
        if (activityKind == ActivityKind.PURCHASE_VERIFICATION) {
            String str3 = this.purchaseVerificationUrlOverwrite;
            if (str3 != null) {
                this.wasLastAttemptWithOverwrittenUrl = true;
                return str3;
            }
            this.wasLastAttemptWithOverwrittenUrl = false;
            return this.purchaseVerificationUrlChoicesList.get(this.choiceIndex);
        }
        String str4 = this.baseUrlOverwrite;
        if (str4 != null) {
            this.wasLastAttemptWithOverwrittenUrl = true;
            return str4;
        }
        this.wasLastAttemptWithOverwrittenUrl = false;
        return this.baseUrlChoicesList.get(this.choiceIndex);
    }
}
