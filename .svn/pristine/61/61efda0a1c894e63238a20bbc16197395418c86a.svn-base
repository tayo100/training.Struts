drop table if exists Announcement;

drop table if exists AnnouncementDocument;

drop table if exists AnnouncementTag;

create table Announcement (
        id bigint not null auto_increment,
        createdBy varchar(255),
        createdDate datetime,
        lastUpdated datetime,
        lastUpdatedBy varchar(255),
        version integer not null,
        accommodation longtext,
        activity longtext,
        costCenter varchar(100),
        courseContents longtext,
        crp longtext,
        deadline datetime,
        expectedOutcome longtext,
        introduction longtext,
        keywords longtext,
        learningMethod longtext,
        numberOfFemale integer not null,
        numberOfMale integer not null,
        numberOfParticipants varchar(255),
        objective longtext,
        payment longtext,
        projectInformation longtext,
        status varchar(9),
        targetGroup longtext,
        title varchar(255),
        trainingFee longtext,
        type varchar(100),
        unit varchar(100),
        owner_id bigint,
        programDirector_id bigint,
        requester_id bigint,
        trainingProposal_id bigint,
        primary key (id)
    ) ENGINE=InnoDB;

    create table AnnouncementDocument (
        id bigint not null auto_increment,
        document_id bigint not null,
        entity_id bigint not null,
        primary key (id)
    ) ENGINE=InnoDB;

    create table AnnouncementTag (
        percentage double precision,
        id bigint not null,
        entity_id bigint not null,
        primary key (id)
    ) ENGINE=InnoDB;

drop table if exists TrainingLocation;

create table TrainingLocation (
        id bigint not null auto_increment,
        createdBy varchar(255),
        createdDate datetime,
        lastUpdated datetime,
        lastUpdatedBy varchar(255),
        version integer not null,
        country varchar(100),
        endDate datetime,
        startDate datetime,
        venue varchar(255),
        announcement_id bigint,
        trainingProposal_id bigint,
        primary key (id)
    ) ENGINE=InnoDB;

drop table if exists TrainingProposal;

create table TrainingProposal (
        id bigint not null auto_increment,
        createdBy varchar(255),
        createdDate datetime,
        lastUpdated datetime,
        lastUpdatedBy varchar(255),
        version integer not null,
        accommodation longtext,
        activity longtext,
        costCenter varchar(100),
        courseContents longtext,
        crp longtext,
        deadline datetime,
        duration longtext,
        expectedOutcome longtext,
        introduction longtext,
        keywords longtext,
        learningMethod longtext,
        numberOfFemale integer not null,
        numberOfMale integer not null,
        numberOfParticipants varchar(255),
        objective longtext,
        payment longtext,
        projectInformation longtext,
        status varchar(15),
        targetGroup longtext,
        title varchar(255),
        trainingFee double,
        type varchar(100),
        unit varchar(100),
        announcement_id bigint,
        owner_id bigint,
        programDirector_id bigint,
        requester_id bigint,
        primary key (id)
    ) ENGINE=InnoDB;

drop table if exists TrainingProposalDocument;

create table TrainingProposalDocument (
        id bigint not null auto_increment,
        document_id bigint not null,
        entity_id bigint not null,
        primary key (id)
    ) ENGINE=InnoDB;

alter table Announcement 
        add index FK1323A1678C161E4B (programDirector_id), 
        add constraint FK1323A1678C161E4B 
        foreign key (programDirector_id) 
        references User (id);

    alter table Announcement 
        add index FK1323A1671EFAAD5F (requester_id), 
        add constraint FK1323A1671EFAAD5F 
        foreign key (requester_id) 
        references User (id);

    alter table Announcement 
        add index FK1323A16733B9577A (trainingProposal_id), 
        add constraint FK1323A16733B9577A 
        foreign key (trainingProposal_id) 
        references TrainingProposal (id);

    alter table Announcement 
        add index FK1323A167CBDFED0E (owner_id), 
        add constraint FK1323A167CBDFED0E 
        foreign key (owner_id) 
        references User (id);

    alter table AnnouncementDocument 
        add index FK28B27FA2AD3C2E26 (document_id), 
        add constraint FK28B27FA2AD3C2E26 
        foreign key (document_id) 
        references Document (id);

    alter table AnnouncementDocument 
        add index FK28B27FA25843215E (entity_id), 
        add constraint FK28B27FA25843215E 
        foreign key (entity_id) 
        references Announcement (id);

    alter table AnnouncementTag 
        add index FK3F5CD8B35843215E (entity_id), 
        add constraint FK3F5CD8B35843215E 
        foreign key (entity_id) 
        references Announcement (id);

    alter table AnnouncementTag 
        add index FK3F5CD8B320DBF6E9 (id), 
        add constraint FK3F5CD8B320DBF6E9 
        foreign key (id) 
        references Tag (id);

alter table TrainingLocation 
        add index FKE4BCD6CFFF318D7A (announcement_id), 
        add constraint FKE4BCD6CFFF318D7A 
        foreign key (announcement_id) 
        references Announcement (id);

    alter table TrainingLocation 
        add index FKE4BCD6CF33B9577A (trainingProposal_id), 
        add constraint FKE4BCD6CF33B9577A 
        foreign key (trainingProposal_id) 
        references TrainingProposal (id);
alter table TrainingProposal 
        add index FK383FA20C8C161E4B (programDirector_id), 
        add constraint FK383FA20C8C161E4B 
        foreign key (programDirector_id) 
        references User (id);

    alter table TrainingProposal 
        add index FK383FA20CFF318D7A (announcement_id), 
        add constraint FK383FA20CFF318D7A 
        foreign key (announcement_id) 
        references Announcement (id);

    alter table TrainingProposal 
        add index FK383FA20C1EFAAD5F (requester_id), 
        add constraint FK383FA20C1EFAAD5F 
        foreign key (requester_id) 
        references User (id);

    alter table TrainingProposal 
        add index FK383FA20CCBDFED0E (owner_id), 
        add constraint FK383FA20CCBDFED0E 
        foreign key (owner_id) 
        references User (id);

    alter table TrainingProposalDocument 
        add index FK1EA0B47AD3C2E26 (document_id), 
        add constraint FK1EA0B47AD3C2E26 
        foreign key (document_id) 
        references Document (id);

    alter table TrainingProposalDocument 
        add index FK1EA0B47A6A203 (entity_id), 
        add constraint FK1EA0B47A6A203 
        foreign key (entity_id) 
        references TrainingProposal (id);
        
        
SET foreign_key_checks = 0;
alter table Application 
        add index FKC00DAD30FF318D7A (announcement_id), 
        add constraint FKC00DAD30FF318D7A 
        foreign key (announcement_id) 
        references Announcement (id);

alter table ApplicationStarter 
        add index FK1F01F53FFF318D7A (announcement_id), 
        add constraint FK1F01F53FFF318D7A 
        foreign key (announcement_id) 
        references Announcement (id);

alter table Trainer 
        add index FK239C3495FF318D7A (announcement_id), 
        add constraint FK239C3495FF318D7A 
        foreign key (announcement_id) 
        references Announcement (id);

alter table TrainingProposal 
        add index FK383FA20CFF318D7A (announcement_id), 
        add constraint FK383FA20CFF318D7A 
        foreign key (announcement_id) 
        references Announcement (id);
SET foreign_key_checks = 1;
