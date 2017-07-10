package org.hrm.dao;

import static org.hrm.util.common.HrmConstants.NOTICETABLE;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;
import org.hrm.domain.Notice;
import org.hrm.util.common.provider.NoticeDynaSqlProvider;;


public interface NoticeDao {

	// 动态查询
	@SelectProvider(type=NoticeDynaSqlProvider.class,method="selectWhitParam")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="CREATE_DATE",property="createDate",javaType=java.util.Date.class),
		@Result(column="USER_ID",property="user",
			one=@One(select="org.hrm.dao.UserDao.selectById",
		fetchType=FetchType.EAGER))
	})
	List<Notice> selectByPage(Map<String, Object> params);
	
	@SelectProvider(type=NoticeDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);
		
	@Select("select * from "+NOTICETABLE+" where ID = #{id}")
	Notice selectById(int id);
	
	// 根据id删除公告
	@Delete(" delete from "+NOTICETABLE+" where id = #{id} ")
	void deleteById(Integer id);
		
	// 动态插入公告
	@SelectProvider(type=NoticeDynaSqlProvider.class,method="insertNotice")
	void save(Notice notice);
		
	// 动态修改公告
	@SelectProvider(type=NoticeDynaSqlProvider.class,method="updateNotice")
	void update(Notice notice);
	
}
