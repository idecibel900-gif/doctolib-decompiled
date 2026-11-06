package com.revenuecat.purchases.ui.revenuecatui.customercenter.data;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001f\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/FeedbackSurveyData;", "", "feedbackSurvey", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey;", "onAnswerSubmitted", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$Option;", "", "(Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey;Lkotlin/jvm/functions/Function1;)V", "getFeedbackSurvey", "()Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey;", "getOnAnswerSubmitted", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class FeedbackSurveyData {
    public static final int $stable = 8;
    private final CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey feedbackSurvey;
    private final Function1 onAnswerSubmitted;

    public static /* synthetic */ FeedbackSurveyData copy$default(FeedbackSurveyData feedbackSurveyData, CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey feedbackSurvey, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            feedbackSurvey = feedbackSurveyData.feedbackSurvey;
        }
        if ((i & 2) != 0) {
            function1 = feedbackSurveyData.onAnswerSubmitted;
        }
        return feedbackSurveyData.copy(feedbackSurvey, function1);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey getFeedbackSurvey() {
        return this.feedbackSurvey;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Function1 getOnAnswerSubmitted() {
        return this.onAnswerSubmitted;
    }

    public final FeedbackSurveyData copy(CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey feedbackSurvey, Function1 onAnswerSubmitted) {
        Intrinsics.checkNotNullParameter(feedbackSurvey, "feedbackSurvey");
        Intrinsics.checkNotNullParameter(onAnswerSubmitted, "onAnswerSubmitted");
        return new FeedbackSurveyData(feedbackSurvey, onAnswerSubmitted);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeedbackSurveyData)) {
            return false;
        }
        FeedbackSurveyData feedbackSurveyData = (FeedbackSurveyData) other;
        return Intrinsics.areEqual(this.feedbackSurvey, feedbackSurveyData.feedbackSurvey) && Intrinsics.areEqual(this.onAnswerSubmitted, feedbackSurveyData.onAnswerSubmitted);
    }

    public int hashCode() {
        return (this.feedbackSurvey.hashCode() * 31) + this.onAnswerSubmitted.hashCode();
    }

    public String toString() {
        return "FeedbackSurveyData(feedbackSurvey=" + this.feedbackSurvey + ", onAnswerSubmitted=" + this.onAnswerSubmitted + ')';
    }

    public FeedbackSurveyData(CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey feedbackSurvey, Function1 onAnswerSubmitted) {
        Intrinsics.checkNotNullParameter(feedbackSurvey, "feedbackSurvey");
        Intrinsics.checkNotNullParameter(onAnswerSubmitted, "onAnswerSubmitted");
        this.feedbackSurvey = feedbackSurvey;
        this.onAnswerSubmitted = onAnswerSubmitted;
    }

    public final /* synthetic */ CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey getFeedbackSurvey() {
        return this.feedbackSurvey;
    }

    public final /* synthetic */ Function1 getOnAnswerSubmitted() {
        return this.onAnswerSubmitted;
    }
}
