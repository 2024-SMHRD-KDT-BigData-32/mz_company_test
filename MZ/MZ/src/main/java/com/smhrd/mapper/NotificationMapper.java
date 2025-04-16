package com.smhrd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.smhrd.entity.Notification;

@Mapper
public interface NotificationMapper {

	void insertNotification(Notification notification);

	List<Notification> selectNotifyByUserId	(@Param("user_id") String user_id);

	boolean updateNotification(@Param("notification_idx") Integer notification_idx, @Param("is_read") boolean is_read);

	boolean deleteNotification(@Param("notification_idx") Integer notification_idx);

}
