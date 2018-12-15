insert into abv_user(username, password, salt) values('balu', 'balu', 'balu');
insert into abv_user(username, password, salt) values('john', 'john', 'john');
insert into abv_user(username, password, salt) values('jack', 'jack', 'jack');
insert into abv_user(username, password, salt) values('jill', 'jill', 'jill');
insert into abv_user(username, password, salt) values('rose', 'rose', 'rose');
insert into abv_user(username, password, salt) values('ramu', 'ramu', 'ramu');
insert into abv_user(username, password, salt) values('divya', 'divya', 'divya');
insert into abv_user(username, password, salt) values('priya', 'priya', 'priya');
insert into abv_user(username, password, salt) values('sai', 'sai', 'sai');

insert into abv_role(role) values('ADMIN');
insert into abv_role(role) values('MANAGER');
insert into abv_role(role) values('TEAM_LEAD');
insert into abv_role(role) values('TEAM_MEMBER');

insert into abv_permission(permission) values('CREATE');
insert into abv_permission(permission) values('READ');
insert into abv_permission(permission) values('UPDATE');
insert into abv_permission(permission) values('DELETE');

insert into abv_user_role(username, role) values('john', 'ADMIN');
insert into abv_user_role(username, role) values('john', 'MANAGER');
insert into abv_user_role(username, role) values('rose', 'MANAGER');
insert into abv_user_role(username, role) values('sai', 'TEAM_LEAD');
insert into abv_user_role(username, role) values('priya', 'TEAM_MEMBER');
insert into abv_user_role(username, role) values('divya', 'TEAM_MEMBER');
insert into abv_user_role(username, role) values('ramu', 'TEAM_MEMBER');
insert into abv_user_role(username, role) values('jill', 'TEAM_LEAD');
insert into abv_user_role(username, role) values('jack', 'TEAM_MEMBER');
insert into abv_user_role(username, role) values('balu', 'TEAM_MEMBER');

insert into abv_role_permission(role, permission) values('ADMIN','CREATE');
insert into abv_role_permission(role, permission) values('ADMIN','READ');
insert into abv_role_permission(role, permission) values('ADMIN','UPDATE');
insert into abv_role_permission(role, permission) values('ADMIN','DELETE');
insert into abv_role_permission(role, permission) values('MANAGER','READ');
insert into abv_role_permission(role, permission) values('MANAGER','UPDATE');
insert into abv_role_permission(role, permission) values('MANAGER','DELETE');
insert into abv_role_permission(role, permission) values('TEAM_LEAD','READ');
insert into abv_role_permission(role, permission) values('TEAM_LEAD','UPDATE');
insert into abv_role_permission(role, permission) values('TEAM_MEMBER','READ');