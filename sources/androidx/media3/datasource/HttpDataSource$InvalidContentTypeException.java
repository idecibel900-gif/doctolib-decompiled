package androidx.media3.datasource;

/* JADX INFO: loaded from: classes.dex */
public final class HttpDataSource$InvalidContentTypeException extends HttpDataSource$HttpDataSourceException {
    public final String contentType;

    public HttpDataSource$InvalidContentTypeException(String str, DataSpec dataSpec) {
        super("Invalid content type: " + str, dataSpec, 2003, 1);
        this.contentType = str;
    }
}
