package com.canhub.cropper;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.TypedValue;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: loaded from: classes3.dex */
public final class CropImageOptions implements Parcelable {
    public static final Parcelable.Creator<CropImageOptions> CREATOR = new Creator();
    public int activityBackgroundColor;
    public int activityMenuIconColor;
    public Integer activityMenuTextColor;
    public CharSequence activityTitle;
    public boolean allowCounterRotation;
    public boolean allowFlipping;
    public boolean allowRotation;
    public int aspectRatioX;
    public int aspectRatioY;
    public boolean autoZoomEnabled;
    public int backgroundColor;
    public int borderCornerColor;
    public float borderCornerLength;
    public float borderCornerOffset;
    public float borderCornerThickness;
    public int borderLineColor;
    public float borderLineThickness;
    public boolean canChangeCropWindow;
    public boolean centerMoveEnabled;
    public int circleCornerFillColorHexValue;
    public CropImageView.CropCornerShape cornerShape;
    public float cropCornerRadius;
    public int cropMenuCropButtonIcon;
    public CharSequence cropMenuCropButtonTitle;
    public CropImageView.CropShape cropShape;
    public String cropperLabelText;
    public int cropperLabelTextColor;
    public float cropperLabelTextSize;
    public Uri customOutputUri;
    public boolean fixAspectRatio;
    public boolean flipHorizontally;
    public boolean flipVertically;
    public CropImageView.Guidelines guidelines;
    public int guidelinesColor;
    public float guidelinesThickness;
    public boolean imageSourceIncludeCamera;
    public boolean imageSourceIncludeGallery;
    public float initialCropWindowPaddingRatio;
    public Rect initialCropWindowRectangle;
    public int initialRotation;
    public List intentChooserPriorityList;
    public String intentChooserTitle;
    public int maxCropResultHeight;
    public int maxCropResultWidth;
    public int maxZoom;
    public int minCropResultHeight;
    public int minCropResultWidth;
    public int minCropWindowHeight;
    public int minCropWindowWidth;
    public boolean multiTouchEnabled;
    public boolean noOutputImage;
    public Bitmap.CompressFormat outputCompressFormat;
    public int outputCompressQuality;
    public int outputRequestHeight;
    public CropImageView.RequestSizeOptions outputRequestSizeOptions;
    public int outputRequestWidth;
    public int progressBarColor;
    public int rotationDegrees;
    public CropImageView.ScaleType scaleType;
    public boolean showCropLabel;
    public boolean showCropOverlay;
    public boolean showIntentChooser;
    public boolean showProgressBar;
    public boolean skipEditing;
    public float snapRadius;
    public Integer toolbarBackButtonColor;
    public Integer toolbarColor;
    public Integer toolbarTintColor;
    public Integer toolbarTitleColor;
    public float touchRadius;

    public static final class Creator implements Parcelable.Creator {
        /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r2v0 ??, still in use, count: 1, list:
              (r2v0 ?? I:??[OBJECT, ARRAY]) from 0x029d: RETURN (r2v0 ?? I:??[OBJECT, ARRAY])
            	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
            	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
            	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
            	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
            	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
            	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
            	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
            */
        @Override // android.os.Parcelable.Creator
        public final com.canhub.cropper.CropImageOptions createFromParcel(
        /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r2v0 ??, still in use, count: 1, list:
              (r2v0 ?? I:??[OBJECT, ARRAY]) from 0x029d: RETURN (r2v0 ?? I:??[OBJECT, ARRAY])
            	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
            	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
            	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
            	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
            	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
            	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
            */
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r74v0 ??
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:215)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            */

