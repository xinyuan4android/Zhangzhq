package com.iningke.zhangzhq.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.iningke.baseproject.utils.LogUtils;
import com.iningke.zhangzhq.R;

public class MyTestTransformMatrixVIewActivity extends AppCompatActivity implements View.OnTouchListener {
    private TransformMatrixImageView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_my_test_transform_matrix_view);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        view = new TransformMatrixImageView(this);
        view.setScaleType(ImageView.ScaleType.MATRIX);
        view.setImageResource(R.mipmap.home_icon_manage);
        view.setBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.home_icon_manage));
        view.setOnTouchListener(this);
        LogUtils.e("width ==  " + view.getWidth() + "height == " + view.getHeight());

        setContentView(view);
    }

//    public class TestTextViwe extends TextView {
//
//        public TestTextViwe(Context context) {
//            super(context);
//        }
//
//        public TestTextViwe(Context context, AttributeSet attrs) {
//            this(context, attrs, com.android.internal.R.attr.textAppearance);
//        }
//
//        public TestTextViwe(Context context, AttributeSet attrs, int defStyleAttr) {
//            super(context, attrs, defStyleAttr);
//        }
//
//        public TestTextViwe(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//            super(context, attrs, defStyleAttr, defStyleRes);
//        }
//
//
//    }

    public class TransformMatrixImageView extends ImageView {
        private Bitmap bitmap;
        private Matrix matrix;

        public TransformMatrixImageView(Context context) {
            super(context);
//            bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.home_icon_manage);
            matrix = new Matrix();
        }

        @Override
        public void setImageMatrix(Matrix matrix) {
            this.matrix.set(matrix);
            super.setImageMatrix(matrix);
        }

        /**
         * @param canvas
         */
        @Override
        protected void onDraw(Canvas canvas) {
            // 画出原图像
            canvas.drawBitmap(bitmap, 0, 0, null);
            // 画出变换后的图像
//            canvas.drawBitmap(bitmap, matrix, new Paint(Paint.ANTI_ALIAS_FLAG));
            super.onDraw(canvas);
        }

        public Bitmap getImageBitmap() {
            return bitmap;
        }

        public void setBitmap(Bitmap bitmap) {
            this.bitmap = bitmap;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent e) {
        if (e.getAction() == MotionEvent.ACTION_UP) {
            Matrix matrix = new Matrix();
            // 输出图像的宽度和高度(162 x 251)
            LogUtils.e("TestTransformMatrixActivity" + "image size: width x height = " + view.getImageBitmap().getWidth() + " x " + view.getImageBitmap().getHeight());
            //平移
//            translate(matrix);
            //旋转
//            rotate(matrix);
            //旋转
//            rotate2(matrix);
            //缩放
            scale(matrix);
            //错切 -水平
//            skewHoriention(matrix);
            //错切-垂直
//            skewVertical(matrix);
            //错切 水平+垂直
//            skewVerticalHoriention(matrix);
            //水平对称
//            horizontal(matrix);
            //垂直对称
//            vertical(matrix);
            //关于y=x对称
//            horizontalVertical(matrix);


//            view.invalidate();
        }
        return true;
    }

    private void horizontalVertical(Matrix matrix) {
        // 10. 对称(对称轴为直线y = x)
        float matrix_values[] = {0f, -1f, 0f, -1f, 0f, 0f, 0f, 0f, 1f};
        matrix.setValues(matrix_values);
        // 下面的代码是为了查看matrix中的元素
        float[] matrixValues = new float[9];
        matrix.getValues(matrixValues);
        for (int i = 0; i < 3; ++i) {
            String temp = new String();
            for (int j = 0; j < 3; ++j) {
                temp += matrixValues[3 * i + j] + "\t";
            }
            LogUtils.e("TestTransformMatrixActivity" + temp);
        }

        // 做下面的平移变换，纯粹是为了让变换后的图像和原图像不重叠
        matrix.postTranslate(view.getImageBitmap().getHeight() + view.getImageBitmap().getWidth(),
                view.getImageBitmap().getHeight() + view.getImageBitmap().getWidth());
        view.setImageMatrix(matrix);

        // 下面的代码是为了查看matrix中的元素
        matrixValues = new float[9];
        matrix.getValues(matrixValues);
        for (int i = 0; i < 3; ++i) {
            String temp = new String();
            for (int j = 0; j < 3; ++j) {
                temp += matrixValues[3 * i + j] + "\t";
            }
            LogUtils.e("TestTransformMatrixActivity" + temp);
        }
    }

    private void vertical(Matrix matrix) {
        // 9. 对称 - 垂直
        float matrix_values[] = {-1f, 0f, 0f, 0f, 1f, 0f, 0f, 0f, 1f};
        matrix.setValues(matrix_values);
        // 下面的代码是为了查看matrix中的元素
        float[] matrixValues = new float[9];
        matrix.getValues(matrixValues);
        for (int i = 0; i < 3; ++i) {
            String temp = new String();
            for (int j = 0; j < 3; ++j) {
                temp += matrixValues[3 * i + j] + "\t";
            }
            LogUtils.e("TestTransformMatrixActivity" + temp);
        }

        // 做下面的平移变换，纯粹是为了让变换后的图像和原图像不重叠
        matrix.postTranslate(view.getImageBitmap().getWidth() * 2f, 0f);
        view.setImageMatrix(matrix);

        // 下面的代码是为了查看matrix中的元素
        matrixValues = new float[9];
        matrix.getValues(matrixValues);
        for (int i = 0; i < 3; ++i) {
            String temp = new String();
            for (int j = 0; j < 3; ++j) {
                temp += matrixValues[3 * i + j] + "\t";
            }
            LogUtils.e("TestTransformMatrixActivity" + temp);
        }
    }

    private void horizontal(Matrix matrix) {
        // 8. 对称 (水平对称)
        float matrix_values[] = {1f, 0f, 0f, 0f, -1f, 0f, 0f, 0f, 1f};
        matrix.setValues(matrix_values);
        // 下面的代码是为了查看matrix中的元素
        float[] matrixValues = new float[9];
        matrix.getValues(matrixValues);
        for (int i = 0; i < 3; ++i) {
            String temp = new String();
            for (int j = 0; j < 3; ++j) {
                temp += matrixValues[3 * i + j] + "\t";
            }
            LogUtils.e("TestTransformMatrixActivity" + temp);
        }

        // 做下面的平移变换，纯粹是为了让变换后的图像和原图像不重叠
        matrix.postTranslate(0f, view.getImageBitmap().getHeight() * 2f);
        view.setImageMatrix(matrix);

        // 下面的代码是为了查看matrix中的元素
        matrixValues = new float[9];
        matrix.getValues(matrixValues);
        for (int i = 0; i < 3; ++i) {
            String temp = new String();
            for (int j = 0; j < 3; ++j) {
                temp += matrixValues[3 * i + j] + "\t";
            }
            LogUtils.e("TestTransformMatrixActivity" + temp);
        }
    }

    private void skewVerticalHoriention(Matrix matrix) {
        //7. 错切 - 水平 + 垂直
        matrix.setSkew(0.5f, 0.5f);
        // 下面的代码是为了查看matrix中的元素
        float[] matrixValues = new float[9];
        matrix.getValues(matrixValues);
        for (int i = 0; i < 3; ++i) {
            String temp = new String();
            for (int j = 0; j < 3; ++j) {
                temp += matrixValues[3 * i + j] + "\t";
            }
            LogUtils.e("TestTransformMatrixActivity" + temp);
        }

        // 做下面的平移变换，纯粹是为了让变换后的图像和原图像不重叠
        matrix.postTranslate(0f, view.getImageBitmap().getHeight());
        view.setImageMatrix(matrix);

        // 下面的代码是为了查看matrix中的元素
        matrixValues = new float[9];
        matrix.getValues(matrixValues);
        for (int i = 0; i < 3; ++i) {
            String temp = new String();
            for (int j = 0; j < 3; ++j) {
                temp += matrixValues[3 * i + j] + "\t";
            }
            LogUtils.e("TestTransformMatrixActivity" + temp);
        }
    }

    private void skewVertical(Matrix matrix) {
        // 6. 错切 - 垂直
        matrix.setSkew(0f, 0.5f);
        // 下面的代码是为了查看matrix中的元素
        float[] matrixValues = new float[9];
        matrix.getValues(matrixValues);
        for (int i = 0; i < 3; ++i) {
            String temp = new String();
            for (int j = 0; j < 3; ++j) {
                temp += matrixValues[3 * i + j] + "\t";
            }
            LogUtils.e("TestTransformMatrixActivity" + temp);
        }

        // 做下面的平移变换，纯粹是为了让变换后的图像和原图像不重叠
        matrix.postTranslate(0f, view.getImageBitmap().getHeight());
        view.setImageMatrix(matrix);

        // 下面的代码是为了查看matrix中的元素
        matrixValues = new float[9];
        matrix.getValues(matrixValues);
        for (int i = 0; i < 3; ++i) {
            String temp = new String();
            for (int j = 0; j < 3; ++j) {
                temp += matrixValues[3 * i + j] + "\t";
            }
            LogUtils.e("TestTransformMatrixActivity" + temp);
        }
    }

    private void skewHoriention(Matrix matrix) {
        // 5. 错切 - 水平
        matrix.setSkew(0.5f, 0f);
        // 下面的代码是为了查看matrix中的元素
        float[] matrixValues = new float[9];
        matrix.getValues(matrixValues);
        for (int i = 0; i < 3; ++i) {
            String temp = new String();
            for (int j = 0; j < 3; ++j) {
                temp += matrixValues[3 * i + j] + "\t";
            }
            LogUtils.e("TestTransformMatrixActivity" + temp);
        }

        // 做下面的平移变换，纯粹是为了让变换后的图像和原图像不重叠
        matrix.postTranslate(view.getImageBitmap().getWidth(), 0f);
        view.setImageMatrix(matrix);

        // 下面的代码是为了查看matrix中的元素
        matrixValues = new float[9];
        matrix.getValues(matrixValues);
        for (int i = 0; i < 3; ++i) {
            String temp = new String();
            for (int j = 0; j < 3; ++j) {
                temp += matrixValues[3 * i + j] + "\t";
            }
            LogUtils.e("TestTransformMatrixActivity" + temp);
        }
    }

    private void scale(Matrix matrix) {
        // 4. 缩放
        matrix.setScale(0.5f, 0.5f);
        // 下面的代码是为了查看matrix中的元素
        float[] matrixValues = new float[9];
        matrix.getValues(matrixValues);
        for (int i = 0; i < 3; ++i) {
            String temp = new String();
            for (int j = 0; j < 3; ++j) {
                temp += matrixValues[3 * i + j] + "\t";
            }
            LogUtils.e("TestTransformMatrixActivity" + temp);
        }

        // 做下面的平移变换，纯粹是为了让变换后的图像和原图像不重叠
        matrix.postTranslate(view.getImageBitmap().getWidth(), view.getImageBitmap().getHeight());
        view.setImageMatrix(matrix);

        // 下面的代码是为了查看matrix中的元素
        matrixValues = new float[9];
        matrix.getValues(matrixValues);
        for (int i = 0; i < 3; ++i) {
            String temp = new String();
            for (int j = 0; j < 3; ++j) {
                temp += matrixValues[3 * i + j] + "\t";
            }
            LogUtils.e("TestTransformMatrixActivity" + temp);
        }
    }

    private void rotate2(Matrix matrix) {
        // 3. 旋转(围绕坐标原点) + 平移(效果同2)
        matrix.setRotate(45f);
        matrix.preTranslate(-1f * view.getImageBitmap().getWidth() / 2f, -1f * view.getImageBitmap().getHeight() / 2f);
        matrix.postTranslate((float) view.getImageBitmap().getWidth() / 2f, (float) view.getImageBitmap().getHeight() / 2f);

        // 做下面的平移变换，纯粹是为了让变换后的图像和原图像不重叠
        matrix.postTranslate((float) view.getImageBitmap().getWidth() * 1.5f, 0f);
        view.setImageMatrix(matrix);

        // 下面的代码是为了查看matrix中的元素
        float[] matrixValues = new float[9];
        matrix.getValues(matrixValues);
        for (int i = 0; i < 3; ++i) {
            String temp = new String();
            for (int j = 0; j < 3; ++j) {
                temp += matrixValues[3 * i + j] + "\t";
            }
            LogUtils.e("TestTransformMatrixActivity" + temp);
        }
    }


    private void rotate(Matrix matrix) {
        // 2. 旋转(围绕图像的中心点)
        matrix.setRotate(45f, view.getImageBitmap().getWidth() / 2f, view.getImageBitmap().getHeight() / 2f);

        // 做下面的平移变换，纯粹是为了让变换后的图像和原图像不重叠
        matrix.postTranslate(view.getImageBitmap().getWidth() * 1.5f, 0f);
        view.setImageMatrix(matrix);

        // 下面的代码是为了查看matrix中的元素
        float[] matrixValues = new float[9];
        matrix.getValues(matrixValues);
        for (int i = 0; i < 3; ++i) {
            String temp = new String();
            for (int j = 0; j < 3; ++j) {
                temp += matrixValues[3 * i + j] + "\t";
            }
            LogUtils.e("TestTransformMatrixActivity" + temp);
        }
    }

    private void translate(Matrix matrix) {
        // 1. 平移
        matrix.postTranslate(view.getImageBitmap().getWidth(), view.getImageBitmap().getHeight());
        // 在x方向平移view.getImageBitmap().getWidth()，在y轴方向view.getImageBitmap().getHeight()
        view.setImageMatrix(matrix);

        // 下面的代码是为了查看matrix中的元素
        float[] matrixValues = new float[9];
        matrix.getValues(matrixValues);
        for (int i = 0; i < 3; ++i) {
            String temp = new String();
            for (int j = 0; j < 3; ++j) {
                temp += matrixValues[3 * i + j] + "\t";
            }
            LogUtils.e("TestTransformMatrixActivity" + temp);
        }
    }
}