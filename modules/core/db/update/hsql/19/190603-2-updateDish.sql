alter table SPEEDYPIZZA_DISH add column INGREDIENTS varchar(255) ^
update SPEEDYPIZZA_DISH set INGREDIENTS = '' where INGREDIENTS is null ;
alter table SPEEDYPIZZA_DISH alter column INGREDIENTS set not null ;
