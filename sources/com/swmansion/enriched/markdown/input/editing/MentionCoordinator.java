package com.swmansion.enriched.markdown.input.editing;

import com.swmansion.enriched.markdown.input.detection.WordsUtils;
import com.swmansion.enriched.markdown.input.formatting.FormattingStore;
import com.swmansion.enriched.markdown.input.model.StyleType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class MentionCoordinator {
    private int activeEnd;
    private String activeIndicator;
    private int activeStart;
    private String activeText;
    private final FormattingStore formattingStore;
    private LinkedHashSet indicators;

    public MentionCoordinator(FormattingStore formattingStore) {
        Intrinsics.checkNotNullParameter(formattingStore, "formattingStore");
        this.formattingStore = formattingStore;
        this.indicators = new LinkedHashSet();
        this.activeStart = -1;
        this.activeEnd = -1;
        this.activeText = "";
    }

    public final String getCurrentIndicator() {
        return this.activeIndicator;
    }

    public final int getCurrentStart() {
        return this.activeStart;
    }

    public final int getCurrentEnd() {
        return this.activeEnd;
    }

    public final boolean containsIndicator(String indicator) {
        Intrinsics.checkNotNullParameter(indicator, "indicator");
        return this.indicators.contains(indicator);
    }

    public final List setIndicators(List newIndicators) {
        Intrinsics.checkNotNullParameter(newIndicators, "newIndicators");
        LinkedHashSet linkedHashSet = new LinkedHashSet(newIndicators);
        if (Intrinsics.areEqual(linkedHashSet, this.indicators)) {
            return CollectionsKt.emptyList();
        }
        this.indicators = linkedHashSet;
        ArrayList arrayList = new ArrayList();
        String str = this.activeIndicator;
        if (str != null && !this.indicators.contains(str)) {
            arrayList.addAll(clear$default(this, false, str, 1, null));
        }
        return arrayList;
    }

    public final List update(String str, int i, int i2) {
        if (str == null || i != i2 || i < 0 || i > str.length()) {
            return clear$default(this, false, null, 3, null);
        }
        MentionCandidate mentionCandidateDetectCandidate = detectCandidate(str, i);
        if (mentionCandidateDetectCandidate == null) {
            return clear$default(this, false, null, 3, null);
        }
        ArrayList arrayList = new ArrayList();
        if (!Intrinsics.areEqual(this.activeIndicator, mentionCandidateDetectCandidate.getIndicator()) || this.activeStart != mentionCandidateDetectCandidate.getStart()) {
            String str2 = this.activeIndicator;
            if (str2 != null) {
                arrayList.add(new MentionEvent.End(str2));
            }
            this.activeIndicator = mentionCandidateDetectCandidate.getIndicator();
            this.activeStart = mentionCandidateDetectCandidate.getStart();
            arrayList.add(new MentionEvent.Start(mentionCandidateDetectCandidate.getIndicator()));
        }
        this.activeEnd = mentionCandidateDetectCandidate.getEnd();
        if (!Intrinsics.areEqual(this.activeText, mentionCandidateDetectCandidate.getText())) {
            this.activeText = mentionCandidateDetectCandidate.getText();
            arrayList.add(new MentionEvent.Change(mentionCandidateDetectCandidate.getIndicator(), mentionCandidateDetectCandidate.getText()));
        }
        return arrayList;
    }

    public static /* synthetic */ List clear$default(MentionCoordinator mentionCoordinator, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return mentionCoordinator.clear(z, str);
    }

    public final List clear(boolean z, String str) {
        if (str == null) {
            str = this.activeIndicator;
        }
        this.activeIndicator = null;
        this.activeStart = -1;
        this.activeEnd = -1;
        this.activeText = "";
        return (!z || str == null) ? CollectionsKt.emptyList() : CollectionsKt.listOf(new MentionEvent.End(str));
    }

    private final MentionCandidate detectCandidate(String str, int i) {
        Object next;
        if (this.indicators.isEmpty()) {
            return null;
        }
        int i2 = WordsUtils.INSTANCE.tokenStart(str, i);
        String strSubstring = str.substring(i2, i);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        Iterator it = this.indicators.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!StringsKt.startsWith$default(strSubstring, (String) next, false, 2, (Object) null));
        String str2 = (String) next;
        if (str2 == null || this.formattingStore.rangeOfType(StyleType.LINK, i2) != null) {
            return null;
        }
        String strSubstring2 = strSubstring.substring(str2.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        return new MentionCandidate(str2, i2, i, strSubstring2);
    }

    private static final class MentionCandidate {
        private final int end;
        private final String indicator;
        private final int start;
        private final String text;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MentionCandidate)) {
                return false;
            }
            MentionCandidate mentionCandidate = (MentionCandidate) obj;
            return Intrinsics.areEqual(this.indicator, mentionCandidate.indicator) && this.start == mentionCandidate.start && this.end == mentionCandidate.end && Intrinsics.areEqual(this.text, mentionCandidate.text);
        }

        public int hashCode() {
            return (((((this.indicator.hashCode() * 31) + Integer.hashCode(this.start)) * 31) + Integer.hashCode(this.end)) * 31) + this.text.hashCode();
        }

        public String toString() {
            return "MentionCandidate(indicator=" + this.indicator + ", start=" + this.start + ", end=" + this.end + ", text=" + this.text + ")";
        }

        public MentionCandidate(String indicator, int i, int i2, String text) {
            Intrinsics.checkNotNullParameter(indicator, "indicator");
            Intrinsics.checkNotNullParameter(text, "text");
            this.indicator = indicator;
            this.start = i;
            this.end = i2;
            this.text = text;
        }

        public final String getIndicator() {
            return this.indicator;
        }

        public final int getStart() {
            return this.start;
        }

        public final int getEnd() {
            return this.end;
        }

        public final String getText() {
            return this.text;
        }
    }
}
