package androidx.compose.ui.text.intl;

/* JADX INFO: loaded from: classes.dex */
public interface PlatformLocaleDelegate {
    LocaleList getCurrent();

    java.util.Locale parseLanguageTag(String str);
}
