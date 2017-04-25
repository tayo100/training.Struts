-- TRUNCATE TABLE ApplicantsChildren;
-- TRUNCATE TABLE EducationAndTraining;
-- TRUNCATE TABLE EmploymentHistory;
-- TRUNCATE TABLE LanguageSpoken;
-- TRUNCATE TABLE OtherLanguages;
-- TRUNCATE TABLE training.ApplicantsBioData;
-- TRUNCATE TABLE training.Application;
-- TRUNCATE TABLE OtherApplicationDetails;

-- DROP TABLE ApplicantsChildren;
-- DROP TABLE EducationAndTraining;
-- DROP TABLE EmploymentHistory;
-- DROP TABLE LanguageSpoken;
-- DROP TABLE OtherLanguages;
-- DROP TABLE training.Application;
-- DROP TABLE OtherApplicationDetails;
-- DROP TABLE training.ApplicantsBioData;
create table ApplicantsBioData (
        id bigint not null auto_increment,
        createdBy varchar(255),
        createdDate datetime,
        lastUpdated datetime,
        lastUpdatedBy varchar(255),
        version integer not null,
        currentNationality varchar(150),
        dateOfBirth date,
        emailAddress varchar(80),
        english varchar(15),
        fileName varchar(200),
        firstName varchar(50),
        gender varchar(10),
        lastName varchar(150),
        maidenName varchar(150),
        maritalStatus varchar(15),
        middleName varchar(150),
        nationality varchar(150),
        nextOfKinAddrs longtext,
        nextOfKinName varchar(255),
        nextOfKinRelationship varchar(25),
        nextOfKinTelNo varchar(255),
        passportNumber varchar(255),
        password varchar(255),
        permAddressTelephone varchar(15),
        permanentAddress longtext,
        placeOfBirth varchar(255),
        spouseName varchar(255),
        telephoneNumbers varchar(255),
        title varchar(10),
        owner_id bigint not null,
        primary key (id)
    ) ENGINE=InnoDB;

    create table ApplicantsChildren (
        id bigint not null auto_increment,
        createdBy varchar(255),
        createdDate datetime,
        lastUpdated datetime,
        lastUpdatedBy varchar(255),
        version integer not null,
        childName longtext,
        dateOfBirth date,
        biodata_id bigint not null,
        primary key (id)
    ) ENGINE=InnoDB;

    create table Application (
        id bigint not null auto_increment,
        createdBy varchar(255),
        createdDate datetime,
        lastUpdated datetime,
        lastUpdatedBy varchar(255),
        version integer not null,
        fundingSource varchar(30),
        refNumber varchar(100),
        signedOn datetime,
        status varchar(255),
        submissionStatus varchar(10),
        type varchar(10),
        typeOfSupport varchar(20),
        announcement_id bigint,
        biodata_id bigint not null,
        primary key (id)
    ) ENGINE=InnoDB;
create table EducationAndTraining (
        id bigint not null auto_increment,
        createdBy varchar(255),
        createdDate datetime,
        lastUpdated datetime,
        lastUpdatedBy varchar(255),
        version integer not null,
        certificateObtained longtext,
        majorFieldOfStudy longtext,
        nameOfInstitution longtext,
        startMonthOfCertification longtext,
        stopMonthOfCertification longtext,
        biodata_id bigint not null,
        primary key (id)
    ) ENGINE=InnoDB;
create table EmploymentHistory (
        id bigint not null auto_increment,
        createdBy varchar(255),
        createdDate datetime,
        lastUpdated datetime,
        lastUpdatedBy varchar(255),
        version integer not null,
        addressOfEmployer longtext,
        appointedOn date,
        exitedOn date,
        jobTitle varchar(255),
        nameOfEmployer varchar(255),
        biodata_id bigint not null,
        primary key (id)
    ) ENGINE=InnoDB;
