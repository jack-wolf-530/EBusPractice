package com.example.ebus

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat

class RoadCircleView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    var arriveNo = 2
    var pointLineLength = 152F
    var pointBaseRadius = 28F
    var inOutCircleDef = 6F
    var pointStartX = 36F
    var pointStartY = 36F

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val pPassPoint = Paint()
        pPassPoint.isAntiAlias = true
        pPassPoint.color = ContextCompat.getColor(context, R.color.client_colors_4)

        val pPoint = Paint()
        pPoint.isAntiAlias = true
        pPoint.color = ContextCompat.getColor(context, R.color.client_colors_3)

        val pArrive = Paint()
        pArrive.isAntiAlias = true
        pArrive.color = ContextCompat.getColor(context, R.color.client_colors_2)

        val pNotArrive = Paint()
        pNotArrive.isAntiAlias = true
        pNotArrive.color = Color.BLACK

        val pLine = Paint()
        pLine.isAntiAlias = true
        pLine.color = ContextCompat.getColor(context, R.color.client_colors_3)
        pLine.strokeWidth = 7f

        var lineX = 0F
        var circleX = 0F
        for (i in 1..6) {
            circleX = when (i) {
                1 -> {
                    pointStartX
                }
                else -> {
                    lineX + pointLineLength + pointBaseRadius
                }
            }
            var paint1:Paint
            var paint2:Paint
            if (i < arriveNo) {
                paint1 = pPassPoint
                paint2 = pNotArrive
            } else if ( i == arriveNo) {
                paint1 = pPoint
                paint2 = pArrive
            } else {
                paint1 = pPoint
                paint2 = pNotArrive
            }

            canvas?.drawCircle(circleX,pointStartY,pointBaseRadius, paint1)
            canvas?.drawCircle(circleX,pointStartY,pointBaseRadius - inOutCircleDef, paint2)
            lineX = circleX + pointBaseRadius
            if (i != 6)
                canvas?.drawLine(lineX, pointStartY, lineX + pointLineLength, pointStartY, pLine);
        }


//        canvas?.drawCircle(36F,36F,28F, pPassPoint)
//        canvas?.drawCircle(36F,36F,22F, pNotArrive)
//        canvas?.drawLine(64F, 36F, 164F, 36F, pLine);
//
//        canvas?.drawCircle(192F,36F,28F, pPoint)
//        canvas?.drawCircle(192F,36F,22F, pArrive)
//        canvas?.drawLine(220F, 36F, 320F, 36F, pLine);
//
//        canvas?.drawCircle(348F,36F,28F, pPoint)
//        canvas?.drawCircle(348F,36F,22F, pNotArrive)
//        canvas?.drawLine(376F, 36F, 476F, 36F, pLine);
//
//        canvas?.drawCircle(504F,36F,28F, pPoint)
//        canvas?.drawCircle(504F,36F,22F, pNotArrive)
//        canvas?.drawLine(532F, 36F, 632F, 36F, pLine);
//
//        canvas?.drawCircle(660F,36F,28F, pPoint)
//        canvas?.drawCircle(660F,36F,22F, pNotArrive)
//        canvas?.drawLine(688F, 36F, 788F, 36F, pLine);
//
//        canvas?.drawCircle(816F,36F,28F, pPoint)
//        canvas?.drawCircle(816F,36F,22F, pNotArrive)


    }

}