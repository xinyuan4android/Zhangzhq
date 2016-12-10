package com.iningke.zhangzhq.mine.userinfo;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.base.ZhangzhqActivity;
import com.iningke.zhangzhq.inter.App;
import com.iningke.zhangzhq.myview.CircleImageView;
import com.iningke.zhangzhq.myview.MyShowGalleryCameraPopupWindow;
import com.iningke.zhangzhq.utils.ImageChooserUtils;
import com.iningke.zhangzhq.utils.PackageUtils;
import com.kbeanie.imagechooser.api.ChooserType;
import com.kbeanie.imagechooser.api.ChosenImage;
import com.kbeanie.imagechooser.api.ChosenImages;
import com.kbeanie.imagechooser.api.ImageChooserListener;
import com.kbeanie.imagechooser.api.ImageChooserManager;
import com.kbeanie.imagechooser.exceptions.ChooserException;
import com.soundcloud.android.crop.Crop;

import java.io.File;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 用户 基本信息
 *
 * @author hxy
 * @date 2016/12/1
 */
public class UserBaseInformationActivity extends ZhangzhqActivity implements MyShowGalleryCameraPopupWindow.OnMyGalleryAndCameraClickListener, ImageChooserListener {


    @Bind(R.id.common_img_back)
    ImageView commonImgBack;
    @Bind(R.id.common_txt_title)
    TextView commonTxtTitle;
    @Bind(R.id.common_img_right)
    ImageView commonImgRight;
    @Bind(R.id.user_baseInfo_img_avatar)
    CircleImageView userBaseInfoImgAvatar;
    @Bind(R.id.user_baseInfo_linear_avatar)
    LinearLayout userBaseInfoLinearAvatar;
    @Bind(R.id.user_baseInfo_txt_name)
    TextView userBaseInfoTxtName;
    @Bind(R.id.user_baseInfo_linear_name)
    LinearLayout userBaseInfoLinearName;
    @Bind(R.id.user_baseInfo_linear_userInfo)
    LinearLayout userBaseInfoLinearUserInfo;
    @Bind(R.id.common_txt_right)
    TextView commonTxtRight;
    @Bind(R.id.userInfo_txt_area)
    TextView userInfoTxtArea;
    @Bind(R.id.userInfo_linear_area)
    LinearLayout userInfoLinearArea;
    @Bind(R.id.userInfo_txt_hospital)
    TextView userInfoTxtHospital;
    @Bind(R.id.userInfo_linear_hospital)
    LinearLayout userInfoLinearHospital;
    @Bind(R.id.userInfo_txt_department)
    TextView userInfoTxtDepartment;
    @Bind(R.id.userInfo_linear_department)
    LinearLayout userInfoLinearDepartment;
    @Bind(R.id.userInfo_txt_role)
    TextView userInfoTxtRole;
    @Bind(R.id.userInfo_linear_role)
    LinearLayout userInfoLinearRole;
    @Bind(R.id.userInfo_txt_realName)
    TextView userInfoTxtRealName;
    @Bind(R.id.userInfo_linear_realName)
    LinearLayout userInfoLinearRealName;
    @Bind(R.id.userInfo_txt_phone)
    TextView userInfoTxtPhone;
    @Bind(R.id.userInfo_linear_phone)
    LinearLayout userInfoLinearPhone;
    @Bind(R.id.userInfo_txt_email)
    TextView userInfoTxtEmail;
    @Bind(R.id.userInfo_linear_email)
    LinearLayout userInfoLinearEmail;
    private MyShowGalleryCameraPopupWindow popupWindow;
    private ImageChooserManager imageChooserManager;

    @Override
    public int setLayoutId() {
        return R.layout.activity_user_base_information;
    }

    @Override
    public void initView() {
        commonImgBack.setVisibility(View.VISIBLE);
        commonTxtTitle.setText("基本信息");
        //TODO 设置ImageChooser图片的 存放目录，， 根目录是sd卡的根目录 即上面的path；
        ImageChooserUtils utils = new ImageChooserUtils();
        utils.setFolderName(PackageUtils.getPackageName() + "/avatar");
    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.common_img_back, R.id.user_baseInfo_img_avatar, R.id.user_baseInfo_linear_avatar, R.id.user_baseInfo_linear_name, R.id.user_baseInfo_linear_userInfo})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.common_img_back:
                finish();
                break;
            case R.id.user_baseInfo_img_avatar:
                break;
            case R.id.user_baseInfo_linear_avatar:
                showSelectGalleryAndCamera();
                break;
            case R.id.user_baseInfo_linear_name:
                //昵称取消
                break;
            case R.id.user_baseInfo_linear_userInfo:
                startActivity(new Intent(this, UserInformationActivity.class));
                break;
        }
    }

    private void showSelectGalleryAndCamera() {
        popupWindow = new MyShowGalleryCameraPopupWindow();
        popupWindow.initPopupWindow(this, R.layout.activity_user_base_information, this);
    }

    @Override
    protected void permissionDenied(int requestCode) {
        super.permissionDenied(requestCode);
    }

    @Override
    protected void permissionGrant(int requestCode) {
        super.permissionGrant(requestCode);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        if (resultCode == RESULT_OK &&
                (requestCode == ChooserType.REQUEST_PICK_PICTURE ||
                        requestCode == ChooserType.REQUEST_CAPTURE_PICTURE)) {
//            imageChooserManager.submit(requestCode, data);
            beginCrop(data.getData());
        } else if (requestCode == Crop.REQUEST_CROP) {
            handleCrop(resultCode, data);
        }
    }

    private void beginCrop(Uri source) {
        Uri destination = Uri.fromFile(new File(getCacheDir(), "cropped"));
        Crop.of(source, destination).asSquare().start(this);
    }

    private void handleCrop(int resultCode, Intent result) {
        if (resultCode == RESULT_OK) {
            userBaseInfoImgAvatar.setImageDrawable(null);
            userBaseInfoImgAvatar.setImageURI(Crop.getOutput(result));
        } else if (resultCode == Crop.RESULT_ERROR) {
            Toast.makeText(this, Crop.getError(result).getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onImageChosen(final ChosenImage chosenImage) {
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                String filePathOriginal = chosenImage.getFileThumbnailSmall();
//                Bitmap bitmap = BitmapFactory.decodeFile(filePathOriginal);
//                userBaseInfoImgAvatar.setImageBitmap(bitmap);
//            }
//        });
    }

    @Override
    public void onError(String s) {

    }

    @Override
    public void onImagesChosen(ChosenImages chosenImages) {

    }
}
