package yc.xuezhifan.schoolbackstage.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import yc.xuezhifan.schoolbackstage.schoolfeedback.bean.YcSchoolFeedback;
import yc.xuezhifan.schoolbackstage.user.bean.YcUser;

/**
 * <p>Title: YcUserMapper.java </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2018年10月31日</p>
 *
 * @author xiaobai
 * @version 1.0
 * @email xiaobai@xuezhifan.com
 * @date 2018年10月31日
 */
@Mapper
public interface YcUserMapper {

    void deleteAll(String id);

    /**
     * 根据id查询用户
     *
     * @param id
     * @return 返回用户对象, 若没有返回null
     */
    YcUser selectById(String id);

    /**
     * <p>Title: selectByPhone</p>
     *
     * <p>Description: 验证手机号是否已注册</p>
     *
     * @param yc_phone
     * @return
     * @email zhuangzhuang@xuezhifan.com
     * @author zhuangzhuang
     * @date 2018年11月3日
     */
    YcUser selectByPhone(String yc_phone);

    /**
     * <p>Title: insertUser</p>
     *
     * <p>Description: 添加教师用户</p>
     *
     * @param ycUser
     * @email zhuangzhuang@xuezhifan.com
     * @author zhuangzhuang
     * @date 2018年11月3日
     */
    void insertUser(YcUser ycUser);

    /**
     * <p>Title: getUserById</p>
     *
     * <p>Description: 根据Id查询用户</p>
     *
     * @param id
     * @return
     * @email zhuangzhuang@xuezhifan.com
     * @author zhuangzhuang
     * @date 2018年11月3日
     */
    YcUser getUserById(String id);

    /**
     * 修改用户信息
     *
     * <p>Title: updateTeacherById</p>
     *
     * <p>Description: </p>
     *
     * @param ycUser
     * @email zhuangzhuang@xuezhifan.com
     * @author zhuangzhuang
     * @date 2018年11月3日
     */
    void updateTeacherById(YcUser ycUser);

    /**
     * <p>Title: deleteTeacherById</p>
     *
     * <p>Description: 删除教师信息（仅将删除状态修改为不展示）</p>
     *
     * @param teacherId
     * @return
     * @email zhuangzhuang@xuezhifan.com
     * @author zhuangzhuang
     * @date 2018年11月3日
     */
    void deleteTeacherById(String teacherId);

    /**
     * 修改密码
     *
     * @param ycUser
     */
    void updatePW(YcUser ycUser);

    /**
     * 根据手机号查询用户
     *
     * @param yc_school_principal_phone
     * @return
     */
    YcUser selectPhone(String yc_school_principal_phone);

    /**
     * 根据姓名模糊查询
     *
     * @param username
     * @return
     */
    List<YcUser> selectUsername(String username);

    /**
     * 查询全部用户token
     * @return
     */
    List<String> selectTokenAll();


    /**
     * 测试
     */
    List<YcUser> selectByfounder(String id);


}
