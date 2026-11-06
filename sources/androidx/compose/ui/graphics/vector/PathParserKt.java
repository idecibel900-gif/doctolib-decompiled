package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.Path;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class PathParserKt {
    private static final float[] EmptyArray = new float[0];

    public static final Path toPath(List list, Path path) {
        float f;
        float f2;
        float x1;
        float x2;
        float y2;
        float dy2;
        float f3;
        float f4;
        float dx1;
        float dy1;
        float dy3;
        List list2 = list;
        Path path2 = path;
        int iMo1304getFillTypeRgk1Os = path2.mo1304getFillTypeRgk1Os();
        path2.rewind();
        path2.mo1306setFillTypeoQ8Xj4U(iMo1304getFillTypeRgk1Os);
        PathNode pathNode = list2.isEmpty() ? PathNode.Close.INSTANCE : (PathNode) list2.get(0);
        int size = list2.size();
        float f5 = 0.0f;
        int i = 0;
        float arcStartX = 0.0f;
        float arcStartY = 0.0f;
        float x = 0.0f;
        float y = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        while (i < size) {
            PathNode pathNode2 = (PathNode) list2.get(i);
            if (pathNode2 instanceof PathNode.Close) {
                path2.close();
                size = size;
                f5 = f5;
                i = i;
                pathNode2 = pathNode2;
                arcStartX = f6;
                x = arcStartX;
                arcStartY = f7;
            } else {
                if (pathNode2 instanceof PathNode.RelativeMoveTo) {
                    PathNode.RelativeMoveTo relativeMoveTo = (PathNode.RelativeMoveTo) pathNode2;
                    x += relativeMoveTo.getDx();
                    y += relativeMoveTo.getDy();
                    path2.relativeMoveTo(relativeMoveTo.getDx(), relativeMoveTo.getDy());
                    f6 = x;
                    f7 = y;
                } else if (pathNode2 instanceof PathNode.MoveTo) {
                    PathNode.MoveTo moveTo = (PathNode.MoveTo) pathNode2;
                    float x3 = moveTo.getX();
                    float y3 = moveTo.getY();
                    path2.moveTo(moveTo.getX(), moveTo.getY());
                    x = x3;
                    f6 = x;
                    y = y3;
                    f7 = y;
                } else {
                    if (pathNode2 instanceof PathNode.RelativeLineTo) {
                        PathNode.RelativeLineTo relativeLineTo = (PathNode.RelativeLineTo) pathNode2;
                        path2.relativeLineTo(relativeLineTo.getDx(), relativeLineTo.getDy());
                        x += relativeLineTo.getDx();
                        dy2 = relativeLineTo.getDy();
                    } else {
                        if (pathNode2 instanceof PathNode.LineTo) {
                            PathNode.LineTo lineTo = (PathNode.LineTo) pathNode2;
                            path2.lineTo(lineTo.getX(), lineTo.getY());
                            x2 = lineTo.getX();
                            y2 = lineTo.getY();
                        } else if (pathNode2 instanceof PathNode.RelativeHorizontalTo) {
                            PathNode.RelativeHorizontalTo relativeHorizontalTo = (PathNode.RelativeHorizontalTo) pathNode2;
                            path2.relativeLineTo(relativeHorizontalTo.getDx(), f5);
                            x += relativeHorizontalTo.getDx();
                        } else if (pathNode2 instanceof PathNode.HorizontalTo) {
                            PathNode.HorizontalTo horizontalTo = (PathNode.HorizontalTo) pathNode2;
                            path2.lineTo(horizontalTo.getX(), y);
                            x = horizontalTo.getX();
                        } else if (pathNode2 instanceof PathNode.RelativeVerticalTo) {
                            PathNode.RelativeVerticalTo relativeVerticalTo = (PathNode.RelativeVerticalTo) pathNode2;
                            path2.relativeLineTo(f5, relativeVerticalTo.getDy());
                            dy2 = relativeVerticalTo.getDy();
                        } else if (pathNode2 instanceof PathNode.VerticalTo) {
                            PathNode.VerticalTo verticalTo = (PathNode.VerticalTo) pathNode2;
                            path2.lineTo(x, verticalTo.getY());
                            y = verticalTo.getY();
                        } else {
                            if (pathNode2 instanceof PathNode.RelativeCurveTo) {
                                PathNode.RelativeCurveTo relativeCurveTo = (PathNode.RelativeCurveTo) pathNode2;
                                path2.relativeCubicTo(relativeCurveTo.getDx1(), relativeCurveTo.getDy1(), relativeCurveTo.getDx2(), relativeCurveTo.getDy2(), relativeCurveTo.getDx3(), relativeCurveTo.getDy3());
                                dx1 = relativeCurveTo.getDx2() + x;
                                dy1 = relativeCurveTo.getDy2() + y;
                                x += relativeCurveTo.getDx3();
                                dy3 = relativeCurveTo.getDy3();
                            } else {
                                if (pathNode2 instanceof PathNode.CurveTo) {
                                    PathNode.CurveTo curveTo = (PathNode.CurveTo) pathNode2;
                                    path.cubicTo(curveTo.getX1(), curveTo.getY1(), curveTo.getX2(), curveTo.getY2(), curveTo.getX3(), curveTo.getY3());
                                    float x4 = curveTo.getX2();
                                    float y4 = curveTo.getY2();
                                    float x5 = curveTo.getX3();
                                    float y5 = curveTo.getY3();
                                    x = x5;
                                    y = y5;
                                    size = size;
                                    f5 = f5;
                                    i = i;
                                    pathNode2 = pathNode2;
                                    arcStartX = x4;
                                    arcStartY = y4;
                                } else if (pathNode2 instanceof PathNode.RelativeReflectiveCurveTo) {
                                    if (pathNode.isCurve()) {
                                        float f8 = x - arcStartX;
                                        f4 = y - arcStartY;
                                        f3 = f8;
                                    } else {
                                        f3 = f5;
                                        f4 = f3;
                                    }
                                    PathNode.RelativeReflectiveCurveTo relativeReflectiveCurveTo = (PathNode.RelativeReflectiveCurveTo) pathNode2;
                                    path.relativeCubicTo(f3, f4, relativeReflectiveCurveTo.getDx1(), relativeReflectiveCurveTo.getDy1(), relativeReflectiveCurveTo.getDx2(), relativeReflectiveCurveTo.getDy2());
                                    dx1 = relativeReflectiveCurveTo.getDx1() + x;
                                    dy1 = relativeReflectiveCurveTo.getDy1() + y;
                                    x += relativeReflectiveCurveTo.getDx2();
                                    dy3 = relativeReflectiveCurveTo.getDy2();
                                } else {
                                    if (pathNode2 instanceof PathNode.ReflectiveCurveTo) {
                                        if (pathNode.isCurve()) {
                                            float f9 = 2;
                                            x = (x * f9) - arcStartX;
                                            y = (f9 * y) - arcStartY;
                                        }
                                        PathNode.ReflectiveCurveTo reflectiveCurveTo = (PathNode.ReflectiveCurveTo) pathNode2;
                                        path.cubicTo(x, y, reflectiveCurveTo.getX1(), reflectiveCurveTo.getY1(), reflectiveCurveTo.getX2(), reflectiveCurveTo.getY2());
                                        x1 = reflectiveCurveTo.getX1();
                                        float y1 = reflectiveCurveTo.getY1();
                                        float x6 = reflectiveCurveTo.getX2();
                                        float y6 = reflectiveCurveTo.getY2();
                                        x = x6;
                                        y = y6;
                                        arcStartY = y1;
                                    } else if (pathNode2 instanceof PathNode.RelativeQuadTo) {
                                        PathNode.RelativeQuadTo relativeQuadTo = (PathNode.RelativeQuadTo) pathNode2;
                                        path.relativeQuadraticTo(relativeQuadTo.getDx1(), relativeQuadTo.getDy1(), relativeQuadTo.getDx2(), relativeQuadTo.getDy2());
                                        arcStartX = relativeQuadTo.getDx1() + x;
                                        arcStartY = relativeQuadTo.getDy1() + y;
                                        x += relativeQuadTo.getDx2();
                                        dy2 = relativeQuadTo.getDy2();
                                    } else if (pathNode2 instanceof PathNode.QuadTo) {
                                        PathNode.QuadTo quadTo = (PathNode.QuadTo) pathNode2;
                                        path.quadraticTo(quadTo.getX1(), quadTo.getY1(), quadTo.getX2(), quadTo.getY2());
                                        arcStartX = quadTo.getX1();
                                        arcStartY = quadTo.getY1();
                                        x2 = quadTo.getX2();
                                        y2 = quadTo.getY2();
                                    } else if (pathNode2 instanceof PathNode.RelativeReflectiveQuadTo) {
                                        if (pathNode.isQuad()) {
                                            f = x - arcStartX;
                                            f2 = y - arcStartY;
                                        } else {
                                            f = f5;
                                            f2 = f;
                                        }
                                        PathNode.RelativeReflectiveQuadTo relativeReflectiveQuadTo = (PathNode.RelativeReflectiveQuadTo) pathNode2;
                                        path.relativeQuadraticTo(f, f2, relativeReflectiveQuadTo.getDx(), relativeReflectiveQuadTo.getDy());
                                        x1 = f + x;
                                        float f10 = f2 + y;
                                        x += relativeReflectiveQuadTo.getDx();
                                        y += relativeReflectiveQuadTo.getDy();
                                        arcStartY = f10;
                                    } else if (pathNode2 instanceof PathNode.ReflectiveQuadTo) {
                                        if (pathNode.isQuad()) {
                                            float f11 = 2;
                                            x = (x * f11) - arcStartX;
                                            y = (f11 * y) - arcStartY;
                                        }
                                        PathNode.ReflectiveQuadTo reflectiveQuadTo = (PathNode.ReflectiveQuadTo) pathNode2;
                                        path.quadraticTo(x, y, reflectiveQuadTo.getX(), reflectiveQuadTo.getY());
                                        float f12 = x;
                                        x = reflectiveQuadTo.getX();
                                        arcStartX = f12;
                                        size = size;
                                        f5 = f5;
                                        i = i;
                                        arcStartY = y;
                                        pathNode2 = pathNode2;
                                        y = reflectiveQuadTo.getY();
                                    } else if (pathNode2 instanceof PathNode.RelativeArcTo) {
                                        PathNode.RelativeArcTo relativeArcTo = (PathNode.RelativeArcTo) pathNode2;
                                        float arcStartDx = relativeArcTo.getArcStartDx() + x;
                                        float arcStartDy = relativeArcTo.getArcStartDy() + y;
                                        f5 = f5;
                                        pathNode2 = pathNode2;
                                        size = size;
                                        i = i;
                                        drawArc(path, x, y, arcStartDx, arcStartDy, relativeArcTo.getHorizontalEllipseRadius(), relativeArcTo.getVerticalEllipseRadius(), relativeArcTo.getTheta(), relativeArcTo.isMoreThanHalf(), relativeArcTo.isPositiveArc());
                                        arcStartX = arcStartDx;
                                        x = arcStartX;
                                        arcStartY = arcStartDy;
                                    } else {
                                        size = size;
                                        f5 = f5;
                                        i = i;
                                        pathNode2 = pathNode2;
                                        if (pathNode2 instanceof PathNode.ArcTo) {
                                            PathNode.ArcTo arcTo = (PathNode.ArcTo) pathNode2;
                                            drawArc(path, x, y, arcTo.getArcStartX(), arcTo.getArcStartY(), arcTo.getHorizontalEllipseRadius(), arcTo.getVerticalEllipseRadius(), arcTo.getTheta(), arcTo.isMoreThanHalf(), arcTo.isPositiveArc());
                                            arcStartX = arcTo.getArcStartX();
                                            x = arcStartX;
                                            arcStartY = arcTo.getArcStartY();
                                        }
                                    }
                                    arcStartX = x1;
                                }
                                i++;
                                path2 = path;
                                pathNode = pathNode2;
                                size = size;
                                f5 = f5;
                                list2 = list;
                            }
                            y += dy3;
                            arcStartX = dx1;
                            arcStartY = dy1;
                        }
                        y = y2;
                        x = x2;
                    }
                    y += dy2;
                }
                pathNode2 = pathNode2;
                i++;
                path2 = path;
                pathNode = pathNode2;
                size = size;
                f5 = f5;
                list2 = list;
            }
            y = arcStartY;
            i++;
            path2 = path;
            pathNode = pathNode2;
            size = size;
            f5 = f5;
            list2 = list;
        }
        return path;
    }

    private static final void drawArc(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, boolean z, boolean z2) {
        double d8;
        double d9;
        double d10 = (d7 / ((double) SensibleDefaults.X_OFFSET)) * 3.141592653589793d;
        double dCos = Math.cos(d10);
        double dSin = Math.sin(d10);
        double d11 = ((d * dCos) + (d2 * dSin)) / d5;
        double d12 = (((-d) * dSin) + (d2 * dCos)) / d6;
        double d13 = ((d3 * dCos) + (d4 * dSin)) / d5;
        double d14 = (((-d3) * dSin) + (d4 * dCos)) / d6;
        double d15 = d11 - d13;
        double d16 = d12 - d14;
        double d17 = 2;
        double d18 = (d11 + d13) / d17;
        double d19 = (d12 + d14) / d17;
        double d20 = (d15 * d15) + (d16 * d16);
        if (d20 == 0.0d) {
            return;
        }
        double d21 = (1.0d / d20) - 0.25d;
        if (d21 < 0.0d) {
            double dSqrt = (float) (Math.sqrt(d20) / 1.99999d);
            drawArc(path, d, d2, d3, d4, d5 * dSqrt, d6 * dSqrt, d7, z, z2);
            return;
        }
        double dSqrt2 = Math.sqrt(d21);
        double d22 = d15 * dSqrt2;
        double d23 = dSqrt2 * d16;
        if (z == z2) {
            d8 = d18 - d23;
            d9 = d19 + d22;
        } else {
            d8 = d18 + d23;
            d9 = d19 - d22;
        }
        double dAtan2 = Math.atan2(d12 - d9, d11 - d8);
        double dAtan3 = Math.atan2(d14 - d9, d13 - d8) - dAtan2;
        if (z2 != (dAtan3 >= 0.0d)) {
            dAtan3 = dAtan3 > 0.0d ? dAtan3 - 6.283185307179586d : dAtan3 + 6.283185307179586d;
        }
        double d24 = d8 * d5;
        double d25 = d9 * d6;
        arcToBezier(path, (d24 * dCos) - (d25 * dSin), (d24 * dSin) + (d25 * dCos), d5, d6, d, d2, d10, dAtan2, dAtan3);
    }

    private static final void arcToBezier(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        double d10 = 4;
        int iCeil = (int) Math.ceil(Math.abs((d9 * d10) / 3.141592653589793d));
        double dCos = Math.cos(d7);
        double dSin = Math.sin(d7);
        double dCos2 = Math.cos(d8);
        double dSin2 = Math.sin(d8);
        double d11 = -d3;
        double d12 = d11 * dCos;
        double d13 = d4 * dSin;
        double d14 = (d12 * dSin2) - (d13 * dCos2);
        double d15 = d11 * dSin;
        double d16 = d4 * dCos;
        double d17 = (dSin2 * d15) + (dCos2 * d16);
        double d18 = d9 / ((double) iCeil);
        double d19 = d17;
        double d20 = d14;
        int i = 0;
        double d21 = d5;
        double d22 = d6;
        double d23 = d8;
        while (i < iCeil) {
            double d24 = d23 + d18;
            double dSin3 = Math.sin(d24);
            double dCos3 = Math.cos(d24);
            int i2 = i;
            double d25 = (d + ((d3 * dCos) * dCos3)) - (d13 * dSin3);
            double d26 = d10;
            double d27 = d2 + (d3 * dSin * dCos3) + (d16 * dSin3);
            double d28 = (d12 * dSin3) - (d13 * dCos3);
            double d29 = (dSin3 * d15) + (dCos3 * d16);
            double d30 = d24 - d23;
            int i3 = iCeil;
            double dTan = Math.tan(d30 / ((double) 2));
            double dSin4 = (Math.sin(d30) * (Math.sqrt(d26 + ((3.0d * dTan) * dTan)) - ((double) 1))) / ((double) 3);
            path.cubicTo((float) (d21 + (d20 * dSin4)), (float) (d22 + (d19 * dSin4)), (float) (d25 - (dSin4 * d28)), (float) (d27 - (dSin4 * d29)), (float) d25, (float) d27);
            dSin = dSin;
            d18 = d18;
            d21 = d25;
            d22 = d27;
            i = i2 + 1;
            d23 = d24;
            d19 = d29;
            iCeil = i3;
            d20 = d28;
            dCos = dCos;
            d10 = d26;
        }
    }
}
