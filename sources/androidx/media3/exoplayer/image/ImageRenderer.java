package androidx.media3.exoplayer.image;

import android.graphics.Bitmap;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.TraceUtil;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.RendererCapabilities;
import com.revenuecat.purchases.common.networking.HTTPTimeoutManager;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
public class ImageRenderer extends BaseRenderer {
    private boolean codecNeedsInitialization;
    private int currentTileIndex;
    private ImageDecoder decoder;
    private final ImageDecoder.Factory decoderFactory;
    private int decoderReinitializationState;
    private int firstFrameState;
    private final DecoderInputBuffer flagsOnlyBuffer;
    private ImageOutput imageOutput;
    private DecoderInputBuffer inputBuffer;
    private Format inputFormat;
    private boolean inputStreamEnded;
    private long largestQueuedPresentationTimeUs;
    private long lastProcessedOutputBufferTimeUs;
    private TileInfo nextTileInfo;
    private Bitmap outputBitmap;
    private boolean outputStreamEnded;
    private OutputStreamInfo outputStreamInfo;
    private final ArrayDeque pendingOutputStreamChanges;
    private boolean readyToOutputTiles;
    private TileInfo tileInfo;

    protected boolean maybeInitializeProcessingPipeline() {
        return true;
    }

    public ImageRenderer(ImageDecoder.Factory factory, ImageOutput imageOutput) {
        super(4);
        this.decoderFactory = factory;
        this.imageOutput = getImageOutput(imageOutput);
        this.flagsOnlyBuffer = DecoderInputBuffer.newNoDataInstance();
        this.outputStreamInfo = OutputStreamInfo.UNSET;
        this.pendingOutputStreamChanges = new ArrayDeque();
        this.largestQueuedPresentationTimeUs = -9223372036854775807L;
        this.lastProcessedOutputBufferTimeUs = -9223372036854775807L;
        this.decoderReinitializationState = 0;
        this.firstFrameState = 1;
    }

    @Override // androidx.media3.exoplayer.Renderer, androidx.media3.exoplayer.RendererCapabilities
    public String getName() {
        return "ImageRenderer";
    }

    @Override // androidx.media3.exoplayer.RendererCapabilities
    public int supportsFormat(Format format) {
        return this.decoderFactory.supportsFormat(format);
    }

    @Override // androidx.media3.exoplayer.Renderer
    public void render(long j, long j2) throws ExoPlaybackException {
        if (this.outputStreamEnded) {
            return;
        }
        if (this.inputFormat == null) {
            FormatHolder formatHolder = getFormatHolder();
            this.flagsOnlyBuffer.clear();
            int source = readSource(formatHolder, this.flagsOnlyBuffer, 2);
            if (source != -5) {
                if (source == -4) {
                    Assertions.checkState(this.flagsOnlyBuffer.isEndOfStream());
                    this.inputStreamEnded = true;
                    this.outputStreamEnded = true;
                    return;
                }
                return;
            }
            this.inputFormat = (Format) Assertions.checkStateNotNull(formatHolder.format);
            this.codecNeedsInitialization = true;
        }
        if (this.decoder != null || maybeInitCodec()) {
            try {
                TraceUtil.beginSection("drainAndFeedDecoder");
                while (drainOutput(j, j2)) {
                }
                while (feedInputBuffer(j)) {
                }
                TraceUtil.endSection();
            } catch (ImageDecoderException e) {
                throw createRendererException(e, null, 4003);
            }
        }
    }

