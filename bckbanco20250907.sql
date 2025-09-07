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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_projeto`
--

LOCK TABLES `tbl_projeto` WRITE;
/*!40000 ALTER TABLE `tbl_projeto` DISABLE KEYS */;
INSERT INTO `tbl_projeto` VALUES (1,'Implementação de Sistema ERP','Substituição do sistema legado pelo novo ERP da empresa, integrando os setores financeiro, RH e logística.','2025-06-01','2025-12-20','Em Andamento'),(2,'Desenvolvimento do Novo App Mobile','Criação do aplicativo móvel para iOS e Android com foco em melhorar a experiência de compra do cliente.','2025-08-15','2026-03-31','Em Andamento'),(3,'Migração de Servidores para a Nuvem','Mover toda a infraestrutura de servidores on-premise para a plataforma AWS, visando redução de custos e escalabilidade.','2025-01-20','2025-07-25','Concluído'),(4,'Campanha de Marketing Digital Q4 2025','Planejamento e execução da campanha de marketing para o último trimestre de 2025, com foco nas vendas de fim de ano.','2025-09-15','2025-12-31','Planejado'),(5,'Reestruturação do Site Corporativo','Modernização do design e da plataforma do site institucional da empresa, com implementação de novas funcionalidades de SEO.','2025-03-10','2025-08-30','Concluído'),(6,'Certificação ISO 9001','Adequação de todos os processos internos para obtenção do selo de qualidade ISO 9001.','2024-11-01',NULL,'Em Andamento'),(7,'Implantação de BI e Analytics','Criação de dashboards e relatórios gerenciais utilizando a ferramenta Power BI para análise de dados de vendas.','2025-07-01','2025-11-28','Em Andamento'),(8,'Treinamento de Equipe de Vendas 2026','Programa de capacitação para a equipe comercial sobre os novos produtos a serem lançados em 2026.','2026-01-20','2026-02-10','Planejado'),(10,'Pesquisa de Satisfação do Cliente 2025','Realização da pesquisa anual de satisfação (NPS) com a base de clientes para coletar feedbacks.','2025-09-01','2025-09-30','Em Andamento');
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
/*!40000 ALTER TABLE `tbl_projetousuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_usuario`
--

DROP TABLE IF EXISTS `tbl_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_usuario` (
  `id_usuario` int NOT NULL,
  `nm_usuario` varchar(100) NOT NULL,
  `senha_usuario` varchar(255) NOT NULL,
  `tp_acesso` varchar(50) NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_usuario`
--

LOCK TABLES `tbl_usuario` WRITE;
/*!40000 ALTER TABLE `tbl_usuario` DISABLE KEYS */;
INSERT INTO `tbl_usuario` VALUES (1,'Ana Carolina Souza','123456','Gerente'),(3,'Carlos Eduardo Martins alt','123456','Gerente'),(4,'Daniela Alves Pereira','123456','Gerente'),(5,'Eduardo Gomes Ribeiro','123456','Gerente'),(6,'Fernanda Costa Carvalho','123456','Gerente'),(7,'Gustavo Rodrigues Melo','123456','Gerente'),(8,'Helena Santos Oliveira','123456','Gerente'),(9,'Igor Almeida Silva','123456','Gerente'),(10,'Juliana Correia Barros','123456','Gerente'),(11,'Larissa Martins Costa','123456','Membro'),(12,'Marcos Pereira Lima','123456','Membro'),(13,'Natália Gomes Alves','123456','Membro'),(14,'Otávio Ferreira Souza','123456','Membro'),(15,'Patrícia Rodrigues Santos','123456','Membro'),(16,'Rafael Oliveira Silva','123456','Membro'),(17,'Sofia Carvalho Ribeiro','123456','Membro'),(18,'Thiago Melo Costa','123456','Membro'),(19,'Valentina Lima Gomes','123456','Membro'),(20,'William Alves Ferreira','123456','Membro'),(21,'Amanda Castro Pinto','123456','Membro'),(22,'Bernardo Dias Rocha','123456','Membro'),(23,'Clara Fogaça Nunes','123456','Membro'),(24,'Davi Mendes Teixeira','123456','Membro'),(25,'Eloá Azevedo Barbosa','123456','Membro'),(26,'Fábio Cunha Moraes','123456','Membro'),(27,'Giovanna Rezende Ramos','123456','Membro'),(28,'Heitor Viana Campos','123456','Membro'),(29,'Isadora Cardoso Freitas','123456','Membro'),(30,'José Lopes Brandão','123456','Membro'),(31,'Karen Vieira Arantes','123456','Membro'),(32,'Lucas Siqueira Paiva','123456','Membro'),(33,'Manuela Duarte Queiroz','123456','Membro'),(34,'Nicolas Silveira Pires','123456','Membro'),(35,'Olívia Neves Caldeira','123456','Membro'),(36,'Pedro Henrique Maciel','123456','Membro'),(37,'Quintino Bicalho Guerra','123456','Membro'),(38,'Raquel Peixoto Valadares','123456','Membro'),(39,'Samuel Tavares Vasconcelos','123456','Membro'),(40,'Tatiane Uchoa Xavier','123456','Membro'),(41,'Ulisses Valente Chaves','123456','Membro'),(42,'Vitória Zagallo Drummond','123456','Membro'),(43,'Wagner Antunes Guedes','123456','Membro'),(44,'Xavier Benevides Lacerda','123456','Membro'),(45,'Yasmin Cordeiro Dorneles','123456','Membro'),(46,'Ziraldo Esteves Figueiredo','123456','Membro'),(47,'Bárbara Frota Meireles','123456','Membro'),(48,'César Gouveia Noronha','123456','Membro'),(49,'Débora Pacheco Ornelas','123456','Membro'),(50,'Emanuel Quintão Sampaio','123456','Membro'),(700,'Thiago','123456','Admin');
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

-- Dump completed on 2025-09-07 15:44:54
