-- 首先创建一个数据库,名字叫做top_list
create database top_list;               -- 创建数据库

use top_list;                           -- 使用数据库

-- 存储图片的表格
create table images(
    id int primary key auto_increment,  -- 图片id
    path text,                          -- 图片路径
    tid int,                            -- 栏目表id
    name varchar(30),                   -- 图片对应名称
    description text,                   -- 介绍
    deleted int                         -- 是否已经删除 1为已经删除 0为没有删除
);

-- 存储后台密码的表格
create table users(
    id int primary key auto_increment,  -- 用户id
    password_md5 text,               -- 加密的密码
    salt text,                          -- 盐值
    name varchar(50),                   -- 用户名
    description text,                   -- 介绍
    deleted int                         -- 是否已经删除 1为已经删除 0为没有删除
);

-- 存储栏目的表格

create table tops(
    id int primary key auto_increment,  -- 栏目id
    name text,                          -- 栏目名
    description text,                   -- 介绍
    deleted int                         -- 是否已经删除 1为已经删除 0为没有删除
);

