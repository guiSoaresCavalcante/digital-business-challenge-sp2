create sequence avaliacoes_usuarios_seq start with 1 increment by 50;
create sequence categoria_software_seq start with 1 increment by 50;
create sequence recursos_software_seq start with 1 increment by 50;
create sequence software_gestao_seq start with 1 increment by 50;
create sequence usuario_seq start with 1 increment by 50;

    create table avaliacoes_usuarios (
       id_avaliacao bigint not null,
        comentarios_usuario varchar(255),
        nota_avaliacao float(53),
        id_usuario bigint,
        primary key (id_avaliacao)
    );

    create table categoria_software (
       id_categoria bigint not null,
        ativo BIT,
        descricao_categoria varchar(255),
        nm_categoria varchar(255),
        primary key (id_categoria)
    );

    create table recursos_software (
       id_recursos bigint not null,
        ativo BIT,
        descricao_recurso varchar(255),
        nm_recurso varchar(255),
        primary key (id_recursos)
    );

    create table software_gestao (
       id_software bigint not null,
        ativo BIT,
        descricao_software varchar(255),
        link_download varchar(255),
        nm_software varchar(255),
        id_avaliacao bigint,
        id_categoria bigint,
        id_recursos bigint,
        id_usuario bigint,
        primary key (id_software)
    );

    create table usuario (
       id_usuario bigint not null,
        ativo BIT,
        data_cadastro date,
        email_usuario varchar(255),
        nm_usuario varchar(255),
        senha_usuario varchar(255),
        sobrenome_usuario varchar(255),
        primary key (id_usuario)
    );

    alter table if exists avaliacoes_usuarios 
       add constraint FKd76vst0olty27si1249t16d3i 
       foreign key (id_usuario) 
       references usuario;

    alter table if exists software_gestao 
       add constraint FK9y4qoxib1wnxaoavgsmd6td4p 
       foreign key (id_avaliacao) 
       references avaliacoes_usuarios;

    alter table if exists software_gestao 
       add constraint FKdf269ifknday1unax2qf4bx0m 
       foreign key (id_categoria) 
       references categoria_software;

    alter table if exists software_gestao 
       add constraint FKar2hhciiy9cc14l4uqrn7f7x6 
       foreign key (id_recursos) 
       references recursos_software;

    alter table if exists software_gestao 
       add constraint FK6i7y0fgu5uirl8i0098825d4e 
       foreign key (id_usuario) 
       references usuario;
create sequence avaliacoes_usuarios_seq start with 1 increment by 50;
create sequence categoria_software_seq start with 1 increment by 50;
create sequence recursos_software_seq start with 1 increment by 50;
create sequence software_gestao_seq start with 1 increment by 50;
create sequence usuario_seq start with 1 increment by 50;

    create table avaliacoes_usuarios (
       id_avaliacao bigint not null,
        comentarios_usuario varchar(255),
        nota_avaliacao float(53),
        id_usuario bigint,
        primary key (id_avaliacao)
    );

    create table categoria_software (
       id_categoria bigint not null,
        ativo BIT,
        descricao_categoria varchar(255),
        nm_categoria varchar(255),
        primary key (id_categoria)
    );

    create table recursos_software (
       id_recursos bigint not null,
        ativo BIT,
        descricao_recurso varchar(255),
        nm_recurso varchar(255),
        primary key (id_recursos)
    );

    create table software_gestao (
       id_software bigint not null,
        ativo BIT,
        descricao_software varchar(255),
        link_download varchar(255),
        nm_software varchar(255),
        id_avaliacao bigint,
        id_categoria bigint,
        id_recursos bigint,
        id_usuario bigint,
        primary key (id_software)
    );

    create table usuario (
       id_usuario bigint not null,
        ativo BIT,
        data_cadastro date,
        email_usuario varchar(255),
        nm_usuario varchar(255),
        senha_usuario varchar(255),
        sobrenome_usuario varchar(255),
        primary key (id_usuario)
    );

    alter table if exists avaliacoes_usuarios 
       add constraint FKd76vst0olty27si1249t16d3i 
       foreign key (id_usuario) 
       references usuario;

    alter table if exists software_gestao 
       add constraint FK9y4qoxib1wnxaoavgsmd6td4p 
       foreign key (id_avaliacao) 
       references avaliacoes_usuarios;

    alter table if exists software_gestao 
       add constraint FKdf269ifknday1unax2qf4bx0m 
       foreign key (id_categoria) 
       references categoria_software;

    alter table if exists software_gestao 
       add constraint FKar2hhciiy9cc14l4uqrn7f7x6 
       foreign key (id_recursos) 
       references recursos_software;

    alter table if exists software_gestao 
       add constraint FK6i7y0fgu5uirl8i0098825d4e 
       foreign key (id_usuario) 
       references usuario;
