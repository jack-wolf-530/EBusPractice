package com.example.ebus

import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat

class RoadTriangleView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        setBackgroundColor(Color.BLACK)

        val p = Paint()
        p.isAntiAlias = true
        p.color = Color.WHITE
        //繪製圓角多邊形（即三角形、矩形等）的簡單示例
        var radius = 20F
        var cornerPathEffect = CornerPathEffect(radius)
        p.pathEffect = cornerPathEffect

        val path = Path()
        path.moveTo(0F, 0F)
        path.lineTo(60F, 30F)
        path.lineTo(0F, 60F)
        path.close()
        canvas!!.drawPath(path, p)




    }
}