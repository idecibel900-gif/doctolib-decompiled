package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import android.os.Build;
import androidx.core.util.Pools$Pool;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.DecodeBufferHelper;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.common.streams.LimitedInputStream;
import com.facebook.common.streams.TailAppendingInputStream;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imagepipeline.memory.DummyBitmapPool;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DefaultDecoder implements PlatformDecoder {
    private boolean mAvoidPoolGet;
    private boolean mAvoidPoolRelease;
    private final BitmapPool mBitmapPool;
    final Pools$Pool mDecodeBuffers;
    private final PreverificationHelper mPreverificationHelper;
    private static final Class TAG = DefaultDecoder.class;
    private static final byte[] EOI_TAIL = {-1, -39};

    public abstract int getBitmapSize(int i, int i2, BitmapFactory.Options options);

    public DefaultDecoder(BitmapPool bitmapPool, Pools$Pool pools$Pool, PlatformDecoderOptions platformDecoderOptions) {
        this.mPreverificationHelper = Build.VERSION.SDK_INT >= 26 ? new PreverificationHelper() : null;
        this.mBitmapPool = bitmapPool;
        if (bitmapPool instanceof DummyBitmapPool) {
            this.mAvoidPoolGet = platformDecoderOptions.getAvoidPoolGet();
            this.mAvoidPoolRelease = platformDecoderOptions.getAvoidPoolRelease();
        }
        this.mDecodeBuffers = pools$Pool;
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference decodeFromEncodedImageWithColorSpace(EncodedImage encodedImage, Bitmap.Config config, Rect rect, ColorSpace colorSpace) {
        BitmapFactory.Options decodeOptionsForStream = getDecodeOptionsForStream(encodedImage, config, this.mAvoidPoolGet);
        boolean z = decodeOptionsForStream.inPreferredConfig != Bitmap.Config.ARGB_8888;
        try {
            return decodeFromStream((InputStream) Preconditions.checkNotNull(encodedImage.getInputStream()), decodeOptionsForStream, rect, colorSpace);
        } catch (RuntimeException e) {
            if (z) {
                return decodeFromEncodedImageWithColorSpace(encodedImage, Bitmap.Config.ARGB_8888, rect, colorSpace);
            }
            throw e;
        }
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference decodeJPEGFromEncodedImageWithColorSpace(EncodedImage encodedImage, Bitmap.Config config, Rect rect, int i, ColorSpace colorSpace) {
        boolean zIsCompleteAt = encodedImage.isCompleteAt(i);
        BitmapFactory.Options decodeOptionsForStream = getDecodeOptionsForStream(encodedImage, config, this.mAvoidPoolGet);
        InputStream inputStream = encodedImage.getInputStream();
        Preconditions.checkNotNull(inputStream);
        if (encodedImage.getSize() > i) {
            inputStream = new LimitedInputStream(inputStream, i);
        }
        if (!zIsCompleteAt) {
            inputStream = new TailAppendingInputStream(inputStream, EOI_TAIL);
        }
        boolean z = decodeOptionsForStream.inPreferredConfig != Bitmap.Config.ARGB_8888;
        try {
            try {
                CloseableReference closeableReferenceDecodeFromStream = decodeFromStream(inputStream, decodeOptionsForStream, rect, colorSpace);
                try {
                    inputStream.close();
                    return closeableReferenceDecodeFromStream;
                } catch (IOException e) {
                    e.printStackTrace();
                    return closeableReferenceDecodeFromStream;
                }
            } catch (Throwable th) {
                try {
                    inputStream.close();
                    throw th;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    throw th;
                }
            }
        } catch (RuntimeException e3) {
            if (z) {
                CloseableReference closeableReferenceDecodeJPEGFromEncodedImageWithColorSpace = decodeJPEGFromEncodedImageWithColorSpace(encodedImage, Bitmap.Config.ARGB_8888, rect, i, colorSpace);
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                return closeableReferenceDecodeJPEGFromEncodedImageWithColorSpace;
            }
            throw e3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x005e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:31:0x0060  */
    /* JADX WARN: Code duplicated, block: B:35:0x0075  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c7 A[Catch: all -> 0x00a3, RuntimeException -> 0x00a6, IllegalArgumentException -> 0x00a8, TRY_LEAVE, TryCatch #8 {IllegalArgumentException -> 0x00a8, RuntimeException -> 0x00a6, blocks: (B:36:0x007d, B:39:0x0087, B:49:0x009f, B:68:0x00c7, B:64:0x00c0, B:65:0x00c3, B:62:0x00ba), top: B:98:0x007d, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:81:0x00f1  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private CloseableReference decodeFromStream(InputStream inputStream, BitmapFactory.Options options, Rect rect, ColorSpace colorSpace) {
        Bitmap bitmap;
        Bitmap bitmap2;
        ByteBuffer byteBufferAllocate;
        Bitmap bitmapDecodeStream;
        BitmapRegionDecoder bitmapRegionDecoderNewInstance;
        PreverificationHelper preverificationHelper;
        Preconditions.checkNotNull(inputStream);
        int i = options.outWidth;
        int iHeight = options.outHeight;
        ?? r0 = i;
        if (rect != null) {
            int iWidth = rect.width() / options.inSampleSize;
            iHeight = rect.height() / options.inSampleSize;
            r0 = iWidth;
        }
        int i2 = Build.VERSION.SDK_INT;
        boolean z = i2 >= 26 && (preverificationHelper = this.mPreverificationHelper) != null && preverificationHelper.shouldUseHardwareBitmapConfig(options.inPreferredConfig);
        BitmapRegionDecoder bitmapRegionDecoder = 0;
        try {
            try {
                if (rect == null && z) {
                    options.inMutable = false;
                } else {
                    if (rect != null && z) {
                        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                    }
                    if (!this.mAvoidPoolGet) {
                        bitmap = (Bitmap) this.mBitmapPool.get(getBitmapSize(r0, iHeight, options));
                        if (bitmap == null) {
                            bitmap2 = bitmap;
                            throw new NullPointerException("BitmapPool.get returned null");
                        }
                    }
                    bitmap2 = bitmap;
                    options.inBitmap = bitmap2;
                    if (i2 >= 26) {
                        if (colorSpace == null) {
                            colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
                        }
                        options.inPreferredColorSpace = colorSpace;
                    }
                    byteBufferAllocate = (ByteBuffer) this.mDecodeBuffers.acquire();
                    if (byteBufferAllocate == null) {
                        byteBufferAllocate = ByteBuffer.allocate(DecodeBufferHelper.getRecommendedDecodeBufferSize());
                    }
                    options.inTempStorage = byteBufferAllocate.array();
                    if (rect != null || bitmap2 == 0) {
                        bitmapDecodeStream = null;
                    } else {
                        Bitmap.Config config = options.inPreferredConfig;
                        try {
                            if (config != null) {
                                try {
                                    bitmap2.reconfigure(r0, iHeight, config);
                                    bitmapRegionDecoderNewInstance = BitmapRegionDecoder.newInstance(inputStream, true);
                                    if (bitmapRegionDecoderNewInstance != null) {
                                        try {
                                            bitmapDecodeStream = bitmapRegionDecoderNewInstance.decodeRegion(rect, options);
                                        } catch (IOException unused) {
                                            FLog.e(TAG, "Could not decode region %s, decoding full bitmap instead.", rect);
                                            if (bitmapRegionDecoderNewInstance != null) {
                                                bitmapRegionDecoderNewInstance.recycle();
                                            }
                                            bitmapDecodeStream = null;
                                        }
                                    } else {
                                        bitmapDecodeStream = null;
                                    }
                                    if (bitmapRegionDecoderNewInstance != null) {
                                        bitmapRegionDecoderNewInstance.recycle();
                                    }
                                } catch (IOException unused2) {
                                    bitmapRegionDecoderNewInstance = null;
                                } catch (Throwable th) {
                                    th = th;
                                    if (bitmapRegionDecoder != 0) {
                                        bitmapRegionDecoder.recycle();
                                    }
                                    throw th;
                                }
                            } else {
                                bitmapDecodeStream = null;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            bitmapRegionDecoder = r0;
                        }
                    }
                    if (bitmapDecodeStream == null) {
                        bitmapDecodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                    }
                    this.mDecodeBuffers.release(byteBufferAllocate);
                    if (bitmap2 == 0 && bitmap2 != bitmapDecodeStream) {
                        this.mBitmapPool.release(bitmap2);
                        if (bitmapDecodeStream != null) {
                            bitmapDecodeStream.recycle();
                        }
                        throw new IllegalStateException();
                    }
                    if (this.mAvoidPoolRelease) {
                        return CloseableReference.of(bitmapDecodeStream, NoOpResourceReleaser.INSTANCE);
                    }
                    return CloseableReference.of(bitmapDecodeStream, this.mBitmapPool);
                }
                options.inTempStorage = byteBufferAllocate.array();
                if (rect != null) {
                    bitmapDecodeStream = null;
                } else {
                    bitmapDecodeStream = null;
                }
                if (bitmapDecodeStream == null) {
                    bitmapDecodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                }
                this.mDecodeBuffers.release(byteBufferAllocate);
                if (bitmap2 == 0) {
                }
                if (this.mAvoidPoolRelease) {
                    return CloseableReference.of(bitmapDecodeStream, NoOpResourceReleaser.INSTANCE);
                }
                return CloseableReference.of(bitmapDecodeStream, this.mBitmapPool);
            } catch (Throwable th3) {
                this.mDecodeBuffers.release(byteBufferAllocate);
                throw th3;
            }
        } catch (IllegalArgumentException e) {
            if (bitmap2 != 0) {
                this.mBitmapPool.release(bitmap2);
            }
            try {
                inputStream.reset();
                Bitmap bitmapDecodeStream2 = BitmapFactory.decodeStream(inputStream);
                if (bitmapDecodeStream2 == null) {
                    throw e;
                }
                CloseableReference closeableReferenceOf = CloseableReference.of(bitmapDecodeStream2, SimpleBitmapReleaser.getInstance());
                this.mDecodeBuffers.release(byteBufferAllocate);
                return closeableReferenceOf;
            } catch (IOException unused3) {
                throw e;
            }
        } catch (RuntimeException e2) {
            if (bitmap2 != 0) {
                this.mBitmapPool.release(bitmap2);
            }
            throw e2;
        }
        bitmap2 = 0;
        bitmap2 = bitmap;
        options.inBitmap = bitmap2;
        if (i2 >= 26) {
            if (colorSpace == null) {
                colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            }
            options.inPreferredColorSpace = colorSpace;
        }
        byteBufferAllocate = (ByteBuffer) this.mDecodeBuffers.acquire();
        if (byteBufferAllocate == null) {
            byteBufferAllocate = ByteBuffer.allocate(DecodeBufferHelper.getRecommendedDecodeBufferSize());
        }
    }

    private static BitmapFactory.Options getDecodeOptionsForStream(EncodedImage encodedImage, Bitmap.Config config, boolean z) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = encodedImage.getSampleSize();
        options.inJustDecodeBounds = true;
        options.inDither = true;
        boolean z2 = Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE;
        if (!z2) {
            options.inPreferredConfig = config;
        }
        options.inMutable = true;
        if (!z) {
            BitmapFactory.decodeStream(encodedImage.getInputStream(), null, options);
            if (options.outWidth == -1 || options.outHeight == -1) {
                throw new IllegalArgumentException();
            }
        }
        if (z2) {
            options.inPreferredConfig = config;
        }
        options.inJustDecodeBounds = false;
        return options;
    }

    private static final class NoOpResourceReleaser implements ResourceReleaser {
        private static final NoOpResourceReleaser INSTANCE = new NoOpResourceReleaser();

        @Override // com.facebook.common.references.ResourceReleaser
        public void release(Bitmap bitmap) {
        }

        private NoOpResourceReleaser() {
        }
    }
}
