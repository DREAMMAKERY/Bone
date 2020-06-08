-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('患者报告单', '3', '1', '/system/patientreport', 'C', '0', 'system:patientreport:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '患者报告单菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('患者报告单查询', @parentId, '1',  '#',  'F', '0', 'system:patientreport:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('患者报告单新增', @parentId, '2',  '#',  'F', '0', 'system:patientreport:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('患者报告单修改', @parentId, '3',  '#',  'F', '0', 'system:patientreport:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('患者报告单删除', @parentId, '4',  '#',  'F', '0', 'system:patientreport:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('患者报告单导出', @parentId, '5',  '#',  'F', '0', 'system:patientreport:export',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');