create sequence avaliacoes_usuarios_seq start with 1 increment by 50;
create sequence categoria_software_seq start with 1 increment by 50;
create sequence recursos_software_seq start with 1 increment by 50;
create sequence software_gestao_seq start with 1 increment by 50;
create sequence usuario_seq start with 1 increment by 50;

    create table avaliacoes_usuarios (
       id_avaliacao bigint not null,
        comentarios_usuario varchar(255),
        nota_avaliacao float(53),
        id_usuario bigint,
        primary key (id_avaliacao)
    );

    create table categoria_software (
       id_categoria bigint not null,
        ativo BIT,
        descricao_categoria varchar(255),
        nm_categoria varchar(255),
        primary key (id_categoria)
    );

    create table recursos_software (
       id_recursos bigint not null,
        ativo BIT,
        descricao_recurso varchar(255),
        nm_recurso varchar(255),
        primary key (id_recursos)
    );

    create table software_gestao (
       id_software bigint not null,
        ativo BIT,
        descricao_software varchar(255),
        link_download varchar(255),
        nm_software varchar(255),
        id_avaliacao bigint,
        id_categoria bigint,
        id_recursos bigint,
        id_usuario bigint,
        primary key (id_software)
    );

    create table usuario (
       id_usuario bigint not null,
        ativo BIT,
        data_cadastro date,
        email_usuario varchar(255),
        nm_usuario varchar(255),
        senha_usuario varchar(255),
        sobrenome_usuario varchar(255),
        primary key (id_usuario)
    );

    alter table if exists avaliacoes_usuarios 
       add constraint FKd76vst0olty27si1249t16d3i 
       foreign key (id_usuario) 
       references usuario;

    alter table if exists software_gestao 
       add constraint FK9y4qoxib1wnxaoavgsmd6td4p 
       foreign key (id_avaliacao) 
       references avaliacoes_usuarios;

    alter table if exists software_gestao 
       add constraint FKdf269ifknday1unax2qf4bx0m 
       foreign key (id_categoria) 
       references categoria_software;

    alter table if exists software_gestao 
       add constraint FKar2hhciiy9cc14l4uqrn7f7x6 
       foreign key (id_recursos) 
       references recursos_software;

    alter table if exists software_gestao 
       add constraint FK6i7y0fgu5uirl8i0098825d4e 
       foreign key (id_usuario) 
       references usuario;
create sequence avaliacoes_usuarios_seq start with 1 increment by 50;
create sequence categoria_software_seq start with 1 increment by 50;
create sequence recursos_software_seq start with 1 increment by 50;
create sequence software_gestao_seq start with 1 increment by 50;
create sequence usuario_seq start with 1 increment by 50;

    create table avaliacoes_usuarios (
       id_avaliacao bigint not null,
        comentarios_usuario varchar(255),
        nota_avaliacao float(53),
        id_usuario bigint,
        primary key (id_avaliacao)
    );

    create table categoria_software (
       id_categoria bigint not null,
        ativo BIT,
        descricao_categoria varchar(255),
        nm_categoria varchar(255),
        primary key (id_categoria)
    );

    create table recursos_software (
       id_recursos bigint not null,
        ativo BIT,
        descricao_recurso varchar(255),
        nm_recurso varchar(255),
        primary key (id_recursos)
    );

    create table software_gestao (
       id_software bigint not null,
        ativo BIT,
        descricao_software varchar(255),
        link_download varchar(255),
        nm_software varchar(255),
        id_avaliacao bigint,
        id_categoria bigint,
        id_recursos bigint,
        id_usuario bigint,
        primary key (id_software)
    );

    create table usuario (
       id_usuario bigint not null,
        ativo BIT,
        data_cadastro date,
        email_usuario varchar(255),
        nm_usuario varchar(255),
        senha_usuario varchar(255),
        sobrenome_usuario varchar(255),
        primary key (id_usuario)
    );

    alter table if exists avaliacoes_usuarios 
       add constraint FKd76vst0olty27si1249t16d3i 
       foreign key (id_usuario) 
       references usuario;

    alter table if exists software_gestao 
       add constraint FK9y4qoxib1wnxaoavgsmd6td4p 
       foreign key (id_avaliacao) 
       references avaliacoes_usuarios;

    alter table if exists software_gestao 
       add constraint FKdf269ifknday1unax2qf4bx0m 
       foreign key (id_categoria) 
       references categoria_software;

    alter table if exists software_gestao 
       add constraint FKar2hhciiy9cc14l4uqrn7f7x6 
       foreign key (id_recursos) 
       references recursos_software;

    alter table if exists software_gestao 
       add constraint FK6i7y0fgu5uirl8i0098825d4e 
       foreign key (id_usuario) 
       references usuario;
