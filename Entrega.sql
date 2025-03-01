--
-- PostgreSQL database dump
--

-- Dumped from database version 14.6
-- Dumped by pg_dump version 14.6

-- Started on 2025-02-28 21:35:58

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
-- TOC entry 209 (class 1259 OID 34165)
-- Name: producto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.producto (
    prodcodi numeric(10,0) NOT NULL,
    prodnomb character varying(50) NOT NULL,
    prodprec numeric NOT NULL
);


ALTER TABLE public.producto OWNER TO postgres;

--
-- TOC entry 3304 (class 0 OID 34165)
-- Dependencies: 209
-- Data for Name: producto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.producto (prodcodi, prodnomb, prodprec) FROM stdin;
\.


--
-- TOC entry 3164 (class 2606 OID 34171)
-- Name: producto pk_producto; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.producto
    ADD CONSTRAINT pk_producto PRIMARY KEY (prodcodi);


-- Completed on 2025-02-28 21:35:59

--
-- PostgreSQL database dump complete
--

