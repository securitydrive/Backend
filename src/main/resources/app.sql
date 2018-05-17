CREATE DATABASE RoadSafe;

USE RoadSafe;

CREATE TABLE `app_user_info`(
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(64) NOT NULL COMMENT ''用户唯一标识'',
  `user_pwd` VARCHAR(255) NOT NULL COMMENT ''密码 MD5 加密后'',
  `salt` VARCHAR(64) NOT NULL COMMENT ''MD5加密用SALT'',
  `user_name` VARCHAR(64) NOT NULL,
  `user_headimg` TEXT DEFAULT '''',
  `user_email` VARCHAR(255) DEFAULT '''',
  `user_phone` VARCHAR(64) DEFAULT '''',
  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP NOT NULL DEFAULT current_timestamp,
  PRIMARY KEY (`id`)
)CHARSET = UTF8 ENGINE = INNODB COMMENT ''app_user_info'';

CREATE TABLE `app_admin_info`(
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `admin_id` VARCHAR(64) NOT NULL COMMENT ''用户唯一标识'',
  `admin_pwd` VARCHAR(255) NOT NULL COMMENT ''密码 MD5 加密后'',
  `salt` VARCHAR(64) NOT NULL COMMENT ''MD5加密用SALT'',
  `admin_name` VARCHAR(64) NOT NULL,
  `admin_headimg` TEXT DEFAULT '''',
  `admin_email` VARCHAR(255) DEFAULT '''',
  `admin_phone` VARCHAR(64) DEFAULT '''',
  `status` INT DEFAULT 0 COMMENT ''可根据需要如管理员等级等，自定义'',
  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP NOT NULL DEFAULT current_timestamp,
  PRIMARY KEY (`id`)
)CHARSET = UTF8 ENGINE = INNODB COMMENT ''app_user_info'';


CREATE TABLE `app_user_car`(
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(64) NOT NULL,
  `car_id` VARCHAR(64) NOT NULL COMMENT ''用户唯一标识'',
  `car_type` VARCHAR(64) NOT NULL,
  `car_number` VARCHAR(255) NOT NULL COMMENT ''车号'',
  `note` TEXT DEFAULT '''' COMMENT ''备注'',
  `car_img` TEXT NOT NULL,
  `obd_number` TEXT NOT NULL DEFAULT '''' COMMENT ''obd设备号'',
  `usual_site` TEXT DEFAULT '''' COMMENT ''常驻位置'',
  `usual_des` TEXT DEFAULT '''' COMMENT ''经常前往的目的地'',
  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP NOT NULL DEFAULT current_timestamp,
  PRIMARY KEY (`id`)
)CHARSET = UTF8 ENGINE = INNODB COMMENT ''app_user_car'';

CREATE TABLE `app_pay_info`(
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(64) NOT NULL,
  `trade_id` VARCHAR(64) NOT NULL COMMENT ''交易唯一标识'',
  `price` INT UNSIGNED NOT NULL COMMENT ''价格，单位分'',
  `car_number` VARCHAR(255) NOT NULL COMMENT ''车号'',
  `info` TEXT DEFAULT '''' COMMENT ''服务/商品具体信息'',
  `title` TEXT DEFAULT '''' COMMENT ''服务/商品标题'',
  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP NOT NULL DEFAULT current_timestamp,
  PRIMARY KEY (`id`)
)CHARSET = UTF8 ENGINE = INNODB COMMENT ''app_pay_info'';

CREATE TABLE `app_ads`(
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `ad_id` VARCHAR(64) NOT NULL COMMENT ''广告唯一标识'',
  `ad_info` TEXT DEFAULT '''' COMMENT ''广告描述信息'',
  `ad_title` TEXT NOT NULL COMMENT ''广告标题'',
  `ad_content` TEXT NOT NULL COMMENT ''广告内容'',
  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP NOT NULL DEFAULT current_timestamp,
  PRIMARY KEY (`id`)
)CHARSET = UTF8 ENGINE = INNODB COMMENT ''app_ads'';

CREATE TABLE `app_data_store`(
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `data_id` VARCHAR(64) NOT NULL,
  `long` VARCHAR(32) NOT NULL COMMENT ''经度'',
  `lat` VARCHAR(32) NOT NULL COMMENT ''纬度'',
  `car_id` VARCHAR(64) NOT NULL COMMENT ''对应车号'',
  `car_speed` FLOAT DEFAULT 0 COMMENT ''车速'',
  `car_acc` FLOAT DEFAULT 0 COMMENT ''车加速度'',
  `gas_use` FLOAT DEFAULT 0 COMMENT ''油耗'',
  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP NOT NULL DEFAULT current_timestamp,
  PRIMARY KEY (`id`)
)CHARSET = UTF8 ENGINE = INNODB COMMENT ''app_data_store'';

CREATE TABLE `app_data_deal`(
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `data_id` VARCHAR(64) NOT NULL COMMENT ''对应信息id'',
  `deal_id` VARCHAR(64) NOT NULL COMMENT ''信息处理id'',
  `long` VARCHAR(32) NOT NULL COMMENT ''经度'',
  `lat` VARCHAR(32) NOT NULL COMMENT ''纬度'',
  `car_id` VARCHAR(64) NOT NULL COMMENT ''对应车号'',
  `car_speed` FLOAT DEFAULT 0 COMMENT ''车速'',
  `car_acc` FLOAT DEFAULT 0 COMMENT ''车加速度'',
  `gas_use` FLOAT DEFAULT 0 COMMENT ''油耗'',
  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP NOT NULL DEFAULT current_timestamp,
  PRIMARY KEY (`id`)
)CHARSET = UTF8 ENGINE = INNODB COMMENT ''app_data_deal'';

CREATE TABLE `app_data_result`(
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `result_id` VARCHAR(64) NOT NULL COMMENT ''结果id'',
  `data_id` VARCHAR(64) NOT NULL COMMENT ''对应信息id'',
  `deal_id` VARCHAR(64) NOT NULL COMMENT ''信息处理id'',
  `result_msg` TEXT DEFAULT '''' COMMENT ''结果'',
  `long` VARCHAR(32) NOT NULL COMMENT ''经度'',
  `lat` VARCHAR(32) NOT NULL COMMENT ''纬度'',
  `car_id` VARCHAR(64) NOT NULL COMMENT ''对应车号'',
  `car_speed` FLOAT DEFAULT 0 COMMENT ''车速'',
  `car_acc` FLOAT DEFAULT 0 COMMENT ''车加速度'',
  `gas_use` FLOAT DEFAULT 0 COMMENT ''油耗'',
  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP NOT NULL DEFAULT current_timestamp,
  PRIMARY KEY (`id`)
)CHARSET = UTF8 ENGINE = INNODB COMMENT ''app_data_result'';