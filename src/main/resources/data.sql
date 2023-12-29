INSERT INTO arbitre (nationalite, nom) VALUES
    ('Française', 'Jean Dupont'),
    ('Espagnole', 'Maria Rodriguez'),
    ('Allemande', 'Hans Müller'),
    ('Argentine', 'Juan Martinez'),
    ('Portugaise', 'João Santos'),
    ('Marocaine', 'Karim El Amrani'),
    ('Marocaine', 'Sara Bouziane'),
    ('Marocaine', 'Ahmed Choukri');


INSERT INTO stade (nom_stade, ville) VALUES
    ('Stade de France', 'Paris'),
    ('Camp Nou', 'Barcelone'),
    ('Stade Mohammed V', 'Casablanca'),
    ('Complexe sportif Prince Moulay Abdellah', 'Rabat'),
    ('Stade Municipal', 'Agadir'),
    ('Estádio da Luz', 'Lisbonne'),
    ('Santiago Bernabéu', 'Madrid'),
    ('Old Trafford', 'Manchester');

INSERT INTO equipe (nom_equipe, pays) VALUES
    ('Barcelona', 'Espagne'),
    ('Real Madrid', 'Espagne'),
    ('Wydad Casablanca', 'Maroc'),
    ('FAR Rabat', 'Maroc'),
    ('Mouloudia Oujda', 'Maroc'),
    ('PSG', 'France'),
    ('Raja Casablanca', 'Maroc'),
    ('Bayern Munich', 'Allemagne'),
    ('Liverpool', 'Angleterre');

-- Barcelona, Espagne
INSERT INTO joueur (nom_joueur, poste, equipe_id) VALUES
    ('Lionel Messi', 'Attaquant', 1),
    ('Sergio Busquets', 'Milieu', 1),
    ('Gerard Piqué', 'Défenseur', 1),
    ('Jordi Alba', 'Défenseur', 1),
    ('Ansu Fati', 'Attaquant', 1),
    ('Frenkie de Jong', 'Milieu', 1),
    ('Marc-André ter Stegen', 'Gardien', 1);

-- Real Madrid, Espagne
INSERT INTO joueur (nom_joueur, poste, equipe_id) VALUES
    ('Karim Benzema', 'Attaquant', 2),
    ('Toni Kroos', 'Milieu', 2),
    ('Sergio Ramos', 'Défenseur', 2),
    ('Thibaut Courtois', 'Gardien', 2),
    ('Luka Modric', 'Milieu', 2),
    ('Casemiro', 'Milieu', 2),
    ('Ferland Mendy', 'Défenseur', 2);

-- Wydad Casablanca, Maroc
INSERT INTO joueur (nom_joueur, poste, equipe_id) VALUES
    ('Achraf Dari', 'Défenseur', 3),
    ('Ayoub El Kaabi', 'Attaquant', 3),
    ('Ismail Haddad', 'Milieu', 3),
    ('Reda Hajhouj', 'Milieu', 3),
    ('Badie Aouk', 'Défenseur', 3),
    ('Achraf Bencharki', 'Attaquant', 3),
    ('Ahmed Tagnaouti', 'Gardien', 3);

-- FAR Rabat, Maroc
INSERT INTO joueur (nom_joueur, poste, equipe_id) VALUES
    ('Abdellatif Noussir', 'Défenseur', 4),
    ('Mohamed Nahiri', 'Défenseur', 4),
    ('Youssef Aguerd', 'Défenseur', 4),
    ('Marouane Saadane', 'Milieu', 4),
    ('Mohcine Iajour', 'Attaquant', 4),
    ('Amine Tighazoui', 'Milieu', 4),
    ('Mohamed Achchakir', 'Gardien', 4);

-- Mouloudia Oujda, Maroc
INSERT INTO joueur (nom_joueur, poste, equipe_id) VALUES
    ('Achraf Dari', 'Défenseur', 5),
    ('Ayoub El Kaabi', 'Attaquant', 5),
    ('Ismail Haddad', 'Milieu', 5),
    ('Reda Hajhouj', 'Milieu', 5),
    ('Badie Aouk', 'Défenseur', 5),
    ('Achraf Bencharki', 'Attaquant', 5),
    ('Ahmed Tagnaouti', 'Gardien', 5);


-- MysQl attends le type date yyyy-MM-dd
INSERT INTO matche (date_match, heure_match, arbitre_id, equipe_domicile, equipe_exterieur, state_id) VALUES
    ('2023-10-11', '15:00:00', 1, 1, 2, 1),
    ('2023-11-07', '14:30:00', 2, 3, 4, 2),
    ('2023-12-03', '16:00:00', 1, 9, 6, 1);



