-- MySQL dump 10.13  Distrib 8.0.38, for macos14 (x86_64)
--
-- Host: localhost    Database: gerprojetos
-- ------------------------------------------------------
-- Server version	8.0.43

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tbl_projeto`
--

DROP TABLE IF EXISTS `tbl_projeto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_projeto` (
  `id_projeto` int NOT NULL AUTO_INCREMENT,
  `nm_projeto` varchar(150) NOT NULL,
  `desc_projeto` text,
  `dt_inicioprojeto` date NOT NULL,
  `dt_fimprojeto` date DEFAULT NULL,
  `status_projeto` varchar(30) NOT NULL,
  PRIMARY KEY (`id_projeto`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_projeto`
--

LOCK TABLES `tbl_projeto` WRITE;
/*!40000 ALTER TABLE `tbl_projeto` DISABLE KEYS */;
INSERT INTO `tbl_projeto` VALUES (1,'Implementação de Sistema ERP','Substituição do sistema legado pelo novo ERP da empresa, integrando os setores financeiro, RH e logística.','2025-06-01','2025-12-20','Em Andamento'),(2,'Desenvolvimento do Novo App Mobile','Criação do aplicativo móvel para iOS e Android com foco em melhorar a experiência de compra do cliente.','2025-08-15','2026-03-31','Em Andamento'),(3,'Migração de Servidores para a Nuvem','Mover toda a infraestrutura de servidores on-premise para a plataforma AWS, visando redução de custos e escalabilidade.','2025-01-20','2025-07-25','Concluído'),(4,'Campanha de Marketing Digital Q4 2025','Planejamento e execução da campanha de marketing para o último trimestre de 2025, com foco nas vendas de fim de ano.','2025-09-15','2025-12-31','Planejado'),(5,'Reestruturação do Site Corporativo','Modernização do design e da plataforma do site institucional da empresa, com implementação de novas funcionalidades de SEO.','2025-03-10','2025-08-30','Concluído'),(6,'Certificação ISO 9001','Adequação de todos os processos internos para obtenção do selo de qualidade ISO 9001.','2024-11-01',NULL,'Em Andamento'),(7,'Implantação de BI e Analytics','Criação de dashboards e relatórios gerenciais utilizando a ferramenta Power BI para análise de dados de vendas.','2025-07-01','2025-11-28','Em Andamento'),(8,'Treinamento de Equipe de Vendas 2026','Programa de capacitação para a equipe comercial sobre os novos produtos a serem lançados em 2026.','2026-01-20','2026-02-10','Planejado'),(10,'Pesquisa de Satisfação do Cliente 2025','Realização da pesquisa anual de satisfação (NPS) com a base de clientes para coletar feedbacks.','2025-09-01','2025-09-30','Em Andamento'),(15,'teste de mascara de data','teste de mascara de data','2025-03-01','2025-12-31','Planejado');
/*!40000 ALTER TABLE `tbl_projeto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_projetousuario`
--

DROP TABLE IF EXISTS `tbl_projetousuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_projetousuario` (
  `id_projeto` int NOT NULL,
  `id_usuario` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_projetousuario`
--

LOCK TABLES `tbl_projetousuario` WRITE;
/*!40000 ALTER TABLE `tbl_projetousuario` DISABLE KEYS */;
INSERT INTO `tbl_projetousuario` VALUES (1,5),(2,3),(2,23),(1,23),(6,6),(6,23),(6,26),(6,27),(6,28),(16,31),(16,9),(16,8),(16,6),(1,49),(1,46),(1,22),(1,42);
/*!40000 ALTER TABLE `tbl_projetousuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_usuario`
--

DROP TABLE IF EXISTS `tbl_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(6) NOT NULL,
  `nm_usuario` varchar(100) NOT NULL,
  `email_usuario` varchar(100) NOT NULL,
  `senha_usuario` varchar(255) NOT NULL,
  `tp_acesso` varchar(20) NOT NULL,
  `status_usuario` char(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `user_name` (`user_name`),
  UNIQUE KEY `email_usuario` (`email_usuario`),
  CONSTRAINT `chk_status` CHECK ((`status_usuario` in (_utf8mb4'A',_utf8mb4'I')))
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_usuario`
--

LOCK TABLES `tbl_usuario` WRITE;
/*!40000 ALTER TABLE `tbl_usuario` DISABLE KEYS */;
INSERT INTO `tbl_usuario` VALUES (1,'aalme','Adriana Almeida','aalme@empresa.com','123456','Admin','A'),(2,'bbarb','Bruno Barbosa','bbarb@empresa.com','123456','Admin','A'),(3,'ccard','Carla Cardoso','ccard@empresa.com','123456','Gerente','A'),(4,'ddias','Daniel Dias','ddias@empresa.com','123456','Gerente','A'),(5,'eeste','Eduarda Esteves','eeste@empresa.com','123456','Gerente','A'),(6,'ffoga','Felipe Fogaça','ffoga@empresa.com','123456','Gerente','A'),(7,'ggued','Gabriela Guedes','ggued@empresa.com','123456','Gerente','A'),(8,'hhenr','Heitor Henriques','hhenr@empresa.com','123456','Funcionário','A'),(9,'jjava','João Javarini','jjava@empresa.com','123456','Funcionário','A'),(10,'kkauf','Karen Kauffman','kkauf@empresa.com','123456','Funcionário','A'),(11,'llace','Lucas Lacerda','llace@empresa.com','123456','Funcionário','A'),(12,'mmeir','Manuela Meireles','mmeir@empresa.com','123456','Funcionário','A'),(13,'nhoro','Nicolas Noronha','nhoro@empresa.com','123456','Funcionário','A'),(14,'oorne','Olívia Ornelas','oorne@empresa.com','123456','Funcionário','A'),(15,'ppach','Pedro Pacheco','ppach@empresa.com','123456','Funcionário','A'),(16,'qquei','Quintino Queiroz','qquei@empresa.com','123456','Funcionário','A'),(17,'rramo','Raquel Ramos','rramo@empresa.com','123456','Funcionário','A'),(18,'ssamp','Samuel Sampaio','ssamp@empresa.com','123456','Funcionário','A'),(19,'ttava','Tatiane Tavares','ttava@empresa.com','123456','Funcionário','A'),(20,'uucho','Ulisses Uchoa','uucho@empresa.com','123456','Funcionário','A'),(21,'vvala','Vitória Valadares','vvala@empresa.com','123456','Funcionário','A'),(22,'wxavi','Wagner Xavier','wxavi@empresa.com','123456','Funcionário','A'),(23,'aantu','Amanda Antunes','aantu@empresa.com','123456','Funcionário','A'),(24,'bbica','Bárbara Bicalho','bbica@empresa.com','123456','Admin','A'),(26,'ddrum','Débora Drummond','ddrum@empresa.com','123456','Funcionário','A'),(27,'emane','Emanuel Esteves','emane@empresa.com','123456','Funcionário','A'),(28,'ffrot','Fátima Frota','ffrot@empresa.com','123456','Funcionário','A'),(29,'ggouv','Giovani Gouveia','ggouv@empresa.com','123456','Funcionário','A'),(30,'hguerr','Heloísa Guerra','hguerr@empresa.com','123456','Funcionário','A'),(31,'iisid','Ícaro Isidoro','iisid@empresa.com','123456','Funcionário','A'),(32,'jjust','Júlia Justino','jjust@empresa.com','123456','Funcionário','A'),(33,'klemo','Kevin Lemos','klemo@empresa.com','123456','Funcionário','A'),(34,'llust','Letícia Lustosa','llust@empresa.com','123456','Funcionário','A'),(35,'mmace','Marcelo Macedo','mmace@empresa.com','123456','Funcionário','A'),(36,'nnogu','Nicole Nogueira','nnogu@empresa.com','123456','Funcionário','A'),(37,'ooiti','Otávio Oiticica','ooiti@empresa.com','123456','Funcionário','A'),(38,'ppime','Paulo Pimenta','ppime@empresa.com','123456','Funcionário','A'),(39,'rrang','Raíssa Rangel','rrang@empresa.com','123456','Funcionário','A'),(40,'ssiqu','Sérgio Siqueira','ssiqu@empresa.com','123456','Funcionário','A'),(41,'ttamo','Thales Tamoio','ttamo@empresa.com','123456','Funcionário','A'),(42,'vvasq','Vanessa Vasques','vvasq@empresa.com','123456','Funcionário','A'),(43,'wwern','Wesley Werner','wwern@empresa.com','123456','Funcionário','A'),(45,'zzimb','Zara Zimbres','zzimb@empresa.com','123456','Funcionário','A'),(46,'xxime','Xavier Ximenes','xxime@empresa.com','123456','Funcionário','I'),(47,'wwall','Wendel Wallach','wwall@empresa.com','123456','Funcionário','I'),(49,'admin','admin','admin@admin.com.br','admin','Admin','A');
/*!40000 ALTER TABLE `tbl_usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-09-13 14:47:29
