package com.iningke.zhangzhq.service;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.activity.SelectAreaActivity;
import com.iningke.zhangzhq.base.ZhangzhqActivity;
import com.iningke.zhangzhq.inter.App;
import com.iningke.zhangzhq.myview.MyShowGalleryCameraPopupWindow;
import com.iningke.zhangzhq.utils.ImageChooserUtils;
import com.iningke.zhangzhq.utils.PackageUtils;
import com.joooonho.SelectableRoundedImageView;
import com.kbeanie.imagechooser.api.ChooserType;
import com.kbeanie.imagechooser.api.ChosenImage;
import com.kbeanie.imagechooser.api.ChosenImages;
import com.kbeanie.imagechooser.api.ImageChooserListener;
import com.kbeanie.imagechooser.api.ImageChooserManager;
import com.kbeanie.imagechooser.exceptions.ChooserException;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 申请报修界面
 *
 * @author hxy
 * @date 2016/11/21
 */
public class ServiceApplyFixActivity extends ZhangzhqActivity implements ImageChooserListener, MyShowGalleryCameraPopupWindow.OnMyGalleryAndCameraClickListener {


    @Bind(R.id.common_img_back)
    ImageView commonImgBack;
    @Bind(R.id.common_txt_title)
    TextView commonTxtTitle;
    @Bind(R.id.common_img_right)
    ImageView commonImgRight;
    @Bind(R.id.service_applyFix_edit_name)
    EditText serviceApplyFixEditName;
    @Bind(R.id.service_applyFix_edit_phone)
    EditText serviceApplyFixEditPhone;
    @Bind(R.id.service_applyFix_txt_selectArea)
    TextView serviceApplyFixTxtSelectArea;
    @Bind(R.id.service_applyFix_linear_selectArea)
    LinearLayout serviceApplyFixLinearSelectArea;
    @Bind(R.id.service_applyFix_edit_address)
    EditText serviceApplyFixEditAddress;
    @Bind(R.id.service_applyFix_txt_selectType)
    TextView serviceApplyFixTxtSelectType;
    @Bind(R.id.service_applyFix_linear_selectType)
    LinearLayout serviceApplyFixLinearSelectType;
    @Bind(R.id.service_applyFix_edit_detail)
    EditText serviceApplyFixEditDetail;
    @Bind(R.id.service_applyFix_linear_uploadImg_1)
    LinearLayout serviceApplyFixLinearUploadImg1;
    @Bind(R.id.service_applyFix_linear_uploadImg_2)
    LinearLayout serviceApplyFixLinearUploadImg2;
    @Bind(R.id.service_applyFix_linear_uploadImg_3)
    LinearLayout serviceApplyFixLinearUploadImg3;
    @Bind(R.id.service_applyFix_txt_comfrim)
    TextView serviceApplyFixTxtComfrim;
    @Bind(R.id.service_applyFix_txt_comfrimExpress)
    TextView serviceApplyFixTxtComfrimExpress;


    private ImageChooserManager imageChooserManager;
    private int which_picture = 0;

    SelectableRoundedImageView serviceApplyFixImg1;
    SelectableRoundedImageView serviceApplyFixImg2;
    SelectableRoundedImageView serviceApplyFixImg3;
    private MyShowGalleryCameraPopupWindow popupWindow;

    @Override
    public int setLayoutId() {
        return R.layout.activity_service_apply_fix;
    }

