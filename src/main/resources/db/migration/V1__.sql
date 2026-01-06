CREATE TABLE administrateur
(
    id             BIGINT   AUTO_INCREMENT     NOT NULL,
    numero_licence VARCHAR(255) NULL,
    CONSTRAINT pk_administrateur PRIMARY KEY (id)
);

CREATE TABLE assistante
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    medecin_id BIGINT NULL,
    CONSTRAINT pk_assistante PRIMARY KEY (id)
);

CREATE TABLE compte
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    email          VARCHAR(255)          NULL,
    mot_de_passe   VARCHAR(255)          NULL,
    `role`         VARCHAR(255)          NULL,
    statut         VARCHAR(255)          NULL,
    currentdate    datetime              NULL,
    updatedate     datetime              NULL,
    utilisateur_id BIGINT                NULL,
    CONSTRAINT pk_compte PRIMARY KEY (id)
);

CREATE TABLE consultation
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    date        datetime              NULL,
    motif       VARCHAR(255)          NULL,
    rapport     VARCHAR(255)          NULL,
    currentdate datetime              NULL,
    updatedate  datetime              NULL,
    medecin_id  BIGINT                NULL,
    patient_id  BIGINT                NULL,
    dossier_id  BIGINT                NULL,
    CONSTRAINT pk_consultation PRIMARY KEY (id)
);

CREATE TABLE diagnosticia
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    date        datetime              NULL,
    symptomes   VARCHAR(255)          NULL,
    resultat    VARCHAR(255)          NULL,
    currentdate datetime              NULL,
    updatedate  datetime              NULL,
    patient_id  BIGINT                NULL,
    CONSTRAINT pk_diagnosticia PRIMARY KEY (id)
);

CREATE TABLE document_medical
(
    id              BIGINT AUTO_INCREMENT NOT NULL,
    nom             VARCHAR(255)          NULL,
    type            VARCHAR(255)          NULL,
    currentdate     datetime              NULL,
    updatedate      datetime              NULL,
    consultation_id BIGINT                NULL,
    CONSTRAINT pk_documentmedical PRIMARY KEY (id)
);

CREATE TABLE dossier_medical
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    currentdate datetime              NULL,
    updatedate  datetime              NULL,
    patient_id  BIGINT                NULL,
    CONSTRAINT pk_dossiermedical PRIMARY KEY (id)
);

CREATE TABLE medecin
(
    id             BIGINT   AUTO_INCREMENT    NOT NULL,
    numero_licence VARCHAR(255) NULL,
    specialite_id  BIGINT       NULL,
    CONSTRAINT pk_medecin PRIMARY KEY (id)
);

CREATE TABLE patient
(
    id                  BIGINT    AUTO_INCREMENT   NOT NULL,
    poids               FLOAT        NOT NULL,
    taille              FLOAT        NOT NULL,
    groupe_sanguin      VARCHAR(255) NULL,
    allergies           VARCHAR(255) NULL,
    maladies_chroniques VARCHAR(255) NULL,
    couverture_medicale VARCHAR(255) NULL,
    CONSTRAINT pk_patient PRIMARY KEY (id)
);

CREATE TABLE rendez_vous
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    date        datetime              NULL,
    statut      VARCHAR(255)          NULL,
    raison      VARCHAR(255)          NULL,
    currentdate datetime              NULL,
    updatedate  datetime              NULL,
    medecin_id  BIGINT                NULL,
    patient_id  BIGINT                NULL,
    CONSTRAINT pk_rendezvous PRIMARY KEY (id)
);

CREATE TABLE specialite
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    nom           VARCHAR(255)          NULL,
    `description` VARCHAR(255)          NULL,
    currentdate   datetime              NULL,
    updatedate    datetime              NULL,
    CONSTRAINT pk_specialite PRIMARY KEY (id)
);

CREATE TABLE utilisateur
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    nom            VARCHAR(255)          NULL,
    prenom         VARCHAR(255)          NULL,
    date_naissance date                  NULL,
    sexe           VARCHAR(255)          NULL,
    telephone      VARCHAR(255)          NULL,
    adresse        VARCHAR(255)          NULL,
    cin            VARCHAR(255)          NULL,
    photo_profil   VARCHAR(255)          NULL,
    currentdate    datetime              NULL,
    updatedate     datetime              NULL,
    CONSTRAINT pk_utilisateur PRIMARY KEY (id)
);

ALTER TABLE compte
    ADD CONSTRAINT uc_compte_utilisateur UNIQUE (utilisateur_id);

ALTER TABLE dossier_medical
    ADD CONSTRAINT uc_dossiermedical_patient UNIQUE (patient_id);

ALTER TABLE administrateur
    ADD CONSTRAINT FK_ADMINISTRATEUR_ON_ID FOREIGN KEY (id) REFERENCES utilisateur (id);

ALTER TABLE assistante
    ADD CONSTRAINT FK_ASSISTANTE_ON_ID FOREIGN KEY (id) REFERENCES utilisateur (id);

ALTER TABLE assistante
    ADD CONSTRAINT FK_ASSISTANTE_ON_MEDECIN FOREIGN KEY (medecin_id) REFERENCES medecin (id);

ALTER TABLE compte
    ADD CONSTRAINT FK_COMPTE_ON_UTILISATEUR FOREIGN KEY (utilisateur_id) REFERENCES utilisateur (id);

ALTER TABLE consultation
    ADD CONSTRAINT FK_CONSULTATION_ON_DOSSIER FOREIGN KEY (dossier_id) REFERENCES dossier_medical (id);

ALTER TABLE consultation
    ADD CONSTRAINT FK_CONSULTATION_ON_MEDECIN FOREIGN KEY (medecin_id) REFERENCES medecin (id);

ALTER TABLE consultation
    ADD CONSTRAINT FK_CONSULTATION_ON_PATIENT FOREIGN KEY (patient_id) REFERENCES patient (id);

ALTER TABLE diagnosticia
    ADD CONSTRAINT FK_DIAGNOSTICIA_ON_PATIENT FOREIGN KEY (patient_id) REFERENCES patient (id);

ALTER TABLE document_medical
    ADD CONSTRAINT FK_DOCUMENTMEDICAL_ON_CONSULTATION FOREIGN KEY (consultation_id) REFERENCES consultation (id);

ALTER TABLE dossier_medical
    ADD CONSTRAINT FK_DOSSIERMEDICAL_ON_PATIENT FOREIGN KEY (patient_id) REFERENCES patient (id);

ALTER TABLE medecin
    ADD CONSTRAINT FK_MEDECIN_ON_ID FOREIGN KEY (id) REFERENCES utilisateur (id);

ALTER TABLE medecin
    ADD CONSTRAINT FK_MEDECIN_ON_SPECIALITE FOREIGN KEY (specialite_id) REFERENCES specialite (id);

ALTER TABLE patient
    ADD CONSTRAINT FK_PATIENT_ON_ID FOREIGN KEY (id) REFERENCES utilisateur (id);

ALTER TABLE rendez_vous
    ADD CONSTRAINT FK_RENDEZVOUS_ON_MEDECIN FOREIGN KEY (medecin_id) REFERENCES medecin (id);

ALTER TABLE rendez_vous
    ADD CONSTRAINT FK_RENDEZVOUS_ON_PATIENT FOREIGN KEY (patient_id) REFERENCES patient (id);