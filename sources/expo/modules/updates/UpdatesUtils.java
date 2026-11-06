package expo.modules.updates;

import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Base64;
import com.amazon.a.a.o.b.f;
import expo.modules.updates.db.entity.AssetEntity;
import expo.modules.updates.logging.UpdatesErrorCode;
import expo.modules.updates.logging.UpdatesLogger;
import j$.util.DesugarTimeZone;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.io.NoSuchFileException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class UpdatesUtils {
    private static final char[] HEX_ARRAY;
    private static final Lazy PARAMETER_PATTERN$delegate;
    public static final UpdatesUtils INSTANCE = new UpdatesUtils();
    private static final String TAG = UpdatesUtils.class.getSimpleName();

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[UpdatesConfiguration.CheckAutomaticallyConfiguration.values().length];
            try {
                iArr[UpdatesConfiguration.CheckAutomaticallyConfiguration.NEVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UpdatesConfiguration.CheckAutomaticallyConfiguration.ERROR_RECOVERY_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[UpdatesConfiguration.CheckAutomaticallyConfiguration.WIFI_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[UpdatesConfiguration.CheckAutomaticallyConfiguration.ALWAYS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private UpdatesUtils() {
    }

    static {
        char[] charArray = "0123456789ABCDEF".toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        HEX_ARRAY = charArray;
        PARAMETER_PATTERN$delegate = LazyKt.lazy(new Function0() { // from class: expo.modules.updates.UpdatesUtils$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UpdatesUtils.PARAMETER_PATTERN_delegate$lambda$8();
            }
        });
    }

    public final Map getMapFromJSONString(String stringifiedJSON) throws Exception {
        Intrinsics.checkNotNullParameter(stringifiedJSON, "stringifiedJSON");
        JSONObject jSONObject = new JSONObject(stringifiedJSON);
        Iterator<String> itKeys = jSONObject.keys();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                Object obj = jSONObject.get(next);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                linkedHashMap.put(next, (String) obj);
            } catch (ClassCastException unused) {
                throw new Exception("The values in the JSON object must be strings");
            }
        }
        return linkedHashMap;
    }

    public final File getOrCreateUpdatesDirectory(Context context) throws Exception {
        Intrinsics.checkNotNullParameter(context, "context");
        File file = new File(context.getFilesDir(), ".expo-internal");
        if (file.exists()) {
            if (file.isFile()) {
                throw new Exception("File already exists at the location of the Updates Directory: " + file + " ; aborting");
            }
        } else if (!file.mkdir()) {
            throw new Exception("Failed to create Updates Directory: mkdir() returned false");
        }
        return file;
    }

    public final byte[] sha256(File file) throws NoSuchAlgorithmException, IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        try {
            byte[] bArr = new byte[8192];
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                DigestInputStream digestInputStream = new DigestInputStream(fileInputStream, MessageDigest.getInstance("SHA-256"));
                do {
                    try {
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(digestInputStream, th);
                            throw th2;
                        }
                    }
                } while (digestInputStream.read(bArr) != -1);
                byte[] bArrDigest = digestInputStream.getMessageDigest().digest();
                Intrinsics.checkNotNullExpressionValue(bArrDigest, "digest(...)");
                CloseableKt.closeFinally(digestInputStream, null);
                CloseableKt.closeFinally(fileInputStream, null);
                return bArrDigest;
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(fileInputStream, th3);
                    throw th4;
                }
            }
        } catch (IOException e) {
            Objects.toString(file);
            throw e;
        } catch (NoSuchAlgorithmException e2) {
            Objects.toString(file);
            throw e2;
        }
    }

    public final byte[] verifySHA256AndWriteToFile(InputStream inputStream, File destination, String str) throws IOException {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(destination, "destination");
        DigestInputStream digestInputStream = new DigestInputStream(inputStream, MessageDigest.getInstance("SHA-256"));
        try {
            File file = new File(destination.getAbsolutePath() + ".tmp");
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    ByteStreamsKt.copyTo$default(digestInputStream, fileOutputStream, 0, 2, null);
                    CloseableKt.closeFinally(fileOutputStream, null);
                    CloseableKt.closeFinally(digestInputStream, null);
                    byte[] bArrDigest = digestInputStream.getMessageDigest().digest();
                    UpdatesUtils updatesUtils = INSTANCE;
                    Intrinsics.checkNotNull(bArrDigest);
                    String base64Url = updatesUtils.toBase64Url(bArrDigest);
                    if (str != null && !Intrinsics.areEqual(str, base64Url)) {
                        throw new IOException("File download was successful but base64url-encoded SHA-256 did not match expected; expected: " + str + "; actual: " + base64Url);
                    }
                    try {
                        try {
                            try {
                                FilesKt.copyTo$default(file, destination, true, 0, 4, null);
                                file.delete();
                                CloseableKt.closeFinally(digestInputStream, null);
                                return bArrDigest;
                            } catch (Throwable th) {
                                file.delete();
                                throw th;
                            }
                        } catch (Exception e) {
                            throw new IOException("File download was successful, but an exception occurred: " + e);
                        }
                    } catch (NoSuchFileException unused) {
                        throw new IOException("File download was successful, but temp file " + file.getAbsolutePath() + " does not exist");
                    }
                } catch (Throwable th2) {
                    try {
                        throw th2;
                    } catch (Throwable th3) {
                        CloseableKt.closeFinally(fileOutputStream, th2);
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                try {
                    throw th4;
                } catch (Throwable th5) {
                    CloseableKt.closeFinally(digestInputStream, th4);
                    throw th5;
                }
            }
        } catch (Throwable th6) {
            try {
                throw th6;
            } catch (Throwable th7) {
                CloseableKt.closeFinally(digestInputStream, th6);
                throw th7;
            }
        }
    }

    public final String toBase64Url(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        String strEncodeToString = Base64.encodeToString(bytes, 11);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
        return strEncodeToString;
    }

    public final String createFilenameForAsset(AssetEntity asset) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        String fileExtension$expo_updates_release = asset.getFileExtension$expo_updates_release();
        if (asset.getKey() == null) {
            return "asset-" + new Date().getTime() + "-" + new Random().nextInt() + fileExtension$expo_updates_release;
        }
        return asset.getKey() + fileExtension$expo_updates_release;
    }

    public final boolean isSafeFilename(String filename) {
        Intrinsics.checkNotNullParameter(filename, "filename");
        if (filename.length() > 0 && !Intrinsics.areEqual(filename, ".") && !Intrinsics.areEqual(filename, "..")) {
            for (int i = 0; i < filename.length(); i++) {
                char cCharAt = filename.charAt(i);
                if (cCharAt != '/' && cCharAt != '\\' && cCharAt != 0) {
                }
            }
            return true;
        }
        return false;
    }

    public final boolean shouldCheckForUpdateOnLaunch(UpdatesConfiguration updatesConfiguration, UpdatesLogger logger, Context context) {
        Intrinsics.checkNotNullParameter(updatesConfiguration, "updatesConfiguration");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(context, "context");
        int i = WhenMappings.$EnumSwitchMapping$0[updatesConfiguration.getCheckOnLaunch().ordinal()];
        if (i != 1 && i != 2) {
            if (i != 3) {
                if (i == 4) {
                    return true;
                }
                throw new NoWhenBranchMatchedException();
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                logger.error("Could not determine active network connection is metered; not checking for updates", new Exception("Null ConnectivityManager system service"), UpdatesErrorCode.Unknown);
                return false;
            }
            if (!connectivityManager.isActiveNetworkMetered()) {
                return true;
            }
        }
        return false;
    }

    public final Date parseDateString(String dateString) throws ParseException {
        Intrinsics.checkNotNullParameter(dateString, "dateString");
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'X'", Locale.US).parse(dateString);
            Intrinsics.checkNotNull(date, "null cannot be cast to non-null type java.util.Date");
            return date;
        } catch (Exception unused) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("GMT"));
            Date date2 = simpleDateFormat.parse(dateString);
            Intrinsics.checkNotNull(date2, "null cannot be cast to non-null type java.util.Date");
            return date2;
        }
    }

    private final Pattern getPARAMETER_PATTERN() {
        Object value = PARAMETER_PATTERN$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Pattern) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pattern PARAMETER_PATTERN_delegate$lambda$8() {
        return Pattern.compile(";\\s*(?:\\s*([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)\\s*=\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)" + f.c + "\"([^\"]*)\"))?\\s*");
    }

    public final String parseContentDispositionNameParameter(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Matcher matcher = getPARAMETER_PATTERN().matcher(str);
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, ';', 0, false, 6, (Object) null);
        while (iIndexOf$default < str.length()) {
            matcher.region(iIndexOf$default, str.length());
            if (!matcher.lookingAt()) {
                String strSubstring = str.substring(iIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                throw new IllegalArgumentException(("Parameter is not formatted correctly: \"" + strSubstring + "\" for: \"" + str + "\"").toString());
            }
            String strGroup = matcher.group(1);
            if (strGroup == null) {
                iIndexOf$default = matcher.end();
            } else {
                String strGroup2 = matcher.group(2);
                if (strGroup2 == null) {
                    strGroup2 = matcher.group(3);
                } else if (StringsKt.startsWith$default(strGroup2, "'", false, 2, (Object) null) && StringsKt.endsWith$default(strGroup2, "'", false, 2, (Object) null) && strGroup2.length() > 2) {
                    strGroup2 = strGroup2.substring(1, strGroup2.length() - 1);
                    Intrinsics.checkNotNullExpressionValue(strGroup2, "substring(...)");
                }
                if (!linkedHashMap.containsKey(strGroup)) {
                    linkedHashMap.put(strGroup, strGroup2);
                }
                iIndexOf$default = matcher.end();
            }
        }
        return (String) linkedHashMap.get("name");
    }
}
