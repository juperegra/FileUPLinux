USE MASTER
GO
CREATE DATABASE FileUPDataBase;
GO
USE FileUPDataBase

CREATE TABLE Usuario	
	(   ID 			nvarchar(20) 	NOT NULL
	,	Nombre		nvarchar(20)	NOT NULL
	,	Apellidos   nvarchar(50)
	,	Contraseña	nvarchar(30)	NOT NULL
	,	IP			nvarchar(15)	NOT NULL

	,	CONSTRAINT PK_usuario PRIMARY KEY (id)
	)
GO

CREATE TABLE Fichero
	(	ID_Fichero 		nvarchar(20) 	NOT NULL
	,	Nombre_Original nvarchar(100)	NOT NULL
	,	ID_Emisor 		nvarchar(20)	NOT NULL
	,	ID_Receptor		nvarchar(20)	NOT NULL	
	,	Ruta			nvarchar(200)	NOT NULL
	,	Codificacion	nvarchar(20)	

	,	CONSTRAINT PK_fich PRIMARY KEY (ID_Fichero,Ruta)
	,	CONSTRAINT FK_emisor FOREIGN KEY (ID_Emisor) REFERENCES Usuario(ID)
	,	CONSTRAINT FK_receptor FOREIGN KEY (ID_Receptor) REFERENCES Usuario(ID)
	)
GO