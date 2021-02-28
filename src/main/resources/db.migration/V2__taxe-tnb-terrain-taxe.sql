
INSERT INTO `taxetnb` (`id`, `annee`, `montant_de_base`, `terrain`) VALUES
(2, 2021, 100, 1);

--
-- Dumping data for table `terrain`
--

INSERT INTO `terrain` (`id`, `adresse`, `categorie`, `reference`, `surface`) VALUES
(1, 'Marrakech Massira', 'Villa', 't1', 70),
(3, 'Marrakech Gueliz', 'Immeuble', 't2', 100);
COMMIT;

