package expo.modules.video.records;

import androidx.media3.common.Format;
import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.io.Serializable;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0013\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bB=\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u000e\u001a\u0004\b\b\u0010\u0018R\u001c\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0018¨\u0006\u001c"}, d2 = {"Lexpo/modules/video/records/AudioTrack;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", DiagnosticsEntry.ID_KEY, "", "language", Constants.ScionAnalytics.PARAM_LABEL, "name", "isDefault", "", "autoSelect", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getId$annotations", "()V", "getId", "()Ljava/lang/String;", "getLanguage$annotations", "getLanguage", "getLabel$annotations", "getLabel", "getName$annotations", "getName", "isDefault$annotations", "()Z", "getAutoSelect$annotations", "getAutoSelect", "Companion", "expo-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioTrack implements Record, Serializable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean autoSelect;
    private final String id;
    private final boolean isDefault;
    private final String label;
    private final String language;
    private final String name;

    @Field
    public static /* synthetic */ void getAutoSelect$annotations() {
    }

    @Field
    public static /* synthetic */ void getId$annotations() {
    }

    @Field
    public static /* synthetic */ void getLabel$annotations() {
    }

    @Field
    public static /* synthetic */ void getLanguage$annotations() {
    }

    @Field
    public static /* synthetic */ void getName$annotations() {
    }

    @Field
    public static /* synthetic */ void isDefault$annotations() {
    }

    public AudioTrack(String id, String str, String str2, String str3, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
        this.language = str;
        this.label = str2;
        this.name = str3;
        this.isDefault = z;
        this.autoSelect = z2;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: isDefault, reason: from getter */
    public final boolean getIsDefault() {
        return this.isDefault;
    }

    public final boolean getAutoSelect() {
        return this.autoSelect;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AudioTrack fromFormat(Format format) {
            String str;
            String displayLanguage;
            if (format == null || (str = format.id) == null) {
                return null;
            }
            String str2 = format.language;
            if (str2 == null || (displayLanguage = new Locale(str2).getDisplayLanguage()) == null) {
                displayLanguage = "Unknown";
            }
            String str3 = displayLanguage;
            String str4 = format.label;
            int i = format.selectionFlags;
            boolean z = true;
            if ((i & 1) == 0) {
                z = false;
            }
            return new AudioTrack(str, str2, str3, str4, z, (i & 4) != 0);
        }
    }
}
