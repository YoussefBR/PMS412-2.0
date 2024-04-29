--
-- PostgreSQL database dump
--

-- Dumped from database version 14.11 (Homebrew)
-- Dumped by pg_dump version 14.11 (Homebrew)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: doctors; Type: TABLE; Schema: public; Owner: youssefbr
--

CREATE TABLE public.doctors (
    employee_id integer NOT NULL,
    department character varying(50),
    specialty character varying(50)
);


ALTER TABLE public.doctors OWNER TO youssefbr;

--
-- Name: employees; Type: TABLE; Schema: public; Owner: youssefbr
--

CREATE TABLE public.employees (
    employee_id integer NOT NULL,
    name character varying(100),
    email character varying(100),
    phone_num character(10),
    role character varying(50)
);


ALTER TABLE public.employees OWNER TO youssefbr;

--
-- Name: employees_employee_id_seq; Type: SEQUENCE; Schema: public; Owner: youssefbr
--

CREATE SEQUENCE public.employees_employee_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.employees_employee_id_seq OWNER TO youssefbr;

--
-- Name: employees_employee_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: youssefbr
--

ALTER SEQUENCE public.employees_employee_id_seq OWNED BY public.employees.employee_id;


--
-- Name: logins; Type: TABLE; Schema: public; Owner: youssefbr
--

CREATE TABLE public.logins (
    login character varying(100) NOT NULL,
    password character varying(100),
    employee_id integer,
    patient_id integer
);


ALTER TABLE public.logins OWNER TO youssefbr;

--
-- Name: patient_assignments; Type: TABLE; Schema: public; Owner: youssefbr
--

CREATE TABLE public.patient_assignments (
    patient_id integer NOT NULL,
    employee_id integer
);


ALTER TABLE public.patient_assignments OWNER TO youssefbr;

--
-- Name: patients; Type: TABLE; Schema: public; Owner: youssefbr
--

CREATE TABLE public.patients (
    patient_id integer NOT NULL,
    name character varying(100),
    email character varying(100),
    phone_num character(10),
    birthdate date,
    sex character(1),
    weight numeric(5,2),
    height numeric(5,2)
);


ALTER TABLE public.patients OWNER TO youssefbr;

--
-- Name: patients_patient_id_seq; Type: SEQUENCE; Schema: public; Owner: youssefbr
--

CREATE SEQUENCE public.patients_patient_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.patients_patient_id_seq OWNER TO youssefbr;

--
-- Name: patients_patient_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: youssefbr
--

ALTER SEQUENCE public.patients_patient_id_seq OWNED BY public.patients.patient_id;


--
-- Name: employees employee_id; Type: DEFAULT; Schema: public; Owner: youssefbr
--

ALTER TABLE ONLY public.employees ALTER COLUMN employee_id SET DEFAULT nextval('public.employees_employee_id_seq'::regclass);


--
-- Name: patients patient_id; Type: DEFAULT; Schema: public; Owner: youssefbr
--

ALTER TABLE ONLY public.patients ALTER COLUMN patient_id SET DEFAULT nextval('public.patients_patient_id_seq'::regclass);


--
-- Data for Name: doctors; Type: TABLE DATA; Schema: public; Owner: youssefbr
--

COPY public.doctors (employee_id, department, specialty) FROM stdin;
3	cardiology	heart failure & transplantation
4	dermatology	acne
\.


--
-- Data for Name: employees; Type: TABLE DATA; Schema: public; Owner: youssefbr
--

COPY public.employees (employee_id, name, email, phone_num, role) FROM stdin;
1	fake_caregiver	fake.caregiver@gmail.com	1234567890	admin
3	fake_doctor	doctor@gmail.com	1324567890	doctor
4	doctor2	doctor2@gmail.com	1235467890	doctor
\.


--
-- Data for Name: logins; Type: TABLE DATA; Schema: public; Owner: youssefbr
--

COPY public.logins (login, password, employee_id, patient_id) FROM stdin;
admin	1234	1	\N
patient	1234	\N	17
doctor	1234	3	\N
\.


--
-- Data for Name: patient_assignments; Type: TABLE DATA; Schema: public; Owner: youssefbr
--

COPY public.patient_assignments (patient_id, employee_id) FROM stdin;
17	3
\.


--
-- Data for Name: patients; Type: TABLE DATA; Schema: public; Owner: youssefbr
--

COPY public.patients (patient_id, name, email, phone_num, birthdate, sex, weight, height) FROM stdin;
17	fake_patient	fake.patient2@gmail.com	1234567890	1990-01-01	M	150.00	72.00
19	another_patient	patient@gmail.com	0987654321	2002-10-10	F	130.00	64.00
\.