create table GRLanguage (
        id bigint not null auto_increment,
        createdBy varchar(255),
        createdDate datetime,
        lastUpdated datetime,
        lastUpdatedBy varchar(255),
        version integer not null,
        languageName varchar(255),
        languageOptions integer,
        graduateResearchTraining_id bigint not null,
        primary key (id)
    ) ENGINE=InnoDB;

    create table GraduateResearchTraining (
        id bigint not null auto_increment,
        createdBy varchar(255),
        createdDate datetime,
        lastUpdated datetime,
        lastUpdatedBy varchar(255),
        version integer not null,
        degreeSought varchar(255),
        emailOfUniversitySupervisor varchar(255),
        endDate datetime,
        expectedDuration varchar(255),
        nameOfIITASupervisor varchar(255),
        nameOfUniversitySupervisor varchar(255),
        proposedResearchTheme varchar(255),
        refNumber varchar(100),
        researchLocation varchar(255),
        startDate datetime,
        status varchar(255),
        submissionStatus varchar(10),
        announcement_id bigint,
        biodata_id bigint not null,
        primary key (id)
    ) ENGINE=InnoDB;

    create table InternalApprovals (
        id bigint not null auto_increment,
        createdBy varchar(255),
        createdDate datetime,
        lastUpdated datetime,
        lastUpdatedBy varchar(255),
        version integer not null,
        budgetCode varchar(100),
        cdoHeadApproval varchar(15),
        cdoHeadComments longtext,
        cdoHeadDateApproved datetime,
        cdoHeadName varchar(150),
        cfoApproval varchar(15),
        cfoComments longtext,
        cfoDateApproved datetime,
        cfoName varchar(150),
        cost double precision not null,
        evaluation longtext,
        progDirector varchar(150),
        progDirectorApproval varchar(15),
        progDirectorDateApproved datetime,
        projOfficer varchar(150),
        projOfficerApproval varchar(15),
        projOfficerDateApproved datetime,
        remarks longtext,
        application_id bigint not null,
        primary key (id),
        unique (application_id)
    ) ENGINE=InnoDB;

    create table LanguageSpoken (
        id bigint not null auto_increment,
        createdBy varchar(255),
        createdDate datetime,
        lastUpdated datetime,
        lastUpdatedBy varchar(255),
        version integer not null,
        language varchar(25),
        biodata_id bigint not null,
        primary key (id)
    ) ENGINE=InnoDB;
create table MajorConstraints (
        id bigint not null auto_increment,
        createdBy varchar(255),
        createdDate datetime,
        lastUpdated datetime,
        lastUpdatedBy varchar(255),
        version integer not null,
        youFaced varchar(255),
        nonDegreeTraining_id bigint not null,
        primary key (id)
    ) ENGINE=InnoDB;

    create table NonDegreeTraining (
        id bigint not null auto_increment,
        createdBy varchar(255),
        createdDate datetime,
        lastUpdated datetime,
        lastUpdatedBy varchar(255),
        version integer not null,
        previousTrainings varchar(5),
        proposedTrainingDuration varchar(255),
        trainingLocation varchar(255),
        trainingReceived varchar(255),
        biodata_id bigint not null,
        primary key (id)
    ) ENGINE=InnoDB;
create table OtherApplicationDetails (
        id bigint not null auto_increment,
        createdBy varchar(255),
        createdDate datetime,
        lastUpdated datetime,
        lastUpdatedBy varchar(255),
        version integer not null,
        addressofSponsor longtext,
        nameOfSponsor varchar(255),
        startDate date,
        application_id bigint not null,
        primary key (id)
    ) ENGINE=InnoDB;

    create table OtherLanguages (
        id bigint not null auto_increment,
        createdBy varchar(255),
        createdDate datetime,
        lastUpdated datetime,
        lastUpdatedBy varchar(255),
        version integer not null,
        otherLanguage varchar(255),
        biodata_id bigint not null,
        primary key (id)
    ) ENGINE=InnoDB;
create table SpecificSkills (
        id bigint not null auto_increment,
        createdBy varchar(255),
        createdDate datetime,
        lastUpdated datetime,
        lastUpdatedBy varchar(255),
        version integer not null,
        acquireSkills varchar(255),
        nonDegreeTraining_id bigint not null,
        primary key (id)
    ) ENGINE=InnoDB;

alter table ApplicantsBioData 
        add index FK2A1719C1CBDFED0E (owner_id), 
        add constraint FK2A1719C1CBDFED0E 
        foreign key (owner_id) 
        references User (id);

    alter table ApplicantsChildren 
        add index FK43BEFEF0FF5C6AF2 (biodata_id), 
        add constraint FK43BEFEF0FF5C6AF2 
        foreign key (biodata_id) 
        references ApplicantsBioData (id);

    alter table Application 
        add index FKC00DAD30FF318D7A (announcement_id), 
        add constraint FKC00DAD30FF318D7A 
        foreign key (announcement_id) 
        references Announcement (id);

    alter table Application 
        add index FKC00DAD30FF5C6AF2 (biodata_id), 
        add constraint FKC00DAD30FF5C6AF2 
        foreign key (biodata_id) 
        references ApplicantsBioData (id);
alter table EducationAndTraining 
        add index FK5A9DBB29FF5C6AF2 (biodata_id), 
        add constraint FK5A9DBB29FF5C6AF2 
        foreign key (biodata_id) 
        references ApplicantsBioData (id);
alter table EmploymentHistory 
        add index FK987D16E8FF5C6AF2 (biodata_id), 
        add constraint FK987D16E8FF5C6AF2 
        foreign key (biodata_id) 
        references ApplicantsBioData (id);

