package mx.edu.ittepic.ladm_u2_ejercicio5canvasanimado

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View

class Lienzo(p : MainActivity) : View(p)
{
    var puntero = p
    var cx = 150f
    var cy = 150f
    var tx = 733f
    var ty = 818f

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        var p = Paint()

        canvas.drawColor(Color.BLACK)
        p.color = Color.RED
        canvas.drawCircle(cx, cy, 120f, p)
        p.style = Paint.Style.STROKE
        p.color = Color.WHITE
        p.strokeWidth = 10f
        canvas.drawCircle(cx, cy, 120f, p)

        //CUADRADO
        p.style = Paint.Style.FILL
        p.color = Color.GREEN
        canvas.drawRect(tx, ty, tx + 200, ty + 200, p)

        p.style = Paint.Style.STROKE
        p.color = Color.BLUE
        canvas.drawRect(tx, ty, tx + 200, ty + 200, p)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when(event.action)
        {
            MotionEvent.ACTION_DOWN -> {
                puntero.setTitle("DOWN(${event.x.toInt()}, ${event.y.toInt()})")
                cy = event.y
                cx = event.x

                tx = event.x
                ty = event.y
            }

            MotionEvent.ACTION_MOVE -> {
                puntero.setTitle("MOVE(${event.x.toInt()}, ${event.y.toInt()})")
                cy = event.y
                cx = event.x

                tx = event.x
                ty = event.y
            }

            MotionEvent.ACTION_UP -> {
                puntero.setTitle("UP(${event.x.toInt()}, ${event.y.toInt()})")
                cy = event.y
                cx = event.x

                tx = event.x
                ty = event.y
            }
        }
        invalidate()
        return true //super.onTouchEvent(event)
    }
}