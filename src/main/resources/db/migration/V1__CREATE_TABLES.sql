-- public.persons definition
-- Drop table
-- DROP TABLE public.persons;

create table hibernate_sequence (
	next_val bigint
) engine=MyISAM

insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );

CREATE TABLE public.persons (
	person_id int4 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	first_name_base varchar(30) NOT NULL,
	first_name_who varchar(10) NULL,
	first_name_to varchar(10) NULL,
	first_name_from varchar(10) NULL,
	last_name_base varchar(30) NOT NULL,
	last_name_who varchar(10) NULL,
	last_name_to varchar(10) NULL,
	last_name_from varchar(10) NULL,
	middle_name_base varchar(30) NULL,
	middle_name_who varchar(10) NULL,
	middle_name_to varchar(10) NULL,
	middle_name_from varchar(10) NULL,
	email varchar(100) NULL,
	job_position varchar(100) NULL,
	job_department varchar(100) NULL,
	CONSTRAINT persons_pkey PRIMARY KEY (person_id)
) engine=MyISAM;

-- public.task_types definition
-- Drop table
-- DROP TABLE public.task_types;

CREATE TABLE public.task_types (
	type_id int4 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	title varchar(50) NULL,
	CONSTRAINT task_types_pkey PRIMARY KEY (type_id)
) engine=MyISAM;

-- public.tasks definition
-- Drop table
-- DROP TABLE public.tasks;

CREATE TABLE public.tasks (
	task_id int4 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	title varchar(100) NOT NULL DEFAULT 'Заголовок задачи'::character varying,
	description varchar(1000) NULL DEFAULT 'Описание задачи ...'::character varying,
	parent_task_id int4 NULL,
	initiator_id int4 NULL,
	manager_id int4 NULL,
	date_start date NOT NULL,
	date_end date NULL,
	task_type_id int4 NOT NULL,
	work_app_id int4 NULL,
	CONSTRAINT tasks_pkey PRIMARY KEY (task_id)
) engine=MyISAM;


-- public.work_apps definition
-- Drop table
-- DROP TABLE public.work_apps;

CREATE TABLE public.work_apps (
	work_app_id int4 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	title varchar(10) NOT NULL,
	description varchar(100) NULL,
	CONSTRAINT work_apps_pkey PRIMARY KEY (work_app_id)
) engine=MyISAM;


CREATE TABLE public.task_statuses (
	type_id int4 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	title varchar(50) NULL,
	CONSTRAINT task_statuses_pkey PRIMARY KEY (type_id)
) engine=MyISAM;