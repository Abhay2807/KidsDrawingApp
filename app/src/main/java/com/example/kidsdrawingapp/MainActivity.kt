package com.example.kidsdrawingapp

import android.app.Dialog
//import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get

class MainActivity : AppCompatActivity() {

    private var drawingView:DrawingView?=null
    private var mIBCurrentColor:ImageButton?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawingView=findViewById(R.id.drawingView)

        drawingView?.setSizeForBrush(20.toFloat())

        val llColors:LinearLayout=findViewById(R.id.ll_colors)
        mIBCurrentColor=llColors[1] as ImageButton

        mIBCurrentColor!!.setImageDrawable(
            ContextCompat.getDrawable(this,R.drawable.pallet_selected)
        )

        val brushBtn:ImageButton=findViewById(R.id.ib_btn_brush)
        brushBtn.setOnClickListener{
            brushSizeChooserDialog()
        }

    }

    private fun brushSizeChooserDialog(){

        val brushDialog=Dialog(this)
        brushDialog.setContentView(R.layout.brushsize_dialog)
        brushDialog.setTitle("Brush Size: ")
        brushDialog.show()

        val smallBtn:ImageButton=brushDialog.findViewById(R.id.small_brush)
        smallBtn.setOnClickListener{
            drawingView?.setSizeForBrush(10.toFloat())
            brushDialog.dismiss()
        }

        val mediumBtn:ImageButton=brushDialog.findViewById(R.id.medium_brush)
        mediumBtn.setOnClickListener{
            drawingView?.setSizeForBrush(20.toFloat())
            brushDialog.dismiss()
        }

        val largeBtn:ImageButton=brushDialog.findViewById(R.id.large_brush)
        largeBtn.setOnClickListener{
            drawingView?.setSizeForBrush(30.toFloat())
            brushDialog.dismiss()
        }

    }

    fun paintClicked(view: View){
        if(mIBCurrentColor!=view){
            val ibtn=view as ImageButton
            val colorTag=ibtn.tag.toString()
            drawingView?.setColor(colorTag)

            ibtn.setImageDrawable(
                ContextCompat.getDrawable(this,R.drawable.pallet_selected)
            )

            mIBCurrentColor!!.setImageDrawable(
                ContextCompat.getDrawable(this,R.drawable.pallet_normal)
            )
            mIBCurrentColor=view
        }

    }



}