        @Override // android.os.Parcelable.Creator
        public final CropImageOptions[] newArray(int i) {
            return new CropImageOptions[i];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CropImageOptions)) {
            return false;
        }
        CropImageOptions cropImageOptions = (CropImageOptions) obj;
        return this.imageSourceIncludeGallery == cropImageOptions.imageSourceIncludeGallery && this.imageSourceIncludeCamera == cropImageOptions.imageSourceIncludeCamera && this.cropShape == cropImageOptions.cropShape && this.cornerShape == cropImageOptions.cornerShape && Float.compare(this.cropCornerRadius, cropImageOptions.cropCornerRadius) == 0 && Float.compare(this.snapRadius, cropImageOptions.snapRadius) == 0 && Float.compare(this.touchRadius, cropImageOptions.touchRadius) == 0 && this.guidelines == cropImageOptions.guidelines && this.scaleType == cropImageOptions.scaleType && this.showCropOverlay == cropImageOptions.showCropOverlay && this.showCropLabel == cropImageOptions.showCropLabel && this.showProgressBar == cropImageOptions.showProgressBar && this.progressBarColor == cropImageOptions.progressBarColor && this.autoZoomEnabled == cropImageOptions.autoZoomEnabled && this.multiTouchEnabled == cropImageOptions.multiTouchEnabled && this.centerMoveEnabled == cropImageOptions.centerMoveEnabled && this.canChangeCropWindow == cropImageOptions.canChangeCropWindow && this.maxZoom == cropImageOptions.maxZoom && Float.compare(this.initialCropWindowPaddingRatio, cropImageOptions.initialCropWindowPaddingRatio) == 0 && this.fixAspectRatio == cropImageOptions.fixAspectRatio && this.aspectRatioX == cropImageOptions.aspectRatioX && this.aspectRatioY == cropImageOptions.aspectRatioY && Float.compare(this.borderLineThickness, cropImageOptions.borderLineThickness) == 0 && this.borderLineColor == cropImageOptions.borderLineColor && Float.compare(this.borderCornerThickness, cropImageOptions.borderCornerThickness) == 0 && Float.compare(this.borderCornerOffset, cropImageOptions.borderCornerOffset) == 0 && Float.compare(this.borderCornerLength, cropImageOptions.borderCornerLength) == 0 && this.borderCornerColor == cropImageOptions.borderCornerColor && this.circleCornerFillColorHexValue == cropImageOptions.circleCornerFillColorHexValue && Float.compare(this.guidelinesThickness, cropImageOptions.guidelinesThickness) == 0 && this.guidelinesColor == cropImageOptions.guidelinesColor && this.backgroundColor == cropImageOptions.backgroundColor && this.minCropWindowWidth == cropImageOptions.minCropWindowWidth && this.minCropWindowHeight == cropImageOptions.minCropWindowHeight && this.minCropResultWidth == cropImageOptions.minCropResultWidth && this.minCropResultHeight == cropImageOptions.minCropResultHeight && this.maxCropResultWidth == cropImageOptions.maxCropResultWidth && this.maxCropResultHeight == cropImageOptions.maxCropResultHeight && Intrinsics.areEqual(this.activityTitle, cropImageOptions.activityTitle) && this.activityMenuIconColor == cropImageOptions.activityMenuIconColor && Intrinsics.areEqual(this.activityMenuTextColor, cropImageOptions.activityMenuTextColor) && Intrinsics.areEqual(this.customOutputUri, cropImageOptions.customOutputUri) && this.outputCompressFormat == cropImageOptions.outputCompressFormat && this.outputCompressQuality == cropImageOptions.outputCompressQuality && this.outputRequestWidth == cropImageOptions.outputRequestWidth && this.outputRequestHeight == cropImageOptions.outputRequestHeight && this.outputRequestSizeOptions == cropImageOptions.outputRequestSizeOptions && this.noOutputImage == cropImageOptions.noOutputImage && Intrinsics.areEqual(this.initialCropWindowRectangle, cropImageOptions.initialCropWindowRectangle) && this.initialRotation == cropImageOptions.initialRotation && this.allowRotation == cropImageOptions.allowRotation && this.allowFlipping == cropImageOptions.allowFlipping && this.allowCounterRotation == cropImageOptions.allowCounterRotation && this.rotationDegrees == cropImageOptions.rotationDegrees && this.flipHorizontally == cropImageOptions.flipHorizontally && this.flipVertically == cropImageOptions.flipVertically && Intrinsics.areEqual(this.cropMenuCropButtonTitle, cropImageOptions.cropMenuCropButtonTitle) && this.cropMenuCropButtonIcon == cropImageOptions.cropMenuCropButtonIcon && this.skipEditing == cropImageOptions.skipEditing && this.showIntentChooser == cropImageOptions.showIntentChooser && Intrinsics.areEqual(this.intentChooserTitle, cropImageOptions.intentChooserTitle) && Intrinsics.areEqual(this.intentChooserPriorityList, cropImageOptions.intentChooserPriorityList) && Float.compare(this.cropperLabelTextSize, cropImageOptions.cropperLabelTextSize) == 0 && this.cropperLabelTextColor == cropImageOptions.cropperLabelTextColor && Intrinsics.areEqual(this.cropperLabelText, cropImageOptions.cropperLabelText) && this.activityBackgroundColor == cropImageOptions.activityBackgroundColor && Intrinsics.areEqual(this.toolbarColor, cropImageOptions.toolbarColor) && Intrinsics.areEqual(this.toolbarTitleColor, cropImageOptions.toolbarTitleColor) && Intrinsics.areEqual(this.toolbarBackButtonColor, cropImageOptions.toolbarBackButtonColor) && Intrinsics.areEqual(this.toolbarTintColor, cropImageOptions.toolbarTintColor);
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((Boolean.hashCode(this.imageSourceIncludeGallery) * 31) + Boolean.hashCode(this.imageSourceIncludeCamera)) * 31) + this.cropShape.hashCode()) * 31) + this.cornerShape.hashCode()) * 31) + Float.hashCode(this.cropCornerRadius)) * 31) + Float.hashCode(this.snapRadius)) * 31) + Float.hashCode(this.touchRadius)) * 31) + this.guidelines.hashCode()) * 31) + this.scaleType.hashCode()) * 31) + Boolean.hashCode(this.showCropOverlay)) * 31) + Boolean.hashCode(this.showCropLabel)) * 31) + Boolean.hashCode(this.showProgressBar)) * 31) + Integer.hashCode(this.progressBarColor)) * 31) + Boolean.hashCode(this.autoZoomEnabled)) * 31) + Boolean.hashCode(this.multiTouchEnabled)) * 31) + Boolean.hashCode(this.centerMoveEnabled)) * 31) + Boolean.hashCode(this.canChangeCropWindow)) * 31) + Integer.hashCode(this.maxZoom)) * 31) + Float.hashCode(this.initialCropWindowPaddingRatio)) * 31) + Boolean.hashCode(this.fixAspectRatio)) * 31) + Integer.hashCode(this.aspectRatioX)) * 31) + Integer.hashCode(this.aspectRatioY)) * 31) + Float.hashCode(this.borderLineThickness)) * 31) + Integer.hashCode(this.borderLineColor)) * 31) + Float.hashCode(this.borderCornerThickness)) * 31) + Float.hashCode(this.borderCornerOffset)) * 31) + Float.hashCode(this.borderCornerLength)) * 31) + Integer.hashCode(this.borderCornerColor)) * 31) + Integer.hashCode(this.circleCornerFillColorHexValue)) * 31) + Float.hashCode(this.guidelinesThickness)) * 31) + Integer.hashCode(this.guidelinesColor)) * 31) + Integer.hashCode(this.backgroundColor)) * 31) + Integer.hashCode(this.minCropWindowWidth)) * 31) + Integer.hashCode(this.minCropWindowHeight)) * 31) + Integer.hashCode(this.minCropResultWidth)) * 31) + Integer.hashCode(this.minCropResultHeight)) * 31) + Integer.hashCode(this.maxCropResultWidth)) * 31) + Integer.hashCode(this.maxCropResultHeight)) * 31) + this.activityTitle.hashCode()) * 31) + Integer.hashCode(this.activityMenuIconColor)) * 31;
        Integer num = this.activityMenuTextColor;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Uri uri = this.customOutputUri;
        int iHashCode3 = (((((((((((((iHashCode2 + (uri == null ? 0 : uri.hashCode())) * 31) + this.outputCompressFormat.hashCode()) * 31) + Integer.hashCode(this.outputCompressQuality)) * 31) + Integer.hashCode(this.outputRequestWidth)) * 31) + Integer.hashCode(this.outputRequestHeight)) * 31) + this.outputRequestSizeOptions.hashCode()) * 31) + Boolean.hashCode(this.noOutputImage)) * 31;
        Rect rect = this.initialCropWindowRectangle;
        int iHashCode4 = (((((((((((((((iHashCode3 + (rect == null ? 0 : rect.hashCode())) * 31) + Integer.hashCode(this.initialRotation)) * 31) + Boolean.hashCode(this.allowRotation)) * 31) + Boolean.hashCode(this.allowFlipping)) * 31) + Boolean.hashCode(this.allowCounterRotation)) * 31) + Integer.hashCode(this.rotationDegrees)) * 31) + Boolean.hashCode(this.flipHorizontally)) * 31) + Boolean.hashCode(this.flipVertically)) * 31;
        CharSequence charSequence = this.cropMenuCropButtonTitle;
        int iHashCode5 = (((((((iHashCode4 + (charSequence == null ? 0 : charSequence.hashCode())) * 31) + Integer.hashCode(this.cropMenuCropButtonIcon)) * 31) + Boolean.hashCode(this.skipEditing)) * 31) + Boolean.hashCode(this.showIntentChooser)) * 31;
        String str = this.intentChooserTitle;
        int iHashCode6 = (iHashCode5 + (str == null ? 0 : str.hashCode())) * 31;
        List list = this.intentChooserPriorityList;
        int iHashCode7 = (((((iHashCode6 + (list == null ? 0 : list.hashCode())) * 31) + Float.hashCode(this.cropperLabelTextSize)) * 31) + Integer.hashCode(this.cropperLabelTextColor)) * 31;
        String str2 = this.cropperLabelText;
        int iHashCode8 = (((iHashCode7 + (str2 == null ? 0 : str2.hashCode())) * 31) + Integer.hashCode(this.activityBackgroundColor)) * 31;
        Integer num2 = this.toolbarColor;
        int iHashCode9 = (iHashCode8 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.toolbarTitleColor;
        int iHashCode10 = (iHashCode9 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.toolbarBackButtonColor;
        int iHashCode11 = (iHashCode10 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.toolbarTintColor;
        return iHashCode11 + (num5 != null ? num5.hashCode() : 0);
    }

    public String toString() {
        boolean z = this.imageSourceIncludeGallery;
        boolean z2 = this.imageSourceIncludeCamera;
        CropImageView.CropShape cropShape = this.cropShape;
        CropImageView.CropCornerShape cropCornerShape = this.cornerShape;
        float f = this.cropCornerRadius;
        float f2 = this.snapRadius;
        float f3 = this.touchRadius;
        CropImageView.Guidelines guidelines = this.guidelines;
        CropImageView.ScaleType scaleType = this.scaleType;
        boolean z3 = this.showCropOverlay;
        boolean z4 = this.showCropLabel;
        boolean z5 = this.showProgressBar;
        int i = this.progressBarColor;
        boolean z6 = this.autoZoomEnabled;
        boolean z7 = this.multiTouchEnabled;
        boolean z8 = this.centerMoveEnabled;
        boolean z9 = this.canChangeCropWindow;
        int i2 = this.maxZoom;
        float f4 = this.initialCropWindowPaddingRatio;
        boolean z10 = this.fixAspectRatio;
        int i3 = this.aspectRatioX;
        int i4 = this.aspectRatioY;
        float f5 = this.borderLineThickness;
        int i5 = this.borderLineColor;
        float f6 = this.borderCornerThickness;
        float f7 = this.borderCornerOffset;
        float f8 = this.borderCornerLength;
        int i6 = this.borderCornerColor;
        int i7 = this.circleCornerFillColorHexValue;
        float f9 = this.guidelinesThickness;
        int i8 = this.guidelinesColor;
        int i9 = this.backgroundColor;
        int i10 = this.minCropWindowWidth;
        int i11 = this.minCropWindowHeight;
        int i12 = this.minCropResultWidth;
        int i13 = this.minCropResultHeight;
        int i14 = this.maxCropResultWidth;
        int i15 = this.maxCropResultHeight;
        CharSequence charSequence = this.activityTitle;
        int i16 = this.activityMenuIconColor;
        Integer num = this.activityMenuTextColor;
        Uri uri = this.customOutputUri;
        Bitmap.CompressFormat compressFormat = this.outputCompressFormat;
        int i17 = this.outputCompressQuality;
        int i18 = this.outputRequestWidth;
        int i19 = this.outputRequestHeight;
        CropImageView.RequestSizeOptions requestSizeOptions = this.outputRequestSizeOptions;
        boolean z11 = this.noOutputImage;
        Rect rect = this.initialCropWindowRectangle;
        int i20 = this.initialRotation;
        boolean z12 = this.allowRotation;
        boolean z13 = this.allowFlipping;
        boolean z14 = this.allowCounterRotation;
        int i21 = this.rotationDegrees;
        boolean z15 = this.flipHorizontally;
        boolean z16 = this.flipVertically;
        CharSequence charSequence2 = this.cropMenuCropButtonTitle;
        return "CropImageOptions(imageSourceIncludeGallery=" + z + ", imageSourceIncludeCamera=" + z2 + ", cropShape=" + cropShape + ", cornerShape=" + cropCornerShape + ", cropCornerRadius=" + f + ", snapRadius=" + f2 + ", touchRadius=" + f3 + ", guidelines=" + guidelines + ", scaleType=" + scaleType + ", showCropOverlay=" + z3 + ", showCropLabel=" + z4 + ", showProgressBar=" + z5 + ", progressBarColor=" + i + ", autoZoomEnabled=" + z6 + ", multiTouchEnabled=" + z7 + ", centerMoveEnabled=" + z8 + ", canChangeCropWindow=" + z9 + ", maxZoom=" + i2 + ", initialCropWindowPaddingRatio=" + f4 + ", fixAspectRatio=" + z10 + ", aspectRatioX=" + i3 + ", aspectRatioY=" + i4 + ", borderLineThickness=" + f5 + ", borderLineColor=" + i5 + ", borderCornerThickness=" + f6 + ", borderCornerOffset=" + f7 + ", borderCornerLength=" + f8 + ", borderCornerColor=" + i6 + ", circleCornerFillColorHexValue=" + i7 + ", guidelinesThickness=" + f9 + ", guidelinesColor=" + i8 + ", backgroundColor=" + i9 + ", minCropWindowWidth=" + i10 + ", minCropWindowHeight=" + i11 + ", minCropResultWidth=" + i12 + ", minCropResultHeight=" + i13 + ", maxCropResultWidth=" + i14 + ", maxCropResultHeight=" + i15 + ", activityTitle=" + ((Object) charSequence) + ", activityMenuIconColor=" + i16 + ", activityMenuTextColor=" + num + ", customOutputUri=" + uri + ", outputCompressFormat=" + compressFormat + ", outputCompressQuality=" + i17 + ", outputRequestWidth=" + i18 + ", outputRequestHeight=" + i19 + ", outputRequestSizeOptions=" + requestSizeOptions + ", noOutputImage=" + z11 + ", initialCropWindowRectangle=" + rect + ", initialRotation=" + i20 + ", allowRotation=" + z12 + ", allowFlipping=" + z13 + ", allowCounterRotation=" + z14 + ", rotationDegrees=" + i21 + ", flipHorizontally=" + z15 + ", flipVertically=" + z16 + ", cropMenuCropButtonTitle=" + ((Object) charSequence2) + ", cropMenuCropButtonIcon=" + this.cropMenuCropButtonIcon + ", skipEditing=" + this.skipEditing + ", showIntentChooser=" + this.showIntentChooser + ", intentChooserTitle=" + this.intentChooserTitle + ", intentChooserPriorityList=" + this.intentChooserPriorityList + ", cropperLabelTextSize=" + this.cropperLabelTextSize + ", cropperLabelTextColor=" + this.cropperLabelTextColor + ", cropperLabelText=" + this.cropperLabelText + ", activityBackgroundColor=" + this.activityBackgroundColor + ", toolbarColor=" + this.toolbarColor + ", toolbarTitleColor=" + this.toolbarTitleColor + ", toolbarBackButtonColor=" + this.toolbarBackButtonColor + ", toolbarTintColor=" + this.toolbarTintColor + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.imageSourceIncludeGallery ? 1 : 0);
        dest.writeInt(this.imageSourceIncludeCamera ? 1 : 0);
        dest.writeString(this.cropShape.name());
        dest.writeString(this.cornerShape.name());
        dest.writeFloat(this.cropCornerRadius);
        dest.writeFloat(this.snapRadius);
        dest.writeFloat(this.touchRadius);
        dest.writeString(this.guidelines.name());
        dest.writeString(this.scaleType.name());
        dest.writeInt(this.showCropOverlay ? 1 : 0);
        dest.writeInt(this.showCropLabel ? 1 : 0);
        dest.writeInt(this.showProgressBar ? 1 : 0);
        dest.writeInt(this.progressBarColor);
        dest.writeInt(this.autoZoomEnabled ? 1 : 0);
        dest.writeInt(this.multiTouchEnabled ? 1 : 0);
        dest.writeInt(this.centerMoveEnabled ? 1 : 0);
        dest.writeInt(this.canChangeCropWindow ? 1 : 0);
        dest.writeInt(this.maxZoom);
        dest.writeFloat(this.initialCropWindowPaddingRatio);
        dest.writeInt(this.fixAspectRatio ? 1 : 0);
        dest.writeInt(this.aspectRatioX);
        dest.writeInt(this.aspectRatioY);
        dest.writeFloat(this.borderLineThickness);
        dest.writeInt(this.borderLineColor);
        dest.writeFloat(this.borderCornerThickness);
        dest.writeFloat(this.borderCornerOffset);
        dest.writeFloat(this.borderCornerLength);
        dest.writeInt(this.borderCornerColor);
        dest.writeInt(this.circleCornerFillColorHexValue);
        dest.writeFloat(this.guidelinesThickness);
        dest.writeInt(this.guidelinesColor);
        dest.writeInt(this.backgroundColor);
        dest.writeInt(this.minCropWindowWidth);
        dest.writeInt(this.minCropWindowHeight);
        dest.writeInt(this.minCropResultWidth);
        dest.writeInt(this.minCropResultHeight);
        dest.writeInt(this.maxCropResultWidth);
        dest.writeInt(this.maxCropResultHeight);
        TextUtils.writeToParcel(this.activityTitle, dest, i);
        dest.writeInt(this.activityMenuIconColor);
        Integer num = this.activityMenuTextColor;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        dest.writeParcelable(this.customOutputUri, i);
        dest.writeString(this.outputCompressFormat.name());
        dest.writeInt(this.outputCompressQuality);
        dest.writeInt(this.outputRequestWidth);
        dest.writeInt(this.outputRequestHeight);
        dest.writeString(this.outputRequestSizeOptions.name());
        dest.writeInt(this.noOutputImage ? 1 : 0);
        dest.writeParcelable(this.initialCropWindowRectangle, i);
        dest.writeInt(this.initialRotation);
        dest.writeInt(this.allowRotation ? 1 : 0);
        dest.writeInt(this.allowFlipping ? 1 : 0);
        dest.writeInt(this.allowCounterRotation ? 1 : 0);
        dest.writeInt(this.rotationDegrees);
        dest.writeInt(this.flipHorizontally ? 1 : 0);
        dest.writeInt(this.flipVertically ? 1 : 0);
        TextUtils.writeToParcel(this.cropMenuCropButtonTitle, dest, i);
        dest.writeInt(this.cropMenuCropButtonIcon);
        dest.writeInt(this.skipEditing ? 1 : 0);
        dest.writeInt(this.showIntentChooser ? 1 : 0);
        dest.writeString(this.intentChooserTitle);
        dest.writeStringList(this.intentChooserPriorityList);
        dest.writeFloat(this.cropperLabelTextSize);
        dest.writeInt(this.cropperLabelTextColor);
        dest.writeString(this.cropperLabelText);
        dest.writeInt(this.activityBackgroundColor);
        Integer num2 = this.toolbarColor;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
        Integer num3 = this.toolbarTitleColor;
        if (num3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num3.intValue());
        }
        Integer num4 = this.toolbarBackButtonColor;
        if (num4 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num4.intValue());
        }
        Integer num5 = this.toolbarTintColor;
        if (num5 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num5.intValue());
        }
    }

    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21, boolean z15, boolean z16, CharSequence charSequence, int i22, boolean z17, boolean z18, String str, List list, float f10, int i23, String str2, int i24, Integer num2, Integer num3, Integer num4, Integer num5) {
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
        this.imageSourceIncludeGallery = z;
        this.imageSourceIncludeCamera = z2;
        this.cropShape = cropShape;
        this.cornerShape = cornerShape;
        this.cropCornerRadius = f;
        this.snapRadius = f2;
        this.touchRadius = f3;
        this.guidelines = guidelines;
        this.scaleType = scaleType;
        this.showCropOverlay = z3;
        this.showCropLabel = z4;
        this.showProgressBar = z5;
        this.progressBarColor = i;
        this.autoZoomEnabled = z6;
        this.multiTouchEnabled = z7;
        this.centerMoveEnabled = z8;
        this.canChangeCropWindow = z9;
        this.maxZoom = i2;
        this.initialCropWindowPaddingRatio = f4;
        this.fixAspectRatio = z10;
        this.aspectRatioX = i3;
        this.aspectRatioY = i4;
        this.borderLineThickness = f5;
        this.borderLineColor = i5;
        this.borderCornerThickness = f6;
        this.borderCornerOffset = f7;
        this.borderCornerLength = f8;
        this.borderCornerColor = i6;
        this.circleCornerFillColorHexValue = i7;
        this.guidelinesThickness = f9;
        this.guidelinesColor = i8;
        this.backgroundColor = i9;
        this.minCropWindowWidth = i10;
        this.minCropWindowHeight = i11;
        this.minCropResultWidth = i12;
        this.minCropResultHeight = i13;
        this.maxCropResultWidth = i14;
        this.maxCropResultHeight = i15;
        this.activityTitle = activityTitle;
        this.activityMenuIconColor = i16;
        this.activityMenuTextColor = num;
        this.customOutputUri = uri;
        this.outputCompressFormat = outputCompressFormat;
        this.outputCompressQuality = i17;
        this.outputRequestWidth = i18;
        this.outputRequestHeight = i19;
        this.outputRequestSizeOptions = outputRequestSizeOptions;
        this.noOutputImage = z11;
        this.initialCropWindowRectangle = rect;
        this.initialRotation = i20;
        this.allowRotation = z12;
        this.allowFlipping = z13;
        this.allowCounterRotation = z14;
        this.rotationDegrees = i21;
        this.flipHorizontally = z15;
        this.flipVertically = z16;
        this.cropMenuCropButtonTitle = charSequence;
        this.cropMenuCropButtonIcon = i22;
        this.skipEditing = z17;
        this.showIntentChooser = z18;
        this.intentChooserTitle = str;
        this.intentChooserPriorityList = list;
        this.cropperLabelTextSize = f10;
        this.cropperLabelTextColor = i23;
        this.cropperLabelText = str2;
        this.activityBackgroundColor = i24;
        this.toolbarColor = num2;
        this.toolbarTitleColor = num3;
        this.toolbarBackButtonColor = num4;
        this.toolbarTintColor = num5;
        if (i2 < 0) {
            throw new IllegalArgumentException("Cannot set max zoom to a number < 1");
        }
        if (f3 < 0.0f) {
            throw new IllegalArgumentException("Cannot set touch radius value to a number <= 0 ");
        }
        if (f4 < 0.0f || f4 >= 0.5d) {
            throw new IllegalArgumentException("Cannot set initial crop window padding value to a number < 0 or >= 0.5");
        }
        if (i3 <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        }
        if (i4 <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        }
        if (f5 < 0.0f) {
            throw new IllegalArgumentException("Cannot set line thickness value to a number less than 0.");
        }
        if (f6 < 0.0f) {
            throw new IllegalArgumentException("Cannot set corner thickness value to a number less than 0.");
        }
        if (f9 < 0.0f) {
            throw new IllegalArgumentException("Cannot set guidelines thickness value to a number less than 0.");
        }
        if (i11 < 0) {
            throw new IllegalArgumentException("Cannot set min crop window height value to a number < 0 ");
        }
        if (i12 < 0) {
            throw new IllegalArgumentException("Cannot set min crop result width value to a number < 0 ");
        }
        if (i13 < 0) {
            throw new IllegalArgumentException("Cannot set min crop result height value to a number < 0 ");
        }
        if (i14 < i12) {
            throw new IllegalArgumentException("Cannot set max crop result width to smaller value than min crop result width");
        }
        if (i15 < i13) {
            throw new IllegalArgumentException("Cannot set max crop result height to smaller value than min crop result height");
        }
        if (i18 < 0) {
            throw new IllegalArgumentException("Cannot set request width value to a number < 0 ");
        }
        if (i19 < 0) {
            throw new IllegalArgumentException("Cannot set request height value to a number < 0 ");
        }
        if (i21 < 0 || i21 > 360) {
            throw new IllegalArgumentException("Cannot set rotation degrees value to a number < 0 or > 360");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cropCornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence charSequence, int i16, Integer num, Uri uri, Bitmap.CompressFormat compressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions requestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21, boolean z15, boolean z16, CharSequence charSequence2, int i22, boolean z17, boolean z18, String str, List list, float f10, int i23, String str2, int i24, Integer num2, Integer num3, Integer num4, Integer num5, int i25, int i26, int i27, DefaultConstructorMarker defaultConstructorMarker) {
        int i28;
        float fApplyDimension;
        int i29;
        int iApplyDimension;
        boolean z19 = (i25 & 1) != 0 ? true : z;
        boolean z20 = (i25 & 2) != 0 ? true : z2;
        CropImageView.CropShape cropShape2 = (i25 & 4) != 0 ? CropImageView.CropShape.RECTANGLE : cropShape;
        CropImageView.CropCornerShape cropCornerShape2 = (i25 & 8) != 0 ? CropImageView.CropCornerShape.RECTANGLE : cropCornerShape;
        float fApplyDimension2 = (i25 & 16) != 0 ? TypedValue.applyDimension(1, 10.0f, Resources.getSystem().getDisplayMetrics()) : f;
        float fApplyDimension3 = (i25 & 32) != 0 ? TypedValue.applyDimension(1, 3.0f, Resources.getSystem().getDisplayMetrics()) : f2;
        float fApplyDimension4 = (i25 & 64) != 0 ? TypedValue.applyDimension(1, 24.0f, Resources.getSystem().getDisplayMetrics()) : f3;
        CropImageView.Guidelines guidelines2 = (i25 & 128) != 0 ? CropImageView.Guidelines.ON : guidelines;
        CropImageView.ScaleType scaleType2 = (i25 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? CropImageView.ScaleType.FIT_CENTER : scaleType;
        boolean z21 = (i25 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? true : z3;
        boolean z22 = (i25 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? false : z4;
        boolean z23 = (i25 & 2048) != 0 ? true : z5;
        int iRgb = (i25 & 4096) != 0 ? Color.rgb(153, 51, 153) : i;
        boolean z24 = (i25 & 8192) != 0 ? true : z6;
        boolean z25 = z19;
        boolean z26 = (i25 & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? false : z7;
        boolean z27 = (i25 & 32768) != 0 ? true : z8;
        boolean z28 = (i25 & 65536) != 0 ? true : z9;
        int i30 = (i25 & 131072) != 0 ? 4 : i2;
        float f11 = (i25 & 262144) != 0 ? 0.0f : f4;
        boolean z29 = (i25 & 524288) != 0 ? false : z10;
        int i31 = (i25 & 1048576) != 0 ? 1 : i3;
        int i32 = (i25 & 2097152) != 0 ? 1 : i4;
        float fApplyDimension5 = (i25 & 4194304) != 0 ? TypedValue.applyDimension(1, 3.0f, Resources.getSystem().getDisplayMetrics()) : f5;
        int iArgb = (i25 & 8388608) != 0 ? Color.argb(170, 255, 255, 255) : i5;
        if ((i25 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0) {
            i28 = 1;
            fApplyDimension = TypedValue.applyDimension(1, 2.0f, Resources.getSystem().getDisplayMetrics());
        } else {
            i28 = 1;
            fApplyDimension = f6;
        }
        float fApplyDimension6 = (i25 & 33554432) != 0 ? TypedValue.applyDimension(i28, 5.0f, Resources.getSystem().getDisplayMetrics()) : f7;
        float fApplyDimension7 = (i25 & 67108864) != 0 ? TypedValue.applyDimension(i28, 14.0f, Resources.getSystem().getDisplayMetrics()) : f8;
        int i33 = (i25 & 134217728) != 0 ? -1 : i6;
        int i34 = (i25 & 268435456) != 0 ? -1 : i7;
        float fApplyDimension8 = (i25 & 536870912) != 0 ? TypedValue.applyDimension(1, 1.0f, Resources.getSystem().getDisplayMetrics()) : f9;
        int iArgb2 = (i25 & 1073741824) != 0 ? Color.argb(170, 255, 255, 255) : i8;
        int iArgb3 = (i25 & LinearLayoutManager.INVALID_OFFSET) != 0 ? Color.argb(119, 0, 0, 0) : i9;
        if ((i26 & 1) != 0) {
            i29 = 1;
            iApplyDimension = (int) TypedValue.applyDimension(1, 42.0f, Resources.getSystem().getDisplayMetrics());
        } else {
            i29 = 1;
            iApplyDimension = i10;
        }
        this(z25, z20, cropShape2, cropCornerShape2, fApplyDimension2, fApplyDimension3, fApplyDimension4, guidelines2, scaleType2, z21, z22, z23, iRgb, z24, z26, z27, z28, i30, f11, z29, i31, i32, fApplyDimension5, iArgb, fApplyDimension, fApplyDimension6, fApplyDimension7, i33, i34, fApplyDimension8, iArgb2, iArgb3, iApplyDimension, (i26 & 2) != 0 ? (int) TypedValue.applyDimension(i29, 42.0f, Resources.getSystem().getDisplayMetrics()) : i11, (i26 & 4) != 0 ? 40 : i12, (i26 & 8) != 0 ? 40 : i13, (i26 & 16) != 0 ? 99999 : i14, (i26 & 32) != 0 ? 99999 : i15, (i26 & 64) != 0 ? "" : charSequence, (i26 & 128) != 0 ? 0 : i16, (i26 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : num, (i26 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? null : uri, (i26 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? Bitmap.CompressFormat.JPEG : compressFormat, (i26 & 2048) != 0 ? 90 : i17, (i26 & 4096) != 0 ? 0 : i18, (i26 & 8192) != 0 ? 0 : i19, (i26 & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? CropImageView.RequestSizeOptions.NONE : requestSizeOptions, (i26 & 32768) != 0 ? false : z11, (i26 & 65536) != 0 ? null : rect, (i26 & 131072) != 0 ? -1 : i20, (i26 & 262144) != 0 ? true : z12, (i26 & 524288) != 0 ? true : z13, (i26 & 1048576) != 0 ? false : z14, (i26 & 2097152) != 0 ? 90 : i21, (i26 & 4194304) != 0 ? false : z15, (i26 & 8388608) != 0 ? false : z16, (i26 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? null : charSequence2, (i26 & 33554432) != 0 ? 0 : i22, (i26 & 67108864) != 0 ? false : z17, (i26 & 134217728) != 0 ? false : z18, (i26 & 268435456) != 0 ? null : str, (i26 & 536870912) != 0 ? CollectionsKt.emptyList() : list, (i26 & 1073741824) != 0 ? TypedValue.applyDimension(2, 20.0f, Resources.getSystem().getDisplayMetrics()) : f10, (i26 & LinearLayoutManager.INVALID_OFFSET) != 0 ? -1 : i23, (i27 & 1) != 0 ? "" : str2, (i27 & 2) != 0 ? -1 : i24, (i27 & 4) != 0 ? null : num2, (i27 & 8) != 0 ? null : num3, (i27 & 16) != 0 ? null : num4, (i27 & 32) != 0 ? null : num5);
    }
}
