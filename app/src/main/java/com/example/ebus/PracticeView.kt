package com.example.ebus

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View


class PracticeView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // 建立初始畫布
        val p = Paint()       // 創建畫筆
        p.isAntiAlias = true  // 設置畫筆的鋸齒效果。 true是去除。
        p.color = Color.RED  //设置画笔颜色
        p.textSize = 20F    // 設置文字的大小為 16。

        // 圓形繪畫
        canvas?.drawText("圓形：", 10F,20F, p) // 寫一段文字
        canvas?.drawCircle(80F,20F,20F, p) // 畫一個小圓
        p.style = Paint.Style.FILL_AND_STROKE //设置填充样式
//        p.strokeWidth = 100f //设置画笔宽度


        // 直線繪畫
        p.color = Color.GREEN	// 設置綠色
        canvas?.drawText("直線：",110F,20F, p)	// 寫一段文字
        p.strokeWidth = 5f
        canvas?.drawLine(170F, 20F, 200F, 20F, p) // 畫線 (起點X, 起點Y, 終點X, 終點Y, 線條型態)


        p.strokeWidth = 0f
        // 斜線繪畫
        p.color = Color.parseColor("#DC143C") // 設置crimson
        canvas?.drawText("斜線：",210F,20F, p)
        canvas?.drawLine(260F, 10F, 350F, 20F, p)


        // 弧線繪畫
        p.color = Color.parseColor("#8B0000")
        canvas!!.drawText("弧線：", 360F, 20F, p)
        p.style = Paint.Style.STROKE //設置空心
        val oval1 = RectF(410F, 0F, 440F, 30F) //繪製區域，左上座標為 (410,0) 右下座標為(440,30)
        canvas!!.drawArc(oval1, 90F, 220F, false, p)
        //	畫弧，oval1是圓弧所在的區域目標
        // 180 圓弧的起始角度
        // 90 從開始位置依順時針測量的角度
        // false 是否顯示半徑連線，true表示顯示圓弧與圓心的半徑連線，false表示不顯示。
        // p 繪製時所使用的畫筆


        // 正方形繪畫
        p.color = Color.parseColor("#FF1493")
        canvas!!.drawText("正方形：", 450F, 20F, p)
        p.style = Paint.Style.FILL //設置填滿
        canvas!!.drawRect(520F, 0F, 540F, 20F, p) // 正方形
        // (520, 0) 左上頂點座標
        // (540, 20) 右下頂點座標


        // 長方形繪畫
        p.color = Color.parseColor("#FFA07A")
        canvas!!.drawText("長方形：", 550F, 20F, p)
        p.style = Paint.Style.FILL
        canvas!!.drawRect(620F, 0F, 700F, 20F, p)


        // 扇形繪圖
        p.color = Color.parseColor("#FF7F50")
        canvas!!.drawText("扇形：", 10F, 100F, p)
        val oval2 = RectF(60F, 100F, 260F, 300F) // 設置個新繪製區域
        canvas!!.drawArc(oval2, 200F, 33F, true, p)


        // 橢圓繪圖
        p.color = Color.parseColor("#FF4500")
        canvas!!.drawText("橢圓形：", 210F, 100F, p)
        canvas!!.drawOval(RectF(280F, 100F, 320F, 200F), p)


        // 三角形繪圖
        p.color = Color.parseColor("#FF8C00")
        canvas!!.drawText("三角形：", 350F, 100F, p)
        val path = Path()
        path.moveTo(430F, 100F) // 此點為多邊形的起點
        path.lineTo(500F, 200F)
        path.lineTo(430F, 200F)
        path.close() // 使這些點構成封閉的多邊形
        canvas!!.drawPath(path, p)


        // 五角形繪圖
        p.color = Color.parseColor("#BDB76B")
        canvas!!.drawText("五角形：", 520F, 100F, p)
        p.reset() //重置
        p.color = Color.LTGRAY
        // p.setStyle(Paint.Style.STROKE);//設置空心
        val path1 = Path()
        path1.moveTo(650F, 100F)
        path1.lineTo(700F, 145F)
        path1.lineTo(675F, 200F)
        path1.lineTo(625F, 200F)
        path1.lineTo(600F, 145F)
        path1.close() //封閉
        canvas!!.drawPath(path1, p)


        // 圓角矩形繪圖
        p.textSize = 16f
        p.color = Color.parseColor("#FF00FF")
        p.isAntiAlias = true // 設置畫筆的去鋸齒效果
        canvas!!.drawText("圓角矩形：", 10F, 250F, p)
        val oval3 = RectF(130F, 250F, 400F, 400F) // 設置個新的長方形
        canvas!!.drawRoundRect(oval3, 20F, 15F, p)
        //第二個參數是 x 方向上的圓角半徑，第三個參數是y方向上的圓角半徑


        // 曲線繪圖
        p.color = Color.parseColor("#4B0082")
        canvas!!.drawText("曲線：", 430F, 250F, p)
        p.style = Paint.Style.STROKE
        val path2 = Path()
        path2.moveTo(450F, 400F) //設置Path的起點
        path2.quadTo(600F, 380F, 650F, 250F) //設置貝塞爾曲線的控制點坐標和終點坐標
        canvas!!.drawPath(path2, p) //畫出貝塞爾曲線

    }
}