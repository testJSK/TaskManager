-- -- -- -- -- -- -- --
-- -- -- v 1.1 -- -- --
-- -- -- -- -- -- -- --

-- create table dbo.hibernate_sequence (
-- 	next_val bigint
-- );

-- insert into hibernate_sequence values ( 1 );
-- insert into hibernate_sequence values ( 1 );

-- TABLE ISSUES --
-- DROP TABLE public.issues 

CREATE SCHEMA public

-- CREATE TABLE IF NOT EXISTS public.test_issues (
-- 	issue_id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY,
-- 	title varchar(300) NOT NULL,
-- 	description varchar(5000) NULL,
-- 	parent_id integer NULL,
-- 	manager_id integer NULL,
-- 	initiator_id integer NULL,
-- 	type_id integer NULL,
-- 	status_id integer NULL,
-- 	work_app_id integer NULL,
-- 	date_start timestamp NULL,
-- 	date_end timestamp NULL,
-- 	additional_data jsonb NULL,
-- 	CONSTRAINT issues_pkey PRIMARY KEY (issue_id)
-- );

-- CREATE TABLE dbo.persons (
-- 	person_id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY,
-- 	first_name varchar(30) NOT NULL, 
-- 	last_name varchar(30) NOT NULL,
-- 	middle_name varchar(30) NOT NULL,
-- 	additional_data jsonb NULL,
-- 	CONSTRAINT persons_pkey PRIMARY KEY (person_id)
-- );

-- CREATE TABLE dbo.issue_statuses (
-- 	status_id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY,
-- 	title varchar(50) NOT NULL, 
-- 	CONSTRAINT issue_statuses_pkey PRIMARY KEY (status_id)
-- );

-- CREATE TABLE dbo.issue_types (
-- 	type_id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY,  
-- 	title varchar(50) NOT NULL,
-- 	CONSTRAINT issue_types_pkey PRIMARY KEY (type_id)
-- );

-- CREATE TABLE dbo.work_apps (
-- 	work_app_id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY,
-- 	title varchar(50) NOT NULL,
-- 	CONSTRAINT work_apps_pkey PRIMARY KEY (work_app_id)
-- );



-- -- -- -- -- -- -- -- --
-- -- -- --  END  -- -- --
-- -- -- -- -- -- -- -- --



-- $ gradle flywayMigrate -i