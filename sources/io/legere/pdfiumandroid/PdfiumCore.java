package io.legere.pdfiumandroid;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.view.Surface;
import com.facebook.imageutils.JfifUtil;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.google.firebase.messaging.Constants;
import io.legere.pdfiumandroid.util.Config;
import io.legere.pdfiumandroid.util.ConfigKt;
import io.legere.pdfiumandroid.util.InitLock;
import io.legere.pdfiumandroid.util.PdfiumNativeSourceBridge;
import io.legere.pdfiumandroid.util.Size;
import java.io.IOException;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import net.openid.appauth.TokenRequest;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\u0018\u0000 [2\u00020\u0001:\u0001[B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0082 J\u001d\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0082 J#\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0016\u001a\u00020\rH\u0082 J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u0019J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0017\u001a\u00020\u00182\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u001a\u0010\u0017\u001a\u00020\u00182\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u001bJ\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u001b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0018H\u0007J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0018H\u0007J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010\u001e\u001a\u00020\u0018H\u0007J\u0018\u0010#\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u000bH\u0007J\u0018\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u000bH\u0007J\u0018\u0010&\u001a\u00020'2\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u000bH\u0007J\u0018\u0010(\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u000bH\u0007J\u0018\u0010)\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u000bH\u0007J\u0018\u0010*\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u000bH\u0007J*\u0010+\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u000bH\u0007J\u0010\u0010.\u001a\u00020/2\u0006\u0010\u001e\u001a\u00020\u0018H\u0007J\u0018\u00100\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u000bH\u0007J\u0018\u00101\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u000bH\u0007JV\u00102\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00182\b\u00103\u001a\u0004\u0018\u0001042\u0006\u0010$\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b2\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020:H\u0007J\"\u0010<\u001a\u0004\u0018\u00010'2\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020\u000bH\u0007J*\u0010>\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020'2\u0006\u0010\u0016\u001a\u00020\u000bH\u0007JH\u0010@\u001a\u00020'2\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020\u000b2\u0006\u0010D\u001a\u00020EH\u0007J(\u0010F\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u000bH\u0007J+\u0010%\u001a\b\u0012\u0004\u0012\u00020\r0H2\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010I\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010KJ\u0018\u0010L\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010=\u001a\u00020\u000bH\u0007J\u0018\u0010M\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010=\u001a\u00020\u000bH\u0007J\u0018\u0010N\u001a\u00020O2\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010=\u001a\u00020\u000bH\u0007JL\u0010P\u001a\u00020:2\u0006\u0010\u001e\u001a\u00020\u00182\b\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010$\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b2\b\b\u0002\u00109\u001a\u00020:H\u0007JL\u00102\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00182\b\u00103\u001a\u0004\u0018\u0001042\u0006\u0010$\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b2\b\b\u0002\u00109\u001a\u00020:H\u0007J\u001e\u0010S\u001a\b\u0012\u0004\u0012\u00020T0!2\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u000bH\u0007JP\u0010U\u001a\u00020V2\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020\u000b2\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020XH\u0007JH\u0010Z\u001a\u00020E2\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020\u000b2\u0006\u0010D\u001a\u00020'H\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\\"}, d2 = {"Lio/legere/pdfiumandroid/PdfiumCore;", "", "context", "Landroid/content/Context;", "config", "Lio/legere/pdfiumandroid/util/Config;", "<init>", "(Landroid/content/Context;Lio/legere/pdfiumandroid/util/Config;)V", "getConfig", "()Lio/legere/pdfiumandroid/util/Config;", "mCurrentDpi", "", "nativeOpenDocument", "", "fd", TokenRequest.GRANT_TYPE_PASSWORD, "", "nativeOpenMemDocument", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "", "nativeOpenCustomDocument", "Lio/legere/pdfiumandroid/util/PdfiumNativeSourceBridge;", "size", "newDocument", "Lio/legere/pdfiumandroid/PdfDocument;", "Landroid/os/ParcelFileDescriptor;", "parcelFileDescriptor", "Lio/legere/pdfiumandroid/PdfiumSource;", "getPageCount", "", "pdfDocument", "closeDocument", "getTableOfContents", "", "Lio/legere/pdfiumandroid/PdfDocument$Bookmark;", "openTextPage", "pageIndex", "openPage", "getPageMediaBox", "Landroid/graphics/RectF;", "closePage", "closeTextPage", "textPageCountChars", "textPageGetText", "start", "count", "getDocumentMeta", "Lio/legere/pdfiumandroid/PdfDocument$Meta;", "getPageWidthPoint", "getPageHeightPoint", "renderPageBitmap", "bitmap", "Landroid/graphics/Bitmap;", "startX", "startY", "drawSizeX", "drawSizeY", "renderAnnot", "", "textMask", "textPageGetRect", "index", "textPageGetBoundedText", "sourceRect", "mapRectToPage", "sizeX", "sizeY", "rotate", "coords", "Landroid/graphics/Rect;", "textPageCountRects", "startIndex", "", "fromIndex", "toIndex", "(Lio/legere/pdfiumandroid/PdfDocument;II)[Ljava/lang/Long;", "getPageWidth", "getPageHeight", "getPageSize", "Lio/legere/pdfiumandroid/util/Size;", "renderPage", "surface", "Landroid/view/Surface;", "getPageLinks", "Lio/legere/pdfiumandroid/PdfDocument$Link;", "mapPageCoordsToDevice", "Landroid/graphics/Point;", "pageX", "", "pageY", "mapRectToDevice", "Companion", "pdfiumandroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PdfiumCore {
    private final Config config;
    private final int mCurrentDpi;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = PdfiumCore.class.getName();
    private static final Object lock = new Object();
    private static final Mutex surfaceMutex = MutexKt.Mutex$default(false, 1, null);
    private static final InitLock isReady = new InitLock();

    /* JADX WARN: Multi-variable type inference failed */
    public PdfiumCore() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    private final native long nativeOpenCustomDocument(PdfiumNativeSourceBridge data, String password, long size);

    private final native long nativeOpenDocument(int fd, String password);

    private final native long nativeOpenMemDocument(byte[] data, String password);

    @Deprecated
    public final void closePage(PdfDocument pdfDocument, int pageIndex) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
    }

    @Deprecated
    public final void closeTextPage(PdfDocument pdfDocument, int pageIndex) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
    }

    @Deprecated
    public final long openPage(PdfDocument pdfDocument, int pageIndex) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        return pageIndex;
    }

    @Deprecated
    public final long openTextPage(PdfDocument pdfDocument, int pageIndex) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        return pageIndex;
    }

    public PdfiumCore(Context context, Config config) {
        Resources resources;
        DisplayMetrics displayMetrics;
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        ConfigKt.setPdfiumConfig(config);
        Logger logger = Logger.INSTANCE;
        logger.setLogger(config.getLogger());
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        logger.d(TAG2, "Starting PdfiumAndroid ");
        this.mCurrentDpi = (context == null || (resources = context.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null) ? -1 : displayMetrics.densityDpi;
        isReady.waitForReady();
    }

    public /* synthetic */ PdfiumCore(Context context, Config config, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : context, (i & 2) != 0 ? new Config(null, null, 3, null) : config);
    }

    public final Config getConfig() {
        return this.config;
    }

    public final PdfDocument newDocument(ParcelFileDescriptor fd) throws IOException {
        Intrinsics.checkNotNullParameter(fd, "fd");
        return newDocument(fd, (String) null);
    }

    public final PdfDocument newDocument(ParcelFileDescriptor parcelFileDescriptor, String password) throws IOException {
        PdfDocument pdfDocument;
        Intrinsics.checkNotNullParameter(parcelFileDescriptor, "parcelFileDescriptor");
        synchronized (lock) {
            pdfDocument = new PdfDocument(nativeOpenDocument(parcelFileDescriptor.getFd(), password));
            pdfDocument.setParcelFileDescriptor(parcelFileDescriptor);
            pdfDocument.setSource(null);
        }
        return pdfDocument;
    }

    public final PdfDocument newDocument(byte[] data) throws IOException {
        return newDocument(data, (String) null);
    }

    public final PdfDocument newDocument(byte[] data, String password) throws IOException {
        PdfDocument pdfDocument;
        synchronized (lock) {
            pdfDocument = new PdfDocument(nativeOpenMemDocument(data, password));
            pdfDocument.setParcelFileDescriptor(null);
            pdfDocument.setSource(null);
        }
        return pdfDocument;
    }

    public final PdfDocument newDocument(PdfiumSource data) throws IOException {
        Intrinsics.checkNotNullParameter(data, "data");
        return newDocument(data, (String) null);
    }

    public final PdfDocument newDocument(PdfiumSource data, String password) throws IOException {
        PdfDocument pdfDocument;
        Intrinsics.checkNotNullParameter(data, "data");
        synchronized (lock) {
            pdfDocument = new PdfDocument(nativeOpenCustomDocument(new PdfiumNativeSourceBridge(data), password, data.getLength()));
            pdfDocument.setParcelFileDescriptor(null);
            pdfDocument.setSource(data);
        }
        return pdfDocument;
    }

    @Deprecated
    public final void getPageCount(PdfDocument pdfDocument) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        pdfDocument.getPageCount();
    }

    @Deprecated
    public final void closeDocument(PdfDocument pdfDocument) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        pdfDocument.close();
    }

    @Deprecated
    public final List<PdfDocument.Bookmark> getTableOfContents(PdfDocument pdfDocument) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        return pdfDocument.getTableOfContents();
    }

    @Deprecated
    public final RectF getPageMediaBox(PdfDocument pdfDocument, int pageIndex) throws IOException {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        PdfPage pdfPageOpenPage = pdfDocument.openPage(pageIndex);
        try {
            RectF pageMediaBox = pdfPageOpenPage.getPageMediaBox();
            CloseableKt.closeFinally(pdfPageOpenPage, null);
            return pageMediaBox;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(pdfPageOpenPage, th);
                throw th2;
            }
        }
    }

    @Deprecated
    public final int textPageCountChars(PdfDocument pdfDocument, int pageIndex) throws IOException {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        PdfPage pdfPageOpenPage = pdfDocument.openPage(pageIndex);
        try {
            PdfTextPage pdfTextPageOpenTextPage = pdfPageOpenPage.openTextPage();
            try {
                int iTextPageCountChars = pdfTextPageOpenTextPage.textPageCountChars();
                CloseableKt.closeFinally(pdfTextPageOpenTextPage, null);
                CloseableKt.closeFinally(pdfPageOpenPage, null);
                return iTextPageCountChars;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(pdfTextPageOpenTextPage, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(pdfPageOpenPage, th3);
                throw th4;
            }
        }
    }

    @Deprecated
    public final String textPageGetText(PdfDocument pdfDocument, int pageIndex, int start, int count) throws IOException {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        PdfPage pdfPageOpenPage = pdfDocument.openPage(pageIndex);
        try {
            PdfTextPage pdfTextPageOpenTextPage = pdfPageOpenPage.openTextPage();
            try {
                String strTextPageGetText = pdfTextPageOpenTextPage.textPageGetText(start, count);
                CloseableKt.closeFinally(pdfTextPageOpenTextPage, null);
                CloseableKt.closeFinally(pdfPageOpenPage, null);
                return strTextPageGetText;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(pdfTextPageOpenTextPage, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(pdfPageOpenPage, th3);
                throw th4;
            }
        }
    }

    @Deprecated
    public final PdfDocument.Meta getDocumentMeta(PdfDocument pdfDocument) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        return pdfDocument.getDocumentMeta();
    }

    @Deprecated
    public final int getPageWidthPoint(PdfDocument pdfDocument, int pageIndex) throws IOException {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        PdfPage pdfPageOpenPage = pdfDocument.openPage(pageIndex);
        try {
            int pageWidthPoint = pdfPageOpenPage.getPageWidthPoint();
            CloseableKt.closeFinally(pdfPageOpenPage, null);
            return pageWidthPoint;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(pdfPageOpenPage, th);
                throw th2;
            }
        }
    }

    @Deprecated
    public final int getPageHeightPoint(PdfDocument pdfDocument, int pageIndex) throws IOException {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        PdfPage pdfPageOpenPage = pdfDocument.openPage(pageIndex);
        try {
            int pageHeightPoint = pdfPageOpenPage.getPageHeightPoint();
            CloseableKt.closeFinally(pdfPageOpenPage, null);
            return pageHeightPoint;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(pdfPageOpenPage, th);
                throw th2;
            }
        }
    }

    public static /* synthetic */ void renderPageBitmap$default(PdfiumCore pdfiumCore, PdfDocument pdfDocument, Bitmap bitmap, int i, int i2, int i3, int i4, int i5, boolean z, boolean z2, int i6, Object obj) throws IOException {
        if ((i6 & 128) != 0) {
            z = false;
        }
        if ((i6 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0) {
            z2 = false;
        }
        pdfiumCore.renderPageBitmap(pdfDocument, bitmap, i, i2, i3, i4, i5, z, z2);
    }

    @Deprecated
    public final void renderPageBitmap(PdfDocument pdfDocument, Bitmap bitmap, int pageIndex, int startX, int startY, int drawSizeX, int drawSizeY, boolean renderAnnot, boolean textMask) throws IOException {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        PdfPage pdfPageOpenPage = pdfDocument.openPage(pageIndex);
        try {
            PdfPage.renderPageBitmap$default(pdfPageOpenPage, bitmap, startX, startY, drawSizeX, drawSizeY, renderAnnot, textMask, 0, 0, 384, null);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(pdfPageOpenPage, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(pdfPageOpenPage, th);
                throw th2;
            }
        }
    }

    @Deprecated
    public final RectF textPageGetRect(PdfDocument pdfDocument, int pageIndex, int index) throws IOException {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        PdfPage pdfPageOpenPage = pdfDocument.openPage(pageIndex);
        try {
            PdfTextPage pdfTextPageOpenTextPage = pdfPageOpenPage.openTextPage();
            try {
                RectF rectFTextPageGetRect = pdfTextPageOpenTextPage.textPageGetRect(index);
                CloseableKt.closeFinally(pdfTextPageOpenTextPage, null);
                CloseableKt.closeFinally(pdfPageOpenPage, null);
                return rectFTextPageGetRect;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(pdfTextPageOpenTextPage, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(pdfPageOpenPage, th3);
                throw th4;
            }
        }
    }

    @Deprecated
    public final String textPageGetBoundedText(PdfDocument pdfDocument, int pageIndex, RectF sourceRect, int size) throws IOException {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        Intrinsics.checkNotNullParameter(sourceRect, "sourceRect");
        PdfPage pdfPageOpenPage = pdfDocument.openPage(pageIndex);
        try {
            PdfTextPage pdfTextPageOpenTextPage = pdfPageOpenPage.openTextPage();
            try {
                String strTextPageGetBoundedText = pdfTextPageOpenTextPage.textPageGetBoundedText(sourceRect, size);
                CloseableKt.closeFinally(pdfTextPageOpenTextPage, null);
                CloseableKt.closeFinally(pdfPageOpenPage, null);
                return strTextPageGetBoundedText;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(pdfTextPageOpenTextPage, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(pdfPageOpenPage, th3);
                throw th4;
            }
        }
    }

    @Deprecated
    public final RectF mapRectToPage(PdfDocument pdfDocument, int pageIndex, int startX, int startY, int sizeX, int sizeY, int rotate, Rect coords) throws IOException {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        Intrinsics.checkNotNullParameter(coords, "coords");
        PdfPage pdfPageOpenPage = pdfDocument.openPage(pageIndex);
        try {
            RectF rectFMapRectToPage = pdfPageOpenPage.mapRectToPage(startX, startY, sizeX, sizeY, rotate, coords);
            CloseableKt.closeFinally(pdfPageOpenPage, null);
            return rectFMapRectToPage;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(pdfPageOpenPage, th);
                throw th2;
            }
        }
    }

    @Deprecated
    public final int textPageCountRects(PdfDocument pdfDocument, int pageIndex, int startIndex, int count) throws IOException {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        PdfPage pdfPageOpenPage = pdfDocument.openPage(pageIndex);
        try {
            PdfTextPage pdfTextPageOpenTextPage = pdfPageOpenPage.openTextPage();
            try {
                int iTextPageCountRects = pdfTextPageOpenTextPage.textPageCountRects(startIndex, count);
                CloseableKt.closeFinally(pdfTextPageOpenTextPage, null);
                CloseableKt.closeFinally(pdfPageOpenPage, null);
                return iTextPageCountRects;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(pdfTextPageOpenTextPage, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(pdfPageOpenPage, th3);
                throw th4;
            }
        }
    }

    @Deprecated
    public final Long[] openPage(PdfDocument pdfDocument, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        return (Long[]) CollectionsKt.toList(new LongRange(fromIndex, toIndex)).toArray(new Long[0]);
    }

    @Deprecated
    public final int getPageWidth(PdfDocument pdfDocument, int index) throws IOException {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        PdfPage pdfPageOpenPage = pdfDocument.openPage(index);
        try {
            int pageWidth = pdfPageOpenPage.getPageWidth(this.mCurrentDpi);
            CloseableKt.closeFinally(pdfPageOpenPage, null);
            return pageWidth;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(pdfPageOpenPage, th);
                throw th2;
            }
        }
    }

    @Deprecated
    public final int getPageHeight(PdfDocument pdfDocument, int index) throws IOException {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        PdfPage pdfPageOpenPage = pdfDocument.openPage(index);
        try {
            int pageHeight = pdfPageOpenPage.getPageHeight(this.mCurrentDpi);
            CloseableKt.closeFinally(pdfPageOpenPage, null);
            return pageHeight;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(pdfPageOpenPage, th);
                throw th2;
            }
        }
    }

    @Deprecated
    public final Size getPageSize(PdfDocument pdfDocument, int index) throws IOException {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        PdfPage pdfPageOpenPage = pdfDocument.openPage(index);
        try {
            Size pageSize = pdfPageOpenPage.getPageSize(this.mCurrentDpi);
            CloseableKt.closeFinally(pdfPageOpenPage, null);
            return pageSize;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(pdfPageOpenPage, th);
                throw th2;
            }
        }
    }

    @Deprecated
    public final boolean renderPage(PdfDocument pdfDocument, Surface surface, int pageIndex, int startX, int startY, int drawSizeX, int drawSizeY, boolean renderAnnot) throws IOException {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        PdfPage pdfPageOpenPage = pdfDocument.openPage(pageIndex);
        try {
            int[] iArr = new int[2];
            long[] jArr = new long[2];
            if (surface != null) {
                PdfPage.INSTANCE.lockSurface(surface, iArr, jArr);
            }
            boolean zRenderPage = false;
            long j = jArr[0];
            long j2 = jArr[1];
            if (j2 != 0 && j2 != -1 && j != 0 && j != -1) {
                zRenderPage = pdfPageOpenPage.renderPage(j2, startX, startY, drawSizeX, drawSizeY, (JfifUtil.MARKER_SOFn & 32) != 0 ? false : renderAnnot, (JfifUtil.MARKER_SOFn & 64) != 0 ? -8092540 : 0, (JfifUtil.MARKER_SOFn & 128) != 0 ? -1 : 0);
                if (surface != null) {
                    PdfPage.INSTANCE.unlockSurface(jArr);
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(pdfPageOpenPage, null);
            return zRenderPage;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(pdfPageOpenPage, th);
                throw th2;
            }
        }
    }

    @Deprecated
    public final void renderPageBitmap(PdfDocument pdfDocument, Bitmap bitmap, int pageIndex, int startX, int startY, int drawSizeX, int drawSizeY, boolean renderAnnot) throws IOException {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        PdfPage pdfPageOpenPage = pdfDocument.openPage(pageIndex);
        try {
            PdfPage.renderPageBitmap$default(pdfPageOpenPage, bitmap, startX, startY, drawSizeX, drawSizeY, renderAnnot, false, 0, 0, 448, null);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(pdfPageOpenPage, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(pdfPageOpenPage, th);
                throw th2;
            }
        }
    }

    @Deprecated
    public final List<PdfDocument.Link> getPageLinks(PdfDocument pdfDocument, int pageIndex) throws IOException {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        PdfPage pdfPageOpenPage = pdfDocument.openPage(pageIndex);
        try {
            List<PdfDocument.Link> pageLinks = pdfPageOpenPage.getPageLinks();
            CloseableKt.closeFinally(pdfPageOpenPage, null);
            return pageLinks;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(pdfPageOpenPage, th);
                throw th2;
            }
        }
    }

    @Deprecated
    public final Point mapPageCoordsToDevice(PdfDocument pdfDocument, int pageIndex, int startX, int startY, int sizeX, int sizeY, int rotate, double pageX, double pageY) throws IOException {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        PdfPage pdfPageOpenPage = pdfDocument.openPage(pageIndex);
        try {
            Point pointMapPageCoordsToDevice = pdfPageOpenPage.mapPageCoordsToDevice(startX, startY, sizeX, sizeY, rotate, pageX, pageY);
            CloseableKt.closeFinally(pdfPageOpenPage, null);
            return pointMapPageCoordsToDevice;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(pdfPageOpenPage, th);
                throw th2;
            }
        }
    }

    @Deprecated
    public final Rect mapRectToDevice(PdfDocument pdfDocument, int pageIndex, int startX, int startY, int sizeX, int sizeY, int rotate, RectF coords) throws IOException {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        Intrinsics.checkNotNullParameter(coords, "coords");
        PdfPage pdfPageOpenPage = pdfDocument.openPage(pageIndex);
        try {
            Rect rectMapRectToDevice = pdfPageOpenPage.mapRectToDevice(startX, startY, sizeX, sizeY, rotate, coords);
            CloseableKt.closeFinally(pdfPageOpenPage, null);
            return rectMapRectToDevice;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(pdfPageOpenPage, th);
                throw th2;
            }
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0018\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/legere/pdfiumandroid/PdfiumCore$Companion;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "Ljava/lang/String;", "lock", "getLock", "()Ljava/lang/Object;", "surfaceMutex", "Lkotlinx/coroutines/sync/Mutex;", "getSurfaceMutex", "()Lkotlinx/coroutines/sync/Mutex;", "isReady", "Lio/legere/pdfiumandroid/util/InitLock;", "()Lio/legere/pdfiumandroid/util/InitLock;", "pdfiumandroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Object getLock() {
            return PdfiumCore.lock;
        }

        public final Mutex getSurfaceMutex() {
            return PdfiumCore.surfaceMutex;
        }

        public final InitLock isReady() {
            return PdfiumCore.isReady;
        }
    }

    static {
        new Thread(new Runnable() { // from class: io.legere.pdfiumandroid.PdfiumCore$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PdfiumCore._init_$lambda$32();
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$32() {
        synchronized (lock) {
            try {
                System.loadLibrary("pdfium");
                System.loadLibrary("pdfiumandroid");
                isReady.markReady();
            } catch (UnsatisfiedLinkError e) {
                Logger logger = Logger.INSTANCE;
                String TAG2 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                logger.e(TAG2, e, "Native libraries failed to load");
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
