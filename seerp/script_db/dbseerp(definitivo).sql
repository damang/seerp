-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.34-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema seerp
--

CREATE DATABASE IF NOT EXISTS seerp;
USE seerp;

--
-- Definition of table `agenda`
--

DROP TABLE IF EXISTS `agenda`;
CREATE TABLE `agenda` (
  `idAgenda` int(11) NOT NULL,
  PRIMARY KEY (`idAgenda`),
  KEY `FK_Agende_Utenti` (`idAgenda`),
  CONSTRAINT `FK_Agende_Utenti` FOREIGN KEY (`idAgenda`) REFERENCES `utente` (`idUtente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `agenda`
--

/*!40000 ALTER TABLE `agenda` DISABLE KEYS */;
/*!40000 ALTER TABLE `agenda` ENABLE KEYS */;


--
-- Definition of table `amministratore`
--

DROP TABLE IF EXISTS `amministratore`;
CREATE TABLE `amministratore` (
  `idAmministratore` int(11) NOT NULL,
  PRIMARY KEY (`idAmministratore`),
  KEY `fk_Amministratore_personale` (`idAmministratore`),
  CONSTRAINT `fk_Amministratore_personale` FOREIGN KEY (`idAmministratore`) REFERENCES `personale` (`idPersonale`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `amministratore`
--

/*!40000 ALTER TABLE `amministratore` DISABLE KEYS */;
/*!40000 ALTER TABLE `amministratore` ENABLE KEYS */;


--
-- Definition of table `appuntamento`
--

DROP TABLE IF EXISTS `appuntamento`;
CREATE TABLE `appuntamento` (
  `dipendente` int(11) NOT NULL,
  `extraazienda` int(11) NOT NULL,
  `data` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `idAppuntamento` int(11) NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  `notifica` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`idAppuntamento`),
  KEY `fk_Dipendenti_has_ExtraAzienda_Dipendenti` (`dipendente`),
  KEY `fk_Dipendenti_has_ExtraAzienda_ExtraAzienda` (`extraazienda`),
  CONSTRAINT `fk_Dipendenti_has_ExtraAzienda_Dipendenti` FOREIGN KEY (`dipendente`) REFERENCES `dipendente` (`idDipendente`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Dipendenti_has_ExtraAzienda_ExtraAzienda` FOREIGN KEY (`extraazienda`) REFERENCES `extraazienda` (`idExtraAzienda`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `appuntamento`
--

/*!40000 ALTER TABLE `appuntamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `appuntamento` ENABLE KEYS */;


--
-- Definition of table `azienda`
--

DROP TABLE IF EXISTS `azienda`;
CREATE TABLE `azienda` (
  `idAzienda` int(11) NOT NULL,
  `citta` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `fax` varchar(45) DEFAULT NULL,
  `indirizzo` varchar(45) DEFAULT NULL,
  `nazione` varchar(45) DEFAULT NULL,
  `piva` varchar(45) DEFAULT NULL,
  `regioneSociale` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idAzienda`),
  KEY `fk_Azienda_Amministratore` (`idAzienda`),
  CONSTRAINT `fk_Azienda_Amministratore` FOREIGN KEY (`idAzienda`) REFERENCES `amministratore` (`idAmministratore`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `azienda`
--

/*!40000 ALTER TABLE `azienda` DISABLE KEYS */;
/*!40000 ALTER TABLE `azienda` ENABLE KEYS */;


--
-- Definition of table `banca`
--

DROP TABLE IF EXISTS `banca`;
CREATE TABLE `banca` (
  `Agenzia` varchar(45) DEFAULT NULL,
  `citta` varchar(45) DEFAULT NULL,
  `provincia` varchar(2) DEFAULT NULL,
  `Indirizzo` varchar(45) DEFAULT NULL,
  `cap` varchar(5) DEFAULT NULL,
  `filiale` varchar(45) DEFAULT NULL,
  `nazione` varchar(45) DEFAULT NULL,
  `importoDare` double DEFAULT NULL,
  `importoAvere` double DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `IBAN` varchar(27) DEFAULT NULL,
  `idBanca` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idBanca`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `banca`
--

/*!40000 ALTER TABLE `banca` DISABLE KEYS */;
/*!40000 ALTER TABLE `banca` ENABLE KEYS */;


--
-- Definition of table `contratto`
--

DROP TABLE IF EXISTS `contratto`;
CREATE TABLE `contratto` (
  `idContratto` int(11) NOT NULL AUTO_INCREMENT,
  `durata` int(11) DEFAULT NULL,
  `stato` varchar(45) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `extrazienda` int(11) NOT NULL,
  `dipendente` int(11) NOT NULL,
  `data` date DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idContratto`),
  KEY `fk_Contratti_ExtraAzienda` (`extrazienda`),
  KEY `fk_Contratti_Dipendenti` (`dipendente`),
  CONSTRAINT `fk_Contratti_Dipendenti` FOREIGN KEY (`dipendente`) REFERENCES `dipendente` (`idDipendente`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_Contratti_ExtraAzienda` FOREIGN KEY (`extrazienda`) REFERENCES `extraazienda` (`idExtraAzienda`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `contratto`
--

/*!40000 ALTER TABLE `contratto` DISABLE KEYS */;
/*!40000 ALTER TABLE `contratto` ENABLE KEYS */;


--
-- Definition of table `ddt`
--

DROP TABLE IF EXISTS `ddt`;
CREATE TABLE `ddt` (
  `idDDT` int(11) NOT NULL AUTO_INCREMENT,
  `data` date DEFAULT NULL,
  `numero` varchar(45) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idDDT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ddt`
--

/*!40000 ALTER TABLE `ddt` DISABLE KEYS */;
/*!40000 ALTER TABLE `ddt` ENABLE KEYS */;


--
-- Definition of table `dipendente`
--

DROP TABLE IF EXISTS `dipendente`;
CREATE TABLE `dipendente` (
  `idDipendente` int(11) NOT NULL,
  PRIMARY KEY (`idDipendente`),
  KEY `fk_Dipendenti_personale` (`idDipendente`),
  CONSTRAINT `fk_Dipendenti_personale` FOREIGN KEY (`idDipendente`) REFERENCES `personale` (`idPersonale`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dipendente`
--

/*!40000 ALTER TABLE `dipendente` DISABLE KEYS */;
/*!40000 ALTER TABLE `dipendente` ENABLE KEYS */;


--
-- Definition of table `disponibilitaliquide`
--

DROP TABLE IF EXISTS `disponibilitaliquide`;
CREATE TABLE `disponibilitaliquide` (
  `idDisponibilitaLiquida` int(11) NOT NULL AUTO_INCREMENT,
  `importo` double DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idDisponibilitaLiquida`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `disponibilitaliquide`
--

/*!40000 ALTER TABLE `disponibilitaliquide` DISABLE KEYS */;
/*!40000 ALTER TABLE `disponibilitaliquide` ENABLE KEYS */;


--
-- Definition of table `evento`
--

DROP TABLE IF EXISTS `evento`;
CREATE TABLE `evento` (
  `idEvento` int(11) NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `ora` time DEFAULT NULL,
  `agenda` int(11) NOT NULL,
  `luogo` varchar(45) DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `tema` varchar(45) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `notifica` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`idEvento`),
  KEY `fk_Eventi_Agende` (`agenda`),
  CONSTRAINT `fk_Eventi_Agende` FOREIGN KEY (`agenda`) REFERENCES `agenda` (`idAgenda`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `evento`
--

/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;


--
-- Definition of table `extraazienda`
--

DROP TABLE IF EXISTS `extraazienda`;
CREATE TABLE `extraazienda` (
  `idExtraAzienda` int(11) NOT NULL,
  `cognome` varchar(45) DEFAULT NULL,
  `fax` varchar(45) DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `piva` varchar(45) DEFAULT NULL,
  `ragioneSociale` varchar(45) DEFAULT NULL,
  `ruolo` varchar(45) NOT NULL,
  `codiceFiscale` char(16) DEFAULT NULL,
  PRIMARY KEY (`idExtraAzienda`),
  KEY `fk_ExtraAzienda_Utenti` (`idExtraAzienda`),
  CONSTRAINT `fk_ExtraAzienda_Utenti` FOREIGN KEY (`idExtraAzienda`) REFERENCES `utente` (`idUtente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `extraazienda`
--

/*!40000 ALTER TABLE `extraazienda` DISABLE KEYS */;
/*!40000 ALTER TABLE `extraazienda` ENABLE KEYS */;


--
-- Definition of table `fattura`
--

DROP TABLE IF EXISTS `fattura`;
CREATE TABLE `fattura` (
  `idfattura` int(11) NOT NULL AUTO_INCREMENT,
  `data` date DEFAULT NULL,
  `imponibile` double DEFAULT NULL,
  `importo` double DEFAULT NULL,
  `iva` double DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idfattura`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fattura`
--

/*!40000 ALTER TABLE `fattura` DISABLE KEYS */;
/*!40000 ALTER TABLE `fattura` ENABLE KEYS */;


--
-- Definition of table `fatturaemessa`
--

DROP TABLE IF EXISTS `fatturaemessa`;
CREATE TABLE `fatturaemessa` (
  `idFatturaEmessa` int(11) NOT NULL AUTO_INCREMENT,
  `ivaAddebito` double NOT NULL,
  `numeroProgressivo` int(11) NOT NULL,
  `tipo` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`idFatturaEmessa`),
  KEY `fk_FatturaEmessa_fatture` (`idFatturaEmessa`),
  CONSTRAINT `fk_FatturaEmessa_fatture` FOREIGN KEY (`idFatturaEmessa`) REFERENCES `fattura` (`idfattura`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fatturaemessa`
--

/*!40000 ALTER TABLE `fatturaemessa` DISABLE KEYS */;
/*!40000 ALTER TABLE `fatturaemessa` ENABLE KEYS */;


--
-- Definition of table `fatturaricevuta`
--

DROP TABLE IF EXISTS `fatturaricevuta`;
CREATE TABLE `fatturaricevuta` (
  `idFatturaRicevuta` int(11) NOT NULL AUTO_INCREMENT,
  `ivaCredito` double NOT NULL,
  `numeroProgressivo` int(11) NOT NULL,
  PRIMARY KEY (`idFatturaRicevuta`),
  KEY `fk_FattureRicevute_fatture` (`idFatturaRicevuta`),
  CONSTRAINT `fk_FattureRicevute_fatture` FOREIGN KEY (`idFatturaRicevuta`) REFERENCES `fattura` (`idfattura`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fatturaricevuta`
--

/*!40000 ALTER TABLE `fatturaricevuta` DISABLE KEYS */;
/*!40000 ALTER TABLE `fatturaricevuta` ENABLE KEYS */;


--
-- Definition of table `incarico`
--

DROP TABLE IF EXISTS `incarico`;
CREATE TABLE `incarico` (
  `ruolo` varchar(45) NOT NULL,
  `permesso` int(11) NOT NULL,
  PRIMARY KEY (`permesso`,`ruolo`),
  KEY `fk_permessi_has_personale_permessi` (`permesso`),
  KEY `fk_Incarico_Ruolo` (`ruolo`),
  CONSTRAINT `fk_Incarico_Ruolo` FOREIGN KEY (`ruolo`) REFERENCES `ruolo` (`nome`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_permessi_has_personale_permessi` FOREIGN KEY (`permesso`) REFERENCES `permesso` (`idPermesso`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `incarico`
--

/*!40000 ALTER TABLE `incarico` DISABLE KEYS */;
INSERT INTO `incarico` (`ruolo`,`permesso`) VALUES 
 ('amministratore',1),
 ('dipendente',1),
 ('responsabile',1),
 ('amministratore',2),
 ('dipendente',2),
 ('responsabile',2),
 ('amministratore',3),
 ('dipendente',3),
 ('responsabile',3),
 ('amministratore',4),
 ('dipendente',4),
 ('responsabile',4),
 ('amministratore',5),
 ('dipendente',5),
 ('responsabile',5),
 ('amministratore',12),
 ('dipendente',12),
 ('responsabile',12),
 ('amministratore',13),
 ('dipendente',13),
 ('responsabile',13),
 ('amministratore',14),
 ('dipendente',14),
 ('responsabile',14),
 ('amministratore',15),
 ('dipendente',15),
 ('responsabile',15),
 ('amministratore',16),
 ('dipendente',16),
 ('responsabile',16),
 ('amministratore',17),
 ('dipendente',17),
 ('responsabile',17),
 ('amministratore',18),
 ('dipendente',18),
 ('responsabile',18),
 ('amministratore',19),
 ('dipendente',19),
 ('responsabile',19),
 ('amministratore',20),
 ('dipendente',20),
 ('responsabile',20),
 ('amministratore',21),
 ('responsabile',21),
 ('amministratore',22),
 ('responsabile',22),
 ('amministratore',23),
 ('responsabile',23),
 ('amministratore',24),
 ('dipendente',24),
 ('responsabile',24),
 ('amministratore',25),
 ('dipendente',25),
 ('responsabile',25),
 ('amministratore',26),
 ('amministratore',27),
 ('amministratore',28),
 ('amministratore',29),
 ('amministratore',30),
 ('amministratore',31),
 ('dipendente',31),
 ('responsabile',31),
 ('amministratore',32),
 ('amministratore',33),
 ('amministratore',34),
 ('amministratore',35),
 ('responsabile',35),
 ('amministratore',36),
 ('responsabile',36);
/*!40000 ALTER TABLE `incarico` ENABLE KEYS */;


--
-- Definition of table `notadicredito`
--

DROP TABLE IF EXISTS `notadicredito`;
CREATE TABLE `notadicredito` (
  `idNotaDiCredito` int(11) NOT NULL,
  `data` date DEFAULT NULL,
  `importo` double DEFAULT NULL,
  `iva` double DEFAULT NULL,
  `motivazione` double DEFAULT NULL,
  `nFattura` int(11) DEFAULT NULL,
  `fatturaEmessa` int(11) NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idNotaDiCredito`),
  KEY `fk_NoteDiCredito_FattureEmesse` (`fatturaEmessa`),
  CONSTRAINT `fk_NoteDiCredito_FattureEmesse` FOREIGN KEY (`fatturaEmessa`) REFERENCES `fatturaemessa` (`idFatturaEmessa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `notadicredito`
--

/*!40000 ALTER TABLE `notadicredito` DISABLE KEYS */;
/*!40000 ALTER TABLE `notadicredito` ENABLE KEYS */;


--
-- Definition of table `pagamento`
--

DROP TABLE IF EXISTS `pagamento`;
CREATE TABLE `pagamento` (
  `idPagamento` int(11) NOT NULL AUTO_INCREMENT,
  `altreInformazioni` varchar(45) DEFAULT NULL,
  `dataScadenza` date DEFAULT NULL,
  `descrizione` varchar(45) DEFAULT NULL,
  `importo` double DEFAULT NULL,
  `modalitàPagamento` varchar(45) DEFAULT NULL,
  `stato` varchar(45) DEFAULT NULL,
  `contratto` int(11) NOT NULL,
  `banca` int(11) NOT NULL,
  `disponibilitaliquida` int(11) NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idPagamento`),
  KEY `fk_Pagamento_Contratto` (`contratto`),
  KEY `fk_Pagamento_Banca` (`banca`),
  KEY `fk_Pagamento_DisponibilitàLiquide` (`disponibilitaliquida`) USING BTREE,
  CONSTRAINT `fk_Pagamento_Banca` FOREIGN KEY (`banca`) REFERENCES `banca` (`idBanca`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_Pagamento_Contratto` FOREIGN KEY (`contratto`) REFERENCES `contratto` (`idContratto`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Pagamento_DisponibilitaLiquide` FOREIGN KEY (`disponibilitaliquida`) REFERENCES `disponibilitaliquide` (`idDisponibilitaLiquida`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pagamento`
--

/*!40000 ALTER TABLE `pagamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagamento` ENABLE KEYS */;


--
-- Definition of table `permesso`
--

DROP TABLE IF EXISTS `permesso`;
CREATE TABLE `permesso` (
  `idPermesso` int(11) NOT NULL AUTO_INCREMENT,
  `task` varchar(45) NOT NULL,
  `action` varchar(45) NOT NULL,
  PRIMARY KEY (`idPermesso`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `permesso`
--

/*!40000 ALTER TABLE `permesso` DISABLE KEYS */;
INSERT INTO `permesso` (`idPermesso`,`task`,`action`) VALUES 
 (1,'gestione_clienti','aggiungi'),
 (2,'gestione_clienti','modifica'),
 (3,'gestione_clienti','elimina'),
 (4,'gestione_clienti','elenca'),
 (5,'gestione_clienti','ricerca'),
 (6,'gestione_contratti','aggiungi'),
 (7,'gestione_contratti','modifica'),
 (8,'gestione_contratti','elimina'),
 (9,'gestione_contratti','elenca'),
 (10,'gestione_contratti','ricerca'),
 (12,'gestione_fornitori','aggiungi'),
 (13,'gestione_fornitori','modifica'),
 (14,'gestione_fornitori','elimina'),
 (15,'gestione_fornitori','elenca'),
 (16,'gestione_fornitori','ricerca'),
 (17,'gestione_servizi','aggiungi'),
 (18,'gestione_servizi','elimina'),
 (19,'gestione_servizi','elenca'),
 (20,'gestione_servizi','ricerca'),
 (21,'gestione_dipendenti','aggiungi'),
 (22,'gestione_dipendenti','modifica'),
 (23,'gestione_dipendenti','elimina'),
 (24,'gestione_dipendenti','elenca'),
 (25,'gestione_dipendenti','ricerca'),
 (26,'gestione_ruoli','aggiungi'),
 (27,'gestione_ruoli','modifica'),
 (28,'gestione_ruoli','elimina'),
 (29,'gestione_ruoli','elenca'),
 (30,'gestione_ruoli','ricerca'),
 (31,'gestione_servizi','modifica'),
 (32,'gestione_responsabili','aggiungi'),
 (33,'gestione_responsabili','modifica'),
 (34,'gestione_responsabili','elimina'),
 (35,'gestione_responsabili','elenca'),
 (36,'gestione_responsabili','ricerca');
/*!40000 ALTER TABLE `permesso` ENABLE KEYS */;


--
-- Definition of table `personale`
--

DROP TABLE IF EXISTS `personale`;
CREATE TABLE `personale` (
  `idPersonale` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `codicefiscale` varchar(16) NOT NULL,
  `ruolo` varchar(45) NOT NULL,
  PRIMARY KEY (`idPersonale`),
  KEY `fk_personale_Utenti` (`idPersonale`),
  KEY `fk_Personale_Ruolo` (`ruolo`),
  CONSTRAINT `fk_Personale_Ruolo` FOREIGN KEY (`ruolo`) REFERENCES `ruolo` (`nome`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_personale_Utenti` FOREIGN KEY (`idPersonale`) REFERENCES `utente` (`idUtente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `personale`
--

/*!40000 ALTER TABLE `personale` DISABLE KEYS */;
/*!40000 ALTER TABLE `personale` ENABLE KEYS */;


--
-- Definition of table `responsabile`
--

DROP TABLE IF EXISTS `responsabile`;
CREATE TABLE `responsabile` (
  `idResponsabile` int(11) NOT NULL,
  PRIMARY KEY (`idResponsabile`),
  KEY `fk_Responsabili_personale` (`idResponsabile`),
  CONSTRAINT `fk_Responsabili_personale` FOREIGN KEY (`idResponsabile`) REFERENCES `personale` (`idPersonale`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `responsabile`
--

/*!40000 ALTER TABLE `responsabile` DISABLE KEYS */;
/*!40000 ALTER TABLE `responsabile` ENABLE KEYS */;


--
-- Definition of table `ruolo`
--

DROP TABLE IF EXISTS `ruolo`;
CREATE TABLE `ruolo` (
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ruolo`
--

/*!40000 ALTER TABLE `ruolo` DISABLE KEYS */;
INSERT INTO `ruolo` (`nome`) VALUES 
 ('amministratore'),
 ('dipendente'),
 ('responsabile');
/*!40000 ALTER TABLE `ruolo` ENABLE KEYS */;


--
-- Definition of table `serviziassociati`
--

DROP TABLE IF EXISTS `serviziassociati`;
CREATE TABLE `serviziassociati` (
  `contratto` int(11) NOT NULL,
  `quantita` int(11) DEFAULT NULL,
  `prezzoUnitario` double DEFAULT NULL,
  `servizio` int(11) NOT NULL,
  PRIMARY KEY (`servizio`,`contratto`),
  KEY `fk_Servizi_has_Contratti_Servizi` (`servizio`),
  KEY `fk_Servizi_has_Contratti_Contratti` (`contratto`),
  CONSTRAINT `fk_Servizi_has_Contratti_Contratti` FOREIGN KEY (`contratto`) REFERENCES `contratto` (`idContratto`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_Servizi_has_Contratti_Servizi` FOREIGN KEY (`servizio`) REFERENCES `servizio` (`idServizio`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `serviziassociati`
--

/*!40000 ALTER TABLE `serviziassociati` DISABLE KEYS */;
/*!40000 ALTER TABLE `serviziassociati` ENABLE KEYS */;


--
-- Definition of table `serviziassociatiddt`
--

DROP TABLE IF EXISTS `serviziassociatiddt`;
CREATE TABLE `serviziassociatiddt` (
  `DDT` int(11) NOT NULL,
  `servizio` int(11) NOT NULL,
  `contratto` int(11) NOT NULL,
  `fattura` int(11) NOT NULL,
  `quantita` int(11) DEFAULT NULL,
  PRIMARY KEY (`DDT`,`servizio`,`contratto`,`fattura`),
  KEY `fk_DDT_has_ServiziAssociatiFatture_DDT` (`DDT`),
  KEY `fk_DDT_has_ServiziAssociatiFatture_ServiziAssociatiFatture` (`servizio`,`contratto`,`fattura`),
  CONSTRAINT `fk_DDT_has_ServiziAssociatiFatture_DDT` FOREIGN KEY (`DDT`) REFERENCES `ddt` (`idDDT`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_DDT_has_ServiziAssociatiFatture_ServiziAssociatiFatture` FOREIGN KEY (`servizio`, `contratto`, `fattura`) REFERENCES `serviziassociatifatture` (`servizio`, `contratto`, `fattura`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `serviziassociatiddt`
--

/*!40000 ALTER TABLE `serviziassociatiddt` DISABLE KEYS */;
/*!40000 ALTER TABLE `serviziassociatiddt` ENABLE KEYS */;


--
-- Definition of table `serviziassociatifatture`
--

DROP TABLE IF EXISTS `serviziassociatifatture`;
CREATE TABLE `serviziassociatifatture` (
  `servizio` int(11) NOT NULL,
  `contratto` int(11) NOT NULL,
  `fattura` int(11) NOT NULL,
  `quantita` int(11) DEFAULT NULL,
  PRIMARY KEY (`servizio`,`contratto`,`fattura`),
  KEY `fk_Servizi_di_Contratto_has_fatture_Servizi_di_Contratto` (`servizio`,`contratto`),
  KEY `fk_Servizi_di_Contratto_has_fatture_fatture` (`fattura`),
  CONSTRAINT `fk_Servizi_di_Contratto_has_fatture_fatture` FOREIGN KEY (`fattura`) REFERENCES `fattura` (`idfattura`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_Servizi_di_Contratto_has_fatture_Servizi_di_Contratto` FOREIGN KEY (`servizio`, `contratto`) REFERENCES `serviziassociati` (`servizio`, `contratto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `serviziassociatifatture`
--

/*!40000 ALTER TABLE `serviziassociatifatture` DISABLE KEYS */;
/*!40000 ALTER TABLE `serviziassociatifatture` ENABLE KEYS */;


--
-- Definition of table `servizio`
--

DROP TABLE IF EXISTS `servizio`;
CREATE TABLE `servizio` (
  `idServizio` int(11) NOT NULL AUTO_INCREMENT,
  `descrizione` varchar(45) DEFAULT NULL,
  `disponibilita` tinyint(1) DEFAULT NULL,
  `quantita` int(11) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `prezzo` double DEFAULT NULL,
  `iva` int(11) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idServizio`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `servizio`
--

/*!40000 ALTER TABLE `servizio` DISABLE KEYS */;
/*!40000 ALTER TABLE `servizio` ENABLE KEYS */;


--
-- Definition of table `utente`
--

DROP TABLE IF EXISTS `utente`;
CREATE TABLE `utente` (
  `idUtente` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `citta` varchar(45) DEFAULT NULL,
  `prov` varchar(2) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `CAP` varchar(5) DEFAULT NULL,
  `note` varchar(100) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `visibilita` tinyint(1) DEFAULT '1',
  `indirizzo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idUtente`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `utente`
--

/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
