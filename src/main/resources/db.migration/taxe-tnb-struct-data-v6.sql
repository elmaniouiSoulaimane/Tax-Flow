-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:3306
-- Généré le : Dim 28 fév. 2021 à 10:33
-- Version du serveur :  5.7.24
-- Version de PHP : 7.4.14

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `taxe-tnb`
--

-- --------------------------------------------------------

--
-- Structure de la table `category`
--

CREATE TABLE `category` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `category`
--

INSERT INTO `category` (`id`, `code`, `libelle`) VALUES
(1, 'zv', 'villa'),
(2, 'zi', 'immeuble'),
(3, 'za', 'autre');

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(13);

-- --------------------------------------------------------

--
-- Structure de la table `redevable`
--

CREATE TABLE `redevable` (
  `id` bigint(20) NOT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `ref` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `redevable`
--

INSERT INTO `redevable` (`id`, `adresse`, `ref`) VALUES
(2, 'Afaq 1 N208 Saada Marrakech', 'V2'),
(3, 'Afaq 2 N200 Saada Marrakech', 'V3');

-- --------------------------------------------------------

--
-- Structure de la table `rue`
--

CREATE TABLE `rue` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `taux`
--

CREATE TABLE `taux` (
  `id` bigint(20) NOT NULL,
  `prix` double NOT NULL,
  `category` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `taux`
--

INSERT INTO `taux` (`id`, `prix`, `category`) VALUES
(1, 5000, 1),
(2, 7000, 2),
(3, 9000, 3);

-- --------------------------------------------------------

--
-- Structure de la table `taxetnb`
--

CREATE TABLE `taxetnb` (
  `id` bigint(20) NOT NULL,
  `annee` bigint(20) DEFAULT NULL,
  `montant_de_base` double NOT NULL,
  `redevable` bigint(20) DEFAULT NULL,
  `taux` bigint(20) DEFAULT NULL,
  `terrain` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `taxetnb`
--

INSERT INTO `taxetnb` (`id`, `annee`, `montant_de_base`, `redevable`, `taux`, `terrain`) VALUES
(6, 2020, 1250000, 3, 1, 4),
(7, 2007, 630000, 2, 2, 5),
(8, 2019, 1250000, 3, 1, 4),
(10, 2019, 3500000, 2, 2, 9),
(11, 2018, 3500000, 2, 2, 9),
(12, 2017, 3500000, 2, 2, 9);

-- --------------------------------------------------------

--
-- Structure de la table `terrain`
--

CREATE TABLE `terrain` (
  `id` bigint(20) NOT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `surface` double NOT NULL,
  `category` bigint(20) DEFAULT NULL,
  `redevable` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `terrain`
--

INSERT INTO `terrain` (`id`, `adresse`, `reference`, `surface`, `category`, `redevable`) VALUES
(4, 'massira 3', 't1', 250, 1, 3),
(5, 'massira 1', 't2', 90, 2, 2),
(9, 'guiliz', 't3', 500, 2, 2);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `redevable`
--
ALTER TABLE `redevable`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `rue`
--
ALTER TABLE `rue`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `taux`
--
ALTER TABLE `taux`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5fh5llj5y2ukhsmyw3aas7720` (`category`);

--
-- Index pour la table `taxetnb`
--
ALTER TABLE `taxetnb`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKldq658v8h5su6tixid9vls2dj` (`redevable`),
  ADD KEY `FKh27qyoxbwrr40rrv0j4abbs65` (`taux`),
  ADD KEY `FKfwcinro9pmsdcfak1dflohnw9` (`terrain`);

--
-- Index pour la table `terrain`
--
ALTER TABLE `terrain`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKobp61h1domvn9g8dseek0p7pk` (`category`),
  ADD KEY `FK46ouvveg7lery762yqk5ish2q` (`redevable`);
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
