DROP TABLE IF EXISTS Produit;

CREATE TABLE Produit(
   num integer primary key auto_increment,
   label VARCHAR(64),
   categorie VARCHAR(64),
   prix double
);

INSERT INTO Produit(num,label,categorie,prix) 
     VALUES(1,'Cahier','divers',1.12),
           (2,'Cd1','cd',10.12),
           (3,'Stylo','divers',2.12),
           (4,'Cd2','cd',12.12),
           (5,'Trousse','divers',3.12);


SELECT * FROM Produit;