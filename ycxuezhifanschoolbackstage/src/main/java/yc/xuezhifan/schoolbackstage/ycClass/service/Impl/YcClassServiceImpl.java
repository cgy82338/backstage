package yc.xuezhifan.schoolbackstage.ycClass.service.Impl;

import java.util.*;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.rong.models.Result;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.rong.models.group.GroupMember;
import io.rong.models.group.GroupModel;
import yc.xuezhifan.schoolbackstage.bean.JacksonData;
import yc.xuezhifan.schoolbackstage.constants.YcClassConstants;
import yc.xuezhifan.schoolbackstage.school.bean.YcSchool;
import yc.xuezhifan.schoolbackstage.teacher.bean.YcTeacherManagement;
import yc.xuezhifan.schoolbackstage.teacher.mapper.YcTeacherManagementMapper;
import yc.xuezhifan.schoolbackstage.user.bean.YcUser;
import yc.xuezhifan.schoolbackstage.user.mapper.YcUserMapper;
import yc.xuezhifan.schoolbackstage.utils.*;
import yc.xuezhifan.schoolbackstage.ycClass.bean.YcClass;
import yc.xuezhifan.schoolbackstage.ycClass.bean.YcClassExcel;
import yc.xuezhifan.schoolbackstage.ycClass.bean.YcIntermediateTable;
import yc.xuezhifan.schoolbackstage.ycClass.bean.YcParentClass;
import yc.xuezhifan.schoolbackstage.ycClass.mapper.YcClassMapper;
import yc.xuezhifan.schoolbackstage.ycClass.mapper.YcIntermediateTableMapper;
import yc.xuezhifan.schoolbackstage.ycClass.mapper.YcParentClassMapper;
import yc.xuezhifan.schoolbackstage.ycClass.service.YcClassService;
import yc.xuezhifan.schoolbackstage.ycClass.service.YcParentClassService;
import yc.xuezhifan.schoolbackstage.ycClass.vo.YcClassVo;

/**
 * <p>
 * Title: YcClassServiceImpl.java
 * </p>
 *
 * <p>
 * Description:班级管理service实现
 * </p>
 *
 * <p>
 * Copyright: Copyright (c) 2018年9月22日
 * </p>
 *
 * @author zhuangzhuang
 * @version 1.0
 * @email zhuangzhuang@xuezhifan.com
 * @date 2018年9月22日
 */
@Service
public class YcClassServiceImpl implements YcClassService {

    private static Logger logger = LoggerFactory.getLogger(YcClassServiceImpl.class);

    @Autowired
    YcClassMapper ycClassMapper;

    @Autowired
    YcUserMapper ycUserMapper;

    @Autowired
    YcIntermediateTableMapper ycIntermediateTableMapper;

    @Autowired
    YcParentClassService ycParentClassService;

    @Autowired
    YcParentClassMapper parentClassMapper;

    @Autowired
    YcTeacherManagementMapper teacherManagementMapper;


    @Value("${YcClass.Image}")
    private String image;