    @Override // androidx.media3.exoplayer.Renderer
    public boolean isReady() {
        int i = this.firstFrameState;
        if (i != 3) {
            return i == 0 && this.readyToOutputTiles;
        }
        return true;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public boolean isEnded() {
        return this.outputStreamEnded;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void onEnabled(boolean z, boolean z2) {
        this.firstFrameState = z2 ? 1 : 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
    
        if (r2 >= r6) goto L15;
     */
    @Override // androidx.media3.exoplayer.BaseRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onStreamChanged(androidx.media3.common.Format[] r5, long r6, long r8, androidx.media3.exoplayer.source.MediaSource.MediaPeriodId r10) {
        /*
            r4 = this;
            super.onStreamChanged(r5, r6, r8, r10)
            r5 = r4
            androidx.media3.exoplayer.image.ImageRenderer$OutputStreamInfo r6 = r5.outputStreamInfo
            long r6 = r6.streamOffsetUs
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r6 == 0) goto L37
            java.util.ArrayDeque r6 = r5.pendingOutputStreamChanges
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L2a
            long r6 = r5.largestQueuedPresentationTimeUs
            int r10 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r10 == 0) goto L37
            long r2 = r5.lastProcessedOutputBufferTimeUs
            int r10 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r10 == 0) goto L2a
            int r6 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r6 < 0) goto L2a
            goto L37
        L2a:
            java.util.ArrayDeque r6 = r5.pendingOutputStreamChanges
            androidx.media3.exoplayer.image.ImageRenderer$OutputStreamInfo r7 = new androidx.media3.exoplayer.image.ImageRenderer$OutputStreamInfo
            long r0 = r5.largestQueuedPresentationTimeUs
            r7.<init>(r0, r8)
            r6.add(r7)
            return
        L37:
            androidx.media3.exoplayer.image.ImageRenderer$OutputStreamInfo r6 = new androidx.media3.exoplayer.image.ImageRenderer$OutputStreamInfo
            r6.<init>(r0, r8)
            r5.outputStreamInfo = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.image.ImageRenderer.onStreamChanged(androidx.media3.common.Format[], long, long, androidx.media3.exoplayer.source.MediaSource$MediaPeriodId):void");
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void onPositionReset(long j, boolean z) {
        lowerFirstFrameState(1);
        this.outputStreamEnded = false;
        this.inputStreamEnded = false;
        this.outputBitmap = null;
        this.tileInfo = null;
        this.nextTileInfo = null;
        this.readyToOutputTiles = false;
        this.inputBuffer = null;
        ImageDecoder imageDecoder = this.decoder;
        if (imageDecoder != null) {
            imageDecoder.flush();
        }
        this.pendingOutputStreamChanges.clear();
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void onDisabled() {
        this.inputFormat = null;
        this.outputStreamInfo = OutputStreamInfo.UNSET;
        this.pendingOutputStreamChanges.clear();
        releaseDecoderResources();
        this.imageOutput.onDisabled();
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void onReset() {
        releaseDecoderResources();
        lowerFirstFrameState(1);
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void onRelease() {
        releaseDecoderResources();
    }

    @Override // androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.PlayerMessage.Target
    public void handleMessage(int i, Object obj) {
        if (i == 15) {
            setImageOutput(obj instanceof ImageOutput ? (ImageOutput) obj : null);
        } else {
            super.handleMessage(i, obj);
        }
    }

    private boolean drainOutput(long j, long j2) throws ExoPlaybackException {
        Bitmap bitmapCropTileFromImageGrid;
        if (this.outputBitmap != null && this.tileInfo == null) {
            return false;
        }
        if (this.firstFrameState == 0 && getState() != 2) {
            return false;
        }
        if (this.outputBitmap == null) {
            Assertions.checkStateNotNull(this.decoder);
            ImageOutputBuffer imageOutputBufferDequeueOutputBuffer = this.decoder.dequeueOutputBuffer();
            if (imageOutputBufferDequeueOutputBuffer == null) {
                return false;
            }
            if (((ImageOutputBuffer) Assertions.checkStateNotNull(imageOutputBufferDequeueOutputBuffer)).isEndOfStream()) {
                if (this.decoderReinitializationState == 3) {
                    releaseDecoderResources();
                    Assertions.checkStateNotNull(this.inputFormat);
                    maybeInitCodec();
                } else {
                    ((ImageOutputBuffer) Assertions.checkStateNotNull(imageOutputBufferDequeueOutputBuffer)).release();
                    if (this.pendingOutputStreamChanges.isEmpty()) {
                        this.outputStreamEnded = true;
                    }
                }
                return false;
            }
            Assertions.checkStateNotNull(imageOutputBufferDequeueOutputBuffer.bitmap, "Non-EOS buffer came back from the decoder without bitmap.");
            this.outputBitmap = imageOutputBufferDequeueOutputBuffer.bitmap;
            ((ImageOutputBuffer) Assertions.checkStateNotNull(imageOutputBufferDequeueOutputBuffer)).release();
        }
        if (!this.readyToOutputTiles || this.outputBitmap == null || this.tileInfo == null) {
            return false;
        }
        Assertions.checkStateNotNull(this.inputFormat);
        Format format = this.inputFormat;
        int i = format.tileCountHorizontal;
        boolean z = ((i == 1 && format.tileCountVertical == 1) || i == -1 || format.tileCountVertical == -1) ? false : true;
        if (!this.tileInfo.hasTileBitmap()) {
            TileInfo tileInfo = this.tileInfo;
            if (z) {
                bitmapCropTileFromImageGrid = cropTileFromImageGrid(tileInfo.getTileIndex());
            } else {
                bitmapCropTileFromImageGrid = (Bitmap) Assertions.checkStateNotNull(this.outputBitmap);
            }
            tileInfo.setTileBitmap(bitmapCropTileFromImageGrid);
        }
        if (!processOutputBuffer(j, j2, (Bitmap) Assertions.checkStateNotNull(this.tileInfo.getTileBitmap()), this.tileInfo.getPresentationTimeUs())) {
            return false;
        }
        onProcessedOutputBuffer(((TileInfo) Assertions.checkStateNotNull(this.tileInfo)).getPresentationTimeUs());
        this.firstFrameState = 3;
        if (!z || ((TileInfo) Assertions.checkStateNotNull(this.tileInfo)).getTileIndex() == (((Format) Assertions.checkStateNotNull(this.inputFormat)).tileCountVertical * ((Format) Assertions.checkStateNotNull(this.inputFormat)).tileCountHorizontal) - 1) {
            this.outputBitmap = null;
        }
        this.tileInfo = this.nextTileInfo;
        this.nextTileInfo = null;
        return true;
    }

    private boolean shouldForceRender() {
        boolean z = getState() == 2;
        int i = this.firstFrameState;
        if (i == 0) {
            return z;
        }
        if (i == 1) {
            return true;
        }
        if (i == 3) {
            return false;
        }
        throw new IllegalStateException();
    }

    protected boolean processOutputBuffer(long j, long j2, Bitmap bitmap, long j3) {
        long j4 = j3 - j;
        if (!shouldForceRender() && j4 >= HTTPTimeoutManager.DEFAULT_TIMEOUT_MS) {
            return false;
        }
        this.imageOutput.onImageAvailable(j3 - this.outputStreamInfo.streamOffsetUs, bitmap);
        return true;
    }

    private void onProcessedOutputBuffer(long j) {
        this.lastProcessedOutputBufferTimeUs = j;
        while (!this.pendingOutputStreamChanges.isEmpty() && j >= ((OutputStreamInfo) this.pendingOutputStreamChanges.peek()).previousStreamLastBufferTimeUs) {
            this.outputStreamInfo = (OutputStreamInfo) this.pendingOutputStreamChanges.removeFirst();
        }
    }

    private boolean feedInputBuffer(long j) {
        if (this.readyToOutputTiles && this.tileInfo != null) {
            return false;
        }
        FormatHolder formatHolder = getFormatHolder();
        ImageDecoder imageDecoder = this.decoder;
        if (imageDecoder == null || this.decoderReinitializationState == 3 || this.inputStreamEnded) {
            return false;
        }
        if (this.inputBuffer == null) {
            DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) imageDecoder.dequeueInputBuffer();
            this.inputBuffer = decoderInputBuffer;
            if (decoderInputBuffer == null) {
                return false;
            }
        }
        if (this.decoderReinitializationState == 2) {
            Assertions.checkStateNotNull(this.inputBuffer);
            this.inputBuffer.setFlags(4);
            ((ImageDecoder) Assertions.checkStateNotNull(this.decoder)).queueInputBuffer(this.inputBuffer);
            this.inputBuffer = null;
            this.decoderReinitializationState = 3;
            return false;
        }
        int source = readSource(formatHolder, this.inputBuffer, 0);
        if (source == -5) {
            this.inputFormat = (Format) Assertions.checkStateNotNull(formatHolder.format);
            this.codecNeedsInitialization = true;
            this.decoderReinitializationState = 2;
            return true;
        }
        if (source != -4) {
            if (source == -3) {
                return false;
            }
            throw new IllegalStateException();
        }
        this.inputBuffer.flip();
        ByteBuffer byteBuffer = this.inputBuffer.data;
        boolean z = (byteBuffer != null && byteBuffer.remaining() > 0) || ((DecoderInputBuffer) Assertions.checkStateNotNull(this.inputBuffer)).isEndOfStream();
        if (z) {
            ((DecoderInputBuffer) Assertions.checkStateNotNull(this.inputBuffer)).format = this.inputFormat;
            ((ImageDecoder) Assertions.checkStateNotNull(this.decoder)).queueInputBuffer((DecoderInputBuffer) Assertions.checkStateNotNull(this.inputBuffer));
            this.currentTileIndex = 0;
        }
        maybeAdvanceTileInfo(j, (DecoderInputBuffer) Assertions.checkStateNotNull(this.inputBuffer));
        if (((DecoderInputBuffer) Assertions.checkStateNotNull(this.inputBuffer)).isEndOfStream()) {
            this.inputStreamEnded = true;
            this.inputBuffer = null;
            return false;
        }
        this.largestQueuedPresentationTimeUs = Math.max(this.largestQueuedPresentationTimeUs, ((DecoderInputBuffer) Assertions.checkStateNotNull(this.inputBuffer)).timeUs);
        if (z) {
            this.inputBuffer = null;
        } else {
            ((DecoderInputBuffer) Assertions.checkStateNotNull(this.inputBuffer)).clear();
        }
        return !this.readyToOutputTiles;
    }

    private boolean maybeInitCodec() throws ExoPlaybackException {
        if (!maybeInitializeProcessingPipeline()) {
            return false;
        }
        if (!this.codecNeedsInitialization) {
            return true;
        }
        if (canCreateDecoderForFormat((Format) Assertions.checkNotNull(this.inputFormat))) {
            ImageDecoder imageDecoder = this.decoder;
            if (imageDecoder != null) {
                imageDecoder.release();
            }
            this.decoder = this.decoderFactory.createImageDecoder();
            this.codecNeedsInitialization = false;
            return true;
        }
        throw createRendererException(new ImageDecoderException("Provided decoder factory can't create decoder for format."), this.inputFormat, 4005);
    }

    private boolean canCreateDecoderForFormat(Format format) {
        int iSupportsFormat = this.decoderFactory.supportsFormat(format);
        return iSupportsFormat == RendererCapabilities.create(4) || iSupportsFormat == RendererCapabilities.create(3);
    }

    private void lowerFirstFrameState(int i) {
        this.firstFrameState = Math.min(this.firstFrameState, i);
    }

    private void releaseDecoderResources() {
        this.inputBuffer = null;
        this.decoderReinitializationState = 0;
        this.largestQueuedPresentationTimeUs = -9223372036854775807L;
        ImageDecoder imageDecoder = this.decoder;
        if (imageDecoder != null) {
            imageDecoder.release();
            this.decoder = null;
        }
    }

    private void setImageOutput(ImageOutput imageOutput) {
        this.imageOutput = getImageOutput(imageOutput);
    }

    private void maybeAdvanceTileInfo(long j, DecoderInputBuffer decoderInputBuffer) {
        boolean z = true;
        if (decoderInputBuffer.isEndOfStream()) {
            this.readyToOutputTiles = true;
            return;
        }
        TileInfo tileInfo = new TileInfo(this.currentTileIndex, decoderInputBuffer.timeUs);
        this.nextTileInfo = tileInfo;
        this.currentTileIndex++;
        if (!this.readyToOutputTiles) {
            long presentationTimeUs = tileInfo.getPresentationTimeUs();
            boolean z2 = presentationTimeUs - HTTPTimeoutManager.DEFAULT_TIMEOUT_MS <= j && j <= HTTPTimeoutManager.DEFAULT_TIMEOUT_MS + presentationTimeUs;
            TileInfo tileInfo2 = this.tileInfo;
            boolean z3 = tileInfo2 != null && tileInfo2.getPresentationTimeUs() <= j && j < presentationTimeUs;
            boolean zIsTileLastInGrid = isTileLastInGrid((TileInfo) Assertions.checkStateNotNull(this.nextTileInfo));
            if (!z2 && !z3 && !zIsTileLastInGrid) {
                z = false;
            }
            this.readyToOutputTiles = z;
            if (z3 && !z2) {
                return;
            }
        }
        this.tileInfo = this.nextTileInfo;
        this.nextTileInfo = null;
    }

    private boolean isTileLastInGrid(TileInfo tileInfo) {
        return ((Format) Assertions.checkStateNotNull(this.inputFormat)).tileCountHorizontal == -1 || this.inputFormat.tileCountVertical == -1 || tileInfo.getTileIndex() == (((Format) Assertions.checkStateNotNull(this.inputFormat)).tileCountVertical * this.inputFormat.tileCountHorizontal) - 1;
    }

    private Bitmap cropTileFromImageGrid(int i) {
        Assertions.checkStateNotNull(this.outputBitmap);
        int width = this.outputBitmap.getWidth() / ((Format) Assertions.checkStateNotNull(this.inputFormat)).tileCountHorizontal;
        int height = this.outputBitmap.getHeight() / ((Format) Assertions.checkStateNotNull(this.inputFormat)).tileCountVertical;
        int i2 = this.inputFormat.tileCountHorizontal;
        return Bitmap.createBitmap(this.outputBitmap, (i % i2) * width, (i / i2) * height, width, height);
    }

    private static ImageOutput getImageOutput(ImageOutput imageOutput) {
        return imageOutput == null ? ImageOutput.NO_OP : imageOutput;
    }

    private static class TileInfo {
        private final long presentationTimeUs;
        private Bitmap tileBitmap;
        private final int tileIndex;

        public TileInfo(int i, long j) {
            this.tileIndex = i;
            this.presentationTimeUs = j;
        }

        public int getTileIndex() {
            return this.tileIndex;
        }

        public long getPresentationTimeUs() {
            return this.presentationTimeUs;
        }

        public Bitmap getTileBitmap() {
            return this.tileBitmap;
        }

        public void setTileBitmap(Bitmap bitmap) {
            this.tileBitmap = bitmap;
        }

        public boolean hasTileBitmap() {
            return this.tileBitmap != null;
        }
    }

    private static final class OutputStreamInfo {
        public static final OutputStreamInfo UNSET = new OutputStreamInfo(-9223372036854775807L, -9223372036854775807L);
        public final long previousStreamLastBufferTimeUs;
        public final long streamOffsetUs;

        public OutputStreamInfo(long j, long j2) {
            this.previousStreamLastBufferTimeUs = j;
            this.streamOffsetUs = j2;
        }
    }
}
