package com.iningke.zhangzhq.manage;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.activity.SelectAreaActivity;
import com.iningke.zhangzhq.base.ZhangzhqActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 水电费管理 查询activity
 *
 * @author hxy
 * @date 2016/11/18
 */
public class ManageQueryActivity extends ZhangzhqActivity {


    @Bind(R.id.common_img_back)
    ImageView commonImgBack;
    @Bind(R.id.common_txt_title)
    TextView commonTxtTitle;
    @Bind(R.id.common_img_right)
    ImageView commonImgRight;
    @Bind(R.id.manage_query_selectArea)
    LinearLayout manageQuerySelectArea;
    @Bind(R.id.manage_query_selectBuilding)
    LinearLayout manageQuerySelectBuilding;
    @Bind(R.id.manage_query_selectFloor)
    LinearLayout manageQuerySelectFloor;
    @Bind(R.id.manage_query_selectRoom)
    LinearLayout manageQuerySelectRoom;
    @Bind(R.id.manage_query_txtBtn)
    TextView manageQueryTxtBtn;
    @Bind(R.id.manage_query_txt_area)
    TextView manageQueryTxtArea;
    @Bind(R.id.manage_query_txt_building)
    TextView manageQueryTxtBuilding;
    @Bind(R.id.manage_query_txt_floor)
    TextView manageQueryTxtFloor;
    @Bind(R.id.manage_query_txt_room)
    TextView manageQueryTxtRoom;
    private int type;
    private int selectType;

    @Override
    public int setLayoutId() {
        return R.layout.activity_manage_query;
    }

    @Override
    public void initView() {
        commonImgBack.setVisibility(View.VISIBLE);
        Intent intent = getIntent();
        type = intent.getIntExtra("type", -1);
        if (type > 0) {
            switch (type) {
                case 10:
                    //水费
                    commonTxtTitle.setText("水费查询");
                    break;
                case 20:
                    //电费
                    commonTxtTitle.setText("电费查询");
                    break;
                case 30:
                    //氧气费
                    commonTxtTitle.setText("氧气费查询");
                    break;
            }
            Toast.makeText(ManageQueryActivity.this, "type == " + type, Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(ManageQueryActivity.this, "数据异常！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.common_img_back, R.id.manage_query_selectArea, R.id.manage_query_selectBuilding, R.id.manage_query_selectFloor, R.id.manage_query_selectRoom, R.id.manage_query_txtBtn})
    public void onClick(View view) {
        Intent intent = new Intent(this, SelectAreaActivity.class);
        selectType = -1;
        switch (view.getId()) {
            case R.id.common_img_back:
                finish();
                return;
            case R.id.manage_query_selectArea:
                selectType = 100;
                break;
            case R.id.manage_query_selectBuilding:
                selectType = 200;
                break;
            case R.id.manage_query_selectFloor:
                selectType = 300;
                break;
            case R.id.manage_query_selectRoom:
                selectType = 400;
                break;
            case R.id.manage_query_txtBtn:
                aboutQuery();
                return;
        }
        if (type > 0) {
            intent.putExtra("type", type);
            intent.putExtra("selectType", selectType);
            startActivityForResult(intent, selectType);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        String result = data.getStringExtra("result");
        if (null == result || "".equals(result)) {
            return;
        }
        switch (requestCode) {
            case 100:
                //area
                manageQueryTxtArea.setText(result);
                break;
            case 200:
                //building
                manageQueryTxtBuilding.setText(result);
                break;
            case 300:
                //floor
                manageQueryTxtFloor.setText(result);
                break;
            case 400:
                //room
                manageQueryTxtRoom.setText(result);
                break;
        }
    }

    private void aboutQuery() {
        if (type < 0) {
            Toast.makeText(ManageQueryActivity.this, "数据异常！", Toast.LENGTH_SHORT).show();
            return;
        }
        String area = manageQueryTxtArea.getText().toString();
        if ("".equals(area) || null == area) {
            Toast.makeText(ManageQueryActivity.this, "请选择区域", Toast.LENGTH_SHORT).show();
            return;
        }
        String building = manageQueryTxtBuilding.getText().toString();
        if ("".equals(building) || null == building) {
            Toast.makeText(ManageQueryActivity.this, "请选择建筑楼", Toast.LENGTH_SHORT).show();
            return;
        }
        String floor = manageQueryTxtFloor.getText().toString();
        if ("".equals(floor) || null == floor) {
            Toast.makeText(ManageQueryActivity.this, "请选择楼层", Toast.LENGTH_SHORT).show();
            return;
        }
        String room = manageQueryTxtRoom.getText().toString();
        if ("".equals(room) || null == room) {
            Toast.makeText(ManageQueryActivity.this, "请选择科室或房间号", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(this, ManageShowActivity.class);
        intent.putExtra("type", type);
        startActivity(intent);
    }

}
