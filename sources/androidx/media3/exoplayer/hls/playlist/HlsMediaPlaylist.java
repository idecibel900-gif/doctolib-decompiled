package androidx.media3.exoplayer.hls.playlist;

import android.net.Uri;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.util.Assertions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class HlsMediaPlaylist extends HlsPlaylist {
    public final int discontinuitySequence;
    public final long durationUs;
    public final boolean hasDiscontinuitySequence;
    public final boolean hasEndTag;
    public final boolean hasPositiveStartOffset;
    public final boolean hasProgramDateTime;
    public final ImmutableList interstitials;
    public final long mediaSequence;
    public final long partTargetDurationUs;
    public final int playlistType;
    public final boolean preciseStart;
    public final DrmInitData protectionSchemes;
    public final Map renditionReports;
    public final List segments;
    public final ServerControl serverControl;
    public final long startOffsetUs;
    public final long startTimeUs;
    public final long targetDurationUs;
    public final List trailingParts;
    public final int version;

    @Override // androidx.media3.exoplayer.offline.FilterableManifest
    public HlsMediaPlaylist copy(List list) {
        return this;
    }

    public static final class ServerControl {
        public final boolean canBlockReload;
        public final boolean canSkipDateRanges;
        public final long holdBackUs;
        public final long partHoldBackUs;
        public final long skipUntilUs;

        public ServerControl(long j, boolean z, long j2, long j3, boolean z2) {
            this.skipUntilUs = j;
            this.canSkipDateRanges = z;
            this.holdBackUs = j2;
            this.partHoldBackUs = j3;
            this.canBlockReload = z2;
        }
    }

    public static final class Segment extends SegmentBase {
        public final List parts;
        public final String title;

        public Segment(String str, long j, long j2, String str2, String str3) {
            this(str, null, "", 0L, -1, -9223372036854775807L, null, str2, str3, j, j2, false, ImmutableList.of());
        }

        public Segment(String str, Segment segment, String str2, long j, int i, long j2, DrmInitData drmInitData, String str3, String str4, long j3, long j4, boolean z, List list) {
            super(str, segment, j, i, j2, drmInitData, str3, str4, j3, j4, z);
            this.title = str2;
            this.parts = ImmutableList.copyOf((Collection) list);
        }

        public Segment copyWith(long j, int i) {
            ArrayList arrayList = new ArrayList();
            long j2 = j;
            for (int i2 = 0; i2 < this.parts.size(); i2++) {
                Part part = (Part) this.parts.get(i2);
                arrayList.add(part.copyWith(j2, i));
                j2 += part.durationUs;
            }
            return new Segment(this.url, this.initializationSegment, this.title, this.durationUs, i, j, this.drmInitData, this.fullSegmentEncryptionKeyUri, this.encryptionIV, this.byteRangeOffset, this.byteRangeLength, this.hasGapTag, arrayList);
        }
    }

    public static final class Part extends SegmentBase {
        public final boolean isIndependent;
        public final boolean isPreload;

        public Part(String str, Segment segment, long j, int i, long j2, DrmInitData drmInitData, String str2, String str3, long j3, long j4, boolean z, boolean z2, boolean z3) {
            super(str, segment, j, i, j2, drmInitData, str2, str3, j3, j4, z);
            this.isIndependent = z2;
            this.isPreload = z3;
        }

        public Part copyWith(long j, int i) {
            return new Part(this.url, this.initializationSegment, this.durationUs, i, j, this.drmInitData, this.fullSegmentEncryptionKeyUri, this.encryptionIV, this.byteRangeOffset, this.byteRangeLength, this.hasGapTag, this.isIndependent, this.isPreload);
        }
    }

    public static class SegmentBase implements Comparable {
        public final long byteRangeLength;
        public final long byteRangeOffset;
        public final DrmInitData drmInitData;
        public final long durationUs;
        public final String encryptionIV;
        public final String fullSegmentEncryptionKeyUri;
        public final boolean hasGapTag;
        public final Segment initializationSegment;
        public final int relativeDiscontinuitySequence;
        public final long relativeStartTimeUs;
        public final String url;

        private SegmentBase(String str, Segment segment, long j, int i, long j2, DrmInitData drmInitData, String str2, String str3, long j3, long j4, boolean z) {
            this.url = str;
            this.initializationSegment = segment;
            this.durationUs = j;
            this.relativeDiscontinuitySequence = i;
            this.relativeStartTimeUs = j2;
            this.drmInitData = drmInitData;
            this.fullSegmentEncryptionKeyUri = str2;
            this.encryptionIV = str3;
            this.byteRangeOffset = j3;
            this.byteRangeLength = j4;
            this.hasGapTag = z;
        }

        @Override // java.lang.Comparable
        public int compareTo(Long l) {
            if (this.relativeStartTimeUs > l.longValue()) {
                return 1;
            }
            return this.relativeStartTimeUs < l.longValue() ? -1 : 0;
        }
    }

    public static final class RenditionReport {
        public final long lastMediaSequence;
        public final int lastPartIndex;
        public final Uri playlistUri;

        public RenditionReport(Uri uri, long j, int i) {
            this.playlistUri = uri;
            this.lastMediaSequence = j;
            this.lastPartIndex = i;
        }
    }

    public static final class Interstitial {
        public final Uri assetListUri;
        public final Uri assetUri;
        public final ImmutableList clientDefinedAttributes;
        public final boolean contentMayVary;
        public final List cue;
        public final long durationUs;
        public final long endDateUnixUs;
        public final boolean endOnNext;
        public final String id;
        public final long plannedDurationUs;
        public final long playoutLimitUs;
        public final ImmutableList restrictions;
        public final long resumeOffsetUs;
        public final ImmutableList snapTypes;
        public final long startDateUnixUs;
        public final String timelineOccupies;
        public final String timelineStyle;

        public Interstitial(String str, Uri uri, Uri uri2, long j, long j2, long j3, long j4, List list, boolean z, long j5, long j6, List list2, List list3, List list4, boolean z2, String str2, String str3) {
            Assertions.checkArgument((uri == null || uri2 == null) && !(uri == null && uri2 == null));
            this.id = str;
            this.assetUri = uri;
            this.assetListUri = uri2;
            this.startDateUnixUs = j;
            this.endDateUnixUs = j2;
            this.durationUs = j3;
            this.plannedDurationUs = j4;
            this.cue = list;
            this.endOnNext = z;
            this.resumeOffsetUs = j5;
            this.playoutLimitUs = j6;
            this.snapTypes = ImmutableList.copyOf((Collection) list2);
            this.restrictions = ImmutableList.copyOf((Collection) list3);
            this.clientDefinedAttributes = ImmutableList.sortedCopyOf(new Comparator() { // from class: androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist$Interstitial$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return ((HlsMediaPlaylist.ClientDefinedAttribute) obj).name.compareTo(((HlsMediaPlaylist.ClientDefinedAttribute) obj2).name);
                }
            }, list4);
            this.contentMayVary = z2;
            this.timelineOccupies = str2;
            this.timelineStyle = str3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Interstitial)) {
                return false;
            }
            Interstitial interstitial = (Interstitial) obj;
            return this.startDateUnixUs == interstitial.startDateUnixUs && this.endDateUnixUs == interstitial.endDateUnixUs && this.durationUs == interstitial.durationUs && this.plannedDurationUs == interstitial.plannedDurationUs && this.endOnNext == interstitial.endOnNext && this.resumeOffsetUs == interstitial.resumeOffsetUs && this.playoutLimitUs == interstitial.playoutLimitUs && this.contentMayVary == interstitial.contentMayVary && Objects.equals(this.id, interstitial.id) && Objects.equals(this.assetUri, interstitial.assetUri) && Objects.equals(this.assetListUri, interstitial.assetListUri) && Objects.equals(this.cue, interstitial.cue) && Objects.equals(this.snapTypes, interstitial.snapTypes) && Objects.equals(this.restrictions, interstitial.restrictions) && Objects.equals(this.clientDefinedAttributes, interstitial.clientDefinedAttributes) && Objects.equals(this.timelineOccupies, interstitial.timelineOccupies) && Objects.equals(this.timelineStyle, interstitial.timelineStyle);
        }

        public int hashCode() {
            return Objects.hash(this.id, this.assetUri, this.assetListUri, Long.valueOf(this.startDateUnixUs), Long.valueOf(this.endDateUnixUs), Long.valueOf(this.durationUs), Long.valueOf(this.plannedDurationUs), this.cue, Boolean.valueOf(this.endOnNext), Long.valueOf(this.resumeOffsetUs), Long.valueOf(this.playoutLimitUs), this.snapTypes, this.restrictions, this.clientDefinedAttributes, Boolean.valueOf(this.contentMayVary), this.timelineOccupies, this.timelineStyle);
        }

        public static final class Builder {
            private Uri assetListUri;
            private Uri assetUri;
            private Boolean contentMayVary;
            private boolean endOnNext;
            private final String id;
            private String timelineOccupies;
            private String timelineStyle;
            private final Map clientDefinedAttributes = new HashMap();
            private long startDateUnixUs = -9223372036854775807L;
            private long endDateUnixUs = -9223372036854775807L;
            private long durationUs = -9223372036854775807L;
            private long plannedDurationUs = -9223372036854775807L;
            private List cue = new ArrayList();
            private long resumeOffsetUs = -9223372036854775807L;
            private long playoutLimitUs = -9223372036854775807L;
            private List snapTypes = new ArrayList();
            private List restrictions = new ArrayList();

            public Builder(String str) {
                this.id = str;
            }

            public Builder setAssetUri(Uri uri) {
                if (uri == null) {
                    return this;
                }
                Uri uri2 = this.assetUri;
                if (uri2 != null) {
                    Assertions.checkArgument(uri2.equals(uri), "Can't change assetUri from " + this.assetUri + " to " + uri);
                }
                this.assetUri = uri;
                return this;
            }

            public Builder setAssetListUri(Uri uri) {
                if (uri == null) {
                    return this;
                }
                Uri uri2 = this.assetListUri;
                if (uri2 != null) {
                    Assertions.checkArgument(uri2.equals(uri), "Can't change assetListUri from " + this.assetListUri + " to " + uri);
                }
                this.assetListUri = uri;
                return this;
            }

            public Builder setStartDateUnixUs(long j) {
                if (j == -9223372036854775807L) {
                    return this;
                }
                long j2 = this.startDateUnixUs;
                if (j2 != -9223372036854775807L) {
                    Assertions.checkArgument(j2 == j, "Can't change startDateUnixUs from " + this.startDateUnixUs + " to " + j);
                }
                this.startDateUnixUs = j;
                return this;
            }

            public Builder setEndDateUnixUs(long j) {
                if (j == -9223372036854775807L) {
                    return this;
                }
                long j2 = this.endDateUnixUs;
                if (j2 != -9223372036854775807L) {
                    Assertions.checkArgument(j2 == j, "Can't change endDateUnixUs from " + this.endDateUnixUs + " to " + j);
                }
                this.endDateUnixUs = j;
                return this;
            }

            public Builder setDurationUs(long j) {
                if (j == -9223372036854775807L) {
                    return this;
                }
                long j2 = this.durationUs;
                if (j2 != -9223372036854775807L) {
                    Assertions.checkArgument(j2 == j, "Can't change durationUs from " + this.durationUs + " to " + j);
                }
                this.durationUs = j;
                return this;
            }

            public Builder setPlannedDurationUs(long j) {
                if (j == -9223372036854775807L) {
                    return this;
                }
                long j2 = this.plannedDurationUs;
                if (j2 != -9223372036854775807L) {
                    Assertions.checkArgument(j2 == j, "Can't change plannedDurationUs from " + this.plannedDurationUs + " to " + j);
                }
                this.plannedDurationUs = j;
                return this;
            }

            public Builder setCue(List list) {
                if (list.isEmpty()) {
                    return this;
                }
                if (!this.cue.isEmpty()) {
                    Assertions.checkArgument(this.cue.equals(list), "Can't change cue from " + HlsMediaPlaylist$Interstitial$Builder$$ExternalSyntheticBackport0.m(", ", this.cue) + " to " + HlsMediaPlaylist$Interstitial$Builder$$ExternalSyntheticBackport0.m(", ", list));
                }
                this.cue = list;
                return this;
            }

            public Builder setEndOnNext(boolean z) {
                if (!z) {
                    return this;
                }
                this.endOnNext = true;
                return this;
            }

            public Builder setResumeOffsetUs(long j) {
                if (j == -9223372036854775807L) {
                    return this;
                }
                long j2 = this.resumeOffsetUs;
                if (j2 != -9223372036854775807L) {
                    Assertions.checkArgument(j2 == j, "Can't change resumeOffsetUs from " + this.resumeOffsetUs + " to " + j);
                }
                this.resumeOffsetUs = j;
                return this;
            }

            public Builder setPlayoutLimitUs(long j) {
                if (j == -9223372036854775807L) {
                    return this;
                }
                long j2 = this.playoutLimitUs;
                if (j2 != -9223372036854775807L) {
                    Assertions.checkArgument(j2 == j, "Can't change playoutLimitUs from " + this.playoutLimitUs + " to " + j);
                }
                this.playoutLimitUs = j;
                return this;
            }

            public Builder setSnapTypes(List list) {
                if (list.isEmpty()) {
                    return this;
                }
                if (!this.snapTypes.isEmpty()) {
                    Assertions.checkArgument(this.snapTypes.equals(list), "Can't change snapTypes from " + HlsMediaPlaylist$Interstitial$Builder$$ExternalSyntheticBackport0.m(", ", this.snapTypes) + " to " + HlsMediaPlaylist$Interstitial$Builder$$ExternalSyntheticBackport0.m(", ", list));
                }
                this.snapTypes = list;
                return this;
            }

            public Builder setRestrictions(List list) {
                if (list.isEmpty()) {
                    return this;
                }
                if (!this.restrictions.isEmpty()) {
                    Assertions.checkArgument(this.restrictions.equals(list), "Can't change restrictions from " + HlsMediaPlaylist$Interstitial$Builder$$ExternalSyntheticBackport0.m(", ", this.restrictions) + " to " + HlsMediaPlaylist$Interstitial$Builder$$ExternalSyntheticBackport0.m(", ", list));
                }
                this.restrictions = list;
                return this;
            }

            public Builder setClientDefinedAttributes(List list) {
                if (!list.isEmpty()) {
                    for (int i = 0; i < list.size(); i++) {
                        ClientDefinedAttribute clientDefinedAttribute = (ClientDefinedAttribute) list.get(i);
                        String str = clientDefinedAttribute.name;
                        ClientDefinedAttribute clientDefinedAttribute2 = (ClientDefinedAttribute) this.clientDefinedAttributes.get(str);
                        if (clientDefinedAttribute2 != null) {
                            Assertions.checkArgument(clientDefinedAttribute2.equals(clientDefinedAttribute), "Can't change " + str + " from " + clientDefinedAttribute2.textValue + " " + clientDefinedAttribute2.doubleValue + " to " + clientDefinedAttribute.textValue + " " + clientDefinedAttribute.doubleValue);
                        }
                        this.clientDefinedAttributes.put(str, clientDefinedAttribute);
                    }
                }
                return this;
            }

            public Builder setContentMayVary(Boolean bool) {
                if (bool == null) {
                    return this;
                }
                Boolean bool2 = this.contentMayVary;
                if (bool2 != null) {
                    Assertions.checkArgument(bool2.equals(bool), "Can't change contentMayVary from " + this.contentMayVary + " to " + bool);
                }
                this.contentMayVary = bool;
                return this;
            }

            public Builder setTimelineOccupies(String str) {
                if (str == null) {
                    return this;
                }
                String str2 = this.timelineOccupies;
                if (str2 != null) {
                    Assertions.checkArgument(str2.equals(str), "Can't change timelineOccupies from " + this.timelineOccupies + " to " + str);
                }
                this.timelineOccupies = str;
                return this;
            }

            public Builder setTimelineStyle(String str) {
                if (str == null) {
                    return this;
                }
                String str2 = this.timelineStyle;
                if (str2 != null) {
                    Assertions.checkArgument(str2.equals(str), "Can't change timelineStyle from " + this.timelineStyle + " to " + str);
                }
                this.timelineStyle = str;
                return this;
            }

            public Interstitial build() {
                Uri uri = this.assetListUri;
                if ((uri != null || this.assetUri == null) && (uri == null || this.assetUri != null)) {
                    return null;
                }
                long j = this.startDateUnixUs;
                if (j == -9223372036854775807L) {
                    return null;
                }
                String str = this.id;
                Uri uri2 = this.assetUri;
                long j2 = this.endDateUnixUs;
                long j3 = this.durationUs;
                long j4 = this.plannedDurationUs;
                List list = this.cue;
                boolean z = this.endOnNext;
                long j5 = this.resumeOffsetUs;
                long j6 = this.playoutLimitUs;
                List list2 = this.snapTypes;
                List list3 = this.restrictions;
                ArrayList arrayList = new ArrayList(this.clientDefinedAttributes.values());
                Boolean bool = this.contentMayVary;
                boolean z2 = bool == null || bool.booleanValue();
                String str2 = this.timelineOccupies;
                if (str2 == null) {
                    str2 = "POINT";
                }
                String str3 = str2;
                String str4 = this.timelineStyle;
                if (str4 == null) {
                    str4 = "HIGHLIGHT";
                }
                return new Interstitial(str, uri2, uri, j, j2, j3, j4, list, z, j5, j6, list2, list3, arrayList, z2, str3, str4);
            }
        }
    }

    public static class ClientDefinedAttribute {
        private final double doubleValue;
        public final String name;
        private final String textValue;
        public final int type;

        public ClientDefinedAttribute(String str, double d) {
            this.name = str;
            this.type = 2;
            this.doubleValue = d;
            this.textValue = null;
        }

        public ClientDefinedAttribute(String str, String str2, int i) {
            boolean z = true;
            if (i == 1 && !str2.startsWith("0x") && !str2.startsWith("0X")) {
                z = false;
            }
            Assertions.checkState(z);
            this.name = str;
            this.type = i;
            this.textValue = str2;
            this.doubleValue = 0.0d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ClientDefinedAttribute)) {
                return false;
            }
            ClientDefinedAttribute clientDefinedAttribute = (ClientDefinedAttribute) obj;
            return this.type == clientDefinedAttribute.type && Double.compare(this.doubleValue, clientDefinedAttribute.doubleValue) == 0 && Objects.equals(this.name, clientDefinedAttribute.name) && Objects.equals(this.textValue, clientDefinedAttribute.textValue);
        }

        public int hashCode() {
            return Objects.hash(this.name, Integer.valueOf(this.type), Double.valueOf(this.doubleValue), this.textValue);
        }
    }

    public HlsMediaPlaylist(int i, String str, List list, long j, boolean z, long j2, boolean z2, int i2, long j3, int i3, long j4, long j5, boolean z3, boolean z4, boolean z5, DrmInitData drmInitData, List list2, List list3, ServerControl serverControl, Map map, List list4) {
        super(str, list, z3);
        this.playlistType = i;
        this.startTimeUs = j2;
        this.preciseStart = z;
        this.hasDiscontinuitySequence = z2;
        this.discontinuitySequence = i2;
        this.mediaSequence = j3;
        this.version = i3;
        this.targetDurationUs = j4;
        this.partTargetDurationUs = j5;
        this.hasEndTag = z4;
        this.hasProgramDateTime = z5;
        this.protectionSchemes = drmInitData;
        this.segments = ImmutableList.copyOf((Collection) list2);
        this.trailingParts = ImmutableList.copyOf((Collection) list3);
        this.renditionReports = ImmutableMap.copyOf(map);
        this.interstitials = ImmutableList.copyOf((Collection) list4);
        if (!list3.isEmpty()) {
            Part part = (Part) Iterables.getLast(list3);
            this.durationUs = part.relativeStartTimeUs + part.durationUs;
        } else if (!list2.isEmpty()) {
            Segment segment = (Segment) Iterables.getLast(list2);
            this.durationUs = segment.relativeStartTimeUs + segment.durationUs;
        } else {
            this.durationUs = 0L;
        }
        long jMax = -9223372036854775807L;
        if (j != -9223372036854775807L) {
            if (j >= 0) {
                jMax = Math.min(this.durationUs, j);
            } else {
                jMax = Math.max(0L, this.durationUs + j);
            }
        }
        this.startOffsetUs = jMax;
        this.hasPositiveStartOffset = j >= 0;
        this.serverControl = serverControl;
    }

    public boolean isNewerThan(HlsMediaPlaylist hlsMediaPlaylist) {
        if (hlsMediaPlaylist != null) {
            long j = this.mediaSequence;
            long j2 = hlsMediaPlaylist.mediaSequence;
            if (j <= j2) {
                if (j < j2) {
                    return false;
                }
                int size = this.segments.size() - hlsMediaPlaylist.segments.size();
                if (size != 0) {
                    return size > 0;
                }
                int size2 = this.trailingParts.size();
                int size3 = hlsMediaPlaylist.trailingParts.size();
                if (size2 <= size3 && (size2 != size3 || !this.hasEndTag || hlsMediaPlaylist.hasEndTag)) {
                    return false;
                }
            }
        }
        return true;
    }

    public long getEndTimeUs() {
        return this.startTimeUs + this.durationUs;
    }

    public HlsMediaPlaylist copyWith(long j, int i) {
        return new HlsMediaPlaylist(this.playlistType, this.baseUri, this.tags, this.startOffsetUs, this.preciseStart, j, true, i, this.mediaSequence, this.version, this.targetDurationUs, this.partTargetDurationUs, this.hasIndependentSegments, this.hasEndTag, this.hasProgramDateTime, this.protectionSchemes, this.segments, this.trailingParts, this.serverControl, this.renditionReports, this.interstitials);
    }

    public HlsMediaPlaylist copyWithEndTag() {
        return this.hasEndTag ? this : new HlsMediaPlaylist(this.playlistType, this.baseUri, this.tags, this.startOffsetUs, this.preciseStart, this.startTimeUs, this.hasDiscontinuitySequence, this.discontinuitySequence, this.mediaSequence, this.version, this.targetDurationUs, this.partTargetDurationUs, this.hasIndependentSegments, true, this.hasProgramDateTime, this.protectionSchemes, this.segments, this.trailingParts, this.serverControl, this.renditionReports, this.interstitials);
    }
}
