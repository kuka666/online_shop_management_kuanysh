PGDMP     2                
    y            Online_shop_management    13.4    13.4 +    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    99230    Online_shop_management    DATABASE     y   CREATE DATABASE "Online_shop_management" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Russian_Kazakhstan.1251';
 (   DROP DATABASE "Online_shop_management";
                postgres    false            �            1259    99248    Order    TABLE     �   CREATE TABLE public."Order" (
    "orderID" integer NOT NULL,
    total double precision NOT NULL,
    "orderDate" date NOT NULL
);
    DROP TABLE public."Order";
       public         heap    postgres    false            �            1259    99266    cart    TABLE     H   CREATE TABLE public.cart (
    item_id integer,
    quantity integer
);
    DROP TABLE public.cart;
       public         heap    postgres    false            �            1259    99233    customer    TABLE     �   CREATE TABLE public.customer (
    id integer NOT NULL,
    name character varying(255),
    phone character varying(255),
    email character varying(255),
    password character varying(255)
);
    DROP TABLE public.customer;
       public         heap    postgres    false            �            1259    99231    customer_id_seq    SEQUENCE     �   CREATE SEQUENCE public.customer_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.customer_id_seq;
       public          postgres    false    201            �           0    0    customer_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.customer_id_seq OWNED BY public.customer.id;
          public          postgres    false    200            �            1259    99260    item    TABLE     m   CREATE TABLE public.item (
    item_id integer NOT NULL,
    quantity integer,
    price double precision
);
    DROP TABLE public.item;
       public         heap    postgres    false            �            1259    99258    item_item_id_seq    SEQUENCE     �   CREATE SEQUENCE public.item_item_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.item_item_id_seq;
       public          postgres    false    206            �           0    0    item_item_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.item_item_id_seq OWNED BY public.item.item_id;
          public          postgres    false    205            �            1259    99287 
   onlineShop    TABLE     �   CREATE TABLE public."onlineShop" (
    id integer NOT NULL,
    billing_address character varying(255) NOT NULL,
    "isClosed" boolean NOT NULL
);
     DROP TABLE public."onlineShop";
       public         heap    postgres    false            �            1259    99285    onlineShop_id_seq    SEQUENCE     �   CREATE SEQUENCE public."onlineShop_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public."onlineShop_id_seq";
       public          postgres    false    211            �           0    0    onlineShop_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public."onlineShop_id_seq" OWNED BY public."onlineShop".id;
          public          postgres    false    210            �            1259    99242    payment    TABLE     g   CREATE TABLE public.payment (
    id integer NOT NULL,
    paid boolean,
    total double precision
);
    DROP TABLE public.payment;
       public         heap    postgres    false            �            1259    99276    product    TABLE     �   CREATE TABLE public.product (
    product_id integer NOT NULL,
    "desc" character varying(255),
    price double precision NOT NULL,
    manufacturer character varying(255) NOT NULL
);
    DROP TABLE public.product;
       public         heap    postgres    false            �            1259    99274    product_product_id_seq    SEQUENCE     �   CREATE SEQUENCE public.product_product_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.product_product_id_seq;
       public          postgres    false    209            �           0    0    product_product_id_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.product_product_id_seq OWNED BY public.product.product_id;
          public          postgres    false    208            �            1259    99253    web_user    TABLE     �   CREATE TABLE public.web_user (
    login_id integer NOT NULL,
    password character varying(255) NOT NULL,
    email character varying NOT NULL
);
    DROP TABLE public.web_user;
       public         heap    postgres    false            G           2604    99236    customer id    DEFAULT     j   ALTER TABLE ONLY public.customer ALTER COLUMN id SET DEFAULT nextval('public.customer_id_seq'::regclass);
 :   ALTER TABLE public.customer ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    200    201    201            H           2604    99263    item item_id    DEFAULT     l   ALTER TABLE ONLY public.item ALTER COLUMN item_id SET DEFAULT nextval('public.item_item_id_seq'::regclass);
 ;   ALTER TABLE public.item ALTER COLUMN item_id DROP DEFAULT;
       public          postgres    false    205    206    206            J           2604    99290    onlineShop id    DEFAULT     r   ALTER TABLE ONLY public."onlineShop" ALTER COLUMN id SET DEFAULT nextval('public."onlineShop_id_seq"'::regclass);
 >   ALTER TABLE public."onlineShop" ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    210    211    211            I           2604    99279    product product_id    DEFAULT     x   ALTER TABLE ONLY public.product ALTER COLUMN product_id SET DEFAULT nextval('public.product_product_id_seq'::regclass);
 A   ALTER TABLE public.product ALTER COLUMN product_id DROP DEFAULT;
       public          postgres    false    209    208    209            �          0    99248    Order 
   TABLE DATA           @   COPY public."Order" ("orderID", total, "orderDate") FROM stdin;
    public          postgres    false    203   �,       �          0    99266    cart 
   TABLE DATA           1   COPY public.cart (item_id, quantity) FROM stdin;
    public          postgres    false    207   �,       �          0    99233    customer 
   TABLE DATA           D   COPY public.customer (id, name, phone, email, password) FROM stdin;
    public          postgres    false    201   �,       �          0    99260    item 
   TABLE DATA           8   COPY public.item (item_id, quantity, price) FROM stdin;
    public          postgres    false    206   p-       �          0    99287 
   onlineShop 
   TABLE DATA           G   COPY public."onlineShop" (id, billing_address, "isClosed") FROM stdin;
    public          postgres    false    211   �-       �          0    99242    payment 
   TABLE DATA           2   COPY public.payment (id, paid, total) FROM stdin;
    public          postgres    false    202   �-       �          0    99276    product 
   TABLE DATA           J   COPY public.product (product_id, "desc", price, manufacturer) FROM stdin;
    public          postgres    false    209   �-       �          0    99253    web_user 
   TABLE DATA           =   COPY public.web_user (login_id, password, email) FROM stdin;
    public          postgres    false    204   �-       �           0    0    customer_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.customer_id_seq', 3, true);
          public          postgres    false    200            �           0    0    item_item_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.item_item_id_seq', 1, false);
          public          postgres    false    205            �           0    0    onlineShop_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public."onlineShop_id_seq"', 1, false);
          public          postgres    false    210            �           0    0    product_product_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.product_product_id_seq', 1, false);
          public          postgres    false    208            N           2606    99252    Order Order_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public."Order"
    ADD CONSTRAINT "Order_pkey" PRIMARY KEY ("orderID");
 >   ALTER TABLE ONLY public."Order" DROP CONSTRAINT "Order_pkey";
       public            postgres    false    203            L           2606    99241    customer customer_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.customer DROP CONSTRAINT customer_pkey;
       public            postgres    false    201            R           2606    99265    item item_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.item
    ADD CONSTRAINT item_pkey PRIMARY KEY (item_id);
 8   ALTER TABLE ONLY public.item DROP CONSTRAINT item_pkey;
       public            postgres    false    206            V           2606    99292    onlineShop onlineShop_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public."onlineShop"
    ADD CONSTRAINT "onlineShop_pkey" PRIMARY KEY (id);
 H   ALTER TABLE ONLY public."onlineShop" DROP CONSTRAINT "onlineShop_pkey";
       public            postgres    false    211            T           2606    99284    product product_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (product_id);
 >   ALTER TABLE ONLY public.product DROP CONSTRAINT product_pkey;
       public            postgres    false    209            P           2606    99257    web_user webUser_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.web_user
    ADD CONSTRAINT "webUser_pkey" PRIMARY KEY (login_id);
 A   ALTER TABLE ONLY public.web_user DROP CONSTRAINT "webUser_pkey";
       public            postgres    false    204            W           2606    99269    cart cart_item_id_fkey    FK CONSTRAINT     y   ALTER TABLE ONLY public.cart
    ADD CONSTRAINT cart_item_id_fkey FOREIGN KEY (item_id) REFERENCES public.item(item_id);
 @   ALTER TABLE ONLY public.cart DROP CONSTRAINT cart_item_id_fkey;
       public          postgres    false    206    207    2898            �      x������ � �      �      x������ � �      �   h   x�3��.M̫,��0707704�44��.�N�a#Cs������RΔ���dC#c.#NKsKKN �����,,O-*���g`��e7���Ԃ��"Y6F��� B�#�      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �   .   x�323�41��.M̫,�00V�,,O-*�t�M���+*����� ��     