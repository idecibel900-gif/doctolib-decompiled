package io.legere.pdfiumandroid;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.ParcelFileDescriptor;
import android.view.Surface;
import androidx.core.content.res.FontResourcesParserCompat$$ExternalSyntheticAutoCloseableDispatcher0;
import com.amazon.a.a.o.b;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.google.firebase.messaging.Constants;
import com.opentok.android.PublisherKit;
import io.legere.pdfiumandroid.util.ConfigKt;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 g2\u00020\u0001:\u0005cdefgB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0003H\u0082 J\u0019\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\nH\u0082 J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\nH\u0082 J\u0011\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0003H\u0082 J!\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nH\u0082 J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001dH\u0082 J\u0019\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0003H\u0082 J\u0019\u0010!\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0003H\u0082 J\u0019\u0010\"\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0003H\u0082 J\u0019\u0010#\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003H\u0082 J\u0011\u0010%\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u0003H\u0082 J!\u0010&\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\nH\u0082 J\u0011\u0010*\u001a\u00020+2\u0006\u0010\u0012\u001a\u00020\u0003H\u0082 JY\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\n2\u0006\u00107\u001a\u00020\nH\u0082 JI\u00108\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u00192\u0006\u00109\u001a\u00020:2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\n2\u0006\u00107\u001a\u00020\nH\u0082 J\u0006\u0010G\u001a\u00020\nJ\u0006\u0010H\u001a\u00020+J\u000e\u0010I\u001a\u00020J2\u0006\u0010\u0014\u001a\u00020\nJ\u000e\u0010K\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\nJ\u001c\u0010L\u001a\b\u0012\u0004\u0012\u00020J0M2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nJp\u0010N\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u00032\u0006\u0010O\u001a\u00020\n2\u0006\u0010P\u001a\u00020\n2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020J0M2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020R0M2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020T0M2\b\b\u0002\u00104\u001a\u00020\u000e2\b\b\u0002\u00105\u001a\u00020\u000e2\b\b\u0002\u00106\u001a\u00020\n2\b\b\u0002\u00107\u001a\u00020\nJ`\u0010N\u001a\u00020\u000e2\u0006\u00109\u001a\u00020:2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020J0M2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020R0M2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020T0M2\b\b\u0002\u00104\u001a\u00020\u000e2\b\b\u0002\u00105\u001a\u00020\u000e2\b\b\u0002\u00106\u001a\u00020\n2\b\b\u0002\u00107\u001a\u00020\nJ\u0006\u0010U\u001a\u00020VJ&\u0010W\u001a\u00020\u00162\f\u0010X\u001a\b\u0012\u0004\u0012\u00020Z0Y2\u0006\u0010 \u001a\u00020\u00032\u0006\u0010[\u001a\u00020\u0003H\u0002J\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020Z0MJ\u0010\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020JH\u0007J\u001c\u0010`\u001a\b\u0012\u0004\u0012\u00020^0M2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nJ\u0018\u0010a\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020\nJ\b\u0010b\u001a\u00020\u0016H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001c\u0010A\u001a\u0004\u0018\u00010BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006h"}, d2 = {"Lio/legere/pdfiumandroid/PdfDocument;", "Ljava/io/Closeable;", "mNativeDocPtr", "", "<init>", "(J)V", "getMNativeDocPtr", "()J", "pageMap", "", "", "Lio/legere/pdfiumandroid/PdfDocument$PageCount;", "textPageMap", "value", "", "isClosed", "()Z", "nativeGetPageCount", "docPtr", "nativeLoadPage", "pageIndex", "nativeDeletePage", "", "nativeCloseDocument", "nativeLoadPages", "", "fromIndex", "toIndex", "nativeGetDocumentMetaText", "", "tag", "nativeGetFirstChildBookmark", "bookmarkPtr", "nativeGetSiblingBookmark", "nativeGetBookmarkDestIndex", "nativeLoadTextPage", "pagePtr", "nativeGetBookmarkTitle", "nativeSaveAsCopy", "callback", "Lio/legere/pdfiumandroid/PdfWriteCallback;", "flags", "nativeGetPageCharCounts", "", "nativeRenderPagesWithMatrix", "pages", "bufferPtr", "drawSizeHor", "drawSizeVer", "matrixFloats", "", "clipFloats", "renderAnnot", "textMask", "canvasColor", "pageBackgroundColor", "nativeRenderPagesSurfaceWithMatrix", "surface", "Landroid/view/Surface;", "parcelFileDescriptor", "Landroid/os/ParcelFileDescriptor;", "getParcelFileDescriptor", "()Landroid/os/ParcelFileDescriptor;", "setParcelFileDescriptor", "(Landroid/os/ParcelFileDescriptor;)V", Constants.ScionAnalytics.PARAM_SOURCE, "Lio/legere/pdfiumandroid/PdfiumSource;", "getSource", "()Lio/legere/pdfiumandroid/PdfiumSource;", "setSource", "(Lio/legere/pdfiumandroid/PdfiumSource;)V", "getPageCount", "getPageCharCounts", "openPage", "Lio/legere/pdfiumandroid/PdfPage;", "deletePage", "openPages", "", "renderPages", "drawSizeX", "drawSizeY", "matrices", "Landroid/graphics/Matrix;", "clipRects", "Landroid/graphics/RectF;", "getDocumentMeta", "Lio/legere/pdfiumandroid/PdfDocument$Meta;", "recursiveGetBookmark", "tree", "", "Lio/legere/pdfiumandroid/PdfDocument$Bookmark;", "level", "getTableOfContents", "openTextPage", "Lio/legere/pdfiumandroid/PdfTextPage;", AuthorizationRequest.Display.PAGE, "openTextPages", "saveAsCopy", "close", "Meta", "Bookmark", "Link", "PageCount", "Companion", "pdfiumandroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PdfDocument implements Closeable {
    public static final int FPDF_INCREMENTAL = 1;
    public static final int FPDF_NO_INCREMENTAL = 2;
    public static final int FPDF_REMOVE_SECURITY = 3;
    private boolean isClosed;
    private final long mNativeDocPtr;
    private ParcelFileDescriptor parcelFileDescriptor;
    private PdfiumSource source;
    private static final String TAG = PdfDocument.class.getName();
    private final Map<Integer, PageCount> pageMap = new LinkedHashMap();
    private final Map<Integer, PageCount> textPageMap = new LinkedHashMap();

    private final native void nativeCloseDocument(long docPtr);

    private final native void nativeDeletePage(long docPtr, int pageIndex);

    private final native long nativeGetBookmarkDestIndex(long docPtr, long bookmarkPtr);

    private final native String nativeGetBookmarkTitle(long bookmarkPtr);

    private final native String nativeGetDocumentMetaText(long docPtr, String tag);

    private final native long nativeGetFirstChildBookmark(long docPtr, long bookmarkPtr);

    private final native int[] nativeGetPageCharCounts(long docPtr);

    private final native int nativeGetPageCount(long docPtr);

    private final native long nativeGetSiblingBookmark(long docPtr, long bookmarkPtr);

    private final native long nativeLoadPage(long docPtr, int pageIndex);

    private final native long[] nativeLoadPages(long docPtr, int fromIndex, int toIndex);

    private final native long nativeLoadTextPage(long docPtr, long pagePtr);

    private final native boolean nativeRenderPagesSurfaceWithMatrix(long[] pages, Surface surface, float[] matrixFloats, float[] clipFloats, boolean renderAnnot, boolean textMask, int canvasColor, int pageBackgroundColor);

    private final native void nativeRenderPagesWithMatrix(long[] pages, long bufferPtr, int drawSizeHor, int drawSizeVer, float[] matrixFloats, float[] clipFloats, boolean renderAnnot, boolean textMask, int canvasColor, int pageBackgroundColor);

    private final native boolean nativeSaveAsCopy(long docPtr, PdfWriteCallback callback, int flags);

    public PdfDocument(long j) {
        this.mNativeDocPtr = j;
    }

    public final long getMNativeDocPtr() {
        return this.mNativeDocPtr;
    }

    /* JADX INFO: renamed from: isClosed, reason: from getter */
    public final boolean getIsClosed() {
        return this.isClosed;
    }

    public final ParcelFileDescriptor getParcelFileDescriptor() {
        return this.parcelFileDescriptor;
    }

    public final void setParcelFileDescriptor(ParcelFileDescriptor parcelFileDescriptor) {
        this.parcelFileDescriptor = parcelFileDescriptor;
    }

    public final PdfiumSource getSource() {
        return this.source;
    }

    public final void setSource(PdfiumSource pdfiumSource) {
        this.source = pdfiumSource;
    }

    public final int getPageCount() {
        int iNativeGetPageCount;
        if (ConfigKt.handleAlreadyClosed(this.isClosed)) {
            return 0;
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            iNativeGetPageCount = nativeGetPageCount(this.mNativeDocPtr);
        }
        return iNativeGetPageCount;
    }

    public final int[] getPageCharCounts() {
        int[] iArrNativeGetPageCharCounts;
        if (ConfigKt.handleAlreadyClosed(this.isClosed)) {
            return new int[0];
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            iArrNativeGetPageCharCounts = nativeGetPageCharCounts(this.mNativeDocPtr);
        }
        return iArrNativeGetPageCharCounts;
    }

    public final PdfPage openPage(int pageIndex) {
        PageCount pageCount;
        if (this.isClosed) {
            throw new IllegalStateException("Already closed");
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            if (this.pageMap.containsKey(Integer.valueOf(pageIndex)) && (pageCount = this.pageMap.get(Integer.valueOf(pageIndex))) != null) {
                pageCount.setCount(pageCount.getCount() + 1);
                return new PdfPage(this, pageIndex, pageCount.getPagePtr(), this.pageMap);
            }
            long jNativeLoadPage = nativeLoadPage(this.mNativeDocPtr, pageIndex);
            this.pageMap.put(Integer.valueOf(pageIndex), new PageCount(jNativeLoadPage, 1));
            return new PdfPage(this, pageIndex, jNativeLoadPage, this.pageMap);
        }
    }

    public final void deletePage(int pageIndex) {
        if (ConfigKt.handleAlreadyClosed(this.isClosed)) {
            return;
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            nativeDeletePage(this.mNativeDocPtr, pageIndex);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final List<PdfPage> openPages(int fromIndex, int toIndex) {
        ArrayList arrayList;
        if (ConfigKt.handleAlreadyClosed(this.isClosed)) {
            return CollectionsKt.emptyList();
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            try {
                long[] jArrNativeLoadPages = nativeLoadPages(this.mNativeDocPtr, fromIndex, toIndex);
                int i = fromIndex;
                for (long j : jArrNativeLoadPages) {
                    if (i > toIndex) {
                        break;
                    }
                    i++;
                }
                arrayList = new ArrayList(jArrNativeLoadPages.length);
                for (long j2 : jArrNativeLoadPages) {
                    arrayList.add(new PdfPage(this, i, j2, this.pageMap));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    public static /* synthetic */ void renderPages$default(PdfDocument pdfDocument, long j, int i, int i2, List list, List list2, List list3, boolean z, boolean z2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 64) != 0) {
            z = false;
        }
        if ((i5 & 128) != 0) {
            z2 = false;
        }
        if ((i5 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0) {
            i3 = -8092540;
        }
        if ((i5 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0) {
            i4 = -1;
        }
        pdfDocument.renderPages(j, i, i2, list, list2, list3, z, z2, i3, i4);
    }

    public final void renderPages(long bufferPtr, int drawSizeX, int drawSizeY, List<PdfPage> pages, List<? extends Matrix> matrices, List<? extends RectF> clipRects, boolean renderAnnot, boolean textMask, int canvasColor, int pageBackgroundColor) {
        boolean z;
        Intrinsics.checkNotNullParameter(pages, "pages");
        Intrinsics.checkNotNullParameter(matrices, "matrices");
        Intrinsics.checkNotNullParameter(clipRects, "clipRects");
        if (this.isClosed) {
            z = true;
        } else {
            List<PdfPage> list = pages;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((PdfPage) it.next()).getIsClosed()) {
                            z = true;
                        }
                    }
                }
            }
            z = false;
        }
        if (ConfigKt.handleAlreadyClosed(z)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it2 = matrices.iterator();
        while (it2.hasNext()) {
            float[] fArr = new float[9];
            ((Matrix) it2.next()).getValues(fArr);
            CollectionsKt.addAll(arrayList, CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(fArr[0]), Float.valueOf(fArr[2]), Float.valueOf(fArr[5])}));
        }
        float[] floatArray = CollectionsKt.toFloatArray(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (RectF rectF : clipRects) {
            CollectionsKt.addAll(arrayList2, CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(rectF.left), Float.valueOf(rectF.top), Float.valueOf(rectF.right), Float.valueOf(rectF.bottom)}));
        }
        float[] floatArray2 = CollectionsKt.toFloatArray(arrayList2);
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            try {
                List<PdfPage> list2 = pages;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator<T> it3 = list2.iterator();
                while (it3.hasNext()) {
                    arrayList3.add(Long.valueOf(((PdfPage) it3.next()).getPagePtr()));
                }
                nativeRenderPagesWithMatrix(CollectionsKt.toLongArray(arrayList3), bufferPtr, drawSizeX, drawSizeY, floatArray, floatArray2, renderAnnot, textMask, canvasColor, pageBackgroundColor);
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* synthetic */ boolean renderPages$default(PdfDocument pdfDocument, Surface surface, List list, List list2, List list3, boolean z, boolean z2, int i, int i2, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            z = false;
        }
        if ((i3 & 32) != 0) {
            z2 = false;
        }
        if ((i3 & 64) != 0) {
            i = -8092540;
        }
        if ((i3 & 128) != 0) {
            i2 = -1;
        }
        return pdfDocument.renderPages(surface, list, list2, list3, z, z2, i, i2);
    }

    public final boolean renderPages(Surface surface, List<PdfPage> pages, List<? extends Matrix> matrices, List<? extends RectF> clipRects, boolean renderAnnot, boolean textMask, int canvasColor, int pageBackgroundColor) {
        boolean z;
        boolean zNativeRenderPagesSurfaceWithMatrix;
        Intrinsics.checkNotNullParameter(surface, "surface");
        Intrinsics.checkNotNullParameter(pages, "pages");
        Intrinsics.checkNotNullParameter(matrices, "matrices");
        Intrinsics.checkNotNullParameter(clipRects, "clipRects");
        if (this.isClosed) {
            z = true;
        } else {
            List<PdfPage> list = pages;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((PdfPage) it.next()).getIsClosed()) {
                            z = true;
                        }
                    }
                }
            }
            z = false;
        }
        if (ConfigKt.handleAlreadyClosed(z)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it2 = matrices.iterator();
        while (it2.hasNext()) {
            float[] fArr = new float[9];
            ((Matrix) it2.next()).getValues(fArr);
            CollectionsKt.addAll(arrayList, CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(fArr[0]), Float.valueOf(fArr[2]), Float.valueOf(fArr[5])}));
        }
        float[] floatArray = CollectionsKt.toFloatArray(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (RectF rectF : clipRects) {
            CollectionsKt.addAll(arrayList2, CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(rectF.left), Float.valueOf(rectF.top), Float.valueOf(rectF.right), Float.valueOf(rectF.bottom)}));
        }
        float[] floatArray2 = CollectionsKt.toFloatArray(arrayList2);
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            try {
                List<PdfPage> list2 = pages;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator<T> it3 = list2.iterator();
                while (it3.hasNext()) {
                    arrayList3.add(Long.valueOf(((PdfPage) it3.next()).getPagePtr()));
                }
                zNativeRenderPagesSurfaceWithMatrix = nativeRenderPagesSurfaceWithMatrix(CollectionsKt.toLongArray(arrayList3), surface, floatArray, floatArray2, renderAnnot, textMask, canvasColor, pageBackgroundColor);
            } catch (Throwable th) {
                throw th;
            }
        }
        return zNativeRenderPagesSurfaceWithMatrix;
    }

    public final Meta getDocumentMeta() {
        Meta meta;
        if (ConfigKt.handleAlreadyClosed(this.isClosed)) {
            return new Meta();
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            meta = new Meta();
            meta.setTitle(nativeGetDocumentMetaText(this.mNativeDocPtr, "Title"));
            meta.setAuthor(nativeGetDocumentMetaText(this.mNativeDocPtr, "Author"));
            meta.setSubject(nativeGetDocumentMetaText(this.mNativeDocPtr, "Subject"));
            meta.setKeywords(nativeGetDocumentMetaText(this.mNativeDocPtr, "Keywords"));
            meta.setCreator(nativeGetDocumentMetaText(this.mNativeDocPtr, "Creator"));
            meta.setProducer(nativeGetDocumentMetaText(this.mNativeDocPtr, "Producer"));
            meta.setCreationDate(nativeGetDocumentMetaText(this.mNativeDocPtr, "CreationDate"));
            meta.setModDate(nativeGetDocumentMetaText(this.mNativeDocPtr, "ModDate"));
        }
        return meta;
    }

    private final void recursiveGetBookmark(List<Bookmark> tree, long bookmarkPtr, long level) {
        long j;
        if (ConfigKt.handleAlreadyClosed(this.isClosed)) {
            return;
        }
        Bookmark bookmark = new Bookmark();
        bookmark.setMNativePtr(bookmarkPtr);
        bookmark.setTitle(nativeGetBookmarkTitle(bookmarkPtr));
        bookmark.setPageIdx(nativeGetBookmarkDestIndex(this.mNativeDocPtr, bookmarkPtr));
        tree.add(bookmark);
        long jNativeGetFirstChildBookmark = nativeGetFirstChildBookmark(this.mNativeDocPtr, bookmarkPtr);
        if (jNativeGetFirstChildBookmark == 0 || level >= 16) {
            j = level;
        } else {
            recursiveGetBookmark(bookmark.getChildren(), jNativeGetFirstChildBookmark, level);
            j = level + 1;
        }
        long jNativeGetSiblingBookmark = nativeGetSiblingBookmark(this.mNativeDocPtr, bookmarkPtr);
        if (jNativeGetSiblingBookmark == 0 || j >= 16) {
            return;
        }
        recursiveGetBookmark(tree, jNativeGetSiblingBookmark, j);
    }

    public final List<Bookmark> getTableOfContents() {
        ArrayList arrayList;
        if (ConfigKt.handleAlreadyClosed(this.isClosed)) {
            return CollectionsKt.emptyList();
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            arrayList = new ArrayList();
            long jNativeGetFirstChildBookmark = nativeGetFirstChildBookmark(this.mNativeDocPtr, 0L);
            if (jNativeGetFirstChildBookmark != 0) {
                recursiveGetBookmark(arrayList, jNativeGetFirstChildBookmark, 1L);
            }
        }
        return arrayList;
    }

    @Deprecated
    public final PdfTextPage openTextPage(PdfPage page) {
        PageCount pageCount;
        Intrinsics.checkNotNullParameter(page, "page");
        if (this.isClosed) {
            throw new IllegalStateException("Already closed");
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            if (this.textPageMap.containsKey(Integer.valueOf(page.getPageIndex())) && (pageCount = this.textPageMap.get(Integer.valueOf(page.getPageIndex()))) != null) {
                pageCount.setCount(pageCount.getCount() + 1);
                return new PdfTextPage(this, page.getPageIndex(), pageCount.getPagePtr(), this.textPageMap);
            }
            long jNativeLoadTextPage = nativeLoadTextPage(this.mNativeDocPtr, page.getPagePtr());
            this.textPageMap.put(Integer.valueOf(page.getPageIndex()), new PageCount(jNativeLoadTextPage, 1));
            return new PdfTextPage(this, page.getPageIndex(), jNativeLoadTextPage, this.textPageMap);
        }
    }

    public final List<PdfTextPage> openTextPages(int fromIndex, int toIndex) {
        ArrayList arrayList;
        if (ConfigKt.handleAlreadyClosed(this.isClosed)) {
            return CollectionsKt.emptyList();
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            long[] jArrNativeLoadPages = nativeLoadPages(this.mNativeDocPtr, fromIndex, toIndex);
            arrayList = new ArrayList(jArrNativeLoadPages.length);
            int length = jArrNativeLoadPages.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int i3 = i2 + 1;
                arrayList.add(new PdfTextPage(this, fromIndex + i2, jArrNativeLoadPages[i], this.textPageMap));
                i++;
                i2 = i3;
            }
        }
        return arrayList;
    }

    public static /* synthetic */ boolean saveAsCopy$default(PdfDocument pdfDocument, PdfWriteCallback pdfWriteCallback, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 2;
        }
        return pdfDocument.saveAsCopy(pdfWriteCallback, i);
    }

    public final boolean saveAsCopy(PdfWriteCallback callback, int flags) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (ConfigKt.handleAlreadyClosed(this.isClosed)) {
            return false;
        }
        return nativeSaveAsCopy(this.mNativeDocPtr, callback, flags);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (ConfigKt.handleAlreadyClosed(this.isClosed)) {
            return;
        }
        Logger logger = Logger.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        logger.d(TAG2, "PdfDocument.close");
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            try {
                this.isClosed = true;
                nativeCloseDocument(this.mNativeDocPtr);
                ParcelFileDescriptor parcelFileDescriptor = this.parcelFileDescriptor;
                if (parcelFileDescriptor != null) {
                    parcelFileDescriptor.close();
                }
                this.parcelFileDescriptor = null;
                PdfiumSource pdfiumSource = this.source;
                if (pdfiumSource != null) {
                    FontResourcesParserCompat$$ExternalSyntheticAutoCloseableDispatcher0.m(pdfiumSource);
                }
                this.source = null;
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001a\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\t¨\u0006\u001f"}, d2 = {"Lio/legere/pdfiumandroid/PdfDocument$Meta;", "", "<init>", "()V", b.S, "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "author", "getAuthor", "setAuthor", "subject", "getSubject", "setSubject", "keywords", "getKeywords", "setKeywords", "creator", "getCreator", "setCreator", "producer", "getProducer", "setProducer", "creationDate", "getCreationDate", "setCreationDate", "modDate", "getModDate", "setModDate", "pdfiumandroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Meta {
        private String author;
        private String creationDate;
        private String creator;
        private String keywords;
        private String modDate;
        private String producer;
        private String subject;
        private String title;

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final String getAuthor() {
            return this.author;
        }

        public final void setAuthor(String str) {
            this.author = str;
        }

        public final String getSubject() {
            return this.subject;
        }

        public final void setSubject(String str) {
            this.subject = str;
        }

        public final String getKeywords() {
            return this.keywords;
        }

        public final void setKeywords(String str) {
            this.keywords = str;
        }

        public final String getCreator() {
            return this.creator;
        }

        public final void setCreator(String str) {
            this.creator = str;
        }

        public final String getProducer() {
            return this.producer;
        }

        public final void setProducer(String str) {
            this.producer = str;
        }

        public final String getCreationDate() {
            return this.creationDate;
        }

        public final void setCreationDate(String str) {
            this.creationDate = str;
        }

        public final String getModDate() {
            return this.modDate;
        }

        public final void setModDate(String str) {
            this.modDate = str;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00000\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013¨\u0006\u0017"}, d2 = {"Lio/legere/pdfiumandroid/PdfDocument$Bookmark;", "", "<init>", "()V", "children", "", "getChildren", "()Ljava/util/List;", b.S, "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "pageIdx", "", "getPageIdx", "()J", "setPageIdx", "(J)V", "mNativePtr", "getMNativePtr", "setMNativePtr", "pdfiumandroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Bookmark {
        private final List<Bookmark> children = new ArrayList();
        private long mNativePtr;
        private long pageIdx;
        private String title;

        public final List<Bookmark> getChildren() {
            return this.children;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final long getPageIdx() {
            return this.pageIdx;
        }

        public final void setPageIdx(long j) {
            this.pageIdx = j;
        }

        public final long getMNativePtr() {
            return this.mNativePtr;
        }

        public final void setMNativePtr(long j) {
            this.mNativePtr = j;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/legere/pdfiumandroid/PdfDocument$Link;", "", "bounds", "Landroid/graphics/RectF;", "destPageIdx", "", "uri", "", "<init>", "(Landroid/graphics/RectF;Ljava/lang/Integer;Ljava/lang/String;)V", "getBounds", "()Landroid/graphics/RectF;", "getDestPageIdx", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUri", "()Ljava/lang/String;", "pdfiumandroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Link {
        private final RectF bounds;
        private final Integer destPageIdx;
        private final String uri;

        public Link(RectF bounds, Integer num, String str) {
            Intrinsics.checkNotNullParameter(bounds, "bounds");
            this.bounds = bounds;
            this.destPageIdx = num;
            this.uri = str;
        }

        public final RectF getBounds() {
            return this.bounds;
        }

        public final Integer getDestPageIdx() {
            return this.destPageIdx;
        }

        public final String getUri() {
            return this.uri;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lio/legere/pdfiumandroid/PdfDocument$PageCount;", "", "pagePtr", "", "count", "", "<init>", "(JI)V", "getPagePtr", "()J", "getCount", "()I", "setCount", "(I)V", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "toString", "", "pdfiumandroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class PageCount {
        private int count;
        private final long pagePtr;

        public static /* synthetic */ PageCount copy$default(PageCount pageCount, long j, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = pageCount.pagePtr;
            }
            if ((i2 & 2) != 0) {
                i = pageCount.count;
            }
            return pageCount.copy(j, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getPagePtr() {
            return this.pagePtr;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getCount() {
            return this.count;
        }

        public final PageCount copy(long pagePtr, int count) {
            return new PageCount(pagePtr, count);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PageCount)) {
                return false;
            }
            PageCount pageCount = (PageCount) other;
            return this.pagePtr == pageCount.pagePtr && this.count == pageCount.count;
        }

        public int hashCode() {
            return (Long.hashCode(this.pagePtr) * 31) + Integer.hashCode(this.count);
        }

        public String toString() {
            return "PageCount(pagePtr=" + this.pagePtr + ", count=" + this.count + ')';
        }

        public PageCount(long j, int i) {
            this.pagePtr = j;
            this.count = i;
        }

        public final long getPagePtr() {
            return this.pagePtr;
        }

        public final int getCount() {
            return this.count;
        }

        public final void setCount(int i) {
            this.count = i;
        }
    }
}
