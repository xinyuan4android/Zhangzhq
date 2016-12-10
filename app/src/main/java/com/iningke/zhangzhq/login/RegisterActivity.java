package com.iningke.zhangzhq.login;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.iningke.baseproject.utils.LogUtils;
import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.activity.SelectAreaActivity;
import com.iningke.zhangzhq.base.ZhangzhqActivity;
import com.iningke.zhangzhq.inter.App;
import com.iningke.zhangzhq.myview.CircleImageView;
import com.iningke.zhangzhq.myview.MyShowGalleryCameraPopupWindow;
import com.iningke.zhangzhq.utils.FileUtils;
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
 * 注册界面
 *
 * @author hxy
 * @date 2016/11/25
 */
public class RegisterActivity extends ZhangzhqActivity implements ImageChooserListener, MyShowGalleryCameraPopupWindow.OnMyGalleryAndCameraClickListener {

    @Bind(R.id.common_img_back)
    ImageView commonImgBack;
    @Bind(R.id.common_txt_title)
    TextView commonTxtTitle;
    @Bind(R.id.common_img_right)
    ImageView commonImgRight;
    @Bind(R.id.register_txt_selectArea)
    TextView registerTxtSelectArea;
    @Bind(R.id.register_linear_selectArea)
    LinearLayout registerLinearSelectArea;
    @Bind(R.id.register_txt_selectHospital)
    TextView registerTxtSelectHospital;
    @Bind(R.id.register_linear_selectHospital)
    LinearLayout registerLinearSelectHospital;
    @Bind(R.id.register_txt_selectDepartment)
    TextView registerTxtSelectDepartment;
    @Bind(R.id.register_linear_selectDepartment)
    LinearLayout registerLinearSelectDepartment;
    @Bind(R.id.register_txt_selectRole)
    TextView registerTxtSelectRole;
    @Bind(R.id.register_linear_selectRole)
    LinearLayout registerLinearSelectRole;
    @Bind(R.id.register_edit_realName)
    EditText registereditRealName;
    @Bind(R.id.register_edit_phone)
    EditText registerEditPhone;
    @Bind(R.id.register_edit_email)
    EditText registerEditEmail;
    @Bind(R.id.register_txt_confirm)
    TextView registerTxtConfirm;

    private CircleImageView imgAvatar;
    private ImageChooserManager imageChooserManager;
    private MyShowGalleryCameraPopupWindow popupWindow;

    @Override
    public int setLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void initView() {
        commonTxtTitle.setText("注册");
        commonImgBack.setVisibility(View.VISIBLE);
        //TODO 设置ImageChooser图片的 存放目录，， 根目录是sd卡的根目录 即上面的path；
        ImageChooserUtils utils = new ImageChooserUtils();
        utils.setFolderName(PackageUtils.getPackageName() + "/avatar");
        imgAvatar = (CircleImageView) findViewById(R.id.register_circleImg_avatar);
    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.common_img_back, R.id.register_circleImg_avatar, R.id.register_linear_selectArea, R.id.register_linear_selectHospital, R.id.register_linear_selectDepartment, R.id.register_linear_selectRole, R.id.register_txt_confirm})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.common_img_back:
                finish();
                break;
            case R.id.register_linear_selectArea:
                Intent intent_area = new Intent(this, SelectAreaActivity.class);
                intent_area.putExtra(App.type_stringParams, App.type_selectArea);
                startActivityForResult(intent_area, App.type_selectArea);
                break;
            case R.id.register_linear_selectHospital:
                Intent intent_hospital = new Intent(this, SelectAreaActivity.class);
                intent_hospital.putExtra(App.type_stringParams, App.type_selectHospital);
                startActivityForResult(intent_hospital, App.type_selectHospital);
                break;
            case R.id.register_linear_selectDepartment:
                Intent intent_department = new Intent(this, SelectAreaActivity.class);
                intent_department.putExtra(App.type_stringParams, App.type_selectDepartment);
                startActivityForResult(intent_department, App.type_selectDepartment);
                break;
            case R.id.register_linear_selectRole:
                Intent intent_role = new Intent(this, SelectAreaActivity.class);
                intent_role.putExtra(App.type_stringParams, App.type_selectRole);
                startActivityForResult(intent_role, App.type_selectRole);
                break;
            case R.id.register_txt_confirm:
                aboutRegister();
                break;
            case R.id.register_circleImg_avatar:
                showGalleryCameraPopupWindow();
                break;
        }
    }

    private void aboutRegister() {
        String area = registerTxtSelectArea.getText().toString();
        if ("".equals(area) || null == area) {
            Toast.makeText(RegisterActivity.this, "请选择区域", Toast.LENGTH_SHORT).show();
            return;
        }
        String hospital = registerTxtSelectHospital.getText().toString();
        if ("".equals(hospital) || null == hospital) {
            Toast.makeText(RegisterActivity.this, "请选择医院", Toast.LENGTH_SHORT).show();
            return;
        }
        String department = registerTxtSelectDepartment.getText().toString();
        if ("".equals(department) || null == department) {
            Toast.makeText(RegisterActivity.this, "请选择科室", Toast.LENGTH_SHORT).show();
            return;
        }
        String role = registerTxtSelectRole.getText().toString();
        if ("".equals(role) || null == role) {
            Toast.makeText(RegisterActivity.this, "请选择角色", Toast.LENGTH_SHORT).show();
            return;
        }
        String realName = registereditRealName.getText().toString();
        if ("".equals(realName) || null == realName) {
            Toast.makeText(RegisterActivity.this, "请输入真实姓名", Toast.LENGTH_SHORT).show();
            return;
        }
        String phone = registerEditPhone.getText().toString();
        if ("".equals(phone) || null == phone) {
            Toast.makeText(RegisterActivity.this, "请输入联系电话", Toast.LENGTH_SHORT).show();
            return;
        }
        String email = registerEditEmail.getText().toString();
        if ("".equals(email) || null == email) {
            Toast.makeText(RegisterActivity.this, "请输入邮箱账号", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    private void showGalleryCameraPopupWindow() {
        popupWindow = new MyShowGalleryCameraPopupWindow();
        popupWindow.initPopupWindow(this, R.layout.activity_register, this);
    }

    @Override
    protected void permissionDenied(int requestCode) {
        super.permissionDenied(requestCode);
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
            imgAvatar.setImageDrawable(null);
            imgAvatar.setImageURI(Crop.getOutput(result));
            String imageAbsolutePath = FileUtils.getImageAbsolutePath(this, Crop.getOutput(result));
            LogUtils.e("imageAbsolutePath === " + imageAbsolutePath);
        } else if (resultCode == Crop.RESULT_ERROR) {
            Toast.makeText(this, Crop.getError(result).getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onImageChosen(final ChosenImage chosenImage) {
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                if (chosenImage != null) {
//                    String filePathOriginal = chosenImage.getFileThumbnailSmall();
//                    Bitmap bitmap = BitmapFactory.decodeFile(filePathOriginal);
//                    imgAvatar.setImageBitmap(bitmap);
//                }
//            }
//        });
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
