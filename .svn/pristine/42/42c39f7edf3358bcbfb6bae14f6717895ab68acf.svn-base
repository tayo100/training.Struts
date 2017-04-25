--2/3/2015 update--
ALTER TABLE TrainingProgram MODIFY `status` VARCHAR(50) NULL;
UPDATE TrainingProgram set status='GROUP' where status='0';
UPDATE TrainingProgram set status='NRS' where status='1';
UPDATE TrainingProgram set status='OTHER' where status='2';
--stops here--

create table ApplicationReportDocument (
        id bigint not null auto_increment,
        document_id bigint not null,
        entity_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

alter table ApplicationReportDocument 
        add index FKD3CABBBFAD3C2E26 (document_id), 
        add constraint FKD3CABBBFAD3C2E26 
        foreign key (document_id) 
        references Document (id);

alter table Announcement add column trainingProposal_id BIGINT(20) after `type`;
alter table Trainer add column announcement_id BIGINT(20) after `type`;
alter table Trainer add column trainingProposal_id BIGINT(20) after `trainee_id`;
ALTER TABLE `training`.`Trainer` ADD COLUMN `names` VARCHAR(255) NULL  AFTER `group_id` , ADD COLUMN `email` VARCHAR(100) NULL  AFTER `names`
alter table TrainingProposal add column announcement_id BIGINT(20) after `venue`;
alter table TrainingProposal add column programDirector_id BIGINT(20) after `announcement_id`;
alter table TrainingProposal add column requester_id BIGINT(20) after `programDirector_id`;

create table TrainingProposal (
        id bigint not null auto_increment,
        createdBy varchar(255),
        createdDate datetime,
        lastUpdated datetime,
        lastUpdatedBy varchar(255),
        version integer not null,
        activity longtext,
        background varchar(250),
        budgetOfficer varchar(100),
        costCenter varchar(100),
        country varchar(100),
        crp varchar(255),
        deadline datetime,
        duration varchar(100),
        expectedTrainingOutcome varchar(250),
        locations varchar(100),
        projectInformation varchar(250),
        resourcePersons varchar(250),
        startTrainingDate datetime,
        endTrainingDate datetime,
        targetParticipants varchar(250),
        trainingBudget varchar(100),
        trainingMaterials varchar(250),
        trainingObjectives varchar(250),
        trainingTitle varchar(250),
        unit varchar(100),
        venue varchar(100),
        announcement_id bigint,
        programDirector_id bigint,
        requester_id bigint,
        primary key (id)
    ) ENGINE=InnoDB;
    
alter table TrainingProposal add column status VARCHAR(15) after `requester_id`;
alter table TrainingProposal add column type VARCHAR(100) after `trainingTitle`;
alter table TrainingProposal add column owner_id BIGINT(20) after `announcement_id`;

    create table TrainingProposalDocument (
        id bigint not null auto_increment,
        document_id bigint not null,
        entity_id bigint not null,
        primary key (id)
    ) ENGINE=InnoDB;
 alter table Announcement 
        add index FK1323A16733B9577A (trainingProposal_id), 
        add constraint FK1323A16733B9577A 
        foreign key (trainingProposal_id) 
        references TrainingProposal (id);
alter table Trainer 
        add index FK239C349533B9577A (trainingProposal_id), 
        add constraint FK239C349533B9577A 
        foreign key (trainingProposal_id) 
        references TrainingProposal (id);
 alter table Trainer 
        add index FK239C3495FF318D7A (announcement_id), 
        add constraint FK239C3495FF318D7A 
        foreign key (announcement_id) 
        references Announcement (id);


alter table TrainingProposal 
        add index FK383FA20C8C161E4B (programDirector_id), 
        add constraint FK383FA20C8C161E4B 
        foreign key (programDirector_id) 
        references Person (id);

    alter table TrainingProposal 
        add index FK383FA20CFF318D7A (announcement_id), 
        add constraint FK383FA20CFF318D7A 
        foreign key (announcement_id) 
        references Announcement (id);

    alter table TrainingProposal 
        add index FK383FA20C1EFAAD5F (requester_id), 
        add constraint FK383FA20C1EFAAD5F 
        foreign key (requester_id) 
        references Person (id);

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
        
  alter table TrainingProposal 
        add index FK383FA20CCBDFED0E (owner_id), 
        add constraint FK383FA20CCBDFED0E 
        foreign key (owner_id) 
        references User (id);