alter table GRLanguage 
        add index FKE1F6E5631BF5F091 (graduateResearchTraining_id), 
        add constraint FKE1F6E5631BF5F091 
        foreign key (graduateResearchTraining_id) 
        references GraduateResearchTraining (id);

    alter table GraduateResearchTraining 
        add index FK3783320FF318D7A (announcement_id), 
        add constraint FK3783320FF318D7A 
        foreign key (announcement_id) 
        references Announcement (id);

    alter table GraduateResearchTraining 
        add index FK3783320FF5C6AF2 (biodata_id), 
        add constraint FK3783320FF5C6AF2 
        foreign key (biodata_id) 
        references ApplicantsBioData (id);

    alter table InternalApprovals 
        add index FKC4D540333CBC77C3 (application_id), 
        add constraint FKC4D540333CBC77C3 
        foreign key (application_id) 
        references Application (id);

    alter table LanguageSpoken 
        add index FKB5C414FAFF5C6AF2 (biodata_id), 
        add constraint FKB5C414FAFF5C6AF2 
        foreign key (biodata_id) 
        references ApplicantsBioData (id);

alter table MajorConstraints 
        add index FK46693EDDD652FE63 (nonDegreeTraining_id), 
        add constraint FK46693EDDD652FE63 
        foreign key (nonDegreeTraining_id) 
        references NonDegreeTraining (id);

    alter table NonDegreeTraining 
        add index FKAD189BD3FF5C6AF2 (biodata_id), 
        add constraint FKAD189BD3FF5C6AF2 
        foreign key (biodata_id) 
        references ApplicantsBioData (id);
alter table OtherApplicationDetails 
        add index FKDDB359E23CBC77C3 (application_id), 
        add constraint FKDDB359E23CBC77C3 
        foreign key (application_id) 
        references Application (id);

    alter table OtherLanguages 
        add index FK3FDC370BFF5C6AF2 (biodata_id), 
        add constraint FK3FDC370BFF5C6AF2 
        foreign key (biodata_id) 
        references ApplicantsBioData (id);
alter table SpecificSkills 
        add index FK1B41F434D652FE63 (nonDegreeTraining_id), 
        add constraint FK1B41F434D652FE63 
        foreign key (nonDegreeTraining_id) 
        references NonDegreeTraining (id);
        
alter table BudgetCode 
        drop 
        foreign key FK4DA982F2956456E9;

    alter table BudgetCode 
        drop 
        foreign key FK4DA982F2E020321F;

    alter table BudgetCode 
        drop 
        foreign key FK4DA982F21BAC2F56;

    alter table BudgetCode 
        drop 
        foreign key FK4DA982F243DB1D0;

drop table if exists BudgetCode;

create table BudgetCode (
        id bigint not null auto_increment,
        createdBy varchar(255),
        createdDate datetime,
        lastUpdated datetime,
        lastUpdatedBy varchar(255),
        version integer not null,
        code varchar(20) not null,
        status integer,
        budgetHolder_id bigint,
        costCenter_costCenter varchar(20),
        internalApproval_id bigint not null,
        nextApprover_id bigint,
        primary key (id)
) ENGINE=InnoDB;
    
alter table BudgetCode 
        add index FK4DA982F2956456E9 (nextApprover_id), 
        add constraint FK4DA982F2956456E9 
        foreign key (nextApprover_id) 
        references User (id);

    alter table BudgetCode 
        add index FK4DA982F2E020321F (costCenter_costCenter), 
        add constraint FK4DA982F2E020321F 
        foreign key (costCenter_costCenter) 
        references CostCenter (costCenter);

    alter table BudgetCode 
        add index FK4DA982F21BAC2F56 (internalApproval_id), 
        add constraint FK4DA982F21BAC2F56 
        foreign key (internalApproval_id) 
        references InternalApprovals (id);

    alter table BudgetCode 
        add index FK4DA982F243DB1D0 (budgetHolder_id), 
        add constraint FK4DA982F243DB1D0 
        foreign key (budgetHolder_id) 
        references User (id);
        
alter table CostCenter add column `costCenter` VARCHAR(20) NULL;

alter table CoreCompetency add column `internalApproval_id` bigint after `trainingProgram_id`;
alter table Crp add column `internalApproval_id` bigint after `trainingProgram_id`;
alter table Hub add column `internalApproval_id` bigint after `trainingProgram_id`;
alter table Application add column `internalApprovals_id`  bigint after `biodata_id`;

alter table CoreCompetency 
        add index FKFE9C34FC1BAC2F56 (internalApproval_id), 
        add constraint FKFE9C34FC1BAC2F56 
        foreign key (internalApproval_id) 
        references InternalApprovals (id);
        
alter table Hub 
        add index FK11CD51BAC2F56 (internalApproval_id), 
        add constraint FK11CD51BAC2F56 
        foreign key (internalApproval_id) 
        references InternalApprovals (id);

alter table Crp 
        add index FK109C11BAC2F56 (internalApproval_id), 
        add constraint FK109C11BAC2F56 
        foreign key (internalApproval_id) 
        references InternalApprovals (id);
        
alter table Application 
        add index FKC00DAD307BEEB603 (internalApprovals_id), 
        add constraint FKC00DAD307BEEB603 
        foreign key (internalApprovals_id) 
        references InternalApprovals (id);