-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('患者情况信息', '3', '1', '/system/patientinfo', 'C', '0', 'system:patientinfo:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '患者情况信息菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('患者情况信息查询', @parentId, '1',  '#',  'F', '0', 'system:patientinfo:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('患者情况信息新增', @parentId, '2',  '#',  'F', '0', 'system:patientinfo:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('患者情况信息修改', @parentId, '3',  '#',  'F', '0', 'system:patientinfo:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('患者情况信息删除', @parentId, '4',  '#',  'F', '0', 'system:patientinfo:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('患者情况信息导出', @parentId, '5',  '#',  'F', '0', 'system:patientinfo:export',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');
