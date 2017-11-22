package student8.example.com.counterstrike2d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Man {

    protected float x; // координата х
    protected float y; // координата у
    protected float size; // размер
    protected float speed; // скорость
    protected int bitmapId; // id картинки
    protected Bitmap bitmap; // картинка

    public Man(Context context) {
        bitmapId = R.drawable.stand; // определяем начальные параметры
        size = GameView.maxY/24;
        y = GameView.maxY - size - 1;
        x = 7;
        speed = (float) 0.2;

        init(context); // инициализируем персонажа
    }

    public void update() { // перемещаем персонажа в зависимости от нажатой кнопки
        if (MainActivity.isLeftPressed && x >= 0) {
            x -= speed;
        }
        if (MainActivity.isRightPressed && x <= GameView.maxX - 5) {
            x += speed;
        }
    }

    void init(Context context) { // сжимаем картинку до нужных размеров
        Bitmap cBitmap = BitmapFactory.decodeResource(context.getResources(), bitmapId);
        bitmap = Bitmap.createScaledBitmap(
                cBitmap, (int)(size * GameView.unitW), (int)(size * GameView.unitH), false);
        cBitmap.recycle();
    }

    void drow(Paint paint, Canvas canvas){ // рисуем картинку
        canvas.drawBitmap(bitmap, x*GameView.unitW, y*GameView.unitH, paint);
    }
}
