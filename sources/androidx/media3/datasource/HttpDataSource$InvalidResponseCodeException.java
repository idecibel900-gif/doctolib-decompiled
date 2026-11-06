package androidx.media3.datasource;

import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class HttpDataSource$InvalidResponseCodeException extends HttpDataSource$HttpDataSourceException {
    public final Map headerFields;
    public final byte[] responseBody;
    public final int responseCode;
    public final String responseMessage;

    public HttpDataSource$InvalidResponseCodeException(int i, String str, IOException iOException, Map map, DataSpec dataSpec, byte[] bArr) {
        super("Response code: " + i, iOException, dataSpec, 2004, 1);
        this.responseCode = i;
        this.responseMessage = str;
        this.headerFields = map;
        this.responseBody = bArr;
    }
}
