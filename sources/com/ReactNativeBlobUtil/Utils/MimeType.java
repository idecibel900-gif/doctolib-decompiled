package com.ReactNativeBlobUtil.Utils;

import android.webkit.MimeTypeMap;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MimeType {
    static String BINARY_FILE = "application/octet-stream";

    public static String getFullFileName(String str, String str2) {
        String extensionFromMimeType = getExtensionFromMimeType(str2);
        if (extensionFromMimeType == null || extensionFromMimeType.isEmpty()) {
            return str;
        }
        if (str.endsWith("." + extensionFromMimeType)) {
            return str;
        }
        String str3 = str + "." + extensionFromMimeType;
        return str3.endsWith(".") ? StringUtils.stripEnd(str3, ".") : str3;
    }

    public static String getExtensionFromMimeType(String str) {
        if (str != null) {
            return str.equals(BINARY_FILE) ? "bin" : MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
        }
        return "";
    }
}
