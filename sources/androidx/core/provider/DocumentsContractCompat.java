package androidx.core.provider;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;

/* JADX INFO: loaded from: classes.dex */
public abstract class DocumentsContractCompat {
    public static boolean isDocumentUri(Context context, Uri uri) {
        return DocumentsContract.isDocumentUri(context, uri);
    }

    public static String getDocumentId(Uri uri) {
        return DocumentsContract.getDocumentId(uri);
    }

    public static String getTreeDocumentId(Uri uri) {
        return DocumentsContractApi21Impl.getTreeDocumentId(uri);
    }

    public static Uri buildDocumentUriUsingTree(Uri uri, String str) {
        return DocumentsContractApi21Impl.buildDocumentUriUsingTree(uri, str);
    }

    private static class DocumentsContractApi21Impl {
        static String getTreeDocumentId(Uri uri) {
            return DocumentsContract.getTreeDocumentId(uri);
        }

        static Uri buildDocumentUriUsingTree(Uri uri, String str) {
            return DocumentsContract.buildDocumentUriUsingTree(uri, str);
        }
    }
}
