import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet

class DrawingView(context:Context,attributes:AttributeSet):View(context,attributes) {

    private var mDrawPath:CustomPath?=null

    private var mCanvasBitmap:Bitmap?=null

    private var mDrawPaint:Paint?=null

    private var mCanvasPaint:Paint?=null

    private var mBrushSize:Float=0.toFloat()

    private var color= android.graphics.Color.BLACK

    private var canvas:Canvas?=null
    // canvas : on which we will draw

    init{
        setupDrawing()
    }

    private fun setupDrawing(){

        mDrawPaint=Paint()
        mDrawPath=CustomPath(color,mBrushSize)
        mDrawPaint!!.color=color
        mDrawPaint!!.style=Paint.Style.STROKE
        mDrawPaint!!.strokeJoin=Paint.Join.ROUND
        mDrawPaint!!.strokeCap=Paint.Cap.ROUND
        mCanvasPaint=Paint(android.graphics.Paint.DITHER_FLAG)
        mBrushSize=20.toFloat()







    }







    internal inner class CustomPath(
        var color:Int,
        var brushThickness:Float
    ):Path(){

    }



}