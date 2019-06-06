create table SPEEDYPIZZA_ORDER_DISH_LINK (
    DISH_ID varchar(36) not null,
    ORDER_ID varchar(36) not null,
    primary key (DISH_ID, ORDER_ID)
);
