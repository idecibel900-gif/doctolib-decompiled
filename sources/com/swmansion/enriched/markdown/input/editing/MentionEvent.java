package com.swmansion.enriched.markdown.input.editing;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MentionEvent {
    public /* synthetic */ MentionEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private MentionEvent() {
    }

    public static final class Start extends MentionEvent {
        private final String indicator;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Start) && Intrinsics.areEqual(this.indicator, ((Start) obj).indicator);
        }

        public int hashCode() {
            return this.indicator.hashCode();
        }

        public String toString() {
            return "Start(indicator=" + this.indicator + ")";
        }

        public final String getIndicator() {
            return this.indicator;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Start(String indicator) {
            super(null);
            Intrinsics.checkNotNullParameter(indicator, "indicator");
            this.indicator = indicator;
        }
    }

    public static final class Change extends MentionEvent {
        private final String indicator;
        private final String text;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Change)) {
                return false;
            }
            Change change = (Change) obj;
            return Intrinsics.areEqual(this.indicator, change.indicator) && Intrinsics.areEqual(this.text, change.text);
        }

        public int hashCode() {
            return (this.indicator.hashCode() * 31) + this.text.hashCode();
        }

        public String toString() {
            return "Change(indicator=" + this.indicator + ", text=" + this.text + ")";
        }

        public final String getIndicator() {
            return this.indicator;
        }

        public final String getText() {
            return this.text;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Change(String indicator, String text) {
            super(null);
            Intrinsics.checkNotNullParameter(indicator, "indicator");
            Intrinsics.checkNotNullParameter(text, "text");
            this.indicator = indicator;
            this.text = text;
        }
    }

    public static final class End extends MentionEvent {
        private final String indicator;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof End) && Intrinsics.areEqual(this.indicator, ((End) obj).indicator);
        }

        public int hashCode() {
            return this.indicator.hashCode();
        }

        public String toString() {
            return "End(indicator=" + this.indicator + ")";
        }

        public final String getIndicator() {
            return this.indicator;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public End(String indicator) {
            super(null);
            Intrinsics.checkNotNullParameter(indicator, "indicator");
            this.indicator = indicator;
        }
    }
}