    /**
     * <p>
     * Title: saveClass
     * </p>
     *
     * <p>
     * Description: 创建班级信息
     * </p>
     *
     * @param ycClassVo
     * @return
     * @email xiaoyu@xuezhifan.com
     * @author xiaoyu
     * @date 2019年1月7日
     */
    @Override
    public JacksonData saveClass(YcSchool ycSchool, YcClassVo ycClassVo) {
        try {
            String className = ycClassVo.getYc_class_name().replace(" ", "");
//        班级名称不能重复
            if (ycClassMapper.selectClassByName(className, ycSchool.getId()) != null){
                return ResultUtil.error(204, YcClassConstants.CLASSNAME);
            }
//        添加班级
            YcClass ycClass = new YcClass();
            ycClass.setYc_class_id(UUIDFactory.random());
            ycClass.setYc_class_number(RandomNumUtil.randomNum());
            ycClass.setYc_school_id(ycSchool.getId());
            ycClass.setYc_class_name(className);
            ycClass.setYc_class_create_time(new Date());
            ycClass.setYc_class_create_id(ycSchool.getId());
            ycClass.setYc_class_head_teacher_id(ycClassVo.getYc_class_head_teacher_id());
            ycClass.setYc_class_head_teacher_name(ycUserMapper.selectById(ycClassVo.getYc_class_head_teacher_id()).getYc_username());
            ycClass.setYc_class_avatar(image);
            ycClass.setSa_latitude(Double.valueOf(ycSchool.getYc_school_map_address().split(",")[0]));
            ycClass.setSa_longitude(Double.valueOf(ycSchool.getYc_school_map_address().split(",")[1]));
            ycClass.setYc_address(ycSchool.getYc_school_address());
            ycClass.setYc_class_introduction("这是" + ycSchool.getYc_school_name() + className + "班级，欢迎各位老师和家长加入" + className + "大家庭");
            ycClass.setYc_class_nature("1");
            ycClass.setYc_banned_status("1");


//        添加班级成员表
            YcParentClass classHead = new YcParentClass();
            classHead.setId(UUIDFactory.random());
            classHead.setYc_parent_id(ycClassVo.getYc_class_head_teacher_id());
            classHead.setYc_class_id(ycClass.getYc_class_id());
            classHead.setYc_create_time(new Date());
            classHead.setYc_status(1);
            classHead.setYc_review_id("");
            classHead.setYc_permission_status(1);//群主
            classHead.setYc_verification_message("");
            classHead.setYc_remarks("");
            classHead.setYc_reason("");
            classHead.setYc_message_avoidance("1");

//            创建群
            List<GroupMember> members = new ArrayList<>();
            //添加群主
            GroupMember member = new GroupMember();
            member.setGroupId(ycClass.getYc_class_id());
            member.setId(ycClassVo.getYc_class_head_teacher_id());
            members.add(member);

            ycClassMapper.insetClass(ycClass);//班级添加
            parentClassMapper.addParentClass(classHead);//班级成员表添加

//      教师不为空则添加任课教师
            if (StringUtils.isNotBlank(ycClassVo.getYc_teacherIds())) {
                String[] teahcers = ycClassVo.getYc_teacherIds().split(",");
                if (teahcers != null) {
                    for (int i = 0; i < teahcers.length; i++) {
                        //      添加班级成员表
                        YcParentClass classTeacher = new YcParentClass();
                        classTeacher.setId(UUIDFactory.random());
                        classTeacher.setYc_parent_id(teahcers[i]);
                        classTeacher.setYc_class_id(ycClass.getYc_class_id());
                        classTeacher.setYc_create_time(new Date());
                        classTeacher.setYc_status(1);
                        classTeacher.setYc_review_id("");
                        classTeacher.setYc_permission_status(2);//管理员
                        classTeacher.setYc_verification_message("");
                        classTeacher.setYc_remarks("");
                        classTeacher.setYc_reason("");
                        classTeacher.setYc_message_avoidance("1");
                        parentClassMapper.addParentClass(classTeacher);
//      添加教师科目与班级关系表
                        YcIntermediateTable teacherTable = new YcIntermediateTable();
                        teacherTable.setYc_intermediate_table_id(UUIDFactory.random());
                        teacherTable.setYc_class_id(ycClass.getYc_class_id());
                        teacherTable.setYc_teacher_information_id(teahcers[i]);
                        if (teahcers[i].equals(ycClassVo.getYc_class_head_teacher_id())) {//如果添加班主任为任课教师则职务为班主任
                            teacherTable.setYc_teacher_position(1);//班主任
                        } else {
                            teacherTable.setYc_teacher_position(2);//普通教师
                        }
                        ycIntermediateTableMapper.insert(teacherTable);
//            添加群成员（管理员）
                        GroupMember membermodel = new GroupMember();
                        membermodel.setGroupId(ycClass.getYc_class_id());
                        membermodel.setId(teahcers[i]);
                        members.add(membermodel);
                    }
                }
//            创建融云
                GroupMember[] memberes = new GroupMember[members.size()];
                GroupModel group = new GroupModel().setId(ycClass.getYc_class_id()).setName(className).setMembers(members.toArray(memberes));
                RongCloudUtil.getRongcloud().group.create(group);
            }
            return ResultUtil.success();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.error(204, YcClassConstants.FAILURE);
    }

    /**
     * 修改班级信息
     */
    @Override
    public JacksonData updateClass(YcSchool ycSchool, YcClassVo ycClassVo) {
        try {
            String className = ycClassVo.getYc_class_name().replace(" ", "");
            //		根据班级id查询班级信息
            YcClass ycClass = ycClassMapper.selectClassById(ycClassVo.getYc_class_id());
//            更改的班级名称不能重复
            if (!ycClassVo.getYc_class_name().equals(ycClass.getYc_class_name())) {
                if (ycClassMapper.selectClassByName(className, ycSchool.getId()) != null){
                        return ResultUtil.error(204, YcClassConstants.CLASSNAME);
                }
            }
            ycClass.setYc_class_name(className);//更改班级名称
//            更改班主任
            if (!ycClassVo.getYc_class_head_teacher_id().equals(ycClass.getYc_class_head_teacher_id())) {
//                原班主任权限更改为管理员
                YcParentClass oldHeadTeacher = parentClassMapper.selectParentClass(ycClass.getYc_class_head_teacher_id(), ycClassVo.getYc_class_id());
                oldHeadTeacher.setYc_permission_status(2);
                parentClassMapper.modify(oldHeadTeacher);
//              查询教师科目与班级关系表中是否有关联数据
                YcIntermediateTable table = new YcIntermediateTable();
                table.setYc_teacher_information_id(ycClass.getYc_class_head_teacher_id());
                table.setYc_class_id(ycClassVo.getYc_class_id());
                YcIntermediateTable ycIntermediateTable = ycIntermediateTableMapper.selectByClassAndTeacher(table);
                if (ycIntermediateTable != null) {//修改教师科目与班级关系表中的职务
                    ycIntermediateTableMapper.updatePosition(2, ycIntermediateTable.getYc_intermediate_table_id());
                }

//                班级表更新班级名称及班主任
                ycClass.setYc_class_head_teacher_id(ycClassVo.getYc_class_head_teacher_id());
                ycClass.setYc_class_head_teacher_name(ycUserMapper.selectById(ycClassVo.getYc_class_head_teacher_id()).getYc_username());

//                判断现任班主任原先是否已与此班级有关联
                YcParentClass newHeadTeacher = parentClassMapper.selectParentClass(ycClassVo.getYc_class_head_teacher_id(), ycClassVo.getYc_class_id());
                if (newHeadTeacher == null) {//无关联则创建关联并赋予群主权限
                    YcParentClass classHead = new YcParentClass();
                    classHead.setId(UUIDFactory.random());
                    classHead.setYc_parent_id(ycClassVo.getYc_class_head_teacher_id());
                    classHead.setYc_class_id(ycClass.getYc_class_id());
                    classHead.setYc_create_time(new Date());
                    classHead.setYc_status(1);
                    classHead.setYc_review_id("");
                    classHead.setYc_permission_status(1);//群主
                    classHead.setYc_verification_message("");
                    classHead.setYc_remarks("");
                    classHead.setYc_reason("");
                    classHead.setYc_message_avoidance("1");
                    parentClassMapper.addParentClass(classHead);
                } else {//有关联直接修改权限即可
                    newHeadTeacher.setYc_permission_status(1);
                    parentClassMapper.modify(newHeadTeacher);
//              查询教师科目与班级关系表中是否有关联数据
                    YcIntermediateTable table2 = new YcIntermediateTable();
                    table2.setYc_teacher_information_id(ycClassVo.getYc_class_head_teacher_id());
                    table2.setYc_class_id(ycClassVo.getYc_class_id());
                    YcIntermediateTable ycIntermediateTable2 = ycIntermediateTableMapper.selectByClassAndTeacher(table2);
                    if (ycIntermediateTable2 != null) {//修改教师科目与班级关系表中的职务
                        ycIntermediateTableMapper.updatePosition(1, ycIntermediateTable2.getYc_intermediate_table_id());
                    }
                }

            }

//		       更新前的任课教师
            List<YcIntermediateTable> teachers = ycIntermediateTableMapper.getIntermediateTableByClassId(ycClassVo.getYc_class_id());
            //		更新后的任课教师
            String[] newteacher = ycClassVo.getYc_teacherIds().split(",");
            //            判断删除的任课教师
            Set<String> delSet1 = new HashSet<>();
            for (int i = 0; i < teachers.size(); i++) {
                delSet1.add(teachers.get(i).getYc_teacher_information_id());
            }
            Set<String> delSet2 = new HashSet<>();
            for (int i = 0; i < newteacher.length; i++) {
                delSet2.add(newteacher[i]);
            }

            delSet1.removeAll(delSet2);
            List<GroupMember> deletemembers = new ArrayList<>();
            if (delSet1.size() != 0) {
                for (String s : delSet1) {
                    if (s.equals(ycClassVo.getYc_class_head_teacher_id())) {//如果删除的是班主任，则只删除任课教师表中与此班级的关联
                        ycIntermediateTableMapper.deleteByTeacherAndClassId(s, ycClassVo.getYc_class_id());
                    } else {//普通任课老师则班级成员表和教师科目与班级关系表的关联都要删除并且通过融云踢出该群
                        ycIntermediateTableMapper.deleteByTeacherAndClassId(s, ycClassVo.getYc_class_id());
                        parentClassMapper.deleteParentClass(s, ycClassVo.getYc_class_id());
                        GroupMember member = new GroupMember();
                        member.setGroupId(ycClassVo.getYc_class_id());
                        member.setId(s);
                        deletemembers.add(member);
                    }
                }
//                融云删除群成员
                GroupMember[] memberes = new GroupMember[deletemembers.size()];
                GroupModel deletegroup = new GroupModel().setId(ycClassVo.getYc_class_id()).setMembers(deletemembers.toArray(memberes))
                        .setName(ycClassVo.getYc_class_name());
                RongCloudUtil.getRongcloud().group.quit(deletegroup);

            }

//            判断新增的任课教师
            Set<String> addSet1 = new HashSet<>();
            for (int i = 0; i < teachers.size(); i++) {
                addSet1.add(teachers.get(i).getYc_teacher_information_id());
            }
            Set<String> addSet2 = new HashSet<>();
            for (int i = 0; i < newteacher.length; i++) {
                if (StringUtils.isNotBlank(ycClassVo.getYc_teacherIds())) {
                    addSet2.add(newteacher[i]);
                }
            }
            addSet2.removeAll(addSet1);
            List<GroupMember> addmembers = new ArrayList<>();
            if (addSet2.size() != 0) {
                for (String s : addSet2) {
                    if (s.equals(ycClassVo.getYc_class_head_teacher_id())) {//为班主任则只添加教师科目与班级关系表的关联数据
                        YcIntermediateTable intermediateTable = new YcIntermediateTable();
                        intermediateTable.setYc_intermediate_table_id(UUIDFactory.random());
                        intermediateTable.setYc_class_id(ycClassVo.getYc_class_id());
                        intermediateTable.setYc_teacher_information_id(s);
                        intermediateTable.setYc_teacher_position(1);//班主任
                        ycIntermediateTableMapper.insert(intermediateTable);
                    } else {//为普通教师则添加班级成员表和教师科目与班级关系表的关联数据
                        //      添加班级成员表
                        YcParentClass classTeacher = new YcParentClass();
                        classTeacher.setId(UUIDFactory.random());
                        classTeacher.setYc_parent_id(s);
                        classTeacher.setYc_class_id(ycClassVo.getYc_class_id());
                        classTeacher.setYc_create_time(new Date());
                        classTeacher.setYc_status(1);
                        classTeacher.setYc_review_id("");
                        classTeacher.setYc_permission_status(2);//管理员
                        classTeacher.setYc_verification_message("");
                        classTeacher.setYc_remarks("");
                        classTeacher.setYc_reason("");
                        classTeacher.setYc_message_avoidance("1");
                        parentClassMapper.addParentClass(classTeacher);
//                        添加教师科目与班级关系表
                        YcIntermediateTable intermediateTable = new YcIntermediateTable();
                        intermediateTable.setYc_intermediate_table_id(UUIDFactory.random());
                        intermediateTable.setYc_class_id(ycClassVo.getYc_class_id());
                        intermediateTable.setYc_teacher_information_id(s);
                        intermediateTable.setYc_teacher_position(2);//普通教师
                        ycIntermediateTableMapper.insert(intermediateTable);
                        GroupMember member = new GroupMember();
                        member.setGroupId(ycClassVo.getYc_class_id());
                        member.setId(s);
                        addmembers.add(member);
                    }
                }
//                添加群成员
                GroupMember[] memberes = new GroupMember[addmembers.size()];
                GroupModel addtegroup = new GroupModel().setId(ycClassVo.getYc_class_id()).setMembers(addmembers.toArray(memberes))
                        .setName(className);
                RongCloudUtil.getRongcloud().group.join(addtegroup);
            }
            ycClassMapper.updateClass(ycClass);
            return ResultUtil.success();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.error(204, YcClassConstants.FAILURE);

    }

    /**
     * 根据学校id查询班级信息
     */
    @Transactional
    @Override
    public Page getClassByschoolid(String id, Integer currentPage, Integer pageSize, String ycusername) {
        try {
            //		分页
            PageHelper.startPage(currentPage, pageSize);
            List<YcClass> yclass = ycClassMapper.getClass(id);
            //		搜索条件不为空(按班级名称查询)
            if (StringUtils.isNotBlank(ycusername)) {
                List<YcClass> searchClass = new ArrayList<>();
                for (YcClass c : yclass) {
                    if (c.getYc_class_name().contains(ycusername)) {
                        searchClass.add(c);
                    }
                }
                yclass = searchClass;
            }
            if (yclass == null) {
                return new Page(0, "", 0, null);
            }
            //		查询每个班级的任课教师
            for (YcClass r : yclass) {
                List<YcIntermediateTable> intermediateTableByClassId = ycIntermediateTableMapper.getIntermediateTableByClassId(r.getYc_class_id());
                String teaName = "";
                for (YcIntermediateTable y : intermediateTableByClassId) {
                    YcUser ycUser = ycUserMapper.selectById(y.getYc_teacher_information_id());
                    teaName += ycUser.getYc_username() + " ";
                }
                r.setYc_class_introduction(teaName);
            }
            PageInfo<YcClass> pageInfo = new PageInfo<>(yclass);
            return new Page(0, "", (int) pageInfo.getTotal(), pageInfo.getList());
        } catch (Exception e) {
            e.printStackTrace();
            return new Page(0, "", 0, null);
        }

    }

    /**
     * 根据班级id 查询班级信息
     */
    @Override
    public YcClass getClassByClassId(String classId) {
        return ycClassMapper.selectClassById(classId);
    }

    /**
     * excel批量创建班级并绑定教师
     */
    @Override
    @Transactional
    public String saveClassBatch(YcSchool ycSchool, List<YcClassExcel> personList) {
        boolean flag = true;// 标记成败
        StringBuilder headTeacher = new StringBuilder();//记录错误信息

        for (int i = 0; i < personList.size(); i++) {//判断整个表中是否有错误操作
//            统一去掉空格
            String exClassName = personList.get(i).getClassName();//班级名称
            if (StringUtils.isNotBlank(exClassName)) {
                exClassName = exClassName.replace(" ", "");
            }
            String exHeadPhone = personList.get(i).getPhone();//班主任手机号
            if (StringUtils.isNotBlank(exHeadPhone)) {
                exHeadPhone = exHeadPhone.replace(" ", "");
            }
            String exOtherPhone = personList.get(i).getOtherPhone();//任课教师手机号
            if (StringUtils.isNotBlank(exOtherPhone)) {
                exOtherPhone = exOtherPhone.replace(" ", "");
            }
            if (StringUtils.isBlank(exClassName) && StringUtils.isBlank(exHeadPhone) && StringUtils.isBlank(exOtherPhone)) {
                continue;
            }
            int sum = 0;
            //班级名称不能重复
            if (StringUtils.isBlank(exClassName)) {
                sum += 1;
                headTeacher.append(sum + "：班级名称不能为空。<br>");
                flag = false;
            } else {
                if (exClassName.length() < 2 || exClassName.length() > 30) {
                    sum += 1;
                    headTeacher.append(sum + "：班级名称必须在2~30个字符之间。<br>");
                    flag = false;
                } else {
                    if (ycClassMapper.selectClassByName(exClassName, ycSchool.getId()) != null) {
                        sum += 1;
                        headTeacher.append(sum + "：班级名称为" + exClassName + "的班级已存在，请重新命名。<br>");
                        flag = false;
                    }
                }
            }
            //判断班主任手机号用户是否存在
            if (StringUtils.isBlank(exHeadPhone)) {
                sum += 1;
                headTeacher.append(sum + "：班主任手机号不能为空。<br>");
                flag = false;
            } else {
                YcUser user = ycUserMapper.selectByPhone(exHeadPhone);
                if (user == null || user.getYc_role() == 1) {//为空或者为家长用户都失败
                    sum += 1;
                    headTeacher.append(sum + "：手机号为[" + exHeadPhone + "]的教师用户不存在，请先注册教师用户。<br>");
                    flag = false;
                } else {
                    if (StringUtils.isBlank(user.getYc_username())) {
                        sum += 1;
                        headTeacher.append(sum + "：手机号为" + exHeadPhone + "的教师用户姓名为空，请先完善教师信息。<br>");
                        flag = false;
                    }
                }
            }
//            判断任课教师手机号是否存在
            if (StringUtils.isNotBlank(exOtherPhone)) {
                String[] otherPhones = exOtherPhone.split("/");
                StringBuilder trueTeachers = new StringBuilder();//记录格式不正确的手机号
                StringBuilder createTeachers = new StringBuilder();//记录没有注册教师用户的任课教师
                for (String op : otherPhones) {
                    YcUser otherPhone = ycUserMapper.selectByPhone(op);
                    if (otherPhone == null || otherPhone.getYc_role() == 1) {
                        createTeachers.append("[" + op + "]");
                        flag = false;
                    }
                }
                if (StringUtils.isNotBlank(createTeachers.toString())) {
                    sum += 1;
                    headTeacher.append(sum + "：本校无手机号为" + createTeachers.toString() + "的教师用户，请先注册教师用户。<br>");
                    flag = false;
                }
            }
            if (!flag) {//有错误操作则结束循环
                break;
            }
        }

        if (flag) {
            for (int i = 0; i < personList.size(); i++) {
//                统一去掉空格
                String exClassName = personList.get(i).getClassName();//班级名称
                if (StringUtils.isNotBlank(exClassName)) {
                    exClassName = exClassName.replace(" ", "");
                }
                String exHeadPhone = personList.get(i).getPhone();//班主任手机号
                if (StringUtils.isNotBlank(exHeadPhone)) {
                    exHeadPhone = exHeadPhone.replace(" ", "");
                }
                String exOtherPhone = personList.get(i).getOtherPhone();//任课教师手机号
                if (StringUtils.isNotBlank(exOtherPhone)) {
                    exOtherPhone = exOtherPhone.replace(" ", "");
                }
                if (StringUtils.isBlank(exClassName) && StringUtils.isBlank(exHeadPhone) && StringUtils.isBlank(exOtherPhone)) {
                    continue;
                }
                try {
                    YcUser user = ycUserMapper.selectByPhone(exHeadPhone);
                    //                创建班级表
                    YcClass ycClass = new YcClass();
                    ycClass.setYc_class_id(UUIDFactory.random());
                    ycClass.setYc_class_number(RandomNumUtil.randomNum());
                    ycClass.setYc_school_id(ycSchool.getId());
                    ycClass.setYc_class_name(exClassName);
                    ycClass.setYc_class_create_time(new Date());
                    ycClass.setYc_class_create_id(ycSchool.getId());
                    ycClass.setYc_class_head_teacher_id(user.getId());
                    ycClass.setYc_class_head_teacher_name(user.getYc_username());
                    ycClass.setYc_class_avatar(image);
                    ycClass.setSa_latitude(Double.valueOf(ycSchool.getYc_school_map_address().split(",")[0]));
                    ycClass.setSa_longitude(Double.valueOf(ycSchool.getYc_school_map_address().split(",")[1]));
                    ycClass.setYc_address(ycSchool.getYc_school_address());
                    ycClass.setYc_class_introduction("这是" + ycSchool.getYc_school_name() + exClassName + "班级，欢迎各位老师和家长加入" + exClassName + "大家庭");
                    ycClass.setYc_class_nature("1");
                    ycClass.setYc_banned_status("1");

                    //        添加班级成员表
                    YcParentClass classHead = new YcParentClass();
                    classHead.setId(UUIDFactory.random());
                    classHead.setYc_parent_id(user.getId());
                    classHead.setYc_class_id(ycClass.getYc_class_id());
                    classHead.setYc_create_time(new Date());
                    classHead.setYc_status(1);
                    classHead.setYc_review_id("");
                    classHead.setYc_permission_status(1);//群主
                    classHead.setYc_verification_message("");
                    classHead.setYc_remarks("");
                    classHead.setYc_reason("");
                    classHead.setYc_message_avoidance("1");
//                      创建群
                    List<GroupMember> members = new ArrayList<>();
                    //添加群主
                    GroupMember member = new GroupMember();
                    member.setGroupId(ycClass.getYc_class_id());
                    member.setId(user.getId());
                    members.add(member);
                    ycClassMapper.insetClass(ycClass);//班级添加
                    parentClassMapper.addParentClass(classHead);//班级成员表添加

//            任课教师手机号不为空则添加任课教师
                    if (StringUtils.isNotBlank(exOtherPhone)) {
                        String[] otherPhones = exOtherPhone.split("/");
                        for (String op : otherPhones) {
                            YcUser Users = ycUserMapper.selectByPhone(op);
                            //      添加班级成员表
                            YcParentClass classTeacher = new YcParentClass();
                            classTeacher.setId(UUIDFactory.random());
                            classTeacher.setYc_parent_id(Users.getId());
                            classTeacher.setYc_class_id(ycClass.getYc_class_id());
                            classTeacher.setYc_create_time(new Date());
                            classTeacher.setYc_status(1);
                            classTeacher.setYc_review_id("");
                            classTeacher.setYc_permission_status(2);//管理员
                            classTeacher.setYc_verification_message("");
                            classTeacher.setYc_remarks("");
                            classTeacher.setYc_reason("");
                            classTeacher.setYc_message_avoidance("1");
                            parentClassMapper.addParentClass(classTeacher);
//      添加教师科目与班级关系表
                            YcIntermediateTable teacherTable = new YcIntermediateTable();
                            teacherTable.setYc_intermediate_table_id(UUIDFactory.random());
                            teacherTable.setYc_class_id(ycClass.getYc_class_id());
                            teacherTable.setYc_teacher_information_id(Users.getId());
                            if (Users.getId().equals(user.getId())) {//如果添加班主任为任课教师则职务为班主任
                                teacherTable.setYc_teacher_position(1);//班主任
                            } else {
                                teacherTable.setYc_teacher_position(2);//普通教师
                            }
                            ycIntermediateTableMapper.insert(teacherTable);
//            添加群成员（管理员）
                            GroupMember membermodel = new GroupMember();
                            membermodel.setGroupId(ycClass.getYc_class_id());
                            membermodel.setId(Users.getId());
                            members.add(membermodel);
                        }
                    }
                    //            创建融云
                    GroupMember[] memberes = new GroupMember[members.size()];
                    GroupModel group = new GroupModel().setId(ycClass.getYc_class_id()).setName(ycClass.getYc_class_name()).setMembers(members.toArray(memberes));
                    RongCloudUtil.getRongcloud().group.create(group);
                } catch (Exception e) {
                    e.printStackTrace();
                    return "发生异常，批量创建班级失败";
                }
            }
            return "批量创建班级成功";
        } else {
            return "批量创建班级失败：<br>" + headTeacher.toString();
        }
    }

    /**
     * 通过学校id查询本校教师
     */
    @Override
    public List<YcUser> findUserBySchoolId(String id) {
        return ycUserMapper.selectByfounder(id);
    }

    /**
     * 通过班级id查询任课教师
     */
    @Override
    public List<YcIntermediateTable> findClassTeacher(String id) {
        return ycIntermediateTableMapper.getIntermediateTableByClassId(id);
    }

    /**
     * 通过用户id查询用户信息
     */
    @Override
    public YcUser findUserById(String id) {
        return ycUserMapper.selectById(id);
    }

}
