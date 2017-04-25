-- 19/03/2015
create table Hub (
        id bigint not null auto_increment,
        createdBy varchar(255),
        createdDate datetime,
        lastUpdated datetime,
        lastUpdatedBy varchar(255),
        version integer not null,
        name varchar(255),
        trainee_id bigint,
        trainingProgram_id bigint,
        primary key (id)
    ) ENGINE=InnoDB;
    
    alter table Hub 
        add index FK11CD589DC963C (trainee_id), 
        add constraint FK11CD589DC963C 
        foreign key (trainee_id) 
        references Trainee (id);

    alter table Hub 
        add index FK11CD576665CDC (trainingProgram_id), 
        add constraint FK11CD576665CDC 
        foreign key (trainingProgram_id) 
        references TrainingProgram (id);

create table Crp (
        id bigint not null auto_increment,
        createdBy varchar(255),
        createdDate datetime,
        lastUpdated datetime,
        lastUpdatedBy varchar(255),
        version integer not null,
        name varchar(255),
        trainee_id bigint,
        trainingProgram_id bigint,
        primary key (id)
    ) ENGINE=InnoDB;
	alter table Crp 
        add index FK109C189DC963C (trainee_id), 
        add constraint FK109C189DC963C 
        foreign key (trainee_id) 
        references Trainee (id);

    alter table Crp 
        add index FK109C176665CDC (trainingProgram_id), 
        add constraint FK109C176665CDC 
        foreign key (trainingProgram_id) 
        references TrainingProgram (id);
        
create table CoreCompetency (
        id bigint not null auto_increment,
        createdBy varchar(255),
        createdDate datetime,
        lastUpdated datetime,
        lastUpdatedBy varchar(255),
        version integer not null,
        name varchar(255),
        trainee_id bigint,
        trainingProgram_id bigint,
        primary key (id)
    ) ENGINE=InnoDB;
    
	alter table CoreCompetency 
        add index FKFE9C34FC89DC963C (trainee_id), 
        add constraint FKFE9C34FC89DC963C 
        foreign key (trainee_id) 
        references Trainee (id);

    alter table CoreCompetency 
        add index FKFE9C34FC76665CDC (trainingProgram_id), 
        add constraint FKFE9C34FC76665CDC 
        foreign key (trainingProgram_id) 
        references TrainingProgram (id);
        
create table SubProgram (
        id bigint not null auto_increment,
        createdBy varchar(255),
        createdDate datetime,
        lastUpdated datetime,
        lastUpdatedBy varchar(255),
        version integer not null,
        name varchar(255),
        trainee_id bigint,
        trainingProgram_id bigint,
        primary key (id)
    ) ENGINE=InnoDB;
    
    alter table SubProgram 
        add index FKC114C4489DC963C (trainee_id), 
        add constraint FKC114C4489DC963C 
        foreign key (trainee_id) 
        references Trainee (id);

    alter table SubProgram 
        add index FKC114C4476665CDC (trainingProgram_id), 
        add constraint FKC114C4476665CDC 
        foreign key (trainingProgram_id) 
        references TrainingProgram (id);
-- stopped here -----------------------------------------------

alter table Partner 
        drop 
        foreign key FK33F574A8C2B57DCC;

    alter table PartnerCategory 
        drop 
        foreign key FKC5076DC65170CCEE;

    alter table PartnerClassification 
        drop 
        foreign key FKE2692EAE5170CCEE;

    alter table PartnerCoreBusiness 
        drop 
        foreign key FK6B3ED1475170CCEE;

    alter table PartnerDocument 
        drop 
        foreign key FKF56181E3AD3C2E26;

    alter table PartnerDocument 
        drop 
        foreign key FKF56181E31B2AABF3;

    alter table PartnerIITAHub 
        drop 
        foreign key FK297C88805170CCEE;

    alter table PartnerMandateCrop 
        drop 
        foreign key FK35477CF05170CCEE;

    alter table PartnerPersonContact 
        drop 
        foreign key FK804E33433D36EE6;

    alter table PartnerPersonContact 
        drop 
        foreign key FK804E33435170CCEE;

    alter table PartnerTag 
        drop 
        foreign key FK80F3B1D21B2AABF3;

    alter table PartnerTag 
        drop 
        foreign key FK80F3B1D220DBF6E9;
