-- begin SPEEDYPIZZA_ORDER
create table SPEEDYPIZZA_ORDER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NUMBER_ varchar(255) not null,
    INSTRUCTIONS varchar(255),
    DELIVERY_TIME decimal(19, 2) not null,
    TOTAL decimal(19, 2) not null,
    DATE_ date not null,
    CUSTOMER_ID varchar(36),
    DISCOUNT decimal(19, 2),
    --
    primary key (ID)
)^
-- end SPEEDYPIZZA_ORDER
-- begin SPEEDYPIZZA_CUSTOMER
create table SPEEDYPIZZA_CUSTOMER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    USERNAME_ID varchar(36) not null,
    PHONE_NUMBER varchar(255) not null,
    DISCOUNT decimal(19, 2),
    ADDRESS varchar(255) not null,
    --
    primary key (ID)
)^
-- end SPEEDYPIZZA_CUSTOMER
-- begin SPEEDYPIZZA_DISH
create table SPEEDYPIZZA_DISH (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    PRICE decimal(19, 2) not null,
    PHOTO_ID varchar(36) not null,
    DISH_TYPE_ID varchar(36) not null,
    INGREDIENTS varchar(255) not null,
    --
    primary key (ID)
)^
-- end SPEEDYPIZZA_DISH
-- begin SPEEDYPIZZA_CLERK
create table SPEEDYPIZZA_CLERK (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    USERNAME_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end SPEEDYPIZZA_CLERK
-- begin SPEEDYPIZZA_DISH_TYPE
create table SPEEDYPIZZA_DISH_TYPE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end SPEEDYPIZZA_DISH_TYPE
-- begin SPEEDYPIZZA_ORDER_DISH_LINK
create table SPEEDYPIZZA_ORDER_DISH_LINK (
    DISH_ID varchar(36) not null,
    ORDER_ID varchar(36) not null,
    primary key (DISH_ID, ORDER_ID)
)^
-- end SPEEDYPIZZA_ORDER_DISH_LINK
