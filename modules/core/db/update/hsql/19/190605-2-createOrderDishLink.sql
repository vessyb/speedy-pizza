alter table SPEEDYPIZZA_ORDER_DISH_LINK add constraint FK_ORDDIS_ON_DISH foreign key (DISH_ID) references SPEEDYPIZZA_DISH(ID);
alter table SPEEDYPIZZA_ORDER_DISH_LINK add constraint FK_ORDDIS_ON_ORDER foreign key (ORDER_ID) references SPEEDYPIZZA_ORDER(ID);