    @Override
    public void initView() {
        commonTxtTitle.setText("我要报修");
        commonImgBack.setVisibility(View.VISIBLE);
        //TODO 设置ImageChooser图片的 存放目录，， 根目录是sd卡的根目录 即上面的path；
        ImageChooserUtils utils = new ImageChooserUtils();
        utils.setFolderName(PackageUtils.getPackageName() + "/applyFix");
        serviceApplyFixImg1 = (SelectableRoundedImageView) findViewById(R.id.service_applyFix_img_1);
        serviceApplyFixImg2 = (SelectableRoundedImageView) findViewById(R.id.service_applyFix_img_2);
        serviceApplyFixImg3 = (SelectableRoundedImageView) findViewById(R.id.service_applyFix_img_3);
    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.common_img_back, R.id.service_applyFix_linear_selectArea, R.id.service_applyFix_linear_selectType, R.id.service_applyFix_linear_uploadImg_1, R.id.service_applyFix_linear_uploadImg_2, R.id.service_applyFix_linear_uploadImg_3, R.id.service_applyFix_txt_comfrim, R.id.service_applyFix_txt_comfrimExpress})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.common_img_back:
                finish();
                break;
            case R.id.service_applyFix_linear_selectArea:
                Intent intent = new Intent(this, SelectAreaActivity.class);
                intent.putExtra("selectType", App.type_selectArea);
                startActivityForResult(intent, 100);
                break;
            case R.id.service_applyFix_linear_selectType:
                Intent intent2 = new Intent(this, SelectAreaActivity.class);
                intent2.putExtra("selectType", 100);
                startActivityForResult(intent2, 200);
                break;
            case R.id.service_applyFix_linear_uploadImg_1:
                which_picture = 100;
                showGalleryCameraPopupWindow();
                break;
            case R.id.service_applyFix_linear_uploadImg_2:
                which_picture = 200;
                showGalleryCameraPopupWindow();
                break;
            case R.id.service_applyFix_linear_uploadImg_3:
                which_picture = 300;
                showGalleryCameraPopupWindow();
                break;
            case R.id.service_applyFix_txt_comfrim:
                break;
            case R.id.service_applyFix_txt_comfrimExpress:
                break;
        }
    }

    private void showGalleryCameraPopupWindow() {
        popupWindow = new MyShowGalleryCameraPopupWindow();
        popupWindow.initPopupWindow(this, R.layout.activity_service_apply_fix, this);
    }

    @Override
    protected void permissionDenied(int requestCode) {
        super.permissionDenied(requestCode);
        //权限拒绝
        Toast.makeText(this, "拒绝了", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void permissionGrant(int requestCode) {
        super.permissionGrant(requestCode);
        //权限允许
        switch (requestCode) {
            case App.RequestCode_Camera:
                showCamera();
                break;
            case App.RequestCode_Gallery:
                showGallery();
                break;
        }
    }

    //跳相册
    private void showGallery() {
        try {
            imageChooserManager = new ImageChooserManager(this,
                    ChooserType.REQUEST_PICK_PICTURE);
            imageChooserManager.clearOldFiles();
            imageChooserManager.setImageChooserListener(this);
            String path = imageChooserManager.choose();
        } catch (ChooserException e) {
            e.printStackTrace();
        }
    }

    //跳相机
    private void showCamera() {
        try {
            imageChooserManager = new ImageChooserManager(this,
                    ChooserType.REQUEST_CAPTURE_PICTURE);
            imageChooserManager.clearOldFiles();
            imageChooserManager.setImageChooserListener(this);
            String path = imageChooserManager.choose();
        } catch (ChooserException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        if (resultCode == RESULT_OK &&
                (requestCode == ChooserType.REQUEST_PICK_PICTURE ||
                        requestCode == ChooserType.REQUEST_CAPTURE_PICTURE)) {
            imageChooserManager.submit(requestCode, data);
        }
        String result = data.getStringExtra("result");
        if (null == result || "".equals(result)) {
            return;
        }
        switch (requestCode) {
            case App.type_selectArea:
                //area
                serviceApplyFixTxtSelectArea.setText(result);
                break;
            case 200:
                //type
                serviceApplyFixTxtSelectType.setText(result);
                break;
        }
    }


    @Override
    public void onImageChosen(final ChosenImage chosenImage) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (chosenImage != null) {
                    String filePathOriginal = chosenImage.getFileThumbnailSmall();
                    Bitmap bitmap = BitmapFactory.decodeFile(filePathOriginal);
                    switch (which_picture) {
                        case 100:
                            serviceApplyFixImg1.setImageBitmap(bitmap);
                            serviceApplyFixImg1.setTag(filePathOriginal);
                            aboutImageViewUpload(true, false, false);
                            break;
                        case 200:
                            serviceApplyFixImg2.setImageBitmap(bitmap);
                            serviceApplyFixImg2.setTag(filePathOriginal);
                            aboutImageViewUpload(true, true, false);
                            break;
                        case 300:
                            serviceApplyFixImg3.setImageBitmap(bitmap);
                            serviceApplyFixImg3.setTag(filePathOriginal);
                            aboutImageViewUpload(true, true, true);
                            break;
                    }
                }
            }
        });
    }

    private void aboutImageViewUpload(boolean img1, boolean img2, boolean img3) {

        serviceApplyFixLinearUploadImg1.setVisibility(View.GONE);
        serviceApplyFixImg1.setVisibility(img1 ? View.VISIBLE : View.GONE);

        serviceApplyFixLinearUploadImg2.setVisibility(img1 ? View.VISIBLE : View.GONE);
        serviceApplyFixImg2.setVisibility(img2 ? View.VISIBLE : View.GONE);

        serviceApplyFixLinearUploadImg3.setVisibility(img2 ? View.VISIBLE : View.GONE);
        serviceApplyFixImg3.setVisibility(img3 ? View.VISIBLE : View.GONE);

    }

    @Override
    public void onError(String s) {

    }

    @Override
    public void onImagesChosen(ChosenImages chosenImages) {

    }


    @Override
    public void onMyCameraClick(View view) {
        popupWindow.disMiss();
        checkPermission(Manifest.permission_group.CAMERA, App.RequestCode_Camera);
    }

    @Override
    public void onMyGalleryClick(View view) {
        popupWindow.disMiss();
        checkPermission(Manifest.permission_group.STORAGE, App.RequestCode_Gallery);
    }

    @Override
    public void onMyCancelClick(View view) {
        popupWindow.disMiss();
    }
}