drop table if exists Partner;

    drop table if exists PartnerCategory;

    drop table if exists PartnerClassification;

    drop table if exists PartnerCoreBusiness;

    drop table if exists PartnerDocument;

    drop table if exists PartnerIITAHub;

    drop table if exists PartnerMandateCrop;

    drop table if exists PartnerPersonContact;

    drop table if exists PartnerTag;
    
    create table Partner (
        id bigint not null auto_increment,
        createdBy varchar(255),
        createdDate datetime,
        lastUpdated datetime,
        lastUpdatedBy varchar(255),
        version integer not null,
        shortName varchar(100),
        title varchar(200) not null,
        parent_id bigint,
        primary key (id)
    ) ENGINE=InnoDB;

    create table PartnerCategory (
        id bigint not null auto_increment,
        createdBy varchar(255),
        createdDate datetime,
        lastUpdated datetime,
        lastUpdatedBy varchar(255),
        version integer not null,
        type varchar(200),
        partner_id bigint not null,
        primary key (id)
    ) ENGINE=InnoDB;

    create table PartnerClassification (
        id bigint not null auto_increment,
        createdBy varchar(255),
        createdDate datetime,
        lastUpdated datetime,
        lastUpdatedBy varchar(255),
        version integer not null,
        type varchar(200),
        partner_id bigint not null,
        primary key (id)
    ) ENGINE=InnoDB;

    create table PartnerCoreBusiness (
        id bigint not null auto_increment,
        createdBy varchar(255),
        createdDate datetime,
        lastUpdated datetime,
        lastUpdatedBy varchar(255),
        version integer not null,
        type varchar(200),
        partner_id bigint not null,
        primary key (id)
    ) ENGINE=InnoDB;

    create table PartnerDocument (
        id bigint not null auto_increment,
        document_id bigint not null,
        entity_id bigint not null,
        primary key (id)
    ) ENGINE=InnoDB;

    create table PartnerIITAHub (
        id bigint not null auto_increment,
        createdBy varchar(255),
        createdDate datetime,
        lastUpdated datetime,
        lastUpdatedBy varchar(255),
        version integer not null,
        hub varchar(255),
        partner_id bigint not null,
        primary key (id)
    ) ENGINE=InnoDB;

    create table PartnerMandateCrop (
        id bigint not null auto_increment,
        createdBy varchar(255),
        createdDate datetime,
        lastUpdated datetime,
        lastUpdatedBy varchar(255),
        version integer not null,
        type varchar(200),
        partner_id bigint not null,
        primary key (id)
    ) ENGINE=InnoDB;

    create table PartnerPersonContact (
        id bigint not null auto_increment,
        createdBy varchar(255),
        createdDate datetime,
        lastUpdated datetime,
        lastUpdatedBy varchar(255),
        version integer not null,
        discipline varchar(200),
        status varchar(255),
        title varchar(200),
        type varchar(255),
        partner_id bigint not null,
        person_id bigint not null,
        primary key (id)
    ) ENGINE=InnoDB;

    create table PartnerTag (
        percentage double precision,
        id bigint not null,
        entity_id bigint not null,
        primary key (id)
    ) ENGINE=InnoDB;
    
    ALTER TABLE `training`.`Person` MODIFY COLUMN `title` VARCHAR(25)  CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL;
        
alter table Contact add column partner_id BIGINT(20) after `organization_id`;
alter table AddressContact add column continent VARCHAR(255) after `state`;

     alter table Partner 
        add index FK33F574A8C2B57DCC (parent_id), 
        add constraint FK33F574A8C2B57DCC 
        foreign key (parent_id) 
        references Partner (id);

    alter table PartnerCategory 
        add index FKC5076DC65170CCEE (partner_id), 
        add constraint FKC5076DC65170CCEE 
        foreign key (partner_id) 
        references Partner (id);

    alter table PartnerClassification 
        add index FKE2692EAE5170CCEE (partner_id), 
        add constraint FKE2692EAE5170CCEE 
        foreign key (partner_id) 
        references Partner (id);

    alter table PartnerCoreBusiness 
        add index FK6B3ED1475170CCEE (partner_id), 
        add constraint FK6B3ED1475170CCEE 
        foreign key (partner_id) 
        references Partner (id);

    alter table PartnerDocument 
        add index FKF56181E3AD3C2E26 (document_id), 
        add constraint FKF56181E3AD3C2E26 
        foreign key (document_id) 
        references Document (id);

    alter table PartnerDocument 
        add index FKF56181E31B2AABF3 (entity_id), 
        add constraint FKF56181E31B2AABF3 
        foreign key (entity_id) 
        references Partner (id);

    alter table PartnerIITAHub 
        add index FK297C88805170CCEE (partner_id), 
        add constraint FK297C88805170CCEE 
        foreign key (partner_id) 
        references Partner (id);

    alter table PartnerMandateCrop 
        add index FK35477CF05170CCEE (partner_id), 
        add constraint FK35477CF05170CCEE 
        foreign key (partner_id) 
        references Partner (id);

    alter table PartnerPersonContact 
        add index FK804E33433D36EE6 (person_id), 
        add constraint FK804E33433D36EE6 
        foreign key (person_id) 
        references Person (id);

    alter table PartnerPersonContact 
        add index FK804E33435170CCEE (partner_id), 
        add constraint FK804E33435170CCEE 
        foreign key (partner_id) 
        references Partner (id);

    alter table PartnerTag 
        add index FK80F3B1D21B2AABF3 (entity_id), 
        add constraint FK80F3B1D21B2AABF3 
        foreign key (entity_id) 
        references Partner (id);

    alter table PartnerTag 
        add index FK80F3B1D220DBF6E9 (id), 
        add constraint FK80F3B1D220DBF6E9 
        foreign key (id) 
        references Tag (id);
        
        alter table Contact 
        add index FK9BEFBC005170CCEE (partner_id), 
        add constraint FK9BEFBC005170CCEE 
        foreign key (partner_id) 
        references Partner (id);