--
-- Name: employees_employee_id_seq; Type: SEQUENCE SET; Schema: public; Owner: youssefbr
--

SELECT pg_catalog.setval('public.employees_employee_id_seq', 4, true);


--
-- Name: patients_patient_id_seq; Type: SEQUENCE SET; Schema: public; Owner: youssefbr
--

SELECT pg_catalog.setval('public.patients_patient_id_seq', 20, true);


--
-- Name: doctors doctors_pkey; Type: CONSTRAINT; Schema: public; Owner: youssefbr
--

ALTER TABLE ONLY public.doctors
    ADD CONSTRAINT doctors_pkey PRIMARY KEY (employee_id);


--
-- Name: employees employees_email_key; Type: CONSTRAINT; Schema: public; Owner: youssefbr
--

ALTER TABLE ONLY public.employees
    ADD CONSTRAINT employees_email_key UNIQUE (email);


--
-- Name: employees employees_pkey; Type: CONSTRAINT; Schema: public; Owner: youssefbr
--

ALTER TABLE ONLY public.employees
    ADD CONSTRAINT employees_pkey PRIMARY KEY (employee_id);


--
-- Name: logins logins_pkey; Type: CONSTRAINT; Schema: public; Owner: youssefbr
--

ALTER TABLE ONLY public.logins
    ADD CONSTRAINT logins_pkey PRIMARY KEY (login);


--
-- Name: patient_assignments patient_assignments_pkey; Type: CONSTRAINT; Schema: public; Owner: youssefbr
--

ALTER TABLE ONLY public.patient_assignments
    ADD CONSTRAINT patient_assignments_pkey PRIMARY KEY (patient_id);


--
-- Name: patients patients_email_key; Type: CONSTRAINT; Schema: public; Owner: youssefbr
--

ALTER TABLE ONLY public.patients
    ADD CONSTRAINT patients_email_key UNIQUE (email);


--
-- Name: patients patients_pkey; Type: CONSTRAINT; Schema: public; Owner: youssefbr
--

ALTER TABLE ONLY public.patients
    ADD CONSTRAINT patients_pkey PRIMARY KEY (patient_id);


--
-- Name: doctors doctors_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: youssefbr
--

ALTER TABLE ONLY public.doctors
    ADD CONSTRAINT doctors_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES public.employees(employee_id);


--
-- Name: logins logins_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: youssefbr
--

ALTER TABLE ONLY public.logins
    ADD CONSTRAINT logins_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES public.employees(employee_id);


--
-- Name: logins logins_patient_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: youssefbr
--

ALTER TABLE ONLY public.logins
    ADD CONSTRAINT logins_patient_id_fkey FOREIGN KEY (patient_id) REFERENCES public.patients(patient_id);


--
-- Name: patient_assignments patient_assignments_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: youssefbr
--

ALTER TABLE ONLY public.patient_assignments
    ADD CONSTRAINT patient_assignments_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES public.doctors(employee_id);


--
-- Name: patient_assignments patient_assignments_patient_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: youssefbr
--

ALTER TABLE ONLY public.patient_assignments
    ADD CONSTRAINT patient_assignments_patient_id_fkey FOREIGN KEY (patient_id) REFERENCES public.patients(patient_id);


--
-- Name: TABLE doctors; Type: ACL; Schema: public; Owner: youssefbr
--

GRANT ALL ON TABLE public.doctors TO script;


--
-- Name: TABLE employees; Type: ACL; Schema: public; Owner: youssefbr
--

GRANT ALL ON TABLE public.employees TO script;


--
-- Name: SEQUENCE employees_employee_id_seq; Type: ACL; Schema: public; Owner: youssefbr
--

GRANT USAGE,UPDATE ON SEQUENCE public.employees_employee_id_seq TO script;


--
-- Name: TABLE logins; Type: ACL; Schema: public; Owner: youssefbr
--

GRANT ALL ON TABLE public.logins TO script;


--
-- Name: TABLE patient_assignments; Type: ACL; Schema: public; Owner: youssefbr
--

GRANT ALL ON TABLE public.patient_assignments TO script;


--
-- Name: TABLE patients; Type: ACL; Schema: public; Owner: youssefbr
--

GRANT ALL ON TABLE public.patients TO script;


--
-- Name: SEQUENCE patients_patient_id_seq; Type: ACL; Schema: public; Owner: youssefbr
--

GRANT USAGE,UPDATE ON SEQUENCE public.patients_patient_id_seq TO script;


--
-- PostgreSQL database dump complete
--

