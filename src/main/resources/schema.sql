/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  vako
 * Created: Apr 13, 2023
 */
create table player (
id bigint not null auto_increment,
name varchar(255) not null,
role varchar(255) not null,
token bigint not null,
userid  varchar(100) not null,
 primary key (id) );
