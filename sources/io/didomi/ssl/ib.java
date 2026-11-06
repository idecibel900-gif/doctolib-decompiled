package io.didomi.ssl;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u0000 \u00182\u00020\u0001:\u0001\bB\u0011\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0012J\u0012\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0017J\b\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u001c\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\fH\u0016R\u0014\u0010\u000f\u001a\u00020\r8\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00108\u0012@\u0012X\u0092.¢\u0006\u0006\n\u0004\b\u0005\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0012@\u0012X\u0092\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lio/didomi/sdk/ib;", "", "", "language", "", "b", "", "resourceId", "a", "", "resourceName", "Landroid/graphics/Typeface;", "", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Landroid/content/res/Resources;", "Landroid/content/res/Resources;", "resources", "c", "Ljava/lang/String;", "currentLanguage", "<init>", "(Landroid/content/Context;)V", "d", "android_release"}, k = 1, mv = {1, 8, 0})
public class ib {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final Context context;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private Resources resources;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private String currentLanguage;

    public ib(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        b(this.currentLanguage);
    }

    public int a(int resourceId) {
        return ContextCompat.getColor(this.context, resourceId);
    }

    public boolean b() {
        Resources resources = this.resources;
        Resources resources2 = null;
        if (resources == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resources");
            resources = null;
        }
        boolean z = (resources.getConfiguration().screenLayout & 15) == 3;
        Resources resources3 = this.resources;
        if (resources3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resources");
        } else {
            resources2 = resources3;
        }
        return (resources2.getConfiguration().screenLayout & 15) == 4 || z;
    }

    public float a() {
        Resources resources = this.resources;
        if (resources == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resources");
            resources = null;
        }
        return resources.getDisplayMetrics().density;
    }

    private void b(String language) {
        Configuration configuration = new Configuration(this.context.getResources().getConfiguration());
        configuration.setLocale(s7.a.a(language));
        Resources resources = this.context.createConfigurationContext(configuration).getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "{\n            context.cr…tion).resources\n        }");
        this.resources = resources;
        this.currentLanguage = configuration.getLocales().get(0).toLanguageTag();
    }

    public Typeface a(String resourceName) {
        Intrinsics.checkNotNullParameter(resourceName, "resourceName");
        int iA = w0.a(this.context, resourceName, "font");
        if (iA > 0) {
            return ResourcesCompat.getFont(this.context, iA);
        }
        return null;
    }

    public String a(String resourceName, String language) {
        Intrinsics.checkNotNullParameter(resourceName, "resourceName");
        if (!s7.a.a(language, this.currentLanguage)) {
            b(language);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("didomi_%s", Arrays.copyOf(new Object[]{resourceName}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        int iA = w0.a(this.context, str, "string");
        Resources resources = null;
        if (iA <= 0) {
            return null;
        }
        Resources resources2 = this.resources;
        if (resources2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resources");
        } else {
            resources = resources2;
        }
        return resources.getString(iA);
    }
}
