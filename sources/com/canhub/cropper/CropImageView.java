package com.canhub.cropper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import java.lang.ref.WeakReference;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000¢\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 \u0099\u00022\u00020\u00012\u00020\u0002:\u0018\u009a\u0002\u009b\u0002\u009c\u0002\u009d\u0002\u009e\u0002\u009f\u0002 \u0002¡\u0002¢\u0002£\u0002¤\u0002\u0099\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ;\u0010\u0012\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ/\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0011H\u0002¢\u0006\u0004\b!\u0010\u0015J\u000f\u0010\"\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\"\u0010\u0015J\u000f\u0010#\u001a\u00020\u0011H\u0002¢\u0006\u0004\b#\u0010\u0015J\u0017\u0010%\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u0016H\u0002¢\u0006\u0004\b%\u0010&J\u0015\u0010(\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u0016¢\u0006\u0004\b(\u0010&J\u0015\u0010*\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u0016¢\u0006\u0004\b*\u0010&J\u0015\u0010,\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u0016¢\u0006\u0004\b,\u0010&J\u0015\u0010/\u001a\u00020\u00112\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b/\u00100J\u0015\u00102\u001a\u00020\u00112\u0006\u00101\u001a\u00020\u001b¢\u0006\u0004\b2\u00103J/\u00107\u001a\u0004\u0018\u00010\t2\b\b\u0002\u00104\u001a\u00020\u000b2\b\b\u0002\u00105\u001a\u00020\u000b2\b\b\u0002\u0010.\u001a\u000206H\u0007¢\u0006\u0004\b7\u00108JK\u0010=\u001a\u00020\u00112\b\b\u0002\u0010:\u001a\u0002092\b\b\u0002\u0010;\u001a\u00020\u000b2\b\b\u0002\u00104\u001a\u00020\u000b2\b\b\u0002\u00105\u001a\u00020\u000b2\b\b\u0002\u0010.\u001a\u0002062\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b=\u0010>J\u0017\u0010A\u001a\u00020\u00112\b\u0010@\u001a\u0004\u0018\u00010?¢\u0006\u0004\bA\u0010BJ\u0017\u0010D\u001a\u00020\u00112\b\u0010@\u001a\u0004\u0018\u00010C¢\u0006\u0004\bD\u0010EJ\u0017\u0010G\u001a\u00020\u00112\b\u0010@\u001a\u0004\u0018\u00010F¢\u0006\u0004\bG\u0010HJ\u0017\u0010J\u001a\u00020\u00112\b\u0010@\u001a\u0004\u0018\u00010I¢\u0006\u0004\bJ\u0010KJ\u0017\u0010M\u001a\u00020\u00112\b\u0010@\u001a\u0004\u0018\u00010L¢\u0006\u0004\bM\u0010NJ\u0017\u0010O\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\bO\u0010PJ\u0017\u0010R\u001a\u00020\u00112\b\u0010Q\u001a\u0004\u0018\u00010\r¢\u0006\u0004\bR\u0010SJ\u0015\u0010U\u001a\u00020\u00112\u0006\u0010T\u001a\u00020\u000b¢\u0006\u0004\bU\u0010VJ\r\u0010W\u001a\u00020\u0011¢\u0006\u0004\bW\u0010\u0015J\r\u0010X\u001a\u00020\u0011¢\u0006\u0004\bX\u0010\u0015J\u0017\u0010]\u001a\u00020\u00112\u0006\u0010Z\u001a\u00020YH\u0000¢\u0006\u0004\b[\u0010\\J\u0017\u0010a\u001a\u00020\u00112\u0006\u0010Z\u001a\u00020^H\u0000¢\u0006\u0004\b_\u0010`J?\u0010b\u001a\u00020\u00112\u0006\u00104\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000b2\u0006\u0010.\u001a\u0002062\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020\u000b2\b\u0010<\u001a\u0004\u0018\u00010\r¢\u0006\u0004\bb\u0010cJ\u0011\u0010e\u001a\u0004\u0018\u00010dH\u0016¢\u0006\u0004\be\u0010fJ\u0017\u0010h\u001a\u00020\u00112\u0006\u0010g\u001a\u00020dH\u0016¢\u0006\u0004\bh\u0010iJ\u001f\u0010l\u001a\u00020\u00112\u0006\u0010j\u001a\u00020\u000b2\u0006\u0010k\u001a\u00020\u000bH\u0014¢\u0006\u0004\bl\u0010mJ7\u0010s\u001a\u00020\u00112\u0006\u0010n\u001a\u00020\u00162\u0006\u0010o\u001a\u00020\u000b2\u0006\u0010p\u001a\u00020\u000b2\u0006\u0010q\u001a\u00020\u000b2\u0006\u0010r\u001a\u00020\u000bH\u0014¢\u0006\u0004\bs\u0010tJ/\u0010y\u001a\u00020\u00112\u0006\u0010u\u001a\u00020\u000b2\u0006\u0010v\u001a\u00020\u000b2\u0006\u0010w\u001a\u00020\u000b2\u0006\u0010x\u001a\u00020\u000bH\u0014¢\u0006\u0004\by\u0010zJ\u0017\u0010{\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b{\u0010&R\u0014\u0010}\u001a\u00020|8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b}\u0010~R\u0019\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u007f8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0018\u0010\u0083\u0001\u001a\u00030\u0082\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0018\u0010\u0085\u0001\u001a\u00030\u0082\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0084\u0001R\u0018\u0010\u0087\u0001\u001a\u00030\u0086\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0018\u0010\u008a\u0001\u001a\u00030\u0089\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0018\u0010\u008c\u0001\u001a\u00030\u0089\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008b\u0001R\u001c\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008d\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001b\u0010\u0090\u0001\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R\u0019\u0010\u0092\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0019\u0010\u0094\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0093\u0001R\u0019\u0010\u0095\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u0019\u0010\u0097\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0096\u0001R\u0019\u0010\u0098\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0093\u0001R\u0019\u0010\u0099\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u0093\u0001R\u0019\u0010\u009a\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u0093\u0001R\u001a\u0010\u009c\u0001\u001a\u00030\u009b\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001R/\u0010\u009e\u0001\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u001e\n\u0006\b\u009e\u0001\u0010\u0096\u0001\u0012\u0005\b¡\u0001\u0010\u0015\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001\"\u0005\b \u0001\u0010&R\u0019\u0010¢\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0001\u0010\u0096\u0001R\u0019\u0010£\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0001\u0010\u0096\u0001R\u001a\u0010¥\u0001\u001a\u00030¤\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001R\u0019\u0010§\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R\u0019\u0010©\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b©\u0001\u0010\u0093\u0001R\u0019\u0010ª\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0001\u0010\u0096\u0001R\u0019\u0010«\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0001\u0010\u0096\u0001R\u0019\u0010¬\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0001\u0010\u0093\u0001R\u001b\u0010\u00ad\u0001\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u00ad\u0001\u0010®\u0001R\u001b\u0010¯\u0001\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010°\u0001R,\u0010\u000e\u001a\u0004\u0018\u00010\r2\t\u0010±\u0001\u001a\u0004\u0018\u00010\r8\u0006@BX\u0086\u000e¢\u0006\u000f\n\u0005\b\u000e\u0010²\u0001\u001a\u0006\b³\u0001\u0010´\u0001R\u0019\u0010µ\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bµ\u0001\u0010\u0093\u0001R\u0019\u0010¶\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¶\u0001\u0010¨\u0001R\u0019\u0010·\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b·\u0001\u0010¨\u0001R\u0019\u0010¸\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¸\u0001\u0010¨\u0001R\u001c\u0010º\u0001\u001a\u0005\u0018\u00010¹\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bº\u0001\u0010»\u0001R\u0019\u0010¼\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¼\u0001\u0010\u0093\u0001R\u0019\u0010½\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b½\u0001\u0010\u0096\u0001R#\u0010À\u0001\u001a\f\u0012\u0005\u0012\u00030¿\u0001\u0018\u00010¾\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÀ\u0001\u0010Á\u0001R#\u0010Ã\u0001\u001a\f\u0012\u0005\u0012\u00030Â\u0001\u0018\u00010¾\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÃ\u0001\u0010Á\u0001R(\u0010<\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b<\u0010²\u0001\u001a\u0006\bÄ\u0001\u0010´\u0001\"\u0005\bÅ\u0001\u0010SR,\u0010Æ\u0001\u001a\u00030\u009b\u00012\b\u0010Æ\u0001\u001a\u00030\u009b\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bÇ\u0001\u0010È\u0001\"\u0006\bÉ\u0001\u0010Ê\u0001R0\u0010Ì\u0001\u001a\u0005\u0018\u00010Ë\u00012\n\u0010Ì\u0001\u001a\u0005\u0018\u00010Ë\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bÍ\u0001\u0010Î\u0001\"\u0006\bÏ\u0001\u0010Ð\u0001R0\u0010Ò\u0001\u001a\u0005\u0018\u00010Ñ\u00012\n\u0010Ò\u0001\u001a\u0005\u0018\u00010Ñ\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bÓ\u0001\u0010Ô\u0001\"\u0006\bÕ\u0001\u0010Ö\u0001R)\u0010Ø\u0001\u001a\u00020\u00162\u0007\u0010×\u0001\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\u000f\u001a\u0006\bØ\u0001\u0010\u009f\u0001\"\u0005\bÙ\u0001\u0010&R)\u0010Ú\u0001\u001a\u00020\u000b2\u0007\u0010Ú\u0001\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0006\bÛ\u0001\u0010Ü\u0001\"\u0005\bÝ\u0001\u0010VR(\u0010à\u0001\u001a\u00020\u000b2\u0006\u0010T\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0006\bÞ\u0001\u0010Ü\u0001\"\u0005\bß\u0001\u0010VR)\u0010â\u0001\u001a\u00020\u00162\u0007\u0010á\u0001\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\u000f\u001a\u0006\bâ\u0001\u0010\u009f\u0001\"\u0005\bã\u0001\u0010&R)\u0010å\u0001\u001a\u00020\u00162\u0007\u0010ä\u0001\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\u000f\u001a\u0006\bå\u0001\u0010\u009f\u0001\"\u0005\bæ\u0001\u0010&R0\u0010è\u0001\u001a\u0005\u0018\u00010ç\u00012\n\u0010è\u0001\u001a\u0005\u0018\u00010ç\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bé\u0001\u0010ê\u0001\"\u0006\bë\u0001\u0010ì\u0001R!\u0010ð\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0í\u00018F¢\u0006\b\u001a\u0006\bî\u0001\u0010ï\u0001R)\u0010ò\u0001\u001a\u00020\u00162\u0007\u0010ñ\u0001\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\u000f\u001a\u0006\bò\u0001\u0010\u009f\u0001\"\u0005\bó\u0001\u0010&R)\u0010õ\u0001\u001a\u00020\u00162\u0007\u0010ô\u0001\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\u000f\u001a\u0006\bõ\u0001\u0010\u009f\u0001\"\u0005\bö\u0001\u0010&R)\u0010ø\u0001\u001a\u00020\u00162\u0007\u0010÷\u0001\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\u000f\u001a\u0006\bø\u0001\u0010\u009f\u0001\"\u0005\bù\u0001\u0010&R,\u0010ú\u0001\u001a\u00030¤\u00012\b\u0010ú\u0001\u001a\u00030¤\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bû\u0001\u0010ü\u0001\"\u0006\bý\u0001\u0010þ\u0001R)\u0010\u0083\u0002\u001a\u00020\u001b2\u0007\u0010ÿ\u0001\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0006\b\u0080\u0002\u0010\u0081\u0002\"\u0005\b\u0082\u0002\u00103R)\u0010\u0084\u0002\u001a\u00020\u000b2\u0007\u0010\u0084\u0002\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0006\b\u0085\u0002\u0010Ü\u0001\"\u0005\b\u0086\u0002\u0010VR(\u0010\f\u001a\u00020\u000b2\u0007\u0010\u0087\u0002\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0006\b\u0088\u0002\u0010Ü\u0001\"\u0005\b\u0089\u0002\u0010VR\u0017\u0010\u008d\u0002\u001a\u0005\u0018\u00010\u008a\u00028F¢\u0006\b\u001a\u0006\b\u008b\u0002\u0010\u008c\u0002R0\u0010\u0092\u0002\u001a\u0005\u0018\u00010\u008a\u00022\n\u0010\u008e\u0002\u001a\u0005\u0018\u00010\u008a\u00028F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u008f\u0002\u0010\u008c\u0002\"\u0006\b\u0090\u0002\u0010\u0091\u0002R\u0017\u0010\u0095\u0002\u001a\u0005\u0018\u00010¹\u00018F¢\u0006\b\u001a\u0006\b\u0093\u0002\u0010\u0094\u0002R\u0015\u0010\u0098\u0002\u001a\u00030\u0089\u00018F¢\u0006\b\u001a\u0006\b\u0096\u0002\u0010\u0097\u0002¨\u0006¥\u0002"}, d2 = {"Lcom/canhub/cropper/CropImageView;", "Landroid/widget/FrameLayout;", "Lcom/canhub/cropper/CropOverlayView$CropWindowChangeListener;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/graphics/Bitmap;", "bitmap", "", "imageResource", "Landroid/net/Uri;", "imageUri", "loadSampleSize", "degreesRotated", "", "setBitmap", "(Landroid/graphics/Bitmap;ILandroid/net/Uri;II)V", "clearImageInt", "()V", "", "inProgress", "animate", "handleCropWindowChanged", "(ZZ)V", "", "width", "height", "center", "applyImageMatrix", "(FFZZ)V", "mapImagePointsByImageMatrix", "setCropOverlayVisibility", "setProgressBarVisibility", "clear", "updateImageBounds", "(Z)V", "multiTouchEnabled", "setMultiTouchEnabled", "centerMoveEnabled", "setCenterMoveEnabled", "fixAspectRatio", "setFixedAspectRatio", "Lcom/canhub/cropper/CropImageOptions;", "options", "setImageCropOptions", "(Lcom/canhub/cropper/CropImageOptions;)V", "snapRadius", "setSnapRadius", "(F)V", "reqWidth", "reqHeight", "Lcom/canhub/cropper/CropImageView$RequestSizeOptions;", "getCroppedImage", "(IILcom/canhub/cropper/CropImageView$RequestSizeOptions;)Landroid/graphics/Bitmap;", "Landroid/graphics/Bitmap$CompressFormat;", "saveCompressFormat", "saveCompressQuality", "customOutputUri", "croppedImageAsync", "(Landroid/graphics/Bitmap$CompressFormat;IIILcom/canhub/cropper/CropImageView$RequestSizeOptions;Landroid/net/Uri;)V", "Lcom/canhub/cropper/CropImageView$OnSetCropOverlayReleasedListener;", "listener", "setOnSetCropOverlayReleasedListener", "(Lcom/canhub/cropper/CropImageView$OnSetCropOverlayReleasedListener;)V", "Lcom/canhub/cropper/CropImageView$OnSetCropOverlayMovedListener;", "setOnSetCropOverlayMovedListener", "(Lcom/canhub/cropper/CropImageView$OnSetCropOverlayMovedListener;)V", "Lcom/canhub/cropper/CropImageView$OnSetCropWindowChangeListener;", "setOnCropWindowChangedListener", "(Lcom/canhub/cropper/CropImageView$OnSetCropWindowChangeListener;)V", "Lcom/canhub/cropper/CropImageView$OnSetImageUriCompleteListener;", "setOnSetImageUriCompleteListener", "(Lcom/canhub/cropper/CropImageView$OnSetImageUriCompleteListener;)V", "Lcom/canhub/cropper/CropImageView$OnCropImageCompleteListener;", "setOnCropImageCompleteListener", "(Lcom/canhub/cropper/CropImageView$OnCropImageCompleteListener;)V", "setImageBitmap", "(Landroid/graphics/Bitmap;)V", "uri", "setImageUriAsync", "(Landroid/net/Uri;)V", "degrees", "rotateImage", "(I)V", "flipImageHorizontally", "flipImageVertically", "Lcom/canhub/cropper/BitmapLoadingWorkerJob$Result;", "result", "onSetImageUriAsyncComplete$cropper_release", "(Lcom/canhub/cropper/BitmapLoadingWorkerJob$Result;)V", "onSetImageUriAsyncComplete", "Lcom/canhub/cropper/BitmapCroppingWorkerJob$Result;", "onImageCroppingAsyncComplete$cropper_release", "(Lcom/canhub/cropper/BitmapCroppingWorkerJob$Result;)V", "onImageCroppingAsyncComplete", "startCropWorkerTask", "(IILcom/canhub/cropper/CropImageView$RequestSizeOptions;Landroid/graphics/Bitmap$CompressFormat;ILandroid/net/Uri;)V", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", "state", "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "l", "t", "r", "b", "onLayout", "(ZIIII)V", "w", "h", "oldw", "oldh", "onSizeChanged", "(IIII)V", "onCropWindowChanged", "Landroid/widget/ImageView;", "imageView", "Landroid/widget/ImageView;", "Lcom/canhub/cropper/CropOverlayView;", "mCropOverlayView", "Lcom/canhub/cropper/CropOverlayView;", "Landroid/graphics/Matrix;", "mImageMatrix", "Landroid/graphics/Matrix;", "mImageInverseMatrix", "Landroid/widget/ProgressBar;", "mProgressBar", "Landroid/widget/ProgressBar;", "", "mImagePoints", "[F", "mScaleImagePoints", "Lcom/canhub/cropper/CropImageAnimation;", "mAnimation", "Lcom/canhub/cropper/CropImageAnimation;", "originalBitmap", "Landroid/graphics/Bitmap;", "mInitialDegreesRotated", "I", "mDegreesRotated", "mFlipHorizontally", "Z", "mFlipVertically", "mLayoutWidth", "mLayoutHeight", "mImageResource", "Lcom/canhub/cropper/CropImageView$ScaleType;", "mScaleType", "Lcom/canhub/cropper/CropImageView$ScaleType;", "isSaveBitmapToInstanceState", "()Z", "setSaveBitmapToInstanceState", "isSaveBitmapToInstanceState$annotations", "mShowCropOverlay", "mShowCropLabel", "", "mCropTextLabel", "Ljava/lang/String;", "mCropLabelTextSize", "F", "mCropLabelTextColor", "mShowProgressBar", "mAutoZoomEnabled", "mMaxZoom", "mOnSetImageUriCompleteListener", "Lcom/canhub/cropper/CropImageView$OnSetImageUriCompleteListener;", "mOnCropImageCompleteListener", "Lcom/canhub/cropper/CropImageView$OnCropImageCompleteListener;", "value", "Landroid/net/Uri;", "getImageUri", "()Landroid/net/Uri;", "loadedSampleSize", "mZoom", "mZoomOffsetX", "mZoomOffsetY", "Landroid/graphics/RectF;", "mRestoreCropWindowRect", "Landroid/graphics/RectF;", "mRestoreDegreesRotated", "mSizeChanged", "Ljava/lang/ref/WeakReference;", "Lcom/canhub/cropper/BitmapLoadingWorkerJob;", "bitmapLoadingWorkerJob", "Ljava/lang/ref/WeakReference;", "Lcom/canhub/cropper/BitmapCroppingWorkerJob;", "bitmapCroppingWorkerJob", "getCustomOutputUri", "setCustomOutputUri", "scaleType", "getScaleType", "()Lcom/canhub/cropper/CropImageView$ScaleType;", "setScaleType", "(Lcom/canhub/cropper/CropImageView$ScaleType;)V", "Lcom/canhub/cropper/CropImageView$CropShape;", "cropShape", "getCropShape", "()Lcom/canhub/cropper/CropImageView$CropShape;", "setCropShape", "(Lcom/canhub/cropper/CropImageView$CropShape;)V", "Lcom/canhub/cropper/CropImageView$CropCornerShape;", "cornerShape", "getCornerShape", "()Lcom/canhub/cropper/CropImageView$CropCornerShape;", "setCornerShape", "(Lcom/canhub/cropper/CropImageView$CropCornerShape;)V", "autoZoomEnabled", "isAutoZoomEnabled", "setAutoZoomEnabled", "maxZoom", "getMaxZoom", "()I", "setMaxZoom", "getRotatedDegrees", "setRotatedDegrees", "rotatedDegrees", "flipHorizontally", "isFlippedHorizontally", "setFlippedHorizontally", "flipVertically", "isFlippedVertically", "setFlippedVertically", "Lcom/canhub/cropper/CropImageView$Guidelines;", "guidelines", "getGuidelines", "()Lcom/canhub/cropper/CropImageView$Guidelines;", "setGuidelines", "(Lcom/canhub/cropper/CropImageView$Guidelines;)V", "Landroid/util/Pair;", "getAspectRatio", "()Landroid/util/Pair;", "aspectRatio", "showProgressBar", "isShowProgressBar", "setShowProgressBar", "showCropOverlay", "isShowCropOverlay", "setShowCropOverlay", "showCropLabel", "isShowCropLabel", "setShowCropLabel", "cropLabelText", "getCropLabelText", "()Ljava/lang/String;", "setCropLabelText", "(Ljava/lang/String;)V", "textSize", "getCropLabelTextSize", "()F", "setCropLabelTextSize", "cropLabelTextSize", "cropLabelTextColor", "getCropLabelTextColor", "setCropLabelTextColor", "resId", "getImageResource", "setImageResource", "Landroid/graphics/Rect;", "getWholeImageRect", "()Landroid/graphics/Rect;", "wholeImageRect", "rect", "getCropRect", "setCropRect", "(Landroid/graphics/Rect;)V", "cropRect", "getCropWindowRect", "()Landroid/graphics/RectF;", "cropWindowRect", "getCropPoints", "()[F", "cropPoints", "Companion", "CropShape", "CropCornerShape", "ScaleType", "Guidelines", "RequestSizeOptions", "OnSetCropOverlayReleasedListener", "OnSetCropOverlayMovedListener", "OnSetCropWindowChangeListener", "OnSetImageUriCompleteListener", "OnCropImageCompleteListener", "CropResult", "cropper_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CropImageView extends FrameLayout implements CropOverlayView.CropWindowChangeListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private WeakReference bitmapCroppingWorkerJob;
    private WeakReference bitmapLoadingWorkerJob;
    private Uri customOutputUri;
    private Uri imageUri;
    private final ImageView imageView;
    private boolean isSaveBitmapToInstanceState;
    private int loadedSampleSize;
    private CropImageAnimation mAnimation;
    private boolean mAutoZoomEnabled;
    private int mCropLabelTextColor;
    private float mCropLabelTextSize;
    private final CropOverlayView mCropOverlayView;
    private String mCropTextLabel;
    private int mDegreesRotated;
    private boolean mFlipHorizontally;
    private boolean mFlipVertically;
    private final Matrix mImageInverseMatrix;
    private final Matrix mImageMatrix;
    private final float[] mImagePoints;
    private int mImageResource;
    private int mInitialDegreesRotated;
    private int mLayoutHeight;
    private int mLayoutWidth;
    private int mMaxZoom;
    private OnCropImageCompleteListener mOnCropImageCompleteListener;
    private OnSetImageUriCompleteListener mOnSetImageUriCompleteListener;
    private final ProgressBar mProgressBar;
    private RectF mRestoreCropWindowRect;
    private int mRestoreDegreesRotated;
    private final float[] mScaleImagePoints;
    private ScaleType mScaleType;
    private boolean mShowCropLabel;
    private boolean mShowCropOverlay;
    private boolean mShowProgressBar;
    private boolean mSizeChanged;
    private float mZoom;
    private float mZoomOffsetX;
    private float mZoomOffsetY;
    private Bitmap originalBitmap;

    public enum CropCornerShape {
        RECTANGLE,
        OVAL;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries getEntries() {
            return $ENTRIES;
        }
    }

    public enum CropShape {
        RECTANGLE,
        OVAL,
        RECTANGLE_VERTICAL_ONLY,
        RECTANGLE_HORIZONTAL_ONLY;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries getEntries() {
            return $ENTRIES;
        }
    }

    public enum Guidelines {
        OFF,
        ON_TOUCH,
        ON;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries getEntries() {
            return $ENTRIES;
        }
    }

    public interface OnCropImageCompleteListener {
        void onCropImageComplete(CropImageView cropImageView, CropResult cropResult);
    }

    public interface OnSetCropOverlayMovedListener {
    }

    public interface OnSetCropOverlayReleasedListener {
    }

    public interface OnSetCropWindowChangeListener {
    }

    public interface OnSetImageUriCompleteListener {
        void onSetImageUriComplete(CropImageView cropImageView, Uri uri, Exception exc);
    }

    public enum RequestSizeOptions {
        NONE,
        SAMPLING,
        RESIZE_INSIDE,
        RESIZE_FIT,
        RESIZE_EXACT;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    }

    public enum ScaleType {
        FIT_CENTER,
        CENTER,
        CENTER_CROP,
        CENTER_INSIDE;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries getEntries() {
            return $ENTRIES;
        }
    }

    public final Bitmap getCroppedImage() {
        return getCroppedImage$default(this, 0, 0, null, 7, null);
    }

    public final void setOnCropWindowChangedListener(OnSetCropWindowChangeListener listener) {
    }

    public final void setOnSetCropOverlayMovedListener(OnSetCropOverlayMovedListener listener) {
    }

    public final void setOnSetCropOverlayReleasedListener(OnSetCropOverlayReleasedListener listener) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Code duplicated, block: B:17:0x0068 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:18:0x006a  */
    /* JADX WARN: Code duplicated, block: B:30:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:35:0x030f  */
    public CropImageView(Context context, AttributeSet attributeSet) {
        CropImageOptions cropImageOptions;
        TypedArray typedArrayObtainStyledAttributes;
        CropImageOptions cropImageOptions2;
        boolean z;
        Intent intent;
        Bundle bundleExtra;
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mImageMatrix = new Matrix();
        this.mImageInverseMatrix = new Matrix();
        this.mImagePoints = new float[8];
        this.mScaleImagePoints = new float[8];
        this.mShowCropOverlay = true;
        this.mCropTextLabel = "";
        this.mCropLabelTextSize = 20.0f;
        this.mCropLabelTextColor = -1;
        this.mShowProgressBar = true;
        this.mAutoZoomEnabled = true;
        this.loadedSampleSize = 1;
        this.mZoom = 1.0f;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null && (intent = activity.getIntent()) != null && (bundleExtra = intent.getBundleExtra("CROP_IMAGE_EXTRA_BUNDLE")) != null) {
            Parcelable parcelable = bundleExtra.getParcelable("CROP_IMAGE_EXTRA_OPTIONS");
            cropImageOptions = (CropImageOptions) (parcelable instanceof CropImageOptions ? parcelable : null);
            if (cropImageOptions == null) {
                if (attributeSet != null) {
                    typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CropImageView, 0, 0);
                    Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
                    cropImageOptions2 = new CropImageOptions(false, false, null, null, 0.0f, 0.0f, 0.0f, null, null, false, false, false, 0, false, false, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -1, -1, 63, null);
                    this.isSaveBitmapToInstanceState = typedArrayObtainStyledAttributes.getBoolean(R$styleable.CropImageView_cropSaveBitmapToInstanceState, this.isSaveBitmapToInstanceState);
                    ScaleType scaleType = (ScaleType) ScaleType.getEntries().get(typedArrayObtainStyledAttributes.getInt(R$styleable.CropImageView_cropScaleType, cropImageOptions2.scaleType.ordinal()));
                    CropShape cropShape = (CropShape) CropShape.getEntries().get(typedArrayObtainStyledAttributes.getInt(R$styleable.CropImageView_cropShape, cropImageOptions2.cropShape.ordinal()));
                    CropCornerShape cropCornerShape = (CropCornerShape) CropCornerShape.getEntries().get(typedArrayObtainStyledAttributes.getInt(R$styleable.CropImageView_cornerShape, cropImageOptions2.cornerShape.ordinal()));
                    Guidelines guidelines = (Guidelines) Guidelines.getEntries().get(typedArrayObtainStyledAttributes.getInt(R$styleable.CropImageView_cropGuidelines, cropImageOptions2.guidelines.ordinal()));
                    int integer = typedArrayObtainStyledAttributes.getInteger(R$styleable.CropImageView_cropAspectRatioX, cropImageOptions2.aspectRatioX);
                    int integer2 = typedArrayObtainStyledAttributes.getInteger(R$styleable.CropImageView_cropAspectRatioY, cropImageOptions2.aspectRatioY);
                    boolean z2 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.CropImageView_cropAutoZoomEnabled, cropImageOptions2.autoZoomEnabled);
                    boolean z3 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.CropImageView_cropMultiTouchEnabled, cropImageOptions2.multiTouchEnabled);
                    boolean z4 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.CropImageView_cropCenterMoveEnabled, cropImageOptions2.centerMoveEnabled);
                    float dimension = typedArrayObtainStyledAttributes.getDimension(R$styleable.CropImageView_cropCornerRadius, cropImageOptions2.cropCornerRadius);
                    float dimension2 = typedArrayObtainStyledAttributes.getDimension(R$styleable.CropImageView_cropSnapRadius, cropImageOptions2.snapRadius);
                    float dimension3 = typedArrayObtainStyledAttributes.getDimension(R$styleable.CropImageView_cropTouchRadius, cropImageOptions2.touchRadius);
                    float f = typedArrayObtainStyledAttributes.getFloat(R$styleable.CropImageView_cropInitialCropWindowPaddingRatio, cropImageOptions2.initialCropWindowPaddingRatio);
                    int integer3 = typedArrayObtainStyledAttributes.getInteger(R$styleable.CropImageView_cropCornerCircleFillColor, cropImageOptions2.circleCornerFillColorHexValue);
                    float dimension4 = typedArrayObtainStyledAttributes.getDimension(R$styleable.CropImageView_cropBorderLineThickness, cropImageOptions2.borderLineThickness);
                    int integer4 = typedArrayObtainStyledAttributes.getInteger(R$styleable.CropImageView_cropBorderLineColor, cropImageOptions2.borderLineColor);
                    float dimension5 = typedArrayObtainStyledAttributes.getDimension(R$styleable.CropImageView_cropBorderCornerThickness, cropImageOptions2.borderCornerThickness);
                    float dimension6 = typedArrayObtainStyledAttributes.getDimension(R$styleable.CropImageView_cropBorderCornerOffset, cropImageOptions2.borderCornerOffset);
                    float dimension7 = typedArrayObtainStyledAttributes.getDimension(R$styleable.CropImageView_cropBorderCornerLength, cropImageOptions2.borderCornerLength);
                    int integer5 = typedArrayObtainStyledAttributes.getInteger(R$styleable.CropImageView_cropBorderCornerColor, cropImageOptions2.borderCornerColor);
                    float dimension8 = typedArrayObtainStyledAttributes.getDimension(R$styleable.CropImageView_cropGuidelinesThickness, cropImageOptions2.guidelinesThickness);
                    int integer6 = typedArrayObtainStyledAttributes.getInteger(R$styleable.CropImageView_cropGuidelinesColor, cropImageOptions2.guidelinesColor);
                    int integer7 = typedArrayObtainStyledAttributes.getInteger(R$styleable.CropImageView_cropBackgroundColor, cropImageOptions2.backgroundColor);
                    int dimension9 = (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.CropImageView_cropMinCropWindowWidth, cropImageOptions2.minCropWindowWidth);
                    int dimension10 = (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.CropImageView_cropMinCropWindowHeight, cropImageOptions2.minCropWindowHeight);
                    int i = (int) typedArrayObtainStyledAttributes.getFloat(R$styleable.CropImageView_cropMinCropResultWidthPX, cropImageOptions2.minCropResultWidth);
                    int i2 = (int) typedArrayObtainStyledAttributes.getFloat(R$styleable.CropImageView_cropMinCropResultHeightPX, cropImageOptions2.minCropResultHeight);
                    int i3 = (int) typedArrayObtainStyledAttributes.getFloat(R$styleable.CropImageView_cropMaxCropResultWidthPX, cropImageOptions2.maxCropResultWidth);
                    int i4 = (int) typedArrayObtainStyledAttributes.getFloat(R$styleable.CropImageView_cropMaxCropResultHeightPX, cropImageOptions2.maxCropResultHeight);
                    boolean z5 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.CropImageView_cropFlipHorizontally, cropImageOptions2.flipHorizontally);
                    boolean z6 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.CropImageView_cropFlipHorizontally, cropImageOptions2.flipVertically);
                    float dimension11 = typedArrayObtainStyledAttributes.getDimension(R$styleable.CropImageView_cropperLabelTextSize, cropImageOptions2.cropperLabelTextSize);
                    int integer8 = typedArrayObtainStyledAttributes.getInteger(R$styleable.CropImageView_cropperLabelTextColor, cropImageOptions2.cropperLabelTextColor);
                    boolean z7 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.CropImageView_cropShowLabel, cropImageOptions2.showCropLabel);
                    int integer9 = typedArrayObtainStyledAttributes.getInteger(R$styleable.CropImageView_cropMaxZoom, cropImageOptions2.maxZoom);
                    boolean z8 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.CropImageView_cropShowCropOverlay, cropImageOptions2.showCropOverlay);
                    boolean z9 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.CropImageView_cropShowProgressBar, cropImageOptions2.showProgressBar);
                    String string = typedArrayObtainStyledAttributes.getString(R$styleable.CropImageView_cropperLabelText);
                    if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.CropImageView_cropFixAspectRatio, cropImageOptions2.fixAspectRatio)) {
                        z = true;
                    } else {
                        z = true;
                    }
                    CropImageOptions cropImageOptions3 = new CropImageOptions(false, false, cropShape, cropCornerShape, dimension, dimension2, dimension3, guidelines, scaleType, z8, z7, z9, 0, z2, z3, z4, false, integer9, f, z, integer, integer2, dimension4, integer4, dimension5, dimension6, dimension7, integer5, integer3, dimension8, integer6, integer7, dimension9, dimension10, i, i2, i3, i4, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, z5, z6, null, 0, false, false, null, null, dimension11, integer8, string, 0, null, null, null, null, 69635, 1061158848, 62, null);
                    typedArrayObtainStyledAttributes.recycle();
                    cropImageOptions = cropImageOptions3;
                } else {
                    cropImageOptions = new CropImageOptions(false, false, null, null, 0.0f, 0.0f, 0.0f, null, null, false, false, false, 0, false, false, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -1, -1, 63, null);
                }
            }
        } else if (attributeSet != null) {
            typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CropImageView, 0, 0);
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
            cropImageOptions2 = new CropImageOptions(false, false, null, null, 0.0f, 0.0f, 0.0f, null, null, false, false, false, 0, false, false, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -1, -1, 63, null);
            try {
                this.isSaveBitmapToInstanceState = typedArrayObtainStyledAttributes.getBoolean(R$styleable.CropImageView_cropSaveBitmapToInstanceState, this.isSaveBitmapToInstanceState);
                ScaleType scaleType2 = (ScaleType) ScaleType.getEntries().get(typedArrayObtainStyledAttributes.getInt(R$styleable.CropImageView_cropScaleType, cropImageOptions2.scaleType.ordinal()));
                CropShape cropShape2 = (CropShape) CropShape.getEntries().get(typedArrayObtainStyledAttributes.getInt(R$styleable.CropImageView_cropShape, cropImageOptions2.cropShape.ordinal()));
                CropCornerShape cropCornerShape2 = (CropCornerShape) CropCornerShape.getEntries().get(typedArrayObtainStyledAttributes.getInt(R$styleable.CropImageView_cornerShape, cropImageOptions2.cornerShape.ordinal()));
                Guidelines guidelines2 = (Guidelines) Guidelines.getEntries().get(typedArrayObtainStyledAttributes.getInt(R$styleable.CropImageView_cropGuidelines, cropImageOptions2.guidelines.ordinal()));
                int integer10 = typedArrayObtainStyledAttributes.getInteger(R$styleable.CropImageView_cropAspectRatioX, cropImageOptions2.aspectRatioX);
                int integer11 = typedArrayObtainStyledAttributes.getInteger(R$styleable.CropImageView_cropAspectRatioY, cropImageOptions2.aspectRatioY);
                boolean z10 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.CropImageView_cropAutoZoomEnabled, cropImageOptions2.autoZoomEnabled);
                boolean z11 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.CropImageView_cropMultiTouchEnabled, cropImageOptions2.multiTouchEnabled);
                boolean z12 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.CropImageView_cropCenterMoveEnabled, cropImageOptions2.centerMoveEnabled);
                float dimension12 = typedArrayObtainStyledAttributes.getDimension(R$styleable.CropImageView_cropCornerRadius, cropImageOptions2.cropCornerRadius);
                float dimension13 = typedArrayObtainStyledAttributes.getDimension(R$styleable.CropImageView_cropSnapRadius, cropImageOptions2.snapRadius);
                float dimension14 = typedArrayObtainStyledAttributes.getDimension(R$styleable.CropImageView_cropTouchRadius, cropImageOptions2.touchRadius);
                float f2 = typedArrayObtainStyledAttributes.getFloat(R$styleable.CropImageView_cropInitialCropWindowPaddingRatio, cropImageOptions2.initialCropWindowPaddingRatio);
                int integer12 = typedArrayObtainStyledAttributes.getInteger(R$styleable.CropImageView_cropCornerCircleFillColor, cropImageOptions2.circleCornerFillColorHexValue);
                float dimension15 = typedArrayObtainStyledAttributes.getDimension(R$styleable.CropImageView_cropBorderLineThickness, cropImageOptions2.borderLineThickness);
                int integer13 = typedArrayObtainStyledAttributes.getInteger(R$styleable.CropImageView_cropBorderLineColor, cropImageOptions2.borderLineColor);
                float dimension16 = typedArrayObtainStyledAttributes.getDimension(R$styleable.CropImageView_cropBorderCornerThickness, cropImageOptions2.borderCornerThickness);
                float dimension17 = typedArrayObtainStyledAttributes.getDimension(R$styleable.CropImageView_cropBorderCornerOffset, cropImageOptions2.borderCornerOffset);
                float dimension18 = typedArrayObtainStyledAttributes.getDimension(R$styleable.CropImageView_cropBorderCornerLength, cropImageOptions2.borderCornerLength);
                int integer14 = typedArrayObtainStyledAttributes.getInteger(R$styleable.CropImageView_cropBorderCornerColor, cropImageOptions2.borderCornerColor);
                float dimension19 = typedArrayObtainStyledAttributes.getDimension(R$styleable.CropImageView_cropGuidelinesThickness, cropImageOptions2.guidelinesThickness);
                int integer15 = typedArrayObtainStyledAttributes.getInteger(R$styleable.CropImageView_cropGuidelinesColor, cropImageOptions2.guidelinesColor);
                int integer16 = typedArrayObtainStyledAttributes.getInteger(R$styleable.CropImageView_cropBackgroundColor, cropImageOptions2.backgroundColor);
                int dimension20 = (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.CropImageView_cropMinCropWindowWidth, cropImageOptions2.minCropWindowWidth);
                int dimension110 = (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.CropImageView_cropMinCropWindowHeight, cropImageOptions2.minCropWindowHeight);
                int i5 = (int) typedArrayObtainStyledAttributes.getFloat(R$styleable.CropImageView_cropMinCropResultWidthPX, cropImageOptions2.minCropResultWidth);
                int i6 = (int) typedArrayObtainStyledAttributes.getFloat(R$styleable.CropImageView_cropMinCropResultHeightPX, cropImageOptions2.minCropResultHeight);
                int i7 = (int) typedArrayObtainStyledAttributes.getFloat(R$styleable.CropImageView_cropMaxCropResultWidthPX, cropImageOptions2.maxCropResultWidth);
                int i8 = (int) typedArrayObtainStyledAttributes.getFloat(R$styleable.CropImageView_cropMaxCropResultHeightPX, cropImageOptions2.maxCropResultHeight);
                boolean z13 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.CropImageView_cropFlipHorizontally, cropImageOptions2.flipHorizontally);
                boolean z14 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.CropImageView_cropFlipHorizontally, cropImageOptions2.flipVertically);
                float dimension111 = typedArrayObtainStyledAttributes.getDimension(R$styleable.CropImageView_cropperLabelTextSize, cropImageOptions2.cropperLabelTextSize);
                int integer17 = typedArrayObtainStyledAttributes.getInteger(R$styleable.CropImageView_cropperLabelTextColor, cropImageOptions2.cropperLabelTextColor);
                boolean z15 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.CropImageView_cropShowLabel, cropImageOptions2.showCropLabel);
                int integer18 = typedArrayObtainStyledAttributes.getInteger(R$styleable.CropImageView_cropMaxZoom, cropImageOptions2.maxZoom);
                boolean z16 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.CropImageView_cropShowCropOverlay, cropImageOptions2.showCropOverlay);
                boolean z17 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.CropImageView_cropShowProgressBar, cropImageOptions2.showProgressBar);
                String string2 = typedArrayObtainStyledAttributes.getString(R$styleable.CropImageView_cropperLabelText);
                if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.CropImageView_cropFixAspectRatio, cropImageOptions2.fixAspectRatio) || (typedArrayObtainStyledAttributes.hasValue(R$styleable.CropImageView_cropAspectRatioX) && typedArrayObtainStyledAttributes.hasValue(R$styleable.CropImageView_cropAspectRatioX))) {
                    z = true;
                } else {
                    z = false;
                }
                CropImageOptions cropImageOptions4 = new CropImageOptions(false, false, cropShape2, cropCornerShape2, dimension12, dimension13, dimension14, guidelines2, scaleType2, z16, z15, z17, 0, z10, z11, z12, false, integer18, f2, z, integer10, integer11, dimension15, integer13, dimension16, dimension17, dimension18, integer14, integer12, dimension19, integer15, integer16, dimension20, dimension110, i5, i6, i7, i8, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, z13, z14, null, 0, false, false, null, null, dimension111, integer17, string2, 0, null, null, null, null, 69635, 1061158848, 62, null);
                typedArrayObtainStyledAttributes.recycle();
                cropImageOptions = cropImageOptions4;
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            cropImageOptions = new CropImageOptions(false, false, null, null, 0.0f, 0.0f, 0.0f, null, null, false, false, false, 0, false, false, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -1, -1, 63, null);
        }
        this.mScaleType = cropImageOptions.scaleType;
        this.mAutoZoomEnabled = cropImageOptions.autoZoomEnabled;
        this.mMaxZoom = cropImageOptions.maxZoom;
        this.mCropLabelTextSize = cropImageOptions.cropperLabelTextSize;
        this.mShowCropLabel = cropImageOptions.showCropLabel;
        this.mShowCropOverlay = cropImageOptions.showCropOverlay;
        this.mShowProgressBar = cropImageOptions.showProgressBar;
        this.mFlipHorizontally = cropImageOptions.flipHorizontally;
        this.mFlipVertically = cropImageOptions.flipVertically;
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.crop_image_view, (ViewGroup) this, true);
        ImageView imageView = (ImageView) viewInflate.findViewById(R$id.ImageView_image);
        this.imageView = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        CropOverlayView cropOverlayView = (CropOverlayView) viewInflate.findViewById(R$id.CropOverlayView);
        this.mCropOverlayView = cropOverlayView;
        cropOverlayView.setCropWindowChangeListener(this);
        cropOverlayView.setInitialAttributeValues(cropImageOptions);
        ProgressBar progressBar = (ProgressBar) viewInflate.findViewById(R$id.CropProgressBar);
        this.mProgressBar = progressBar;
        progressBar.setIndeterminateTintList(ColorStateList.valueOf(cropImageOptions.progressBarColor));
        setProgressBarVisibility();
    }

    public final void setSaveBitmapToInstanceState(boolean z) {
        this.isSaveBitmapToInstanceState = z;
    }

    public final Uri getImageUri() {
        return this.imageUri;
    }

    /* JADX INFO: renamed from: getScaleType, reason: from getter */
    public final ScaleType getMScaleType() {
        return this.mScaleType;
    }

    public final void setScaleType(ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        if (scaleType != this.mScaleType) {
            this.mScaleType = scaleType;
            this.mZoom = 1.0f;
            this.mZoomOffsetY = 0.0f;
            this.mZoomOffsetX = 0.0f;
            CropOverlayView cropOverlayView = this.mCropOverlayView;
            if (cropOverlayView != null) {
                cropOverlayView.resetCropOverlayView();
            }
            requestLayout();
        }
    }

    public final CropShape getCropShape() {
        CropOverlayView cropOverlayView = this.mCropOverlayView;
        Intrinsics.checkNotNull(cropOverlayView);
        return cropOverlayView.getCropShape();
    }

    public final void setCropShape(CropShape cropShape) {
        CropOverlayView cropOverlayView = this.mCropOverlayView;
        Intrinsics.checkNotNull(cropOverlayView);
        Intrinsics.checkNotNull(cropShape);
        cropOverlayView.setCropShape(cropShape);
    }

    public final CropCornerShape getCornerShape() {
        CropOverlayView cropOverlayView = this.mCropOverlayView;
        Intrinsics.checkNotNull(cropOverlayView);
        return cropOverlayView.getCornerShape();
    }

    public final void setCornerShape(CropCornerShape cropCornerShape) {
        CropOverlayView cropOverlayView = this.mCropOverlayView;
        Intrinsics.checkNotNull(cropOverlayView);
        Intrinsics.checkNotNull(cropCornerShape);
        cropOverlayView.setCropCornerShape(cropCornerShape);
    }

    public final void setAutoZoomEnabled(boolean z) {
        if (this.mAutoZoomEnabled != z) {
            this.mAutoZoomEnabled = z;
            handleCropWindowChanged(false, false);
            CropOverlayView cropOverlayView = this.mCropOverlayView;
            Intrinsics.checkNotNull(cropOverlayView);
            cropOverlayView.invalidate();
        }
    }

    public final void setMultiTouchEnabled(boolean multiTouchEnabled) {
        CropOverlayView cropOverlayView = this.mCropOverlayView;
        Intrinsics.checkNotNull(cropOverlayView);
        if (cropOverlayView.setMultiTouchEnabled(multiTouchEnabled)) {
            handleCropWindowChanged(false, false);
            this.mCropOverlayView.invalidate();
        }
    }

    public final void setCenterMoveEnabled(boolean centerMoveEnabled) {
        CropOverlayView cropOverlayView = this.mCropOverlayView;
        Intrinsics.checkNotNull(cropOverlayView);
        if (cropOverlayView.setCenterMoveEnabled(centerMoveEnabled)) {
            handleCropWindowChanged(false, false);
            this.mCropOverlayView.invalidate();
        }
    }

    /* JADX INFO: renamed from: getMaxZoom, reason: from getter */
    public final int getMMaxZoom() {
        return this.mMaxZoom;
    }

    public final void setMaxZoom(int i) {
        if (this.mMaxZoom == i || i <= 0) {
            return;
        }
        this.mMaxZoom = i;
        handleCropWindowChanged(false, false);
        CropOverlayView cropOverlayView = this.mCropOverlayView;
        Intrinsics.checkNotNull(cropOverlayView);
        cropOverlayView.invalidate();
    }

    /* JADX INFO: renamed from: getRotatedDegrees, reason: from getter */
    public final int getMDegreesRotated() {
        return this.mDegreesRotated;
    }

    public final void setRotatedDegrees(int i) {
        int i2 = this.mDegreesRotated;
        if (i2 != i) {
            rotateImage(i - i2);
        }
    }

    public final void setFixedAspectRatio(boolean fixAspectRatio) {
        CropOverlayView cropOverlayView = this.mCropOverlayView;
        Intrinsics.checkNotNull(cropOverlayView);
        cropOverlayView.setFixedAspectRatio(fixAspectRatio);
    }

    public final void setFlippedHorizontally(boolean z) {
        if (this.mFlipHorizontally != z) {
            this.mFlipHorizontally = z;
            applyImageMatrix(getWidth(), getHeight(), true, false);
        }
    }

    public final Uri getCustomOutputUri() {
        return this.customOutputUri;
    }

    public final void setCustomOutputUri(Uri uri) {
        this.customOutputUri = uri;
    }

    public final void setFlippedVertically(boolean z) {
        if (this.mFlipVertically != z) {
            this.mFlipVertically = z;
            applyImageMatrix(getWidth(), getHeight(), true, false);
        }
    }

    public final Guidelines getGuidelines() {
        CropOverlayView cropOverlayView = this.mCropOverlayView;
        Intrinsics.checkNotNull(cropOverlayView);
        return cropOverlayView.getGuidelines();
    }

    public final void setGuidelines(Guidelines guidelines) {
        CropOverlayView cropOverlayView = this.mCropOverlayView;
        Intrinsics.checkNotNull(cropOverlayView);
        Intrinsics.checkNotNull(guidelines);
        cropOverlayView.setGuidelines(guidelines);
    }

    public final Pair<Integer, Integer> getAspectRatio() {
        CropOverlayView cropOverlayView = this.mCropOverlayView;
        Intrinsics.checkNotNull(cropOverlayView);
        return new Pair<>(Integer.valueOf(cropOverlayView.getMAspectRatioX()), Integer.valueOf(this.mCropOverlayView.getMAspectRatioY()));
    }

    public final void setImageCropOptions(CropImageOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        setScaleType(options.scaleType);
        this.customOutputUri = options.customOutputUri;
        CropOverlayView cropOverlayView = this.mCropOverlayView;
        if (cropOverlayView != null) {
            cropOverlayView.setInitialAttributeValues(options);
        }
        setMultiTouchEnabled(options.multiTouchEnabled);
        setCenterMoveEnabled(options.centerMoveEnabled);
        setShowCropOverlay(options.showCropOverlay);
        setShowProgressBar(options.showProgressBar);
        setAutoZoomEnabled(options.autoZoomEnabled);
        setMaxZoom(options.maxZoom);
        setFlippedHorizontally(options.flipHorizontally);
        setFlippedVertically(options.flipVertically);
        this.mAutoZoomEnabled = options.autoZoomEnabled;
        this.mShowCropOverlay = options.showCropOverlay;
        this.mShowProgressBar = options.showProgressBar;
        this.mProgressBar.setIndeterminateTintList(ColorStateList.valueOf(options.progressBarColor));
    }

    public final void setSnapRadius(float snapRadius) {
        if (snapRadius >= 0.0f) {
            CropOverlayView cropOverlayView = this.mCropOverlayView;
            Intrinsics.checkNotNull(cropOverlayView);
            cropOverlayView.setSnapRadius(snapRadius);
        }
    }

    public final void setShowProgressBar(boolean z) {
        if (this.mShowProgressBar != z) {
            this.mShowProgressBar = z;
            setProgressBarVisibility();
        }
    }

    public final void setShowCropOverlay(boolean z) {
        if (this.mShowCropOverlay != z) {
            this.mShowCropOverlay = z;
            setCropOverlayVisibility();
        }
    }

    public final void setShowCropLabel(boolean z) {
        if (this.mShowCropLabel != z) {
            this.mShowCropLabel = z;
            CropOverlayView cropOverlayView = this.mCropOverlayView;
            if (cropOverlayView != null) {
                cropOverlayView.setCropperTextLabelVisibility(z);
            }
        }
    }

    /* JADX INFO: renamed from: getCropLabelText, reason: from getter */
    public final String getMCropTextLabel() {
        return this.mCropTextLabel;
    }

    public final void setCropLabelText(String cropLabelText) {
        Intrinsics.checkNotNullParameter(cropLabelText, "cropLabelText");
        this.mCropTextLabel = cropLabelText;
        CropOverlayView cropOverlayView = this.mCropOverlayView;
        if (cropOverlayView != null) {
            cropOverlayView.setCropLabelText(cropLabelText);
        }
    }

    /* JADX INFO: renamed from: getCropLabelTextSize, reason: from getter */
    public final float getMCropLabelTextSize() {
        return this.mCropLabelTextSize;
    }

    public final void setCropLabelTextSize(float f) {
        this.mCropLabelTextSize = getMCropLabelTextSize();
        CropOverlayView cropOverlayView = this.mCropOverlayView;
        if (cropOverlayView != null) {
            cropOverlayView.setCropLabelTextSize(f);
        }
    }

    /* JADX INFO: renamed from: getCropLabelTextColor, reason: from getter */
    public final int getMCropLabelTextColor() {
        return this.mCropLabelTextColor;
    }

    public final void setCropLabelTextColor(int i) {
        this.mCropLabelTextColor = i;
        CropOverlayView cropOverlayView = this.mCropOverlayView;
        if (cropOverlayView != null) {
            cropOverlayView.setCropLabelTextColor(i);
        }
    }

    /* JADX INFO: renamed from: getImageResource, reason: from getter */
    public final int getMImageResource() {
        return this.mImageResource;
    }

    public final void setImageResource(int i) {
        if (i != 0) {
            CropOverlayView cropOverlayView = this.mCropOverlayView;
            Intrinsics.checkNotNull(cropOverlayView);
            cropOverlayView.setInitialCropWindowRect(null);
            setBitmap(BitmapFactory.decodeResource(getResources(), i), i, null, 1, 0);
        }
    }

    public final Rect getWholeImageRect() {
        int i = this.loadedSampleSize;
        Bitmap bitmap = this.originalBitmap;
        if (bitmap == null) {
            return null;
        }
        return new Rect(0, 0, bitmap.getWidth() * i, bitmap.getHeight() * i);
    }

    public final Rect getCropRect() {
        int i = this.loadedSampleSize;
        Bitmap bitmap = this.originalBitmap;
        if (bitmap == null) {
            return null;
        }
        float[] cropPoints = getCropPoints();
        int width = bitmap.getWidth() * i;
        int height = bitmap.getHeight() * i;
        BitmapUtils bitmapUtils = BitmapUtils.INSTANCE;
        CropOverlayView cropOverlayView = this.mCropOverlayView;
        Intrinsics.checkNotNull(cropOverlayView);
        return bitmapUtils.getRectFromPoints(cropPoints, width, height, cropOverlayView.getIsFixAspectRatio(), this.mCropOverlayView.getMAspectRatioX(), this.mCropOverlayView.getMAspectRatioY());
    }

    public final void setCropRect(Rect rect) {
        CropOverlayView cropOverlayView = this.mCropOverlayView;
        Intrinsics.checkNotNull(cropOverlayView);
        cropOverlayView.setInitialCropWindowRect(rect);
    }

    public final RectF getCropWindowRect() {
        CropOverlayView cropOverlayView = this.mCropOverlayView;
        if (cropOverlayView != null) {
            return cropOverlayView.getCropWindowRect();
        }
        return null;
    }

    public final float[] getCropPoints() {
        CropOverlayView cropOverlayView = this.mCropOverlayView;
        Intrinsics.checkNotNull(cropOverlayView);
        RectF cropWindowRect = cropOverlayView.getCropWindowRect();
        float f = cropWindowRect.left;
        float f2 = cropWindowRect.top;
        float f3 = cropWindowRect.right;
        float f4 = cropWindowRect.bottom;
        float[] fArr = {f, f2, f3, f2, f3, f4, f, f4};
        this.mImageMatrix.invert(this.mImageInverseMatrix);
        this.mImageInverseMatrix.mapPoints(fArr);
        float[] fArr2 = new float[8];
        for (int i = 0; i < 8; i++) {
            fArr2[i] = fArr[i] * this.loadedSampleSize;
        }
        return fArr2;
    }

    public static /* synthetic */ Bitmap getCroppedImage$default(CropImageView cropImageView, int i, int i2, RequestSizeOptions requestSizeOptions, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            requestSizeOptions = RequestSizeOptions.RESIZE_INSIDE;
        }
        return cropImageView.getCroppedImage(i, i2, requestSizeOptions);
    }

    public final Bitmap getCroppedImage(int reqWidth, int reqHeight, RequestSizeOptions options) {
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(options, "options");
        Bitmap bitmap2 = this.originalBitmap;
        if (bitmap2 == null) {
            return null;
        }
        RequestSizeOptions requestSizeOptions = RequestSizeOptions.NONE;
        int i = options != requestSizeOptions ? reqWidth : 0;
        int i2 = options != requestSizeOptions ? reqHeight : 0;
        if (this.imageUri != null && (this.loadedSampleSize > 1 || options == RequestSizeOptions.SAMPLING)) {
            BitmapUtils bitmapUtils = BitmapUtils.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            Uri uri = this.imageUri;
            float[] cropPoints = getCropPoints();
            int i3 = this.mDegreesRotated;
            Bitmap bitmap3 = this.originalBitmap;
            Intrinsics.checkNotNull(bitmap3);
            int width = bitmap3.getWidth() * this.loadedSampleSize;
            Bitmap bitmap4 = this.originalBitmap;
            Intrinsics.checkNotNull(bitmap4);
            int height = bitmap4.getHeight() * this.loadedSampleSize;
            CropOverlayView cropOverlayView = this.mCropOverlayView;
            Intrinsics.checkNotNull(cropOverlayView);
            bitmap = bitmapUtils.cropBitmap(context, uri, cropPoints, i3, width, height, cropOverlayView.getIsFixAspectRatio(), this.mCropOverlayView.getMAspectRatioX(), this.mCropOverlayView.getMAspectRatioY(), i, i2, this.mFlipHorizontally, this.mFlipVertically).getBitmap();
        } else {
            BitmapUtils bitmapUtils2 = BitmapUtils.INSTANCE;
            float[] cropPoints2 = getCropPoints();
            int i4 = this.mDegreesRotated;
            CropOverlayView cropOverlayView2 = this.mCropOverlayView;
            Intrinsics.checkNotNull(cropOverlayView2);
            bitmap = bitmapUtils2.cropBitmapObjectHandleOOM(bitmap2, cropPoints2, i4, cropOverlayView2.getIsFixAspectRatio(), this.mCropOverlayView.getMAspectRatioX(), this.mCropOverlayView.getMAspectRatioY(), this.mFlipHorizontally, this.mFlipVertically).getBitmap();
        }
        return BitmapUtils.INSTANCE.resizeBitmap(bitmap, i, i2, options);
    }

    public final void croppedImageAsync(Bitmap.CompressFormat saveCompressFormat, int saveCompressQuality, int reqWidth, int reqHeight, RequestSizeOptions options, Uri customOutputUri) {
        Intrinsics.checkNotNullParameter(saveCompressFormat, "saveCompressFormat");
        Intrinsics.checkNotNullParameter(options, "options");
        if (this.mOnCropImageCompleteListener == null) {
            throw new IllegalArgumentException("mOnCropImageCompleteListener is not set");
        }
        startCropWorkerTask(reqWidth, reqHeight, options, saveCompressFormat, saveCompressQuality, customOutputUri);
    }

    public final void setOnSetImageUriCompleteListener(OnSetImageUriCompleteListener listener) {
        this.mOnSetImageUriCompleteListener = listener;
    }

    public final void setOnCropImageCompleteListener(OnCropImageCompleteListener listener) {
        this.mOnCropImageCompleteListener = listener;
    }

    public final void setImageBitmap(Bitmap bitmap) {
        CropOverlayView cropOverlayView = this.mCropOverlayView;
        Intrinsics.checkNotNull(cropOverlayView);
        cropOverlayView.setInitialCropWindowRect(null);
        setBitmap(bitmap, 0, null, 1, 0);
    }

    public final void setImageUriAsync(Uri uri) {
        BitmapLoadingWorkerJob bitmapLoadingWorkerJob;
        if (uri != null) {
            WeakReference weakReference = this.bitmapLoadingWorkerJob;
            if (weakReference != null && (bitmapLoadingWorkerJob = (BitmapLoadingWorkerJob) weakReference.get()) != null) {
                bitmapLoadingWorkerJob.cancel();
            }
            clearImageInt();
            CropOverlayView cropOverlayView = this.mCropOverlayView;
            Intrinsics.checkNotNull(cropOverlayView);
            cropOverlayView.setInitialCropWindowRect(null);
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            WeakReference weakReference2 = new WeakReference(new BitmapLoadingWorkerJob(context, this, uri));
            this.bitmapLoadingWorkerJob = weakReference2;
            BitmapLoadingWorkerJob bitmapLoadingWorkerJob2 = (BitmapLoadingWorkerJob) weakReference2.get();
            if (bitmapLoadingWorkerJob2 != null) {
                bitmapLoadingWorkerJob2.start();
            }
            setProgressBarVisibility();
        }
    }

    public final void rotateImage(int degrees) {
        int i;
        if (this.originalBitmap != null) {
            if (degrees < 0) {
                i = (degrees % 360) + 360;
            } else {
                i = degrees % 360;
            }
            CropOverlayView cropOverlayView = this.mCropOverlayView;
            Intrinsics.checkNotNull(cropOverlayView);
            boolean z = !cropOverlayView.getIsFixAspectRatio() && ((46 <= i && i < 135) || (216 <= i && i < 305));
            BitmapUtils bitmapUtils = BitmapUtils.INSTANCE;
            bitmapUtils.getRECT().set(this.mCropOverlayView.getCropWindowRect());
            RectF rect = bitmapUtils.getRECT();
            float fHeight = (z ? rect.height() : rect.width()) / 2.0f;
            RectF rect2 = bitmapUtils.getRECT();
            float fWidth = (z ? rect2.width() : rect2.height()) / 2.0f;
            if (z) {
                boolean z2 = this.mFlipHorizontally;
                this.mFlipHorizontally = this.mFlipVertically;
                this.mFlipVertically = z2;
            }
            this.mImageMatrix.invert(this.mImageInverseMatrix);
            bitmapUtils.getPOINTS()[0] = bitmapUtils.getRECT().centerX();
            bitmapUtils.getPOINTS()[1] = bitmapUtils.getRECT().centerY();
            bitmapUtils.getPOINTS()[2] = 0.0f;
            bitmapUtils.getPOINTS()[3] = 0.0f;
            bitmapUtils.getPOINTS()[4] = 1.0f;
            bitmapUtils.getPOINTS()[5] = 0.0f;
            this.mImageInverseMatrix.mapPoints(bitmapUtils.getPOINTS());
            this.mDegreesRotated = (this.mDegreesRotated + i) % 360;
            applyImageMatrix(getWidth(), getHeight(), true, false);
            this.mImageMatrix.mapPoints(bitmapUtils.getPOINTS2(), bitmapUtils.getPOINTS());
            float fSqrt = this.mZoom / ((float) Math.sqrt(Math.pow(bitmapUtils.getPOINTS2()[4] - bitmapUtils.getPOINTS2()[2], 2.0d) + Math.pow(bitmapUtils.getPOINTS2()[5] - bitmapUtils.getPOINTS2()[3], 2.0d)));
            this.mZoom = fSqrt;
            this.mZoom = Math.max(fSqrt, 1.0f);
            applyImageMatrix(getWidth(), getHeight(), true, false);
            this.mImageMatrix.mapPoints(bitmapUtils.getPOINTS2(), bitmapUtils.getPOINTS());
            float fSqrt2 = (float) Math.sqrt(Math.pow(bitmapUtils.getPOINTS2()[4] - bitmapUtils.getPOINTS2()[2], 2.0d) + Math.pow(bitmapUtils.getPOINTS2()[5] - bitmapUtils.getPOINTS2()[3], 2.0d));
            float f = fHeight * fSqrt2;
            float f2 = fWidth * fSqrt2;
            bitmapUtils.getRECT().set(bitmapUtils.getPOINTS2()[0] - f, bitmapUtils.getPOINTS2()[1] - f2, bitmapUtils.getPOINTS2()[0] + f, bitmapUtils.getPOINTS2()[1] + f2);
            this.mCropOverlayView.resetCropOverlayView();
            this.mCropOverlayView.setCropWindowRect(bitmapUtils.getRECT());
            applyImageMatrix(getWidth(), getHeight(), true, false);
            handleCropWindowChanged(false, false);
            this.mCropOverlayView.fixCurrentCropWindowRect();
        }
    }

    public final void flipImageHorizontally() {
        this.mFlipHorizontally = !this.mFlipHorizontally;
        applyImageMatrix(getWidth(), getHeight(), true, false);
    }

    public final void flipImageVertically() {
        this.mFlipVertically = !this.mFlipVertically;
        applyImageMatrix(getWidth(), getHeight(), true, false);
    }

    public final void onSetImageUriAsyncComplete$cropper_release(BitmapLoadingWorkerJob.Result result) {
        CropImageView cropImageView;
        Intrinsics.checkNotNullParameter(result, "result");
        this.bitmapLoadingWorkerJob = null;
        setProgressBarVisibility();
        if (result.getError() == null) {
            this.mInitialDegreesRotated = result.getDegreesRotated();
            this.mFlipHorizontally = result.getFlipHorizontally();
            this.mFlipVertically = result.getFlipVertically();
            cropImageView = this;
            cropImageView.setBitmap(result.getBitmap(), 0, result.getUri(), result.getLoadSampleSize(), result.getDegreesRotated());
        } else {
            cropImageView = this;
        }
        OnSetImageUriCompleteListener onSetImageUriCompleteListener = cropImageView.mOnSetImageUriCompleteListener;
        if (onSetImageUriCompleteListener != null) {
            onSetImageUriCompleteListener.onSetImageUriComplete(this, result.getUri(), result.getError());
        }
    }

    public final void onImageCroppingAsyncComplete$cropper_release(BitmapCroppingWorkerJob.Result result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.bitmapCroppingWorkerJob = null;
        setProgressBarVisibility();
        OnCropImageCompleteListener onCropImageCompleteListener = this.mOnCropImageCompleteListener;
        if (onCropImageCompleteListener != null) {
            onCropImageCompleteListener.onCropImageComplete(this, new CropResult(this.originalBitmap, this.imageUri, result.getBitmap(), result.getUri(), result.getError(), getCropPoints(), getCropRect(), getWholeImageRect(), getMDegreesRotated(), result.getSampleSize()));
        }
    }

    private final void setBitmap(Bitmap bitmap, int imageResource, Uri imageUri, int loadSampleSize, int degreesRotated) {
        Bitmap bitmap2 = this.originalBitmap;
        if (bitmap2 == null || !Intrinsics.areEqual(bitmap2, bitmap)) {
            clearImageInt();
            this.originalBitmap = bitmap;
            this.imageView.setImageBitmap(bitmap);
            this.imageUri = imageUri;
            this.mImageResource = imageResource;
            this.loadedSampleSize = loadSampleSize;
            this.mDegreesRotated = degreesRotated;
            applyImageMatrix(getWidth(), getHeight(), true, false);
            CropOverlayView cropOverlayView = this.mCropOverlayView;
            if (cropOverlayView != null) {
                cropOverlayView.resetCropOverlayView();
                setCropOverlayVisibility();
            }
        }
    }

    private final void clearImageInt() {
        Bitmap bitmap = this.originalBitmap;
        if (bitmap != null && (this.mImageResource > 0 || this.imageUri != null)) {
            Intrinsics.checkNotNull(bitmap);
            bitmap.recycle();
        }
        this.originalBitmap = null;
        this.mImageResource = 0;
        this.imageUri = null;
        this.loadedSampleSize = 1;
        this.mDegreesRotated = 0;
        this.mZoom = 1.0f;
        this.mZoomOffsetX = 0.0f;
        this.mZoomOffsetY = 0.0f;
        this.mImageMatrix.reset();
        this.mRestoreCropWindowRect = null;
        this.mRestoreDegreesRotated = 0;
        this.imageView.setImageBitmap(null);
        setCropOverlayVisibility();
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public final void startCropWorkerTask(int r22, int r23, com.canhub.cropper.CropImageView.RequestSizeOptions r24, android.graphics.Bitmap.CompressFormat r25, int r26, android.net.Uri r27) {
        /*
            Method dump skipped, instruction units count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.canhub.cropper.CropImageView.startCropWorkerTask(int, int, com.canhub.cropper.CropImageView$RequestSizeOptions, android.graphics.Bitmap$CompressFormat, int, android.net.Uri):void");
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Uri uriWriteTempStateStoreBitmap;
        if (this.imageUri == null && this.originalBitmap == null && this.mImageResource < 1) {
            return super.onSaveInstanceState();
        }
        Bundle bundle = new Bundle();
        if (this.isSaveBitmapToInstanceState && this.imageUri == null && this.mImageResource < 1) {
            BitmapUtils bitmapUtils = BitmapUtils.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            uriWriteTempStateStoreBitmap = bitmapUtils.writeTempStateStoreBitmap(context, this.originalBitmap, this.customOutputUri);
        } else {
            uriWriteTempStateStoreBitmap = this.imageUri;
        }
        if (uriWriteTempStateStoreBitmap != null && this.originalBitmap != null) {
            String string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            BitmapUtils.INSTANCE.setMStateBitmap(new Pair(string, new WeakReference(this.originalBitmap)));
            bundle.putString("LOADED_IMAGE_STATE_BITMAP_KEY", string);
        }
        WeakReference weakReference = this.bitmapLoadingWorkerJob;
        BitmapLoadingWorkerJob bitmapLoadingWorkerJob = weakReference != null ? (BitmapLoadingWorkerJob) weakReference.get() : null;
        if (bitmapLoadingWorkerJob != null) {
            bundle.putParcelable("LOADING_IMAGE_URI", bitmapLoadingWorkerJob.getUri$cropper_release());
        }
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putParcelable("LOADED_IMAGE_URI", uriWriteTempStateStoreBitmap);
        bundle.putInt("LOADED_IMAGE_RESOURCE", this.mImageResource);
        bundle.putInt("LOADED_SAMPLE_SIZE", this.loadedSampleSize);
        bundle.putInt("DEGREES_ROTATED", this.mDegreesRotated);
        CropOverlayView cropOverlayView = this.mCropOverlayView;
        Intrinsics.checkNotNull(cropOverlayView);
        bundle.putParcelable("INITIAL_CROP_RECT", cropOverlayView.getMInitialCropWindowRect());
        BitmapUtils bitmapUtils2 = BitmapUtils.INSTANCE;
        bitmapUtils2.getRECT().set(this.mCropOverlayView.getCropWindowRect());
        this.mImageMatrix.invert(this.mImageInverseMatrix);
        this.mImageInverseMatrix.mapRect(bitmapUtils2.getRECT());
        bundle.putParcelable("CROP_WINDOW_RECT", bitmapUtils2.getRECT());
        CropShape cropShape = this.mCropOverlayView.getCropShape();
        Intrinsics.checkNotNull(cropShape);
        bundle.putString("CROP_SHAPE", cropShape.name());
        bundle.putBoolean("CROP_AUTO_ZOOM_ENABLED", this.mAutoZoomEnabled);
        bundle.putInt("CROP_MAX_ZOOM", this.mMaxZoom);
        bundle.putBoolean("CROP_FLIP_HORIZONTALLY", this.mFlipHorizontally);
        bundle.putBoolean("CROP_FLIP_VERTICALLY", this.mFlipVertically);
        bundle.putBoolean("SHOW_CROP_LABEL", this.mShowCropLabel);
        return bundle;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x006c  */
    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        CropImageView cropImageView;
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(state, "state");
        if (!(state instanceof Bundle)) {
            super.onRestoreInstanceState(state);
            return;
        }
        if (this.bitmapLoadingWorkerJob == null && this.imageUri == null && this.originalBitmap == null && this.mImageResource == 0) {
            Bundle bundle = (Bundle) state;
            Parcelable parcelable = bundle.getParcelable("LOADED_IMAGE_URI");
            if (!(parcelable instanceof Uri)) {
                parcelable = null;
            }
            Uri uri = (Uri) parcelable;
            if (uri != null) {
                String string = bundle.getString("LOADED_IMAGE_STATE_BITMAP_KEY");
                if (string == null) {
                    cropImageView = this;
                } else {
                    BitmapUtils bitmapUtils = BitmapUtils.INSTANCE;
                    Pair mStateBitmap = bitmapUtils.getMStateBitmap();
                    if (mStateBitmap != null) {
                        bitmap = Intrinsics.areEqual(mStateBitmap.first, string) ? (Bitmap) ((WeakReference) mStateBitmap.second).get() : null;
                    } else {
                        bitmap = null;
                    }
                    bitmapUtils.setMStateBitmap(null);
                    if (bitmap == null || bitmap.isRecycled()) {
                        cropImageView = this;
                    } else {
                        cropImageView = this;
                        cropImageView.setBitmap(bitmap, 0, uri, bundle.getInt("LOADED_SAMPLE_SIZE"), 0);
                    }
                }
                if (cropImageView.imageUri == null) {
                    setImageUriAsync(uri);
                    Unit unit = Unit.INSTANCE;
                }
            } else {
                cropImageView = this;
                int i = bundle.getInt("LOADED_IMAGE_RESOURCE");
                if (i > 0) {
                    setImageResource(i);
                    Unit unit2 = Unit.INSTANCE;
                } else {
                    Parcelable parcelable2 = bundle.getParcelable("LOADING_IMAGE_URI");
                    if (!(parcelable2 instanceof Uri)) {
                        parcelable2 = null;
                    }
                    Uri uri2 = (Uri) parcelable2;
                    if (uri2 != null) {
                        setImageUriAsync(uri2);
                        Unit unit3 = Unit.INSTANCE;
                    }
                }
            }
            int i2 = bundle.getInt("DEGREES_ROTATED");
            cropImageView.mRestoreDegreesRotated = i2;
            cropImageView.mDegreesRotated = i2;
            Parcelable parcelable3 = bundle.getParcelable("INITIAL_CROP_RECT");
            if (!(parcelable3 instanceof Rect)) {
                parcelable3 = null;
            }
            Rect rect = (Rect) parcelable3;
            if (rect != null && (rect.width() > 0 || rect.height() > 0)) {
                CropOverlayView cropOverlayView = cropImageView.mCropOverlayView;
                Intrinsics.checkNotNull(cropOverlayView);
                cropOverlayView.setInitialCropWindowRect(rect);
            }
            Parcelable parcelable4 = bundle.getParcelable("CROP_WINDOW_RECT");
            if (!(parcelable4 instanceof RectF)) {
                parcelable4 = null;
            }
            RectF rectF = (RectF) parcelable4;
            if (rectF != null && (rectF.width() > 0.0f || rectF.height() > 0.0f)) {
                cropImageView.mRestoreCropWindowRect = rectF;
            }
            CropOverlayView cropOverlayView2 = cropImageView.mCropOverlayView;
            Intrinsics.checkNotNull(cropOverlayView2);
            String string2 = bundle.getString("CROP_SHAPE");
            Intrinsics.checkNotNull(string2);
            cropOverlayView2.setCropShape(CropShape.valueOf(string2));
            cropImageView.mAutoZoomEnabled = bundle.getBoolean("CROP_AUTO_ZOOM_ENABLED");
            cropImageView.mMaxZoom = bundle.getInt("CROP_MAX_ZOOM");
            cropImageView.mFlipHorizontally = bundle.getBoolean("CROP_FLIP_HORIZONTALLY");
            cropImageView.mFlipVertically = bundle.getBoolean("CROP_FLIP_VERTICALLY");
            boolean z = bundle.getBoolean("SHOW_CROP_LABEL");
            cropImageView.mShowCropLabel = z;
            cropImageView.mCropOverlayView.setCropperTextLabelVisibility(z);
        }
        Parcelable parcelable5 = ((Bundle) state).getParcelable("instanceState");
        super.onRestoreInstanceState(parcelable5 instanceof Parcelable ? parcelable5 : null);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width;
        int height;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        Bitmap bitmap = this.originalBitmap;
        if (bitmap != null) {
            if (size2 == 0) {
                size2 = bitmap.getHeight();
            }
            double width2 = size < bitmap.getWidth() ? ((double) size) / ((double) bitmap.getWidth()) : Double.POSITIVE_INFINITY;
            double height2 = size2 < bitmap.getHeight() ? ((double) size2) / ((double) bitmap.getHeight()) : Double.POSITIVE_INFINITY;
            if (width2 == Double.POSITIVE_INFINITY && height2 == Double.POSITIVE_INFINITY) {
                width = bitmap.getWidth();
                height = bitmap.getHeight();
            } else if (width2 <= height2) {
                height = (int) (((double) bitmap.getHeight()) * width2);
                width = size;
            } else {
                width = (int) (((double) bitmap.getWidth()) * height2);
                height = size2;
            }
            Companion companion = INSTANCE;
            int onMeasureSpec$cropper_release = companion.getOnMeasureSpec$cropper_release(mode, size, width);
            int onMeasureSpec$cropper_release2 = companion.getOnMeasureSpec$cropper_release(mode2, size2, height);
            this.mLayoutWidth = onMeasureSpec$cropper_release;
            this.mLayoutHeight = onMeasureSpec$cropper_release2;
            setMeasuredDimension(onMeasureSpec$cropper_release, onMeasureSpec$cropper_release2);
            return;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (this.mLayoutWidth > 0 && this.mLayoutHeight > 0) {
            if (this.originalBitmap != null) {
                float f = r - l;
                float f2 = b - t;
                applyImageMatrix(f, f2, true, false);
                RectF rectF = this.mRestoreCropWindowRect;
                if (rectF != null) {
                    int i = this.mRestoreDegreesRotated;
                    if (i != this.mInitialDegreesRotated) {
                        this.mDegreesRotated = i;
                        applyImageMatrix(f, f2, true, false);
                        this.mRestoreDegreesRotated = 0;
                    }
                    this.mImageMatrix.mapRect(this.mRestoreCropWindowRect);
                    CropOverlayView cropOverlayView = this.mCropOverlayView;
                    if (cropOverlayView != null) {
                        cropOverlayView.setCropWindowRect(rectF);
                    }
                    handleCropWindowChanged(false, false);
                    CropOverlayView cropOverlayView2 = this.mCropOverlayView;
                    if (cropOverlayView2 != null) {
                        cropOverlayView2.fixCurrentCropWindowRect();
                    }
                    this.mRestoreCropWindowRect = null;
                    return;
                }
                if (this.mSizeChanged) {
                    this.mSizeChanged = false;
                    handleCropWindowChanged(false, false);
                    return;
                }
                return;
            }
            updateImageBounds(true);
            return;
        }
        updateImageBounds(true);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.mSizeChanged = oldw > 0 && oldh > 0;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x008b  */
    private final void handleCropWindowChanged(boolean inProgress, boolean animate) {
        float fMax;
        int width = getWidth();
        int height = getHeight();
        if (this.originalBitmap == null || width <= 0 || height <= 0) {
            return;
        }
        CropOverlayView cropOverlayView = this.mCropOverlayView;
        Intrinsics.checkNotNull(cropOverlayView);
        RectF cropWindowRect = cropOverlayView.getCropWindowRect();
        if (inProgress) {
            if (cropWindowRect.left < 0.0f || cropWindowRect.top < 0.0f || cropWindowRect.right > width || cropWindowRect.bottom > height) {
                applyImageMatrix(width, height, false, false);
                return;
            }
            return;
        }
        if (this.mAutoZoomEnabled || this.mZoom > 1.0f) {
            if (this.mZoom < this.mMaxZoom) {
                float f = width;
                if (cropWindowRect.width() < f * 0.5f) {
                    float f2 = height;
                    if (cropWindowRect.height() < 0.5f * f2) {
                        fMax = Math.min(this.mMaxZoom, Math.min(f / ((cropWindowRect.width() / this.mZoom) / 0.64f), f2 / ((cropWindowRect.height() / this.mZoom) / 0.64f)));
                    } else {
                        fMax = 0.0f;
                    }
                } else {
                    fMax = 0.0f;
                }
            } else {
                fMax = 0.0f;
            }
            if (this.mZoom > 1.0f) {
                float f3 = width;
                if (cropWindowRect.width() > f3 * 0.65f || cropWindowRect.height() > height * 0.65f) {
                    fMax = Math.max(1.0f, Math.min(f3 / ((cropWindowRect.width() / this.mZoom) / 0.51f), height / ((cropWindowRect.height() / this.mZoom) / 0.51f)));
                }
            }
            float f4 = this.mAutoZoomEnabled ? fMax : 1.0f;
            if (f4 <= 0.0f || f4 == this.mZoom) {
                return;
            }
            if (animate) {
                if (this.mAnimation == null) {
                    this.mAnimation = new CropImageAnimation(this.imageView, this.mCropOverlayView);
                }
                CropImageAnimation cropImageAnimation = this.mAnimation;
                Intrinsics.checkNotNull(cropImageAnimation);
                cropImageAnimation.setStartState(this.mImagePoints, this.mImageMatrix);
            }
            this.mZoom = f4;
            applyImageMatrix(width, height, true, animate);
        }
    }

    private final void applyImageMatrix(float width, float height, boolean center, boolean animate) {
        Bitmap bitmap = this.originalBitmap;
        if (bitmap != null) {
            if (width <= 0.0f || height <= 0.0f) {
                return;
            }
            this.mImageMatrix.invert(this.mImageInverseMatrix);
            CropOverlayView cropOverlayView = this.mCropOverlayView;
            Intrinsics.checkNotNull(cropOverlayView);
            RectF cropWindowRect = cropOverlayView.getCropWindowRect();
            this.mImageInverseMatrix.mapRect(cropWindowRect);
            this.mImageMatrix.reset();
            float f = 2;
            this.mImageMatrix.postTranslate((width - bitmap.getWidth()) / f, (height - bitmap.getHeight()) / f);
            mapImagePointsByImageMatrix();
            int i = this.mDegreesRotated;
            if (i > 0) {
                BitmapUtils bitmapUtils = BitmapUtils.INSTANCE;
                this.mImageMatrix.postRotate(i, bitmapUtils.getRectCenterX(this.mImagePoints), bitmapUtils.getRectCenterY(this.mImagePoints));
                mapImagePointsByImageMatrix();
            }
            BitmapUtils bitmapUtils2 = BitmapUtils.INSTANCE;
            float fMin = Math.min(width / bitmapUtils2.getRectWidth(this.mImagePoints), height / bitmapUtils2.getRectHeight(this.mImagePoints));
            ScaleType scaleType = this.mScaleType;
            if (scaleType == ScaleType.FIT_CENTER || ((scaleType == ScaleType.CENTER_INSIDE && fMin < 1.0f) || (fMin > 1.0f && this.mAutoZoomEnabled))) {
                this.mImageMatrix.postScale(fMin, fMin, bitmapUtils2.getRectCenterX(this.mImagePoints), bitmapUtils2.getRectCenterY(this.mImagePoints));
                mapImagePointsByImageMatrix();
            } else if (scaleType == ScaleType.CENTER_CROP) {
                this.mZoom = Math.max(getWidth() / bitmapUtils2.getRectWidth(this.mImagePoints), getHeight() / bitmapUtils2.getRectHeight(this.mImagePoints));
            }
            float f2 = this.mFlipHorizontally ? -this.mZoom : this.mZoom;
            float f3 = this.mFlipVertically ? -this.mZoom : this.mZoom;
            this.mImageMatrix.postScale(f2, f3, bitmapUtils2.getRectCenterX(this.mImagePoints), bitmapUtils2.getRectCenterY(this.mImagePoints));
            mapImagePointsByImageMatrix();
            this.mImageMatrix.mapRect(cropWindowRect);
            if (this.mScaleType == ScaleType.CENTER_CROP && center && !animate) {
                this.mZoomOffsetX = 0.0f;
                this.mZoomOffsetY = 0.0f;
            } else if (center) {
                this.mZoomOffsetX = width > bitmapUtils2.getRectWidth(this.mImagePoints) ? 0.0f : Math.max(Math.min((width / f) - cropWindowRect.centerX(), -bitmapUtils2.getRectLeft(this.mImagePoints)), getWidth() - bitmapUtils2.getRectRight(this.mImagePoints)) / f2;
                this.mZoomOffsetY = height <= bitmapUtils2.getRectHeight(this.mImagePoints) ? Math.max(Math.min((height / f) - cropWindowRect.centerY(), -bitmapUtils2.getRectTop(this.mImagePoints)), getHeight() - bitmapUtils2.getRectBottom(this.mImagePoints)) / f3 : 0.0f;
            } else {
                this.mZoomOffsetX = Math.min(Math.max(this.mZoomOffsetX * f2, -cropWindowRect.left), (-cropWindowRect.right) + width) / f2;
                this.mZoomOffsetY = Math.min(Math.max(this.mZoomOffsetY * f3, -cropWindowRect.top), (-cropWindowRect.bottom) + height) / f3;
            }
            this.mImageMatrix.postTranslate(this.mZoomOffsetX * f2, this.mZoomOffsetY * f3);
            cropWindowRect.offset(this.mZoomOffsetX * f2, this.mZoomOffsetY * f3);
            this.mCropOverlayView.setCropWindowRect(cropWindowRect);
            mapImagePointsByImageMatrix();
            this.mCropOverlayView.invalidate();
            if (animate) {
                CropImageAnimation cropImageAnimation = this.mAnimation;
                Intrinsics.checkNotNull(cropImageAnimation);
                cropImageAnimation.setEndState(this.mImagePoints, this.mImageMatrix);
                this.imageView.startAnimation(this.mAnimation);
            } else {
                this.imageView.setImageMatrix(this.mImageMatrix);
            }
            updateImageBounds(false);
        }
    }

    private final void mapImagePointsByImageMatrix() {
        float[] fArr = this.mImagePoints;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        Bitmap bitmap = this.originalBitmap;
        Intrinsics.checkNotNull(bitmap);
        fArr[2] = bitmap.getWidth();
        float[] fArr2 = this.mImagePoints;
        fArr2[3] = 0.0f;
        Bitmap bitmap2 = this.originalBitmap;
        Intrinsics.checkNotNull(bitmap2);
        fArr2[4] = bitmap2.getWidth();
        float[] fArr3 = this.mImagePoints;
        Bitmap bitmap3 = this.originalBitmap;
        Intrinsics.checkNotNull(bitmap3);
        fArr3[5] = bitmap3.getHeight();
        float[] fArr4 = this.mImagePoints;
        fArr4[6] = 0.0f;
        Bitmap bitmap4 = this.originalBitmap;
        Intrinsics.checkNotNull(bitmap4);
        fArr4[7] = bitmap4.getHeight();
        this.mImageMatrix.mapPoints(this.mImagePoints);
        float[] fArr5 = this.mScaleImagePoints;
        fArr5[0] = 0.0f;
        fArr5[1] = 0.0f;
        fArr5[2] = 100.0f;
        fArr5[3] = 0.0f;
        fArr5[4] = 100.0f;
        fArr5[5] = 100.0f;
        fArr5[6] = 0.0f;
        fArr5[7] = 100.0f;
        this.mImageMatrix.mapPoints(fArr5);
    }

    private final void setCropOverlayVisibility() {
        CropOverlayView cropOverlayView = this.mCropOverlayView;
        if (cropOverlayView != null) {
            cropOverlayView.setVisibility((!this.mShowCropOverlay || this.originalBitmap == null) ? 4 : 0);
        }
    }

    private final void setProgressBarVisibility() {
        this.mProgressBar.setVisibility(this.mShowProgressBar && ((this.originalBitmap == null && this.bitmapLoadingWorkerJob != null) || this.bitmapCroppingWorkerJob != null) ? 0 : 4);
    }

    private final void updateImageBounds(boolean clear) {
        if (this.originalBitmap != null && !clear) {
            float f = this.loadedSampleSize * 100.0f;
            BitmapUtils bitmapUtils = BitmapUtils.INSTANCE;
            float rectWidth = f / bitmapUtils.getRectWidth(this.mScaleImagePoints);
            float rectHeight = (this.loadedSampleSize * 100.0f) / bitmapUtils.getRectHeight(this.mScaleImagePoints);
            CropOverlayView cropOverlayView = this.mCropOverlayView;
            Intrinsics.checkNotNull(cropOverlayView);
            cropOverlayView.setCropWindowLimits(getWidth(), getHeight(), rectWidth, rectHeight);
        }
        CropOverlayView cropOverlayView2 = this.mCropOverlayView;
        Intrinsics.checkNotNull(cropOverlayView2);
        cropOverlayView2.setBounds(clear ? null : this.mImagePoints, getWidth(), getHeight());
    }

    public static class CropResult {
        private final Bitmap bitmap;
        private final float[] cropPoints;
        private final Rect cropRect;
        private final Exception error;
        private final Bitmap originalBitmap;
        private final Uri originalUri;
        private final int rotation;
        private final int sampleSize;
        private final Uri uriContent;
        private final Rect wholeImageRect;

        public CropResult(Bitmap bitmap, Uri uri, Bitmap bitmap2, Uri uri2, Exception exc, float[] cropPoints, Rect rect, Rect rect2, int i, int i2) {
            Intrinsics.checkNotNullParameter(cropPoints, "cropPoints");
            this.originalBitmap = bitmap;
            this.originalUri = uri;
            this.bitmap = bitmap2;
            this.uriContent = uri2;
            this.error = exc;
            this.cropPoints = cropPoints;
            this.cropRect = rect;
            this.wholeImageRect = rect2;
            this.rotation = i;
            this.sampleSize = i2;
        }

        public final Uri getOriginalUri() {
            return this.originalUri;
        }

        public final Uri getUriContent() {
            return this.uriContent;
        }

        public final Exception getError() {
            return this.error;
        }

        public final float[] getCropPoints() {
            return this.cropPoints;
        }

        public final Rect getCropRect() {
            return this.cropRect;
        }

        public final Rect getWholeImageRect() {
            return this.wholeImageRect;
        }

        public final int getRotation() {
            return this.rotation;
        }

        public final int getSampleSize() {
            return this.sampleSize;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getOnMeasureSpec$cropper_release(int i, int i2, int i3) {
            if (i != Integer.MIN_VALUE) {
                return i != 1073741824 ? i3 : i2;
            }
            return Math.min(i3, i2);
        }
    }

    @Override // com.canhub.cropper.CropOverlayView.CropWindowChangeListener
    public void onCropWindowChanged(boolean inProgress) {
        handleCropWindowChanged(inProgress, true);
    }
}
