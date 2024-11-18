package com.example.project6

import android.content.Context
import android.graphics.*
import android.view.View

class CustomView(context: Context) : View(context) {

    private val paint = Paint().apply {
        color = Color.BLUE
        style = Paint.Style.FILL
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Increase spacing by adjusting the coordinates
        val width = width.toFloat()
        val height = height.toFloat()

        // Draw Rectangle (with added spacing)
        canvas.drawRect(50f, 50f, 250f, 200f, paint) // Adjust Y coordinate for space below

        // Draw Circle (below the rectangle with space)
        canvas.drawCircle(150f, 300f, 100f, paint) // Adjust Y coordinate for space above

        // Draw Line (below the circle with space)
        paint.color = Color.RED // Change color for line
        canvas.drawLine(50f, 450f, 250f, 450f, paint) // Adjust Y coordinate for space above

        // Draw Triangle (below the line with space)
        paint.color = Color.GREEN // Change color for triangle
        val path = Path().apply {
            moveTo(150f, 500f) // Adjust Y coordinate for space above
            lineTo(100f, 600f)
            lineTo(200f, 600f)
            close()
        }
        canvas.drawPath(path, paint)
    }
}
