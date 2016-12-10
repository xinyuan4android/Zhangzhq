package com.iningke.zhangzhq.inter;


import com.iningke.zhangzhq.utils.LogUtils;

/**
 * Created by iningke on 2016/10/24.
 */
public interface App {
    //TODO Log输出级别
    int Debuggable = LogUtils.LEVEL_ERROR;

    /**
     * 记录当前显示的页面是哪个fragment
     */
    int Currentpage_HomeFragment = 100;
    int Currentpage_ManageFragment = 200;
    int Currentpage_ServiceFragment = 300;
    int Currentpage_MineFragment = 400;
    //TODO 订单状态
    String[] strings_orderState_fix = {"全部", "待受理", "待修理", "待审核", "已完成"};
    int[] ints_orderState_fix = {0, 2, 3, 4, 5};
    String[] strings_orderState_NotFix = {"全部", "待受理", "待修理", "待审核", "已完成", "已拒绝"};
    int[] ints_orderState_NotFix = {0, 2, 3, 4, 5, 6};

    //TODO 类型
    int state_wait_comment = 1;//待评估
    int state_wait_accept = 2;//待受理
    int state_wait_fix = 3;//待修理
    int state_wait_check = 4;//待审核
    int state_wait_finish = 5;//已完成
    int state_wait_refuse = 6;//已拒绝

    //TODO 类型string
    String state_string_wait_accept = "待受理";
    String state_string_wait_check = "待审核";
    String state_string_wait_fix = "待维修";
    String state_string_wait_comment = "待评估";
    String state_string_refuse = "已拒绝";
    String state_string_wait_finish = "已完成";

    //TODO 角色类型
    int type_role_workMan = 1;
    int type_role_notWorkMan = 2;

    //TODO 申请权限 code
    int RequestCode_Camera = 1000;
    int RequestCode_Gallery = 1001;
    int RequestCode_CallPhone = 1002;

    //TODO 选择类型
    String type_stringParams = "selectType";
    int type_selectArea = 100;//选择区域
    int type_selectBuilding = 200;//选择建筑楼
    int type_selectFloor = 300;//选择楼层
    int type_selectRoom = 400;//选择科室或者房间号
    int type_selectHospital = 500;//选择医院
    int type_selectRole = 600;//选择角色
    int type_selectDepartment = 700;//选择科室

    // TODO: 2016/12/9 颜色列表
    int[] colors = {0XFFf4a164, 0XFF57ffbf, 0XFFfee05a, 0XFFf03a3f, 0XFF936fff, 0XFFffffc7, 0XFF5a9fe5,
            0XFF64e65f, 0XFF21ffff, 0XFFf96eb0, 0XFFc0a8fa, 0XFFa68636, 0XFFd9dde4, 0XFF636ac0};

}
