package student8.example.com.counterstrike2d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class SpaceShipBody {

    protected float x; // координата х
    protected float y; // координата у
    protected float size; // размер
    protected float speed; // скорость
    protected int bitmapId; // id картинки
    protected Bitmap bitmap; // картинка
    private static final int BMP_ROWS = 3; //Рядoв в спрайте
    private static final int BMP_COLUMNS = 8; //Колон в спрайте

    void init(Context context) { // сжимаем картинку до нужных размеров
        Bitmap cBitmap = BitmapFactory.decodeResource(context.getResources(), bitmapId);
        bitmap = Bitmap.createScaledBitmap(
                cBitmap, (int)(size * GameView.unitW), (int)(size * GameView.unitH), false);
        cBitmap.recycle();
    }

    void update(){ // тут будут вычисляться новые координаты
    }

    void drow(Paint paint, Canvas canvas){ // рисуем картинку
        canvas.drawBitmap(bitmap, x*GameView.unitW, y*GameView.unitH, paint);
    }
}
