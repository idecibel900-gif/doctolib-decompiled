package expo.modules.constants;

import android.content.Context;
import android.os.Build;
import com.adjust.sdk.Constants;
import expo.modules.interfaces.constants.ConstantsInterface;
import expo.modules.kotlin.services.ServiceInterface;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes4.dex */
@ServiceInterface(clazz = ConstantsInterface.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0006\b\u0017\u0018\u0000 !2\u00020\u0001:\u0002\"!B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0012R\u0014\u0010\u001c\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0012R\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lexpo/modules/constants/ConstantsService;", "Lexpo/modules/interfaces/constants/ConstantsInterface;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/content/Context;", "", "statusBarHeightInternal", "I", "getStatusBarHeightInternal", "()I", "setStatusBarHeightInternal", "(I)V", "", "sessionId", "Ljava/lang/String;", "getAppConfig", "()Ljava/lang/String;", "appConfig", "", "", "getConstants", "()Ljava/util/Map;", "constants", "getDeviceName", "deviceName", "getSystemVersion", "systemVersion", "", "getSystemFonts", "()Ljava/util/List;", "systemFonts", "Companion", "ExecutionEnvironment", "expo-constants_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ConstantsService implements ConstantsInterface {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Context context;
    private final String sessionId;
    private int statusBarHeightInternal;

    public ConstantsService(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        Integer numValueOf = Integer.valueOf(context.getResources().getIdentifier("status_bar_height", "dimen", "android"));
        numValueOf = numValueOf.intValue() <= 0 ? null : numValueOf;
        this.statusBarHeightInternal = numValueOf != null ? INSTANCE.convertPixelsToDp(context.getResources().getDimensionPixelSize(numValueOf.intValue()), context) : 0;
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        this.sessionId = string;
    }

    public enum ExecutionEnvironment {
        BARE("bare"),
        STANDALONE("standalone"),
        STORE_CLIENT("storeClient");

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        private final String string;

        ExecutionEnvironment(String str) {
            this.string = str;
        }

        public final String getString() {
            return this.string;
        }
    }

    @Override // expo.modules.interfaces.constants.ConstantsInterface
    public Map getConstants() {
        return MapsKt.mapOf(TuplesKt.to("sessionId", this.sessionId), TuplesKt.to("executionEnvironment", ExecutionEnvironment.BARE.getString()), TuplesKt.to("statusBarHeight", Integer.valueOf(this.statusBarHeightInternal)), TuplesKt.to("deviceName", getDeviceName()), TuplesKt.to("systemFonts", getSystemFonts()), TuplesKt.to("systemVersion", getSystemVersion()), TuplesKt.to("manifest", getAppConfig()), TuplesKt.to("platform", MapsKt.mapOf(TuplesKt.to("android", MapsKt.emptyMap()))));
    }

    public String getDeviceName() {
        String MODEL = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        return MODEL;
    }

    public String getSystemVersion() {
        String RELEASE = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
        return RELEASE;
    }

    public List getSystemFonts() {
        return CollectionsKt.listOf((Object[]) new String[]{Constants.NORMAL, "notoserif", "sans-serif", "sans-serif-light", "sans-serif-thin", "sans-serif-condensed", "sans-serif-medium", "serif", "Roboto", "monospace"});
    }

    private final String getAppConfig() {
        try {
            InputStream inputStreamOpen = this.context.getAssets().open("app.config");
            try {
                Intrinsics.checkNotNull(inputStreamOpen);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, Charsets.UTF_8), 8192);
                try {
                    String text = TextStreamsKt.readText(bufferedReader);
                    CloseableKt.closeFinally(bufferedReader, null);
                    CloseableKt.closeFinally(inputStreamOpen, null);
                    return text;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(bufferedReader, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(inputStreamOpen, th3);
                    throw th4;
                }
            }
        } catch (FileNotFoundException unused) {
            return null;
        } catch (Exception unused2) {
            String unused3 = ConstantsServiceKt.TAG;
            return null;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int convertPixelsToDp(float f, Context context) {
            return (int) (f / (context.getResources().getDisplayMetrics().densityDpi / 160.0f));
        }
    }
}
