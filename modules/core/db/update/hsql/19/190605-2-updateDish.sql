alter table SPEEDYPIZZA_DISH alter column ORDER_ID rename to ORDER_ID__U64659 ^
drop index IDX_SPEEDYPIZZA_DISH_ON_ORDER ;
alter table SPEEDYPIZZA_DISH drop constraint FK_SPEEDYPIZZA_DISH_ON_ORDER ;
