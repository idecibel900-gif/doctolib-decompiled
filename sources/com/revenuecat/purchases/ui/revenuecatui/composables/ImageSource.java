package com.revenuecat.purchases.ui.revenuecatui.composables;

import com.google.firebase.messaging.Constants;
import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b3\u0018\u00002\u00020\u0001:\u0002\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/composables/ImageSource;", "", "()V", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "getData", "()Ljava/lang/Object;", "Local", "Remote", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/ImageSource$Local;", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/ImageSource$Remote;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
abstract class ImageSource {
    public /* synthetic */ ImageSource(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract Object getData();

    private ImageSource() {
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/composables/ImageSource$Local;", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/ImageSource;", "resource", "", "(I)V", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "", "getData", "()Ljava/lang/Object;", "getResource", "()I", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Local extends ImageSource {
        public static final int $stable = 0;
        private final Object data;
        private final int resource;

        public static /* synthetic */ Local copy$default(Local local, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = local.resource;
            }
            return local.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getResource() {
            return this.resource;
        }

        public final Local copy(int resource) {
            return new Local(resource);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Local) && this.resource == ((Local) other).resource;
        }

        public int hashCode() {
            return Integer.hashCode(this.resource);
        }

        public String toString() {
            return "Local(resource=" + this.resource + ')';
        }

        public Local(int i) {
            super(null);
            this.resource = i;
            this.data = Integer.valueOf(i);
        }

        public final int getResource() {
            return this.resource;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.composables.ImageSource
        public Object getData() {
            return this.data;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/composables/ImageSource$Remote;", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/ImageSource;", "urlString", "", "(Ljava/lang/String;)V", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "", "getData", "()Ljava/lang/Object;", "getUrlString", "()Ljava/lang/String;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Remote extends ImageSource {
        public static final int $stable = 0;
        private final Object data;
        private final String urlString;

        public static /* synthetic */ Remote copy$default(Remote remote, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = remote.urlString;
            }
            return remote.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrlString() {
            return this.urlString;
        }

        public final Remote copy(String urlString) {
            Intrinsics.checkNotNullParameter(urlString, "urlString");
            return new Remote(urlString);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Remote) && Intrinsics.areEqual(this.urlString, ((Remote) other).urlString);
        }

        public int hashCode() {
            return this.urlString.hashCode();
        }

        public String toString() {
            return "Remote(urlString=" + this.urlString + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Remote(String urlString) {
            super(null);
            Intrinsics.checkNotNullParameter(urlString, "urlString");
            this.urlString = urlString;
            this.data = urlString;
        }

        public final String getUrlString() {
            return this.urlString;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.composables.ImageSource
        public Object getData() {
            return this.data;
        }
    }
}
