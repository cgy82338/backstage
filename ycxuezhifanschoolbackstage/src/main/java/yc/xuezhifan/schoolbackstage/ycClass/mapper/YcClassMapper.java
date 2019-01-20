package yc.xuezhifan.schoolbackstage.ycClass.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import yc.xuezhifan.schoolbackstage.ycClass.bean.YcClass;

/**
 * <p>Title: YcClassMapper.java </p>
 *
 * <p>Description: 班级表Mapper</p>
 *
 * <p>Copyright: Copyright (c) 2018年9月22日</p>
 *
 * @author zhuangzhuang
 * @version 1.0
 * @email zhuangzhuang@xuezhifan.com
 * @date 2018年9月22日
 */
@Mapper
public interface YcClassMapper {

    /**
     * <p>Title: selectClassByName</p>
     *
     * <p>Description: 根据班级名称查询班级信息</p>
     *
     * @param ycClassId
     * @param ycSchoolId
     * @return
     * @email zhuangzhuang@xuezhifan.com
     * @author zhuangzhuang
     * @date 2018年9月22日
     */
    YcClass selectClassByName(@Param("ycClassId") String ycClassId, @Param("ycSchoolId") String ycSchoolId);

    /**
     * <p>Title: insetClass</p>
     *
     * <p>Description: 添加班级</p>
     *
     * @param ycClass
     * @email zhuangzhuang@xuezhifan.com
     * @author zhuangzhuang
     * @date 2018年11月2日
     */
    void insetClass(YcClass ycClass);

    /**
     * <p>Title: selectClassById</p>
     *
     * <p>Description: 根据班级Id查询班级信息</p>
     *
     * @param yc_class_id
     * @return
     * @email zhuangzhuang@xuezhifan.com
     * @author zhuangzhuang
     * @date 2018年9月22日
     */
    YcClass selectClassById(String yc_class_id);

    /**
     * <p>Title: deleteClass</p>
     *
     * <p>Description: 删除班级信息</p>
     *
     * @param yc_class_id
     * @email zhuangzhuang@xuezhifan.com
     * @author zhuangzhuang
     * @date 2018年9月22日
     */
    void deleteClass(String yc_class_id);

    /**
     * <p>Title: updateClass</p>
     *
     * <p>Description: 修改班级信息</p>
     *
     * @param ycClass
     * @email zhuangzhuang@xuezhifan.com
     * @author zhuangzhuang
     * @date 2018年9月22日
     */
    void updateClass(YcClass ycClass);

    /**
     * <p>Title: getClass</p>
     *
     * <p>Description: 查询班级信息</p>
     *
     * @param id
     * @return
     * @email zhuangzhuang@xuezhifan.com
     * @author zhuangzhuang
     * @date 2018年9月22日
     */
    List<YcClass> getClass(String id);

    /**
     * <p>Title: getClass</p>
     *
     * <p>Description: 根据班主任id查询班级信息</p>
     *
     * @param id
     * @return
     * @email zhuangzhuang@xuezhifan.com
     * @author zhuangzhuang
     * @date 2018年9月22日
     */
    List<YcClass> findHeadTeahcerById(String id);

}
