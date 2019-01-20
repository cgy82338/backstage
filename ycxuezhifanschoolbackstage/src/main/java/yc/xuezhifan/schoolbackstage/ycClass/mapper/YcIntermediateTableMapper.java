package yc.xuezhifan.schoolbackstage.ycClass.mapper;

import java.util.List;

import javax.jws.soap.InitParam;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import yc.xuezhifan.schoolbackstage.ycClass.bean.YcIntermediateTable;

/**
 * @author hanchangqing
 * @version 创建时间：2018年8月6日 下午4:13:00
 * 教师科目与班级关系表
 */
@Mapper
public interface YcIntermediateTableMapper {

    /**
     * 添加教师科目与班级关系
     *
     * @param ycIntermediateTableMapper
     */
    void insert(YcIntermediateTable ycIntermediateTable);

    /**
     * <p>Title: getIntermediateTableByClassId</p>
     *
     * <p>Description: 根据班级id查询信息</p>
     *
     * @return
     * @email zhuangzhuang@xuezhifan.com
     * @author zhuangzhuang
     * @date 2018年9月22日
     */
    List<YcIntermediateTable> getIntermediateTableByClassId(String yc_class_id);

    /**
     * <p>Title: deleteIntermediateTable</p>
     *
     * <p>Description: 批量删除</p>
     *
     * @param yc_class_id
     * @email zhuangzhuang@xuezhifan.com
     * @author zhuangzhuang
     * @date 2018年9月22日
     */
    void deleteIntermediateTable(String yc_class_id);


    /*
    根据主键id删除信息
     */
    void deleteIntermediateById(String yc_intermediate_table_id);

    /**
     * <p>Title: selectByClassAndTeacher</p>
     *
     * <p>Description: 根据班级ID和教师ID查询信息</p>
     *
     * @param ycIntermediateTable
     * @return
     * @email zhuangzhuang@xuezhifan.com
     * @author zhuangzhuang
     * @date 2018年9月23日
     */
    YcIntermediateTable selectByClassAndTeacher(YcIntermediateTable ycIntermediateTable);

    /**
     * <p>Title: deleteIntermediateTableByTeacher</p>
     *
     * <p>Description: 根据教师Id删除</p>
     *
     * @param string
     * @email zhuangzhuang@xuezhifan.com
     * @author zhuangzhuang
     * @date 2018年9月23日
     */
    void deleteIntermediateTableByTeacher(String string);

    /**
     * <p>Title: deleteByTeacherAndClassId</p>
     *
     * <p>Description: 根据教师ID和班级id删除信息</p>
     *
     * @param string
     * @param yc_class_id
     * @email zhuangzhuang@xuezhifan.com
     * @author zhuangzhuang
     * @date 2018年12月8日
     */
    void deleteByTeacherAndClassId(@Param("teacherId") String teacherId, @Param("yc_class_id") String yc_class_id);


    /***********************************************************************************************/

    /**
     * 查询所有教师科目与班级关系
     *
     * @return
     */
    List<YcIntermediateTableMapper> findAll();


    /**
     * <p>Title: getIntermediateTableByTeacherId</p>
     *
     * <p>Description: 根据教师id查询信息</p>
     *
     * @param id
     * @return
     * @email zhuangzhuang@xuezhifan.com
     * @author zhuangzhuang
     * @date 2018年10月8日
     */
    YcIntermediateTable getIntermediateTableByTeacherId(String id);

    /*
    通过id修改教师职务
     */
    void updatePosition(@Param("yc_teacher_position") Integer yc_teacher_position, @Param("yc_intermediate_table_id") String yc_intermediate_table_id);

}
